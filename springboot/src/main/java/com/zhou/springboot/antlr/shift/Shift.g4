grammar Shift;

prog: expr+ ;
expr: 'int' ID '=' INT ';';

ID: [a-zA-Z]+;
INT: [0-9]+;

WS:[ \t\r\n]+ -> channel(1);
SL_COMM: '//' .*? '\n' -> channel(2);


/*

int n = 0; //定义一个计数器
int i = 9;

*/