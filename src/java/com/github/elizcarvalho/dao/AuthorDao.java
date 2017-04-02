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
        
        Author author = (Author)object;
        try{
            em.getTransaction().begin();
            author = em.find(Author.class, author.getId());
            em.remove(author);
            em.getTransaction().commit();
            em.close();
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
            em.close();
        } catch(Exception e){
            log.gravarLog(e.getStackTrace());
            em.getTransaction().rollback();
        }
        return allAuthor;
    }
    
    @Override
    public Object searchForId(int id) {   
       return em.find(Author.class, id);
    }

    
    @Override
    public void update(Object object) {
        Author author = (Author)object;
        try{
            em.getTransaction().begin();
            em.merge(author);
            em.getTransaction().commit();
            em.close();
        } catch(Exception e){
            log.gravarLog(e.getStackTrace());
            em.getTransaction().rollback();
        } 
    }

    @Override
    public boolean existOne(Object object) {
        
        Author author = (Author)object;
        //checa se o autor ja foi cadastrado        
        boolean authorFound = false;
        try {
            em.getTransaction().begin();
            TypedQuery<Author> search = em.createQuery("SELECT a FROM Author a WHERE a.name=?1", Author.class)
                    .setParameter(1, author.getName());
            List<Author> list = search.getResultList();
            if (list.isEmpty()==false){
                authorFound = true;
            }
        } catch(Exception e){
            log.gravarLog(e.getStackTrace());
            em.getTransaction().rollback();
        }
        return authorFound;
    }
            
    
}
