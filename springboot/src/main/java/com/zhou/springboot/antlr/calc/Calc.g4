grammar Calc;
import LexerRule; //词法规则

//语法规则
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

//词法，用大写表示
MUL: '*';
DIV: '/';
ADD: '+';
SUB: '-';