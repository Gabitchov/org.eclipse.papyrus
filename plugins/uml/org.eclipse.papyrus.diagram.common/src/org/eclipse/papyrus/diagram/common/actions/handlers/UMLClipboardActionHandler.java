package org.eclipse.papyrus.diagram.common.actions.handlers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.diagram.common.actions.LabelHelper;
import org.eclipse.uml2.uml.NamedElement;

public class UMLClipboardActionHandler extends ClipboardActionHandler {

	@Override
	protected void prepareEObject(EObject eObject) {
		if (eObject instanceof NamedElement) {
			NamedElement namedElement = (NamedElement) eObject;
			namedElement.setName(LabelHelper.INSTANCE.findName(eObject.eContainer(), namedElement));
		}
	}
}
