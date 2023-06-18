<%--
  Created by IntelliJ IDEA.
  User: sasha
  Date: 01.04.2023
  Time: 12:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"  %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/header-icons.html"%>
<html>
<head>
    <title>Первый квест</title>
</head>
<body>
<form class="form-horizontal" action="/firstQuest" method="post">


        <!-- Form Name -->
        <legend>Первый квест</legend>
    <br>
        <p>Шаг ${sessionScope.get("numberOfStep")}</p>
    <br>
        <!-- Textarea -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="step">Состояние</label>
            <div class="col-md-4">
                <textarea class="form-control" id="step" name="step">
                    ${requestScope.get("step")}</textarea>
            </div>
        </div>
    <br>
    <input type="radio" name="numberOfFirstAnswer" value="1"/>${requestScope.get("firstAnswer")}
    <br>
    <input type="radio" name="numberOfSecondAnswer" value="2"/>${requestScope.get("secondAnswer")}


<!-- Button first answer-->
<c:if test="${sessionScope.numberOfStep<=2}">
<div class="form-group">
    <label class="col-md-4 control-label" for="firstAnswer"></label>
    <div class="col-md-4">
        <button type="submit" id="firstAnswer" name="numberOfFirstAnswer" value="1"
                class="btn btn-success"> ${requestScope.get("firstAnswer")} </button>
    </div>
</div>
</c:if>

<!-- Button second answer-->
<c:if test="${sessionScope.numberOfStep<=2}">
<div class="form-group">
    <label class="col-md-4 control-label" for="secondAnswer"></label>
    <div class="col-md-4">
        <button type="submit" id="secondAnswer" name="numberOfSecondAnswer" value="2"
                class="btn btn-success"> ${requestScope.get("secondAnswer")} </button>
    </div>
</div>
</c:if>

        <!-- Button go to Final quest page-->

        <div class="form-group">
            <label class="col-md-4 control-label" for="goToFinal"></label>
            <div class="col-md-4">
                <button type="submit" id="goToFinal" name="numberOfStep" value="${sessionScope.get("numberOfStep")}"
                        class="btn btn-success"> Вперед </button>
            </div>
        </div>



<%@include file="/footer.html"%>

</body>
</html>