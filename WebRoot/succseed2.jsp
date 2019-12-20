<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'succseed2.jsp' starting page</title>
    
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
  </head>
  
  <body>
    
      <div class="zhezhao" id='zhezhao'>
		<div class="tankuang">
			<div id="header">
				<div id="header_jia"><h3>结账成功</h3><h3>可点击上方按钮进行查看</h3></div>
				<div id="h"><input type="button" value="确定"  onclick="hidder()"/></div>
			</div>
		</div>
		</div>
		
		<script type="text/javascript">
			
			
			function hidder(){
				document.getElementById('zhezhao').style.display="none";
				window.location.href ='shopping_car_servlet';
			}
			
		</script>
  </body>
</html>
