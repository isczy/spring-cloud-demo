package com.czy.service;

import com.czy.entity.User;

public interface UserService {

	/**
	 * 根据id查询
	 */
	User findById(Integer id);


	void delete(Integer id);
}
