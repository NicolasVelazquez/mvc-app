package com.springMVCTutorial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springMVCTutorial.exception.ApplicationException;
import com.springMVCTutorial.hibernate.Book;
import com.springMVCTutorial.service.BookService;
import com.springMVCTutorial.service.GenericService;

@Controller
public class HelloWorldController {
	
	@Autowired
	GenericService bs;
	
	@RequestMapping("/welcome")
	public ModelAndView helloWorld() {
		
		String message = "<br><div style='text-align:center;'>"
				+ "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from CrunchifyHelloWorld.java **********</div><br><br>";
		return new ModelAndView("welcome", "message", message);
	}
	
	@RequestMapping(value = "/irAltaLibro")
	public ModelAndView irAltaLibro(@ModelAttribute(value = "libro") Book book) {
		return new ModelAndView("altaLibro");
	}
	
	@RequestMapping(value = "/altaLibro", method = RequestMethod.POST)
	public ModelAndView crearLibro(@ModelAttribute(value = "libro") Book book) throws ApplicationException {
		((BookService) bs).crearLibro(book);
		return new ModelAndView("welcome", "message", "Libro creado con éxito!");
	}
	
	@RequestMapping("/bookList")
	public ModelAndView mostrarLibros() {
		List<Book> libros = null;
		try {
			libros = bs.findAll();
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
		return new ModelAndView("welcome", "libros", libros);
	}

}
