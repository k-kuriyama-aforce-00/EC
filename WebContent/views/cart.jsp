<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="jp.co.aforce.beans.ProductBean" %>
<%@ page import="jp.co.aforce.dao.CartDAO" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart</title>
</head>
<link rel="stylesheet" href="../css/cart.css">
<link href="https://fonts.googleapis.com/css2?family=M+PLUS+1:wght@300&display=swap" rel="stylesheet">
<body>

<h1>Cart Page</h1>


<%	List<ProductBean> cartItems = (List<ProductBean>) session.getAttribute("cartItems");%>

<% if (cartItems == null || cartItems.isEmpty()) { %>
    <div class="empty-cart">
    	<p>カートは空です</p>
    	<a href="../views/product.jsp">商品画面に戻る</a>
    </div>
    
<% } else { %>
	<table>
		<thead>
			<tr>
		        <th>商品画像</th>
		        <th>商品名</th>
		        <th>価格</th>
		        <th>個数</th>
		        <th>小計</th>
      		</tr>
      	</thead>
		<c:set var="totalPrice" value="0" />
		<c:forEach var="item" items="${cartItems}" varStatus="status">
		  <tr>
		    <td><img src="${item.imagePass}" width="193" height="130"></td>
		    <td>${item.productName}</td>
		    <td>${item.price}円</td>
		    <td>${item.purchaseNumber}個</td>
		    <td colspan="3" class="subtotal">${item.purchaseNumber * item.price}円</td>
		    <td>
		    	<form action="/ShoppingSite2/jp.co.aforce/individualcancel" method="post">
		        	<input type="hidden" name="itemIndex" value="${status.index}">
		        	<input  class="cancel" type="submit" value="キャンセル" onclick="return confirm('注文をキャンセルしまか？');">
		        	
		     	 </form>
		     </td>
		  </tr>
		  <c:set var="totalPrice" value="${totalPrice + (item.purchaseNumber * item.price)}" />
		</c:forEach>
	</table>	

	<div class="total-price">
		<p class="total-price-content">合計金額：${totalPrice }円</p>
	</div>
	
	<div class="cart-actions">
 		<form action="/ShoppingSite2/jp.co.aforce/cartdelete" method="post">
 			<input class="all-delete" type="submit" value="カートをすべて削除" onclick="return confirm('カートの商品をすべて削除しますか？');">
 		</form>
 		<button class="all-delete"  type="button" onclick="history.back()">商品をページに戻る</button>
	</div>
<div class="purchase-form">
	<h2>お客様情報入力</h2>
	<form action="/ShoppingSite2/jp.co.aforce/purchase" method="post">
				<div class="form-field">
                    <label for="target">お届け先</label>
                    <input type="text" id="target" name="target" required>
                </div>
                <div class="form-field">
                    <label>配送方法</label>
                    <div>
                        <label>
                            <input type="radio" name="method" value="COLD" required>COLD
                        </label>
                    </div>
                    <div>
                        <label>
                            <input type="radio" name="method" value="HOT" required>HOT
                        </label>
                    </div>
                </div>
                <div class="form-field">
                    <label>お支払方法</label>
                    <div>
                        <label>
                            <input type="radio" name="payment" value="クレジットカード" required>クレジットカード
                        </label>
                    </div>
                    <div>
                        <label>
                            <input type="radio" name="payment" value="PayPay" required>PayPay
                        </label>
                    </div>
                    <div>
                        <label>
                            <input type="radio" name="payment" value="振込" required>振込
                        </label>
                    </div>
                </div>
                <div class="form-actions">
                    <input type="hidden" value="${totalPrice}">
                    <input  class="purchase-button"type="submit" name="purchase" value="購入" onclick="return confirm('購入を確定いたしますか？');">
                </div>
	</form>
</div>
<%} %>
</body>
</html>