

import java.io.IOException;
import java.io.PrintWriter;
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
public class IoTServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at:").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		ServletContext application = this.getServletContext();
		
		ArrayList<String> list = (ArrayList<String>)application.getAttribute("list");
		 if(list==null) {
			 return;
		 }

		 for(String s :list) {
			out.println("<H3>"+s+"</H3>");
		 }
		 
		Result result = (Result) application.getAttribute("Result");
		if(result.Temp >= 27) {
			 response.getWriter().append("BLUE");
		 }else {
			 if(result.pitch <= -170) {
				 response.getWriter().append("GREEN");
			 }else {
				 if(result.pitch >= -4 || result.pitch <= 4) {
					 if(result.roll >= -4 || result.roll <= 4) {
						 response.getWriter().append("RED");
					 }else {
						 response.getWriter().append("NONE");
					 }
				 }else {
					 response.getWriter().append("NONE");
				 }
			 }
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
		 String json = content;
		 Gson gson = new Gson();
		 Result result = gson.fromJson(json, Result.class);
		 application.setAttribute("list", list);
		 application.setAttribute("Result", result);
		 if(result.Temp >= 27) {
			 response.getWriter().append("BLUE");
		 }else {
			 if(result.pitch <= -170) {
				 response.getWriter().append("GREEN");
			 }else {
				 if(result.pitch >= -4 || result.roll >= -4) {
					 if(result.pitch <= 4 || result.roll <= 4) {
						 response.getWriter().append("RED");
					 }else {
						 response.getWriter().append("NONE");
					 }
				 }else {
					 response.getWriter().append("NONE");
				 }
			 }
		 }
		 
		
	}
}
class Result{
	Float roll;
	Float pitch;
	Float Press;
	Float Temp;
	Float Humi;
	String name;
}
