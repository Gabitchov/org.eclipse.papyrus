package org.eclipse.papyrus.uml.search.ui.providers;

import org.eclipse.emf.ecore.EObject;


public class ParticipantTypeAttribute extends ParticipantTypeElement {

	ParticipantTypeElement parent;

	public ParticipantTypeAttribute(EObject element, ParticipantTypeElement type) {
		super(element);
		this.parent = type;
	}


	public ParticipantTypeElement getParent() {
		return parent;
	}


	public void setType(ParticipantTypeElement parent) {
		this.parent = parent;
	}

	public String getText() {

		return super.getText();
	}
}
