<%--
  Created by IntelliJ IDEA.
  User: p_zba
  Date: 28.03.2021
  Time: 23:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>Login</h1>

<jstl:if test="${not empty requestScope.notExistsAtLogin}">
    <p>This user not exists</p>
</jstl:if>

<form method="post" action="controller?action=login">
    <p><input type="text" name="name" size="10"/></p>
    <p><input type="password" name="password" size="10" /></p>

    <p><input type="submit" value="Login" /></p>
    <p></p>
</form>
<form method="post" action="register.jsp">
    <input type="submit" value="Register"/>
</form>
</body>
</html>
