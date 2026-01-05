package com.foodapp.servlet;

import com.foodapp.dao.RestaurantDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class HomeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            req.setAttribute("restaurants",
                new RestaurantDAO().getAllRestaurants());
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
