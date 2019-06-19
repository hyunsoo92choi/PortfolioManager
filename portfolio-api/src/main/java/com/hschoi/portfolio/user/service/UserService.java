package com.hschoi.portfolio.user.service;

import com.hschoi.portfolio.user.dto.UserDto;
import com.hschoi.portfolio.user.entity.User;

/**
 * <pre>
 * com.hschoi.portfolio.user.service_UserService.java
 * </pre>
 * @date : 2019. 6. 18.
 * @author : hychoi
 */
public interface UserService {
	public UserDto register(UserDto user);
	public User findByUserEmail(String userEmail);
	public UserDto login(String userEmail, String password);
}
