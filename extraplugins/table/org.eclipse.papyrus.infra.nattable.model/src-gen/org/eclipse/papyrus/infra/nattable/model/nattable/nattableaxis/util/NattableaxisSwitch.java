/**
 * Copyright (c) 2013 CEA LIST.
 * 
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.*;

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
 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.NattableaxisPackage
 * @generated
 */
public class NattableaxisSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static NattableaxisPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NattableaxisSwitch() {
		if (modelPackage == null) {
			modelPackage = NattableaxisPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case NattableaxisPackage.IAXIS: {
				IAxis iAxis = (IAxis)theEObject;
				T result = caseIAxis(iAxis);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NattableaxisPackage.ID_AXIS: {
				IdAxis idAxis = (IdAxis)theEObject;
				T result = caseIdAxis(idAxis);
				if (result == null) result = caseIAxis(idAxis);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NattableaxisPackage.EOBJECT_AXIS: {
				EObjectAxis eObjectAxis = (EObjectAxis)theEObject;
				T result = caseEObjectAxis(eObjectAxis);
				if (result == null) result = caseObjectAxis(eObjectAxis);
				if (result == null) result = caseIAxis(eObjectAxis);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NattableaxisPackage.FEATURE_AXIS: {
				FeatureAxis featureAxis = (FeatureAxis)theEObject;
				T result = caseFeatureAxis(featureAxis);
				if (result == null) result = caseIAxis(featureAxis);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NattableaxisPackage.OBJECT_AXIS: {
				ObjectAxis objectAxis = (ObjectAxis)theEObject;
				T result = caseObjectAxis(objectAxis);
				if (result == null) result = caseIAxis(objectAxis);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NattableaxisPackage.FEATURE_ID_AXIS: {
				FeatureIdAxis featureIdAxis = (FeatureIdAxis)theEObject;
				T result = caseFeatureIdAxis(featureIdAxis);
				if (result == null) result = caseIdAxis(featureIdAxis);
				if (result == null) result = caseFeatureAxis(featureIdAxis);
				if (result == null) result = caseIAxis(featureIdAxis);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NattableaxisPackage.ESTRUCTURAL_FEATURE_AXIS: {
				EStructuralFeatureAxis eStructuralFeatureAxis = (EStructuralFeatureAxis)theEObject;
				T result = caseEStructuralFeatureAxis(eStructuralFeatureAxis);
				if (result == null) result = caseFeatureAxis(eStructuralFeatureAxis);
				if (result == null) result = caseIAxis(eStructuralFeatureAxis);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NattableaxisPackage.OBJECT_ID_AXIS: {
				ObjectIdAxis objectIdAxis = (ObjectIdAxis)theEObject;
				T result = caseObjectIdAxis(objectIdAxis);
				if (result == null) result = caseIdAxis(objectIdAxis);
				if (result == null) result = caseObjectAxis(objectIdAxis);
				if (result == null) result = caseIAxis(objectIdAxis);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IAxis</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IAxis</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIAxis(IAxis object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Id Axis</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Id Axis</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIdAxis(IdAxis object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject Axis</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject Axis</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEObjectAxis(EObjectAxis object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Feature Axis</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Feature Axis</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFeatureAxis(FeatureAxis object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Object Axis</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Object Axis</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseObjectAxis(ObjectAxis object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Feature Id Axis</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Feature Id Axis</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFeatureIdAxis(FeatureIdAxis object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EStructural Feature Axis</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EStructural Feature Axis</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEStructuralFeatureAxis(EStructuralFeatureAxis object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Object Id Axis</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Object Id Axis</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseObjectIdAxis(ObjectIdAxis object) {
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
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //NattableaxisSwitch
