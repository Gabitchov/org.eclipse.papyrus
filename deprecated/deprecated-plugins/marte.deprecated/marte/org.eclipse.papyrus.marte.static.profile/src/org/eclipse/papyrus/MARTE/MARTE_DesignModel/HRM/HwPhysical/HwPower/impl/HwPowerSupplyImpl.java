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
package org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwPhysical.HwPower.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwPhysical.HwLayout.impl.HwComponentImpl;

import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwPhysical.HwPower.HwPowerPackage;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwPhysical.HwPower.HwPowerSupply;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Supply</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwPhysical.HwPower.impl.HwPowerSupplyImpl#getSuppliedPower <em>Supplied Power</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwPhysical.HwPower.impl.HwPowerSupplyImpl#getCapacity <em>Capacity</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class HwPowerSupplyImpl extends HwComponentImpl implements HwPowerSupply {
	/**
	 * The default value of the '{@link #getSuppliedPower() <em>Supplied Power</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuppliedPower()
	 * @generated
	 * @ordered
	 */
	protected static final String SUPPLIED_POWER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSuppliedPower() <em>Supplied Power</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuppliedPower()
	 * @generated
	 * @ordered
	 */
	protected String suppliedPower = SUPPLIED_POWER_EDEFAULT;

	/**
	 * The default value of the '{@link #getCapacity() <em>Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCapacity()
	 * @generated
	 * @ordered
	 */
	protected static final String CAPACITY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCapacity() <em>Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCapacity()
	 * @generated
	 * @ordered
	 */
	protected String capacity = CAPACITY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HwPowerSupplyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HwPowerPackage.Literals.HW_POWER_SUPPLY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSuppliedPower() {
		return suppliedPower;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuppliedPower(String newSuppliedPower) {
		String oldSuppliedPower = suppliedPower;
		suppliedPower = newSuppliedPower;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HwPowerPackage.HW_POWER_SUPPLY__SUPPLIED_POWER, oldSuppliedPower, suppliedPower));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCapacity() {
		return capacity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapacity(String newCapacity) {
		String oldCapacity = capacity;
		capacity = newCapacity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HwPowerPackage.HW_POWER_SUPPLY__CAPACITY, oldCapacity, capacity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case HwPowerPackage.HW_POWER_SUPPLY__SUPPLIED_POWER:
				return getSuppliedPower();
			case HwPowerPackage.HW_POWER_SUPPLY__CAPACITY:
				return getCapacity();
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
			case HwPowerPackage.HW_POWER_SUPPLY__SUPPLIED_POWER:
				setSuppliedPower((String)newValue);
				return;
			case HwPowerPackage.HW_POWER_SUPPLY__CAPACITY:
				setCapacity((String)newValue);
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
			case HwPowerPackage.HW_POWER_SUPPLY__SUPPLIED_POWER:
				setSuppliedPower(SUPPLIED_POWER_EDEFAULT);
				return;
			case HwPowerPackage.HW_POWER_SUPPLY__CAPACITY:
				setCapacity(CAPACITY_EDEFAULT);
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
			case HwPowerPackage.HW_POWER_SUPPLY__SUPPLIED_POWER:
				return SUPPLIED_POWER_EDEFAULT == null ? suppliedPower != null : !SUPPLIED_POWER_EDEFAULT.equals(suppliedPower);
			case HwPowerPackage.HW_POWER_SUPPLY__CAPACITY:
				return CAPACITY_EDEFAULT == null ? capacity != null : !CAPACITY_EDEFAULT.equals(capacity);
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
		result.append(" (suppliedPower: ");
		result.append(suppliedPower);
		result.append(", capacity: ");
		result.append(capacity);
		result.append(')');
		return result.toString();
	}

} //HwPowerSupplyImpl
