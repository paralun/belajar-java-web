/*
 * Copyright (c) 2016 | James Kusmambang
 * Source : https://github.com/paralun
 */
package com.paralun.belajar.servlet;

import com.paralun.belajar.domain.UserList;
import com.paralun.belajar.domain.UserSession;
import com.paralun.belajar.domain.listener.SessionListener;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserLogin extends HttpServlet {
      
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<html><body>");
            out.println("<h1> We don't support Get request </h1>");
            out.println("</body></html>");
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String name = (String) request.getParameter("name");
            String password = (String) request.getParameter("password");
            
            if (name.equals("")) {
                out.println(errorAppend("<h1> Name cannot be empty </h1>"));
            }
            
            if (password.equals("")) {
                out.println(errorAppend("<h1> Password cannot be empty </h1>"));
            }
            
            if (UserList.getInstance().validUser(name, password)) {
                if (!SessionListener.isUserLogin(name)) {
                    // create user session object
                    UserSession userSession = new UserSession(name);
                    
                    HttpSession session = request.getSession(true);
                    session.setAttribute(UserSession.sessionName, userSession);
                    
                    SessionListener.addLoginUser(name, session);
                    
                    response.sendRedirect("main");
                } else {
                    out.println(errorAppend("<h1> User is already login, you should wait for user logout first </h1>"));
                }
            } else {
                out.println(errorAppend("<h1> Invalid User </h1>"));
            }
        }
    }
    
    private String errorAppend(String error) {
        StringBuilder buff = new StringBuilder();
        buff.append("<html><body>");
        buff.append(error);
        buff.append("<a href='' onClick='history.back()'> <- back </a>");
        buff.append("</body></html>");
        
        return buff.toString();
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }
    
}
