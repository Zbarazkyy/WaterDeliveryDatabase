<%--
  Created by IntelliJ IDEA.
  User: p_zba
  Date: 25.03.2021
  Time: 12:27
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Main</title>
</head>
<body>
<p><h3>User: <jstl:out value="${sessionScope.user.userName}"/></h3></p>
<p><a href="controller?action=logout">Logout</a></p>

<h1>Add client</h1>

<form method="post" action="controller?action=addClients">
    <p> Name: <input type="text" name="fname" size="10"/>
        Surname: <input type="text" name="lname" size="10"/></p>
    <p> City: <input type="text" name="city" size="10"/>
        Street: <input type="text" name="street" size="10"/>
        House: <input type="text" name="house" size="10"/>
        Flat: <input type="text" name="flat" size="10"/>
        Notes:<input type="text" name="notes" size="10"/></p>
    <p> Phone: <input type="text" name="phone1" size="10"/>
        Phone: <input type="text" name="phone2" size="10"/>
        Phone: <input type="text" name="phone3" size="10"/></p>

    <p><input type="submit" value="Add Clients"/>
    </p>

</form>
<form method="post" action="controller?action=ordersList">
    <input type="submit" value="Add Order"/>
</form>
<p></p>
<p></p>
<p></p>
<h2>Clients List</h2>
<table border="2">

    <tr>
        <th>#</th>
        <th>Name</th>
        <th>Surname</th>
        <th>City</th>
        <th>Street</th>
        <th>House</th>
        <th>Flat</th>
        <th>Notes</th>
        <th>Phone</th>
        <th>Phone</th>
        <th>Phone</th>
    </tr>

    <jstl:forEach var="clip" items="${requestScope.clientsList}">
        <tr>
            <td><jstl:out value="${clip.clientId}"/></td>
            <td><jstl:out value="${clip.fName}"/></td>
            <td><jstl:out value="${clip.lName}"/></td>
            <td><jstl:out value="${clip.addressCity}"/></td>
            <td><jstl:out value="${clip.addressStreet}"/></td>
            <td><jstl:out value="${clip.addressHouse}"/></td>
            <td><jstl:out value="${clip.addressFlat}"/></td>
            <td><jstl:out value="${clip.addressNotes}"/></td>
            <td><jstl:out value="${clip.phone1}"/></td>
            <td><jstl:out value="${clip.phone2}"/></td>
            <td><jstl:out value="${clip.phone3}"/></td>
        </tr>
    </jstl:forEach>
</table>
</body>
</html>
