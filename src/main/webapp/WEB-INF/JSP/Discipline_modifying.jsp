<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="eng">

<head>
    <meta charset="UTF-8">
    <title>Discipline modification</title>
    <link rel="stylesheet" href="CSS/students_style.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="/JavaScript/function.js"></script>
</head>

<body>
<div class="logo_wrap">
    <div class="logo">Students management system</div>
    <a href="">Logout</a>
</div>
<div class="back">
    <a href="http://localhost:8080">To main</a>
    <a class="goback" href="#" onclick="history.back();">Backward</a>
</div>
<form class="modify_title">
    <p>For discipline modification,fill out all the field and press "Create"</p>
</form>

<form class="mod_form" style="padding-top: 20px" method="post" action="/discipline_modify">
    <input type="hidden" name="id" value="${selectedDiscipline.id}">

    <p style="margin-left: 230px;">Name <input name="modifiedDiscipline" value="${selectedDiscipline.discipline}"></p>
    <p style="margin-left: 284px;"><input class="btn_submit" type="submit" value="Apply"></p>
    <c:if test="${error eq '2'}">
        <p class="error">Fields can't be empty!</p>
    </c:if>
</form>

</body>

</html>

