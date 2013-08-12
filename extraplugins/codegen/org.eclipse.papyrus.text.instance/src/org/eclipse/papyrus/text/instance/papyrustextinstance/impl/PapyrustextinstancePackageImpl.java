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
 */
package org.eclipse.papyrus.text.instance.papyrustextinstance.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.papyrus.text.instance.papyrustextinstance.PapyrusTextInstance;
import org.eclipse.papyrus.text.instance.papyrustextinstance.PapyrustextinstanceFactory;
import org.eclipse.papyrus.text.instance.papyrustextinstance.PapyrustextinstancePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PapyrustextinstancePackageImpl extends EPackageImpl implements PapyrustextinstancePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass papyrusTextInstanceEClass = null;

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
	 * @see org.eclipse.papyrus.text.instance.papyrustextinstance.PapyrustextinstancePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private PapyrustextinstancePackageImpl() {
		super(eNS_URI, PapyrustextinstanceFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link PapyrustextinstancePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static PapyrustextinstancePackage init() {
		if (isInited) return (PapyrustextinstancePackage)EPackage.Registry.INSTANCE.getEPackage(PapyrustextinstancePackage.eNS_URI);

		// Obtain or create and register package
		PapyrustextinstancePackageImpl thePapyrustextinstancePackage = (PapyrustextinstancePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof PapyrustextinstancePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new PapyrustextinstancePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		thePapyrustextinstancePackage.createPackageContents();

		// Initialize created meta-data
		thePapyrustextinstancePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thePapyrustextinstancePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(PapyrustextinstancePackage.eNS_URI, thePapyrustextinstancePackage);
		return thePapyrustextinstancePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPapyrusTextInstance() {
		return papyrusTextInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPapyrusTextInstance_EditedObject() {
		return (EReference)papyrusTextInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPapyrusTextInstance_Type() {
		return (EAttribute)papyrusTextInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPapyrusTextInstance_Name() {
		return (EAttribute)papyrusTextInstanceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PapyrustextinstanceFactory getPapyrustextinstanceFactory() {
		return (PapyrustextinstanceFactory)getEFactoryInstance();
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
		papyrusTextInstanceEClass = createEClass(PAPYRUS_TEXT_INSTANCE);
		createEReference(papyrusTextInstanceEClass, PAPYRUS_TEXT_INSTANCE__EDITED_OBJECT);
		createEAttribute(papyrusTextInstanceEClass, PAPYRUS_TEXT_INSTANCE__TYPE);
		createEAttribute(papyrusTextInstanceEClass, PAPYRUS_TEXT_INSTANCE__NAME);
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
		papyrusTextInstanceEClass.getESuperTypes().add(theEcorePackage.getEModelElement());

		// Initialize classes and features; add operations and parameters
		initEClass(papyrusTextInstanceEClass, PapyrusTextInstance.class, "PapyrusTextInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPapyrusTextInstance_EditedObject(), theEcorePackage.getEObject(), null, "editedObject", null, 0, 1, PapyrusTextInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPapyrusTextInstance_Type(), ecorePackage.getEString(), "type", null, 0, 1, PapyrusTextInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPapyrusTextInstance_Name(), ecorePackage.getEString(), "name", null, 0, 1, PapyrusTextInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //PapyrustextinstancePackageImpl
