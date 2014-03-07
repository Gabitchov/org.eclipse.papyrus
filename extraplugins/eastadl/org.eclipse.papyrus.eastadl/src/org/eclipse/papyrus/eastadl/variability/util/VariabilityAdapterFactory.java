/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Sara TUCCI (CEA LIST) sara.tucci@cea.fr - Initial API and implementation
 *  Chokri MRAIDHA (CEA LIST) chokri.mraidha@cea.fr - Initial API and implementation
 *  David SERVAT (CEA LIST) david.servat@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.eastadl.variability.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.eastadl.infrastructure.elements.Context;
import org.eclipse.papyrus.eastadl.infrastructure.elements.EAElement;
import org.eclipse.papyrus.eastadl.infrastructure.elements.EAPackageableElement;
import org.eclipse.papyrus.eastadl.infrastructure.elements.TraceableSpecification;
import org.eclipse.papyrus.eastadl.variability.*;
import org.eclipse.papyrus.eastadl.variability.ConfigurableContainer;
import org.eclipse.papyrus.eastadl.variability.ConfigurationDecision;
import org.eclipse.papyrus.eastadl.variability.ConfigurationDecisionFolder;
import org.eclipse.papyrus.eastadl.variability.ConfigurationDecisionModel;
import org.eclipse.papyrus.eastadl.variability.ConfigurationDecisionModelEntry;
import org.eclipse.papyrus.eastadl.variability.ContainerConfiguration;
import org.eclipse.papyrus.eastadl.variability.FeatureConfiguration;
import org.eclipse.papyrus.eastadl.variability.InternalBinding;
import org.eclipse.papyrus.eastadl.variability.PrivateContent;
import org.eclipse.papyrus.eastadl.variability.ReuseMetaInformation;
import org.eclipse.papyrus.eastadl.variability.SelectionCriterion;
import org.eclipse.papyrus.eastadl.variability.Variability;
import org.eclipse.papyrus.eastadl.variability.VariabilityPackage;
import org.eclipse.papyrus.eastadl.variability.VariableElement;
import org.eclipse.papyrus.eastadl.variability.VariationGroup;
import org.eclipse.papyrus.eastadl.variability.VehicleLevelBinding;


/**
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.eastadl.variability.VariabilityPackage
 * @generated
 */
public class VariabilityAdapterFactory extends AdapterFactoryImpl {

