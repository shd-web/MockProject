<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import = "JavaBeans.AccountsBeans"%>
 <!DOCTYPE html>
 <html>
 <head>
 <link rel="stylesheet" type="text/css" href="./Header.css">
<meta charset="UTF-8">
</head>
 <header>
 <%
 	AccountsBeans ab= (AccountsBeans)session.getAttribute("account");
	String name = ab.getName();
 %>
  <h6>ようこそ<%= name%>さん</h6>
  <h1 class="headline">
    <a>THE DSK</a>
  </h1>
  <ul class="nav-list">
    <li class="nav-list-item">
      <a class = "roma" href = "/模擬プロジェクト/loginedTop">Home</a>
      <ul>
      	<li><a href = "/模擬プロジェクト/myPage">マイページ</a></li>
      	<li><a href = "/模擬プロジェクト/cart">カート</a></li>
      	<li><a href = "/模擬プロジェクト/top">ログアウト</a></li>
      </ul>
    </li>
    <li class="nav-list-item">
	    <a class = "roma">About</a>
	    <ul>
	      	<li><a href = "#">会社概要</a></li>
	      	<li><a href = "#">IR情報</a></li>
	      	<li><a href = "#">採用情報</a></li>
      </ul></li>
    <li class="nav-list-item">
		<form class = "search" action = "/模擬プロジェクト/itemSearchResult" method = "post">
				<input class = "header-input" type = "text" name = "keyword" placeholder = "キーワード">
				<input class = "header-btn-square" type = "submit" value = "検索">
      		</form>
      </li>

  </ul>
</header>
</html>

