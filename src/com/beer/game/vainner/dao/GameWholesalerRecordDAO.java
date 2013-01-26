package com.beer.game.vainner.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.springframework.stereotype.Component;

import com.beer.common.utility.BaseHibernateDAO;
import com.beer.game.vainner.model.GameWholesalerRecord;


@Component("gameWholesalerRecordDAO")
public class GameWholesalerRecordDAO extends BaseHibernateDAO {
	private static final Logger log = Logger
			.getLogger(GameWholesalerRecordDAO.class);
	// property constants
	public static final String THIS_TIME_BUY = "thisTimeBuy";
	public static final String ALL_NEED = "allNeed";
	public static final String ACTUAL_SALE = "actualSale";
	public static final String ALL_OWE = "allOwe";
	public static final String DELAY_COST = "delayCost";
	public static final String BEGIN_GOODS = "beginGoods";
	public static final String RECEIVE_GOODS = "receiveGoods";
	public static final String TOTAL_RECIVE_GOODS = "totalReciveGoods";
	public static final String TOTAL_UP_OWE_GOODS = "totalUpOweGoods";
	public static final String END_GOODS = "endGoods";
	public static final String STORAGE_COST = "storageCost";
	public static final String ORDER_GOODS = "orderGoods";
	public static final String TOTAL_ORDER_GOODS = "totalOrderGoods";
	public static final String THIS_TIME_PROFIT = "thisTimeProfit";
	public static final String GAME_ID = "gameId";
	public static final String TIMES = "times";
	public static final String USER_ID = "userId";

	public void save(GameWholesalerRecord transientInstance) {
		log.debug("saving TblGameWholesalerRecord instance");
		Session session = this.getSession();
		try {
			
			session.save(transientInstance);
			
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(GameWholesalerRecord persistentInstance) {
		log.debug("deleting TblGameWholesalerRecord instance");
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

	public GameWholesalerRecord findById(java.lang.Integer id) {
		log.debug("getting TblGameWholesalerRecord instance with id: " + id);
		try {
			GameWholesalerRecord instance = (GameWholesalerRecord) getSession()
					.get("com.vainner.game1.TblGameWholesalerRecord", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<?> findByExample(GameWholesalerRecord instance) {
		log.debug("finding TblGameWholesalerRecord instance by example");
		try {
			List<?> results = getSession()
					.createCriteria("com.vainner.game1.TblGameWholesalerRecord")
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
		log.debug("finding TblGameWholesalerRecord instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TblGameWholesalerRecord as model where model."
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

	public List<?> findByTotalReciveGoods(Object totalReciveGoods) {
		return findByProperty(TOTAL_RECIVE_GOODS, totalReciveGoods);
	}

	public List<?> findByTotalUpOweGoods(Object totalUpOweGoods) {
		return findByProperty(TOTAL_UP_OWE_GOODS, totalUpOweGoods);
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

	public List<?> findByTotalOrderGoods(Object totalOrderGoods) {
		return findByProperty(TOTAL_ORDER_GOODS, totalOrderGoods);
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
		log.debug("finding all TblGameWholesalerRecord instances");
		try {
			String queryString = "from TblGameWholesalerRecord";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public GameWholesalerRecord merge(
			GameWholesalerRecord detachedInstance) {
		log.debug("merging TblGameWholesalerRecord instance");
		try {
			GameWholesalerRecord result = (GameWholesalerRecord) getSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(GameWholesalerRecord instance) {
		log.debug("attaching dirty TblGameWholesalerRecord instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

}