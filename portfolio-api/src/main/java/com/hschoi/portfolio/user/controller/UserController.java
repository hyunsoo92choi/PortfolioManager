package com.hschoi.portfolio.user.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hschoi.portfolio.user.dto.UserDto;
import com.hschoi.portfolio.user.service.UserService;

/**
 * <pre>
 * com.hschoi.portfolio.user.controller_UserController.java
 * </pre>
 * 
 * @date : 2019. 6. 18.
 * @author : hychoi
 */
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

	private final Logger log = LoggerFactory.getLogger(UserController.class);

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/sign")
    public ResponseEntity<UserDto> register(@Valid @RequestBody UserDto userDto) {
        
		log.debug("회원가입 : {}", userDto);
        UserDto user = userService.register(userDto);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
