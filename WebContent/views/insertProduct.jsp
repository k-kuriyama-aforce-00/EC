<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../js/insertProduct.js"></script>
<link rel="stylesheet" href="../css/insert.css">
<link href="https://fonts.googleapis.com/css2?family=M+PLUS+1:wght@300&display=swap" rel="stylesheet">
</head>
<body>

<h1>商品登録</h1>

<form action="/ShoppingSite2/jp.co.aforce/insertproduct" method="post" enctype="multipart/form-data">
	<span class="message">${insertFailure }</span>
	<div>
		商品名<input type="text" name="productName" required>
	</div>
	<div>
		在庫数<input type="number" name="stock" min="1" required>
	</div>
	<div>
		画像ファイル<input type="file" name="imagePass" accept="image/*" required onchange="previewImage(event)">
	</div>
	
	<div id="preview-container" style="display: none;">
  		<img id="preview-image" src="#" alt="プレビュー" style="max-width: 200px; max-height: 200px;">
	</div>


	<div>
		価格<input type="number" name="price" min="1" required> 
	</div>
	<div>
		商品分類<input type="text" name="productCategory" required>
	</div>
	<input type="submit" value="登録" onclick="return confirm('商品を追加しますか？');">
	<div class="home-link">
  		<a href="../views/adminHome.jsp">ホームへ</a>
	</div>
</form>


</body>
</html>