package src;

import java.io.IOException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IoTServlet
 */
@WebServlet("/iot")
public class IoTServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Connected.");
		Map<String, String[]> params = request.getParameterMap();
		for(String key : params.keySet()) {
			System.out.println("key["+key+"]");
			for(String value : params.get(key)) {
				System.out.println("value["+key+"]");
			}
		}
		Enumeration<String> headerName = request.getHeaderNames();
		for(String key : Collections.list(headerName)) {
			System.out.println("header["+key+"]");
			String value = request.getHeader(key);
			System.out.println("value["+value+"]");
		}
		String content = request.getReader().readLine();
		System.out.println(content);
		
	}

}
