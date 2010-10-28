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
package org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimePackage;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimedEvent;

import org.eclipse.uml2.uml.TimeEvent;
import org.eclipse.uml2.uml.ValueSpecification;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Timed Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.TimedEventImpl#getRepetition <em>Repetition</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.TimedEventImpl#getBase_TimeEvent <em>Base Time Event</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.TimedEventImpl#getEvery <em>Every</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TimedEventImpl extends TimedElementImpl implements TimedEvent {
	/**
	 * The default value of the '{@link #getRepetition() <em>Repetition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepetition()
	 * @generated
	 * @ordered
	 */
	protected static final int REPETITION_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getRepetition() <em>Repetition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepetition()
	 * @generated
	 * @ordered
	 */
	protected int repetition = REPETITION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBase_TimeEvent() <em>Base Time Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_TimeEvent()
	 * @generated
	 * @ordered
	 */
	protected TimeEvent base_TimeEvent;

	/**
	 * The cached value of the '{@link #getEvery() <em>Every</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEvery()
	 * @generated
	 * @ordered
	 */
	protected ValueSpecification every;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TimedEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TimePackage.Literals.TIMED_EVENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getRepetition() {
		return repetition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepetition(int newRepetition) {
		int oldRepetition = repetition;
		repetition = newRepetition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimePackage.TIMED_EVENT__REPETITION, oldRepetition, repetition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeEvent getBase_TimeEvent() {
		if (base_TimeEvent != null && base_TimeEvent.eIsProxy()) {
			InternalEObject oldBase_TimeEvent = (InternalEObject)base_TimeEvent;
			base_TimeEvent = (TimeEvent)eResolveProxy(oldBase_TimeEvent);
			if (base_TimeEvent != oldBase_TimeEvent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TimePackage.TIMED_EVENT__BASE_TIME_EVENT, oldBase_TimeEvent, base_TimeEvent));
			}
		}
		return base_TimeEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeEvent basicGetBase_TimeEvent() {
		return base_TimeEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_TimeEvent(TimeEvent newBase_TimeEvent) {
		TimeEvent oldBase_TimeEvent = base_TimeEvent;
		base_TimeEvent = newBase_TimeEvent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimePackage.TIMED_EVENT__BASE_TIME_EVENT, oldBase_TimeEvent, base_TimeEvent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueSpecification getEvery() {
		return every;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEvery(ValueSpecification newEvery, NotificationChain msgs) {
		ValueSpecification oldEvery = every;
		every = newEvery;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TimePackage.TIMED_EVENT__EVERY, oldEvery, newEvery);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEvery(ValueSpecification newEvery) {
		if (newEvery != every) {
			NotificationChain msgs = null;
			if (every != null)
				msgs = ((InternalEObject)every).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TimePackage.TIMED_EVENT__EVERY, null, msgs);
			if (newEvery != null)
				msgs = ((InternalEObject)newEvery).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TimePackage.TIMED_EVENT__EVERY, null, msgs);
			msgs = basicSetEvery(newEvery, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimePackage.TIMED_EVENT__EVERY, newEvery, newEvery));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TimePackage.TIMED_EVENT__EVERY:
				return basicSetEvery(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TimePackage.TIMED_EVENT__REPETITION:
				return getRepetition();
			case TimePackage.TIMED_EVENT__BASE_TIME_EVENT:
				if (resolve) return getBase_TimeEvent();
				return basicGetBase_TimeEvent();
			case TimePackage.TIMED_EVENT__EVERY:
				return getEvery();
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
			case TimePackage.TIMED_EVENT__REPETITION:
				setRepetition((Integer)newValue);
				return;
			case TimePackage.TIMED_EVENT__BASE_TIME_EVENT:
				setBase_TimeEvent((TimeEvent)newValue);
				return;
			case TimePackage.TIMED_EVENT__EVERY:
				setEvery((ValueSpecification)newValue);
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
			case TimePackage.TIMED_EVENT__REPETITION:
				setRepetition(REPETITION_EDEFAULT);
				return;
			case TimePackage.TIMED_EVENT__BASE_TIME_EVENT:
				setBase_TimeEvent((TimeEvent)null);
				return;
			case TimePackage.TIMED_EVENT__EVERY:
				setEvery((ValueSpecification)null);
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
			case TimePackage.TIMED_EVENT__REPETITION:
				return repetition != REPETITION_EDEFAULT;
			case TimePackage.TIMED_EVENT__BASE_TIME_EVENT:
				return base_TimeEvent != null;
			case TimePackage.TIMED_EVENT__EVERY:
				return every != null;
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
		result.append(" (repetition: ");
		result.append(repetition);
		result.append(')');
		return result.toString();
	}

} //TimedEventImpl
