grammar R;

prog: (expr_or_assign (';'|NL) | NL)* EOF;

expr_or_assign: expr ('<-' | '=' | '<<-') expr_or_assign  //尾递归
              | expr
              ;

expr: expr '[[' sublist ']' ']'
    | expr '[' expr ']'
    | expr '^'<assoc=right> expr
    | expr ':' expr
    | expr ('*'|'/') expr
    | expr ('+'|'-') expr
    | expr ('>'|'>='|'<'|'<='|'=='|'!=') expr
    | expr ('->' | '->>' | ':=') expr
    | 'function' '(' formlist? ')' expr
    | expr '(' sublist ')'

    |'{' exprlist '}'
    | 'if' '(' expr ')' expr
    | 'if' '(' expr ')' expr 'else' expr
    | 'for' '(' ID 'in' expr ')' expr
    | 'while' '(' expr ')' expr
    | 'repeat' expr
    | '?' expr  //获取expr的帮助信息，通常是字符串或者标识符
    | 'next'
    | 'break'
    | NUMBER
    | ID
    ;

formlist: form (',' form)*;
form: ID
    | ID '=' expr
    | '...'
    ;
sublist: sub (',' sub)*;
sub: expr
   | ID '='
   | ID '=' expr
   | STRING '='
   | STRING '=' expr
   | 'NULL' '='
   | 'NULL' '=' expr
   | '...'
   |
   ;


exprlist: expr_or_assign ((';'|NL) expr_or_assign)*
        |  //允许空体
        ;

NUMBER: '-'?('.'DIGIT+ | DIGIT+('.'DIGIT*)?);
ID: '.' (LETTER|'_'|'.') (LETTER|DIGIT|'_'|'.')*
  | LETTER (LETTER|DIGIT|'_'|'.')*
  ;
fragment LETTER:[a-zA-Z];
fragment DIGIT:[0-9];
NL: '\r'?'\n';
WS:[ \t\r\n]+ -> skip;

/**

x <- seq(1,10,.5)
y <- 1:5
z <- c(9,6,2,10,-4)
y + z
z[z<5]
mean(z)
zero <- function() {return (0)}
zero()

**/


/**

expr: '{' exprlist '}'
    | 'if' '(' expr ')' expr
    | 'if' '(' expr ')' expr 'else' expr
    | 'for' '(' ID 'in' expr ')' expr
    | 'while' '(' expr ')' expr
    | 'repeat' expr
    | '?' expr  //获取expr的帮助信息，通常是字符串或者标识符
    | 'next'
    | 'break'
    ;

**/