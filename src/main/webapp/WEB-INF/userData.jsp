
<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/header-icons.html"%>


<html>
<head>
    <title> Data of User ${sessionScope.user.login!=null?sessionScope.user.login:"none"}</title>


</head>
<body>
<div class="container"> </div>
<form class="form-horizontal" action="userData.jsp" method="get">
    <fieldset>

        <!-- Form Name -->
        <legend>User data</legend>
        <p style="font-size: 14px">User login: "${sessionScope.get("login")}"</p>
        <br>
        <p style="font-size: 14px">User password: "${sessionScope.get("password")}"</p>
        <br>
        <p style="font-size: 14px">User role: "${sessionScope.get("login")}"</p>
        <br>
        <p style="font-size: 14px">User game status:
            "${sessionScope.get("finalState")==null?"not begin":sessionScope.get("finalState")}"</p>
        <br>

    </fieldset>
</form>
<%@include file="/footer.html"%>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
</body>
</html>
