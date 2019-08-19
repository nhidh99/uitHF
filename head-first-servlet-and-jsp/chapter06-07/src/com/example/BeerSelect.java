package com.example;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class BeerSelect extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException 
	{
		var session = request.getSession();
		var color = request.getParameter("color");
		session.setAttribute("color", color);
		response.sendRedirect("form2.html");
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException 
	{
		var session = request.getSession();		
		var size = request.getParameter("size");
		session.setAttribute("size", size);
		var view = request.getRequestDispatcher("result.jsp");
		view.forward(request, response);				
		session.invalidate();
	}
}