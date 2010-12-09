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
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.ClockType;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimePackage;

import org.eclipse.papyrus.MARTE_Library.TimeTypesLibrary.TimeNatureKind;

import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Property;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Clock Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.ClockTypeImpl#getNature <em>Nature</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.ClockTypeImpl#getUnitType <em>Unit Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.ClockTypeImpl#isIsLogical <em>Is Logical</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.ClockTypeImpl#getResolAttr <em>Resol Attr</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.ClockTypeImpl#getMaxValAttr <em>Max Val Attr</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.ClockTypeImpl#getOffsetAttr <em>Offset Attr</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.ClockTypeImpl#getGetTime <em>Get Time</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.ClockTypeImpl#getSetTime <em>Set Time</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.ClockTypeImpl#getIndexToValue <em>Index To Value</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.ClockTypeImpl#getBase_Class <em>Base Class</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClockTypeImpl extends EObjectImpl implements ClockType {
	/**
	 * The default value of the '{@link #getNature() <em>Nature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNature()
	 * @generated
	 * @ordered
	 */
	protected static final TimeNatureKind NATURE_EDEFAULT = TimeNatureKind.DISCRETE;

	/**
	 * The cached value of the '{@link #getNature() <em>Nature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNature()
	 * @generated
	 * @ordered
	 */
	protected TimeNatureKind nature = NATURE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getUnitType() <em>Unit Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnitType()
	 * @generated
	 * @ordered
	 */
	protected Enumeration unitType;

	/**
	 * The default value of the '{@link #isIsLogical() <em>Is Logical</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsLogical()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_LOGICAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsLogical() <em>Is Logical</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsLogical()
	 * @generated
	 * @ordered
	 */
	protected boolean isLogical = IS_LOGICAL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getResolAttr() <em>Resol Attr</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResolAttr()
	 * @generated
	 * @ordered
	 */
	protected Property resolAttr;

	/**
	 * The cached value of the '{@link #getMaxValAttr() <em>Max Val Attr</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxValAttr()
	 * @generated
	 * @ordered
	 */
	protected Property maxValAttr;

	/**
	 * The cached value of the '{@link #getOffsetAttr() <em>Offset Attr</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOffsetAttr()
	 * @generated
	 * @ordered
	 */
	protected Property offsetAttr;

	/**
	 * The cached value of the '{@link #getGetTime() <em>Get Time</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGetTime()
	 * @generated
	 * @ordered
	 */
	protected Operation getTime;

	/**
	 * The cached value of the '{@link #getSetTime() <em>Set Time</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSetTime()
	 * @generated
	 * @ordered
	 */
	protected Operation setTime;

	/**
	 * The cached value of the '{@link #getIndexToValue() <em>Index To Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndexToValue()
	 * @generated
	 * @ordered
	 */
	protected Operation indexToValue;

	/**
	 * The cached value of the '{@link #getBase_Class() <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Class()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.Class base_Class;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClockTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TimePackage.Literals.CLOCK_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeNatureKind getNature() {
		return nature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNature(TimeNatureKind newNature) {
		TimeNatureKind oldNature = nature;
		nature = newNature == null ? NATURE_EDEFAULT : newNature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimePackage.CLOCK_TYPE__NATURE, oldNature, nature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Enumeration getUnitType() {
		if (unitType != null && unitType.eIsProxy()) {
			InternalEObject oldUnitType = (InternalEObject)unitType;
			unitType = (Enumeration)eResolveProxy(oldUnitType);
			if (unitType != oldUnitType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TimePackage.CLOCK_TYPE__UNIT_TYPE, oldUnitType, unitType));
			}
		}
		return unitType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Enumeration basicGetUnitType() {
		return unitType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitType(Enumeration newUnitType) {
		Enumeration oldUnitType = unitType;
		unitType = newUnitType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimePackage.CLOCK_TYPE__UNIT_TYPE, oldUnitType, unitType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsLogical() {
		return isLogical;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsLogical(boolean newIsLogical) {
		boolean oldIsLogical = isLogical;
		isLogical = newIsLogical;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimePackage.CLOCK_TYPE__IS_LOGICAL, oldIsLogical, isLogical));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property getResolAttr() {
		if (resolAttr != null && resolAttr.eIsProxy()) {
			InternalEObject oldResolAttr = (InternalEObject)resolAttr;
			resolAttr = (Property)eResolveProxy(oldResolAttr);
			if (resolAttr != oldResolAttr) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TimePackage.CLOCK_TYPE__RESOL_ATTR, oldResolAttr, resolAttr));
			}
		}
		return resolAttr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property basicGetResolAttr() {
		return resolAttr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResolAttr(Property newResolAttr) {
		Property oldResolAttr = resolAttr;
		resolAttr = newResolAttr;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimePackage.CLOCK_TYPE__RESOL_ATTR, oldResolAttr, resolAttr));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property getMaxValAttr() {
		if (maxValAttr != null && maxValAttr.eIsProxy()) {
			InternalEObject oldMaxValAttr = (InternalEObject)maxValAttr;
			maxValAttr = (Property)eResolveProxy(oldMaxValAttr);
			if (maxValAttr != oldMaxValAttr) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TimePackage.CLOCK_TYPE__MAX_VAL_ATTR, oldMaxValAttr, maxValAttr));
			}
		}
		return maxValAttr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property basicGetMaxValAttr() {
		return maxValAttr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxValAttr(Property newMaxValAttr) {
		Property oldMaxValAttr = maxValAttr;
		maxValAttr = newMaxValAttr;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimePackage.CLOCK_TYPE__MAX_VAL_ATTR, oldMaxValAttr, maxValAttr));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property getOffsetAttr() {
		if (offsetAttr != null && offsetAttr.eIsProxy()) {
			InternalEObject oldOffsetAttr = (InternalEObject)offsetAttr;
			offsetAttr = (Property)eResolveProxy(oldOffsetAttr);
			if (offsetAttr != oldOffsetAttr) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TimePackage.CLOCK_TYPE__OFFSET_ATTR, oldOffsetAttr, offsetAttr));
			}
		}
		return offsetAttr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property basicGetOffsetAttr() {
		return offsetAttr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOffsetAttr(Property newOffsetAttr) {
		Property oldOffsetAttr = offsetAttr;
		offsetAttr = newOffsetAttr;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimePackage.CLOCK_TYPE__OFFSET_ATTR, oldOffsetAttr, offsetAttr));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation getGetTime() {
		if (getTime != null && getTime.eIsProxy()) {
			InternalEObject oldGetTime = (InternalEObject)getTime;
			getTime = (Operation)eResolveProxy(oldGetTime);
			if (getTime != oldGetTime) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TimePackage.CLOCK_TYPE__GET_TIME, oldGetTime, getTime));
			}
		}
		return getTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation basicGetGetTime() {
		return getTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGetTime(Operation newGetTime) {
		Operation oldGetTime = getTime;
		getTime = newGetTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimePackage.CLOCK_TYPE__GET_TIME, oldGetTime, getTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation getSetTime() {
		if (setTime != null && setTime.eIsProxy()) {
			InternalEObject oldSetTime = (InternalEObject)setTime;
			setTime = (Operation)eResolveProxy(oldSetTime);
			if (setTime != oldSetTime) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TimePackage.CLOCK_TYPE__SET_TIME, oldSetTime, setTime));
			}
		}
		return setTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation basicGetSetTime() {
		return setTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSetTime(Operation newSetTime) {
		Operation oldSetTime = setTime;
		setTime = newSetTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimePackage.CLOCK_TYPE__SET_TIME, oldSetTime, setTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation getIndexToValue() {
		if (indexToValue != null && indexToValue.eIsProxy()) {
			InternalEObject oldIndexToValue = (InternalEObject)indexToValue;
			indexToValue = (Operation)eResolveProxy(oldIndexToValue);
			if (indexToValue != oldIndexToValue) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TimePackage.CLOCK_TYPE__INDEX_TO_VALUE, oldIndexToValue, indexToValue));
			}
		}
		return indexToValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation basicGetIndexToValue() {
		return indexToValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIndexToValue(Operation newIndexToValue) {
		Operation oldIndexToValue = indexToValue;
		indexToValue = newIndexToValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimePackage.CLOCK_TYPE__INDEX_TO_VALUE, oldIndexToValue, indexToValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class getBase_Class() {
		if (base_Class != null && base_Class.eIsProxy()) {
			InternalEObject oldBase_Class = (InternalEObject)base_Class;
			base_Class = (org.eclipse.uml2.uml.Class)eResolveProxy(oldBase_Class);
			if (base_Class != oldBase_Class) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TimePackage.CLOCK_TYPE__BASE_CLASS, oldBase_Class, base_Class));
			}
		}
		return base_Class;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class basicGetBase_Class() {
		return base_Class;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Class(org.eclipse.uml2.uml.Class newBase_Class) {
		org.eclipse.uml2.uml.Class oldBase_Class = base_Class;
		base_Class = newBase_Class;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimePackage.CLOCK_TYPE__BASE_CLASS, oldBase_Class, base_Class));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TimePackage.CLOCK_TYPE__NATURE:
				return getNature();
			case TimePackage.CLOCK_TYPE__UNIT_TYPE:
				if (resolve) return getUnitType();
				return basicGetUnitType();
			case TimePackage.CLOCK_TYPE__IS_LOGICAL:
				return isIsLogical();
			case TimePackage.CLOCK_TYPE__RESOL_ATTR:
				if (resolve) return getResolAttr();
				return basicGetResolAttr();
			case TimePackage.CLOCK_TYPE__MAX_VAL_ATTR:
				if (resolve) return getMaxValAttr();
				return basicGetMaxValAttr();
			case TimePackage.CLOCK_TYPE__OFFSET_ATTR:
				if (resolve) return getOffsetAttr();
				return basicGetOffsetAttr();
			case TimePackage.CLOCK_TYPE__GET_TIME:
				if (resolve) return getGetTime();
				return basicGetGetTime();
			case TimePackage.CLOCK_TYPE__SET_TIME:
				if (resolve) return getSetTime();
				return basicGetSetTime();
			case TimePackage.CLOCK_TYPE__INDEX_TO_VALUE:
				if (resolve) return getIndexToValue();
				return basicGetIndexToValue();
			case TimePackage.CLOCK_TYPE__BASE_CLASS:
				if (resolve) return getBase_Class();
				return basicGetBase_Class();
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
			case TimePackage.CLOCK_TYPE__NATURE:
				setNature((TimeNatureKind)newValue);
				return;
			case TimePackage.CLOCK_TYPE__UNIT_TYPE:
				setUnitType((Enumeration)newValue);
				return;
			case TimePackage.CLOCK_TYPE__IS_LOGICAL:
				setIsLogical((Boolean)newValue);
				return;
			case TimePackage.CLOCK_TYPE__RESOL_ATTR:
				setResolAttr((Property)newValue);
				return;
			case TimePackage.CLOCK_TYPE__MAX_VAL_ATTR:
				setMaxValAttr((Property)newValue);
				return;
			case TimePackage.CLOCK_TYPE__OFFSET_ATTR:
				setOffsetAttr((Property)newValue);
				return;
			case TimePackage.CLOCK_TYPE__GET_TIME:
				setGetTime((Operation)newValue);
				return;
			case TimePackage.CLOCK_TYPE__SET_TIME:
				setSetTime((Operation)newValue);
				return;
			case TimePackage.CLOCK_TYPE__INDEX_TO_VALUE:
				setIndexToValue((Operation)newValue);
				return;
			case TimePackage.CLOCK_TYPE__BASE_CLASS:
				setBase_Class((org.eclipse.uml2.uml.Class)newValue);
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
			case TimePackage.CLOCK_TYPE__NATURE:
				setNature(NATURE_EDEFAULT);
				return;
			case TimePackage.CLOCK_TYPE__UNIT_TYPE:
				setUnitType((Enumeration)null);
				return;
			case TimePackage.CLOCK_TYPE__IS_LOGICAL:
				setIsLogical(IS_LOGICAL_EDEFAULT);
				return;
			case TimePackage.CLOCK_TYPE__RESOL_ATTR:
				setResolAttr((Property)null);
				return;
			case TimePackage.CLOCK_TYPE__MAX_VAL_ATTR:
				setMaxValAttr((Property)null);
				return;
			case TimePackage.CLOCK_TYPE__OFFSET_ATTR:
				setOffsetAttr((Property)null);
				return;
			case TimePackage.CLOCK_TYPE__GET_TIME:
				setGetTime((Operation)null);
				return;
			case TimePackage.CLOCK_TYPE__SET_TIME:
				setSetTime((Operation)null);
				return;
			case TimePackage.CLOCK_TYPE__INDEX_TO_VALUE:
				setIndexToValue((Operation)null);
				return;
			case TimePackage.CLOCK_TYPE__BASE_CLASS:
				setBase_Class((org.eclipse.uml2.uml.Class)null);
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
			case TimePackage.CLOCK_TYPE__NATURE:
				return nature != NATURE_EDEFAULT;
			case TimePackage.CLOCK_TYPE__UNIT_TYPE:
				return unitType != null;
			case TimePackage.CLOCK_TYPE__IS_LOGICAL:
				return isLogical != IS_LOGICAL_EDEFAULT;
			case TimePackage.CLOCK_TYPE__RESOL_ATTR:
				return resolAttr != null;
			case TimePackage.CLOCK_TYPE__MAX_VAL_ATTR:
				return maxValAttr != null;
			case TimePackage.CLOCK_TYPE__OFFSET_ATTR:
				return offsetAttr != null;
			case TimePackage.CLOCK_TYPE__GET_TIME:
				return getTime != null;
			case TimePackage.CLOCK_TYPE__SET_TIME:
				return setTime != null;
			case TimePackage.CLOCK_TYPE__INDEX_TO_VALUE:
				return indexToValue != null;
			case TimePackage.CLOCK_TYPE__BASE_CLASS:
				return base_Class != null;
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
		result.append(" (nature: ");
		result.append(nature);
		result.append(", isLogical: ");
		result.append(isLogical);
		result.append(')');
		return result.toString();
	}

} //ClockTypeImpl
