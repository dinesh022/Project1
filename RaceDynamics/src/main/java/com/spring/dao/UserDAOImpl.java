package com.spring.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.model.Users;

@Repository
public class UserDAOImpl implements UserDAO {
	
		public UserDAOImpl()
		{}
	
	
	@Autowired
	private SessionFactory sessionFactory;

	

	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}


	public boolean saveUser(Users users) {
		
		
		try {
			Session	session =sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			session.saveOrUpdate(users);
			tx.commit();
			return true;
		} catch (HibernateException e) {
			
			e.printStackTrace();
		}
		return false;
	}
	
	

}
