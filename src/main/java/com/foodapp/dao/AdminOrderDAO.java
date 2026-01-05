package com.foodapp.dao;

import com.foodapp.model.Order;
import com.foodapp.util.DBConnection;

import java.sql.*;
import java.util.*;

public class AdminOrderDAO {

    public List<Order> getOrdersByRestaurant(int restaurantId) throws Exception {
        List<Order> list = new ArrayList<>();

        String sql = """
            SELECT o.*
            FROM orders o
            JOIN order_items oi ON o.id = oi.order_id
            JOIN foods f ON oi.food_id = f.id
            WHERE f.restaurant_id=?
            GROUP BY o.id
            ORDER BY o.order_time DESC
        """;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, restaurantId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Order o = new Order();
                o.setId(rs.getInt("id"));
                o.setTotalPrice(rs.getDouble("total_price"));
                o.setStatus(rs.getString("order_status"));
                o.setOrderTime(rs.getTimestamp("order_time"));
                list.add(o);
            }
        }
        return list;
    }

    public void updateStatus(int orderId, String status) throws Exception {
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps =
                 con.prepareStatement("UPDATE orders SET order_status=? WHERE id=?")) {
            ps.setString(1, status);
            ps.setInt(2, orderId);
            ps.executeUpdate();
        }
    }
}
