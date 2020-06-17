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
<%
	int itemId = (int)request.getAttribute("itemId");
	ItemsDTO itemsDto = new ItemsDTO();
	ItemsDAO itemsDao = new ItemsDAO();
	itemsDto = itemsDao.getItemDetail(itemId);

%>
	<%= itemId%><br>
	<%= itemsDto.getItemName()%><br>
	<%= itemsDto.getCategoryName()%><br>
	<%= itemsDto.getColorName()%><br>
	<%= itemsDto.getManufacture()%><br>
	<%= itemsDto.getPrice()%><br>
	<%= itemsDto.getStock()%><br><br>

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