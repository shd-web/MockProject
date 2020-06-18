<!-- 住所の選択画面（１） -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "JavaBeans.AccountsBeans"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="./ForAll.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%@include file = "header.jsp" %>
<body>
	<!-- 登録されている住所に届ける -->
	<hr><h2>登録されている住所へ配送</h2>
	<form action = "/模擬プロジェクト/shipping" method="post">

	<%
		//DBに登録されているアカウント名と住所表示
		AccountsBeans ab = (AccountsBeans)session.getAttribute("account");
		String name = ab.getName();
		String address = ab.getAddress();
	%>
		<p><%= name%><br>
		<%= address%></p>
	<input type = "hidden" name = "name" value = <%= name%>>
	<input type = "hidden" name = "address" value = <%= address%>>
	<input class = "btn-square" type = "submit" value = "この住所に届ける" ><br>

	</form>

	<!-- 新しい住所に届ける -->
	<hr><h2>新しい住所へ配送</h2>
	<p>必要事項を入力し、「この住所に届ける」ボタンをクリックしてください。<br><br></p>

	<form action = "/模擬プロジェクト/shipping" method = "post" name = "newAddress">
	住所<input class = "body-input" type = "text" name = "address"><br>
	<input class = "btn-square" type = "submit" value = "この住所に届ける">
	</form>
</body>
<%@include file = "footer.jsp" %>
</html>