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
 *  
 */
package org.eclipse.papyrus.emf.facet.query.java.javaquery.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.papyrus.emf.facet.efacet.EFacetPackage;
import org.eclipse.papyrus.emf.facet.query.java.javaquery.JavaQuery;
import org.eclipse.papyrus.emf.facet.query.java.javaquery.JavaqueryFactory;
import org.eclipse.papyrus.emf.facet.query.java.javaquery.JavaqueryPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * 
 * @generated
 * @deprecated cf. https://bugs.eclipse.org/bugs/show_bug.cgi?id=374198
 */
@Deprecated
public class JavaqueryPackageImpl extends EPackageImpl implements JavaqueryPackage {
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
	 * @see org.eclipse.papyrus.emf.facet.query.java.javaquery.JavaqueryPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private JavaqueryPackageImpl() {
		super(JavaqueryPackage.eNS_URI, JavaqueryFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link JavaqueryPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static JavaqueryPackage init() {
		if (JavaqueryPackageImpl.isInited) {
			return (JavaqueryPackage)EPackage.Registry.INSTANCE.getEPackage(JavaqueryPackage.eNS_URI);
		}

		// Obtain or create and register package
		JavaqueryPackageImpl theJavaqueryPackage = (JavaqueryPackageImpl)(EPackage.Registry.INSTANCE.get(JavaqueryPackage.eNS_URI) instanceof JavaqueryPackageImpl ? EPackage.Registry.INSTANCE.get(JavaqueryPackage.eNS_URI) : new JavaqueryPackageImpl());

		JavaqueryPackageImpl.isInited = true;

		// Initialize simple dependencies
		EFacetPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theJavaqueryPackage.createPackageContents();

		// Initialize created meta-data
		theJavaqueryPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theJavaqueryPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(JavaqueryPackage.eNS_URI, theJavaqueryPackage);
		return theJavaqueryPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJavaQuery() {
		return this.javaQueryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaQuery_ImplementationClassName() {
		return (EAttribute)this.javaQueryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavaqueryFactory getJavaqueryFactory() {
		return (JavaqueryFactory)getEFactoryInstance();
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
		if (this.isCreated) {
			return;
		}
		this.isCreated = true;

		// Create classes and their features
		this.javaQueryEClass = createEClass(JavaqueryPackage.JAVA_QUERY);
		createEAttribute(this.javaQueryEClass, JavaqueryPackage.JAVA_QUERY__IMPLEMENTATION_CLASS_NAME);
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
		if (this.isInitialized) {
			return;
		}
		this.isInitialized = true;

		// Initialize package
		setName(JavaqueryPackage.eNAME);
		setNsPrefix(JavaqueryPackage.eNS_PREFIX);
		setNsURI(JavaqueryPackage.eNS_URI);

		// Obtain other dependent packages
		EFacetPackage theEFacetPackage = (EFacetPackage)EPackage.Registry.INSTANCE.getEPackage(EFacetPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		this.javaQueryEClass.getESuperTypes().add(theEFacetPackage.getQuery());

		// Initialize classes and features; add operations and parameters
		initEClass(this.javaQueryEClass, JavaQuery.class, "JavaQuery", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getJavaQuery_ImplementationClassName(), this.ecorePackage.getEString(), "implementationClassName", null, 0, 1, JavaQuery.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE, !EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED); //$NON-NLS-1$

		// Create resource
		createResource(JavaqueryPackage.eNS_URI);
	}

} //JavaqueryPackageImpl
