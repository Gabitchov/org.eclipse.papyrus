/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.tabbed.profile.imagesection;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.uml2.uml.Image;


/**
 * filter in order to display property view only for the element IMAGE of UML
 */
public class ImageSectionFilter implements IFilter {

	/**
	 * {@inheritDoc}
	 */
	public boolean select(Object object) {
		if(object instanceof GraphicalEditPart && ((GraphicalEditPart)object).getNotationView().getElement() instanceof Image) {
			return true;
		}

		if(object instanceof IAdaptable && ((IAdaptable)object).getAdapter(EObject.class) instanceof Image) {
			return true;
		}
		return false;
	}
}
