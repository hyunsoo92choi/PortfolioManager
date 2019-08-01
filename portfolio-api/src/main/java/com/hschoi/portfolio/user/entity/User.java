package com.hschoi.portfolio.user.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.hschoi.common.entity.BaseEntity;
import com.hschoi.portfolio.projects.entity.Project;
import com.hschoi.portfolio.user.dto.UserDto;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * <pre>
 * com.hschoi.portfolio.user.entity_UserEntity.java
 * 사용자는 중복가입을 허용하지 않음
 * 하나의 사용자는 다수의 프로젝트를 등록 할 수 있음 (One to Many)
 * </pre>
 * @date : 2019. 6. 18.
 * @author : hychoi.
 */
@Entity
@Table(name="user")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	
	@Column(nullable = false, unique = true)
	private String userEmail;
	
	@Column(nullable = false)
	@NotEmpty(message="비밀번호을 입력해주세요.")
	private String userPassword;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Project> projects = new ArrayList<>();
	
	public User(String userEmail, String userPassword) {
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
//            throw new PasswordConfirmNotMatching("Password is not Matching");
        }
        
    	return true;
    }
}
