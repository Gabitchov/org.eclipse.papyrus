package org.eclipse.papyrus.qompass.designer.core.dialogs;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;

public class InstanceLabelProvider extends LabelProvider {

	public String getText(Object element) {
		if (element instanceof NamedElement) {	
			String instanceName = ((NamedElement)element).getName();
			Element owner = ((Element) element).getOwner();
			if (owner instanceof NamedElement) {
				return "Plan " + ((NamedElement) owner).getName() + ": " + instanceName;
			}
			else {
				return instanceName; 
			}
		}
		else {
			return "not a named element";
		}
	}
};
