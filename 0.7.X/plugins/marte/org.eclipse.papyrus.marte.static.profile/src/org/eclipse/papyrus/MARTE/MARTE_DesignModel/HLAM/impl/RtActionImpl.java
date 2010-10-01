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
package org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.HLAMPackage;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtAction;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.SynchronizationKind;

import org.eclipse.uml2.uml.BehavioralFeature;
import org.eclipse.uml2.uml.InvocationAction;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rt Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.RtActionImpl#isIsAtomic <em>Is Atomic</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.RtActionImpl#getSynchKind <em>Synch Kind</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.RtActionImpl#getMsgSize <em>Msg Size</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.RtActionImpl#getBase_BehavioralFeature <em>Base Behavioral Feature</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.RtActionImpl#getBase_InvocationAction <em>Base Invocation Action</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RtActionImpl extends EObjectImpl implements RtAction {
	/**
	 * The default value of the '{@link #isIsAtomic() <em>Is Atomic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsAtomic()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ATOMIC_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsAtomic() <em>Is Atomic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsAtomic()
	 * @generated
	 * @ordered
	 */
	protected boolean isAtomic = IS_ATOMIC_EDEFAULT;

	/**
	 * The default value of the '{@link #getSynchKind() <em>Synch Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSynchKind()
	 * @generated
	 * @ordered
	 */
	protected static final SynchronizationKind SYNCH_KIND_EDEFAULT = SynchronizationKind.SYNCHRONOUS;

	/**
	 * The cached value of the '{@link #getSynchKind() <em>Synch Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSynchKind()
	 * @generated
	 * @ordered
	 */
	protected SynchronizationKind synchKind = SYNCH_KIND_EDEFAULT;

	/**
	 * The default value of the '{@link #getMsgSize() <em>Msg Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMsgSize()
	 * @generated
	 * @ordered
	 */
	protected static final String MSG_SIZE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMsgSize() <em>Msg Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMsgSize()
	 * @generated
	 * @ordered
	 */
	protected String msgSize = MSG_SIZE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBase_BehavioralFeature() <em>Base Behavioral Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_BehavioralFeature()
	 * @generated
	 * @ordered
	 */
	protected BehavioralFeature base_BehavioralFeature;

	/**
	 * The cached value of the '{@link #getBase_InvocationAction() <em>Base Invocation Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_InvocationAction()
	 * @generated
	 * @ordered
	 */
	protected InvocationAction base_InvocationAction;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RtActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HLAMPackage.Literals.RT_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsAtomic() {
		return isAtomic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsAtomic(boolean newIsAtomic) {
		boolean oldIsAtomic = isAtomic;
		isAtomic = newIsAtomic;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HLAMPackage.RT_ACTION__IS_ATOMIC, oldIsAtomic, isAtomic));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SynchronizationKind getSynchKind() {
		return synchKind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSynchKind(SynchronizationKind newSynchKind) {
		SynchronizationKind oldSynchKind = synchKind;
		synchKind = newSynchKind == null ? SYNCH_KIND_EDEFAULT : newSynchKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HLAMPackage.RT_ACTION__SYNCH_KIND, oldSynchKind, synchKind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMsgSize() {
		return msgSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMsgSize(String newMsgSize) {
		String oldMsgSize = msgSize;
		msgSize = newMsgSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HLAMPackage.RT_ACTION__MSG_SIZE, oldMsgSize, msgSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BehavioralFeature getBase_BehavioralFeature() {
		if (base_BehavioralFeature != null && base_BehavioralFeature.eIsProxy()) {
			InternalEObject oldBase_BehavioralFeature = (InternalEObject)base_BehavioralFeature;
			base_BehavioralFeature = (BehavioralFeature)eResolveProxy(oldBase_BehavioralFeature);
			if (base_BehavioralFeature != oldBase_BehavioralFeature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, HLAMPackage.RT_ACTION__BASE_BEHAVIORAL_FEATURE, oldBase_BehavioralFeature, base_BehavioralFeature));
			}
		}
		return base_BehavioralFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BehavioralFeature basicGetBase_BehavioralFeature() {
		return base_BehavioralFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_BehavioralFeature(BehavioralFeature newBase_BehavioralFeature) {
		BehavioralFeature oldBase_BehavioralFeature = base_BehavioralFeature;
		base_BehavioralFeature = newBase_BehavioralFeature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HLAMPackage.RT_ACTION__BASE_BEHAVIORAL_FEATURE, oldBase_BehavioralFeature, base_BehavioralFeature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InvocationAction getBase_InvocationAction() {
		if (base_InvocationAction != null && base_InvocationAction.eIsProxy()) {
			InternalEObject oldBase_InvocationAction = (InternalEObject)base_InvocationAction;
			base_InvocationAction = (InvocationAction)eResolveProxy(oldBase_InvocationAction);
			if (base_InvocationAction != oldBase_InvocationAction) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, HLAMPackage.RT_ACTION__BASE_INVOCATION_ACTION, oldBase_InvocationAction, base_InvocationAction));
			}
		}
		return base_InvocationAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InvocationAction basicGetBase_InvocationAction() {
		return base_InvocationAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_InvocationAction(InvocationAction newBase_InvocationAction) {
		InvocationAction oldBase_InvocationAction = base_InvocationAction;
		base_InvocationAction = newBase_InvocationAction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HLAMPackage.RT_ACTION__BASE_INVOCATION_ACTION, oldBase_InvocationAction, base_InvocationAction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case HLAMPackage.RT_ACTION__IS_ATOMIC:
				return isIsAtomic();
			case HLAMPackage.RT_ACTION__SYNCH_KIND:
				return getSynchKind();
			case HLAMPackage.RT_ACTION__MSG_SIZE:
				return getMsgSize();
			case HLAMPackage.RT_ACTION__BASE_BEHAVIORAL_FEATURE:
				if (resolve) return getBase_BehavioralFeature();
				return basicGetBase_BehavioralFeature();
			case HLAMPackage.RT_ACTION__BASE_INVOCATION_ACTION:
				if (resolve) return getBase_InvocationAction();
				return basicGetBase_InvocationAction();
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
			case HLAMPackage.RT_ACTION__IS_ATOMIC:
				setIsAtomic((Boolean)newValue);
				return;
			case HLAMPackage.RT_ACTION__SYNCH_KIND:
				setSynchKind((SynchronizationKind)newValue);
				return;
			case HLAMPackage.RT_ACTION__MSG_SIZE:
				setMsgSize((String)newValue);
				return;
			case HLAMPackage.RT_ACTION__BASE_BEHAVIORAL_FEATURE:
				setBase_BehavioralFeature((BehavioralFeature)newValue);
				return;
			case HLAMPackage.RT_ACTION__BASE_INVOCATION_ACTION:
				setBase_InvocationAction((InvocationAction)newValue);
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
			case HLAMPackage.RT_ACTION__IS_ATOMIC:
				setIsAtomic(IS_ATOMIC_EDEFAULT);
				return;
			case HLAMPackage.RT_ACTION__SYNCH_KIND:
				setSynchKind(SYNCH_KIND_EDEFAULT);
				return;
			case HLAMPackage.RT_ACTION__MSG_SIZE:
				setMsgSize(MSG_SIZE_EDEFAULT);
				return;
			case HLAMPackage.RT_ACTION__BASE_BEHAVIORAL_FEATURE:
				setBase_BehavioralFeature((BehavioralFeature)null);
				return;
			case HLAMPackage.RT_ACTION__BASE_INVOCATION_ACTION:
				setBase_InvocationAction((InvocationAction)null);
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
			case HLAMPackage.RT_ACTION__IS_ATOMIC:
				return isAtomic != IS_ATOMIC_EDEFAULT;
			case HLAMPackage.RT_ACTION__SYNCH_KIND:
				return synchKind != SYNCH_KIND_EDEFAULT;
			case HLAMPackage.RT_ACTION__MSG_SIZE:
				return MSG_SIZE_EDEFAULT == null ? msgSize != null : !MSG_SIZE_EDEFAULT.equals(msgSize);
			case HLAMPackage.RT_ACTION__BASE_BEHAVIORAL_FEATURE:
				return base_BehavioralFeature != null;
			case HLAMPackage.RT_ACTION__BASE_INVOCATION_ACTION:
				return base_InvocationAction != null;
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
		result.append(" (isAtomic: ");
		result.append(isAtomic);
		result.append(", synchKind: ");
		result.append(synchKind);
		result.append(", msgSize: ");
		result.append(msgSize);
		result.append(')');
		return result.toString();
	}

} //RtActionImpl
