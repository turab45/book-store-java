package com.dao;

import java.util.List;

import com.models.Book;

public interface BookDao {
	
	public Integer addBook(Book author);
	public Integer updateBook(Book author);
	public Integer deleteBook(Book author);
	public Book getBookById(Integer id);
	public List<Book> getAllBook();
	public Book getBookByName(String book);

}
