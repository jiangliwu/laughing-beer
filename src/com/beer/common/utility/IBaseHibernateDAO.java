package com.beer.common.utility;

import org.hibernate.Session;



public interface IBaseHibernateDAO {
	public Session getSession();
}