/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.elizcarvalho.controller;

import com.github.elizcarvalho.dao.Book2Dao;
import com.github.elizcarvalho.entity.Book2;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Eliz
 */
public class Book2Controller {
   
    @RequestMapping(value="/startRegisterBook.htm", method = RequestMethod.GET )
    public String iniciarCadastroBook(@ModelAttribute("book") Book2 book){
        return "registerBook";
    }
    
    @RequestMapping(value="/registerBook.htm", method = RequestMethod.POST )
    public String cadastrarBook(@ModelAttribute("book") Book2 book){
        Book2Dao bdao = new Book2Dao();
        bdao.registerBook(book);
        return "sucessoBook";
    }
    
    @RequestMapping(value = "/updateBook.htm", method = RequestMethod.POST)
    public String updateBook(@ModelAttribute("book") Book2 book, HttpServletRequest request){
        
        Book2Dao bdao = new Book2Dao();
        bdao.updateBook(book);
        request.setAttribute("message", "The book updated successfully!");
        return "listBook";
        
    }
    
    @RequestMapping(value = "/deleteBook.htm", method = RequestMethod.POST)
    public String deleteBook(@ModelAttribute("book") Book2 book, HttpServletRequest request){
        
        Book2Dao bdao = new Book2Dao();
        bdao.deleteBook(book);
        request.setAttribute("message", "The book delete successfully!");
        return "listBook";
        
    }
    
    @RequestMapping(value = "/listBook.htm", method = RequestMethod.GET)
    public String listaBook(){
        return "listBook";
    }
}
