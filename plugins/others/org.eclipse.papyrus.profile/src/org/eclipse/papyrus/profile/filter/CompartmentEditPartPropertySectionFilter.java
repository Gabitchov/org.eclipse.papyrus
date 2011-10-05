/******************************************************************************
 * Copyright (c) 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - initial API and implementation 
 ****************************************************************************/

package org.eclipse.papyrus.profile.filter;

import org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart;
import org.eclipse.jface.viewers.IFilter;

/**
 * Filter to display a property section if the selection is a compartment edit part.
 */
public class CompartmentEditPartPropertySectionFilter implements IFilter {

	/**
	 * {@inheritDoc}
	 */
	public boolean select(Object object) {
		if(object instanceof CompartmentEditPart)
			return true;

		return false;
	}
}
