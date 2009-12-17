/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.parametric.navigator;

import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.papyrus.sysml.diagram.parametric.part.SysmlVisualIDRegistry;

/**
 * @generated
 */
public class SysmlNavigatorSorter extends ViewerSorter {

	/**
	 * @generated
	 */
	private static final int GROUP_CATEGORY = 2007;

	/**
	 * @generated
	 */
	public int category(Object element) {
		if (element instanceof SysmlNavigatorItem) {
			SysmlNavigatorItem item = (SysmlNavigatorItem) element;
			return SysmlVisualIDRegistry.getVisualID(item.getView());
		}
		return GROUP_CATEGORY;
	}

}
