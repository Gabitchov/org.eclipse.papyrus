/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.profile.properties.modelelement;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.uml.profile.structure.AppliedStereotypeProperty;
import org.eclipse.papyrus.uml.tools.databinding.PapyrusObservableList;
import org.eclipse.papyrus.uml.tools.databinding.PapyrusObservableValue;
import org.eclipse.papyrus.views.properties.modelelement.EMFModelElement;

public class AppliedStereotypePropertyModelElement extends EMFModelElement {

	protected AppliedStereotypeProperty stereotypeProperty;

	public AppliedStereotypePropertyModelElement(AppliedStereotypeProperty stereotypeProperty) {
		this(stereotypeProperty, null);
	}

	public AppliedStereotypePropertyModelElement(AppliedStereotypeProperty stereotypeProperty, EditingDomain domain) {
		super(stereotypeProperty.getStereotypeApplication(), domain);
		this.stereotypeProperty = stereotypeProperty;
	}

	@Override
	protected IObservable doGetObservable(String propertyPath) {
		EStructuralFeature feature = getFeature(propertyPath);

		//TODO : Handle datatypes
		//We should delegate that to StereotypeModelElement
		if(feature.getEType() instanceof EDataType && !(feature.getEType() instanceof EEnum)) {
			if(feature.getUpperBound() == 1) {
				//Single-valued DataType
				//if(DataTypeProvider.instance.canHandle((EDataType)feature.getEType())) {
				//	return new StructuredDataTypeObservableValue(source, feature, domain, (EDataType)feature.getEType());
				//}
				//TODO : Multi-valued DataTypes
			}
		}

		if(feature.getUpperBound() != 1) {
			return new PapyrusObservableList(EMFProperties.list(feature).observe(source), domain, source, feature);
		}

		return new PapyrusObservableValue(source, feature, domain);
	}

	//propertyPath = "value" | "values" : this is a generic property name.
	//We should rely on stereotypeProperty#getStereotypeProperty#getName instead
	@Override
	public EStructuralFeature getFeature(String propertyPath) {
		return super.getFeature(stereotypeProperty.getStereotypeProperty().getName());
	}

	//propertyPath = "value" | "values" : this is a generic property name.
	//We should rely on stereotypeProperty#getStereotypeProperty#getName instead
	@Override
	public FeaturePath getFeaturePath(String propertyPath) {
		return super.getFeaturePath(stereotypeProperty.getStereotypeProperty().getName());
	}
}
