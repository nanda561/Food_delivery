<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<!DOCTYPE html>
	<html lang="en">

	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Login - FoodFlow</title>
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
						<a href="login" class="active">Login</a>
					</div>
				</nav>
			</div>
		</header>

		<div class="container">
			<div class="form-container">
				<h2 class="section-title" style="margin-bottom: 20px;">Welcome Back</h2>
				<p style="text-align: center; color: var(--text-muted); margin-bottom: 30px;">Login to manage your
					orders.</p>

				<form action="login" method="post">
					<div class="form-group">
						<label for="email">Email Address</label>
						<input type="email" id="email" name="email" required placeholder="Enter your email">
					</div>
					<div class="form-group">
						<label for="password">Password</label>
						<input type="password" id="password" name="password" required placeholder="Enter your password">
					</div>
					<button type="submit" class="btn" style="width: 100%; margin-top: 10px;">Login</button>
				</form>

				<p style="text-align: center; margin-top: 20px;">
					Don't have an account? <a href="register.jsp"
						style="color: var(--primary); font-weight: 600; text-decoration: none;">Register</a>
				</p>
			</div>
		</div>

		<footer class="footer">
			<p>&copy; 2026 FoodFlow. All rights reserved.</p>
		</footer>

		<script src="js/app.js"></script>
	</body>

	</html>