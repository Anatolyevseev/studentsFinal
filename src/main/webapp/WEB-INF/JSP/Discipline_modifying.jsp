
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="ru">

<head>
    <meta charset="UTF-8">
    <title>Student management system</title>
    <link rel="stylesheet" href="CSS/students_style.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="/JavaScript/function.js"></script>
</head>

<body>
<div class="logo_wrap">
    <div class="logo">Ð¡Ð¸Ñ�Ñ‚ÐµÐ¼Ð° ÑƒÐ¿Ñ€Ð°Ð²Ð»ÐµÐ½Ð¸Ñ� Ñ�Ñ‚ÑƒÐ´ÐµÐ½Ñ‚Ð°Ð¼Ð¸ Ð¸ Ð¸Ñ… ÑƒÑ�Ð¿ÐµÐ²Ð°ÐµÐ¼Ð¾Ñ�Ñ‚ÑŒÑŽ</div>
    <a href="">Logout</a>
</div>
<div class="back">
    <a href="http://localhost:8080">Ð�Ð° Ð³Ð»Ð°Ð²Ð½ÑƒÑŽ</a>
    <a class="goback" href="#" onclick="history.back();">Ð�Ð°Ð·Ð°Ð´</a>
</div>
<form class="modify_title">
    <p>Ð”Ð»Ñ� Ñ‚Ð¾Ð³Ð¾, Ñ‡Ñ‚Ð¾Ð±Ñ‹ Ð¼Ð¾Ð´Ð¸Ñ„Ð¸Ñ†Ð¸Ñ€Ð¾Ð²Ð°Ñ‚ÑŒ Ð´Ð¸Ñ�Ñ†Ð¸Ð¿Ð»Ð¸Ð½Ñƒ Ð·Ð°Ð¿Ð¾Ð»Ð½Ð¸Ñ‚Ðµ Ð²Ñ�Ðµ Ð¿Ð¾Ð»Ñ� Ð¸ Ð½Ð°Ð¶Ð¼Ð¸Ñ‚Ðµ ÐºÐ½Ð¾Ð¿ÐºÑƒ "Ð¡Ð¾Ð·Ð´Ð°Ñ‚ÑŒ"</p>
</form>

<form class="mod_form" style="padding-top: 20px" method="post" action="/discipline_modify">
    <input type="hidden" name="id" value="${selectedDiscipline.id}">

    <p style="margin-left: 230px;">Ð�Ð°Ð·Ð²Ð°Ð½Ð¸Ðµ <input name="modifiedDiscipline" value="${selectedDiscipline.discipline}"></p>
    <p style="margin-left: 284px;"><input class="btn_submit" type="submit" value="ÐŸÑ€Ð¸Ð¼ÐµÐ½Ð¸Ñ‚ÑŒ"></p>
    <c:if test="${error eq '2'}">
        <p class="error">ÐŸÐ¾Ð»Ñ� Ð½Ðµ Ð´Ð¾Ð»Ð¶Ð½Ñ‹ Ð±Ñ‹Ñ‚ÑŒ Ð¿ÑƒÑ�Ñ‚Ñ‹Ð¼Ð¸!</p>
    </c:if>
</form>

</body>

</html>
