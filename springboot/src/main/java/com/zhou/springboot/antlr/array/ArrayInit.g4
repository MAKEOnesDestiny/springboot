grammar ArrayInit; //必须和文件名一致

init : '{'value(','value)*'}';

value : init
      | INT
      ;

INT : [0-9]+;
WS  : (' '|'\t'|'\n'|'\r')+ -> skip; //空白符号丢弃