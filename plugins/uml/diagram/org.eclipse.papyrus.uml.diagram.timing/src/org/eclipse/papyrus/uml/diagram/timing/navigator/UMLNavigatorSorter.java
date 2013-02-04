/*
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.papyrus.uml.diagram.timing.navigator;

import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.papyrus.uml.diagram.timing.part.UMLVisualIDRegistry;

/**
 * @generated
 */
@SuppressWarnings("all")
// disable warnings on generated code
public class UMLNavigatorSorter extends ViewerSorter {

	/**
	 * @generated
	 */
	private static final int GROUP_CATEGORY = 85;

	/**
	 * @generated
	 */
	@Override
	public int category(final Object element) {
		if(element instanceof UMLNavigatorItem) {
			final UMLNavigatorItem item = (UMLNavigatorItem)element;
			return UMLVisualIDRegistry.getVisualID(item.getView());
		}
		return GROUP_CATEGORY;
	}

}
