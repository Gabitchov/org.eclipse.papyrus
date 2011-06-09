/*****************************************************************************
 * Copyright (c) 2009 ATOS ORIGIN.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan FAURE (ATOS ORIGIN) tristan.faure@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.internalblock.navigator;

import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.papyrus.sysml.diagram.internalblock.part.SysmlVisualIDRegistry;

/**
 * @generated
 */
public class SysmlNavigatorSorter extends ViewerSorter {

	/**
	 * @generated
	 */
	private static final int GROUP_CATEGORY = 2003;

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
