package java_servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 
import java_bean.clothe_bean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class Upclothe extends HttpServlet {
	Connection con;
    Statement sql; 
    ResultSet rs;
    private static final long serialVersionUID = 1L;
     
    // �ϴ��ļ��洢Ŀ¼
    private static final String UPLOAD_DIRECTORY = "img";
 
    // �ϴ�����
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB
 
    /**
     * �ϴ����ݼ������ļ�
     */
    protected void doPost(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {
        // ����Ƿ�Ϊ��ý���ϴ�
        if (!ServletFileUpload.isMultipartContent(request)) {
            // ���������ֹͣ
            PrintWriter writer = response.getWriter();
            writer.println("Error: ��������� enctype=multipart/form-data");
            writer.flush();
            return;
        }
 
        // �����ϴ�����
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // �����ڴ��ٽ�ֵ - �����󽫲�����ʱ�ļ����洢����ʱĿ¼��
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        // ������ʱ�洢Ŀ¼
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
 
        ServletFileUpload upload = new ServletFileUpload(factory);
         
        // ��������ļ��ϴ�ֵ
        upload.setFileSizeMax(MAX_FILE_SIZE);
         
        // �����������ֵ (�����ļ��ͱ�����)
        upload.setSizeMax(MAX_REQUEST_SIZE);
        
        // ���Ĵ���
        upload.setHeaderEncoding("UTF-8"); 
        
        String ClotheImg="";
        double ClothePrice = 0;
        String Clothetype="";
        String ClothefactoryAddress="";
        
        // ������ʱ·�����洢�ϴ����ļ�
        // ���·����Ե�ǰӦ�õ�Ŀ¼
        String uploadPath = getServletContext().getRealPath("/") + File.separator + UPLOAD_DIRECTORY;
        String ClotheName ="";
        String f="";
        // ���Ŀ¼�������򴴽�
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        try{  Class.forName("com.mysql.jdbc.Driver");
	     }
	     catch(Exception e){} 
        try {
            // ���������������ȡ�ļ�����
            @SuppressWarnings("unchecked")
            List<FileItem> formItems = upload.parseRequest(request);
            
            if (formItems != null && formItems.size() > 0) {
                // ����������
                for (FileItem item : formItems) {
                    // �����ڱ��е��ֶ�
                    if (!item.isFormField()) {
                        String fileName = new File(item.getName()).getName();
                        f = "E:\\JavaMyeclipse\\.metadata\\.me_tcat\\webapps\\img\\" + fileName;
                        File storeFile = new File(f);
                        // �ڿ���̨����ļ����ϴ�·��
                        // �����ļ���Ӳ��
                        ClotheImg = "http://192.168.137.1:8080/img/"+fileName;
                        ClotheImg = ClotheImg.replaceAll("////", "////////");
                        item.write(storeFile);
                        request.setAttribute("message",
                            "�ļ��ϴ��ɹ�!");
                    }
                    else{
                    	String value = item.getString("UTF-8"); // ��ȡvalue���Ե�ֵ��������Ҫָ��UTF-8��ʽ���������������������
                        if (item.getFieldName().equals("ClotheName")) {// ��Ӧform�����Ե�����
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
  	          String condion = "INSERT INTO clothe_information(ClotheName,ClothePrice,Clothetype,ClotheImg,ClothefactoryAddress) " +
  	          		"value('"+ClotheName+"',"+ClothePrice+",'"+Clothetype+"','"+ClotheImg+"','"+ClothefactoryAddress+"');";
  	          sql.executeUpdate(condion);
          }
            
           
            
        } catch (Exception ex) {
            request.setAttribute("message",
                    "������Ϣ: " + ex.getMessage());
        }
       
        // ��ת�� message.jsp
        getServletContext().getRequestDispatcher("/message.jsp").forward(
                request, response);
    }
}
