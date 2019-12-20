package java_servlet;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


public class clothe_modify extends HttpServlet {
	Connection con;
    Statement sql; 
    ResultSet rs;
    private static final long serialVersionUID = 1L;
     
    // 上传文件存储目录
    private static final String UPLOAD_DIRECTORY = "img";
 
    // 上传配置
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB
 
    /**
     * 上传数据及保存文件
     */
    protected void doPost(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {
        // 检测是否为多媒体上传
        if (!ServletFileUpload.isMultipartContent(request)) {
            // 如果不是则停止
            PrintWriter writer = response.getWriter();
            writer.println("Error: 表单必须包含 enctype=multipart/form-data");
            writer.flush();
            return;
        }
 
        // 配置上传参数
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // 设置内存临界值 - 超过后将产生临时文件并存储于临时目录中
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        // 设置临时存储目录
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
 
        ServletFileUpload upload = new ServletFileUpload(factory);
         
        // 设置最大文件上传值
        upload.setFileSizeMax(MAX_FILE_SIZE);
         
        // 设置最大请求值 (包含文件和表单数据)
        upload.setSizeMax(MAX_REQUEST_SIZE);
        
        // 中文处理
        upload.setHeaderEncoding("UTF-8"); 
        String ClotheImg="";
        double ClothePrice = 0;
        String Clothetype="";
        String ClothefactoryAddress="";
        String ID= request.getParameter("ID");
        String img = request.getParameter("img");
        
        
        
        // 构造临时路径来存储上传的文件
        // 这个路径相对当前应用的目录
        String uploadPath = getServletContext().getRealPath("/") + File.separator ;
        String ClotheName ="";
        String f="";
       
        // 如果目录不存在则创建
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        try{  Class.forName("com.mysql.jdbc.Driver");
	     }
	     catch(Exception e){} 
        try {
            // 解析请求的内容提取文件数据
            @SuppressWarnings("unchecked")
            List<FileItem> formItems = upload.parseRequest(request);
            
            if (formItems != null && formItems.size() > 0) {
                // 迭代表单数据
                for (FileItem item : formItems) {
                    // 处理不在表单中的字段
                    if (!item.isFormField()) {
                        String fileName = new File(item.getName()).getName();
                        System.out.println("---------------->"+fileName);
                        if(fileName==""){
                        	ClotheImg = img;
                        	continue;
                        }
                        else{
                        f = "E:\\JavaMyeclipse\\.metadata\\.me_tcat\\webapps\\img\\" + fileName;
                        File storeFile = new File(f);
                        // 在控制台输出文件的上传路径
                        // 保存文件到硬盘
                        ClotheImg = "http://192.168.137.1:8080/img/"+fileName;
                        System.out.println("---------------->"+ClotheImg);
                        ClotheImg = ClotheImg.replaceAll("////", "////////");
                        item.write(storeFile);
                       
                        }
                    }
                    else{
                    	String value = item.getString("UTF-8"); // 获取value属性的值，这里需要指明UTF-8格式，否则出现中文乱码问题
                        if (item.getFieldName().equals("ClotheName")) {// 对应form中属性的名字
                        	ClotheName = value;
                        }
                        else if(item.getFieldName().equals("ClothePrice")){
        
                        	ClothePrice =Double.parseDouble(value);
                        }
                        else if(item.getFieldName().equals("Clothetype")){
                        	Clothetype = value;
                        }
                        else if(item.getFieldName().equals("ClothefactoryAddress")){
                        	ClothefactoryAddress =value;
                        }
                    }
              }
              String user = "root";
  	    	  String password = "";
  	          String uri="jdbc:mysql://127.0.0.1/people_information";
  	          con=DriverManager.getConnection(uri,user,password);
  	          sql=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
  	                                 ResultSet.CONCUR_READ_ONLY);
  	          String condion = "UPDATE clothe_information set ClotheName='"+ClotheName+"',ClotheImg='"+ClotheImg+"',ClothePrice="+ClothePrice+",Clothetype='"+Clothetype+"',ClothefactoryAddress='"+ClothefactoryAddress+"' where ClotheId="+ID+";";
  	          sql.executeUpdate(condion);
  	          response.sendRedirect("clothe_details?ID="+ID);
          }
           
           
            
        } catch (Exception ex) {
            request.setAttribute("message",
                    "错误信息: " + ex.getMessage());
        }
       
    }
}