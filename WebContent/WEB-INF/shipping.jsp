<!-- 配送方法指定画面（２） -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		String address = (String)request.getAttribute("address");

	%>
	<h2>配送オプション</h2>
	<form action = "/模擬プロジェクト/purchaseConfirmation" method = "post">

		<h3>支払方法<br></h3>

		<input type = "radio" checked = "checked">代金引換<br><br>

		<h3>配送方法</h3>
		<input type ="radio" name = "shipping" value = "通常配送"> 通常配送<br>
		<input type ="radio" name = "shipping" value = "お急ぎ便　無料" checked="checked"> お急ぎ便　無料<br>
		<input type ="radio" name = "shipping" value = "お届け日時指定便　無料"> お届け日時指定便　無料<br><br>
		<input type = "submit" value = "次に進む"><br>
		<input type = "hidden" name = "address" value = "<%= address%>">
	</form>
</body>
</html>