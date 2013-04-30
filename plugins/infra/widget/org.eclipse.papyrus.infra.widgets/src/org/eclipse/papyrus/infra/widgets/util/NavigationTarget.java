/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (camille.letavernier@cea.fr) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.widgets.util;

import java.util.Collection;

/**
 * This interface is used to select and reveal element that are given in parameter. Example
 * of the use case: the class that implements this interface can be a diagram
 * that select all editparts that are linked to the given list of elements.
 * 
 * The element parameter can be either a semantic element (Which will likely be wrapped
 * in a graphical element such as an EditPart), or a notation element (Such as a GMF notation::View)
 */
public interface NavigationTarget {

	/**
	 * Select and reveal the given element. Element may be either a semantic element (e.g. a uml::Class)
	 * or a graphical element (e.g. GMF notation::View)
	 * 
	 * @param element
	 * @return
	 *         True if the element has been selected, false otherwise
	 */
	public boolean revealElement(Object element);

	/**
	 * Select and reveal the given elements. Elements may be either semantic elements (e.g. uml::Class)
	 * or graphical elements (e.g. GMF notation::View)
	 * 
	 * @param elements
	 * @return
	 *         True if the elements have been selected, false otherwise
	 */
	public boolean revealElement(Collection<?> elements);
}
