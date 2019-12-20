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
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class gou_servlet extends HttpServlet{
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
		     String dataBase = request.getParameter("dataBase");
		     String tableName = request.getParameter("tableName"); 
		     String size = request.getParameter("chima");
		     String number = request.getParameter("number");
		     String ClotheId = request.getParameter("ClotheId");
		     String UserName = (String)session.getAttribute("UserName");
		     int cid = Integer.parseInt(ClotheId);
		     int ClotheNumber = Integer.parseInt(number);
		     Connection con;
		     Statement sql,sql1; 
		     ResultSet rs,rs1;
		     try{ 
		    	  String user = "root";
		    	  String password = "";
		          String uri="jdbc:mysql://127.0.0.1/"+dataBase;
		          con=DriverManager.getConnection(uri,user,password);
		          sql=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
		                                 ResultSet.CONCUR_READ_ONLY);
		          sql1=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                          ResultSet.CONCUR_READ_ONLY);
		             ArrayList<clothe_bean> clother_gu=new ArrayList<clothe_bean>();
		        	  rs=sql.executeQuery("SELECT * FROM "+ tableName +" where ClotheId="+ ClotheId);
			          rs.next();
			          String ClotheName =  rs.getString("ClotheName");
			          String ClothePrice =  rs.getString("ClothePrice");
			          double price = Double.parseDouble(ClothePrice);
			          String Clothetype = rs.getString("Clothetype");
			          String ClotheImg = rs.getString("ClotheImg");
			         
			          
			          rs1=sql.executeQuery("SELECT * FROM shoppingcar_information where ClotheName='"+ ClotheName+"';");
			          String b = null;
			          if(rs1.next()){
			        	  rs1.previous();
			        	  int count=0;
			        	  while(rs1.next()){
				          b = rs1.getString("ClotheSzie");
				          if(size.equals(b)){
					        	 int a = rs1.getInt("ClotheNumber");
						         a = a+ClotheNumber;
						         sql1.executeUpdate("update shoppingcar_information set  ClotheNumber="+a+" where ClotheName='"+ ClotheName+"' and ClotheSzie = '"+ b+"';");
						         break;
				        	 }
				         count++;
				        }
			        	  rs1.last();
			        	  int ccc = rs1.getRow();
			        	  if(count>=ccc){
			        		  String condion = "INSERT INTO shoppingcar_information(ClotheID,UserName,ClotheNumber,ClotheName,ClotheSzie,ClothePrice,Clothetype,ClotheImg)"+
							          " VALUES("+ClotheId+",'"+UserName+"',"+ClotheNumber+",'"+ClotheName+"','"+size+"',"+price +",'"+Clothetype+"','"+ClotheImg+"');";
							   sql1.executeUpdate(condion);
			        	  }
			        	  rs1.beforeFirst();
			        	  	
			          }
			          else{
			        	  String condion = "INSERT INTO shoppingcar_information(ClotheID,UserName,ClotheNumber,ClotheName,ClotheSzie,ClothePrice,Clothetype,ClotheImg)"+
						          " VALUES("+ClotheId+",'"+UserName+"',"+ClotheNumber+",'"+ClotheName+"','"+size+"',"+price +",'"+Clothetype+"','"+ClotheImg+"');";
						   sql.executeUpdate(condion);
			          }
			         
			          session.setAttribute("aaa",1);
			          response.sendRedirect("succseed1.jsp");
			          con.close();
			         
			          
			          
			          
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
