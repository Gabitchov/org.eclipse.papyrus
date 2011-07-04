/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.widgets.providers;

import org.eclipse.jface.viewers.IStructuredContentProvider;

/**
 * A content provider that can be adapted from container value
 * to semantic value. Useful when you want to provide wrapped
 * values.
 * 
 * @author Camille Letavernier
 */
public interface IAdaptableContentProvider extends IStructuredContentProvider {

	/**
	 * Returns the actual Object contained in the given selection
	 * 
	 * @param selection
	 * @return
	 */
	public Object getAdaptedValue(Object selection);

	/**
	 * Return an object containing the given selection
	 * 
	 * @param selection
	 * @return
	 */
	public Object getContainerValue(Object selection);
}
