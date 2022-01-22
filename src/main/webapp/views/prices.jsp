<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: yerch
  Date: 22.01.2022
  Time: 6:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Prices</title>
</head>
<body>
<table>
    <tr>
        <th>Prices for ${carrency}</th>
    </tr>
    <c:forEach var="p" items="${prices}">
        <tr>
            <td>${p}$</td>
        </tr>
    </c:forEach>
</table>
<a href="/">Back</a>

</body>
</html>
