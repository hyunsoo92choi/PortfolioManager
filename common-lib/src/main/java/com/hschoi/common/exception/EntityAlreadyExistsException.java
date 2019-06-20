package com.hschoi.common.exception;


/**
 * <pre>
 * com.hschoi.common.exception_EntityAlreadyExistsException.java
 * </pre>
 * @date : 2019. 6. 19.
 * @author : hychoi
 */
public class EntityAlreadyExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7924628826237791379L;
	
	public EntityAlreadyExistsException () {

    }
	
    public EntityAlreadyExistsException (String message) {
        super(message);
    }

}
