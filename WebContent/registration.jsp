<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="./LoginMain.css">
<meta charset="UTF-8">
<title>新規登録画面</title>
</head>
<%@include file = "header.jsp" %>
<body>
<h2>アカウント登録</h2>
<form action="registration_success.jsp" method="post">
<p>すべて入力してください</p>
<p>
<input class ="radio-input" id = "a" type="radio" name="role" value="1"><label for = "a">管理者で登録する</label>
<input class ="radio-input" id = "b" type="radio" name="role" value="2" checked><label for = "b">ユーザーで登録する</label>
</p>
　　　名前：<input type="text" name="name" required><br>
ユーザーID：<input type="text" name="loginId" required><br>
パスワード：<input type="password" name="pass" required><br>
<input class = "main-button" type="submit" value="登録"><br>
</form>
</body>
<%@include file = "footer.jsp" %>
</html>