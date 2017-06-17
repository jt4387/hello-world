<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Web App Home</title>
</head>
	<style>
		a:link, a:visited {
			background-color: #87CEFA;
			color: white;
			padding: 14px 25px;
			text-align: center;
			text-decoration: none;
			display: inline-block
		}
		
		a:hover, a:active {
			background-color: #87CEEB
		}
		
		h2: {
			font-family: "Verdana", serif
		}
	</style>
<body>
	<h2><center>DogWalker Web App</center></h2>
	<div align=center>
		<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
		<a href="${contextPath}/client"> Client Page </a>
		<a href="${contextPath}/schedule"> Schedule </a>
		<a href="${contextPath}/invoices"> Invoices </a>
	</div>
</body>
</html>