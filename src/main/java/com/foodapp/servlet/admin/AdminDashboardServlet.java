package com.foodapp.servlet.admin;

import com.foodapp.dao.*;
import com.foodapp.model.User;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class AdminDashboardServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        try {
            User admin = (User) req.getSession().getAttribute("user");

            req.setAttribute("foods",
                new AdminFoodDAO().getFoodsByRestaurant(admin.getId()));
            req.setAttribute("orders",
                new AdminOrderDAO().getOrdersByRestaurant(admin.getId()));

            req.getRequestDispatcher("/admin/admin_dashboard.jsp")
               .forward(req, resp);

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
