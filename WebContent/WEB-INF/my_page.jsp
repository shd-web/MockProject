<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="./Account.css">
<meta charset="UTF-8">
<title>ユーザー情報</title>
</head>
<%@ include file = "header.jsp" %>
<body>
<h2>ユーザーページです。</h2><br>
<c:choose>
<c:when test="${account.role == 2 }">
<h3>登録内容の確認</h3>
<p>　　　名前：<c:out value="${account.name }"></c:out></p>
<p>パスワード：<c:out value="${account.pass }"></c:out></p>

<p><a href="/itemSearch"><button class = "main-button-long" type="button" >トップページへ</button></a></p>
</c:when>
<c:when test="${account.role == 1 }">
<a href="/admin">管理者ページへ</a>
</c:when>
<c:otherwise>
<a href="/login">ログインページへ</a>
</c:otherwise>
</c:choose>

</body>
<%@ include file = "footer.jsp" %>
</html>