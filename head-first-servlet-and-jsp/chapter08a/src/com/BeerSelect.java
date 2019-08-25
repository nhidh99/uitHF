package com;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class BeerSelect extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException 
	{	
		var name = request.getParameter("name");
		var age = request.getParameter("age");
		var color = request.getParameter("color");
		var result = BeerExpert.selectBeerByColor(color);
		
		request.setAttribute("name", name);
		request.setAttribute("age", age);
		request.setAttribute("result", result);
		
		var view = request.getRequestDispatcher("result.jsp");
		view.forward(request, response);
	}
}