/*
 * Copyright (c) 2016 | James Kusmambang
 * Source : https://github.com/paralun
 */
package com.paralun.app.controller;

import com.paralun.app.dao.ClubDao;
import com.paralun.app.util.DatabaseUtil;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/delete-club")
public class DeleteClubServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ClubDao dao = DatabaseUtil.getClubDao();
            String id = req.getParameter("id");
            System.out.println("Waktu Delete " + id);
            dao.delete(Integer.parseInt(id));
            
            resp.sendRedirect("clubs");
        }catch(NumberFormatException | IOException ex){}
    }
}
