grammar Demo;

//parser
//程序和语句
prog:stat
;
stat:expr|NEWLINE
;

//表达式
expr:multExpr(('+'|'-')multExpr)*
;
multExpr:atom(('*'|'/')atom)*
;
atom:'('expr')'
  |INT
  |ID
;

//记号定义
ID:('a'..'z'|'A'..'Z')+;
INT:'0'..'9'+;
NEWLINE:'\r'?'\n';
WS:(' '|'\t'|'\n'|'\r')+ -> skip;   //空格选择忽略

//options {language=?;} 来改变目标语言
