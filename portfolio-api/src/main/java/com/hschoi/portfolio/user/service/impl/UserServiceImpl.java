package com.hschoi.portfolio.user.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hschoi.common.exception.EntityAlreadyExistsException;
import com.hschoi.portfolio.user.dto.UserDto;
import com.hschoi.portfolio.user.entity.User;
import com.hschoi.portfolio.user.repository.UserRepository;
import com.hschoi.portfolio.user.service.UserService;

/**
 * <pre>
 * com.hschoi.portfolio.user.service.impl_UserServiceImpl.java
 * </pre>
 * 
 * @date : 2019. 6. 18.
 * @author : hychoi
 */
@Service
public class UserServiceImpl implements UserService {
	
	private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	
	public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public UserDto register(UserDto user) {
		
		
		verifyExist(user);
        
		return userRepository
                .save(user.toEntity(passwordEncoder)).toUserDto();
	}
	
	/**
	 * <pre>
	 * 1. 개요 : Param UserEmail 정보가 기존에 존재하는지 체크
	 * 2. 처리내용 : 이미 가입한 UserEmail 정보가 존재하면 Biz Exception을 발생 시키고 종료
	 * </pre>
	 * @Method Name : verifyExist
	 * @date : 2019. 6. 19.
	 * @author : hychoi
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2019. 6. 19.		hychoi				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param user
	 */ 	
	public void verifyExist(UserDto user) {
		
		log.info("회원 가입 유효성 체크 : {}", user);
		
		if (userRepository.findByUserEmail(user.getUserEmail()).isPresent()) {
            throw new EntityAlreadyExistsException("EXIST_ID");
        }
	}

	@Override
	public User findByUserEmail(String userEmail) {

		return userRepository.findByUserEmail(userEmail)
				.orElseThrow((null));
	}
	
	@Override
	public UserDto login(String userEmail, String password) {

		User user = findByUserEmail(userEmail);
        user.matchPassword(password, passwordEncoder);
        
        return user.toUserDto();
    }
	
}
