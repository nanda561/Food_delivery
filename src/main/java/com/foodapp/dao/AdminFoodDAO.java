package com.foodapp.dao;

import com.foodapp.model.Food;
import com.foodapp.util.DBConnection;

import java.sql.*;
import java.util.*;

public class AdminFoodDAO {

    public void addFood(Food f) throws Exception {
        String sql = """
            INSERT INTO foods(restaurant_id,name,description,price,image,category)
            VALUES (?,?,?,?,?,?)
        """;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, f.getRestaurantId());
            ps.setString(2, f.getName());
            ps.setString(3, f.getDescription());
            ps.setDouble(4, f.getPrice());
            ps.setString(5, f.getImage());
            ps.setString(6, f.getCategory());
            ps.executeUpdate();
        }
    }

    public List<Food> getFoodsByRestaurant(int rid) throws Exception {
        List<Food> list = new ArrayList<>();
        String sql = "SELECT * FROM foods WHERE restaurant_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, rid);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Food f = new Food();
                f.setId(rs.getInt("id"));
                f.setName(rs.getString("name"));
                f.setPrice(rs.getDouble("price"));
                f.setCategory(rs.getString("category"));
                list.add(f);
            }
        }
        return list;
    }

    public void deleteFood(int foodId) throws Exception {
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps =
                 con.prepareStatement("DELETE FROM foods WHERE id=?")) {
            ps.setInt(1, foodId);
            ps.executeUpdate();
        }
    }
}
