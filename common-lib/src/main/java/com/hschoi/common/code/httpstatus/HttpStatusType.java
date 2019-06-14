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
	
	USERNAME_NOT_FOUND("ADMIN_001", "이메일이 올바르지 않습니다.", 404)
  , BAD_CREDENTIIALS("ADMIN_002", "비밀번호가 올바르지 않습니다.", 401)
  , INPUT_VALUE_INVALID("ADMIN_003", "입력값이 올바르지 않습니다.", 400)
  , SERVICE_UNAVAILABLE("ADMIN_004", "서버에 장애가 있습니다.", 503)
  ,	INVALID_ACCESS("ACCESS_001", "접근권한이 없습니다.", 403)  
  , PASSWORD_CONFIRM_NOT_MATCHING("ACCESS_002", "비밀번호가 일치하지 않습니다.", 401)
  , REQUEST_TIMEOUT("ACCESS_003", "요청시간을 초과하였습니다.", 408)
  , OK("ACCESS_004", "요청이 성공하였습니다..", 200)
  , ACCEPTED("ACCESS_005", "요청을 수신하였지만 그에 응하여 행동할 수 없습니다.", 202)
   
  ; 

	private String title;
	private final int status;

	HttpStatusType(String code, String title, int status) {
		this.title = title;
		this.status = status;
	}
	
	@Override
	public String getCode() {
		return name();
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return title;
	}
	
	public int getStatus() {
		return status;
	}
}
