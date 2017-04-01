/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.elizcarvalho.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author Eliz
 */
public class LoginInterceptor extends HandlerInterceptorAdapter{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        
        HttpSession session = request.getSession();
        String token = (String) session.getAttribute("token");
        String uri = request.getRequestURI();
        if (uri.endsWith("singIn.htm") || uri.endsWith("login.htm") || uri.endsWith("registerUser.htm")
           || uri.endsWith("sucesso.htm") || uri.endsWith("startRegisterUser.htm")
           ||(token!=null && token.equals("approved"))){
            return true;
        }
        else{
            response.sendRedirect("login.htm");
            return false;
        }
        
    }
   
}
