<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="ru">

<head>
    <meta charset="UTF-8">
    <title>Успеваемость студента</title>
    <link rel="stylesheet" href="CSS/students_style.css">
</head>

<body>
<div class="logo_wrap">
    <div class="logo">Система управления студентами и их успеваемостью</div>
    <a href="">Logout</a>
</div>
<div class="back">
    <a href="title_page.html">На главную</a>
    <a class="goback" href="#" onclick="history.back();">Назад</a>
</div>
<form class="modify_title">
    <p>Отображена успеваемость для следующего студента: </p>
</form>
<table class="main" border="1">
    <tr class="table_prgs">
        <th class="table_prgs">Фамилия</th>
        <th class="table_prgs">Имя</th>
        <th class="table_prgs">Группа</th>
        <th class="table_prgs">Дата поступления</th>
    </tr>
    <c:forEach items="${student}" var="student">
    <tr>
        <td class="table_prgs">${student.sername}</td>
        <td class="table_prgs">${student.name}</td>
        <td class="table_prgs">${student.group}</td>
        <td class="table_prgs">${student.date}</td>
    </tr>
    </c:forEach>
</table>

<table class="main" style="float: left" border="1">
    <tr>
        <th class="tb_progress1">Дисциплина</th>
        <th class="tb_progress2">Оценка</th>
    </tr>

    <tr>
        <td class="tb_progress1">Информатика</td>
        <td class="tb_progress2">5</td>
    </tr>

</table>
<form class ="form_semestr">
    <p style="padding: 10px">
        Выбрать семестр
        <select class="opt_progress1">
            <option value="1">Семестр1</option>
            <option value="2">Семестр2</option>
            <option value="3">Семестр3</option>
        </select>
        <input class="opt_progress2" type="submit" value="выбрать">
    </p>
    <p style="padding: 10px">
        Средняя оценка за семестр: 4,8 балла.
    </p>

</form>
</body>

</html>
