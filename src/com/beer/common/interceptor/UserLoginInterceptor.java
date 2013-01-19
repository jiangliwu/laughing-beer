package com.beer.common.interceptor;

import com.opensymphony.xwork2.Action;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class UserLoginInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = -3397540827641050980L;

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {

		String username = (String) arg0.getInvocationContext().getSession()
				.get("username");
		
		if (username != null) {
			return arg0.invoke();
		}
		return Action.LOGIN;

	}

}
