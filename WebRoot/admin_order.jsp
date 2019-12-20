<%@ page language="java" import="java.util.*,java_bean.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
   <title>订单信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  <link rel="icon" type="image/png" sizes="16x16" href="assets/images/favicon.png">
    
    <!-- This page CSS -->
    <!-- chartist CSS -->
    <link href="assets/node_modules/morrisjs/morris.css" rel="stylesheet">
    <!--c3 plugins CSS -->
    <link href="assets/node_modules/c3-master/c3.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="dist/css/style.css" rel="stylesheet">
    <!-- Dashboard 1 Page CSS -->
    <link href="dist/css/pages/dashboard1.css" rel="stylesheet">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    
	<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
   .abcd {
        border: 3px solid darkgrey;
        height: min-content;
        width: 225px;
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
</style>
    
</head>

<body class="skin-default-dark fixed-layout">
    <!-- ============================================================== -->
    <!-- Preloader - style you can find in spinners.css -->
    <!-- ============================================================== -->
    <div class="preloader">
        <div class="loader">
            <div class="loader__figure"></div>
            <p class="loader__label"></p>
        </div>
    </div>
    <!-- ============================================================== -->
    <!-- Main wrapper - style you can find in pages.scss -->
    <!-- ============================================================== -->
    <div id="main-wrapper">
        <!-- ============================================================== -->
        <!-- Topbar header - style you can find in pages.scss -->
        <!-- ============================================================== -->
        <header class="topbar">
            <nav class="navbar top-navbar navbar-expand-md navbar-dark">
                <!-- ============================================================== -->
                <!-- Logo -->
                <!-- ============================================================== -->
                
                <!-- ============================================================== -->
                <!-- End Logo -->
                <!-- ============================================================== -->
                <div class="navbar-collapse">
                    <!-- ============================================================== -->
                    <!-- toggle and nav items -->
                    <!-- ============================================================== -->
                    <ul class="navbar-nav mr-auto">
                        <!-- This is  -->
                        <li class="nav-item hidden-sm-up"> <a class="nav-link nav-toggler waves-effect waves-light" href="javascript:void(0)"><i class="ti-menu"></i></a></li>
                        <!-- ============================================================== -->
                        <!-- Search -->
                        <!-- ============================================================== -->
                        <li class="nav-item search-box"> <a class="nav-link waves-effect waves-dark" href="javascript:void(0)"><i class="fa fa-search"></i></a>
                            <form class="app-search">
                                <input type="text" class="form-control" placeholder="Search &amp; enter"> <a class="srh-btn"><i class="fa fa-times"></i></a>
                            </form>
                        </li>
                    </ul>
                    <ul class="navbar-nav my-lg-0">
                        <!-- ============================================================== -->
                        <!-- User profile and search -->
                        <!-- ============================================================== -->
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle text-muted waves-effect waves-dark" href="" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"></a>
                        </li>
                        <!-- ============================================================== -->
                        <!-- User profile and search -->
                        <!-- ============================================================== -->
                    </ul>
                </div>
            </nav>
        </header>
        <!-- ============================================================== -->
        <!-- End Topbar header -->
        <!-- ============================================================== -->
        <!-- ============================================================== -->
        <!-- Left Sidebar - style you can find in sidebar.scss  -->
        <!-- ============================================================== -->
        <aside class="left-sidebar">
            <div class="d-flex no-block nav-text-box align-items-center">
                <span><img src="assets/images/logo-icon.png" alt="elegant admin template"></span>
                <a class="waves-effect waves-dark ml-auto hidden-sm-down" href="javascript:void(0)"><i class="ti-menu"></i></a>
                <a class="nav-toggler waves-effect waves-dark ml-auto hidden-sm-up" href="javascript:void(0)"><i class="ti-menu ti-close"></i></a>
            </div>
            <!-- Sidebar scroll-->
            <div class="scroll-sidebar">
                <!-- Sidebar navigation-->
                <nav class="sidebar-nav">
                    <ul id="sidebarnav">
                         <li> <a class="waves-effect waves-dark" href="login_look_servlet" aria-expanded="false"><i class="fa fa-tachometer"></i><span class="hide-menu">用户列表</span></a></li>
                        <li> <a class="waves-effect waves-dark" href="admin_clothe" aria-expanded="false"><i class="fa fa-user-circle-o"></i><span class="hide-menu">商品列表</span></a></li>
                        <li> <a class="waves-effect waves-dark" href="upclothe.jsp" aria-expanded="false"><i class="fa fa-table"></i><span class="hide-menu"></span>上传衣服信息</a></li>
                        <li> <a class="waves-effect waves-dark" href="admin_order" aria-expanded="false"><i class="fa fa-smile-o"></i><span class="hide-menu"></span>订单消息</a></li>
                      
                        <div class="text-center m-t-30">
                            <a href="login_look_servlet" class="btn waves-effect waves-light btn-success hidden-md-down"> Upgrade to Pro</a>
                        </div>
                    </ul>
                </nav>
                <!-- End Sidebar navigation -->
            </div>
            <!-- End Sidebar scroll-->
        </aside>
        <!-- ============================================================== -->
        <!-- End Left Sidebar - style you can find in sidebar.scss  -->
        <!-- ============================================================== -->
        <!-- ============================================================== -->
        <!-- Page wrapper  -->
        <!-- ============================================================== -->
        <div class="page-wrapper">
            <!-- ============================================================== -->
            <!-- Container fluid  -->
            <!-- ============================================================== -->
            <div class="container-fluid">
                <!-- ============================================================== -->
                <!-- Bread crumb and right sidebar toggle -->
                <!-- ============================================================== -->
                <div class="row page-titles">
                    <div class="col-md-5 align-self-center">
                        <h4 class="text-themecolor">用户列表</h4>
                    </div>
                    <div class="col-md-7 align-self-center text-right">
                        <div class="d-flex justify-content-end align-items-center">
                            <ol class="breadcrumb">
                                <li class="breadcrumb-item"><a href="javascript:void(0)">Home</a></li>
                                <li  class="breadcrumb-item active"><a href="login_look_servlet">Order</a></li>
                            </ol>
                            <a class="btn btn-success d-none d-lg-block m-l-15" href="admin_clothe"> Upgrade To Pro</a>
                        </div>
                    </div>
                </div>
                <!-- ============================================================== -->
                <!-- End Bread crumb and right sidebar toggle -->
                <!-- ============================================================== -->
                <!-- ============================================================== -->
                <!-- Yearly Sales -->
                <!-- ============================================================== -->
              
                <!-- ============================================================== -->
                <!-- News -->
                <!-- ============================================================== -->
                <div class="row">
                    <!-- column -->
                    <div class="col-12">
                        <div class="card">
                            <div class="card-body">
                                <div class="d-flex">
                                    <div>
                                        <h5 class="card-title">订单信息</h5>
                                        <h6 class="card-subtitle">你猜猜有多少订单？ </h6>
                                    </div>
                                    
                                </div>
                                <div><a href="upclothe.jsp"><button style="background-color: #9C0; color:#FFF; font-size:20px; ">上传衣服信息</button></a></div>
                               <form action="queryServlet?table=order_information" method=post>
									<div class="abcd">
									        <input style="" type="text" height="15px" placeholder="搜索.."  name="goodsname"  size="15">
											 <button  type="submit" class="btn btn-info btn-lg">
									            <span class="glyphicon glyphicon-search"></span>
									        </button>
									    </div>
								</form>

                                
                            </div>
                            <div class="table-responsive">
                                <table class="table table-hover">
                                    <thead>
                                        <tr>
                                            <th class="text-center">订单id</th>
                                            <th>订单买主及用户名</th>
                                            <th>宝贝名称</th>
                                            <th>宝贝尺寸</th>
                                            <th>宝贝单价</th>
                                            <th>订单总价</th>
                                            <th>订单地址（---》）</th>
                                            <th>操作</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                   <%ArrayList<order_bean> order_bean= (ArrayList)request.getAttribute("order_bean");
                                   if(order_bean!=null){
     								 for(int i=0;i<order_bean.size();i++){%>
                                        <tr>
                                            <td class="text-center"><%=order_bean.get(i).getOrderId()%></td>
                                            <td class="txt-oflo"><%=order_bean.get(i).getName()%>:<%=order_bean.get(i).getUserName()%></a></td>
                                            <td class="txt-oflo"><%=order_bean.get(i).getClotheName() %></td>
                                            <td><span class="txt-oflo"> <%=order_bean.get(i).getClotherSize() %> </span></td>
                                            <td><span class="txt-oflo"> <%=order_bean.get(i).getClotheprice()%> </span></td>
                                            <td><span class="txt-oflo"> <%=order_bean.get(i).getTotalMoney()%> </span></td>
                                            <td><span class="txt-oflo"> <%=order_bean.get(i).getAddress() %> </span></td>
                                            <td class="text-success"> <a href="delete_user?ID=<%=order_bean.get(i).getOrderId()%>&table=order_information">删除订单</a></td>
                                        </tr>
                                        <%}} %>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
           
          
        </div>
       
       
        </footer>
       
    </div>
    
    <script src="assets/node_modules/jquery/jquery-3.2.1.min.js"></script>
    <!-- Bootstrap popper Core JavaScript -->
    <script src="assets/node_modules/popper/popper.min.js"></script>
    <script src="assets/node_modules/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- slimscrollbar scrollbar JavaScript -->
    <script src="dist/js/perfect-scrollbar.jquery.min.js"></script>
    <!--Wave Effects -->
    <script src="dist/js/waves.js"></script>
    <!--Menu sidebar -->
    <script src="dist/js/sidebarmenu.js"></script>
    <!--Custom JavaScript -->
    <script src="dist/js/custom.min.js"></script>
    <!-- ============================================================== -->
    <!-- This page plugins -->
    <!-- ============================================================== -->
    <!--morris JavaScript -->
    <script src="assets/node_modules/raphael/raphael-min.js"></script>
    <script src="assets/node_modules/morrisjs/morris.min.js"></script>
    <script src="assets/node_modules/jquery-sparkline/jquery.sparkline.min.js"></script>
    <!--c3 JavaScript -->
    <script src="assets/node_modules/d3/d3.min.js"></script>
    <script src="assets/node_modules/c3-master/c3.min.js"></script>
    <!-- Chart JS -->
    <script src="dist/js/dashboard1.js"></script>
</body>

</html>