package com.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.dao.BookDao;
import com.models.Book;
import com.models.User;
import com.utils.DBConnection;

public class BookDaoImpl implements BookDao{

	@Override
	public Integer addBook(Book book) {
		Integer result = null;
		try {
			SessionFactory factory = DBConnection.getConnection();
			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();

			session.save(book);
			result = 1;

			transaction.commit();
			System.out.println("Successfully added.");
			// factory.close();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error : " + e.getMessage());
		}
		return result;
	}

	@Override
	public Integer updateBook(Book book) {
		Integer result = null;
		try {
			SessionFactory factory = DBConnection.getConnection();
			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();

			session.update(book);
			result = 1;

			transaction.commit();
			System.out.println("Successfully updated.");
			// factory.close();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error : " + e.getMessage());
		}
		return result;
	}

	@Override
	public Integer deleteBook(Book book) {
		Integer result = null;
		try {
			SessionFactory factory = DBConnection.getConnection();
			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();

			session.remove(book);
			result = 1;

			transaction.commit();
			System.out.println("Successfully deleted.");
			// factory.close();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error : " + e.getMessage());
		}
		return result;
	}

	@Override
	public Book getBookById(Integer id) {
		Book book = null;
		try {
			SessionFactory factory = DBConnection.getConnection();
			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();

			book = session.get(Book.class, id);
			
			transaction.commit();
			System.out.println("Successfully fetched.");
			// factory.close();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error : " + e.getMessage());
		}
		return book;
	}

	@Override
	public List<Book> getAllBook() {
		List<Book> books = new ArrayList<Book>();
		try {
			SessionFactory factory = DBConnection.getConnection();
			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();

			books = session.createQuery("From Book").list();
			
			transaction.commit();
			System.out.println("Successfully fetched.");
			// factory.close();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error : " + e.getMessage());
		}
		return books;
	}

	@Override
	public Book getBookByName(String name) {
		Book book = null;
		try {
			SessionFactory factory = DBConnection.getConnection();
			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();

			Query query = session.createQuery("From Book b where b.title=:n");
			query.setParameter("n", name);
			
			book = (Book) query.getSingleResult();
			
			transaction.commit();
			System.out.println("Successfully fetched.");
			// factory.close();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error : " + e.getMessage());
		}
		return book;
	}

}
