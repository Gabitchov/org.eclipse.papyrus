/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.runtime.propertyeditor;

import org.eclipse.jface.viewers.EditingSupport;



/**
 * Property editor for structural features that have multiplicity [n..*]
 */
public class MultipleStructuralFeaturesPropertyEditor extends AbstractTablePropertyEditor {

	/** id of this editor */
	public static final String ID = "org.eclipse.papyrus.views.properties.runtime.multipleStructuralFeaturesPropertyEditor";

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected EditingSupport createEditingSupport() {
		return null;
	}

}
