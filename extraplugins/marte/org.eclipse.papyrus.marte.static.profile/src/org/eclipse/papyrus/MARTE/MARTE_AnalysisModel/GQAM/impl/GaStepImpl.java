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
package org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GQAMPackage;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaExecHost;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaRequestedService;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaScenario;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaStep;

import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.SchedulableResource;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ga Step</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaStepImpl#getIsAtomic <em>Is Atomic</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaStepImpl#getBlockT <em>Block T</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaStepImpl#getRep <em>Rep</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaStepImpl#getProb <em>Prob</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaStepImpl#getPriority <em>Priority</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaStepImpl#getConcurRes <em>Concur Res</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaStepImpl#getHost <em>Host</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaStepImpl#getServDemand <em>Serv Demand</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaStepImpl#getServCount <em>Serv Count</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaStepImpl#getSelfDelay <em>Self Delay</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaStepImpl#getScenario <em>Scenario</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaStepImpl#getChildScenario <em>Child Scenario</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GaStepImpl extends GaScenarioImpl implements GaStep {
	/**
	 * The default value of the '{@link #getIsAtomic() <em>Is Atomic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsAtomic()
	 * @generated
	 * @ordered
	 */
	protected static final String IS_ATOMIC_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIsAtomic() <em>Is Atomic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsAtomic()
	 * @generated
	 * @ordered
	 */
	protected String isAtomic = IS_ATOMIC_EDEFAULT;

	/**
	 * The default value of the '{@link #getBlockT() <em>Block T</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBlockT()
	 * @generated
	 * @ordered
	 */
	protected static final String BLOCK_T_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBlockT() <em>Block T</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBlockT()
	 * @generated
	 * @ordered
	 */
	protected String blockT = BLOCK_T_EDEFAULT;

	/**
	 * The default value of the '{@link #getRep() <em>Rep</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRep()
	 * @generated
	 * @ordered
	 */
	protected static final String REP_EDEFAULT = "1.0";

	/**
	 * The cached value of the '{@link #getRep() <em>Rep</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRep()
	 * @generated
	 * @ordered
	 */
	protected String rep = REP_EDEFAULT;

	/**
	 * The default value of the '{@link #getProb() <em>Prob</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProb()
	 * @generated
	 * @ordered
	 */
	protected static final String PROB_EDEFAULT = "1.0";

	/**
	 * The cached value of the '{@link #getProb() <em>Prob</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProb()
	 * @generated
	 * @ordered
	 */
	protected String prob = PROB_EDEFAULT;

	/**
	 * The default value of the '{@link #getPriority() <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
	protected static final String PRIORITY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPriority() <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
	protected String priority = PRIORITY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getConcurRes() <em>Concur Res</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConcurRes()
	 * @generated
	 * @ordered
	 */
	protected SchedulableResource concurRes;

	/**
	 * The cached value of the '{@link #getHost() <em>Host</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHost()
	 * @generated
	 * @ordered
	 */
	protected GaExecHost host;

	/**
	 * The cached value of the '{@link #getServDemand() <em>Serv Demand</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServDemand()
	 * @generated
	 * @ordered
	 */
	protected EList<GaRequestedService> servDemand;

	/**
	 * The cached value of the '{@link #getServCount() <em>Serv Count</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServCount()
	 * @generated
	 * @ordered
	 */
	protected EList<String> servCount;

	/**
	 * The default value of the '{@link #getSelfDelay() <em>Self Delay</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSelfDelay()
	 * @generated
	 * @ordered
	 */
	protected static final String SELF_DELAY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSelfDelay() <em>Self Delay</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSelfDelay()
	 * @generated
	 * @ordered
	 */
	protected String selfDelay = SELF_DELAY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getScenario() <em>Scenario</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScenario()
	 * @generated
	 * @ordered
	 */
	protected GaScenario scenario;

	/**
	 * The cached value of the '{@link #getChildScenario() <em>Child Scenario</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildScenario()
	 * @generated
	 * @ordered
	 */
	protected GaScenario childScenario;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GaStepImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GQAMPackage.Literals.GA_STEP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIsAtomic() {
		return isAtomic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsAtomic(String newIsAtomic) {
		String oldIsAtomic = isAtomic;
		isAtomic = newIsAtomic;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GQAMPackage.GA_STEP__IS_ATOMIC, oldIsAtomic, isAtomic));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBlockT() {
		return blockT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBlockT(String newBlockT) {
		String oldBlockT = blockT;
		blockT = newBlockT;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GQAMPackage.GA_STEP__BLOCK_T, oldBlockT, blockT));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRep() {
		return rep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRep(String newRep) {
		String oldRep = rep;
		rep = newRep;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GQAMPackage.GA_STEP__REP, oldRep, rep));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProb() {
		return prob;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProb(String newProb) {
		String oldProb = prob;
		prob = newProb;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GQAMPackage.GA_STEP__PROB, oldProb, prob));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPriority() {
		return priority;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPriority(String newPriority) {
		String oldPriority = priority;
		priority = newPriority;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GQAMPackage.GA_STEP__PRIORITY, oldPriority, priority));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SchedulableResource getConcurRes() {
		if (concurRes != null && concurRes.eIsProxy()) {
			InternalEObject oldConcurRes = (InternalEObject)concurRes;
			concurRes = (SchedulableResource)eResolveProxy(oldConcurRes);
			if (concurRes != oldConcurRes) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GQAMPackage.GA_STEP__CONCUR_RES, oldConcurRes, concurRes));
			}
		}
		return concurRes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SchedulableResource basicGetConcurRes() {
		return concurRes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConcurRes(SchedulableResource newConcurRes) {
		SchedulableResource oldConcurRes = concurRes;
		concurRes = newConcurRes;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GQAMPackage.GA_STEP__CONCUR_RES, oldConcurRes, concurRes));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GaExecHost getHost() {
		if (host != null && host.eIsProxy()) {
			InternalEObject oldHost = (InternalEObject)host;
			host = (GaExecHost)eResolveProxy(oldHost);
			if (host != oldHost) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GQAMPackage.GA_STEP__HOST, oldHost, host));
			}
		}
		return host;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GaExecHost basicGetHost() {
		return host;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHost(GaExecHost newHost) {
		GaExecHost oldHost = host;
		host = newHost;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GQAMPackage.GA_STEP__HOST, oldHost, host));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GaRequestedService> getServDemand() {
		if (servDemand == null) {
			servDemand = new EObjectResolvingEList<GaRequestedService>(GaRequestedService.class, this, GQAMPackage.GA_STEP__SERV_DEMAND);
		}
		return servDemand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getServCount() {
		if (servCount == null) {
			servCount = new EDataTypeUniqueEList<String>(String.class, this, GQAMPackage.GA_STEP__SERV_COUNT);
		}
		return servCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSelfDelay() {
		return selfDelay;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSelfDelay(String newSelfDelay) {
		String oldSelfDelay = selfDelay;
		selfDelay = newSelfDelay;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GQAMPackage.GA_STEP__SELF_DELAY, oldSelfDelay, selfDelay));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GaScenario getScenario() {
		if (scenario != null && scenario.eIsProxy()) {
			InternalEObject oldScenario = (InternalEObject)scenario;
			scenario = (GaScenario)eResolveProxy(oldScenario);
			if (scenario != oldScenario) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GQAMPackage.GA_STEP__SCENARIO, oldScenario, scenario));
			}
		}
		return scenario;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GaScenario basicGetScenario() {
		return scenario;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetScenario(GaScenario newScenario, NotificationChain msgs) {
		GaScenario oldScenario = scenario;
		scenario = newScenario;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GQAMPackage.GA_STEP__SCENARIO, oldScenario, newScenario);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScenario(GaScenario newScenario) {
		if (newScenario != scenario) {
			NotificationChain msgs = null;
			if (scenario != null)
				msgs = ((InternalEObject)scenario).eInverseRemove(this, GQAMPackage.GA_SCENARIO__STEPS, GaScenario.class, msgs);
			if (newScenario != null)
				msgs = ((InternalEObject)newScenario).eInverseAdd(this, GQAMPackage.GA_SCENARIO__STEPS, GaScenario.class, msgs);
			msgs = basicSetScenario(newScenario, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GQAMPackage.GA_STEP__SCENARIO, newScenario, newScenario));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GaScenario getChildScenario() {
		if (childScenario != null && childScenario.eIsProxy()) {
			InternalEObject oldChildScenario = (InternalEObject)childScenario;
			childScenario = (GaScenario)eResolveProxy(oldChildScenario);
			if (childScenario != oldChildScenario) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GQAMPackage.GA_STEP__CHILD_SCENARIO, oldChildScenario, childScenario));
			}
		}
		return childScenario;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GaScenario basicGetChildScenario() {
		return childScenario;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetChildScenario(GaScenario newChildScenario, NotificationChain msgs) {
		GaScenario oldChildScenario = childScenario;
		childScenario = newChildScenario;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GQAMPackage.GA_STEP__CHILD_SCENARIO, oldChildScenario, newChildScenario);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChildScenario(GaScenario newChildScenario) {
		if (newChildScenario != childScenario) {
			NotificationChain msgs = null;
			if (childScenario != null)
				msgs = ((InternalEObject)childScenario).eInverseRemove(this, GQAMPackage.GA_SCENARIO__PARENT_STEP, GaScenario.class, msgs);
			if (newChildScenario != null)
				msgs = ((InternalEObject)newChildScenario).eInverseAdd(this, GQAMPackage.GA_SCENARIO__PARENT_STEP, GaScenario.class, msgs);
			msgs = basicSetChildScenario(newChildScenario, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GQAMPackage.GA_STEP__CHILD_SCENARIO, newChildScenario, newChildScenario));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GQAMPackage.GA_STEP__SCENARIO:
				if (scenario != null)
					msgs = ((InternalEObject)scenario).eInverseRemove(this, GQAMPackage.GA_SCENARIO__STEPS, GaScenario.class, msgs);
				return basicSetScenario((GaScenario)otherEnd, msgs);
			case GQAMPackage.GA_STEP__CHILD_SCENARIO:
				if (childScenario != null)
					msgs = ((InternalEObject)childScenario).eInverseRemove(this, GQAMPackage.GA_SCENARIO__PARENT_STEP, GaScenario.class, msgs);
				return basicSetChildScenario((GaScenario)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GQAMPackage.GA_STEP__SCENARIO:
				return basicSetScenario(null, msgs);
			case GQAMPackage.GA_STEP__CHILD_SCENARIO:
				return basicSetChildScenario(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GQAMPackage.GA_STEP__IS_ATOMIC:
				return getIsAtomic();
			case GQAMPackage.GA_STEP__BLOCK_T:
				return getBlockT();
			case GQAMPackage.GA_STEP__REP:
				return getRep();
			case GQAMPackage.GA_STEP__PROB:
				return getProb();
			case GQAMPackage.GA_STEP__PRIORITY:
				return getPriority();
			case GQAMPackage.GA_STEP__CONCUR_RES:
				if (resolve) return getConcurRes();
				return basicGetConcurRes();
			case GQAMPackage.GA_STEP__HOST:
				if (resolve) return getHost();
				return basicGetHost();
			case GQAMPackage.GA_STEP__SERV_DEMAND:
				return getServDemand();
			case GQAMPackage.GA_STEP__SERV_COUNT:
				return getServCount();
			case GQAMPackage.GA_STEP__SELF_DELAY:
				return getSelfDelay();
			case GQAMPackage.GA_STEP__SCENARIO:
				if (resolve) return getScenario();
				return basicGetScenario();
			case GQAMPackage.GA_STEP__CHILD_SCENARIO:
				if (resolve) return getChildScenario();
				return basicGetChildScenario();
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
			case GQAMPackage.GA_STEP__IS_ATOMIC:
				setIsAtomic((String)newValue);
				return;
			case GQAMPackage.GA_STEP__BLOCK_T:
				setBlockT((String)newValue);
				return;
			case GQAMPackage.GA_STEP__REP:
				setRep((String)newValue);
				return;
			case GQAMPackage.GA_STEP__PROB:
				setProb((String)newValue);
				return;
			case GQAMPackage.GA_STEP__PRIORITY:
				setPriority((String)newValue);
				return;
			case GQAMPackage.GA_STEP__CONCUR_RES:
				setConcurRes((SchedulableResource)newValue);
				return;
			case GQAMPackage.GA_STEP__HOST:
				setHost((GaExecHost)newValue);
				return;
			case GQAMPackage.GA_STEP__SERV_DEMAND:
				getServDemand().clear();
				getServDemand().addAll((Collection<? extends GaRequestedService>)newValue);
				return;
			case GQAMPackage.GA_STEP__SERV_COUNT:
				getServCount().clear();
				getServCount().addAll((Collection<? extends String>)newValue);
				return;
			case GQAMPackage.GA_STEP__SELF_DELAY:
				setSelfDelay((String)newValue);
				return;
			case GQAMPackage.GA_STEP__SCENARIO:
				setScenario((GaScenario)newValue);
				return;
			case GQAMPackage.GA_STEP__CHILD_SCENARIO:
				setChildScenario((GaScenario)newValue);
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
			case GQAMPackage.GA_STEP__IS_ATOMIC:
				setIsAtomic(IS_ATOMIC_EDEFAULT);
				return;
			case GQAMPackage.GA_STEP__BLOCK_T:
				setBlockT(BLOCK_T_EDEFAULT);
				return;
			case GQAMPackage.GA_STEP__REP:
				setRep(REP_EDEFAULT);
				return;
			case GQAMPackage.GA_STEP__PROB:
				setProb(PROB_EDEFAULT);
				return;
			case GQAMPackage.GA_STEP__PRIORITY:
				setPriority(PRIORITY_EDEFAULT);
				return;
			case GQAMPackage.GA_STEP__CONCUR_RES:
				setConcurRes((SchedulableResource)null);
				return;
			case GQAMPackage.GA_STEP__HOST:
				setHost((GaExecHost)null);
				return;
			case GQAMPackage.GA_STEP__SERV_DEMAND:
				getServDemand().clear();
				return;
			case GQAMPackage.GA_STEP__SERV_COUNT:
				getServCount().clear();
				return;
			case GQAMPackage.GA_STEP__SELF_DELAY:
				setSelfDelay(SELF_DELAY_EDEFAULT);
				return;
			case GQAMPackage.GA_STEP__SCENARIO:
				setScenario((GaScenario)null);
				return;
			case GQAMPackage.GA_STEP__CHILD_SCENARIO:
				setChildScenario((GaScenario)null);
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
			case GQAMPackage.GA_STEP__IS_ATOMIC:
				return IS_ATOMIC_EDEFAULT == null ? isAtomic != null : !IS_ATOMIC_EDEFAULT.equals(isAtomic);
			case GQAMPackage.GA_STEP__BLOCK_T:
				return BLOCK_T_EDEFAULT == null ? blockT != null : !BLOCK_T_EDEFAULT.equals(blockT);
			case GQAMPackage.GA_STEP__REP:
				return REP_EDEFAULT == null ? rep != null : !REP_EDEFAULT.equals(rep);
			case GQAMPackage.GA_STEP__PROB:
				return PROB_EDEFAULT == null ? prob != null : !PROB_EDEFAULT.equals(prob);
			case GQAMPackage.GA_STEP__PRIORITY:
				return PRIORITY_EDEFAULT == null ? priority != null : !PRIORITY_EDEFAULT.equals(priority);
			case GQAMPackage.GA_STEP__CONCUR_RES:
				return concurRes != null;
			case GQAMPackage.GA_STEP__HOST:
				return host != null;
			case GQAMPackage.GA_STEP__SERV_DEMAND:
				return servDemand != null && !servDemand.isEmpty();
			case GQAMPackage.GA_STEP__SERV_COUNT:
				return servCount != null && !servCount.isEmpty();
			case GQAMPackage.GA_STEP__SELF_DELAY:
				return SELF_DELAY_EDEFAULT == null ? selfDelay != null : !SELF_DELAY_EDEFAULT.equals(selfDelay);
			case GQAMPackage.GA_STEP__SCENARIO:
				return scenario != null;
			case GQAMPackage.GA_STEP__CHILD_SCENARIO:
				return childScenario != null;
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
		result.append(", blockT: ");
		result.append(blockT);
		result.append(", rep: ");
		result.append(rep);
		result.append(", prob: ");
		result.append(prob);
		result.append(", priority: ");
		result.append(priority);
		result.append(", servCount: ");
		result.append(servCount);
		result.append(", selfDelay: ");
		result.append(selfDelay);
		result.append(')');
		return result.toString();
	}

} //GaStepImpl
