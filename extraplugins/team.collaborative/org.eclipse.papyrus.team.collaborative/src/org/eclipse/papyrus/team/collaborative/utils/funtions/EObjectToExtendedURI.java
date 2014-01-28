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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.team.collaborative.ExtendedURI;
import org.eclipse.papyrus.team.collaborative.IExtendedURI;

import com.google.common.base.Function;


/**
 * The Class EObjectToExtendedURI.
 * Function to convert {@link EObject} to {@link ExtendedURI}
 */
public class EObjectToExtendedURI implements Function<EObject, IExtendedURI> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.common.base.Function#apply(java.lang.Object)
	 */
	@Override
	public IExtendedURI apply(EObject from) {
		Resource resoure = from.eResource();
		return new ExtendedURI(resoure.getURI().appendFragment(resoure.getURIFragment(from)));
	}

	/**
	 * The Class SingletonHolder.
	 */
	private static class SingletonHolder {

		/** The instance. */
		private static EObjectToExtendedURI INSTANCE = new EObjectToExtendedURI();
	}

	/**
	 * Private constructor.
	 */
	private EObjectToExtendedURI() {
	}

	/**
	 * Returns the Singleton instance.
	 * <p>
	 * 
	 * @return The Singleton instance.
	 */
	public static EObjectToExtendedURI getInstance() {
		return SingletonHolder.INSTANCE;
	}

}
