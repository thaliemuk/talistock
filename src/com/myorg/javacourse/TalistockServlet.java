package com.myorg.javacourse;
import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class TalistockServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		int num1 = 4, num2 = 3, num3 = 7,
		result = num3 *(num1+num2);
		String resultStr = new String("<h1>Result of: " +num3+ " *( " +num1+" + "+ num2 +") = "+result+"</h1>");

		resp.setContentType("text/html"); 
		resp.getWriter().println(resultStr);
	}
}
