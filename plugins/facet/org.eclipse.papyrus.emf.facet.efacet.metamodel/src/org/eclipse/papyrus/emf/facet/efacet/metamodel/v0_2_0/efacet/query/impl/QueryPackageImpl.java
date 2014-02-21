/**
 *  Copyright (c) 2011, 2012 Mia-Software.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 * 	Gregoire Dupe (Mia-Software) - Design
 * 	Nicolas Guyomar (Mia-Software) - Implementation
 * 	Emmanuelle RouillÃ© (Mia-Software) - Bug 352618 - To be able to use non derived facet structural features and save them values. 
 * 	Nicolas Bros (Mia-Software) - Bug 361823 - [Restructuring] eFacet2 meta-model
 *  Gregoire Dupe (Mia-Software) - Bug 366055 - NavigationQuery
 *  Gregoire Dupe (Mia-Software) - Bug 369987 - [Restructuring][Table] Switch to the new customization and facet framework
 *  Gregoire Dupe (Mia-Software) - Bug 364325 - [Restructuring] The user must be able to navigate into a model using the Facet.
 */
package org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.EFacetPackage;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.ExtensiblePackage;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.impl.ExtensiblePackageImpl;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.EFacetPackageImpl;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.EObjectLiteralQuery;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.FalseLiteralQuery;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.FloatLiteralQuery;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.IntegerLiteralQuery;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.IsOneOfQuery;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.NavigationQuery;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.NullLiteralQuery;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.OperationCallQuery;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.QueryFactory;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.QueryPackage;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.StringLiteralQuery;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.TrueLiteralQuery;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.RuntimePackage;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.impl.RuntimePackageImpl;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.SerializationPackage;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.impl.SerializationPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class QueryPackageImpl extends EPackageImpl implements QueryPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass navigationQueryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass isOneOfQueryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringLiteralQueryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass trueLiteralQueryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass falseLiteralQueryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nullLiteralQueryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass integerLiteralQueryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass floatLiteralQueryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eObjectLiteralQueryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operationCallQueryEClass = null;

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
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.QueryPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private QueryPackageImpl() {
		super(eNS_URI, QueryFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link QueryPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static QueryPackage init() {
		if (isInited) return (QueryPackage)EPackage.Registry.INSTANCE.getEPackage(QueryPackage.eNS_URI);

		// Obtain or create and register package
		QueryPackageImpl theQueryPackage = (QueryPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof QueryPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new QueryPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		EFacetPackageImpl theEFacetPackage = (EFacetPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(EFacetPackage.eNS_URI) instanceof EFacetPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(EFacetPackage.eNS_URI) : EFacetPackage.eINSTANCE);
		SerializationPackageImpl theSerializationPackage = (SerializationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SerializationPackage.eNS_URI) instanceof SerializationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SerializationPackage.eNS_URI) : SerializationPackage.eINSTANCE);
		ExtensiblePackageImpl theExtensiblePackage = (ExtensiblePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ExtensiblePackage.eNS_URI) instanceof ExtensiblePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ExtensiblePackage.eNS_URI) : ExtensiblePackage.eINSTANCE);
		RuntimePackageImpl theRuntimePackage = (RuntimePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(RuntimePackage.eNS_URI) instanceof RuntimePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(RuntimePackage.eNS_URI) : RuntimePackage.eINSTANCE);

		// Create package meta-data objects
		theQueryPackage.createPackageContents();
		theEFacetPackage.createPackageContents();
		theSerializationPackage.createPackageContents();
		theExtensiblePackage.createPackageContents();
		theRuntimePackage.createPackageContents();

		// Initialize created meta-data
		theQueryPackage.initializePackageContents();
		theEFacetPackage.initializePackageContents();
		theSerializationPackage.initializePackageContents();
		theExtensiblePackage.initializePackageContents();
		theRuntimePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theQueryPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(QueryPackage.eNS_URI, theQueryPackage);
		return theQueryPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNavigationQuery() {
		return navigationQueryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNavigationQuery_Path() {
		return (EReference)navigationQueryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNavigationQuery_FailOnError() {
		return (EAttribute)navigationQueryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIsOneOfQuery() {
		return isOneOfQueryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIsOneOfQuery_ExpectedEObjects() {
		return (EReference)isOneOfQueryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStringLiteralQuery() {
		return stringLiteralQueryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringLiteralQuery_Value() {
		return (EAttribute)stringLiteralQueryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTrueLiteralQuery() {
		return trueLiteralQueryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFalseLiteralQuery() {
		return falseLiteralQueryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNullLiteralQuery() {
		return nullLiteralQueryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntegerLiteralQuery() {
		return integerLiteralQueryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntegerLiteralQuery_Value() {
		return (EAttribute)integerLiteralQueryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFloatLiteralQuery() {
		return floatLiteralQueryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFloatLiteralQuery_Value() {
		return (EAttribute)floatLiteralQueryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEObjectLiteralQuery() {
		return eObjectLiteralQueryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEObjectLiteralQuery_Element() {
		return (EReference)eObjectLiteralQueryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperationCallQuery() {
		return operationCallQueryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationCallQuery_Operation() {
		return (EReference)operationCallQueryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationCallQuery_Arguments() {
		return (EReference)operationCallQueryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QueryFactory getQueryFactory() {
		return (QueryFactory)getEFactoryInstance();
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
		navigationQueryEClass = createEClass(NAVIGATION_QUERY);
		createEReference(navigationQueryEClass, NAVIGATION_QUERY__PATH);
		createEAttribute(navigationQueryEClass, NAVIGATION_QUERY__FAIL_ON_ERROR);

		isOneOfQueryEClass = createEClass(IS_ONE_OF_QUERY);
		createEReference(isOneOfQueryEClass, IS_ONE_OF_QUERY__EXPECTED_EOBJECTS);

		stringLiteralQueryEClass = createEClass(STRING_LITERAL_QUERY);
		createEAttribute(stringLiteralQueryEClass, STRING_LITERAL_QUERY__VALUE);

		trueLiteralQueryEClass = createEClass(TRUE_LITERAL_QUERY);

		falseLiteralQueryEClass = createEClass(FALSE_LITERAL_QUERY);

		nullLiteralQueryEClass = createEClass(NULL_LITERAL_QUERY);

		integerLiteralQueryEClass = createEClass(INTEGER_LITERAL_QUERY);
		createEAttribute(integerLiteralQueryEClass, INTEGER_LITERAL_QUERY__VALUE);

		floatLiteralQueryEClass = createEClass(FLOAT_LITERAL_QUERY);
		createEAttribute(floatLiteralQueryEClass, FLOAT_LITERAL_QUERY__VALUE);

		eObjectLiteralQueryEClass = createEClass(EOBJECT_LITERAL_QUERY);
		createEReference(eObjectLiteralQueryEClass, EOBJECT_LITERAL_QUERY__ELEMENT);

		operationCallQueryEClass = createEClass(OPERATION_CALL_QUERY);
		createEReference(operationCallQueryEClass, OPERATION_CALL_QUERY__OPERATION);
		createEReference(operationCallQueryEClass, OPERATION_CALL_QUERY__ARGUMENTS);
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
		navigationQueryEClass.getESuperTypes().add(theExtensiblePackage.getQuery());
		isOneOfQueryEClass.getESuperTypes().add(theExtensiblePackage.getQuery());
		stringLiteralQueryEClass.getESuperTypes().add(theExtensiblePackage.getQuery());
		trueLiteralQueryEClass.getESuperTypes().add(theExtensiblePackage.getQuery());
		falseLiteralQueryEClass.getESuperTypes().add(theExtensiblePackage.getQuery());
		nullLiteralQueryEClass.getESuperTypes().add(theExtensiblePackage.getQuery());
		integerLiteralQueryEClass.getESuperTypes().add(theExtensiblePackage.getQuery());
		floatLiteralQueryEClass.getESuperTypes().add(theExtensiblePackage.getQuery());
		eObjectLiteralQueryEClass.getESuperTypes().add(theExtensiblePackage.getQuery());
		operationCallQueryEClass.getESuperTypes().add(theExtensiblePackage.getQuery());

		// Initialize classes and features; add operations and parameters
		initEClass(navigationQueryEClass, NavigationQuery.class, "NavigationQuery", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getNavigationQuery_Path(), ecorePackage.getETypedElement(), null, "path", null, 1, -1, NavigationQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getNavigationQuery_FailOnError(), ecorePackage.getEBoolean(), "failOnError", "true", 0, 1, NavigationQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(isOneOfQueryEClass, IsOneOfQuery.class, "IsOneOfQuery", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getIsOneOfQuery_ExpectedEObjects(), ecorePackage.getEObject(), null, "expectedEObjects", null, 0, -1, IsOneOfQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(stringLiteralQueryEClass, StringLiteralQuery.class, "StringLiteralQuery", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getStringLiteralQuery_Value(), ecorePackage.getEString(), "value", null, 0, 1, StringLiteralQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(trueLiteralQueryEClass, TrueLiteralQuery.class, "TrueLiteralQuery", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(falseLiteralQueryEClass, FalseLiteralQuery.class, "FalseLiteralQuery", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(nullLiteralQueryEClass, NullLiteralQuery.class, "NullLiteralQuery", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(integerLiteralQueryEClass, IntegerLiteralQuery.class, "IntegerLiteralQuery", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getIntegerLiteralQuery_Value(), ecorePackage.getEInt(), "value", null, 0, 1, IntegerLiteralQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(floatLiteralQueryEClass, FloatLiteralQuery.class, "FloatLiteralQuery", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getFloatLiteralQuery_Value(), ecorePackage.getEFloat(), "value", null, 0, 1, FloatLiteralQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(eObjectLiteralQueryEClass, EObjectLiteralQuery.class, "EObjectLiteralQuery", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getEObjectLiteralQuery_Element(), ecorePackage.getEObject(), null, "element", null, 0, 1, EObjectLiteralQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(operationCallQueryEClass, OperationCallQuery.class, "OperationCallQuery", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getOperationCallQuery_Operation(), ecorePackage.getEOperation(), null, "operation", null, 0, 1, OperationCallQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getOperationCallQuery_Arguments(), theExtensiblePackage.getQuery(), null, "arguments", null, 0, -1, OperationCallQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
	}

} //QueryPackageImpl
