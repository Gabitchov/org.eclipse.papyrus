/**
 *  Copyright (c) 2011 Mia-Software.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *  	Nicolas Guyomar (Mia-Software) - Bug 334615 - Java Query for EMF Facet
 *  
 */
package org.eclipse.papyrus.emf.facet.query.java.javaquery;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.papyrus.emf.facet.efacet.EFacetPackage;

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
 * 
 * @see org.eclipse.papyrus.emf.facet.query.java.javaquery.JavaqueryFactory
 * @model kind="package"
 * @generated
 * @deprecated cf. https://bugs.eclipse.org/bugs/show_bug.cgi?id=374198
 */
@Deprecated
public interface JavaqueryPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "javaquery"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/emf/facet/query/java/0.1.incubation"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "javaQuery"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	JavaqueryPackage eINSTANCE = org.eclipse.papyrus.emf.facet.query.java.javaquery.impl.JavaqueryPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.emf.facet.query.java.javaquery.impl.JavaQueryImpl <em>Java Query</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.emf.facet.query.java.javaquery.impl.JavaQueryImpl
	 * @see org.eclipse.papyrus.emf.facet.query.java.javaquery.impl.JavaqueryPackageImpl#getJavaQuery()
	 * @generated
	 */
	int JAVA_QUERY = 0;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_QUERY__EANNOTATIONS = EFacetPackage.QUERY__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_QUERY__NAME = EFacetPackage.QUERY__NAME;

	/**
	 * The feature id for the '<em><b>Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_QUERY__ORDERED = EFacetPackage.QUERY__ORDERED;

	/**
	 * The feature id for the '<em><b>Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_QUERY__UNIQUE = EFacetPackage.QUERY__UNIQUE;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_QUERY__LOWER_BOUND = EFacetPackage.QUERY__LOWER_BOUND;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_QUERY__UPPER_BOUND = EFacetPackage.QUERY__UPPER_BOUND;

	/**
	 * The feature id for the '<em><b>Many</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_QUERY__MANY = EFacetPackage.QUERY__MANY;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_QUERY__REQUIRED = EFacetPackage.QUERY__REQUIRED;

	/**
	 * The feature id for the '<em><b>EType</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_QUERY__ETYPE = EFacetPackage.QUERY__ETYPE;

	/**
	 * The feature id for the '<em><b>EGeneric Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_QUERY__EGENERIC_TYPE = EFacetPackage.QUERY__EGENERIC_TYPE;

	/**
	 * The feature id for the '<em><b>Scope</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_QUERY__SCOPE = EFacetPackage.QUERY__SCOPE;

	/**
	 * The feature id for the '<em><b>Has Side Effect</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_QUERY__HAS_SIDE_EFFECT = EFacetPackage.QUERY__HAS_SIDE_EFFECT;

	/**
	 * The feature id for the '<em><b>Can Be Cached</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_QUERY__CAN_BE_CACHED = EFacetPackage.QUERY__CAN_BE_CACHED;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_QUERY__PARAMETERS = EFacetPackage.QUERY__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Implementation Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_QUERY__IMPLEMENTATION_CLASS_NAME = EFacetPackage.QUERY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Java Query</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_QUERY_FEATURE_COUNT = EFacetPackage.QUERY_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.emf.facet.query.java.javaquery.JavaQuery <em>Java Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Java Query</em>'.
	 * @see org.eclipse.papyrus.emf.facet.query.java.javaquery.JavaQuery
	 * @generated
	 */
	EClass getJavaQuery();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.emf.facet.query.java.javaquery.JavaQuery#getImplementationClassName <em>Implementation Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Implementation Class Name</em>'.
	 * @see org.eclipse.papyrus.emf.facet.query.java.javaquery.JavaQuery#getImplementationClassName()
	 * @see #getJavaQuery()
	 * @generated
	 */
	EAttribute getJavaQuery_ImplementationClassName();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	JavaqueryFactory getJavaqueryFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.emf.facet.query.java.javaquery.impl.JavaQueryImpl <em>Java Query</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.emf.facet.query.java.javaquery.impl.JavaQueryImpl
		 * @see org.eclipse.papyrus.emf.facet.query.java.javaquery.impl.JavaqueryPackageImpl#getJavaQuery()
		 * @generated
		 */
		EClass JAVA_QUERY = JavaqueryPackage.eINSTANCE.getJavaQuery();

		/**
		 * The meta object literal for the '<em><b>Implementation Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_QUERY__IMPLEMENTATION_CLASS_NAME = JavaqueryPackage.eINSTANCE.getJavaQuery_ImplementationClassName();

	}

} //JavaqueryPackage
