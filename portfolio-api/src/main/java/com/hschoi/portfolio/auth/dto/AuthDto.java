package com.hschoi.portfolio.auth.dto;

import lombok.Builder;
import lombok.Getter;

/**
 * <pre>
 * com.hschoi.portfolio.auth.dto_AuthDto.java
 * </pre>
 * @date : 2019. 8. 1.
 * @author : hychoi
 */
@Getter
@Builder
public class AuthDto {
	private String accessToken;
}
