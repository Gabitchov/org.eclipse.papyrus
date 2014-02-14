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
 * 	Emmanuelle Rouillé (Mia-Software) - Bug 352618 - To be able to use non derived facet structural features and save them values. 
 * 	Nicolas Bros (Mia-Software) - Bug 361823 - [Restructuring] eFacet2 meta-model
 *       Gregoire Dupe (Mia-Software) - Bug 366055 - NavigationQuery
 *       Gregoire Dupe (Mia-Software) - Bug 369673 - [Facet] IsOneOfQuery
 *       Olivier Remaud (Soft-Maint) - Bug 369824 - Add a simple way to return string literal constants from a customization query
 *       Gregoire Dupe (Mia-software) - Bug 369987 - [Restructuring][Table] Switch to the new customization and facet framework
 *       Gregoire Dupe (Mia-software) - Bug 364325 - [Restructuring] The user must be able to navigate into a model using the Facet.
 */
package org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.*;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.ETypedElementEObjectListResult;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.ETypedElementEObjectResult;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.ETypedElementPrimitiveTypeListResult;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.ETypedElementPrimitiveTypeResult;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.ETypedElementResult;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.RuntimePackage;

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
 * @see org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.RuntimePackage
 * @generated
 */
public class RuntimeSwitch<T1> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static RuntimePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuntimeSwitch() {
		if (modelPackage == null) {
			modelPackage = RuntimePackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T1 doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T1 doSwitch(EClass theEClass, EObject theEObject) {
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
	protected T1 doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case RuntimePackage.ETYPED_ELEMENT_PRIMITIVE_TYPE_RESULT: {
				ETypedElementPrimitiveTypeResult<?> eTypedElementPrimitiveTypeResult = (ETypedElementPrimitiveTypeResult<?>)theEObject;
				T1 result = caseETypedElementPrimitiveTypeResult(eTypedElementPrimitiveTypeResult);
				if (result == null) result = caseETypedElementResult(eTypedElementPrimitiveTypeResult);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RuntimePackage.ETYPED_ELEMENT_EOBJECT_RESULT: {
				ETypedElementEObjectResult<?> eTypedElementEObjectResult = (ETypedElementEObjectResult<?>)theEObject;
				T1 result = caseETypedElementEObjectResult(eTypedElementEObjectResult);
				if (result == null) result = caseETypedElementResult(eTypedElementEObjectResult);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RuntimePackage.ETYPED_ELEMENT_PRIMITIVE_TYPE_LIST_RESULT: {
				ETypedElementPrimitiveTypeListResult<?> eTypedElementPrimitiveTypeListResult = (ETypedElementPrimitiveTypeListResult<?>)theEObject;
				T1 result = caseETypedElementPrimitiveTypeListResult(eTypedElementPrimitiveTypeListResult);
				if (result == null) result = caseETypedElementResult(eTypedElementPrimitiveTypeListResult);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RuntimePackage.ETYPED_ELEMENT_EOBJECT_LIST_RESULT: {
				ETypedElementEObjectListResult<?> eTypedElementEObjectListResult = (ETypedElementEObjectListResult<?>)theEObject;
				T1 result = caseETypedElementEObjectListResult(eTypedElementEObjectListResult);
				if (result == null) result = caseETypedElementResult(eTypedElementEObjectListResult);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RuntimePackage.ETYPED_ELEMENT_RESULT: {
				ETypedElementResult eTypedElementResult = (ETypedElementResult)theEObject;
				T1 result = caseETypedElementResult(eTypedElementResult);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ETyped Element Primitive Type Result</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ETyped Element Primitive Type Result</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T> T1 caseETypedElementPrimitiveTypeResult(ETypedElementPrimitiveTypeResult<T> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ETyped Element EObject Result</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ETyped Element EObject Result</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T extends EObject> T1 caseETypedElementEObjectResult(ETypedElementEObjectResult<T> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ETyped Element Primitive Type List Result</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ETyped Element Primitive Type List Result</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T> T1 caseETypedElementPrimitiveTypeListResult(ETypedElementPrimitiveTypeListResult<T> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ETyped Element EObject List Result</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ETyped Element EObject List Result</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T extends EObject> T1 caseETypedElementEObjectListResult(ETypedElementEObjectListResult<T> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ETyped Element Result</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ETyped Element Result</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseETypedElementResult(ETypedElementResult object) {
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
	public T1 defaultCase(EObject object) {
		return null;
	}

} //RuntimeSwitch
