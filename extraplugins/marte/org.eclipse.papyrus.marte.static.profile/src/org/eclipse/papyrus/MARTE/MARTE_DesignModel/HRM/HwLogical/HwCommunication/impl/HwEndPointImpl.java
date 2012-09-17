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
package org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwCommunication.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwCommunication.HwCommunicationPackage;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwCommunication.HwEndPoint;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwCommunication.HwMedia;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.CommunicationEndPoint;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.GRMPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Hw End Point</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwCommunication.impl.HwEndPointImpl#getPacketSize <em>Packet Size</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwCommunication.impl.HwEndPointImpl#getConnectedTo <em>Connected To</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class HwEndPointImpl extends HwCommunicationResourceImpl implements HwEndPoint {
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
	 * The cached value of the '{@link #getConnectedTo() <em>Connected To</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectedTo()
	 * @generated
	 * @ordered
	 */
	protected EList<HwMedia> connectedTo;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HwEndPointImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HwCommunicationPackage.Literals.HW_END_POINT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, HwCommunicationPackage.HW_END_POINT__PACKET_SIZE, oldPacketSize, packetSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<HwMedia> getConnectedTo() {
		if (connectedTo == null) {
			connectedTo = new EObjectResolvingEList<HwMedia>(HwMedia.class, this, HwCommunicationPackage.HW_END_POINT__CONNECTED_TO);
		}
		return connectedTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case HwCommunicationPackage.HW_END_POINT__PACKET_SIZE:
				return getPacketSize();
			case HwCommunicationPackage.HW_END_POINT__CONNECTED_TO:
				return getConnectedTo();
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
			case HwCommunicationPackage.HW_END_POINT__PACKET_SIZE:
				setPacketSize((String)newValue);
				return;
			case HwCommunicationPackage.HW_END_POINT__CONNECTED_TO:
				getConnectedTo().clear();
				getConnectedTo().addAll((Collection<? extends HwMedia>)newValue);
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
			case HwCommunicationPackage.HW_END_POINT__PACKET_SIZE:
				setPacketSize(PACKET_SIZE_EDEFAULT);
				return;
			case HwCommunicationPackage.HW_END_POINT__CONNECTED_TO:
				getConnectedTo().clear();
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
			case HwCommunicationPackage.HW_END_POINT__PACKET_SIZE:
				return PACKET_SIZE_EDEFAULT == null ? packetSize != null : !PACKET_SIZE_EDEFAULT.equals(packetSize);
			case HwCommunicationPackage.HW_END_POINT__CONNECTED_TO:
				return connectedTo != null && !connectedTo.isEmpty();
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
		if (baseClass == CommunicationEndPoint.class) {
			switch (derivedFeatureID) {
				case HwCommunicationPackage.HW_END_POINT__PACKET_SIZE: return GRMPackage.COMMUNICATION_END_POINT__PACKET_SIZE;
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
		if (baseClass == CommunicationEndPoint.class) {
			switch (baseFeatureID) {
				case GRMPackage.COMMUNICATION_END_POINT__PACKET_SIZE: return HwCommunicationPackage.HW_END_POINT__PACKET_SIZE;
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
		result.append(" (packetSize: ");
		result.append(packetSize);
		result.append(')');
		return result.toString();
	}

} //HwEndPointImpl
