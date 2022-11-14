

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class IoTServlet3
 */
@WebServlet("/iot3")
public class IoTServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IoTServlet3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String json = "{\"USER\":\"yoshzawa\",\"MESSAGE\":\"Hello\",\"VALUE\":0.8}";
		response.getWriter().append("JSON:["+json+"]");
		Gson gson = new Gson();
		Result result = gson.fromJson(json, Result.class);
		response.getWriter().append(" USER:["+result.USER+"]");
		response.getWriter().append(" MESSAGE:["+result.MESSAGE+"]");
		response.getWriter().append(" VALUE:["+result.VALUE+"]");
		
	}

	class Result{
		String USER;
		String MESSAGE;
		Float VALUE;
	}
	
}
