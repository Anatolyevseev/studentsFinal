
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="ru">

<head>
    <meta charset="UTF-8">
    <title>Модификация дисциплины</title>
    <link rel="stylesheet" href="CSS/students_style.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="/JavaScript/function.js"></script>
</head>

<body>
<div class="logo_wrap">
    <div class="logo">Система управления студентами и их успеваемостью</div>
    <a href="">Logout</a>
</div>
<div class="back">
    <a href="http://localhost:8080">На главную</a>
    <a class="goback" href="#" onclick="history.back();">Назад</a>
</div>
<form class="modify_title">
    <p>Для того, чтобы модифицировать дисциплину заполните все поля и нажмите кнопку "Создать"</p>
</form>

<form class="mod_form" style="padding-top: 20px" method="post" action="/discipline_modify">
    <input type="hidden" name="id" value="${selectedDiscipline.id}">

    <p style="margin-left: 230px;">Название <input name="modifiedDiscipline" value="${selectedDiscipline.discipline}"></p>
    <p style="margin-left: 284px;"><input class="btn_submit" type="submit" value="Применить"></p>
    <c:if test="${error eq '2'}">
        <p class="error">Поля не должны быть пустыми!</p>
    </c:if>
</form>

</body>

</html>