	/**
	 * The cached model package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static VariabilityPackage modelPackage;

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected VariabilitySwitch<Adapter> modelSwitch = new VariabilitySwitch<Adapter>() {

		@Override
		public Adapter caseVariationGroup(VariationGroup object) {
			return createVariationGroupAdapter();
		}

		@Override
		public Adapter caseVariableElement(VariableElement object) {
			return createVariableElementAdapter();
		}

		@Override
		public Adapter caseReuseMetaInformation(ReuseMetaInformation object) {
			return createReuseMetaInformationAdapter();
		}

		@Override
		public Adapter caseConfigurableContainer(ConfigurableContainer object) {
			return createConfigurableContainerAdapter();
		}

		@Override
		public Adapter caseInternalBinding(InternalBinding object) {
			return createInternalBindingAdapter();
		}

		@Override
		public Adapter caseConfigurationDecisionModel(ConfigurationDecisionModel object) {
			return createConfigurationDecisionModelAdapter();
		}

		@Override
		public Adapter caseConfigurationDecisionModelEntry(ConfigurationDecisionModelEntry object) {
			return createConfigurationDecisionModelEntryAdapter();
		}

		@Override
		public Adapter caseVariability(Variability object) {
			return createVariabilityAdapter();
		}

		@Override
		public Adapter caseFeatureConfiguration(FeatureConfiguration object) {
			return createFeatureConfigurationAdapter();
		}

		@Override
		public Adapter caseVehicleLevelBinding(VehicleLevelBinding object) {
			return createVehicleLevelBindingAdapter();
		}

		@Override
		public Adapter caseConfigurationDecision(ConfigurationDecision object) {
			return createConfigurationDecisionAdapter();
		}

		@Override
		public Adapter caseSelectionCriterion(SelectionCriterion object) {
			return createSelectionCriterionAdapter();
		}

		@Override
		public Adapter caseConfigurationDecisionFolder(ConfigurationDecisionFolder object) {
			return createConfigurationDecisionFolderAdapter();
		}

		@Override
		public Adapter caseContainerConfiguration(ContainerConfiguration object) {
			return createContainerConfigurationAdapter();
		}

		@Override
		public Adapter casePrivateContent(PrivateContent object) {
			return createPrivateContentAdapter();
		}

		@Override
		public Adapter caseEAElement(EAElement object) {
			return createEAElementAdapter();
		}

		@Override
		public Adapter caseEAPackageableElement(EAPackageableElement object) {
			return createEAPackageableElementAdapter();
		}

		@Override
		public Adapter caseTraceableSpecification(TraceableSpecification object) {
			return createTraceableSpecificationAdapter();
		}

		@Override
		public Adapter caseContext(Context object) {
			return createContextAdapter();
		}

		@Override
		public Adapter defaultCase(EObject object) {
			return createEObjectAdapter();
		}
	};

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public VariabilityAdapterFactory() {
		if(modelPackage == null) {
			modelPackage = VariabilityPackage.eINSTANCE;
		}
	}

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param target
	 *        the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.eastadl.variability.ConfigurableContainer
	 * <em>Configurable Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.eastadl.variability.ConfigurableContainer
	 * @generated
	 */
	public Adapter createConfigurableContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.eastadl.variability.ConfigurationDecision
	 * <em>Configuration Decision</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.eastadl.variability.ConfigurationDecision
	 * @generated
	 */
	public Adapter createConfigurationDecisionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.eastadl.variability.ConfigurationDecisionFolder
	 * <em>Configuration Decision Folder</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.eastadl.variability.ConfigurationDecisionFolder
	 * @generated
	 */
	public Adapter createConfigurationDecisionFolderAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.eastadl.variability.ConfigurationDecisionModel
	 * <em>Configuration Decision Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.eastadl.variability.ConfigurationDecisionModel
	 * @generated
	 */
	public Adapter createConfigurationDecisionModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.eastadl.variability.ConfigurationDecisionModelEntry
	 * <em>Configuration Decision Model Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.eastadl.variability.ConfigurationDecisionModelEntry
	 * @generated
	 */
	public Adapter createConfigurationDecisionModelEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.eastadl.variability.ContainerConfiguration
	 * <em>Container Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.eastadl.variability.ContainerConfiguration
	 * @generated
	 */
	public Adapter createContainerConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.eastadl.infrastructure.elements.Context <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.Context
	 * @generated
	 */
	public Adapter createContextAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc --> This default
	 * implementation returns null. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.eastadl.variability.FeatureConfiguration
	 * <em>Feature Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.eastadl.variability.FeatureConfiguration
	 * @generated
	 */
	public Adapter createFeatureConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.eastadl.variability.VehicleLevelBinding
	 * <em>Vehicle Level Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.eastadl.variability.VehicleLevelBinding
	 * @generated
	 */
	public Adapter createVehicleLevelBindingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.eastadl.variability.InternalBinding <em>Internal Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.eastadl.variability.InternalBinding
	 * @generated
	 */
	public Adapter createInternalBindingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.eastadl.variability.PrivateContent <em>Private Content</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.eastadl.variability.PrivateContent
	 * @generated
	 */
	public Adapter createPrivateContentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.eastadl.infrastructure.elements.EAElement <em>EA Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.EAElement
	 * @generated
	 */
	public Adapter createEAElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.eastadl.infrastructure.elements.EAPackageableElement
	 * <em>EA Packageable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.EAPackageableElement
	 * @generated
	 */
	public Adapter createEAPackageableElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.eastadl.variability.ReuseMetaInformation
	 * <em>Reuse Meta Information</em>}'.
	 * <!-- begin-user-doc --> This default implementation
	 * returns null so that we can easily ignore cases; it's useful to ignore a case when
	 * inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.eastadl.variability.ReuseMetaInformation
	 * @generated
	 */
	public Adapter createReuseMetaInformationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.eastadl.variability.SelectionCriterion <em>Selection Criterion</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.eastadl.variability.SelectionCriterion
	 * @generated
	 */
	public Adapter createSelectionCriterionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.eastadl.infrastructure.elements.TraceableSpecification
	 * <em>Traceable Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.TraceableSpecification
	 * @generated
	 */
	public Adapter createTraceableSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.eastadl.variability.Variability <em>Variability</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.eastadl.variability.Variability
	 * @generated
	 */
	public Adapter createVariabilityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.eastadl.variability.VariableElement <em>Variable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.eastadl.variability.VariableElement
	 * @generated
	 */
	public Adapter createVariableElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.eastadl.variability.VariationGroup <em>Variation Group</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null
	 * so that we can easily ignore cases; it's useful to ignore a case when inheritance will catch
	 * all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.eastadl.variability.VariationGroup
	 * @generated
	 */
	public Adapter createVariationGroupAdapter() {
		return null;
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc
	 * --> This implementation returns <code>true</code> if the object is either the model's package
	 * or is an instance object of the model. <!-- end-user-doc -->
	 * 
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if(object == modelPackage) {
			return true;
		}
		if(object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

} // VariabilityAdapterFactory
