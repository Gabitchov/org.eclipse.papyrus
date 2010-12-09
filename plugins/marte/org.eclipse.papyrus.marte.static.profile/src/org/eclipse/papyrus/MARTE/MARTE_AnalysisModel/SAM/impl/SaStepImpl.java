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
package org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GaStepImpl;

import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SAMPackage;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaSharedResource;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaStep;

import org.eclipse.uml2.uml.BehavioralFeature;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sa Step</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SaStepImpl#getBase_BehavioralFeature <em>Base Behavioral Feature</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SaStepImpl#getDeadline <em>Deadline</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SaStepImpl#getSpareCap <em>Spare Cap</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SaStepImpl#getSchSlack <em>Sch Slack</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SaStepImpl#getPreemptT <em>Preempt T</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SaStepImpl#getReadyT <em>Ready T</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SaStepImpl#getNonpreemptionBlocking <em>Nonpreemption Blocking</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SaStepImpl#getSharedRes <em>Shared Res</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SaStepImpl#getSelfSuspensionBlocking <em>Self Suspension Blocking</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SaStepImpl#getNumberSelfSuspensions <em>Number Self Suspensions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SaStepImpl extends GaStepImpl implements SaStep {
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
	 * The default value of the '{@link #getDeadline() <em>Deadline</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeadline()
	 * @generated
	 * @ordered
	 */
	protected static final String DEADLINE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDeadline() <em>Deadline</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeadline()
	 * @generated
	 * @ordered
	 */
	protected String deadline = DEADLINE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSpareCap() <em>Spare Cap</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpareCap()
	 * @generated
	 * @ordered
	 */
	protected static final String SPARE_CAP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSpareCap() <em>Spare Cap</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpareCap()
	 * @generated
	 * @ordered
	 */
	protected String spareCap = SPARE_CAP_EDEFAULT;

	/**
	 * The default value of the '{@link #getSchSlack() <em>Sch Slack</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchSlack()
	 * @generated
	 * @ordered
	 */
	protected static final String SCH_SLACK_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSchSlack() <em>Sch Slack</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchSlack()
	 * @generated
	 * @ordered
	 */
	protected String schSlack = SCH_SLACK_EDEFAULT;

	/**
	 * The default value of the '{@link #getPreemptT() <em>Preempt T</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreemptT()
	 * @generated
	 * @ordered
	 */
	protected static final String PREEMPT_T_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPreemptT() <em>Preempt T</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreemptT()
	 * @generated
	 * @ordered
	 */
	protected String preemptT = PREEMPT_T_EDEFAULT;

	/**
	 * The default value of the '{@link #getReadyT() <em>Ready T</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReadyT()
	 * @generated
	 * @ordered
	 */
	protected static final String READY_T_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getReadyT() <em>Ready T</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReadyT()
	 * @generated
	 * @ordered
	 */
	protected String readyT = READY_T_EDEFAULT;

	/**
	 * The default value of the '{@link #getNonpreemptionBlocking() <em>Nonpreemption Blocking</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNonpreemptionBlocking()
	 * @generated
	 * @ordered
	 */
	protected static final String NONPREEMPTION_BLOCKING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNonpreemptionBlocking() <em>Nonpreemption Blocking</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNonpreemptionBlocking()
	 * @generated
	 * @ordered
	 */
	protected String nonpreemptionBlocking = NONPREEMPTION_BLOCKING_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSharedRes() <em>Shared Res</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSharedRes()
	 * @generated
	 * @ordered
	 */
	protected EList<SaSharedResource> sharedRes;

	/**
	 * The default value of the '{@link #getSelfSuspensionBlocking() <em>Self Suspension Blocking</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSelfSuspensionBlocking()
	 * @generated
	 * @ordered
	 */
	protected static final String SELF_SUSPENSION_BLOCKING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSelfSuspensionBlocking() <em>Self Suspension Blocking</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSelfSuspensionBlocking()
	 * @generated
	 * @ordered
	 */
	protected String selfSuspensionBlocking = SELF_SUSPENSION_BLOCKING_EDEFAULT;

	/**
	 * The default value of the '{@link #getNumberSelfSuspensions() <em>Number Self Suspensions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberSelfSuspensions()
	 * @generated
	 * @ordered
	 */
	protected static final String NUMBER_SELF_SUSPENSIONS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNumberSelfSuspensions() <em>Number Self Suspensions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberSelfSuspensions()
	 * @generated
	 * @ordered
	 */
	protected String numberSelfSuspensions = NUMBER_SELF_SUSPENSIONS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SaStepImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SAMPackage.Literals.SA_STEP;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SAMPackage.SA_STEP__BASE_BEHAVIORAL_FEATURE, oldBase_BehavioralFeature, base_BehavioralFeature));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SAMPackage.SA_STEP__BASE_BEHAVIORAL_FEATURE, oldBase_BehavioralFeature, base_BehavioralFeature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDeadline() {
		return deadline;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeadline(String newDeadline) {
		String oldDeadline = deadline;
		deadline = newDeadline;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SAMPackage.SA_STEP__DEADLINE, oldDeadline, deadline));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSpareCap() {
		return spareCap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpareCap(String newSpareCap) {
		String oldSpareCap = spareCap;
		spareCap = newSpareCap;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SAMPackage.SA_STEP__SPARE_CAP, oldSpareCap, spareCap));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSchSlack() {
		return schSlack;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSchSlack(String newSchSlack) {
		String oldSchSlack = schSlack;
		schSlack = newSchSlack;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SAMPackage.SA_STEP__SCH_SLACK, oldSchSlack, schSlack));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPreemptT() {
		return preemptT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPreemptT(String newPreemptT) {
		String oldPreemptT = preemptT;
		preemptT = newPreemptT;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SAMPackage.SA_STEP__PREEMPT_T, oldPreemptT, preemptT));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getReadyT() {
		return readyT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReadyT(String newReadyT) {
		String oldReadyT = readyT;
		readyT = newReadyT;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SAMPackage.SA_STEP__READY_T, oldReadyT, readyT));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNonpreemptionBlocking() {
		return nonpreemptionBlocking;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNonpreemptionBlocking(String newNonpreemptionBlocking) {
		String oldNonpreemptionBlocking = nonpreemptionBlocking;
		nonpreemptionBlocking = newNonpreemptionBlocking;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SAMPackage.SA_STEP__NONPREEMPTION_BLOCKING, oldNonpreemptionBlocking, nonpreemptionBlocking));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SaSharedResource> getSharedRes() {
		if (sharedRes == null) {
			sharedRes = new EObjectResolvingEList<SaSharedResource>(SaSharedResource.class, this, SAMPackage.SA_STEP__SHARED_RES);
		}
		return sharedRes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSelfSuspensionBlocking() {
		return selfSuspensionBlocking;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSelfSuspensionBlocking(String newSelfSuspensionBlocking) {
		String oldSelfSuspensionBlocking = selfSuspensionBlocking;
		selfSuspensionBlocking = newSelfSuspensionBlocking;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SAMPackage.SA_STEP__SELF_SUSPENSION_BLOCKING, oldSelfSuspensionBlocking, selfSuspensionBlocking));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNumberSelfSuspensions() {
		return numberSelfSuspensions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumberSelfSuspensions(String newNumberSelfSuspensions) {
		String oldNumberSelfSuspensions = numberSelfSuspensions;
		numberSelfSuspensions = newNumberSelfSuspensions;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SAMPackage.SA_STEP__NUMBER_SELF_SUSPENSIONS, oldNumberSelfSuspensions, numberSelfSuspensions));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SAMPackage.SA_STEP__BASE_BEHAVIORAL_FEATURE:
				if (resolve) return getBase_BehavioralFeature();
				return basicGetBase_BehavioralFeature();
			case SAMPackage.SA_STEP__DEADLINE:
				return getDeadline();
			case SAMPackage.SA_STEP__SPARE_CAP:
				return getSpareCap();
			case SAMPackage.SA_STEP__SCH_SLACK:
				return getSchSlack();
			case SAMPackage.SA_STEP__PREEMPT_T:
				return getPreemptT();
			case SAMPackage.SA_STEP__READY_T:
				return getReadyT();
			case SAMPackage.SA_STEP__NONPREEMPTION_BLOCKING:
				return getNonpreemptionBlocking();
			case SAMPackage.SA_STEP__SHARED_RES:
				return getSharedRes();
			case SAMPackage.SA_STEP__SELF_SUSPENSION_BLOCKING:
				return getSelfSuspensionBlocking();
			case SAMPackage.SA_STEP__NUMBER_SELF_SUSPENSIONS:
				return getNumberSelfSuspensions();
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
			case SAMPackage.SA_STEP__BASE_BEHAVIORAL_FEATURE:
				setBase_BehavioralFeature((BehavioralFeature)newValue);
				return;
			case SAMPackage.SA_STEP__DEADLINE:
				setDeadline((String)newValue);
				return;
			case SAMPackage.SA_STEP__SPARE_CAP:
				setSpareCap((String)newValue);
				return;
			case SAMPackage.SA_STEP__SCH_SLACK:
				setSchSlack((String)newValue);
				return;
			case SAMPackage.SA_STEP__PREEMPT_T:
				setPreemptT((String)newValue);
				return;
			case SAMPackage.SA_STEP__READY_T:
				setReadyT((String)newValue);
				return;
			case SAMPackage.SA_STEP__NONPREEMPTION_BLOCKING:
				setNonpreemptionBlocking((String)newValue);
				return;
			case SAMPackage.SA_STEP__SHARED_RES:
				getSharedRes().clear();
				getSharedRes().addAll((Collection<? extends SaSharedResource>)newValue);
				return;
			case SAMPackage.SA_STEP__SELF_SUSPENSION_BLOCKING:
				setSelfSuspensionBlocking((String)newValue);
				return;
			case SAMPackage.SA_STEP__NUMBER_SELF_SUSPENSIONS:
				setNumberSelfSuspensions((String)newValue);
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
			case SAMPackage.SA_STEP__BASE_BEHAVIORAL_FEATURE:
				setBase_BehavioralFeature((BehavioralFeature)null);
				return;
			case SAMPackage.SA_STEP__DEADLINE:
				setDeadline(DEADLINE_EDEFAULT);
				return;
			case SAMPackage.SA_STEP__SPARE_CAP:
				setSpareCap(SPARE_CAP_EDEFAULT);
				return;
			case SAMPackage.SA_STEP__SCH_SLACK:
				setSchSlack(SCH_SLACK_EDEFAULT);
				return;
			case SAMPackage.SA_STEP__PREEMPT_T:
				setPreemptT(PREEMPT_T_EDEFAULT);
				return;
			case SAMPackage.SA_STEP__READY_T:
				setReadyT(READY_T_EDEFAULT);
				return;
			case SAMPackage.SA_STEP__NONPREEMPTION_BLOCKING:
				setNonpreemptionBlocking(NONPREEMPTION_BLOCKING_EDEFAULT);
				return;
			case SAMPackage.SA_STEP__SHARED_RES:
				getSharedRes().clear();
				return;
			case SAMPackage.SA_STEP__SELF_SUSPENSION_BLOCKING:
				setSelfSuspensionBlocking(SELF_SUSPENSION_BLOCKING_EDEFAULT);
				return;
			case SAMPackage.SA_STEP__NUMBER_SELF_SUSPENSIONS:
				setNumberSelfSuspensions(NUMBER_SELF_SUSPENSIONS_EDEFAULT);
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
			case SAMPackage.SA_STEP__BASE_BEHAVIORAL_FEATURE:
				return base_BehavioralFeature != null;
			case SAMPackage.SA_STEP__DEADLINE:
				return DEADLINE_EDEFAULT == null ? deadline != null : !DEADLINE_EDEFAULT.equals(deadline);
			case SAMPackage.SA_STEP__SPARE_CAP:
				return SPARE_CAP_EDEFAULT == null ? spareCap != null : !SPARE_CAP_EDEFAULT.equals(spareCap);
			case SAMPackage.SA_STEP__SCH_SLACK:
				return SCH_SLACK_EDEFAULT == null ? schSlack != null : !SCH_SLACK_EDEFAULT.equals(schSlack);
			case SAMPackage.SA_STEP__PREEMPT_T:
				return PREEMPT_T_EDEFAULT == null ? preemptT != null : !PREEMPT_T_EDEFAULT.equals(preemptT);
			case SAMPackage.SA_STEP__READY_T:
				return READY_T_EDEFAULT == null ? readyT != null : !READY_T_EDEFAULT.equals(readyT);
			case SAMPackage.SA_STEP__NONPREEMPTION_BLOCKING:
				return NONPREEMPTION_BLOCKING_EDEFAULT == null ? nonpreemptionBlocking != null : !NONPREEMPTION_BLOCKING_EDEFAULT.equals(nonpreemptionBlocking);
			case SAMPackage.SA_STEP__SHARED_RES:
				return sharedRes != null && !sharedRes.isEmpty();
			case SAMPackage.SA_STEP__SELF_SUSPENSION_BLOCKING:
				return SELF_SUSPENSION_BLOCKING_EDEFAULT == null ? selfSuspensionBlocking != null : !SELF_SUSPENSION_BLOCKING_EDEFAULT.equals(selfSuspensionBlocking);
			case SAMPackage.SA_STEP__NUMBER_SELF_SUSPENSIONS:
				return NUMBER_SELF_SUSPENSIONS_EDEFAULT == null ? numberSelfSuspensions != null : !NUMBER_SELF_SUSPENSIONS_EDEFAULT.equals(numberSelfSuspensions);
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
		result.append(" (deadline: ");
		result.append(deadline);
		result.append(", spareCap: ");
		result.append(spareCap);
		result.append(", schSlack: ");
		result.append(schSlack);
		result.append(", preemptT: ");
		result.append(preemptT);
		result.append(", readyT: ");
		result.append(readyT);
		result.append(", nonpreemptionBlocking: ");
		result.append(nonpreemptionBlocking);
		result.append(", selfSuspensionBlocking: ");
		result.append(selfSuspensionBlocking);
		result.append(", numberSelfSuspensions: ");
		result.append(numberSelfSuspensions);
		result.append(')');
		return result.toString();
	}

} //SaStepImpl
