grammar PropertyFile;

@members{
  void startFile() {}
  void finishFile() {}
  void defineProperty(Token name,Token value) {}
}
file: {startFile();} prop+ {finishFile();} ;
prop: ID '=' STRING '\n' {defineProperty($ID,$STRING)};

ID: [a-z]+;
STRING: '"' .*? '"'; //非贪婪匹配
WS:[ \t\n\r] -> skip;