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
    <title>ИТОГ КВЕСТА</title>
</head>
<body>
<form class="form-horizontal" action="/final" method="post">
    <fieldset>

        <!-- Form Name -->
        <legend>Первый квест</legend>
        <p>Шаг ${sessionScope.get("step")}</p>

        <!-- Textarea -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="step">Состояние</label>
            <div class="col-md-4">
                <textarea class="form-control" id="step" name=${requestScope.get("step")}>
                    ${requestScope.get("step")}</textarea>
            </div>
        </div>

<!-- Button -->
<div class="form-group">
    <label class="col-md-4 control-label" for="firstAnswer"></label>
    <div class="col-md-4">
        <button type="submit" id="firstAnswer" name="${sessionScope.firstAnswer}" value="${sessionScope.step}"
                class="btn btn-success"> ${requestScope.get("firstAnswer")} </button>
    </div>
</div>

<!-- Button -->
<div class="form-group">
    <label class="col-md-4 control-label" for="secondAnswer"></label>
    <div class="col-md-4">
        <button type="submit" id="secondAnswer" name="${sessionScope.secondAnswer}" value="${sessionScope.step}"
                class="btn btn-success"> ${requestScope.get("secondAnswer")} </button>
    </div>
</div>


<!-- Button -->
<div class="form-group">
    <label class="col-md-4 control-label" for="next"></label>
    <div class="col-md-4">
        <button type="submit" id="next" name="next"
                class="btn btn-success"> Вперед </button>
    </div>
</div>

<%@include file="/footer.html"%>

</body>
</html>
