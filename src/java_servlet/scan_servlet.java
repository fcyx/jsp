package java_servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

import java_bean.clothe_bean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class scan_servlet extends HttpServlet {

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
		Connection con;
	    Statement sql; 
	    ResultSet rs;
		String user = "root";
		String password = "";
        try{
        	String uri="jdbc:mysql://127.0.0.1/people_information";
	        con=DriverManager.getConnection(uri,user,password);
	        sql=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
	                               ResultSet.CONCUR_READ_ONLY);
	       
	        ArrayList<clothe_bean> clother=new ArrayList<clothe_bean>();
	        rs=sql.executeQuery("SELECT * FROM clothe_information;");
		    
		    while(rs.next()){
		        clothe_bean c=new clothe_bean();
			  	c.setClotheId(rs.getInt("ClotheId"));
			  	c.setClothefactoryAddress(rs.getString("clothefactoryAddress"));
			  	c.setClotheImg(rs.getString("clotheImg"));
			  	c.setClotheName(rs.getString("clotheName"));
			  	c.setClothePrice(rs.getDouble("clothePrice"));
			  	c.setClothetype(rs.getString("clothetype"));
			  	clother.add(c);
		  	}
		    request.setAttribute("clother", clother);
		    RequestDispatcher dis = request.getRequestDispatcher("clothe_scan.jsp");
		    dis.forward(request,response);
        }
        catch(Exception e){}
		
	}

}
