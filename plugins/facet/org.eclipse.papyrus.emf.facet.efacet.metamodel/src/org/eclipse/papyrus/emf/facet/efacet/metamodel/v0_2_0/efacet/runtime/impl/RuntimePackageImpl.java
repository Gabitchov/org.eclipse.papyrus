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
 * 	Emmanuelle Rouillé (Mia-Software) - Bug 352618 - To be able to use non derived facet structural features and save them values. 
 * 	Nicolas Bros (Mia-Software) - Bug 361823 - [Restructuring] eFacet2 meta-model
 *       Gregoire Dupe (Mia-Software) - Bug 366055 - NavigationQuery
 *       Gregoire Dupe (Mia-Software) - Bug 369673 - [Facet] IsOneOfQuery
 *       Olivier Remaud (Soft-Maint) - Bug 369824 - Add a simple way to return string literal constants from a customization query
 *       Gregoire Dupe (Mia-software) - Bug 369987 - [Restructuring][Table] Switch to the new customization and facet framework
 *       Gregoire Dupe (Mia-software) - Bug 364325 - [Restructuring] The user must be able to navigate into a model using the Facet.
 */
package org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.EFacetPackage;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.ExtensiblePackage;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.impl.ExtensiblePackageImpl;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.EFacetPackageImpl;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.QueryPackage;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.impl.QueryPackageImpl;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.ETypedElementEObjectListResult;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.ETypedElementEObjectResult;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.ETypedElementPrimitiveTypeListResult;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.ETypedElementPrimitiveTypeResult;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.ETypedElementResult;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.RuntimeFactory;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.RuntimePackage;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.SerializationPackage;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.impl.SerializationPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RuntimePackageImpl extends EPackageImpl implements RuntimePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eTypedElementPrimitiveTypeResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eTypedElementEObjectResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eTypedElementPrimitiveTypeListResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eTypedElementEObjectListResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eTypedElementResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType javaExceptionEDataType = null;

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
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.RuntimePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private RuntimePackageImpl() {
		super(eNS_URI, RuntimeFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link RuntimePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static RuntimePackage init() {
		if (isInited) return (RuntimePackage)EPackage.Registry.INSTANCE.getEPackage(RuntimePackage.eNS_URI);

		// Obtain or create and register package
		RuntimePackageImpl theRuntimePackage = (RuntimePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof RuntimePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new RuntimePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		EFacetPackageImpl theEFacetPackage = (EFacetPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(EFacetPackage.eNS_URI) instanceof EFacetPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(EFacetPackage.eNS_URI) : EFacetPackage.eINSTANCE);
		SerializationPackageImpl theSerializationPackage = (SerializationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SerializationPackage.eNS_URI) instanceof SerializationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SerializationPackage.eNS_URI) : SerializationPackage.eINSTANCE);
		ExtensiblePackageImpl theExtensiblePackage = (ExtensiblePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ExtensiblePackage.eNS_URI) instanceof ExtensiblePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ExtensiblePackage.eNS_URI) : ExtensiblePackage.eINSTANCE);
		QueryPackageImpl theQueryPackage = (QueryPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(QueryPackage.eNS_URI) instanceof QueryPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(QueryPackage.eNS_URI) : QueryPackage.eINSTANCE);

		// Create package meta-data objects
		theRuntimePackage.createPackageContents();
		theEFacetPackage.createPackageContents();
		theSerializationPackage.createPackageContents();
		theExtensiblePackage.createPackageContents();
		theQueryPackage.createPackageContents();

		// Initialize created meta-data
		theRuntimePackage.initializePackageContents();
		theEFacetPackage.initializePackageContents();
		theSerializationPackage.initializePackageContents();
		theExtensiblePackage.initializePackageContents();
		theQueryPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theRuntimePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(RuntimePackage.eNS_URI, theRuntimePackage);
		return theRuntimePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getETypedElementPrimitiveTypeResult() {
		return eTypedElementPrimitiveTypeResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getETypedElementPrimitiveTypeResult_Result() {
		return (EAttribute)eTypedElementPrimitiveTypeResultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getETypedElementEObjectResult() {
		return eTypedElementEObjectResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getETypedElementEObjectResult_Result() {
		return (EReference)eTypedElementEObjectResultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getETypedElementPrimitiveTypeListResult() {
		return eTypedElementPrimitiveTypeListResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getETypedElementPrimitiveTypeListResult_ResultList() {
		return (EAttribute)eTypedElementPrimitiveTypeListResultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getETypedElementEObjectListResult() {
		return eTypedElementEObjectListResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getETypedElementEObjectListResult_ResultList() {
		return (EReference)eTypedElementEObjectListResultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getETypedElementResult() {
		return eTypedElementResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getETypedElementResult_DerivedTypedElement() {
		return (EReference)eTypedElementResultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getETypedElementResult_ParameterValues() {
		return (EReference)eTypedElementResultEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getETypedElementResult_Source() {
		return (EReference)eTypedElementResultEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getETypedElementResult_Exception() {
		return (EAttribute)eTypedElementResultEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getJavaException() {
		return javaExceptionEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuntimeFactory getRuntimeFactory() {
		return (RuntimeFactory)getEFactoryInstance();
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
		eTypedElementPrimitiveTypeResultEClass = createEClass(ETYPED_ELEMENT_PRIMITIVE_TYPE_RESULT);
		createEAttribute(eTypedElementPrimitiveTypeResultEClass, ETYPED_ELEMENT_PRIMITIVE_TYPE_RESULT__RESULT);

		eTypedElementEObjectResultEClass = createEClass(ETYPED_ELEMENT_EOBJECT_RESULT);
		createEReference(eTypedElementEObjectResultEClass, ETYPED_ELEMENT_EOBJECT_RESULT__RESULT);

		eTypedElementPrimitiveTypeListResultEClass = createEClass(ETYPED_ELEMENT_PRIMITIVE_TYPE_LIST_RESULT);
		createEAttribute(eTypedElementPrimitiveTypeListResultEClass, ETYPED_ELEMENT_PRIMITIVE_TYPE_LIST_RESULT__RESULT_LIST);

		eTypedElementEObjectListResultEClass = createEClass(ETYPED_ELEMENT_EOBJECT_LIST_RESULT);
		createEReference(eTypedElementEObjectListResultEClass, ETYPED_ELEMENT_EOBJECT_LIST_RESULT__RESULT_LIST);

		eTypedElementResultEClass = createEClass(ETYPED_ELEMENT_RESULT);
		createEReference(eTypedElementResultEClass, ETYPED_ELEMENT_RESULT__DERIVED_TYPED_ELEMENT);
		createEReference(eTypedElementResultEClass, ETYPED_ELEMENT_RESULT__PARAMETER_VALUES);
		createEReference(eTypedElementResultEClass, ETYPED_ELEMENT_RESULT__SOURCE);
		createEAttribute(eTypedElementResultEClass, ETYPED_ELEMENT_RESULT__EXCEPTION);

		// Create data types
		javaExceptionEDataType = createEDataType(JAVA_EXCEPTION);
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
		EFacetPackage theEFacetPackage = (EFacetPackage)EPackage.Registry.INSTANCE.getEPackage(EFacetPackage.eNS_URI);

		// Create type parameters
		ETypeParameter eTypedElementPrimitiveTypeResultEClass_T = addETypeParameter(eTypedElementPrimitiveTypeResultEClass, "T"); //$NON-NLS-1$
		ETypeParameter eTypedElementEObjectResultEClass_T = addETypeParameter(eTypedElementEObjectResultEClass, "T"); //$NON-NLS-1$
		ETypeParameter eTypedElementPrimitiveTypeListResultEClass_T = addETypeParameter(eTypedElementPrimitiveTypeListResultEClass, "T"); //$NON-NLS-1$
		ETypeParameter eTypedElementEObjectListResultEClass_T = addETypeParameter(eTypedElementEObjectListResultEClass, "T"); //$NON-NLS-1$

		// Set bounds for type parameters
		EGenericType g1 = createEGenericType(ecorePackage.getEObject());
		eTypedElementEObjectResultEClass_T.getEBounds().add(g1);
		g1 = createEGenericType(ecorePackage.getEObject());
		eTypedElementEObjectListResultEClass_T.getEBounds().add(g1);

		// Add supertypes to classes
		eTypedElementPrimitiveTypeResultEClass.getESuperTypes().add(this.getETypedElementResult());
		eTypedElementEObjectResultEClass.getESuperTypes().add(this.getETypedElementResult());
		eTypedElementPrimitiveTypeListResultEClass.getESuperTypes().add(this.getETypedElementResult());
		eTypedElementEObjectListResultEClass.getESuperTypes().add(this.getETypedElementResult());

		// Initialize classes and features; add operations and parameters
		initEClass(eTypedElementPrimitiveTypeResultEClass, ETypedElementPrimitiveTypeResult.class, "ETypedElementPrimitiveTypeResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		g1 = createEGenericType(eTypedElementPrimitiveTypeResultEClass_T);
		initEAttribute(getETypedElementPrimitiveTypeResult_Result(), g1, "result", null, 0, 1, ETypedElementPrimitiveTypeResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(eTypedElementEObjectResultEClass, ETypedElementEObjectResult.class, "ETypedElementEObjectResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		g1 = createEGenericType(eTypedElementEObjectResultEClass_T);
		initEReference(getETypedElementEObjectResult_Result(), g1, null, "result", null, 0, 1, ETypedElementEObjectResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(eTypedElementPrimitiveTypeListResultEClass, ETypedElementPrimitiveTypeListResult.class, "ETypedElementPrimitiveTypeListResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		g1 = createEGenericType(eTypedElementPrimitiveTypeListResultEClass_T);
		initEAttribute(getETypedElementPrimitiveTypeListResult_ResultList(), g1, "resultList", null, 0, -1, ETypedElementPrimitiveTypeListResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(eTypedElementEObjectListResultEClass, ETypedElementEObjectListResult.class, "ETypedElementEObjectListResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		g1 = createEGenericType(eTypedElementEObjectListResultEClass_T);
		initEReference(getETypedElementEObjectListResult_ResultList(), g1, null, "resultList", null, 0, -1, ETypedElementEObjectListResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(eTypedElementResultEClass, ETypedElementResult.class, "ETypedElementResult", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getETypedElementResult_DerivedTypedElement(), ecorePackage.getETypedElement(), null, "derivedTypedElement", null, 1, 1, ETypedElementResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getETypedElementResult_ParameterValues(), theEFacetPackage.getParameterValue(), null, "parameterValues", null, 0, -1, ETypedElementResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getETypedElementResult_Source(), ecorePackage.getEObject(), null, "source", null, 1, 1, ETypedElementResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getETypedElementResult_Exception(), this.getJavaException(), "exception", null, 0, 1, ETypedElementResult.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		// Initialize data types
		initEDataType(javaExceptionEDataType, Throwable.class, "JavaException", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
	}

} //RuntimePackageImpl
