/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.elizcarvalho.dao;

import com.github.elizcarvalho.entity.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Eliz
 */
public class UserDao {
   
    private EntityManagerFactory factory = null;
    private EntityManager em = null;
    
    
    public UserDao(){
        factory = Persistence.createEntityManagerFactory("AsmntJavaWebPU");
        em = factory.createEntityManager();
    }
    
    public void cadastrarUser(User user){
        
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();
        
    }
    
    
    public boolean existUser(User user){
        
        boolean userFound = false;
        List<User> list;

        TypedQuery<User> search = em.createQuery("SELECT u FROM User u WHERE u.username=?1 AND u.password=?2", User.class)
                .setParameter(1, user.getUsername())
                .setParameter(2, user.getPassword());
        
        list = search.getResultList();

        System.out.println(list);
        if (!list.isEmpty()){
            userFound = true;
        }
        
        return userFound;
    }
    
}
