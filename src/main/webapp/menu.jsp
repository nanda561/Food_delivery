<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ page import="java.util.*" %>
    <%@ page import="com.foodapp.model.Food" %>
      <!DOCTYPE html>
      <html lang="en">

      <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Menu - FoodFlow</title>
        <link rel="stylesheet" href="css/style.css">
      </head>

      <body>
        <header>
          <div class="container">
            <nav>
              <a href="home" class="logo">FoodFlow</a>
              <div class="nav-links">
                <a href="home">Home</a>
                <a href="cart.jsp">Cart</a>
                <a href="login.jsp">Login</a>
              </div>
            </nav>
          </div>
        </header>

        <div class="container" style="padding-top: 50px;">
          <h2 class="section-title">Explore Our Menu</h2>

          <% List<Food> foods = (List<Food>) request.getAttribute("foods");
              if (foods != null && !foods.isEmpty()) {
              %>
              <div style="max-width: 800px; margin: 0 auto;">
                <% int j=0; for (Food f : foods) { String foodImg=(j % 2==0) ? "images/food-pizza.png"
                  : "images/food-burger.png" ; j++; %>
                  <div class="menu-item">
                    <img src="<%= foodImg %>" alt="<%= f.getName() %>">
                    <div class="menu-item-info">
                      <h4>
                        <%= f.getName() %>
                      </h4>
                      <p style="color: var(--text-muted); font-size: 14px;">
                        <%= f.getDescription() %>
                      </p>
                      <div style="margin-top: 10px;">
                        <span class="menu-item-price">₹<%= f.getPrice() %></span>
                      </div>
                    </div>
                    <div>
                      <form method="post" action="cart">
                        <input type="hidden" name="foodId" value="<%= f.getId() %>">
                        <input type="hidden" name="action" value="add">
                        <button type="submit" class="btn">Add to Cart</button>
                      </form>
                    </div>
                  </div>
                  <% } %>
              </div>
              <% } else { %>
                <p style="text-align: center;">No menu items found for this restaurant.</p>
                <% } %>
        </div>

        <footer class="footer">
          <p>&copy; 2026 FoodFlow. All rights reserved.</p>
        </footer>

        <script src="js/app.js"></script>
      </body>

      </html>