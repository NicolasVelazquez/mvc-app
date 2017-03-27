package com.springMVCTutorial.business;

import java.util.List;

import com.springMVCTutorial.dao.BookDAOImpl;
import com.springMVCTutorial.exception.ApplicationException;
import com.springMVCTutorial.hibernate.Book;

public class BookBusiness {
	
	@SuppressWarnings("unchecked")
	public List<Book> finAll() throws ApplicationException {
		BookDAOImpl dao = new BookDAOImpl();
		return dao.findAll(Book.class);
	}
	
	public void crearLibro(Book book) {
		BookDAOImpl dao = new BookDAOImpl();
		dao.save(book);
	}
}
