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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.papyrus.eastadl.timing.TimeDuration;
import org.eclipse.papyrus.eastadl.timing.timingconstraints.PatternEventConstraint;
import org.eclipse.papyrus.eastadl.timing.timingconstraints.TimingconstraintsPackage;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pattern Event Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.impl.PatternEventConstraintImpl#getPeriod <em>Period</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.impl.PatternEventConstraintImpl#getMinimumInterArrivalTime <em>Minimum Inter Arrival Time</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.impl.PatternEventConstraintImpl#getOccurence <em>Occurence</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.impl.PatternEventConstraintImpl#getJitter <em>Jitter</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PatternEventConstraintImpl extends EventConstraintImpl implements PatternEventConstraint {
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
	 * The cached value of the '{@link #getMinimumInterArrivalTime() <em>Minimum Inter Arrival Time</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinimumInterArrivalTime()
	 * @generated
	 * @ordered
	 */
	protected TimeDuration minimumInterArrivalTime;

	/**
	 * The cached value of the '{@link #getOccurence() <em>Occurence</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOccurence()
	 * @generated
	 * @ordered
	 */
	protected EList<TimeDuration> occurence;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PatternEventConstraintImpl() {
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
			case TimingconstraintsPackage.PATTERN_EVENT_CONSTRAINT__PERIOD:
				if (resolve) return getPeriod();
				return basicGetPeriod();
			case TimingconstraintsPackage.PATTERN_EVENT_CONSTRAINT__MINIMUM_INTER_ARRIVAL_TIME:
				if (resolve) return getMinimumInterArrivalTime();
				return basicGetMinimumInterArrivalTime();
			case TimingconstraintsPackage.PATTERN_EVENT_CONSTRAINT__OCCURENCE:
				return getOccurence();
			case TimingconstraintsPackage.PATTERN_EVENT_CONSTRAINT__JITTER:
				if (resolve) return getJitter();
				return basicGetJitter();
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
			case TimingconstraintsPackage.PATTERN_EVENT_CONSTRAINT__PERIOD:
				return period != null;
			case TimingconstraintsPackage.PATTERN_EVENT_CONSTRAINT__MINIMUM_INTER_ARRIVAL_TIME:
				return minimumInterArrivalTime != null;
			case TimingconstraintsPackage.PATTERN_EVENT_CONSTRAINT__OCCURENCE:
				return occurence != null && !occurence.isEmpty();
			case TimingconstraintsPackage.PATTERN_EVENT_CONSTRAINT__JITTER:
				return jitter != null;
		}
		return super.eIsSet(featureID);
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
			case TimingconstraintsPackage.PATTERN_EVENT_CONSTRAINT__PERIOD:
				setPeriod((TimeDuration)newValue);
				return;
			case TimingconstraintsPackage.PATTERN_EVENT_CONSTRAINT__MINIMUM_INTER_ARRIVAL_TIME:
				setMinimumInterArrivalTime((TimeDuration)newValue);
				return;
			case TimingconstraintsPackage.PATTERN_EVENT_CONSTRAINT__OCCURENCE:
				getOccurence().clear();
				getOccurence().addAll((Collection<? extends TimeDuration>)newValue);
				return;
			case TimingconstraintsPackage.PATTERN_EVENT_CONSTRAINT__JITTER:
				setJitter((TimeDuration)newValue);
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
		return TimingconstraintsPackage.Literals.PATTERN_EVENT_CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case TimingconstraintsPackage.PATTERN_EVENT_CONSTRAINT__PERIOD:
				setPeriod((TimeDuration)null);
				return;
			case TimingconstraintsPackage.PATTERN_EVENT_CONSTRAINT__MINIMUM_INTER_ARRIVAL_TIME:
				setMinimumInterArrivalTime((TimeDuration)null);
				return;
			case TimingconstraintsPackage.PATTERN_EVENT_CONSTRAINT__OCCURENCE:
				getOccurence().clear();
				return;
			case TimingconstraintsPackage.PATTERN_EVENT_CONSTRAINT__JITTER:
				setJitter((TimeDuration)null);
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TimingconstraintsPackage.PATTERN_EVENT_CONSTRAINT__JITTER, oldJitter, jitter));
			}
		}
		return jitter;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TimingconstraintsPackage.PATTERN_EVENT_CONSTRAINT__MINIMUM_INTER_ARRIVAL_TIME, oldMinimumInterArrivalTime, minimumInterArrivalTime));
			}
		}
		return minimumInterArrivalTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TimeDuration> getOccurence() {
		if (occurence == null) {
			occurence = new EObjectResolvingEList<TimeDuration>(TimeDuration.class, this, TimingconstraintsPackage.PATTERN_EVENT_CONSTRAINT__OCCURENCE);
		}
		return occurence;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TimingconstraintsPackage.PATTERN_EVENT_CONSTRAINT__PERIOD, oldPeriod, period));
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
			eNotify(new ENotificationImpl(this, Notification.SET, TimingconstraintsPackage.PATTERN_EVENT_CONSTRAINT__JITTER, oldJitter, jitter));
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
			eNotify(new ENotificationImpl(this, Notification.SET, TimingconstraintsPackage.PATTERN_EVENT_CONSTRAINT__MINIMUM_INTER_ARRIVAL_TIME, oldMinimumInterArrivalTime, minimumInterArrivalTime));
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
			eNotify(new ENotificationImpl(this, Notification.SET, TimingconstraintsPackage.PATTERN_EVENT_CONSTRAINT__PERIOD, oldPeriod, period));
	}

} //PatternEventConstraintImpl
