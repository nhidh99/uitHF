<!DOCTYPE html>
<html>
  <head>
    <title>Beer Select</title>
  </head>
  <body>
    <h1>Beer Select</h1>
    <%
    	  String color = (String)request.getSession().getAttribute("color");
    	  String size = (String)request.getSession().getAttribute("size");
        out.println("<p>You choose beer with color " + color + " and size " + size + "</p>");
    %>
    <%! int x = 0; %>
    <em>This page has served <%= ++x %> cups of beer</em>
    <br/><br/>
    <a href="form1.html">Choose another beer</a>
  </body>
</html>