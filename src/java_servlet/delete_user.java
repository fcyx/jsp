package java_servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class delete_user extends HttpServlet {

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

		 
	     String Id=request.getParameter("ID");
	     String table = request.getParameter("table");
	     int id = Integer.parseInt(Id);
	     String condition;
	     Connection con;
	     Statement sql; 
	     ResultSet rs;
	     try{ 
	    	  HttpSession session = request.getSession(true);
	    	  String username= (String) session.getAttribute("UserName");
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
	          else if(table.equals("order_information")){
		         	 condition = "DELETE FROM "+table+" where OrderId ="+ id+";";
		         	sql.executeUpdate(condition);
		         	response.sendRedirect("admin_order");
		          }
	          else if(table.equals("order_informatio")){
		         	 condition = "DELETE FROM order_information where OrderId ="+ id+";";
		         	sql.executeUpdate(condition);
		         	System.out.println("----------->"+username);
		         	response.sendRedirect("Order?Username="+username);
		         	
		          }
	          
	         
	          con.close();
	       
	          sql.close();
	     }
	     catch(Exception e){}

	}
}
