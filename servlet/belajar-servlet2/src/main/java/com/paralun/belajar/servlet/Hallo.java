/*
 * Copyright (c) 2016 | James Kusmambang
 * Source : https://github.com/paralun
 */
package com.paralun.belajar.servlet;

import com.paralun.belajar.domain.UserSession;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Hallo extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            //HttpSession sess = request.getSession(false);
            HttpSession sess = null;

            if (sess != null) {
                UserSession session = (UserSession) sess.getAttribute(UserSession.sessionName);
                out.println("<html><body>");
                out.println("<h1> You are : " + session.getName() + " </h1>");
                out.println("<form method=POST action='logout'>");
                out.println("<input type=submit value=Logout>");
                out.println("</form>");
                out.println("</body></html>");
            } else {
                out.println("<html><body>");
                out.println("<h1> You are not login yet </h1>");
                out.println("<form method=POST action='login' >");
                out.println("Username : <br>");
                out.println("<input type=text name='name'/><br>");
                out.println("Password : <br>");
                out.println("<input type=password name='password'/><br>");
                out.println("<input type=submit value=Login>");
                out.println("</form>");
                out.println("</body></html>");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
