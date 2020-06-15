<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action = "/模擬プロジェクト/ItemSearchResult" method = "post">
		<select name = "category">
			<option value = "すべて">すべて</option>
			<option value = "靴">靴</option>
			<option value = "帽子">帽子</option>
		</select>
		<input type = "text" name = "keyword">
		<input type = "submit" value = "検索"><br>
	</form>
</body>
</html>