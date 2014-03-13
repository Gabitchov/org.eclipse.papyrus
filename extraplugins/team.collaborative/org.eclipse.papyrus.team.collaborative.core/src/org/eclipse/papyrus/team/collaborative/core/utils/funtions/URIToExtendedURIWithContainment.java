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
import org.eclipse.papyrus.team.collaborative.core.ExtendedURI;
import org.eclipse.papyrus.team.collaborative.core.IExtendedURI;

import com.google.common.base.Function;


/**
 * The Class URIToExtendedURIWithContainment.
 * Function used to convert {@link URI} to {@link ExtendedURI} with containment
 */
public class URIToExtendedURIWithContainment implements Function<URI, IExtendedURI> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.common.base.Function#apply(java.lang.Object)
	 */
	@Override
	public ExtendedURI apply(URI from) {
		return new ExtendedURI(from).setContainment(true);
	}

	/**
	 * The Class SingletonHolder.
	 */
	private static class SingletonHolder {

		/** The instance. */
		private static URIToExtendedURIWithContainment INSTANCE = new URIToExtendedURIWithContainment();
	}

	/**
	 * Private constructor.
	 */
	private URIToExtendedURIWithContainment() {
		// TODO auto-generated constructor
	}

	/**
	 * Returns the Singleton instance.
	 * <p>
	 * 
	 * @return The Singleton instance.
	 */
	public static URIToExtendedURIWithContainment getInstance() {
		return SingletonHolder.INSTANCE;
	}

}