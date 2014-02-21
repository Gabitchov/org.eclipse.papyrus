/**
 *  Copyright (c) 2012 Mia-Software.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 * 	Alban Ménager (Soft-Maint) - Bug 387470 - [EFacet][Custom] Editors
 * 
 * 
 */
package org.eclipse.papyrus.emf.facet.query.ocl.metamodel.oclquery.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.EFacetPackage;

import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.ExtensiblePackage;

import org.eclipse.papyrus.emf.facet.query.ocl.metamodel.oclquery.OclQuery;
import org.eclipse.papyrus.emf.facet.query.ocl.metamodel.oclquery.OclQueryFactory;
import org.eclipse.papyrus.emf.facet.query.ocl.metamodel.oclquery.OclQueryPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OclQueryPackageImpl extends EPackageImpl implements OclQueryPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass oclQueryEClass = null;

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
	 * @see org.eclipse.papyrus.emf.facet.query.ocl.metamodel.oclquery.OclQueryPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private OclQueryPackageImpl() {
		super(eNS_URI, OclQueryFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link OclQueryPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static OclQueryPackage init() {
		if (isInited) return (OclQueryPackage)EPackage.Registry.INSTANCE.getEPackage(OclQueryPackage.eNS_URI);

		// Obtain or create and register package
		OclQueryPackageImpl theOclQueryPackage = (OclQueryPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof OclQueryPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new OclQueryPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EFacetPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theOclQueryPackage.createPackageContents();

		// Initialize created meta-data
		theOclQueryPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theOclQueryPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(OclQueryPackage.eNS_URI, theOclQueryPackage);
		return theOclQueryPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOclQuery() {
		return oclQueryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOclQuery_Context() {
		return (EReference)oclQueryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOclQuery_OclExpression() {
		return (EAttribute)oclQueryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclQueryFactory getOclQueryFactory() {
		return (OclQueryFactory)getEFactoryInstance();
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
		oclQueryEClass = createEClass(OCL_QUERY);
		createEReference(oclQueryEClass, OCL_QUERY__CONTEXT);
		createEAttribute(oclQueryEClass, OCL_QUERY__OCL_EXPRESSION);
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
		ExtensiblePackage theExtensiblePackage = (ExtensiblePackage)EPackage.Registry.INSTANCE.getEPackage(ExtensiblePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		oclQueryEClass.getESuperTypes().add(theExtensiblePackage.getQuery());

		// Initialize classes and features; add operations and parameters
		initEClass(oclQueryEClass, OclQuery.class, "OclQuery", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOclQuery_Context(), ecorePackage.getEClassifier(), null, "context", null, 0, 1, OclQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOclQuery_OclExpression(), ecorePackage.getEString(), "oclExpression", null, 0, 1, OclQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(oclQueryEClass, ecorePackage.getEString(), "toString", 0, 1, IS_UNIQUE, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //OclQueryPackageImpl
