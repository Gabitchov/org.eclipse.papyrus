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
package org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwGeneral.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwGeneral.HwGeneralPackage;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwGeneral.HwResourceService;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.GrServiceImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Hw Resource Service</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwGeneral.impl.HwResourceServiceImpl#getConsumption <em>Consumption</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwGeneral.impl.HwResourceServiceImpl#getDissipation <em>Dissipation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class HwResourceServiceImpl extends GrServiceImpl implements HwResourceService {
	/**
	 * The default value of the '{@link #getConsumption() <em>Consumption</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConsumption()
	 * @generated
	 * @ordered
	 */
	protected static final String CONSUMPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getConsumption() <em>Consumption</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConsumption()
	 * @generated
	 * @ordered
	 */
	protected String consumption = CONSUMPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getDissipation() <em>Dissipation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDissipation()
	 * @generated
	 * @ordered
	 */
	protected static final String DISSIPATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDissipation() <em>Dissipation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDissipation()
	 * @generated
	 * @ordered
	 */
	protected String dissipation = DISSIPATION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HwResourceServiceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HwGeneralPackage.Literals.HW_RESOURCE_SERVICE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getConsumption() {
		return consumption;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConsumption(String newConsumption) {
		String oldConsumption = consumption;
		consumption = newConsumption;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HwGeneralPackage.HW_RESOURCE_SERVICE__CONSUMPTION, oldConsumption, consumption));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDissipation() {
		return dissipation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDissipation(String newDissipation) {
		String oldDissipation = dissipation;
		dissipation = newDissipation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HwGeneralPackage.HW_RESOURCE_SERVICE__DISSIPATION, oldDissipation, dissipation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case HwGeneralPackage.HW_RESOURCE_SERVICE__CONSUMPTION:
				return getConsumption();
			case HwGeneralPackage.HW_RESOURCE_SERVICE__DISSIPATION:
				return getDissipation();
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
			case HwGeneralPackage.HW_RESOURCE_SERVICE__CONSUMPTION:
				setConsumption((String)newValue);
				return;
			case HwGeneralPackage.HW_RESOURCE_SERVICE__DISSIPATION:
				setDissipation((String)newValue);
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
			case HwGeneralPackage.HW_RESOURCE_SERVICE__CONSUMPTION:
				setConsumption(CONSUMPTION_EDEFAULT);
				return;
			case HwGeneralPackage.HW_RESOURCE_SERVICE__DISSIPATION:
				setDissipation(DISSIPATION_EDEFAULT);
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
			case HwGeneralPackage.HW_RESOURCE_SERVICE__CONSUMPTION:
				return CONSUMPTION_EDEFAULT == null ? consumption != null : !CONSUMPTION_EDEFAULT.equals(consumption);
			case HwGeneralPackage.HW_RESOURCE_SERVICE__DISSIPATION:
				return DISSIPATION_EDEFAULT == null ? dissipation != null : !DISSIPATION_EDEFAULT.equals(dissipation);
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
		result.append(" (consumption: ");
		result.append(consumption);
		result.append(", dissipation: ");
		result.append(dissipation);
		result.append(')');
		return result.toString();
	}

} //HwResourceServiceImpl
