/**
 * 
 */
package org.eclipse.papyrus.resource;


/**
 * Root exception for this package.
 * 
 * @author cedric dumoulin
 *
 */
public class ModelException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor.
	 *
	 */
	public ModelException() {
	}

	/**
	 * Constructor.
	 *
	 * @param message
	 */
	public ModelException(String message) {
		super(message);
	}

	/**
	 * Constructor.
	 *
	 * @param cause
	 */
	public ModelException(Throwable cause) {
		super(cause);
	}

	/**
	 * Constructor.
	 *
	 * @param message
	 * @param cause
	 */
	public ModelException(String message, Throwable cause) {
		super(message, cause);
	}

}
