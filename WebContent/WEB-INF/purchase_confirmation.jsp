<!-- 住所と配送方法の確認画面（３） -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.List"%>
<%@ page import = "dto.CartDTO"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="./ForAll.css">
<meta charset="UTF-8">
<title>Purchase Confirmation</title>
</head>
<%@include file = "header.jsp" %>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		//String name = request.getParameter("name");
		String address = request.getParameter("address");
		String shipping = request.getParameter("shipping");
	%>
	<h2>確認画面</h2>

	<h5>「注文を確定する」ボタンを押してご注文いただくことで、お客様は当サイトの各種規約、
	プライバシー規約および商品ページ・キャンペーンページ上の販売条件ならびに配送料と注文合計に
	同意の上、商品をご注文されたことになります。</h5>


	<h3>お届け先住所<br></h3>
	<p><%= session.getAttribute("accountName")%><br>
	<%= address%><br><br></p>

	<h3>支払方法<br></h3>
	<h5>代金引換<br><br></h5>


	<h3>商品情報<br></h3>
	<h5>
	<%
	List<CartDTO> cartList = (List<CartDTO>) session.getAttribute("cartList");
	for(CartDTO cart : cartList){%>
		<%= cart.getItemName()%>
		<%= cart.getColorName()%>
		<%= cart.getManufacturer()%>
		￥<%= cart.getPrice() %>
		数量：<%= cart.getQuantity()%>
		<br>
	<%}	%></h5>

	<h3>配送方法<br></h3>
	<h5><%= shipping%><br><br></h5>

		<input type = "hidden" name = "shippingAddress" value = "<%= shipping%>">
	<form class = "body-form" action = "/模擬プロジェクト/purchaseComplete" method = "post">
		<input class = "btn-square" type = "submit" value = "注文を確定する">
	</form>
</body>
<%@include file = "footer.jsp" %>
</html>