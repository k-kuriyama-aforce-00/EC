<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
<link rel="stylesheet" href="../css/login.css">
</head>
<body>

<div class="main">
	<p class="sign" align="center">Sign in</p>
	<form class="form1" action="/ShoppingSite2/jp.co.aforce/login"  method="post">
		<input class="id" type="text" name="memberId" placeholder="id" required>
		<input class="pass" type="password"  required size="20" maxlength="10" placeholder="password" name="password">
		<input class="submit" type="submit" value="Sign in">
	</form>
<span class="message">${loginFailure }</span>

</div>
</body>
</html>