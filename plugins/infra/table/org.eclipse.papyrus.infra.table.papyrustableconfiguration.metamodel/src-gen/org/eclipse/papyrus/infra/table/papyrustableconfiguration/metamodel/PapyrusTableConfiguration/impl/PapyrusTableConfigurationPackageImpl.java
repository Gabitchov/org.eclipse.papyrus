/**
 * Copyright (c) 2012 CEA LIST.
 * 
 *     
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * ttp://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.infra.table.papyrustableconfiguration.metamodel.PapyrusTableConfiguration.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.facet.widgets.nattable.tableconfiguration2.Tableconfiguration2Package;

import org.eclipse.papyrus.infra.table.papyrustableconfiguration.metamodel.PapyrusTableConfiguration.PapyrusTableConfiguration;
import org.eclipse.papyrus.infra.table.papyrustableconfiguration.metamodel.PapyrusTableConfiguration.PapyrusTableConfigurationFactory;
import org.eclipse.papyrus.infra.table.papyrustableconfiguration.metamodel.PapyrusTableConfiguration.PapyrusTableConfigurationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PapyrusTableConfigurationPackageImpl extends EPackageImpl implements PapyrusTableConfigurationPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass papyrusTableConfigurationEClass = null;

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
	 * @see org.eclipse.papyrus.infra.table.papyrustableconfiguration.metamodel.PapyrusTableConfiguration.PapyrusTableConfigurationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private PapyrusTableConfigurationPackageImpl() {
		super(eNS_URI, PapyrusTableConfigurationFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link PapyrusTableConfigurationPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static PapyrusTableConfigurationPackage init() {
		if (isInited) return (PapyrusTableConfigurationPackage)EPackage.Registry.INSTANCE.getEPackage(PapyrusTableConfigurationPackage.eNS_URI);

		// Obtain or create and register package
		PapyrusTableConfigurationPackageImpl thePapyrusTableConfigurationPackage = (PapyrusTableConfigurationPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof PapyrusTableConfigurationPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new PapyrusTableConfigurationPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		Tableconfiguration2Package.eINSTANCE.eClass();

		// Create package meta-data objects
		thePapyrusTableConfigurationPackage.createPackageContents();

		// Initialize created meta-data
		thePapyrusTableConfigurationPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thePapyrusTableConfigurationPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(PapyrusTableConfigurationPackage.eNS_URI, thePapyrusTableConfigurationPackage);
		return thePapyrusTableConfigurationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPapyrusTableConfiguration() {
		return papyrusTableConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPapyrusTableConfiguration_PastedElementContainmentFeature() {
		return (EReference)papyrusTableConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPapyrusTableConfiguration_PastedElementId() {
		return (EAttribute)papyrusTableConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPapyrusTableConfiguration_TableConfiguration() {
		return (EReference)papyrusTableConfigurationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PapyrusTableConfigurationFactory getPapyrusTableConfigurationFactory() {
		return (PapyrusTableConfigurationFactory)getEFactoryInstance();
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
		papyrusTableConfigurationEClass = createEClass(PAPYRUS_TABLE_CONFIGURATION);
		createEReference(papyrusTableConfigurationEClass, PAPYRUS_TABLE_CONFIGURATION__PASTED_ELEMENT_CONTAINMENT_FEATURE);
		createEAttribute(papyrusTableConfigurationEClass, PAPYRUS_TABLE_CONFIGURATION__PASTED_ELEMENT_ID);
		createEReference(papyrusTableConfigurationEClass, PAPYRUS_TABLE_CONFIGURATION__TABLE_CONFIGURATION);
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
		Tableconfiguration2Package theTableconfiguration2Package = (Tableconfiguration2Package)EPackage.Registry.INSTANCE.getEPackage(Tableconfiguration2Package.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		papyrusTableConfigurationEClass.getESuperTypes().add(theEcorePackage.getEModelElement());

		// Initialize classes and features; add operations and parameters
		initEClass(papyrusTableConfigurationEClass, PapyrusTableConfiguration.class, "PapyrusTableConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPapyrusTableConfiguration_PastedElementContainmentFeature(), theEcorePackage.getEReference(), null, "pastedElementContainmentFeature", null, 0, 1, PapyrusTableConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPapyrusTableConfiguration_PastedElementId(), theEcorePackage.getEString(), "pastedElementId", null, 0, 1, PapyrusTableConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPapyrusTableConfiguration_TableConfiguration(), theTableconfiguration2Package.getTableConfiguration2(), null, "TableConfiguration", null, 0, 1, PapyrusTableConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //PapyrusTableConfigurationPackageImpl
