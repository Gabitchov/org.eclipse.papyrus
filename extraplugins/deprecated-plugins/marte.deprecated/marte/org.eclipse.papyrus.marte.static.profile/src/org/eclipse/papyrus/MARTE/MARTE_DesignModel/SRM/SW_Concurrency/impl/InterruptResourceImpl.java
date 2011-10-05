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
package org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.InterruptKind;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.InterruptResource;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SW_ConcurrencyPackage;

import org.eclipse.uml2.uml.BehavioralFeature;
import org.eclipse.uml2.uml.TypedElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Interrupt Resource</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.impl.InterruptResourceImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.impl.InterruptResourceImpl#isIsMaskable <em>Is Maskable</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.impl.InterruptResourceImpl#getVectorElements <em>Vector Elements</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.impl.InterruptResourceImpl#getMaskElements <em>Mask Elements</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.impl.InterruptResourceImpl#getRoutineConnectServices <em>Routine Connect Services</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.impl.InterruptResourceImpl#getRoutineDisconnectServices <em>Routine Disconnect Services</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InterruptResourceImpl extends SwConcurrentResourceImpl implements InterruptResource {
	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final InterruptKind KIND_EDEFAULT = InterruptKind.HARDWARE_INTERRUPTION;

	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected InterruptKind kind = KIND_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsMaskable() <em>Is Maskable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsMaskable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_MASKABLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsMaskable() <em>Is Maskable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsMaskable()
	 * @generated
	 * @ordered
	 */
	protected boolean isMaskable = IS_MASKABLE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getVectorElements() <em>Vector Elements</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVectorElements()
	 * @generated
	 * @ordered
	 */
	protected EList<TypedElement> vectorElements;

	/**
	 * The cached value of the '{@link #getMaskElements() <em>Mask Elements</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaskElements()
	 * @generated
	 * @ordered
	 */
	protected EList<TypedElement> maskElements;

	/**
	 * The cached value of the '{@link #getRoutineConnectServices() <em>Routine Connect Services</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoutineConnectServices()
	 * @generated
	 * @ordered
	 */
	protected EList<BehavioralFeature> routineConnectServices;

	/**
	 * The cached value of the '{@link #getRoutineDisconnectServices() <em>Routine Disconnect Services</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoutineDisconnectServices()
	 * @generated
	 * @ordered
	 */
	protected EList<BehavioralFeature> routineDisconnectServices;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InterruptResourceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SW_ConcurrencyPackage.Literals.INTERRUPT_RESOURCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InterruptKind getKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKind(InterruptKind newKind) {
		InterruptKind oldKind = kind;
		kind = newKind == null ? KIND_EDEFAULT : newKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SW_ConcurrencyPackage.INTERRUPT_RESOURCE__KIND, oldKind, kind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsMaskable() {
		return isMaskable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsMaskable(boolean newIsMaskable) {
		boolean oldIsMaskable = isMaskable;
		isMaskable = newIsMaskable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SW_ConcurrencyPackage.INTERRUPT_RESOURCE__IS_MASKABLE, oldIsMaskable, isMaskable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TypedElement> getVectorElements() {
		if (vectorElements == null) {
			vectorElements = new EObjectResolvingEList<TypedElement>(TypedElement.class, this, SW_ConcurrencyPackage.INTERRUPT_RESOURCE__VECTOR_ELEMENTS);
		}
		return vectorElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TypedElement> getMaskElements() {
		if (maskElements == null) {
			maskElements = new EObjectResolvingEList<TypedElement>(TypedElement.class, this, SW_ConcurrencyPackage.INTERRUPT_RESOURCE__MASK_ELEMENTS);
		}
		return maskElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BehavioralFeature> getRoutineConnectServices() {
		if (routineConnectServices == null) {
			routineConnectServices = new EObjectResolvingEList<BehavioralFeature>(BehavioralFeature.class, this, SW_ConcurrencyPackage.INTERRUPT_RESOURCE__ROUTINE_CONNECT_SERVICES);
		}
		return routineConnectServices;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BehavioralFeature> getRoutineDisconnectServices() {
		if (routineDisconnectServices == null) {
			routineDisconnectServices = new EObjectResolvingEList<BehavioralFeature>(BehavioralFeature.class, this, SW_ConcurrencyPackage.INTERRUPT_RESOURCE__ROUTINE_DISCONNECT_SERVICES);
		}
		return routineDisconnectServices;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SW_ConcurrencyPackage.INTERRUPT_RESOURCE__KIND:
				return getKind();
			case SW_ConcurrencyPackage.INTERRUPT_RESOURCE__IS_MASKABLE:
				return isIsMaskable();
			case SW_ConcurrencyPackage.INTERRUPT_RESOURCE__VECTOR_ELEMENTS:
				return getVectorElements();
			case SW_ConcurrencyPackage.INTERRUPT_RESOURCE__MASK_ELEMENTS:
				return getMaskElements();
			case SW_ConcurrencyPackage.INTERRUPT_RESOURCE__ROUTINE_CONNECT_SERVICES:
				return getRoutineConnectServices();
			case SW_ConcurrencyPackage.INTERRUPT_RESOURCE__ROUTINE_DISCONNECT_SERVICES:
				return getRoutineDisconnectServices();
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
			case SW_ConcurrencyPackage.INTERRUPT_RESOURCE__KIND:
				setKind((InterruptKind)newValue);
				return;
			case SW_ConcurrencyPackage.INTERRUPT_RESOURCE__IS_MASKABLE:
				setIsMaskable((Boolean)newValue);
				return;
			case SW_ConcurrencyPackage.INTERRUPT_RESOURCE__VECTOR_ELEMENTS:
				getVectorElements().clear();
				getVectorElements().addAll((Collection<? extends TypedElement>)newValue);
				return;
			case SW_ConcurrencyPackage.INTERRUPT_RESOURCE__MASK_ELEMENTS:
				getMaskElements().clear();
				getMaskElements().addAll((Collection<? extends TypedElement>)newValue);
				return;
			case SW_ConcurrencyPackage.INTERRUPT_RESOURCE__ROUTINE_CONNECT_SERVICES:
				getRoutineConnectServices().clear();
				getRoutineConnectServices().addAll((Collection<? extends BehavioralFeature>)newValue);
				return;
			case SW_ConcurrencyPackage.INTERRUPT_RESOURCE__ROUTINE_DISCONNECT_SERVICES:
				getRoutineDisconnectServices().clear();
				getRoutineDisconnectServices().addAll((Collection<? extends BehavioralFeature>)newValue);
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
			case SW_ConcurrencyPackage.INTERRUPT_RESOURCE__KIND:
				setKind(KIND_EDEFAULT);
				return;
			case SW_ConcurrencyPackage.INTERRUPT_RESOURCE__IS_MASKABLE:
				setIsMaskable(IS_MASKABLE_EDEFAULT);
				return;
			case SW_ConcurrencyPackage.INTERRUPT_RESOURCE__VECTOR_ELEMENTS:
				getVectorElements().clear();
				return;
			case SW_ConcurrencyPackage.INTERRUPT_RESOURCE__MASK_ELEMENTS:
				getMaskElements().clear();
				return;
			case SW_ConcurrencyPackage.INTERRUPT_RESOURCE__ROUTINE_CONNECT_SERVICES:
				getRoutineConnectServices().clear();
				return;
			case SW_ConcurrencyPackage.INTERRUPT_RESOURCE__ROUTINE_DISCONNECT_SERVICES:
				getRoutineDisconnectServices().clear();
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
			case SW_ConcurrencyPackage.INTERRUPT_RESOURCE__KIND:
				return kind != KIND_EDEFAULT;
			case SW_ConcurrencyPackage.INTERRUPT_RESOURCE__IS_MASKABLE:
				return isMaskable != IS_MASKABLE_EDEFAULT;
			case SW_ConcurrencyPackage.INTERRUPT_RESOURCE__VECTOR_ELEMENTS:
				return vectorElements != null && !vectorElements.isEmpty();
			case SW_ConcurrencyPackage.INTERRUPT_RESOURCE__MASK_ELEMENTS:
				return maskElements != null && !maskElements.isEmpty();
			case SW_ConcurrencyPackage.INTERRUPT_RESOURCE__ROUTINE_CONNECT_SERVICES:
				return routineConnectServices != null && !routineConnectServices.isEmpty();
			case SW_ConcurrencyPackage.INTERRUPT_RESOURCE__ROUTINE_DISCONNECT_SERVICES:
				return routineDisconnectServices != null && !routineDisconnectServices.isEmpty();
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
		result.append(" (kind: ");
		result.append(kind);
		result.append(", isMaskable: ");
		result.append(isMaskable);
		result.append(')');
		return result.toString();
	}

} //InterruptResourceImpl
