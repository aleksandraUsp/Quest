<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/header-icons.html" %>
<html>
<head>
    <title>ИТОГ КВЕСТА</title>
</head>
<body>
<form class="form-horizontal" action="/final" method="get">
    <fieldset>

        <!-- Form Name -->
        <legend>Итоговая страница</legend>
        <p style="font-size: 14px">Шаг ${sessionScope.get("numberOfStep")}</p>
        <br>
        <p style="font-size: 14px">Состояние</p>
        <br>
        <p style="font-size: 14px"> ${sessionScope.get("finalStateString")}</p>
        <!-- Textarea -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="step">Состояние</label>
            <div class="col-md-4">
                <textarea style="font-size: 14px" class="form-control" id="step" name="finalStateString">
                    ${sessionScope.get("finalStateString")}
                   </textarea>
            </div>
        </div>

        <br>
        <a href="firstQuest" style="font-size: 14px">Начать квест</a>
        <br>
        <a href="" style="font-size: 14px">Главная страница</a>

        <%@include file="/footer.html" %>

</body>
</html>
