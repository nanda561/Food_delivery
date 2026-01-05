package com.foodapp.dao;

import com.foodapp.model.Restaurant;
import com.foodapp.util.DBConnection;

import java.sql.*;
import java.util.*;

public class RestaurantDAO {

    public List<Restaurant> getAllRestaurants() throws Exception {
        List<Restaurant> list = new ArrayList<>();
        String sql = "SELECT * FROM restaurants";

        try (Connection con = DBConnection.getConnection();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Restaurant r = new Restaurant();
                r.setId(rs.getInt("id"));
                r.setName(rs.getString("name"));
                r.setLocation(rs.getString("location"));
                r.setRating(rs.getDouble("rating"));
                r.setImage(rs.getString("image"));
                r.setCuisineType(rs.getString("cuisine_type"));
                list.add(r);
            }
        }
        return list;
    }
}
