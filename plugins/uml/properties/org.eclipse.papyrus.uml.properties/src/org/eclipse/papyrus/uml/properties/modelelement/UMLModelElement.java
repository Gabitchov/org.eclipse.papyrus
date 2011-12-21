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
package org.eclipse.papyrus.uml.properties.modelelement;

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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.infra.emf.providers.EMFLabelProvider;
import org.eclipse.papyrus.infra.widgets.creation.ReferenceValueFactory;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;
import org.eclipse.papyrus.uml.properties.creation.ConnectorTypeEditorFactory;
import org.eclipse.papyrus.uml.properties.creation.MessageValueSpecificationFactory;
import org.eclipse.papyrus.uml.properties.creation.OwnedRuleCreationFactory;
import org.eclipse.papyrus.uml.properties.creation.UMLPropertyEditorFactory;
import org.eclipse.papyrus.uml.properties.providers.InstanceValueContentProvider;
import org.eclipse.papyrus.uml.properties.providers.UMLFilteredLabelProvider;
import org.eclipse.papyrus.uml.tools.databinding.ExtensionRequiredObservableValue;
import org.eclipse.papyrus.uml.tools.databinding.PapyrusObservableList;
import org.eclipse.papyrus.uml.tools.databinding.PapyrusObservableValue;
import org.eclipse.papyrus.uml.tools.databinding.ProvidedInterfaceObservableList;
import org.eclipse.papyrus.uml.tools.databinding.RequiredInterfaceObservableList;
import org.eclipse.papyrus.uml.tools.helper.HistoryUtil;
import org.eclipse.papyrus.uml.tools.providers.ServiceEditFilteredUMLContentProvider;
import org.eclipse.papyrus.uml.tools.providers.internal.UMLElementMEBContentProvider;
import org.eclipse.papyrus.uml.tools.utils.PackageUtil;
import org.eclipse.papyrus.views.properties.modelelement.EMFModelElement;
import org.eclipse.papyrus.views.properties.providers.ContainerContentProvider;
import org.eclipse.papyrus.views.properties.providers.FeatureContentProvider;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Extension;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.Port;
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

		if(feature == UMLPackage.eINSTANCE.getExtension_IsRequired()) {
			return new ExtensionRequiredObservableValue((Extension)source, domain);
		}

		if(feature == UMLPackage.eINSTANCE.getPort_Provided()) {
			//TODO : Currently, this is read-only
			//See #isEditable(String)
			return new ProvidedInterfaceObservableList((Port)source, domain);
		}

		if(feature == UMLPackage.eINSTANCE.getPort_Required()) {
			//TODO : Currently, this is read-only
			//See #isEditable(String)
			return new RequiredInterfaceObservableList((Port)source, domain);
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
		if(feature == UMLPackage.eINSTANCE.getExtension_IsRequired()) {
			return true;
		}
		if(feature == UMLPackage.eINSTANCE.getPort_Provided()) {
			return false;
			//return true; //TODO : Unsupported yet
		}
		if(feature == UMLPackage.eINSTANCE.getPort_Required()) {
			return false;
			//return true; //TODO : Unsupported yet
		}
		return super.isEditable(propertyPath);
	}

	@Override
	public IStaticContentProvider getContentProvider(String propertyPath) {
		EStructuralFeature feature = getFeature(propertyPath);

		if(feature == UMLPackage.eINSTANCE.getPort_Provided() || feature == UMLPackage.eINSTANCE.getPort_Required()) {
			Package root = null;
			if(((Element)source).getNearestPackage() != null) {
				root = PackageUtil.getRootPackage((Element)source);
			}

			String historyId = HistoryUtil.getHistoryID(source, feature, root);
			UMLElementMEBContentProvider contentProvider = new UMLElementMEBContentProvider(root, historyId);
			contentProvider.setMetaClassWanted(feature.getEType());
			return contentProvider;
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
		if(feature != null && feature.getEType() instanceof EEnum) {
			return super.getLabelProvider(propertyPath);
		}
		return new UMLFilteredLabelProvider();
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
		if(!(feature instanceof EReference)) {
			return null;
		}
		EReference reference = (EReference)feature;
		if(reference == UMLPackage.eINSTANCE.getMessage_Argument()) {
			if(source instanceof Message) {
				Set<ParameterDirectionKind> directions = new HashSet<ParameterDirectionKind>();
				switch(((Message)source).getMessageSort()) {
				case REPLY_LITERAL:
					directions.add(OUT_LITERAL);
					directions.add(INOUT_LITERAL);
					directions.add(RETURN_LITERAL);
					return new MessageValueSpecificationFactory(reference, (Message)source, directions);
				case SYNCH_CALL_LITERAL:
				case ASYNCH_CALL_LITERAL:
				case ASYNCH_SIGNAL_LITERAL:
					directions.add(IN_LITERAL);
					directions.add(INOUT_LITERAL);
					return new MessageValueSpecificationFactory(reference, (Message)source, directions);
				}
			}
		}

		boolean isOwnedRuleSubset = ownedRuleSubsets.contains(reference);

		if(isOwnedRuleSubset) {
			return new OwnedRuleCreationFactory(reference);
		}

		UMLPropertyEditorFactory factory;

		if(reference == UMLPackage.eINSTANCE.getConnector_Type() && source instanceof Connector) {
			factory = new ConnectorTypeEditorFactory(reference);
		} else {
			factory = new UMLPropertyEditorFactory(reference);
		}

		EClass type = reference.getEReferenceType();

		factory.setContainerLabelProvider(new UMLFilteredLabelProvider());
		factory.setReferenceLabelProvider(new EMFLabelProvider());
		IStaticContentProvider contentProvider = new ContainerContentProvider(type);
		factory.setContainerContentProvider(contentProvider);
		factory.setReferenceContentProvider(new FeatureContentProvider(type));

		return factory;
	}

	/**
	 * The set of all EStructuralFeature representing subsets of {@link Namespace#getOwnedRules()}
	 */
	public final static Set<EStructuralFeature> ownedRuleSubsets = new HashSet<EStructuralFeature>();
	static {
		//Behavior
		ownedRuleSubsets.add(UMLPackage.eINSTANCE.getBehavior_Precondition());
		ownedRuleSubsets.add(UMLPackage.eINSTANCE.getBehavior_Postcondition());

		//Operation
		ownedRuleSubsets.add(UMLPackage.eINSTANCE.getOperation_BodyCondition());
		ownedRuleSubsets.add(UMLPackage.eINSTANCE.getOperation_Precondition());
		ownedRuleSubsets.add(UMLPackage.eINSTANCE.getOperation_Postcondition());

		//ProtocolTransition
		ownedRuleSubsets.add(UMLPackage.eINSTANCE.getProtocolTransition_PreCondition());
		ownedRuleSubsets.add(UMLPackage.eINSTANCE.getProtocolTransition_PostCondition());

		//Transition
		ownedRuleSubsets.add(UMLPackage.eINSTANCE.getTransition_Guard());
	}

}
