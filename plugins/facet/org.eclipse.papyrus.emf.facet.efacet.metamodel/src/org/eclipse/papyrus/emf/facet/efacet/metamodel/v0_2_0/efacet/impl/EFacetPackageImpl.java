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
 *  Gregoire Dupe (Mia-Software) - Bug 369987 - [Restructuring][Table] Switch to the new customization and facet framework
 *  Gregoire Dupe (Mia-Software) - Bug 364325 - [Restructuring] The user must be able to navigate into a model using the Facet.
 *  Gregoire Dupe (Mia-Software) - Bug 373078 - API Cleaning
 *  Gregoire Dupe (Mia-Software) - Bug 376576 - [EFacet] Change the multiplicity of Facet::extendedFacet
 */
package org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.impl;

import static org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.EFacetPackage.RESOURCE;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.Category;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.DerivedTypedElement;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.DocumentedElement;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.EFacetFactory;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.EFacetPackage;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetAttribute;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetElement;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetOperation;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetReference;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.ParameterValue;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.ExtensiblePackage;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.impl.ExtensiblePackageImpl;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.query.QueryPackage;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.query.impl.QueryPackageImpl;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.RuntimePackage;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.impl.RuntimePackageImpl;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.SerializationPackage;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.impl.SerializationPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EFacetPackageImpl extends EPackageImpl implements EFacetPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass facetAttributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass facetReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass facetOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass facetSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass facetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass categoryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass facetElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass derivedTypedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass documentedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType resourceEDataType = null;

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
	 * @see org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.EFacetPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EFacetPackageImpl() {
		super(eNS_URI, EFacetFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link EFacetPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static EFacetPackage init() {
		if (isInited) return (EFacetPackage)EPackage.Registry.INSTANCE.getEPackage(EFacetPackage.eNS_URI);

		// Obtain or create and register package
		EFacetPackageImpl theEFacetPackage = (EFacetPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof EFacetPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new EFacetPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		SerializationPackageImpl theSerializationPackage = (SerializationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SerializationPackage.eNS_URI) instanceof SerializationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SerializationPackage.eNS_URI) : SerializationPackage.eINSTANCE);
		ExtensiblePackageImpl theExtensiblePackage = (ExtensiblePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ExtensiblePackage.eNS_URI) instanceof ExtensiblePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ExtensiblePackage.eNS_URI) : ExtensiblePackage.eINSTANCE);
		QueryPackageImpl theQueryPackage = (QueryPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(QueryPackage.eNS_URI) instanceof QueryPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(QueryPackage.eNS_URI) : QueryPackage.eINSTANCE);
		RuntimePackageImpl theRuntimePackage = (RuntimePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(RuntimePackage.eNS_URI) instanceof RuntimePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(RuntimePackage.eNS_URI) : RuntimePackage.eINSTANCE);

		// Create package meta-data objects
		theEFacetPackage.createPackageContents();
		theSerializationPackage.createPackageContents();
		theExtensiblePackage.createPackageContents();
		theQueryPackage.createPackageContents();
		theRuntimePackage.createPackageContents();

		// Initialize created meta-data
		theEFacetPackage.initializePackageContents();
		theSerializationPackage.initializePackageContents();
		theExtensiblePackage.initializePackageContents();
		theQueryPackage.initializePackageContents();
		theRuntimePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEFacetPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(EFacetPackage.eNS_URI, theEFacetPackage);
		return theEFacetPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFacetAttribute() {
		return facetAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFacetReference() {
		return facetReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFacetOperation() {
		return facetOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFacetSet() {
		return facetSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFacetSet_Categories() {
		return (EReference)facetSetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFacet() {
		return facetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFacet_ExtendedMetaclass() {
		return (EReference)facetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFacet_FacetElements() {
		return (EReference)facetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFacet_FacetOperations() {
		return (EReference)facetEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFacet_ConformanceTypedElement() {
		return (EReference)facetEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFacet_ExtendedFacets() {
		return (EReference)facetEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCategory() {
		return categoryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFacetElement() {
		return facetElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFacetElement_Categories() {
		return (EReference)facetElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDerivedTypedElement() {
		return derivedTypedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDerivedTypedElement_Query() {
		return (EReference)derivedTypedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDerivedTypedElement_Override() {
		return (EReference)derivedTypedElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParameterValue() {
		return parameterValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParameterValue_Parameter() {
		return (EReference)parameterValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParameterValue_Value() {
		return (EAttribute)parameterValueEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDocumentedElement() {
		return documentedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentedElement_Documentation() {
		return (EAttribute)documentedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getResource() {
		return resourceEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EFacetFactory getEFacetFactory() {
		return (EFacetFactory)getEFactoryInstance();
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
		facetAttributeEClass = createEClass(FACET_ATTRIBUTE);

		facetReferenceEClass = createEClass(FACET_REFERENCE);

		facetOperationEClass = createEClass(FACET_OPERATION);

		facetSetEClass = createEClass(FACET_SET);
		createEReference(facetSetEClass, FACET_SET__CATEGORIES);

		facetEClass = createEClass(FACET);
		createEReference(facetEClass, FACET__EXTENDED_METACLASS);
		createEReference(facetEClass, FACET__FACET_ELEMENTS);
		createEReference(facetEClass, FACET__FACET_OPERATIONS);
		createEReference(facetEClass, FACET__CONFORMANCE_TYPED_ELEMENT);
		createEReference(facetEClass, FACET__EXTENDED_FACETS);

		categoryEClass = createEClass(CATEGORY);

		facetElementEClass = createEClass(FACET_ELEMENT);
		createEReference(facetElementEClass, FACET_ELEMENT__CATEGORIES);

		derivedTypedElementEClass = createEClass(DERIVED_TYPED_ELEMENT);
		createEReference(derivedTypedElementEClass, DERIVED_TYPED_ELEMENT__QUERY);
		createEReference(derivedTypedElementEClass, DERIVED_TYPED_ELEMENT__OVERRIDE);

		parameterValueEClass = createEClass(PARAMETER_VALUE);
		createEReference(parameterValueEClass, PARAMETER_VALUE__PARAMETER);
		createEAttribute(parameterValueEClass, PARAMETER_VALUE__VALUE);

		documentedElementEClass = createEClass(DOCUMENTED_ELEMENT);
		createEAttribute(documentedElementEClass, DOCUMENTED_ELEMENT__DOCUMENTATION);

		// Create data types
		resourceEDataType = createEDataType(RESOURCE);
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
		SerializationPackage theSerializationPackage = (SerializationPackage)EPackage.Registry.INSTANCE.getEPackage(SerializationPackage.eNS_URI);
		ExtensiblePackage theExtensiblePackage = (ExtensiblePackage)EPackage.Registry.INSTANCE.getEPackage(ExtensiblePackage.eNS_URI);
		QueryPackage theQueryPackage = (QueryPackage)EPackage.Registry.INSTANCE.getEPackage(QueryPackage.eNS_URI);
		RuntimePackage theRuntimePackage = (RuntimePackage)EPackage.Registry.INSTANCE.getEPackage(RuntimePackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theSerializationPackage);
		getESubpackages().add(theExtensiblePackage);
		getESubpackages().add(theQueryPackage);
		getESubpackages().add(theRuntimePackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		facetAttributeEClass.getESuperTypes().add(ecorePackage.getEAttribute());
		facetAttributeEClass.getESuperTypes().add(this.getDerivedTypedElement());
		facetReferenceEClass.getESuperTypes().add(ecorePackage.getEReference());
		facetReferenceEClass.getESuperTypes().add(this.getDerivedTypedElement());
		facetOperationEClass.getESuperTypes().add(ecorePackage.getEOperation());
		facetOperationEClass.getESuperTypes().add(this.getDerivedTypedElement());
		facetSetEClass.getESuperTypes().add(ecorePackage.getEPackage());
		facetSetEClass.getESuperTypes().add(this.getDocumentedElement());
		facetEClass.getESuperTypes().add(ecorePackage.getEClassifier());
		facetEClass.getESuperTypes().add(this.getDocumentedElement());
		categoryEClass.getESuperTypes().add(ecorePackage.getENamedElement());
		categoryEClass.getESuperTypes().add(this.getDocumentedElement());
		facetElementEClass.getESuperTypes().add(ecorePackage.getETypedElement());
		facetElementEClass.getESuperTypes().add(this.getDocumentedElement());
		derivedTypedElementEClass.getESuperTypes().add(this.getFacetElement());

		// Initialize classes and features; add operations and parameters
		initEClass(facetAttributeEClass, FacetAttribute.class, "FacetAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(facetReferenceEClass, FacetReference.class, "FacetReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(facetOperationEClass, FacetOperation.class, "FacetOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(facetSetEClass, FacetSet.class, "FacetSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getFacetSet_Categories(), this.getCategory(), null, "categories", null, 0, -1, FacetSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		addEOperation(facetSetEClass, this.getFacetSet(), "getFacetSets", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		initEClass(facetEClass, Facet.class, "Facet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getFacet_ExtendedMetaclass(), ecorePackage.getEClass(), null, "extendedMetaclass", null, 0, 1, Facet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getFacet_FacetElements(), ecorePackage.getEStructuralFeature(), null, "facetElements", null, 0, -1, Facet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getFacet_FacetOperations(), this.getFacetOperation(), null, "facetOperations", null, 0, -1, Facet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getFacet_ConformanceTypedElement(), ecorePackage.getETypedElement(), null, "conformanceTypedElement", null, 0, 1, Facet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getFacet_ExtendedFacets(), this.getFacet(), null, "extendedFacets", null, 0, -1, Facet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(categoryEClass, Category.class, "Category", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(facetElementEClass, FacetElement.class, "FacetElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getFacetElement_Categories(), this.getCategory(), null, "categories", null, 0, -1, FacetElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(derivedTypedElementEClass, DerivedTypedElement.class, "DerivedTypedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getDerivedTypedElement_Query(), theExtensiblePackage.getQuery(), null, "query", null, 1, 1, DerivedTypedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDerivedTypedElement_Override(), this.getDerivedTypedElement(), null, "override", null, 0, 1, DerivedTypedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(parameterValueEClass, ParameterValue.class, "ParameterValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getParameterValue_Parameter(), ecorePackage.getEParameter(), null, "parameter", null, 1, 1, ParameterValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getParameterValue_Value(), ecorePackage.getEJavaObject(), "value", null, 0, 1, ParameterValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(documentedElementEClass, DocumentedElement.class, "DocumentedElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getDocumentedElement_Documentation(), ecorePackage.getEString(), "documentation", null, 0, 1, DocumentedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		// Initialize data types
		initEDataType(resourceEDataType, Resource.class, "Resource", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
		// GenModel
		createGenModel_1Annotations();
		// org.eclipse.ocl.ecore.OCL
		createOrgAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEcoreAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore"; //$NON-NLS-1$		
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "validationDelegates", "org.eclipse.ocl.ecore.OCL" //$NON-NLS-1$ //$NON-NLS-2$
		   });							
		addAnnotation
		  (facetEClass, 
		   source, 
		   new String[] {
			 "validationDelegates", "( self.query.scope = self.facet.extendedMetaClass ) and ( self.query.name = self.name )" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (facetEClass, 
		   source, 
		   new String[] {
			 "validationDelegates", "self.conformanceQuery.scope = self.extendedMetaClass" //$NON-NLS-1$ //$NON-NLS-2$
		   });									
	}

	/**
	 * Initializes the annotations for <b>GenModel</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createGenModel_1Annotations() {
		String source = "GenModel"; //$NON-NLS-1$						
		addAnnotation
		  (facetSetEClass, 
		   source, 
		   new String[] {
			 "documentation", "A \"FacetSet\" is the root element of a facet model. It contains a list of \"Facet\"." //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
		   });		
		addAnnotation
		  (facetSetEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "documentation", "The FacetSets aggregated by this FacetSet (this operation is overridden in Aggregate in the aggregate metamodel)." //$NON-NLS-1$ //$NON-NLS-2$
		   });						
		addAnnotation
		  (getFacet_ExtendedMetaclass(), 
		   source, 
		   new String[] {
			 "documentation", "The \"extendedMetaclass\" reference references the virtually subtyped EClass." //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		   });			
		addAnnotation
		  (getFacet_ExtendedFacets(), 
		   source, 
		   new String[] {
			 "documentation", "A facet can extend other facets. If A facet A can extend a facet B. In this case an eObject conforms to the facet A if it matches conformance evaluation of A and B. " //$NON-NLS-1$ //$NON-NLS-2$
		   });					
	}

	/**
	 * Initializes the annotations for <b>org.eclipse.ocl.ecore.OCL</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createOrgAnnotations() {
		String source = "org.eclipse.ocl.ecore.OCL"; //$NON-NLS-1$											
		addAnnotation
		  (facetEClass, 
		   source, 
		   new String[] {
			 "body", "not(self.container().oclCastAs(FacetSet).facets->exists(f|f.extendedMetaClass.container() <> self.extendedMetaClass.container() ))" //$NON-NLS-1$ //$NON-NLS-2$
		   });								
	}

} //EFacetPackageImpl
