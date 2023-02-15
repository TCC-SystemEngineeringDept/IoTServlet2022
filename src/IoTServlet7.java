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
		double pitch = result.pitch;
		
		 if ((roll <= 10) || (pitch <= 10)) {
				response.getWriter().append("RED");
			
		}else {
			response.getWriter().append("GREEN");
				
			}
			
		}
		

			
			


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		ServletContext application = this.getServletContext();
		String list =  (String) application.getAttribute("list");
		String json = list;
		Gson gson = new Gson();
		Result result = gson.fromJson(json, Result.class);
		double roll = result.roll;
		double pitch = result.pitch;
		
		 if ((roll <= 10) || (pitch <= 10)) {
				response.getWriter().append("RED");
			
		}else {
			response.getWriter().append("GREEN");
				
			}
			
		}
}
class Result{
	double roll;
	double pitch;
}