grammar Mock;

prog: stat+;
stat: VAR '=''>' expr DELIMITER
    ;
expr: func'(' params? ')'
    ;
func: FUNC
    ;

params: param (','param)*;

param: DECIMAL
     | STRING
     | BOOLEAN
     | 'null'
     ;

DECIMAL: '-'? DIGIT+ '.' DIGIT+
       | '-'? DIGIT+
       ; //123  12.0  12.11
fragment DIGIT: [0-9];

STRING: '"' ~["\\]* '"'
      ;


BOOLEAN: 'true'
       | 'false'
       ;


VAR: ID ('.'ID)* ;   //VAR代表导航字符串, 例如 a.b.c[]
FUNC: '_'[a-zA-Z_]+;
ID: [\\[\]a-zA-Z]+;
WS: [ \t\r\n]+ -> channel(HIDDEN);
DELIMITER: ';';





/**
grammar Mock;

prog: stat+;
stat: VAR '=''>' expr DELIMITER
    ;
expr: ID '(' params? ')'
    ;

params: param (','param)*;

param: DECIMAL
     | STRING
     | BOOLEAN
     | 'null'
     ;

DECIMAL: '-'? DIGIT+ '.' DIGIT+
       | '-'? DIGIT+
       ; //123  12.0  12.11
fragment DIGIT: [0-9];

STRING: '"' ~["\\]* '"'
      ;


BOOLEAN: 'true'
       | 'false'
       ;


ID: [a-zA-Z_]+;
VAR: ID ('.'ID)* ;   //VAR代表导航字符串, 例如 a.b.c[]
//FUNC: [a-zA-Z_]+;
WS: [ \t\r\n]+ -> channel(HIDDEN);
DELIMITER: ';';

**/