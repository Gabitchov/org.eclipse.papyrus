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

import org.eclipse.jface.viewers.IStructuredContentProvider;

/**
 * A ContentProvider which returns values that don't depend
 * on an input value
 * 
 * In most cases, you should extend the Abstract implementation {@link AbstractStaticContentProvider}
 * 
 * @author Camille Letavernier
 * 
 * @see AbstractStaticContentProvider
 * 
 */
public interface IStaticContentProvider extends IStructuredContentProvider {

	/**
	 * @return the elements provided by this class
	 */
	public Object[] getElements();
}
