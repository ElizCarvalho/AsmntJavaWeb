/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.elizcarvalho.dao;

import com.github.elizcarvalho.entity.Author;
import com.github.elizcarvalho.factory.Factory;
import com.github.elizcarvalho.log.Log;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Eliz
 */
public class AuthorDao implements IDao{
    
    Log log = new Log();
    private EntityManager em = Factory.getEntityManager();
    
    @Override
    public void register(Object object) {
        try{
            //so cadastra se o autor ainda nao existir no bd
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
        
        Author author = (Author)object;
        try{
            em.getTransaction().begin();
            author = em.find(Author.class, author.getId());
            em.remove(author);
            em.getTransaction().commit();
        } catch(Exception e){
            log.gravarLog(e.getStackTrace());
            em.getTransaction().rollback();
        }  
    }
    
    @Override
    public List<Object> list() {
        
        List<Object> allAuthor = null;
        try{
            em.getTransaction().begin();
            allAuthor = em.createNamedQuery("Author.findAll").getResultList();
        
        } catch(Exception e){
            log.gravarLog(e.getStackTrace());
            em.getTransaction().rollback();
        }
        return allAuthor;
    }

    
    @Override
    public void update(int id) {
         //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean existOne(Object object) {
        
        Author author = (Author)object;
        //checa se o autor ja foi cadastrado        
        boolean authorFound = false;
        try {
            em.getTransaction().begin();
            TypedQuery<Author> search = em.createNamedQuery("Author.findByName", Author.class)
                    .setParameter(1, author.getName());
            List<Author> list = search.getResultList();
            System.out.println(list);
            if (!list.isEmpty()){
                authorFound = true;
            }
        } catch(Exception e){
            log.gravarLog(e.getStackTrace());
            em.getTransaction().rollback();
        }
        return authorFound;
    }
            
    
}
