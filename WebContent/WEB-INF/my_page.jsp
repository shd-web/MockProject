<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー情報</title>
</head>
<body>
ここはユーザーページです。<br>
<form action="/模擬プロジェクト/MyAccountCheck" method="post">
    <table>

        <tr>
            <th>ID（メールアドレス）</th>
            <th>パスワード</th>
            <th></th>
        </tr>
        <tr>
            <td><input type="text" name="id"  /></td>
            <td><input type="password" name="pass" /></td>
            <td><input type="submit" value="ログイン"></td>
        </tr>
    </table>
</form>
<p><a href="/itemSearch"><button type="button" >トップページへ</button></a></p>
<a href="/login">ログインページへ</a>

</body>
</html>