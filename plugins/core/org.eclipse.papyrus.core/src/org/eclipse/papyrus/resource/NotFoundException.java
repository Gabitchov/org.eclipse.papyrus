/**
 * 
 */
package org.eclipse.papyrus.resource;


/**
 * Exception indicating that something is not found.
 * 
 * @author cedric dumoulin
 *
 */
public class NotFoundException extends ModelException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor.
	 *
	 */
	public NotFoundException() {
	}

	/**
	 * Constructor.
	 *
	 * @param message
	 */
	public NotFoundException(String message) {
		super(message);
	}

	/**
	 * Constructor.
	 *
	 * @param cause
	 */
	public NotFoundException(Throwable cause) {
		super(cause);
	}

	/**
	 * Constructor.
	 *
	 * @param message
	 * @param cause
	 */
	public NotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}
