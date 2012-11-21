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
package org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.facet.infra.facet.FacetPackage;

import org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.EObjectFacetRepresentation;
import org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.ProfileFacetFactory;
import org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.ProfileFacetPackage;
import org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.ProfileFacetSet;
import org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.StereotypeFacet;
import org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.StereotypePropertyElement;
import org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.StereotypePropertyFacetAttribute;
import org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.StereotypePropertyFacetReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ProfileFacetPackageImpl extends EPackageImpl implements ProfileFacetPackage {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eObjectFacetRepresentationEClass = null;

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
	 * @see org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.ProfileFacetPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ProfileFacetPackageImpl() {
		super(eNS_URI, ProfileFacetFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ProfileFacetPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ProfileFacetPackage init() {
		if (isInited) return (ProfileFacetPackage)EPackage.Registry.INSTANCE.getEPackage(ProfileFacetPackage.eNS_URI);

		// Obtain or create and register package
		ProfileFacetPackageImpl theProfileFacetPackage = (ProfileFacetPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ProfileFacetPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ProfileFacetPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		FacetPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theProfileFacetPackage.createPackageContents();

		// Initialize created meta-data
		theProfileFacetPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theProfileFacetPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ProfileFacetPackage.eNS_URI, theProfileFacetPackage);
		return theProfileFacetPackage;
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
	public EReference getProfileFacetSet_StereotypeFacets() {
		return (EReference)profileFacetSetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProfileFacetSet_SubProfileFacetSet() {
		return (EReference)profileFacetSetEClass.getEStructuralFeatures().get(2);
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
	public EReference getStereotypeFacet_StereotypeProperties() {
		return (EReference)stereotypeFacetEClass.getEStructuralFeatures().get(1);
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
	public EAttribute getStereotypePropertyElement_PropertyQualifiedName() {
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
	public EClass getEObjectFacetRepresentation() {
		return eObjectFacetRepresentationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEObjectFacetRepresentation_RepresentedElement_XMI_ID() {
		return (EAttribute)eObjectFacetRepresentationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProfileFacetFactory getProfileFacetFactory() {
		return (ProfileFacetFactory)getEFactoryInstance();
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
		createEReference(profileFacetSetEClass, PROFILE_FACET_SET__STEREOTYPE_FACETS);
		createEReference(profileFacetSetEClass, PROFILE_FACET_SET__SUB_PROFILE_FACET_SET);

		stereotypeFacetEClass = createEClass(STEREOTYPE_FACET);
		createEAttribute(stereotypeFacetEClass, STEREOTYPE_FACET__STEREOTYPE_QUALIFIED_NAME);
		createEReference(stereotypeFacetEClass, STEREOTYPE_FACET__STEREOTYPE_PROPERTIES);

		stereotypePropertyElementEClass = createEClass(STEREOTYPE_PROPERTY_ELEMENT);
		createEAttribute(stereotypePropertyElementEClass, STEREOTYPE_PROPERTY_ELEMENT__PROPERTY_QUALIFIED_NAME);
		createEAttribute(stereotypePropertyElementEClass, STEREOTYPE_PROPERTY_ELEMENT__IS_DERIVED);

		stereotypePropertyFacetReferenceEClass = createEClass(STEREOTYPE_PROPERTY_FACET_REFERENCE);

		stereotypePropertyFacetAttributeEClass = createEClass(STEREOTYPE_PROPERTY_FACET_ATTRIBUTE);

		eObjectFacetRepresentationEClass = createEClass(EOBJECT_FACET_REPRESENTATION);
		createEAttribute(eObjectFacetRepresentationEClass, EOBJECT_FACET_REPRESENTATION__REPRESENTED_ELEMENT_XMI_ID);
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
		FacetPackage theFacetPackage = (FacetPackage)EPackage.Registry.INSTANCE.getEPackage(FacetPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		profileFacetSetEClass.getESuperTypes().add(theFacetPackage.getFacetSet());
		profileFacetSetEClass.getESuperTypes().add(this.getEObjectFacetRepresentation());
		stereotypeFacetEClass.getESuperTypes().add(theFacetPackage.getFacet());
		stereotypeFacetEClass.getESuperTypes().add(this.getEObjectFacetRepresentation());
		stereotypePropertyElementEClass.getESuperTypes().add(theFacetPackage.getFacetStructuralFeature());
		stereotypePropertyElementEClass.getESuperTypes().add(this.getEObjectFacetRepresentation());
		stereotypePropertyFacetReferenceEClass.getESuperTypes().add(theFacetPackage.getFacetReference());
		stereotypePropertyFacetReferenceEClass.getESuperTypes().add(this.getStereotypePropertyElement());
		stereotypePropertyFacetAttributeEClass.getESuperTypes().add(theFacetPackage.getFacetAttribute());
		stereotypePropertyFacetAttributeEClass.getESuperTypes().add(this.getStereotypePropertyElement());
		eObjectFacetRepresentationEClass.getESuperTypes().add(theEcorePackage.getEObject());

		// Initialize classes and features; add operations and parameters
		initEClass(profileFacetSetEClass, ProfileFacetSet.class, "ProfileFacetSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getProfileFacetSet_ProfileQualifiedName(), ecorePackage.getEString(), "profileQualifiedName", null, 1, 1, ProfileFacetSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getProfileFacetSet_StereotypeFacets(), this.getStereotypeFacet(), null, "stereotypeFacets", null, 0, -1, ProfileFacetSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getProfileFacetSet_SubProfileFacetSet(), this.getProfileFacetSet(), null, "subProfileFacetSet", null, 0, -1, ProfileFacetSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(stereotypeFacetEClass, StereotypeFacet.class, "StereotypeFacet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getStereotypeFacet_StereotypeQualifiedName(), ecorePackage.getEString(), "stereotypeQualifiedName", null, 1, 1, StereotypeFacet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getStereotypeFacet_StereotypeProperties(), this.getStereotypePropertyElement(), null, "stereotypeProperties", null, 0, -1, StereotypeFacet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(stereotypePropertyElementEClass, StereotypePropertyElement.class, "StereotypePropertyElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getStereotypePropertyElement_PropertyQualifiedName(), ecorePackage.getEString(), "propertyQualifiedName", null, 1, 1, StereotypePropertyElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getStereotypePropertyElement_IsDerived(), ecorePackage.getEBoolean(), "isDerived", "false", 0, 1, StereotypePropertyElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(stereotypePropertyFacetReferenceEClass, StereotypePropertyFacetReference.class, "StereotypePropertyFacetReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(stereotypePropertyFacetAttributeEClass, StereotypePropertyFacetAttribute.class, "StereotypePropertyFacetAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(eObjectFacetRepresentationEClass, EObjectFacetRepresentation.class, "EObjectFacetRepresentation", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getEObjectFacetRepresentation_RepresentedElement_XMI_ID(), ecorePackage.getEString(), "representedElement_XMI_ID", null, 1, 1, EObjectFacetRepresentation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		// Create resource
		createResource(eNS_URI);
	}

} //ProfileFacetPackageImpl
