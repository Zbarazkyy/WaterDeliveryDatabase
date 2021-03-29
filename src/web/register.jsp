<%--
  Created by IntelliJ IDEA.
  User: p_zba
  Date: 25.03.2021
  Time: 12:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Register</title>
   </head>
<body>
<h1>Register</h1>

<jstl:if test="${not empty requestScope.notAdd}">
    <p>This user is exists</p>

</jstl:if>

<form method="post" action="controller?action=register">
    <p><input type="text" name="name" size="10"/></p>
    <p><input type="password" name="password" size="10" /></p>
    <p>
        <select size="2" name="admin">
            <option value = "true">Admin</option>
            <option value = "false">User</option>
        </select>
    </p>
    <p><input type="submit" value="Register" /></p>
    <p></p>
</form>

</body>
</html>
