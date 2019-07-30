
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="ru">

<head>
    <meta charset="UTF-8">
    <title>Создание дисциплины</title>
    <link rel="stylesheet" href="CSS/students_style.css">
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
    <p>Для того, чтобы создать новую дисциплину заполните все поля и нажмите кнопку "Создать"</p>
</form>
<form class="mod_form" method="post" action="/disciplines_creating" style="padding-top: 20px">
    <p style="margin-left: 230px;">Название <input type="text" name="name"></p>
    <p style="margin-left: 284px;"><input class="btn_submit" type="submit" value="Создать"></p>
    <c:if test="${error eq '3'}">
        <p class="error">Поля не должны быть пустыми!</p>
    </c:if>
</form>
</body>

</html>
