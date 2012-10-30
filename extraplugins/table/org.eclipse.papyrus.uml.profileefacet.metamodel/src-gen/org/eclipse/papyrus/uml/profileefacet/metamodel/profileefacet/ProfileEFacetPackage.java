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
package org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.EFacetPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.ProfileEFacetFactory
 * @model kind="package"
 * @generated
 */
public interface ProfileEFacetPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "profileefacet"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/0.9/profileefacet"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "profileefacet"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ProfileEFacetPackage eINSTANCE = org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.impl.ProfileEFacetPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.impl.ProfileFacetSetImpl <em>Profile Facet Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.impl.ProfileFacetSetImpl
	 * @see org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.impl.ProfileEFacetPackageImpl#getProfileFacetSet()
	 * @generated
	 */
	int PROFILE_FACET_SET = 0;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE_FACET_SET__EANNOTATIONS = EFacetPackage.FACET_SET__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE_FACET_SET__NAME = EFacetPackage.FACET_SET__NAME;

	/**
	 * The feature id for the '<em><b>Ns URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE_FACET_SET__NS_URI = EFacetPackage.FACET_SET__NS_URI;

	/**
	 * The feature id for the '<em><b>Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE_FACET_SET__NS_PREFIX = EFacetPackage.FACET_SET__NS_PREFIX;

	/**
	 * The feature id for the '<em><b>EFactory Instance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE_FACET_SET__EFACTORY_INSTANCE = EFacetPackage.FACET_SET__EFACTORY_INSTANCE;

	/**
	 * The feature id for the '<em><b>EClassifiers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE_FACET_SET__ECLASSIFIERS = EFacetPackage.FACET_SET__ECLASSIFIERS;

	/**
	 * The feature id for the '<em><b>ESubpackages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE_FACET_SET__ESUBPACKAGES = EFacetPackage.FACET_SET__ESUBPACKAGES;

	/**
	 * The feature id for the '<em><b>ESuper Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE_FACET_SET__ESUPER_PACKAGE = EFacetPackage.FACET_SET__ESUPER_PACKAGE;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE_FACET_SET__DOCUMENTATION = EFacetPackage.FACET_SET__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Categories</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE_FACET_SET__CATEGORIES = EFacetPackage.FACET_SET__CATEGORIES;

	/**
	 * The feature id for the '<em><b>Represented Element XMI ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE_FACET_SET__REPRESENTED_ELEMENT_XMI_ID = EFacetPackage.FACET_SET_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Profile Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE_FACET_SET__PROFILE_QUALIFIED_NAME = EFacetPackage.FACET_SET_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Profile Facet Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE_FACET_SET_FEATURE_COUNT = EFacetPackage.FACET_SET_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.impl.StereotypeFacetImpl <em>Stereotype Facet</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.impl.StereotypeFacetImpl
	 * @see org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.impl.ProfileEFacetPackageImpl#getStereotypeFacet()
	 * @generated
	 */
	int STEREOTYPE_FACET = 1;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_FACET__EANNOTATIONS = EFacetPackage.FACET__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_FACET__NAME = EFacetPackage.FACET__NAME;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_FACET__INSTANCE_CLASS_NAME = EFacetPackage.FACET__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Instance Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_FACET__INSTANCE_CLASS = EFacetPackage.FACET__INSTANCE_CLASS;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_FACET__DEFAULT_VALUE = EFacetPackage.FACET__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>Instance Type Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_FACET__INSTANCE_TYPE_NAME = EFacetPackage.FACET__INSTANCE_TYPE_NAME;

	/**
	 * The feature id for the '<em><b>EPackage</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_FACET__EPACKAGE = EFacetPackage.FACET__EPACKAGE;

	/**
	 * The feature id for the '<em><b>EType Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_FACET__ETYPE_PARAMETERS = EFacetPackage.FACET__ETYPE_PARAMETERS;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_FACET__DOCUMENTATION = EFacetPackage.FACET__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extended Metaclass</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_FACET__EXTENDED_METACLASS = EFacetPackage.FACET__EXTENDED_METACLASS;

	/**
	 * The feature id for the '<em><b>Facet Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_FACET__FACET_ELEMENTS = EFacetPackage.FACET__FACET_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Facet Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_FACET__FACET_OPERATIONS = EFacetPackage.FACET__FACET_OPERATIONS;

	/**
	 * The feature id for the '<em><b>Conformance Typed Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_FACET__CONFORMANCE_TYPED_ELEMENT = EFacetPackage.FACET__CONFORMANCE_TYPED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Extended Facets</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_FACET__EXTENDED_FACETS = EFacetPackage.FACET__EXTENDED_FACETS;

	/**
	 * The feature id for the '<em><b>Represented Element XMI ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_FACET__REPRESENTED_ELEMENT_XMI_ID = EFacetPackage.FACET_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Stereotype Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_FACET__STEREOTYPE_QUALIFIED_NAME = EFacetPackage.FACET_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Stereotype Facet</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_FACET_FEATURE_COUNT = EFacetPackage.FACET_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.impl.StereotypePropertyElementImpl <em>Stereotype Property Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.impl.StereotypePropertyElementImpl
	 * @see org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.impl.ProfileEFacetPackageImpl#getStereotypePropertyElement()
	 * @generated
	 */
	int STEREOTYPE_PROPERTY_ELEMENT = 2;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_ELEMENT__EANNOTATIONS = EFacetPackage.FACET_ELEMENT__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_ELEMENT__NAME = EFacetPackage.FACET_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_ELEMENT__ORDERED = EFacetPackage.FACET_ELEMENT__ORDERED;

	/**
	 * The feature id for the '<em><b>Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_ELEMENT__UNIQUE = EFacetPackage.FACET_ELEMENT__UNIQUE;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_ELEMENT__LOWER_BOUND = EFacetPackage.FACET_ELEMENT__LOWER_BOUND;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_ELEMENT__UPPER_BOUND = EFacetPackage.FACET_ELEMENT__UPPER_BOUND;

	/**
	 * The feature id for the '<em><b>Many</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_ELEMENT__MANY = EFacetPackage.FACET_ELEMENT__MANY;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_ELEMENT__REQUIRED = EFacetPackage.FACET_ELEMENT__REQUIRED;

	/**
	 * The feature id for the '<em><b>EType</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_ELEMENT__ETYPE = EFacetPackage.FACET_ELEMENT__ETYPE;

	/**
	 * The feature id for the '<em><b>EGeneric Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_ELEMENT__EGENERIC_TYPE = EFacetPackage.FACET_ELEMENT__EGENERIC_TYPE;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_ELEMENT__DOCUMENTATION = EFacetPackage.FACET_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Categories</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_ELEMENT__CATEGORIES = EFacetPackage.FACET_ELEMENT__CATEGORIES;

	/**
	 * The feature id for the '<em><b>Represented Element XMI ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_ELEMENT__REPRESENTED_ELEMENT_XMI_ID = EFacetPackage.FACET_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Property Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_ELEMENT__PROPERTY_NAME = EFacetPackage.FACET_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Is Derived</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_ELEMENT__IS_DERIVED = EFacetPackage.FACET_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Stereotype Property Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_ELEMENT_FEATURE_COUNT = EFacetPackage.FACET_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.impl.StereotypePropertyFacetReferenceImpl <em>Stereotype Property Facet Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.impl.StereotypePropertyFacetReferenceImpl
	 * @see org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.impl.ProfileEFacetPackageImpl#getStereotypePropertyFacetReference()
	 * @generated
	 */
	int STEREOTYPE_PROPERTY_FACET_REFERENCE = 3;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_REFERENCE__EANNOTATIONS = EFacetPackage.FACET_REFERENCE__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_REFERENCE__NAME = EFacetPackage.FACET_REFERENCE__NAME;

	/**
	 * The feature id for the '<em><b>Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_REFERENCE__ORDERED = EFacetPackage.FACET_REFERENCE__ORDERED;

	/**
	 * The feature id for the '<em><b>Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_REFERENCE__UNIQUE = EFacetPackage.FACET_REFERENCE__UNIQUE;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_REFERENCE__LOWER_BOUND = EFacetPackage.FACET_REFERENCE__LOWER_BOUND;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_REFERENCE__UPPER_BOUND = EFacetPackage.FACET_REFERENCE__UPPER_BOUND;

	/**
	 * The feature id for the '<em><b>Many</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_REFERENCE__MANY = EFacetPackage.FACET_REFERENCE__MANY;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_REFERENCE__REQUIRED = EFacetPackage.FACET_REFERENCE__REQUIRED;

	/**
	 * The feature id for the '<em><b>EType</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_REFERENCE__ETYPE = EFacetPackage.FACET_REFERENCE__ETYPE;

	/**
	 * The feature id for the '<em><b>EGeneric Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_REFERENCE__EGENERIC_TYPE = EFacetPackage.FACET_REFERENCE__EGENERIC_TYPE;

	/**
	 * The feature id for the '<em><b>Changeable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_REFERENCE__CHANGEABLE = EFacetPackage.FACET_REFERENCE__CHANGEABLE;

	/**
	 * The feature id for the '<em><b>Volatile</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_REFERENCE__VOLATILE = EFacetPackage.FACET_REFERENCE__VOLATILE;

	/**
	 * The feature id for the '<em><b>Transient</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_REFERENCE__TRANSIENT = EFacetPackage.FACET_REFERENCE__TRANSIENT;

	/**
	 * The feature id for the '<em><b>Default Value Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_REFERENCE__DEFAULT_VALUE_LITERAL = EFacetPackage.FACET_REFERENCE__DEFAULT_VALUE_LITERAL;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_REFERENCE__DEFAULT_VALUE = EFacetPackage.FACET_REFERENCE__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>Unsettable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_REFERENCE__UNSETTABLE = EFacetPackage.FACET_REFERENCE__UNSETTABLE;

	/**
	 * The feature id for the '<em><b>Derived</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_REFERENCE__DERIVED = EFacetPackage.FACET_REFERENCE__DERIVED;

	/**
	 * The feature id for the '<em><b>EContaining Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_REFERENCE__ECONTAINING_CLASS = EFacetPackage.FACET_REFERENCE__ECONTAINING_CLASS;

	/**
	 * The feature id for the '<em><b>Containment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_REFERENCE__CONTAINMENT = EFacetPackage.FACET_REFERENCE__CONTAINMENT;

	/**
	 * The feature id for the '<em><b>Container</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_REFERENCE__CONTAINER = EFacetPackage.FACET_REFERENCE__CONTAINER;

	/**
	 * The feature id for the '<em><b>Resolve Proxies</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_REFERENCE__RESOLVE_PROXIES = EFacetPackage.FACET_REFERENCE__RESOLVE_PROXIES;

	/**
	 * The feature id for the '<em><b>EOpposite</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_REFERENCE__EOPPOSITE = EFacetPackage.FACET_REFERENCE__EOPPOSITE;

	/**
	 * The feature id for the '<em><b>EReference Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_REFERENCE__EREFERENCE_TYPE = EFacetPackage.FACET_REFERENCE__EREFERENCE_TYPE;

	/**
	 * The feature id for the '<em><b>EKeys</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_REFERENCE__EKEYS = EFacetPackage.FACET_REFERENCE__EKEYS;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_REFERENCE__DOCUMENTATION = EFacetPackage.FACET_REFERENCE__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Categories</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_REFERENCE__CATEGORIES = EFacetPackage.FACET_REFERENCE__CATEGORIES;

	/**
	 * The feature id for the '<em><b>Query</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_REFERENCE__QUERY = EFacetPackage.FACET_REFERENCE__QUERY;

	/**
	 * The feature id for the '<em><b>Override</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_REFERENCE__OVERRIDE = EFacetPackage.FACET_REFERENCE__OVERRIDE;

	/**
	 * The feature id for the '<em><b>Represented Element XMI ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_REFERENCE__REPRESENTED_ELEMENT_XMI_ID = EFacetPackage.FACET_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Property Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_REFERENCE__PROPERTY_NAME = EFacetPackage.FACET_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Is Derived</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_REFERENCE__IS_DERIVED = EFacetPackage.FACET_REFERENCE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Stereotype Property Facet Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_REFERENCE_FEATURE_COUNT = EFacetPackage.FACET_REFERENCE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.impl.StereotypePropertyFacetAttributeImpl <em>Stereotype Property Facet Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.impl.StereotypePropertyFacetAttributeImpl
	 * @see org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.impl.ProfileEFacetPackageImpl#getStereotypePropertyFacetAttribute()
	 * @generated
	 */
	int STEREOTYPE_PROPERTY_FACET_ATTRIBUTE = 4;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__EANNOTATIONS = EFacetPackage.FACET_ATTRIBUTE__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__NAME = EFacetPackage.FACET_ATTRIBUTE__NAME;

	/**
	 * The feature id for the '<em><b>Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__ORDERED = EFacetPackage.FACET_ATTRIBUTE__ORDERED;

	/**
	 * The feature id for the '<em><b>Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__UNIQUE = EFacetPackage.FACET_ATTRIBUTE__UNIQUE;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__LOWER_BOUND = EFacetPackage.FACET_ATTRIBUTE__LOWER_BOUND;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__UPPER_BOUND = EFacetPackage.FACET_ATTRIBUTE__UPPER_BOUND;

	/**
	 * The feature id for the '<em><b>Many</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__MANY = EFacetPackage.FACET_ATTRIBUTE__MANY;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__REQUIRED = EFacetPackage.FACET_ATTRIBUTE__REQUIRED;

	/**
	 * The feature id for the '<em><b>EType</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__ETYPE = EFacetPackage.FACET_ATTRIBUTE__ETYPE;

	/**
	 * The feature id for the '<em><b>EGeneric Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__EGENERIC_TYPE = EFacetPackage.FACET_ATTRIBUTE__EGENERIC_TYPE;

	/**
	 * The feature id for the '<em><b>Changeable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__CHANGEABLE = EFacetPackage.FACET_ATTRIBUTE__CHANGEABLE;

	/**
	 * The feature id for the '<em><b>Volatile</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__VOLATILE = EFacetPackage.FACET_ATTRIBUTE__VOLATILE;

	/**
	 * The feature id for the '<em><b>Transient</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__TRANSIENT = EFacetPackage.FACET_ATTRIBUTE__TRANSIENT;

	/**
	 * The feature id for the '<em><b>Default Value Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__DEFAULT_VALUE_LITERAL = EFacetPackage.FACET_ATTRIBUTE__DEFAULT_VALUE_LITERAL;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__DEFAULT_VALUE = EFacetPackage.FACET_ATTRIBUTE__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>Unsettable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__UNSETTABLE = EFacetPackage.FACET_ATTRIBUTE__UNSETTABLE;

	/**
	 * The feature id for the '<em><b>Derived</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__DERIVED = EFacetPackage.FACET_ATTRIBUTE__DERIVED;

	/**
	 * The feature id for the '<em><b>EContaining Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__ECONTAINING_CLASS = EFacetPackage.FACET_ATTRIBUTE__ECONTAINING_CLASS;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__ID = EFacetPackage.FACET_ATTRIBUTE__ID;

	/**
	 * The feature id for the '<em><b>EAttribute Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__EATTRIBUTE_TYPE = EFacetPackage.FACET_ATTRIBUTE__EATTRIBUTE_TYPE;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__DOCUMENTATION = EFacetPackage.FACET_ATTRIBUTE__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Categories</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__CATEGORIES = EFacetPackage.FACET_ATTRIBUTE__CATEGORIES;

	/**
	 * The feature id for the '<em><b>Query</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__QUERY = EFacetPackage.FACET_ATTRIBUTE__QUERY;

	/**
	 * The feature id for the '<em><b>Override</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__OVERRIDE = EFacetPackage.FACET_ATTRIBUTE__OVERRIDE;

	/**
	 * The feature id for the '<em><b>Represented Element XMI ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__REPRESENTED_ELEMENT_XMI_ID = EFacetPackage.FACET_ATTRIBUTE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Property Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__PROPERTY_NAME = EFacetPackage.FACET_ATTRIBUTE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Is Derived</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__IS_DERIVED = EFacetPackage.FACET_ATTRIBUTE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Stereotype Property Facet Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_ATTRIBUTE_FEATURE_COUNT = EFacetPackage.FACET_ATTRIBUTE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.EObjectFacetRepresentation <em>EObject Facet Representation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.EObjectFacetRepresentation
	 * @see org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.impl.ProfileEFacetPackageImpl#getEObjectFacetRepresentation()
	 * @generated
	 */
	int EOBJECT_FACET_REPRESENTATION = 5;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOBJECT_FACET_REPRESENTATION__EANNOTATIONS = EcorePackage.EMODEL_ELEMENT__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Represented Element XMI ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOBJECT_FACET_REPRESENTATION__REPRESENTED_ELEMENT_XMI_ID = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>EObject Facet Representation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOBJECT_FACET_REPRESENTATION_FEATURE_COUNT = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.ProfileFacetSet <em>Profile Facet Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Profile Facet Set</em>'.
	 * @see org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.ProfileFacetSet
	 * @generated
	 */
	EClass getProfileFacetSet();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.ProfileFacetSet#getProfileQualifiedName <em>Profile Qualified Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Profile Qualified Name</em>'.
	 * @see org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.ProfileFacetSet#getProfileQualifiedName()
	 * @see #getProfileFacetSet()
	 * @generated
	 */
	EAttribute getProfileFacetSet_ProfileQualifiedName();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.StereotypeFacet <em>Stereotype Facet</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stereotype Facet</em>'.
	 * @see org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.StereotypeFacet
	 * @generated
	 */
	EClass getStereotypeFacet();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.StereotypeFacet#getStereotypeQualifiedName <em>Stereotype Qualified Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stereotype Qualified Name</em>'.
	 * @see org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.StereotypeFacet#getStereotypeQualifiedName()
	 * @see #getStereotypeFacet()
	 * @generated
	 */
	EAttribute getStereotypeFacet_StereotypeQualifiedName();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.StereotypePropertyElement <em>Stereotype Property Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stereotype Property Element</em>'.
	 * @see org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.StereotypePropertyElement
	 * @generated
	 */
	EClass getStereotypePropertyElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.StereotypePropertyElement#getPropertyName <em>Property Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Property Name</em>'.
	 * @see org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.StereotypePropertyElement#getPropertyName()
	 * @see #getStereotypePropertyElement()
	 * @generated
	 */
	EAttribute getStereotypePropertyElement_PropertyName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.StereotypePropertyElement#isIsDerived <em>Is Derived</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Derived</em>'.
	 * @see org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.StereotypePropertyElement#isIsDerived()
	 * @see #getStereotypePropertyElement()
	 * @generated
	 */
	EAttribute getStereotypePropertyElement_IsDerived();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.StereotypePropertyFacetReference <em>Stereotype Property Facet Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stereotype Property Facet Reference</em>'.
	 * @see org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.StereotypePropertyFacetReference
	 * @generated
	 */
	EClass getStereotypePropertyFacetReference();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.StereotypePropertyFacetAttribute <em>Stereotype Property Facet Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stereotype Property Facet Attribute</em>'.
	 * @see org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.StereotypePropertyFacetAttribute
	 * @generated
	 */
	EClass getStereotypePropertyFacetAttribute();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.EObjectFacetRepresentation <em>EObject Facet Representation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EObject Facet Representation</em>'.
	 * @see org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.EObjectFacetRepresentation
	 * @generated
	 */
	EClass getEObjectFacetRepresentation();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.EObjectFacetRepresentation#getRepresentedElement_XMI_ID <em>Represented Element XMI ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Represented Element XMI ID</em>'.
	 * @see org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.EObjectFacetRepresentation#getRepresentedElement_XMI_ID()
	 * @see #getEObjectFacetRepresentation()
	 * @generated
	 */
	EAttribute getEObjectFacetRepresentation_RepresentedElement_XMI_ID();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ProfileEFacetFactory getProfileEFacetFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.impl.ProfileFacetSetImpl <em>Profile Facet Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.impl.ProfileFacetSetImpl
		 * @see org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.impl.ProfileEFacetPackageImpl#getProfileFacetSet()
		 * @generated
		 */
		EClass PROFILE_FACET_SET = eINSTANCE.getProfileFacetSet();

		/**
		 * The meta object literal for the '<em><b>Profile Qualified Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROFILE_FACET_SET__PROFILE_QUALIFIED_NAME = eINSTANCE.getProfileFacetSet_ProfileQualifiedName();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.impl.StereotypeFacetImpl <em>Stereotype Facet</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.impl.StereotypeFacetImpl
		 * @see org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.impl.ProfileEFacetPackageImpl#getStereotypeFacet()
		 * @generated
		 */
		EClass STEREOTYPE_FACET = eINSTANCE.getStereotypeFacet();

		/**
		 * The meta object literal for the '<em><b>Stereotype Qualified Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STEREOTYPE_FACET__STEREOTYPE_QUALIFIED_NAME = eINSTANCE.getStereotypeFacet_StereotypeQualifiedName();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.impl.StereotypePropertyElementImpl <em>Stereotype Property Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.impl.StereotypePropertyElementImpl
		 * @see org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.impl.ProfileEFacetPackageImpl#getStereotypePropertyElement()
		 * @generated
		 */
		EClass STEREOTYPE_PROPERTY_ELEMENT = eINSTANCE.getStereotypePropertyElement();

		/**
		 * The meta object literal for the '<em><b>Property Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STEREOTYPE_PROPERTY_ELEMENT__PROPERTY_NAME = eINSTANCE.getStereotypePropertyElement_PropertyName();

		/**
		 * The meta object literal for the '<em><b>Is Derived</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STEREOTYPE_PROPERTY_ELEMENT__IS_DERIVED = eINSTANCE.getStereotypePropertyElement_IsDerived();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.impl.StereotypePropertyFacetReferenceImpl <em>Stereotype Property Facet Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.impl.StereotypePropertyFacetReferenceImpl
		 * @see org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.impl.ProfileEFacetPackageImpl#getStereotypePropertyFacetReference()
		 * @generated
		 */
		EClass STEREOTYPE_PROPERTY_FACET_REFERENCE = eINSTANCE.getStereotypePropertyFacetReference();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.impl.StereotypePropertyFacetAttributeImpl <em>Stereotype Property Facet Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.impl.StereotypePropertyFacetAttributeImpl
		 * @see org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.impl.ProfileEFacetPackageImpl#getStereotypePropertyFacetAttribute()
		 * @generated
		 */
		EClass STEREOTYPE_PROPERTY_FACET_ATTRIBUTE = eINSTANCE.getStereotypePropertyFacetAttribute();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.EObjectFacetRepresentation <em>EObject Facet Representation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.EObjectFacetRepresentation
		 * @see org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.impl.ProfileEFacetPackageImpl#getEObjectFacetRepresentation()
		 * @generated
		 */
		EClass EOBJECT_FACET_REPRESENTATION = eINSTANCE.getEObjectFacetRepresentation();

		/**
		 * The meta object literal for the '<em><b>Represented Element XMI ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EOBJECT_FACET_REPRESENTATION__REPRESENTED_ELEMENT_XMI_ID = eINSTANCE.getEObjectFacetRepresentation_RepresentedElement_XMI_ID();

	}

} //ProfileEFacetPackage
