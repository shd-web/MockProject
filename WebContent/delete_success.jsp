<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>アカウント削除画面</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Account.css">
</head>
<%@include file = "header.jsp" %>
<body>
<h3>ユーザ削除成功</h3>
<hr>
<%
    String name = (String)request.getAttribute("account_name");
    if (name != null) {
%>
    <p style="color:blue; font-size: larger;"><%= name %>さんの登録を削除しました。</p>
<%   } %>
<br>
<hr>
<form action="/模擬プロジェクト/login/main" method="post">
    <p><button class = "main-button" type="submit"><pre>戻る</pre></button>
</form>
</body>
<%@include file = "footer.jsp" %>
</html>