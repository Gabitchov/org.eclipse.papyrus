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
package org.eclipse.papyrus.eastadl.timing.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.eastadl.infrastructure.elements.impl.EAElementImpl;
import org.eclipse.papyrus.eastadl.timing.TimeDuration;
import org.eclipse.papyrus.eastadl.timing.TimingPackage;
import org.eclipse.uml2.uml.DataType;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Time Duration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.timing.impl.TimeDurationImpl#getBase_DataType <em>Base Data Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.timing.impl.TimeDurationImpl#getCseCode <em>Cse Code</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.timing.impl.TimeDurationImpl#getCseCodeFactor <em>Cse Code Factor</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.timing.impl.TimeDurationImpl#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TimeDurationImpl extends EAElementImpl implements TimeDuration {

	/**
	 * The cached value of the '{@link #getBase_DataType() <em>Base Data Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_DataType()
	 * @generated
	 * @ordered
	 */
	protected DataType base_DataType;

	/**
	 * The default value of the '{@link #getCseCode() <em>Cse Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCseCode()
	 * @generated
	 * @ordered
	 */
	protected static final int CSE_CODE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getCseCode() <em>Cse Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCseCode()
	 * @generated
	 * @ordered
	 */
	protected int cseCode = CSE_CODE_EDEFAULT;

	/**
	 * The default value of the '{@link #getCseCodeFactor() <em>Cse Code Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCseCodeFactor()
	 * @generated
	 * @ordered
	 */
	protected static final int CSE_CODE_FACTOR_EDEFAULT = 1;

	/**
	 * The cached value of the '{@link #getCseCodeFactor() <em>Cse Code Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCseCodeFactor()
	 * @generated
	 * @ordered
	 */
	protected int cseCodeFactor = CSE_CODE_FACTOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final Float VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected Float value = VALUE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TimeDurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TimingPackage.TIME_DURATION__BASE_DATA_TYPE:
				if (resolve) return getBase_DataType();
				return basicGetBase_DataType();
			case TimingPackage.TIME_DURATION__CSE_CODE:
				return getCseCode();
			case TimingPackage.TIME_DURATION__CSE_CODE_FACTOR:
				return getCseCodeFactor();
			case TimingPackage.TIME_DURATION__VALUE:
				return getValue();
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
			case TimingPackage.TIME_DURATION__BASE_DATA_TYPE:
				return base_DataType != null;
			case TimingPackage.TIME_DURATION__CSE_CODE:
				return cseCode != CSE_CODE_EDEFAULT;
			case TimingPackage.TIME_DURATION__CSE_CODE_FACTOR:
				return cseCodeFactor != CSE_CODE_FACTOR_EDEFAULT;
			case TimingPackage.TIME_DURATION__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
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
			case TimingPackage.TIME_DURATION__BASE_DATA_TYPE:
				setBase_DataType((DataType)newValue);
				return;
			case TimingPackage.TIME_DURATION__CSE_CODE:
				setCseCode((Integer)newValue);
				return;
			case TimingPackage.TIME_DURATION__CSE_CODE_FACTOR:
				setCseCodeFactor((Integer)newValue);
				return;
			case TimingPackage.TIME_DURATION__VALUE:
				setValue((Float)newValue);
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
		return TimingPackage.Literals.TIME_DURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType getBase_DataType() {
		if (base_DataType != null && base_DataType.eIsProxy()) {
			InternalEObject oldBase_DataType = (InternalEObject)base_DataType;
			base_DataType = (DataType)eResolveProxy(oldBase_DataType);
			if (base_DataType != oldBase_DataType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TimingPackage.TIME_DURATION__BASE_DATA_TYPE, oldBase_DataType, base_DataType));
			}
		}
		return base_DataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType basicGetBase_DataType() {
		return base_DataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_DataType(DataType newBase_DataType) {
		DataType oldBase_DataType = base_DataType;
		base_DataType = newBase_DataType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimingPackage.TIME_DURATION__BASE_DATA_TYPE, oldBase_DataType, base_DataType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case TimingPackage.TIME_DURATION__BASE_DATA_TYPE:
				setBase_DataType((DataType)null);
				return;
			case TimingPackage.TIME_DURATION__CSE_CODE:
				setCseCode(CSE_CODE_EDEFAULT);
				return;
			case TimingPackage.TIME_DURATION__CSE_CODE_FACTOR:
				setCseCodeFactor(CSE_CODE_FACTOR_EDEFAULT);
				return;
			case TimingPackage.TIME_DURATION__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getCseCode() {
		return cseCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCseCode(int newCseCode) {
		int oldCseCode = cseCode;
		cseCode = newCseCode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimingPackage.TIME_DURATION__CSE_CODE, oldCseCode, cseCode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getCseCodeFactor() {
		return cseCodeFactor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCseCodeFactor(int newCseCodeFactor) {
		int oldCseCodeFactor = cseCodeFactor;
		cseCodeFactor = newCseCodeFactor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimingPackage.TIME_DURATION__CSE_CODE_FACTOR, oldCseCodeFactor, cseCodeFactor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Float getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(Float newValue) {
		Float oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimingPackage.TIME_DURATION__VALUE, oldValue, value));
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
		result.append(" (cseCode: ");
		result.append(cseCode);
		result.append(", cseCodeFactor: ");
		result.append(cseCodeFactor);
		result.append(", value: ");
		result.append(value);
		result.append(')');
		return result.toString();
	}

} //TimeDurationImpl
