package com.beer.game.vainner.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.springframework.stereotype.Component;

import com.beer.common.utility.BaseHibernateDAO;
import com.beer.game.vainner.model.Game;


@Component("gameDAO")
public class GameDAO extends BaseHibernateDAO {
	private static final Logger log = Logger.getLogger(GameDAO.class);
	public static final String GAME_TITLE = "gameTitle";
	public static final String GAME_STAUTS = "gameStauts";

	// property constants

	public void save(Game transientInstance) {
		log.debug("saving Game instance");
		Session session = this.getSession();
		try {
			session.save(transientInstance);
			System.out.println(transientInstance.getGameTitle());
			log.debug(transientInstance.getGameTitle());
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Game persistentInstance) {
		log.debug("deleting Game instance");
		Session session = this.getSession();
		try {
			session.beginTransaction();
			session.delete(persistentInstance);
			session.getTransaction().commit();
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Game findById(java.lang.Integer id) {
		log.debug("getting Game instance with id: " + id);
		try {
			Game instance = (Game) getSession()
					.get("com.beer.game.vainner.model.Game", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<?> findByExample(Game instance) {
		log.debug("finding Game instance by example");
		try {
			List<?> results = getSession()
					.createCriteria("com.vainner.game.Game")
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
		log.debug("finding Game instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Game as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<?> findAll() {
		log.debug("finding all Game instances");
		try {
			String queryString = "from Game";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Game merge(Game detachedInstance) {
		log.debug("merging Game instance");
		try {
			Game result = (Game) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Game instance) {
		log.debug("attaching dirty Game instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

}