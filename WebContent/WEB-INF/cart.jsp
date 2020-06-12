<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.List"%>
<%@ page import = "dto.CartDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ショッピングカート</title>
</head>
<body>

	<%
		//カートに商品がないとき
		if((int)session.getAttribute("countCart") == 0){

			request.setAttribute("cartMessage", "カートは空です。<br><br>");

		}else{ //カートに商品があるとき(L86まで１ブロック)

			int	sum = (int)session.getAttribute("sum");

			List<CartDTO> cartList = (List<CartDTO>) session.getAttribute("cartList");





	%>
	<h1>ショッピングカート</h1>

	${cartMessage } <!--削除しましたのメッセージ-->


	<table border = "1">

		<tr bgcolor = "#7fffd4">
			<th>商品名</th>
			<th>商品の色</th>
			<th>メーカ―名</th>
			<th>価格</th>
			<th>数量</th>
			<th>在庫</th>
			<th></th>
		</tr>
	<%

			for(CartDTO cart : cartList){
	%>
		<tr>
			<td><%=cart.getItemName() %></td>
			<td><%=cart.getColorName() %></td>
			<td><%=cart.getManufacturer() %></td>
			<td><%=cart.getPrice() %>円</td>
			<td><form><select name="quantity">
			<% for(int i = 1; i <= 20; i++){
					if(i == cart.getQuantity()){
			%>
						<option value = "<%= i %>" selected><%=i %></option>
			<% 		}else{ %>
						<option value = "<%= i %>"><%=i %></option>
			<%  	}
			   	}
			%>
			</select></form></td>
			<td><%
				if (cart.getStock() >= cart.getQuantity()) out.print("〇");
				else out.print("　×　在庫：" + cart.getStock());

			%></td>
			<td><form action = "/模擬プロジェクト/cartDelete" method = "post">
					<input type = "submit" value="カートから削除">
					<input type = "hidden" name = "itemId" value = "<%= cart.getItemId()%>">
			</form></td>
	<%
			}
	%></tr>

	</table><br>


	合計　<%=sum %>円
	<form action = "/模擬プロジェクト/purchase">
		<input type = "submit" value = "レジに進む">
	</form><br>
	<%
		}
	%>
	<a href = "/模擬プロジェクト/itemSearch"></a>トップページへ<br>

</body>
</html>