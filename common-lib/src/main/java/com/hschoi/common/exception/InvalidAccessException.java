package com.hschoi.common.exception;


/**
 * <pre>
 * com.hschoi.common.exception_InvalidAccessException.java
 * </pre>
 * @date : 2019. 6. 17.
 * @author : hychoi
 */
public class InvalidAccessException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2173032127607394543L;
	
	public InvalidAccessException() {
		super();
	}

	public InvalidAccessException(String message) {
		super(message);
	}


}
