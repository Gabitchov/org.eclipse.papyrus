/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.widgets.providers;


/**
 * A ContentProvider returning empty collections
 * 
 * @author Camille Letavernier
 * 
 */
public class EmptyContentProvider extends AbstractStaticContentProvider {

	/**
	 * Singleton instance
	 */
	public static EmptyContentProvider instance = new EmptyContentProvider();

	private final Object[] value = new Object[0];

	private EmptyContentProvider() {

	}

	/**
	 * @see org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider#getElements()
	 * 
	 * @return
	 *         an empty array
	 */
	public Object[] getElements() {
		return value;
	}

}
