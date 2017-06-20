<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Client List</title>
</head>
<style>
		h2 {
			 font-family: "Verdana", serif;
			 text-align: center
		}
</style>
<body>
	<c:forEach var="row" items="${allClients}">
		ID: ${row.id} <br/>
		First Name: ${row.firstName} <br/>
		Last Name: ${row.lastName} <br/>
		Address: ${row.address} <br/>
		Pets: ${row.pets}
		<hr/>
	</c:forEach>
	
</body>
</html>