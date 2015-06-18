package com.diajar.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");
        
        if(user.equals("test") && pwd.equals("12345")){
        	response.sendRedirect("login_suksess.jsp");
        }
		
	}

}
