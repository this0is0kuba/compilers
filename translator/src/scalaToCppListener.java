// Generated from /Users/reczkok/Kompilatory/compilers/scalaToCpp.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link scalaToCppParser}.
 */
public interface scalaToCppListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link scalaToCppParser#plure}.
	 * @param ctx the parse tree
	 */
	void enterPlure(scalaToCppParser.PlureContext ctx);
	/**
	 * Exit a parse tree produced by {@link scalaToCppParser#plure}.
	 * @param ctx the parse tree
	 */
	void exitPlure(scalaToCppParser.PlureContext ctx);
	/**
	 * Enter a parse tree produced by {@link scalaToCppParser#topLevelDef}.
	 * @param ctx the parse tree
	 */
	void enterTopLevelDef(scalaToCppParser.TopLevelDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link scalaToCppParser#topLevelDef}.
	 * @param ctx the parse tree
	 */
	void exitTopLevelDef(scalaToCppParser.TopLevelDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link scalaToCppParser#classDef}.
	 * @param ctx the parse tree
	 */
	void enterClassDef(scalaToCppParser.ClassDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link scalaToCppParser#classDef}.
	 * @param ctx the parse tree
	 */
	void exitClassDef(scalaToCppParser.ClassDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link scalaToCppParser#accessModifier}.
	 * @param ctx the parse tree
	 */
	void enterAccessModifier(scalaToCppParser.AccessModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link scalaToCppParser#accessModifier}.
	 * @param ctx the parse tree
	 */
	void exitAccessModifier(scalaToCppParser.AccessModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link scalaToCppParser#objectDef}.
	 * @param ctx the parse tree
	 */
	void enterObjectDef(scalaToCppParser.ObjectDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link scalaToCppParser#objectDef}.
	 * @param ctx the parse tree
	 */
	void exitObjectDef(scalaToCppParser.ObjectDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link scalaToCppParser#traitDef}.
	 * @param ctx the parse tree
	 */
	void enterTraitDef(scalaToCppParser.TraitDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link scalaToCppParser#traitDef}.
	 * @param ctx the parse tree
	 */
	void exitTraitDef(scalaToCppParser.TraitDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link scalaToCppParser#def}.
	 * @param ctx the parse tree
	 */
	void enterDef(scalaToCppParser.DefContext ctx);
	/**
	 * Exit a parse tree produced by {@link scalaToCppParser#def}.
	 * @param ctx the parse tree
	 */
	void exitDef(scalaToCppParser.DefContext ctx);
	/**
	 * Enter a parse tree produced by {@link scalaToCppParser#classBody}.
	 * @param ctx the parse tree
	 */
	void enterClassBody(scalaToCppParser.ClassBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link scalaToCppParser#classBody}.
	 * @param ctx the parse tree
	 */
	void exitClassBody(scalaToCppParser.ClassBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link scalaToCppParser#traitBody}.
	 * @param ctx the parse tree
	 */
	void enterTraitBody(scalaToCppParser.TraitBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link scalaToCppParser#traitBody}.
	 * @param ctx the parse tree
	 */
	void exitTraitBody(scalaToCppParser.TraitBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link scalaToCppParser#classMember}.
	 * @param ctx the parse tree
	 */
	void enterClassMember(scalaToCppParser.ClassMemberContext ctx);
	/**
	 * Exit a parse tree produced by {@link scalaToCppParser#classMember}.
	 * @param ctx the parse tree
	 */
	void exitClassMember(scalaToCppParser.ClassMemberContext ctx);
	/**
	 * Enter a parse tree produced by {@link scalaToCppParser#traitMember}.
	 * @param ctx the parse tree
	 */
	void enterTraitMember(scalaToCppParser.TraitMemberContext ctx);
	/**
	 * Exit a parse tree produced by {@link scalaToCppParser#traitMember}.
	 * @param ctx the parse tree
	 */
	void exitTraitMember(scalaToCppParser.TraitMemberContext ctx);
	/**
	 * Enter a parse tree produced by {@link scalaToCppParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterList(scalaToCppParser.ParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link scalaToCppParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterList(scalaToCppParser.ParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link scalaToCppParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(scalaToCppParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link scalaToCppParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(scalaToCppParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link scalaToCppParser#returnType}.
	 * @param ctx the parse tree
	 */
	void enterReturnType(scalaToCppParser.ReturnTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link scalaToCppParser#returnType}.
	 * @param ctx the parse tree
	 */
	void exitReturnType(scalaToCppParser.ReturnTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link scalaToCppParser#defBlock}.
	 * @param ctx the parse tree
	 */
	void enterDefBlock(scalaToCppParser.DefBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link scalaToCppParser#defBlock}.
	 * @param ctx the parse tree
	 */
	void exitDefBlock(scalaToCppParser.DefBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link scalaToCppParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(scalaToCppParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link scalaToCppParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(scalaToCppParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link scalaToCppParser#returnVal}.
	 * @param ctx the parse tree
	 */
	void enterReturnVal(scalaToCppParser.ReturnValContext ctx);
	/**
	 * Exit a parse tree produced by {@link scalaToCppParser#returnVal}.
	 * @param ctx the parse tree
	 */
	void exitReturnVal(scalaToCppParser.ReturnValContext ctx);
	/**
	 * Enter a parse tree produced by {@link scalaToCppParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(scalaToCppParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link scalaToCppParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(scalaToCppParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link scalaToCppParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(scalaToCppParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link scalaToCppParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(scalaToCppParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link scalaToCppParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(scalaToCppParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link scalaToCppParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(scalaToCppParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link scalaToCppParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(scalaToCppParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link scalaToCppParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(scalaToCppParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link scalaToCppParser#enumeration}.
	 * @param ctx the parse tree
	 */
	void enterEnumeration(scalaToCppParser.EnumerationContext ctx);
	/**
	 * Exit a parse tree produced by {@link scalaToCppParser#enumeration}.
	 * @param ctx the parse tree
	 */
	void exitEnumeration(scalaToCppParser.EnumerationContext ctx);
	/**
	 * Enter a parse tree produced by {@link scalaToCppParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void enterExpressionStatement(scalaToCppParser.ExpressionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link scalaToCppParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void exitExpressionStatement(scalaToCppParser.ExpressionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link scalaToCppParser#logicExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogicExpression(scalaToCppParser.LogicExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link scalaToCppParser#logicExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogicExpression(scalaToCppParser.LogicExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link scalaToCppParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(scalaToCppParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link scalaToCppParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(scalaToCppParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link scalaToCppParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(scalaToCppParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link scalaToCppParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(scalaToCppParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link scalaToCppParser#objectMethodAccess}.
	 * @param ctx the parse tree
	 */
	void enterObjectMethodAccess(scalaToCppParser.ObjectMethodAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link scalaToCppParser#objectMethodAccess}.
	 * @param ctx the parse tree
	 */
	void exitObjectMethodAccess(scalaToCppParser.ObjectMethodAccessContext ctx);
	/**
	 * Enter a parse tree produced by {@link scalaToCppParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentList(scalaToCppParser.ArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link scalaToCppParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentList(scalaToCppParser.ArgumentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link scalaToCppParser#definition}.
	 * @param ctx the parse tree
	 */
	void enterDefinition(scalaToCppParser.DefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link scalaToCppParser#definition}.
	 * @param ctx the parse tree
	 */
	void exitDefinition(scalaToCppParser.DefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link scalaToCppParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(scalaToCppParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link scalaToCppParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(scalaToCppParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link scalaToCppParser#listliteral}.
	 * @param ctx the parse tree
	 */
	void enterListliteral(scalaToCppParser.ListliteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link scalaToCppParser#listliteral}.
	 * @param ctx the parse tree
	 */
	void exitListliteral(scalaToCppParser.ListliteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link scalaToCppParser#operation}.
	 * @param ctx the parse tree
	 */
	void enterOperation(scalaToCppParser.OperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link scalaToCppParser#operation}.
	 * @param ctx the parse tree
	 */
	void exitOperation(scalaToCppParser.OperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link scalaToCppParser#creation}.
	 * @param ctx the parse tree
	 */
	void enterCreation(scalaToCppParser.CreationContext ctx);
	/**
	 * Exit a parse tree produced by {@link scalaToCppParser#creation}.
	 * @param ctx the parse tree
	 */
	void exitCreation(scalaToCppParser.CreationContext ctx);
	/**
	 * Enter a parse tree produced by {@link scalaToCppParser#binaryOperator}.
	 * @param ctx the parse tree
	 */
	void enterBinaryOperator(scalaToCppParser.BinaryOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link scalaToCppParser#binaryOperator}.
	 * @param ctx the parse tree
	 */
	void exitBinaryOperator(scalaToCppParser.BinaryOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link scalaToCppParser#unaryOperator}.
	 * @param ctx the parse tree
	 */
	void enterUnaryOperator(scalaToCppParser.UnaryOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link scalaToCppParser#unaryOperator}.
	 * @param ctx the parse tree
	 */
	void exitUnaryOperator(scalaToCppParser.UnaryOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link scalaToCppParser#simpleOperator}.
	 * @param ctx the parse tree
	 */
	void enterSimpleOperator(scalaToCppParser.SimpleOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link scalaToCppParser#simpleOperator}.
	 * @param ctx the parse tree
	 */
	void exitSimpleOperator(scalaToCppParser.SimpleOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link scalaToCppParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(scalaToCppParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link scalaToCppParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(scalaToCppParser.LiteralContext ctx);
}