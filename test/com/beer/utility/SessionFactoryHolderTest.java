package com.beer.utility;

import static org.junit.Assert.*;



import org.hibernate.Session;
import org.junit.Test;

public class SessionFactoryHolderTest {

	@Test
	public void testGetSessionFactory() {
		Session session = SessionFactoryHolder.getSessionFactory().openSession();
		session.beginTransaction();
	}

}
