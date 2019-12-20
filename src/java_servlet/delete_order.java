package java_servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import java_bean.java_bean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class delete_order extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
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

		 
	     String Id=request.getParameter("id");
	     String table = request.getParameter("table");
	     int id = Integer.parseInt(Id);
	     String condition;
	     Connection con;
	     Statement sql; 
	     ResultSet rs;
	     try{ 
	          String uri="jdbc:mysql://127.0.0.1/people_information?"+
	                      "user=root&password=&characterEncoding=gb2312";
	          con=DriverManager.getConnection(uri);
	          sql=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
	                                 ResultSet.CONCUR_READ_ONLY);
	         
	          if(table.equals("clothe_information")){
	 	    	 condition = "DELETE FROM "+table+" where ClotheId ="+ id+";";
	 	    	 sql.executeUpdate(condition);
	 	    	response.sendRedirect("admin_clothe");
	          }
	          else if(table.equals("reg")){
	         	 condition = "DELETE FROM "+table+" where ID ="+ id+";";
	         	sql.executeUpdate(condition);
	         	response.sendRedirect("login_look_servlet");
	          }
	          
	         
	          con.close();
	       
	          sql.close();
	     }
	     catch(Exception e){}

	}
}
