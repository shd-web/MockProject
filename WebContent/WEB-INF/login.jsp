<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
<link rel="stylesheet" href="ForAll.css" type="text/css" />
</head>
<%@include file = "open_header.jsp" %>
<body>
<form action="/模擬プロジェクト/AccountSearch" method="post">
ID（メールアドレス）：<input type="text" name="id" required><br>
パスワード：<input type="password" name="pass" required><br>
<input type="submit" value="ログイン"><br>
</form>
<p>
アカウント登録がお済みでない方はこちらへ↓<br>
<a href="/模擬プロジェクト/registration"><button>新規登録</button></a>
</p>
</body>
<%@include file = "footer.jsp" %>
</html>