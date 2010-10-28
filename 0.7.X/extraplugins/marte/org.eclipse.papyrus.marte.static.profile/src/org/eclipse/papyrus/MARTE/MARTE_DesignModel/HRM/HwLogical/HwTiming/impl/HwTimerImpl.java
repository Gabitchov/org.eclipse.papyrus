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
package org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwTiming.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwTiming.HwClock;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwTiming.HwTimer;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwTiming.HwTimingPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Hw Timer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwTiming.impl.HwTimerImpl#getNbCounters <em>Nb Counters</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwTiming.impl.HwTimerImpl#getCounterWidth <em>Counter Width</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwTiming.impl.HwTimerImpl#getInputClock <em>Input Clock</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class HwTimerImpl extends HwTimingResourceImpl implements HwTimer {
	/**
	 * The default value of the '{@link #getNbCounters() <em>Nb Counters</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNbCounters()
	 * @generated
	 * @ordered
	 */
	protected static final String NB_COUNTERS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNbCounters() <em>Nb Counters</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNbCounters()
	 * @generated
	 * @ordered
	 */
	protected String nbCounters = NB_COUNTERS_EDEFAULT;

	/**
	 * The default value of the '{@link #getCounterWidth() <em>Counter Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCounterWidth()
	 * @generated
	 * @ordered
	 */
	protected static final String COUNTER_WIDTH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCounterWidth() <em>Counter Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCounterWidth()
	 * @generated
	 * @ordered
	 */
	protected String counterWidth = COUNTER_WIDTH_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInputClock() <em>Input Clock</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputClock()
	 * @generated
	 * @ordered
	 */
	protected HwClock inputClock;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HwTimerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HwTimingPackage.Literals.HW_TIMER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNbCounters() {
		return nbCounters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNbCounters(String newNbCounters) {
		String oldNbCounters = nbCounters;
		nbCounters = newNbCounters;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HwTimingPackage.HW_TIMER__NB_COUNTERS, oldNbCounters, nbCounters));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCounterWidth() {
		return counterWidth;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCounterWidth(String newCounterWidth) {
		String oldCounterWidth = counterWidth;
		counterWidth = newCounterWidth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HwTimingPackage.HW_TIMER__COUNTER_WIDTH, oldCounterWidth, counterWidth));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HwClock getInputClock() {
		if (inputClock != null && inputClock.eIsProxy()) {
			InternalEObject oldInputClock = (InternalEObject)inputClock;
			inputClock = (HwClock)eResolveProxy(oldInputClock);
			if (inputClock != oldInputClock) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, HwTimingPackage.HW_TIMER__INPUT_CLOCK, oldInputClock, inputClock));
			}
		}
		return inputClock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HwClock basicGetInputClock() {
		return inputClock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputClock(HwClock newInputClock) {
		HwClock oldInputClock = inputClock;
		inputClock = newInputClock;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HwTimingPackage.HW_TIMER__INPUT_CLOCK, oldInputClock, inputClock));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case HwTimingPackage.HW_TIMER__NB_COUNTERS:
				return getNbCounters();
			case HwTimingPackage.HW_TIMER__COUNTER_WIDTH:
				return getCounterWidth();
			case HwTimingPackage.HW_TIMER__INPUT_CLOCK:
				if (resolve) return getInputClock();
				return basicGetInputClock();
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
			case HwTimingPackage.HW_TIMER__NB_COUNTERS:
				setNbCounters((String)newValue);
				return;
			case HwTimingPackage.HW_TIMER__COUNTER_WIDTH:
				setCounterWidth((String)newValue);
				return;
			case HwTimingPackage.HW_TIMER__INPUT_CLOCK:
				setInputClock((HwClock)newValue);
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
			case HwTimingPackage.HW_TIMER__NB_COUNTERS:
				setNbCounters(NB_COUNTERS_EDEFAULT);
				return;
			case HwTimingPackage.HW_TIMER__COUNTER_WIDTH:
				setCounterWidth(COUNTER_WIDTH_EDEFAULT);
				return;
			case HwTimingPackage.HW_TIMER__INPUT_CLOCK:
				setInputClock((HwClock)null);
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
			case HwTimingPackage.HW_TIMER__NB_COUNTERS:
				return NB_COUNTERS_EDEFAULT == null ? nbCounters != null : !NB_COUNTERS_EDEFAULT.equals(nbCounters);
			case HwTimingPackage.HW_TIMER__COUNTER_WIDTH:
				return COUNTER_WIDTH_EDEFAULT == null ? counterWidth != null : !COUNTER_WIDTH_EDEFAULT.equals(counterWidth);
			case HwTimingPackage.HW_TIMER__INPUT_CLOCK:
				return inputClock != null;
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
		result.append(" (nbCounters: ");
		result.append(nbCounters);
		result.append(", counterWidth: ");
		result.append(counterWidth);
		result.append(')');
		return result.toString();
	}

} //HwTimerImpl
