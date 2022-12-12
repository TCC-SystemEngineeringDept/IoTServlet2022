

import java.io.IOException;
import java.io.PrintWriter;

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
@WebServlet("/iot7")
public class IoTServlet7 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		ServletContext application = this.getServletContext();
		String list =  (String) application.getAttribute("list");
		
		 String json = list;
		 Gson gson = new Gson();
			Result result = gson.fromJson(json, Result.class);
			double roll = result.roll;
			out.println(roll);
			//double roll = -172;

			 if ((roll >= 100) || (roll<= -160)) {
					response.getWriter().append("GREEN");
					
				}else if(roll  >= -1) {
					response.getWriter().append("RED");
					
				}else{
					response.getWriter().append("NONE");
					
				}
				
			}
		
	
			
			


protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String content = request.getReader().readLine();
	Gson gson = new Gson();
	Result result = gson.fromJson(content, Result.class);//Jsonをインスタンスに 
	
	ServletContext application = this.getServletContext();

	 application.setAttribute("list", content);
	 
	 double roll = result.roll;
	
	 
	  
	 if ((roll >= 100) || (roll<= -160)) {
		 response.getWriter().append("GREEN");
				
		}else if(roll  <= 5) {
			response.getWriter().append("RED");
			
		}
		else{
			response.getWriter().append("NONE");
			
		}
		
	}

}

class Result{
	double roll;
	double pitch;
}


