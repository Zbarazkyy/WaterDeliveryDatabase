<%--
  Created by IntelliJ IDEA.
  User: p_zba
  Date: 26.03.2021
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Orders</title>
</head>
<body>

<p><h3>User: <jstl:out value="${sessionScope.user.userName}"/></h3></p>
<p><a href="controller?action=logout">Logout</a></p>

<h1>Choose client and create order </h1>

<form method="post" action="controller?action=addOrder">
    <p> Client: <select name="fName">
        <jstl:forEach var="clip" items="${requestScope.clientsList}">
            <option>${clip.fName}</option>
        </jstl:forEach>
    </select>

        Item: <select name="item" size="1">
            <option value="bottle of water">Бутыль с водой</option>
            <option value="empty bottle">Пустой бутыль</option>
            <option value="water pump">Помпа для воды</option>
        </select>
        Quantity: <input type="text" name="quantity" size="10"/></p>
    <p><input type="submit" value="Add Orders"/></p>
</form>
<p></p>
<form method="post" action="controller?action=clientsList">
    <input type="submit" value="Add Client"/>
</form>
<p></p>
<p></p>

<h1>Orders</h1>
<table border="2">

    <tr>
        <th>#</th>
        <th>Name</th>
        <th>Item</th>
        <th>Quantity</th>
        <th>Data</th>
    </tr>

    <jstl:forEach var="clip" items="${requestScope.ordersList}">
        <tr>
            <td><jstl:out value="${clip.orderId}"/></td>
            <td><jstl:out value="${clip.clientId}"/></td>
            <td><jstl:out value="${clip.itemId}"/></td>
            <td><jstl:out value="${clip.quantity}"/></td>
            <td><jstl:out value="${clip.ordersDate}"/></td>
        </tr>
    </jstl:forEach>
</table>

</body>
</html>
