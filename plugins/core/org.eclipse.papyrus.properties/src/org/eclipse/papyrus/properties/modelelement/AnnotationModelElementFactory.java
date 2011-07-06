package org.eclipse.papyrus.properties.modelelement;

import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.properties.Activator;
import org.eclipse.papyrus.properties.contexts.DataContextElement;
import org.eclipse.papyrus.properties.util.EMFHelper;


public class AnnotationModelElementFactory implements ModelElementFactory {

	public ModelElement createFromSource(Object sourceElement, DataContextElement context) {
		EObject source = EMFHelper.getEObject(sourceElement);
		if(source == null) {
			Activator.log.warn("Unable to resolve the selected element to an EObject"); //$NON-NLS-1$
			return null;
		}
		
		if (! (source instanceof EModelElement)){
			Activator.log.warn("The selected element must be an EModelElement");
		}

		EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(source);
		return new AnnotationModelElement((EModelElement)source, domain, context.getName());
	}

}
