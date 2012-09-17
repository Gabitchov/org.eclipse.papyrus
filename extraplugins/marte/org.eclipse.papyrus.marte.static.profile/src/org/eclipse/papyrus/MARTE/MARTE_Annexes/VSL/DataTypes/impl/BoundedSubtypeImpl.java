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
package org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.BoundedSubtype;
import org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.DataTypesPackage;
import org.eclipse.uml2.uml.DataType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bounded Subtype</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.impl.BoundedSubtypeImpl#getBaseType <em>Base Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.impl.BoundedSubtypeImpl#getMinValue <em>Min Value</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.impl.BoundedSubtypeImpl#getMaxValue <em>Max Value</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.impl.BoundedSubtypeImpl#isIsMinOpen <em>Is Min Open</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.impl.BoundedSubtypeImpl#isIsMaxOpen <em>Is Max Open</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.impl.BoundedSubtypeImpl#getBase_DataType <em>Base Data Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BoundedSubtypeImpl extends EObjectImpl implements BoundedSubtype {
	/**
	 * The cached value of the '{@link #getBaseType() <em>Base Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBaseType()
	 * @generated
	 * @ordered
	 */
	protected DataType baseType;

	/**
	 * The default value of the '{@link #getMinValue() <em>Min Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinValue()
	 * @generated
	 * @ordered
	 */
	protected static final String MIN_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMinValue() <em>Min Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinValue()
	 * @generated
	 * @ordered
	 */
	protected String minValue = MIN_VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxValue() <em>Max Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxValue()
	 * @generated
	 * @ordered
	 */
	protected static final String MAX_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMaxValue() <em>Max Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxValue()
	 * @generated
	 * @ordered
	 */
	protected String maxValue = MAX_VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsMinOpen() <em>Is Min Open</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsMinOpen()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_MIN_OPEN_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsMinOpen() <em>Is Min Open</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsMinOpen()
	 * @generated
	 * @ordered
	 */
	protected boolean isMinOpen = IS_MIN_OPEN_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsMaxOpen() <em>Is Max Open</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsMaxOpen()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_MAX_OPEN_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsMaxOpen() <em>Is Max Open</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsMaxOpen()
	 * @generated
	 * @ordered
	 */
	protected boolean isMaxOpen = IS_MAX_OPEN_EDEFAULT;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BoundedSubtypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataTypesPackage.Literals.BOUNDED_SUBTYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType getBaseType() {
		if (baseType != null && baseType.eIsProxy()) {
			InternalEObject oldBaseType = (InternalEObject)baseType;
			baseType = (DataType)eResolveProxy(oldBaseType);
			if (baseType != oldBaseType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DataTypesPackage.BOUNDED_SUBTYPE__BASE_TYPE, oldBaseType, baseType));
			}
		}
		return baseType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType basicGetBaseType() {
		return baseType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBaseType(DataType newBaseType) {
		DataType oldBaseType = baseType;
		baseType = newBaseType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataTypesPackage.BOUNDED_SUBTYPE__BASE_TYPE, oldBaseType, baseType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMinValue() {
		return minValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinValue(String newMinValue) {
		String oldMinValue = minValue;
		minValue = newMinValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataTypesPackage.BOUNDED_SUBTYPE__MIN_VALUE, oldMinValue, minValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMaxValue() {
		return maxValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxValue(String newMaxValue) {
		String oldMaxValue = maxValue;
		maxValue = newMaxValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataTypesPackage.BOUNDED_SUBTYPE__MAX_VALUE, oldMaxValue, maxValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsMinOpen() {
		return isMinOpen;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsMinOpen(boolean newIsMinOpen) {
		boolean oldIsMinOpen = isMinOpen;
		isMinOpen = newIsMinOpen;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataTypesPackage.BOUNDED_SUBTYPE__IS_MIN_OPEN, oldIsMinOpen, isMinOpen));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsMaxOpen() {
		return isMaxOpen;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsMaxOpen(boolean newIsMaxOpen) {
		boolean oldIsMaxOpen = isMaxOpen;
		isMaxOpen = newIsMaxOpen;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataTypesPackage.BOUNDED_SUBTYPE__IS_MAX_OPEN, oldIsMaxOpen, isMaxOpen));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DataTypesPackage.BOUNDED_SUBTYPE__BASE_DATA_TYPE, oldBase_DataType, base_DataType));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DataTypesPackage.BOUNDED_SUBTYPE__BASE_DATA_TYPE, oldBase_DataType, base_DataType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DataTypesPackage.BOUNDED_SUBTYPE__BASE_TYPE:
				if (resolve) return getBaseType();
				return basicGetBaseType();
			case DataTypesPackage.BOUNDED_SUBTYPE__MIN_VALUE:
				return getMinValue();
			case DataTypesPackage.BOUNDED_SUBTYPE__MAX_VALUE:
				return getMaxValue();
			case DataTypesPackage.BOUNDED_SUBTYPE__IS_MIN_OPEN:
				return isIsMinOpen();
			case DataTypesPackage.BOUNDED_SUBTYPE__IS_MAX_OPEN:
				return isIsMaxOpen();
			case DataTypesPackage.BOUNDED_SUBTYPE__BASE_DATA_TYPE:
				if (resolve) return getBase_DataType();
				return basicGetBase_DataType();
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
			case DataTypesPackage.BOUNDED_SUBTYPE__BASE_TYPE:
				setBaseType((DataType)newValue);
				return;
			case DataTypesPackage.BOUNDED_SUBTYPE__MIN_VALUE:
				setMinValue((String)newValue);
				return;
			case DataTypesPackage.BOUNDED_SUBTYPE__MAX_VALUE:
				setMaxValue((String)newValue);
				return;
			case DataTypesPackage.BOUNDED_SUBTYPE__IS_MIN_OPEN:
				setIsMinOpen((Boolean)newValue);
				return;
			case DataTypesPackage.BOUNDED_SUBTYPE__IS_MAX_OPEN:
				setIsMaxOpen((Boolean)newValue);
				return;
			case DataTypesPackage.BOUNDED_SUBTYPE__BASE_DATA_TYPE:
				setBase_DataType((DataType)newValue);
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
			case DataTypesPackage.BOUNDED_SUBTYPE__BASE_TYPE:
				setBaseType((DataType)null);
				return;
			case DataTypesPackage.BOUNDED_SUBTYPE__MIN_VALUE:
				setMinValue(MIN_VALUE_EDEFAULT);
				return;
			case DataTypesPackage.BOUNDED_SUBTYPE__MAX_VALUE:
				setMaxValue(MAX_VALUE_EDEFAULT);
				return;
			case DataTypesPackage.BOUNDED_SUBTYPE__IS_MIN_OPEN:
				setIsMinOpen(IS_MIN_OPEN_EDEFAULT);
				return;
			case DataTypesPackage.BOUNDED_SUBTYPE__IS_MAX_OPEN:
				setIsMaxOpen(IS_MAX_OPEN_EDEFAULT);
				return;
			case DataTypesPackage.BOUNDED_SUBTYPE__BASE_DATA_TYPE:
				setBase_DataType((DataType)null);
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
			case DataTypesPackage.BOUNDED_SUBTYPE__BASE_TYPE:
				return baseType != null;
			case DataTypesPackage.BOUNDED_SUBTYPE__MIN_VALUE:
				return MIN_VALUE_EDEFAULT == null ? minValue != null : !MIN_VALUE_EDEFAULT.equals(minValue);
			case DataTypesPackage.BOUNDED_SUBTYPE__MAX_VALUE:
				return MAX_VALUE_EDEFAULT == null ? maxValue != null : !MAX_VALUE_EDEFAULT.equals(maxValue);
			case DataTypesPackage.BOUNDED_SUBTYPE__IS_MIN_OPEN:
				return isMinOpen != IS_MIN_OPEN_EDEFAULT;
			case DataTypesPackage.BOUNDED_SUBTYPE__IS_MAX_OPEN:
				return isMaxOpen != IS_MAX_OPEN_EDEFAULT;
			case DataTypesPackage.BOUNDED_SUBTYPE__BASE_DATA_TYPE:
				return base_DataType != null;
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
		result.append(" (minValue: ");
		result.append(minValue);
		result.append(", maxValue: ");
		result.append(maxValue);
		result.append(", isMinOpen: ");
		result.append(isMinOpen);
		result.append(", isMaxOpen: ");
		result.append(isMaxOpen);
		result.append(')');
		return result.toString();
	}

} //BoundedSubtypeImpl
