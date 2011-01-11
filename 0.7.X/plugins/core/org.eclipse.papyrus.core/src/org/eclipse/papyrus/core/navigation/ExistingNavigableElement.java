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
