<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!DOCTYPE html>
 <html>
 <head>
 <link rel="stylesheet" type="text/css" href="./Header.css">
<meta charset="UTF-8">
</head>
 <header>
  <h1 class="headline">
    <a>THE DSK</a>
  </h1>
  <ul class="nav-list">
    <li class="nav-list-item">
      <a href = "top.jsp">Home</a>
      <ul>
      	<li><a href = "login.jsp">ログイン</a></li>
      	<li><a href = "registration.jsp">アカウント登録</a></li>
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
		<form class = "search" action = "item_search_result.jsp" method = "post">
				<input class = "header-input" type = "text" name = "address" placeholder = "キーワード">
				<input class = "header-btn-square" type = "submit" value = "検索">
      		</form>
      </li>

  </ul>
</header>
</html>




