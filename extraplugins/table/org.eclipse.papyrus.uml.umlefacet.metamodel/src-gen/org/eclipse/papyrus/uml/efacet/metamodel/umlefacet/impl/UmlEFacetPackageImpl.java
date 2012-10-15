/**
 * Copyright (c) 2012 CEA LIST.
 * 
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.uml.efacet.metamodel.umlefacet.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.EFacetPackage;

import org.eclipse.papyrus.uml.efacet.metamodel.umlefacet.ProfileFacetSet;
import org.eclipse.papyrus.uml.efacet.metamodel.umlefacet.StereotypeFacet;
import org.eclipse.papyrus.uml.efacet.metamodel.umlefacet.StereotypePropertyElement;
import org.eclipse.papyrus.uml.efacet.metamodel.umlefacet.StereotypePropertyFacetAttribute;
import org.eclipse.papyrus.uml.efacet.metamodel.umlefacet.StereotypePropertyFacetReference;
import org.eclipse.papyrus.uml.efacet.metamodel.umlefacet.UmlEFacetFactory;
import org.eclipse.papyrus.uml.efacet.metamodel.umlefacet.UmlEFacetPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UmlEFacetPackageImpl extends EPackageImpl implements UmlEFacetPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass profileFacetSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stereotypeFacetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stereotypePropertyElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stereotypePropertyFacetReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stereotypePropertyFacetAttributeEClass = null;

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
	 * @see org.eclipse.papyrus.uml.efacet.metamodel.umlefacet.UmlEFacetPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private UmlEFacetPackageImpl() {
		super(eNS_URI, UmlEFacetFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link UmlEFacetPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static UmlEFacetPackage init() {
		if (isInited) return (UmlEFacetPackage)EPackage.Registry.INSTANCE.getEPackage(UmlEFacetPackage.eNS_URI);

		// Obtain or create and register package
		UmlEFacetPackageImpl theUmlEFacetPackage = (UmlEFacetPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof UmlEFacetPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new UmlEFacetPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EFacetPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theUmlEFacetPackage.createPackageContents();

		// Initialize created meta-data
		theUmlEFacetPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theUmlEFacetPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(UmlEFacetPackage.eNS_URI, theUmlEFacetPackage);
		return theUmlEFacetPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProfileFacetSet() {
		return profileFacetSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProfileFacetSet_ProfileQualifiedName() {
		return (EAttribute)profileFacetSetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStereotypeFacet() {
		return stereotypeFacetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStereotypeFacet_StereotypeQualifiedName() {
		return (EAttribute)stereotypeFacetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStereotypePropertyElement() {
		return stereotypePropertyElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStereotypePropertyElement_PropertyName() {
		return (EAttribute)stereotypePropertyElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStereotypePropertyElement_IsDerived() {
		return (EAttribute)stereotypePropertyElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStereotypePropertyFacetReference() {
		return stereotypePropertyFacetReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStereotypePropertyFacetAttribute() {
		return stereotypePropertyFacetAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UmlEFacetFactory getUmlEFacetFactory() {
		return (UmlEFacetFactory)getEFactoryInstance();
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
		profileFacetSetEClass = createEClass(PROFILE_FACET_SET);
		createEAttribute(profileFacetSetEClass, PROFILE_FACET_SET__PROFILE_QUALIFIED_NAME);

		stereotypeFacetEClass = createEClass(STEREOTYPE_FACET);
		createEAttribute(stereotypeFacetEClass, STEREOTYPE_FACET__STEREOTYPE_QUALIFIED_NAME);

		stereotypePropertyElementEClass = createEClass(STEREOTYPE_PROPERTY_ELEMENT);
		createEAttribute(stereotypePropertyElementEClass, STEREOTYPE_PROPERTY_ELEMENT__PROPERTY_NAME);
		createEAttribute(stereotypePropertyElementEClass, STEREOTYPE_PROPERTY_ELEMENT__IS_DERIVED);

		stereotypePropertyFacetReferenceEClass = createEClass(STEREOTYPE_PROPERTY_FACET_REFERENCE);

		stereotypePropertyFacetAttributeEClass = createEClass(STEREOTYPE_PROPERTY_FACET_ATTRIBUTE);
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

		// Set bounds for type parameters

		// Add supertypes to classes
		profileFacetSetEClass.getESuperTypes().add(theEFacetPackage.getFacetSet());
		stereotypeFacetEClass.getESuperTypes().add(theEFacetPackage.getFacet());
		stereotypePropertyElementEClass.getESuperTypes().add(theEFacetPackage.getFacetElement());
		stereotypePropertyFacetReferenceEClass.getESuperTypes().add(theEFacetPackage.getFacetReference());
		stereotypePropertyFacetReferenceEClass.getESuperTypes().add(this.getStereotypePropertyElement());
		stereotypePropertyFacetAttributeEClass.getESuperTypes().add(theEFacetPackage.getFacetAttribute());
		stereotypePropertyFacetAttributeEClass.getESuperTypes().add(this.getStereotypePropertyElement());

		// Initialize classes and features; add operations and parameters
		initEClass(profileFacetSetEClass, ProfileFacetSet.class, "ProfileFacetSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getProfileFacetSet_ProfileQualifiedName(), ecorePackage.getEString(), "profileQualifiedName", null, 1, 1, ProfileFacetSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		addEOperation(profileFacetSetEClass, this.getProfileFacetSet(), "getProfileFacetSet", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		initEClass(stereotypeFacetEClass, StereotypeFacet.class, "StereotypeFacet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getStereotypeFacet_StereotypeQualifiedName(), ecorePackage.getEString(), "stereotypeQualifiedName", null, 1, 1, StereotypeFacet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(stereotypePropertyElementEClass, StereotypePropertyElement.class, "StereotypePropertyElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getStereotypePropertyElement_PropertyName(), ecorePackage.getEString(), "propertyName", null, 1, 1, StereotypePropertyElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getStereotypePropertyElement_IsDerived(), ecorePackage.getEBoolean(), "isDerived", "false", 0, 1, StereotypePropertyElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(stereotypePropertyFacetReferenceEClass, StereotypePropertyFacetReference.class, "StereotypePropertyFacetReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(stereotypePropertyFacetAttributeEClass, StereotypePropertyFacetAttribute.class, "StereotypePropertyFacetAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		// Create resource
		createResource(eNS_URI);
	}

} //UmlEFacetPackageImpl
