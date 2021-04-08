<!DOCTYPE HTML>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>API在线文档</title>
  <link href="http://localhost:8000/demo/api.css" rel="stylesheet" type="text/css" />
  <script language="javascript" src="http://localhost:8000/demo/jquery.min.js"></script>
  <script language="javascript" src="http://localhost:8000/demo/jquery.dimensions.js"></script>
</head>
<body>
<div class="tit">
  <div id="titcont">
    API在线文档<span class="sma"> DP版权所有，侵权必究！</span>
  </div>
</div>
<div id="cont">

  <div class='fun'>
    <div class='lineface'>一、接口总述 </div>
    <span>#.<em>全局参数说明</em></span>
    <span class='ri'></span>
    <div class='says'>
      全局基本参数：目前本文档中涉及的所有接口都必需带上2个基本参数,用户ID和签名验证参数<br>
      更多内容...<br>
      更多内容...<br>
    </div>
  </div>

  <div class='fun'>
    <div class='lineface'>二、接口</div>
    <a name="接口列表"></a>

    <#list wss as ws>
      <span class='le'> ${ws.menuDoc?if_exists} - ${ws.apiDoc?if_exists} </span>
      <span class='le'>URL:<em> ${ws.urlPath} </em></span>
      <span class='le'>请求类型:${ws.consumeType?if_exists}</span>

      <!--json-->
      <#if ws.getShowType()='param_json'>
        <#list ws.inputParams as ps>
  <div>
    <pre>
      ${ps.example?if_exists}
    </pre>
  </div>
        </#list>
      </#if>

      <!--表单-->
      <#if ws.getShowType()='param_form'>
          <div>
            <table border="1">
                <tr>
                  <th>参数名称</th>
                  <th>是否必填</th>
                  <th>类型</th>
                  <th>示例</th>
                  <th>说明</th>
                </tr>
              <#list ws.inputParams as ps>
                <tr>
                  <th>${ps.name}</th>
                  <th>${ps.getRequired()?string('是','否')}</th>
                  <th>${ps.type.getSimpleName()}</th>
                  <th>${ps.example}</th>
                  <th>${ps.meaning}</th>
                </tr>
              </#list>
            </table>
          </div>
      </#if>
    </#list>

  </div>


</div>
<div id="foot">
  DP-数据工厂<br>
</div>


<!--浮动接口导航栏-->
<div id="floatMenu">
  <ul class="menu"></ul>
</div>
<script language="javascript">
  var name = "#floatMenu";
  var menuYloc = null;
  $(document).ready(function(){
    $(".le > em").each(function(index, element){
      $(".menu").append(" <li><a href='#"+ $(this).text() +"'>"+ $(this).text()+"</a></li>");
    });
    menuYloc = parseInt($(name).css("top").substring(0,$(name).css("top").indexOf("px")))
    $(window).scroll(function () {
      offset = menuYloc+$(document).scrollTop()+"px";
      $(name).animate({top:offset},{duration:500,queue:false});
    });
  });
</script>
</body>
</html>
