grammar Cymbol;

file: (varDecl|functionDecl)+
    ;

varDecl: TYPE ID '=' expr STAT_END;
functionDecl: TYPE ID '(' formalParameters? ')' block;
formalParameters: formalParameter (',' formalParameter)*;
formalParameter: TYPE ID;

block: '{' stat* '}';
stat: block  //左递归
    | varDecl STAT_END
    | 'if' expr 'then' stat ('else' stat)?
    | 'return' expr STAT_END
    | expr '=' expr STAT_END
    | expr STAT_END
    ;

expr: ID '(' exprList? ')'  //类似f(1),f(1,2)的函数调用
    | expr '[' expr ']'
    | '-' expr
    | '!' expr
    | expr ('*') expr  //分开是为了优先级？
    | expr ('+'|'-') expr
    | expr '==' expr
    | ID
    | INT
    | '(' expr ')'
    ;
exprList: expr (',' expr)*; // 1,2,3


TYPE: ('int'|'float'|'void');
ID: LETTER (LETTER|DIGIT)*;
fragment LETTER:[a-zA-Z];
fragment DIGIT: '0'|[1-9][0-9]*;  //fragment一定要写
STAT_END: ';';
INT: '0'|[1-9]([0-9])*;

WS: [ \t\r\n]+ -> skip;