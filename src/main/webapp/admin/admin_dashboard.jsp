<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.foodapp.model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Admin Dashboard</h2>

	<h3>Add Food</h3>
	<form method="post" action="addFood">
		<input name="name" placeholder="Food Name" required> <input
			name="price" placeholder="Price" required> <input
			name="category" placeholder="Category">
		<textarea name="description"></textarea>
		<button>Add</button>
	</form>

	<hr>

	<h3>Your Foods</h3>
	<%
List<Food> foods = (List<Food>) request.getAttribute("foods");
for (Food f : foods) {
%>
	<p><%= f.getName() %>
		- ₹<%= f.getPrice() %></p>
	<% } %>

	<hr>

	<h3>Orders</h3>
	<%
List<Order> orders = (List<Order>) request.getAttribute("orders");
for (Order o : orders) {
%>
	<form method="post" action="updateStatus">
		Order #<%= o.getId() %>
		| ₹<%= o.getTotalPrice() %>
		<select name="status">
			<option>Preparing</option>
			<option>Out for delivery</option>
			<option>Delivered</option>
		</select> <input type="hidden" name="orderId" value="<%= o.getId() %>">
		<button>Update</button>
	</form>
	<% } %>
</body>
</html>