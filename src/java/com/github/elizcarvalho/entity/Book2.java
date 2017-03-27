/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.elizcarvalho.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
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
@Entity
@Table(name = "book2")
@NamedQueries({
    @NamedQuery(name = "Book2.findAll", query = "SELECT b FROM Book2 b")
    , @NamedQuery(name = "Book2.findByIdbook", query = "SELECT b FROM Book2 b WHERE b.idbook = :idbook")
    , @NamedQuery(name = "Book2.findByTitle", query = "SELECT b FROM Book2 b WHERE b.title = :title")
    , @NamedQuery(name = "Book2.findByAuthor", query = "SELECT b FROM Book2 b WHERE b.author = :author")
    , @NamedQuery(name = "Book2.findByPublishingcomp", query = "SELECT b FROM Book2 b WHERE b.publishingcomp = :publishingcomp")
    , @NamedQuery(name = "Book2.findByReleaseyear", query = "SELECT b FROM Book2 b WHERE b.releaseyear = :releaseyear")})
public class Book2 implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "idbook")
    private Integer idbook;
    
    @Column(name = "title")
    private String title;
    
    @Column(name = "author")
    private String author;
    
    @Column(name = "publishingcomp")
    private String publishingcomp;
    
    @Column(name = "releaseyear")
    private int releaseyear;

    public Integer getIdbook() {
        return idbook;
    }

    public void setIdbook(Integer idbook) {
        this.idbook = idbook;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishingcomp() {
        return publishingcomp;
    }

    public void setPublishingcomp(String publishingcomp) {
        this.publishingcomp = publishingcomp;
    }

    public int getReleaseyear() {
        return releaseyear;
    }

    public void setReleaseyear(int releaseyear) {
        this.releaseyear = releaseyear;
    }
   
}
