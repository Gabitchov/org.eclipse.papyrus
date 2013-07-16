package org.eclipse.papyrus.uml.search.ui.providers;

import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.NamedElement;


public class ParticipantTypeElement {

	boolean isChecked;

	EObject element;



	public EObject getElement() {
		return element;
	}



	public void setElement(EObject element) {
		this.element = element;
	}


	public ParticipantTypeElement(EObject element) {
		super();
		this.element = element;
		isChecked = false;
	}


	public boolean isChecked() {
		return isChecked;
	}


	public void setChecked(boolean isChecked) {
		this.isChecked = isChecked;
	}


	public String getText() {
		if(element instanceof NamedElement) {
			return ((NamedElement)element).getName();
		} else if(element instanceof ENamedElement) {
			return ((ENamedElement)element).getName();
		}
		return null;
	}

}
