package com.foodapp.filter;

import com.foodapp.model.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class AuthFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession(false);
        User user = (session != null) ? (User) session.getAttribute("user") : null;

        if (user == null || !"RESTAURANT".equals(user.getRole())) {
            ((HttpServletResponse) res).sendRedirect("login.jsp");
            return;
        }
        chain.doFilter(req, res);
    }
}
