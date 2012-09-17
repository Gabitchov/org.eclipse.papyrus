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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwCommunication.HwBus;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwCommunication.HwCommunicationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Hw Bus</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwCommunication.impl.HwBusImpl#getAdressWidth <em>Adress Width</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwCommunication.impl.HwBusImpl#getWordWidth <em>Word Width</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwCommunication.impl.HwBusImpl#getIsSynchronous <em>Is Synchronous</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwCommunication.impl.HwBusImpl#getIsSerial <em>Is Serial</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class HwBusImpl extends HwMediaImpl implements HwBus {
	/**
	 * The default value of the '{@link #getAdressWidth() <em>Adress Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdressWidth()
	 * @generated
	 * @ordered
	 */
	protected static final String ADRESS_WIDTH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAdressWidth() <em>Adress Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdressWidth()
	 * @generated
	 * @ordered
	 */
	protected String adressWidth = ADRESS_WIDTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getWordWidth() <em>Word Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWordWidth()
	 * @generated
	 * @ordered
	 */
	protected static final String WORD_WIDTH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getWordWidth() <em>Word Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWordWidth()
	 * @generated
	 * @ordered
	 */
	protected String wordWidth = WORD_WIDTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getIsSynchronous() <em>Is Synchronous</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsSynchronous()
	 * @generated
	 * @ordered
	 */
	protected static final String IS_SYNCHRONOUS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIsSynchronous() <em>Is Synchronous</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsSynchronous()
	 * @generated
	 * @ordered
	 */
	protected String isSynchronous = IS_SYNCHRONOUS_EDEFAULT;

	/**
	 * The default value of the '{@link #getIsSerial() <em>Is Serial</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsSerial()
	 * @generated
	 * @ordered
	 */
	protected static final String IS_SERIAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIsSerial() <em>Is Serial</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsSerial()
	 * @generated
	 * @ordered
	 */
	protected String isSerial = IS_SERIAL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HwBusImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HwCommunicationPackage.Literals.HW_BUS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAdressWidth() {
		return adressWidth;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAdressWidth(String newAdressWidth) {
		String oldAdressWidth = adressWidth;
		adressWidth = newAdressWidth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HwCommunicationPackage.HW_BUS__ADRESS_WIDTH, oldAdressWidth, adressWidth));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getWordWidth() {
		return wordWidth;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWordWidth(String newWordWidth) {
		String oldWordWidth = wordWidth;
		wordWidth = newWordWidth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HwCommunicationPackage.HW_BUS__WORD_WIDTH, oldWordWidth, wordWidth));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIsSynchronous() {
		return isSynchronous;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsSynchronous(String newIsSynchronous) {
		String oldIsSynchronous = isSynchronous;
		isSynchronous = newIsSynchronous;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HwCommunicationPackage.HW_BUS__IS_SYNCHRONOUS, oldIsSynchronous, isSynchronous));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIsSerial() {
		return isSerial;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsSerial(String newIsSerial) {
		String oldIsSerial = isSerial;
		isSerial = newIsSerial;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HwCommunicationPackage.HW_BUS__IS_SERIAL, oldIsSerial, isSerial));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case HwCommunicationPackage.HW_BUS__ADRESS_WIDTH:
				return getAdressWidth();
			case HwCommunicationPackage.HW_BUS__WORD_WIDTH:
				return getWordWidth();
			case HwCommunicationPackage.HW_BUS__IS_SYNCHRONOUS:
				return getIsSynchronous();
			case HwCommunicationPackage.HW_BUS__IS_SERIAL:
				return getIsSerial();
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
			case HwCommunicationPackage.HW_BUS__ADRESS_WIDTH:
				setAdressWidth((String)newValue);
				return;
			case HwCommunicationPackage.HW_BUS__WORD_WIDTH:
				setWordWidth((String)newValue);
				return;
			case HwCommunicationPackage.HW_BUS__IS_SYNCHRONOUS:
				setIsSynchronous((String)newValue);
				return;
			case HwCommunicationPackage.HW_BUS__IS_SERIAL:
				setIsSerial((String)newValue);
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
			case HwCommunicationPackage.HW_BUS__ADRESS_WIDTH:
				setAdressWidth(ADRESS_WIDTH_EDEFAULT);
				return;
			case HwCommunicationPackage.HW_BUS__WORD_WIDTH:
				setWordWidth(WORD_WIDTH_EDEFAULT);
				return;
			case HwCommunicationPackage.HW_BUS__IS_SYNCHRONOUS:
				setIsSynchronous(IS_SYNCHRONOUS_EDEFAULT);
				return;
			case HwCommunicationPackage.HW_BUS__IS_SERIAL:
				setIsSerial(IS_SERIAL_EDEFAULT);
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
			case HwCommunicationPackage.HW_BUS__ADRESS_WIDTH:
				return ADRESS_WIDTH_EDEFAULT == null ? adressWidth != null : !ADRESS_WIDTH_EDEFAULT.equals(adressWidth);
			case HwCommunicationPackage.HW_BUS__WORD_WIDTH:
				return WORD_WIDTH_EDEFAULT == null ? wordWidth != null : !WORD_WIDTH_EDEFAULT.equals(wordWidth);
			case HwCommunicationPackage.HW_BUS__IS_SYNCHRONOUS:
				return IS_SYNCHRONOUS_EDEFAULT == null ? isSynchronous != null : !IS_SYNCHRONOUS_EDEFAULT.equals(isSynchronous);
			case HwCommunicationPackage.HW_BUS__IS_SERIAL:
				return IS_SERIAL_EDEFAULT == null ? isSerial != null : !IS_SERIAL_EDEFAULT.equals(isSerial);
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
		result.append(" (adressWidth: ");
		result.append(adressWidth);
		result.append(", wordWidth: ");
		result.append(wordWidth);
		result.append(", isSynchronous: ");
		result.append(isSynchronous);
		result.append(", isSerial: ");
		result.append(isSerial);
		result.append(')');
		return result.toString();
	}

} //HwBusImpl
