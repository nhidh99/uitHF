package com.example.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.BeerExpert;

@SuppressWarnings("serial")
public class BeerSelect extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException
    {
        response.setContentType("text/html");
        var color = request.getParameter("color");
        var size = request.getParameter("size");
        var brands = new BeerExpert().getBrands(color);
        
        request.setAttribute("color", color);
        request.setAttribute("size", size);
        request.setAttribute("styles", brands);
        
        var view = request.getRequestDispatcher("result.jsp");
        view.forward(request, response);
    }
} 