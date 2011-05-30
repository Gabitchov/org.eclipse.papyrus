package org.eclipse.papyrus.properties.uml.modelelement;

import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.papyrus.properties.Activator;
import org.eclipse.papyrus.properties.contexts.DataContextElement;
import org.eclipse.papyrus.properties.modelelement.ModelElement;
import org.eclipse.papyrus.properties.modelelement.ModelElementFactory;
import org.eclipse.papyrus.properties.uml.util.UMLUtil;
import org.eclipse.uml2.uml.Element;


public class StereotypeAppearanceFactory implements ModelElementFactory {

	public ModelElement createFromSource(Object sourceElement, DataContextElement context) {
		Element umlSource = UMLUtil.resolveUMLElement(sourceElement);

		if(umlSource == null) {
			Activator.log.warn("Unable to resolve the selected element to a UML Element"); //$NON-NLS-1$
			return null;
		}

		if(sourceElement instanceof EditPart) {
			EModelElement modelElement = (EModelElement)((EditPart)sourceElement).getModel();
			EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(umlSource);
			return new StereotypeAppearanceModelElement(umlSource, domain, modelElement);
		}

		Activator.log.warn("The selected element is not an edit part");
		return null;
	}

}
