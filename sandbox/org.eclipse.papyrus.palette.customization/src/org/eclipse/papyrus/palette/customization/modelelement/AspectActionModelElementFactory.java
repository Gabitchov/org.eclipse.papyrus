package org.eclipse.papyrus.palette.customization.modelelement;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.diagram.common.service.palette.IAspectAction;
import org.eclipse.papyrus.paletteconfiguration.ToolConfiguration;
import org.eclipse.papyrus.properties.contexts.DataContextElement;
import org.eclipse.papyrus.properties.modelelement.ModelElement;
import org.eclipse.papyrus.properties.modelelement.ModelElementFactory;


public class AspectActionModelElementFactory implements ModelElementFactory {

	public ModelElement createFromSource(Object sourceElement, DataContextElement context) {
		if(sourceElement instanceof IAspectAction) {
			return new AspectActionModelElement((IAspectAction)sourceElement);
		} else if(sourceElement instanceof IAdaptable) {
			Object adaptedEObject = ((IAdaptable)sourceElement).getAdapter(EObject.class);
			if(adaptedEObject instanceof EObject) {
				EObject eObject = (EObject)adaptedEObject;
				if(eObject instanceof ToolConfiguration) {
					return new ToolConfigurationModelElement((ToolConfiguration)eObject);
				}
			}
		}
		return null;
	}

}
