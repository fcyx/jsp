<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%request.setCharacterEncoding("utf-8");%> 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'reg.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
 <style type="text/css">
		*{
			padding: 0;margin: 0;

		}
		.footer{
			width: 2300px;
			height: 40px;
			position: absolute;
			bottom: 0px;
		}
		.all{
			border:1px solid lightblue;
			width: 335px;
			height: 700px;
			position: absolute;
			top: 136px;
			right: 341px;
		}
		.all .first .login,.all .first .pas{
			width:167px;
			height: 50px;
			text-align: center;
			line-height: 50px;
			display: block;
			float: left;
			background-color: lightblue;
			font-family: "微软雅黑";
			color: gray;
		}
		.all .second .number{
			width: 284px;
			height: 35px;
			margin-top:22px;
			margin-left: 17px;
		}
		.all .second .password{
			width: 284px;
			height: 35px;
			margin-top: 5px;
			margin-left: 17px;
		}
		all .second .ok{
			width: 284px;
			height: 40px;
			margin-top: 17px;
			margin-left: 17px;
			border: 0;
			background-color: cornflowerblue;
			font-size:larger;
			color: white;
			font-family: "微软雅黑";
		}
		.all .first{
			width: 335px;
			height:52px;
		}

		.all .second{
			width: 332px;
			height:610px;
		}
		.all .third{
			width: 222px;
			height:45px;
			line-height: 45px;
			padding-left: 110px;
		}

		.all .first .login:hover{
			color:black;
		}
		.all .first .pas{
			color: black;
		 }
		.all .second .bnext{
			width: 20px;
			height: 20px;
			margin-top: 10px;
			margin-left: 17px;
		}
		.all .second .tnext{
			display: block;
			width: 100px;
			height: 15px;
			margin-left: 45px;
			margin-top: -22px;
			font-size: small;

		}
		.all .third span{
			font-size:smaller;
			color: blue;
			font-family: "微软雅黑";
		}
	</style>
	<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>

<div class="all">
	<div class="first">
		<span class="login"><a href="index.jsp">账号密码登录</a></span>
		<span class="pas">快速注册账号</span>
	</div>
	<form action="reg?dataBase=people_information&tableName=reg" method=post>
	<div class="second">
		<input type="text" name="UserName"  placeholder="用户名" class="number"/>
		<br />
		<input type="password" name="PassWord"  placeholder="密码"  class="password">
		<input type="password"  name="PassWord1"  placeholder="确认密码"  class="password">
        <input type="text" name = "Name" placeholder="真实姓名"  class="password"/>
        <input type="text" name = "sex"  placeholder="性别"  class="password" />
        <input type="text" name = "address" placeholder="地址"  class="password" />        
        <input type="text" name = "Tel" placeholder="电话"  class="password" />
        <input type="text"name = "youzhen" placeholder="邮政"  class="password" />
        <input type="text" name = "post" placeholder="电子邮箱"  class="password" />
        <input type="text" name = "RegisterTIme" placeholder="注册时间"  class="password" />
        <input type="text" name = "hobby" placeholder="爱好"  class="password" />
        <input type="text" name = "BirthTime" placeholder="出生日期"  class="password" />
        
		<input type="checkbox" class="bnext"><span class="tnext">同意协议</span>
		<br/>
		<div class="col-lg-12">
			<input type="submit" value="注册"  class="ok btn btn-primary form-control" />
		</div>
	</div>
	</form>
	<div class="third">
		<span>注册协议</span>
		<span>意见反馈</span>
	</div>
</div>
<img width=100% height="100%" src="img/bj2.jpg">

</body>
</html>
