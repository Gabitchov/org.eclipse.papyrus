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
package org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.util;

import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.*;

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
 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.NattablecontentproviderPackage
 * @generated
 */
public class NattablecontentproviderSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static NattablecontentproviderPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NattablecontentproviderSwitch() {
		if (modelPackage == null) {
			modelPackage = NattablecontentproviderPackage.eINSTANCE;
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
			case NattablecontentproviderPackage.IAXIS_CONTENTS_PROVIDER: {
				IAxisContentsProvider iAxisContentsProvider = (IAxisContentsProvider)theEObject;
				T result = caseIAxisContentsProvider(iAxisContentsProvider);
				if (result == null) result = caseEModelElement(iAxisContentsProvider);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NattablecontentproviderPackage.DEFAULT_CONTENT_PROVIDER: {
				DefaultContentProvider defaultContentProvider = (DefaultContentProvider)theEObject;
				T result = caseDefaultContentProvider(defaultContentProvider);
				if (result == null) result = caseIAxisContentsProvider(defaultContentProvider);
				if (result == null) result = caseEModelElement(defaultContentProvider);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NattablecontentproviderPackage.EMF_FEATURE_CONTENT_PROVIDER: {
				EMFFeatureContentProvider emfFeatureContentProvider = (EMFFeatureContentProvider)theEObject;
				T result = caseEMFFeatureContentProvider(emfFeatureContentProvider);
				if (result == null) result = caseDefaultContentProvider(emfFeatureContentProvider);
				if (result == null) result = caseISynchronizedAxisContentProvider(emfFeatureContentProvider);
				if (result == null) result = caseIAxisContentsProvider(emfFeatureContentProvider);
				if (result == null) result = caseEModelElement(emfFeatureContentProvider);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NattablecontentproviderPackage.ISYNCHRONIZED_AXIS_CONTENT_PROVIDER: {
				ISynchronizedAxisContentProvider iSynchronizedAxisContentProvider = (ISynchronizedAxisContentProvider)theEObject;
				T result = caseISynchronizedAxisContentProvider(iSynchronizedAxisContentProvider);
				if (result == null) result = caseIAxisContentsProvider(iSynchronizedAxisContentProvider);
				if (result == null) result = caseEModelElement(iSynchronizedAxisContentProvider);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IAxis Contents Provider</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IAxis Contents Provider</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIAxisContentsProvider(IAxisContentsProvider object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Default Content Provider</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Default Content Provider</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDefaultContentProvider(DefaultContentProvider object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EMF Feature Content Provider</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EMF Feature Content Provider</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEMFFeatureContentProvider(EMFFeatureContentProvider object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ISynchronized Axis Content Provider</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ISynchronized Axis Content Provider</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseISynchronizedAxisContentProvider(ISynchronizedAxisContentProvider object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EModel Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EModel Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEModelElement(EModelElement object) {
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

} //NattablecontentproviderSwitch
