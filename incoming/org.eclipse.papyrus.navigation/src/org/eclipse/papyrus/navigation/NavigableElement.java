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
 * This class represents an element which can be accessed
 * from an other element throught a feature using defined navigation rules.
 * 
 * @author mvelten
 *
 */
public abstract class NavigableElement implements Comparable<NavigableElement> {

	private EObject element = null;

	private EStructuralFeature feature = null;

	private int depth = 0;

	public NavigableElement(EObject element, EStructuralFeature feature) {
		this.element = element;
		this.feature = feature;
	}

	public NavigableElement(EObject element, NavigableElement previousNavigableElement, EStructuralFeature feature) {
		this(element, feature);
		if (previousNavigableElement != null) {
			this.depth = previousNavigableElement.getDepth() + 1;
		}
	}

	public EObject getElement() {
		return element;
	}

	public EStructuralFeature getFeature() {
		return feature;
	}

	/**
	 * Retrieve the navigation depth.
	 * 
	 * @return the navigation depth
	 */
	public int getDepth() {
		return depth;
	}

	public int compareTo(NavigableElement o) {
		return getDepth() - o.getDepth();
	}
}
