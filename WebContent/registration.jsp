<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規登録</title>
</head>
<body>
<form action="/模擬プロジェクト/RegistrationTry" method="post">
<p>すべて入力してください</p>

　　　　　　　名前：<input type="text" name="name" value ="中根優里" required><br>
　　　　パスワード：<input type="password" name="pass" value ="yuri" required><br>
　　　　　　　住所：<input type="text" name="address" value="日本" required><br>
メールアドレス（ID)：<input type="text" name="id" value="mail" required><br>
<input type="submit" value="登録"><br>
</form>
</body>
</html>