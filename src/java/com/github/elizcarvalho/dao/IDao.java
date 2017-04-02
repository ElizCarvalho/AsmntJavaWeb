/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.elizcarvalho.dao;

import java.util.List;

/**
 *
 * @author Eliz
 */
public interface IDao {
    
    public void register(Object object);
    public void delete(Object object);
    public List<Object> list();
    public void update(Object object);
    public boolean existOne(Object object);
}
