package com.hschoi.portfolio.admin.service;

import com.hschoi.portfolio.admin.entity.AdminEntity;

/**
 * <pre>
 * com.hschoi.portfolio.admin.service_AdminService.java
 * </pre>
 * @date : 2019. 6. 14.
 * @author : hychoi
 */
public interface AdminService {
	public boolean createAccount(AdminEntity adminEntity);
	public AdminEntity readByEmail(String email);
}
