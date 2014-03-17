/**
 *  Copyright (c) 2013 Soft-Maint.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 * 		David Couvrand (Soft-Maint) - Bug 402725 - Need a query to get an image from an URI
 *  	Nicolas Rault (Soft-Maint) - Bug 402725 - Need a query to get an image from an URI
 */
package org.eclipse.papyrus.emf.facet.custom.metamodel.v0_3_0.query;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.ExtensiblePackage;

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
 * @see org.eclipse.papyrus.emf.facet.custom.metamodel.v0_3_0.query.QueryFactory
 * @model kind="package"
 * @generated
 */
public interface QueryPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "query";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/emf/facet/custom/0.3.incubation/query";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "customQuery";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	QueryPackage eINSTANCE = org.eclipse.papyrus.emf.facet.custom.metamodel.v0_3_0.query.impl.QueryPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.emf.facet.custom.metamodel.v0_3_0.query.impl.URIImageQueryImpl <em>URI Image Query</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.emf.facet.custom.metamodel.v0_3_0.query.impl.URIImageQueryImpl
	 * @see org.eclipse.papyrus.emf.facet.custom.metamodel.v0_3_0.query.impl.QueryPackageImpl#getURIImageQuery()
	 * @generated
	 */
	int URI_IMAGE_QUERY = 0;

	/**
	 * The feature id for the '<em><b>Can Have Side Effects</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URI_IMAGE_QUERY__CAN_HAVE_SIDE_EFFECTS = ExtensiblePackage.QUERY__CAN_HAVE_SIDE_EFFECTS;

	/**
	 * The feature id for the '<em><b>Can Be Cached</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URI_IMAGE_QUERY__CAN_BE_CACHED = ExtensiblePackage.QUERY__CAN_BE_CACHED;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URI_IMAGE_QUERY__URI = ExtensiblePackage.QUERY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>URI Image Query</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URI_IMAGE_QUERY_FEATURE_COUNT = ExtensiblePackage.QUERY_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.emf.facet.custom.metamodel.v0_3_0.query.URIImageQuery <em>URI Image Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>URI Image Query</em>'.
	 * @see org.eclipse.papyrus.emf.facet.custom.metamodel.v0_3_0.query.URIImageQuery
	 * @generated
	 */
	EClass getURIImageQuery();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.emf.facet.custom.metamodel.v0_3_0.query.URIImageQuery#getUri <em>Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uri</em>'.
	 * @see org.eclipse.papyrus.emf.facet.custom.metamodel.v0_3_0.query.URIImageQuery#getUri()
	 * @see #getURIImageQuery()
	 * @generated
	 */
	EAttribute getURIImageQuery_Uri();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	QueryFactory getQueryFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.emf.facet.custom.metamodel.v0_3_0.query.impl.URIImageQueryImpl <em>URI Image Query</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.emf.facet.custom.metamodel.v0_3_0.query.impl.URIImageQueryImpl
		 * @see org.eclipse.papyrus.emf.facet.custom.metamodel.v0_3_0.query.impl.QueryPackageImpl#getURIImageQuery()
		 * @generated
		 */
		EClass URI_IMAGE_QUERY = eINSTANCE.getURIImageQuery();

		/**
		 * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute URI_IMAGE_QUERY__URI = eINSTANCE.getURIImageQuery_Uri();

	}

} //QueryPackage
