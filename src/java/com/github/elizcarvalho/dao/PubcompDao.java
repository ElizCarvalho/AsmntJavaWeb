/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.elizcarvalho.dao;

import com.github.elizcarvalho.entity.Pubcomp;
import com.github.elizcarvalho.factory.Factory;
import com.github.elizcarvalho.log.Log;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Eliz
 */
public class PubcompDao implements IDao{

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
        
        Pubcomp pubComp = (Pubcomp)object;
        try{
            em.getTransaction().begin();
            Pubcomp pubCom = em.find(Pubcomp.class, pubComp.getId());
            em.remove(pubCom);
            em.getTransaction().commit();
        
        } catch(Exception e){
            log.gravarLog(e.getStackTrace());
            em.getTransaction().rollback();
        }
        
    }

    @Override
    public List<Object> list() {
        
        List<Object> allPubCom = null;
        try{
            em.getTransaction().begin();
            allPubCom = em.createNamedQuery("Pubcomp.findAll").getResultList();
        
        } catch(Exception e){
            log.gravarLog(e.getStackTrace());
            em.getTransaction().rollback();
        }
        return allPubCom;
        
    }

    @Override
    public void update(Object object) {
    
    }

    @Override
    public boolean existOne(Object object) {
        
        Pubcomp pubComp = (Pubcomp)object;
        //checa se o autor ja foi cadastrado        
        boolean pubCompFound = false;
        try {
            em.getTransaction().begin();
            TypedQuery<Pubcomp> search = em.createNamedQuery("Pubcomp.findByName", Pubcomp.class)
                    .setParameter(1, pubComp.getName());
            List<Pubcomp> list = search.getResultList();
            System.out.println(list);
            if (!list.isEmpty()){
                pubCompFound = true;
            }
        } catch(Exception e){
            log.gravarLog(e.getStackTrace());
            em.getTransaction().rollback();
        }
        return pubCompFound;
    }
    
}
