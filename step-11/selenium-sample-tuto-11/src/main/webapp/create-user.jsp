<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<title>Send data using a HTML form</title>
</head>
<body>
    For instance, let's have a form to create dummy users :<br />
    <br />
	<form method="post" action="create-user-results" name="create-user-form.jsp">
		Firstname: <input type="text" name="firstname"/> <br/>
		Lastname: <input type="text" name="lastname"/><br/>
		Age: <input type="text" name="age"/><br/>
    <br />
		<input type="submit" value='Create user !'/>
	</form>
</body>
</html>
