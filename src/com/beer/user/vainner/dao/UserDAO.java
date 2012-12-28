package com.beer.user.vainner.dao;

import java.util.List;

import com.beer.user.vainner.model.User;

public interface UserDAO {
	public void save(User user);
	public void delete(User user);
	public User findById(Integer id);
	@SuppressWarnings("rawtypes")
	public List findByUsername(String username);
	@SuppressWarnings("rawtypes")
	public List findByProperty(String property,String value);
}
