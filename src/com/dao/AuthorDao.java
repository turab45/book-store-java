package com.dao;

import java.util.List;

import com.models.Author;

public interface AuthorDao {
public Integer addAuthor(Author author);
public Integer updateAuthor(Author author);
public Integer deleteAuthor(Author author);
public Author getAuthorById(Integer id);
public List<Author> getAllAuthor();
public Author getAuthorByName(String name);


}
