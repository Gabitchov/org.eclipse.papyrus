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
package org.eclipse.papyrus.infra.widgets.providers;

import org.eclipse.jface.viewers.IStructuredContentProvider;

/**
 * A content provider that can be adapted from container value
 * to semantic value. Useful when you want to display wrapped
 * values, but still keep an access to the actual semantic values
 * 
 * @author Camille Letavernier
 */
public interface IAdaptableContentProvider extends IStructuredContentProvider {

	/**
	 * Returns the semantic Object contained in the given selection
	 * 
	 * @param containerElement
	 * @return
	 *         The semantic element contained in the given containerElement
	 */
	public Object getAdaptedValue(Object containerElement);

	/**
	 * Return an object wrapping the given semanticElement
	 * 
	 * @param semanticElement
	 * @return
	 *         The container object wrapping the semantic element
	 */
	//	public Object getContainerValue(Object semanticElement);
}
