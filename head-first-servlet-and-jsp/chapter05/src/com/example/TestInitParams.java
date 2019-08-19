package com.example;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class TestInitParams extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException 
	{
		response.setContentType("text/html");
		var out = response.getWriter();
		
		/*
		var servletConfig = getServletConfig();
		var adminEmail = servletConfig.getInitParameter("adminEmail");
		var mainEmail = servletConfig.getInitParameter("mainEmail");
		out.println("<h1>Test Init Parameters</h1>");
		out.println("Admin Email: " + adminEmail + "<br>");
		out.println("Main Email: " + mainEmail + "<br>");
		*/

		var servletContext = getServletContext();
		var adminEmail = (Email)servletContext.getAttribute("adminEmailObject");
		var mainEmail = (Email)servletContext.getAttribute("mainEmailObject");
		
		out.println("<h1>Test Init Object</h1>");
		out.println("Admin Email: " + adminEmail.getEmail() + "<br>");
		out.println("Main Email: " + mainEmail.getEmail() + "<br>");
	}
}