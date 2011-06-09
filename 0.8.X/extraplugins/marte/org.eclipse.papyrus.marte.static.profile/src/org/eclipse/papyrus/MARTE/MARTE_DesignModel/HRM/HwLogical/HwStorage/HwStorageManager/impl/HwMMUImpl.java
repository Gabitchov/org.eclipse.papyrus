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
package org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwStorage.HwStorageManager.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwStorage.HwMemory.HwCache;

import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwStorage.HwStorageManager.HwMMU;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwStorage.HwStorageManager.HwStorageManagerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Hw MMU</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwStorage.HwStorageManager.impl.HwMMUImpl#getVirtualAddrSpace <em>Virtual Addr Space</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwStorage.HwStorageManager.impl.HwMMUImpl#getPhysicalAddrSpace <em>Physical Addr Space</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwStorage.HwStorageManager.impl.HwMMUImpl#getMemoryProtection <em>Memory Protection</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwStorage.HwStorageManager.impl.HwMMUImpl#getNbEntries <em>Nb Entries</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwStorage.HwStorageManager.impl.HwMMUImpl#getOwnedTLBs <em>Owned TL Bs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class HwMMUImpl extends HwStorageManagerImpl implements HwMMU {
	/**
	 * The default value of the '{@link #getVirtualAddrSpace() <em>Virtual Addr Space</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVirtualAddrSpace()
	 * @generated
	 * @ordered
	 */
	protected static final String VIRTUAL_ADDR_SPACE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVirtualAddrSpace() <em>Virtual Addr Space</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVirtualAddrSpace()
	 * @generated
	 * @ordered
	 */
	protected String virtualAddrSpace = VIRTUAL_ADDR_SPACE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPhysicalAddrSpace() <em>Physical Addr Space</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPhysicalAddrSpace()
	 * @generated
	 * @ordered
	 */
	protected static final String PHYSICAL_ADDR_SPACE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPhysicalAddrSpace() <em>Physical Addr Space</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPhysicalAddrSpace()
	 * @generated
	 * @ordered
	 */
	protected String physicalAddrSpace = PHYSICAL_ADDR_SPACE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMemoryProtection() <em>Memory Protection</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMemoryProtection()
	 * @generated
	 * @ordered
	 */
	protected static final String MEMORY_PROTECTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMemoryProtection() <em>Memory Protection</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMemoryProtection()
	 * @generated
	 * @ordered
	 */
	protected String memoryProtection = MEMORY_PROTECTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getNbEntries() <em>Nb Entries</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNbEntries()
	 * @generated
	 * @ordered
	 */
	protected static final String NB_ENTRIES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOwnedTLBs() <em>Owned TL Bs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedTLBs()
	 * @generated
	 * @ordered
	 */
	protected EList<HwCache> ownedTLBs;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HwMMUImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HwStorageManagerPackage.Literals.HW_MMU;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVirtualAddrSpace() {
		return virtualAddrSpace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVirtualAddrSpace(String newVirtualAddrSpace) {
		String oldVirtualAddrSpace = virtualAddrSpace;
		virtualAddrSpace = newVirtualAddrSpace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HwStorageManagerPackage.HW_MMU__VIRTUAL_ADDR_SPACE, oldVirtualAddrSpace, virtualAddrSpace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPhysicalAddrSpace() {
		return physicalAddrSpace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPhysicalAddrSpace(String newPhysicalAddrSpace) {
		String oldPhysicalAddrSpace = physicalAddrSpace;
		physicalAddrSpace = newPhysicalAddrSpace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HwStorageManagerPackage.HW_MMU__PHYSICAL_ADDR_SPACE, oldPhysicalAddrSpace, physicalAddrSpace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMemoryProtection() {
		return memoryProtection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMemoryProtection(String newMemoryProtection) {
		String oldMemoryProtection = memoryProtection;
		memoryProtection = newMemoryProtection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HwStorageManagerPackage.HW_MMU__MEMORY_PROTECTION, oldMemoryProtection, memoryProtection));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getNbEntries() {
		// TODO: implement this method to return the 'Nb Entries' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		// throw new UnsupportedOperationException();
		
		return String.valueOf(getOwnedTLBs().size());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNbEntries(String newNbEntries) {
		// TODO: implement this method to set the 'Nb Entries' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<HwCache> getOwnedTLBs() {
		if (ownedTLBs == null) {
			ownedTLBs = new EObjectResolvingEList<HwCache>(HwCache.class, this, HwStorageManagerPackage.HW_MMU__OWNED_TL_BS);
		}
		return ownedTLBs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case HwStorageManagerPackage.HW_MMU__VIRTUAL_ADDR_SPACE:
				return getVirtualAddrSpace();
			case HwStorageManagerPackage.HW_MMU__PHYSICAL_ADDR_SPACE:
				return getPhysicalAddrSpace();
			case HwStorageManagerPackage.HW_MMU__MEMORY_PROTECTION:
				return getMemoryProtection();
			case HwStorageManagerPackage.HW_MMU__NB_ENTRIES:
				return getNbEntries();
			case HwStorageManagerPackage.HW_MMU__OWNED_TL_BS:
				return getOwnedTLBs();
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
			case HwStorageManagerPackage.HW_MMU__VIRTUAL_ADDR_SPACE:
				setVirtualAddrSpace((String)newValue);
				return;
			case HwStorageManagerPackage.HW_MMU__PHYSICAL_ADDR_SPACE:
				setPhysicalAddrSpace((String)newValue);
				return;
			case HwStorageManagerPackage.HW_MMU__MEMORY_PROTECTION:
				setMemoryProtection((String)newValue);
				return;
			case HwStorageManagerPackage.HW_MMU__NB_ENTRIES:
				setNbEntries((String)newValue);
				return;
			case HwStorageManagerPackage.HW_MMU__OWNED_TL_BS:
				getOwnedTLBs().clear();
				getOwnedTLBs().addAll((Collection<? extends HwCache>)newValue);
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
			case HwStorageManagerPackage.HW_MMU__VIRTUAL_ADDR_SPACE:
				setVirtualAddrSpace(VIRTUAL_ADDR_SPACE_EDEFAULT);
				return;
			case HwStorageManagerPackage.HW_MMU__PHYSICAL_ADDR_SPACE:
				setPhysicalAddrSpace(PHYSICAL_ADDR_SPACE_EDEFAULT);
				return;
			case HwStorageManagerPackage.HW_MMU__MEMORY_PROTECTION:
				setMemoryProtection(MEMORY_PROTECTION_EDEFAULT);
				return;
			case HwStorageManagerPackage.HW_MMU__NB_ENTRIES:
				setNbEntries(NB_ENTRIES_EDEFAULT);
				return;
			case HwStorageManagerPackage.HW_MMU__OWNED_TL_BS:
				getOwnedTLBs().clear();
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
			case HwStorageManagerPackage.HW_MMU__VIRTUAL_ADDR_SPACE:
				return VIRTUAL_ADDR_SPACE_EDEFAULT == null ? virtualAddrSpace != null : !VIRTUAL_ADDR_SPACE_EDEFAULT.equals(virtualAddrSpace);
			case HwStorageManagerPackage.HW_MMU__PHYSICAL_ADDR_SPACE:
				return PHYSICAL_ADDR_SPACE_EDEFAULT == null ? physicalAddrSpace != null : !PHYSICAL_ADDR_SPACE_EDEFAULT.equals(physicalAddrSpace);
			case HwStorageManagerPackage.HW_MMU__MEMORY_PROTECTION:
				return MEMORY_PROTECTION_EDEFAULT == null ? memoryProtection != null : !MEMORY_PROTECTION_EDEFAULT.equals(memoryProtection);
			case HwStorageManagerPackage.HW_MMU__NB_ENTRIES:
				return NB_ENTRIES_EDEFAULT == null ? getNbEntries() != null : !NB_ENTRIES_EDEFAULT.equals(getNbEntries());
			case HwStorageManagerPackage.HW_MMU__OWNED_TL_BS:
				return ownedTLBs != null && !ownedTLBs.isEmpty();
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
		result.append(" (virtualAddrSpace: ");
		result.append(virtualAddrSpace);
		result.append(", physicalAddrSpace: ");
		result.append(physicalAddrSpace);
		result.append(", memoryProtection: ");
		result.append(memoryProtection);
		result.append(')');
		return result.toString();
	}

} //HwMMUImpl
