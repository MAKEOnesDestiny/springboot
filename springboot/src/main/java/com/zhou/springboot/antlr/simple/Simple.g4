grammar Simple;

prog: classDef+;
classDef: 'class' ID '{' member* '}'
        { System.out.println("class "+$ID.text); }
        ;
member: 'int' ID ';'
        { System.out.println("var "+$ID.text);}
      | 'void' f=ID '('')' '{' expr* '}'
        { System.out.println("method: "+$f.text);}
      ;
expr: ID '(' ')' ';'
      { System.out.println("found expr: "+$ctx.getText());}
    ;


SPLIT: ';';
ID : [a-zA-Z]+;
INT: [0-9]+;
WS: [ \t\r\n]+ -> skip;

/**

class MyClass {

  int a;

  void b(){
      f();
  }
}

**/