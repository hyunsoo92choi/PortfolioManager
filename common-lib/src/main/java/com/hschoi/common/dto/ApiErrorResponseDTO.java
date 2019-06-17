package com.hschoi.common.dto;

import lombok.Builder;
import lombok.Getter;

/**
 * <pre>
 * com.hschoi.common.dto_ApiErrorResponseDTO.java
 * </pre>
 * @date : 2019. 6. 14.
 * @author : hychoi
 */
@Getter
public class ApiErrorResponseDTO {
	private String message;
    private String code;
    private int status;
    
    @Builder
    public ApiErrorResponseDTO(String message, String code, int status) {
    	this.message = message;
    	this.code = code;
    	this.status = status;
    }
    
}
