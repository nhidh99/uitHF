package com.example;
import javax.servlet.*;

public class MyServletContextListener implements ServletContextListener {
	public void contextInitialized(ServletContextEvent event) {
		var servletContext = event.getServletContext();
		var adminEmailParams = servletContext.getInitParameter("adminEmail").split("@");
		var mainEmailParams = servletContext.getInitParameter("mainEmail").split("@");
		
		var adminEmail = new Email(adminEmailParams[0], adminEmailParams[1]);
		var mainEmail = new Email(mainEmailParams[0], mainEmailParams[1]);
		
		servletContext.setAttribute("adminEmailObject", adminEmail);
		servletContext.setAttribute("mainEmailObject", mainEmail);
	}

	public void contextDestroyed(ServletContextEvent event) {
		
	}
}