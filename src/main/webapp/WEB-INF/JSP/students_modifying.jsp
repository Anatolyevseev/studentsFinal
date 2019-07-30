
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="ru">

<head>
    <meta charset="UTF-8">
    <title>Модификация студента</title>
    <link rel="stylesheet" href="CSS/students_style.css">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
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
<form class="modify_title">
    <p>Для модификации значения, введите новые значения и нажмите  кнопку "Применить"</p>
</form>
<form class="mod_form" method="post" action="/students_modifying">
<input type="hidden" name="if" value="${selectedStudent.id}">
    <p style="margin-left: 290px;">Фамилия <input type="text" name="sername" value="${selectedStudent.sername}"></p>
    <p style="margin-left: 316px;">Имя  <input type="text" name="name" value="${selectedStudent.name}"></p>
    <p style="margin-left: 299px;">Группа <input type="text" name="group" value="${selectedStudent.group}"></p>
    <p style="margin-left: 240px;">Дата поступления <input type="text" name="date" id="datepicker" value="${selectedStudent.date}"></p>
    <p style="margin-left: 342px;"><input class="btn_submit" type="submit" value="Применить"></p>
    <c:if test="${error eq '1'}">
        <p class="error">Поля не должны быть пустыми!</p>
    </c:if>
</form>
</body>

</html>

<%--//<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%--<%@ page isELIgnored="false" %>--%>
<%--<!DOCTYPE html>--%>
<%--<html lang="ru">--%>

<%--<head>--%>
    <%--<meta charset="UTF-8">--%>
    <%--<title>Модификация студента</title>--%>
    <%--<link rel="stylesheet" href="CSS/students_style.css">--%>
    <%--<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">--%>
    <%--<script src="https://code.jquery.com/jquery-1.12.4.js"></script>--%>
    <%--<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>--%>
    <%--<script>--%>
        <%--$( function() {--%>
            <%--$( "#datepicker" ).datepicker();--%>
            <%--$( "#format" ).on( "change", function() {--%>
                <%--$( "#datepicker" ).datepicker( "option", "dateFormat", $( this ).val() );--%>
            <%--});--%>
        <%--} );--%>
    <%--</script>--%>
<%--</head>--%>

<%--<body>--%>
<%--<div class="logo_wrap">--%>
    <%--<div class="logo">Система управления студентами и их успеваемостью</div>--%>
    <%--<a href="">Logout</a>--%>
<%--</div>--%>
<%--<div class="back">--%>
    <%--<a href="http://localhost:8080">На главную</a>--%>
    <%--<a class="goback" href="#" onclick="history.back();">Назад</a>--%>
<%--</div>--%>
<%--<form class="modify_title">--%>
    <%--<p>Для модфикации занчения, введите новые значение и нажмите  кнопку "Применить"</p>--%>
<%--</form>--%>
<%--<div class="mod_form" >--%>
    <%--<form method="post" action="/students_modifying">--%>
        <%--<input type="hidden" name="id" value="${id}">--%>
        <%--<p style="margin-left: 267px;">Фамилия <input name="modifiedLastName" value="${selectedStudent.lastName}"></p>--%>
        <%--<p style="margin-left: 293px;">Имя  <input name="modifiedFirstName" value="${selectedStudent.firstName}"></p>--%>
        <%--<p style="margin-left: 275px;">Группа <input name="modifiedGroup" value="${selectedStudent.group}"></p>--%>
        <%--<p style="margin-left: 216px;">Дата поступления <input name="modifiedDate" id="datepicker" autocomplete="off" value="${selectedStudent.date}"></p>--%>
        <%--<p style="margin-left: 318px;"><input class="btn_submit" type="submit" value="Применить"></p>--%>
        <%--<c:if test="${error eq '1'}">--%>
            <%--<p class="error">Поля не должны быть пустыми!</p>--%>
        <%--</c:if>--%>
    <%--</form>--%>

<%--</div>--%>
<%--</body>--%>

<%--</html>--%>

