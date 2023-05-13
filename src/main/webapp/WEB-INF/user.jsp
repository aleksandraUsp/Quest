
<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/header-icons.html"%>


<html>
<head>
    <title>User ${requestScope.user.login!=null?requestScope.user.login:"none"}</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
          crossorigin="anonymous">

</head>
<body>
<div class="container"> </div>
<form class="form-horizontal" action="user?id=${requestScope.user.id==null?0:requestScope.user.id}" method="post"
      enctype="multipart/form-data">
    <fieldset>

        <!-- Form Name -->
        <legend>User Form</legend>

        <!-- Avatar Input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="image">Avatar</label>
            <div class="col-md-4">
                <input id="image" name="image" class="input-file" type="file" value="">
            </div>
        </div>

        <input type="hidden" name="id" value="${requestScope.user.id}">

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="userLogin">Login</label>
            <div class="col-md-4">
                <input id="userLogin" name="login" type="text" placeholder="set login" class="form-control input-md" required=""
                value="${requestScope.login}">

            </div>
        </div>

        <!-- Password input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="userPassword">Password</label>
            <div class="col-md-4">
                <input id="userPassword" name="password" type="password" placeholder="" class="form-control input-md"
                       required="" value="${requestScope.user.password}">
            </div>
        </div>


        <!-- Button Drop Down -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="role">Role</label>
            <div class="col-md-4">
                <select id="role" name="role" class="form-control">
                    <c:forEach items="${applicationScope.roles}" var="role">
                        <option value="${role}" ${requestScope.user.role==role?"selected":""}>${role}</option>
                    </c:forEach>
                </select>
            </div>
        </div>


        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="submit"></label>
            <div class="col-md-4">
                <button id="submit" name="${requestScope.user.id>0?"update":"create"}"
                        class="btn btn-success">${requestScope.user.id>0?"Update":"Create"}</button>
            </div>
        </div>


        <!-- Button -->
        <c:if test="${requestScope.user.id>0}">
        <div class="form-group">
            <label class="col-md-4 control-label" for="userDelete"></label>
            <div class="col-md-4">
                <button id="userDelete" name="delete" class="btn btn-danger">Delete</button>
            </div>
        </div>
        </c:if>
    </fieldset>
</form>
<%@include file="/footer.html"%>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
</body>
</html>
