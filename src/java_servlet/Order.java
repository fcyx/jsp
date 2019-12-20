package java_servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java_bean.clothe_bean;
import java_bean.order_bean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Order extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		  Connection con;
	      Statement sql; 
	      ResultSet rs;
	      String Username = request.getParameter("Username");
	      try{ 

	    	  String user = "root";
	    	  String password = "";
	          String uri="jdbc:mysql://127.0.0.1/people_information";
	          con=DriverManager.getConnection(uri,user,password);
	          sql=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
	                                 ResultSet.CONCUR_READ_ONLY);
	          ArrayList<order_bean> order1=new ArrayList<order_bean>();
	        	  rs=sql.executeQuery("SELECT * FROM order_information where Username='"+Username+"';");
		          
		          while(rs.next()){
		        	 order_bean c=new order_bean();
		  			c.setClotheId(rs.getInt("ClotheId"));
		  			c.setOrderId(rs.getInt("OrderId"));
		  			c.setAddress(rs.getString("address"));
		  			c.setClotheNumber(rs.getInt("ClotheNumber"));
		  			c.setClotheprice(rs.getDouble("Clotheprice"));
		  			c.setClotherSize(rs.getString("ClotherSize"));
		  			c.setOrderDate(rs.getString("OrderDate"));
		  			c.setPost(rs.getString("post"));
		  			c.setTotalMoney(rs.getDouble("TotalMoney"));
		  			c.setUserName(rs.getString("UserName"));
		  			c.setClotheImg(rs.getString("ClotheImg"));
		  			c.setClotheName(rs.getString("ClotheName"));
		  			order1.add(c);
		  		}
		          request.setAttribute("order",order1);
		          RequestDispatcher dispatcher=
		          request.getRequestDispatcher("order_scan.jsp");
		          dispatcher.forward(request,response);
		          con.close();
		          rs.close();
		          sql.close();
	     }
	     catch(SQLException e){
	          System.out.println(e);
	     }  
	   }
	}

