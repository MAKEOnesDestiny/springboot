grammar Expr;

@header{
import java.util.*;
}

@parser::members {
  Map<String,Integer> memory = new HashMap<String,Integer>();

  int eval(int left,int op,int right){
    switch(op){
      case MUL : return left*right;
      case DIV : return left/right;
      case ADD : return left+right;
      case SUB : return left-right;
    }
    return 0;
  }
}

prog: stat+
    ;

//stat要么是复制语句，要么是计算表达式
stat: expr NEWLINE  {System.out.println($expr.v);}
    | ID '=' expr NEWLINE {memory.put($ID.text, $expr.v);}
    | NEWLINE
    ;

expr  returns [int v]
    : a=expr op=('*'|'/') b=expr {$v = eval($a.v, $op.type, $b.v);}
    | a=expr op=('+'|'-') b=expr {$v = eval($a.v, $op.type, $b.v);}
    | INT                        {$v = $INT.int;}
    | ID
      {
      String id = $ID.text;
      $v = memory.containsKey(id)? memory.get(id) : 0;
      }
    | '(' expr ')'    {$v = $expr.v;}
    ;

INT: [0-9]+;
ID: [a-zA-Z]+;
//词法，用大写表示
MUL: '*';
DIV: '/';
ADD: '+';
SUB: '-';
NEWLINE: '\r'?'\n';
WS: [\t] -> skip;




