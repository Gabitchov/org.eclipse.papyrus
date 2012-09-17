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
import org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimedValueSpecification;
import org.eclipse.papyrus.MARTE_Library.TimeTypesLibrary.TimeInterpretationKind;
import org.eclipse.uml2.uml.ValueSpecification;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Timed Value Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.TimedValueSpecificationImpl#getInterpretation <em>Interpretation</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.TimedValueSpecificationImpl#getBase_ValueSpecification <em>Base Value Specification</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TimedValueSpecificationImpl extends TimedElementImpl implements TimedValueSpecification {
	/**
	 * The default value of the '{@link #getInterpretation() <em>Interpretation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterpretation()
	 * @generated
	 * @ordered
	 */
	protected static final TimeInterpretationKind INTERPRETATION_EDEFAULT = TimeInterpretationKind.DURATION;

	/**
	 * The cached value of the '{@link #getInterpretation() <em>Interpretation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterpretation()
	 * @generated
	 * @ordered
	 */
	protected TimeInterpretationKind interpretation = INTERPRETATION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBase_ValueSpecification() <em>Base Value Specification</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_ValueSpecification()
	 * @generated
	 * @ordered
	 */
	protected ValueSpecification base_ValueSpecification;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TimedValueSpecificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TimePackage.Literals.TIMED_VALUE_SPECIFICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeInterpretationKind getInterpretation() {
		return interpretation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInterpretation(TimeInterpretationKind newInterpretation) {
		TimeInterpretationKind oldInterpretation = interpretation;
		interpretation = newInterpretation == null ? INTERPRETATION_EDEFAULT : newInterpretation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimePackage.TIMED_VALUE_SPECIFICATION__INTERPRETATION, oldInterpretation, interpretation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueSpecification getBase_ValueSpecification() {
		if (base_ValueSpecification != null && base_ValueSpecification.eIsProxy()) {
			InternalEObject oldBase_ValueSpecification = (InternalEObject)base_ValueSpecification;
			base_ValueSpecification = (ValueSpecification)eResolveProxy(oldBase_ValueSpecification);
			if (base_ValueSpecification != oldBase_ValueSpecification) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TimePackage.TIMED_VALUE_SPECIFICATION__BASE_VALUE_SPECIFICATION, oldBase_ValueSpecification, base_ValueSpecification));
			}
		}
		return base_ValueSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueSpecification basicGetBase_ValueSpecification() {
		return base_ValueSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_ValueSpecification(ValueSpecification newBase_ValueSpecification) {
		ValueSpecification oldBase_ValueSpecification = base_ValueSpecification;
		base_ValueSpecification = newBase_ValueSpecification;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimePackage.TIMED_VALUE_SPECIFICATION__BASE_VALUE_SPECIFICATION, oldBase_ValueSpecification, base_ValueSpecification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TimePackage.TIMED_VALUE_SPECIFICATION__INTERPRETATION:
				return getInterpretation();
			case TimePackage.TIMED_VALUE_SPECIFICATION__BASE_VALUE_SPECIFICATION:
				if (resolve) return getBase_ValueSpecification();
				return basicGetBase_ValueSpecification();
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
			case TimePackage.TIMED_VALUE_SPECIFICATION__INTERPRETATION:
				setInterpretation((TimeInterpretationKind)newValue);
				return;
			case TimePackage.TIMED_VALUE_SPECIFICATION__BASE_VALUE_SPECIFICATION:
				setBase_ValueSpecification((ValueSpecification)newValue);
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
			case TimePackage.TIMED_VALUE_SPECIFICATION__INTERPRETATION:
				setInterpretation(INTERPRETATION_EDEFAULT);
				return;
			case TimePackage.TIMED_VALUE_SPECIFICATION__BASE_VALUE_SPECIFICATION:
				setBase_ValueSpecification((ValueSpecification)null);
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
			case TimePackage.TIMED_VALUE_SPECIFICATION__INTERPRETATION:
				return interpretation != INTERPRETATION_EDEFAULT;
			case TimePackage.TIMED_VALUE_SPECIFICATION__BASE_VALUE_SPECIFICATION:
				return base_ValueSpecification != null;
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
		result.append(" (interpretation: ");
		result.append(interpretation);
		result.append(')');
		return result.toString();
	}

} //TimedValueSpecificationImpl
