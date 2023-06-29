<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, javax.servlet.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME</title>
<script type="text/javascript" src="/ShoppingSite2/js/jquery-3.6.4.min.js"></script>
<link rel="stylesheet" href="../css/main.css">
<link href="https://fonts.googleapis.com/css2?family=M+PLUS+1:wght@300&display=swap" rel="stylesheet">
</head>
<body class="body">


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
				<a href="../jp.co.aforce/logout" class="header_nav-link"onclick="return confirm('ログアウトしますか？');">
					<div class="link_click">logout</div>
				</a>
			</li>
			<li class="header_nav-item">
				<a href="../views/cart.jsp" class="header_nav-link">
					<div class="link_click">cart</div>
				</a>
			</li>		
		</ul>
	</div>
</header>

<div class="home">
		 <div class="home-space">
		<img src="../img/食べてもいいぜ-g.png">
 <!--  <div id="slidertype1">
	      <img class = "home-img" alt="伊達" src="../img/home-1.png">
	    </div>
	    <div id="slidertype2">
	      <img class = "home-img" alt="伊達" src="../img/home-2.png">
	    </div>
	    <div id="slidertype3">
	      <img class = "home-img" alt="伊達" src="../img/home-3.png">
	    </div>
	    <div id="slidertype4">
	      <img class = "home-img" alt="伊達" src="../img/home-4.png">
	    </div>
	    <div id="slidertype5">
	      <img class = "home-img" alt="伊達" src="../img/home-5.png">
	    </div>  --> 
	</div>
</div>

<div class="wrap">
 	<ul class="slideshow">
	    <li class="content"><img class="slider-img" alt="伊達" src="../img/date-slide-right.png" ></li>
	    <li class="content"><img class="slider-img" alt="伊達" src="../img/date-slide-left.png" ></li>
	    <li class="content"><img class="slider-img" alt="伊達" src="../img/date-slide-right.png" ></li>
	    <li class="content"><img class="slider-img" alt="伊達" src="../img/date-slide-left.png" ></li>
	</ul>
	<ul class="slideshow">
	    <li class="content"><img class="slider-img" alt="伊達" src="../img/date-slide-right.png" ></li>
	    <li class="content"><img class="slider-img" alt="伊達" src="../img/date-slide-left.png" ></li>
	    <li class="content"><img class="slider-img" alt="伊達" src="../img/date-slide-right.png" ></li>
	    <li class="content"><img class="slider-img" alt="伊達" src="../img/date-slide-left.png" ></li>
	</ul> 
	<ul class="slideshow">
	    <li class="content"><img class="slider-img" alt="伊達" src="../img/date-slide-right.png" ></li>
	    <li class="content"><img class="slider-img" alt="伊達" src="../img/date-slide-left.png" ></li>
	    <li class="content"><img class="slider-img" alt="伊達" src="../img/date-slide-right.png" ></li>
	    <li class="content"><img class="slider-img" alt="伊達" src="../img/date-slide-left.png" ></li>
	</ul>
	<ul class="slideshow">
	    <li class="content"><img class="slider-img" alt="伊達" src="../img/date-slide-right.png" ></li>
	    <li class="content"><img class="slider-img" alt="伊達" src="../img/date-slide-left.png" ></li>
	    <li class="content"><img class="slider-img" alt="伊達" src="../img/date-slide-right.png" ></li>
	    <li class="content"><img class="slider-img" alt="伊達" src="../img/date-slide-left.png" ></li>
	</ul>
</div>

<div class="main-banner">
	<div class="main-banner-item">
		<a href="../jp.co.aforce/product" data-text="テキストを入力">
			<img class="center-content" src="../img/slide1.png">
			<p class="center">あれもゼロカロリー</p>
		</a>
	</div>
	<div class="main-banner-item">
		<a href="../jp.co.aforce/product">
			<img class="center-content" src="../img/slide2.png">
			<p class="center">これもゼロカロリー</p>
		</a>
	</div>
	<div class="main-banner-item">
		<a href="../jp.co.aforce/product">
			<img class="center-content" src="../img/slide3.png">
			<p class="center">それもゼロカロリー</p>
		</a>
	</div>
	<div class="main-banner-item">
		<a href="../jp.co.aforce/product">
			<img class="center-content" src="../img/slide4.png">
			<p class="center">全部ゼロカロリー</p>
		</a>
	</div>
</div>

<footer>
	<div class="footer-left">
		<img alt="ロゴ" src="../img/logo_noback.png" width="193" height="130">
	</div>
	<div class="footer-right">
		<p>Copyright 2023 Zcal.Allright reserved</p>
	</div>
	
</footer>
</body>
</html>