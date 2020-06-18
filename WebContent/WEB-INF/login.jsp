<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="./Account.css">
<meta charset="UTF-8">
<title>ログイン画面</title>
</head>
<%@ include file = "header.jsp" %>
<body>
<form action="/模擬プロジェクト/AccountSearch" method="post">
ID（メールアドレス）：<input type="text" name="id" required><br>
　　　　　パスワード：<input type="password" name="pass" required><br>
<input class = "main-button" type="submit" value="ログイン"><br>
</form>
<p>
アカウント登録がお済みでない方はこちらへ↓<br>
<a href="/模擬プロジェクト/registration"><button class = "main-button">新規登録</button></a>
</p>
</body>
<%@ include file = "footer.jsp" %>
</html>