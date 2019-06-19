package com.hschoi.common.exception;
/**
 * <pre>
 * com.hschoi.common.exception_EntityNotFoundException.java
 * </pre>
 * @date : 2019. 6. 18.
 * @author : hychoi
 */
public class EntityNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5988471295787614324L;

	public EntityNotFoundException () {

    }
	
    public EntityNotFoundException (String message) {
        super(message);
    }
}
