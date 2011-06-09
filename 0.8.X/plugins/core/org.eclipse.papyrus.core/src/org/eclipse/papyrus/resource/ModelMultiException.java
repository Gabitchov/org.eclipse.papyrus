/**
 * 
 */
package org.eclipse.papyrus.resource;

import java.util.ArrayList;
import java.util.List;


/**
 * An exception encapsulating multiple exceptions.
 * This exception is thrown when an operation performed on several Models fails 
 * on one or more of these models. 
 * The exception contains all the exceptions encoutered while opertating on models.
 * 
 * @author cedric dumoulin
 *
 */
public class ModelMultiException extends ModelException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * List of encountered exceptions.
	 */
	List<Throwable> encounteredExceptions = new ArrayList<Throwable>();
	/**
	 * List of identifiers corresponding to exceptions.
	 */
	List<Object> encounteredModels = new ArrayList<Object>();
	
	
	/**
	 * @return the encounteredExceptions
	 */
	public List<Throwable> getExceptions() {
		return encounteredExceptions;
	}

	/**
	 * Constructor.
	 *
	 */
	public ModelMultiException() {
		super("Multiple exceptions");
	}

	/**
	 * Constructor.
	 *
	 * @param message
	 */
	public ModelMultiException(String message) {
		super(message);
	}

	/**
	 * Return the first exception.
	 * @see java.lang.Throwable#getCause()
	 *
	 * @return
	 */
	@Override
	public Throwable getCause() {
        return ( encounteredExceptions.size()>0 ? encounteredExceptions.get(0) : null );
	}
	
	/**
	 * Return the message if any, or the message of the first exception.
	 * @see java.lang.Throwable#getMessage()
	 *
	 * @return
	 */
	@Override
	public String getMessage() {
		
		StringBuffer buffer = new StringBuffer();
		
		String message = super.getMessage();
		if (message != null)
			buffer.append(message).append('\n');
		
		buffer.append("----- exceptions : ----------\n");
		for( int i = 0; i< encounteredExceptions.size(); i++ ) {
			Throwable exception = encounteredExceptions.get(i);
			Object identifierMsg = encounteredModels.get(i);
			
			if(identifierMsg != null)
				buffer.append(identifierMsg.toString()).append(" : ");
			String msg = exception.getMessage();
			if(msg != null)
				buffer.append(msg).append('\n');
		}
		buffer.append("----------------------------- \n");
		
		return buffer.toString();
//		// Check for first exception
//		if( encounteredExceptions.size() > 1)
//			return encounteredExceptions.get(0).getMessage();
//		
//		// default
//		return null;
	}
	
	/**
	 * Add an exception to the list of exceptions.
	 * @param exception
	 */
	public void addException( Throwable exception) {
		addException("unknown", exception);
	}

	/**
	 * Add an exception to the list of exceptions. Also record the corresponding model identifier if any.
	 * @param exception
	 */
	public void addException(Object identifier, Throwable exception) {
		encounteredExceptions.add( exception );
		encounteredModels.add(identifier);
	}
	
	/**
	 * Return true if this MultiExceptions contains nested exceptions.
	 * @return
	 */
	public boolean isNotEmpty() {
		return encounteredExceptions.size() != 0;
	}
}
