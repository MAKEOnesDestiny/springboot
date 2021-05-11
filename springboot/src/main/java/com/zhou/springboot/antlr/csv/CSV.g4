grammar CSV;

prog: file;

file: hdr row+;  //hdr必然会有，row可以有1个或多个

hdr: row;

row: field (','field)* '\r'?'\n';

field: TEXT       # text
      | STRING    # string
      |           # empty
      ;


TEXT: ~[,\r\n"]+;  //~代表直到运算符
STRING: '"' ('""'|~'"')* '"';   //两个双引号是对双引号的转义？

/**
name,age,sex
kobe,42,male
james,38,male
gigi,16,female

**/

