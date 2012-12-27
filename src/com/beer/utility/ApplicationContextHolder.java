package com.beer.utility;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ApplicationContextHolder implements ApplicationContextAware {
	private static ApplicationContext applicatioContext;

	/**
	 * ApplicationContextAware 实现这个接口后，服务器启动后，自动将spring的applicationContext注入进来
	 */
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		ApplicationContextHolder.applicatioContext = arg0;
	}

	/**
	 * 静态方法,获取spring的applicationContext
	 * 
	 * @return ApplicationContext
	 */
	public static ApplicationContext getApplicationContext() {
		return ApplicationContextHolder.applicatioContext;
	}
}
