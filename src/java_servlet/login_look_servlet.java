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
import java_bean.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class login_look_servlet  extends HttpServlet{
	   public void init(ServletConfig config) throws ServletException{
		      super.init(config);
		   }
		   public void doPost(HttpServletRequest request,HttpServletResponse response)
		               throws ServletException,IOException{
		      
		     
		     try{  Class.forName("com.mysql.jdbc.Driver");
		     }
		     catch(Exception e){} 
		     
		    
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
		          ArrayList<reg> reg=new ArrayList<reg>();
		        	  rs=sql.executeQuery("SELECT * FROM reg");
			          
			          while(rs.next()){
			        	reg c=new reg();
			  			c.setID(rs.getInt("ID"));
			  			c.setName(rs.getString("Name"));
			  			c.setUserName(rs.getString("UserName"));
			  			c.setPassword(rs.getString("PassWord"));
			  			reg.add(c);}
			          request.setAttribute("reg",reg);
			          RequestDispatcher dispatcher=
			          request.getRequestDispatcher("admin_loginers.jsp");
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
