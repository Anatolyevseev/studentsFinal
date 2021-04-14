<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib url="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="eng">

<head>
    <meta charset="UTF-8">
    <title>Disciplines</title>
    <link rel="stylesheet" href="CSS/students_style.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="/js/function.js"></script>
</head>

<body>
<div class="logo_wrap">
    <div class="logo">Students management systems</div>
    <a href="">Logout</a>
</div>
<div>
    <div class="back">
        <a href="http://localhost:8080">To main</a>
    </div>
    <form class="modify_title" style="padding-left: 63px">
        <p>Disciplines list </p>
    </form>
</div>

<table class="main" align="left" border="1">
    <tr>
        <th class="td1"></th>
        <th>Discilpline name</th>
    </tr>

    <c:forEach items="${alldisciplines}" var="discipline">
        <tr>
            <td><input type="checkbox" value="${discipline.id}"></td>
            <td class="td2">${discipline.discipline}</td>
        </tr>
    </c:forEach>

</table>
<div class="div_btn" >
    <input class="opt_progress2" style="width: 270px; padding: 3px" type="submit" value="Create discipline..." onclick="javascript:window.location='/disciplines_creating'">
</div>
<div class="div_btn" >
    <form action="/discipline_modify" METHOD="get" id="discipline-modify-form">
        <input type="hidden" name="modifydisc" id="modifyId">
    <input onclick="modifyDiscipline()" class="opt_progress2" style="width: 270px; padding: 3px" type="submit" value="Modify selected discipline..." ">
    </form>

</div>
<div class="div_btn" >
    <input onclick="deleteDiscipline()" class="opt_progress2" style="width: 270px; padding: 3px" type="submit" value="Delete selected discipline...">
</div>

<form action="/disciplines" METHOD="post" id="delete-discipline-form">
 <input type="hidden" name="ids" id="idsDisc">
</form>





</body>

</html>