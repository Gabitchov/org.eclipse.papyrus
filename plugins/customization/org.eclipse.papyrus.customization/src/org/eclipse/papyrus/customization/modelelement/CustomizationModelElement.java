package org.eclipse.papyrus.customization.modelelement;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.customization.creation.CustomizationElementCreationFactory;
import org.eclipse.papyrus.customization.model.customization.CustomizationPackage;
import org.eclipse.papyrus.properties.modelelement.EMFModelElement;
import org.eclipse.papyrus.widgets.creation.ReferenceValueFactory;


public class CustomizationModelElement extends EMFModelElement {

	public CustomizationModelElement(EObject source) {
		super(source);
	}

	public CustomizationModelElement(EObject source, EditingDomain domain) {
		super(source, domain);
	}

	@Override
	public ReferenceValueFactory getValueFactory(String propertyPath) {
		EStructuralFeature feature = getFeature(propertyPath);
		if(feature.getEType() == CustomizationPackage.eINSTANCE.getCustomizableElement()) {
			return new CustomizationElementCreationFactory((EReference)feature);
		}
		return super.getValueFactory(propertyPath);
	}

}
