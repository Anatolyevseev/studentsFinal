<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="ru">

<head>
    <meta charset="UTF-8">
    <title>Список всех студентов</title>
    <link rel="stylesheet" href="CSS\students_style.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="/js/function.js"></script>
</head>

<body>
<div class="logo_wrap">
    <div class="logo">Система управления студентами и их успеваемостью</div>
    <a href="">Logout</a>
</div>
<div class="back">
    <a href="http://localhost:8080">На главную</a>
</div>
<form class="btn_form1">
    <input type="button" class="btn1" value="Просмотреть успеваемость выбранных студентов" onclick="javascript:window.location='/students_progress'">
    <c:if test="${role eq 1}">
    <input type="button" class="btn2" value="Создать студента..." onclick="javascript:window.location='/students_creating'">
    </c:if>
</form>
<div class="btn_form1">
        <form action="/students_modifying" METHOD="get" id="student-modify-form">
            <input type="hidden" name="modifyst" id="modifystId">
            <input onclick="modifyStudent()" type="submit" class="btn1" value="Модифицировать выбранного студента">
        </form>
    </div>
<div class="btn_form1">
    <form action="/students" method="post" id="delete-student-form">
        <input type="hidden" name="idstudent" id="idstud">
        <input onclick="deleteStudent()" type="button" class="btn2" value="Удалить выбранных студентов" >
    </form>
</div>

<table class="main" class="main" border="1">
    <caption>Список студентов</caption>
    <tr>
        <th class="td1"></th>
        <th>Фамилия</th>
        <th>Имя</th>
        <th>Группа</th>
        <th>Дата поступления</th>
    </tr>
    <c:forEach items="${allstudents}" var="student">
    <tr>
        <td class="td1"><input type="checkbox" value="${student.id}"></td>
        <td >${student.sername}</td>
        <td>${student.name}</td>
        <td>${student.group}</td>
        <td>${student.date}</td>
    </tr>
    </c:forEach>
</table>



</body>

</html>


