<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品情報変更</title>
<link rel="stylesheet" href="../css/changeproduct.css">
<link href="https://fonts.googleapis.com/css2?family=M+PLUS+1:wght@300&display=swap" rel="stylesheet">
</head>
<body>

<%@ page import="jp.co.aforce.beans.ProductBean" %>
<%@ page import="java.util.List" %>
<%@ page import="javax.servlet.http.HttpSession" %>

<c:if test="${productId != null }">
</c:if>

<h1>商品情報変更</h1>



<div class="input">
	<form action="/ShoppingSite2/jp.co.aforce/searchproduct" method="post">
		<span class="message">${changeFailure }</span>
		<div><p>商品ID<br>
				<input type="text" name="productId" value="${productId }">
			</p>
		</div>
				<input type="submit" value="検索">
	</form>
	<%List<ProductBean> productInfo = (List<ProductBean>)request.getAttribute("searchProduct");
		if(productInfo != null){
			for(ProductBean p : productInfo){
				%>
	<form action="/ShoppingSite2/jp.co.aforce/changeproduct" method="post">
		<input type="hidden" name="productId" value="${productId }">
		<p>商品名<br>
			<input type="text" name="productName" value="<%= p.getProductName() %>" required>
		</p>
		<p>在庫数<br>
			<input type="number" name="stock" value="<%= p.getStock() %>" required>
		</p>
		<p>画像パス<br>
			<input type="text" name="imagePass" value="<%= p.getImagePass() %>" required>
		</p>
		<p>価格<br>
			<input type="number" name="price" value="<%= p.getPrice() %>"  required>
		</p>
		<p>商品分類<br>
			<input type="text" name="productCategory" value="<%= p.getProductCategory() %>" required>
		</p>
		<input type="submit"  value="更新" onclick="return confirm('商品情報を更新しますか？');">
	</form>
	<% }
	}%>
	
	<div class="home-link">
  		<a href="../views/adminHome.jsp">Admin Menu</a>
	</div>
	
</div>
</body>
</html>