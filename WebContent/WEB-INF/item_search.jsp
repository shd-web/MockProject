<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
		<meta charset="UTF-8"/>
		<title>トップページ</title>
</head>

		<%--<h1>ショッピングサイト名</h1>
		<h3>ようこそ、ゲストさん</h3> --%>
<body>
		<h2>Lamellibrachia</h2>

		<form action="/itemSearch" method="post">
			<input  name="keyword" type="text"/> 商品名を入力してください
			<input type="submit">検索

  			<input type="radio" name="category" class="radio02-input" id="radio02-01" value='0'checked>
  			<input type="radio" name="category" class="radio02-input" id="radio02-02" value='1'>
  			<input type="radio" name="category" class="radio02-input" id="radio02-03" value='2'>


		</form>
	</body>
</html>