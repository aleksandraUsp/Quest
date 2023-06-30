<%@page contentType="text /html" %>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"   %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"   %>
<%@include file="/header-icons.html"%>

<html>
<head>
    <title>Users</title>
</head>

<body>
<ul>
    <c:forEach var="user" items="${requestScope.users}">
        <li>
             ${user.role}:<a href="user?id=${user.id}">${user.login}</a>
        </li>
        <br>
    </c:forEach>
    <li><a href="user?id=0">Creat new user</a></li>
</ul>
<%@include file="/footer.html"%>
</body>
</html>
