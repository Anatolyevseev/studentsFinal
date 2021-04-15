
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="eng">

<head>
    <meta charset="UTF-8">
    <title>Discipline Creation</title>
    <link rel="stylesheet" href="CSS/students_style.css">
</head>

<body>
<div class="logo_wrap">
    <div class="logo">Students management system</div>
    <a href="">Logout</a>
</div>
<div class="back">
    <a href="http://localhost:8080">To main</a>
    <a class="goback" href="#" onclick="history.back();">Go Back</a>
</div>
<form class="modify_title">
    <p>For new discipline creation,fill out all fields and press "Create"</p>
</form>
<form class="mod_form" method="post" action="/disciplines_creating" style="padding-top: 20px">
    <p style="margin-left: 230px;">Name <input type="text" name="name"></p>
    <p style="margin-left: 284px;"><input class="btn_submit" type="submit" value="Create"></p>
    <c:if test="${error eq '3'}">
        <p class="error">Fields can't be empty!</p>
    </c:if>
</form>
</body>

</html>
