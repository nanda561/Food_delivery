<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<!DOCTYPE html>
	<html lang="en">

	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Register - FoodFlow</title>
		<link rel="stylesheet" href="css/style.css">
	</head>

	<body>
		<header>
			<div class="container">
				<nav>
					<a href="home" class="logo">FoodFlow</a>
					<div class="nav-links">
						<a href="home">Home</a>
						<a href="cart">Cart</a>
						<a href="login">Login</a>
					</div>
				</nav>
			</div>
		</header>

		<div class="container">
			<div class="form-container">
				<h2 class="section-title" style="margin-bottom: 20px;">Create Account</h2>
				<p style="text-align: center; color: var(--text-muted); margin-bottom: 30px;">Join FoodFlow and start
					ordering today.</p>

				<form action="register" method="post">
					<div class="form-group">
						<label for="name">Full Name</label>
						<input type="text" id="name" name="name" required placeholder="Enter your full name">
					</div>
					<div class="form-group">
						<label for="email">Email</label>
						<input type="email" id="email" name="email" required placeholder="Enter your email">
					</div>
					<div class="form-group">
						<label for="role">Role</label>
						<select id="role" name="role" required
							style="width: 100%; padding: 12px; border: 1px solid #ddd; border-radius: 8px;">
							<option value="customer">Customer</option>
							<option value="restaurant_owner">Restaurant Owner</option>
						</select>
					</div>
					<div class="form-group">
						<label for="password">Password</label>
						<input type="password" id="password" name="password" required
							placeholder="Create a strong password">
					</div>
					<button type="submit" class="btn" style="width: 100%; margin-top: 10px;">Register</button>
				</form>

				<p style="text-align: center; margin-top: 20px;">
					Already have an account? <a href="login.jsp"
						style="color: var(--primary); font-weight: 600; text-decoration: none;">Login</a>
				</p>
			</div>
		</div>

		<footer class="footer">
			<p>&copy; 2026 FoodFlow. All rights reserved.</p>
		</footer>

		<script src="js/app.js"></script>
	</body>

	</html>