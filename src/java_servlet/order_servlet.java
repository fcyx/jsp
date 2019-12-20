package java_servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class order_servlet extends HttpServlet {

	
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
		
		 try{  Class.forName("com.mysql.jdbc.Driver");
	     }
	     catch(Exception e){} 
		
		Connection con;
	    Statement sql,sql1,sql2,sql3; 
	    ResultSet rs,rs1,rs2;
		String user = "root";
  	  	String password = "";
        try{String uri="jdbc:mysql://127.0.0.1/people_information";
        con=DriverManager.getConnection(uri,user,password);
        sql=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                               ResultSet.CONCUR_READ_ONLY);
        sql1=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        sql2=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        sql3=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
		HttpSession session = request.getSession(true);
		String id[] = request.getParameterValues("checkbox");
		String UserName = (String)session.getAttribute("UserName");
		double a=0;
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		String date = sd.format(new Date());
		for(int i=0;i<id.length;i++){
			String condtion = "SELECT * FROM shoppingcar_information where ShoppingcarID="+id[i]+";";
			rs = sql.executeQuery(condtion);
			rs.next();
			int cid = rs.getInt("ClotheID");
			int ClotheNumber = rs.getInt("ClotheNumber");
			double ClothePrice = rs.getDouble("ClothePrice");
			double totalmoney = ClotheNumber*ClothePrice;
			String clotheImg = rs.getString("ClotheImg");
			String clothename = rs.getString("ClotheName");
			a = a + totalmoney;
			String ClotheSzie = rs.getString("ClotheSzie");
			rs1 = sql1.executeQuery("SELECT ClothefactoryAddress FROM clothe_information where ClotheId="+cid+";");
			rs1.next();
			String ClotheFactoryAddress = rs1.getString("ClothefactoryAddress");
			
			rs2 = sql2.executeQuery("SELECT * FROM reg where UserName='"+UserName+"';");
			rs2.next();
			String Tel = rs2.getString("Tel");
			String regaddress = rs2.getString("address");
			String post = rs2.getString("post");
			String name = rs2.getString("Name");
			String addre = regaddress+"--->"+ClotheFactoryAddress;
			condtion = "INSERT INTO  order_information(UserName,ClotheId,ClotheImg,Clotheprice,ClotheNumber,ClotherSize,TotalMoney,OrderDate,address,post,ClotheName,Name)"+
			" VALUES('"+UserName+"','"+cid+"','"+clotheImg+"','"
	 				+ClothePrice+"','"+ClotheNumber+"','"+ClotheSzie+"','"+totalmoney+"','"+date+"','"+addre+"','"
	 			+post+"','"+clothename+"','"+name+"');";
			sql2.executeUpdate(condtion);
			String condtion1 = "DELETE FROM shoppingcar_information where ShoppingcarID="+id[i]+";";
			sql3.executeUpdate(condtion1);
		}
		response.sendRedirect("succseed2.jsp");
        con.close();
        }
        
        catch(Exception e){}
		
	}

}
