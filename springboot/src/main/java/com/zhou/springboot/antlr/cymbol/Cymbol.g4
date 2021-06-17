grammar Cymbol;

file: (varDecl|functionDecl)+
    ;

varDecl: TYPE ID ('=' expr)? STAT_END;  //变量声明
functionDecl: TYPE ID '(' formalParameters? ')' block;  //函数声明
formalParameters: formalParameter (',' formalParameter)*;
formalParameter: TYPE ID;

block: '{' stat* '}';
stat: block  //左递归
    | varDecl
    | 'if' expr 'then' stat ('else' stat)?
    | 'return' expr STAT_END
    | expr '=' expr STAT_END
    | expr STAT_END
    ;

expr: ID '(' exprList? ')' # Call //类似f(1),f(1,2)的函数调用
    | expr '[' expr ']' # Index
    | '-' expr # Negate
    | '!' expr # Not
    | expr ('*') expr # Mult   //分开是为了优先级？
    | expr ('+'|'-') expr # AddSub
    | expr '==' expr # Equal
    | ID  # Var
    | INT # Int
    | '(' expr ')' # Parenss
    ;
exprList: expr (',' expr)*; // 1,2,3


//词法
TYPE: ('int'|'float'|'void');
ID: LETTER (LETTER|DIGIT)*;
fragment LETTER:[a-zA-Z];
fragment DIGIT: '0'|[1-9][0-9]*;  //fragment一定要写,数字开头不能为0
STAT_END: ';';
INT: '0'|[1-9]([0-9])*;

WS: [ \t\r\n]+ -> skip;
//注释忽略
SL_COMMENT
          : '//' .*? '\n' -> skip
          ;

/**

  int x;
  int y;
  void a()
  {
    int x;
    x = 1;   // x是当前作用域的x，并不是全局作用域的x
    y = 2;   // y在当前作用域不存在，但在全局作用域存在
    { int y = x; }
  }

  void b(int z)
  { }

**/

/**

int f(int x, float y) {
    g();   //函数只要有定义即可
    i = 3;
    g = 4;
    return x + y;
}

void g(){
    int x = 0;
    float y;
    y = 9;
    f();
    z();
    y();
    x = f;
}

**/

/**

int main() { fact();  a(); }

float fact(int n){
   print(n);

   if(n==0) then return 1;
   return n * fact(n-1);
}

void a() { int x = b(); if false then { c(); d(); } }
void b() { c(); }
void c() { b(); }
void d() { }
void e() { }

**/