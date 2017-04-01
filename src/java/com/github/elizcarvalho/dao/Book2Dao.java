///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.github.elizcarvalho.dao;
//
//import com.github.elizcarvalho.entity.Book2;
//import com.github.elizcarvalho.factory.Factory;
//import java.util.List;
//import javax.persistence.EntityManager;
//import javax.persistence.Query;
//
///**
// *
// * @author Eliz
// */
//public class Book2Dao{
//    
//    private EntityManager em = Factory.getEntityManager();
//    
//    //cadastra o livro
//    public void registerBook(Book2 book){
//        
//        try{
//            //so cadastra se o livro ainda nao existir no bd
//            if (!existBook(book)==true){
//                em.getTransaction().begin();
//                em.persist(book);
//                em.getTransaction().commit();
//            }
//        } catch(Exception ex){
//            ex.printStackTrace();
//            em.getTransaction().rollback();
//        }
//          
//    }
//    
//    //checa se o livro está cadastrado atraves do titulo
//    public boolean existBook(Book2 book){
//        
//        boolean bookFound = false;
//        Query q = em.createNamedQuery("Book2.findByTitle", Book2.class)
//                .setParameter("title", book.getTitle());
//        List<Book2> list = q.getResultList();
//        if (!list.isEmpty()){
//            bookFound = true;
//        }
//        return bookFound;
//    }
//    
//    //funcao para listar os livros para consulta
//    public List<Book2> listAllBooks(){
//        
//        em.getTransaction().begin();
//        List<Book2> allBooks = em.createNamedQuery("Book2.findAll").getResultList();
//        return allBooks;
//        
//    }
//    
//    //apagar o livro pela id
//    public void deleteBook(Book2 book){
//        
//        try {
//            em.getTransaction().begin();
//            //pega o objeto e vincula ao objeto do BD
//            Book2 bAux = em.find(Book2.class, book.getIdbook());
//            //agora que bAux esta vinculado ao contexto de persistencia podemos excluir
//            em.remove(bAux);
//            em.getTransaction().commit();
//        } catch(Exception ex){
//            ex.printStackTrace();
//            em.getTransaction().rollback();
//        }
//        
//    }
//    
//    //efetua atualizacao do cadastro do livro
//    public void updateBook(Book2 book){
//        
//        try {
//            em.getTransaction().begin();
//            //Book2 bAux = em.find(Book2.class, book.getIdbook());
//            //bAux.setTitle(book.getTitle());
//            //bAux.setAuthor(book.getAuthor());
//            //bAux.setPublishingcomp(book.getPublishingcomp());
//            //bAux.setReleaseyear(book.getReleaseyear());
//            em.merge(book);
//            em.getTransaction().commit();
//        } catch(Exception ex){
//            ex.printStackTrace();
//            em.getTransaction().rollback();
//        }
//
//    }
//
//    public void register(Object object) {
//       try{
//            //so cadastra se o livro ainda nao existir no bd
//            if (!existBook((Book2)object)==true){
//                em.getTransaction().begin();
//                em.persist(object);
//                em.getTransaction().commit();
//            }
//        } catch(Exception ex){
//            ex.printStackTrace();
//            em.getTransaction().rollback();
//        }
//    }
//
//    public void delete(int id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    public List<Object> list() {
//        
//        List<Object> allBook = null;
//        try{
//            em.getTransaction().begin();
//            allBook = em.createNamedQuery("Book2.findAll").getResultList();
//        
//        } catch(Exception e){
//            //log.gravaErro(e);
//            //log.close();
//            em.getTransaction().rollback();
//        }
//        return allBook;
//        
//    }
//
//    public void update(Object object) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    public void deleteas(int id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    public boolean existOne(Object object) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//}
