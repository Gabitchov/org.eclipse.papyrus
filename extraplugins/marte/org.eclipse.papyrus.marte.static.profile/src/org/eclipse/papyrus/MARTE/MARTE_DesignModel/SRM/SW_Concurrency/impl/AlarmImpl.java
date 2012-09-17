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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.Alarm;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SW_ConcurrencyPackage;
import org.eclipse.uml2.uml.TypedElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Alarm</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.impl.AlarmImpl#isIsWatchdog <em>Is Watchdog</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.impl.AlarmImpl#getTimers <em>Timers</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AlarmImpl extends InterruptResourceImpl implements Alarm {
	/**
	 * The default value of the '{@link #isIsWatchdog() <em>Is Watchdog</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsWatchdog()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_WATCHDOG_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsWatchdog() <em>Is Watchdog</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsWatchdog()
	 * @generated
	 * @ordered
	 */
	protected boolean isWatchdog = IS_WATCHDOG_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTimers() <em>Timers</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimers()
	 * @generated
	 * @ordered
	 */
	protected EList<TypedElement> timers;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AlarmImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SW_ConcurrencyPackage.Literals.ALARM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsWatchdog() {
		return isWatchdog;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsWatchdog(boolean newIsWatchdog) {
		boolean oldIsWatchdog = isWatchdog;
		isWatchdog = newIsWatchdog;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SW_ConcurrencyPackage.ALARM__IS_WATCHDOG, oldIsWatchdog, isWatchdog));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TypedElement> getTimers() {
		if (timers == null) {
			timers = new EObjectResolvingEList<TypedElement>(TypedElement.class, this, SW_ConcurrencyPackage.ALARM__TIMERS);
		}
		return timers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SW_ConcurrencyPackage.ALARM__IS_WATCHDOG:
				return isIsWatchdog();
			case SW_ConcurrencyPackage.ALARM__TIMERS:
				return getTimers();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SW_ConcurrencyPackage.ALARM__IS_WATCHDOG:
				setIsWatchdog((Boolean)newValue);
				return;
			case SW_ConcurrencyPackage.ALARM__TIMERS:
				getTimers().clear();
				getTimers().addAll((Collection<? extends TypedElement>)newValue);
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
			case SW_ConcurrencyPackage.ALARM__IS_WATCHDOG:
				setIsWatchdog(IS_WATCHDOG_EDEFAULT);
				return;
			case SW_ConcurrencyPackage.ALARM__TIMERS:
				getTimers().clear();
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
			case SW_ConcurrencyPackage.ALARM__IS_WATCHDOG:
				return isWatchdog != IS_WATCHDOG_EDEFAULT;
			case SW_ConcurrencyPackage.ALARM__TIMERS:
				return timers != null && !timers.isEmpty();
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
		result.append(" (isWatchdog: ");
		result.append(isWatchdog);
		result.append(')');
		return result.toString();
	}

} //AlarmImpl
