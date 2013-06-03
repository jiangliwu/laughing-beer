package com.beer.game.vainner.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.springframework.stereotype.Component;

import com.beer.common.utility.BaseHibernateDAO;
import com.beer.game.vainner.model.UserGame;

@Component("userGameDAO")
public class UserGameDAO extends BaseHibernateDAO {
	private static final Logger log = Logger.getLogger(UserGameDAO.class);
	// property constants
	public static final String GAME_ROLE = "gameRole";
	public static final String GAME_HOLDER = "gameHolder";

	public void save(UserGame transientInstance) {
		log.debug("saving UserGame instance");
		Session session = this.getSession();
		try {
		
			session.save(transientInstance);
			
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(UserGame persistentInstance) {
		log.debug("deleting UserGame instance");
		Session session = this.getSession();
		try {

			session.delete(persistentInstance);

			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public UserGame findById(java.lang.Integer id) {
		log.debug("getting UserGame instance with id: " + id);
		try {
			UserGame instance = (UserGame) getSession().get(
					"com.vainner.usergame.UserGame", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<?> findByExample(UserGame instance) {
		log.debug("finding UserGame instance by example");
		try {
			List<?> results = getSession()
					.createCriteria("com.vainner.usergame.UserGame")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List<?> findByProperty(String propertyName, Object value) {
		log.debug("finding UserGame instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from UserGame as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<?> findByGameRole(Object gameRole) {
		return findByProperty(GAME_ROLE, gameRole);
	}

	public List<?> findByGameHolder(Object gameHolder) {
		return findByProperty(GAME_HOLDER, gameHolder);
	}

	public List<?> findAll() {
		log.debug("finding all UserGame instances");
		try {
			String queryString = "from UserGame";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public UserGame merge(UserGame detachedInstance) {
		log.debug("merging UserGame instance");
		try {
			UserGame result = (UserGame) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(UserGame instance) {
		log.debug("attaching dirty UserGame instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}