package com.foodapp.servlet;

import com.foodapp.dao.FoodDAO;
import com.foodapp.model.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.*;

public class CartServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        try {
            String action = req.getParameter("action");
            int foodId = Integer.parseInt(req.getParameter("foodId"));

            HttpSession session = req.getSession();
            Map<Integer, CartItem> cart =
                (Map<Integer, CartItem>) session.getAttribute("cart");

            if (cart == null) {
                cart = new LinkedHashMap<>();
            }

            Food food = new FoodDAO().getFoodById(foodId);

            switch (action) {

                case "add":
                case "inc":
                    if (cart.containsKey(foodId)) {
                        cart.get(foodId)
                            .setQuantity(cart.get(foodId).getQuantity() + 1);
                    } else {
                        CartItem item = new CartItem();
                        item.setFood(food);
                        item.setQuantity(1);
                        cart.put(foodId, item);
                    }
                    break;

                case "dec":
                    if (cart.containsKey(foodId)) {
                        CartItem item = cart.get(foodId);
                        int qty = item.getQuantity() - 1;

                        if (qty <= 0) {
                            cart.remove(foodId);
                        } else {
                            item.setQuantity(qty);
                        }
                    }
                    break;
            }

            session.setAttribute("cart", cart);

            // 🔥 Redirect logic (THIS SOLVES YOUR PROBLEM)
            if ("add".equals(action)) {
                resp.sendRedirect(req.getHeader("Referer")); // stay on menu
            } else {
                resp.sendRedirect("cart.jsp"); // stay on cart
            }

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}