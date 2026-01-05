package com.foodapp.servlet;

import com.foodapp.dao.UserDAO;
import com.foodapp.model.User;
import com.foodapp.util.PasswordUtil;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        try {
            User user = new User();
            user.setName(req.getParameter("name"));
            user.setEmail(req.getParameter("email"));
            user.setRole(req.getParameter("role"));
            user.setPassword(
                PasswordUtil.hashPassword(req.getParameter("password"))
            );

            new UserDAO().register(user);
            resp.sendRedirect("login.jsp");

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
