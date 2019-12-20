package java_servlet;
import java_bean.java_bean;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java_bean.clothe_bean;
import javax.servlet.*;
import javax.servlet.http.*;
public class login_severlet extends HttpServlet implements Serializable{
	   public void init(ServletConfig config) throws ServletException{
		      super.init(config);
		   }
		   public void doPost(HttpServletRequest request,HttpServletResponse response)
		               throws ServletException,IOException{
		      java_bean resultBean=null;
		      try{  resultBean=(java_bean)request.getAttribute("resultBean");
		            if(resultBean==null){
		                resultBean=new java_bean(); //����Javabean����
		                request.setAttribute("resultBean",resultBean);
		            }
		      }
		      catch(Exception exp){
		            resultBean=new java_bean();  //����Javabean����
		            request.setAttribute("resultBean",resultBean);
		      } 
		     try{  Class.forName("com.mysql.jdbc.Driver");
		     }
		     catch(Exception e){} 
		     String dataBase = request.getParameter("dataBase");
		     String tableName = request.getParameter("tableName"); 
		     String UserName = request.getParameter("UserName");
		     String Password = request.getParameter("PassWord");
		     Connection con;
		     Statement sql; 
		     ResultSet rs;
		     try{ 
		    	  String user = "root";
		    	  String password = "";
		          String uri="jdbc:mysql://127.0.0.1/"+dataBase;
		          con=DriverManager.getConnection(uri,user,password);
		          sql=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
		                                 ResultSet.CONCUR_READ_ONLY);
		          HttpSession session = request.getSession(true);
		          String condition ="SELECT PassWord FROM "+tableName+" where UserName = '"+UserName+"';";
		          
		          
		          ArrayList<clothe_bean> clother=new ArrayList<clothe_bean>();
		          rs=sql.executeQuery(condition);
		          rs.next();
		          if(Password.equals(rs.getString(1))){
		        	  if(Password.equals("admin")&&UserName.equals("admin")){
		        		  response.sendRedirect("login_look_servlet");
		        	  }
		        	  else{
		        	  session.setAttribute("islogin",1);
			          String condition1 ="SELECT Name FROM "+tableName+" where UserName = '"+UserName+"';";
			          rs=sql.executeQuery(condition1);
			          rs.next();
			          String name = rs.getString("Name");
			          session.setAttribute("aaa",0);
			          session.setAttribute("Name",name);
			          session.setAttribute("UserName", UserName);
			          response.sendRedirect("scan_servlet");
			          con.close();
			          rs.close();
			          sql.close();}
		          }
		          else{
		        	  response.setContentType("text/html;charset=GB2312");
		        	  PrintWriter out = response.getWriter();
		        	  out.println("<html><body><center>");
		        	  out.println("<h2>��½ʧ�ܣ���ѡ������ѡ��</h2>");
		        	  out.println("<a href =index.jsp>���ص�¼����</a>");
		        	  out.println("<a href =reg.jsp>����ע�����</a>");
		        	  out.println("<a href =modify.jsp>�����޸��������</a></center>");
		          }
		          
		          
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
