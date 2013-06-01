package com.beer.game.vainner.dao;


import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.springframework.stereotype.Component;

import com.beer.common.utility.BaseHibernateDAO;
import com.beer.game.vainner.model.GameWholesaleParameter;

@Component("gameWholesaleParameterDAO")
public class GameWholesaleParameterDAO extends BaseHibernateDAO {
	private static final Logger log = Logger
			.getLogger(GameWholesaleParameterDAO.class);
	// property constants
	public static final String PRICE = "price";
	public static final String DELAY_COST = "delayCost";
	public static final String REPERTORY_COST = "repertoryCost";
	public static final String ORDER_COST = "orderCost";
	public static final String TRANSPORT_COST = "transportCost";
	public static final String DISCOUNT = "discount";
	public static final String ORIGIN = "origin";
	public static final String COST = "cost";
	public static final String GAME_ID = "gameId";

	public void save(GameWholesaleParameter transientInstance) {
		log.debug("saving GameWholesaleParameter instance");
		Session session = this.getSession();
		try {
			
			session.save(transientInstance);
			
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(GameWholesaleParameter persistentInstance) {
		log.debug("deleting GameWholesaleParameter instance");
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

	public GameWholesaleParameter findById(java.lang.Integer id) {
		log.debug("getting GameWholesaleParameter instance with id: " + id);
		try {
			GameWholesaleParameter instance = (GameWholesaleParameter) getSession()
					.get("com.vainner.game1.GameWholesaleParameter", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<?> findByExample(GameWholesaleParameter instance) {
		log.debug("finding GameWholesaleParameter instance by example");
		try {
			List<?> results = getSession()
					.createCriteria(
							"com.vainner.game1.GameWholesaleParameter")
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
		log.debug("finding GameWholesaleParameter instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from GameWholesaleParameter as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<?> findByPrice(Object price) {
		return findByProperty(PRICE, price);
	}

	public List<?> findByDelayCost(Object delayCost) {
		return findByProperty(DELAY_COST, delayCost);
	}

	public List<?> findByRepertoryCost(Object repertoryCost) {
		return findByProperty(REPERTORY_COST, repertoryCost);
	}

	public List<?> findByOrderCost(Object orderCost) {
		return findByProperty(ORDER_COST, orderCost);
	}

	public List<?> findByTransportCost(Object transportCost) {
		return findByProperty(TRANSPORT_COST, transportCost);
	}

	public List<?> findByDiscount(Object discount) {
		return findByProperty(DISCOUNT, discount);
	}

	public List<?> findByOrigin(Object origin) {
		return findByProperty(ORIGIN, origin);
	}

	public List<?> findByCost(Object cost) {
		return findByProperty(COST, cost);
	}

	public List<?> findByGameId(Object gameId) {
		return findByProperty(GAME_ID, gameId);
	}

	public List<?> findAll() {
		log.debug("finding all GameWholesaleParameter instances");
		try {
			String queryString = "from GameWholesaleParameter";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public GameWholesaleParameter merge(
			GameWholesaleParameter detachedInstance) {
		log.debug("merging GameWholesaleParameter instance");
		try {
			GameWholesaleParameter result = (GameWholesaleParameter) getSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(GameWholesaleParameter instance) {
		log.debug("attaching dirty GameWholesaleParameter instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

}