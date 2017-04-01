/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.elizcarvalho.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Eliz
 */
@NamedQueries({
    @NamedQuery(name = "PublishingComp.findAll", query = "SELECT p FROM PublishingComp p")
    , @NamedQuery(name = "PublishingComp.findById", query = "SELECT p FROM PublishingComp p WHERE p.id = :id")
    , @NamedQuery(name = "PublishingComp.findByName", query = "SELECT p FROM PublishingComp p WHERE p.name = :name")})

@Entity
public class PublishingComp implements Serializable {
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.toUpperCase().trim();
    }
    
}
