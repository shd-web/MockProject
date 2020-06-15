<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="./ForAll.css">
<meta charset="UTF-8">
<title>ショッピングカート</title>
</head>
<%@include file = "header.jsp" %>
<body>
	<h2>ショッピングカート</h2>
	<table border = "1">

		<tr bgcolor = "white">
			<th>商品名</th>
			<th>商品の色</th>
			<th>メーカ―名</th>
			<th>価格</th>
			<th>数量</th>
			<th>在庫</th>
			<th></th>
		</tr>

		<tr>

			<td>スニーカーA</td>
			<td>青</td>
			<td>ABAマート</td>
			<td>590000</td>
			<td><form><select name="quantity">

				</select></form></td>
			<td>〇</td>
			<td><form><input  class = "btn-square" type = "submit" value="カートから削除"></form></td>

		</tr>

	</table><br>


	<p>合計　590000円
	<form>
		<input class = "btn-square" type = "submit" value = "レジに進む">
	</form><br>
	<a href = ".html"></a>トップページへ<br>

</body>
<%@include file = "footer.jsp" %>
</html>