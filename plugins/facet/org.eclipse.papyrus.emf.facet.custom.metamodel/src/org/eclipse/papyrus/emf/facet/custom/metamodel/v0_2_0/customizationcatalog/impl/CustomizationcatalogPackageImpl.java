/**
 *  Copyright (c) 2011 Mia-Software.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *  	Gregoire Dupe (Mia-Software) - Bug 361794 - [Restructuring] New customization meta-model
 *   	Gregoire Dupe (Mia-Software) - Bug 373078 - API Cleaning
 *  
 */
package org.eclipse.emf.facet.custom.metamodel.v0_2_0.customizationcatalog.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.facet.custom.metamodel.v0_2_0.customizationcatalog.CustomizationCatalog;
import org.eclipse.emf.facet.custom.metamodel.v0_2_0.customizationcatalog.CustomizationPropertiesCatalog;
import org.eclipse.emf.facet.custom.metamodel.v0_2_0.customizationcatalog.CustomizationcatalogFactory;
import org.eclipse.emf.facet.custom.metamodel.v0_2_0.customizationcatalog.CustomizationcatalogPackage;

import org.eclipse.emf.facet.util.emf.catalog.CatalogPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CustomizationcatalogPackageImpl extends EPackageImpl implements CustomizationcatalogPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass customizationCatalogEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass customizationPropertiesCatalogEClass = null;

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
	 * @see org.eclipse.emf.facet.custom.metamodel.v0_2_0.customizationcatalog.CustomizationcatalogPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CustomizationcatalogPackageImpl() {
		super(eNS_URI, CustomizationcatalogFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link CustomizationcatalogPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CustomizationcatalogPackage init() {
		if (isInited) return (CustomizationcatalogPackage)EPackage.Registry.INSTANCE.getEPackage(CustomizationcatalogPackage.eNS_URI);

		// Obtain or create and register package
		CustomizationcatalogPackageImpl theCustomizationcatalogPackage = (CustomizationcatalogPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CustomizationcatalogPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CustomizationcatalogPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		CatalogPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theCustomizationcatalogPackage.createPackageContents();

		// Initialize created meta-data
		theCustomizationcatalogPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCustomizationcatalogPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CustomizationcatalogPackage.eNS_URI, theCustomizationcatalogPackage);
		return theCustomizationcatalogPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCustomizationCatalog() {
		return customizationCatalogEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCustomizationPropertiesCatalog() {
		return customizationPropertiesCatalogEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CustomizationcatalogFactory getCustomizationcatalogFactory() {
		return (CustomizationcatalogFactory)getEFactoryInstance();
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
		customizationCatalogEClass = createEClass(CUSTOMIZATION_CATALOG);

		customizationPropertiesCatalogEClass = createEClass(CUSTOMIZATION_PROPERTIES_CATALOG);
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
		CatalogPackage theCatalogPackage = (CatalogPackage)EPackage.Registry.INSTANCE.getEPackage(CatalogPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		customizationCatalogEClass.getESuperTypes().add(theCatalogPackage.getCatalog());
		customizationPropertiesCatalogEClass.getESuperTypes().add(theCatalogPackage.getCatalog());

		// Initialize classes and features; add operations and parameters
		initEClass(customizationCatalogEClass, CustomizationCatalog.class, "CustomizationCatalog", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(customizationPropertiesCatalogEClass, CustomizationPropertiesCatalog.class, "CustomizationPropertiesCatalog", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //CustomizationcatalogPackageImpl
