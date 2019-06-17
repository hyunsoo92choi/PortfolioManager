package com.hschoi.portfolio.admin.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hschoi.common.dto.ApiResponseDTO;
import com.hschoi.common.exception.PasswordConfirmNotMatching;
import com.hschoi.portfolio.admin.entity.AdminEntity;
import com.hschoi.portfolio.admin.service.AdminService;

import lombok.extern.slf4j.Slf4j;

/**
 * <pre>
 * com.hschoi.portfolio.admin_AdminController.java
 * </pre>
 * @date : 2019. 6. 14.
 * @author : hychoi
 */
@Slf4j
@RestController
@RequestMapping("/api/v1")
public class AdminController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
//	@Autowired	
//	AdminService adminService;
	private final AdminService adminService;

	public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }
	
	@ResponseBody
	@RequestMapping(value="/sign", method=RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.OK)
	public  ResponseEntity<ApiResponseDTO> adminAccountCreate(@Valid @RequestBody AdminEntity param, Principal principal) {
		
		String adminEmail = param.getAdminEmail();
		String password = param.getAdminPassword();
		String passwordConfirm = param.getAdminPasswordConfirm();
		
		if(!password.equals(passwordConfirm)) {
			throw new PasswordConfirmNotMatching("Password is not matching Please check your Password");
		}
		
		AdminEntity admin = AdminEntity.builder()
								.adminEmail(adminEmail)
								.adminPassword(password)
								.build();
		logger.debug("[Admin]:[AdminController] AdminEntity=>{}", admin);
		// Account Create
		adminService.createAccount(admin);
		
		ApiResponseDTO response = new ApiResponseDTO();
		
		
		// return
		return ResponseEntity.ok().body(response);
		
	}
}
