<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.foodapp.model.CartItem" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Your Cart | FoodFlow</title>

    <style>
        body {
            margin: 0;
            font-family: "Segoe UI", Arial, sans-serif;
            background: #f5f5f5;
        }

        h2 {
            text-align: center;
            margin: 30px 0;
        }

        .cart-container {
            max-width: 900px;
            margin: auto;
            background: #fff;
            padding: 25px;
            border-radius: 10px;
            box-shadow: 0 10px 25px rgba(0,0,0,0.08);
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th {
            background: #ff4f5a;
            color: white;
            padding: 12px;
            text-align: left;
        }

        td {
            padding: 12px;
            border-bottom: 1px solid #eee;
            vertical-align: middle;
        }

        tr:last-child td {
            border-bottom: none;
        }

        .qty-box {
            display: flex;
            align-items: center;
            gap: 10px;
        }

        .qty-btn {
            width: 32px;
            height: 32px;
            border: none;
            border-radius: 50%;
            background: #ff4f5a;
            color: white;
            font-size: 18px;
            cursor: pointer;
        }

        .qty-btn:hover {
            background: #e63b45;
        }

        .qty {
            min-width: 20px;
            text-align: center;
            font-weight: bold;
        }

        .total {
            text-align: right;
            margin-top: 20px;
            font-size: 20px;
            font-weight: bold;
        }

        .checkout-btn {
            width: 100%;
            margin-top: 20px;
            padding: 14px;
            font-size: 16px;
            background: #ff4f5a;
            color: white;
            border: none;
            border-radius: 8px;
            cursor: pointer;
        }

        .checkout-btn:hover {
            background: #e63b45;
        }

        .empty {
            text-align: center;
            font-size: 18px;
            color: #777;
        }

        /* Loader */
        .loader {
            position: fixed;
            inset: 0;
            background: rgba(255,255,255,0.85);
            display: none;
            align-items: center;
            justify-content: center;
            z-index: 999;
        }

        .loader div {
            width: 55px;
            height: 55px;
            border: 6px solid #ddd;
            border-top-color: #ff4f5a;
            border-radius: 50%;
            animation: spin 0.8s linear infinite;
        }

        @keyframes spin {
            to { transform: rotate(360deg); }
        }

        @media (max-width: 600px) {
            th, td {
                font-size: 14px;
            }
            .total {
                font-size: 18px;
            }
        }
    </style>
</head>

<body>

<h2>Your Cart</h2>

<div class="cart-container">

<%
    Map<Integer, CartItem> cart =
        (Map<Integer, CartItem>) session.getAttribute("cart");

    double total = 0;

    if (cart != null && !cart.isEmpty()) {
%>

<table>
    <tr>
        <th>Food Item</th>
        <th>Quantity</th>
        <th>Price</th>
    </tr>

<%
    for (CartItem item : cart.values()) {
        double itemTotal =
            item.getFood().getPrice() * item.getQuantity();
        total += itemTotal;
%>
    <tr>
        <td><%= item.getFood().getName() %></td>

        <td>
            <div class="qty-box">

                <!-- Decrease -->
                <form method="post" action="cart">
                    <input type="hidden" name="foodId"
                           value="<%= item.getFood().getId() %>">
                    <input type="hidden" name="action" value="dec">
                    <button type="submit" class="qty-btn">−</button>
                </form>

                <span class="qty"><%= item.getQuantity() %></span>

                <!-- Increase -->
                <form method="post" action="cart">
                    <input type="hidden" name="foodId"
                           value="<%= item.getFood().getId() %>">
                    <input type="hidden" name="action" value="inc">
                    <button type="submit" class="qty-btn">+</button>
                </form>

            </div>
        </td>

        <td>₹<%= itemTotal %></td>
    </tr>
<%
    }
%>
</table>

<div class="total">
    Total: ₹<%= total %>
</div>

<form method="post" action="orderSuccess.jsp" onsubmit="showLoader()">
 
  <button type="submit" class="checkout-btn">
        Place Order
    </button>
 
</form>

<%
    } else {
%>
    <p class="empty">Your cart is empty 🛒</p>
<%
    }
%>

</div>

<!-- Loader -->
<div class="loader" id="loader">
    <div></div>
</div>

<script>
    function showLoader() {
        document.getElementById("loader").style.display = "flex";
    }
</script>

</body>
</html>
