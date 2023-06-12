import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


public class scalaToCpp {

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
        public void enterAccessModifier(scalaToCppParser.AccessModifierContext ctx) {
            writeToOutput("\t".repeat(Math.max(0, indent_level)) + ctx.getText() + ":\n");
        }

        @Override
        public void exitAccessModifier(scalaToCppParser.AccessModifierContext ctx) {
        }

        @Override
        public void enterObjectDef(scalaToCppParser.ObjectDefContext ctx) {
            StringBuilder objectDef = new StringBuilder();
            objectDef.append("\t".repeat(Math.max(0, indent_level)));
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
            definition = definition.append("void*").append(ctx.IDENTIFIER().getText());
            // !!!!!!!!!!!!!!!!!! TODO: add type
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
            assignment.append(ctx.IDENTIFIER().getText()).append(" = ");
            if(ctx.operation() != null){
                assignment.append(ctx.operation().getText());
            }
            if(ctx.creation() != null){
                assignment.append(ctx.creation().getText());
            }
            if(ctx.listliteral() != null){
                assignment.append(ctx.listliteral().getText());
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
            listliteral.append("vector<");
            if(ctx.literal().get(0) != null){
                if(ctx.literal().get(0).INT_LITERAL() != null){
                    listliteral.append("int");
                }
                if(ctx.literal().get(0).STRING_LITERAL() != null){
                    listliteral.append("string");
                }
                if(ctx.literal().get(0).BOOLEAN_LITERAL() != null){
                    listliteral.append("bool");
                }
            }
            // !!!!!!!!!!!!!!!!!! TODO: add functions type
            listliteral.append(">");
        }
        @Override
        public void exitListliteral(scalaToCppParser.ListliteralContext ctx) {
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
            StringBuilder block = new StringBuilder();
            block.append("\t".repeat(Math.max(0, indent_level)) + "return ");
        }

        @Override
        public void exitReturnVal(scalaToCppParser.ReturnValContext ctx) {}


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
        ParseTreeWalker walker = new ParseTreeWalker();
        scalaToCppListener listener = null;
        try {
            listener = new ProdListener("translator/src/test.cpp");
            walker.walk(listener, tree);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
