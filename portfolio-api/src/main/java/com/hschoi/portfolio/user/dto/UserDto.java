package com.hschoi.portfolio.user.dto;

import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.hschoi.portfolio.user.entity.UserEntity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * <pre>
 * com.hschoi.portfolio.user.dto_UserDto.java
 * </pre>
 * @date : 2019. 6. 18.
 * @author : hychoi
 */
@Data
@ToString
@NoArgsConstructor
public class UserDto {
	
	private Long id;
	
	@NotNull
    @Size(min = 5, max = 20)
	private String userEmail;
	
	@NotNull
    @Size(min = 5, max = 20)
	private String userPassword;
	
	public UserDto(Long id, String userEmail) {
        this.id = id;
        this.userEmail = userEmail;
    }
	
	public UserDto(String userEmail, String userPassword) {
		this.userEmail = userEmail;
		this.userPassword = userPassword;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(userEmail);
	}

	public UserEntity toEntity(PasswordEncoder passwordEncoder) {
		return new UserEntity(userEmail, passwordEncoder.encode(userPassword));
	}
}
