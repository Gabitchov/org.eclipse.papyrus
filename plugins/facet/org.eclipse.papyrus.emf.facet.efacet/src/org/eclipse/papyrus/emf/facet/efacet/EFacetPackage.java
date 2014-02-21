/**
 *  Copyright (c) 2011 Mia-Software.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 * 	Gregoire Dupe (Mia-Software) - Design
 * 	Nicolas Guyomar (Mia-Software) - Implementation
 *  
 */
package org.eclipse.papyrus.emf.facet.efacet;

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
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.emf.facet.efacet.EFacetFactory
 * @model kind="package"
 * @generated
 * @deprecated use the new eFacet metamodel in org.eclipse.papyrus.emf.facet.efacet.metamodel. Cf.
 *             https://bugs.eclipse.org/bugs/show_bug.cgi?id=373672
 */
@Deprecated
public interface EFacetPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	String eNAME = "efacet"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	String eNS_URI = "http://www.eclipse.org/emf/facet/efacet/0.1.incubation"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	String eNS_PREFIX = "efacet"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	EFacetPackage eINSTANCE = org.eclipse.papyrus.emf.facet.efacet.impl.EFacetPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.emf.facet.efacet.impl.FacetAttributeImpl <em>Facet Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.emf.facet.efacet.impl.FacetAttributeImpl
	 * @see org.eclipse.papyrus.emf.facet.efacet.impl.EFacetPackageImpl#getFacetAttribute()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	int FACET_ATTRIBUTE = 0;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_ATTRIBUTE__EANNOTATIONS = EcorePackage.EATTRIBUTE__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_ATTRIBUTE__NAME = EcorePackage.EATTRIBUTE__NAME;

	/**
	 * The feature id for the '<em><b>Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_ATTRIBUTE__ORDERED = EcorePackage.EATTRIBUTE__ORDERED;

	/**
	 * The feature id for the '<em><b>Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_ATTRIBUTE__UNIQUE = EcorePackage.EATTRIBUTE__UNIQUE;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_ATTRIBUTE__LOWER_BOUND = EcorePackage.EATTRIBUTE__LOWER_BOUND;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_ATTRIBUTE__UPPER_BOUND = EcorePackage.EATTRIBUTE__UPPER_BOUND;

	/**
	 * The feature id for the '<em><b>Many</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_ATTRIBUTE__MANY = EcorePackage.EATTRIBUTE__MANY;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_ATTRIBUTE__REQUIRED = EcorePackage.EATTRIBUTE__REQUIRED;

	/**
	 * The feature id for the '<em><b>EType</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_ATTRIBUTE__ETYPE = EcorePackage.EATTRIBUTE__ETYPE;

	/**
	 * The feature id for the '<em><b>EGeneric Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_ATTRIBUTE__EGENERIC_TYPE = EcorePackage.EATTRIBUTE__EGENERIC_TYPE;

	/**
	 * The feature id for the '<em><b>Changeable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_ATTRIBUTE__CHANGEABLE = EcorePackage.EATTRIBUTE__CHANGEABLE;

	/**
	 * The feature id for the '<em><b>Volatile</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_ATTRIBUTE__VOLATILE = EcorePackage.EATTRIBUTE__VOLATILE;

	/**
	 * The feature id for the '<em><b>Transient</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_ATTRIBUTE__TRANSIENT = EcorePackage.EATTRIBUTE__TRANSIENT;

	/**
	 * The feature id for the '<em><b>Default Value Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_ATTRIBUTE__DEFAULT_VALUE_LITERAL = EcorePackage.EATTRIBUTE__DEFAULT_VALUE_LITERAL;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_ATTRIBUTE__DEFAULT_VALUE = EcorePackage.EATTRIBUTE__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>Unsettable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_ATTRIBUTE__UNSETTABLE = EcorePackage.EATTRIBUTE__UNSETTABLE;

	/**
	 * The feature id for the '<em><b>Derived</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_ATTRIBUTE__DERIVED = EcorePackage.EATTRIBUTE__DERIVED;

	/**
	 * The feature id for the '<em><b>EContaining Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_ATTRIBUTE__ECONTAINING_CLASS = EcorePackage.EATTRIBUTE__ECONTAINING_CLASS;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_ATTRIBUTE__ID = EcorePackage.EATTRIBUTE__ID;

	/**
	 * The feature id for the '<em><b>EAttribute Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_ATTRIBUTE__EATTRIBUTE_TYPE = EcorePackage.EATTRIBUTE__EATTRIBUTE_TYPE;

	/**
	 * The feature id for the '<em><b>Categories</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_ATTRIBUTE__CATEGORIES = EcorePackage.EATTRIBUTE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Facet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_ATTRIBUTE__FACET = EcorePackage.EATTRIBUTE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Override</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_ATTRIBUTE__OVERRIDE = EcorePackage.EATTRIBUTE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Query</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_ATTRIBUTE__QUERY = EcorePackage.EATTRIBUTE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Facet Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_ATTRIBUTE_FEATURE_COUNT = EcorePackage.EATTRIBUTE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.emf.facet.efacet.impl.FacetReferenceImpl <em>Facet Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.emf.facet.efacet.impl.FacetReferenceImpl
	 * @see org.eclipse.papyrus.emf.facet.efacet.impl.EFacetPackageImpl#getFacetReference()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	int FACET_REFERENCE = 1;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_REFERENCE__EANNOTATIONS = EcorePackage.EREFERENCE__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_REFERENCE__NAME = EcorePackage.EREFERENCE__NAME;

	/**
	 * The feature id for the '<em><b>Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_REFERENCE__ORDERED = EcorePackage.EREFERENCE__ORDERED;

	/**
	 * The feature id for the '<em><b>Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_REFERENCE__UNIQUE = EcorePackage.EREFERENCE__UNIQUE;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_REFERENCE__LOWER_BOUND = EcorePackage.EREFERENCE__LOWER_BOUND;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_REFERENCE__UPPER_BOUND = EcorePackage.EREFERENCE__UPPER_BOUND;

	/**
	 * The feature id for the '<em><b>Many</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_REFERENCE__MANY = EcorePackage.EREFERENCE__MANY;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_REFERENCE__REQUIRED = EcorePackage.EREFERENCE__REQUIRED;

	/**
	 * The feature id for the '<em><b>EType</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_REFERENCE__ETYPE = EcorePackage.EREFERENCE__ETYPE;

	/**
	 * The feature id for the '<em><b>EGeneric Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_REFERENCE__EGENERIC_TYPE = EcorePackage.EREFERENCE__EGENERIC_TYPE;

	/**
	 * The feature id for the '<em><b>Changeable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_REFERENCE__CHANGEABLE = EcorePackage.EREFERENCE__CHANGEABLE;

	/**
	 * The feature id for the '<em><b>Volatile</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_REFERENCE__VOLATILE = EcorePackage.EREFERENCE__VOLATILE;

	/**
	 * The feature id for the '<em><b>Transient</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_REFERENCE__TRANSIENT = EcorePackage.EREFERENCE__TRANSIENT;

	/**
	 * The feature id for the '<em><b>Default Value Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_REFERENCE__DEFAULT_VALUE_LITERAL = EcorePackage.EREFERENCE__DEFAULT_VALUE_LITERAL;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_REFERENCE__DEFAULT_VALUE = EcorePackage.EREFERENCE__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>Unsettable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_REFERENCE__UNSETTABLE = EcorePackage.EREFERENCE__UNSETTABLE;

	/**
	 * The feature id for the '<em><b>Derived</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_REFERENCE__DERIVED = EcorePackage.EREFERENCE__DERIVED;

	/**
	 * The feature id for the '<em><b>EContaining Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_REFERENCE__ECONTAINING_CLASS = EcorePackage.EREFERENCE__ECONTAINING_CLASS;

	/**
	 * The feature id for the '<em><b>Containment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_REFERENCE__CONTAINMENT = EcorePackage.EREFERENCE__CONTAINMENT;

	/**
	 * The feature id for the '<em><b>Container</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_REFERENCE__CONTAINER = EcorePackage.EREFERENCE__CONTAINER;

	/**
	 * The feature id for the '<em><b>Resolve Proxies</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_REFERENCE__RESOLVE_PROXIES = EcorePackage.EREFERENCE__RESOLVE_PROXIES;

	/**
	 * The feature id for the '<em><b>EOpposite</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_REFERENCE__EOPPOSITE = EcorePackage.EREFERENCE__EOPPOSITE;

	/**
	 * The feature id for the '<em><b>EReference Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_REFERENCE__EREFERENCE_TYPE = EcorePackage.EREFERENCE__EREFERENCE_TYPE;

	/**
	 * The feature id for the '<em><b>EKeys</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_REFERENCE__EKEYS = EcorePackage.EREFERENCE__EKEYS;

	/**
	 * The feature id for the '<em><b>Categories</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_REFERENCE__CATEGORIES = EcorePackage.EREFERENCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Facet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_REFERENCE__FACET = EcorePackage.EREFERENCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Override</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_REFERENCE__OVERRIDE = EcorePackage.EREFERENCE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Query</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_REFERENCE__QUERY = EcorePackage.EREFERENCE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Facet Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_REFERENCE_FEATURE_COUNT = EcorePackage.EREFERENCE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.emf.facet.efacet.impl.FacetOperationImpl <em>Facet Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.emf.facet.efacet.impl.FacetOperationImpl
	 * @see org.eclipse.papyrus.emf.facet.efacet.impl.EFacetPackageImpl#getFacetOperation()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	int FACET_OPERATION = 2;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_OPERATION__EANNOTATIONS = EcorePackage.EOPERATION__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_OPERATION__NAME = EcorePackage.EOPERATION__NAME;

	/**
	 * The feature id for the '<em><b>Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_OPERATION__ORDERED = EcorePackage.EOPERATION__ORDERED;

	/**
	 * The feature id for the '<em><b>Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_OPERATION__UNIQUE = EcorePackage.EOPERATION__UNIQUE;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_OPERATION__LOWER_BOUND = EcorePackage.EOPERATION__LOWER_BOUND;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_OPERATION__UPPER_BOUND = EcorePackage.EOPERATION__UPPER_BOUND;

	/**
	 * The feature id for the '<em><b>Many</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_OPERATION__MANY = EcorePackage.EOPERATION__MANY;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_OPERATION__REQUIRED = EcorePackage.EOPERATION__REQUIRED;

	/**
	 * The feature id for the '<em><b>EType</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_OPERATION__ETYPE = EcorePackage.EOPERATION__ETYPE;

	/**
	 * The feature id for the '<em><b>EGeneric Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_OPERATION__EGENERIC_TYPE = EcorePackage.EOPERATION__EGENERIC_TYPE;

	/**
	 * The feature id for the '<em><b>EContaining Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_OPERATION__ECONTAINING_CLASS = EcorePackage.EOPERATION__ECONTAINING_CLASS;

	/**
	 * The feature id for the '<em><b>EType Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_OPERATION__ETYPE_PARAMETERS = EcorePackage.EOPERATION__ETYPE_PARAMETERS;

	/**
	 * The feature id for the '<em><b>EParameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_OPERATION__EPARAMETERS = EcorePackage.EOPERATION__EPARAMETERS;

	/**
	 * The feature id for the '<em><b>EExceptions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_OPERATION__EEXCEPTIONS = EcorePackage.EOPERATION__EEXCEPTIONS;

	/**
	 * The feature id for the '<em><b>EGeneric Exceptions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_OPERATION__EGENERIC_EXCEPTIONS = EcorePackage.EOPERATION__EGENERIC_EXCEPTIONS;

	/**
	 * The feature id for the '<em><b>Categories</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_OPERATION__CATEGORIES = EcorePackage.EOPERATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Facet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_OPERATION__FACET = EcorePackage.EOPERATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Override</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_OPERATION__OVERRIDE = EcorePackage.EOPERATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Query</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_OPERATION__QUERY = EcorePackage.EOPERATION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Facet Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_OPERATION_FEATURE_COUNT = EcorePackage.EOPERATION_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.emf.facet.efacet.impl.FacetSetImpl <em>Facet Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.emf.facet.efacet.impl.FacetSetImpl
	 * @see org.eclipse.papyrus.emf.facet.efacet.impl.EFacetPackageImpl#getFacetSet()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	int FACET_SET = 3;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_SET__EANNOTATIONS = EcorePackage.EPACKAGE__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_SET__NAME = EcorePackage.EPACKAGE__NAME;

	/**
	 * The feature id for the '<em><b>Ns URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_SET__NS_URI = EcorePackage.EPACKAGE__NS_URI;

	/**
	 * The feature id for the '<em><b>Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_SET__NS_PREFIX = EcorePackage.EPACKAGE__NS_PREFIX;

	/**
	 * The feature id for the '<em><b>EFactory Instance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_SET__EFACTORY_INSTANCE = EcorePackage.EPACKAGE__EFACTORY_INSTANCE;

	/**
	 * The feature id for the '<em><b>EClassifiers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_SET__ECLASSIFIERS = EcorePackage.EPACKAGE__ECLASSIFIERS;

	/**
	 * The feature id for the '<em><b>ESubpackages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_SET__ESUBPACKAGES = EcorePackage.EPACKAGE__ESUBPACKAGES;

	/**
	 * The feature id for the '<em><b>ESuper Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_SET__ESUPER_PACKAGE = EcorePackage.EPACKAGE__ESUPER_PACKAGE;

	/**
	 * The feature id for the '<em><b>Facets</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_SET__FACETS = EcorePackage.EPACKAGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Categories</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_SET__CATEGORIES = EcorePackage.EPACKAGE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Extended EPackage</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_SET__EXTENDED_EPACKAGE = EcorePackage.EPACKAGE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Facet Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_SET_FEATURE_COUNT = EcorePackage.EPACKAGE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.emf.facet.efacet.impl.FacetImpl <em>Facet</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.emf.facet.efacet.impl.FacetImpl
	 * @see org.eclipse.papyrus.emf.facet.efacet.impl.EFacetPackageImpl#getFacet()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	int FACET = 4;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET__EANNOTATIONS = EcorePackage.ECLASSIFIER__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET__NAME = EcorePackage.ECLASSIFIER__NAME;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET__INSTANCE_CLASS_NAME = EcorePackage.ECLASSIFIER__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Instance Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET__INSTANCE_CLASS = EcorePackage.ECLASSIFIER__INSTANCE_CLASS;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET__DEFAULT_VALUE = EcorePackage.ECLASSIFIER__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>Instance Type Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET__INSTANCE_TYPE_NAME = EcorePackage.ECLASSIFIER__INSTANCE_TYPE_NAME;

	/**
	 * The feature id for the '<em><b>EPackage</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET__EPACKAGE = EcorePackage.ECLASSIFIER__EPACKAGE;

	/**
	 * The feature id for the '<em><b>EType Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET__ETYPE_PARAMETERS = EcorePackage.ECLASSIFIER__ETYPE_PARAMETERS;

	/**
	 * The feature id for the '<em><b>Facet Set</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET__FACET_SET = EcorePackage.ECLASSIFIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Conformance Query</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET__CONFORMANCE_QUERY = EcorePackage.ECLASSIFIER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Extended Metaclass</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET__EXTENDED_METACLASS = EcorePackage.ECLASSIFIER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Facet Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET__FACET_ELEMENTS = EcorePackage.ECLASSIFIER_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Facet</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_FEATURE_COUNT = EcorePackage.ECLASSIFIER_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.emf.facet.efacet.impl.QueryImpl <em>Query</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.emf.facet.efacet.impl.QueryImpl
	 * @see org.eclipse.papyrus.emf.facet.efacet.impl.EFacetPackageImpl#getQuery()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	int QUERY = 5;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int QUERY__EANNOTATIONS = EcorePackage.ETYPED_ELEMENT__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int QUERY__NAME = EcorePackage.ETYPED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int QUERY__ORDERED = EcorePackage.ETYPED_ELEMENT__ORDERED;

	/**
	 * The feature id for the '<em><b>Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int QUERY__UNIQUE = EcorePackage.ETYPED_ELEMENT__UNIQUE;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int QUERY__LOWER_BOUND = EcorePackage.ETYPED_ELEMENT__LOWER_BOUND;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int QUERY__UPPER_BOUND = EcorePackage.ETYPED_ELEMENT__UPPER_BOUND;

	/**
	 * The feature id for the '<em><b>Many</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int QUERY__MANY = EcorePackage.ETYPED_ELEMENT__MANY;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int QUERY__REQUIRED = EcorePackage.ETYPED_ELEMENT__REQUIRED;

	/**
	 * The feature id for the '<em><b>EType</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int QUERY__ETYPE = EcorePackage.ETYPED_ELEMENT__ETYPE;

	/**
	 * The feature id for the '<em><b>EGeneric Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int QUERY__EGENERIC_TYPE = EcorePackage.ETYPED_ELEMENT__EGENERIC_TYPE;

	/**
	 * The feature id for the '<em><b>Scope</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int QUERY__SCOPE = EcorePackage.ETYPED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Has Side Effect</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int QUERY__HAS_SIDE_EFFECT = EcorePackage.ETYPED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Can Be Cached</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int QUERY__CAN_BE_CACHED = EcorePackage.ETYPED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int QUERY__PARAMETERS = EcorePackage.ETYPED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Query</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int QUERY_FEATURE_COUNT = EcorePackage.ETYPED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.emf.facet.efacet.impl.QueryResultImpl <em>Query Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.emf.facet.efacet.impl.QueryResultImpl
	 * @see org.eclipse.papyrus.emf.facet.efacet.impl.EFacetPackageImpl#getQueryResult()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	int QUERY_RESULT = 6;

	/**
	 * The feature id for the '<em><b>Query</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int QUERY_RESULT__QUERY = 0;

	/**
	 * The feature id for the '<em><b>Scope</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int QUERY_RESULT__SCOPE = 1;

	/**
	 * The feature id for the '<em><b>Parameter Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int QUERY_RESULT__PARAMETER_VALUES = 2;

	/**
	 * The feature id for the '<em><b>Result</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int QUERY_RESULT__RESULT = 3;

	/**
	 * The feature id for the '<em><b>Exception</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int QUERY_RESULT__EXCEPTION = 4;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int QUERY_RESULT__SOURCE = 5;

	/**
	 * The number of structural features of the '<em>Query Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int QUERY_RESULT_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.emf.facet.efacet.impl.CategoryImpl <em>Category</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.emf.facet.efacet.impl.CategoryImpl
	 * @see org.eclipse.papyrus.emf.facet.efacet.impl.EFacetPackageImpl#getCategory()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	int CATEGORY = 7;

	/**
	 * The number of structural features of the '<em>Category</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int CATEGORY_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.emf.facet.efacet.impl.FacetElementImpl <em>Facet Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.emf.facet.efacet.impl.FacetElementImpl
	 * @see org.eclipse.papyrus.emf.facet.efacet.impl.EFacetPackageImpl#getFacetElement()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	int FACET_ELEMENT = 8;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_ELEMENT__EANNOTATIONS = EcorePackage.ETYPED_ELEMENT__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_ELEMENT__NAME = EcorePackage.ETYPED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_ELEMENT__ORDERED = EcorePackage.ETYPED_ELEMENT__ORDERED;

	/**
	 * The feature id for the '<em><b>Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_ELEMENT__UNIQUE = EcorePackage.ETYPED_ELEMENT__UNIQUE;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_ELEMENT__LOWER_BOUND = EcorePackage.ETYPED_ELEMENT__LOWER_BOUND;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_ELEMENT__UPPER_BOUND = EcorePackage.ETYPED_ELEMENT__UPPER_BOUND;

	/**
	 * The feature id for the '<em><b>Many</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_ELEMENT__MANY = EcorePackage.ETYPED_ELEMENT__MANY;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_ELEMENT__REQUIRED = EcorePackage.ETYPED_ELEMENT__REQUIRED;

	/**
	 * The feature id for the '<em><b>EType</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_ELEMENT__ETYPE = EcorePackage.ETYPED_ELEMENT__ETYPE;

	/**
	 * The feature id for the '<em><b>EGeneric Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_ELEMENT__EGENERIC_TYPE = EcorePackage.ETYPED_ELEMENT__EGENERIC_TYPE;

	/**
	 * The feature id for the '<em><b>Categories</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_ELEMENT__CATEGORIES = EcorePackage.ETYPED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Facet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_ELEMENT__FACET = EcorePackage.ETYPED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Override</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_ELEMENT__OVERRIDE = EcorePackage.ETYPED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Facet Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int FACET_ELEMENT_FEATURE_COUNT = EcorePackage.ETYPED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.emf.facet.efacet.impl.QueryFacetElementImpl <em>Query Facet Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.emf.facet.efacet.impl.QueryFacetElementImpl
	 * @see org.eclipse.papyrus.emf.facet.efacet.impl.EFacetPackageImpl#getQueryFacetElement()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	int QUERY_FACET_ELEMENT = 9;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int QUERY_FACET_ELEMENT__EANNOTATIONS = EFacetPackage.FACET_ELEMENT__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int QUERY_FACET_ELEMENT__NAME = EFacetPackage.FACET_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int QUERY_FACET_ELEMENT__ORDERED = EFacetPackage.FACET_ELEMENT__ORDERED;

	/**
	 * The feature id for the '<em><b>Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int QUERY_FACET_ELEMENT__UNIQUE = EFacetPackage.FACET_ELEMENT__UNIQUE;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int QUERY_FACET_ELEMENT__LOWER_BOUND = EFacetPackage.FACET_ELEMENT__LOWER_BOUND;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int QUERY_FACET_ELEMENT__UPPER_BOUND = EFacetPackage.FACET_ELEMENT__UPPER_BOUND;

	/**
	 * The feature id for the '<em><b>Many</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int QUERY_FACET_ELEMENT__MANY = EFacetPackage.FACET_ELEMENT__MANY;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int QUERY_FACET_ELEMENT__REQUIRED = EFacetPackage.FACET_ELEMENT__REQUIRED;

	/**
	 * The feature id for the '<em><b>EType</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int QUERY_FACET_ELEMENT__ETYPE = EFacetPackage.FACET_ELEMENT__ETYPE;

	/**
	 * The feature id for the '<em><b>EGeneric Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int QUERY_FACET_ELEMENT__EGENERIC_TYPE = EFacetPackage.FACET_ELEMENT__EGENERIC_TYPE;

	/**
	 * The feature id for the '<em><b>Categories</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int QUERY_FACET_ELEMENT__CATEGORIES = EFacetPackage.FACET_ELEMENT__CATEGORIES;

	/**
	 * The feature id for the '<em><b>Facet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int QUERY_FACET_ELEMENT__FACET = EFacetPackage.FACET_ELEMENT__FACET;

	/**
	 * The feature id for the '<em><b>Override</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int QUERY_FACET_ELEMENT__OVERRIDE = EFacetPackage.FACET_ELEMENT__OVERRIDE;

	/**
	 * The feature id for the '<em><b>Query</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int QUERY_FACET_ELEMENT__QUERY = EFacetPackage.FACET_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Query Facet Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int QUERY_FACET_ELEMENT_FEATURE_COUNT = EFacetPackage.FACET_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.emf.facet.efacet.impl.OppositeReferenceImpl <em>Opposite Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.emf.facet.efacet.impl.OppositeReferenceImpl
	 * @see org.eclipse.papyrus.emf.facet.efacet.impl.EFacetPackageImpl#getOppositeReference()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	int OPPOSITE_REFERENCE = 10;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int OPPOSITE_REFERENCE__EANNOTATIONS = EFacetPackage.FACET_ELEMENT__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int OPPOSITE_REFERENCE__NAME = EFacetPackage.FACET_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int OPPOSITE_REFERENCE__ORDERED = EFacetPackage.FACET_ELEMENT__ORDERED;

	/**
	 * The feature id for the '<em><b>Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int OPPOSITE_REFERENCE__UNIQUE = EFacetPackage.FACET_ELEMENT__UNIQUE;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int OPPOSITE_REFERENCE__LOWER_BOUND = EFacetPackage.FACET_ELEMENT__LOWER_BOUND;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int OPPOSITE_REFERENCE__UPPER_BOUND = EFacetPackage.FACET_ELEMENT__UPPER_BOUND;

	/**
	 * The feature id for the '<em><b>Many</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int OPPOSITE_REFERENCE__MANY = EFacetPackage.FACET_ELEMENT__MANY;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int OPPOSITE_REFERENCE__REQUIRED = EFacetPackage.FACET_ELEMENT__REQUIRED;

	/**
	 * The feature id for the '<em><b>EType</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int OPPOSITE_REFERENCE__ETYPE = EFacetPackage.FACET_ELEMENT__ETYPE;

	/**
	 * The feature id for the '<em><b>EGeneric Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int OPPOSITE_REFERENCE__EGENERIC_TYPE = EFacetPackage.FACET_ELEMENT__EGENERIC_TYPE;

	/**
	 * The feature id for the '<em><b>Categories</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int OPPOSITE_REFERENCE__CATEGORIES = EFacetPackage.FACET_ELEMENT__CATEGORIES;

	/**
	 * The feature id for the '<em><b>Facet</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int OPPOSITE_REFERENCE__FACET = EFacetPackage.FACET_ELEMENT__FACET;

	/**
	 * The feature id for the '<em><b>Override</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int OPPOSITE_REFERENCE__OVERRIDE = EFacetPackage.FACET_ELEMENT__OVERRIDE;

	/**
	 * The feature id for the '<em><b>FOpposite</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int OPPOSITE_REFERENCE__FOPPOSITE = EFacetPackage.FACET_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Opposite Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int OPPOSITE_REFERENCE_FEATURE_COUNT = EFacetPackage.FACET_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.emf.facet.efacet.impl.QuerySetImpl <em>Query Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.emf.facet.efacet.impl.QuerySetImpl
	 * @see org.eclipse.papyrus.emf.facet.efacet.impl.EFacetPackageImpl#getQuerySet()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	int QUERY_SET = 11;

	/**
	 * The feature id for the '<em><b>Queries</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int QUERY_SET__QUERIES = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int QUERY_SET__NAME = 1;

	/**
	 * The number of structural features of the '<em>Query Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int QUERY_SET_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.emf.facet.efacet.impl.LiteralImpl <em>Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.emf.facet.efacet.impl.LiteralImpl
	 * @see org.eclipse.papyrus.emf.facet.efacet.impl.EFacetPackageImpl#getLiteral()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	int LITERAL = 12;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int LITERAL__EANNOTATIONS = EFacetPackage.QUERY__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int LITERAL__NAME = EFacetPackage.QUERY__NAME;

	/**
	 * The feature id for the '<em><b>Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int LITERAL__ORDERED = EFacetPackage.QUERY__ORDERED;

	/**
	 * The feature id for the '<em><b>Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int LITERAL__UNIQUE = EFacetPackage.QUERY__UNIQUE;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int LITERAL__LOWER_BOUND = EFacetPackage.QUERY__LOWER_BOUND;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int LITERAL__UPPER_BOUND = EFacetPackage.QUERY__UPPER_BOUND;

	/**
	 * The feature id for the '<em><b>Many</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int LITERAL__MANY = EFacetPackage.QUERY__MANY;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int LITERAL__REQUIRED = EFacetPackage.QUERY__REQUIRED;

	/**
	 * The feature id for the '<em><b>EType</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int LITERAL__ETYPE = EFacetPackage.QUERY__ETYPE;

	/**
	 * The feature id for the '<em><b>EGeneric Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int LITERAL__EGENERIC_TYPE = EFacetPackage.QUERY__EGENERIC_TYPE;

	/**
	 * The feature id for the '<em><b>Scope</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int LITERAL__SCOPE = EFacetPackage.QUERY__SCOPE;

	/**
	 * The feature id for the '<em><b>Has Side Effect</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int LITERAL__HAS_SIDE_EFFECT = EFacetPackage.QUERY__HAS_SIDE_EFFECT;

	/**
	 * The feature id for the '<em><b>Can Be Cached</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int LITERAL__CAN_BE_CACHED = EFacetPackage.QUERY__CAN_BE_CACHED;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int LITERAL__PARAMETERS = EFacetPackage.QUERY__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int LITERAL__VALUE = EFacetPackage.QUERY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int LITERAL_FEATURE_COUNT = EFacetPackage.QUERY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.emf.facet.efacet.impl.TypedElementRefImpl <em>Typed Element Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.emf.facet.efacet.impl.TypedElementRefImpl
	 * @see org.eclipse.papyrus.emf.facet.efacet.impl.EFacetPackageImpl#getTypedElementRef()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	int TYPED_ELEMENT_REF = 13;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int TYPED_ELEMENT_REF__EANNOTATIONS = EFacetPackage.QUERY__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int TYPED_ELEMENT_REF__NAME = EFacetPackage.QUERY__NAME;

	/**
	 * The feature id for the '<em><b>Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int TYPED_ELEMENT_REF__ORDERED = EFacetPackage.QUERY__ORDERED;

	/**
	 * The feature id for the '<em><b>Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int TYPED_ELEMENT_REF__UNIQUE = EFacetPackage.QUERY__UNIQUE;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int TYPED_ELEMENT_REF__LOWER_BOUND = EFacetPackage.QUERY__LOWER_BOUND;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int TYPED_ELEMENT_REF__UPPER_BOUND = EFacetPackage.QUERY__UPPER_BOUND;

	/**
	 * The feature id for the '<em><b>Many</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int TYPED_ELEMENT_REF__MANY = EFacetPackage.QUERY__MANY;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int TYPED_ELEMENT_REF__REQUIRED = EFacetPackage.QUERY__REQUIRED;

	/**
	 * The feature id for the '<em><b>EType</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int TYPED_ELEMENT_REF__ETYPE = EFacetPackage.QUERY__ETYPE;

	/**
	 * The feature id for the '<em><b>EGeneric Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int TYPED_ELEMENT_REF__EGENERIC_TYPE = EFacetPackage.QUERY__EGENERIC_TYPE;

	/**
	 * The feature id for the '<em><b>Scope</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int TYPED_ELEMENT_REF__SCOPE = EFacetPackage.QUERY__SCOPE;

	/**
	 * The feature id for the '<em><b>Has Side Effect</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int TYPED_ELEMENT_REF__HAS_SIDE_EFFECT = EFacetPackage.QUERY__HAS_SIDE_EFFECT;

	/**
	 * The feature id for the '<em><b>Can Be Cached</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int TYPED_ELEMENT_REF__CAN_BE_CACHED = EFacetPackage.QUERY__CAN_BE_CACHED;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int TYPED_ELEMENT_REF__PARAMETERS = EFacetPackage.QUERY__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Typed Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int TYPED_ELEMENT_REF__TYPED_ELEMENT = EFacetPackage.QUERY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Typed Element Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int TYPED_ELEMENT_REF_FEATURE_COUNT = EFacetPackage.QUERY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.emf.facet.efacet.impl.ParameterImpl <em>Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.emf.facet.efacet.impl.ParameterImpl
	 * @see org.eclipse.papyrus.emf.facet.efacet.impl.EFacetPackageImpl#getParameter()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	int PARAMETER = 14;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int PARAMETER__EANNOTATIONS = EcorePackage.ETYPED_ELEMENT__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int PARAMETER__NAME = EcorePackage.ETYPED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int PARAMETER__ORDERED = EcorePackage.ETYPED_ELEMENT__ORDERED;

	/**
	 * The feature id for the '<em><b>Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int PARAMETER__UNIQUE = EcorePackage.ETYPED_ELEMENT__UNIQUE;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int PARAMETER__LOWER_BOUND = EcorePackage.ETYPED_ELEMENT__LOWER_BOUND;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int PARAMETER__UPPER_BOUND = EcorePackage.ETYPED_ELEMENT__UPPER_BOUND;

	/**
	 * The feature id for the '<em><b>Many</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int PARAMETER__MANY = EcorePackage.ETYPED_ELEMENT__MANY;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int PARAMETER__REQUIRED = EcorePackage.ETYPED_ELEMENT__REQUIRED;

	/**
	 * The feature id for the '<em><b>EType</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int PARAMETER__ETYPE = EcorePackage.ETYPED_ELEMENT__ETYPE;

	/**
	 * The feature id for the '<em><b>EGeneric Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int PARAMETER__EGENERIC_TYPE = EcorePackage.ETYPED_ELEMENT__EGENERIC_TYPE;

	/**
	 * The number of structural features of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int PARAMETER_FEATURE_COUNT = EcorePackage.ETYPED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.emf.facet.efacet.impl.ParameterValueImpl <em>Parameter Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.emf.facet.efacet.impl.ParameterValueImpl
	 * @see org.eclipse.papyrus.emf.facet.efacet.impl.EFacetPackageImpl#getParameterValue()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	int PARAMETER_VALUE = 15;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int PARAMETER_VALUE__PARAMETER = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int PARAMETER_VALUE__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Parameter Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int PARAMETER_VALUE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.emf.facet.efacet.impl.QueryContextImpl <em>Query Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.emf.facet.efacet.impl.QueryContextImpl
	 * @see org.eclipse.papyrus.emf.facet.efacet.impl.EFacetPackageImpl#getQueryContext()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	int QUERY_CONTEXT = 16;

	/**
	 * The feature id for the '<em><b>Selected Model Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int QUERY_CONTEXT__SELECTED_MODEL_ELEMENTS = 0;

	/**
	 * The feature id for the '<em><b>Selected Models</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int QUERY_CONTEXT__SELECTED_MODELS = 1;

	/**
	 * The number of structural features of the '<em>Query Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	int QUERY_CONTEXT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '<em>Java Exception</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Exception
	 * @see org.eclipse.papyrus.emf.facet.efacet.impl.EFacetPackageImpl#getJavaException()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	int JAVA_EXCEPTION = 17;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.emf.facet.efacet.FacetAttribute <em>Facet Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Facet Attribute</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.FacetAttribute
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	EClass getFacetAttribute();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.emf.facet.efacet.FacetReference <em>Facet Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Facet Reference</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.FacetReference
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	EClass getFacetReference();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.emf.facet.efacet.FacetOperation <em>Facet Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Facet Operation</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.FacetOperation
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	EClass getFacetOperation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.emf.facet.efacet.FacetSet <em>Facet Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Facet Set</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.FacetSet
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	EClass getFacetSet();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.emf.facet.efacet.FacetSet#getFacets <em>Facets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Facets</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.FacetSet#getFacets()
	 * @see #getFacetSet()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	EReference getFacetSet_Facets();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.emf.facet.efacet.FacetSet#getCategories <em>Categories</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Categories</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.FacetSet#getCategories()
	 * @see #getFacetSet()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	EReference getFacetSet_Categories();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.emf.facet.efacet.FacetSet#getExtendedEPackage <em>Extended EPackage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Extended EPackage</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.FacetSet#getExtendedEPackage()
	 * @see #getFacetSet()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	EReference getFacetSet_ExtendedEPackage();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.emf.facet.efacet.Facet <em>Facet</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Facet</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.Facet
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	EClass getFacet();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.papyrus.emf.facet.efacet.Facet#getFacetSet <em>Facet Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Facet Set</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.Facet#getFacetSet()
	 * @see #getFacet()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	EReference getFacet_FacetSet();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.emf.facet.efacet.Facet#getConformanceQuery <em>Conformance Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Conformance Query</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.Facet#getConformanceQuery()
	 * @see #getFacet()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	EReference getFacet_ConformanceQuery();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.emf.facet.efacet.Facet#getExtendedMetaclass <em>Extended Metaclass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Extended Metaclass</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.Facet#getExtendedMetaclass()
	 * @see #getFacet()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	EReference getFacet_ExtendedMetaclass();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.emf.facet.efacet.Facet#getFacetElements <em>Facet Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Facet Elements</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.Facet#getFacetElements()
	 * @see #getFacet()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	EReference getFacet_FacetElements();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.emf.facet.efacet.Query <em>Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Query</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.Query
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	EClass getQuery();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.emf.facet.efacet.Query#getScope <em>Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Scope</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.Query#getScope()
	 * @see #getQuery()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	EReference getQuery_Scope();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.emf.facet.efacet.Query#isHasSideEffect <em>Has Side Effect</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Has Side Effect</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.Query#isHasSideEffect()
	 * @see #getQuery()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	EAttribute getQuery_HasSideEffect();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.emf.facet.efacet.Query#isCanBeCached <em>Can Be Cached</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Can Be Cached</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.Query#isCanBeCached()
	 * @see #getQuery()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	EAttribute getQuery_CanBeCached();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.emf.facet.efacet.Query#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.Query#getParameters()
	 * @see #getQuery()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	EReference getQuery_Parameters();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.emf.facet.efacet.QueryResult <em>Query Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Query Result</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.QueryResult
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	EClass getQueryResult();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.emf.facet.efacet.QueryResult#getQuery <em>Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Query</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.QueryResult#getQuery()
	 * @see #getQueryResult()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	EReference getQueryResult_Query();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.emf.facet.efacet.QueryResult#getScope <em>Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Scope</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.QueryResult#getScope()
	 * @see #getQueryResult()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	EReference getQueryResult_Scope();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.emf.facet.efacet.QueryResult#getParameterValues <em>Parameter Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameter Values</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.QueryResult#getParameterValues()
	 * @see #getQueryResult()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	EReference getQueryResult_ParameterValues();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.emf.facet.efacet.QueryResult#getResult <em>Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Result</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.QueryResult#getResult()
	 * @see #getQueryResult()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	EAttribute getQueryResult_Result();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.emf.facet.efacet.QueryResult#getException <em>Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Exception</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.QueryResult#getException()
	 * @see #getQueryResult()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	EAttribute getQueryResult_Exception();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.emf.facet.efacet.QueryResult#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.QueryResult#getSource()
	 * @see #getQueryResult()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	EReference getQueryResult_Source();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.emf.facet.efacet.Category <em>Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Category</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.Category
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	EClass getCategory();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.emf.facet.efacet.FacetElement <em>Facet Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Facet Element</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.FacetElement
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	EClass getFacetElement();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.emf.facet.efacet.FacetElement#getCategories <em>Categories</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Categories</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.FacetElement#getCategories()
	 * @see #getFacetElement()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	EReference getFacetElement_Categories();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.papyrus.emf.facet.efacet.FacetElement#getFacet <em>Facet</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Facet</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.FacetElement#getFacet()
	 * @see #getFacetElement()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	EReference getFacetElement_Facet();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.emf.facet.efacet.FacetElement#getOverride <em>Override</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Override</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.FacetElement#getOverride()
	 * @see #getFacetElement()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	EReference getFacetElement_Override();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.emf.facet.efacet.QueryFacetElement <em>Query Facet Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Query Facet Element</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.QueryFacetElement
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	EClass getQueryFacetElement();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.emf.facet.efacet.QueryFacetElement#getQuery <em>Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Query</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.QueryFacetElement#getQuery()
	 * @see #getQueryFacetElement()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	EReference getQueryFacetElement_Query();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.emf.facet.efacet.OppositeReference <em>Opposite Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Opposite Reference</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.OppositeReference
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	EClass getOppositeReference();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.emf.facet.efacet.OppositeReference#getFOpposite <em>FOpposite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>FOpposite</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.OppositeReference#getFOpposite()
	 * @see #getOppositeReference()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	EReference getOppositeReference_FOpposite();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.emf.facet.efacet.QuerySet <em>Query Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Query Set</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.QuerySet
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	EClass getQuerySet();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.emf.facet.efacet.QuerySet#getQueries <em>Queries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Queries</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.QuerySet#getQueries()
	 * @see #getQuerySet()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	EReference getQuerySet_Queries();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.emf.facet.efacet.QuerySet#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.QuerySet#getName()
	 * @see #getQuerySet()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	EAttribute getQuerySet_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.emf.facet.efacet.Literal <em>Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.Literal
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	EClass getLiteral();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.emf.facet.efacet.Literal#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.Literal#getValue()
	 * @see #getLiteral()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	EAttribute getLiteral_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.emf.facet.efacet.TypedElementRef <em>Typed Element Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Typed Element Ref</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.TypedElementRef
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	EClass getTypedElementRef();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.emf.facet.efacet.TypedElementRef#getTypedElement <em>Typed Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Typed Element</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.TypedElementRef#getTypedElement()
	 * @see #getTypedElementRef()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	EReference getTypedElementRef_TypedElement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.emf.facet.efacet.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.Parameter
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	EClass getParameter();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.emf.facet.efacet.ParameterValue <em>Parameter Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter Value</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.ParameterValue
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	EClass getParameterValue();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.emf.facet.efacet.ParameterValue#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parameter</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.ParameterValue#getParameter()
	 * @see #getParameterValue()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	EReference getParameterValue_Parameter();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.emf.facet.efacet.ParameterValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Value</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.ParameterValue#getValue()
	 * @see #getParameterValue()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	EAttribute getParameterValue_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.emf.facet.efacet.QueryContext <em>Query Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Query Context</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.QueryContext
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	EClass getQueryContext();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.emf.facet.efacet.QueryContext#getSelectedModelElements <em>Selected Model Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Selected Model Elements</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.QueryContext#getSelectedModelElements()
	 * @see #getQueryContext()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	EReference getQueryContext_SelectedModelElements();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.emf.facet.efacet.QueryContext#getSelectedModels <em>Selected Models</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Selected Models</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.QueryContext#getSelectedModels()
	 * @see #getQueryContext()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	EAttribute getQueryContext_SelectedModels();

	/**
	 * Returns the meta object for data type '{@link java.lang.Exception <em>Java Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Java Exception</em>'.
	 * @see java.lang.Exception
	 * @model instanceClass="java.lang.Exception"
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	EDataType getJavaException();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
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
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.emf.facet.efacet.impl.FacetAttributeImpl <em>Facet Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.emf.facet.efacet.impl.FacetAttributeImpl
		 * @see org.eclipse.papyrus.emf.facet.efacet.impl.EFacetPackageImpl#getFacetAttribute()
		 * @generated
		 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
		 */
		@Deprecated
		EClass FACET_ATTRIBUTE = EFacetPackage.eINSTANCE.getFacetAttribute();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.emf.facet.efacet.impl.FacetReferenceImpl <em>Facet Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.emf.facet.efacet.impl.FacetReferenceImpl
		 * @see org.eclipse.papyrus.emf.facet.efacet.impl.EFacetPackageImpl#getFacetReference()
		 * @generated
		 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
		 */
		@Deprecated
		EClass FACET_REFERENCE = EFacetPackage.eINSTANCE.getFacetReference();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.emf.facet.efacet.impl.FacetOperationImpl <em>Facet Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.emf.facet.efacet.impl.FacetOperationImpl
		 * @see org.eclipse.papyrus.emf.facet.efacet.impl.EFacetPackageImpl#getFacetOperation()
		 * @generated
		 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
		 */
		@Deprecated
		EClass FACET_OPERATION = EFacetPackage.eINSTANCE.getFacetOperation();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.emf.facet.efacet.impl.FacetSetImpl <em>Facet Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.emf.facet.efacet.impl.FacetSetImpl
		 * @see org.eclipse.papyrus.emf.facet.efacet.impl.EFacetPackageImpl#getFacetSet()
		 * @generated
		 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
		 */
		@Deprecated
		EClass FACET_SET = EFacetPackage.eINSTANCE.getFacetSet();

		/**
		 * The meta object literal for the '<em><b>Facets</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
		 */
		@Deprecated
		EReference FACET_SET__FACETS = EFacetPackage.eINSTANCE.getFacetSet_Facets();

		/**
		 * The meta object literal for the '<em><b>Categories</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
		 */
		@Deprecated
		EReference FACET_SET__CATEGORIES = EFacetPackage.eINSTANCE.getFacetSet_Categories();

		/**
		 * The meta object literal for the '<em><b>Extended EPackage</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
		 */
		@Deprecated
		EReference FACET_SET__EXTENDED_EPACKAGE = EFacetPackage.eINSTANCE.getFacetSet_ExtendedEPackage();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.emf.facet.efacet.impl.FacetImpl <em>Facet</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.emf.facet.efacet.impl.FacetImpl
		 * @see org.eclipse.papyrus.emf.facet.efacet.impl.EFacetPackageImpl#getFacet()
		 * @generated
		 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
		 */
		@Deprecated
		EClass FACET = EFacetPackage.eINSTANCE.getFacet();

		/**
		 * The meta object literal for the '<em><b>Facet Set</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
		 */
		@Deprecated
		EReference FACET__FACET_SET = EFacetPackage.eINSTANCE.getFacet_FacetSet();

		/**
		 * The meta object literal for the '<em><b>Conformance Query</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
		 */
		@Deprecated
		EReference FACET__CONFORMANCE_QUERY = EFacetPackage.eINSTANCE.getFacet_ConformanceQuery();

		/**
		 * The meta object literal for the '<em><b>Extended Metaclass</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
		 */
		@Deprecated
		EReference FACET__EXTENDED_METACLASS = EFacetPackage.eINSTANCE.getFacet_ExtendedMetaclass();

		/**
		 * The meta object literal for the '<em><b>Facet Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
		 */
		@Deprecated
		EReference FACET__FACET_ELEMENTS = EFacetPackage.eINSTANCE.getFacet_FacetElements();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.emf.facet.efacet.impl.QueryImpl <em>Query</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.emf.facet.efacet.impl.QueryImpl
		 * @see org.eclipse.papyrus.emf.facet.efacet.impl.EFacetPackageImpl#getQuery()
		 * @generated
		 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
		 */
		@Deprecated
		EClass QUERY = EFacetPackage.eINSTANCE.getQuery();

		/**
		 * The meta object literal for the '<em><b>Scope</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
		 */
		@Deprecated
		EReference QUERY__SCOPE = EFacetPackage.eINSTANCE.getQuery_Scope();

		/**
		 * The meta object literal for the '<em><b>Has Side Effect</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
		 */
		@Deprecated
		EAttribute QUERY__HAS_SIDE_EFFECT = EFacetPackage.eINSTANCE.getQuery_HasSideEffect();

		/**
		 * The meta object literal for the '<em><b>Can Be Cached</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
		 */
		@Deprecated
		EAttribute QUERY__CAN_BE_CACHED = EFacetPackage.eINSTANCE.getQuery_CanBeCached();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
		 */
		@Deprecated
		EReference QUERY__PARAMETERS = EFacetPackage.eINSTANCE.getQuery_Parameters();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.emf.facet.efacet.impl.QueryResultImpl <em>Query Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.emf.facet.efacet.impl.QueryResultImpl
		 * @see org.eclipse.papyrus.emf.facet.efacet.impl.EFacetPackageImpl#getQueryResult()
		 * @generated
		 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
		 */
		@Deprecated
		EClass QUERY_RESULT = EFacetPackage.eINSTANCE.getQueryResult();

		/**
		 * The meta object literal for the '<em><b>Query</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
		 */
		@Deprecated
		EReference QUERY_RESULT__QUERY = EFacetPackage.eINSTANCE.getQueryResult_Query();

		/**
		 * The meta object literal for the '<em><b>Scope</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
		 */
		@Deprecated
		EReference QUERY_RESULT__SCOPE = EFacetPackage.eINSTANCE.getQueryResult_Scope();

		/**
		 * The meta object literal for the '<em><b>Parameter Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
		 */
		@Deprecated
		EReference QUERY_RESULT__PARAMETER_VALUES = EFacetPackage.eINSTANCE.getQueryResult_ParameterValues();

		/**
		 * The meta object literal for the '<em><b>Result</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
		 */
		@Deprecated
		EAttribute QUERY_RESULT__RESULT = EFacetPackage.eINSTANCE.getQueryResult_Result();

		/**
		 * The meta object literal for the '<em><b>Exception</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
		 */
		@Deprecated
		EAttribute QUERY_RESULT__EXCEPTION = EFacetPackage.eINSTANCE.getQueryResult_Exception();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
		 */
		@Deprecated
		EReference QUERY_RESULT__SOURCE = EFacetPackage.eINSTANCE.getQueryResult_Source();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.emf.facet.efacet.impl.CategoryImpl <em>Category</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.emf.facet.efacet.impl.CategoryImpl
		 * @see org.eclipse.papyrus.emf.facet.efacet.impl.EFacetPackageImpl#getCategory()
		 * @generated
		 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
		 */
		@Deprecated
		EClass CATEGORY = EFacetPackage.eINSTANCE.getCategory();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.emf.facet.efacet.impl.FacetElementImpl <em>Facet Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.emf.facet.efacet.impl.FacetElementImpl
		 * @see org.eclipse.papyrus.emf.facet.efacet.impl.EFacetPackageImpl#getFacetElement()
		 * @generated
		 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
		 */
		@Deprecated
		EClass FACET_ELEMENT = EFacetPackage.eINSTANCE.getFacetElement();

		/**
		 * The meta object literal for the '<em><b>Categories</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
		 */
		@Deprecated
		EReference FACET_ELEMENT__CATEGORIES = EFacetPackage.eINSTANCE.getFacetElement_Categories();

		/**
		 * The meta object literal for the '<em><b>Facet</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
		 */
		@Deprecated
		EReference FACET_ELEMENT__FACET = EFacetPackage.eINSTANCE.getFacetElement_Facet();

		/**
		 * The meta object literal for the '<em><b>Override</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
		 */
		@Deprecated
		EReference FACET_ELEMENT__OVERRIDE = EFacetPackage.eINSTANCE.getFacetElement_Override();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.emf.facet.efacet.impl.QueryFacetElementImpl <em>Query Facet Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.emf.facet.efacet.impl.QueryFacetElementImpl
		 * @see org.eclipse.papyrus.emf.facet.efacet.impl.EFacetPackageImpl#getQueryFacetElement()
		 * @generated
		 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
		 */
		@Deprecated
		EClass QUERY_FACET_ELEMENT = EFacetPackage.eINSTANCE.getQueryFacetElement();

		/**
		 * The meta object literal for the '<em><b>Query</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
		 */
		@Deprecated
		EReference QUERY_FACET_ELEMENT__QUERY = EFacetPackage.eINSTANCE.getQueryFacetElement_Query();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.emf.facet.efacet.impl.OppositeReferenceImpl <em>Opposite Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.emf.facet.efacet.impl.OppositeReferenceImpl
		 * @see org.eclipse.papyrus.emf.facet.efacet.impl.EFacetPackageImpl#getOppositeReference()
		 * @generated
		 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
		 */
		@Deprecated
		EClass OPPOSITE_REFERENCE = EFacetPackage.eINSTANCE.getOppositeReference();

		/**
		 * The meta object literal for the '<em><b>FOpposite</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
		 */
		@Deprecated
		EReference OPPOSITE_REFERENCE__FOPPOSITE = EFacetPackage.eINSTANCE.getOppositeReference_FOpposite();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.emf.facet.efacet.impl.QuerySetImpl <em>Query Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.emf.facet.efacet.impl.QuerySetImpl
		 * @see org.eclipse.papyrus.emf.facet.efacet.impl.EFacetPackageImpl#getQuerySet()
		 * @generated
		 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
		 */
		@Deprecated
		EClass QUERY_SET = EFacetPackage.eINSTANCE.getQuerySet();

		/**
		 * The meta object literal for the '<em><b>Queries</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
		 */
		@Deprecated
		EReference QUERY_SET__QUERIES = EFacetPackage.eINSTANCE.getQuerySet_Queries();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
		 */
		@Deprecated
		EAttribute QUERY_SET__NAME = EFacetPackage.eINSTANCE.getQuerySet_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.emf.facet.efacet.impl.LiteralImpl <em>Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.emf.facet.efacet.impl.LiteralImpl
		 * @see org.eclipse.papyrus.emf.facet.efacet.impl.EFacetPackageImpl#getLiteral()
		 * @generated
		 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
		 */
		@Deprecated
		EClass LITERAL = EFacetPackage.eINSTANCE.getLiteral();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
		 */
		@Deprecated
		EAttribute LITERAL__VALUE = EFacetPackage.eINSTANCE.getLiteral_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.emf.facet.efacet.impl.TypedElementRefImpl <em>Typed Element Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.emf.facet.efacet.impl.TypedElementRefImpl
		 * @see org.eclipse.papyrus.emf.facet.efacet.impl.EFacetPackageImpl#getTypedElementRef()
		 * @generated
		 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
		 */
		@Deprecated
		EClass TYPED_ELEMENT_REF = EFacetPackage.eINSTANCE.getTypedElementRef();

		/**
		 * The meta object literal for the '<em><b>Typed Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
		 */
		@Deprecated
		EReference TYPED_ELEMENT_REF__TYPED_ELEMENT = EFacetPackage.eINSTANCE.getTypedElementRef_TypedElement();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.emf.facet.efacet.impl.ParameterImpl <em>Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.emf.facet.efacet.impl.ParameterImpl
		 * @see org.eclipse.papyrus.emf.facet.efacet.impl.EFacetPackageImpl#getParameter()
		 * @generated
		 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
		 */
		@Deprecated
		EClass PARAMETER = EFacetPackage.eINSTANCE.getParameter();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.emf.facet.efacet.impl.ParameterValueImpl <em>Parameter Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.emf.facet.efacet.impl.ParameterValueImpl
		 * @see org.eclipse.papyrus.emf.facet.efacet.impl.EFacetPackageImpl#getParameterValue()
		 * @generated
		 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
		 */
		@Deprecated
		EClass PARAMETER_VALUE = EFacetPackage.eINSTANCE.getParameterValue();

		/**
		 * The meta object literal for the '<em><b>Parameter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
		 */
		@Deprecated
		EReference PARAMETER_VALUE__PARAMETER = EFacetPackage.eINSTANCE.getParameterValue_Parameter();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
		 */
		@Deprecated
		EAttribute PARAMETER_VALUE__VALUE = EFacetPackage.eINSTANCE.getParameterValue_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.emf.facet.efacet.impl.QueryContextImpl <em>Query Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.emf.facet.efacet.impl.QueryContextImpl
		 * @see org.eclipse.papyrus.emf.facet.efacet.impl.EFacetPackageImpl#getQueryContext()
		 * @generated
		 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
		 */
		@Deprecated
		EClass QUERY_CONTEXT = EFacetPackage.eINSTANCE.getQueryContext();

		/**
		 * The meta object literal for the '<em><b>Selected Model Elements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
		 */
		@Deprecated
		EReference QUERY_CONTEXT__SELECTED_MODEL_ELEMENTS = EFacetPackage.eINSTANCE.getQueryContext_SelectedModelElements();

		/**
		 * The meta object literal for the '<em><b>Selected Models</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
		 */
		@Deprecated
		EAttribute QUERY_CONTEXT__SELECTED_MODELS = EFacetPackage.eINSTANCE.getQueryContext_SelectedModels();

		/**
		 * The meta object literal for the '<em>Java Exception</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Exception
		 * @see org.eclipse.papyrus.emf.facet.efacet.impl.EFacetPackageImpl#getJavaException()
		 * @generated
		 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
		 */
		@Deprecated
		EDataType JAVA_EXCEPTION = EFacetPackage.eINSTANCE.getJavaException();

	}

} //EFacetPackage
