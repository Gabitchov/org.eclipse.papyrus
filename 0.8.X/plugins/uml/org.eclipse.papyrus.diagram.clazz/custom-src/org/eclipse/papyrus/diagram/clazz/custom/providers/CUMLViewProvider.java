package org.eclipse.papyrus.diagram.clazz.custom.providers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;


public class CUMLViewProvider extends org.eclipse.papyrus.diagram.clazz.providers.UMLViewProvider {

	@Override
	public Edge createAssociation_4019(EObject domainElement,
			View containerView, int index, boolean persisted,
			PreferencesHint preferencesHint) {
		
		
		return super.createAssociation_4019(domainElement, containerView, index,
				persisted, preferencesHint);
	}
}
