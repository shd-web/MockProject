<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="./ForAll.css">
<meta charset="UTF-8">
<title>検索画面</title>
</head>
<%@include file = "header.jsp" %>
<body>
	<form action = "/模擬プロジェクト/ItemSearchResult" method = "post">
		<div class = "cp_ipselect">
		<select class = "cp_sl06" name = "category">
			<option value = "すべて">すべて</option>
			<option value = "靴">靴</option>
			<option value = "帽子">帽子</option>
		</select>
		<span class="cp_sl06_highlight"></span>
		<span class="cp_sl06_selectbar"></span>
		<label class="cp_sl06_selectlabel">カテゴリ</label>
		</div>
		<input class = "body-input" type = "text" name = "keyword" placeholder = "キーワード">
		<input class = "btn-square" type = "submit" value = "検索"><br>


	</form>

</body>
<%@include file = "footer.jsp" %>
</html>