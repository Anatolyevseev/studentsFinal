
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">

<head>
    <meta charset="UTF-8">
    <title>Вход</title>
    <link rel="stylesheet" href="/CSS/logn.css">
</head>

<body>
<div class="signin">
    <form action="/login" method="post">
        <h2 class="color: white">Учетная запись</h2>
        <input type="text" name="username" placeholder="Логин">
        <input type="password" name="pass" placeholder="Пароль"><br><br>
<%--        <a href="/index.jsp">--%>
            <input type="submit" value="Войти"><br>
        <br>
        <div id="container">
            <a href="/re" style="margin-right: 0px; font-size: 13px; font-family: Tahoma, Geneva, sans-serif;">Изменить пароль</a>
            <a href="/for" style="margin-right: 0px; font-size: 13px; font-family: Tahoma, Geneva, sans-serif;">Восстановить пароль</a>
        </div><br><br><br><br><br><br>
        Нет аккаунта?<a href="/sgnup">&nbsp;Регистрация</a>
    </form>
</div>
</body>

</html>