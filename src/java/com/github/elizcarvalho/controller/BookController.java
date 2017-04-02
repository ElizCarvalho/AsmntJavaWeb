/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.elizcarvalho.controller;

import com.github.elizcarvalho.dao.AuthorDao;
import com.github.elizcarvalho.dao.BookDao;
import com.github.elizcarvalho.dao.PubcompDao;
import com.github.elizcarvalho.entity.Author;
import com.github.elizcarvalho.entity.Book;
import com.github.elizcarvalho.entity.Pubcomp;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Eliz
 */
@Controller
public class BookController {
    
    @RequestMapping(value="/startRegisterBook.htm", method = RequestMethod.GET )
    public String startRegisterBook(@ModelAttribute("book") Book book, HttpServletRequest req){
        book.setAuthor(new Author());
        book.setPubcomp(new Pubcomp());
        AuthorDao adao = new AuthorDao();
        PubcompDao pdao = new PubcompDao();
        req.setAttribute("listAuthor", adao.list());
        req.setAttribute("listPubcomp", pdao.list());
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
    
    @RequestMapping(value = "/deleteBook.htm")
    public String deleteBook(Book book){
        BookDao bdao = new BookDao();
        bdao.delete(book);
        return "redirect:listBook.htm"; 
    }
    
    @RequestMapping(value = "/listBook.htm", method = RequestMethod.GET)
    public String listBook(Model model){
        BookDao bdao = new BookDao();
        model.addAttribute("listBook", bdao.list());
        return "listBook";
    }
    
}
