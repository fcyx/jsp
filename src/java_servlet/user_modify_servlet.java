package java_servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java_bean.reg;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class user_modify_servlet  extends HttpServlet{
	   public void init(ServletConfig config) throws ServletException{
		      super.init(config);
		   }
		   public void doPost(HttpServletRequest request,HttpServletResponse response)
		               throws ServletException,IOException{
		      
		     
		     try{  Class.forName("com.mysql.jdbc.Driver");
		     }
		     catch(Exception e){} 
		     
		     String ID = request.getParameter("ID");
		     String Name = new String(request.getParameter("Name").getBytes("iso-8859-1"),"utf-8");
		     String UserName = new String(request.getParameter("UserName").getBytes("iso-8859-1"),"GB2312");
		     String PassWord = request.getParameter("PassWord");
		     String sex = new String(request.getParameter("sex").getBytes("iso-8859-1"),"utf-8");
		     String post = request.getParameter("post");
		     String address = new String(request.getParameter("address").getBytes("iso-8859-1"),"utf-8");
		     String BirthTime = request.getParameter("BirthTime");
		     String hobby =new String( request.getParameter("hobby").getBytes("iso-8859-1"),"utf-8");
		     
		     System.out.println("--------------->"+PassWord);
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
		          sql.executeUpdate("update reg set Name='"+Name+"',"+"UserName='"+UserName+"',"+"PassWord='"+PassWord+"',"+"sex='"+sex+"',"
		        		  +"post='"+post+"',"+"address='"+address+"',"+"BirthTime='"+BirthTime+"',"+"hobby='"+hobby+"' where ID="+ID);
		          
		          response.sendRedirect("user_information?ID="+ID);
			     
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
