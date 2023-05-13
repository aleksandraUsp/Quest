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
<form class="form-horizontal">
    <fieldset>

        <!-- Form Name -->
        <legend>Первый квест</legend>

        <!-- Textarea -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="step">Состояние</label>
            <div class="col-md-4">
                <textarea class="form-control" id="step" name="">${requestScope.get("step")}</textarea>
            </div>
        </div>

        <!-- Multiple Checkboxes -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="firstAnswer">Шаг</label>
            <div class="col-md-4">
                <div class="checkbox">
                    <label for="firstAnswer">
                        <input type="checkbox" name="checkboxes" id="firstAnswer" value="${requestScope.get("firstAnswer")}">
                        ${requestScope.get("firstAnswer")}
                    </label>
                </div>
                <div class="checkbox">
                    <label for="secondAnswer">
                        <input type="checkbox" name="checkboxes" id="secondAnswer" value="${requestScope.get("secondAnswer")}">
                        ${requestScope.get("secondAnswer")}
                    </label>
                </div>
            </div>
        </div>

    </fieldset>
</form>
<br>
<br>

<!-- Button -->
<div class="form-group">
    <label class="col-md-4 control-label" for="next"></label>
    <div class="col-md-4">
        <button id="next" name="next"
                class="btn btn-success"> Вперед </button>
    </div>
</div>

<%@include file="/footer.html"%>
</body>
</html>
