<%@ page language="java" import="java.util.*,java_bean.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>详细界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/bootstrap-theme.css">
    <script src="//cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
     <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
  </head>
   <style type="text/css">
  	.nav > li > a:hover{
  		background-color:#CCF;
  		color: #000 ;
  	}
  </style>
  <body>
	<div class="dao">
    	<div class="container">
        	<div class="row">
               	
                <div class="col-lg-1"></div>
                <div  class="col-lg-4">
                    <h4 class="abc"><a  href="index.jsp">切换账号</a>|<a href="reg.jsp">注册</a>|<a href="scan_servlet">主页</a></h4>
                
                </div>
                <div class="col-lg-2"></div>
                 <div class="col-lg-2">
                	<% String name =(String)session.getAttribute("Name");
                	String username = (String)session.getAttribute("UserName");%>
                	<h4 >欢迎您，<%=name %></h4>
                </div>
                <div class="col-lg-3">
	                <h4 class="abc">
	                	 <a  href="shopping_car_servlet">
				          <span  class="glyphicon glyphicon-shopping-cart"></span>查看购物车
				        </a>|
				         <a  href="Order?Username=<%=username%>">
				          <span  class="glyphicon glyphicon-folder-close""></span>查看订单
				        </a>
				    </h4>
                </div>
            </div>
    	</div>
    
    </div>
    <div class="container">
    <div class="row">
    	<div class="col-lg-12">
        	<img width=100% src="nanclotherImg/beijing2_1.jpg" />
        
        </div>
    
    </div>
	<div class="row">
    	<div class="col-lg-12">
        	<ul class="nav nav-pills nav-justified">
                <li><a href="scan_servlet">全 部</a></li>
                <li ><a href="chun?dataBase=people_information&tableName=clothe_information">春装</a></li>
                <li ><a href="xia?dataBase=people_information&tableName=clothe_information">夏装</a></li>
                <li><a href="qiu?dataBase=people_information&tableName=clothe_information">秋装</a></li>
                <li><a href="dong?dataBase=people_information&tableName=clothe_information">冬装</a></li>
                <li><a href="gu?dataBase=people_information&tableName=clothe_information">古装汉服</a></li>
            </ul>
        </div>
    </div>
      <%   ArrayList< clothe_bean> xiangxi=(ArrayList)session.getAttribute("xiangxi");
     %>
    <div class="row" style="margin-top:20px;">
    	<div class="col-lg-1"></div>
    	<div class="col-lg-4" style="margin-top:20px;">
        		<img width="360px" height="500px;" src="<%= xiangxi.get(0).getClotheImg() %>" />
        
        </div>
       
        <div class=" col-lg-6">
        	<h4><b><%=xiangxi.get(0).getClotheName() %></b></h4>
        	<div class="cu">
            	<div class="row">
                	<div class="col-lg-2">
                    	<p>价格：</p>
                    </div>
                    <div class="col-lg-10">
                    	<p>¥ 1280.00</p>
                    </div>
                </div>
                <div class="row">
                	<div class="col-lg-2">
                    	<p style="margin-top:16px;">促销价：</p>
                    </div>
                    <div class="col-lg-10">
                    	<b><p class="cu1">¥ <%=xiangxi.get(0).getClothePrice() %></p></b>
                    </div>
                </div>
            </div>
            <form id ="form"  name="form" method=post>
            <div style="padding:10px;">
            	<h4>尺码：   <input type="text" name="chima"   style="width:40px;"/></h4>
            	<p>&nbsp;</p>
            	<p>&nbsp;</p>
            	<p>&nbsp;</p>
            	
          <h4>数量：   <input type="text" name="number" style="width:40px;" /></h4>
            
            </div>
            <div>
            	<input  class="jiaru" id = "gou" type="button" value="加入购物车" />
               
            </div>
             
            </form>
        </div>
    	<div class="col-lg-1"></div>
    
    </div>
    </div>
    
     
   </div>
    <script>
 $(function(){
    $("#gou").click(function(){
        var newUrl = 'gou?dataBase=people_information&tableName=clothe_information&ClotheId=<%=xiangxi.get(0).getClotheId()%>';//设置新提交地址
        $("#form").attr('action',newUrl);    //通过jquery为action属性赋值
        $("#form").submit();    //提交ID为myform的表单
    })
     $("#ti").click(function(){
        var newUrl = 'tijiao?dataBase=people_information&tableName=clothe_information&ClotheId=<%=xiangxi.get(0).getClotheId()%>';    //设置新提交地址
        $("#form").attr('action',newUrl);    //通过jquery为action属性赋值
        $("#form").submit();    //提交ID为myform的表单
    })
})
</script>
</body>
</html>
