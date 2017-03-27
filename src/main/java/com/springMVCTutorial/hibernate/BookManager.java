package com.springMVCTutorial.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class BookManager {
	
    protected SessionFactory sessionFactory;
 
    protected void setup() {
    	final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
    			// configures settings from hibernate.cfg.xml
    	try {
    	    sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    	} catch (Exception ex) {
    	    StandardServiceRegistryBuilder.destroy(registry);
    	}
    }
 
    protected void exit() {
    	sessionFactory.close();
    }
 
    public void create() {
    	setup();
        Book book = new Book();
        book.setTitle("Effective Java");
        book.setAuthor("Joshua Bloch");
        book.setPrice(32.59f);
     
        Session session = sessionFactory.openSession();
        session.beginTransaction();
     
        session.save(book);
     
        session.getTransaction().commit();
        session.close();
        exit();
    }
 
    public Book read() {
    	setup();
        Session session = sessionFactory.openSession();
     
        int bookId = 1;
        Book book = session.get(Book.class, bookId);
        if( book != null){
	        System.out.println("Title: " + book.getTitle());
	        System.out.println("Author: " + book.getAuthor());
	        System.out.println("Price: " + book.getPrice());
        }
        session.close();
        exit();
		return book;
    }
 
    public void update() {
        Book book = new Book();
        book.setId(20);
        book.setTitle("Ultimate Java Programming");
        book.setAuthor("Nam Ha Minh");
        book.setPrice(19.99f);
     
        Session session = sessionFactory.openSession();
        session.beginTransaction();
     
        session.update(book);
     
        session.getTransaction().commit();
        session.close();
    }
 
    public void delete() {
        Book book = new Book();
        book.setId(20);
     
        Session session = sessionFactory.openSession();
        session.beginTransaction();
     
        session.delete(book);
     
        session.getTransaction().commit();
        session.close();
    }
 
    public static void main(String[] args) {
	    BookManager manager = new BookManager();
	    manager.setup();
	 
	    manager.create();
	    
	    manager.exit();
    }
}