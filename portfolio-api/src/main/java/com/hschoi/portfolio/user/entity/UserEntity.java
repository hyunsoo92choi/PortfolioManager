package com.hschoi.portfolio.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.hschoi.common.exception.PasswordConfirmNotMatching;
import com.hschoi.portfolio.user.dto.UserDto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <pre>
 * com.hschoi.portfolio.user.entity_UserEntity.java
 * </pre>
 * @date : 2019. 6. 18.
 * @author : hychoi
 */
@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Id
	@Column
	private String userEmail;
	
	@Column
	@NotEmpty(message="비밀번호을 입력해주세요.")
	private String userPassword;
	
	public UserEntity(String userEmail, String userPassword) {
		this.userEmail = userEmail;
		this.userPassword = userPassword;
	}
	
	public UserDto toUserDto() {
        return new UserDto(id, userEmail);
    }
    
    /**
     * <pre>
     * 1. 개요 : Password Match checker
     * 2. 처리내용 : 인코딩 된 패스워드와 입력된 패스워드가 일치하는지 체크하는 메서드
     * </pre>
     * @Method Name : matchPassword
     * @date : 2019. 6. 18.
     * @author : hychoi
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2019. 6. 18.		hychoi				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param inputPassword
     * @param passwordEncoder
     * @return boolean
     */ 	
    public boolean matchPassword(String inputPassword, PasswordEncoder passwordEncoder) {
        
    	if (!passwordEncoder.matches(inputPassword, userPassword)) {
            throw new PasswordConfirmNotMatching("Password is not Matching");
        }
        return true;
    }
}
