/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.uml.modelelement;

import java.util.Collections;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.properties.modelelement.EMFModelElement;
import org.eclipse.papyrus.properties.uml.databinding.PapyrusObservableList;
import org.eclipse.papyrus.properties.uml.databinding.PapyrusObservableValue;
import org.eclipse.papyrus.properties.uml.databinding.SignatureObservableValue;
import org.eclipse.papyrus.properties.uml.providers.SignatureContentProvider;
import org.eclipse.papyrus.properties.uml.providers.UMLLabelProvider;
import org.eclipse.papyrus.uml.modelexplorer.widgets.ServiceEditFilteredUMLContentProvider;
import org.eclipse.papyrus.umlutils.PackageUtil;
import org.eclipse.papyrus.widgets.providers.IStaticContentProvider;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLPackage;


public class UMLModelElement extends EMFModelElement {

	public UMLModelElement(EObject source) {
		super(source);
	}

	public UMLModelElement(EObject source, EditingDomain domain) {
		super(source, domain);
	}

	@Override
	public IObservable getObservable(String propertyPath) {
		FeaturePath featurePath = getFeaturePath(propertyPath);
		EStructuralFeature feature = getFeature(propertyPath);

		if(feature == UMLPackage.eINSTANCE.getMessage_Signature()) {
			return new SignatureObservableValue(source, domain);
		}

		if(feature == null) {
			return null;
		}

		if(feature.getUpperBound() != 1) {
			IObservableList list = domain == null ? EMFProperties.list(featurePath).observe(source) : new PapyrusObservableList(EMFProperties.list(featurePath).observe(source), domain, getSource(featurePath), feature);
			return list;
		}

		IObservableValue value = domain == null ? EMFProperties.value(featurePath).observe(source) : new PapyrusObservableValue(getSource(featurePath), feature, domain);
		return value;
	}

	@Override
	public boolean isEditable(String propertyPath) {
		EStructuralFeature feature = getFeature(propertyPath);
		if(feature == UMLPackage.eINSTANCE.getMessage_Signature()) {
			return true;
		}
		return super.isEditable(propertyPath);
	}

	@Override
	public IStaticContentProvider getContentProvider(String propertyPath) {
		EStructuralFeature feature = getFeature(propertyPath);
		if(feature == UMLPackage.eINSTANCE.getMessage_Signature() || feature == UMLPackage.eINSTANCE.getSendOperationEvent_Operation() || feature == UMLPackage.eINSTANCE.getReceiveOperationEvent_Operation()) {
			return new SignatureContentProvider(source);
		}

		if(feature instanceof EReference) {
			Package root = null;
			if(((Element)source).getNearestPackage() != null) {
				root = PackageUtil.getRootPackage((Element)source);
			}

			ServiceEditFilteredUMLContentProvider contentProvider = new ServiceEditFilteredUMLContentProvider(source, feature, root);
			//		contentProvider = new UMLElementMEBContentProvider(root);
			contentProvider.setMetaClassWanted(feature.getEType());
			contentProvider.setMetaClassNotWanted(Collections.EMPTY_LIST);

			return contentProvider;
		}

		return super.getContentProvider(propertyPath);
	}

	@Override
	public ILabelProvider getLabelProvider(String propertyPath) {
		EStructuralFeature feature = getFeature(propertyPath);
		if(feature.getEType() instanceof EEnum) {
			return super.getLabelProvider(propertyPath);
		}
		return new UMLLabelProvider();
	}

	@Override
	public boolean isOrdered(String propertyPath) {
		EStructuralFeature feature = getFeature(propertyPath);
		if(feature == UMLPackage.eINSTANCE.getStereotype_Icon()) {
			return true;
		}
		return super.isOrdered(propertyPath);
	}

}
