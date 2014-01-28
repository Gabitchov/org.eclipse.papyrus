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
package org.eclipse.papyrus.uml.tools.extendedtypes.stereotypedelementmatcherconfiguration.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.papyrus.infra.extendedtypes.ExtendedtypesPackage;

import org.eclipse.papyrus.uml.tools.extendedtypes.stereotypedelementmatcherconfiguration.StereotypedElementMatcherConfiguration;
import org.eclipse.papyrus.uml.tools.extendedtypes.stereotypedelementmatcherconfiguration.StereotypedElementMatcherConfigurationFactory;
import org.eclipse.papyrus.uml.tools.extendedtypes.stereotypedelementmatcherconfiguration.StereotypedElementMatcherConfigurationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class StereotypedElementMatcherConfigurationPackageImpl extends EPackageImpl implements StereotypedElementMatcherConfigurationPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stereotypedElementMatcherConfigurationEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.papyrus.uml.tools.extendedtypes.stereotypedelementmatcherconfiguration.StereotypedElementMatcherConfigurationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private StereotypedElementMatcherConfigurationPackageImpl() {
		super(eNS_URI, StereotypedElementMatcherConfigurationFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link StereotypedElementMatcherConfigurationPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static StereotypedElementMatcherConfigurationPackage init() {
		if (isInited) return (StereotypedElementMatcherConfigurationPackage)EPackage.Registry.INSTANCE.getEPackage(StereotypedElementMatcherConfigurationPackage.eNS_URI);

		// Obtain or create and register package
		StereotypedElementMatcherConfigurationPackageImpl theStereotypedElementMatcherConfigurationPackage = (StereotypedElementMatcherConfigurationPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof StereotypedElementMatcherConfigurationPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new StereotypedElementMatcherConfigurationPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ExtendedtypesPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theStereotypedElementMatcherConfigurationPackage.createPackageContents();

		// Initialize created meta-data
		theStereotypedElementMatcherConfigurationPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theStereotypedElementMatcherConfigurationPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(StereotypedElementMatcherConfigurationPackage.eNS_URI, theStereotypedElementMatcherConfigurationPackage);
		return theStereotypedElementMatcherConfigurationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStereotypedElementMatcherConfiguration() {
		return stereotypedElementMatcherConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStereotypedElementMatcherConfiguration_StereotypedQualifiedName() {
		return (EAttribute)stereotypedElementMatcherConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StereotypedElementMatcherConfigurationFactory getStereotypedElementMatcherConfigurationFactory() {
		return (StereotypedElementMatcherConfigurationFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		stereotypedElementMatcherConfigurationEClass = createEClass(STEREOTYPED_ELEMENT_MATCHER_CONFIGURATION);
		createEAttribute(stereotypedElementMatcherConfigurationEClass, STEREOTYPED_ELEMENT_MATCHER_CONFIGURATION__STEREOTYPED_QUALIFIED_NAME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		ExtendedtypesPackage theExtendedtypesPackage = (ExtendedtypesPackage)EPackage.Registry.INSTANCE.getEPackage(ExtendedtypesPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		stereotypedElementMatcherConfigurationEClass.getESuperTypes().add(theExtendedtypesPackage.getMatcherConfiguration());

		// Initialize classes, features, and operations; add parameters
		initEClass(stereotypedElementMatcherConfigurationEClass, StereotypedElementMatcherConfiguration.class, "StereotypedElementMatcherConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStereotypedElementMatcherConfiguration_StereotypedQualifiedName(), theEcorePackage.getEString(), "stereotypedQualifiedName", null, 0, 1, StereotypedElementMatcherConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //StereotypedElementMatcherConfigurationPackageImpl
