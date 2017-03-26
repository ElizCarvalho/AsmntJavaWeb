/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.elizcarvalho.controller;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Eliz
 */
@Controller
public class MainController {
    
    @RequestMapping(value = "/index.htm", method = RequestMethod.GET)
    public String callIndex(){
        return "index";
    }
    
    @RequestMapping(value = "/menu.htm", method = RequestMethod.GET)
    public String callMenu(){
        return "menu";
    }
    
    @RequestMapping(value = "/sucesso.htm", method = RequestMethod.GET)
    public String callSucesso(){
        return "sucesso";
    }
}
