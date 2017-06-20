<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Appointment List</title>
</head>
<style>
	h2 {
		font-family: "Verdana", serif
	}
</style>
<body>
	<sql:query var ="rs" dataSource="jdbc/clientdb">
		SELECT * FROM client_list
	</sql:query>
	<h2> Full Appointment List </h2>
	<c:forEach var="row" items="${allAppointments}">
		Date: ${row.date} <br/>
		Time: ${row.time} <br/>
		<c:forEach var="innerRow" items="${rs.rows}">
			<c:if test="${row.clientID == innerRow.client_id}">
				Client: ${innerRow.client_first_name } ${innerRow.client_last_name}
			</c:if>
		</c:forEach>
	</c:forEach>
</body>
</html>