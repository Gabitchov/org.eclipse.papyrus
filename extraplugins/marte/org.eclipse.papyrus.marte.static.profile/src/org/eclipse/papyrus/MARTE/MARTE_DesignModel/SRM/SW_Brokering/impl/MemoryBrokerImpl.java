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
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.MemoryBroker;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.SW_BrokeringPackage;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_ResourceCore.impl.SwResourceImpl;
import org.eclipse.uml2.uml.BehavioralFeature;
import org.eclipse.uml2.uml.TypedElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Memory Broker</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.impl.MemoryBrokerImpl#getAccessPolicy <em>Access Policy</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.impl.MemoryBrokerImpl#getMemories <em>Memories</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.impl.MemoryBrokerImpl#getMemoryBlockAdressElements <em>Memory Block Adress Elements</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.impl.MemoryBrokerImpl#getMemoryBlockSizeElements <em>Memory Block Size Elements</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.impl.MemoryBrokerImpl#getLockServices <em>Lock Services</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.impl.MemoryBrokerImpl#getUnlockServices <em>Unlock Services</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.impl.MemoryBrokerImpl#getMapServices <em>Map Services</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.impl.MemoryBrokerImpl#getUnMapServices <em>Un Map Services</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MemoryBrokerImpl extends SwResourceImpl implements MemoryBroker {
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
	 * The cached value of the '{@link #getMemories() <em>Memories</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMemories()
	 * @generated
	 * @ordered
	 */
	protected EList<TypedElement> memories;

	/**
	 * The cached value of the '{@link #getMemoryBlockAdressElements() <em>Memory Block Adress Elements</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMemoryBlockAdressElements()
	 * @generated
	 * @ordered
	 */
	protected EList<TypedElement> memoryBlockAdressElements;

	/**
	 * The cached value of the '{@link #getMemoryBlockSizeElements() <em>Memory Block Size Elements</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMemoryBlockSizeElements()
	 * @generated
	 * @ordered
	 */
	protected EList<TypedElement> memoryBlockSizeElements;

	/**
	 * The cached value of the '{@link #getLockServices() <em>Lock Services</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLockServices()
	 * @generated
	 * @ordered
	 */
	protected EList<BehavioralFeature> lockServices;

	/**
	 * The cached value of the '{@link #getUnlockServices() <em>Unlock Services</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnlockServices()
	 * @generated
	 * @ordered
	 */
	protected EList<BehavioralFeature> unlockServices;

	/**
	 * The cached value of the '{@link #getMapServices() <em>Map Services</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMapServices()
	 * @generated
	 * @ordered
	 */
	protected EList<BehavioralFeature> mapServices;

	/**
	 * The cached value of the '{@link #getUnMapServices() <em>Un Map Services</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnMapServices()
	 * @generated
	 * @ordered
	 */
	protected EList<BehavioralFeature> unMapServices;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MemoryBrokerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SW_BrokeringPackage.Literals.MEMORY_BROKER;
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
			eNotify(new ENotificationImpl(this, Notification.SET, SW_BrokeringPackage.MEMORY_BROKER__ACCESS_POLICY, oldAccessPolicy, accessPolicy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TypedElement> getMemories() {
		if (memories == null) {
			memories = new EObjectResolvingEList<TypedElement>(TypedElement.class, this, SW_BrokeringPackage.MEMORY_BROKER__MEMORIES);
		}
		return memories;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TypedElement> getMemoryBlockAdressElements() {
		if (memoryBlockAdressElements == null) {
			memoryBlockAdressElements = new EObjectResolvingEList<TypedElement>(TypedElement.class, this, SW_BrokeringPackage.MEMORY_BROKER__MEMORY_BLOCK_ADRESS_ELEMENTS);
		}
		return memoryBlockAdressElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TypedElement> getMemoryBlockSizeElements() {
		if (memoryBlockSizeElements == null) {
			memoryBlockSizeElements = new EObjectResolvingEList<TypedElement>(TypedElement.class, this, SW_BrokeringPackage.MEMORY_BROKER__MEMORY_BLOCK_SIZE_ELEMENTS);
		}
		return memoryBlockSizeElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BehavioralFeature> getLockServices() {
		if (lockServices == null) {
			lockServices = new EObjectResolvingEList<BehavioralFeature>(BehavioralFeature.class, this, SW_BrokeringPackage.MEMORY_BROKER__LOCK_SERVICES);
		}
		return lockServices;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BehavioralFeature> getUnlockServices() {
		if (unlockServices == null) {
			unlockServices = new EObjectResolvingEList<BehavioralFeature>(BehavioralFeature.class, this, SW_BrokeringPackage.MEMORY_BROKER__UNLOCK_SERVICES);
		}
		return unlockServices;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BehavioralFeature> getMapServices() {
		if (mapServices == null) {
			mapServices = new EObjectResolvingEList<BehavioralFeature>(BehavioralFeature.class, this, SW_BrokeringPackage.MEMORY_BROKER__MAP_SERVICES);
		}
		return mapServices;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BehavioralFeature> getUnMapServices() {
		if (unMapServices == null) {
			unMapServices = new EObjectResolvingEList<BehavioralFeature>(BehavioralFeature.class, this, SW_BrokeringPackage.MEMORY_BROKER__UN_MAP_SERVICES);
		}
		return unMapServices;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SW_BrokeringPackage.MEMORY_BROKER__ACCESS_POLICY:
				return getAccessPolicy();
			case SW_BrokeringPackage.MEMORY_BROKER__MEMORIES:
				return getMemories();
			case SW_BrokeringPackage.MEMORY_BROKER__MEMORY_BLOCK_ADRESS_ELEMENTS:
				return getMemoryBlockAdressElements();
			case SW_BrokeringPackage.MEMORY_BROKER__MEMORY_BLOCK_SIZE_ELEMENTS:
				return getMemoryBlockSizeElements();
			case SW_BrokeringPackage.MEMORY_BROKER__LOCK_SERVICES:
				return getLockServices();
			case SW_BrokeringPackage.MEMORY_BROKER__UNLOCK_SERVICES:
				return getUnlockServices();
			case SW_BrokeringPackage.MEMORY_BROKER__MAP_SERVICES:
				return getMapServices();
			case SW_BrokeringPackage.MEMORY_BROKER__UN_MAP_SERVICES:
				return getUnMapServices();
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
			case SW_BrokeringPackage.MEMORY_BROKER__ACCESS_POLICY:
				setAccessPolicy((AccessPolicyKind)newValue);
				return;
			case SW_BrokeringPackage.MEMORY_BROKER__MEMORIES:
				getMemories().clear();
				getMemories().addAll((Collection<? extends TypedElement>)newValue);
				return;
			case SW_BrokeringPackage.MEMORY_BROKER__MEMORY_BLOCK_ADRESS_ELEMENTS:
				getMemoryBlockAdressElements().clear();
				getMemoryBlockAdressElements().addAll((Collection<? extends TypedElement>)newValue);
				return;
			case SW_BrokeringPackage.MEMORY_BROKER__MEMORY_BLOCK_SIZE_ELEMENTS:
				getMemoryBlockSizeElements().clear();
				getMemoryBlockSizeElements().addAll((Collection<? extends TypedElement>)newValue);
				return;
			case SW_BrokeringPackage.MEMORY_BROKER__LOCK_SERVICES:
				getLockServices().clear();
				getLockServices().addAll((Collection<? extends BehavioralFeature>)newValue);
				return;
			case SW_BrokeringPackage.MEMORY_BROKER__UNLOCK_SERVICES:
				getUnlockServices().clear();
				getUnlockServices().addAll((Collection<? extends BehavioralFeature>)newValue);
				return;
			case SW_BrokeringPackage.MEMORY_BROKER__MAP_SERVICES:
				getMapServices().clear();
				getMapServices().addAll((Collection<? extends BehavioralFeature>)newValue);
				return;
			case SW_BrokeringPackage.MEMORY_BROKER__UN_MAP_SERVICES:
				getUnMapServices().clear();
				getUnMapServices().addAll((Collection<? extends BehavioralFeature>)newValue);
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
			case SW_BrokeringPackage.MEMORY_BROKER__ACCESS_POLICY:
				setAccessPolicy(ACCESS_POLICY_EDEFAULT);
				return;
			case SW_BrokeringPackage.MEMORY_BROKER__MEMORIES:
				getMemories().clear();
				return;
			case SW_BrokeringPackage.MEMORY_BROKER__MEMORY_BLOCK_ADRESS_ELEMENTS:
				getMemoryBlockAdressElements().clear();
				return;
			case SW_BrokeringPackage.MEMORY_BROKER__MEMORY_BLOCK_SIZE_ELEMENTS:
				getMemoryBlockSizeElements().clear();
				return;
			case SW_BrokeringPackage.MEMORY_BROKER__LOCK_SERVICES:
				getLockServices().clear();
				return;
			case SW_BrokeringPackage.MEMORY_BROKER__UNLOCK_SERVICES:
				getUnlockServices().clear();
				return;
			case SW_BrokeringPackage.MEMORY_BROKER__MAP_SERVICES:
				getMapServices().clear();
				return;
			case SW_BrokeringPackage.MEMORY_BROKER__UN_MAP_SERVICES:
				getUnMapServices().clear();
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
			case SW_BrokeringPackage.MEMORY_BROKER__ACCESS_POLICY:
				return accessPolicy != ACCESS_POLICY_EDEFAULT;
			case SW_BrokeringPackage.MEMORY_BROKER__MEMORIES:
				return memories != null && !memories.isEmpty();
			case SW_BrokeringPackage.MEMORY_BROKER__MEMORY_BLOCK_ADRESS_ELEMENTS:
				return memoryBlockAdressElements != null && !memoryBlockAdressElements.isEmpty();
			case SW_BrokeringPackage.MEMORY_BROKER__MEMORY_BLOCK_SIZE_ELEMENTS:
				return memoryBlockSizeElements != null && !memoryBlockSizeElements.isEmpty();
			case SW_BrokeringPackage.MEMORY_BROKER__LOCK_SERVICES:
				return lockServices != null && !lockServices.isEmpty();
			case SW_BrokeringPackage.MEMORY_BROKER__UNLOCK_SERVICES:
				return unlockServices != null && !unlockServices.isEmpty();
			case SW_BrokeringPackage.MEMORY_BROKER__MAP_SERVICES:
				return mapServices != null && !mapServices.isEmpty();
			case SW_BrokeringPackage.MEMORY_BROKER__UN_MAP_SERVICES:
				return unMapServices != null && !unMapServices.isEmpty();
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
		result.append(')');
		return result.toString();
	}

} //MemoryBrokerImpl
