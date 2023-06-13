import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class scalaToCpp {

    public static Map<String, String> types;

    private static class DebugListener extends scalaToCppBaseListener {
        private int indent_level = 0;
        @Override
        public void enterEveryRule(ParserRuleContext ctx) {
            for(int i = 0; i < indent_level; i++) {
                System.out.print("  |  ");
            }
            indent_level += 1;
            int tokenType = ctx.getRuleIndex();
            String tokenName = scalaToCppParser.ruleNames[tokenType];
            String tokenContent = ctx.getText();

            System.out.print("Entering   " +  "Token: " + tokenName + " - " + tokenContent + "  ");

            List<TerminalNode> identifiers = ctx.getTokens(scalaToCppParser.IDENTIFIER);
            if(identifiers.size() > 0) {
                for( TerminalNode identifier : identifiers) {
                    System.out.print("!Found identifier: " + identifier.getText() + "  ");
                }
            }
            System.out.println();
        }

        @Override
        public void exitEveryRule(ParserRuleContext ctx) {
            indent_level -= 1;
            for(int i = 0; i < indent_level; i++) {
                System.out.print("  |  ");
            }
            int tokenType = ctx.getRuleIndex();
            String tokenName = scalaToCppParser.ruleNames[tokenType];
            System.out.println("Exiting    " +  "Token: " + tokenName);
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
            String type = ctx.returnType().IDENTIFIER().getText();
            types.put(name, type);
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
            }else{
                if(ctx.listliteral().literal(0).INT_LITERAL() != null){
                    types.put(name, "vector<int>");
                }else if(ctx.listliteral().literal(0).STRING_LITERAL() != null){
                    types.put(name, "vector<string>");
                }else if(ctx.listliteral().literal(0).BOOLEAN_LITERAL() != null){
                    types.put(name, "vector<boolean>");
                }
            }
        }
    }

    private static class ProdListener extends scalaToCppBaseListener{
        private int indent_level = 0;
        private final PrintWriter writer;
        private String path;
        private File output;

        private void writeToOutput(String s){
            writer.append(s);
        }

        public ProdListener(String path) throws IOException {
            this.path = path;
            output = new File(path);
            writer = new PrintWriter(this.output);
            if(!output.createNewFile()) writer.print("");
        }

        public ProdListener(File file) throws IOException {
            this.output = file;
            writer = new PrintWriter(this.output);
            if(!output.createNewFile()) writer.print("");
        }

        @Override
        public void enterEveryRule(ParserRuleContext ctx){
            indent_level += 1;
            int tokenType = ctx.getRuleIndex();
            writeToOutput(String.valueOf(tokenType));
        }

        @Override
        public void exitEveryRule(ParserRuleContext ctx){
            indent_level -= 1;
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
            writeToOutput(classDef.toString());
        }

        @Override
        public void exitClassDef(scalaToCppParser.ClassDefContext ctx) {
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
            writeToOutput(objectDef.toString());
        }

        @Override
        public void exitObjectDef(scalaToCppParser.ObjectDefContext ctx) {
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
            writeToOutput(traitDef.toString());
        }

        @Override
        public void exitTraitDef(scalaToCppParser.TraitDefContext ctx) {
            String traitDef = "\t".repeat(Math.max(0, indent_level)) +
                    "}\n";
            writeToOutput(traitDef);
        }

        @Override
        public void enterDef(scalaToCppParser.DefContext ctx) {
        }

        @Override
        public void enterExpression(scalaToCppParser.ExpressionContext ctx) {
            if(ctx.IDENTIFIER() != null){
                writeToOutput(ctx.IDENTIFIER().getText());
            }
        }

        @Override
        public void exitExpression(scalaToCppParser.ExpressionContext ctx) {
            writeToOutput(" ");
        }

        @Override
        public void enterFunctionCall(scalaToCppParser.FunctionCallContext ctx) {
            String functionCall = "\t".repeat(Math.max(0, indent_level)) +
                    ctx.IDENTIFIER().getText();
            writeToOutput(functionCall);
        }
        @Override
        public void exitFunctionCall(scalaToCppParser.FunctionCallContext ctx) {
            writeToOutput(";\n");
        }
        @Override
        public void enterObjectMethodAccess(scalaToCppParser.ObjectMethodAccessContext ctx) {
            StringBuilder objectMethodAccess = new StringBuilder();
            objectMethodAccess.append("\t".repeat(Math.max(0, indent_level)));
            objectMethodAccess.append(ctx.IDENTIFIER().get(0).getText()).append(".").append(ctx.IDENTIFIER().get(1).getText());
            if(ctx.argumentList() != null){
                objectMethodAccess.append(ctx.argumentList().getText());
            }
            else{
                objectMethodAccess.append("()");
            }
            writeToOutput(objectMethodAccess.toString());
        }

        @Override
        public void exitObjectMethodAccess(scalaToCppParser.ObjectMethodAccessContext ctx) {
            writeToOutput(";\n");
        }
        @Override
        public void enterArgumentList(scalaToCppParser.ArgumentListContext ctx) {
            writeToOutput("(");
            StringBuilder argumentList = new StringBuilder();
            for(int i = 0; i < ctx.expression().size(); i++){
                argumentList.append(ctx.expression(i).getText());
                if(i != ctx.expression().size() - 1){
                    argumentList.append(", ");
                }
            }
            writeToOutput(argumentList.toString());
        }
        @Override
        public void exitArgumentList(scalaToCppParser.ArgumentListContext ctx) {
            writeToOutput(")");
        }
        @Override
        public void enterDefinition(scalaToCppParser.DefinitionContext ctx) {
            StringBuilder definition = new StringBuilder();
            definition.append("\t".repeat(Math.max(0, indent_level)));
            Map<String, String> map = TypeListener.getTypes();
            if(map.containsKey(ctx.IDENTIFIER().getText())){
                definition.append(map.get(ctx.IDENTIFIER().getText())).append(" ");
            }
            definition = definition.append(ctx.IDENTIFIER().getText());
            writeToOutput(definition.toString());
        }
        @Override
        public void exitDefinition(scalaToCppParser.DefinitionContext ctx) {
            writeToOutput(";\n");
        }
        @Override
        public void enterAssignment(scalaToCppParser.AssignmentContext ctx) {
            StringBuilder assignment = new StringBuilder();
            assignment.append("\t".repeat(Math.max(0, indent_level)));
            Map<String, String> map = TypeListener.getTypes();
            if(map.containsKey(ctx.IDENTIFIER().getText())){
                assignment.append(map.get(ctx.IDENTIFIER().getText())).append(" ");
            }
            assignment.append(ctx.IDENTIFIER().getText()).append(" = ");
            if(ctx.operation() != null){
                assignment.append(ctx.operation().getText());
            }
            else if(ctx.listliteral() != null){
                assignment.append(ctx.listliteral().getText());
            }
            else if(ctx.creation() != null){
                assignment.append(ctx.creation().getText());
            }
            writeToOutput(assignment.toString());
        }
        @Override
        public void exitAssignment(scalaToCppParser.AssignmentContext ctx) {
            writeToOutput(";\n");
        }
        @Override
        public void enterListliteral(scalaToCppParser.ListliteralContext ctx) {
            StringBuilder listliteral = new StringBuilder();
            listliteral.append("\t".repeat(Math.max(0, indent_level)));
            Map<String, String> map = TypeListener.getTypes();
            listliteral.append("vector<");
            if(map.containsKey(ctx.literal(0).getText())){
                listliteral.append(map.get(ctx.literal(0).getText())).append(" ");
            }
            listliteral.append(">");

            writeToOutput(listliteral.toString());
            // ?????????????????????????????????? WHERE IDENTIFIER
        }
        @Override
        public void exitListliteral(scalaToCppParser.ListliteralContext ctx) {
            writeToOutput(";\n");
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
        public void exitOperation(scalaToCppParser.OperationContext ctx) {
            writeToOutput(";\n");
        }

        @Override
        public void enterCreation(scalaToCppParser.CreationContext ctx) {
            String creation = "\t".repeat(Math.max(0, indent_level)) +
                    "new ";
            writeToOutput(creation);
        }
        @Override
        public void exitCreation(scalaToCppParser.CreationContext ctx) {
            writeToOutput(";\n");
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
            writeToOutput(" ");
        }

        @Override
        public void enterParameter(scalaToCppParser.ParameterContext ctx) {
            StringBuilder parameter = new StringBuilder();
            parameter.append("\t".repeat(Math.max(0, indent_level)));

            List<TerminalNode> identifiers = ctx.getTokens(scalaToCppParser.IDENTIFIER);
            parameter.append(identifiers.get(0).toString() + " " + identifiers.get(1).toString());
            writeToOutput(parameter.toString());
        }

        @Override
        public void exitParameter(scalaToCppParser.ParameterContext ctx) {}

        @Override
        public void enterDefBlock(scalaToCppParser.DefBlockContext ctx) {
            StringBuilder defBlock = new StringBuilder();
            defBlock.append("\t".repeat(Math.max(0, indent_level)) + "{\n");

            writeToOutput(defBlock.toString());
        }

        @Override
        public void exitDefBlock(scalaToCppParser.DefBlockContext ctx) {
            StringBuilder defBlock = new StringBuilder();
            defBlock.append("\t".repeat(Math.max(0, indent_level)) + "}");

            writeToOutput(defBlock.toString());
        }

        @Override
        public void enterBlock(scalaToCppParser.BlockContext ctx) {
            StringBuilder block = new StringBuilder();
            block.append("\t".repeat(Math.max(0, indent_level)) + "{\n");

            writeToOutput(block.toString());
        }

        @Override
        public void exitBlock(scalaToCppParser.BlockContext ctx) {
            StringBuilder block = new StringBuilder();
            block.append("\t".repeat(Math.max(0, indent_level)) + "}");

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
            ifStatmenet.append("if (" + ctx.logicExpression().getText() + ")\n");

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
            whileStatmenet.append("while (" + ctx.logicExpression().getText() + ")\n");

            writeToOutput(whileStatmenet.toString());
        }
    }

    void processFile(){
        CharStream input = null;
        try {
            input = CharStreams.fromFileName("translator/src/test.scala");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Lexer lexer = new scalaToCppLexer(input);
        TokenStream tokens = new CommonTokenStream(lexer);
        scalaToCppParser parser = new scalaToCppParser(tokens);
        ParseTree tree = parser.plure();
        ParseTreeWalker walkerPrep = new ParseTreeWalker();
        ParseTreeWalker walker = new ParseTreeWalker();
        TypeListener listenerPrep = new TypeListener();
        walkerPrep.walk(listenerPrep, tree);

        types = listenerPrep.types;
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
            listener = new ProdListener("translator/src/test.cpp");
            walker.walk(listener, tree);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
