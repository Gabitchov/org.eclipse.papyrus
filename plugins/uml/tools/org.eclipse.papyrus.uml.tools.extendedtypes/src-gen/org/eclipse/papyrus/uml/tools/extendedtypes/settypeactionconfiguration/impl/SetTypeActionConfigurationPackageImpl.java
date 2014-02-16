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
package org.eclipse.papyrus.uml.tools.extendedtypes.settypeactionconfiguration.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.papyrus.infra.extendedtypes.ExtendedtypesPackage;

import org.eclipse.papyrus.uml.tools.extendedtypes.settypeactionconfiguration.SetTypeActionConfiguration;
import org.eclipse.papyrus.uml.tools.extendedtypes.settypeactionconfiguration.SetTypeActionConfigurationFactory;
import org.eclipse.papyrus.uml.tools.extendedtypes.settypeactionconfiguration.SetTypeActionConfigurationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SetTypeActionConfigurationPackageImpl extends EPackageImpl implements SetTypeActionConfigurationPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass setTypeActionConfigurationEClass = null;

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
	 * @see org.eclipse.papyrus.uml.tools.extendedtypes.settypeactionconfiguration.SetTypeActionConfigurationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SetTypeActionConfigurationPackageImpl() {
		super(eNS_URI, SetTypeActionConfigurationFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link SetTypeActionConfigurationPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SetTypeActionConfigurationPackage init() {
		if (isInited) return (SetTypeActionConfigurationPackage)EPackage.Registry.INSTANCE.getEPackage(SetTypeActionConfigurationPackage.eNS_URI);

		// Obtain or create and register package
		SetTypeActionConfigurationPackageImpl theSetTypeActionConfigurationPackage = (SetTypeActionConfigurationPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SetTypeActionConfigurationPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SetTypeActionConfigurationPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ExtendedtypesPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theSetTypeActionConfigurationPackage.createPackageContents();

		// Initialize created meta-data
		theSetTypeActionConfigurationPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSetTypeActionConfigurationPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SetTypeActionConfigurationPackage.eNS_URI, theSetTypeActionConfigurationPackage);
		return theSetTypeActionConfigurationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSetTypeActionConfiguration() {
		return setTypeActionConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSetTypeActionConfiguration_ValidTypes() {
		return (EAttribute)setTypeActionConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSetTypeActionConfiguration_CreationTypes() {
		return (EAttribute)setTypeActionConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SetTypeActionConfigurationFactory getSetTypeActionConfigurationFactory() {
		return (SetTypeActionConfigurationFactory)getEFactoryInstance();
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
		setTypeActionConfigurationEClass = createEClass(SET_TYPE_ACTION_CONFIGURATION);
		createEAttribute(setTypeActionConfigurationEClass, SET_TYPE_ACTION_CONFIGURATION__VALID_TYPES);
		createEAttribute(setTypeActionConfigurationEClass, SET_TYPE_ACTION_CONFIGURATION__CREATION_TYPES);
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
		setTypeActionConfigurationEClass.getESuperTypes().add(theExtendedtypesPackage.getSemanticActionConfiguration());

		// Initialize classes, features, and operations; add parameters
		initEClass(setTypeActionConfigurationEClass, SetTypeActionConfiguration.class, "SetTypeActionConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSetTypeActionConfiguration_ValidTypes(), theEcorePackage.getEString(), "validTypes", null, 0, -1, SetTypeActionConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSetTypeActionConfiguration_CreationTypes(), theEcorePackage.getEString(), "creationTypes", null, 0, -1, SetTypeActionConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //SetTypeActionConfigurationPackageImpl
