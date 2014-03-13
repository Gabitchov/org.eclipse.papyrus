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
 * The Class URIToExtendedURI.
 * Function used to convert {@link URI} to {@link ExtendedURI} (No containment)
 */
public class URIToExtendedURI implements Function<URI, IExtendedURI> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.common.base.Function#apply(java.lang.Object)
	 */
	@Override
	public IExtendedURI apply(URI from) {
		return new ExtendedURI(from);
	}

	private static class SingletonHolder {

		private static URIToExtendedURI INSTANCE = new URIToExtendedURI();
	}

	/**
	 * Private constructor.
	 */
	private URIToExtendedURI() {
		// TODO auto-generated constructor
	}

	/**
	 * Returns the Singleton instance.
	 * <p>
	 * 
	 * @return The Singleton instance.
	 */
	public static URIToExtendedURI getInstance() {
		return SingletonHolder.INSTANCE;
	}

}
