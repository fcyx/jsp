package java_servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java_bean.clothe_bean;
import java_bean.java_bean;
import java_bean.shoppingcar_bean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class shopping_car_servlet extends HttpServlet implements Serializable{
	   public void init(ServletConfig config) throws ServletException{
		      super.init(config);
		   }
		   public void doPost(HttpServletRequest request,HttpServletResponse response)
		               throws ServletException,IOException{
		      java_bean resultBean=null;
		      try{  resultBean=(java_bean)request.getAttribute("resultBean");
		            if(resultBean==null){
		                resultBean=new java_bean(); //创建Javabean对象
		                request.setAttribute("resultBean",resultBean);
		            }
		      }
		      catch(Exception exp){
		            resultBean=new java_bean();  //创建Javabean对象
		            request.setAttribute("resultBean",resultBean);
		      } 
		     try{  Class.forName("com.mysql.jdbc.Driver");
		     }
		     catch(Exception e){} 
		     
		     HttpSession session = request.getSession(true);
		     String UserName = (String)session.getAttribute("UserName");
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
		          String condition ="SELECT * FROM shoppingcar_information where UserName = "+UserName;
		          ArrayList<shoppingcar_bean> shopping=new ArrayList<shoppingcar_bean>();
		          rs=sql.executeQuery(condition);
		        	  
			          while(rs.next()){
			        	shoppingcar_bean c=new shoppingcar_bean();
			  			c.setClotheName(rs.getString("ClotheName"));
			  			c.setClotheNumber(rs.getInt("ClotheNumber"));
			  			c.setClothePrice(rs.getDouble("ClothePrice"));
			  			c.setClotheSize(rs.getString("ClotheSzie"));
			  			c.setClothetype(rs.getString("Clothetype"));
			  			c.setShoppingcarID(rs.getInt("ShoppingcarID"));
			  			c.setUserName(rs.getString("UserName"));
			  			c.setClotheImg(rs.getString("ClotheImg"));
			  			shopping.add(c);
			  		}
			          rs.next();
			          request.setAttribute("shoppingcar", shopping);
			          RequestDispatcher dispatcher=
					          request.getRequestDispatcher("shopping_car.jsp");
				      dispatcher.forward(request,response);
				      con.close();
			          rs.close();
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
