package com.foodapp.servlet;

import com.foodapp.dao.RestaurantDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class RestaurantServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        try {
			req.setAttribute("restaurants",
			    new RestaurantDAO().getAllRestaurants());
			req.getRequestDispatcher("restaurants.jsp").forward(req, res);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
        
    }
}
