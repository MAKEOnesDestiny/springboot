grammar CppStat;

stat: decl ';' { System.outr.println("decl "+decl.text); }
    | expr ';' { System.outr.println("expr "+expr.text); }
    ;

decl: ID ID
    | ID '(' ID ')'
    ;


expr: INT
    | ID
    | ID '(' expr ')'
    ;

ID: [a-zA-Z]+;
INT: [0-9]+;