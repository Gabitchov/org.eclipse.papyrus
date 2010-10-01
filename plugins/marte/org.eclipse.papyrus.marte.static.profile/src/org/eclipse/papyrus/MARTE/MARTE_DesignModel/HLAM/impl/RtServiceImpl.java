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

import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.ConcurrencyKind;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.ExecutionKind;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.HLAMPackage;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtService;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.SynchronizationKind;

import org.eclipse.uml2.uml.BehavioralFeature;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rt Service</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.RtServiceImpl#getConcPolicy <em>Conc Policy</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.RtServiceImpl#getExeKind <em>Exe Kind</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.RtServiceImpl#isIsAtomic <em>Is Atomic</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.RtServiceImpl#getSynchKind <em>Synch Kind</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.RtServiceImpl#getBase_BehavioralFeature <em>Base Behavioral Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RtServiceImpl extends EObjectImpl implements RtService {
	/**
	 * The default value of the '{@link #getConcPolicy() <em>Conc Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConcPolicy()
	 * @generated
	 * @ordered
	 */
	protected static final ConcurrencyKind CONC_POLICY_EDEFAULT = ConcurrencyKind.READER;

	/**
	 * The cached value of the '{@link #getConcPolicy() <em>Conc Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConcPolicy()
	 * @generated
	 * @ordered
	 */
	protected ConcurrencyKind concPolicy = CONC_POLICY_EDEFAULT;

	/**
	 * The default value of the '{@link #getExeKind() <em>Exe Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExeKind()
	 * @generated
	 * @ordered
	 */
	protected static final ExecutionKind EXE_KIND_EDEFAULT = ExecutionKind.DEFERRED;

	/**
	 * The cached value of the '{@link #getExeKind() <em>Exe Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExeKind()
	 * @generated
	 * @ordered
	 */
	protected ExecutionKind exeKind = EXE_KIND_EDEFAULT;

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
	 * The cached value of the '{@link #getBase_BehavioralFeature() <em>Base Behavioral Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_BehavioralFeature()
	 * @generated
	 * @ordered
	 */
	protected BehavioralFeature base_BehavioralFeature;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RtServiceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HLAMPackage.Literals.RT_SERVICE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConcurrencyKind getConcPolicy() {
		return concPolicy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConcPolicy(ConcurrencyKind newConcPolicy) {
		ConcurrencyKind oldConcPolicy = concPolicy;
		concPolicy = newConcPolicy == null ? CONC_POLICY_EDEFAULT : newConcPolicy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HLAMPackage.RT_SERVICE__CONC_POLICY, oldConcPolicy, concPolicy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionKind getExeKind() {
		return exeKind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExeKind(ExecutionKind newExeKind) {
		ExecutionKind oldExeKind = exeKind;
		exeKind = newExeKind == null ? EXE_KIND_EDEFAULT : newExeKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HLAMPackage.RT_SERVICE__EXE_KIND, oldExeKind, exeKind));
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
			eNotify(new ENotificationImpl(this, Notification.SET, HLAMPackage.RT_SERVICE__IS_ATOMIC, oldIsAtomic, isAtomic));
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
			eNotify(new ENotificationImpl(this, Notification.SET, HLAMPackage.RT_SERVICE__SYNCH_KIND, oldSynchKind, synchKind));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, HLAMPackage.RT_SERVICE__BASE_BEHAVIORAL_FEATURE, oldBase_BehavioralFeature, base_BehavioralFeature));
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
			eNotify(new ENotificationImpl(this, Notification.SET, HLAMPackage.RT_SERVICE__BASE_BEHAVIORAL_FEATURE, oldBase_BehavioralFeature, base_BehavioralFeature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case HLAMPackage.RT_SERVICE__CONC_POLICY:
				return getConcPolicy();
			case HLAMPackage.RT_SERVICE__EXE_KIND:
				return getExeKind();
			case HLAMPackage.RT_SERVICE__IS_ATOMIC:
				return isIsAtomic();
			case HLAMPackage.RT_SERVICE__SYNCH_KIND:
				return getSynchKind();
			case HLAMPackage.RT_SERVICE__BASE_BEHAVIORAL_FEATURE:
				if (resolve) return getBase_BehavioralFeature();
				return basicGetBase_BehavioralFeature();
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
			case HLAMPackage.RT_SERVICE__CONC_POLICY:
				setConcPolicy((ConcurrencyKind)newValue);
				return;
			case HLAMPackage.RT_SERVICE__EXE_KIND:
				setExeKind((ExecutionKind)newValue);
				return;
			case HLAMPackage.RT_SERVICE__IS_ATOMIC:
				setIsAtomic((Boolean)newValue);
				return;
			case HLAMPackage.RT_SERVICE__SYNCH_KIND:
				setSynchKind((SynchronizationKind)newValue);
				return;
			case HLAMPackage.RT_SERVICE__BASE_BEHAVIORAL_FEATURE:
				setBase_BehavioralFeature((BehavioralFeature)newValue);
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
			case HLAMPackage.RT_SERVICE__CONC_POLICY:
				setConcPolicy(CONC_POLICY_EDEFAULT);
				return;
			case HLAMPackage.RT_SERVICE__EXE_KIND:
				setExeKind(EXE_KIND_EDEFAULT);
				return;
			case HLAMPackage.RT_SERVICE__IS_ATOMIC:
				setIsAtomic(IS_ATOMIC_EDEFAULT);
				return;
			case HLAMPackage.RT_SERVICE__SYNCH_KIND:
				setSynchKind(SYNCH_KIND_EDEFAULT);
				return;
			case HLAMPackage.RT_SERVICE__BASE_BEHAVIORAL_FEATURE:
				setBase_BehavioralFeature((BehavioralFeature)null);
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
			case HLAMPackage.RT_SERVICE__CONC_POLICY:
				return concPolicy != CONC_POLICY_EDEFAULT;
			case HLAMPackage.RT_SERVICE__EXE_KIND:
				return exeKind != EXE_KIND_EDEFAULT;
			case HLAMPackage.RT_SERVICE__IS_ATOMIC:
				return isAtomic != IS_ATOMIC_EDEFAULT;
			case HLAMPackage.RT_SERVICE__SYNCH_KIND:
				return synchKind != SYNCH_KIND_EDEFAULT;
			case HLAMPackage.RT_SERVICE__BASE_BEHAVIORAL_FEATURE:
				return base_BehavioralFeature != null;
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
		result.append(" (concPolicy: ");
		result.append(concPolicy);
		result.append(", exeKind: ");
		result.append(exeKind);
		result.append(", isAtomic: ");
		result.append(isAtomic);
		result.append(", synchKind: ");
		result.append(synchKind);
		result.append(')');
		return result.toString();
	}

} //RtServiceImpl
