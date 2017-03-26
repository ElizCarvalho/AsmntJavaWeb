/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.elizcarvalho.controller;

import com.github.elizcarvalho.dao.UserDao;
import com.github.elizcarvalho.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Eliz
 */
@Controller
public class UserController {
    
    @RequestMapping(value="/iniciaCadastroUser.htm", method = RequestMethod.GET )
    public String iniciarCadastroUser(@ModelAttribute("user") User user){
        return "registerUser";
    }
    
    @RequestMapping(value="/cadastrarUser.htm", method = RequestMethod.POST )
    public String cadastrarUser(@ModelAttribute("user") User user){
        UserDao udao = new UserDao();
        udao.cadastrarUser(user);
        return "sucesso";
    }
    
    
}
