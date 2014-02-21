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
 *  Gregoire Dupe (Mia-Software) - Bug 364325 - [Restructuring] The user must be able to navigate into a model using the Facet.
 *  Gregoire Dupe (Mia-Software) - Bug 373078 - API Cleaning
 *  Gregoire Dupe (Mia-Software) - Bug 376576 - [EFacet] Change the multiplicity of Facet::extendedFacet
 */
package org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
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
 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.EFacetFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore validationDelegates='org.eclipse.ocl.ecore.OCL'"
 * @generated
 */
public interface EFacetPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "efacet"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/emf/facet/efacet/0.2.incubation/efacet"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "efacet"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EFacetPackage eINSTANCE = org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.EFacetPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.FacetAttributeImpl <em>Facet Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.FacetAttributeImpl
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.EFacetPackageImpl#getFacetAttribute()
	 * @generated
	 */
	int FACET_ATTRIBUTE = 0;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_ATTRIBUTE__EANNOTATIONS = EcorePackage.EATTRIBUTE__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_ATTRIBUTE__NAME = EcorePackage.EATTRIBUTE__NAME;

	/**
	 * The feature id for the '<em><b>Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_ATTRIBUTE__ORDERED = EcorePackage.EATTRIBUTE__ORDERED;

	/**
	 * The feature id for the '<em><b>Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_ATTRIBUTE__UNIQUE = EcorePackage.EATTRIBUTE__UNIQUE;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_ATTRIBUTE__LOWER_BOUND = EcorePackage.EATTRIBUTE__LOWER_BOUND;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_ATTRIBUTE__UPPER_BOUND = EcorePackage.EATTRIBUTE__UPPER_BOUND;

	/**
	 * The feature id for the '<em><b>Many</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_ATTRIBUTE__MANY = EcorePackage.EATTRIBUTE__MANY;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_ATTRIBUTE__REQUIRED = EcorePackage.EATTRIBUTE__REQUIRED;

	/**
	 * The feature id for the '<em><b>EType</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_ATTRIBUTE__ETYPE = EcorePackage.EATTRIBUTE__ETYPE;

	/**
	 * The feature id for the '<em><b>EGeneric Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_ATTRIBUTE__EGENERIC_TYPE = EcorePackage.EATTRIBUTE__EGENERIC_TYPE;

	/**
	 * The feature id for the '<em><b>Changeable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_ATTRIBUTE__CHANGEABLE = EcorePackage.EATTRIBUTE__CHANGEABLE;

	/**
	 * The feature id for the '<em><b>Volatile</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_ATTRIBUTE__VOLATILE = EcorePackage.EATTRIBUTE__VOLATILE;

	/**
	 * The feature id for the '<em><b>Transient</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_ATTRIBUTE__TRANSIENT = EcorePackage.EATTRIBUTE__TRANSIENT;

	/**
	 * The feature id for the '<em><b>Default Value Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_ATTRIBUTE__DEFAULT_VALUE_LITERAL = EcorePackage.EATTRIBUTE__DEFAULT_VALUE_LITERAL;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_ATTRIBUTE__DEFAULT_VALUE = EcorePackage.EATTRIBUTE__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>Unsettable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_ATTRIBUTE__UNSETTABLE = EcorePackage.EATTRIBUTE__UNSETTABLE;

	/**
	 * The feature id for the '<em><b>Derived</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_ATTRIBUTE__DERIVED = EcorePackage.EATTRIBUTE__DERIVED;

	/**
	 * The feature id for the '<em><b>EContaining Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_ATTRIBUTE__ECONTAINING_CLASS = EcorePackage.EATTRIBUTE__ECONTAINING_CLASS;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_ATTRIBUTE__ID = EcorePackage.EATTRIBUTE__ID;

	/**
	 * The feature id for the '<em><b>EAttribute Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_ATTRIBUTE__EATTRIBUTE_TYPE = EcorePackage.EATTRIBUTE__EATTRIBUTE_TYPE;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_ATTRIBUTE__DOCUMENTATION = EcorePackage.EATTRIBUTE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Categories</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_ATTRIBUTE__CATEGORIES = EcorePackage.EATTRIBUTE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Query</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_ATTRIBUTE__QUERY = EcorePackage.EATTRIBUTE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Override</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_ATTRIBUTE__OVERRIDE = EcorePackage.EATTRIBUTE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Facet Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_ATTRIBUTE_FEATURE_COUNT = EcorePackage.EATTRIBUTE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.FacetReferenceImpl <em>Facet Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.FacetReferenceImpl
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.EFacetPackageImpl#getFacetReference()
	 * @generated
	 */
	int FACET_REFERENCE = 1;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_REFERENCE__EANNOTATIONS = EcorePackage.EREFERENCE__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_REFERENCE__NAME = EcorePackage.EREFERENCE__NAME;

	/**
	 * The feature id for the '<em><b>Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_REFERENCE__ORDERED = EcorePackage.EREFERENCE__ORDERED;

	/**
	 * The feature id for the '<em><b>Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_REFERENCE__UNIQUE = EcorePackage.EREFERENCE__UNIQUE;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_REFERENCE__LOWER_BOUND = EcorePackage.EREFERENCE__LOWER_BOUND;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_REFERENCE__UPPER_BOUND = EcorePackage.EREFERENCE__UPPER_BOUND;

	/**
	 * The feature id for the '<em><b>Many</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_REFERENCE__MANY = EcorePackage.EREFERENCE__MANY;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_REFERENCE__REQUIRED = EcorePackage.EREFERENCE__REQUIRED;

	/**
	 * The feature id for the '<em><b>EType</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_REFERENCE__ETYPE = EcorePackage.EREFERENCE__ETYPE;

	/**
	 * The feature id for the '<em><b>EGeneric Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_REFERENCE__EGENERIC_TYPE = EcorePackage.EREFERENCE__EGENERIC_TYPE;

	/**
	 * The feature id for the '<em><b>Changeable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_REFERENCE__CHANGEABLE = EcorePackage.EREFERENCE__CHANGEABLE;

	/**
	 * The feature id for the '<em><b>Volatile</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_REFERENCE__VOLATILE = EcorePackage.EREFERENCE__VOLATILE;

	/**
	 * The feature id for the '<em><b>Transient</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_REFERENCE__TRANSIENT = EcorePackage.EREFERENCE__TRANSIENT;

	/**
	 * The feature id for the '<em><b>Default Value Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_REFERENCE__DEFAULT_VALUE_LITERAL = EcorePackage.EREFERENCE__DEFAULT_VALUE_LITERAL;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_REFERENCE__DEFAULT_VALUE = EcorePackage.EREFERENCE__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>Unsettable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_REFERENCE__UNSETTABLE = EcorePackage.EREFERENCE__UNSETTABLE;

	/**
	 * The feature id for the '<em><b>Derived</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_REFERENCE__DERIVED = EcorePackage.EREFERENCE__DERIVED;

	/**
	 * The feature id for the '<em><b>EContaining Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_REFERENCE__ECONTAINING_CLASS = EcorePackage.EREFERENCE__ECONTAINING_CLASS;

	/**
	 * The feature id for the '<em><b>Containment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_REFERENCE__CONTAINMENT = EcorePackage.EREFERENCE__CONTAINMENT;

	/**
	 * The feature id for the '<em><b>Container</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_REFERENCE__CONTAINER = EcorePackage.EREFERENCE__CONTAINER;

	/**
	 * The feature id for the '<em><b>Resolve Proxies</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_REFERENCE__RESOLVE_PROXIES = EcorePackage.EREFERENCE__RESOLVE_PROXIES;

	/**
	 * The feature id for the '<em><b>EOpposite</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_REFERENCE__EOPPOSITE = EcorePackage.EREFERENCE__EOPPOSITE;

	/**
	 * The feature id for the '<em><b>EReference Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_REFERENCE__EREFERENCE_TYPE = EcorePackage.EREFERENCE__EREFERENCE_TYPE;

	/**
	 * The feature id for the '<em><b>EKeys</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_REFERENCE__EKEYS = EcorePackage.EREFERENCE__EKEYS;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_REFERENCE__DOCUMENTATION = EcorePackage.EREFERENCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Categories</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_REFERENCE__CATEGORIES = EcorePackage.EREFERENCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Query</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_REFERENCE__QUERY = EcorePackage.EREFERENCE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Override</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_REFERENCE__OVERRIDE = EcorePackage.EREFERENCE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Facet Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_REFERENCE_FEATURE_COUNT = EcorePackage.EREFERENCE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.FacetOperationImpl <em>Facet Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.FacetOperationImpl
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.EFacetPackageImpl#getFacetOperation()
	 * @generated
	 */
	int FACET_OPERATION = 2;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_OPERATION__EANNOTATIONS = EcorePackage.EOPERATION__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_OPERATION__NAME = EcorePackage.EOPERATION__NAME;

	/**
	 * The feature id for the '<em><b>Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_OPERATION__ORDERED = EcorePackage.EOPERATION__ORDERED;

	/**
	 * The feature id for the '<em><b>Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_OPERATION__UNIQUE = EcorePackage.EOPERATION__UNIQUE;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_OPERATION__LOWER_BOUND = EcorePackage.EOPERATION__LOWER_BOUND;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_OPERATION__UPPER_BOUND = EcorePackage.EOPERATION__UPPER_BOUND;

	/**
	 * The feature id for the '<em><b>Many</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_OPERATION__MANY = EcorePackage.EOPERATION__MANY;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_OPERATION__REQUIRED = EcorePackage.EOPERATION__REQUIRED;

	/**
	 * The feature id for the '<em><b>EType</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_OPERATION__ETYPE = EcorePackage.EOPERATION__ETYPE;

	/**
	 * The feature id for the '<em><b>EGeneric Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_OPERATION__EGENERIC_TYPE = EcorePackage.EOPERATION__EGENERIC_TYPE;

	/**
	 * The feature id for the '<em><b>EContaining Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_OPERATION__ECONTAINING_CLASS = EcorePackage.EOPERATION__ECONTAINING_CLASS;

	/**
	 * The feature id for the '<em><b>EType Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_OPERATION__ETYPE_PARAMETERS = EcorePackage.EOPERATION__ETYPE_PARAMETERS;

	/**
	 * The feature id for the '<em><b>EParameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_OPERATION__EPARAMETERS = EcorePackage.EOPERATION__EPARAMETERS;

	/**
	 * The feature id for the '<em><b>EExceptions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_OPERATION__EEXCEPTIONS = EcorePackage.EOPERATION__EEXCEPTIONS;

	/**
	 * The feature id for the '<em><b>EGeneric Exceptions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_OPERATION__EGENERIC_EXCEPTIONS = EcorePackage.EOPERATION__EGENERIC_EXCEPTIONS;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_OPERATION__DOCUMENTATION = EcorePackage.EOPERATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Categories</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_OPERATION__CATEGORIES = EcorePackage.EOPERATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Query</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_OPERATION__QUERY = EcorePackage.EOPERATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Override</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_OPERATION__OVERRIDE = EcorePackage.EOPERATION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Facet Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_OPERATION_FEATURE_COUNT = EcorePackage.EOPERATION_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.FacetSetImpl <em>Facet Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.FacetSetImpl
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.EFacetPackageImpl#getFacetSet()
	 * @generated
	 */
	int FACET_SET = 3;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_SET__EANNOTATIONS = EcorePackage.EPACKAGE__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_SET__NAME = EcorePackage.EPACKAGE__NAME;

	/**
	 * The feature id for the '<em><b>Ns URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_SET__NS_URI = EcorePackage.EPACKAGE__NS_URI;

	/**
	 * The feature id for the '<em><b>Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_SET__NS_PREFIX = EcorePackage.EPACKAGE__NS_PREFIX;

	/**
	 * The feature id for the '<em><b>EFactory Instance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_SET__EFACTORY_INSTANCE = EcorePackage.EPACKAGE__EFACTORY_INSTANCE;

	/**
	 * The feature id for the '<em><b>EClassifiers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_SET__ECLASSIFIERS = EcorePackage.EPACKAGE__ECLASSIFIERS;

	/**
	 * The feature id for the '<em><b>ESubpackages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_SET__ESUBPACKAGES = EcorePackage.EPACKAGE__ESUBPACKAGES;

	/**
	 * The feature id for the '<em><b>ESuper Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_SET__ESUPER_PACKAGE = EcorePackage.EPACKAGE__ESUPER_PACKAGE;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_SET__DOCUMENTATION = EcorePackage.EPACKAGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Categories</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_SET__CATEGORIES = EcorePackage.EPACKAGE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Facet Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_SET_FEATURE_COUNT = EcorePackage.EPACKAGE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.FacetImpl <em>Facet</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.FacetImpl
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.EFacetPackageImpl#getFacet()
	 * @generated
	 */
	int FACET = 4;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET__EANNOTATIONS = EcorePackage.ECLASSIFIER__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET__NAME = EcorePackage.ECLASSIFIER__NAME;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET__INSTANCE_CLASS_NAME = EcorePackage.ECLASSIFIER__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Instance Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET__INSTANCE_CLASS = EcorePackage.ECLASSIFIER__INSTANCE_CLASS;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET__DEFAULT_VALUE = EcorePackage.ECLASSIFIER__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>Instance Type Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET__INSTANCE_TYPE_NAME = EcorePackage.ECLASSIFIER__INSTANCE_TYPE_NAME;

	/**
	 * The feature id for the '<em><b>EPackage</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET__EPACKAGE = EcorePackage.ECLASSIFIER__EPACKAGE;

	/**
	 * The feature id for the '<em><b>EType Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET__ETYPE_PARAMETERS = EcorePackage.ECLASSIFIER__ETYPE_PARAMETERS;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET__DOCUMENTATION = EcorePackage.ECLASSIFIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extended Metaclass</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET__EXTENDED_METACLASS = EcorePackage.ECLASSIFIER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Facet Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET__FACET_ELEMENTS = EcorePackage.ECLASSIFIER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Facet Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET__FACET_OPERATIONS = EcorePackage.ECLASSIFIER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Conformance Typed Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET__CONFORMANCE_TYPED_ELEMENT = EcorePackage.ECLASSIFIER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Extended Facets</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 * @since 0.2
	 */
	int FACET__EXTENDED_FACETS = EcorePackage.ECLASSIFIER_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Facet</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_FEATURE_COUNT = EcorePackage.ECLASSIFIER_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.CategoryImpl <em>Category</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.CategoryImpl
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.EFacetPackageImpl#getCategory()
	 * @generated
	 */
	int CATEGORY = 5;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__EANNOTATIONS = EcorePackage.ENAMED_ELEMENT__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__NAME = EcorePackage.ENAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__DOCUMENTATION = EcorePackage.ENAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Category</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_FEATURE_COUNT = EcorePackage.ENAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.FacetElementImpl <em>Facet Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.FacetElementImpl
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.EFacetPackageImpl#getFacetElement()
	 * @generated
	 */
	int FACET_ELEMENT = 6;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_ELEMENT__EANNOTATIONS = EcorePackage.ETYPED_ELEMENT__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_ELEMENT__NAME = EcorePackage.ETYPED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_ELEMENT__ORDERED = EcorePackage.ETYPED_ELEMENT__ORDERED;

	/**
	 * The feature id for the '<em><b>Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_ELEMENT__UNIQUE = EcorePackage.ETYPED_ELEMENT__UNIQUE;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_ELEMENT__LOWER_BOUND = EcorePackage.ETYPED_ELEMENT__LOWER_BOUND;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_ELEMENT__UPPER_BOUND = EcorePackage.ETYPED_ELEMENT__UPPER_BOUND;

	/**
	 * The feature id for the '<em><b>Many</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_ELEMENT__MANY = EcorePackage.ETYPED_ELEMENT__MANY;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_ELEMENT__REQUIRED = EcorePackage.ETYPED_ELEMENT__REQUIRED;

	/**
	 * The feature id for the '<em><b>EType</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_ELEMENT__ETYPE = EcorePackage.ETYPED_ELEMENT__ETYPE;

	/**
	 * The feature id for the '<em><b>EGeneric Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_ELEMENT__EGENERIC_TYPE = EcorePackage.ETYPED_ELEMENT__EGENERIC_TYPE;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_ELEMENT__DOCUMENTATION = EcorePackage.ETYPED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Categories</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_ELEMENT__CATEGORIES = EcorePackage.ETYPED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Facet Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_ELEMENT_FEATURE_COUNT = EcorePackage.ETYPED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.DerivedTypedElementImpl <em>Derived Typed Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.DerivedTypedElementImpl
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.EFacetPackageImpl#getDerivedTypedElement()
	 * @generated
	 */
	int DERIVED_TYPED_ELEMENT = 7;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVED_TYPED_ELEMENT__EANNOTATIONS = FACET_ELEMENT__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVED_TYPED_ELEMENT__NAME = FACET_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVED_TYPED_ELEMENT__ORDERED = FACET_ELEMENT__ORDERED;

	/**
	 * The feature id for the '<em><b>Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVED_TYPED_ELEMENT__UNIQUE = FACET_ELEMENT__UNIQUE;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVED_TYPED_ELEMENT__LOWER_BOUND = FACET_ELEMENT__LOWER_BOUND;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVED_TYPED_ELEMENT__UPPER_BOUND = FACET_ELEMENT__UPPER_BOUND;

	/**
	 * The feature id for the '<em><b>Many</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVED_TYPED_ELEMENT__MANY = FACET_ELEMENT__MANY;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVED_TYPED_ELEMENT__REQUIRED = FACET_ELEMENT__REQUIRED;

	/**
	 * The feature id for the '<em><b>EType</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVED_TYPED_ELEMENT__ETYPE = FACET_ELEMENT__ETYPE;

	/**
	 * The feature id for the '<em><b>EGeneric Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVED_TYPED_ELEMENT__EGENERIC_TYPE = FACET_ELEMENT__EGENERIC_TYPE;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVED_TYPED_ELEMENT__DOCUMENTATION = FACET_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Categories</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVED_TYPED_ELEMENT__CATEGORIES = FACET_ELEMENT__CATEGORIES;

	/**
	 * The feature id for the '<em><b>Query</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVED_TYPED_ELEMENT__QUERY = FACET_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Override</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVED_TYPED_ELEMENT__OVERRIDE = FACET_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Derived Typed Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVED_TYPED_ELEMENT_FEATURE_COUNT = FACET_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.ParameterValueImpl <em>Parameter Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.ParameterValueImpl
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.EFacetPackageImpl#getParameterValue()
	 * @generated
	 */
	int PARAMETER_VALUE = 8;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_VALUE__PARAMETER = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_VALUE__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Parameter Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_VALUE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.DocumentedElementImpl <em>Documented Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.DocumentedElementImpl
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.EFacetPackageImpl#getDocumentedElement()
	 * @generated
	 */
	int DOCUMENTED_ELEMENT = 9;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENTED_ELEMENT__DOCUMENTATION = 0;

	/**
	 * The number of structural features of the '<em>Documented Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENTED_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '<em>Resource</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.resource.Resource
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.EFacetPackageImpl#getResource()
	 * @generated
	 */
	int RESOURCE = 10;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetAttribute <em>Facet Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Facet Attribute</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetAttribute
	 * @generated
	 */
	EClass getFacetAttribute();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetReference <em>Facet Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Facet Reference</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetReference
	 * @generated
	 */
	EClass getFacetReference();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetOperation <em>Facet Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Facet Operation</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetOperation
	 * @generated
	 */
	EClass getFacetOperation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet <em>Facet Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Facet Set</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet
	 * @generated
	 */
	EClass getFacetSet();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet#getCategories <em>Categories</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Categories</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet#getCategories()
	 * @see #getFacetSet()
	 * @generated
	 */
	EReference getFacetSet_Categories();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet <em>Facet</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Facet</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet
	 * @generated
	 */
	EClass getFacet();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet#getExtendedMetaclass <em>Extended Metaclass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Extended Metaclass</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet#getExtendedMetaclass()
	 * @see #getFacet()
	 * @generated
	 */
	EReference getFacet_ExtendedMetaclass();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet#getFacetElements <em>Facet Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Facet Elements</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet#getFacetElements()
	 * @see #getFacet()
	 * @generated
	 */
	EReference getFacet_FacetElements();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet#getFacetOperations <em>Facet Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Facet Operations</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet#getFacetOperations()
	 * @see #getFacet()
	 * @generated
	 */
	EReference getFacet_FacetOperations();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet#getConformanceTypedElement <em>Conformance Typed Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Conformance Typed Element</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet#getConformanceTypedElement()
	 * @see #getFacet()
	 * @generated
	 */
	EReference getFacet_ConformanceTypedElement();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet#getExtendedFacets <em>Extended Facets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Extended Facets</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet#getExtendedFacets()
	 * @see #getFacet()
	 * @generated
	 * @since 0.2
	 */
	EReference getFacet_ExtendedFacets();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.Category <em>Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Category</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.Category
	 * @generated
	 */
	EClass getCategory();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetElement <em>Facet Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Facet Element</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetElement
	 * @generated
	 */
	EClass getFacetElement();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetElement#getCategories <em>Categories</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Categories</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetElement#getCategories()
	 * @see #getFacetElement()
	 * @generated
	 */
	EReference getFacetElement_Categories();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.DerivedTypedElement <em>Derived Typed Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Derived Typed Element</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.DerivedTypedElement
	 * @generated
	 */
	EClass getDerivedTypedElement();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.DerivedTypedElement#getQuery <em>Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Query</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.DerivedTypedElement#getQuery()
	 * @see #getDerivedTypedElement()
	 * @generated
	 */
	EReference getDerivedTypedElement_Query();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.DerivedTypedElement#getOverride <em>Override</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Override</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.DerivedTypedElement#getOverride()
	 * @see #getDerivedTypedElement()
	 * @generated
	 */
	EReference getDerivedTypedElement_Override();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.ParameterValue <em>Parameter Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter Value</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.ParameterValue
	 * @generated
	 */
	EClass getParameterValue();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.ParameterValue#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parameter</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.ParameterValue#getParameter()
	 * @see #getParameterValue()
	 * @generated
	 */
	EReference getParameterValue_Parameter();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.ParameterValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.ParameterValue#getValue()
	 * @see #getParameterValue()
	 * @generated
	 */
	EAttribute getParameterValue_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.DocumentedElement <em>Documented Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Documented Element</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.DocumentedElement
	 * @generated
	 */
	EClass getDocumentedElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.DocumentedElement#getDocumentation <em>Documentation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Documentation</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.DocumentedElement#getDocumentation()
	 * @see #getDocumentedElement()
	 * @generated
	 */
	EAttribute getDocumentedElement_Documentation();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.emf.ecore.resource.Resource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Resource</em>'.
	 * @see org.eclipse.emf.ecore.resource.Resource
	 * @model instanceClass="org.eclipse.emf.ecore.resource.Resource"
	 * @generated
	 */
	EDataType getResource();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EFacetFactory getEFacetFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.FacetAttributeImpl <em>Facet Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.FacetAttributeImpl
		 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.EFacetPackageImpl#getFacetAttribute()
		 * @generated
		 */
		EClass FACET_ATTRIBUTE = eINSTANCE.getFacetAttribute();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.FacetReferenceImpl <em>Facet Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.FacetReferenceImpl
		 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.EFacetPackageImpl#getFacetReference()
		 * @generated
		 */
		EClass FACET_REFERENCE = eINSTANCE.getFacetReference();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.FacetOperationImpl <em>Facet Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.FacetOperationImpl
		 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.EFacetPackageImpl#getFacetOperation()
		 * @generated
		 */
		EClass FACET_OPERATION = eINSTANCE.getFacetOperation();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.FacetSetImpl <em>Facet Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.FacetSetImpl
		 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.EFacetPackageImpl#getFacetSet()
		 * @generated
		 */
		EClass FACET_SET = eINSTANCE.getFacetSet();

		/**
		 * The meta object literal for the '<em><b>Categories</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FACET_SET__CATEGORIES = eINSTANCE.getFacetSet_Categories();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.FacetImpl <em>Facet</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.FacetImpl
		 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.EFacetPackageImpl#getFacet()
		 * @generated
		 */
		EClass FACET = eINSTANCE.getFacet();

		/**
		 * The meta object literal for the '<em><b>Extended Metaclass</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FACET__EXTENDED_METACLASS = eINSTANCE.getFacet_ExtendedMetaclass();

		/**
		 * The meta object literal for the '<em><b>Facet Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FACET__FACET_ELEMENTS = eINSTANCE.getFacet_FacetElements();

		/**
		 * The meta object literal for the '<em><b>Facet Operations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FACET__FACET_OPERATIONS = eINSTANCE.getFacet_FacetOperations();

		/**
		 * The meta object literal for the '<em><b>Conformance Typed Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FACET__CONFORMANCE_TYPED_ELEMENT = eINSTANCE.getFacet_ConformanceTypedElement();

		/**
		 * The meta object literal for the '<em><b>Extended Facets</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 * @since 0.2
		 */
		EReference FACET__EXTENDED_FACETS = eINSTANCE.getFacet_ExtendedFacets();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.CategoryImpl <em>Category</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.CategoryImpl
		 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.EFacetPackageImpl#getCategory()
		 * @generated
		 */
		EClass CATEGORY = eINSTANCE.getCategory();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.FacetElementImpl <em>Facet Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.FacetElementImpl
		 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.EFacetPackageImpl#getFacetElement()
		 * @generated
		 */
		EClass FACET_ELEMENT = eINSTANCE.getFacetElement();

		/**
		 * The meta object literal for the '<em><b>Categories</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FACET_ELEMENT__CATEGORIES = eINSTANCE.getFacetElement_Categories();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.DerivedTypedElementImpl <em>Derived Typed Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.DerivedTypedElementImpl
		 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.EFacetPackageImpl#getDerivedTypedElement()
		 * @generated
		 */
		EClass DERIVED_TYPED_ELEMENT = eINSTANCE.getDerivedTypedElement();

		/**
		 * The meta object literal for the '<em><b>Query</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DERIVED_TYPED_ELEMENT__QUERY = eINSTANCE.getDerivedTypedElement_Query();

		/**
		 * The meta object literal for the '<em><b>Override</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DERIVED_TYPED_ELEMENT__OVERRIDE = eINSTANCE.getDerivedTypedElement_Override();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.ParameterValueImpl <em>Parameter Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.ParameterValueImpl
		 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.EFacetPackageImpl#getParameterValue()
		 * @generated
		 */
		EClass PARAMETER_VALUE = eINSTANCE.getParameterValue();

		/**
		 * The meta object literal for the '<em><b>Parameter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER_VALUE__PARAMETER = eINSTANCE.getParameterValue_Parameter();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER_VALUE__VALUE = eINSTANCE.getParameterValue_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.DocumentedElementImpl <em>Documented Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.DocumentedElementImpl
		 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.EFacetPackageImpl#getDocumentedElement()
		 * @generated
		 */
		EClass DOCUMENTED_ELEMENT = eINSTANCE.getDocumentedElement();

		/**
		 * The meta object literal for the '<em><b>Documentation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENTED_ELEMENT__DOCUMENTATION = eINSTANCE.getDocumentedElement_Documentation();

		/**
		 * The meta object literal for the '<em>Resource</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecore.resource.Resource
		 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.EFacetPackageImpl#getResource()
		 * @generated
		 */
		EDataType RESOURCE = eINSTANCE.getResource();

	}

} //EFacetPackage
