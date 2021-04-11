grammar Calc;
import LexerRule;

prog: stat+;
stat: expr NEWLINE          # printExpr  //标签
    | ID '=' expr NEWLINE   # assign
    | NEWLINE               # blank
    ;
expr: expr op=('*'|'/') expr  # MulDiv   //op是关键字？？
    | expr op=('+'|'-') expr  # AddSub
    | INT                     # int
    | ID                      # id
    | '(' expr ')'            # parens
    ;

MUL: '*';
DIV: '/';
ADD: '+';
SUB: '-';