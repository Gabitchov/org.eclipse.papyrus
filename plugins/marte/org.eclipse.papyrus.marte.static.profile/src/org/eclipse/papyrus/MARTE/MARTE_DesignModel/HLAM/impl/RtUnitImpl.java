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
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.PoolMgtPolicyKind;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtUnit;

import org.eclipse.papyrus.MARTE_Library.GRM_BasicTypes.SchedPolicyKind;

import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.BehavioredClassifier;
import org.eclipse.uml2.uml.Operation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rt Unit</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.RtUnitImpl#isIsDynamic <em>Is Dynamic</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.RtUnitImpl#isIsMain <em>Is Main</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.RtUnitImpl#getSrPoolSize <em>Sr Pool Size</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.RtUnitImpl#getSrPoolPolicy <em>Sr Pool Policy</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.RtUnitImpl#getSrPoolWaitingTime <em>Sr Pool Waiting Time</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.RtUnitImpl#getOperationalMode <em>Operational Mode</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.RtUnitImpl#getMain <em>Main</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.RtUnitImpl#getMemorySize <em>Memory Size</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.RtUnitImpl#getBase_BehavioredClassifier <em>Base Behaviored Classifier</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.RtUnitImpl#getQueueSchedPolicy <em>Queue Sched Policy</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.RtUnitImpl#getQueueSize <em>Queue Size</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.RtUnitImpl#getMsgMaxSize <em>Msg Max Size</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RtUnitImpl extends EObjectImpl implements RtUnit {
	/**
	 * The default value of the '{@link #isIsDynamic() <em>Is Dynamic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsDynamic()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_DYNAMIC_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isIsDynamic() <em>Is Dynamic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsDynamic()
	 * @generated
	 * @ordered
	 */
	protected boolean isDynamic = IS_DYNAMIC_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsMain() <em>Is Main</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsMain()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_MAIN_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsMain() <em>Is Main</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsMain()
	 * @generated
	 * @ordered
	 */
	protected boolean isMain = IS_MAIN_EDEFAULT;

	/**
	 * The default value of the '{@link #getSrPoolSize() <em>Sr Pool Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSrPoolSize()
	 * @generated
	 * @ordered
	 */
	protected static final int SR_POOL_SIZE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSrPoolSize() <em>Sr Pool Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSrPoolSize()
	 * @generated
	 * @ordered
	 */
	protected int srPoolSize = SR_POOL_SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSrPoolPolicy() <em>Sr Pool Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSrPoolPolicy()
	 * @generated
	 * @ordered
	 */
	protected static final PoolMgtPolicyKind SR_POOL_POLICY_EDEFAULT = PoolMgtPolicyKind.INFINITE_WAIT;

	/**
	 * The cached value of the '{@link #getSrPoolPolicy() <em>Sr Pool Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSrPoolPolicy()
	 * @generated
	 * @ordered
	 */
	protected PoolMgtPolicyKind srPoolPolicy = SR_POOL_POLICY_EDEFAULT;

	/**
	 * The default value of the '{@link #getSrPoolWaitingTime() <em>Sr Pool Waiting Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSrPoolWaitingTime()
	 * @generated
	 * @ordered
	 */
	protected static final String SR_POOL_WAITING_TIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSrPoolWaitingTime() <em>Sr Pool Waiting Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSrPoolWaitingTime()
	 * @generated
	 * @ordered
	 */
	protected String srPoolWaitingTime = SR_POOL_WAITING_TIME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOperationalMode() <em>Operational Mode</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperationalMode()
	 * @generated
	 * @ordered
	 */
	protected Behavior operationalMode;

	/**
	 * The cached value of the '{@link #getMain() <em>Main</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMain()
	 * @generated
	 * @ordered
	 */
	protected Operation main;

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
	 * The cached value of the '{@link #getBase_BehavioredClassifier() <em>Base Behaviored Classifier</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_BehavioredClassifier()
	 * @generated
	 * @ordered
	 */
	protected BehavioredClassifier base_BehavioredClassifier;

	/**
	 * The default value of the '{@link #getQueueSchedPolicy() <em>Queue Sched Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueueSchedPolicy()
	 * @generated
	 * @ordered
	 */
	protected static final SchedPolicyKind QUEUE_SCHED_POLICY_EDEFAULT = SchedPolicyKind.EARLIEST_DEADLINE_FIRST;

	/**
	 * The cached value of the '{@link #getQueueSchedPolicy() <em>Queue Sched Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueueSchedPolicy()
	 * @generated
	 * @ordered
	 */
	protected SchedPolicyKind queueSchedPolicy = QUEUE_SCHED_POLICY_EDEFAULT;

	/**
	 * The default value of the '{@link #getQueueSize() <em>Queue Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueueSize()
	 * @generated
	 * @ordered
	 */
	protected static final int QUEUE_SIZE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getQueueSize() <em>Queue Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueueSize()
	 * @generated
	 * @ordered
	 */
	protected int queueSize = QUEUE_SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMsgMaxSize() <em>Msg Max Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMsgMaxSize()
	 * @generated
	 * @ordered
	 */
	protected static final String MSG_MAX_SIZE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMsgMaxSize() <em>Msg Max Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMsgMaxSize()
	 * @generated
	 * @ordered
	 */
	protected String msgMaxSize = MSG_MAX_SIZE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RtUnitImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HLAMPackage.Literals.RT_UNIT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsDynamic() {
		return isDynamic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsDynamic(boolean newIsDynamic) {
		boolean oldIsDynamic = isDynamic;
		isDynamic = newIsDynamic;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HLAMPackage.RT_UNIT__IS_DYNAMIC, oldIsDynamic, isDynamic));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsMain() {
		return isMain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsMain(boolean newIsMain) {
		boolean oldIsMain = isMain;
		isMain = newIsMain;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HLAMPackage.RT_UNIT__IS_MAIN, oldIsMain, isMain));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSrPoolSize() {
		return srPoolSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSrPoolSize(int newSrPoolSize) {
		int oldSrPoolSize = srPoolSize;
		srPoolSize = newSrPoolSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HLAMPackage.RT_UNIT__SR_POOL_SIZE, oldSrPoolSize, srPoolSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PoolMgtPolicyKind getSrPoolPolicy() {
		return srPoolPolicy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSrPoolPolicy(PoolMgtPolicyKind newSrPoolPolicy) {
		PoolMgtPolicyKind oldSrPoolPolicy = srPoolPolicy;
		srPoolPolicy = newSrPoolPolicy == null ? SR_POOL_POLICY_EDEFAULT : newSrPoolPolicy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HLAMPackage.RT_UNIT__SR_POOL_POLICY, oldSrPoolPolicy, srPoolPolicy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSrPoolWaitingTime() {
		return srPoolWaitingTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSrPoolWaitingTime(String newSrPoolWaitingTime) {
		String oldSrPoolWaitingTime = srPoolWaitingTime;
		srPoolWaitingTime = newSrPoolWaitingTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HLAMPackage.RT_UNIT__SR_POOL_WAITING_TIME, oldSrPoolWaitingTime, srPoolWaitingTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Behavior getOperationalMode() {
		if (operationalMode != null && operationalMode.eIsProxy()) {
			InternalEObject oldOperationalMode = (InternalEObject)operationalMode;
			operationalMode = (Behavior)eResolveProxy(oldOperationalMode);
			if (operationalMode != oldOperationalMode) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, HLAMPackage.RT_UNIT__OPERATIONAL_MODE, oldOperationalMode, operationalMode));
			}
		}
		return operationalMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Behavior basicGetOperationalMode() {
		return operationalMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperationalMode(Behavior newOperationalMode) {
		Behavior oldOperationalMode = operationalMode;
		operationalMode = newOperationalMode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HLAMPackage.RT_UNIT__OPERATIONAL_MODE, oldOperationalMode, operationalMode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation getMain() {
		if (main != null && main.eIsProxy()) {
			InternalEObject oldMain = (InternalEObject)main;
			main = (Operation)eResolveProxy(oldMain);
			if (main != oldMain) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, HLAMPackage.RT_UNIT__MAIN, oldMain, main));
			}
		}
		return main;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation basicGetMain() {
		return main;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMain(Operation newMain) {
		Operation oldMain = main;
		main = newMain;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HLAMPackage.RT_UNIT__MAIN, oldMain, main));
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
			eNotify(new ENotificationImpl(this, Notification.SET, HLAMPackage.RT_UNIT__MEMORY_SIZE, oldMemorySize, memorySize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BehavioredClassifier getBase_BehavioredClassifier() {
		if (base_BehavioredClassifier != null && base_BehavioredClassifier.eIsProxy()) {
			InternalEObject oldBase_BehavioredClassifier = (InternalEObject)base_BehavioredClassifier;
			base_BehavioredClassifier = (BehavioredClassifier)eResolveProxy(oldBase_BehavioredClassifier);
			if (base_BehavioredClassifier != oldBase_BehavioredClassifier) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, HLAMPackage.RT_UNIT__BASE_BEHAVIORED_CLASSIFIER, oldBase_BehavioredClassifier, base_BehavioredClassifier));
			}
		}
		return base_BehavioredClassifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BehavioredClassifier basicGetBase_BehavioredClassifier() {
		return base_BehavioredClassifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_BehavioredClassifier(BehavioredClassifier newBase_BehavioredClassifier) {
		BehavioredClassifier oldBase_BehavioredClassifier = base_BehavioredClassifier;
		base_BehavioredClassifier = newBase_BehavioredClassifier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HLAMPackage.RT_UNIT__BASE_BEHAVIORED_CLASSIFIER, oldBase_BehavioredClassifier, base_BehavioredClassifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SchedPolicyKind getQueueSchedPolicy() {
		return queueSchedPolicy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQueueSchedPolicy(SchedPolicyKind newQueueSchedPolicy) {
		SchedPolicyKind oldQueueSchedPolicy = queueSchedPolicy;
		queueSchedPolicy = newQueueSchedPolicy == null ? QUEUE_SCHED_POLICY_EDEFAULT : newQueueSchedPolicy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HLAMPackage.RT_UNIT__QUEUE_SCHED_POLICY, oldQueueSchedPolicy, queueSchedPolicy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getQueueSize() {
		return queueSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQueueSize(int newQueueSize) {
		int oldQueueSize = queueSize;
		queueSize = newQueueSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HLAMPackage.RT_UNIT__QUEUE_SIZE, oldQueueSize, queueSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMsgMaxSize() {
		return msgMaxSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMsgMaxSize(String newMsgMaxSize) {
		String oldMsgMaxSize = msgMaxSize;
		msgMaxSize = newMsgMaxSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HLAMPackage.RT_UNIT__MSG_MAX_SIZE, oldMsgMaxSize, msgMaxSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case HLAMPackage.RT_UNIT__IS_DYNAMIC:
				return isIsDynamic();
			case HLAMPackage.RT_UNIT__IS_MAIN:
				return isIsMain();
			case HLAMPackage.RT_UNIT__SR_POOL_SIZE:
				return getSrPoolSize();
			case HLAMPackage.RT_UNIT__SR_POOL_POLICY:
				return getSrPoolPolicy();
			case HLAMPackage.RT_UNIT__SR_POOL_WAITING_TIME:
				return getSrPoolWaitingTime();
			case HLAMPackage.RT_UNIT__OPERATIONAL_MODE:
				if (resolve) return getOperationalMode();
				return basicGetOperationalMode();
			case HLAMPackage.RT_UNIT__MAIN:
				if (resolve) return getMain();
				return basicGetMain();
			case HLAMPackage.RT_UNIT__MEMORY_SIZE:
				return getMemorySize();
			case HLAMPackage.RT_UNIT__BASE_BEHAVIORED_CLASSIFIER:
				if (resolve) return getBase_BehavioredClassifier();
				return basicGetBase_BehavioredClassifier();
			case HLAMPackage.RT_UNIT__QUEUE_SCHED_POLICY:
				return getQueueSchedPolicy();
			case HLAMPackage.RT_UNIT__QUEUE_SIZE:
				return getQueueSize();
			case HLAMPackage.RT_UNIT__MSG_MAX_SIZE:
				return getMsgMaxSize();
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
			case HLAMPackage.RT_UNIT__IS_DYNAMIC:
				setIsDynamic((Boolean)newValue);
				return;
			case HLAMPackage.RT_UNIT__IS_MAIN:
				setIsMain((Boolean)newValue);
				return;
			case HLAMPackage.RT_UNIT__SR_POOL_SIZE:
				setSrPoolSize((Integer)newValue);
				return;
			case HLAMPackage.RT_UNIT__SR_POOL_POLICY:
				setSrPoolPolicy((PoolMgtPolicyKind)newValue);
				return;
			case HLAMPackage.RT_UNIT__SR_POOL_WAITING_TIME:
				setSrPoolWaitingTime((String)newValue);
				return;
			case HLAMPackage.RT_UNIT__OPERATIONAL_MODE:
				setOperationalMode((Behavior)newValue);
				return;
			case HLAMPackage.RT_UNIT__MAIN:
				setMain((Operation)newValue);
				return;
			case HLAMPackage.RT_UNIT__MEMORY_SIZE:
				setMemorySize((String)newValue);
				return;
			case HLAMPackage.RT_UNIT__BASE_BEHAVIORED_CLASSIFIER:
				setBase_BehavioredClassifier((BehavioredClassifier)newValue);
				return;
			case HLAMPackage.RT_UNIT__QUEUE_SCHED_POLICY:
				setQueueSchedPolicy((SchedPolicyKind)newValue);
				return;
			case HLAMPackage.RT_UNIT__QUEUE_SIZE:
				setQueueSize((Integer)newValue);
				return;
			case HLAMPackage.RT_UNIT__MSG_MAX_SIZE:
				setMsgMaxSize((String)newValue);
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
			case HLAMPackage.RT_UNIT__IS_DYNAMIC:
				setIsDynamic(IS_DYNAMIC_EDEFAULT);
				return;
			case HLAMPackage.RT_UNIT__IS_MAIN:
				setIsMain(IS_MAIN_EDEFAULT);
				return;
			case HLAMPackage.RT_UNIT__SR_POOL_SIZE:
				setSrPoolSize(SR_POOL_SIZE_EDEFAULT);
				return;
			case HLAMPackage.RT_UNIT__SR_POOL_POLICY:
				setSrPoolPolicy(SR_POOL_POLICY_EDEFAULT);
				return;
			case HLAMPackage.RT_UNIT__SR_POOL_WAITING_TIME:
				setSrPoolWaitingTime(SR_POOL_WAITING_TIME_EDEFAULT);
				return;
			case HLAMPackage.RT_UNIT__OPERATIONAL_MODE:
				setOperationalMode((Behavior)null);
				return;
			case HLAMPackage.RT_UNIT__MAIN:
				setMain((Operation)null);
				return;
			case HLAMPackage.RT_UNIT__MEMORY_SIZE:
				setMemorySize(MEMORY_SIZE_EDEFAULT);
				return;
			case HLAMPackage.RT_UNIT__BASE_BEHAVIORED_CLASSIFIER:
				setBase_BehavioredClassifier((BehavioredClassifier)null);
				return;
			case HLAMPackage.RT_UNIT__QUEUE_SCHED_POLICY:
				setQueueSchedPolicy(QUEUE_SCHED_POLICY_EDEFAULT);
				return;
			case HLAMPackage.RT_UNIT__QUEUE_SIZE:
				setQueueSize(QUEUE_SIZE_EDEFAULT);
				return;
			case HLAMPackage.RT_UNIT__MSG_MAX_SIZE:
				setMsgMaxSize(MSG_MAX_SIZE_EDEFAULT);
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
			case HLAMPackage.RT_UNIT__IS_DYNAMIC:
				return isDynamic != IS_DYNAMIC_EDEFAULT;
			case HLAMPackage.RT_UNIT__IS_MAIN:
				return isMain != IS_MAIN_EDEFAULT;
			case HLAMPackage.RT_UNIT__SR_POOL_SIZE:
				return srPoolSize != SR_POOL_SIZE_EDEFAULT;
			case HLAMPackage.RT_UNIT__SR_POOL_POLICY:
				return srPoolPolicy != SR_POOL_POLICY_EDEFAULT;
			case HLAMPackage.RT_UNIT__SR_POOL_WAITING_TIME:
				return SR_POOL_WAITING_TIME_EDEFAULT == null ? srPoolWaitingTime != null : !SR_POOL_WAITING_TIME_EDEFAULT.equals(srPoolWaitingTime);
			case HLAMPackage.RT_UNIT__OPERATIONAL_MODE:
				return operationalMode != null;
			case HLAMPackage.RT_UNIT__MAIN:
				return main != null;
			case HLAMPackage.RT_UNIT__MEMORY_SIZE:
				return MEMORY_SIZE_EDEFAULT == null ? memorySize != null : !MEMORY_SIZE_EDEFAULT.equals(memorySize);
			case HLAMPackage.RT_UNIT__BASE_BEHAVIORED_CLASSIFIER:
				return base_BehavioredClassifier != null;
			case HLAMPackage.RT_UNIT__QUEUE_SCHED_POLICY:
				return queueSchedPolicy != QUEUE_SCHED_POLICY_EDEFAULT;
			case HLAMPackage.RT_UNIT__QUEUE_SIZE:
				return queueSize != QUEUE_SIZE_EDEFAULT;
			case HLAMPackage.RT_UNIT__MSG_MAX_SIZE:
				return MSG_MAX_SIZE_EDEFAULT == null ? msgMaxSize != null : !MSG_MAX_SIZE_EDEFAULT.equals(msgMaxSize);
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
		result.append(" (isDynamic: ");
		result.append(isDynamic);
		result.append(", isMain: ");
		result.append(isMain);
		result.append(", srPoolSize: ");
		result.append(srPoolSize);
		result.append(", srPoolPolicy: ");
		result.append(srPoolPolicy);
		result.append(", srPoolWaitingTime: ");
		result.append(srPoolWaitingTime);
		result.append(", memorySize: ");
		result.append(memorySize);
		result.append(", queueSchedPolicy: ");
		result.append(queueSchedPolicy);
		result.append(", queueSize: ");
		result.append(queueSize);
		result.append(", msgMaxSize: ");
		result.append(msgMaxSize);
		result.append(')');
		return result.toString();
	}

} //RtUnitImpl
