/*******************************************************************************
 * Copyright (c) 2009 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     CEA LIST - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.profile.utils;

import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.uml2.uml.Element;

/**
 * Filter that returns <code>true</code> if the element associated to the object is a UML {@link Element}.
 */
public class UmlElementFilter implements IFilter {

	/**
	 * {@inheritDoc}
	 */
	public boolean select(Object object) {
		// test element is a node edit part and its controlled element has an associated UML element
		if(object instanceof IGraphicalEditPart
				&& ((IGraphicalEditPart)object).getNotationView().getElement() instanceof Element)
			return true;

		if(object instanceof Element) {
			return true;
		}

		return false;
	}

}
