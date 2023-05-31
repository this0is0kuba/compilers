import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.CharStream.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.io.IOException;
import java.util.List;


public class scalaToCpp {
    private static class CustomListener extends scalaToCppBaseListener {
        private static int indent_level = 0;
        @Override
        public void enterEveryRule(ParserRuleContext ctx) {
            for(int i = 0; i < indent_level; i++) {
                System.out.print("  |  ");
            }
            // make an indentation based on the amount of children
            indent_level += 1;
            // get every token that is of type identifier
            // get the token type of the current rule
            int tokenType = ctx.getRuleIndex();
            // get the name of the token
            String tokenName = scalaToCppParser.ruleNames[tokenType];
            // get the token content (only current rule)
            String tokenContent = ctx.getText();

            // print the token
            System.out.print("Entering   " +  "Token: " + tokenName + " - " + tokenContent + "  ");

            List<TerminalNode> identifiers = ctx.getTokens(scalaToCppParser.IDENTIFIER);
            if(identifiers.size() > 0) {
                for( TerminalNode identifier : identifiers) {
                    System.out.print("Found identifier: " + identifier.getText());
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
            // get the token type of the current rule
            int tokenType = ctx.getRuleIndex();
            // get the name of the token
            String tokenName = scalaToCppParser.ruleNames[tokenType];
            // signal that we are exiting the token
            System.out.println("Exiting    " +  "Token: " + tokenName);
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
        ParseTreeWalker walker = new ParseTreeWalker();
        scalaToCppListener listener = new CustomListener();
        walker.walk(listener, tree);
    }

}
