<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import = "JavaBeans.AccountsBeans" %>
<!DOCTYPE html>
<%
	AccountsBeans returnAb = (AccountsBeans)session.getAttribute("account");
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>
		ID（メールアドレス）　<%=returnAb.getId() %><br>
        氏名　　　　　　　　　<%=returnAb.getName() %><br>
        パスワード　　　　　　<%=returnAb.getPass() %><br>
        住所　　　　　　　　　<%=returnAb.getAddress() %>
    </p>
</body>
</html>