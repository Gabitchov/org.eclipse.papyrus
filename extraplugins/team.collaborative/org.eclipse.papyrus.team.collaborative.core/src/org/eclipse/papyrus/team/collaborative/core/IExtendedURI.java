/*******************************************************************************
 * Copyright (c) 2013 Atos
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Arthur Daussy - initial implementation
 *******************************************************************************/
package org.eclipse.papyrus.team.collaborative.core;

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
