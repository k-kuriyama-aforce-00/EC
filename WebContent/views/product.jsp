<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="jp.co.aforce.beans.ProductBean" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>product</title>
<script type="text/javascript" src="/ShoppingSite2/js/jquery-3.6.4.min.js"></script>
<script type="text/javascript" src="/ShoppingSite2/js/cart.js"></script>
<link rel="stylesheet" href="../css/product.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=M+PLUS+1:wght@300&display=swap" rel="stylesheet">

</head>
<body>

<header role="banner" class="header"> 
	<div class="">
		<div class="header_logo">
			<a href="home.jsp">
				<img alt="ロゴ" src="../img/logo-removebg-preview (1).png" width="193" height="130">
			</a>
		</div>
	</div>
	<div>
		<ul class="header_nav">
			<li class="header_nav-item">
				<a href="../jp.co.aforce/product" class="header_nav-link">
					<div class="link_click">product</div>
				</a>
			</li>
			<li class="header_nav-item">
				<a href="../jp.co.aforce/logout" class="header_nav-link">
					<div class="link_click">logout</div>
				</a>
			</li>
			<li class="header_nav-item">
				<a href="cart.jsp" class="header_nav-link">
					<div class="link_click">cart</div>
				</a>
			</li>		
		</ul>
	</div>
</header>

<h1>Menu</h1>

<span>${cartFailure }</span>

<div class="cart-custom">
	<form action="/ShoppingSite2/jp.co.aforce/sort" method="post">
		<select name="sort" id="product-sort">
			<option value=""></option>
			<option value="low">価格：安い順</option>
			<option value="high">価格：高い順</option>
		</select>
		<input  class="button-change" type="submit" value="並べ替え">
	</form>
	
	<form action="/ShoppingSite2/jp.co.aforce/categoryfilter" method="post">
	  <select name="categoryFilter" >
	    <option value="all">ゼロカロリー(全商品)</option>
	    <option value="揚げ物">揚げ物</option>
	    <option value="スイーツ">スイーツ</option>
	    <option value="炭水化物">炭水化物</option>
	  <input class="button-change" type="submit" value="絞り込み">
	</form>
</div>
 <%  List<ProductBean> productList = (List<ProductBean>) session.getAttribute("list");%>
 <div class="cart-content">
 	<c:forEach var="product" items="${ list }">
 		<div class="cart-col">
 			<div class="cart-col-img">
 				<img src=" ${product.imagePass }" width="193" height="130">
 			</div>
 			<div class="cart-col-articl">
 				<span class="cart-col-articl-name">${product.productName }</span>
				<span class="cart-col-articl-price">${product.price }円(税込)</span>
			</div>
			<div class="cart-col-form">
				<form id="addToCartForm" onsubmit="addTocart(event, this)">
					<input type="hidden" name="productId" value="${product.productId}">
					購入数<input type="number" name="purchaseNumber" min="1" max="100"></br>
					<input  class="button-cartin" type="submit" value="カートに入れる">
				</form>
			</div>
		</div>	
 	</c:forEach>
 </div>	
 
 <div class="cart-enter">
	 <form  action="/ShoppingSite2/views/cart.jsp">
	 	<input  class="button-cart" type="submit" value="カートへ">
	 </form>
 </div>

</body>
</html>