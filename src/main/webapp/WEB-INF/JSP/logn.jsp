<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="eng">

<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="/CSS/logn.css">
</head>

<body>
<div class="signin">
    <form action="/login" method="post">
        <h2 class="color: white">UserName</h2>
        <input type="text" name="username" placeholder="UserName">
        <input type="password" name="pass" placeholder="Password"><br><br>
<%--        <a href="/index.jsp">--%>
            <input type="submit" value="Login"><br>
        <br>
        <div id="container">
            <a href="/re" style="margin-right: 0px; font-size: 13px; font-family: Tahoma, Geneva, sans-serif;">Change password</a>
            <a href="/for" style="margin-right: 0px; font-size: 13px; font-family: Tahoma, Geneva, sans-serif;">Restore password</a>
        </div><br><br><br><br><br><br>
        Not registered?<a href="/sgnup">&nbsp;Registration</a>
    </form>
</div>
</body>

</html>
