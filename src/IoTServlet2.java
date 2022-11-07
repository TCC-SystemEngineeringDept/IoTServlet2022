

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IoTServlet
 */
@WebServlet("/iot2")
public class IoTServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter out = response.getWriter();
		ServletContext application = this.getServletContext();
		 ArrayList<String> list = (ArrayList<String>)application.getAttribute("list");
		 if(list==null) {
			 return;
		 }

		 for(String s :list) {
			out.println("<H3>"+s+"</H3>");
		 }
		 

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String host = request.getHeader("host");
		System.out.println("host["+host+"]");

		String user = request.getHeader("user");
		System.out.println("user["+user+"]");

		String content = request.getReader().readLine();
		System.out.println(content);
		
		
		ServletContext application = this.getServletContext();

		 ArrayList<String> list = (ArrayList<String>)application.getAttribute("list");
		 if(list == null) {
			 list = new ArrayList<String>();
		 }
		 list.add("host["+host+"] user["+user+"] content=["+content+"]");
		 application.setAttribute("list", list);
		
		
		
	}

}
