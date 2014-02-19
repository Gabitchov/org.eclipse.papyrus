/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.modelelement;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;
import org.eclipse.papyrus.uml.properties.datatype.DataTypeProvider;
import org.eclipse.papyrus.uml.properties.datatype.StructuredDataTypeObservableValue;
import org.eclipse.papyrus.uml.tools.databinding.PapyrusObservableList;
import org.eclipse.papyrus.uml.tools.databinding.PapyrusObservableValue;
import org.eclipse.papyrus.uml.tools.providers.UMLContentProvider;
import org.eclipse.papyrus.uml.tools.providers.UMLFilteredLabelProvider;
import org.eclipse.papyrus.views.properties.modelelement.EMFModelElement;
import org.eclipse.uml2.uml.Stereotype;

/**
 * A Model Element for manipulating Stereotype properties
 * 
 * @author Camille Letavernier
 */
public class StereotypeModelElement extends EMFModelElement {

	/**
	 * The stereotype handled by this ModelElement
	 */
	protected Stereotype stereotype;

	/**
	 * Constructor.
	 * 
	 * @param stereotypeApplication
	 *        The StereotypeApplication being edited
	 * @param stereotype
	 *        The Stereotype element
	 * @param domain
	 *        The Editing domain on which the commands will be called
	 * 
	 */
	public StereotypeModelElement(EObject stereotypeApplication, Stereotype stereotype, EditingDomain domain) {
		super(stereotypeApplication, domain);
		this.stereotype = stereotype;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IObservable doGetObservable(String propertyPath) {
		FeaturePath featurePath = getFeaturePath(propertyPath);
		EStructuralFeature feature = getFeature(featurePath);
		if(feature == null) {
			return super.doGetObservable(propertyPath);
		}

		if(feature.getEType() instanceof EDataType && !(feature.getEType() instanceof EEnum)) {
			if(feature.getUpperBound() == 1) {
				//Single-valued DataType
				if(DataTypeProvider.instance.canHandle((EDataType)feature.getEType())) {
					return new StructuredDataTypeObservableValue(source, feature, domain, (EDataType)feature.getEType());
				}
				//TODO : Multi-valued DataTypes
			}
		}

		if(feature.getUpperBound() != 1) {
			return new PapyrusObservableList(EMFProperties.list(featurePath).observe(source), domain, getSource(featurePath), feature);
		}

		return new PapyrusObservableValue(getSource(featurePath), feature, domain);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ILabelProvider getLabelProvider(String propertyPath) {
		EStructuralFeature feature = getFeature(propertyPath);
		if(feature == null) {
			return super.getLabelProvider(propertyPath);
		}
		if(feature.getEType() instanceof EEnum) {
			return super.getLabelProvider(propertyPath);
		}
		return new UMLFilteredLabelProvider();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IStaticContentProvider getContentProvider(String propertyPath) {
		EStructuralFeature feature = getFeature(propertyPath);

		if(feature == null) {
			return super.getContentProvider(propertyPath);
		}

		return new UMLContentProvider(source, feature, stereotype);
	}
}
