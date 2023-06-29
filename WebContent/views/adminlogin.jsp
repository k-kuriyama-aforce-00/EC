<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者ログイン</title>
<link rel="stylesheet" href="../css/adlogin.css">
</head>
<body>

<div class="main">
	<p class="sign" align="center">Admin Sign in</p>
		<form class="form1" action="/ShoppingSite2/jp.co.aforce/adminlogin" method="post">
		<input class="id" type="text" name="adminId" placeholder="id" required>
		<input class="pass" type="password" name="adminPass" placeholder="password" required>
		<input class="submit" type="submit"value="Sign in">
	</form>
<span class="message">${adloginFailure }</span>

</div>
</body>
</html>