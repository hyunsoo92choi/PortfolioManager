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
	
	/**
	 * <pre>
	 * 1. 개요 : 회원가입 
	 * 2. 처리내용 : UserDto에 담긴 회원 정보를 이용하여 회원 가입 서비스를 제공하는 컨트롤러
	 * </pre>
	 * @Method Name : register
	 * @date : 2019. 6. 19.
	 * @author : hychoi
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2019. 6. 19.		hychoi				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param userDto
	 * @return ResponseEntity<UserDto>
	 */ 	
	@PostMapping("/sign")
    public ResponseEntity<UserDto> register(@Valid @RequestBody UserDto userDto) {
        
		log.info("회원가입 : {}", userDto);
		
        UserDto user = userService.register(userDto);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
	
	/**
	 * <pre>
	 * 1. 개요 : 로그인
	 * 2. 처리내용 : UserDto에 담긴 회원 정보를 이용하여 로그인 서비스를 제공하는 컨트롤러
	 * </pre>
	 * @Method Name : userLogin
	 * @date : 2019. 6. 19.
	 * @author : hychoi
	 * @history : ResponseEntity<UserDto>
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2019. 6. 19.		hychoi				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param userDto
	 * @return
	 */ 	
	@PostMapping("/login")
	public ResponseEntity<UserDto> userLogin(@Valid @RequestBody UserDto userDto) {
		
		log.info("로그인 : {}", userDto);
		UserDto loginUser = userService.login(userDto.getUserEmail(), userDto.getUserPassword());
		
		return ResponseEntity.ok().body(loginUser);
	}
}
