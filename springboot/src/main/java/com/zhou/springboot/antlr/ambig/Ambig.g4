grammar Ambig;

stat: ID '(' ')'
    | expr
    ;

expr: ID '(' ')'
    | INT
    ;

ID: [a-zA-Z]+;
INT: [0-9]+;
WS: [ \t\r\n]+ -> skip;