## Tokens

| Token Name       | Token Value                  |
|------------------|------------------------------|
| CLASS            | 'class'                      |
| OBJECT           | 'object'                     |
| TRAIT            | 'trait'                      |
| DEF              | 'def'                        |
| NEW              | 'new'                        |
| LPAREN           | '('                          |
| RPAREN           | ')'                          |
| LBRACE           | '{'                          |
| RBRACE           | '}'                          |
| COMMA            | ','                          |
| DOT              | '.'                          |
| EQ               | '='                          |
| SEMICOLON        | ';'                          |
| COLON            | ':'                          |
| IF               | 'if'                         |
| ELSE             | 'else'                       |
| WHILE            | 'while'                      |
| FOR              | 'for'                        |
| RETURN           | 'return'                     |
| VAR              | 'var'                        |
| VAL              | 'val'                        |
| ARROW            | '<-'                         |
| EQEQ             | '=='                         |
| NEQ              | '!='                         |
| LT               | '<'                          |
| GT               | '>'                          |
| LTEQ             | '<='                         |
| GTEQ             | '>='                         |
| PRO              | '%'                          |
| AND              | '&&'                         |
| OR               | '||'                         |
| PLUS             | '+'                          |
| MINUS            | '-'                          |
| ASTERISK         | '*'                          |
| SLASH            | '/'                          |
| BANG             | '!'                          |
| BOOLEAN_LITERAL  | 'true' or 'false'            |
| INT_LITERAL      | Any series of digits (0-9)   |
| STRING_LITERAL   | Any series between " "        |
| IDENTIFIER       | Alphabetic followed by alphanumeric characters |
| WS               | Whitespaces                  |

## Productions


| Production Name  | Production Value                                                                                                        |
|------------------|-------------------------------------------------------------------------------------------------------------------------|
| Plure            | `topLevelDef* EOF`                                                                                                      |
| TopLevelDef      | `classDef` &#124; `objectDef` &#124; `traitDef` &#124; `def`                                                            |
| ClassDef         | `CLASS IDENTIFIER classBody`                                                                                            |
| ObjectDef        | `OBJECT IDENTIFIER classBody`                                                                                           |
| TraitDef         | `TRAIT IDENTIFIER traitBody`                                                                                            |
| Def              | `DEF IDENTIFIER parameterList returnType EQ defBlock`                                                                   |
| ClassBody        | `LBRACE classMember* RBRACE`                                                                                            |
| TraitBody        | `LBRACE traitMember* RBRACE`                                                                                            |
| ClassMember      | `classDef` &#124; `def` &#124; `assignment SEMICOLON` &#124; `definition SEMICOLON`                                     |
| TraitMember      | `traitDef` &#124; `def`                                                                                                 |
| ParameterList    | `LPAREN parameter (COMMA parameter)* RPAREN` &#124; `LPAREN RPAREN`                                                     |
| Parameter        | `IDENTIFIER COLON IDENTIFIER`                                                                                           |
| ReturnType       | `COLON IDENTIFIER` &#124; *epsilon*                                                                                     |
| DefBlock         | `LBRACE statement* returnVal? RBRACE`                                                                                   |
| Block            | `LBRACE statement* RBRACE`                                                                                              |
| ReturnVal        | `RETURN expressionStatement`                                                                                            |
| Statement        | `block` &#124; `ifStatement` &#124; `whileStatement` &#124; `forStatement` &#124; `expressionStatement`                 |
| IfStatement      | `IF LPAREN logicExpression RPAREN (block &#124; statement) (ELSE (block &#124; statement))?`                            |
| WhileStatement   | `WHILE LPAREN logicExpression RPAREN block`                                                                             |
| ForStatement     | `FOR LPAREN logicExpression RPAREN block`                                                                               |
| Enumeration      | `IDENTIFIER ARROW expression`                                                                                           |
| ExpressionStatement | `expression SEMICOLON`                                                                                                  |
| LogicExpression  | `expression binaryOperator expression` &#124; `unaryOperator expression` &#124; `LPAREN expression RPAREN`              |
| Expression       | `literal` &#124; `IDENTIFIER` &#124; `functionCall` &#124; `objectMethodAccess` &#124; `assignment` &#124; `definition` |
| FunctionCall     | `IDENTIFIER argumentList`                                                                                               |
| ObjectMethodAccess | `IDENTIFIER DOT IDENTIFIER argumentList?`                                                                               |
| ArgumentList     | `LPAREN (expression (COMMA expression)*)? RPAREN`                                                                       |
| Definition       | `(VAR &#124; VAL) IDENTIFIER`                                                                                           |
| Assignment       | `(VAR &#124; VAL) IDENTIFIER EQ (operation &#124; creation)`                                                            |
| Operation        | `(IDENTIFIER &#124; literal) (simpleOperator (IDENTIFIER &#124; literal))*`                                             |
| Creation         | `NEW functionCall`                                                                                                      |
| BinaryOperator   | `EQEQ` &#124; `NEQ` &#124; `LT` &#124; `GT` &#124; `LTEQ` &#124; `GTEQ` &#124; `AND` &#124; `OR` &#124; `PRO`           |
| UnaryOperator    | `PLUS` &#124; `MINUS` &#124; `BANG`                                                                                     |
| SimpleOperator   | `PLUS` &#124; `MINUS` &#124; `ASTERISK` &#124; `SLASH`                                                                  |
| Literal          | `BOOLEAN_LITERAL` &#124; `INT_LITERAL` &#124; `STRING_LITERAL`                                                          |
