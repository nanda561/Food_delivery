<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order Success</title>
    <style>
        body {
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            background: #f5f5f5;
            font-family: Arial, sans-serif;
        }
        .success {
            text-align: center;
        }
        .check {
            width: 100px;
            height: 100px;
            border-radius: 50%;
            background: #4CAF50;
            color: white;
            font-size: 50px;
            display: flex;
            align-items: center;
            justify-content: center;
            animation: pop 0.6s ease;
            margin: auto;
        }
        @keyframes pop {
            0% { transform: scale(0); }
            80% { transform: scale(1.2); }
            100% { transform: scale(1); }
        }
        a {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 16px;
            background: #ff4f5a;
            color: white;
            text-decoration: none;
            border-radius: 6px;
        }
    </style>
</head>
<body>

<div class="success">
    <div class="check">✓</div>
    <h2>Order Placed Successfully!</h2>
    <p>Your food is on the way 🍔</p>
    <a href="home">Back to Home</a>
</div>

</body>
</html>
