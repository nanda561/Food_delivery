package com.foodapp.dao;

import com.foodapp.model.Food;
import com.foodapp.util.DBConnection;

import java.sql.*;
import java.util.*;

public class FoodDAO {

    public List<Food> getFoodsByRestaurant(int restaurantId) throws Exception {
        List<Food> list = new ArrayList<>();
        String sql = "SELECT * FROM foods WHERE restaurant_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, restaurantId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Food f = new Food();
                f.setId(rs.getInt("id"));
                f.setRestaurantId(restaurantId);
                f.setName(rs.getString("name"));
                f.setDescription(rs.getString("description"));
                f.setPrice(rs.getDouble("price"));
                f.setImage(rs.getString("image"));
                f.setCategory(rs.getString("category"));
                list.add(f);
            }
        }
        return list;
    }

    public Food getFoodById(int id) throws Exception {
        String sql = "SELECT * FROM foods WHERE id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Food f = new Food();
                f.setId(id);
                f.setRestaurantId(rs.getInt("restaurant_id"));
                f.setName(rs.getString("name"));
                f.setDescription(rs.getString("description"));
                f.setPrice(rs.getDouble("price"));
                return f;
            }
        }
        return null;
    }
}
