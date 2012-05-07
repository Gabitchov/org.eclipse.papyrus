/**
 *  Copyright (c) 2012 CEA LIST.
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *  Vincent Lorenzo (CEA-LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 * 
 * 
 */
package org.eclipse.papyrus.infra.emf.compare.instance.papyrusemfcompareinstance.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.papyrus.infra.emf.compare.instance.papyrusemfcompareinstance.PapyrusEMFCompareInstance;
import org.eclipse.papyrus.infra.emf.compare.instance.papyrusemfcompareinstance.PapyrusemfcompareinstanceFactory;
import org.eclipse.papyrus.infra.emf.compare.instance.papyrusemfcompareinstance.PapyrusemfcompareinstancePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PapyrusemfcompareinstancePackageImpl extends EPackageImpl implements PapyrusemfcompareinstancePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass papyrusEMFCompareInstanceEClass = null;

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
	 * @see org.eclipse.papyrus.infra.emf.compare.instance.papyrusemfcompareinstance.PapyrusemfcompareinstancePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private PapyrusemfcompareinstancePackageImpl() {
		super(eNS_URI, PapyrusemfcompareinstanceFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link PapyrusemfcompareinstancePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static PapyrusemfcompareinstancePackage init() {
		if (isInited) return (PapyrusemfcompareinstancePackage)EPackage.Registry.INSTANCE.getEPackage(PapyrusemfcompareinstancePackage.eNS_URI);

		// Obtain or create and register package
		PapyrusemfcompareinstancePackageImpl thePapyrusemfcompareinstancePackage = (PapyrusemfcompareinstancePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof PapyrusemfcompareinstancePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new PapyrusemfcompareinstancePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		thePapyrusemfcompareinstancePackage.createPackageContents();

		// Initialize created meta-data
		thePapyrusemfcompareinstancePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thePapyrusemfcompareinstancePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(PapyrusemfcompareinstancePackage.eNS_URI, thePapyrusemfcompareinstancePackage);
		return thePapyrusemfcompareinstancePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPapyrusEMFCompareInstance() {
		return papyrusEMFCompareInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPapyrusEMFCompareInstance_Left() {
		return (EReference)papyrusEMFCompareInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPapyrusEMFCompareInstance_Right() {
		return (EReference)papyrusEMFCompareInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPapyrusEMFCompareInstance_Type() {
		return (EAttribute)papyrusEMFCompareInstanceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPapyrusEMFCompareInstance_Name() {
		return (EAttribute)papyrusEMFCompareInstanceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PapyrusemfcompareinstanceFactory getPapyrusemfcompareinstanceFactory() {
		return (PapyrusemfcompareinstanceFactory)getEFactoryInstance();
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
		papyrusEMFCompareInstanceEClass = createEClass(PAPYRUS_EMF_COMPARE_INSTANCE);
		createEReference(papyrusEMFCompareInstanceEClass, PAPYRUS_EMF_COMPARE_INSTANCE__LEFT);
		createEReference(papyrusEMFCompareInstanceEClass, PAPYRUS_EMF_COMPARE_INSTANCE__RIGHT);
		createEAttribute(papyrusEMFCompareInstanceEClass, PAPYRUS_EMF_COMPARE_INSTANCE__TYPE);
		createEAttribute(papyrusEMFCompareInstanceEClass, PAPYRUS_EMF_COMPARE_INSTANCE__NAME);
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
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		papyrusEMFCompareInstanceEClass.getESuperTypes().add(theEcorePackage.getEModelElement());

		// Initialize classes and features; add operations and parameters
		initEClass(papyrusEMFCompareInstanceEClass, PapyrusEMFCompareInstance.class, "PapyrusEMFCompareInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPapyrusEMFCompareInstance_Left(), theEcorePackage.getEObject(), null, "left", null, 0, 1, PapyrusEMFCompareInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPapyrusEMFCompareInstance_Right(), theEcorePackage.getEObject(), null, "right", null, 0, 1, PapyrusEMFCompareInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPapyrusEMFCompareInstance_Type(), ecorePackage.getEString(), "type", null, 0, 1, PapyrusEMFCompareInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPapyrusEMFCompareInstance_Name(), ecorePackage.getEString(), "name", null, 0, 1, PapyrusEMFCompareInstance.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //PapyrusemfcompareinstancePackageImpl
