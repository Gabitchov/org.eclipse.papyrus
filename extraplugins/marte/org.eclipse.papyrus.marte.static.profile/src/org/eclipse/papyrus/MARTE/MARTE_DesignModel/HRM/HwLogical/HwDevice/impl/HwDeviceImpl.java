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
package org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwDevice.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwGeneral.impl.HwResourceImpl;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwDevice.HwDevice;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwDevice.HwDevicePackage;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.DeviceResource;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.GRMPackage;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.ProcessingResource;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Scheduler;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Hw Device</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwDevice.impl.HwDeviceImpl#getSpeedFactor <em>Speed Factor</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwDevice.impl.HwDeviceImpl#getMainScheduler <em>Main Scheduler</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class HwDeviceImpl extends HwResourceImpl implements HwDevice {
	/**
	 * The default value of the '{@link #getSpeedFactor() <em>Speed Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpeedFactor()
	 * @generated
	 * @ordered
	 */
	protected static final String SPEED_FACTOR_EDEFAULT = "1.0";

	/**
	 * The cached value of the '{@link #getSpeedFactor() <em>Speed Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpeedFactor()
	 * @generated
	 * @ordered
	 */
	protected String speedFactor = SPEED_FACTOR_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMainScheduler() <em>Main Scheduler</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMainScheduler()
	 * @generated
	 * @ordered
	 */
	protected Scheduler mainScheduler;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HwDeviceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HwDevicePackage.Literals.HW_DEVICE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSpeedFactor() {
		return speedFactor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpeedFactor(String newSpeedFactor) {
		String oldSpeedFactor = speedFactor;
		speedFactor = newSpeedFactor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HwDevicePackage.HW_DEVICE__SPEED_FACTOR, oldSpeedFactor, speedFactor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Scheduler getMainScheduler() {
		if (mainScheduler != null && mainScheduler.eIsProxy()) {
			InternalEObject oldMainScheduler = (InternalEObject)mainScheduler;
			mainScheduler = (Scheduler)eResolveProxy(oldMainScheduler);
			if (mainScheduler != oldMainScheduler) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, HwDevicePackage.HW_DEVICE__MAIN_SCHEDULER, oldMainScheduler, mainScheduler));
			}
		}
		return mainScheduler;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Scheduler basicGetMainScheduler() {
		return mainScheduler;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMainScheduler(Scheduler newMainScheduler) {
		Scheduler oldMainScheduler = mainScheduler;
		mainScheduler = newMainScheduler;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HwDevicePackage.HW_DEVICE__MAIN_SCHEDULER, oldMainScheduler, mainScheduler));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case HwDevicePackage.HW_DEVICE__SPEED_FACTOR:
				return getSpeedFactor();
			case HwDevicePackage.HW_DEVICE__MAIN_SCHEDULER:
				if (resolve) return getMainScheduler();
				return basicGetMainScheduler();
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
			case HwDevicePackage.HW_DEVICE__SPEED_FACTOR:
				setSpeedFactor((String)newValue);
				return;
			case HwDevicePackage.HW_DEVICE__MAIN_SCHEDULER:
				setMainScheduler((Scheduler)newValue);
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
			case HwDevicePackage.HW_DEVICE__SPEED_FACTOR:
				setSpeedFactor(SPEED_FACTOR_EDEFAULT);
				return;
			case HwDevicePackage.HW_DEVICE__MAIN_SCHEDULER:
				setMainScheduler((Scheduler)null);
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
			case HwDevicePackage.HW_DEVICE__SPEED_FACTOR:
				return SPEED_FACTOR_EDEFAULT == null ? speedFactor != null : !SPEED_FACTOR_EDEFAULT.equals(speedFactor);
			case HwDevicePackage.HW_DEVICE__MAIN_SCHEDULER:
				return mainScheduler != null;
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
		if (baseClass == ProcessingResource.class) {
			switch (derivedFeatureID) {
				case HwDevicePackage.HW_DEVICE__SPEED_FACTOR: return GRMPackage.PROCESSING_RESOURCE__SPEED_FACTOR;
				case HwDevicePackage.HW_DEVICE__MAIN_SCHEDULER: return GRMPackage.PROCESSING_RESOURCE__MAIN_SCHEDULER;
				default: return -1;
			}
		}
		if (baseClass == DeviceResource.class) {
			switch (derivedFeatureID) {
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
		if (baseClass == ProcessingResource.class) {
			switch (baseFeatureID) {
				case GRMPackage.PROCESSING_RESOURCE__SPEED_FACTOR: return HwDevicePackage.HW_DEVICE__SPEED_FACTOR;
				case GRMPackage.PROCESSING_RESOURCE__MAIN_SCHEDULER: return HwDevicePackage.HW_DEVICE__MAIN_SCHEDULER;
				default: return -1;
			}
		}
		if (baseClass == DeviceResource.class) {
			switch (baseFeatureID) {
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
		result.append(" (speedFactor: ");
		result.append(speedFactor);
		result.append(')');
		return result.toString();
	}

} //HwDeviceImpl
