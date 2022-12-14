

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class IoTServlet
 */
@WebServlet("/iot2")
public class IoTServlet7 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		ServletContext application = this.getServletContext();
		 ArrayList<String> list = (ArrayList<String>)application.getAttribute("list");
		 if(list==null) {
			 return;
		 }
		 Gson gson = new Gson();
		 String content = request.getReader().readLine();
		 Result result = gson.fromJson(content, Result.class);
		 application.setAttribute("list",result );

		
		 if(result.roll>=100) {
			 response.getWriter().append("GREEN");
		 }else if(result.roll<=5){
			 response.getWriter().append("RED");
		 }else {
			 response.getWriter().append("NONE");
		 }

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		/*Gson gson = new Gson();
		 String content = request.getReader().readLine();
		 Result result = gson.fromJson(content, Result.class);
		 ServletContext application = this.getServletContext();
		 application.setAttribute("list",result );
		 if(result.roll>=100) {
			 response.getWriter().append("GREEN");
		 }else if(result.roll<=5){
			 response.getWriter().append("RED");
		 }else {
			 response.getWriter().append("NONE");
		 }	 */ 
		 
	}
	class Result{
				float pitch;
				float roll;
	}
	

}
