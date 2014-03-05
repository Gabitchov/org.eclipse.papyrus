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
package org.eclipse.papyrus.team.collaborative.utils.funtions;

import org.eclipse.core.resources.IResource;
import org.eclipse.papyrus.team.collaborative.ExtendedURI;
import org.eclipse.papyrus.team.collaborative.utils.URIUtils;

import com.google.common.base.Function;


/**
 * The Class IResourceToExtendedURI.
 * Function used to convert {@link IResource} to {@link ExtendedURI}
 */
public class IResourceToExtendedURI implements Function<IResource, ExtendedURI> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.common.base.Function#apply(java.lang.Object)
	 */
	@Override
	public ExtendedURI apply(IResource from) {
		return new ExtendedURI(URIUtils.getURI(from));
	}

	/**
	 * The Class SingletonHolder.
	 */
	private static class SingletonHolder {

		/** The instance. */
		private static IResourceToExtendedURI INSTANCE = new IResourceToExtendedURI();
	}

	/**
	 * Private constructor.
	 */
	private IResourceToExtendedURI() {
	}

	/**
	 * Returns the Singleton instance.
	 * <p>
	 * 
	 * @return The Singleton instance.
	 */
	public static IResourceToExtendedURI getInstance() {
		return SingletonHolder.INSTANCE;
	}

}
