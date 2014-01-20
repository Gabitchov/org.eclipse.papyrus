/**
 * Copyright (c) 2013 CEA LIST.
 * 
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.infra.extendedtypes.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.papyrus.infra.extendedtypes.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.infra.extendedtypes.ExtendedtypesPackage
 * @generated
 */
public class ExtendedtypesAdapterFactory extends AdapterFactoryImpl {

	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static ExtendedtypesPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ExtendedtypesAdapterFactory() {
		if(modelPackage == null) {
			modelPackage = ExtendedtypesPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
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

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ExtendedtypesSwitch<Adapter> modelSwitch = new ExtendedtypesSwitch<Adapter>() {

		@Override
		public Adapter caseExtendedElementTypeSet(ExtendedElementTypeSet object) {
			return createExtendedElementTypeSetAdapter();
		}

		@Override
		public Adapter caseElementTypeConfiguration(ElementTypeConfiguration object) {
			return createElementTypeConfigurationAdapter();
		}

		@Override
		public Adapter caseIconEntry(IconEntry object) {
			return createIconEntryAdapter();
		}

		@Override
		public Adapter caseConfigurationElement(ConfigurationElement object) {
			return createConfigurationElementAdapter();
		}

		@Override
		public Adapter caseViewTypeAdviceConfiguration(ViewTypeAdviceConfiguration object) {
			return createViewTypeAdviceConfigurationAdapter();
		}

		@Override
		public Adapter caseSemanticTypeAdviceConfiguration(SemanticTypeAdviceConfiguration object) {
			return createSemanticTypeAdviceConfigurationAdapter();
		}

		@Override
		public Adapter caseMatcherConfiguration(MatcherConfiguration object) {
			return createMatcherConfigurationAdapter();
		}

		@Override
		public Adapter caseActionConfiguration(ActionConfiguration object) {
			return createActionConfigurationAdapter();
		}

		@Override
		public Adapter caseViewActionConfiguration(ViewActionConfiguration object) {
			return createViewActionConfigurationAdapter();
		}

		@Override
		public Adapter caseSemanticActionConfiguration(SemanticActionConfiguration object) {
			return createSemanticActionConfigurationAdapter();
		}

		@Override
		public Adapter caseSemanticTypeConfiguration(SemanticTypeConfiguration object) {
			return createSemanticTypeConfigurationAdapter();
		}

		@Override
		public Adapter caseViewTypeConfiguration(ViewTypeConfiguration object) {
			return createViewTypeConfigurationAdapter();
		}

		@Override
		public Adapter caseElementTypeAdviceConfiguration(ElementTypeAdviceConfiguration object) {
			return createElementTypeAdviceConfigurationAdapter();
		}

		@Override
		public Adapter caseAspectSemanticTypeConfiguration(AspectSemanticTypeConfiguration object) {
			return createAspectSemanticTypeConfigurationAdapter();
		}

		@Override
		public Adapter caseAspectSemanticTypeAdviceConfiguration(AspectSemanticTypeAdviceConfiguration object) {
			return createAspectSemanticTypeAdviceConfigurationAdapter();
		}

		@Override
		public Adapter caseAspectViewTypeConfiguration(AspectViewTypeConfiguration object) {
			return createAspectViewTypeConfigurationAdapter();
		}

		@Override
		public Adapter caseAspectViewTypeAdviceConfiguration(AspectViewTypeAdviceConfiguration object) {
			return createAspectViewTypeAdviceConfigurationAdapter();
		}

		@Override
		public Adapter defaultCase(EObject object) {
			return createEObjectAdapter();
		}
	};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.extendedtypes.ExtendedElementTypeSet
	 * <em>Extended Element Type Set</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.extendedtypes.ExtendedElementTypeSet
	 * @generated
	 */
	public Adapter createExtendedElementTypeSetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.extendedtypes.ElementTypeConfiguration
	 * <em>Element Type Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.extendedtypes.ElementTypeConfiguration
	 * @generated
	 */
	public Adapter createElementTypeConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.extendedtypes.IconEntry <em>Icon Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.extendedtypes.IconEntry
	 * @generated
	 */
	public Adapter createIconEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.extendedtypes.ConfigurationElement
	 * <em>Configuration Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.extendedtypes.ConfigurationElement
	 * @generated
	 */
	public Adapter createConfigurationElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.extendedtypes.ViewTypeAdviceConfiguration
	 * <em>View Type Advice Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.extendedtypes.ViewTypeAdviceConfiguration
	 * @generated
	 */
	public Adapter createViewTypeAdviceConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.extendedtypes.SemanticTypeAdviceConfiguration
	 * <em>Semantic Type Advice Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.extendedtypes.SemanticTypeAdviceConfiguration
	 * @generated
	 */
	public Adapter createSemanticTypeAdviceConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.extendedtypes.MatcherConfiguration
	 * <em>Matcher Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.extendedtypes.MatcherConfiguration
	 * @generated
	 */
	public Adapter createMatcherConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.extendedtypes.ActionConfiguration <em>Action Configuration</em>}
	 * '.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.extendedtypes.ActionConfiguration
	 * @generated
	 */
	public Adapter createActionConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.extendedtypes.ViewActionConfiguration
	 * <em>View Action Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.extendedtypes.ViewActionConfiguration
	 * @generated
	 */
	public Adapter createViewActionConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.extendedtypes.SemanticActionConfiguration
	 * <em>Semantic Action Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.extendedtypes.SemanticActionConfiguration
	 * @generated
	 */
	public Adapter createSemanticActionConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.extendedtypes.SemanticTypeConfiguration
	 * <em>Semantic Type Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.extendedtypes.SemanticTypeConfiguration
	 * @generated
	 */
	public Adapter createSemanticTypeConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.extendedtypes.ViewTypeConfiguration
	 * <em>View Type Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.extendedtypes.ViewTypeConfiguration
	 * @generated
	 */
	public Adapter createViewTypeConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.extendedtypes.ElementTypeAdviceConfiguration
	 * <em>Element Type Advice Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.extendedtypes.ElementTypeAdviceConfiguration
	 * @generated
	 */
	public Adapter createElementTypeAdviceConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.extendedtypes.AspectSemanticTypeConfiguration
	 * <em>Aspect Semantic Type Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.extendedtypes.AspectSemanticTypeConfiguration
	 * @generated
	 */
	public Adapter createAspectSemanticTypeConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.extendedtypes.AspectSemanticTypeAdviceConfiguration
	 * <em>Aspect Semantic Type Advice Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.extendedtypes.AspectSemanticTypeAdviceConfiguration
	 * @generated
	 */
	public Adapter createAspectSemanticTypeAdviceConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.extendedtypes.AspectViewTypeConfiguration
	 * <em>Aspect View Type Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.extendedtypes.AspectViewTypeConfiguration
	 * @generated
	 */
	public Adapter createAspectViewTypeConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.extendedtypes.AspectViewTypeAdviceConfiguration
	 * <em>Aspect View Type Advice Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.extendedtypes.AspectViewTypeAdviceConfiguration
	 * @generated
	 */
	public Adapter createAspectViewTypeAdviceConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}
} //ExtendedtypesAdapterFactory
