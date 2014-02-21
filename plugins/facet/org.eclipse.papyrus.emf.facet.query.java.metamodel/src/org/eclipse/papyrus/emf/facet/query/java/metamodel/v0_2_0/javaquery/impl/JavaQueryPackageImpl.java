/**
 *  Copyright (c) 2011 Mia-Software.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *  	Nicolas Guyomar (Mia-Software) - Bug 334615 - Java Query for EMF Facet
 *  	Emmanuelle Rouillé (Mia-Software) - Bug 352618 - To be able to use non derived facet structural features and save them values. 
 *  
 */
package org.eclipse.papyrus.emf.facet.query.java.metamodel.v0_2_0.javaquery.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.EFacetPackage;

import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.ExtensiblePackage;

import org.eclipse.papyrus.emf.facet.query.java.metamodel.v0_2_0.javaquery.JavaQuery;
import org.eclipse.papyrus.emf.facet.query.java.metamodel.v0_2_0.javaquery.JavaQueryFactory;
import org.eclipse.papyrus.emf.facet.query.java.metamodel.v0_2_0.javaquery.JavaQueryPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class JavaQueryPackageImpl extends EPackageImpl implements JavaQueryPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass javaQueryEClass = null;

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
	 * @see org.eclipse.papyrus.emf.facet.query.java.metamodel.v0_2_0.javaquery.JavaQueryPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private JavaQueryPackageImpl() {
		super(eNS_URI, JavaQueryFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link JavaQueryPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static JavaQueryPackage init() {
		if (isInited) return (JavaQueryPackage)EPackage.Registry.INSTANCE.getEPackage(JavaQueryPackage.eNS_URI);

		// Obtain or create and register package
		JavaQueryPackageImpl theJavaQueryPackage = (JavaQueryPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof JavaQueryPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new JavaQueryPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EFacetPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theJavaQueryPackage.createPackageContents();

		// Initialize created meta-data
		theJavaQueryPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theJavaQueryPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(JavaQueryPackage.eNS_URI, theJavaQueryPackage);
		return theJavaQueryPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJavaQuery() {
		return javaQueryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaQuery_ImplementationClassName() {
		return (EAttribute)javaQueryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavaQueryFactory getJavaQueryFactory() {
		return (JavaQueryFactory)getEFactoryInstance();
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
		javaQueryEClass = createEClass(JAVA_QUERY);
		createEAttribute(javaQueryEClass, JAVA_QUERY__IMPLEMENTATION_CLASS_NAME);
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
		javaQueryEClass.getESuperTypes().add(theExtensiblePackage.getQuery());

		// Initialize classes and features; add operations and parameters
		initEClass(javaQueryEClass, JavaQuery.class, "JavaQuery", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getJavaQuery_ImplementationClassName(), ecorePackage.getEString(), "implementationClassName", null, 0, 1, JavaQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		// Create resource
		createResource(eNS_URI);
	}

} //JavaQueryPackageImpl
