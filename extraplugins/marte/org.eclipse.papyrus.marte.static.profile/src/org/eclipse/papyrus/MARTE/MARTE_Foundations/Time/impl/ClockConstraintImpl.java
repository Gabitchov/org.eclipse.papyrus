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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.impl.NfpConstraintImpl;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.Clock;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.ClockConstraint;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimePackage;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimedElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Clock Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.ClockConstraintImpl#getOn <em>On</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.ClockConstraintImpl#isIsCoincidenceBased <em>Is Coincidence Based</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.ClockConstraintImpl#isIsPrecedenceBased <em>Is Precedence Based</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.ClockConstraintImpl#isIsChronometricBased <em>Is Chronometric Based</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClockConstraintImpl extends NfpConstraintImpl implements ClockConstraint {
	/**
	 * The cached value of the '{@link #getOn() <em>On</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOn()
	 * @generated
	 * @ordered
	 */
	protected EList<Clock> on;

	/**
	 * The default value of the '{@link #isIsCoincidenceBased() <em>Is Coincidence Based</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsCoincidenceBased()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_COINCIDENCE_BASED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsCoincidenceBased() <em>Is Coincidence Based</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsCoincidenceBased()
	 * @generated
	 * @ordered
	 */
	protected boolean isCoincidenceBased = IS_COINCIDENCE_BASED_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsPrecedenceBased() <em>Is Precedence Based</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsPrecedenceBased()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_PRECEDENCE_BASED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsPrecedenceBased() <em>Is Precedence Based</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsPrecedenceBased()
	 * @generated
	 * @ordered
	 */
	protected boolean isPrecedenceBased = IS_PRECEDENCE_BASED_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsChronometricBased() <em>Is Chronometric Based</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsChronometricBased()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_CHRONOMETRIC_BASED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsChronometricBased() <em>Is Chronometric Based</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsChronometricBased()
	 * @generated
	 * @ordered
	 */
	protected boolean isChronometricBased = IS_CHRONOMETRIC_BASED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClockConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TimePackage.Literals.CLOCK_CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Clock> getOn() {
		if (on == null) {
			on = new EObjectResolvingEList<Clock>(Clock.class, this, TimePackage.CLOCK_CONSTRAINT__ON);
		}
		return on;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsCoincidenceBased() {
		return isCoincidenceBased;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsCoincidenceBased(boolean newIsCoincidenceBased) {
		boolean oldIsCoincidenceBased = isCoincidenceBased;
		isCoincidenceBased = newIsCoincidenceBased;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimePackage.CLOCK_CONSTRAINT__IS_COINCIDENCE_BASED, oldIsCoincidenceBased, isCoincidenceBased));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsPrecedenceBased() {
		return isPrecedenceBased;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsPrecedenceBased(boolean newIsPrecedenceBased) {
		boolean oldIsPrecedenceBased = isPrecedenceBased;
		isPrecedenceBased = newIsPrecedenceBased;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimePackage.CLOCK_CONSTRAINT__IS_PRECEDENCE_BASED, oldIsPrecedenceBased, isPrecedenceBased));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsChronometricBased() {
		return isChronometricBased;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsChronometricBased(boolean newIsChronometricBased) {
		boolean oldIsChronometricBased = isChronometricBased;
		isChronometricBased = newIsChronometricBased;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimePackage.CLOCK_CONSTRAINT__IS_CHRONOMETRIC_BASED, oldIsChronometricBased, isChronometricBased));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TimePackage.CLOCK_CONSTRAINT__ON:
				return getOn();
			case TimePackage.CLOCK_CONSTRAINT__IS_COINCIDENCE_BASED:
				return isIsCoincidenceBased();
			case TimePackage.CLOCK_CONSTRAINT__IS_PRECEDENCE_BASED:
				return isIsPrecedenceBased();
			case TimePackage.CLOCK_CONSTRAINT__IS_CHRONOMETRIC_BASED:
				return isIsChronometricBased();
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
			case TimePackage.CLOCK_CONSTRAINT__ON:
				getOn().clear();
				getOn().addAll((Collection<? extends Clock>)newValue);
				return;
			case TimePackage.CLOCK_CONSTRAINT__IS_COINCIDENCE_BASED:
				setIsCoincidenceBased((Boolean)newValue);
				return;
			case TimePackage.CLOCK_CONSTRAINT__IS_PRECEDENCE_BASED:
				setIsPrecedenceBased((Boolean)newValue);
				return;
			case TimePackage.CLOCK_CONSTRAINT__IS_CHRONOMETRIC_BASED:
				setIsChronometricBased((Boolean)newValue);
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
			case TimePackage.CLOCK_CONSTRAINT__ON:
				getOn().clear();
				return;
			case TimePackage.CLOCK_CONSTRAINT__IS_COINCIDENCE_BASED:
				setIsCoincidenceBased(IS_COINCIDENCE_BASED_EDEFAULT);
				return;
			case TimePackage.CLOCK_CONSTRAINT__IS_PRECEDENCE_BASED:
				setIsPrecedenceBased(IS_PRECEDENCE_BASED_EDEFAULT);
				return;
			case TimePackage.CLOCK_CONSTRAINT__IS_CHRONOMETRIC_BASED:
				setIsChronometricBased(IS_CHRONOMETRIC_BASED_EDEFAULT);
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
			case TimePackage.CLOCK_CONSTRAINT__ON:
				return on != null && !on.isEmpty();
			case TimePackage.CLOCK_CONSTRAINT__IS_COINCIDENCE_BASED:
				return isCoincidenceBased != IS_COINCIDENCE_BASED_EDEFAULT;
			case TimePackage.CLOCK_CONSTRAINT__IS_PRECEDENCE_BASED:
				return isPrecedenceBased != IS_PRECEDENCE_BASED_EDEFAULT;
			case TimePackage.CLOCK_CONSTRAINT__IS_CHRONOMETRIC_BASED:
				return isChronometricBased != IS_CHRONOMETRIC_BASED_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == TimedElement.class) {
			switch (derivedFeatureID) {
				case TimePackage.CLOCK_CONSTRAINT__ON: return TimePackage.TIMED_ELEMENT__ON;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == TimedElement.class) {
			switch (baseFeatureID) {
				case TimePackage.TIMED_ELEMENT__ON: return TimePackage.CLOCK_CONSTRAINT__ON;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (isCoincidenceBased: ");
		result.append(isCoincidenceBased);
		result.append(", isPrecedenceBased: ");
		result.append(isPrecedenceBased);
		result.append(", isChronometricBased: ");
		result.append(isChronometricBased);
		result.append(')');
		return result.toString();
	}

} //ClockConstraintImpl
