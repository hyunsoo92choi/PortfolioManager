package com.hschoi.portfolio.admin.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hschoi.portfolio.admin.entity.AdminEntity;
import com.hschoi.portfolio.admin.repository.AdminRepository;
import com.hschoi.portfolio.admin.service.AdminService;

import lombok.extern.slf4j.Slf4j;

/**
 * <pre>
 * com.hschoi.portfolio.admin.service.impl_AdminServiceImpl.java
 * </pre>
 * @date : 2019. 6. 14.
 * @author : hychoi
 */
@Slf4j
@Service
public class AdminServiceImpl implements AdminService {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);
	
	private final AdminRepository adminRepository ;
	private final BCryptPasswordEncoder bcryptPasswordEncoder;

	public AdminServiceImpl(AdminRepository adminRepository, BCryptPasswordEncoder bcryptPasswordEncoder) {
        this.adminRepository = adminRepository;
        this.bcryptPasswordEncoder = bcryptPasswordEncoder;
    }
	
	@Override
	public boolean createAccount(AdminEntity adminEntity) {
		
		String encodedPassword = bcryptPasswordEncoder.encode(adminEntity.getAdminPassword());
		adminEntity.setAdminPassword(encodedPassword);
		
		AdminEntity returnedAccount = adminRepository.save(adminEntity);
		logger.debug("[Admin]:[AdminServiceImpl] returnd AdminEntity=>{}", returnedAccount);
		
		if (returnedAccount != null)
			System.out.printf("account ID is %d and for returned account ID is %d\n", returnedAccount.getAdminEmail(), returnedAccount.getUsername());
		
		return false;
	}

	@Override
	public AdminEntity readByEmail(String email) {
		return adminRepository.findById(email).orElseThrow(()->new UsernameNotFoundException(email)); 
	}

}
