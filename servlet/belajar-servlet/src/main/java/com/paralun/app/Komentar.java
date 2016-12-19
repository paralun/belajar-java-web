/*
 * Copyright (c) 2016 | James Kusmambang
 * Source : https://github.com/paralun
 */
package com.paralun.app;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Komentar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String nama = request.getParameter("nama");
            String email = request.getParameter("email");
            String komentar = request.getParameter("komentar");

            // simpan variabel di session
            request.getSession().setAttribute("nama", nama);

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Komentar Anda</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Halo " + nama + "</h1>");
            out.println("<p>Menurut Anda, aplikasi ini " + komentar + "</p>");
            out.println("<p>Terima kasih atas komentar Anda.");
            out.println("Bila ada informasi baru, akan kami kirimkan ke " + email);
            out.println("</body>");
            out.println("</html>");
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
    }// </editor-fold>

}
