grammar CSVN;

@header{
import java.util.*;
}

prog: file;

file
locals [int i=0]
    : hdr ( rows+=row[$hdr.text.split(",")] {$i++;} )+
      {
      System.out.println($i+" rows");
      for (RowContext r : $rows){
        System.out.println("row token interval: "+r.getSourceInterval());
      }
      }
    ;

hdr: row[null] {System.out.println("header: '"+$text.trim()+"'");}
   ;

//方括号扩起来的内容相当于参数
row[String[] columns] returns [Map<String,String> values]
locals [int col=0]
@init{
  $values=new HashMap<String,String>();
}
@after{
  if($values!=null && $values.size()>0){
    System.out.println("values = "+$values);
  }
}
: field
  {
  if($columns!=null){
    $values.put($columns[$col++].trim(),$field.text.trim());
  }
  }
  (',' field
    {
    if($columns!=null){
      $values.put($columns[$col++].trim(),$field.text.trim());
    }
    }
  )* '\r'?'\n';


field: TEXT
      | STRING
      |
      ;

TEXT: ~[,\r\n"]+;
STRING: '"'('""'|~'"')*'"';



/**
name,age,sex
kobe,42,male
james,38,male
gigi,16,female

**/