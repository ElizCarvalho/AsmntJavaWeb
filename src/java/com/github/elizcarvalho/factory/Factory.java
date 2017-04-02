/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.elizcarvalho.factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Eliz
 */
public class Factory {
    
    private static EntityManagerFactory emf;
    private static EntityManager em;
    
    //fica com o nome da entidade de persistencia
    //responsavel por criar entitymanager
    public static EntityManager getEntityManager(){
        if(emf==null){
            emf = Persistence.createEntityManagerFactory("AJavaWebPU");
        }
        return emf.createEntityManager();
    }
}
