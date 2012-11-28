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
package org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.ProfileFacetFactory
 * @model kind="package"
 * @generated
 */
public interface ProfileFacetPackage extends EPackage {

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "profilefacet"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/0.9/profilefacet"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "profilefacet"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ProfileFacetPackage eINSTANCE = org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.impl.ProfileFacetPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.impl.ProfileFacetSetImpl <em>Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.impl.ProfileFacetSetImpl
	 * @see org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.impl.ProfileFacetPackageImpl#getProfileFacetSet()
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
	int PROFILE_FACET_SET__EANNOTATIONS = EcorePackage.EPACKAGE__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE_FACET_SET__NAME = EcorePackage.EPACKAGE__NAME;

	/**
	 * The feature id for the '<em><b>Ns URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE_FACET_SET__NS_URI = EcorePackage.EPACKAGE__NS_URI;

	/**
	 * The feature id for the '<em><b>Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE_FACET_SET__NS_PREFIX = EcorePackage.EPACKAGE__NS_PREFIX;

	/**
	 * The feature id for the '<em><b>EFactory Instance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE_FACET_SET__EFACTORY_INSTANCE = EcorePackage.EPACKAGE__EFACTORY_INSTANCE;

	/**
	 * The feature id for the '<em><b>EClassifiers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE_FACET_SET__ECLASSIFIERS = EcorePackage.EPACKAGE__ECLASSIFIERS;

	/**
	 * The feature id for the '<em><b>ESubpackages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE_FACET_SET__ESUBPACKAGES = EcorePackage.EPACKAGE__ESUBPACKAGES;

	/**
	 * The feature id for the '<em><b>ESuper Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE_FACET_SET__ESUPER_PACKAGE = EcorePackage.EPACKAGE__ESUPER_PACKAGE;

	/**
	 * The feature id for the '<em><b>Represented Element XMI ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE_FACET_SET__REPRESENTED_ELEMENT_XMI_ID = EcorePackage.EPACKAGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extended Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE_FACET_SET__EXTENDED_PACKAGE = EcorePackage.EPACKAGE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Facets</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE_FACET_SET__FACETS = EcorePackage.EPACKAGE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Profile Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE_FACET_SET__PROFILE_QUALIFIED_NAME = EcorePackage.EPACKAGE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE_FACET_SET_FEATURE_COUNT = EcorePackage.EPACKAGE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.impl.StereotypeFacetImpl <em>Stereotype Facet</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.impl.StereotypeFacetImpl
	 * @see org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.impl.ProfileFacetPackageImpl#getStereotypeFacet()
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
	int STEREOTYPE_FACET__EANNOTATIONS = EcorePackage.ECLASS__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_FACET__NAME = EcorePackage.ECLASS__NAME;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_FACET__INSTANCE_CLASS_NAME = EcorePackage.ECLASS__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Instance Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_FACET__INSTANCE_CLASS = EcorePackage.ECLASS__INSTANCE_CLASS;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_FACET__DEFAULT_VALUE = EcorePackage.ECLASS__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>Instance Type Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_FACET__INSTANCE_TYPE_NAME = EcorePackage.ECLASS__INSTANCE_TYPE_NAME;

	/**
	 * The feature id for the '<em><b>EPackage</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_FACET__EPACKAGE = EcorePackage.ECLASS__EPACKAGE;

	/**
	 * The feature id for the '<em><b>EType Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_FACET__ETYPE_PARAMETERS = EcorePackage.ECLASS__ETYPE_PARAMETERS;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_FACET__ABSTRACT = EcorePackage.ECLASS__ABSTRACT;

	/**
	 * The feature id for the '<em><b>Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_FACET__INTERFACE = EcorePackage.ECLASS__INTERFACE;

	/**
	 * The feature id for the '<em><b>ESuper Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_FACET__ESUPER_TYPES = EcorePackage.ECLASS__ESUPER_TYPES;

	/**
	 * The feature id for the '<em><b>EOperations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_FACET__EOPERATIONS = EcorePackage.ECLASS__EOPERATIONS;

	/**
	 * The feature id for the '<em><b>EAll Attributes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_FACET__EALL_ATTRIBUTES = EcorePackage.ECLASS__EALL_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>EAll References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_FACET__EALL_REFERENCES = EcorePackage.ECLASS__EALL_REFERENCES;

	/**
	 * The feature id for the '<em><b>EReferences</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_FACET__EREFERENCES = EcorePackage.ECLASS__EREFERENCES;

	/**
	 * The feature id for the '<em><b>EAttributes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_FACET__EATTRIBUTES = EcorePackage.ECLASS__EATTRIBUTES;

	/**
	 * The feature id for the '<em><b>EAll Containments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_FACET__EALL_CONTAINMENTS = EcorePackage.ECLASS__EALL_CONTAINMENTS;

	/**
	 * The feature id for the '<em><b>EAll Operations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_FACET__EALL_OPERATIONS = EcorePackage.ECLASS__EALL_OPERATIONS;

	/**
	 * The feature id for the '<em><b>EAll Structural Features</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_FACET__EALL_STRUCTURAL_FEATURES = EcorePackage.ECLASS__EALL_STRUCTURAL_FEATURES;

	/**
	 * The feature id for the '<em><b>EAll Super Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_FACET__EALL_SUPER_TYPES = EcorePackage.ECLASS__EALL_SUPER_TYPES;

	/**
	 * The feature id for the '<em><b>EID Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_FACET__EID_ATTRIBUTE = EcorePackage.ECLASS__EID_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>EStructural Features</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_FACET__ESTRUCTURAL_FEATURES = EcorePackage.ECLASS__ESTRUCTURAL_FEATURES;

	/**
	 * The feature id for the '<em><b>EGeneric Super Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_FACET__EGENERIC_SUPER_TYPES = EcorePackage.ECLASS__EGENERIC_SUPER_TYPES;

	/**
	 * The feature id for the '<em><b>EAll Generic Super Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_FACET__EALL_GENERIC_SUPER_TYPES = EcorePackage.ECLASS__EALL_GENERIC_SUPER_TYPES;

	/**
	 * The feature id for the '<em><b>Represented Element XMI ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_FACET__REPRESENTED_ELEMENT_XMI_ID = EcorePackage.ECLASS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Condition Query</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_FACET__CONDITION_QUERY = EcorePackage.ECLASS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Facet Set</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_FACET__FACET_SET = EcorePackage.ECLASS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Stereotype Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_FACET__STEREOTYPE_QUALIFIED_NAME = EcorePackage.ECLASS_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Stereotype Facet</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_FACET_FEATURE_COUNT = EcorePackage.ECLASS_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.impl.StereotypePropertyElementImpl <em>Stereotype Property Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.impl.StereotypePropertyElementImpl
	 * @see org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.impl.ProfileFacetPackageImpl#getStereotypePropertyElement()
	 * @generated
	 */
	int STEREOTYPE_PROPERTY_ELEMENT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.impl.StereotypePropertyFacetReferenceImpl <em>Stereotype Property Facet Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.impl.StereotypePropertyFacetReferenceImpl
	 * @see org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.impl.ProfileFacetPackageImpl#getStereotypePropertyFacetReference()
	 * @generated
	 */
	int STEREOTYPE_PROPERTY_FACET_REFERENCE = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.impl.StereotypePropertyFacetAttributeImpl <em>Stereotype Property Facet Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.impl.StereotypePropertyFacetAttributeImpl
	 * @see org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.impl.ProfileFacetPackageImpl#getStereotypePropertyFacetAttribute()
	 * @generated
	 */
	int STEREOTYPE_PROPERTY_FACET_ATTRIBUTE = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.EObjectFacetRepresentation <em>EObject Facet Representation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.EObjectFacetRepresentation
	 * @see org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.impl.ProfileFacetPackageImpl#getEObjectFacetRepresentation()
	 * @generated
	 */
	int EOBJECT_FACET_REPRESENTATION = 5;

