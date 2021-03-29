<%--
  Created by IntelliJ IDEA.
  User: p_zba
  Date: 26.03.2021
  Time: 11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Items</title>
</head>
<body>
<p><h1>User: <jstl:out value="${sessionScope.user.userName}"/></h1></p>
<h1>Items</h1>

<table border="2">
    <tr>
        <th>#</th>
        <th>Item</th>
        <th>Price</th>
    </tr>

    <jstl:forEach var="clip" items="${requestScope.itemsList}">
        <tr>
            <td><jstl:out value="${clip.itemId}"/></td>
            <td><jstl:out value="${clip.item}"/></td>
            <td><jstl:out value="${clip.itemPrice}"/></td>
        </tr>
    </jstl:forEach>
</table>

</body>
</html>
