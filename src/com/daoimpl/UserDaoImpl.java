package com.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.dao.UserDao;

import com.utils.Database;

public class UserDaoImpl implements UserDao{

	
	
	@Override
	public Integer addUser(com.models.User author) {
		SessionFactory factory = Database.getConnection();
		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();

		session.save(author);

		
		
		transaction.commit();
		System.out.println("Successfully saved.");
		
		session.close();
		return null;
	}

	@Override
	public Integer updateUser(com.models.User author) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteUser(com.models.User author) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public com.models.User getUserById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<com.models.User> getAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

}
