/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.elizcarvalho.controller;

import com.github.elizcarvalho.dao.UserDao;
import com.github.elizcarvalho.entity.User;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
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
    
    @RequestMapping(value="/startRegisterUser.htm", method = RequestMethod.GET )
    public String startRegisterUser(@ModelAttribute("user") User user){
        return "registerUser";
    }
    
    @RequestMapping(value="/registerUser.htm", method = RequestMethod.POST )
    public String registerUser(@ModelAttribute("user") User user){
        UserDao udao = new UserDao();
        udao.registerUser(user);
        return "sucesso";
    }
    
    
}
