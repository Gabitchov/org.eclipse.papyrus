package org.eclipse.papyrus.qompass.designer.core.dialogs;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.uml2.uml.NamedElement;

public class QNameLabelProvider extends LabelProvider {

	public String getText(Object element) {
		return ((NamedElement)element).getQualifiedName();
	}
};
