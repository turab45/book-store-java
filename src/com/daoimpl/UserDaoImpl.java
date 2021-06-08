package com.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.dao.UserDao;
import com.models.User;
import com.utils.DBConnection;

public class UserDaoImpl implements UserDao {

	@Override
	public Integer addUser(User user) {
		Integer result = null;
		try {
			SessionFactory factory = DBConnection.getConnection();
			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();

			session.save(user);
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
	public Integer updateUser(User user) {
		Integer result = null;
		try {
			SessionFactory factory = DBConnection.getConnection();
			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();

			session.update(user);
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
	public Integer deleteUser(User user) {
		Integer result = null;
		try {
			SessionFactory factory = DBConnection.getConnection();
			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();

			session.remove(user);
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
	public User getUserById(Integer id) {
		User user = null;
		try {
			SessionFactory factory = DBConnection.getConnection();
			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();

			user = session.get(User.class, id);
			
			transaction.commit();
			System.out.println("Successfully fetched.");
			// factory.close();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error : " + e.getMessage());
		}
		return user;
	}

	@Override
	public List<User> getAllUser() {
		List<User> users = new ArrayList<User>();
		try {
			SessionFactory factory = DBConnection.getConnection();
			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();

			users = session.createQuery("From User").list();
			
			transaction.commit();
			System.out.println("Successfully fetched.");
			// factory.close();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error : " + e.getMessage());
		}
		return users;
	}

	@Override
	public User getUserByEmailAndPassword(String email, String password) {
		User user = null;
		try {
			SessionFactory factory = DBConnection.getConnection();
			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();

			Query query = session.createQuery("From User u where u.userName=:n and u.password=:p");
			query.setParameter("n", email);
			query.setParameter("p", password);
			
			user = (User) query.getResultList().get(0);
			
			transaction.commit();
			System.out.println("Successfully fetched.");
			// factory.close();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error : " + e.getMessage());
		}
		return user;
	}

}
