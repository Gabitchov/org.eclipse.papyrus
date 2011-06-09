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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwGeneral.impl.HwResourceImpl;

import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwStorage.HwMemory.HwMemory;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwStorage.HwMemory.HwMemoryPackage;

import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.GRMPackage;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.StorageResource;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Hw Memory</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwStorage.HwMemory.impl.HwMemoryImpl#getElementSize <em>Element Size</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwStorage.HwMemory.impl.HwMemoryImpl#getMemorySize <em>Memory Size</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwStorage.HwMemory.impl.HwMemoryImpl#getAdressSize <em>Adress Size</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwStorage.HwMemory.impl.HwMemoryImpl#getTimings <em>Timings</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwStorage.HwMemory.impl.HwMemoryImpl#getThroughput <em>Throughput</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class HwMemoryImpl extends HwResourceImpl implements HwMemory {
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
	 * The default value of the '{@link #getMemorySize() <em>Memory Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMemorySize()
	 * @generated
	 * @ordered
	 */
	protected static final String MEMORY_SIZE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMemorySize() <em>Memory Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMemorySize()
	 * @generated
	 * @ordered
	 */
	protected String memorySize = MEMORY_SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #getAdressSize() <em>Adress Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdressSize()
	 * @generated
	 * @ordered
	 */
	protected static final String ADRESS_SIZE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAdressSize() <em>Adress Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdressSize()
	 * @generated
	 * @ordered
	 */
	protected String adressSize = ADRESS_SIZE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTimings() <em>Timings</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimings()
	 * @generated
	 * @ordered
	 */
	protected EList<String> timings;

	/**
	 * The default value of the '{@link #getThroughput() <em>Throughput</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThroughput()
	 * @generated
	 * @ordered
	 */
	protected static final String THROUGHPUT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getThroughput() <em>Throughput</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThroughput()
	 * @generated
	 * @ordered
	 */
	protected String throughput = THROUGHPUT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HwMemoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HwMemoryPackage.Literals.HW_MEMORY;
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
			eNotify(new ENotificationImpl(this, Notification.SET, HwMemoryPackage.HW_MEMORY__ELEMENT_SIZE, oldElementSize, elementSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMemorySize() {
		return memorySize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMemorySize(String newMemorySize) {
		String oldMemorySize = memorySize;
		memorySize = newMemorySize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HwMemoryPackage.HW_MEMORY__MEMORY_SIZE, oldMemorySize, memorySize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAdressSize() {
		return adressSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAdressSize(String newAdressSize) {
		String oldAdressSize = adressSize;
		adressSize = newAdressSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HwMemoryPackage.HW_MEMORY__ADRESS_SIZE, oldAdressSize, adressSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getTimings() {
		if (timings == null) {
			timings = new EDataTypeUniqueEList<String>(String.class, this, HwMemoryPackage.HW_MEMORY__TIMINGS);
		}
		return timings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getThroughput() {
		return throughput;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThroughput(String newThroughput) {
		String oldThroughput = throughput;
		throughput = newThroughput;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HwMemoryPackage.HW_MEMORY__THROUGHPUT, oldThroughput, throughput));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case HwMemoryPackage.HW_MEMORY__ELEMENT_SIZE:
				return getElementSize();
			case HwMemoryPackage.HW_MEMORY__MEMORY_SIZE:
				return getMemorySize();
			case HwMemoryPackage.HW_MEMORY__ADRESS_SIZE:
				return getAdressSize();
			case HwMemoryPackage.HW_MEMORY__TIMINGS:
				return getTimings();
			case HwMemoryPackage.HW_MEMORY__THROUGHPUT:
				return getThroughput();
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
			case HwMemoryPackage.HW_MEMORY__ELEMENT_SIZE:
				setElementSize((String)newValue);
				return;
			case HwMemoryPackage.HW_MEMORY__MEMORY_SIZE:
				setMemorySize((String)newValue);
				return;
			case HwMemoryPackage.HW_MEMORY__ADRESS_SIZE:
				setAdressSize((String)newValue);
				return;
			case HwMemoryPackage.HW_MEMORY__TIMINGS:
				getTimings().clear();
				getTimings().addAll((Collection<? extends String>)newValue);
				return;
			case HwMemoryPackage.HW_MEMORY__THROUGHPUT:
				setThroughput((String)newValue);
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
			case HwMemoryPackage.HW_MEMORY__ELEMENT_SIZE:
				setElementSize(ELEMENT_SIZE_EDEFAULT);
				return;
			case HwMemoryPackage.HW_MEMORY__MEMORY_SIZE:
				setMemorySize(MEMORY_SIZE_EDEFAULT);
				return;
			case HwMemoryPackage.HW_MEMORY__ADRESS_SIZE:
				setAdressSize(ADRESS_SIZE_EDEFAULT);
				return;
			case HwMemoryPackage.HW_MEMORY__TIMINGS:
				getTimings().clear();
				return;
			case HwMemoryPackage.HW_MEMORY__THROUGHPUT:
				setThroughput(THROUGHPUT_EDEFAULT);
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
			case HwMemoryPackage.HW_MEMORY__ELEMENT_SIZE:
				return ELEMENT_SIZE_EDEFAULT == null ? elementSize != null : !ELEMENT_SIZE_EDEFAULT.equals(elementSize);
			case HwMemoryPackage.HW_MEMORY__MEMORY_SIZE:
				return MEMORY_SIZE_EDEFAULT == null ? memorySize != null : !MEMORY_SIZE_EDEFAULT.equals(memorySize);
			case HwMemoryPackage.HW_MEMORY__ADRESS_SIZE:
				return ADRESS_SIZE_EDEFAULT == null ? adressSize != null : !ADRESS_SIZE_EDEFAULT.equals(adressSize);
			case HwMemoryPackage.HW_MEMORY__TIMINGS:
				return timings != null && !timings.isEmpty();
			case HwMemoryPackage.HW_MEMORY__THROUGHPUT:
				return THROUGHPUT_EDEFAULT == null ? throughput != null : !THROUGHPUT_EDEFAULT.equals(throughput);
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
				case HwMemoryPackage.HW_MEMORY__ELEMENT_SIZE: return GRMPackage.STORAGE_RESOURCE__ELEMENT_SIZE;
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
				case GRMPackage.STORAGE_RESOURCE__ELEMENT_SIZE: return HwMemoryPackage.HW_MEMORY__ELEMENT_SIZE;
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
		result.append(", memorySize: ");
		result.append(memorySize);
		result.append(", adressSize: ");
		result.append(adressSize);
		result.append(", timings: ");
		result.append(timings);
		result.append(", throughput: ");
		result.append(throughput);
		result.append(')');
		return result.toString();
	}

} //HwMemoryImpl
