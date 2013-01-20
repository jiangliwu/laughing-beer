package com.beer.game.vainner.dao;

import com.beer.common.utility.BaseHibernateDAO;
import com.beer.game.vainner.model.GameProducerRecord;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;


/**
 * A data access object (DAO) providing persistence and search support for
 * TblGameProducerRecord entities. Transaction control of the save(), update()
 * and delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.vainner.GameProducerRecord.TblGameProducerRecord
 * @author MyEclipse Persistence Tools
 */

public class GameProducerRecordDAO extends BaseHibernateDAO {
	private static final Logger log = Logger
			.getLogger(GameProducerRecordDAO.class);
	// property constants
	public static final String THIS_TIME_BUY = "thisTimeBuy";
	public static final String ALL_NEED = "allNeed";
	public static final String ACTUAL_SALE = "actualSale";
	public static final String ALL_OWE = "allOwe";
	public static final String DELAY_COST = "delayCost";
	public static final String BEGIN_GOODS = "beginGoods";
	public static final String RECEIVE_GOODS = "receiveGoods";
	public static final String END_GOODS = "endGoods";
	public static final String STORAGE_COST = "storageCost";
	public static final String ORDER_GOODS = "orderGoods";
	public static final String THIS_TIME_PROFIT = "thisTimeProfit";
	public static final String GAME_ID = "gameId";
	public static final String TIMES = "times";
	public static final String USER_ID = "userId";

	public void save(GameProducerRecord transientInstance) {
		log.debug("saving TblGameProducerRecord instance");
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

	public void delete(GameProducerRecord persistentInstance) {
		log.debug("deleting TblGameProducerRecord instance");
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

	public GameProducerRecord findById(java.lang.Integer id) {
		log.debug("getting TblGameProducerRecord instance with id: " + id);
		try {
			GameProducerRecord instance = (GameProducerRecord) getSession()
					.get("com.vainner.game1.TblGameProducerRecord", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<?> findByExample(GameProducerRecord instance) {
		log.debug("finding TblGameProducerRecord instance by example");
		try {
			List<?> results = getSession()
					.createCriteria("com.vainner.game1.TblGameProducerRecord")
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
		log.debug("finding TblGameProducerRecord instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TblGameProducerRecord as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<?> findByThisTimeBuy(Object thisTimeBuy) {
		return findByProperty(THIS_TIME_BUY, thisTimeBuy);
	}

	public List<?> findByAllNeed(Object allNeed) {
		return findByProperty(ALL_NEED, allNeed);
	}

	public List<?> findByActualSale(Object actualSale) {
		return findByProperty(ACTUAL_SALE, actualSale);
	}

	public List<?> findByAllOwe(Object allOwe) {
		return findByProperty(ALL_OWE, allOwe);
	}

	public List<?> findByDelayCost(Object delayCost) {
		return findByProperty(DELAY_COST, delayCost);
	}

	public List<?> findByBeginGoods(Object beginGoods) {
		return findByProperty(BEGIN_GOODS, beginGoods);
	}

	public List<?> findByReceiveGoods(Object receiveGoods) {
		return findByProperty(RECEIVE_GOODS, receiveGoods);
	}

	public List<?> findByEndGoods(Object endGoods) {
		return findByProperty(END_GOODS, endGoods);
	}

	public List<?> findByStorageCost(Object storageCost) {
		return findByProperty(STORAGE_COST, storageCost);
	}

	public List<?> findByOrderGoods(Object orderGoods) {
		return findByProperty(ORDER_GOODS, orderGoods);
	}

	public List<?> findByThisTimeProfit(Object thisTimeProfit) {
		return findByProperty(THIS_TIME_PROFIT, thisTimeProfit);
	}

	public List<?> findByGameId(Object gameId) {
		return findByProperty(GAME_ID, gameId);
	}

	public List<?> findByTimes(Object times) {
		return findByProperty(TIMES, times);
	}

	public List<?> findByUserId(Object userId) {
		return findByProperty(USER_ID, userId);
	}

	public List<?> findAll() {
		log.debug("finding all TblGameProducerRecord instances");
		try {
			String queryString = "from TblGameProducerRecord";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public GameProducerRecord merge(GameProducerRecord detachedInstance) {
		log.debug("merging TblGameProducerRecord instance");
		try {
			GameProducerRecord result = (GameProducerRecord) getSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(GameProducerRecord instance) {
		log.debug("attaching dirty TblGameProducerRecord instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}