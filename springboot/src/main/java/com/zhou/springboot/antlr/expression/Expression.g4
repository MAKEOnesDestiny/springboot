grammar Expression; //必须和文件名一致

//大写代表词法
//小写代表语法

prog: stat+; //支持多个表达式
stat: expr NEWLINE
    | ID '=' expr NEWLINE  //单引号代表简单文本，如果不带说明有特殊含义
    | NEWLINE
    ;

expr: expr('*'|'/') expr  //+ - * / 会作为token的一部分
    | expr('+'|'-') expr
    | INT
    | ID
    | '('expr')'
    ;

ID: [a-zA-Z]*;     //遵循BNF范式
INT: [0-9]+;
NEWLINE: '\r'?'\n';
WS: [\t] -> skip; //丢弃空白字符
