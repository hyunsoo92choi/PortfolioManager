package com.hschoi.common.exception;
/**
 * <pre>
 * com.hschoi.common.exception_AccountNotFoundException.java
 * </pre>
 * @date : 2019. 6. 19.
 * @author : hychoi
 */
public class AccountNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 921339816937614814L;
	
	public AccountNotFoundException() {

    }
	
    public AccountNotFoundException (String message) {
        super(message);
    }

}
