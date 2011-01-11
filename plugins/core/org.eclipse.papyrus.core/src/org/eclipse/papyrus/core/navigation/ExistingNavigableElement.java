/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Mathieu Velten (Atos Origin) mathieu.velten@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.core.navigation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;


public class ExistingNavigableElement extends NavigableElement {

	/**
	 * This constructor initiates a navigable element from an existing model element.
	 * 
	 * @param element
	 */
	public ExistingNavigableElement(EObject element, NavigationType navigationType, EStructuralFeature feature) {
		super(element, navigationType, feature);
	}

	@Override
	public int getCreationDepth() {
		return 0;
	}
}
