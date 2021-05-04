grammar JSON;

//BNF不支持类似 (...)* 的循环，因此用尾递归可以对循环进行模拟

json: object
    | array
    ;

object: '{' pair (',' pair)* '}'
       | '{' '}'
       ;

pair: STRING ':' value;

array: '[' value (',' value)* ']'
      | '[' ']'  //空数组
      ;

value: STRING //字符串匹配
     | NUMBER //数字
     | object //递归调用
     | array
     | 'true'
     | 'false'
     | 'null'
     ;


//下面是词法
STRING: '"' (ESC | ~["\\])* '"';  //  '//'是因为需要匹配unicode规则
fragment ESC : '\\' (["\\/bfnrt] | UNICODE);   //fragment有点类似私有函数
fragment UNICODE : 'u' HEX HEX HEX HEX;
fragment HEX : [0-9a-fA-F];

NUMBER: '-'? INT '.' INT EXP?   // 1.35 1.35E-9
      | '-'? INT EXP            // 1e10 -3e4
      | '-'? INT
      ;
fragment INT: '0'|[1-9][0-9]*;  //除0之外的数字不允许以0开始
fragment EXP: [Ee][+\-]? INT;   // \- 是对 - 的转义

WS: [ \t\n\r]+ -> skip; //在任意两个词法符号之间，可以存在任意多的空白字符




