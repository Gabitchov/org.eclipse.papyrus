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

import static org.eclipse.uml2.uml.ParameterDirectionKind.INOUT_LITERAL;
import static org.eclipse.uml2.uml.ParameterDirectionKind.IN_LITERAL;
import static org.eclipse.uml2.uml.ParameterDirectionKind.OUT_LITERAL;
import static org.eclipse.uml2.uml.ParameterDirectionKind.RETURN_LITERAL;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

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
import org.eclipse.papyrus.properties.uml.creation.MessageValueSpecificationFactory;
import org.eclipse.papyrus.properties.uml.databinding.PapyrusObservableList;
import org.eclipse.papyrus.properties.uml.databinding.PapyrusObservableValue;
import org.eclipse.papyrus.properties.uml.databinding.SignatureObservableValue;
import org.eclipse.papyrus.properties.uml.providers.InstanceValueContentProvider;
import org.eclipse.papyrus.properties.uml.providers.SignatureContentProvider;
import org.eclipse.papyrus.properties.uml.providers.UMLLabelProvider;
import org.eclipse.papyrus.uml.modelexplorer.widgets.ServiceEditFilteredUMLContentProvider;
import org.eclipse.papyrus.umlutils.PackageUtil;
import org.eclipse.papyrus.widgets.creation.ReferenceValueFactory;
import org.eclipse.papyrus.widgets.providers.IStaticContentProvider;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * A ModelElement representing a UML Element
 * 
 * @author Camille Letavernier
 * 
 */
public class UMLModelElement extends EMFModelElement {

	/**
	 * 
	 * Constructor.
	 * 
	 * @param source
	 *        The EObject represented by this ModelElement
	 */
	public UMLModelElement(EObject source) {
		super(source);
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param source
	 *        The EObject represented by this ModelElement
	 * @param domain
	 *        The EditingDomain on which the commands will be executed
	 */
	public UMLModelElement(EObject source, EditingDomain domain) {
		super(source, domain);
	}

	@Override
	public IObservable doGetObservable(String propertyPath) {
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

			ServiceEditFilteredUMLContentProvider contentProvider;

			if(feature == UMLPackage.eINSTANCE.getInstanceValue_Instance()) {
				contentProvider = new InstanceValueContentProvider((InstanceValue)source, feature, root);
			} else {
				contentProvider = new ServiceEditFilteredUMLContentProvider(source, feature, root);
			}

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

	@Override
	public ReferenceValueFactory getValueFactory(String propertyPath) {
		EStructuralFeature feature = getFeature(propertyPath);
		if(feature == UMLPackage.eINSTANCE.getMessage_Argument()) {
			if(source instanceof Message) {
				Set<ParameterDirectionKind> directions = new HashSet<ParameterDirectionKind>();
				switch(((Message)source).getMessageSort()) {
				case REPLY_LITERAL:
					directions.add(OUT_LITERAL);
					directions.add(INOUT_LITERAL);
					directions.add(RETURN_LITERAL);
					return new MessageValueSpecificationFactory(((EReference)feature).getEReferenceType(), (Message)source, directions);
				case SYNCH_CALL_LITERAL:
				case ASYNCH_CALL_LITERAL:
				case ASYNCH_SIGNAL_LITERAL:
					directions.add(IN_LITERAL);
					directions.add(INOUT_LITERAL);
					return new MessageValueSpecificationFactory(((EReference)feature).getEReferenceType(), (Message)source, directions);
				}
			}
		}

		return super.getValueFactory(propertyPath);
	}

}
