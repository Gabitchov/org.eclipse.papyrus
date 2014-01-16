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
package org.eclipse.papyrus.infra.extendedtypes.aspectsemantictypeconfiguration.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.papyrus.infra.extendedtypes.ExtendedtypesPackage;

import org.eclipse.papyrus.infra.extendedtypes.aspectsemantictypeconfiguration.AspectSemanticTypeAdviceConfiguration;
import org.eclipse.papyrus.infra.extendedtypes.aspectsemantictypeconfiguration.AspectSemanticTypeConfiguration;
import org.eclipse.papyrus.infra.extendedtypes.aspectsemantictypeconfiguration.AspectSemanticTypeConfigurationFactory;
import org.eclipse.papyrus.infra.extendedtypes.aspectsemantictypeconfiguration.AspectSemanticTypeConfigurationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class AspectSemanticTypeConfigurationPackageImpl extends EPackageImpl implements AspectSemanticTypeConfigurationPackage {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass aspectSemanticTypeConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass aspectSemanticTypeAdviceConfigurationEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the
	 * package
	 * package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also performs initialization of the
	 * package, or returns the registered package, if one already exists. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.papyrus.infra.extendedtypes.aspectsemantictypeconfiguration.AspectSemanticTypeConfigurationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private AspectSemanticTypeConfigurationPackageImpl() {
		super(eNS_URI, AspectSemanticTypeConfigurationFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>
	 * This method is used to initialize {@link AspectSemanticTypeConfigurationPackage#eINSTANCE} when that field is accessed. Clients should not
	 * invoke it directly. Instead, they should simply access that field to obtain the package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static AspectSemanticTypeConfigurationPackage init() {
		if(isInited)
			return (AspectSemanticTypeConfigurationPackage)EPackage.Registry.INSTANCE.getEPackage(AspectSemanticTypeConfigurationPackage.eNS_URI);
		// Obtain or create and register package
		AspectSemanticTypeConfigurationPackageImpl theAspectSemanticTypeConfigurationPackage = (AspectSemanticTypeConfigurationPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof AspectSemanticTypeConfigurationPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new AspectSemanticTypeConfigurationPackageImpl());
		isInited = true;
		// Initialize simple dependencies
		ExtendedtypesPackage.eINSTANCE.eClass();
		// Create package meta-data objects
		theAspectSemanticTypeConfigurationPackage.createPackageContents();
		// Initialize created meta-data
		theAspectSemanticTypeConfigurationPackage.initializePackageContents();
		// Mark meta-data to indicate it can't be changed
		theAspectSemanticTypeConfigurationPackage.freeze();
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(AspectSemanticTypeConfigurationPackage.eNS_URI, theAspectSemanticTypeConfigurationPackage);
		return theAspectSemanticTypeConfigurationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getAspectSemanticTypeConfiguration() {
		return aspectSemanticTypeConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getAspectSemanticTypeConfiguration_AdviceConfiguration() {
		return (EReference)aspectSemanticTypeConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getAspectSemanticTypeAdviceConfiguration() {
		return aspectSemanticTypeAdviceConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getAspectSemanticTypeAdviceConfiguration_PreActionConfiguration() {
		return (EReference)aspectSemanticTypeAdviceConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getAspectSemanticTypeAdviceConfiguration_PostActionConfiguration() {
		return (EReference)aspectSemanticTypeAdviceConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public AspectSemanticTypeConfigurationFactory getAspectSemanticTypeConfigurationFactory() {
		return (AspectSemanticTypeConfigurationFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package. This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void createPackageContents() {
		if(isCreated)
			return;
		isCreated = true;
		// Create classes and their features
		aspectSemanticTypeConfigurationEClass = createEClass(ASPECT_SEMANTIC_TYPE_CONFIGURATION);
		createEReference(aspectSemanticTypeConfigurationEClass, ASPECT_SEMANTIC_TYPE_CONFIGURATION__ADVICE_CONFIGURATION);
		aspectSemanticTypeAdviceConfigurationEClass = createEClass(ASPECT_SEMANTIC_TYPE_ADVICE_CONFIGURATION);
		createEReference(aspectSemanticTypeAdviceConfigurationEClass, ASPECT_SEMANTIC_TYPE_ADVICE_CONFIGURATION__PRE_ACTION_CONFIGURATION);
		createEReference(aspectSemanticTypeAdviceConfigurationEClass, ASPECT_SEMANTIC_TYPE_ADVICE_CONFIGURATION__POST_ACTION_CONFIGURATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model. This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void initializePackageContents() {
		if(isInitialized)
			return;
		isInitialized = true;
		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);
		// Obtain other dependent packages
		ExtendedtypesPackage theExtendedtypesPackage = (ExtendedtypesPackage)EPackage.Registry.INSTANCE.getEPackage(ExtendedtypesPackage.eNS_URI);
		// Create type parameters
		// Set bounds for type parameters
		// Add supertypes to classes
		aspectSemanticTypeConfigurationEClass.getESuperTypes().add(theExtendedtypesPackage.getSemanticTypeConfiguration());
		aspectSemanticTypeAdviceConfigurationEClass.getESuperTypes().add(theExtendedtypesPackage.getSemanticTypeAdviceConfiguration());
		// Initialize classes, features, and operations; add parameters
		initEClass(aspectSemanticTypeConfigurationEClass, AspectSemanticTypeConfiguration.class, "AspectSemanticTypeConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAspectSemanticTypeConfiguration_AdviceConfiguration(), this.getAspectSemanticTypeAdviceConfiguration(), null, "adviceConfiguration", null, 1, 1, AspectSemanticTypeConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEClass(aspectSemanticTypeAdviceConfigurationEClass, AspectSemanticTypeAdviceConfiguration.class, "AspectSemanticTypeAdviceConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAspectSemanticTypeAdviceConfiguration_PreActionConfiguration(), theExtendedtypesPackage.getSemanticActionConfiguration(), null, "preActionConfiguration", null, 0, -1, AspectSemanticTypeAdviceConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAspectSemanticTypeAdviceConfiguration_PostActionConfiguration(), theExtendedtypesPackage.getSemanticActionConfiguration(), null, "postActionConfiguration", null, 0, -1, AspectSemanticTypeAdviceConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		// Create resource
		createResource(eNS_URI);
	}
} //AspectSemanticTypeConfigurationPackageImpl
