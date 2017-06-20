<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add A New Pet to Client</title>
</head>
<body>
	<div align = "center">
		<h2>Add A New Pet:</h2>
		<form action = "addPet">
			<label id = "client-id">Client ID: </label><br/>
			<input type = "text" placeholder="Enter client ID" name = "clientID"><br/>
			<label id = "pet-name">Pet Name: </label><br/>
			<input type = "text" placeholder="Enter new pet name" name = "petName"><br/>
			<input type = "submit" value = "Submit"><br/>
		</form>
	</div>
</body>
</html>