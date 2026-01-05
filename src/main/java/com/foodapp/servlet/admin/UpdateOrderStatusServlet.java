package com.foodapp.servlet.admin;

import com.foodapp.dao.AdminOrderDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class UpdateOrderStatusServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        try {
            int orderId = Integer.parseInt(req.getParameter("orderId"));
            String status = req.getParameter("status");

            new AdminOrderDAO().updateStatus(orderId, status);
            resp.sendRedirect("dashboard");

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
