<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<title>Login page</title>
</head>
<body>
<p>Authorication:<sec:authentication property="name"/></p>
<c:url var="loginUrl" value="/login" />
<form action="${loginUrl}" method="post">
<input type="text" name="username">
<input type="password" name="password">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
<input type="submit" value="Submit">
</form>
</body>
</html>