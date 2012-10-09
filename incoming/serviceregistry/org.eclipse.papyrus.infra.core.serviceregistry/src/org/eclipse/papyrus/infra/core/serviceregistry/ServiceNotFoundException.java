package org.eclipse.papyrus.infra.core.serviceregistry;

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
	public ServiceNotFoundException() {
		super();
	}

	/**
	 * Constructor.
	 * 
	 * @param message
	 * @param cause
	 */
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
	public ServiceNotFoundException(Throwable cause) {
		super(cause);
	}

}
