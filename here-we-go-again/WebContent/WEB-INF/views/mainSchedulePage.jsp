<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Schedule Page</title>
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
</head>
<body>
	<h2><center>Schedule</center></h2>
	<div align=center>
		<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
		<a href="${contextPath}/getAllAppointments"> Get All Appointments</a>
		<a href="${contextPath}/getAllClientAppointments"> Get All Appointments By Client</a>
		<a href="${contextPath}/addClientForm"> Create/Delete/Update Appointment </a>
	</div>
</body>
</html>