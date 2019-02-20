package com.qetch.springmvc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.qetch.springmvc.domain.Book;
import com.qetch.springmvc.domain.Category;

@Service
public class BookServiceImpl implements BookService {

	List<Category> categories;
	List<Book> books;
	
	public BookServiceImpl() {
		categories = new ArrayList<>();
		Category category1 = new Category(1, "Computing");
		Category category2 = new Category(2, "Travel");
		Category category3 = new Category(3, "Health");
		categories.add(category1);
		categories.add(category2);
		categories.add(category3);
		
		books = new ArrayList<>();
		books.add(new Book(1L, "9780980839623", "Servlet & JSP: A Tutorial", category1, "Budi Kurniawan"));
		books.add(new Book(2L, "9780980839630", "C#: A Beginner's Tutorial", category1, "Jayden Ky"));
	}
	
	@Override
	public List<Category> getAllCategories() {
		return categories;
	}

	@Override
	public Category getCategory(int id) {
		for (Category category : categories) {
			if (category.getId() == id) {
				return category;
			}
		}
		return null;
	}

	@Override
	public List<Book> getAllBooks() {
		return books;
	}

	@Override
	public Book save(Book book) {
		book.setId(getNextId());
		books.add(book);
		return book;
	}

	@Override
	public Book update(Book book) {
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getId() == book.getId()) {
				books.set(i, book);
				return book;
			}
		}
		return book;
	}

	@Override
	public Book get(long id) {
		for (Book book : books) {
			if (book.getId() == id) {
				return book;
			}
		}
		return null;
	}

	@Override
	public long getNextId() {
		long id = 0L;
		synchronized (books) {
			for (Book book : books) {
				if (book.getId() > id) {
					id = book.getId();
				}
			}
		}
		return id + 1;
	}
}
