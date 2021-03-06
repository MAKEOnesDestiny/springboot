grammar DOT;

/**

EXAMPLE:

digraph G {
    rankdir=LR;
    main [shape=box];
    main -> f -> g;
    f -> f [style=dotted];  //f是递归的
    f -> h;
}

**/

graph: STRICT?(GRAPH|DIGRAPH) id? '{' stmt_list '}' ;
stmt_list: (stmt ';'?)*;
stmt: node_stmt
    | edge_stmt
    | attr_stmt
    | id '=' id
    | subgraph
    ;

attr_stmt: (GRAPH|NODE|EDGE) attr_list;
attr_list: ('[' a_list? ']')+;
a_list: (id ('=' id)? ','?)+;

edge_stmt: (node_id | subgraph) edgeRHS attr_list? ;
edgeRHS: (edgeop (node_id | subgraph))+;
edgeop: '->' | '--';
node_stmt: node_id attr_list?;
node_id: id port?;
port: ':' id (':' id)?;


subgraph: (SUBGRAPH id?)? '{' stmt_list '}'; //子图
id: ID
  | STRING
  | HTML_STRING
  | NUMBER
  ;



STRICT:[Ss][Tt][Rr][Ii][Cc][Tt];
GRAPH:[Gg][Rr][Aa][Pp][Hh];
DIGRAPH:[Dd][Ii][Gg][Rr][Aa][Pp][Hh];
NODE:[Nn][Oo][Dd][Ee];
EDGE:[Ee][Dd][Gg][Ee];
SUBGRAPH:[Ss][Uu][Bb][Gg][Rr][Aa][Pp][Hh];

//标识符规则
ID: LETTER(LETTER|DIGIT)*;
fragment LETTER:[a-zA-Z\u0080-\u00FF];
NUMBER: '-'?('.'DIGIT+ | DIGIT+('.'DIGIT*)?);
DIGIT: [0-9];
STRING: '"' ('\\"'|.)*? '"';

HTML_STRING:'<' (TAG|~[<>])* '>';
fragment TAG:'<' .*? '>';

PREPROC: '#' .*? '\n' -> skip;
WS: [ \r\n\t]+ -> skip;




