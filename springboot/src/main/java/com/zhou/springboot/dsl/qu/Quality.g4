grammar Quality;

prog: stat;
stat: expr  DELIMITER
    ;
expr: '!' expr             # Not
    | expr op=('*'|'/') expr  # MulDiv
    | expr op=('+'|'-') expr  # AddSub
    | expr op=('||'|'&') expr # AndOr
    | expr op=(GT|LT|GTE|LTE|EQ) expr  # Compare
    | '(' expr ')'         # Parens
    | DECIMAL              # Decimal
    | BOOLEAN              # Boolean
    | func                 # Function
    //| column               # TableColumn
    ;

func: ID '(' column ')'
    ;

column: (table=(ID|ID2)'.')? field=(ID|ID2)
     ;

DECIMAL: '-'? DIGIT+ '.' DIGIT+
       | '-'? DIGIT+
       ; //123  12.0  12.11
fragment DIGIT: [0-9];


BOOLEAN: 'true'
       | 'false'
       ;

ID: [a-zA-Z]+;
ID2: [a-zA-Z_]+;
WS: [ \t\r\n]+ -> channel(HIDDEN);
DELIMITER: ';';

MUL: '*';
DIV: '/';
ADD: '+';
SUB: '-';
AND: '&';
OR: '||';
GT: '>';
LT: '<';
GTE: '>=';
LTE: '<=';
EQ: '=';