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
package org.eclipse.papyrus.uml.tools.extendedtypes.invariantstereotypeconfiguration.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.InvariantSemanticTypeConfigurationPackage;
import org.eclipse.papyrus.uml.tools.extendedtypes.invariantstereotypeconfiguration.InvariantStereotypeConfiguration;
import org.eclipse.papyrus.uml.tools.extendedtypes.invariantstereotypeconfiguration.InvariantStereotypeConfigurationFactory;
import org.eclipse.papyrus.uml.tools.extendedtypes.invariantstereotypeconfiguration.InvariantStereotypeConfigurationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class InvariantStereotypeConfigurationPackageImpl extends EPackageImpl implements InvariantStereotypeConfigurationPackage {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass invariantStereotypeConfigurationEClass = null;

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
	 * @see org.eclipse.papyrus.uml.tools.extendedtypes.invariantstereotypeconfiguration.InvariantStereotypeConfigurationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private InvariantStereotypeConfigurationPackageImpl() {
		super(eNS_URI, InvariantStereotypeConfigurationFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link InvariantStereotypeConfigurationPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static InvariantStereotypeConfigurationPackage init() {
		if(isInited)
			return (InvariantStereotypeConfigurationPackage)EPackage.Registry.INSTANCE.getEPackage(InvariantStereotypeConfigurationPackage.eNS_URI);
		// Obtain or create and register package
		InvariantStereotypeConfigurationPackageImpl theInvariantStereotypeConfigurationPackage = (InvariantStereotypeConfigurationPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof InvariantStereotypeConfigurationPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new InvariantStereotypeConfigurationPackageImpl());
		isInited = true;
		// Initialize simple dependencies
		InvariantSemanticTypeConfigurationPackage.eINSTANCE.eClass();
		// Create package meta-data objects
		theInvariantStereotypeConfigurationPackage.createPackageContents();
		// Initialize created meta-data
		theInvariantStereotypeConfigurationPackage.initializePackageContents();
		// Mark meta-data to indicate it can't be changed
		theInvariantStereotypeConfigurationPackage.freeze();
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(InvariantStereotypeConfigurationPackage.eNS_URI, theInvariantStereotypeConfigurationPackage);
		return theInvariantStereotypeConfigurationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInvariantStereotypeConfiguration() {
		return invariantStereotypeConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInvariantStereotypeConfiguration_StereotypeQualifiedName() {
		return (EAttribute)invariantStereotypeConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInvariantStereotypeConfiguration_RequiredProfile() {
		return (EAttribute)invariantStereotypeConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InvariantStereotypeConfigurationFactory getInvariantStereotypeConfigurationFactory() {
		return (InvariantStereotypeConfigurationFactory)getEFactoryInstance();
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
		if(isCreated)
			return;
		isCreated = true;
		// Create classes and their features
		invariantStereotypeConfigurationEClass = createEClass(INVARIANT_STEREOTYPE_CONFIGURATION);
		createEAttribute(invariantStereotypeConfigurationEClass, INVARIANT_STEREOTYPE_CONFIGURATION__STEREOTYPE_QUALIFIED_NAME);
		createEAttribute(invariantStereotypeConfigurationEClass, INVARIANT_STEREOTYPE_CONFIGURATION__REQUIRED_PROFILE);
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
		if(isInitialized)
			return;
		isInitialized = true;
		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);
		// Obtain other dependent packages
		InvariantSemanticTypeConfigurationPackage theInvariantSemanticTypeConfigurationPackage = (InvariantSemanticTypeConfigurationPackage)EPackage.Registry.INSTANCE.getEPackage(InvariantSemanticTypeConfigurationPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
		// Create type parameters
		// Set bounds for type parameters
		// Add supertypes to classes
		invariantStereotypeConfigurationEClass.getESuperTypes().add(theInvariantSemanticTypeConfigurationPackage.getInvariantRuleConfiguration());
		// Initialize classes, features, and operations; add parameters
		initEClass(invariantStereotypeConfigurationEClass, InvariantStereotypeConfiguration.class, "InvariantStereotypeConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInvariantStereotypeConfiguration_StereotypeQualifiedName(), theEcorePackage.getEString(), "stereotypeQualifiedName", null, 1, 1, InvariantStereotypeConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInvariantStereotypeConfiguration_RequiredProfile(), theEcorePackage.getEString(), "requiredProfile", null, 0, 1, InvariantStereotypeConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		// Create resource
		createResource(eNS_URI);
	}
} //InvariantStereotypeConfigurationPackageImpl
