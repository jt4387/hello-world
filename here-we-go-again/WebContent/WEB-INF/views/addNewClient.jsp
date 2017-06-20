<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Client</title>
</head>
<body>
	<body>
	<div align="center">
		<h2>Add A New Client:</h2>
		<form action ="addClient">
			<label id="client-first-name">First Name: </label><br/>
			<input type = "text" placeholder="Enter First Name" name = "firstName"/><br/>
			<label id="client-last-name">Last Name: </label><br/>
			<input type = "text" placeholder="Enter Last Name" name = "lastName"/><br/>
			<label id="client-address">Address: </label> <br/>
			<input type = "text"placeholder = "Enter Address"  name =  "address"/> <br/>
			<input type = "submit" value = "Submit"> <br/>
		</form>
	</div>
</body>
</html>