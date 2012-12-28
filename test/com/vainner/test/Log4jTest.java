package com.vainner.test;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.Test;

public class Log4jTest {

	@Test
	public void test() {
		Logger log = Logger.getLogger(Log4jTest.class);
		log.debug("test");
		log.info("info");
	}

}
