/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.elizcarvalho.dao;

import com.github.elizcarvalho.entity.User;
import com.github.elizcarvalho.factory.Factory;
import com.github.elizcarvalho.log.Log;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Eliz
 */
public class UserDao {
   
    Log log = new Log();
    private EntityManager em = Factory.getEntityManager();
    
    //cadastra usuario
    public void registerUser(User user){
        
        user.setPassword(convertStringToSHA256(user.getPassword()));
        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        } catch(Exception e){
            log.gravarLog(e.getStackTrace());
            em.getTransaction().rollback();
        }
    }
    
    //checa se o usuario existe para efetuar o login
    public boolean existUser(User user){
        
        boolean userFound = false;
        user.setPassword(convertStringToSHA256(user.getPassword()));
        try {
            em.getTransaction().begin();
            TypedQuery<User> search = em.createQuery("SELECT u FROM User u WHERE u.username=?1 AND u.password=?2", User.class)
                    .setParameter(1, user.getUsername())
                    .setParameter(2, user.getPassword());
            List<User> list = search.getResultList();
            System.out.println(list);
            if (!list.isEmpty()){
                userFound = true;
            }
        } catch(Exception e){
            log.gravarLog(e.getStackTrace());
            em.getTransaction().rollback();
        }
        return userFound;
    }
    
    
    private String convertStringToSHA256(String valor) {
        
        MessageDigest mDigest;
        try { 
            //instanciei HASH SHA-256,podia ser o MD5 tbm
            mDigest = MessageDigest.getInstance("SHA-256");      
            //converte a var valor q é string em um array de bytes em SHA256
            byte[] valorSHA = mDigest.digest(valor.getBytes("UTF-8"));
            //converte os bytes para string, pra salvar no BD e ficar mais facil comparar
            StringBuilder sb = new StringBuilder();
            for (byte b : valorSHA){
                sb.append(String.format("%02X", 0xFF & b));
            }
            String passEncrip = sb.toString();
            return passEncrip;
            
         } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            log.gravarLog(e.getStackTrace()); 
            return null;
         }
        
  }
    
}
