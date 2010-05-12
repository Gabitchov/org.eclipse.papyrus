/**
 * 
 */
package org.eclipse.papyrus.core.services;



/**
 * @author cedric dumoulin
 *
 */
public class BadStateException extends ServiceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor.
	 *
	 */
	public BadStateException(ServiceState expectedState, ServiceState state, ServiceDescriptor descriptor) {
		super( "Bad state for service '" + descriptor.getKey() 
				+ "'. Expected " + expectedState 
				+ "found " + state 
				+ ".");
	}

	/**
	 * 
	 * Constructor.
	 *
	 * @param text
	 * @param state
	 * @param serviceDescriptor
	 */
	public BadStateException(String text, ServiceState state, ServiceDescriptor descriptor) {
		super( text 
				+ " (Service= '" + descriptor.getKey() 
				+ ", state= " + state 
				+ ")");
	}

}
