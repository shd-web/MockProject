<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ユーザ削除</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/login.css">
</head>
<body>
<h1>ユーザ削除</h1>
<form action="/模擬プロジェクト/AccountCheck" method="post">
    <table>

        <tr>
            <th>ID（メールアドレス）</th>
            <th>パスワード</th>
            <th></th>
        </tr>
        <tr>
            <td><input type="text" name="id"  /></td>
            <td><input type="password" name="pass" /></td>
            <td><input type="submit" value="削除"></td>
        </tr>
    </table>
</form>
<%
    String error = (String)request.getAttribute("error");
    if (error != null) {
%>
    <p style="color:red; font-size: larger;"><%= error %></p>
<%   } %>
<br>
<hr>
<form action="/模擬プロジェクト/login/main" method="post">
    <button type="submit"><pre>戻る</pre></button>
</form>
</body>
</html>