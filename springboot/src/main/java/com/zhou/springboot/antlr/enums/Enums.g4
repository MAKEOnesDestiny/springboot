grammar Enums;

@parser::members {

  public static boolean java5;

}

prog: (stat    //代表java5之前的情况
      |enumDecl //代表java5之后的情况
      )+
      ;

stat: id '=' expr ';' {System.out.println($id.text+"="+$expr.text);}
    ;
expr : id
     | INT
     ;

enumDecl: {java5}? 'enum' name=id '{' id (','id)* '}'
          {System.out.println("enum "+$name.text);}
        ;
id: ID
  | {!java5}? 'enum'  //判定可以开启和关闭任何在通过判定后能被匹配的规则
  ;

ID: [a-zA-Z]+;
INT: [0-9]+;
WS: [ \t\r\n]+ -> skip;


/**

enum Sex { MALE,FEMALE }

**/
