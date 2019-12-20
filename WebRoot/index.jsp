<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
   <style type="text/css">

        * {
            padding: 0;
            margin: 0;

        }

        .footer {
            width: 2300px;
            height: 40px;
            position: absolute;
            bottom: 0px;
        }

        .all {
            border: 1px solid lightblue;
            width: 335px;
            height: 387px;
            position: absolute;
            top: 35%;
            left:28%;

        }

        .all .first .login, .all .first .pas {
            width: 167px;
            height: 50px;
            text-align: center;
            line-height: 50px;
            display: block;
            float: left;
            background-color: lightblue;
            font-family: "微软雅黑";
            color: gray;
        }

        .all .first .login {
            color: black;
        }

        .all .second .number {
            width: 284px;
            height: 35px;
            margin-top: 33px;
            margin-left: 17px;
        }

        .all .second .password {
            width: 284px;
            height: 35px;
            margin-top: 15px;
            margin-left: 17px;
        }

        all .second .ok {
            width: 284px;
            height: 40px;
            margin-top: 17px;
            margin-left: 17px;
            border: 0;
            background-color: cornflowerblue;
            font-size: larger;
            color: white;
            font-family: "微软雅黑";
        }

        .all .first {
            width: 335px;
            height: 52px;
        }

        .all .second {
            width: 332px;
            height: 290px;
        }

        .all .third {
            text-align: center;
            height: 45px;
            line-height: 45px;
        }

        .all .first .login:hover {
            color: black;
        }

        .all .first .pas:hover {
            color: black;
        }

        .all .second .bnext {
            width: 20px;
            height: 20px;
            margin-top: 10px;
            margin-left: 17px;
        }

        .all .second .tnext {
            display: block;
            width: 100px;
            height: 15px;
            margin-left: 45px;
            margin-top: -22px;
            font-size: small;

        }

        .all .third span {
            padding: 0px;

            font-size: smaller;
            color: blue;
            font-family: "微软雅黑";
        }
    </style>
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>

<div class="all">
    <div class="first">
        <span class="login"> 账号密码登录</span>
        <span class="pas"><a href="reg.jsp">快速注册账号</a></span>
    </div>
    <div class="second">
    <form action="login?dataBase=people_information&tableName=reg" method="post">
        <input type="text" name="UserName" placeholder="账号" class="number"/>
        <br/>
        <input type="password" name="PassWord" placeholder="密码" class="password"/>
        <input type="checkbox" class="bnext"><span class="tnext">下次自动登录</span>
        <br/>
        <div class="col-lg-12">
            <input type="submit" value="登录" class="ok btn btn-primary form-control"/>
        </div>
    </div>
    </form>
    <div class="third">
        <span class="col-lg-offset-2 col-lg-3">忘了密码？|</span>
        <span class="col-lg-3"><a href="reg.jsp">注册新账户|</a></span>
        <span class="col-lg-3">意见反馈</span>
    </div>
</div>

<img width=100% height="100%" src="img/bj1.jpg">

  </body>
  
</html>
