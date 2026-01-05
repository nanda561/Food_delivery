package com.foodapp.servlet;

import com.foodapp.dao.FoodDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class MenuServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        try {
            int rid = Integer.parseInt(req.getParameter("rid"));
            req.setAttribute("foods",
                new FoodDAO().getFoodsByRestaurant(rid));
            req.getRequestDispatcher("menu.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
