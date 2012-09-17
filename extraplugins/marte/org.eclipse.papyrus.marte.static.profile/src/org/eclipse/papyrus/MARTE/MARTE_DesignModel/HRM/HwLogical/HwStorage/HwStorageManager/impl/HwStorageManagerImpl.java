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
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwGeneral.impl.HwResourceImpl;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwStorage.HwMemory.HwMemory;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwStorage.HwStorageManager.HwStorageManager;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwStorage.HwStorageManager.HwStorageManagerPackage;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.GRMPackage;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.StorageResource;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Hw Storage Manager</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwStorage.HwStorageManager.impl.HwStorageManagerImpl#getElementSize <em>Element Size</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwStorage.HwStorageManager.impl.HwStorageManagerImpl#getManagedMemories <em>Managed Memories</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class HwStorageManagerImpl extends HwResourceImpl implements HwStorageManager {
	/**
	 * The default value of the '{@link #getElementSize() <em>Element Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElementSize()
	 * @generated
	 * @ordered
	 */
	protected static final String ELEMENT_SIZE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getElementSize() <em>Element Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElementSize()
	 * @generated
	 * @ordered
	 */
	protected String elementSize = ELEMENT_SIZE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getManagedMemories() <em>Managed Memories</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getManagedMemories()
	 * @generated
	 * @ordered
	 */
	protected EList<HwMemory> managedMemories;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HwStorageManagerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HwStorageManagerPackage.Literals.HW_STORAGE_MANAGER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getElementSize() {
		return elementSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElementSize(String newElementSize) {
		String oldElementSize = elementSize;
		elementSize = newElementSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HwStorageManagerPackage.HW_STORAGE_MANAGER__ELEMENT_SIZE, oldElementSize, elementSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<HwMemory> getManagedMemories() {
		if (managedMemories == null) {
			managedMemories = new EObjectResolvingEList<HwMemory>(HwMemory.class, this, HwStorageManagerPackage.HW_STORAGE_MANAGER__MANAGED_MEMORIES);
		}
		return managedMemories;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case HwStorageManagerPackage.HW_STORAGE_MANAGER__ELEMENT_SIZE:
				return getElementSize();
			case HwStorageManagerPackage.HW_STORAGE_MANAGER__MANAGED_MEMORIES:
				return getManagedMemories();
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
			case HwStorageManagerPackage.HW_STORAGE_MANAGER__ELEMENT_SIZE:
				setElementSize((String)newValue);
				return;
			case HwStorageManagerPackage.HW_STORAGE_MANAGER__MANAGED_MEMORIES:
				getManagedMemories().clear();
				getManagedMemories().addAll((Collection<? extends HwMemory>)newValue);
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
			case HwStorageManagerPackage.HW_STORAGE_MANAGER__ELEMENT_SIZE:
				setElementSize(ELEMENT_SIZE_EDEFAULT);
				return;
			case HwStorageManagerPackage.HW_STORAGE_MANAGER__MANAGED_MEMORIES:
				getManagedMemories().clear();
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
			case HwStorageManagerPackage.HW_STORAGE_MANAGER__ELEMENT_SIZE:
				return ELEMENT_SIZE_EDEFAULT == null ? elementSize != null : !ELEMENT_SIZE_EDEFAULT.equals(elementSize);
			case HwStorageManagerPackage.HW_STORAGE_MANAGER__MANAGED_MEMORIES:
				return managedMemories != null && !managedMemories.isEmpty();
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
		if (baseClass == StorageResource.class) {
			switch (derivedFeatureID) {
				case HwStorageManagerPackage.HW_STORAGE_MANAGER__ELEMENT_SIZE: return GRMPackage.STORAGE_RESOURCE__ELEMENT_SIZE;
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
		if (baseClass == StorageResource.class) {
			switch (baseFeatureID) {
				case GRMPackage.STORAGE_RESOURCE__ELEMENT_SIZE: return HwStorageManagerPackage.HW_STORAGE_MANAGER__ELEMENT_SIZE;
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
		result.append(" (elementSize: ");
		result.append(elementSize);
		result.append(')');
		return result.toString();
	}

} //HwStorageManagerImpl
