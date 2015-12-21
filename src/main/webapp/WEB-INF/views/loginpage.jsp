<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no, minimal-ui">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<title>My App</title>
<!-- Path to Framework7 Library CSS-->
<link rel="stylesheet" href="css/framework7.ios.min.css">
<link rel="stylesheet" href="css/framework7.ios.colors.min.css">
<!-- Path to your custom app styles-->
<link rel="stylesheet" href="css/my-app.css">
</head>
<body>
	<c:url var="loginUrl" value="/loginOneUser" />
	<div class="login-screen modal-in">
		<!-- Default view-page layout -->
		<div class="view">
			<div class="page">
				<!-- page-content has additional login-screen content -->
				<div class="page-content login-screen-content">
					<div class="login-screen-title">QY</div>
					<!-- Login form -->
					<form action="${loginUrl}" method="post" id="loginForm">
						<div class="list-block">
							<ul>
								<li class="item-content">
									<div class="item-inner">
										<div class="item-title label">Username</div>
										<div class="item-input">
											<input type="text" name="username" placeholder="Username">
										</div>
									</div>
								</li>
								<li class="item-content">
									<div class="item-inner">
										<div class="item-title label">Password</div>
										<div class="item-input">
											<input type="password" name="password" placeholder="Password">
											<input type="hidden" name="${_csrf.parameterName}"
												value="${_csrf.token}" />
										</div>
									</div>
								</li>
								<li>
									<label class="label-checkbox item-content">
										<input type="checkbox" id="remember-me" name="remember-me" value="true">
										<div class="item-media">
          									<i class="icon icon-form-checkbox"></i>
        								</div>
       									<div class="item-inner">
          									<div class="item-title">Remember Me</div>
        								</div>
									</label>
								</li>
							</ul>
						</div>
						<div class="list-block">
							<ul>
								<li><a id="toLogin" class="item-link list-button">Sign In</a></li>
							</ul>
							<div class="list-block-labe">${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message}</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	
	<script type="text/javascript" src="js/framework7.min.js"></script>
    <!-- Path to your app js-->
    <script type="text/javascript" src="js/my-app2.js"></script>
</body>
</html>