package org.eclipse.papyrus.qompass.designer.core.dialogs;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;

public class AttributeLabelProvider extends LabelProvider {

	public String getText(Object element) {
		if(element instanceof Property) {
			Property p = (Property)element;
			Type type = p.getType();
			return p.getClass_().getName() + "." + p.getName() + ((type != null) ?
				" : " + type.getQualifiedName() :
				"");
		}
		else {
			return "invalid";
		}
	}
};
