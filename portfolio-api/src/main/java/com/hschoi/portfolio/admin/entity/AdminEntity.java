package com.hschoi.portfolio.admin.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <pre>
 * com.hschoi.portfolio.admin.entity_AdminEntity.java
 * </pre>
 * @date : 2019. 6. 14.
 * @author : hychoi
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminEntity implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column
	private String adminEmail;
	
	@Column
	@NotEmpty(message="비밀번호을 입력해주세요.")
	private String adminPassword;
	
	/* 관리자 비밀번호 확인은 DB 매핑에서 제외 */
	@Transient
	private String adminPasswordConfirm;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return adminPassword;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return adminEmail;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
