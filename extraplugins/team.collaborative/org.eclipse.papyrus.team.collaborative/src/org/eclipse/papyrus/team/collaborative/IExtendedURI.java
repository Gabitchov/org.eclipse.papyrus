package org.eclipse.papyrus.team.collaborative;

import org.eclipse.emf.common.util.URI;



public interface IExtendedURI {

	/**
	 * Checks if this {@link ExtendedURI} is express containment.
	 * 
	 * @return true, if is containment
	 */
	public abstract boolean isContainment();

	/**
	 * Sets the parameter.
	 * 
	 * @param id
	 *        the id
	 * @param value
	 *        the value
	 * @return the extended uri
	 */
	public abstract IExtendedURI setParameter(String id, Object value);

	/**
	 * Gets the parameter.
	 * 
	 * @param id
	 *        the id
	 * @return the parameter
	 */
	public abstract Object getParameter(String id);

	/**
	 * Gets the uri.
	 * 
	 * @return the uri
	 */
	public abstract URI getUri();

}
