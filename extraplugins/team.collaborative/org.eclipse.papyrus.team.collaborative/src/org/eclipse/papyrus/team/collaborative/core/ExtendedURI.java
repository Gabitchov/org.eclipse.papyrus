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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;


/**
 * The Class ExtendedURI.
 * The {@link ExtendedURI} uri is a wrapper for {@link URI}.
 * However it add a way to express containment. This aim to be used for performance issues
 */
public class ExtendedURI implements IExtendedURI {

	/** The Constant CONTAINMENT_PARAMETER_KEY. */
	public static final String CONTAINMENT_PARAMETER_KEY = "Containment";

	/** The uri. */
	private URI uri;

	/** The parameters. */
	private Map<String, Object> parameters = new HashMap<String, Object>();

	/**
	 * Instantiates a new extended uri.
	 * 
	 * @param uri
	 *        the uri
	 */
	public ExtendedURI(URI uri) {
		super();
		this.uri = uri;
	}


	/**
	 * Sets the containment.
	 * 
	 * @param containment
	 *        the containment
	 * @return the extended uri
	 */
	public ExtendedURI setContainment(boolean containment) {
		return setParameter(CONTAINMENT_PARAMETER_KEY, containment);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.team.collaborative.core.IExtendedURI#isContainment()
	 */
	@Override
	public boolean isContainment() {
		Object containment = getParameter(CONTAINMENT_PARAMETER_KEY);
		if(containment != null) {
			return (Boolean)containment;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.team.collaborative.core.IExtendedURI#setParameter(java.lang.String, java.lang.Object)
	 */
	@Override
	public ExtendedURI setParameter(String id, Object value) {
		parameters.put(id, value);
		return this;
	}




	/**
	 * Sets the uri.
	 * 
	 * @param uri
	 *        the uri
	 * @return the extended uri
	 */
	public IExtendedURI setUri(URI uri) {
		this.uri = uri;
		return this;
	}


	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.team.collaborative.core.IExtendedURI#getParameter(java.lang.String)
	 */
	@Override
	public Object getParameter(String id) {
		return parameters.get(id);
	}


	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.team.collaborative.core.IExtendedURI#getUri()
	 */
	@Override
	public URI getUri() {
		return uri;
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((parameters == null) ? 0 : parameters.hashCode());
		result = prime * result + ((uri == null) ? 0 : uri.hashCode());
		return result;
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		ExtendedURI other = (ExtendedURI)obj;
		if(parameters == null) {
			if(other.parameters != null)
				return false;
		} else if(!parameters.equals(other.parameters))
			return false;
		if(uri == null) {
			if(other.uri != null)
				return false;
		} else if(!uri.equals(other.uri))
			return false;
		return true;
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(uri.toString());
		stringBuilder.append("[");
		stringBuilder.append(isContainment());
		stringBuilder.append("]");
		return stringBuilder.toString();
	}





}
