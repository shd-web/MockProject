<!-- 配送方法指定画面（２） -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="./ForAll.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%@include file = "header.jsp" %>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		String address = (String)request.getAttribute("address");

	%>
	<h2>配送オプション</h2>
	<form class = "radio" action = "/模擬プロジェクト/purchaseConfirmation" method = "post">
		<input class = "radio-input" id = "a" type ="radio" name = "shipping" value = "通常配送">
		<label for = "a">通常配送</label><br>
		<input class = "radio-input" id = "b" type ="radio" name = "shipping" value = "お急ぎ便　無料" checked="checked">
		<label for = "b">お急ぎ便　無料</label><br>
		<input class = "radio-input" id = "c" type ="radio" name = "shipping" value = "お届け日時指定便　無料">
		<label for = "c">お届け日時指定便　無料</label><br><br>

		<h3>支払方法<br></h3>
		<input type = "radio" checked = "checked">代金引換<br><br>

		<input class = "btn-square" type = "submit" value = "次に進む"><br>
		<input type = "hidden" name = "address" value = "<%= address%>">
	</form>
</body>
<%@include file = "footer.jsp" %>
</html>