	/**
	 * The feature id for the '<em><b>Represented Element XMI ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOBJECT_FACET_REPRESENTATION__REPRESENTED_ELEMENT_XMI_ID = EcorePackage.EOBJECT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>EObject Facet Representation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOBJECT_FACET_REPRESENTATION_FEATURE_COUNT = EcorePackage.EOBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Represented Element XMI ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_ELEMENT__REPRESENTED_ELEMENT_XMI_ID = EOBJECT_FACET_REPRESENTATION__REPRESENTED_ELEMENT_XMI_ID;

	/**
	 * The feature id for the '<em><b>Value Query</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_ELEMENT__VALUE_QUERY = EOBJECT_FACET_REPRESENTATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Set Query</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_ELEMENT__SET_QUERY = EOBJECT_FACET_REPRESENTATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Property Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_ELEMENT__PROPERTY_QUALIFIED_NAME = EOBJECT_FACET_REPRESENTATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Is Derived</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_ELEMENT__IS_DERIVED = EOBJECT_FACET_REPRESENTATION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Stereotype Property Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_ELEMENT_FEATURE_COUNT = EOBJECT_FACET_REPRESENTATION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_REFERENCE__EANNOTATIONS = EcorePackage.EREFERENCE__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_REFERENCE__NAME = EcorePackage.EREFERENCE__NAME;

	/**
	 * The feature id for the '<em><b>Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_REFERENCE__ORDERED = EcorePackage.EREFERENCE__ORDERED;

	/**
	 * The feature id for the '<em><b>Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_REFERENCE__UNIQUE = EcorePackage.EREFERENCE__UNIQUE;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_REFERENCE__LOWER_BOUND = EcorePackage.EREFERENCE__LOWER_BOUND;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_REFERENCE__UPPER_BOUND = EcorePackage.EREFERENCE__UPPER_BOUND;

	/**
	 * The feature id for the '<em><b>Many</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_REFERENCE__MANY = EcorePackage.EREFERENCE__MANY;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_REFERENCE__REQUIRED = EcorePackage.EREFERENCE__REQUIRED;

	/**
	 * The feature id for the '<em><b>EType</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_REFERENCE__ETYPE = EcorePackage.EREFERENCE__ETYPE;

	/**
	 * The feature id for the '<em><b>EGeneric Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_REFERENCE__EGENERIC_TYPE = EcorePackage.EREFERENCE__EGENERIC_TYPE;

	/**
	 * The feature id for the '<em><b>Changeable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_REFERENCE__CHANGEABLE = EcorePackage.EREFERENCE__CHANGEABLE;

	/**
	 * The feature id for the '<em><b>Volatile</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_REFERENCE__VOLATILE = EcorePackage.EREFERENCE__VOLATILE;

	/**
	 * The feature id for the '<em><b>Transient</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_REFERENCE__TRANSIENT = EcorePackage.EREFERENCE__TRANSIENT;

	/**
	 * The feature id for the '<em><b>Default Value Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_REFERENCE__DEFAULT_VALUE_LITERAL = EcorePackage.EREFERENCE__DEFAULT_VALUE_LITERAL;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_REFERENCE__DEFAULT_VALUE = EcorePackage.EREFERENCE__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>Unsettable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_REFERENCE__UNSETTABLE = EcorePackage.EREFERENCE__UNSETTABLE;

	/**
	 * The feature id for the '<em><b>Derived</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_REFERENCE__DERIVED = EcorePackage.EREFERENCE__DERIVED;

	/**
	 * The feature id for the '<em><b>EContaining Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_REFERENCE__ECONTAINING_CLASS = EcorePackage.EREFERENCE__ECONTAINING_CLASS;

	/**
	 * The feature id for the '<em><b>Containment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_REFERENCE__CONTAINMENT = EcorePackage.EREFERENCE__CONTAINMENT;

	/**
	 * The feature id for the '<em><b>Container</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_REFERENCE__CONTAINER = EcorePackage.EREFERENCE__CONTAINER;

	/**
	 * The feature id for the '<em><b>Resolve Proxies</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_REFERENCE__RESOLVE_PROXIES = EcorePackage.EREFERENCE__RESOLVE_PROXIES;

	/**
	 * The feature id for the '<em><b>EOpposite</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_REFERENCE__EOPPOSITE = EcorePackage.EREFERENCE__EOPPOSITE;

	/**
	 * The feature id for the '<em><b>EReference Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_REFERENCE__EREFERENCE_TYPE = EcorePackage.EREFERENCE__EREFERENCE_TYPE;

	/**
	 * The feature id for the '<em><b>EKeys</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_REFERENCE__EKEYS = EcorePackage.EREFERENCE__EKEYS;

	/**
	 * The feature id for the '<em><b>Represented Element XMI ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_REFERENCE__REPRESENTED_ELEMENT_XMI_ID = EcorePackage.EREFERENCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value Query</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_REFERENCE__VALUE_QUERY = EcorePackage.EREFERENCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Set Query</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_REFERENCE__SET_QUERY = EcorePackage.EREFERENCE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Property Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_REFERENCE__PROPERTY_QUALIFIED_NAME = EcorePackage.EREFERENCE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Is Derived</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_REFERENCE__IS_DERIVED = EcorePackage.EREFERENCE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Stereotype Property Facet Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_REFERENCE_FEATURE_COUNT = EcorePackage.EREFERENCE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__EANNOTATIONS = EcorePackage.EATTRIBUTE__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__NAME = EcorePackage.EATTRIBUTE__NAME;

	/**
	 * The feature id for the '<em><b>Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__ORDERED = EcorePackage.EATTRIBUTE__ORDERED;

	/**
	 * The feature id for the '<em><b>Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__UNIQUE = EcorePackage.EATTRIBUTE__UNIQUE;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__LOWER_BOUND = EcorePackage.EATTRIBUTE__LOWER_BOUND;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__UPPER_BOUND = EcorePackage.EATTRIBUTE__UPPER_BOUND;

	/**
	 * The feature id for the '<em><b>Many</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__MANY = EcorePackage.EATTRIBUTE__MANY;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__REQUIRED = EcorePackage.EATTRIBUTE__REQUIRED;

	/**
	 * The feature id for the '<em><b>EType</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__ETYPE = EcorePackage.EATTRIBUTE__ETYPE;

	/**
	 * The feature id for the '<em><b>EGeneric Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__EGENERIC_TYPE = EcorePackage.EATTRIBUTE__EGENERIC_TYPE;

	/**
	 * The feature id for the '<em><b>Changeable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__CHANGEABLE = EcorePackage.EATTRIBUTE__CHANGEABLE;

	/**
	 * The feature id for the '<em><b>Volatile</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__VOLATILE = EcorePackage.EATTRIBUTE__VOLATILE;

	/**
	 * The feature id for the '<em><b>Transient</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__TRANSIENT = EcorePackage.EATTRIBUTE__TRANSIENT;

	/**
	 * The feature id for the '<em><b>Default Value Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__DEFAULT_VALUE_LITERAL = EcorePackage.EATTRIBUTE__DEFAULT_VALUE_LITERAL;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__DEFAULT_VALUE = EcorePackage.EATTRIBUTE__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>Unsettable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__UNSETTABLE = EcorePackage.EATTRIBUTE__UNSETTABLE;

	/**
	 * The feature id for the '<em><b>Derived</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__DERIVED = EcorePackage.EATTRIBUTE__DERIVED;

	/**
	 * The feature id for the '<em><b>EContaining Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__ECONTAINING_CLASS = EcorePackage.EATTRIBUTE__ECONTAINING_CLASS;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__ID = EcorePackage.EATTRIBUTE__ID;

	/**
	 * The feature id for the '<em><b>EAttribute Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__EATTRIBUTE_TYPE = EcorePackage.EATTRIBUTE__EATTRIBUTE_TYPE;

	/**
	 * The feature id for the '<em><b>Represented Element XMI ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__REPRESENTED_ELEMENT_XMI_ID = EcorePackage.EATTRIBUTE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value Query</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__VALUE_QUERY = EcorePackage.EATTRIBUTE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Set Query</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__SET_QUERY = EcorePackage.EATTRIBUTE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Property Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__PROPERTY_QUALIFIED_NAME = EcorePackage.EATTRIBUTE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Is Derived</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__IS_DERIVED = EcorePackage.EATTRIBUTE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Stereotype Property Facet Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_PROPERTY_FACET_ATTRIBUTE_FEATURE_COUNT = EcorePackage.EATTRIBUTE_FEATURE_COUNT + 5;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.ProfileFacetSet <em>Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set</em>'.
	 * @see org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.ProfileFacetSet
	 * @generated
	 */
	EClass getProfileFacetSet();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.ProfileFacetSet#getProfileQualifiedName <em>Profile Qualified Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Profile Qualified Name</em>'.
	 * @see org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.ProfileFacetSet#getProfileQualifiedName()
	 * @see #getProfileFacetSet()
	 * @generated
	 */
	EAttribute getProfileFacetSet_ProfileQualifiedName();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.StereotypeFacet <em>Stereotype Facet</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stereotype Facet</em>'.
	 * @see org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.StereotypeFacet
	 * @generated
	 */
	EClass getStereotypeFacet();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.StereotypeFacet#getStereotypeQualifiedName <em>Stereotype Qualified Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stereotype Qualified Name</em>'.
	 * @see org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.StereotypeFacet#getStereotypeQualifiedName()
	 * @see #getStereotypeFacet()
	 * @generated
	 */
	EAttribute getStereotypeFacet_StereotypeQualifiedName();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.StereotypePropertyElement <em>Stereotype Property Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stereotype Property Element</em>'.
	 * @see org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.StereotypePropertyElement
	 * @generated
	 */
	EClass getStereotypePropertyElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.StereotypePropertyElement#getPropertyQualifiedName <em>Property Qualified Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Property Qualified Name</em>'.
	 * @see org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.StereotypePropertyElement#getPropertyQualifiedName()
	 * @see #getStereotypePropertyElement()
	 * @generated
	 */
	EAttribute getStereotypePropertyElement_PropertyQualifiedName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.StereotypePropertyElement#isIsDerived <em>Is Derived</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Derived</em>'.
	 * @see org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.StereotypePropertyElement#isIsDerived()
	 * @see #getStereotypePropertyElement()
	 * @generated
	 */
	EAttribute getStereotypePropertyElement_IsDerived();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.StereotypePropertyFacetReference <em>Stereotype Property Facet Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stereotype Property Facet Reference</em>'.
	 * @see org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.StereotypePropertyFacetReference
	 * @generated
	 */
	EClass getStereotypePropertyFacetReference();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.StereotypePropertyFacetAttribute <em>Stereotype Property Facet Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stereotype Property Facet Attribute</em>'.
	 * @see org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.StereotypePropertyFacetAttribute
	 * @generated
	 */
	EClass getStereotypePropertyFacetAttribute();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.EObjectFacetRepresentation <em>EObject Facet Representation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EObject Facet Representation</em>'.
	 * @see org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.EObjectFacetRepresentation
	 * @generated
	 */
	EClass getEObjectFacetRepresentation();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.EObjectFacetRepresentation#getRepresentedElement_XMI_ID <em>Represented Element XMI ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Represented Element XMI ID</em>'.
	 * @see org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.EObjectFacetRepresentation#getRepresentedElement_XMI_ID()
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
	ProfileFacetFactory getProfileFacetFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.impl.ProfileFacetSetImpl <em>Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.impl.ProfileFacetSetImpl
		 * @see org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.impl.ProfileFacetPackageImpl#getProfileFacetSet()
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
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.impl.StereotypeFacetImpl <em>Stereotype Facet</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.impl.StereotypeFacetImpl
		 * @see org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.impl.ProfileFacetPackageImpl#getStereotypeFacet()
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
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.impl.StereotypePropertyElementImpl <em>Stereotype Property Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.impl.StereotypePropertyElementImpl
		 * @see org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.impl.ProfileFacetPackageImpl#getStereotypePropertyElement()
		 * @generated
		 */
		EClass STEREOTYPE_PROPERTY_ELEMENT = eINSTANCE.getStereotypePropertyElement();

