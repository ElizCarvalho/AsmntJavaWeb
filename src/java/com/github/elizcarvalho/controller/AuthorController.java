/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.elizcarvalho.controller;

import com.github.elizcarvalho.dao.AuthorDao;
import com.github.elizcarvalho.entity.Author;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Eliz
 */
@Controller
public class AuthorController {
    
    @RequestMapping(value="/startRegisterAuthor.htm", method = RequestMethod.GET )
    public String startRegisterAuthor(@ModelAttribute("author") Author author){
        return "registerAuthor";
    }
    
    @RequestMapping(value="/registerAuthor.htm", method = RequestMethod.POST )
    public String registerAuthor(@ModelAttribute("author") Author author){ 
        AuthorDao adao = new AuthorDao();
        adao.register(author);
        return "sucessoAuthor";
    }
    
    @RequestMapping(value = "/updateAuthor.htm", method = RequestMethod.GET)
    public String updateBook(@ModelAttribute("author") Author author, HttpServletRequest request){
        AuthorDao adao = new AuthorDao();
        //adao.update(author);
        List<Object> list = adao.list();
        request.setAttribute("listAuthor", list);
        return "listAuthor";   
    }
    
    @RequestMapping(value = "/deleteAuthor.htm", method = RequestMethod.GET)
    public String deleteAuthor(HttpServletRequest request, @RequestParam("id") String id){
        AuthorDao adao = new AuthorDao();
        adao.delete(Integer.parseInt(id));
        List<Object> list = adao.list();
        request.setAttribute("listAuthor", list);
        return "listAuthor"; 
    }
    
    @RequestMapping(value = "/listAuthor.htm", method = RequestMethod.GET)
    public String listAuthor(HttpServletRequest req){
        AuthorDao adao = new AuthorDao();
        List<Object> list = adao.list();
        req.setAttribute("listAuthor", list);
        return "listAuthor";
    }
    
}
