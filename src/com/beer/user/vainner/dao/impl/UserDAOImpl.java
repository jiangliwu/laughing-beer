package com.beer.user.vainner.dao.impl;

import java.util.List;



import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.beer.user.vainner.dao.UserDAO;
import com.beer.user.vainner.model.User;
import com.beer.utility.SessionFactoryHolder;


@Component("userDAO")
public class UserDAOImpl implements UserDAO {

	
	public void save(User user) {
		
		
		Session session = SessionFactoryHolder.getSession();
		session.beginTransaction();		
		try
		{
			session.save(user);
			session.getTransaction().commit();
		}catch(Exception ex)
		{
			ex.printStackTrace();	
			session.getTransaction().rollback();				
		}
		finally{
			SessionFactoryHolder.closeSession();    
		}
	}

	public void delete(User user) {

	}

	public List<User> findById(Integer id) {
		return null;
	}

}
