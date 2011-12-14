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

import java.util.Collections;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.infra.widgets.providers.EmptyContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;
import org.eclipse.papyrus.uml.modelexplorer.widgets.ServiceEditFilteredUMLContentProvider;
import org.eclipse.papyrus.uml.properties.databinding.PapyrusObservableList;
import org.eclipse.papyrus.uml.properties.databinding.PapyrusObservableValue;
import org.eclipse.papyrus.uml.properties.datatype.DataTypeProvider;
import org.eclipse.papyrus.uml.properties.datatype.StructuredDataTypeObservableValue;
import org.eclipse.papyrus.uml.properties.providers.UMLLabelProvider;
import org.eclipse.papyrus.uml.tools.utils.PackageUtil;
import org.eclipse.papyrus.views.properties.modelelement.EMFModelElement;
import org.eclipse.papyrus.views.properties.util.EMFHelper;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * A Model Element for manipulating Stereotype properties
 *
 * @author Camille Letavernier
 */
public class StereotypeModelElement extends EMFModelElement {

	/**
	 * Constructor.
	 *
	 * @param source
	 *        The StereotypeApplication being edited
	 * @param domain
	 *        The Editing domain on which the commands will be called
	 *
	 */
	public StereotypeModelElement(EObject source, EditingDomain domain) {
		super(source, domain);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IObservable doGetObservable(String propertyPath) {
		FeaturePath featurePath = getFeaturePath(propertyPath);
		EStructuralFeature feature = getFeature(featurePath);

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
		if(feature.getEType() instanceof EEnum) {
			return super.getLabelProvider(propertyPath);
		}
		return new UMLLabelProvider();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IStaticContentProvider getContentProvider(String propertyPath) {
		FeaturePath featurePath = getFeaturePath(propertyPath);
		EStructuralFeature feature = getFeature(featurePath);
		EClassifier type = feature.getEType();

		if(isStereotype(type)) {
			return getStereotypedReferenceContentProvider(propertyPath);
		} else if(type instanceof EEnum || type instanceof EClass) {
			return super.getContentProvider(propertyPath);
		}

		return EmptyContentProvider.instance;
	}

	protected boolean isStereotype(EClassifier type) {
		if(type instanceof Stereotype) {
			return true;
		}

		if(type instanceof EClass) {
			EClass eClass = (EClass)type;
			return !EMFHelper.isSubclass(eClass, UMLPackage.eINSTANCE.getElement());
		}

		return false;
	}

	/**
	 * Returns the content provider for reference properties typed
	 * by a stereotype
	 *
	 * @param propertyPath
	 *        The name of the property being edited
	 * @return
	 *         The Content Provider for properties typed by a stereotype
	 */
	protected IStaticContentProvider getStereotypedReferenceContentProvider(String propertyPath) {
		EStructuralFeature feature = getFeature(propertyPath);

		Package root = null;
		if(source != null) {
			Element umlElement = UMLUtil.getBaseElement(source);
			if(umlElement != null) {
				if(umlElement.getNearestPackage() != null) {
					root = PackageUtil.getRootPackage(umlElement);
				}
			}
		}

		ServiceEditFilteredUMLContentProvider contentProvider = new ServiceEditFilteredUMLContentProvider(source, feature, root);
		contentProvider.setMetaClassWanted(feature.getEType());
		contentProvider.setMetaClassNotWanted(Collections.EMPTY_LIST);

		return contentProvider;
	}
}
