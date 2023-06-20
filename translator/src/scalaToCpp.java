import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;


public class scalaToCpp {

    public static Map<String, String> types;
    File input;
    File output = new File("translator/src/test.cpp");
    public static List<List<String>> errors = new ArrayList<>();

    public static class ErrorListener extends scalaToCppBaseListener implements ANTLRErrorListener {

        public static class ErrorListenerException extends RuntimeException {
            Throwable cause;
            public ErrorListenerException(String message, Throwable cause) {
                super(message);
                this.cause = cause;
            }
        }

        @Override
        public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
            String sourceName = recognizer.getInputStream().getSourceName();
            String errorMsg = "Syntax error in " + sourceName + " at line " + line + ", position " + charPositionInLine + ": " + msg;
            throw new ErrorListenerException(errorMsg, e);
        }

        @Override
        public void reportAmbiguity(Parser parser, DFA dfa, int startIndex, int stopIndex, boolean exact, BitSet ambigAlts, ATNConfigSet configs) {
            String inputText = parser.getTokenStream().getText(new Interval(startIndex, stopIndex));
            List<String> error = new ArrayList<>();
            error.add("Ambiguity detected from index " + startIndex + " to " + stopIndex + " in input: " + inputText);
            error.add("Conflicting alternative(s): " + getAlternativeLabels(parser, ambigAlts));
            errors.add(error);
        }

        @Override
        public void reportAttemptingFullContext(Parser parser, DFA dfa, int startIndex, int stopIndex, BitSet conflictingAlts, ATNConfigSet atnConfigSet) {
            String inputText = parser.getTokenStream().getText(new Interval(startIndex, stopIndex));
            List<String> error = new ArrayList<>();
            error.add("Attempting full context parsing from index " + startIndex + " to " + stopIndex + " in input: " + inputText);
            error.add("Conflicting alternative(s): " + getAlternativeLabels(parser, conflictingAlts));
            errors.add(error);
        }

        @Override
        public void reportContextSensitivity(Parser parser, DFA dfa, int startIndex, int stopIndex, int prediction, ATNConfigSet atnConfigSet) {
            String inputText = parser.getTokenStream().getText(new Interval(startIndex, stopIndex));
            String predictedAlternative = getPredictedAlternativeLabel(parser, prediction);
            List<String> error = new ArrayList<>();
            error.add("Context sensitivity detected from index " + startIndex + " to " + stopIndex + " in input: " + inputText);
            error.add("Predicted alternative: " + predictedAlternative);
            errors.add(error);
        }

        private String getAlternativeLabels(Parser parser, BitSet altSet) {
            StringJoiner joiner = new StringJoiner(", ");

            for (int i = altSet.nextSetBit(0); i >= 0; i = altSet.nextSetBit(i + 1)) {
                String altLabel = parser.getRuleNames()[parser.getATN().decisionToState.get(i).ruleIndex];
                joiner.add(altLabel);
            }

            return joiner.toString();
        }

