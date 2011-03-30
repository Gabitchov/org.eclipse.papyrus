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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimePackage;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimedInstantObservation;

import org.eclipse.papyrus.MARTE_Library.TimeTypesLibrary.EventKind;

import org.eclipse.uml2.uml.TimeObservation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Timed Instant Observation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.TimedInstantObservationImpl#getObsKind <em>Obs Kind</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.TimedInstantObservationImpl#getBase_TimeObservation <em>Base Time Observation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TimedInstantObservationImpl extends TimedElementImpl implements TimedInstantObservation {
	/**
	 * The default value of the '{@link #getObsKind() <em>Obs Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObsKind()
	 * @generated
	 * @ordered
	 */
	protected static final EventKind OBS_KIND_EDEFAULT = EventKind.START;

	/**
	 * The cached value of the '{@link #getObsKind() <em>Obs Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObsKind()
	 * @generated
	 * @ordered
	 */
	protected EventKind obsKind = OBS_KIND_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBase_TimeObservation() <em>Base Time Observation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_TimeObservation()
	 * @generated
	 * @ordered
	 */
	protected TimeObservation base_TimeObservation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TimedInstantObservationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TimePackage.Literals.TIMED_INSTANT_OBSERVATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventKind getObsKind() {
		return obsKind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setObsKind(EventKind newObsKind) {
		EventKind oldObsKind = obsKind;
		obsKind = newObsKind == null ? OBS_KIND_EDEFAULT : newObsKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimePackage.TIMED_INSTANT_OBSERVATION__OBS_KIND, oldObsKind, obsKind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeObservation getBase_TimeObservation() {
		if (base_TimeObservation != null && base_TimeObservation.eIsProxy()) {
			InternalEObject oldBase_TimeObservation = (InternalEObject)base_TimeObservation;
			base_TimeObservation = (TimeObservation)eResolveProxy(oldBase_TimeObservation);
			if (base_TimeObservation != oldBase_TimeObservation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TimePackage.TIMED_INSTANT_OBSERVATION__BASE_TIME_OBSERVATION, oldBase_TimeObservation, base_TimeObservation));
			}
		}
		return base_TimeObservation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeObservation basicGetBase_TimeObservation() {
		return base_TimeObservation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_TimeObservation(TimeObservation newBase_TimeObservation) {
		TimeObservation oldBase_TimeObservation = base_TimeObservation;
		base_TimeObservation = newBase_TimeObservation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimePackage.TIMED_INSTANT_OBSERVATION__BASE_TIME_OBSERVATION, oldBase_TimeObservation, base_TimeObservation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TimePackage.TIMED_INSTANT_OBSERVATION__OBS_KIND:
				return getObsKind();
			case TimePackage.TIMED_INSTANT_OBSERVATION__BASE_TIME_OBSERVATION:
				if (resolve) return getBase_TimeObservation();
				return basicGetBase_TimeObservation();
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
			case TimePackage.TIMED_INSTANT_OBSERVATION__OBS_KIND:
				setObsKind((EventKind)newValue);
				return;
			case TimePackage.TIMED_INSTANT_OBSERVATION__BASE_TIME_OBSERVATION:
				setBase_TimeObservation((TimeObservation)newValue);
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
			case TimePackage.TIMED_INSTANT_OBSERVATION__OBS_KIND:
				setObsKind(OBS_KIND_EDEFAULT);
				return;
			case TimePackage.TIMED_INSTANT_OBSERVATION__BASE_TIME_OBSERVATION:
				setBase_TimeObservation((TimeObservation)null);
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
			case TimePackage.TIMED_INSTANT_OBSERVATION__OBS_KIND:
				return obsKind != OBS_KIND_EDEFAULT;
			case TimePackage.TIMED_INSTANT_OBSERVATION__BASE_TIME_OBSERVATION:
				return base_TimeObservation != null;
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
		result.append(" (obsKind: ");
		result.append(obsKind);
		result.append(')');
		return result.toString();
	}

} //TimedInstantObservationImpl
