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
            String expression = ctx.getText();
            writeToOutput(expression);
        }

        @Override
        public void exitExpression(scalaToCppParser.ExpressionContext ctx) {
            writeToOutput(" ");
        }

        @Override
        public void enterFunctionCall(scalaToCppParser.FunctionCallContext ctx) {
            StringBuilder functionCall = new StringBuilder();
            functionCall.append("\t".repeat(Math.max(0, indent_level)));
            functionCall.append(ctx.IDENTIFIER().getText());
            writeToOutput(functionCall.toString());
        }
        @Override
        public void exitFunctionCall(scalaToCppParser.FunctionCallContext ctx) {
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
