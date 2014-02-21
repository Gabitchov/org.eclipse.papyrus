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
 *       Gregoire Dupe (Mia-Software) - Bug 369987 - [Restructuring][Table] Switch to the new customization and facet framework
 *       Gregoire Dupe (Mia-Software) - Bug 373078 - API Cleaning 
 */
package org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.EFacetPackage;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.ExtensiblePackage;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.CustomFactory;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.CustomPackage;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.Customization;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.EClassCustomization;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.ETypedElementCase;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.ETypedElementSwitchQuery;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.FacetCustomization;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CustomPackageImpl extends EPackageImpl implements CustomPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass customizationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eClassCustomizationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass facetCustomizationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eTypedElementSwitchQueryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eTypedElementCaseEClass = null;

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
	 * @see org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.CustomPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CustomPackageImpl() {
		super(eNS_URI, CustomFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link CustomPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CustomPackage init() {
		if (isInited) return (CustomPackage)EPackage.Registry.INSTANCE.getEPackage(CustomPackage.eNS_URI);

		// Obtain or create and register package
		CustomPackageImpl theCustomPackage = (CustomPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CustomPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CustomPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EFacetPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theCustomPackage.createPackageContents();

		// Initialize created meta-data
		theCustomPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCustomPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CustomPackage.eNS_URI, theCustomPackage);
		return theCustomPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCustomization() {
		return customizationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCustomization_MustBeLoadedByDefault() {
		return (EAttribute)customizationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEClassCustomization() {
		return eClassCustomizationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFacetCustomization() {
		return facetCustomizationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFacetCustomization_CustomizedFacet() {
		return (EReference)facetCustomizationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getETypedElementSwitchQuery() {
		return eTypedElementSwitchQueryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getETypedElementSwitchQuery_Cases() {
		return (EReference)eTypedElementSwitchQueryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getETypedElementCase() {
		return eTypedElementCaseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getETypedElementCase_Case() {
		return (EReference)eTypedElementCaseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getETypedElementCase_Value() {
		return (EReference)eTypedElementCaseEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CustomFactory getCustomFactory() {
		return (CustomFactory)getEFactoryInstance();
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
		customizationEClass = createEClass(CUSTOMIZATION);
		createEAttribute(customizationEClass, CUSTOMIZATION__MUST_BE_LOADED_BY_DEFAULT);

		eClassCustomizationEClass = createEClass(ECLASS_CUSTOMIZATION);

		facetCustomizationEClass = createEClass(FACET_CUSTOMIZATION);
		createEReference(facetCustomizationEClass, FACET_CUSTOMIZATION__CUSTOMIZED_FACET);

		eTypedElementSwitchQueryEClass = createEClass(ETYPED_ELEMENT_SWITCH_QUERY);
		createEReference(eTypedElementSwitchQueryEClass, ETYPED_ELEMENT_SWITCH_QUERY__CASES);

		eTypedElementCaseEClass = createEClass(ETYPED_ELEMENT_CASE);
		createEReference(eTypedElementCaseEClass, ETYPED_ELEMENT_CASE__CASE);
		createEReference(eTypedElementCaseEClass, ETYPED_ELEMENT_CASE__VALUE);
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
		ExtensiblePackage theExtensiblePackage = (ExtensiblePackage)EPackage.Registry.INSTANCE.getEPackage(ExtensiblePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		customizationEClass.getESuperTypes().add(theEFacetPackage.getFacetSet());
		eClassCustomizationEClass.getESuperTypes().add(theEFacetPackage.getFacet());
		facetCustomizationEClass.getESuperTypes().add(theEFacetPackage.getFacet());
		eTypedElementSwitchQueryEClass.getESuperTypes().add(theExtensiblePackage.getQuery());

		// Initialize classes and features; add operations and parameters
		initEClass(customizationEClass, Customization.class, "Customization", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCustomization_MustBeLoadedByDefault(), ecorePackage.getEBoolean(), "mustBeLoadedByDefault", "false", 1, 1, Customization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eClassCustomizationEClass, EClassCustomization.class, "EClassCustomization", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(facetCustomizationEClass, FacetCustomization.class, "FacetCustomization", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFacetCustomization_CustomizedFacet(), theEFacetPackage.getFacet(), null, "customizedFacet", null, 1, 1, FacetCustomization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eTypedElementSwitchQueryEClass, ETypedElementSwitchQuery.class, "ETypedElementSwitchQuery", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getETypedElementSwitchQuery_Cases(), this.getETypedElementCase(), null, "cases", null, 0, -1, ETypedElementSwitchQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eTypedElementCaseEClass, ETypedElementCase.class, "ETypedElementCase", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getETypedElementCase_Case(), ecorePackage.getETypedElement(), null, "case", null, 1, 1, ETypedElementCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getETypedElementCase_Value(), theExtensiblePackage.getQuery(), null, "value", null, 0, 1, ETypedElementCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //CustomPackageImpl
