<%@page import="com.webeco.entity.OrderItem"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
		String user = (String)session.getAttribute("USERNAME");
		List<OrderItem> orders = (List<OrderItem>) session.getAttribute("orderitemslist");
		int i =0;
	%>
<h1><%=user %>'s previous Order</h1><br/>
<pre>												<a href="index.jsp">Home</a></pre><br/><br/>

<table border="1">
			<thead>
				<tr>
					<td>Sl no.</td>
					<td>Order ID</td>
					<td>Product ID</td>
					<td>Quantity</td>
					<td>Sub total</td>
					
				</tr>
			</thead>
	<%
		for(OrderItem o : orders)
		{
	%>
		<tr>
			<td><%= i%></td>
			<td><%=o.getOrderId() %></td>
			<td><%=o.getProductId() %></td>
			<td><%=o.getQuantity() %></td>
			<td><%=o.getSubtotal() %></td>
			
		</tr>
	
	<%
			i+=1;
		}
	%>
		</table><br/>


</body>
</html>