<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ page import="java.util.*" %>
    <%@ page import="com.foodapp.model.Restaurant" %>
      <!DOCTYPE html>
      <html lang="en">

      <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>FoodFlow - Deliciousness Delivered</title>
        <link rel="stylesheet" href="css/style.css">
      </head>

      <body>
        <header>
          <div class="container">
            <nav>
              <a href="home" class="logo">FoodFlow</a>
              <div class="nav-links">
                <a href="home">Home</a>
                <a href="/cart.jsp">Cart</a>
                <a href="login.jsp">Login</a>
              </div>
            </nav>
          </div>
        </header>

        <div class="hero">
          <div class="hero-content">
            <h1>Cravings Delivered to Your Door</h1>
            <p>Explore the best restaurants in your city.</p>
            <a href="#restaurants" class="btn">Explore Now</a>
          </div>
        </div>

        <div class="container" id="restaurants">
          <h2 class="section-title">Restaurants Near You</h2>

          <% List<Restaurant> list = (List<Restaurant>) request.getAttribute("restaurants");
              if (list != null && !list.isEmpty()) {
              %>
              <div class="grid">
                <% int i=0; for (Restaurant r : list) { String imgPath=(i % 2==0) ? "images/restaurant-pizza.png"
                  : "images/restaurant-burger.png" ; i++; %>
                  <div class="card">
                    <img src="<%= imgPath %>" alt="<%= r.getName() %>">
                    <div class="card-body">
                      <h3>
                        <%= r.getName() %>
                      </h3>
                      <p class="rating">⭐ <%= r.getRating() %>
                      </p>
                      <p>
                        <%= r.getCuisineType() %>
                      </p>
                      <div style="margin-top: 15px;">
                        <a href="menu?rid=<%= r.getId() %>" class="btn">View Menu</a>
                      </div>
                    </div>
                  </div>
                  <% } %>
              </div>
              <% } else { %>
                <p style="text-align: center;">No restaurants found.</p>
                <% } %>
        </div>

        <footer class="footer">
          <p>&copy; 2026 FoodFlow. All rights reserved.</p>
        </footer>

        <script src="js/app.js"></script>
      </body>

      </html>