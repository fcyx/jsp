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

public class admin_clothe_servlet  extends HttpServlet{
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
		          ArrayList<clothe_bean> clothe_bean=new ArrayList<clothe_bean>();
		        	  rs=sql.executeQuery("SELECT * FROM clothe_information");
			          
			          while(rs.next()){
			        	clothe_bean c=new clothe_bean();
			  			c.setClotheId(rs.getInt("ClotheId"));
			  			c.setClotheName(rs.getString("ClotheName"));
			  			c.setClothePrice(rs.getDouble("ClothePrice"));
			  			c.setClothetype(rs.getString("Clothetype"));
			  			c.setClothefactoryAddress(rs.getString("ClothefactoryAddress"));
			  			c.setClotheImg(rs.getString("ClotheImg"));
			  			clothe_bean.add(c);}
			          request.setAttribute("clothe_bean",clothe_bean);
			          RequestDispatcher dispatcher=
			          request.getRequestDispatcher("admin_clothe.jsp");
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
