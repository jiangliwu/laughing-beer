package com.beer.user.vainner.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.beer.user.vainner.dao.UserDAO;
import com.beer.user.vainner.model.User;

public class UserDAOImpl implements UserDAO {

	@SuppressWarnings("deprecation")
	public void save(User user) {
		System.out.println("DAO add");

		Configuration cfg = new Configuration(); 
		SessionFactory sf = cfg.configure().buildSessionFactory(); 
		Session ss = sf.openSession();
		ss.beginTransaction();
		ss.save(user);
		ss.getTransaction().commit();
	}

	public void delete(User user) {
		// TODO Auto-generated method stub

	}

	public List<User> findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
