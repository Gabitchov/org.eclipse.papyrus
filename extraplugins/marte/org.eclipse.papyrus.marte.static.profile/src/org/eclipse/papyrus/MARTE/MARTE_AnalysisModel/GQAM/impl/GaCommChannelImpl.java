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
package org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GQAMPackage;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaCommChannel;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.SchedulableResourceImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ga Comm Channel</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaCommChannelImpl#getPacketSize <em>Packet Size</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaCommChannelImpl#getUtilization <em>Utilization</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GaCommChannelImpl extends SchedulableResourceImpl implements GaCommChannel {
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
	 * The default value of the '{@link #getUtilization() <em>Utilization</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUtilization()
	 * @generated
	 * @ordered
	 */
	protected static final String UTILIZATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUtilization() <em>Utilization</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUtilization()
	 * @generated
	 * @ordered
	 */
	protected String utilization = UTILIZATION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GaCommChannelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GQAMPackage.Literals.GA_COMM_CHANNEL;
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
			eNotify(new ENotificationImpl(this, Notification.SET, GQAMPackage.GA_COMM_CHANNEL__PACKET_SIZE, oldPacketSize, packetSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUtilization() {
		return utilization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUtilization(String newUtilization) {
		String oldUtilization = utilization;
		utilization = newUtilization;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GQAMPackage.GA_COMM_CHANNEL__UTILIZATION, oldUtilization, utilization));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GQAMPackage.GA_COMM_CHANNEL__PACKET_SIZE:
				return getPacketSize();
			case GQAMPackage.GA_COMM_CHANNEL__UTILIZATION:
				return getUtilization();
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
			case GQAMPackage.GA_COMM_CHANNEL__PACKET_SIZE:
				setPacketSize((String)newValue);
				return;
			case GQAMPackage.GA_COMM_CHANNEL__UTILIZATION:
				setUtilization((String)newValue);
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
			case GQAMPackage.GA_COMM_CHANNEL__PACKET_SIZE:
				setPacketSize(PACKET_SIZE_EDEFAULT);
				return;
			case GQAMPackage.GA_COMM_CHANNEL__UTILIZATION:
				setUtilization(UTILIZATION_EDEFAULT);
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
			case GQAMPackage.GA_COMM_CHANNEL__PACKET_SIZE:
				return PACKET_SIZE_EDEFAULT == null ? packetSize != null : !PACKET_SIZE_EDEFAULT.equals(packetSize);
			case GQAMPackage.GA_COMM_CHANNEL__UTILIZATION:
				return UTILIZATION_EDEFAULT == null ? utilization != null : !UTILIZATION_EDEFAULT.equals(utilization);
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
		result.append(", utilization: ");
		result.append(utilization);
		result.append(')');
		return result.toString();
	}

} //GaCommChannelImpl
