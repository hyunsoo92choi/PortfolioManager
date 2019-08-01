package com.hschoi.portfolio.auth.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hschoi.portfolio.auth.dto.AuthDto;
import com.hschoi.portfolio.auth.service.AuthService;
import com.hschoi.portfolio.user.dto.UserDto;
import com.hschoi.portfolio.user.service.UserService;

/**
 * <pre>
 * com.hschoi.portfolio.auth_AuthController.java
 * </pre>
 * @date : 2019. 7. 30.
 * @author : hychoi
 */
@RestController
public class AuthController {
	private final Logger log = LoggerFactory.getLogger(AuthController.class);

	@Autowired
	private UserService userService;
	@Autowired
	private AuthService authService;
	
	/**
	 * <pre>
	 * 1. 개요 : JsonWebToken 적용한 회원 가입 메서드 
	 * 2. 처리내용 : UserDto 의 사용자 e-mail 을 가지고 회원 가입 요청을 받아 관련 서비스를 호출 한다. 
	 * </pre>
	 * @Method Name : register
	 * @date : 2019. 8. 1.
	 * @author : hychoi
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2019. 8. 1.		hychoi				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param userDto
	 * @return
	 */ 	
	@PostMapping("/sign")
    public ResponseEntity<AuthDto> register(@Valid @RequestBody UserDto userDto) {
        
		log.info("[AuthController]: >> 회원가입 : {}", userDto);
		//회원 가입 처리
        UserDto user = userService.register(userDto);
        // 성공 시 리턴된 UserDto를 파라미터로 Access Token 발행 후 Token 정보를 return
        String accessToken = authService.createUserKey(user);

		AuthDto tokenDto = AuthDto.builder()
						  .accessToken(accessToken)
						  .build();
        
        return ResponseEntity.status(HttpStatus.CREATED).body(tokenDto);
    }
}
