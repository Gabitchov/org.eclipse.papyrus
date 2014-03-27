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
package org.eclipse.papyrus.team.collaborative.core.utils.funtions;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

import com.google.common.base.Function;


/**
 * The Class ResourceToURI.
 * Function used to convert {@link Resource} to {@link URI}
 */
public class ResourceToURI implements Function<Resource, URI> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.common.base.Function#apply(java.lang.Object)
	 */
	@Override
	public URI apply(Resource from) {
		return from.getURI();
	}

	/**
	 * The Class SingletonHolder.
	 */
	private static class SingletonHolder {

		/** The instance. */
		private static ResourceToURI INSTANCE = new ResourceToURI();
	}

	/**
	 * Private constructor.
	 */
	private ResourceToURI() {
		// TODO auto-generated constructor
	}

	/**
	 * Returns the Singleton instance.
	 * <p>
	 * 
	 * @return The Singleton instance.
	 */
	public static ResourceToURI getInstance() {
		return SingletonHolder.INSTANCE;
	}

}
