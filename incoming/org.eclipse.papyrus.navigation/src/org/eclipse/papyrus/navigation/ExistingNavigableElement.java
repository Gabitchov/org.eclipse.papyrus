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
package org.eclipse.papyrus.navigation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * This class represents an element that already exists in the navigated model.
 * @author mvelten
 *
 */
public class ExistingNavigableElement extends NavigableElement {

	/**
	 * This constructor initiates a navigable element from an existing model element.
	 * 
	 * @param element
	 */
	public ExistingNavigableElement(EObject element, EStructuralFeature feature) {
		super(element, feature);
	}

}
