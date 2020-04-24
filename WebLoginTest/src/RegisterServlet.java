import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.http.Part;

@WebServlet("/RegisterServlet")
@MultipartConfig(maxFileSize = 1024*1024*50, maxRequestSize = 1024*1024*100)
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setHeader("content-type","text/html;charset=utf-8");
        PrintWriter printWriter = response.getWriter();
//        String username = request.getParameter("userName");
//        String pw1 = request.getParameter("Pwd");
//        String pw2 = request.getParameter("Pwd2");
//        if(pw1.equals(pw2))
//        {
//            try {
//                Database database = new Database("root","a9988765");
//                database.insert(username, pw1,"testimgname","testimgpath");
//                database.close();
//                printWriter.write("Register Successfully");
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
//        }
//        else
//        {
//            printWriter.write("password did not match");
//        }
    	String realPath = request.getServletContext().getRealPath("/WEB-INF/upload");
    	File file = new File(realPath);
    	if(!file.exists()) {
    		file.mkdirs();    		
    	}
    	
    	String username = new String();
    	String userpara = new String();
    	String pwd1 = new String();
    	String pwdpara = new String();
    	String pwd2 = new String();
    	String pwdpara2 = new String();
    	String picname = new String();    	
    	
    	Collection<Part> parts = request.getParts();
    	System.out.println(parts.size());
    	
    	for (Part part : parts) {
    		String filename = part.getSubmittedFileName();
    		System.out.println(filename);
    		String name = part.getName();
    		System.out.println(name);
    		if(filename!=null)
    		{
    			part.write(realPath+File.separator+filename.replace("C:", ""));
    			picname = filename;
    		}
    		else
    		{
    			System.out.println("1111111111111111");
    			if(name.equals("userName")) {
    				username = part.getName();
    				userpara = request.getParameter(username);
//    				System.out.println(userpara);
    			}else if(name.equals("Pwd"))
    			{
    				pwd1 = part.getName();
    				pwdpara = request.getParameter(pwd1);
    			}else if(name.equals("Pwd2")) {
    				pwd2 = part.getName();
    				pwdpara2 = request.getParameter(pwd2);
    			}
    		}
    	}
    	if(pwdpara.equals(pwdpara2))
          {
              try {
                  Database database = new Database("root","a9988765");
                  database.insert(username, pwdpara, picname);
                  database.close();
                  printWriter.write("Register Successfully");
              } catch (ClassNotFoundException e) {
                  e.printStackTrace();
              } catch (SQLException throwables) {
                  throwables.printStackTrace();
              }
          }
          else
          {
              printWriter.write("password did not match");
          }
//        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    	request.setCharacterEncoding("utf-8");
//    	response.setContentType("text/html;charset=utf-8");
    	
    	
    	doPost(request,response);
    }
}