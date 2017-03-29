/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.elizcarvalho.dao;

import com.github.elizcarvalho.entity.User;
import com.github.elizcarvalho.factory.Factory;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Eliz
 */
public class UserDao {
   
    private EntityManager em = Factory.getEntityManager();
    
    
    //cadastra usuario
    public void cadastrarUser(User user){
        
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        
    }
    
    //checa se o usuario existe para efetuar o login
    public boolean existUser(User user){
        
        boolean userFound = false;
        List<User> list;
        em.getTransaction().begin();
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
