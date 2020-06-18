<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "JavaBeans.AccountsBeans"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="ForAll.css" type="text/css" />
</head>

<%@include file = "header.jsp" %>

<body>

	<form action = "/模擬プロジェクト/itemSearchResult" method = "post">
		<select name = "category">
			<option value = "すべて">すべて</option>
			<option value = "靴">靴</option>
			<option value = "帽子">帽子</option>
		</select>
		<input type = "text" name = "keyword">
		<input type = "submit" value = "検索"><br>
	</form>
</body>
<%@include file = "footer.jsp" %>
</html>