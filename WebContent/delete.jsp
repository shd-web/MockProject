<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="Account.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>退会画面</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/LoginMain.css">
</head>
<%@include file = "header.jsp" %>
<body>
<h2>退会</h2>
<form action="./UserDelServlet" method="post">
	メールアドレス<input class = "body-input" type="text" name="id"  /><br>
		　　パスワード<input class = "body-input" type="password" name="password" /><br>
     <input class = "main-button" type="submit" value="削除">
</form>
<%
    String error = (String)request.getAttribute("error");
    if (error != null) {
%>
    <p style="color:red; font-size: larger;"><%= error %></p>
<%   } %>
<br>
<hr>
<form action="login_main.jsp" method="post">
    <button class = "main-button" type="submit"><pre>戻る</pre></button>
</form>
</body>
<%@include file = "footer.jsp" %>
</html>