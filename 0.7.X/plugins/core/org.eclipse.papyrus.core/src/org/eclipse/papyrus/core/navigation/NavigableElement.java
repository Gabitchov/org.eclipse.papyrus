package org.eclipse.papyrus.core.navigation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;


public abstract class NavigableElement implements Comparable<NavigableElement> {

	public enum NavigationType {
		STRUCTURAL, BEHAVIORAL;

		@Override
		public String toString() {
			if(this.equals(STRUCTURAL)) {
				return "Structural";
			} else {
				return "Behavioral";
			}
		}
	}

	private EObject element = null;

	private NavigationType navigationType = NavigationType.STRUCTURAL;

	private EStructuralFeature feature = null;

	public NavigableElement(EObject element, NavigationType navigationType, EStructuralFeature feature) {
		this.element = element;
		this.navigationType = navigationType;
		this.feature = feature;
	}

	public EObject getElement() {
		return element;
	}

	public EStructuralFeature getFeature() {
		return feature;
	}

	public NavigationType getNavigationType() {
		return navigationType;
	}

	/**
	 * Retrieve the creation depth.
	 * It is 0 for an existing element.
	 * 
	 * @return
	 */
	public abstract int getCreationDepth();

	public int compareTo(NavigableElement o) {
		return getCreationDepth() - o.getCreationDepth();
	}
}
