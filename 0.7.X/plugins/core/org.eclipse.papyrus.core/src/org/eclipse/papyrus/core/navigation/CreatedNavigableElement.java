package org.eclipse.papyrus.core.navigation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;


public class CreatedNavigableElement extends NavigableElement {

	protected NavigableElement previousNavigableElement = null;

	protected int depth;

	private IModelLinker modelLinker = null;

	private IBaseNameSetter baseNameSetter = null;

	/**
	 * This constructor initiates a navigable element from a newly created element.
	 * This element is not directly linked to its container.
	 * linkToModel() needs to be defined and call when you want to link.
	 * 
	 * @param element
	 * @param previousNavigableElement
	 */
	public CreatedNavigableElement(EObject element, NavigableElement previousNavigableElement, NavigationType navigationType, EStructuralFeature feature, IModelLinker modelLinker, IBaseNameSetter baseNameSetter) {
		super(element, navigationType, feature);
		this.previousNavigableElement = previousNavigableElement;
		this.modelLinker  = modelLinker;
		this.baseNameSetter = baseNameSetter;
		depth = previousNavigableElement.getCreationDepth() + 1;
	}

	public NavigableElement getPreviousNavigableElement() {
		return previousNavigableElement;
	}

	public int getCreationDepth() {
		return depth;
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
