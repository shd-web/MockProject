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
<c:choose>
<c:when test="${account.role == 2 }">
登録内容の確認
<p>　　　名前：<c:out value="${account.name }"></c:out></p>
<p>パスワード：<c:out value="${account.pass }"></c:out></p>

<p><a href="/itemSearch"><button type="button" >トップページへ</button></a></p>
</c:when>
<c:when test="${account.role == 1 }">
<a href="/admin">管理者ページへ</a>
</c:when>
<c:otherwise>
<a href="/login">ログインページへ</a>
</c:otherwise>
</c:choose>

</body>
</html>
