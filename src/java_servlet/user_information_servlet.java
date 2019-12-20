package java_servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java_bean.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class user_information_servlet extends HttpServlet{
	   public void init(ServletConfig config) throws ServletException{
		      super.init(config);
		   }
		   public void doPost(HttpServletRequest request,HttpServletResponse response)
		               throws ServletException,IOException{
		      
		     
		     try{  Class.forName("com.mysql.jdbc.Driver");
		     }
		     catch(Exception e){} 
		     
		     String ID = request.getParameter("ID");
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
		          ArrayList<reg> reg_uesr=new ArrayList<reg>();
		          rs=sql.executeQuery("SELECT * FROM reg where ID="+ID);
			          while(rs.next()){
			        	reg c=new reg();
				  		c.setID(rs.getInt("ID"));
				  		c.setName(rs.getString("Name"));
				  		c.setUserName(rs.getString("UserName"));
				  		c.setPassword(rs.getString("PassWord"));
				  		c.setAddress(rs.getString("address"));
				  		c.setBirthTime(rs.getString("BirthTime"));
				  		c.setHobby(rs.getString("hobby"));
				  		c.setSex(rs.getString("sex"));
				  		c.setTel(rs.getString("Tel"));
				  		c.setPost(rs.getString("post"));
				  		reg_uesr.add(c);
				  		
			  		}
			          request.setAttribute("reg_uesr",reg_uesr);
			        
			          RequestDispatcher dispatcher=
			          request.getRequestDispatcher("user_details.jsp");
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
