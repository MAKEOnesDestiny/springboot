grammar Channel;

@lexer::members{
public static final int WHITESPACE = 1;
public static final int COMMENTS = 2;
}

prog: stat
    ;

stat: expr
    ;

expr: ID '(' ')';


ID: [a-zA-Z]+;
WS: [ \t\r\n]+ -> channel(1);
COM: '//' .*? '\n' -> channel(2);

/**

//测试
f()

**/
