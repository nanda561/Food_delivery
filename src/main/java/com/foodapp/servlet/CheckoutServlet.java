package com.foodapp.servlet;

import com.foodapp.model.*;
import com.foodapp.util.DBConnection;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.*;
import java.util.*;


public class CheckoutServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        Map<Integer, CartItem> cart =
            (Map<Integer, CartItem>) session.getAttribute("cart");

        if (user == null || cart == null || cart.isEmpty()) {
            resp.sendRedirect("cart.jsp");
            return;
        }

        try (Connection con = DBConnection.getConnection()) {

            con.setAutoCommit(false);

            double total = 0;
            for (CartItem item : cart.values()) {
                total += item.getFood().getPrice() * item.getQuantity();
            }

            PreparedStatement psOrder = con.prepareStatement(
                "INSERT INTO orders(user_id, total_price, order_status) VALUES (?, ?, ?)",
                Statement.RETURN_GENERATED_KEYS
            );

            psOrder.setInt(1, user.getId());
            psOrder.setDouble(2, total);
            psOrder.setString(3, "Preparing");
            psOrder.executeUpdate();

            ResultSet rs = psOrder.getGeneratedKeys();
            rs.next();
            int orderId = rs.getInt(1);

            PreparedStatement psItem = con.prepareStatement(
                "INSERT INTO order_items(order_id, food_id, quantity, price) VALUES (?, ?, ?, ?)"
            );

            for (CartItem item : cart.values()) {
                psItem.setInt(1, orderId);
                psItem.setInt(2, item.getFood().getId());
                psItem.setInt(3, item.getQuantity());
                psItem.setDouble(4, item.getFood().getPrice());
                psItem.addBatch();
            }

            psItem.executeBatch();
            con.commit();

            session.removeAttribute("cart");
            resp.sendRedirect("orderSuccess.jsp");

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}


