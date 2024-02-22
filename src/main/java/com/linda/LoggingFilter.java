package com.linda;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

@WebFilter("/*")
public class LoggingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
     
        HttpServletRequest httpRequest = (HttpServletRequest) request;

     
        String requestURI = httpRequest.getRequestURI();

 
        System.out.println("Request received: " + request.getRemoteAddr() + " - " + requestURI);

        chain.doFilter(request, response);

     
        System.out.println("Response sent: " + response.getContentType());
    }

    @Override
    public void destroy() {

    }
}

