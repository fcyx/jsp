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
import java_bean.java_bean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class jia_servlet extends HttpServlet {

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
			throws ServletException, IOException
			{
			
			
			String shoppingID =request.getParameter("shoppingid");
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
			  ArrayList<clothe_bean> clother_chun=new ArrayList<clothe_bean>();
				  rs=sql.executeQuery("SELECT ClotheNumber FROM shoppingcar_information where ShoppingcarID="+shoppingID+";");
			      rs.next();
			      int a = rs.getInt("ClotheNumber");
			      a++;
			      rs.close();
			      sql.executeUpdate("UPDATE  shoppingcar_information SET ClotheNumber = "+ a +" where ShoppingcarID="+shoppingID+";");
			      con.close();
			      sql.close();
			      response.sendRedirect("shopping_car_servlet");
			}
			catch(SQLException e){
			  System.out.println(e);
			  
			  
			
			}  
			}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
