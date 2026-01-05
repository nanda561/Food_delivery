package com.foodapp.servlet.admin;

import com.foodapp.dao.AdminFoodDAO;
import com.foodapp.model.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class AddFoodServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        try {
            User admin = (User) req.getSession().getAttribute("user");

            Food f = new Food();
            f.setRestaurantId(admin.getId());
            f.setName(req.getParameter("name"));
            f.setDescription(req.getParameter("description"));
            f.setPrice(Double.parseDouble(req.getParameter("price")));
            f.setCategory(req.getParameter("category"));

            new AdminFoodDAO().addFood(f);
            resp.sendRedirect("dashboard");

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
