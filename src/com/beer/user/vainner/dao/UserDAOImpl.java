package com.beer.user.vainner.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import org.springframework.stereotype.Component;

import com.beer.common.utility.SessionFactoryHolder;
import com.beer.user.vainner.model.User;

@Component("userDAO")
public class UserDAOImpl implements UserDAO {
	private static final Logger log = Logger.getLogger(UserDAOImpl.class);

	public void save(User user) {
		log.debug("UserDAOImpl 开始 " + user);
		Session session = SessionFactoryHolder.getSession();
		try {
			session.save(user);

			log.debug("UserDAOImpl  保存成功! " + user);
		} catch (Exception ex) {
			log.debug("UserDAOImpl Save error" + ex);
		}
	}

	public void delete(User user) {
		log.debug("UserDAOImpl 开始删除 " + user);
		Session session = SessionFactoryHolder.getSession();
		try {
			session.beginTransaction();
			session.delete(user);
			session.getTransaction().commit();
			log.debug("UserDAOImpl  删除成功！" + user);
		} catch (Exception ex) {
			log.debug("UserDAOImpl delete error" + ex);
		}
	}

	@SuppressWarnings("rawtypes")
	public List findByUsername(String username) {
		return findByProperty("username", username);
	}

	public User findById(Integer id) {
		try {
			return (User) SessionFactoryHolder.getSession().get(
					"com.beer.user.vainner.model.User", id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("rawtypes")
	public List findByProperty(String propertyName, String value) {
		log.debug("finding User instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from User as model where model."
					+ propertyName + "= ?";
			Query queryObject = SessionFactoryHolder.getSession().createQuery(
					queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

}
