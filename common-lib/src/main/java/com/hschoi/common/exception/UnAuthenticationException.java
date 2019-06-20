package com.hschoi.common.exception;


/**
 * <pre>
 * com.hschoi.common.exception_UnAuthenticationException.java
 * </pre>
 * @date : 2019. 6. 18.
 * @author : hychoi
 */
public class UnAuthenticationException extends RuntimeException {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -865480054652277675L;

	public UnAuthenticationException () {
        super();
    }

    public UnAuthenticationException (String message) {
        super(message);
    }
}
