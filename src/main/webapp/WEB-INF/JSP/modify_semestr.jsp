<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="eng">

<head>
    <meta charset="UTF-8">
    <title>Term Modification</title>
    <link rel="stylesheet" href="CSS/students_style.css">

</head>

<body>
<div class="logo_wrap">
    <div class="logo">Students management system</div>
    <a href="">Logout</a>
</div>
<div class="back">
    <a href="title_page.html">To main</a>
    <a class="goback" href="#" onclick="history.back();">Go Back</a>
</div>
<form class="modify_title">

    <p>For term modification change the data and press "Apply"</p>
</form>
<form class="mod_form" style="padding-top: 20px" method="post" action="/term_modifying">
    <input type="hidden" name="idselectedTerm" value="${selectedTerm.id}">
    <p style="margin-left: 230px;">Duration(in weeks) <input value="${selectedTerm.duration}" name="modifiedDuration"></p>
    <select class="opt_progress1" name="modifiedDisciplinesId" multiple style="margin-left: 373px; width: 173px">
        <c:forEach items="${allDisciplines}" var="d">
        <option>${d.discipline}</option>
        </c:forEach>
    </select>
    <p style="margin-left: 374px;"><input class="btn_submit" type="submit" value="Apply"></p>
</form>

<c:if test="${error eq '1'}">
    <p class="error">Fields can't be empty!</p>
</c:if>
</body>

</html>
