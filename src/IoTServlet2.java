

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
		String content = request.getReader().readLine();
		Gson gson = new Gson();
		Result result = gson.fromJson(content,Result.class);
		float pitch = result.pitch;
		float roll = result.roll;
		
		if((pitch < -175)) {
			response.getWriter().append("GREEN");
		}else if(((pitch < 10) && (pitch > -45)) || ((roll < 15)&& (roll >-15))) {
			response.getWriter().append("RED");
		}else {
			response.getWriter().append("NONE");
		}
		
		
		
		
		//ServletContext application = this.getServletContext();

		 /*ArrayList<String> list = (ArrayList<String>)application.getAttribute("list");
		 if(list == null) {
			 list = new ArrayList<String>();
		 }
		 list.add("host["+host+"] user["+user+"] content=["+content+"]");
		 application.setAttribute("list", list);
		*/
		
		
	}
	
}



class Result{
	float roll;
	float pitch;
}

