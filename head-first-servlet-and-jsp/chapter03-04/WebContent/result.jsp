<%@ page import="java.util.*" %>
<html>
  <body>
    <h1>Beer Recommendations JSP</h1>
    <p>
        <%
        	String color = (String)request.getAttribute("color");
        	String size = (String)request.getAttribute("size");
        	out.print("<h2>Recommend beer with color " + color + " and size " + size + "</h2>");
        	
            List<String> styles = (List<String>)request.getAttribute("styles");
        	for (String s : styles) {
        		out.print("<br>try: " + s);
        	}
        %>
    </p>
  </body>
</html>