/*
 * Copyright (c) 2016 | James Kusmambang
 * Source : https://github.com/paralun
 */
package com.paralun.app;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = request.getParameter("username");
        String pass = request.getParameter("password");
        
        HttpSession session = null;
        RequestDispatcher dispatcher = null;
        
        if(user.equals("bambang") && pass.equals("12345")) {
            session = request.getSession();
            session.setAttribute("username", user);
            dispatcher = request.getRequestDispatcher("page/welcome.jsp");
        }else {
            dispatcher = request.getRequestDispatcher("page/failure.jsp");
        }
        
        dispatcher.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
