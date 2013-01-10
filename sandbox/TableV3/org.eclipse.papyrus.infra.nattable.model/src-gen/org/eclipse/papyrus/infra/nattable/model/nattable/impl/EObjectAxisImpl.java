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
package org.eclipse.papyrus.infra.nattable.model.nattable.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EModelElementImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.infra.nattable.model.nattable.EObjectAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.NattablePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EObject Axis</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.impl.EObjectAxisImpl#getEobject <em>Eobject</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EObjectAxisImpl extends EModelElementImpl implements EObjectAxis {
	/**
	 * The cached value of the '{@link #getEobject() <em>Eobject</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEobject()
	 * @generated
	 * @ordered
	 */
	protected EObject eobject;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EObjectAxisImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NattablePackage.Literals.EOBJECT_AXIS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getEobject() {
		if (eobject != null && eobject.eIsProxy()) {
			InternalEObject oldEobject = (InternalEObject)eobject;
			eobject = eResolveProxy(oldEobject);
			if (eobject != oldEobject) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NattablePackage.EOBJECT_AXIS__EOBJECT, oldEobject, eobject));
			}
		}
		return eobject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetEobject() {
		return eobject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEobject(EObject newEobject) {
		EObject oldEobject = eobject;
		eobject = newEobject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NattablePackage.EOBJECT_AXIS__EOBJECT, oldEobject, eobject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getElement() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case NattablePackage.EOBJECT_AXIS__EOBJECT:
				if (resolve) return getEobject();
				return basicGetEobject();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case NattablePackage.EOBJECT_AXIS__EOBJECT:
				setEobject((EObject)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case NattablePackage.EOBJECT_AXIS__EOBJECT:
				setEobject((EObject)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case NattablePackage.EOBJECT_AXIS__EOBJECT:
				return eobject != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case NattablePackage.EOBJECT_AXIS___GET_ELEMENT:
				return getElement();
		}
		return super.eInvoke(operationID, arguments);
	}

} //EObjectAxisImpl
