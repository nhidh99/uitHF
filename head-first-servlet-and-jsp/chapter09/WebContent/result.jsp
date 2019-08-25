<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <title>Magic Shop</title>
    <link type="text/css" rel="stylesheet" href="style.css" />
  </head>

  <body>
    <h1>Magic Shop - Bill</h1>
    <table>
      <caption>
        Your items:
      </caption>
      <tr>
        <th>No.</th>
        <th>Item Name</th>
      </tr>
      <c:forEach var="item" items="${items}" varStatus="itemCount">
        <tr>
          <td><c:out value="${itemCount.count}"/></td>
          <td><c:out value="${item}"/></td>
        </tr>
      </c:forEach>
    </table>
    
    <c:choose>
      <c:when test="${contact == 'owl'}">
        <p>You choose a magical way to contact!</p>
      </c:when>

      <c:otherwise>
        <p>You choose a hoo-man way to contact!</p>
      </c:otherwise>
    </c:choose>
  </body>
</html>
