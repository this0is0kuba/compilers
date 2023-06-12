// Generated from C:/Users/Kuba/IdeaProjects/compilers\scalaToCpp.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class scalaToCppParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		CLASS=1, OBJECT=2, TRAIT=3, DEF=4, NEW=5, PRIVATE=6, PUBLIC=7, PROTECTED=8, 
		LPAREN=9, RPAREN=10, LBRACE=11, RBRACE=12, COMMA=13, DOT=14, EQ=15, SEMICOLON=16, 
		COLON=17, IF=18, ELSE=19, WHILE=20, FOR=21, RETURN=22, VAR=23, VAL=24, 
		ARROW=25, EQEQ=26, NEQ=27, LT=28, GT=29, LTEQ=30, GTEQ=31, PRO=32, AND=33, 
		OR=34, PLUS=35, MINUS=36, ASTERISK=37, SLASH=38, BANG=39, LIST=40, BOOLEAN_LITERAL=41, 
		INT_LITERAL=42, STRING_LITERAL=43, IDENTIFIER=44, WS=45;
	public static final int
		RULE_plure = 0, RULE_topLevelDef = 1, RULE_classDef = 2, RULE_accessModifier = 3, 
		RULE_objectDef = 4, RULE_traitDef = 5, RULE_def = 6, RULE_classBody = 7, 
		RULE_traitBody = 8, RULE_classMember = 9, RULE_traitMember = 10, RULE_parameterList = 11, 
		RULE_parameter = 12, RULE_returnType = 13, RULE_defBlock = 14, RULE_block = 15, 
		RULE_returnVal = 16, RULE_statement = 17, RULE_ifStatement = 18, RULE_elseStatement = 19, 
		RULE_whileStatement = 20, RULE_forStatement = 21, RULE_enumeration = 22, 
		RULE_expressionStatement = 23, RULE_logicExpression = 24, RULE_expression = 25, 
		RULE_functionCall = 26, RULE_objectMethodAccess = 27, RULE_argumentList = 28, 
		RULE_definition = 29, RULE_assignment = 30, RULE_listliteral = 31, RULE_operation = 32, 
		RULE_creation = 33, RULE_binaryOperator = 34, RULE_unaryOperator = 35, 
		RULE_simpleOperator = 36, RULE_literal = 37;
	private static String[] makeRuleNames() {
		return new String[] {
			"plure", "topLevelDef", "classDef", "accessModifier", "objectDef", "traitDef", 
			"def", "classBody", "traitBody", "classMember", "traitMember", "parameterList", 
			"parameter", "returnType", "defBlock", "block", "returnVal", "statement", 
			"ifStatement", "elseStatement", "whileStatement", "forStatement", "enumeration", 
			"expressionStatement", "logicExpression", "expression", "functionCall", 
			"objectMethodAccess", "argumentList", "definition", "assignment", "listliteral", 
			"operation", "creation", "binaryOperator", "unaryOperator", "simpleOperator", 
			"literal"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'class'", "'object'", "'trait'", "'def'", "'new'", "'private'", 
			"'public'", "'protected'", "'('", "')'", "'{'", "'}'", "','", "'.'", 
			"'='", "';'", "':'", "'if'", "'else'", "'while'", "'for'", "'return'", 
			"'var'", "'val'", "'<-'", "'=='", "'!='", "'<'", "'>'", "'<='", "'>='", 
			"'%'", "'&&'", "'||'", "'+'", "'-'", "'*'", "'/'", "'!'", "'List'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "CLASS", "OBJECT", "TRAIT", "DEF", "NEW", "PRIVATE", "PUBLIC", 
			"PROTECTED", "LPAREN", "RPAREN", "LBRACE", "RBRACE", "COMMA", "DOT", 
			"EQ", "SEMICOLON", "COLON", "IF", "ELSE", "WHILE", "FOR", "RETURN", "VAR", 
			"VAL", "ARROW", "EQEQ", "NEQ", "LT", "GT", "LTEQ", "GTEQ", "PRO", "AND", 
			"OR", "PLUS", "MINUS", "ASTERISK", "SLASH", "BANG", "LIST", "BOOLEAN_LITERAL", 
			"INT_LITERAL", "STRING_LITERAL", "IDENTIFIER", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "scalaToCpp.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public scalaToCppParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PlureContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(scalaToCppParser.EOF, 0); }
		public List<TopLevelDefContext> topLevelDef() {
			return getRuleContexts(TopLevelDefContext.class);
		}
		public TopLevelDefContext topLevelDef(int i) {
			return getRuleContext(TopLevelDefContext.class,i);
		}
		public PlureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_plure; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof scalaToCppListener ) ((scalaToCppListener)listener).enterPlure(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof scalaToCppListener ) ((scalaToCppListener)listener).exitPlure(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof scalaToCppVisitor ) return ((scalaToCppVisitor<? extends T>)visitor).visitPlure(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PlureContext plure() throws RecognitionException {
		PlureContext _localctx = new PlureContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_plure);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 478L) != 0)) {
				{
				{
				setState(76);
				topLevelDef();
				}
				}
				setState(81);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(82);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TopLevelDefContext extends ParserRuleContext {
		public ClassDefContext classDef() {
			return getRuleContext(ClassDefContext.class,0);
		}
		public ObjectDefContext objectDef() {
			return getRuleContext(ObjectDefContext.class,0);
		}
		public TraitDefContext traitDef() {
			return getRuleContext(TraitDefContext.class,0);
		}
		public DefContext def() {
			return getRuleContext(DefContext.class,0);
		}
		public TopLevelDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_topLevelDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof scalaToCppListener ) ((scalaToCppListener)listener).enterTopLevelDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof scalaToCppListener ) ((scalaToCppListener)listener).exitTopLevelDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof scalaToCppVisitor ) return ((scalaToCppVisitor<? extends T>)visitor).visitTopLevelDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TopLevelDefContext topLevelDef() throws RecognitionException {
		TopLevelDefContext _localctx = new TopLevelDefContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_topLevelDef);
		try {
			setState(88);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(84);
				classDef();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(85);
				objectDef();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(86);
				traitDef();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(87);
				def();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ClassDefContext extends ParserRuleContext {
		public TerminalNode CLASS() { return getToken(scalaToCppParser.CLASS, 0); }
		public TerminalNode IDENTIFIER() { return getToken(scalaToCppParser.IDENTIFIER, 0); }
		public ClassBodyContext classBody() {
			return getRuleContext(ClassBodyContext.class,0);
		}
		public AccessModifierContext accessModifier() {
			return getRuleContext(AccessModifierContext.class,0);
		}
		public ClassDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof scalaToCppListener ) ((scalaToCppListener)listener).enterClassDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof scalaToCppListener ) ((scalaToCppListener)listener).exitClassDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof scalaToCppVisitor ) return ((scalaToCppVisitor<? extends T>)visitor).visitClassDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDefContext classDef() throws RecognitionException {
		ClassDefContext _localctx = new ClassDefContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_classDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 448L) != 0)) {
				{
				setState(90);
				accessModifier();
				}
			}

			setState(93);
			match(CLASS);
			setState(94);
			match(IDENTIFIER);
			setState(95);
			classBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AccessModifierContext extends ParserRuleContext {
		public TerminalNode PUBLIC() { return getToken(scalaToCppParser.PUBLIC, 0); }
		public TerminalNode PRIVATE() { return getToken(scalaToCppParser.PRIVATE, 0); }
		public TerminalNode PROTECTED() { return getToken(scalaToCppParser.PROTECTED, 0); }
		public AccessModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_accessModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof scalaToCppListener ) ((scalaToCppListener)listener).enterAccessModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof scalaToCppListener ) ((scalaToCppListener)listener).exitAccessModifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof scalaToCppVisitor ) return ((scalaToCppVisitor<? extends T>)visitor).visitAccessModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AccessModifierContext accessModifier() throws RecognitionException {
		AccessModifierContext _localctx = new AccessModifierContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_accessModifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 448L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ObjectDefContext extends ParserRuleContext {
		public TerminalNode OBJECT() { return getToken(scalaToCppParser.OBJECT, 0); }
		public TerminalNode IDENTIFIER() { return getToken(scalaToCppParser.IDENTIFIER, 0); }
		public ClassBodyContext classBody() {
			return getRuleContext(ClassBodyContext.class,0);
		}
		public AccessModifierContext accessModifier() {
			return getRuleContext(AccessModifierContext.class,0);
		}
		public ObjectDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objectDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof scalaToCppListener ) ((scalaToCppListener)listener).enterObjectDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof scalaToCppListener ) ((scalaToCppListener)listener).exitObjectDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof scalaToCppVisitor ) return ((scalaToCppVisitor<? extends T>)visitor).visitObjectDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObjectDefContext objectDef() throws RecognitionException {
		ObjectDefContext _localctx = new ObjectDefContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_objectDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 448L) != 0)) {
				{
				setState(99);
				accessModifier();
				}
			}

			setState(102);
			match(OBJECT);
			setState(103);
			match(IDENTIFIER);
			setState(104);
			classBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TraitDefContext extends ParserRuleContext {
		public TerminalNode TRAIT() { return getToken(scalaToCppParser.TRAIT, 0); }
		public TerminalNode IDENTIFIER() { return getToken(scalaToCppParser.IDENTIFIER, 0); }
		public TraitBodyContext traitBody() {
			return getRuleContext(TraitBodyContext.class,0);
		}
		public AccessModifierContext accessModifier() {
			return getRuleContext(AccessModifierContext.class,0);
		}
		public TraitDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_traitDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof scalaToCppListener ) ((scalaToCppListener)listener).enterTraitDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof scalaToCppListener ) ((scalaToCppListener)listener).exitTraitDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof scalaToCppVisitor ) return ((scalaToCppVisitor<? extends T>)visitor).visitTraitDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TraitDefContext traitDef() throws RecognitionException {
		TraitDefContext _localctx = new TraitDefContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_traitDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 448L) != 0)) {
				{
				setState(106);
				accessModifier();
				}
			}

			setState(109);
			match(TRAIT);
			setState(110);
			match(IDENTIFIER);
			setState(111);
			traitBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DefContext extends ParserRuleContext {
		public TerminalNode DEF() { return getToken(scalaToCppParser.DEF, 0); }
		public TerminalNode IDENTIFIER() { return getToken(scalaToCppParser.IDENTIFIER, 0); }
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public ReturnTypeContext returnType() {
			return getRuleContext(ReturnTypeContext.class,0);
		}
		public TerminalNode EQ() { return getToken(scalaToCppParser.EQ, 0); }
		public DefBlockContext defBlock() {
			return getRuleContext(DefBlockContext.class,0);
		}
		public AccessModifierContext accessModifier() {
			return getRuleContext(AccessModifierContext.class,0);
		}
		public DefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof scalaToCppListener ) ((scalaToCppListener)listener).enterDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof scalaToCppListener ) ((scalaToCppListener)listener).exitDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof scalaToCppVisitor ) return ((scalaToCppVisitor<? extends T>)visitor).visitDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefContext def() throws RecognitionException {
		DefContext _localctx = new DefContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 448L) != 0)) {
				{
				setState(113);
				accessModifier();
				}
			}

			setState(116);
			match(DEF);
			setState(117);
			match(IDENTIFIER);
			setState(118);
			parameterList();
			setState(119);
			returnType();
			setState(120);
			match(EQ);
			setState(121);
			defBlock();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ClassBodyContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(scalaToCppParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(scalaToCppParser.RBRACE, 0); }
		public List<ClassMemberContext> classMember() {
			return getRuleContexts(ClassMemberContext.class);
		}
		public ClassMemberContext classMember(int i) {
			return getRuleContext(ClassMemberContext.class,i);
		}
		public ClassBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof scalaToCppListener ) ((scalaToCppListener)listener).enterClassBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof scalaToCppListener ) ((scalaToCppListener)listener).exitClassBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof scalaToCppVisitor ) return ((scalaToCppVisitor<? extends T>)visitor).visitClassBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassBodyContext classBody() throws RecognitionException {
		ClassBodyContext _localctx = new ClassBodyContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_classBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			match(LBRACE);
			setState(127);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 17592211210706L) != 0)) {
				{
				{
				setState(124);
				classMember();
				}
				}
				setState(129);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(130);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TraitBodyContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(scalaToCppParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(scalaToCppParser.RBRACE, 0); }
		public List<TraitMemberContext> traitMember() {
			return getRuleContexts(TraitMemberContext.class);
		}
		public TraitMemberContext traitMember(int i) {
			return getRuleContext(TraitMemberContext.class,i);
		}
		public TraitBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_traitBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof scalaToCppListener ) ((scalaToCppListener)listener).enterTraitBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof scalaToCppListener ) ((scalaToCppListener)listener).exitTraitBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof scalaToCppVisitor ) return ((scalaToCppVisitor<? extends T>)visitor).visitTraitBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TraitBodyContext traitBody() throws RecognitionException {
		TraitBodyContext _localctx = new TraitBodyContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_traitBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			match(LBRACE);
			setState(136);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 472L) != 0)) {
				{
				{
				setState(133);
				traitMember();
				}
				}
				setState(138);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(139);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ClassMemberContext extends ParserRuleContext {
		public ClassDefContext classDef() {
			return getRuleContext(ClassDefContext.class,0);
		}
		public DefContext def() {
			return getRuleContext(DefContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(scalaToCppParser.SEMICOLON, 0); }
		public DefinitionContext definition() {
			return getRuleContext(DefinitionContext.class,0);
		}
		public ClassMemberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classMember; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof scalaToCppListener ) ((scalaToCppListener)listener).enterClassMember(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof scalaToCppListener ) ((scalaToCppListener)listener).exitClassMember(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof scalaToCppVisitor ) return ((scalaToCppVisitor<? extends T>)visitor).visitClassMember(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassMemberContext classMember() throws RecognitionException {
		ClassMemberContext _localctx = new ClassMemberContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_classMember);
		try {
			setState(149);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(141);
				classDef();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(142);
				def();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(143);
				assignment();
				setState(144);
				match(SEMICOLON);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(146);
				definition();
				setState(147);
				match(SEMICOLON);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TraitMemberContext extends ParserRuleContext {
		public TraitDefContext traitDef() {
			return getRuleContext(TraitDefContext.class,0);
		}
		public DefContext def() {
			return getRuleContext(DefContext.class,0);
		}
		public TraitMemberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_traitMember; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof scalaToCppListener ) ((scalaToCppListener)listener).enterTraitMember(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof scalaToCppListener ) ((scalaToCppListener)listener).exitTraitMember(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof scalaToCppVisitor ) return ((scalaToCppVisitor<? extends T>)visitor).visitTraitMember(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TraitMemberContext traitMember() throws RecognitionException {
		TraitMemberContext _localctx = new TraitMemberContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_traitMember);
		try {
			setState(153);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(151);
				traitDef();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(152);
				def();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParameterListContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(scalaToCppParser.LPAREN, 0); }
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(scalaToCppParser.RPAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(scalaToCppParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(scalaToCppParser.COMMA, i);
		}
		public ParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof scalaToCppListener ) ((scalaToCppListener)listener).enterParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof scalaToCppListener ) ((scalaToCppListener)listener).exitParameterList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof scalaToCppVisitor ) return ((scalaToCppVisitor<? extends T>)visitor).visitParameterList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterListContext parameterList() throws RecognitionException {
		ParameterListContext _localctx = new ParameterListContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_parameterList);
		int _la;
		try {
			setState(168);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(155);
				match(LPAREN);
				setState(156);
				parameter();
				setState(161);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(157);
					match(COMMA);
					setState(158);
					parameter();
					}
					}
					setState(163);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(164);
				match(RPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(166);
				match(LPAREN);
				setState(167);
				match(RPAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParameterContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(scalaToCppParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(scalaToCppParser.IDENTIFIER, i);
		}
		public TerminalNode COLON() { return getToken(scalaToCppParser.COLON, 0); }
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof scalaToCppListener ) ((scalaToCppListener)listener).enterParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof scalaToCppListener ) ((scalaToCppListener)listener).exitParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof scalaToCppVisitor ) return ((scalaToCppVisitor<? extends T>)visitor).visitParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_parameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			match(IDENTIFIER);
			setState(171);
			match(COLON);
			setState(172);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReturnTypeContext extends ParserRuleContext {
		public TerminalNode COLON() { return getToken(scalaToCppParser.COLON, 0); }
		public TerminalNode IDENTIFIER() { return getToken(scalaToCppParser.IDENTIFIER, 0); }
		public ReturnTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof scalaToCppListener ) ((scalaToCppListener)listener).enterReturnType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof scalaToCppListener ) ((scalaToCppListener)listener).exitReturnType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof scalaToCppVisitor ) return ((scalaToCppVisitor<? extends T>)visitor).visitReturnType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnTypeContext returnType() throws RecognitionException {
		ReturnTypeContext _localctx = new ReturnTypeContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_returnType);
		try {
			setState(177);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COLON:
				enterOuterAlt(_localctx, 1);
				{
				setState(174);
				match(COLON);
				setState(175);
				match(IDENTIFIER);
				}
				break;
			case EQ:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DefBlockContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(scalaToCppParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(scalaToCppParser.RBRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ReturnValContext returnVal() {
			return getRuleContext(ReturnValContext.class,0);
		}
		public DefBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof scalaToCppListener ) ((scalaToCppListener)listener).enterDefBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof scalaToCppListener ) ((scalaToCppListener)listener).exitDefBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof scalaToCppVisitor ) return ((scalaToCppVisitor<? extends T>)visitor).visitDefBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefBlockContext defBlock() throws RecognitionException {
		DefBlockContext _localctx = new DefBlockContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_defBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			match(LBRACE);
			setState(183);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 32985377409024L) != 0)) {
				{
				{
				setState(180);
				statement();
				}
				}
				setState(185);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(187);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RETURN) {
				{
				setState(186);
				returnVal();
				}
			}

			setState(189);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(scalaToCppParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(scalaToCppParser.RBRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof scalaToCppListener ) ((scalaToCppListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof scalaToCppListener ) ((scalaToCppListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof scalaToCppVisitor ) return ((scalaToCppVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			match(LBRACE);
			setState(195);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 32985377409024L) != 0)) {
				{
				{
				setState(192);
				statement();
				}
				}
				setState(197);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(198);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReturnValContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(scalaToCppParser.RETURN, 0); }
		public ExpressionStatementContext expressionStatement() {
			return getRuleContext(ExpressionStatementContext.class,0);
		}
		public ReturnValContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnVal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof scalaToCppListener ) ((scalaToCppListener)listener).enterReturnVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof scalaToCppListener ) ((scalaToCppListener)listener).exitReturnVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof scalaToCppVisitor ) return ((scalaToCppVisitor<? extends T>)visitor).visitReturnVal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnValContext returnVal() throws RecognitionException {
		ReturnValContext _localctx = new ReturnValContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_returnVal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			match(RETURN);
			setState(201);
			expressionStatement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
		}
		public ForStatementContext forStatement() {
			return getRuleContext(ForStatementContext.class,0);
		}
		public ExpressionStatementContext expressionStatement() {
			return getRuleContext(ExpressionStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof scalaToCppListener ) ((scalaToCppListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof scalaToCppListener ) ((scalaToCppListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof scalaToCppVisitor ) return ((scalaToCppVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_statement);
		try {
			setState(208);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(203);
				block();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(204);
				ifStatement();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 3);
				{
				setState(205);
				whileStatement();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 4);
				{
				setState(206);
				forStatement();
				}
				break;
			case VAR:
			case VAL:
			case BOOLEAN_LITERAL:
			case INT_LITERAL:
			case STRING_LITERAL:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 5);
				{
				setState(207);
				expressionStatement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IfStatementContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(scalaToCppParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(scalaToCppParser.LPAREN, 0); }
		public LogicExpressionContext logicExpression() {
			return getRuleContext(LogicExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(scalaToCppParser.RPAREN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ElseStatementContext elseStatement() {
			return getRuleContext(ElseStatementContext.class,0);
		}
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof scalaToCppListener ) ((scalaToCppListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof scalaToCppListener ) ((scalaToCppListener)listener).exitIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof scalaToCppVisitor ) return ((scalaToCppVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_ifStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			match(IF);
			setState(211);
			match(LPAREN);
			setState(212);
			logicExpression();
			setState(213);
			match(RPAREN);
			setState(216);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(214);
				block();
				}
				break;
			case 2:
				{
				setState(215);
				statement();
				}
				break;
			}
			setState(219);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(218);
				elseStatement();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ElseStatementContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(scalaToCppParser.ELSE, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ElseStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof scalaToCppListener ) ((scalaToCppListener)listener).enterElseStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof scalaToCppListener ) ((scalaToCppListener)listener).exitElseStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof scalaToCppVisitor ) return ((scalaToCppVisitor<? extends T>)visitor).visitElseStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseStatementContext elseStatement() throws RecognitionException {
		ElseStatementContext _localctx = new ElseStatementContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_elseStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			match(ELSE);
			setState(224);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(222);
				block();
				}
				break;
			case 2:
				{
				setState(223);
				statement();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WhileStatementContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(scalaToCppParser.WHILE, 0); }
		public TerminalNode LPAREN() { return getToken(scalaToCppParser.LPAREN, 0); }
		public LogicExpressionContext logicExpression() {
			return getRuleContext(LogicExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(scalaToCppParser.RPAREN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public WhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof scalaToCppListener ) ((scalaToCppListener)listener).enterWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof scalaToCppListener ) ((scalaToCppListener)listener).exitWhileStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof scalaToCppVisitor ) return ((scalaToCppVisitor<? extends T>)visitor).visitWhileStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226);
			match(WHILE);
			setState(227);
			match(LPAREN);
			setState(228);
			logicExpression();
			setState(229);
			match(RPAREN);
			setState(230);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForStatementContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(scalaToCppParser.FOR, 0); }
		public TerminalNode LPAREN() { return getToken(scalaToCppParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(scalaToCppParser.RPAREN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public LogicExpressionContext logicExpression() {
			return getRuleContext(LogicExpressionContext.class,0);
		}
		public EnumerationContext enumeration() {
			return getRuleContext(EnumerationContext.class,0);
		}
		public ForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof scalaToCppListener ) ((scalaToCppListener)listener).enterForStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof scalaToCppListener ) ((scalaToCppListener)listener).exitForStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof scalaToCppVisitor ) return ((scalaToCppVisitor<? extends T>)visitor).visitForStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForStatementContext forStatement() throws RecognitionException {
		ForStatementContext _localctx = new ForStatementContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_forStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
			match(FOR);
			setState(233);
			match(LPAREN);
			setState(236);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(234);
				logicExpression();
				}
				break;
			case 2:
				{
				setState(235);
				enumeration();
				}
				break;
			}
			setState(238);
			match(RPAREN);
			setState(239);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EnumerationContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(scalaToCppParser.IDENTIFIER, 0); }
		public TerminalNode ARROW() { return getToken(scalaToCppParser.ARROW, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ListliteralContext listliteral() {
			return getRuleContext(ListliteralContext.class,0);
		}
		public EnumerationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumeration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof scalaToCppListener ) ((scalaToCppListener)listener).enterEnumeration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof scalaToCppListener ) ((scalaToCppListener)listener).exitEnumeration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof scalaToCppVisitor ) return ((scalaToCppVisitor<? extends T>)visitor).visitEnumeration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumerationContext enumeration() throws RecognitionException {
		EnumerationContext _localctx = new EnumerationContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_enumeration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			match(IDENTIFIER);
			setState(242);
			match(ARROW);
			setState(245);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAR:
			case VAL:
			case BOOLEAN_LITERAL:
			case INT_LITERAL:
			case STRING_LITERAL:
			case IDENTIFIER:
				{
				setState(243);
				expression();
				}
				break;
			case LIST:
				{
				setState(244);
				listliteral();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(scalaToCppParser.SEMICOLON, 0); }
		public ExpressionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof scalaToCppListener ) ((scalaToCppListener)listener).enterExpressionStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof scalaToCppListener ) ((scalaToCppListener)listener).exitExpressionStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof scalaToCppVisitor ) return ((scalaToCppVisitor<? extends T>)visitor).visitExpressionStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionStatementContext expressionStatement() throws RecognitionException {
		ExpressionStatementContext _localctx = new ExpressionStatementContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_expressionStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			expression();
			setState(248);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LogicExpressionContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public BinaryOperatorContext binaryOperator() {
			return getRuleContext(BinaryOperatorContext.class,0);
		}
		public UnaryOperatorContext unaryOperator() {
			return getRuleContext(UnaryOperatorContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(scalaToCppParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(scalaToCppParser.RPAREN, 0); }
		public LogicExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof scalaToCppListener ) ((scalaToCppListener)listener).enterLogicExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof scalaToCppListener ) ((scalaToCppListener)listener).exitLogicExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof scalaToCppVisitor ) return ((scalaToCppVisitor<? extends T>)visitor).visitLogicExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicExpressionContext logicExpression() throws RecognitionException {
		LogicExpressionContext _localctx = new LogicExpressionContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_logicExpression);
		try {
			setState(261);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAR:
			case VAL:
			case BOOLEAN_LITERAL:
			case INT_LITERAL:
			case STRING_LITERAL:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(250);
				expression();
				setState(251);
				binaryOperator();
				setState(252);
				expression();
				}
				break;
			case PLUS:
			case MINUS:
			case BANG:
				enterOuterAlt(_localctx, 2);
				{
				setState(254);
				unaryOperator();
				setState(255);
				expression();
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 3);
				{
				setState(257);
				match(LPAREN);
				setState(258);
				expression();
				setState(259);
				match(RPAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(scalaToCppParser.IDENTIFIER, 0); }
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public ObjectMethodAccessContext objectMethodAccess() {
			return getRuleContext(ObjectMethodAccessContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public DefinitionContext definition() {
			return getRuleContext(DefinitionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof scalaToCppListener ) ((scalaToCppListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof scalaToCppListener ) ((scalaToCppListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof scalaToCppVisitor ) return ((scalaToCppVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_expression);
		try {
			setState(269);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(263);
				literal();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(264);
				match(IDENTIFIER);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(265);
				functionCall();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(266);
				objectMethodAccess();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(267);
				assignment();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(268);
				definition();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionCallContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(scalaToCppParser.IDENTIFIER, 0); }
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof scalaToCppListener ) ((scalaToCppListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof scalaToCppListener ) ((scalaToCppListener)listener).exitFunctionCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof scalaToCppVisitor ) return ((scalaToCppVisitor<? extends T>)visitor).visitFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_functionCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(271);
			match(IDENTIFIER);
			setState(272);
			argumentList();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ObjectMethodAccessContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(scalaToCppParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(scalaToCppParser.IDENTIFIER, i);
		}
		public TerminalNode DOT() { return getToken(scalaToCppParser.DOT, 0); }
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public ObjectMethodAccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objectMethodAccess; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof scalaToCppListener ) ((scalaToCppListener)listener).enterObjectMethodAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof scalaToCppListener ) ((scalaToCppListener)listener).exitObjectMethodAccess(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof scalaToCppVisitor ) return ((scalaToCppVisitor<? extends T>)visitor).visitObjectMethodAccess(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObjectMethodAccessContext objectMethodAccess() throws RecognitionException {
		ObjectMethodAccessContext _localctx = new ObjectMethodAccessContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_objectMethodAccess);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
			match(IDENTIFIER);
			setState(275);
			match(DOT);
			setState(276);
			match(IDENTIFIER);
			setState(278);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(277);
				argumentList();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArgumentListContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(scalaToCppParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(scalaToCppParser.RPAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(scalaToCppParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(scalaToCppParser.COMMA, i);
		}
		public ArgumentListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof scalaToCppListener ) ((scalaToCppListener)listener).enterArgumentList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof scalaToCppListener ) ((scalaToCppListener)listener).exitArgumentList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof scalaToCppVisitor ) return ((scalaToCppVisitor<? extends T>)visitor).visitArgumentList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentListContext argumentList() throws RecognitionException {
		ArgumentListContext _localctx = new ArgumentListContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_argumentList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(280);
			match(LPAREN);
			setState(289);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 32985373999104L) != 0)) {
				{
				setState(281);
				expression();
				setState(286);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(282);
					match(COMMA);
					setState(283);
					expression();
					}
					}
					setState(288);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(291);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DefinitionContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(scalaToCppParser.IDENTIFIER, 0); }
		public TerminalNode VAR() { return getToken(scalaToCppParser.VAR, 0); }
		public TerminalNode VAL() { return getToken(scalaToCppParser.VAL, 0); }
		public DefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof scalaToCppListener ) ((scalaToCppListener)listener).enterDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof scalaToCppListener ) ((scalaToCppListener)listener).exitDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof scalaToCppVisitor ) return ((scalaToCppVisitor<? extends T>)visitor).visitDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefinitionContext definition() throws RecognitionException {
		DefinitionContext _localctx = new DefinitionContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_definition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(296);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAR:
				{
				setState(293);
				match(VAR);
				}
				break;
			case VAL:
				{
				setState(294);
				match(VAL);
				}
				break;
			case IDENTIFIER:
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(298);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(scalaToCppParser.IDENTIFIER, 0); }
		public TerminalNode EQ() { return getToken(scalaToCppParser.EQ, 0); }
		public TerminalNode VAR() { return getToken(scalaToCppParser.VAR, 0); }
		public TerminalNode VAL() { return getToken(scalaToCppParser.VAL, 0); }
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
		}
		public CreationContext creation() {
			return getRuleContext(CreationContext.class,0);
		}
		public ListliteralContext listliteral() {
			return getRuleContext(ListliteralContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof scalaToCppListener ) ((scalaToCppListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof scalaToCppListener ) ((scalaToCppListener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof scalaToCppVisitor ) return ((scalaToCppVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(303);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAR:
				{
				setState(300);
				match(VAR);
				}
				break;
			case VAL:
				{
				setState(301);
				match(VAL);
				}
				break;
			case IDENTIFIER:
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(305);
			match(IDENTIFIER);
			setState(306);
			match(EQ);
			setState(310);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOLEAN_LITERAL:
			case INT_LITERAL:
			case STRING_LITERAL:
			case IDENTIFIER:
				{
				setState(307);
				operation();
				}
				break;
			case NEW:
				{
				setState(308);
				creation();
				}
				break;
			case LIST:
				{
				setState(309);
				listliteral();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ListliteralContext extends ParserRuleContext {
		public TerminalNode LIST() { return getToken(scalaToCppParser.LIST, 0); }
		public TerminalNode LPAREN() { return getToken(scalaToCppParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(scalaToCppParser.RPAREN, 0); }
		public List<LiteralContext> literal() {
			return getRuleContexts(LiteralContext.class);
		}
		public LiteralContext literal(int i) {
			return getRuleContext(LiteralContext.class,i);
		}
		public List<CreationContext> creation() {
			return getRuleContexts(CreationContext.class);
		}
		public CreationContext creation(int i) {
			return getRuleContext(CreationContext.class,i);
		}
		public List<FunctionCallContext> functionCall() {
			return getRuleContexts(FunctionCallContext.class);
		}
		public FunctionCallContext functionCall(int i) {
			return getRuleContext(FunctionCallContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(scalaToCppParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(scalaToCppParser.COMMA, i);
		}
		public ListliteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listliteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof scalaToCppListener ) ((scalaToCppListener)listener).enterListliteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof scalaToCppListener ) ((scalaToCppListener)listener).exitListliteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof scalaToCppVisitor ) return ((scalaToCppVisitor<? extends T>)visitor).visitListliteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListliteralContext listliteral() throws RecognitionException {
		ListliteralContext _localctx = new ListliteralContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_listliteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(312);
			match(LIST);
			setState(313);
			match(LPAREN);
			setState(330);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 32985348833312L) != 0)) {
				{
				setState(317);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case BOOLEAN_LITERAL:
				case INT_LITERAL:
				case STRING_LITERAL:
					{
					setState(314);
					literal();
					}
					break;
				case NEW:
					{
					setState(315);
					creation();
					}
					break;
				case IDENTIFIER:
					{
					setState(316);
					functionCall();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(327);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(319);
					match(COMMA);
					setState(323);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case BOOLEAN_LITERAL:
					case INT_LITERAL:
					case STRING_LITERAL:
						{
						setState(320);
						literal();
						}
						break;
					case NEW:
						{
						setState(321);
						creation();
						}
						break;
					case IDENTIFIER:
						{
						setState(322);
						functionCall();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					}
					setState(329);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(332);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OperationContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(scalaToCppParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(scalaToCppParser.IDENTIFIER, i);
		}
		public List<LiteralContext> literal() {
			return getRuleContexts(LiteralContext.class);
		}
		public LiteralContext literal(int i) {
			return getRuleContext(LiteralContext.class,i);
		}
		public List<SimpleOperatorContext> simpleOperator() {
			return getRuleContexts(SimpleOperatorContext.class);
		}
		public SimpleOperatorContext simpleOperator(int i) {
			return getRuleContext(SimpleOperatorContext.class,i);
		}
		public OperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof scalaToCppListener ) ((scalaToCppListener)listener).enterOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof scalaToCppListener ) ((scalaToCppListener)listener).exitOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof scalaToCppVisitor ) return ((scalaToCppVisitor<? extends T>)visitor).visitOperation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperationContext operation() throws RecognitionException {
		OperationContext _localctx = new OperationContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_operation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(336);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				{
				setState(334);
				match(IDENTIFIER);
				}
				break;
			case BOOLEAN_LITERAL:
			case INT_LITERAL:
			case STRING_LITERAL:
				{
				setState(335);
				literal();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(345);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 515396075520L) != 0)) {
				{
				{
				setState(338);
				simpleOperator();
				setState(341);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case IDENTIFIER:
					{
					setState(339);
					match(IDENTIFIER);
					}
					break;
				case BOOLEAN_LITERAL:
				case INT_LITERAL:
				case STRING_LITERAL:
					{
					setState(340);
					literal();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				setState(347);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CreationContext extends ParserRuleContext {
		public TerminalNode NEW() { return getToken(scalaToCppParser.NEW, 0); }
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public CreationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_creation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof scalaToCppListener ) ((scalaToCppListener)listener).enterCreation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof scalaToCppListener ) ((scalaToCppListener)listener).exitCreation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof scalaToCppVisitor ) return ((scalaToCppVisitor<? extends T>)visitor).visitCreation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CreationContext creation() throws RecognitionException {
		CreationContext _localctx = new CreationContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_creation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(348);
			match(NEW);
			setState(349);
			functionCall();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BinaryOperatorContext extends ParserRuleContext {
		public TerminalNode EQEQ() { return getToken(scalaToCppParser.EQEQ, 0); }
		public TerminalNode NEQ() { return getToken(scalaToCppParser.NEQ, 0); }
		public TerminalNode LT() { return getToken(scalaToCppParser.LT, 0); }
		public TerminalNode GT() { return getToken(scalaToCppParser.GT, 0); }
		public TerminalNode LTEQ() { return getToken(scalaToCppParser.LTEQ, 0); }
		public TerminalNode GTEQ() { return getToken(scalaToCppParser.GTEQ, 0); }
		public TerminalNode AND() { return getToken(scalaToCppParser.AND, 0); }
		public TerminalNode OR() { return getToken(scalaToCppParser.OR, 0); }
		public TerminalNode PRO() { return getToken(scalaToCppParser.PRO, 0); }
		public BinaryOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binaryOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof scalaToCppListener ) ((scalaToCppListener)listener).enterBinaryOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof scalaToCppListener ) ((scalaToCppListener)listener).exitBinaryOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof scalaToCppVisitor ) return ((scalaToCppVisitor<? extends T>)visitor).visitBinaryOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BinaryOperatorContext binaryOperator() throws RecognitionException {
		BinaryOperatorContext _localctx = new BinaryOperatorContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_binaryOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(351);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 34292629504L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UnaryOperatorContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(scalaToCppParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(scalaToCppParser.MINUS, 0); }
		public TerminalNode BANG() { return getToken(scalaToCppParser.BANG, 0); }
		public UnaryOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof scalaToCppListener ) ((scalaToCppListener)listener).enterUnaryOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof scalaToCppListener ) ((scalaToCppListener)listener).exitUnaryOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof scalaToCppVisitor ) return ((scalaToCppVisitor<? extends T>)visitor).visitUnaryOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryOperatorContext unaryOperator() throws RecognitionException {
		UnaryOperatorContext _localctx = new UnaryOperatorContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_unaryOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(353);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 652835028992L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SimpleOperatorContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(scalaToCppParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(scalaToCppParser.MINUS, 0); }
		public TerminalNode ASTERISK() { return getToken(scalaToCppParser.ASTERISK, 0); }
		public TerminalNode SLASH() { return getToken(scalaToCppParser.SLASH, 0); }
		public SimpleOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof scalaToCppListener ) ((scalaToCppListener)listener).enterSimpleOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof scalaToCppListener ) ((scalaToCppListener)listener).exitSimpleOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof scalaToCppVisitor ) return ((scalaToCppVisitor<? extends T>)visitor).visitSimpleOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleOperatorContext simpleOperator() throws RecognitionException {
		SimpleOperatorContext _localctx = new SimpleOperatorContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_simpleOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(355);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 515396075520L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode BOOLEAN_LITERAL() { return getToken(scalaToCppParser.BOOLEAN_LITERAL, 0); }
		public TerminalNode INT_LITERAL() { return getToken(scalaToCppParser.INT_LITERAL, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(scalaToCppParser.STRING_LITERAL, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof scalaToCppListener ) ((scalaToCppListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof scalaToCppListener ) ((scalaToCppListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof scalaToCppVisitor ) return ((scalaToCppVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(357);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 15393162788864L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001-\u0168\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0001\u0000\u0005\u0000N\b\u0000"+
		"\n\u0000\f\u0000Q\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0003\u0001Y\b\u0001\u0001\u0002\u0003\u0002"+
		"\\\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0003\u0004e\b\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0003\u0005l\b\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0003\u0006s\b\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0005\u0007~\b\u0007\n\u0007\f\u0007"+
		"\u0081\t\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0005\b\u0087\b"+
		"\b\n\b\f\b\u008a\t\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0003\t\u0096\b\t\u0001\n\u0001\n\u0003\n\u009a"+
		"\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u00a0"+
		"\b\u000b\n\u000b\f\u000b\u00a3\t\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0003\u000b\u00a9\b\u000b\u0001\f\u0001\f\u0001\f\u0001\f"+
		"\u0001\r\u0001\r\u0001\r\u0003\r\u00b2\b\r\u0001\u000e\u0001\u000e\u0005"+
		"\u000e\u00b6\b\u000e\n\u000e\f\u000e\u00b9\t\u000e\u0001\u000e\u0003\u000e"+
		"\u00bc\b\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0005\u000f"+
		"\u00c2\b\u000f\n\u000f\f\u000f\u00c5\t\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0003\u0011\u00d1\b\u0011\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u00d9\b\u0012\u0001"+
		"\u0012\u0003\u0012\u00dc\b\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0003"+
		"\u0013\u00e1\b\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0003"+
		"\u0015\u00ed\b\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0003\u0016\u00f6\b\u0016\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0003\u0018\u0106\b\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0003\u0019\u010e\b\u0019\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0003"+
		"\u001b\u0117\b\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0005"+
		"\u001c\u011d\b\u001c\n\u001c\f\u001c\u0120\t\u001c\u0003\u001c\u0122\b"+
		"\u001c\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0003"+
		"\u001d\u0129\b\u001d\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001"+
		"\u001e\u0003\u001e\u0130\b\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001"+
		"\u001e\u0001\u001e\u0003\u001e\u0137\b\u001e\u0001\u001f\u0001\u001f\u0001"+
		"\u001f\u0001\u001f\u0001\u001f\u0003\u001f\u013e\b\u001f\u0001\u001f\u0001"+
		"\u001f\u0001\u001f\u0001\u001f\u0003\u001f\u0144\b\u001f\u0005\u001f\u0146"+
		"\b\u001f\n\u001f\f\u001f\u0149\t\u001f\u0003\u001f\u014b\b\u001f\u0001"+
		"\u001f\u0001\u001f\u0001 \u0001 \u0003 \u0151\b \u0001 \u0001 \u0001 "+
		"\u0003 \u0156\b \u0005 \u0158\b \n \f \u015b\t \u0001!\u0001!\u0001!\u0001"+
		"\"\u0001\"\u0001#\u0001#\u0001$\u0001$\u0001%\u0001%\u0001%\u0000\u0000"+
		"&\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a"+
		"\u001c\u001e \"$&(*,.02468:<>@BDFHJ\u0000\u0005\u0001\u0000\u0006\b\u0001"+
		"\u0000\u001a\"\u0002\u0000#$\'\'\u0001\u0000#&\u0001\u0000)+\u0177\u0000"+
		"O\u0001\u0000\u0000\u0000\u0002X\u0001\u0000\u0000\u0000\u0004[\u0001"+
		"\u0000\u0000\u0000\u0006a\u0001\u0000\u0000\u0000\bd\u0001\u0000\u0000"+
		"\u0000\nk\u0001\u0000\u0000\u0000\fr\u0001\u0000\u0000\u0000\u000e{\u0001"+
		"\u0000\u0000\u0000\u0010\u0084\u0001\u0000\u0000\u0000\u0012\u0095\u0001"+
		"\u0000\u0000\u0000\u0014\u0099\u0001\u0000\u0000\u0000\u0016\u00a8\u0001"+
		"\u0000\u0000\u0000\u0018\u00aa\u0001\u0000\u0000\u0000\u001a\u00b1\u0001"+
		"\u0000\u0000\u0000\u001c\u00b3\u0001\u0000\u0000\u0000\u001e\u00bf\u0001"+
		"\u0000\u0000\u0000 \u00c8\u0001\u0000\u0000\u0000\"\u00d0\u0001\u0000"+
		"\u0000\u0000$\u00d2\u0001\u0000\u0000\u0000&\u00dd\u0001\u0000\u0000\u0000"+
		"(\u00e2\u0001\u0000\u0000\u0000*\u00e8\u0001\u0000\u0000\u0000,\u00f1"+
		"\u0001\u0000\u0000\u0000.\u00f7\u0001\u0000\u0000\u00000\u0105\u0001\u0000"+
		"\u0000\u00002\u010d\u0001\u0000\u0000\u00004\u010f\u0001\u0000\u0000\u0000"+
		"6\u0112\u0001\u0000\u0000\u00008\u0118\u0001\u0000\u0000\u0000:\u0128"+
		"\u0001\u0000\u0000\u0000<\u012f\u0001\u0000\u0000\u0000>\u0138\u0001\u0000"+
		"\u0000\u0000@\u0150\u0001\u0000\u0000\u0000B\u015c\u0001\u0000\u0000\u0000"+
		"D\u015f\u0001\u0000\u0000\u0000F\u0161\u0001\u0000\u0000\u0000H\u0163"+
		"\u0001\u0000\u0000\u0000J\u0165\u0001\u0000\u0000\u0000LN\u0003\u0002"+
		"\u0001\u0000ML\u0001\u0000\u0000\u0000NQ\u0001\u0000\u0000\u0000OM\u0001"+
		"\u0000\u0000\u0000OP\u0001\u0000\u0000\u0000PR\u0001\u0000\u0000\u0000"+
		"QO\u0001\u0000\u0000\u0000RS\u0005\u0000\u0000\u0001S\u0001\u0001\u0000"+
		"\u0000\u0000TY\u0003\u0004\u0002\u0000UY\u0003\b\u0004\u0000VY\u0003\n"+
		"\u0005\u0000WY\u0003\f\u0006\u0000XT\u0001\u0000\u0000\u0000XU\u0001\u0000"+
		"\u0000\u0000XV\u0001\u0000\u0000\u0000XW\u0001\u0000\u0000\u0000Y\u0003"+
		"\u0001\u0000\u0000\u0000Z\\\u0003\u0006\u0003\u0000[Z\u0001\u0000\u0000"+
		"\u0000[\\\u0001\u0000\u0000\u0000\\]\u0001\u0000\u0000\u0000]^\u0005\u0001"+
		"\u0000\u0000^_\u0005,\u0000\u0000_`\u0003\u000e\u0007\u0000`\u0005\u0001"+
		"\u0000\u0000\u0000ab\u0007\u0000\u0000\u0000b\u0007\u0001\u0000\u0000"+
		"\u0000ce\u0003\u0006\u0003\u0000dc\u0001\u0000\u0000\u0000de\u0001\u0000"+
		"\u0000\u0000ef\u0001\u0000\u0000\u0000fg\u0005\u0002\u0000\u0000gh\u0005"+
		",\u0000\u0000hi\u0003\u000e\u0007\u0000i\t\u0001\u0000\u0000\u0000jl\u0003"+
		"\u0006\u0003\u0000kj\u0001\u0000\u0000\u0000kl\u0001\u0000\u0000\u0000"+
		"lm\u0001\u0000\u0000\u0000mn\u0005\u0003\u0000\u0000no\u0005,\u0000\u0000"+
		"op\u0003\u0010\b\u0000p\u000b\u0001\u0000\u0000\u0000qs\u0003\u0006\u0003"+
		"\u0000rq\u0001\u0000\u0000\u0000rs\u0001\u0000\u0000\u0000st\u0001\u0000"+
		"\u0000\u0000tu\u0005\u0004\u0000\u0000uv\u0005,\u0000\u0000vw\u0003\u0016"+
		"\u000b\u0000wx\u0003\u001a\r\u0000xy\u0005\u000f\u0000\u0000yz\u0003\u001c"+
		"\u000e\u0000z\r\u0001\u0000\u0000\u0000{\u007f\u0005\u000b\u0000\u0000"+
		"|~\u0003\u0012\t\u0000}|\u0001\u0000\u0000\u0000~\u0081\u0001\u0000\u0000"+
		"\u0000\u007f}\u0001\u0000\u0000\u0000\u007f\u0080\u0001\u0000\u0000\u0000"+
		"\u0080\u0082\u0001\u0000\u0000\u0000\u0081\u007f\u0001\u0000\u0000\u0000"+
		"\u0082\u0083\u0005\f\u0000\u0000\u0083\u000f\u0001\u0000\u0000\u0000\u0084"+
		"\u0088\u0005\u000b\u0000\u0000\u0085\u0087\u0003\u0014\n\u0000\u0086\u0085"+
		"\u0001\u0000\u0000\u0000\u0087\u008a\u0001\u0000\u0000\u0000\u0088\u0086"+
		"\u0001\u0000\u0000\u0000\u0088\u0089\u0001\u0000\u0000\u0000\u0089\u008b"+
		"\u0001\u0000\u0000\u0000\u008a\u0088\u0001\u0000\u0000\u0000\u008b\u008c"+
		"\u0005\f\u0000\u0000\u008c\u0011\u0001\u0000\u0000\u0000\u008d\u0096\u0003"+
		"\u0004\u0002\u0000\u008e\u0096\u0003\f\u0006\u0000\u008f\u0090\u0003<"+
		"\u001e\u0000\u0090\u0091\u0005\u0010\u0000\u0000\u0091\u0096\u0001\u0000"+
		"\u0000\u0000\u0092\u0093\u0003:\u001d\u0000\u0093\u0094\u0005\u0010\u0000"+
		"\u0000\u0094\u0096\u0001\u0000\u0000\u0000\u0095\u008d\u0001\u0000\u0000"+
		"\u0000\u0095\u008e\u0001\u0000\u0000\u0000\u0095\u008f\u0001\u0000\u0000"+
		"\u0000\u0095\u0092\u0001\u0000\u0000\u0000\u0096\u0013\u0001\u0000\u0000"+
		"\u0000\u0097\u009a\u0003\n\u0005\u0000\u0098\u009a\u0003\f\u0006\u0000"+
		"\u0099\u0097\u0001\u0000\u0000\u0000\u0099\u0098\u0001\u0000\u0000\u0000"+
		"\u009a\u0015\u0001\u0000\u0000\u0000\u009b\u009c\u0005\t\u0000\u0000\u009c"+
		"\u00a1\u0003\u0018\f\u0000\u009d\u009e\u0005\r\u0000\u0000\u009e\u00a0"+
		"\u0003\u0018\f\u0000\u009f\u009d\u0001\u0000\u0000\u0000\u00a0\u00a3\u0001"+
		"\u0000\u0000\u0000\u00a1\u009f\u0001\u0000\u0000\u0000\u00a1\u00a2\u0001"+
		"\u0000\u0000\u0000\u00a2\u00a4\u0001\u0000\u0000\u0000\u00a3\u00a1\u0001"+
		"\u0000\u0000\u0000\u00a4\u00a5\u0005\n\u0000\u0000\u00a5\u00a9\u0001\u0000"+
		"\u0000\u0000\u00a6\u00a7\u0005\t\u0000\u0000\u00a7\u00a9\u0005\n\u0000"+
		"\u0000\u00a8\u009b\u0001\u0000\u0000\u0000\u00a8\u00a6\u0001\u0000\u0000"+
		"\u0000\u00a9\u0017\u0001\u0000\u0000\u0000\u00aa\u00ab\u0005,\u0000\u0000"+
		"\u00ab\u00ac\u0005\u0011\u0000\u0000\u00ac\u00ad\u0005,\u0000\u0000\u00ad"+
		"\u0019\u0001\u0000\u0000\u0000\u00ae\u00af\u0005\u0011\u0000\u0000\u00af"+
		"\u00b2\u0005,\u0000\u0000\u00b0\u00b2\u0001\u0000\u0000\u0000\u00b1\u00ae"+
		"\u0001\u0000\u0000\u0000\u00b1\u00b0\u0001\u0000\u0000\u0000\u00b2\u001b"+
		"\u0001\u0000\u0000\u0000\u00b3\u00b7\u0005\u000b\u0000\u0000\u00b4\u00b6"+
		"\u0003\"\u0011\u0000\u00b5\u00b4\u0001\u0000\u0000\u0000\u00b6\u00b9\u0001"+
		"\u0000\u0000\u0000\u00b7\u00b5\u0001\u0000\u0000\u0000\u00b7\u00b8\u0001"+
		"\u0000\u0000\u0000\u00b8\u00bb\u0001\u0000\u0000\u0000\u00b9\u00b7\u0001"+
		"\u0000\u0000\u0000\u00ba\u00bc\u0003 \u0010\u0000\u00bb\u00ba\u0001\u0000"+
		"\u0000\u0000\u00bb\u00bc\u0001\u0000\u0000\u0000\u00bc\u00bd\u0001\u0000"+
		"\u0000\u0000\u00bd\u00be\u0005\f\u0000\u0000\u00be\u001d\u0001\u0000\u0000"+
		"\u0000\u00bf\u00c3\u0005\u000b\u0000\u0000\u00c0\u00c2\u0003\"\u0011\u0000"+
		"\u00c1\u00c0\u0001\u0000\u0000\u0000\u00c2\u00c5\u0001\u0000\u0000\u0000"+
		"\u00c3\u00c1\u0001\u0000\u0000\u0000\u00c3\u00c4\u0001\u0000\u0000\u0000"+
		"\u00c4\u00c6\u0001\u0000\u0000\u0000\u00c5\u00c3\u0001\u0000\u0000\u0000"+
		"\u00c6\u00c7\u0005\f\u0000\u0000\u00c7\u001f\u0001\u0000\u0000\u0000\u00c8"+
		"\u00c9\u0005\u0016\u0000\u0000\u00c9\u00ca\u0003.\u0017\u0000\u00ca!\u0001"+
		"\u0000\u0000\u0000\u00cb\u00d1\u0003\u001e\u000f\u0000\u00cc\u00d1\u0003"+
		"$\u0012\u0000\u00cd\u00d1\u0003(\u0014\u0000\u00ce\u00d1\u0003*\u0015"+
		"\u0000\u00cf\u00d1\u0003.\u0017\u0000\u00d0\u00cb\u0001\u0000\u0000\u0000"+
		"\u00d0\u00cc\u0001\u0000\u0000\u0000\u00d0\u00cd\u0001\u0000\u0000\u0000"+
		"\u00d0\u00ce\u0001\u0000\u0000\u0000\u00d0\u00cf\u0001\u0000\u0000\u0000"+
		"\u00d1#\u0001\u0000\u0000\u0000\u00d2\u00d3\u0005\u0012\u0000\u0000\u00d3"+
		"\u00d4\u0005\t\u0000\u0000\u00d4\u00d5\u00030\u0018\u0000\u00d5\u00d8"+
		"\u0005\n\u0000\u0000\u00d6\u00d9\u0003\u001e\u000f\u0000\u00d7\u00d9\u0003"+
		"\"\u0011\u0000\u00d8\u00d6\u0001\u0000\u0000\u0000\u00d8\u00d7\u0001\u0000"+
		"\u0000\u0000\u00d9\u00db\u0001\u0000\u0000\u0000\u00da\u00dc\u0003&\u0013"+
		"\u0000\u00db\u00da\u0001\u0000\u0000\u0000\u00db\u00dc\u0001\u0000\u0000"+
		"\u0000\u00dc%\u0001\u0000\u0000\u0000\u00dd\u00e0\u0005\u0013\u0000\u0000"+
		"\u00de\u00e1\u0003\u001e\u000f\u0000\u00df\u00e1\u0003\"\u0011\u0000\u00e0"+
		"\u00de\u0001\u0000\u0000\u0000\u00e0\u00df\u0001\u0000\u0000\u0000\u00e1"+
		"\'\u0001\u0000\u0000\u0000\u00e2\u00e3\u0005\u0014\u0000\u0000\u00e3\u00e4"+
		"\u0005\t\u0000\u0000\u00e4\u00e5\u00030\u0018\u0000\u00e5\u00e6\u0005"+
		"\n\u0000\u0000\u00e6\u00e7\u0003\u001e\u000f\u0000\u00e7)\u0001\u0000"+
		"\u0000\u0000\u00e8\u00e9\u0005\u0015\u0000\u0000\u00e9\u00ec\u0005\t\u0000"+
		"\u0000\u00ea\u00ed\u00030\u0018\u0000\u00eb\u00ed\u0003,\u0016\u0000\u00ec"+
		"\u00ea\u0001\u0000\u0000\u0000\u00ec\u00eb\u0001\u0000\u0000\u0000\u00ed"+
		"\u00ee\u0001\u0000\u0000\u0000\u00ee\u00ef\u0005\n\u0000\u0000\u00ef\u00f0"+
		"\u0003\u001e\u000f\u0000\u00f0+\u0001\u0000\u0000\u0000\u00f1\u00f2\u0005"+
		",\u0000\u0000\u00f2\u00f5\u0005\u0019\u0000\u0000\u00f3\u00f6\u00032\u0019"+
		"\u0000\u00f4\u00f6\u0003>\u001f\u0000\u00f5\u00f3\u0001\u0000\u0000\u0000"+
		"\u00f5\u00f4\u0001\u0000\u0000\u0000\u00f6-\u0001\u0000\u0000\u0000\u00f7"+
		"\u00f8\u00032\u0019\u0000\u00f8\u00f9\u0005\u0010\u0000\u0000\u00f9/\u0001"+
		"\u0000\u0000\u0000\u00fa\u00fb\u00032\u0019\u0000\u00fb\u00fc\u0003D\""+
		"\u0000\u00fc\u00fd\u00032\u0019\u0000\u00fd\u0106\u0001\u0000\u0000\u0000"+
		"\u00fe\u00ff\u0003F#\u0000\u00ff\u0100\u00032\u0019\u0000\u0100\u0106"+
		"\u0001\u0000\u0000\u0000\u0101\u0102\u0005\t\u0000\u0000\u0102\u0103\u0003"+
		"2\u0019\u0000\u0103\u0104\u0005\n\u0000\u0000\u0104\u0106\u0001\u0000"+
		"\u0000\u0000\u0105\u00fa\u0001\u0000\u0000\u0000\u0105\u00fe\u0001\u0000"+
		"\u0000\u0000\u0105\u0101\u0001\u0000\u0000\u0000\u01061\u0001\u0000\u0000"+
		"\u0000\u0107\u010e\u0003J%\u0000\u0108\u010e\u0005,\u0000\u0000\u0109"+
		"\u010e\u00034\u001a\u0000\u010a\u010e\u00036\u001b\u0000\u010b\u010e\u0003"+
		"<\u001e\u0000\u010c\u010e\u0003:\u001d\u0000\u010d\u0107\u0001\u0000\u0000"+
		"\u0000\u010d\u0108\u0001\u0000\u0000\u0000\u010d\u0109\u0001\u0000\u0000"+
		"\u0000\u010d\u010a\u0001\u0000\u0000\u0000\u010d\u010b\u0001\u0000\u0000"+
		"\u0000\u010d\u010c\u0001\u0000\u0000\u0000\u010e3\u0001\u0000\u0000\u0000"+
		"\u010f\u0110\u0005,\u0000\u0000\u0110\u0111\u00038\u001c\u0000\u01115"+
		"\u0001\u0000\u0000\u0000\u0112\u0113\u0005,\u0000\u0000\u0113\u0114\u0005"+
		"\u000e\u0000\u0000\u0114\u0116\u0005,\u0000\u0000\u0115\u0117\u00038\u001c"+
		"\u0000\u0116\u0115\u0001\u0000\u0000\u0000\u0116\u0117\u0001\u0000\u0000"+
		"\u0000\u01177\u0001\u0000\u0000\u0000\u0118\u0121\u0005\t\u0000\u0000"+
		"\u0119\u011e\u00032\u0019\u0000\u011a\u011b\u0005\r\u0000\u0000\u011b"+
		"\u011d\u00032\u0019\u0000\u011c\u011a\u0001\u0000\u0000\u0000\u011d\u0120"+
		"\u0001\u0000\u0000\u0000\u011e\u011c\u0001\u0000\u0000\u0000\u011e\u011f"+
		"\u0001\u0000\u0000\u0000\u011f\u0122\u0001\u0000\u0000\u0000\u0120\u011e"+
		"\u0001\u0000\u0000\u0000\u0121\u0119\u0001\u0000\u0000\u0000\u0121\u0122"+
		"\u0001\u0000\u0000\u0000\u0122\u0123\u0001\u0000\u0000\u0000\u0123\u0124"+
		"\u0005\n\u0000\u0000\u01249\u0001\u0000\u0000\u0000\u0125\u0129\u0005"+
		"\u0017\u0000\u0000\u0126\u0129\u0005\u0018\u0000\u0000\u0127\u0129\u0001"+
		"\u0000\u0000\u0000\u0128\u0125\u0001\u0000\u0000\u0000\u0128\u0126\u0001"+
		"\u0000\u0000\u0000\u0128\u0127\u0001\u0000\u0000\u0000\u0129\u012a\u0001"+
		"\u0000\u0000\u0000\u012a\u012b\u0005,\u0000\u0000\u012b;\u0001\u0000\u0000"+
		"\u0000\u012c\u0130\u0005\u0017\u0000\u0000\u012d\u0130\u0005\u0018\u0000"+
		"\u0000\u012e\u0130\u0001\u0000\u0000\u0000\u012f\u012c\u0001\u0000\u0000"+
		"\u0000\u012f\u012d\u0001\u0000\u0000\u0000\u012f\u012e\u0001\u0000\u0000"+
		"\u0000\u0130\u0131\u0001\u0000\u0000\u0000\u0131\u0132\u0005,\u0000\u0000"+
		"\u0132\u0136\u0005\u000f\u0000\u0000\u0133\u0137\u0003@ \u0000\u0134\u0137"+
		"\u0003B!\u0000\u0135\u0137\u0003>\u001f\u0000\u0136\u0133\u0001\u0000"+
		"\u0000\u0000\u0136\u0134\u0001\u0000\u0000\u0000\u0136\u0135\u0001\u0000"+
		"\u0000\u0000\u0137=\u0001\u0000\u0000\u0000\u0138\u0139\u0005(\u0000\u0000"+
		"\u0139\u014a\u0005\t\u0000\u0000\u013a\u013e\u0003J%\u0000\u013b\u013e"+
		"\u0003B!\u0000\u013c\u013e\u00034\u001a\u0000\u013d\u013a\u0001\u0000"+
		"\u0000\u0000\u013d\u013b\u0001\u0000\u0000\u0000\u013d\u013c\u0001\u0000"+
		"\u0000\u0000\u013e\u0147\u0001\u0000\u0000\u0000\u013f\u0143\u0005\r\u0000"+
		"\u0000\u0140\u0144\u0003J%\u0000\u0141\u0144\u0003B!\u0000\u0142\u0144"+
		"\u00034\u001a\u0000\u0143\u0140\u0001\u0000\u0000\u0000\u0143\u0141\u0001"+
		"\u0000\u0000\u0000\u0143\u0142\u0001\u0000\u0000\u0000\u0144\u0146\u0001"+
		"\u0000\u0000\u0000\u0145\u013f\u0001\u0000\u0000\u0000\u0146\u0149\u0001"+
		"\u0000\u0000\u0000\u0147\u0145\u0001\u0000\u0000\u0000\u0147\u0148\u0001"+
		"\u0000\u0000\u0000\u0148\u014b\u0001\u0000\u0000\u0000\u0149\u0147\u0001"+
		"\u0000\u0000\u0000\u014a\u013d\u0001\u0000\u0000\u0000\u014a\u014b\u0001"+
		"\u0000\u0000\u0000\u014b\u014c\u0001\u0000\u0000\u0000\u014c\u014d\u0005"+
		"\n\u0000\u0000\u014d?\u0001\u0000\u0000\u0000\u014e\u0151\u0005,\u0000"+
		"\u0000\u014f\u0151\u0003J%\u0000\u0150\u014e\u0001\u0000\u0000\u0000\u0150"+
		"\u014f\u0001\u0000\u0000\u0000\u0151\u0159\u0001\u0000\u0000\u0000\u0152"+
		"\u0155\u0003H$\u0000\u0153\u0156\u0005,\u0000\u0000\u0154\u0156\u0003"+
		"J%\u0000\u0155\u0153\u0001\u0000\u0000\u0000\u0155\u0154\u0001\u0000\u0000"+
		"\u0000\u0156\u0158\u0001\u0000\u0000\u0000\u0157\u0152\u0001\u0000\u0000"+
		"\u0000\u0158\u015b\u0001\u0000\u0000\u0000\u0159\u0157\u0001\u0000\u0000"+
		"\u0000\u0159\u015a\u0001\u0000\u0000\u0000\u015aA\u0001\u0000\u0000\u0000"+
		"\u015b\u0159\u0001\u0000\u0000\u0000\u015c\u015d\u0005\u0005\u0000\u0000"+
		"\u015d\u015e\u00034\u001a\u0000\u015eC\u0001\u0000\u0000\u0000\u015f\u0160"+
		"\u0007\u0001\u0000\u0000\u0160E\u0001\u0000\u0000\u0000\u0161\u0162\u0007"+
		"\u0002\u0000\u0000\u0162G\u0001\u0000\u0000\u0000\u0163\u0164\u0007\u0003"+
		"\u0000\u0000\u0164I\u0001\u0000\u0000\u0000\u0165\u0166\u0007\u0004\u0000"+
		"\u0000\u0166K\u0001\u0000\u0000\u0000%OX[dkr\u007f\u0088\u0095\u0099\u00a1"+
		"\u00a8\u00b1\u00b7\u00bb\u00c3\u00d0\u00d8\u00db\u00e0\u00ec\u00f5\u0105"+
		"\u010d\u0116\u011e\u0121\u0128\u012f\u0136\u013d\u0143\u0147\u014a\u0150"+
		"\u0155\u0159";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}