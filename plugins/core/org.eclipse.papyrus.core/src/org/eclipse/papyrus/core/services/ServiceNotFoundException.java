package org.eclipse.papyrus.core.services;

/**
 * Service is not found.
 * 
 * @author dumoulin
 * 
 */
public class ServiceNotFoundException extends ServiceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor.
	 */
	// @unused
	public ServiceNotFoundException() {
		super();
	}

	/**
	 * Constructor.
	 * 
	 * @param message
	 * @param cause
	 */
	// @unused
	public ServiceNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructor.
	 * 
	 * @param message
	 */
	public ServiceNotFoundException(String message) {
		super(message);
	}

	/**
	 * Constructor.
	 * 
	 * @param cause
	 */
	// @unused
	public ServiceNotFoundException(Throwable cause) {
		super(cause);
	}

}
