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
                em.persist(object);
                em.getTransaction().commit();
                em.close();
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
            em.close();
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
            em.close();
        } catch(Exception e){
            log.gravarLog(e.getStackTrace());
            em.getTransaction().rollback();
        }
        return allBook;
    }

    @Override
    public Object searchForId(int id) {   
       return em.find(Book.class, id);
    }
    
    @Override
    public void update(Object object) {
        Book book = (Book)object;
        try{
            em.getTransaction().begin();
            em.merge(book);
            em.getTransaction().commit();
            em.close();
        } catch(Exception e){
            log.gravarLog(e.getStackTrace());
            em.getTransaction().rollback();
        }
    }

    @Override
    public boolean existOne(Object object) {
        
        Book book = (Book)object;
        //checa se o livro ja foi cadastrado        
        boolean bookFound = false;
        try {
            em.getTransaction().begin();
            TypedQuery<Book> search = em.createQuery("SELECT b FROM Book b WHERE b.title=?1 AND b.author=?2 AND b.pubcomp=?3", Book.class)
                    .setParameter(1, book.getTitle())
                    .setParameter(2, book.getAuthor())
                    .setParameter(3, book.getPubcomp());
            List<Book> list = search.getResultList();
            if (list.isEmpty()==false){
                bookFound = true;
            }
        } catch(Exception e){
            log.gravarLog(e.getStackTrace());
            em.getTransaction().rollback();
        }
        return bookFound;
        
    }
    
}
