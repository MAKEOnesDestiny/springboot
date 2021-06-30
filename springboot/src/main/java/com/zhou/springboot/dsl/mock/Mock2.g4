grammar Mock2;

prog: stat+
    ;
stat: var '=''>' expr DELIMITER
    ;
var: singleVar ('.'singleVar)*
   ;
singleVar: ID '[' ('*'| (INTEGER_VALUE (','INTEGER_VALUE)* ) )? ']'  #array
         | ID         #obj
         ;

expr: func'(' params? ')'
    ;
func: FUNC
    ;

params: param (','param)*
      ;

param: number   #num
     | STRING   #str
     | BOOLEAN  #bool
     | 'null'   #nil
     ;

number : DECIMAL_VALUE  #decimalLiteral
       | INTEGER_VALUE  #integerLiteral
       ;

INTEGER_VALUE: '-'?DIGIT+;
DECIMAL_VALUE: '-'? DIGIT+ '.' DIGIT+
       ; //123  12.0  12.11
fragment DIGIT: [0-9];

STRING: '"' ~["\\]* '"'
      ;


BOOLEAN: 'true'
       | 'false'
       ;
FUNC: '_'[a-zA-Z_]+;
ID: [a-zA-Z]+;
INT: [0-9]+;
DELIMITER: ';';

WS: [ \t\r\n]+ -> channel(HIDDEN);
