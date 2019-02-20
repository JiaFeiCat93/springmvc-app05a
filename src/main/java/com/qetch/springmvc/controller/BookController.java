package com.qetch.springmvc.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qetch.springmvc.domain.Book;
import com.qetch.springmvc.domain.Category;
import com.qetch.springmvc.service.BookService;

@Controller
public class BookController {
	private static final Log logger = LogFactory.getLog(BookController.class);
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping(value = "/book_input")
	public String inputBook(Model model) {
		logger.info("--->inputBook--->");
		List<Category> categories = bookService.getAllCategories();
		model.addAttribute("categories", categories);
		// "book"对应BookAddForm.jsp中的<form:form>标签中属性modelAttribute的值
		// 如果注释掉该行，则会报错：Neither BindingResult nor plain target object for bean name 'book' available as request attribute
		model.addAttribute("book", new Book());
		return "BookAddForm";
	}
	
	@RequestMapping(value = "/book_edit/{id}")
	public String editBook(Model model, @PathVariable long id) {
		logger.info("--->editBook--->");
		List<Category> categories = bookService.getAllCategories();
		Book book = bookService.get(id);
		model.addAttribute("categories", categories);
		model.addAttribute("book", book);
		return "BookEditForm";
	}
	
	@RequestMapping(value = "/book_save")
	public String saveBook(@ModelAttribute Book book) {
		logger.info("--->saveBook--->");
		Category category = bookService.getCategory(book.getCategory().getId());
		book.setCategory(category);
		bookService.save(book);
		return "redirect:/book_list";
	}

	//https://blog.csdn.net/pozmckaoddb/article/details/51472940
	//https://blog.csdn.net/justlpf/article/details/80984906
	//https://blog.csdn.net/cordova/article/details/50853415
	
	@RequestMapping(value = "/book_update")
	public String updateBook(@ModelAttribute Book book) {
		logger.info("--->updateBook--->");
		Category category = bookService.getCategory(book.getCategory().getId());
		book.setCategory(category);
		bookService.update(book);
		return "redirect:/book_list";
	}
	
	@RequestMapping(value = "/book_list")
	public String listBook(Model model) {
		logger.info("--->listBook--->");
		List<Book> books = bookService.getAllBooks();
		model.addAttribute("books", books);
		return "BookList";
	}
}
