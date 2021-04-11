grammar LexerRule;

ID: [a-zA-Z]*;     //遵循BNF范式
INT: [0-9]+;
NEWLINE: '\r'?'\n';
WS: [\t] -> skip; //丢弃空白字符