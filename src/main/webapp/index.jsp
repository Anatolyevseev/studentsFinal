<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Главная страница</title>
    <link rel="stylesheet" href="CSS\students_style.css">
</head>
<body>
<div class="logo_wrap">
    <div class="logo" >Система управления студентами и их успеваемостью</div>
    <c:choose>
        <c:when test="${isLogin eq 1}">
            <a href="">Logout</a>
        </c:when>

        <c:otherwise>
            <a href="/login">Login</a>
        </c:otherwise>
    </c:choose>

    <div class="nav">
        <a href="/students">Студенты</a>
        <a href="/disciplines">Дисциплины</a>
        <a href="/semestr">Семестры</a>
    </div>
</div>


</body>
</html>
