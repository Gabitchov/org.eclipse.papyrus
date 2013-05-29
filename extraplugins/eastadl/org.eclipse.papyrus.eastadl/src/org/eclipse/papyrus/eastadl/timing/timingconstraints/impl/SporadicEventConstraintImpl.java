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
 *  Sara TUCCI (CEA LIST) sara.tucci@cea.fr - Initial API and implementation
 *  Chokri MRAIDHA (CEA LIST) chokri.mraidha@cea.fr - Initial API and implementation
 *  David SERVAT (CEA LIST) david.servat@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.eastadl.timing.timingconstraints.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.eastadl.timing.TimeDuration;
import org.eclipse.papyrus.eastadl.timing.timingconstraints.SporadicEventConstraint;
import org.eclipse.papyrus.eastadl.timing.timingconstraints.TimingconstraintsPackage;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sporadic Event Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.impl.SporadicEventConstraintImpl#getJitter <em>Jitter</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.impl.SporadicEventConstraintImpl#getPeriod <em>Period</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.impl.SporadicEventConstraintImpl#getMaximumInterArrivalTime <em>Maximum Inter Arrival Time</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.impl.SporadicEventConstraintImpl#getMinimumInterArrivalTime <em>Minimum Inter Arrival Time</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SporadicEventConstraintImpl extends EventConstraintImpl implements SporadicEventConstraint {
	/**
	 * The cached value of the '{@link #getJitter() <em>Jitter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJitter()
	 * @generated
	 * @ordered
	 */
	protected TimeDuration jitter;

	/**
	 * The cached value of the '{@link #getPeriod() <em>Period</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPeriod()
	 * @generated
	 * @ordered
	 */
	protected TimeDuration period;

	/**
	 * The cached value of the '{@link #getMaximumInterArrivalTime() <em>Maximum Inter Arrival Time</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximumInterArrivalTime()
	 * @generated
	 * @ordered
	 */
	protected TimeDuration maximumInterArrivalTime;

	/**
	 * The cached value of the '{@link #getMinimumInterArrivalTime() <em>Minimum Inter Arrival Time</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinimumInterArrivalTime()
	 * @generated
	 * @ordered
	 */
	protected TimeDuration minimumInterArrivalTime;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SporadicEventConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeDuration basicGetJitter() {
		return jitter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeDuration basicGetMaximumInterArrivalTime() {
		return maximumInterArrivalTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeDuration basicGetMinimumInterArrivalTime() {
		return minimumInterArrivalTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeDuration basicGetPeriod() {
		return period;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TimingconstraintsPackage.SPORADIC_EVENT_CONSTRAINT__JITTER:
				if (resolve) return getJitter();
				return basicGetJitter();
			case TimingconstraintsPackage.SPORADIC_EVENT_CONSTRAINT__PERIOD:
				if (resolve) return getPeriod();
				return basicGetPeriod();
			case TimingconstraintsPackage.SPORADIC_EVENT_CONSTRAINT__MAXIMUM_INTER_ARRIVAL_TIME:
				if (resolve) return getMaximumInterArrivalTime();
				return basicGetMaximumInterArrivalTime();
			case TimingconstraintsPackage.SPORADIC_EVENT_CONSTRAINT__MINIMUM_INTER_ARRIVAL_TIME:
				if (resolve) return getMinimumInterArrivalTime();
				return basicGetMinimumInterArrivalTime();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TimingconstraintsPackage.SPORADIC_EVENT_CONSTRAINT__JITTER:
				return jitter != null;
			case TimingconstraintsPackage.SPORADIC_EVENT_CONSTRAINT__PERIOD:
				return period != null;
			case TimingconstraintsPackage.SPORADIC_EVENT_CONSTRAINT__MAXIMUM_INTER_ARRIVAL_TIME:
				return maximumInterArrivalTime != null;
			case TimingconstraintsPackage.SPORADIC_EVENT_CONSTRAINT__MINIMUM_INTER_ARRIVAL_TIME:
				return minimumInterArrivalTime != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TimingconstraintsPackage.SPORADIC_EVENT_CONSTRAINT__JITTER:
				setJitter((TimeDuration)newValue);
				return;
			case TimingconstraintsPackage.SPORADIC_EVENT_CONSTRAINT__PERIOD:
				setPeriod((TimeDuration)newValue);
				return;
			case TimingconstraintsPackage.SPORADIC_EVENT_CONSTRAINT__MAXIMUM_INTER_ARRIVAL_TIME:
				setMaximumInterArrivalTime((TimeDuration)newValue);
				return;
			case TimingconstraintsPackage.SPORADIC_EVENT_CONSTRAINT__MINIMUM_INTER_ARRIVAL_TIME:
				setMinimumInterArrivalTime((TimeDuration)newValue);
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
	protected EClass eStaticClass() {
		return TimingconstraintsPackage.Literals.SPORADIC_EVENT_CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case TimingconstraintsPackage.SPORADIC_EVENT_CONSTRAINT__JITTER:
				setJitter((TimeDuration)null);
				return;
			case TimingconstraintsPackage.SPORADIC_EVENT_CONSTRAINT__PERIOD:
				setPeriod((TimeDuration)null);
				return;
			case TimingconstraintsPackage.SPORADIC_EVENT_CONSTRAINT__MAXIMUM_INTER_ARRIVAL_TIME:
				setMaximumInterArrivalTime((TimeDuration)null);
				return;
			case TimingconstraintsPackage.SPORADIC_EVENT_CONSTRAINT__MINIMUM_INTER_ARRIVAL_TIME:
				setMinimumInterArrivalTime((TimeDuration)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeDuration getJitter() {
		if (jitter != null && jitter.eIsProxy()) {
			InternalEObject oldJitter = (InternalEObject)jitter;
			jitter = (TimeDuration)eResolveProxy(oldJitter);
			if (jitter != oldJitter) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TimingconstraintsPackage.SPORADIC_EVENT_CONSTRAINT__JITTER, oldJitter, jitter));
			}
		}
		return jitter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeDuration getMaximumInterArrivalTime() {
		if (maximumInterArrivalTime != null && maximumInterArrivalTime.eIsProxy()) {
			InternalEObject oldMaximumInterArrivalTime = (InternalEObject)maximumInterArrivalTime;
			maximumInterArrivalTime = (TimeDuration)eResolveProxy(oldMaximumInterArrivalTime);
			if (maximumInterArrivalTime != oldMaximumInterArrivalTime) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TimingconstraintsPackage.SPORADIC_EVENT_CONSTRAINT__MAXIMUM_INTER_ARRIVAL_TIME, oldMaximumInterArrivalTime, maximumInterArrivalTime));
			}
		}
		return maximumInterArrivalTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeDuration getMinimumInterArrivalTime() {
		if (minimumInterArrivalTime != null && minimumInterArrivalTime.eIsProxy()) {
			InternalEObject oldMinimumInterArrivalTime = (InternalEObject)minimumInterArrivalTime;
			minimumInterArrivalTime = (TimeDuration)eResolveProxy(oldMinimumInterArrivalTime);
			if (minimumInterArrivalTime != oldMinimumInterArrivalTime) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TimingconstraintsPackage.SPORADIC_EVENT_CONSTRAINT__MINIMUM_INTER_ARRIVAL_TIME, oldMinimumInterArrivalTime, minimumInterArrivalTime));
			}
		}
		return minimumInterArrivalTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeDuration getPeriod() {
		if (period != null && period.eIsProxy()) {
			InternalEObject oldPeriod = (InternalEObject)period;
			period = (TimeDuration)eResolveProxy(oldPeriod);
			if (period != oldPeriod) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TimingconstraintsPackage.SPORADIC_EVENT_CONSTRAINT__PERIOD, oldPeriod, period));
			}
		}
		return period;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJitter(TimeDuration newJitter) {
		TimeDuration oldJitter = jitter;
		jitter = newJitter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimingconstraintsPackage.SPORADIC_EVENT_CONSTRAINT__JITTER, oldJitter, jitter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaximumInterArrivalTime(TimeDuration newMaximumInterArrivalTime) {
		TimeDuration oldMaximumInterArrivalTime = maximumInterArrivalTime;
		maximumInterArrivalTime = newMaximumInterArrivalTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimingconstraintsPackage.SPORADIC_EVENT_CONSTRAINT__MAXIMUM_INTER_ARRIVAL_TIME, oldMaximumInterArrivalTime, maximumInterArrivalTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinimumInterArrivalTime(TimeDuration newMinimumInterArrivalTime) {
		TimeDuration oldMinimumInterArrivalTime = minimumInterArrivalTime;
		minimumInterArrivalTime = newMinimumInterArrivalTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimingconstraintsPackage.SPORADIC_EVENT_CONSTRAINT__MINIMUM_INTER_ARRIVAL_TIME, oldMinimumInterArrivalTime, minimumInterArrivalTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPeriod(TimeDuration newPeriod) {
		TimeDuration oldPeriod = period;
		period = newPeriod;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimingconstraintsPackage.SPORADIC_EVENT_CONSTRAINT__PERIOD, oldPeriod, period));
	}

} //SporadicEventConstraintImpl
