/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.elizcarvalho.controller;

import com.github.elizcarvalho.dao.BookDao;
import com.github.elizcarvalho.entity.Book;
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
public class BookController {
    
    @RequestMapping(value="/startRegisterBook.htm", method = RequestMethod.GET )
    public String startRegisterBook(@ModelAttribute("book") Book book){
        return "registerBook";
    }
    
    @RequestMapping(value="/registerBook.htm", method = RequestMethod.POST )
    public String registerBook(@ModelAttribute("book") Book book){
        BookDao bdao = new BookDao();
        bdao.register(book);
        return "sucessoBook";
    }
    
    @RequestMapping(value = "/updateBook.htm", method = RequestMethod.GET)
    public String updateBook(@ModelAttribute("book") Book book, HttpServletRequest request){
        BookDao bdao = new BookDao();
        //bdao.update(book);
        request.setAttribute("message", "The book updated successfully!");
        return "listBook";
        
    }
    
    @RequestMapping(value = "/deleteBook.htm", method = RequestMethod.GET)
    public String deleteBook(HttpServletRequest request, @RequestParam("id") String id){
        BookDao bdao = new BookDao();
        bdao.delete(Integer.parseInt(id));
        List<Object> list = bdao.list();
        request.setAttribute("listBook", list);
        return "listBook";
        
    }
    
    @RequestMapping(value = "/listBook.htm", method = RequestMethod.GET)
    public String listBook(HttpServletRequest req){
        BookDao bdao = new BookDao();
        List<Object> list = bdao.list();
        req.setAttribute("listBook", list);
        return "listBook";
    }
    
}
