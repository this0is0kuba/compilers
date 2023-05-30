import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.CharStream.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.io.IOException;
import java.util.List;


public class scalaToCpp {
    private static class CustomListener extends scalaToCppBaseListener {
        @Override
        public void enterEveryRule(ParserRuleContext ctx) {
            // get the token type of the current rule
            int tokenType = ctx.getRuleIndex();
            // get the name of the token
            String tokenName = scalaToCppParser.ruleNames[tokenType];
            // get the token content (only current rule)
            String tokenContent = ctx.getText();

            // print the token
            System.out.println("Entering   " +  "Token: " + tokenName + " - " + tokenContent);
        }

        @Override
        public void exitEveryRule(ParserRuleContext ctx) {
            // get the token type of the current rule
            int tokenType = ctx.getRuleIndex();
            // get the name of the token
            String tokenName = scalaToCppParser.ruleNames[tokenType];
            // get the token content (only current rule)
            String tokenContent = ctx.getText();

            // print the token
            System.out.println("Exiting    " +"Token: " + tokenName + " - " + tokenContent);
        }
    }

    void doStuff(){
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
