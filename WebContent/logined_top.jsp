<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="./LoginedTop.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ユーザートップ画面</title>
</head>
<body>
 <header>
  <h1 class="headline">
    <a>THE DSK</a>
  </h1>
  <ul class="nav-list">
    <li class="nav-list-item">
      <a href = "top.jsp">Home</a>
      <ul>
      	<li><a href = "#">アカウント情報</a></li>
      	<li><a href = "top.jsp">ログアウト</a></li>
      	<li><a href = "delete.jsp">退会</a></li>
      </ul>
    </li>
    <li class="nav-list-item">
	    <a>About</a>
	    <ul>
	      	<li><a href = "#">会社概要</a></li>
	      	<li><a href = "#">IR情報</a></li>
	      	<li><a href = "#">採用情報</a></li>
      </ul></li>
    <li class="nav-list-item">
    <a>Search</a>
    <ul>
      	<li><form class = "search" action = "item_search_result.jsp" method = "post">
				<input class = "header-input" type = "text" name = "address" placeholder = "キーワード">
				<input class = "header-btn-square" type = "submit" value = "検索">
      		</form>
      	</li>
      </ul></li>

  </ul>
</header>
<div>
<h2>あえて靴と帽子だけ売っています。</h2>
<h3>明日の夕飯は焼肉にしたいところですが、そんなことより靴と帽子を買いませんか？</h3>
</div>
</body>
<%@include file = "footer.jsp" %>
</html>