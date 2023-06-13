// Generated from C:/Users/asiaw/Desktop/GitHub/compilers\scalaToCpp.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link scalaToCppParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface scalaToCppVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link scalaToCppParser#plure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlure(scalaToCppParser.PlureContext ctx);
	/**
	 * Visit a parse tree produced by {@link scalaToCppParser#topLevelDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTopLevelDef(scalaToCppParser.TopLevelDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link scalaToCppParser#classDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDef(scalaToCppParser.ClassDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link scalaToCppParser#accessModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccessModifier(scalaToCppParser.AccessModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link scalaToCppParser#objectDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectDef(scalaToCppParser.ObjectDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link scalaToCppParser#traitDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTraitDef(scalaToCppParser.TraitDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link scalaToCppParser#def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDef(scalaToCppParser.DefContext ctx);
	/**
	 * Visit a parse tree produced by {@link scalaToCppParser#classBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBody(scalaToCppParser.ClassBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link scalaToCppParser#traitBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTraitBody(scalaToCppParser.TraitBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link scalaToCppParser#classMember}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassMember(scalaToCppParser.ClassMemberContext ctx);
	/**
	 * Visit a parse tree produced by {@link scalaToCppParser#traitMember}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTraitMember(scalaToCppParser.TraitMemberContext ctx);
	/**
	 * Visit a parse tree produced by {@link scalaToCppParser#parameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterList(scalaToCppParser.ParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link scalaToCppParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(scalaToCppParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link scalaToCppParser#returnType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnType(scalaToCppParser.ReturnTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link scalaToCppParser#defBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefBlock(scalaToCppParser.DefBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link scalaToCppParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(scalaToCppParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link scalaToCppParser#returnVal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnVal(scalaToCppParser.ReturnValContext ctx);
	/**
	 * Visit a parse tree produced by {@link scalaToCppParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(scalaToCppParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link scalaToCppParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(scalaToCppParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link scalaToCppParser#elseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseStatement(scalaToCppParser.ElseStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link scalaToCppParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(scalaToCppParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link scalaToCppParser#forStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(scalaToCppParser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link scalaToCppParser#enumeration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumeration(scalaToCppParser.EnumerationContext ctx);
	/**
	 * Visit a parse tree produced by {@link scalaToCppParser#expressionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionStatement(scalaToCppParser.ExpressionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link scalaToCppParser#printStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStatement(scalaToCppParser.PrintStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link scalaToCppParser#printList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintList(scalaToCppParser.PrintListContext ctx);
	/**
	 * Visit a parse tree produced by {@link scalaToCppParser#printListElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintListElement(scalaToCppParser.PrintListElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link scalaToCppParser#logicExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicExpression(scalaToCppParser.LogicExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link scalaToCppParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(scalaToCppParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link scalaToCppParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(scalaToCppParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link scalaToCppParser#objectMethodAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectMethodAccess(scalaToCppParser.ObjectMethodAccessContext ctx);
	/**
	 * Visit a parse tree produced by {@link scalaToCppParser#argumentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentList(scalaToCppParser.ArgumentListContext ctx);
	/**
	 * Visit a parse tree produced by {@link scalaToCppParser#argumentListElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentListElement(scalaToCppParser.ArgumentListElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link scalaToCppParser#definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefinition(scalaToCppParser.DefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link scalaToCppParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(scalaToCppParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link scalaToCppParser#listliteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListliteral(scalaToCppParser.ListliteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link scalaToCppParser#listLiteralElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListLiteralElement(scalaToCppParser.ListLiteralElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link scalaToCppParser#operation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperation(scalaToCppParser.OperationContext ctx);
	/**
	 * Visit a parse tree produced by {@link scalaToCppParser#creation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreation(scalaToCppParser.CreationContext ctx);
	/**
	 * Visit a parse tree produced by {@link scalaToCppParser#binaryOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryOperator(scalaToCppParser.BinaryOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link scalaToCppParser#unaryOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryOperator(scalaToCppParser.UnaryOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link scalaToCppParser#simpleOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleOperator(scalaToCppParser.SimpleOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link scalaToCppParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(scalaToCppParser.LiteralContext ctx);
}