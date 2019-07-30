
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="ru">

<head>
    <meta charset="UTF-8">
    <title>Модификация семестра</title>
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

    <p>Для модификации семестра отредактируйте данные и нажмите кнопку "Применить"</p>
</form>
<form class="mod_form" style="padding-top: 20px" method="post" action="/term_modifying">
    <input type="hidden" name="idselectedTerm" value="${selectedTerm.id}">
    <p style="margin-left: 230px;">Длительность (в неделях) <input value="${selectedTerm.duration}" name="modifiedDuration"></p>
    <select class="opt_progress1" name="modifiedDisciplinesId" multiple style="margin-left: 373px; width: 173px">
        <c:forEach items="${allDisciplines}" var="d">
        <option>${d.discipline}</option>
        </c:forEach>
    </select>
    <p style="margin-left: 374px;"><input class="btn_submit" type="submit" value="Применить"></p>
</form>

<c:if test="${error eq '1'}">
    <p class="error">Поля не должны быть пустыми!</p>
</c:if>
</body>

</html>

