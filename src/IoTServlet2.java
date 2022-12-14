

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
       
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		//ServletContext application = this.getServletContext();
		//String list =  (String) application.getAttribute("list");
		
		 //String json = list;
		 //Gson gson = new Gson();
			//Result result = gson.fromJson(json, Result.class);
			//double roll = result.roll;
			//out.println(roll);
			//double roll = -172;

			 //if ((roll >= 100) || (roll<= -160)) {
					//response.getWriter().append("GREEN");
					
				//}else if(roll  >= -1) {
					//response.getWriter().append("RED");
					
				//}else{
					//response.getWriter().append("NONE");
					
				//}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		 
		 //list.add("host["+host+"] user["+user+"] content=["+content+"]");
		 //application.setAttribute("list", list);
		
		//String content = request.getReader().readLine();
		//Gson gson = new Gson();
		//Result result = gson.fromJson(content, Result.class);//Jsonをインスタンスに 
		
		//ServletContext application = this.getServletContext();

		 //ArrayList<String> list = (ArrayList<String>)application.getAttribute("list");
		 //if(list == null) {
			// list = new ArrayList<String>();
		 //}
		 //application.setAttribute("list", content);
		 
		// double roll = result.roll;
		 
		 //if ((roll >= 100) || (roll<= -160)) {
				//response.getWriter().append("GREEN");
				
			//}else if((roll  >= -1)||(roll>=100)) {
				//response.getWriter().append("RED");
				
			//}
			//else{
				//response.getWriter().append("NONE");
				
			//}
			
		}
		
	}

