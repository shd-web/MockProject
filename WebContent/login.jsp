<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="./LoginMain.css">
<meta charset="UTF-8">
<title>ログイン画面</title>
</head>
<%@include file = "header.jsp" %>
<body>
<form action="login.jsp" method="post">
<h2>ログイン</h2>
メールアドレス：<input type="text" name="loginId" required><br>
　　パスワード：<input type="password" name="pass" required><br>
<input class = "main-button" type="submit" value="ログイン"><br>
</form>
<p>
アカウント登録がお済みでない方はこちらへ↓<br>
<a href="registration.jsp"><button class = "main-button">新規登録</button></a>
</p>
</body>
<%@include file = "footer.jsp" %>
</html>