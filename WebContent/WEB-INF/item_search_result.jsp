<%@page import="dto.ItemsDTO"%>
<%@page import="dao.ItemsDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
		<title>検索結果</title>
		<link rel="stylesheet" href="ForAll.css" type="text/css" />
	</head>
	<%@include file = "header.jsp" %>
	<body>


		<h3>検索結果</h3>
		<hr>
		<form action="/模擬プロジェクト/itemDetail" name = "toDetail" method='POST'>
			<table>
				<tr>
					<th>商品名</th>
					<th>カテゴリー名</th>
					<th>商品の色</th>
					<th>価格</th>
					<th>メーカー名</th>
					<th>在庫数</th>
				</tr>
				<%
				List<ItemsDTO> iList2 = (List<ItemsDTO>)request.getAttribute("searchResult");
				%>

				<!--  キーワードと一致する商品を表示-->
				<% for(ItemsDTO item : iList2) {%>
				<tr>
				<td><%= item.getItemName() %></td>
				<td><%= item.getCategoryName() %></td>
				<td><%= item.getColorName() %></td>
				<td><%= item.getPrice() %></td>
				<td><%= item.getManufacture() %></td>
				<td><%= item.getStock() %></td>

				<td><input type="hidden" id = "itemId" name="itemId" value="" />
					<input type="submit" value="商品詳細" onclick = "setItemId(<%= item.getItemId()%>)"/>

					<script type="text/javascript">
					function setItemId(id){
						var element = document.getElementById("itemId");
						setValue(element, id);

					}
					//element:hidden要素。value属性に商品IDをセットする
					function setValue(element,value){
						element.setAttribute("value", value);
					}

					</script>
				</td>
				</tr>
				<%} %>

			</table>
		</form>

	</body>
	<%@include file = "footer.jsp" %>
</html>