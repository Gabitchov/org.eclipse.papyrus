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
 *   Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *   Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.infra.emf.facet.queries.parametricquery;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.facet.infra.query.QueryPackage;

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
 * @see org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.ParametricqueryFactory
 * @model kind="package"
 * @generated
 */
public interface ParametricqueryPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "parametricquery"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/infra/emf/facet/parametric/query/0.9.1"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "paramQuery"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ParametricqueryPackage eINSTANCE = org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.impl.ParametricqueryPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.impl.ParametricQueryImpl <em>Parametric Query</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.impl.ParametricQueryImpl
	 * @see org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.impl.ParametricqueryPackageImpl#getParametricQuery()
	 * @generated
	 */
	int PARAMETRIC_QUERY = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETRIC_QUERY__NAME = QueryPackage.MODEL_QUERY__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETRIC_QUERY__DESCRIPTION = QueryPackage.MODEL_QUERY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Return Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETRIC_QUERY__RETURN_TYPE = QueryPackage.MODEL_QUERY__RETURN_TYPE;

	/**
	 * The feature id for the '<em><b>Scope</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETRIC_QUERY__SCOPE = QueryPackage.MODEL_QUERY__SCOPE;

	/**
	 * The feature id for the '<em><b>Model Query Set</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETRIC_QUERY__MODEL_QUERY_SET = QueryPackage.MODEL_QUERY__MODEL_QUERY_SET;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETRIC_QUERY__PARAMETERS = QueryPackage.MODEL_QUERY__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Is External Context Dependent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETRIC_QUERY__IS_EXTERNAL_CONTEXT_DEPENDENT = QueryPackage.MODEL_QUERY__IS_EXTERNAL_CONTEXT_DEPENDENT;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETRIC_QUERY__UPPER_BOUND = QueryPackage.MODEL_QUERY__UPPER_BOUND;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETRIC_QUERY__LOWER_BOUND = QueryPackage.MODEL_QUERY__LOWER_BOUND;

	/**
	 * The feature id for the '<em><b>Called Query</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETRIC_QUERY__CALLED_QUERY = QueryPackage.MODEL_QUERY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETRIC_QUERY__ARGUMENTS = QueryPackage.MODEL_QUERY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Parametric Query</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETRIC_QUERY_FEATURE_COUNT = QueryPackage.MODEL_QUERY_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.impl.ArgumentImpl <em>Argument</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.impl.ArgumentImpl
	 * @see org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.impl.ParametricqueryPackageImpl#getArgument()
	 * @generated
	 */
	int ARGUMENT = 1;

	/**
	 * The number of structural features of the '<em>Argument</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.impl.StringArgumentImpl <em>String Argument</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.impl.StringArgumentImpl
	 * @see org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.impl.ParametricqueryPackageImpl#getStringArgument()
	 * @generated
	 */
	int STRING_ARGUMENT = 2;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_ARGUMENT__VALUE = ARGUMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>String Argument</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_ARGUMENT_FEATURE_COUNT = ARGUMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.impl.EStructuralFeatureArgumentImpl <em>EStructural Feature Argument</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.impl.EStructuralFeatureArgumentImpl
	 * @see org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.impl.ParametricqueryPackageImpl#getEStructuralFeatureArgument()
	 * @generated
	 */
	int ESTRUCTURAL_FEATURE_ARGUMENT = 3;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRUCTURAL_FEATURE_ARGUMENT__VALUE = ARGUMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>EStructural Feature Argument</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRUCTURAL_FEATURE_ARGUMENT_FEATURE_COUNT = ARGUMENT_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.ParametricQuery <em>Parametric Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parametric Query</em>'.
	 * @see org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.ParametricQuery
	 * @generated
	 */
	EClass getParametricQuery();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.ParametricQuery#getCalledQuery <em>Called Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Called Query</em>'.
	 * @see org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.ParametricQuery#getCalledQuery()
	 * @see #getParametricQuery()
	 * @generated
	 */
	EReference getParametricQuery_CalledQuery();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.ParametricQuery#getArguments <em>Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Arguments</em>'.
	 * @see org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.ParametricQuery#getArguments()
	 * @see #getParametricQuery()
	 * @generated
	 */
	EReference getParametricQuery_Arguments();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.Argument <em>Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Argument</em>'.
	 * @see org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.Argument
	 * @generated
	 */
	EClass getArgument();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.StringArgument <em>String Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Argument</em>'.
	 * @see org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.StringArgument
	 * @generated
	 */
	EClass getStringArgument();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.StringArgument#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.StringArgument#getValue()
	 * @see #getStringArgument()
	 * @generated
	 */
	EAttribute getStringArgument_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.EStructuralFeatureArgument <em>EStructural Feature Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EStructural Feature Argument</em>'.
	 * @see org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.EStructuralFeatureArgument
	 * @generated
	 */
	EClass getEStructuralFeatureArgument();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.EStructuralFeatureArgument#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.EStructuralFeatureArgument#getValue()
	 * @see #getEStructuralFeatureArgument()
	 * @generated
	 */
	EReference getEStructuralFeatureArgument_Value();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ParametricqueryFactory getParametricqueryFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.impl.ParametricQueryImpl <em>Parametric Query</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.impl.ParametricQueryImpl
		 * @see org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.impl.ParametricqueryPackageImpl#getParametricQuery()
		 * @generated
		 */
		EClass PARAMETRIC_QUERY = eINSTANCE.getParametricQuery();

		/**
		 * The meta object literal for the '<em><b>Called Query</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETRIC_QUERY__CALLED_QUERY = eINSTANCE.getParametricQuery_CalledQuery();

		/**
		 * The meta object literal for the '<em><b>Arguments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETRIC_QUERY__ARGUMENTS = eINSTANCE.getParametricQuery_Arguments();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.impl.ArgumentImpl <em>Argument</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.impl.ArgumentImpl
		 * @see org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.impl.ParametricqueryPackageImpl#getArgument()
		 * @generated
		 */
		EClass ARGUMENT = eINSTANCE.getArgument();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.impl.StringArgumentImpl <em>String Argument</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.impl.StringArgumentImpl
		 * @see org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.impl.ParametricqueryPackageImpl#getStringArgument()
		 * @generated
		 */
		EClass STRING_ARGUMENT = eINSTANCE.getStringArgument();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_ARGUMENT__VALUE = eINSTANCE.getStringArgument_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.impl.EStructuralFeatureArgumentImpl <em>EStructural Feature Argument</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.impl.EStructuralFeatureArgumentImpl
		 * @see org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.impl.ParametricqueryPackageImpl#getEStructuralFeatureArgument()
		 * @generated
		 */
		EClass ESTRUCTURAL_FEATURE_ARGUMENT = eINSTANCE.getEStructuralFeatureArgument();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ESTRUCTURAL_FEATURE_ARGUMENT__VALUE = eINSTANCE.getEStructuralFeatureArgument_Value();

	}

} //ParametricqueryPackage
