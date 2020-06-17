<%@page import="dto.ItemsDTO"%>
<%@page import="dao.ItemsDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
      List<ItemsDTO> itemList =(List<ItemsDTO>)request.getAttribute("searchResult");
	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
		<title>検索結果</title>
<link rel="stylesheet" href="ForAll.css" type="text/css" />
	</head>
	<body>
		<form action='${pageContext.request.contextPath}/src/ItemDetailControlServlet' method='POST'>

		<h3>検索結果</h3>
		<hr>
			<table>
				<tr>
					<th>商品名</th>
					<th>商品の色ID</th>
					<th>メーカー名</th>
					<th>価格</th>
				</tr>
				<%
				List<ItemsDTO> iList2 = (List<ItemsDTO>)request.getAttribute("itemList2");
				 %>

					<!--  キーワードと一致する商品を表示-->
				<% for(ItemsDTO item:iList2) {%>
				<tr>
				<td><%=item.getItemName() %></td>
				<td><%=item.getColorId() %></td>
				<td><%=item.getManufacture() %></td>
				<td><%=item.getPrice() %></td>
				<td><input type="hidden" name="itemId" value="<%= item.getItemId()%>" />
					<input type='submit' value='商品詳細' />
				</td>
				</tr>
			<%} %>

			</table>
		</form>
		<a href='${pageContext.request.contextPath}/src/ItemSerchControlServlet'>検索画面</a>へ戻る<br />
	</body>
</html>
