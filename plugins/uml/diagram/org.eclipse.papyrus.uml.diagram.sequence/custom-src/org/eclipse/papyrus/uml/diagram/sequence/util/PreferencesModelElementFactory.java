package org.eclipse.papyrus.uml.diagram.sequence.util;

import org.eclipse.papyrus.views.properties.contexts.DataContextElement;
import org.eclipse.papyrus.views.properties.modelelement.ModelElement;
import org.eclipse.papyrus.views.properties.modelelement.ModelElementFactory;
import org.eclipse.papyrus.views.properties.modelelement.PreferencesModelElement;


public class PreferencesModelElementFactory implements ModelElementFactory {

	public ModelElement createFromSource(Object sourceElement, DataContextElement context) {
		return new PreferencesModelElement(context);
	}

}
