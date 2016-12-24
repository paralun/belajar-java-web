/*
 * Copyright (c) 2016 | James Kusmambang
 * Source : https://github.com/paralun
 */
package com.paralun.app.controller;

import com.paralun.app.dao.ClubDao;
import com.paralun.app.model.Club;
import com.paralun.app.util.DatabaseUtil;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/edit-club", description = "EditClubServlet")
public class EditClubServlet extends HttpServlet {
    
    private ClubDao dao;

    @Override
    public void init() throws ServletException {
        dao = DatabaseUtil.getClubDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Club club = new Club();
        String id = req.getParameter("id");
        System.out.println("Waktu GET " + id);
        if(id != null) {
            club = dao.getClub(Integer.parseInt(id));
        }
        
        req.setAttribute("club", club);
        req.getRequestDispatcher("page/edit-club.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Club club = new Club();
        club.setNamaClub(req.getParameter("nama"));
        club.setStadion(req.getParameter("stadion"));
        
        String id = req.getParameter("id");
        System.out.println("Waktu POST " + id);
        if(id != null && !id.trim().equals("0")) {
            club.setId(Integer.parseInt(id));
            dao.update(club);
        }else {
            System.out.println("Waktu Save");
            dao.save(club);
        }
        
        resp.sendRedirect("clubs");
    }
}
