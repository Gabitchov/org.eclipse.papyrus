/**
 * 
 */
package org.eclipse.papyrus.resource;


/**
 * Exception thrown when a method is called while the object state is not ready for this 
 * call.
 * 
 * @author cedric dumoulin
 *
 */
public class BadStateException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor.
	 *
	 */
	public BadStateException() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor.
	 *
	 * @param message
	 * @param cause
	 */
	public BadStateException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor.
	 *
	 * @param message
	 */
	public BadStateException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor.
	 *
	 * @param cause
	 */
	public BadStateException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
