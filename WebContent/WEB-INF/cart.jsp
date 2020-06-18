<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.List"%>
<%@ page import = "dto.CartDTO"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="./ForAll.css">
<meta charset="UTF-8">
<title>ショッピングカート</title>
</head>
<%@include file = "header.jsp" %>
<body>

<h2>ショッピングカート</h2>
	<%
		//カートに商品がないとき
		if((int)session.getAttribute("countCart") == 0){
	%>

			カートは空です。<br><br>
	<%
		}else{ //カートに商品があるとき(L86まで１ブロック)

			int j =0; //ウェブ画面のカート内商品数のカウンタ
			int	sum = (int)session.getAttribute("sum");

			List<CartDTO> cartList = (List<CartDTO>) session.getAttribute("cartList");





	%>





	<table>

		<tr bgcolor = "white">
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
			<td class = table><%=cart.getItemName() %></td>
			<td><%=cart.getColorName() %></td>
			<td><%=cart.getManufacturer() %></td>
			<td><%=cart.getPrice() %>円</td>
			<td>
				<div class = "cp_ipselect_mini">
					<select class = "cp_s106_mini" name = "quantity" id="quantity" onclick = "handleBtnClick(event)" form = "form1">
			<%
				j++;
				for(int i = 1; i <= 20; i++){
					if(i == cart.getQuantity()){
			%>
						<option value = "<%= i %>" selected><%=i %></option>
			<% 		}else{ %>
						<option value = "<%= i %>"><%=i %></option>
			<%  	}
			   	}
			%>
					</select>
					<span class = "cp_s106_highlight_mini"></span>
					<span class = "cp_s106_selectbar_mini"></span>
					</div>
					<input type = "hidden" name = "itemId<%= j%>" value = "<%= cart.getItemId()%>" form = "form1">

			<script type="text/javascript">
			function handleBtnClick(event){
				//ウェブ画面上で選択された値を取得
				var selectElements = document.form1.quantity ;
				for(var selectElement in selectElements){
					console.log(selectElement);
					//var selectedIndex= selectElements[i].selectedIndex;

					console.log("before "+selectedIndex);
					var a = selectElement.options[selectedIndex].selected;
					console.log(a);
				}
				//var element = document.getElementById("quantity");
				//console.log("element"+element);
				//var elements = element.options;
				//console.log("elements:"+elements);
				//elements[selected].selected = true;
				//console.log(elements[selected].selected);
				//console.log(elements[0].selected);
				//setValue(element, selected + 1);
			}

			//element:select要素の下のhidden要素。value属性に数量をセットする
			function setValue(element,value){
				element.setAttribute("value", value);
			}


			</script>

			</td>
			<td><%
				if (cart.getStock() >= cart.getQuantity()) out.print("〇");
				else out.print("　×　在庫：" + cart.getStock());

			%></td>

			<td><form action = "/模擬プロジェクト/cartDelete" method = "post">
					<input class = "btn-square-small" type = "submit" value="カートから削除">
					<input type = "hidden" name = "itemId" value = "<%= cart.getItemId()%>">
			</form></td>
	<%

			}
	%></tr>

	</table><br>


	合計　<%=sum %>円
	<form name = "form1"id = "form1" action = "/模擬プロジェクト/purchase">
		<input type = "hidden" name = "numOfItems" value = "<%= j%>">
		<input class = "btn-square-small" type = "submit" value = "レジに進む">
	</form><br>
	<%
		}
	%>
	<a href = "/模擬プロジェクト/itemSearch"></a>トップページへ<br>

</body>
<%@include file = "footer.jsp" %>
</html>