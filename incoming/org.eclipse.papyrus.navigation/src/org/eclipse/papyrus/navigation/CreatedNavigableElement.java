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
 * This class represents an element that have been created by the navigation.
 * This element is not currently linked to the model, but it can be
 * by using linkToModel if the user decides to navigate to it,
 * to create a diagram on it for example.
 * @author mvelten
 *
 */
public class CreatedNavigableElement extends NavigableElement {

	protected NavigableElement previousNavigableElement = null;

	private IModelLinker modelLinker = null;

	private IBaseNameSetter baseNameSetter = null;

	/**
	 * This constructor initiates a navigable element from a newly created element.
	 * This element is not directly linked to its container.
	 * linkToModel() needs to be defined and call when you want to link it.
	 * 
	 * @param element
	 * @param previousNavigableElement
	 */
	public CreatedNavigableElement(EObject element, NavigableElement previousNavigableElement, EStructuralFeature feature, IModelLinker modelLinker, IBaseNameSetter baseNameSetter) {
		super(element, previousNavigableElement, feature);
		this.previousNavigableElement = previousNavigableElement;
		this.modelLinker  = modelLinker;
		this.baseNameSetter = baseNameSetter;
	}

	public NavigableElement getPreviousNavigableElement() {
		return previousNavigableElement;
	}

	public void linkToModel() {
		if (modelLinker != null) {
			modelLinker.linkToModel(getElement());
		}
	}

	public void setBaseName(String base) {
		if (baseNameSetter != null) {
			baseNameSetter.setBaseName(base, getElement());
		}
	}
}
