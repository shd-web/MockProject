<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "dto.ItemsDTO"%>
<%@ page import = "dao.ItemsDAO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="ForAll.css" type="text/css" />
</head>
<%@include file = "header.jsp" %>
<body>
<h2>商品詳細</h2><hr>
<%
	int itemId = (int)request.getAttribute("itemId");
	ItemsDTO itemsDto = new ItemsDTO();
	ItemsDAO itemsDao = new ItemsDAO();
	itemsDto = itemsDao.getItemDetail(itemId);

%>
	<table>
	<tr bgcolor = "white"><th>商品ID</th><th>商品名</th><th>カテゴリー名</th><th>色</th><th>製造者</th><th>価格</th><th>在庫</th></tr>
	<tr><td><%= itemId%></td>
	<td class = table><%= itemsDto.getItemName()%></td>
	<td><%= itemsDto.getCategoryName()%></td>
	<td><%= itemsDto.getColorName()%></td>
	<td><%= itemsDto.getManufacture()%></td>
	<td><%= itemsDto.getPrice()%></td>
	<td><%= itemsDto.getStock()%></td>
	</tr>
	</table>
	<form action = "/模擬プロジェクト/cart" method = "post">
	数量：
	<select name = "quantity">
		<option value = "1" selected>1</option>
		<% for(int i = 2; i <= 20; i++) {%>
		<option value = "<%= i%>"><%= i%></option>
		<% }%>
	</select>
	<input type = "submit" value = "カートに入れる">
	<input type = "hidden" name = "itemId" value = "<%= itemId%>">
	<input type = "hidden" name = "colorId" value = "<%= itemsDto.getColorId()%>">
	</form>

</body>
</html>