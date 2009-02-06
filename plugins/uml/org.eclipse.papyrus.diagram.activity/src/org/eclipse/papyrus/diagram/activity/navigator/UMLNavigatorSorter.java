/*******************************************************************************
 * Copyright (c) 2008 
 * Conselleria de Infraestructuras y Transporte, Generalitat de la Comunitat Valenciana .
 * All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *	  Francisco Javier Cano Muñoz (Prodevelop) - initial API implementation
 ******************************************************************************/
package org.eclipse.papyrus.diagram.activity.navigator;

import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.papyrus.diagram.activity.part.UMLVisualIDRegistry;

/**
 * @generated
 */
public class UMLNavigatorSorter extends ViewerSorter {

	/**
	 * @generated
	 */
	private static final int GROUP_CATEGORY = 5005;

	/**
	 * @generated
	 */
	private static final int SHORTCUTS_CATEGORY = 5004;

	/**
	 * @generated
	 */
	@Override
	public int category(Object element) {
		if (element instanceof UMLNavigatorItem) {
			UMLNavigatorItem item = (UMLNavigatorItem) element;
			if (item.getView().getEAnnotation("Shortcut") != null) { //$NON-NLS-1$
				return SHORTCUTS_CATEGORY;
			}
			return UMLVisualIDRegistry.getVisualID(item.getView());
		}
		return GROUP_CATEGORY;
	}

}
