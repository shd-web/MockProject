<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import = "JavaBeans.AccountsBeans" %>
<!DOCTYPE html>
<%
	AccountsBeans returnAb = (AccountsBeans)session.getAttribute("account");
	System.out.println("name in 詳細画面"+returnAb.getName());
%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="./ForAll.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%@include file = "header.jsp" %>
<body>

<h2>会員情報詳細</h2>
		<hr>
		<table>
		<tr bgcolor = "white"><th>ID（メールアドレス）</th><th>氏名</th><th>パスワード</th><th>住所</th></tr>
		<tr><td class = table><%=returnAb.getId() %></td>
			<td><%=returnAb.getName() %></td>
			<td><%=returnAb.getPass() %></td>
			<td><%=returnAb.getAddress() %></td>
		</tr>

        </table>
</body>
<%@include file = "footer.jsp" %>
</html>