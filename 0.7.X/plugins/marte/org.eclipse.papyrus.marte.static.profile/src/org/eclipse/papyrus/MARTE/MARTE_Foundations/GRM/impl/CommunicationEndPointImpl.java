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
package org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.CommunicationEndPoint;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.GRMPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Communication End Point</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.CommunicationEndPointImpl#getPacketSize <em>Packet Size</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CommunicationEndPointImpl extends ResourceImpl implements CommunicationEndPoint {
	/**
	 * The default value of the '{@link #getPacketSize() <em>Packet Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPacketSize()
	 * @generated
	 * @ordered
	 */
	protected static final String PACKET_SIZE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPacketSize() <em>Packet Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPacketSize()
	 * @generated
	 * @ordered
	 */
	protected String packetSize = PACKET_SIZE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CommunicationEndPointImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GRMPackage.Literals.COMMUNICATION_END_POINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPacketSize() {
		return packetSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPacketSize(String newPacketSize) {
		String oldPacketSize = packetSize;
		packetSize = newPacketSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GRMPackage.COMMUNICATION_END_POINT__PACKET_SIZE, oldPacketSize, packetSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GRMPackage.COMMUNICATION_END_POINT__PACKET_SIZE:
				return getPacketSize();
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
			case GRMPackage.COMMUNICATION_END_POINT__PACKET_SIZE:
				setPacketSize((String)newValue);
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
			case GRMPackage.COMMUNICATION_END_POINT__PACKET_SIZE:
				setPacketSize(PACKET_SIZE_EDEFAULT);
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
			case GRMPackage.COMMUNICATION_END_POINT__PACKET_SIZE:
				return PACKET_SIZE_EDEFAULT == null ? packetSize != null : !PACKET_SIZE_EDEFAULT.equals(packetSize);
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
		result.append(" (packetSize: ");
		result.append(packetSize);
		result.append(')');
		return result.toString();
	}

} //CommunicationEndPointImpl
