package com.hschoi.common.exception;


/**
 * <pre>
 * com.hschoi.common.exception_PasswordConfirmNotMatching.java
 * </pre>
 * @date : 2019. 6. 14.
 * @author : hychoi
 */
public class PasswordConfirmNotMatching extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7675321644379798122L;
	
	public PasswordConfirmNotMatching() {
		super();
	}

	public PasswordConfirmNotMatching(String message) {
		super(message);
	}

}
