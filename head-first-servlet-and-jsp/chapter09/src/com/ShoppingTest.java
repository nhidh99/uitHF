package com;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class ShoppingTest extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException 
	{
		response.setContentType("text/html");
		String[] items = request.getParameterValues("items");
		String contact = request.getParameter("contact");
		
		request.setAttribute("items", items);
		request.setAttribute("contact", contact);
		
		var view = request.getRequestDispatcher("result.jsp");
		view.forward(request, response);
	}
}