		/**
		 * The meta object literal for the '<em><b>Property Qualified Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STEREOTYPE_PROPERTY_ELEMENT__PROPERTY_QUALIFIED_NAME = eINSTANCE.getStereotypePropertyElement_PropertyQualifiedName();

		/**
		 * The meta object literal for the '<em><b>Is Derived</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STEREOTYPE_PROPERTY_ELEMENT__IS_DERIVED = eINSTANCE.getStereotypePropertyElement_IsDerived();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.impl.StereotypePropertyFacetReferenceImpl <em>Stereotype Property Facet Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.impl.StereotypePropertyFacetReferenceImpl
		 * @see org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.impl.ProfileFacetPackageImpl#getStereotypePropertyFacetReference()
		 * @generated
		 */
		EClass STEREOTYPE_PROPERTY_FACET_REFERENCE = eINSTANCE.getStereotypePropertyFacetReference();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.impl.StereotypePropertyFacetAttributeImpl <em>Stereotype Property Facet Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.impl.StereotypePropertyFacetAttributeImpl
		 * @see org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.impl.ProfileFacetPackageImpl#getStereotypePropertyFacetAttribute()
		 * @generated
		 */
		EClass STEREOTYPE_PROPERTY_FACET_ATTRIBUTE = eINSTANCE.getStereotypePropertyFacetAttribute();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.EObjectFacetRepresentation <em>EObject Facet Representation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.EObjectFacetRepresentation
		 * @see org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.impl.ProfileFacetPackageImpl#getEObjectFacetRepresentation()
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

} //ProfileFacetPackage
