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
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import javax.servlet.http.Part;

@WebServlet("/RegisterServlet")
@MultipartConfig(maxFileSize = 1024 * 1024 * 50, maxRequestSize = 1024 * 1024 * 100)
public class RegisterServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setHeader("content-type", "text/html;charset=utf-8");
		PrintWriter printWriter = response.getWriter();

		String realPath = request.getServletContext().getRealPath("/WEB-INF/upload");
		File file = new File(realPath);
		if (!file.exists()) {
			file.mkdirs();
		}

		String userpara = new String();
		String pwdpara = new String();
		String pwdpara2 = new String();
		String picname = new String();

		Collection<Part> parts = request.getParts();
		System.out.println(parts.size());

		for (Part part : parts) {
			String filename = part.getSubmittedFileName();
			System.out.println(filename);
			String name = part.getName();
			System.out.println(name);
			if (filename != null) {
				String strtime = (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date());
				part.write(realPath + File.separator + strtime + filename.replace("C:", ""));
				picname = filename;
			} else {
				if (name.equals("userName")) {
					userpara = request.getParameter(name);
				} else if (name.equals("Pwd")) {
					pwdpara = request.getParameter(name);
				} else if (name.equals("Pwd2")) {
					pwdpara2 = request.getParameter(name);
				}
			}
		}
		if (pwdpara.equals(pwdpara2)) {
			try {
				Database database = new Database("root", "a9988765");
				database.insert(userpara, pwdpara, picname);
				database.close();
				printWriter.write("Register Successfully");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
		} else {
			printWriter.write("password did not match");
		}
//        doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
}