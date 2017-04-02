/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.elizcarvalho.dao;

import com.github.elizcarvalho.entity.Book;
import com.github.elizcarvalho.factory.Factory;
import com.github.elizcarvalho.log.Log;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Eliz
 */

public class BookDao implements IDao{
    
    Log log = new Log();
    
    private EntityManager em = Factory.getEntityManager();

    @Override
    public void register(Object object) {
       try{
            //so cadastra se o livro ainda nao existir no bd
            if (!existOne(object)==true){
                em.getTransaction().begin();
                em.persist(object);
                em.getTransaction().commit();
            }
        } catch(Exception e){
            log.gravarLog(e.getStackTrace());
            em.getTransaction().rollback();
        }
    }

    @Override
    public void delete(Object object) {
        
        Book book = (Book)object;
        try{
            em.getTransaction().begin();
            book = em.find(Book.class, book.getId());
            em.remove(book);
            em.getTransaction().commit();
        
        } catch(Exception e){
            log.gravarLog(e.getStackTrace());
            em.getTransaction().rollback();
        }
    }

    @Override
    public List<Object> list() {
        
        List<Object> allBook = null;
        try{
            em.getTransaction().begin();
            allBook = em.createNamedQuery("Book.findAll").getResultList();
        
        } catch(Exception e){
            log.gravarLog(e.getStackTrace());
            em.getTransaction().rollback();
        }
        return allBook;
    }

    @Override
    public void update(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean existOne(Object object) {
        
        Book book = (Book)object;
        //checa se o livro ja foi cadastrado        
        boolean bookFound = false;
        try {
            em.getTransaction().begin();
            TypedQuery<Book> search = em.createNamedQuery("Book.findByTitle", Book.class)
                    .setParameter(1, book.getTitle());
            List<Book> list = search.getResultList();
            System.out.println(list);
            if (!list.isEmpty()){
                bookFound = true;
            }
        } catch(Exception e){
            log.gravarLog(e.getStackTrace());
            em.getTransaction().rollback();
        }
        return bookFound;
        
    }
    
}
