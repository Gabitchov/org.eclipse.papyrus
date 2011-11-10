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

import org.eclipse.jface.viewers.ITreeContentProvider;

/**
 * A Hierarchic content provider. In some cases, we want to be able to display
 * elements as a Tree, but we are only interested in some specific elements.
 * The other ones are displayed only to show the hierarchy.
 * This interface allows the user to specify which elements he is interested
 * in.
 * 
 * @author Camille Letavernier
 * 
 */
public interface IHierarchicContentProvider extends ITreeContentProvider {

	/**
	 * Indicates if the given is a valid value. Only valid values can be
	 * chosen.
	 * 
	 * @param element
	 *        The element to test
	 * @return
	 *         True if the element is a valid value
	 */
	public boolean isValidValue(Object element);
}
