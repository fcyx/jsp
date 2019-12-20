<%@ page language="java" import="java.util.*,java_bean.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>查看订单</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="css/bootstrap.css" rel="stylesheet">
	<script src="js/jquery.min.js"></script>
	<script src="js/carts.js"></script>
	<link rel="stylesheet" href="css/reset.css">
	<link rel="stylesheet" href="css/carts.css">
     <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
  </head>
  <style type="text/css">
		.ddd{
			padding-top:10px; 
			 width: 100%; 
			 height:35px; 
			 color:#fff;
			 background-color:dimgray;
			}
    	.din{
			float:left;
			 font-size:18px; 
			 margin-left:25px;
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
  <section class="cartMain">
	<div class="cartMain_hd">
		<ul class="order_lists cartTop" style="font-size:20px; font:'Arial Black', Gadget, sans-serif;">
			<li class="list_chk">
				<!--所有商品全选-->
			</li>
			<li class="list_con">商品信息</li>
			<li class="list_info">商品操作</li>
			<li class="list_price">单价</li>
			<li class="list_amount">数量</li>
			<li class="list_sum">实付金额</li>
			<li class="list_op">交易操作</li>
		</ul>
	</div>
	
	<div class="cartBox">
		<%ArrayList<order_bean> order=(ArrayList)request.getAttribute("order"); 
		 if(order!=null){
      for(int i=0;i<order.size();i++){%>
		<div class="order_content" style="margin-top:10px;">
        		<div class="ddd">		
            		<div  class="din"><%=order.get(i).getOrderDate() %></div>
                    <div style="float:right;font-size:18px;margin-left:25px;">订单号:<%=order.get(i).getOrderId() %></div>
            	</div>
			<ul class="order_lists" style="margin-top:6px;">
				<li class="list_chk">
					<input type="checkbox" id="checkbox_2" class="son_check">
					<label for="checkbox_2"></label>
				</li>
				<li class="list_con">
					<div class="list_img"><a href="javascript:;"><img src="<%=order.get(i).getClotheImg() %>" alt=""></a></div>
					<div class="list_text"><a href="javascript:;"><%=order.get(i).getClotheName() %></a></div>
				</li>
				<li class="list_info">
					<p>规格：默认</p>
					<p>尺寸：<%=order.get(i).getClotherSize() %></p>
				</li>
				<li class="list_price">
					<p class="price">￥<%=order.get(i).getClotheprice() %></p>
				</li>
				<li class="list_amount">
					<div class="amount_box">
						
						<%=order.get(i).getClotheNumber() %>
						
					</div>
				</li>
				<li class="list_sum">
					<p class="sum_price">￥<%=order.get(i).getTotalMoney() %></p>
				</li>
				<li class="list_op">
					<p class="del"><a  href="delete_user?ID=<%=order.get(i).getOrderId() %>&table=order_informatio&Username=<%=username %>" class="delBtn">确认收货</a></p>
				</li>
			</ul>
		</div>
        <%}} %>
        
	</div>
</section>
<section class="model_bg"></section>
<section class="my_model">
	<p class="title">删除宝贝<span class="closeModel">X</span></p>
	<p>您确认要删除该宝贝吗？</p>
	<div class="opBtn"><a href="javascript:;" class="dialog-sure">确定</a><a href="javascript:;" class="dialog-close">关闭</a></div>
</section>


</div>
  </body>
</html>
