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
 * 	Emmanuelle Rouillé (Mia-Software) - Bug 352618 - To be able to use non derived facet structural features and save them values. 
 * 	Nicolas Bros (Mia-Software) - Bug 361823 - [Restructuring] eFacet2 meta-model
 *       Gregoire Dupe (Mia-Software) - Bug 366055 - NavigationQuery
 *       Gregoire Dupe (Mia-Software) - Bug 369673 - [Facet] IsOneOfQuery
 *       Olivier Remaud (Soft-Maint) - Bug 369824 - Add a simple way to return string literal constants from a customization query
 *       Gregoire Dupe (Mia-software) - Bug 369987 - [Restructuring][Table] Switch to the new customization and facet framework
 */
package org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.Query;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.*;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.FalseLiteralQuery;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.IsOneOfQuery;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.NavigationQuery;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.NullLiteralQuery;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.QueryPackage;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.StringLiteralQuery;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.TrueLiteralQuery;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.query.QueryPackage
 * @generated
 */
public class QuerySwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static QueryPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QuerySwitch() {
		if (modelPackage == null) {
			modelPackage = QueryPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case QueryPackage.NAVIGATION_QUERY: {
				NavigationQuery navigationQuery = (NavigationQuery)theEObject;
				T result = caseNavigationQuery(navigationQuery);
				if (result == null) result = caseQuery(navigationQuery);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QueryPackage.IS_ONE_OF_QUERY: {
				IsOneOfQuery isOneOfQuery = (IsOneOfQuery)theEObject;
				T result = caseIsOneOfQuery(isOneOfQuery);
				if (result == null) result = caseQuery(isOneOfQuery);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QueryPackage.STRING_LITERAL_QUERY: {
				StringLiteralQuery stringLiteralQuery = (StringLiteralQuery)theEObject;
				T result = caseStringLiteralQuery(stringLiteralQuery);
				if (result == null) result = caseQuery(stringLiteralQuery);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QueryPackage.TRUE_LITERAL_QUERY: {
				TrueLiteralQuery trueLiteralQuery = (TrueLiteralQuery)theEObject;
				T result = caseTrueLiteralQuery(trueLiteralQuery);
				if (result == null) result = caseQuery(trueLiteralQuery);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QueryPackage.FALSE_LITERAL_QUERY: {
				FalseLiteralQuery falseLiteralQuery = (FalseLiteralQuery)theEObject;
				T result = caseFalseLiteralQuery(falseLiteralQuery);
				if (result == null) result = caseQuery(falseLiteralQuery);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QueryPackage.NULL_LITERAL_QUERY: {
				NullLiteralQuery nullLiteralQuery = (NullLiteralQuery)theEObject;
				T result = caseNullLiteralQuery(nullLiteralQuery);
				if (result == null) result = caseQuery(nullLiteralQuery);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QueryPackage.INTEGER_LITERAL_QUERY: {
				IntegerLiteralQuery integerLiteralQuery = (IntegerLiteralQuery)theEObject;
				T result = caseIntegerLiteralQuery(integerLiteralQuery);
				if (result == null) result = caseQuery(integerLiteralQuery);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QueryPackage.FLOAT_LITERAL_QUERY: {
				FloatLiteralQuery floatLiteralQuery = (FloatLiteralQuery)theEObject;
				T result = caseFloatLiteralQuery(floatLiteralQuery);
				if (result == null) result = caseQuery(floatLiteralQuery);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QueryPackage.EOBJECT_LITERAL_QUERY: {
				EObjectLiteralQuery eObjectLiteralQuery = (EObjectLiteralQuery)theEObject;
				T result = caseEObjectLiteralQuery(eObjectLiteralQuery);
				if (result == null) result = caseQuery(eObjectLiteralQuery);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QueryPackage.OPERATION_CALL_QUERY: {
				OperationCallQuery operationCallQuery = (OperationCallQuery)theEObject;
				T result = caseOperationCallQuery(operationCallQuery);
				if (result == null) result = caseQuery(operationCallQuery);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Navigation Query</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Navigation Query</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNavigationQuery(NavigationQuery object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Is One Of Query</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Is One Of Query</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIsOneOfQuery(IsOneOfQuery object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Literal Query</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Literal Query</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringLiteralQuery(StringLiteralQuery object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>True Literal Query</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>True Literal Query</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTrueLiteralQuery(TrueLiteralQuery object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>False Literal Query</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>False Literal Query</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFalseLiteralQuery(FalseLiteralQuery object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Null Literal Query</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Null Literal Query</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNullLiteralQuery(NullLiteralQuery object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Integer Literal Query</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Integer Literal Query</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntegerLiteralQuery(IntegerLiteralQuery object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Float Literal Query</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Float Literal Query</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFloatLiteralQuery(FloatLiteralQuery object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject Literal Query</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject Literal Query</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEObjectLiteralQuery(EObjectLiteralQuery object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operation Call Query</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation Call Query</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperationCallQuery(OperationCallQuery object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Query</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Query</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseQuery(Query object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //QuerySwitch
