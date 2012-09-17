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
package org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwStorage.HwMemory.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwStorage.HwMemory.HwDrive;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwStorage.HwMemory.HwMemoryPackage;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwStorage.HwMemory.HwRAM;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Hw Drive</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwStorage.HwMemory.impl.HwDriveImpl#getSectorSize <em>Sector Size</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwStorage.HwMemory.impl.HwDriveImpl#getBuffer <em>Buffer</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class HwDriveImpl extends HwMemoryImpl implements HwDrive {
	/**
	 * The default value of the '{@link #getSectorSize() <em>Sector Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSectorSize()
	 * @generated
	 * @ordered
	 */
	protected static final String SECTOR_SIZE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSectorSize() <em>Sector Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSectorSize()
	 * @generated
	 * @ordered
	 */
	protected String sectorSize = SECTOR_SIZE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBuffer() <em>Buffer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBuffer()
	 * @generated
	 * @ordered
	 */
	protected HwRAM buffer;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HwDriveImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HwMemoryPackage.Literals.HW_DRIVE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSectorSize() {
		return sectorSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSectorSize(String newSectorSize) {
		String oldSectorSize = sectorSize;
		sectorSize = newSectorSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HwMemoryPackage.HW_DRIVE__SECTOR_SIZE, oldSectorSize, sectorSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HwRAM getBuffer() {
		if (buffer != null && buffer.eIsProxy()) {
			InternalEObject oldBuffer = (InternalEObject)buffer;
			buffer = (HwRAM)eResolveProxy(oldBuffer);
			if (buffer != oldBuffer) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, HwMemoryPackage.HW_DRIVE__BUFFER, oldBuffer, buffer));
			}
		}
		return buffer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HwRAM basicGetBuffer() {
		return buffer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBuffer(HwRAM newBuffer) {
		HwRAM oldBuffer = buffer;
		buffer = newBuffer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HwMemoryPackage.HW_DRIVE__BUFFER, oldBuffer, buffer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case HwMemoryPackage.HW_DRIVE__SECTOR_SIZE:
				return getSectorSize();
			case HwMemoryPackage.HW_DRIVE__BUFFER:
				if (resolve) return getBuffer();
				return basicGetBuffer();
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
			case HwMemoryPackage.HW_DRIVE__SECTOR_SIZE:
				setSectorSize((String)newValue);
				return;
			case HwMemoryPackage.HW_DRIVE__BUFFER:
				setBuffer((HwRAM)newValue);
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
			case HwMemoryPackage.HW_DRIVE__SECTOR_SIZE:
				setSectorSize(SECTOR_SIZE_EDEFAULT);
				return;
			case HwMemoryPackage.HW_DRIVE__BUFFER:
				setBuffer((HwRAM)null);
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
			case HwMemoryPackage.HW_DRIVE__SECTOR_SIZE:
				return SECTOR_SIZE_EDEFAULT == null ? sectorSize != null : !SECTOR_SIZE_EDEFAULT.equals(sectorSize);
			case HwMemoryPackage.HW_DRIVE__BUFFER:
				return buffer != null;
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
		result.append(" (sectorSize: ");
		result.append(sectorSize);
		result.append(')');
		return result.toString();
	}

} //HwDriveImpl
