<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ page import="jp.co.aforce.beans.ProductBean" %>
<%@ page import="jp.co.aforce.beans.PurchaseInfoBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>決済完了</title>
<link rel="stylesheet" href="../css/purchase.css">
<link href="https://fonts.googleapis.com/css2?family=M+PLUS+1:wght@300&display=swap" rel="stylesheet">
</head>
<body>

<h1>決済完了</h1>
<h2>購入情報</h2>

<div class="cart-items">
  <table>
    <thead>
      <tr>
        <th>商品画像</th>
        <th>商品名</th>
        <th>価格</th>
        <th>個数</th>
      </tr>
    </thead>
    <tbody>
    <c:set var="totalPrice" value="0" />
      <c:forEach var="item" items="${cartItems}">
        <tr>
          <td><img src="${item.imagePass}" alt="${item.productName}" width="100"></td>
          <td>${item.productName}</td>
          <td>${item.price}円</td>
          <td>${item.purchaseNumber}個</td>
        </tr>
        <c:set var="totalPrice" value="${totalPrice + (item.purchaseNumber * item.price)}" />
      </c:forEach>
    </tbody>
  </table>
</div>

<div class="total-price">
  <p>合計金額：${totalPrice}円</p>
</div>

<div class="purchase-info">
  <table>
    <tr>
      <th>お届け先</th>
      <th>決済方法</th>
      <th>支払い方法</th>
    </tr>
    <tr>
      <td>${purchaseInfo.target}</td>
      <td>${purchaseInfo.method}</td>
      <td>${purchaseInfo.payment}</td>
    </tr>
  </table>
</div>

<% session.removeAttribute("cartItems") %>
	
<div class="home-link">
  <a href="../views/home.jsp">ホームへ</a>
</div>



</body>
</html>
