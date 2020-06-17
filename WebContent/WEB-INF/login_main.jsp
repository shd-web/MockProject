<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ログインメイン画面</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/login.css">
</head>
<body>
<h1>ログイン</h1>
<form action="/模擬プロジェクト/login" method="post">
    <button type="submit"><pre>ログイン</pre></button>
</form>
<hr>
<h1>登録</h1>
<form action="/模擬プロジェクト/registration" method="post">
    <button type="submit"><pre>ユーザ登録</pre></button>
</form>
<hr>
<h1>削除</h1>
<form action="/模擬プロジェクト/delete" method="post">
    <button type="submit"><pre>ユーザ削除</pre></button>
</form>
<hr>
</body>
</html>