        private String getPredictedAlternativeLabel(Parser parser, int alternativeNumber) {
            String[] ruleNames = parser.getRuleNames();
            String ruleLabel = ruleNames[parser.getContext().getRuleIndex()];

            return ruleLabel + " - Alternative " + alternativeNumber;
        }
    }

    private static class TypeListener extends scalaToCppBaseListener {
        static Map<String, String> types = new HashMap<>();
        public static Map<String, String> getTypes() {
            return types;
        }

        @Override
        public void enterDef(scalaToCppParser.DefContext ctx) {
            String name = ctx.IDENTIFIER().getText();
            if(ctx.returnType() != null){
                String type = ctx.returnType().IDENTIFIER().getText();
                types.put(name, type);
            }else{
                types.put(name, "void");
            }
        }

        @Override
        public void enterParameter(scalaToCppParser.ParameterContext ctx) {
            String name = ctx.IDENTIFIER().get(0).getText();
            switch (ctx.IDENTIFIER().get(1).getText()) {
                case "Int" -> types.put(name, "int");
                case "String" -> types.put(name, "string");
                case "Boolean" -> types.put(name, "bool");
                default -> types.put(name, ctx.IDENTIFIER().get(1).getText());
            }
        }

        @Override
        public void enterAssignment(scalaToCppParser.AssignmentContext ctx) {
            String name = ctx.IDENTIFIER().getText();
            if(ctx.operation() != null){
                if(ctx.operation().IDENTIFIER().size() > 0) {
                    String type = ctx.operation().IDENTIFIER(0).getText();
                    types.put(name, type);
                }else{
                    if(ctx.operation().literal().size() > 0) {
                        if(ctx.operation().literal().get(0).BOOLEAN_LITERAL() != null) {
                            types.put(name, "bool");
                        }else if(ctx.operation().literal().get(0).INT_LITERAL() != null) {
                            types.put(name, "int");
                        }else if(ctx.operation().literal().get(0).STRING_LITERAL() != null) {
                            types.put(name, "string");
                        }
                    }
                }
            }else if(ctx.creation() != null){
                if(ctx.creation().NEW() != null){
                    String type = ctx.creation().functionCall().IDENTIFIER().getText();
                    types.put(name, type);
                }else{
                    String type = types.get(ctx.creation().functionCall().IDENTIFIER().toString());
                    types.put(name, type);
                }
            }else {
                if (ctx.listliteral().literal() != null) {
                    if (ctx.listliteral().literal().INT_LITERAL() != null) {
                        types.put(name, "vector<int>");
                    } else if (ctx.listliteral().literal().STRING_LITERAL() != null) {
                        types.put(name, "vector<string>");
                    } else if (ctx.listliteral().literal().BOOLEAN_LITERAL() != null) {
                        types.put(name, "vector<boolean>");
                    }
                }
                else if(ctx.listliteral().creation() != null){
                    if(ctx.listliteral().creation().functionCall().IDENTIFIER() != null){
                        String type = ctx.listliteral().creation().functionCall().IDENTIFIER().toString();
                        types.put(name, "vector<" + type + ">");
                    }
                }
            }
        }
    }

    private static class ProdListener extends scalaToCppBaseListener{
        private int indent_level = 0;
        private final PrintWriter writer;
        private File output;

        private void writeToOutput(String s){
            writer.append(s);
        }

        public ProdListener(File file) throws IOException {
            this.output = file;
            writer = new PrintWriter(this.output);
            if(!output.createNewFile()) writer.print("");
        }

        @Override
        public void enterEveryRule(ParserRuleContext ctx){
            //indent_level += 1;
            int tokenType = ctx.getRuleIndex();
            //writeToOutput(String.valueOf(tokenType));
        }

        @Override
        public void exitEveryRule(ParserRuleContext ctx){
            //indent_level -= 1;
        }
        @Override
        public void enterPlure(scalaToCppParser.PlureContext ctx) {
            StringBuilder plure = new StringBuilder();
            plure.append("#include <iostream>\n");
            plure.append("#include <vector>\n");
            plure.append("#include <string>\n");
            plure.append("using namespace std;\n\n");
            writeToOutput(plure.toString());
        }

        @Override
        public void exitPlure(scalaToCppParser.PlureContext ctx) {
            writer.close();
        }

        @Override
        public void enterClassDef(scalaToCppParser.ClassDefContext ctx) {
            StringBuilder classDef = new StringBuilder();
            classDef.append("\t".repeat(Math.max(0, indent_level)));
            // check if access modifier is present
            if(ctx.accessModifier() != null){
                classDef.append(ctx.accessModifier().getText());
                classDef.append(" ");
            }
            classDef.append("class ").append(ctx.IDENTIFIER().getText()).append(" {\n");
            indent_level += 1;
            writeToOutput(classDef.toString());
        }

        @Override
        public void exitClassDef(scalaToCppParser.ClassDefContext ctx) {
            indent_level -= 1;
            String classDef = "\t".repeat(Math.max(0, indent_level)) +
                    "}\n";
            writeToOutput(classDef);
        }

        @Override
        public void enterObjectDef(scalaToCppParser.ObjectDefContext ctx) {
            StringBuilder objectDef = new StringBuilder();
            objectDef.append("\t".repeat(Math.max(0, indent_level)));
            if(ctx.accessModifier() != null){
                objectDef.append(ctx.accessModifier().getText());
                objectDef.append(" ");
            }
            objectDef.append("class ").append(ctx.IDENTIFIER().getText()).append(" {\n");
            indent_level += 1;
            writeToOutput(objectDef.toString());
        }

        @Override
        public void exitObjectDef(scalaToCppParser.ObjectDefContext ctx) {
            indent_level -= 1;
            String objectDef = "\t".repeat(Math.max(0, indent_level)) +
                    "}\n";
            writeToOutput(objectDef);
        }

        @Override
        public void enterTraitDef(scalaToCppParser.TraitDefContext ctx) {
            StringBuilder traitDef = new StringBuilder();
            traitDef.append("\t".repeat(Math.max(0, indent_level)));
            if(ctx.accessModifier() != null){
                traitDef.append(ctx.accessModifier().getText());
                traitDef.append(" ");
            }
            traitDef.append("abstract class ").append(ctx.IDENTIFIER().getText()).append(" {\n");
            indent_level += 1;
            writeToOutput(traitDef.toString());
        }

        @Override
        public void exitTraitDef(scalaToCppParser.TraitDefContext ctx) {
            indent_level -= 1;
            String traitDef = "\t".repeat(Math.max(0, indent_level)) +
                    "}\n";
            writeToOutput(traitDef);
        }

        @Override
        public void enterDef(scalaToCppParser.DefContext ctx) {
            StringBuilder def = new StringBuilder();
            def.append("\t".repeat(Math.max(0, indent_level)));
            if(ctx.accessModifier() != null){
                def.append(ctx.accessModifier().getText());
                def.append(" ");
            }
            if(types.containsKey(ctx.IDENTIFIER().getText())){
                def.append(types.get(ctx.IDENTIFIER().getText()));
                def.append(" ");
            }else{
                def.append("void ");
            }
            def.append(ctx.IDENTIFIER().getText());
            writeToOutput(def.toString());
        }

        @Override
        public void exitDef(scalaToCppParser.DefContext ctx) {
        }


        @Override
        public void enterClassBody(scalaToCppParser.ClassBodyContext ctx) {
        }

        @Override
        public void exitClassBody(scalaToCppParser.ClassBodyContext ctx) {
        }

        @Override
        public void enterClassMember(scalaToCppParser.ClassMemberContext ctx) {
        }

        @Override
        public void exitClassMember(scalaToCppParser.ClassMemberContext ctx) {
        }

        @Override
        public void enterParameterList(scalaToCppParser.ParameterListContext ctx) {
            StringBuilder parameterList = new StringBuilder();
            parameterList.append("(");
            if(ctx.parameter() == null){
                parameterList.append(")");
                writeToOutput(parameterList.toString());
                return;
            }
            for(int i = 0; i < ctx.parameter().size(); i++){
                parameterList.append(types.get(ctx.parameter(i).IDENTIFIER().get(0).getText()));
                parameterList.append(" ");
                parameterList.append(ctx.parameter(i).IDENTIFIER().get(0).getText());
                if(i != ctx.parameter().size() - 1){
                    parameterList.append(", ");
                }
            }
            parameterList.append(")");
            writeToOutput(parameterList.toString());
        }

        @Override
        public void exitParameterList(scalaToCppParser.ParameterListContext ctx) {
        }

        @Override
        public void enterExpression(scalaToCppParser.ExpressionContext ctx) {
            if(ctx.IDENTIFIER() != null){
                writeToOutput(ctx.IDENTIFIER().getText());
            }
        }

        @Override
        public void exitExpression(scalaToCppParser.ExpressionContext ctx) {
            writeToOutput("");
        }

        @Override
        public void enterFunctionCall(scalaToCppParser.FunctionCallContext ctx) {
            writeToOutput(ctx.IDENTIFIER().getText());
        }

        @Override
        public void exitFunctionCall(scalaToCppParser.FunctionCallContext ctx) {
            writeToOutput("");
        }

        @Override
        public void enterObjectMethodAccess(scalaToCppParser.ObjectMethodAccessContext ctx) {
            StringBuilder objectMethodAccess = new StringBuilder();
            objectMethodAccess.append("\t".repeat(Math.max(0, indent_level)));
            objectMethodAccess.append(ctx.IDENTIFIER().get(0).getText()).append(".").append(ctx.IDENTIFIER().get(1).getText());
            if(ctx.argumentList() == null){
                objectMethodAccess.append("()");
            }
            writeToOutput(objectMethodAccess.toString());
        }

        @Override
        public void exitObjectMethodAccess(scalaToCppParser.ObjectMethodAccessContext ctx) {
            writeToOutput("");
        }

        @Override
        public void enterArgumentList(scalaToCppParser.ArgumentListContext ctx) {
            writeToOutput("(");
        }

        @Override
        public void exitArgumentList(scalaToCppParser.ArgumentListContext ctx) {
            writeToOutput(")");
        }

        @Override
        public void enterArgumentListElement(scalaToCppParser.ArgumentListElementContext ctx) {
            writeToOutput(", ");
        }
        @Override
        public void enterDefinition(scalaToCppParser.DefinitionContext ctx) {
            StringBuilder definition = new StringBuilder();
            definition.append("\t".repeat(Math.max(0, indent_level)));
            Map<String, String> map = TypeListener.getTypes();
            if(map.containsKey(ctx.IDENTIFIER().getText())){
                definition.append(map.get(ctx.IDENTIFIER().getText())).append(" ");
            }
            else{
                definition.append("void* ");
            }
            definition = definition.append(ctx.IDENTIFIER().getText());
            writeToOutput(definition.toString());
        }

        @Override
        public void exitDefinition(scalaToCppParser.DefinitionContext ctx) {
            writeToOutput("");
        }

        @Override
        public void enterAssignment(scalaToCppParser.AssignmentContext ctx) {
            StringBuilder assignment = new StringBuilder();
            //assignment.append("\t".repeat(Math.max(0, indent_level)));
            Map<String, String> map = TypeListener.getTypes();
            if(map.containsKey(ctx.IDENTIFIER().getText())){
                assignment.append(map.get(ctx.IDENTIFIER().getText())).append(" ");
            }
            assignment.append(ctx.IDENTIFIER().getText()).append(" = ");

            writeToOutput(assignment.toString());
        }

        @Override
        public void exitAssignment(scalaToCppParser.AssignmentContext ctx) {
            writeToOutput("");
        }

        @Override
        public void enterListliteral(scalaToCppParser.ListliteralContext ctx) {
            StringBuilder listliteral = new StringBuilder();
            listliteral.append("{");

            writeToOutput(listliteral.toString());

        }

        @Override
        public void exitListliteral(scalaToCppParser.ListliteralContext ctx) {
            writeToOutput("}");
        }
        @Override
        public void enterListLiteralElement(scalaToCppParser.ListLiteralElementContext ctx) {
            writeToOutput(", ");
        }

        @Override
        public void enterOperation(scalaToCppParser.OperationContext ctx) {
            StringBuilder operation = new StringBuilder();

            for(int i = 0; i < ctx.IDENTIFIER().size(); i++){
                operation.append(ctx.IDENTIFIER(i).getText());
                if(i != ctx.IDENTIFIER().size() - 1){
                    operation.append(" ").append(ctx.simpleOperator(i).getText()).append(" ");
                }
            }
            writeToOutput(operation.toString());
        }

        @Override
        public void exitOperation(scalaToCppParser.OperationContext ctx) {}

        @Override
        public void enterCreation(scalaToCppParser.CreationContext ctx) {
            writeToOutput("new ");
        }

        @Override
        public void exitCreation(scalaToCppParser.CreationContext ctx) {
        }

        @Override
        public void enterBinaryOperator(scalaToCppParser.BinaryOperatorContext ctx) {
            writeToOutput(ctx.getText());
        }

        @Override public void exitBinaryOperator(scalaToCppParser.BinaryOperatorContext ctx) {}

        @Override
        public void enterUnaryOperator(scalaToCppParser.UnaryOperatorContext ctx) {
            writeToOutput(ctx.getText());
        }

        @Override public void exitUnaryOperator(scalaToCppParser.UnaryOperatorContext ctx) {}

        @Override
        public void enterSimpleOperator(scalaToCppParser.SimpleOperatorContext ctx) {
            writeToOutput(ctx.getText());
        }

        @Override public void exitSimpleOperator(scalaToCppParser.SimpleOperatorContext ctx) {}

        @Override
        public void enterLiteral(scalaToCppParser.LiteralContext ctx) {
            String literal = ctx.getText();
            writeToOutput(literal);
        }

        @Override
        public void exitLiteral(scalaToCppParser.LiteralContext ctx) {
            writeToOutput("");
        }

        @Override
        public void enterParameter(scalaToCppParser.ParameterContext ctx) {
        }

        @Override
        public void exitParameter(scalaToCppParser.ParameterContext ctx) {}

        @Override
        public void enterDefBlock(scalaToCppParser.DefBlockContext ctx) {
            StringBuilder defBlock = new StringBuilder();
            defBlock.append("\t".repeat(Math.max(0, indent_level)) + "{\n");
            indent_level++;
            writeToOutput(defBlock.toString());
        }

        @Override
        public void exitDefBlock(scalaToCppParser.DefBlockContext ctx) {
            StringBuilder defBlock = new StringBuilder();
            indent_level--;
            defBlock.append("\t".repeat(Math.max(0, indent_level)) + "}\n");
            writeToOutput(defBlock.toString());
        }

        @Override
        public void enterBlock(scalaToCppParser.BlockContext ctx) {
            StringBuilder block = new StringBuilder();
            block.append("\t".repeat(Math.max(0, indent_level)) + "{\n");
            indent_level++;
            writeToOutput(block.toString());
        }

        @Override
        public void exitBlock(scalaToCppParser.BlockContext ctx) {
            StringBuilder block = new StringBuilder();
            indent_level--;
            block.append("\t".repeat(Math.max(0, indent_level)) + "}\n");
            writeToOutput(block.toString());
        }

        @Override
        public void enterReturnVal(scalaToCppParser.ReturnValContext ctx) {
            StringBuilder returnVal = new StringBuilder();
            returnVal.append("\t".repeat(Math.max(0, indent_level)) + "return ");

            writeToOutput(returnVal.toString());
        }

        @Override
        public void exitReturnVal(scalaToCppParser.ReturnValContext ctx) {}

        @Override
        public void enterIfStatement(scalaToCppParser.IfStatementContext ctx) {
            StringBuilder ifStatmenet = new StringBuilder();
            ifStatmenet.append("\t".repeat(Math.max(0, indent_level)));
            ifStatmenet.append("if (");

            writeToOutput(ifStatmenet.toString());
        }

        @Override
        public void enterLogicExpression(scalaToCppParser.LogicExpressionContext ctx) {}

        @Override
        public void exitLogicExpression(scalaToCppParser.LogicExpressionContext ctx) {
            StringBuilder ifStatmenet = new StringBuilder();
            ifStatmenet.append(")\n");

            writeToOutput(ifStatmenet.toString());
        }

        @Override
        public void enterElseStatement(scalaToCppParser.ElseStatementContext ctx) {
            StringBuilder elseStatmenet = new StringBuilder();
            elseStatmenet.append("\t".repeat(Math.max(0, indent_level)) + "else\n");

            writeToOutput(elseStatmenet.toString());
        }

        @Override
        public void enterWhileStatement(scalaToCppParser.WhileStatementContext ctx) {
            StringBuilder whileStatmenet = new StringBuilder();
            whileStatmenet.append("\t".repeat(Math.max(0, indent_level)));
            whileStatmenet.append("while (");

            writeToOutput(whileStatmenet.toString());
        }

        @Override
        public void exitWhileStatement(scalaToCppParser.WhileStatementContext ctx) {}

        @Override
        public void enterForStatement(scalaToCppParser.ForStatementContext ctx) {
            StringBuilder forStatmenet = new StringBuilder();
            forStatmenet.append("\t".repeat(Math.max(0, indent_level)));
            forStatmenet.append("for ( auto ");

            writeToOutput(forStatmenet.toString());
        }

        @Override
        public void exitForStatement(scalaToCppParser.ForStatementContext ctx) {}

        @Override
        public void enterEnumeration(scalaToCppParser.EnumerationContext ctx) {
            StringBuilder enumeration = new StringBuilder();
            enumeration.append(ctx.IDENTIFIER().getText() + " : ");

            writeToOutput(enumeration.toString());
        }

        @Override
        public void exitEnumeration(scalaToCppParser.EnumerationContext ctx) {
            StringBuilder enumeration = new StringBuilder();
            enumeration.append(" )\n");

            writeToOutput(enumeration.toString());
        }

        @Override
        public void enterExpressionStatement(scalaToCppParser.ExpressionStatementContext ctx) {
            if(!(ctx.getParent().getRuleIndex() == scalaToCppParser.RULE_returnVal)) writeToOutput("\t".repeat(Math.max(0, indent_level)));
        }

        @Override
        public void exitExpressionStatement(scalaToCppParser.ExpressionStatementContext ctx) {
            StringBuilder expressionStatement = new StringBuilder();
            expressionStatement.append(";\n");

            writeToOutput(expressionStatement.toString());
        }
        @Override
        public void enterPrintStatement(scalaToCppParser.PrintStatementContext ctx) {
            StringBuilder printStatement = new StringBuilder();
            printStatement.append("cout << ");

            writeToOutput(printStatement.toString());
        }
        @Override
        public void exitPrintStatement(scalaToCppParser.PrintStatementContext ctx) {
            writeToOutput(" << endl");
        }
        @Override
        public void enterPrintListElement(scalaToCppParser.PrintListElementContext ctx) {
            writeToOutput(" << ");
        }


    }

    List<List<String>> processFile() throws IOException, ErrorListener.ErrorListenerException {
        if(this.input == null) {
            throw new ErrorListener.ErrorListenerException("File does not exist", new FileNotFoundException());
        }
        CharStream input = CharStreams.fromFileName(this.input.getAbsolutePath());
        Lexer lexer = new scalaToCppLexer(input);
        TokenStream tokens = new CommonTokenStream(lexer);
        scalaToCppParser parser = new scalaToCppParser(tokens);
        parser.addErrorListener(new ErrorListener());
        ParseTree tree = parser.plure();
        ParseTreeWalker walkerPrep = new ParseTreeWalker();
        ParseTreeWalker walker = new ParseTreeWalker();
        TypeListener listenerPrep = new TypeListener();
        walkerPrep.walk(listenerPrep, tree);

        types = TypeListener.types;
        for (Map.Entry<String, String> entry : types.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            switch (value) {
                case "Int" -> types.put(key, "int");
                case "Boolean" -> types.put(key, "bool");
                case "String" -> types.put(key, "string");
            }
        }

        scalaToCppListener listener = null;
        try {
            listener = new ProdListener(output);
            walker.walk(listener, tree);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return errors;
    }
}
