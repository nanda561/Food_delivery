package com.foodapp.servlet;

import com.foodapp.dao.UserDAO;
import com.foodapp.model.User;
import com.foodapp.util.PasswordUtil;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        try {
            String email = req.getParameter("email");
            String password = PasswordUtil.hashPassword(req.getParameter("password"));

            User user = new UserDAO().login(email, password);

            if (user != null) {
                HttpSession session = req.getSession();
                session.setAttribute("user", user);

                resp.sendRedirect("home");
            } else {
                resp.sendRedirect("login.jsp?error=1");
            }

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
