package com.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.dao.AuthorDao;
import com.models.Author;
import com.models.Book;
import com.utils.DBConnection;

public class AuthorDaoImpl implements AuthorDao{

	@Override
	public Integer addAuthor(Author author) {
		Integer result = null;
		try {
			SessionFactory factory = DBConnection.getConnection();
			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();

			session.save(author);
			result = 1;

			transaction.commit();
			System.out.println("Successfully saved.");
			// factory.close();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error : " + e.getMessage());
		}
		return result;
	}

	@Override
	public Integer updateAuthor(Author author) {
		Integer result = null;
		try {
			SessionFactory factory = DBConnection.getConnection();
			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();

			session.update(author);
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
	public Integer deleteAuthor(Author author) {
		Integer result = null;
		try {
			SessionFactory factory = DBConnection.getConnection();
			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();

			session.remove(author);
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
	public Author getAuthorById(Integer id) {
		Author author = null;
		try {
			SessionFactory factory = DBConnection.getConnection();
			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();

			author = session.get(Author.class, id);
			
			transaction.commit();
			System.out.println("Successfully fetched.");
			// factory.close();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error : " + e.getMessage());
		}
		return author;
	}

	@Override
	public List<Author> getAllAuthor() {
		List<Author> authors = new ArrayList<Author>();
		try {
			SessionFactory factory = DBConnection.getConnection();
			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();

			authors = session.createQuery("From Author").list();
			
			transaction.commit();
			System.out.println("Successfully fetched.");
			// factory.close();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error : " + e.getMessage());
		}
		return authors;
	}

	@Override
	public Author getAuthorByName(String name) {
		Author author = null;
		try {
			SessionFactory factory = DBConnection.getConnection();
			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();
			Query query = session.createQuery("From Author a where a.name=:n");
			query.setParameter("n", name);
			author = (Author)query.getSingleResult();
			
			transaction.commit();
			System.out.println("Successfully fetched.");
			// factory.close();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error : " + e.getMessage());
		}
		return author;
	}

}
