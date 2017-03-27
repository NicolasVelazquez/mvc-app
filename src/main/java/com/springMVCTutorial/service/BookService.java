package com.springMVCTutorial.service;

import java.util.List;

import com.springMVCTutorial.business.BookBusiness;
import com.springMVCTutorial.exception.ApplicationException;
import com.springMVCTutorial.hibernate.Book;

public class BookService extends GenericService{

	@Override
	public List<Book> findAll() throws ApplicationException {
		BookBusiness bb = new BookBusiness();
		return bb.finAll();
	}
	
	public void crearLibro(Book book) throws ApplicationException {
		 entityManager.getTransaction().begin();
        try {
        	BookBusiness bb = new BookBusiness();
    		bb.crearLibro(book);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
            throw new ApplicationException(ex);
        }
	}

}
