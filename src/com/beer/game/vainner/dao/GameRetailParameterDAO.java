package com.beer.game.vainner.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;

import com.beer.common.utility.BaseHibernateDAO;
import com.beer.game.vainner.model.GameRetailParameter;

public class GameRetailParameterDAO extends BaseHibernateDAO {
	private static final Logger log = Logger
			.getLogger(GameRetailParameterDAO.class);
	public static final String PRICE = "price";
	public static final String DELAY_COST = "delayCost";
	public static final String REPERTORY_COST = "repertoryCost";
	public static final String ORDER_COST = "orderCost";
	public static final String TRANSPORT_COST = "transportCost";
	public static final String DISCOUNT = "discount";
	public static final String ORIGIN = "origin";
	public static final String COST = "cost";
	public static final String GAME_ID = "gameId";

	public void save(GameRetailParameter transientInstance) {
		log.debug("saving TblGameRetailParameter instance");
		Session session = this.getSession();
		try {
			session.beginTransaction();
			session.save(transientInstance);
			session.getTransaction().commit();
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(GameRetailParameter persistentInstance) {
		log.debug("deleting TblGameRetailParameter instance");
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

	public GameRetailParameter findById(java.lang.Integer id) {
		log.debug("getting TblGameRetailParameter instance with id: " + id);
		try {
			GameRetailParameter instance = (GameRetailParameter) getSession()
					.get("com.vainner.game1.TblGameRetailParameter", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<?> findByExample(GameRetailParameter instance) {
		log.debug("finding TblGameRetailParameter instance by example");
		try {
			List<?> results = getSession()
					.createCriteria("com.vainner.game1.TblGameRetailParameter")
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
		log.debug("finding TblGameRetailParameter instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TblGameRetailParameter as model where model."
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
		log.debug("finding all TblGameRetailParameter instances");
		try {
			String queryString = "from TblGameRetailParameter";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public GameRetailParameter merge(GameRetailParameter detachedInstance) {
		log.debug("merging TblGameRetailParameter instance");
		try {
			GameRetailParameter result = (GameRetailParameter) getSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(GameRetailParameter instance) {
		log.debug("attaching dirty TblGameRetailParameter instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

}