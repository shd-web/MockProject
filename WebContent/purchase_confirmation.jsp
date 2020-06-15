<!-- 住所と配送方法の確認画面（３） -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="./ForAll.css">
<meta charset="UTF-8">
<title>Purchase Confirmation</title>
</head>
<%@include file = "header.jsp" %>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String shipping = request.getParameter("shipping");
	%>
	<h2>確認画面</h2>

	<p>
	氏名：<%= name%><br>
	住所：<%= address%><br>
	配送方法：<%= shipping%><br><br>
	</p>
	<p>以上でよろしいですか？<br><br>

	<form action = "/模擬プロジェクト/purchaseComplete" method = "post">
		<input class = "btn-square" type = "submit" value = "注文を完了">
	</form>
</body>
<%@include file = "footer.jsp" %>
</html>