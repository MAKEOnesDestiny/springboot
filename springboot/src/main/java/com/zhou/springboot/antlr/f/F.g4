grammar F;

group
    : '[' expr ']'
    | '(' expr ')'
    ;

expr: atom '^' INT;
atom: ID
    | INT
    ;

ID: [a-zA-Z]+;
INT: [0-9]+;
WS: [ \t\r\n]+ -> skip;
