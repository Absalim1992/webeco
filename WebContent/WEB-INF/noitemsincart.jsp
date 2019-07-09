<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cart</title>
</head>
<body>
	<% String user = (String)session.getAttribute("USERNAME"); %>
	
	<h1>Your Cart</h1> <br/>
	
	<b>There are no items in your cart</b><br/>
	
	<a href="index.html">Home</a>
	
	

</body>
</html>