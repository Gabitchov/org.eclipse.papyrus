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
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwPhysical.HwPower.HwCoolingSupply;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwPhysical.HwPower.HwPowerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Hw Cooling Supply</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwPhysical.HwPower.impl.HwCoolingSupplyImpl#getCoolingPower <em>Cooling Power</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class HwCoolingSupplyImpl extends HwComponentImpl implements HwCoolingSupply {
	/**
	 * The default value of the '{@link #getCoolingPower() <em>Cooling Power</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCoolingPower()
	 * @generated
	 * @ordered
	 */
	protected static final String COOLING_POWER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCoolingPower() <em>Cooling Power</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCoolingPower()
	 * @generated
	 * @ordered
	 */
	protected String coolingPower = COOLING_POWER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HwCoolingSupplyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HwPowerPackage.Literals.HW_COOLING_SUPPLY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCoolingPower() {
		return coolingPower;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCoolingPower(String newCoolingPower) {
		String oldCoolingPower = coolingPower;
		coolingPower = newCoolingPower;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HwPowerPackage.HW_COOLING_SUPPLY__COOLING_POWER, oldCoolingPower, coolingPower));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case HwPowerPackage.HW_COOLING_SUPPLY__COOLING_POWER:
				return getCoolingPower();
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
			case HwPowerPackage.HW_COOLING_SUPPLY__COOLING_POWER:
				setCoolingPower((String)newValue);
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
			case HwPowerPackage.HW_COOLING_SUPPLY__COOLING_POWER:
				setCoolingPower(COOLING_POWER_EDEFAULT);
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
			case HwPowerPackage.HW_COOLING_SUPPLY__COOLING_POWER:
				return COOLING_POWER_EDEFAULT == null ? coolingPower != null : !COOLING_POWER_EDEFAULT.equals(coolingPower);
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
		result.append(" (coolingPower: ");
		result.append(coolingPower);
		result.append(')');
		return result.toString();
	}

} //HwCoolingSupplyImpl
