package com.linda;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

import jakarta.servlet.http.HttpSession;
import jakarta.servlet.RequestDispatcher;

@WebServlet("/signin")	
public class LoginServelet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if ("admin@gmail.com".equals(email) && "password".equals(password)) {
        	String userName = "Admin";
            HttpSession session = request.getSession();
            session.setAttribute("userName", userName);
            response.sendRedirect("welcome.html?userName=" + URLEncoder.encode(userName, "UTF-8"));
           // response.sendRedirect("welcome.html");
        } else {
          
            RequestDispatcher dispatcher = request.getRequestDispatcher("signup.html");
            dispatcher.forward(request, response);
        }
    }
	
}
