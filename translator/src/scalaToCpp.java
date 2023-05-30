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
            String tokenText = ctx.getText();
            System.out.println("Token Text: " + tokenText);
        }
    }

    void doStuff(){
        CharStream input = null;
        try {
            input = CharStreams.fromFileName("/Users/reczkok/Kompilatory/compilers/translator/src/test.scala");
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
