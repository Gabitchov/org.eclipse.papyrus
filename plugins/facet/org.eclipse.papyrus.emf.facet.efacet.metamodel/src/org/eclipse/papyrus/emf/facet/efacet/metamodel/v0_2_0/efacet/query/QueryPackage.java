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
 * 	Emmanuelle RouillÃ© (Mia-Software) - Bug 352618 - To be able to use non derived facet structural features and save them values. 
 * 	Nicolas Bros (Mia-Software) - Bug 361823 - [Restructuring] eFacet2 meta-model
 *  Gregoire Dupe (Mia-Software) - Bug 366055 - NavigationQuery
 *  Gregoire Dupe (Mia-Software) - Bug 369987 - [Restructuring][Table] Switch to the new customization and facet framework
 *  Gregoire Dupe (Mia-Software) - Bug 373078 - API Cleaning
 */
package org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.ExtensiblePackage;

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
 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.QueryFactory
 * @model kind="package"
 * @generated
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface QueryPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "query"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/emf/facet/efacet/0.2.incubation/efacet/query"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "query"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	QueryPackage eINSTANCE = org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.impl.QueryPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.impl.NavigationQueryImpl <em>Navigation Query</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.impl.NavigationQueryImpl
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.impl.QueryPackageImpl#getNavigationQuery()
	 * @generated
	 */
	int NAVIGATION_QUERY = 0;

	/**
	 * The feature id for the '<em><b>Can Have Side Effects</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_QUERY__CAN_HAVE_SIDE_EFFECTS = ExtensiblePackage.QUERY__CAN_HAVE_SIDE_EFFECTS;

	/**
	 * The feature id for the '<em><b>Can Be Cached</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_QUERY__CAN_BE_CACHED = ExtensiblePackage.QUERY__CAN_BE_CACHED;

	/**
	 * The feature id for the '<em><b>Path</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_QUERY__PATH = ExtensiblePackage.QUERY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Fail On Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_QUERY__FAIL_ON_ERROR = ExtensiblePackage.QUERY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Navigation Query</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_QUERY_FEATURE_COUNT = ExtensiblePackage.QUERY_FEATURE_COUNT + 2;


	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.impl.IsOneOfQueryImpl <em>Is One Of Query</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.impl.IsOneOfQueryImpl
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.impl.QueryPackageImpl#getIsOneOfQuery()
	 * @generated
	 */
	int IS_ONE_OF_QUERY = 1;

	/**
	 * The feature id for the '<em><b>Can Have Side Effects</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_ONE_OF_QUERY__CAN_HAVE_SIDE_EFFECTS = ExtensiblePackage.QUERY__CAN_HAVE_SIDE_EFFECTS;

	/**
	 * The feature id for the '<em><b>Can Be Cached</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_ONE_OF_QUERY__CAN_BE_CACHED = ExtensiblePackage.QUERY__CAN_BE_CACHED;

	/**
	 * The feature id for the '<em><b>Expected EObjects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_ONE_OF_QUERY__EXPECTED_EOBJECTS = ExtensiblePackage.QUERY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Is One Of Query</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_ONE_OF_QUERY_FEATURE_COUNT = ExtensiblePackage.QUERY_FEATURE_COUNT + 1;


	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.impl.StringLiteralQueryImpl <em>String Literal Query</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.impl.StringLiteralQueryImpl
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.impl.QueryPackageImpl#getStringLiteralQuery()
	 * @generated
	 */
	int STRING_LITERAL_QUERY = 2;

	/**
	 * The feature id for the '<em><b>Can Have Side Effects</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_QUERY__CAN_HAVE_SIDE_EFFECTS = ExtensiblePackage.QUERY__CAN_HAVE_SIDE_EFFECTS;

	/**
	 * The feature id for the '<em><b>Can Be Cached</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_QUERY__CAN_BE_CACHED = ExtensiblePackage.QUERY__CAN_BE_CACHED;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_QUERY__VALUE = ExtensiblePackage.QUERY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>String Literal Query</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_QUERY_FEATURE_COUNT = ExtensiblePackage.QUERY_FEATURE_COUNT + 1;


	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.impl.TrueLiteralQueryImpl <em>True Literal Query</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.impl.TrueLiteralQueryImpl
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.impl.QueryPackageImpl#getTrueLiteralQuery()
	 * @generated
	 */
	int TRUE_LITERAL_QUERY = 3;

	/**
	 * The feature id for the '<em><b>Can Have Side Effects</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUE_LITERAL_QUERY__CAN_HAVE_SIDE_EFFECTS = ExtensiblePackage.QUERY__CAN_HAVE_SIDE_EFFECTS;

	/**
	 * The feature id for the '<em><b>Can Be Cached</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUE_LITERAL_QUERY__CAN_BE_CACHED = ExtensiblePackage.QUERY__CAN_BE_CACHED;

	/**
	 * The number of structural features of the '<em>True Literal Query</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUE_LITERAL_QUERY_FEATURE_COUNT = ExtensiblePackage.QUERY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.impl.FalseLiteralQueryImpl <em>False Literal Query</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.impl.FalseLiteralQueryImpl
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.impl.QueryPackageImpl#getFalseLiteralQuery()
	 * @generated
	 */
	int FALSE_LITERAL_QUERY = 4;

	/**
	 * The feature id for the '<em><b>Can Have Side Effects</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FALSE_LITERAL_QUERY__CAN_HAVE_SIDE_EFFECTS = ExtensiblePackage.QUERY__CAN_HAVE_SIDE_EFFECTS;

	/**
	 * The feature id for the '<em><b>Can Be Cached</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FALSE_LITERAL_QUERY__CAN_BE_CACHED = ExtensiblePackage.QUERY__CAN_BE_CACHED;

	/**
	 * The number of structural features of the '<em>False Literal Query</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FALSE_LITERAL_QUERY_FEATURE_COUNT = ExtensiblePackage.QUERY_FEATURE_COUNT + 0;


	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.impl.NullLiteralQueryImpl <em>Null Literal Query</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.impl.NullLiteralQueryImpl
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.impl.QueryPackageImpl#getNullLiteralQuery()
	 * @generated
	 */
	int NULL_LITERAL_QUERY = 5;

	/**
	 * The feature id for the '<em><b>Can Have Side Effects</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL_QUERY__CAN_HAVE_SIDE_EFFECTS = ExtensiblePackage.QUERY__CAN_HAVE_SIDE_EFFECTS;

	/**
	 * The feature id for the '<em><b>Can Be Cached</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL_QUERY__CAN_BE_CACHED = ExtensiblePackage.QUERY__CAN_BE_CACHED;

	/**
	 * The number of structural features of the '<em>Null Literal Query</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL_QUERY_FEATURE_COUNT = ExtensiblePackage.QUERY_FEATURE_COUNT + 0;


	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.impl.IntegerLiteralQueryImpl <em>Integer Literal Query</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.impl.IntegerLiteralQueryImpl
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.impl.QueryPackageImpl#getIntegerLiteralQuery()
	 * @generated
	 * @since 0.2
	 */
	int INTEGER_LITERAL_QUERY = 6;

	/**
	 * The feature id for the '<em><b>Can Have Side Effects</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 * @since 0.2
	 */
	int INTEGER_LITERAL_QUERY__CAN_HAVE_SIDE_EFFECTS = ExtensiblePackage.QUERY__CAN_HAVE_SIDE_EFFECTS;

	/**
	 * The feature id for the '<em><b>Can Be Cached</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 * @since 0.2
	 */
	int INTEGER_LITERAL_QUERY__CAN_BE_CACHED = ExtensiblePackage.QUERY__CAN_BE_CACHED;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 * @since 0.2
	 */
	int INTEGER_LITERAL_QUERY__VALUE = ExtensiblePackage.QUERY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Integer Literal Query</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 * @since 0.2
	 */
	int INTEGER_LITERAL_QUERY_FEATURE_COUNT = ExtensiblePackage.QUERY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.impl.FloatLiteralQueryImpl <em>Float Literal Query</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.impl.FloatLiteralQueryImpl
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.impl.QueryPackageImpl#getFloatLiteralQuery()
	 * @generated
	 * @since 0.2
	 */
	int FLOAT_LITERAL_QUERY = 7;

	/**
	 * The feature id for the '<em><b>Can Have Side Effects</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 * @since 0.2
	 */
	int FLOAT_LITERAL_QUERY__CAN_HAVE_SIDE_EFFECTS = ExtensiblePackage.QUERY__CAN_HAVE_SIDE_EFFECTS;

	/**
	 * The feature id for the '<em><b>Can Be Cached</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 * @since 0.2
	 */
	int FLOAT_LITERAL_QUERY__CAN_BE_CACHED = ExtensiblePackage.QUERY__CAN_BE_CACHED;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 * @since 0.2
	 */
	int FLOAT_LITERAL_QUERY__VALUE = ExtensiblePackage.QUERY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Float Literal Query</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 * @since 0.2
	 */
	int FLOAT_LITERAL_QUERY_FEATURE_COUNT = ExtensiblePackage.QUERY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.impl.EObjectLiteralQueryImpl <em>EObject Literal Query</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.impl.EObjectLiteralQueryImpl
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.impl.QueryPackageImpl#getEObjectLiteralQuery()
	 * @generated
	 * @since 0.2
	 */
	int EOBJECT_LITERAL_QUERY = 8;

	/**
	 * The feature id for the '<em><b>Can Have Side Effects</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 * @since 0.2
	 */
	int EOBJECT_LITERAL_QUERY__CAN_HAVE_SIDE_EFFECTS = ExtensiblePackage.QUERY__CAN_HAVE_SIDE_EFFECTS;

	/**
	 * The feature id for the '<em><b>Can Be Cached</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 * @since 0.2
	 */
	int EOBJECT_LITERAL_QUERY__CAN_BE_CACHED = ExtensiblePackage.QUERY__CAN_BE_CACHED;

	/**
	 * The feature id for the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 * @since 0.2
	 */
	int EOBJECT_LITERAL_QUERY__ELEMENT = ExtensiblePackage.QUERY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>EObject Literal Query</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 * @since 0.2
	 */
	int EOBJECT_LITERAL_QUERY_FEATURE_COUNT = ExtensiblePackage.QUERY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.impl.OperationCallQueryImpl <em>Operation Call Query</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.impl.OperationCallQueryImpl
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.impl.QueryPackageImpl#getOperationCallQuery()
	 * @generated
	 * @since 0.2
	 */
	int OPERATION_CALL_QUERY = 9;

	/**
	 * The feature id for the '<em><b>Can Have Side Effects</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 * @since 0.2
	 */
	int OPERATION_CALL_QUERY__CAN_HAVE_SIDE_EFFECTS = ExtensiblePackage.QUERY__CAN_HAVE_SIDE_EFFECTS;

	/**
	 * The feature id for the '<em><b>Can Be Cached</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 * @since 0.2
	 */
	int OPERATION_CALL_QUERY__CAN_BE_CACHED = ExtensiblePackage.QUERY__CAN_BE_CACHED;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 * @since 0.2
	 */
	int OPERATION_CALL_QUERY__OPERATION = ExtensiblePackage.QUERY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 * @since 0.2
	 */
	int OPERATION_CALL_QUERY__ARGUMENTS = ExtensiblePackage.QUERY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Operation Call Query</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 * @since 0.2
	 */
	int OPERATION_CALL_QUERY_FEATURE_COUNT = ExtensiblePackage.QUERY_FEATURE_COUNT + 2;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.NavigationQuery <em>Navigation Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Navigation Query</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.NavigationQuery
	 * @generated
	 */
	EClass getNavigationQuery();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.NavigationQuery#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Path</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.NavigationQuery#getPath()
	 * @see #getNavigationQuery()
	 * @generated
	 */
	EReference getNavigationQuery_Path();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.NavigationQuery#isFailOnError <em>Fail On Error</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fail On Error</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.NavigationQuery#isFailOnError()
	 * @see #getNavigationQuery()
	 * @generated
	 */
	EAttribute getNavigationQuery_FailOnError();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.IsOneOfQuery <em>Is One Of Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Is One Of Query</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.IsOneOfQuery
	 * @generated
	 */
	EClass getIsOneOfQuery();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.IsOneOfQuery#getExpectedEObjects <em>Expected EObjects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Expected EObjects</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.IsOneOfQuery#getExpectedEObjects()
	 * @see #getIsOneOfQuery()
	 * @generated
	 */
	EReference getIsOneOfQuery_ExpectedEObjects();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.StringLiteralQuery <em>String Literal Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Literal Query</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.StringLiteralQuery
	 * @generated
	 */
	EClass getStringLiteralQuery();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.StringLiteralQuery#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.StringLiteralQuery#getValue()
	 * @see #getStringLiteralQuery()
	 * @generated
	 */
	EAttribute getStringLiteralQuery_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.TrueLiteralQuery <em>True Literal Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>True Literal Query</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.TrueLiteralQuery
	 * @generated
	 */
	EClass getTrueLiteralQuery();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.FalseLiteralQuery <em>False Literal Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>False Literal Query</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.FalseLiteralQuery
	 * @generated
	 */
	EClass getFalseLiteralQuery();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.NullLiteralQuery <em>Null Literal Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Null Literal Query</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.NullLiteralQuery
	 * @generated
	 */
	EClass getNullLiteralQuery();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.IntegerLiteralQuery <em>Integer Literal Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer Literal Query</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.IntegerLiteralQuery
	 * @generated
	 * @since 0.2
	 */
	EClass getIntegerLiteralQuery();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.IntegerLiteralQuery#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.IntegerLiteralQuery#getValue()
	 * @see #getIntegerLiteralQuery()
	 * @generated
	 * @since 0.2
	 */
	EAttribute getIntegerLiteralQuery_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.FloatLiteralQuery <em>Float Literal Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Float Literal Query</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.FloatLiteralQuery
	 * @generated
	 * @since 0.2
	 */
	EClass getFloatLiteralQuery();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.FloatLiteralQuery#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.FloatLiteralQuery#getValue()
	 * @see #getFloatLiteralQuery()
	 * @generated
	 * @since 0.2
	 */
	EAttribute getFloatLiteralQuery_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.EObjectLiteralQuery <em>EObject Literal Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EObject Literal Query</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.EObjectLiteralQuery
	 * @generated
	 * @since 0.2
	 */
	EClass getEObjectLiteralQuery();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.EObjectLiteralQuery#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Element</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.EObjectLiteralQuery#getElement()
	 * @see #getEObjectLiteralQuery()
	 * @generated
	 * @since 0.2
	 */
	EReference getEObjectLiteralQuery_Element();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.OperationCallQuery <em>Operation Call Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation Call Query</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.OperationCallQuery
	 * @generated
	 * @since 0.2
	 */
	EClass getOperationCallQuery();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.OperationCallQuery#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Operation</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.OperationCallQuery#getOperation()
	 * @see #getOperationCallQuery()
	 * @generated
	 * @since 0.2
	 */
	EReference getOperationCallQuery_Operation();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.OperationCallQuery#getArguments <em>Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Arguments</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.OperationCallQuery#getArguments()
	 * @see #getOperationCallQuery()
	 * @generated
	 * @since 0.2
	 */
	EReference getOperationCallQuery_Arguments();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.impl.NavigationQueryImpl <em>Navigation Query</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.impl.NavigationQueryImpl
		 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.impl.QueryPackageImpl#getNavigationQuery()
		 * @generated
		 */
		EClass NAVIGATION_QUERY = eINSTANCE.getNavigationQuery();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAVIGATION_QUERY__PATH = eINSTANCE.getNavigationQuery_Path();

		/**
		 * The meta object literal for the '<em><b>Fail On Error</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAVIGATION_QUERY__FAIL_ON_ERROR = eINSTANCE.getNavigationQuery_FailOnError();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.impl.IsOneOfQueryImpl <em>Is One Of Query</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.impl.IsOneOfQueryImpl
		 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.impl.QueryPackageImpl#getIsOneOfQuery()
		 * @generated
		 */
		EClass IS_ONE_OF_QUERY = eINSTANCE.getIsOneOfQuery();

		/**
		 * The meta object literal for the '<em><b>Expected EObjects</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IS_ONE_OF_QUERY__EXPECTED_EOBJECTS = eINSTANCE.getIsOneOfQuery_ExpectedEObjects();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.impl.StringLiteralQueryImpl <em>String Literal Query</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.impl.StringLiteralQueryImpl
		 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.impl.QueryPackageImpl#getStringLiteralQuery()
		 * @generated
		 */
		EClass STRING_LITERAL_QUERY = eINSTANCE.getStringLiteralQuery();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_LITERAL_QUERY__VALUE = eINSTANCE.getStringLiteralQuery_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.impl.TrueLiteralQueryImpl <em>True Literal Query</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.impl.TrueLiteralQueryImpl
		 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.impl.QueryPackageImpl#getTrueLiteralQuery()
		 * @generated
		 */
		EClass TRUE_LITERAL_QUERY = eINSTANCE.getTrueLiteralQuery();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.impl.FalseLiteralQueryImpl <em>False Literal Query</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.impl.FalseLiteralQueryImpl
		 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.impl.QueryPackageImpl#getFalseLiteralQuery()
		 * @generated
		 */
		EClass FALSE_LITERAL_QUERY = eINSTANCE.getFalseLiteralQuery();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.impl.NullLiteralQueryImpl <em>Null Literal Query</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.impl.NullLiteralQueryImpl
		 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.impl.QueryPackageImpl#getNullLiteralQuery()
		 * @generated
		 */
		EClass NULL_LITERAL_QUERY = eINSTANCE.getNullLiteralQuery();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.impl.IntegerLiteralQueryImpl <em>Integer Literal Query</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.impl.IntegerLiteralQueryImpl
		 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.impl.QueryPackageImpl#getIntegerLiteralQuery()
		 * @generated
		 * @since 0.2
		 */
		EClass INTEGER_LITERAL_QUERY = eINSTANCE.getIntegerLiteralQuery();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 * @since 0.2
		 */
		EAttribute INTEGER_LITERAL_QUERY__VALUE = eINSTANCE.getIntegerLiteralQuery_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.impl.FloatLiteralQueryImpl <em>Float Literal Query</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.impl.FloatLiteralQueryImpl
		 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.impl.QueryPackageImpl#getFloatLiteralQuery()
		 * @generated
		 * @since 0.2
		 */
		EClass FLOAT_LITERAL_QUERY = eINSTANCE.getFloatLiteralQuery();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 * @since 0.2
		 */
		EAttribute FLOAT_LITERAL_QUERY__VALUE = eINSTANCE.getFloatLiteralQuery_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.impl.EObjectLiteralQueryImpl <em>EObject Literal Query</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.impl.EObjectLiteralQueryImpl
		 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.impl.QueryPackageImpl#getEObjectLiteralQuery()
		 * @generated
		 * @since 0.2
		 */
		EClass EOBJECT_LITERAL_QUERY = eINSTANCE.getEObjectLiteralQuery();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 * @since 0.2
		 */
		EReference EOBJECT_LITERAL_QUERY__ELEMENT = eINSTANCE.getEObjectLiteralQuery_Element();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.impl.OperationCallQueryImpl <em>Operation Call Query</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.impl.OperationCallQueryImpl
		 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.impl.QueryPackageImpl#getOperationCallQuery()
		 * @generated
		 * @since 0.2
		 */
		EClass OPERATION_CALL_QUERY = eINSTANCE.getOperationCallQuery();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 * @since 0.2
		 */
		EReference OPERATION_CALL_QUERY__OPERATION = eINSTANCE.getOperationCallQuery_Operation();

		/**
		 * The meta object literal for the '<em><b>Arguments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 * @since 0.2
		 */
		EReference OPERATION_CALL_QUERY__ARGUMENTS = eINSTANCE.getOperationCallQuery_Arguments();

	}

} //QueryPackage
