/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.elizcarvalho.controller;

import com.github.elizcarvalho.dao.AuthorDao;
import com.github.elizcarvalho.dao.PubcompDao;
import com.github.elizcarvalho.entity.Pubcomp;
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
public class PubcompController {
    
    @RequestMapping(value="/startRegisterPubcomp.htm", method = RequestMethod.GET )
    public String startRegisterPubcomp(@ModelAttribute("pubcomp") Pubcomp pubcomp){
        return "registerPubcomp";
    }
    
    @RequestMapping(value="/registerPubcomp.htm", method = RequestMethod.POST )
    public String registerAuthor(@ModelAttribute("pubcomp") Pubcomp pubcomp){ 
        PubcompDao pdao = new PubcompDao();
        pdao.register(pubcomp);
        return "sucessoPubcomp";
    }
    
    @RequestMapping(value = "/updatePubcomp.htm", method = RequestMethod.GET)
    public String updateBook(@ModelAttribute("pubcomp") Pubcomp pubcomp, HttpServletRequest request){
        PubcompDao pdao = new PubcompDao();
        //adao.update(author);
        List<Object> list = pdao.list();
        request.setAttribute("listPubcomp", list);
        return "listPubcomp";   
    }
    
    @RequestMapping(value = "/deletePubcomp.htm", method = RequestMethod.GET)
    public String deleteAuthor(HttpServletRequest request, @RequestParam("id") String id){
        PubcompDao pdao = new PubcompDao();
        pdao.delete(Integer.parseInt(id));
        List<Object> list = pdao.list();
        request.setAttribute("listPubcomp", list);
        return "listPubcomp"; 
    }
    
    @RequestMapping(value = "/listPubcomp.htm", method = RequestMethod.GET)
    public String listAuthor(HttpServletRequest req){
        PubcompDao pdao = new PubcompDao();
        List<Object> list = pdao.list();
        req.setAttribute("listPubcomp", list);
        return "listPubcomp"; 
    }
    
}
