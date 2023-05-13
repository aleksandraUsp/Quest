<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="/header-icons.html"%>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
          crossorigin="anonymous">
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"   %>
</head>
<body>
<h1>"Квест!"
</h1>
<br>
<h3>Пролог</h3>
<p>Ты стоишь в космическом порту и готов подняться на борт. Разве ты не об этом мечтал?<br>
    Стать капитаном галактического судна с экипажем, который будет совершать подвиги под твоим командованием.<br>
    Так что вперед!</p>
<br>
<br>
<h3>Знакомство с экипажем</h3>
<p>Когда ты поднялся на борт корабля тебя приветствовала девушка с черной папкой в руках:
    <br>
    -Здравствуйте, командир! Я - Зинаида, Ваша помощница! Видите? Там в углу пьет кофе наш штурман,
    <br>
    под штурвалом спит наш бортмеханик, а фотографирует его наш навигатор.</p>
<br>
<br>
<a href="users">All users</a>
<br>
<br>
<a href="firstQuest">Начать квест</a>

<%@include file="/footer.html"%>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
</body>
</html>