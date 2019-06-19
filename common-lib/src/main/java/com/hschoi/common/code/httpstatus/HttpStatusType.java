package com.hschoi.common.code.httpstatus;

import com.hschoi.common.code.mapper.EnumMapperType;

/**
 * <pre>
 * code_HttpStatusType.java
 * </pre>
 * @date : 2019. 6. 14.
 * @author : hychoi
 */
public enum HttpStatusType implements EnumMapperType {
	
	USER_NOT_FOUND("ADMIN_001", "해당 회원을 찾을 수 없습니다.", 404)
  , INVALID_ACCOUNT_FORM("ADMIN_002", "올바른 계정 형식이 아닙니다.", 400)
  , ACCOUNT_DUPLICATION("ADMIN_003", "계정이 중복되었습니다.", 400)  
  , PASSWORD_FAILED_EXCEEDED("ADMIN_004", "비밀번호 실패 횟수가 초과했습니다.", 400)
  , SERVICE_UNAVAILABLE("ADMIN_005", "서버에 장애가 있습니다.", 503)
  ,	INVALID_ACCESS("ACCESS_001", "접근권한이 없습니다.", 403)  
  , PASSWORD_CONFIRM_NOT_MATCHING("ACCESS_002", "비밀번호가 일치하지 않습니다.", 401)
  , REQUEST_TIMEOUT("ACCESS_003", "요청시간을 초과하였습니다.", 408)
  , OK("ACCESS_004", "요청이 성공하였습니다..", 200); 

	private String message;
	private final int status;

	HttpStatusType(String code, String message, int status) {
		this.message = message;
		this.status = status;
	}
	
	@Override
	public String getCode() {
		return name();
	}
	
	public int getStatus() {
		return status;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
