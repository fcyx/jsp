<%@ page language="java" import="java.util.*,java_bean.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>全部</title>
    
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
  <style type="text/css">
  	.nav > li > a:hover{
  		background-color:#CCF;
  		color: #000 ;
  		
  	}
  	.abcd {
        border: 3px solid darkgrey;
        height: min-content;
        width: 300px;
        margin-right: auto;
        margin-left: auto;
        margin-top: auto;
        border-radius: 50px;
        background-color: rgba(11, 90, 114, 0.959);
        margin-top: 10px;
        
    }

    .abcd>input {
        height: 50px;
        padding: 10px 10px 10px 10px;
        border-top-left-radius: 50px;
        border-bottom-left-radius: 50px;
        border: 0px;
    }
    .abcd>button {
        border: 0px;
        border-top-right-radius: 50px;
        border-bottom-right-radius: 50px;
        background-color: rgba(11, 90, 114, 0.959);
        width: 55px;
        height: 100%;
    }
    .abcd>button:hover{
        background-color: rgba(8, 66, 83, 0.959);
    }
    img:hover{
       filter:alpha(opacity=80);
        opacity: 0.8;
        -moz-opacity: 0.8;
    }
  </style>
  </head>
  
  <body >
   
 	<div class="dao">
    	<div class="container">
        	<div class="row">
                <div  class="col-lg-1">
                    <img width="50" height="40" style="margin-left:10px;" src="nanclotherImg/dao1_1.png">
                </div>
                <div  class="col-lg-4">
                    <h4 class="abc"><a  href="index.jsp">切换账号</a>|<a href="reg.jsp">注册</a>|<a href="scan_servlet">主页</a></h4>
                	
                </div>
                <div class="col-lg-2"></div>
                <div class="col-lg-2">
                	<% String name =(String)session.getAttribute("Name");
                	   String username = (String)session.getAttribute("UserName");
                	   if(name!=null){%>
                	<h4 >欢迎您，<%=name %></h4>
                	<%}else{ %>
                	<h4 >欢迎浏览，点击右方登录</h4><%} %>
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
	    	<div style=" padding-right:0px;" class="col-lg-8">
	        	<div id="myCarousel" class="carousel slide">
		<!-- 轮播（Carousel）指标 -->
	                <ol class="carousel-indicators">
	                    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
	                    <li data-target="#myCarousel" data-slide-to="1"></li>
	                    <li data-target="#myCarousel" data-slide-to="2"></li>
	                    <li data-target="#myCarousel" data-slide-to="3"></li>
	                </ol>   
	                <!-- 轮播（Carousel）项目 -->
	                <div class="carousel-inner">
	                    <div class="item active">
	                        <img src="nanclotherImg/nan1_2.jpg" alt="First slide">
	                    </div>
	                    <div class="item">
	                        <img src="nanclotherImg/nan1_1.jpg" alt="Second slide">
	                    </div>
	                    <div class="item">
	                        <img src="nanclotherImg/nan1_3.jpg" alt="Third slide">
	                    </div>
	                    <div class="item">
	                        <img src="nanclotherImg/nan1_4.jpg" alt="Third slide">
	                    </div>
	                </div>
	                <!-- 轮播（Carousel）导航 -->
	                <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
	                    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
	                    <span class="sr-only">Previous</span>
	                </a>
	                <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
	                    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
	                    <span class="sr-only">Next</span>
	                </a>
	            </div> 
	        </div><form action="queryServlet?&table=clothe_informati" method=post>
	        <div style=" padding: 0px;margin: 0px;" class="col-lg-4">
	        		<div >
				        <div class="abcd">
				        
				            <input style="" type="text" height="15px" placeholder="搜索.." name="goodsname" size="25">
				            <button type="submit" class="btn btn-info btn-lg">
				                <span class="glyphicon glyphicon-search"></span>
				            </button>
				        </div>
				    </div></form>
				    <div style=" margin-top: 20px;"> 
				    	<img width="183px;" height="75px" src="nanclotherImg/sos1.jpg">
				    	<img width="183px;" height="75px" src="nanclotherImg/sos2.jpg">
				    	<img width="183px;" height="76px" src="nanclotherImg/sos3.jpg">
				    	<img width="183px;" height="76px" src="nanclotherImg/sos4.jpg">
				    	
				    	
				    </div>
				    
	        </div>
	    
	    </div>
		<div class="row">
	    	<div   class="col-lg-12">
	        	<ul style="background-color: #CFF;" class="nav nav-pills nav-justified">
	                <li class="active"><a href="scan_servlet">全 部</a></li>
	                <li><a class="ayf" href="chun?dataBase=people_information&tableName=clothe_information">春装</a></li>
	                <li><a href="xia?dataBase=people_information&tableName=clothe_information">夏装</a></li>
	                <li><a href="qiu?dataBase=people_information&tableName=clothe_information">秋装</a></li>
	                <li><a href="dong?dataBase=people_information&tableName=clothe_information">冬装</a></li>
	                <li><a href="gu?dataBase=people_information&tableName=clothe_information">古装汉服</a></li>
	            </ul>
	        </div>
	    </div>  
	   	<div class="row">
	   	
	   	 <%   ArrayList<clothe_bean> clother=(ArrayList)request.getAttribute("clother");
	   if(clother!=null){
	      for(int i=0;i<clother.size();i++){%>
	    	<div class="col-lg-4" style="margin-top:20px;padding-left:30px;">
	        	<a href="xiangxi?id=<%=clother.get(i).getClotheId() %>&dataBase=people_information"><img width="320px;" height="420px;" src="<%=clother.get(i).getClotheImg() %>"> </a>
	        	<div style="height:50px;width: 320px"><h4><%= clother.get(i).getClotheName() %></h4></div>
	        	<div style="height:30px;"><h3 style="color:#900">￥<%= clother.get(i).getClothePrice() %></h3></div>
	        	<div style="height:50px;"><p><%=clother.get(i).getClothetype() %></p></div>
	        </div>
	        
	         <%}
	         }%>
	     </div>  
     </div>  
      
  </body>
</html>
