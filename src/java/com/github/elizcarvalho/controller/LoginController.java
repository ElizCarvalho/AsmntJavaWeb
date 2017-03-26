/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.elizcarvalho.controller;

import com.github.elizcarvalho.dao.UserDao;
import com.github.elizcarvalho.entity.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Eliz
 */
@Controller
public class LoginController {
    
    //serve para mapear a pagina de login
    @RequestMapping(value = "/login.htm", method = RequestMethod.GET)
    public String loginForm(@ModelAttribute("user") User user, HttpSession session) {
        
        String token = (String) session.getAttribute("token");
        if(token!=null && token.equals("approved")){
            return "index";
        }
        return "login";
    }

    //esse é chamado pelo formulario de login
    //se o login estiver certo, encaminha para pagina index
    @RequestMapping(value = "/efetuarLogin.htm", method = RequestMethod.POST)
    public String efetuarLogin(@ModelAttribute("user") User user, HttpSession session, HttpServletRequest request){
        
        UserDao udao = new UserDao();
        if(udao.existUser(user)){
        //if(user.getUsername().equals("root") && user.getPassword().equals("root")){
            session.setAttribute("token", "approved");
            return "index";
        }
        request.setAttribute("message", "Username or password invalid");
        return "login";
        
    }
    
    
    
}
