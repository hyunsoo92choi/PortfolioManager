package com.hschoi.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <pre>
 * com.hschoi.common.dto_ApiResponseDTO.java
 * </pre>
 * @date : 2019. 6. 14.
 * @author : hychoi
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponseDTO<T> {
	private int code;
    private String message;
    private T data;
}
