/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.elizcarvalho.entity;

import java.io.Serializable;
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
@Table(name = "livro2")
@NamedQueries({
    @NamedQuery(name = "Livro2.findAll", query = "SELECT l FROM Livro2 l")
    , @NamedQuery(name = "Livro2.findByIdlivro", query = "SELECT l FROM Livro2 l WHERE l.idlivro = :idlivro")
    , @NamedQuery(name = "Livro2.findByTitulo", query = "SELECT l FROM Livro2 l WHERE l.titulo = :titulo")
    , @NamedQuery(name = "Livro2.findByAutor", query = "SELECT l FROM Livro2 l WHERE l.autor = :autor")
    , @NamedQuery(name = "Livro2.findByEditora", query = "SELECT l FROM Livro2 l WHERE l.editora = :editora")
    , @NamedQuery(name = "Livro2.findByAnolancamento", query = "SELECT l FROM Livro2 l WHERE l.anolancamento = :anolancamento")})
public class Livro2 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idlivro")
    private Integer idlivro;
    
    @Column(name = "titulo")
    private String titulo;
    
    @Column(name = "autor")
    private String autor;
    
    @Column(name = "editora")
    private String editora;
    
    @Column(name = "anolancamento")
    private int anolancamento;


    public Integer getIdlivro() {
        return idlivro;
    }

    public void setIdlivro(Integer idlivro) {
        this.idlivro = idlivro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public int getAnolancamento() {
        return anolancamento;
    }

    public void setAnolancamento(int anolancamento) {
        this.anolancamento = anolancamento;
    }
    
}
