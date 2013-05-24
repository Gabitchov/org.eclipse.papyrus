/**
 * Copyright (c) 2013 CEA LIST.
 * 
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.MasterObjectAxisProvider;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.NattableaxisproviderPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Master Object Axis Provider</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.impl.MasterObjectAxisProviderImpl#isDisconnectSlave <em>Disconnect Slave</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MasterObjectAxisProviderImpl extends AxisProviderImpl implements MasterObjectAxisProvider {
	/**
	 * The default value of the '{@link #isDisconnectSlave() <em>Disconnect Slave</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDisconnectSlave()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DISCONNECT_SLAVE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDisconnectSlave() <em>Disconnect Slave</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDisconnectSlave()
	 * @generated
	 * @ordered
	 */
	protected boolean disconnectSlave = DISCONNECT_SLAVE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MasterObjectAxisProviderImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NattableaxisproviderPackage.Literals.MASTER_OBJECT_AXIS_PROVIDER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDisconnectSlave() {
		return disconnectSlave;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDisconnectSlave(boolean newDisconnectSlave) {
		boolean oldDisconnectSlave = disconnectSlave;
		disconnectSlave = newDisconnectSlave;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NattableaxisproviderPackage.MASTER_OBJECT_AXIS_PROVIDER__DISCONNECT_SLAVE, oldDisconnectSlave, disconnectSlave));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case NattableaxisproviderPackage.MASTER_OBJECT_AXIS_PROVIDER__DISCONNECT_SLAVE:
				return isDisconnectSlave();
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
			case NattableaxisproviderPackage.MASTER_OBJECT_AXIS_PROVIDER__DISCONNECT_SLAVE:
				setDisconnectSlave((Boolean)newValue);
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
			case NattableaxisproviderPackage.MASTER_OBJECT_AXIS_PROVIDER__DISCONNECT_SLAVE:
				setDisconnectSlave(DISCONNECT_SLAVE_EDEFAULT);
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
			case NattableaxisproviderPackage.MASTER_OBJECT_AXIS_PROVIDER__DISCONNECT_SLAVE:
				return disconnectSlave != DISCONNECT_SLAVE_EDEFAULT;
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
		result.append(" (disconnectSlave: "); //$NON-NLS-1$
		result.append(disconnectSlave);
		result.append(')');
		return result.toString();
	}

} //MasterObjectAxisProviderImpl
