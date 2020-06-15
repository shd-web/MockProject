<%@page import="dto.ItemsDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
		<title>検索結果</title>
<link rel="stylesheet" href="/webapplication/css/searchResult.css" type="text/css" />
	</head>
	<body>
	<% System.out.println("jspに来た");
	%>

	<%
      List<ItemsDTO> itemList =(List<ItemsDTO>)request.getAttribute("itemList");
	%>
		<h3>検索結果</h3>
		<hr>
		<table border=1>
			<tr>
				<th>商品名</th>
				<th>商品の色</th>
				<th>メーカー名</th>
				<th>価格</th>
				<th>商品詳細</th>
			</tr>
			<%for(ItemsDTO ItemsDTO:itemList){ %>
			<tr>
				<td><%=ItemsDTO.getItemName()%></td>
				<td><%=ItemsDTO.getColorId() %></td>
				<td><%=ItemsDTO.getManufacture() %></td>
				<td><%=ItemsDTO.getPrice() %></td>
				<td><form action='${pageContext.request.contextPath}/src/ItemDetailControlServlet' method='POST'>
				<input type="hidden" name="detailId" value="<%= ItemsDTO.getItemId() %>" />
				<input type='submit' value='商品詳細' />
				</form></td>
			</tr>
			<%} %>

		</table>

		<a href='${pageContext.request.contextPath}/src/ItemSerchControlServlet'>検索画面</a>へ戻る<br />
	</body>
</html>
