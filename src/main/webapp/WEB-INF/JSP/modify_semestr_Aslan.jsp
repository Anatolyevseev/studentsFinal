<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="ru">

<head>
    <meta charset="UTF-8">
    <title>Модификация семестра</title>
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
<div class="modify_title">
    <p>Для модификации семестра отредактируйте данные и нажмите кнопку "Применить"</p>
</div>
<div class="mod_form" style="padding-top: 20px">
    <form method="post" action="/term_modifying">
        <p style="margin-left: 230px;">Длительность (в неделях) <input type="text" name="modifiedDuration" value="${selectedTerm.duration}"></p>
        <input type="hidden" name="id" value="${selectedTerm.id}">
        <select class="opt_progress1" name="modifiedDisciplinesId" multiple style="margin-left: 373px; width: 173px">
            <c:forEach items="${allDisciplines}" var="disciplines">
                <option value="${disciplines.id}">${disciplines.discipline}</option>
            </c:forEach>
        </select>
        <p style="margin-left: 374px;"><input class="btn_submit" type="submit" value="Применить"></p>
        <c:if test="${error eq '1'}">
            <p class="error">Поля не должны быть пустыми!</p>
        </c:if>
    </form>
</div>
</body>

</html>