grammar ArrayInit; //必须和文件名一致

init : '{'value(','value)'}';

value : init
      | INT
      ;

INT : ('a'..'z')+; //..是范围运算符
WS  : (' '|'\t'|'\n'|'\r')+ -> skip; //空白符号丢弃