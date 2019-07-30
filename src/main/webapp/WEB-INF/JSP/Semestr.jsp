
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="ru">

<head>
    <meta charset="UTF-8">
    <title>Семестры</title>
    <link rel="stylesheet" href="CSS/students_style.css">

</head>

<body>
<div class="logo_wrap">
    <div class="logo">Система управления студентами и их успеваемостью</div>
    <a href="">Logout</a>
</div>
<div>
    <div class="back">
        <a href="http://localhost:8080">На главную</a>
    </div>
</div>
<form style="padding-left: 216px">
    <p style="padding: 10px">
        Выбрать семестр
        <select class="opt_progress1">
            <c:forEach items="${semestrs}" var="s">
            <option value="${s.id}">${s.term}</option>
            </c:forEach>
        </select>
    </p>
        <form action="/disciplines" method="get">
        <input class="opt_progress2" type="submit" name="idSemestr" value="${s.id}">
        </form>

    <p style="padding-left: 10px">
        Длительность семестр: ${selectedSemestr.duration}
    </p>
</form>
<table class="main" class="main" align="left" border="1">
    <caption>Список дисциплин семестра</caption>
    <tr>
        <th>Наименование дисциплины</th>
    </tr>
    <c:forEach items="${alldisciplines}" var="discipline">
    <tr>
        <td class="td1">${discipline.discipline}</td>
    </tr>
    <tr>
        </c:forEach>
</table>
<div style="padding-top: 38px">
    <div class="div_btn">
        <form action="/semestr_creating" method="get">
        <input class="opt_progress2" style="width: 270px; padding: 3px" type="submit" value="Создать семестр..." onclick="javascript:window.location='terms_creating.html'">
        </form>
    </div>
    <div class="div_btn">
    <form action="/term_modifying" method="get">
        <input type="hidden" name="idModifyTerm" id="idModifyTerm" value="${selectedSemestr.id}">


        <input class="opt_progress2" style="width: 270px; padding: 3px" type="submit" value="Модифицировать текущий семестр..." >
    </form>
    </div>
    <div class="div_btn">
        <input class="opt_progress2" style="width: 270px; padding: 3px" type="submit" value="Удалить текущий семестр">
    </div>
</div>




</body>
</html>

