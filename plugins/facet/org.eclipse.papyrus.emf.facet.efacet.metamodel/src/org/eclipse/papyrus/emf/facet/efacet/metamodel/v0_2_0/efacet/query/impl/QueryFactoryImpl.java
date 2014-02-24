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
 */
package org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.*;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.FalseLiteralQuery;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.IsOneOfQuery;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.NavigationQuery;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.NullLiteralQuery;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.QueryFactory;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.QueryPackage;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.StringLiteralQuery;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.TrueLiteralQuery;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class QueryFactoryImpl extends EFactoryImpl implements QueryFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static QueryFactory init() {
		try {
			QueryFactory theQueryFactory = (QueryFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/papyrus/emf/facet/efacet/0.2.incubation/efacet/query"); //$NON-NLS-1$ 
			if (theQueryFactory != null) {
				return theQueryFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new QueryFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QueryFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case QueryPackage.NAVIGATION_QUERY: return createNavigationQuery();
			case QueryPackage.IS_ONE_OF_QUERY: return createIsOneOfQuery();
			case QueryPackage.STRING_LITERAL_QUERY: return createStringLiteralQuery();
			case QueryPackage.TRUE_LITERAL_QUERY: return createTrueLiteralQuery();
			case QueryPackage.FALSE_LITERAL_QUERY: return createFalseLiteralQuery();
			case QueryPackage.NULL_LITERAL_QUERY: return createNullLiteralQuery();
			case QueryPackage.INTEGER_LITERAL_QUERY: return createIntegerLiteralQuery();
			case QueryPackage.FLOAT_LITERAL_QUERY: return createFloatLiteralQuery();
			case QueryPackage.EOBJECT_LITERAL_QUERY: return createEObjectLiteralQuery();
			case QueryPackage.OPERATION_CALL_QUERY: return createOperationCallQuery();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NavigationQuery createNavigationQuery() {
		NavigationQueryImpl navigationQuery = new NavigationQueryImpl();
		return navigationQuery;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IsOneOfQuery createIsOneOfQuery() {
		IsOneOfQueryImpl isOneOfQuery = new IsOneOfQueryImpl();
		return isOneOfQuery;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringLiteralQuery createStringLiteralQuery() {
		StringLiteralQueryImpl stringLiteralQuery = new StringLiteralQueryImpl();
		return stringLiteralQuery;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TrueLiteralQuery createTrueLiteralQuery() {
		TrueLiteralQueryImpl trueLiteralQuery = new TrueLiteralQueryImpl();
		return trueLiteralQuery;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FalseLiteralQuery createFalseLiteralQuery() {
		FalseLiteralQueryImpl falseLiteralQuery = new FalseLiteralQueryImpl();
		return falseLiteralQuery;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NullLiteralQuery createNullLiteralQuery() {
		NullLiteralQueryImpl nullLiteralQuery = new NullLiteralQueryImpl();
		return nullLiteralQuery;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegerLiteralQuery createIntegerLiteralQuery() {
		IntegerLiteralQueryImpl integerLiteralQuery = new IntegerLiteralQueryImpl();
		return integerLiteralQuery;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FloatLiteralQuery createFloatLiteralQuery() {
		FloatLiteralQueryImpl floatLiteralQuery = new FloatLiteralQueryImpl();
		return floatLiteralQuery;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObjectLiteralQuery createEObjectLiteralQuery() {
		EObjectLiteralQueryImpl eObjectLiteralQuery = new EObjectLiteralQueryImpl();
		return eObjectLiteralQuery;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationCallQuery createOperationCallQuery() {
		OperationCallQueryImpl operationCallQuery = new OperationCallQueryImpl();
		return operationCallQuery;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QueryPackage getQueryPackage() {
		return (QueryPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static QueryPackage getPackage() {
		return QueryPackage.eINSTANCE;
	}

} //QueryFactoryImpl
