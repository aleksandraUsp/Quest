<%@page contentType="text /html" %>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"   %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"   %>
<%@include file="/header-icons.html"%>
<html>
    <head>
        <title>Users</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
              rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
              crossorigin="anonymous"></link>
    </head>

    <body>
        <h3> Список пользователей </h3>
        <c:forEach var="user" items="${requestScope.users}">
            <img src="images/${user.image}" alt="images/${user.image}" width="100px"></img>
        Edit user:    <a href="user?id=${user.id}">${user.login}</a> <br>
        </c:forEach>
        <%@include file="/footer.html"%>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
                crossorigin="anonymous">
        </script>
    </body>
</html>
