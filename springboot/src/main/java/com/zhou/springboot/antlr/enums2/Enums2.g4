grammar Enums2;

@lexer::members {
  public static boolean java5;
}

prog: ( stat
    | enumDecl
    )+
    ;

stat: ID '=' expr ';' {System.out.println($ID.text+"="+$expr.text);}
    ;
expr: ID
    | INT
    ;

enumDecl: 'enum' t=ID '{' ID (',' ID)* '}'
          { System.out.println("enum "+$t.text); }
        ;

ID: [a-zA-Z]+ {java5}?;
INT: [0-9]+;
WS: [ \t\r\n]+ -> skip;