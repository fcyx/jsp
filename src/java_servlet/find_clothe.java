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
import java_bean.reg;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class find_clothe extends HttpServlet{
	   public void init(ServletConfig config) throws ServletException{
		      super.init(config);
		   }
		   public void doPost(HttpServletRequest request,HttpServletResponse response)
		               throws ServletException,IOException{
		   
		     try{  Class.forName("com.mysql.jdbc.Driver");
		     }
		     catch(Exception e){} 
		     
		     String tableName = request.getParameter("table"); 
		     String name = new String(request.getParameter("goodsname").getBytes("iso-8859-1"),"utf-8"); 
		     Connection con;
		     Statement sql; 
		     ResultSet rs;
		     try{ 

		    	  String user = "root";
		    	  String password = "";
		          String uri="jdbc:mysql://127.0.0.1/people_information";
		          con=DriverManager.getConnection(uri,user,password);
		          sql=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
		                                 ResultSet.CONCUR_READ_ONLY);
		          if(tableName.equals("clothe_information")){
		              ArrayList<clothe_bean> clothe_bean=new ArrayList<clothe_bean>();
		        	  rs=sql.executeQuery("SELECT * FROM clothe_information where Clothetype LIKE '%"+name+"%'");
			          while(rs.next()){
			        	clothe_bean c=new clothe_bean();
			  			c.setClotheId(rs.getInt("ClotheId"));
			  			c.setClothefactoryAddress(rs.getString("clothefactoryAddress"));
			  			c.setClotheImg(rs.getString("clotheImg"));
			  			c.setClotheName(rs.getString("clotheName"));
			  			c.setClothePrice(rs.getDouble("clothePrice"));
			  			c.setClothetype(rs.getString("clothetype"));
			  			clothe_bean.add(c);
			  		}
			          request.setAttribute("clothe_bean",clothe_bean);
			        
			          RequestDispatcher dispatcher=
			          request.getRequestDispatcher("admin_clothe.jsp");
			          dispatcher.forward(request,response);
		          }
		          else if(tableName.equals("order_information")){
		              ArrayList<order_bean> order_bean=new ArrayList<order_bean>();
		        	  rs=sql.executeQuery("SELECT * FROM order_information where UserName LIKE '%"+name+"%'");
			          while(rs.next()){
			        	  order_bean c=new order_bean();
				  			c.setClotheName(rs.getString("ClotheName"));
				  			c.setName(rs.getString("Name"));
				  			c.setOrderId(rs.getInt("OrderId"));
				  			c.setClotherSize(rs.getString("ClotherSize"));
				  			c.setUserName(rs.getString("UserName"));
				  			c.setClotheprice(rs.getDouble("Clotheprice"));
				  			c.setTotalMoney(rs.getDouble("TotalMoney"));
				  			c.setAddress(rs.getString("address"));
				  			order_bean.add(c);
			  		}
			          request.setAttribute("order_bean",order_bean);
			        
			          RequestDispatcher dispatcher=
			          request.getRequestDispatcher("admin_order.jsp");
			          dispatcher.forward(request,response);
		          }
		          else if(tableName.equals("reg")){
		        	  ArrayList<reg> reg=new ArrayList<reg>();
		        	  rs=sql.executeQuery("SELECT * FROM reg where Name LIKE '%"+name+"%'");
		        	  
			          while(rs.next()){
			        	reg c=new reg();
			  			c.setID(rs.getInt("ID"));
			  			c.setName(rs.getString("Name"));
			  			c.setUserName(rs.getString("UserName"));
			  			c.setPassword(rs.getString("PassWord"));
			  			reg.add(c);
			  			
			          }
			          
			          request.setAttribute("reg",reg);
			          RequestDispatcher dispatcher=
			          request.getRequestDispatcher("admin_loginers.jsp");
		          }
		          
			          con.close();
			          sql.close();
		     }
		     catch(SQLException e){
		          System.out.println(e);
		     }  
		   }
		   public  void  doGet(HttpServletRequest request,HttpServletResponse response)
		           throws ServletException,IOException{
		       doPost(request,response);
		   }
		}
