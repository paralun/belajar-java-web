/*
 * Copyright (c) 2016 | James Kusmambang
 * Source : https://github.com/paralun
 */
package com.paralun.app.controller;

import com.paralun.app.dao.ClubDao;
import com.paralun.app.model.Club;
import com.paralun.app.util.DatabaseUtil;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/clubs", description = "ClubController")
public class DaftarClubServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            ClubDao dao = DatabaseUtil.getClubDao();
            List<Club> clubs = dao.getClubs();
            
            request.setAttribute("clubs", clubs);
            request.getRequestDispatcher("page/list-club.jsp").forward(request, response);
        }catch(ServletException | IOException ex){
            
        }
    }
}
