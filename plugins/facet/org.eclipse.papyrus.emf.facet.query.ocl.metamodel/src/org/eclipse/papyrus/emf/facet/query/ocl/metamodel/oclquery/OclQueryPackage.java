/**
 *  Copyright (c) 2012 Mia-Software.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 * 	Alban Ménager (Soft-Maint) - Bug 387470 - [EFacet][Custom] Editors
 * 
 * 
 */
package org.eclipse.emf.facet.query.ocl.metamodel.oclquery;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.ExtensiblePackage;

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
 * @see org.eclipse.emf.facet.query.ocl.metamodel.oclquery.OclQueryFactory
 * @model kind="package"
 * @generated
 */
public interface OclQueryPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "oclquery";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/emf/facet/query/ocl/0.3.incubation/oclquery";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "oclQuery";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	OclQueryPackage eINSTANCE = org.eclipse.emf.facet.query.ocl.metamodel.oclquery.impl.OclQueryPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.emf.facet.query.ocl.metamodel.oclquery.impl.OclQueryImpl <em>Ocl Query</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.facet.query.ocl.metamodel.oclquery.impl.OclQueryImpl
	 * @see org.eclipse.emf.facet.query.ocl.metamodel.oclquery.impl.OclQueryPackageImpl#getOclQuery()
	 * @generated
	 */
	int OCL_QUERY = 0;

	/**
	 * The feature id for the '<em><b>Can Have Side Effects</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_QUERY__CAN_HAVE_SIDE_EFFECTS = ExtensiblePackage.QUERY__CAN_HAVE_SIDE_EFFECTS;

	/**
	 * The feature id for the '<em><b>Can Be Cached</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_QUERY__CAN_BE_CACHED = ExtensiblePackage.QUERY__CAN_BE_CACHED;

	/**
	 * The feature id for the '<em><b>Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_QUERY__CONTEXT = ExtensiblePackage.QUERY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ocl Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_QUERY__OCL_EXPRESSION = ExtensiblePackage.QUERY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Ocl Query</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_QUERY_FEATURE_COUNT = ExtensiblePackage.QUERY_FEATURE_COUNT + 2;


	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.facet.query.ocl.metamodel.oclquery.OclQuery <em>Ocl Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ocl Query</em>'.
	 * @see org.eclipse.emf.facet.query.ocl.metamodel.oclquery.OclQuery
	 * @generated
	 */
	EClass getOclQuery();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.facet.query.ocl.metamodel.oclquery.OclQuery#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Context</em>'.
	 * @see org.eclipse.emf.facet.query.ocl.metamodel.oclquery.OclQuery#getContext()
	 * @see #getOclQuery()
	 * @generated
	 */
	EReference getOclQuery_Context();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.facet.query.ocl.metamodel.oclquery.OclQuery#getOclExpression <em>Ocl Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ocl Expression</em>'.
	 * @see org.eclipse.emf.facet.query.ocl.metamodel.oclquery.OclQuery#getOclExpression()
	 * @see #getOclQuery()
	 * @generated
	 */
	EAttribute getOclQuery_OclExpression();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	OclQueryFactory getOclQueryFactory();

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
		 * The meta object literal for the '{@link org.eclipse.emf.facet.query.ocl.metamodel.oclquery.impl.OclQueryImpl <em>Ocl Query</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.facet.query.ocl.metamodel.oclquery.impl.OclQueryImpl
		 * @see org.eclipse.emf.facet.query.ocl.metamodel.oclquery.impl.OclQueryPackageImpl#getOclQuery()
		 * @generated
		 */
		EClass OCL_QUERY = eINSTANCE.getOclQuery();

		/**
		 * The meta object literal for the '<em><b>Context</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OCL_QUERY__CONTEXT = eINSTANCE.getOclQuery_Context();

		/**
		 * The meta object literal for the '<em><b>Ocl Expression</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OCL_QUERY__OCL_EXPRESSION = eINSTANCE.getOclQuery_OclExpression();

	}

} //OclQueryPackage
