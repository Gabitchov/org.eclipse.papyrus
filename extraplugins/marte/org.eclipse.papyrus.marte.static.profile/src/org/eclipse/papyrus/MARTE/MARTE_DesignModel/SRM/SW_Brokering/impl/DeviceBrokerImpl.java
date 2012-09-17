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
package org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.AccessPolicyKind;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.DeviceBroker;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.SW_BrokeringPackage;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_ResourceCore.impl.SwResourceImpl;
import org.eclipse.uml2.uml.BehavioralFeature;
import org.eclipse.uml2.uml.TypedElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Device Broker</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.impl.DeviceBrokerImpl#getAccessPolicy <em>Access Policy</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.impl.DeviceBrokerImpl#isIsBuffered <em>Is Buffered</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.impl.DeviceBrokerImpl#getDevices <em>Devices</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.impl.DeviceBrokerImpl#getCloseServices <em>Close Services</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.impl.DeviceBrokerImpl#getControlServices <em>Control Services</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.impl.DeviceBrokerImpl#getOpenServices <em>Open Services</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.impl.DeviceBrokerImpl#getReadServices <em>Read Services</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.impl.DeviceBrokerImpl#getWriteServices <em>Write Services</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DeviceBrokerImpl extends SwResourceImpl implements DeviceBroker {
	/**
	 * The default value of the '{@link #getAccessPolicy() <em>Access Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccessPolicy()
	 * @generated
	 * @ordered
	 */
	protected static final AccessPolicyKind ACCESS_POLICY_EDEFAULT = AccessPolicyKind.READ;

	/**
	 * The cached value of the '{@link #getAccessPolicy() <em>Access Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccessPolicy()
	 * @generated
	 * @ordered
	 */
	protected AccessPolicyKind accessPolicy = ACCESS_POLICY_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsBuffered() <em>Is Buffered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsBuffered()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_BUFFERED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsBuffered() <em>Is Buffered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsBuffered()
	 * @generated
	 * @ordered
	 */
	protected boolean isBuffered = IS_BUFFERED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDevices() <em>Devices</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDevices()
	 * @generated
	 * @ordered
	 */
	protected EList<TypedElement> devices;

	/**
	 * The cached value of the '{@link #getCloseServices() <em>Close Services</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCloseServices()
	 * @generated
	 * @ordered
	 */
	protected EList<BehavioralFeature> closeServices;

	/**
	 * The cached value of the '{@link #getControlServices() <em>Control Services</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getControlServices()
	 * @generated
	 * @ordered
	 */
	protected EList<BehavioralFeature> controlServices;

	/**
	 * The cached value of the '{@link #getOpenServices() <em>Open Services</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOpenServices()
	 * @generated
	 * @ordered
	 */
	protected EList<BehavioralFeature> openServices;

	/**
	 * The cached value of the '{@link #getReadServices() <em>Read Services</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReadServices()
	 * @generated
	 * @ordered
	 */
	protected EList<BehavioralFeature> readServices;

	/**
	 * The cached value of the '{@link #getWriteServices() <em>Write Services</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWriteServices()
	 * @generated
	 * @ordered
	 */
	protected EList<BehavioralFeature> writeServices;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DeviceBrokerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SW_BrokeringPackage.Literals.DEVICE_BROKER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AccessPolicyKind getAccessPolicy() {
		return accessPolicy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAccessPolicy(AccessPolicyKind newAccessPolicy) {
		AccessPolicyKind oldAccessPolicy = accessPolicy;
		accessPolicy = newAccessPolicy == null ? ACCESS_POLICY_EDEFAULT : newAccessPolicy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SW_BrokeringPackage.DEVICE_BROKER__ACCESS_POLICY, oldAccessPolicy, accessPolicy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsBuffered() {
		return isBuffered;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsBuffered(boolean newIsBuffered) {
		boolean oldIsBuffered = isBuffered;
		isBuffered = newIsBuffered;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SW_BrokeringPackage.DEVICE_BROKER__IS_BUFFERED, oldIsBuffered, isBuffered));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TypedElement> getDevices() {
		if (devices == null) {
			devices = new EObjectResolvingEList<TypedElement>(TypedElement.class, this, SW_BrokeringPackage.DEVICE_BROKER__DEVICES);
		}
		return devices;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BehavioralFeature> getCloseServices() {
		if (closeServices == null) {
			closeServices = new EObjectResolvingEList<BehavioralFeature>(BehavioralFeature.class, this, SW_BrokeringPackage.DEVICE_BROKER__CLOSE_SERVICES);
		}
		return closeServices;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BehavioralFeature> getControlServices() {
		if (controlServices == null) {
			controlServices = new EObjectResolvingEList<BehavioralFeature>(BehavioralFeature.class, this, SW_BrokeringPackage.DEVICE_BROKER__CONTROL_SERVICES);
		}
		return controlServices;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BehavioralFeature> getOpenServices() {
		if (openServices == null) {
			openServices = new EObjectResolvingEList<BehavioralFeature>(BehavioralFeature.class, this, SW_BrokeringPackage.DEVICE_BROKER__OPEN_SERVICES);
		}
		return openServices;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BehavioralFeature> getReadServices() {
		if (readServices == null) {
			readServices = new EObjectResolvingEList<BehavioralFeature>(BehavioralFeature.class, this, SW_BrokeringPackage.DEVICE_BROKER__READ_SERVICES);
		}
		return readServices;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BehavioralFeature> getWriteServices() {
		if (writeServices == null) {
			writeServices = new EObjectResolvingEList<BehavioralFeature>(BehavioralFeature.class, this, SW_BrokeringPackage.DEVICE_BROKER__WRITE_SERVICES);
		}
		return writeServices;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SW_BrokeringPackage.DEVICE_BROKER__ACCESS_POLICY:
				return getAccessPolicy();
			case SW_BrokeringPackage.DEVICE_BROKER__IS_BUFFERED:
				return isIsBuffered();
			case SW_BrokeringPackage.DEVICE_BROKER__DEVICES:
				return getDevices();
			case SW_BrokeringPackage.DEVICE_BROKER__CLOSE_SERVICES:
				return getCloseServices();
			case SW_BrokeringPackage.DEVICE_BROKER__CONTROL_SERVICES:
				return getControlServices();
			case SW_BrokeringPackage.DEVICE_BROKER__OPEN_SERVICES:
				return getOpenServices();
			case SW_BrokeringPackage.DEVICE_BROKER__READ_SERVICES:
				return getReadServices();
			case SW_BrokeringPackage.DEVICE_BROKER__WRITE_SERVICES:
				return getWriteServices();
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
			case SW_BrokeringPackage.DEVICE_BROKER__ACCESS_POLICY:
				setAccessPolicy((AccessPolicyKind)newValue);
				return;
			case SW_BrokeringPackage.DEVICE_BROKER__IS_BUFFERED:
				setIsBuffered((Boolean)newValue);
				return;
			case SW_BrokeringPackage.DEVICE_BROKER__DEVICES:
				getDevices().clear();
				getDevices().addAll((Collection<? extends TypedElement>)newValue);
				return;
			case SW_BrokeringPackage.DEVICE_BROKER__CLOSE_SERVICES:
				getCloseServices().clear();
				getCloseServices().addAll((Collection<? extends BehavioralFeature>)newValue);
				return;
			case SW_BrokeringPackage.DEVICE_BROKER__CONTROL_SERVICES:
				getControlServices().clear();
				getControlServices().addAll((Collection<? extends BehavioralFeature>)newValue);
				return;
			case SW_BrokeringPackage.DEVICE_BROKER__OPEN_SERVICES:
				getOpenServices().clear();
				getOpenServices().addAll((Collection<? extends BehavioralFeature>)newValue);
				return;
			case SW_BrokeringPackage.DEVICE_BROKER__READ_SERVICES:
				getReadServices().clear();
				getReadServices().addAll((Collection<? extends BehavioralFeature>)newValue);
				return;
			case SW_BrokeringPackage.DEVICE_BROKER__WRITE_SERVICES:
				getWriteServices().clear();
				getWriteServices().addAll((Collection<? extends BehavioralFeature>)newValue);
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
			case SW_BrokeringPackage.DEVICE_BROKER__ACCESS_POLICY:
				setAccessPolicy(ACCESS_POLICY_EDEFAULT);
				return;
			case SW_BrokeringPackage.DEVICE_BROKER__IS_BUFFERED:
				setIsBuffered(IS_BUFFERED_EDEFAULT);
				return;
			case SW_BrokeringPackage.DEVICE_BROKER__DEVICES:
				getDevices().clear();
				return;
			case SW_BrokeringPackage.DEVICE_BROKER__CLOSE_SERVICES:
				getCloseServices().clear();
				return;
			case SW_BrokeringPackage.DEVICE_BROKER__CONTROL_SERVICES:
				getControlServices().clear();
				return;
			case SW_BrokeringPackage.DEVICE_BROKER__OPEN_SERVICES:
				getOpenServices().clear();
				return;
			case SW_BrokeringPackage.DEVICE_BROKER__READ_SERVICES:
				getReadServices().clear();
				return;
			case SW_BrokeringPackage.DEVICE_BROKER__WRITE_SERVICES:
				getWriteServices().clear();
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
			case SW_BrokeringPackage.DEVICE_BROKER__ACCESS_POLICY:
				return accessPolicy != ACCESS_POLICY_EDEFAULT;
			case SW_BrokeringPackage.DEVICE_BROKER__IS_BUFFERED:
				return isBuffered != IS_BUFFERED_EDEFAULT;
			case SW_BrokeringPackage.DEVICE_BROKER__DEVICES:
				return devices != null && !devices.isEmpty();
			case SW_BrokeringPackage.DEVICE_BROKER__CLOSE_SERVICES:
				return closeServices != null && !closeServices.isEmpty();
			case SW_BrokeringPackage.DEVICE_BROKER__CONTROL_SERVICES:
				return controlServices != null && !controlServices.isEmpty();
			case SW_BrokeringPackage.DEVICE_BROKER__OPEN_SERVICES:
				return openServices != null && !openServices.isEmpty();
			case SW_BrokeringPackage.DEVICE_BROKER__READ_SERVICES:
				return readServices != null && !readServices.isEmpty();
			case SW_BrokeringPackage.DEVICE_BROKER__WRITE_SERVICES:
				return writeServices != null && !writeServices.isEmpty();
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
		result.append(" (accessPolicy: ");
		result.append(accessPolicy);
		result.append(", isBuffered: ");
		result.append(isBuffered);
		result.append(')');
		return result.toString();
	}

} //DeviceBrokerImpl
