/**
 *  Copyright (c) 2011,2012 Mia-Software.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *     Gregoire Dupe (Mia-Software) - Design
 *     Nicolas Guyomar (Mia-Software) - Implementation
 *     Emmanuelle Rouillé (Mia-Software) - Bug 352618 - To be able to use non-derived facet structural features and save their values.
 *     Nicolas Bros (Mia-Software) - Bug 370110 - Rename efacetcatalog2.ecore
 *     Grégoire Dupé (Mia-Software) - Bug 361817 - [Restructuring] Dynamic load to the facet catalog
 * 
 */
package org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacetcatalog.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.EFacetPackage;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacetcatalog.EfacetcatalogFactory;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacetcatalog.EfacetcatalogPackage;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacetcatalog.FacetSetCatalog;
import org.eclipse.papyrus.emf.facet.util.emf.catalog.CatalogPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EfacetcatalogPackageImpl extends EPackageImpl implements EfacetcatalogPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass facetSetCatalogEClass = null;

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
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacetcatalog.EfacetcatalogPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EfacetcatalogPackageImpl() {
		super(eNS_URI, EfacetcatalogFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link EfacetcatalogPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static EfacetcatalogPackage init() {
		if (isInited) return (EfacetcatalogPackage)EPackage.Registry.INSTANCE.getEPackage(EfacetcatalogPackage.eNS_URI);

		// Obtain or create and register package
		EfacetcatalogPackageImpl theEfacetcatalogPackage = (EfacetcatalogPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof EfacetcatalogPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new EfacetcatalogPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		CatalogPackage.eINSTANCE.eClass();
		EFacetPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theEfacetcatalogPackage.createPackageContents();

		// Initialize created meta-data
		theEfacetcatalogPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEfacetcatalogPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(EfacetcatalogPackage.eNS_URI, theEfacetcatalogPackage);
		return theEfacetcatalogPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFacetSetCatalog() {
		return facetSetCatalogEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EfacetcatalogFactory getEfacetcatalogFactory() {
		return (EfacetcatalogFactory)getEFactoryInstance();
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
		facetSetCatalogEClass = createEClass(FACET_SET_CATALOG);
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
		facetSetCatalogEClass.getESuperTypes().add(theCatalogPackage.getCatalog());

		// Initialize classes and features; add operations and parameters
		initEClass(facetSetCatalogEClass, FacetSetCatalog.class, "FacetSetCatalog", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		// Create resource
		createResource(eNS_URI);
	}

} //EfacetcatalogPackageImpl
