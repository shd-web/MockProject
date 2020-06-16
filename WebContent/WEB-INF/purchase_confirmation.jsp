<!-- 住所と配送方法の確認画面（３） -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.List"%>
<%@ page import = "dto.CartDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Purchase Confirmation</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		//String name = request.getParameter("name");
		String address = request.getParameter("address");
		String shipping = request.getParameter("shipping");
	%>
	<h1>注文内容を確認する</h1>

	<h5>「注文を確定する」ボタンを押してご注文いただくことで、お客様は当サイトの各種規約、
	プライバシー規約および商品ページ・キャンペーンページ上の販売条件ならびに配送料と注文合計に
	同意の上、商品をご注文されたことになります。</h5>


	<h3>お届け先住所<br></h3>
	<h5><%= session.getAttribute("accountName")%><br>
	<%= address%><br><br></h5>

	<h3>支払方法<br></h3>
	<h6>代金引換<br><br></h6>


	<h3>商品情報<br></h3>
	<h6>
	<%
	List<CartDTO> cartList = (List<CartDTO>) session.getAttribute("cartList");
	for(CartDTO cart : cartList){
		out.println(cart.getItemName());
		out.println(cart.getColorName());
		out.println(cart.getManufacturer());
		out.println(cart.getPrice());
		out.println(cart.getQuantity());
		out.println("<br>");
	}

	%></h6>

	<h3>配送方法<br></h3>
	<h5><%= shipping%><br><br></h5>

	<form action = "/模擬プロジェクト/purchaseComplete" method = "post">
		<input type = "submit" value = "注文を確定する">
		<input type = "hidden" name = "shippingAddress" value = "<%= shipping%>">
	</form>
</body>
</html>