<!-- 住所の選択画面（１） -->
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
	<!-- 登録されている住所に届ける -->
	<form action = "/模擬プロジェクト/shipping.jsp">
	＜データベースに入っている名前＞<br>
	＜データベースに入っている住所＞<br>
	<input class ="btn-square" type = "submit" value = "この住所に届ける"><br>
	<input type = "hidden" name = "address">
	</form>

	<!-- 新しい住所に届ける -->
	<hr><h2>新しい住所を追加</h2>
	必要事項を入力し、「この住所に届ける」ボタンをクリックしてください。<br><br>

	<form action = "/模擬プロジェクト/shipping" method = "post">
	氏名<input class = "text" type = "text" name = "name"><br>
	住所<input class = "text" type = "text" name = "address"><br>
	<input class = "btn-square" type = "submit" value = "この住所に届ける">
	</form>
</body>
<%@include file = "footer.jsp" %>
</html>