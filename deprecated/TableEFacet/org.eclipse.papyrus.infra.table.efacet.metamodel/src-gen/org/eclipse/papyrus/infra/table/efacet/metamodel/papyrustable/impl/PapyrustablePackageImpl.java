/**
 * Copyright (c) 2011 CEA LIST.
 * 
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.ExtensiblePackage;
import org.eclipse.emf.facet.widgets.table.metamodel.v0_2_0.table.TablePackage;
import org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.FillingMode;
import org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable;
import org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrustableFactory;
import org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrustablePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PapyrustablePackageImpl extends EPackageImpl implements PapyrustablePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass papyrusTableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum fillingModeEEnum = null;

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
	 * @see org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrustablePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private PapyrustablePackageImpl() {
		super(eNS_URI, PapyrustableFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link PapyrustablePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static PapyrustablePackage init() {
		if (isInited) return (PapyrustablePackage)EPackage.Registry.INSTANCE.getEPackage(PapyrustablePackage.eNS_URI);

		// Obtain or create and register package
		PapyrustablePackageImpl thePapyrustablePackage = (PapyrustablePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof PapyrustablePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new PapyrustablePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		TablePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		thePapyrustablePackage.createPackageContents();

		// Initialize created meta-data
		thePapyrustablePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thePapyrustablePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(PapyrustablePackage.eNS_URI, thePapyrustablePackage);
		return thePapyrustablePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPapyrusTable() {
		return papyrusTableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPapyrusTable_Name() {
		return (EAttribute)papyrusTableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPapyrusTable_Type() {
		return (EAttribute)papyrusTableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPapyrusTable_Table() {
		return (EReference)papyrusTableEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPapyrusTable_FillingMode() {
		return (EAttribute)papyrusTableEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPapyrusTable_ContextFeature() {
		return (EReference)papyrusTableEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPapyrusTable_Queries() {
		return (EReference)papyrusTableEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPapyrusTable_UsingUser() {
		return (EAttribute)papyrusTableEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPapyrusTable_UsingContextFeature() {
		return (EAttribute)papyrusTableEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPapyrusTable_UsingQueries() {
		return (EAttribute)papyrusTableEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getFillingMode() {
		return fillingModeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PapyrustableFactory getPapyrustableFactory() {
		return (PapyrustableFactory)getEFactoryInstance();
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
		papyrusTableEClass = createEClass(PAPYRUS_TABLE);
		createEAttribute(papyrusTableEClass, PAPYRUS_TABLE__NAME);
		createEAttribute(papyrusTableEClass, PAPYRUS_TABLE__TYPE);
		createEReference(papyrusTableEClass, PAPYRUS_TABLE__TABLE);
		createEAttribute(papyrusTableEClass, PAPYRUS_TABLE__FILLING_MODE);
		createEReference(papyrusTableEClass, PAPYRUS_TABLE__CONTEXT_FEATURE);
		createEReference(papyrusTableEClass, PAPYRUS_TABLE__QUERIES);
		createEAttribute(papyrusTableEClass, PAPYRUS_TABLE__USING_USER);
		createEAttribute(papyrusTableEClass, PAPYRUS_TABLE__USING_CONTEXT_FEATURE);
		createEAttribute(papyrusTableEClass, PAPYRUS_TABLE__USING_QUERIES);

		// Create enums
		fillingModeEEnum = createEEnum(FILLING_MODE);
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
		TablePackage theTablePackage = (TablePackage)EPackage.Registry.INSTANCE.getEPackage(TablePackage.eNS_URI);
		ExtensiblePackage theExtensiblePackage = (ExtensiblePackage)EPackage.Registry.INSTANCE.getEPackage(ExtensiblePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		papyrusTableEClass.getESuperTypes().add(theEcorePackage.getEModelElement());

		// Initialize classes and features; add operations and parameters
		initEClass(papyrusTableEClass, PapyrusTable.class, "PapyrusTable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getPapyrusTable_Name(), ecorePackage.getEString(), "name", null, 0, 1, PapyrusTable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getPapyrusTable_Type(), ecorePackage.getEString(), "type", null, 0, 1, PapyrusTable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getPapyrusTable_Table(), theTablePackage.getTable(), null, "table", null, 0, 1, PapyrusTable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getPapyrusTable_FillingMode(), this.getFillingMode(), "fillingMode", null, 0, 1, PapyrusTable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getPapyrusTable_ContextFeature(), ecorePackage.getEReference(), null, "contextFeature", null, 0, 1, PapyrusTable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getPapyrusTable_Queries(), theExtensiblePackage.getQuery(), null, "queries", null, 0, -1, PapyrusTable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getPapyrusTable_UsingUser(), ecorePackage.getEBoolean(), "usingUser", null, 0, 1, PapyrusTable.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getPapyrusTable_UsingContextFeature(), ecorePackage.getEBoolean(), "usingContextFeature", null, 0, 1, PapyrusTable.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getPapyrusTable_UsingQueries(), ecorePackage.getEBoolean(), "usingQueries", null, 0, 1, PapyrusTable.class, !IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$

		// Initialize enums and add enum literals
		initEEnum(fillingModeEEnum, FillingMode.class, "FillingMode"); //$NON-NLS-1$
		addEEnumLiteral(fillingModeEEnum, FillingMode.USER);
		addEEnumLiteral(fillingModeEEnum, FillingMode.QUERIES);
		addEEnumLiteral(fillingModeEEnum, FillingMode.CONTEXT_FEATURE);

		// Create resource
		createResource(eNS_URI);
	}

} //PapyrustablePackageImpl
