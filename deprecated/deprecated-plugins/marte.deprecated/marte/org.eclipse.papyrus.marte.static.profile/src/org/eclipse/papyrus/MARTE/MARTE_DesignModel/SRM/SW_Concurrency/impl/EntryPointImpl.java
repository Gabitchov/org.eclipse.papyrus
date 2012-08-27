/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Chokri MRAIDHA (CEA LIST) chokri.mraidha@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.EntryPoint;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SW_ConcurrencyPackage;

import org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.impl.AllocateImpl;

import org.eclipse.uml2.uml.BehavioralFeature;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Entry Point</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.impl.EntryPointImpl#isIsReentrant <em>Is Reentrant</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.impl.EntryPointImpl#getRoutine <em>Routine</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EntryPointImpl extends AllocateImpl implements EntryPoint {
	/**
	 * The default value of the '{@link #isIsReentrant() <em>Is Reentrant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsReentrant()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_REENTRANT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsReentrant() <em>Is Reentrant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsReentrant()
	 * @generated
	 * @ordered
	 */
	protected boolean isReentrant = IS_REENTRANT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRoutine() <em>Routine</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoutine()
	 * @generated
	 * @ordered
	 */
	protected BehavioralFeature routine;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EntryPointImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SW_ConcurrencyPackage.Literals.ENTRY_POINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsReentrant() {
		return isReentrant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsReentrant(boolean newIsReentrant) {
		boolean oldIsReentrant = isReentrant;
		isReentrant = newIsReentrant;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SW_ConcurrencyPackage.ENTRY_POINT__IS_REENTRANT, oldIsReentrant, isReentrant));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BehavioralFeature getRoutine() {
		if (routine != null && routine.eIsProxy()) {
			InternalEObject oldRoutine = (InternalEObject)routine;
			routine = (BehavioralFeature)eResolveProxy(oldRoutine);
			if (routine != oldRoutine) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SW_ConcurrencyPackage.ENTRY_POINT__ROUTINE, oldRoutine, routine));
			}
		}
		return routine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BehavioralFeature basicGetRoutine() {
		return routine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRoutine(BehavioralFeature newRoutine) {
		BehavioralFeature oldRoutine = routine;
		routine = newRoutine;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SW_ConcurrencyPackage.ENTRY_POINT__ROUTINE, oldRoutine, routine));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SW_ConcurrencyPackage.ENTRY_POINT__IS_REENTRANT:
				return isIsReentrant();
			case SW_ConcurrencyPackage.ENTRY_POINT__ROUTINE:
				if (resolve) return getRoutine();
				return basicGetRoutine();
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
			case SW_ConcurrencyPackage.ENTRY_POINT__IS_REENTRANT:
				setIsReentrant((Boolean)newValue);
				return;
			case SW_ConcurrencyPackage.ENTRY_POINT__ROUTINE:
				setRoutine((BehavioralFeature)newValue);
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
			case SW_ConcurrencyPackage.ENTRY_POINT__IS_REENTRANT:
				setIsReentrant(IS_REENTRANT_EDEFAULT);
				return;
			case SW_ConcurrencyPackage.ENTRY_POINT__ROUTINE:
				setRoutine((BehavioralFeature)null);
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
			case SW_ConcurrencyPackage.ENTRY_POINT__IS_REENTRANT:
				return isReentrant != IS_REENTRANT_EDEFAULT;
			case SW_ConcurrencyPackage.ENTRY_POINT__ROUTINE:
				return routine != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (isReentrant: ");
		result.append(isReentrant);
		result.append(')');
		return result.toString();
	}

} //EntryPointImpl
