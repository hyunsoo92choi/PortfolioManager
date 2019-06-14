package com.hschoi.portfolio.admin.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * <pre>
 * com.hschoi.portfolio.admin_AdminController.java
 * </pre>
 * @date : 2019. 6. 14.
 * @author : hychoi
 */
@RestController
@RequestMapping("/api")
public class AdminController {

	@Autowired 
	private AuthenticationManager authenticationManager;
	
	@ResponseBody
	@RequestMapping(value="/sign", method=RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.OK)
	public void adminAccountCreate(@Valid @RequestBody Admin param, Principal principal) {
		
	
	}
}
