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
package org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.ComputingResource;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.GRMPackage;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.MutualExclusionResource;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.ProcessingResource;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.SchedulableResource;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Scheduler;
import org.eclipse.papyrus.MARTE_Library.GRM_BasicTypes.SchedPolicyKind;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Scheduler</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.SchedulerImpl#isIsPreemptible <em>Is Preemptible</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.SchedulerImpl#getSchedPolicy <em>Sched Policy</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.SchedulerImpl#getOtherSchedPolicy <em>Other Sched Policy</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.SchedulerImpl#getSchedule <em>Schedule</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.SchedulerImpl#getProcessingUnits <em>Processing Units</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.SchedulerImpl#getHost <em>Host</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.SchedulerImpl#getProtectedSharedResources <em>Protected Shared Resources</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.SchedulerImpl#getSchedulableResources <em>Schedulable Resources</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SchedulerImpl extends ResourceImpl implements Scheduler {
	/**
	 * The default value of the '{@link #isIsPreemptible() <em>Is Preemptible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsPreemptible()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_PREEMPTIBLE_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isIsPreemptible() <em>Is Preemptible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsPreemptible()
	 * @generated
	 * @ordered
	 */
	protected boolean isPreemptible = IS_PREEMPTIBLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSchedPolicy() <em>Sched Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchedPolicy()
	 * @generated
	 * @ordered
	 */
	protected static final SchedPolicyKind SCHED_POLICY_EDEFAULT = SchedPolicyKind.FIXED_PRIORITY;

	/**
	 * The cached value of the '{@link #getSchedPolicy() <em>Sched Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchedPolicy()
	 * @generated
	 * @ordered
	 */
	protected SchedPolicyKind schedPolicy = SCHED_POLICY_EDEFAULT;

	/**
	 * The default value of the '{@link #getOtherSchedPolicy() <em>Other Sched Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOtherSchedPolicy()
	 * @generated
	 * @ordered
	 */
	protected static final String OTHER_SCHED_POLICY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOtherSchedPolicy() <em>Other Sched Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOtherSchedPolicy()
	 * @generated
	 * @ordered
	 */
	protected String otherSchedPolicy = OTHER_SCHED_POLICY_EDEFAULT;

	/**
	 * The default value of the '{@link #getSchedule() <em>Schedule</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchedule()
	 * @generated
	 * @ordered
	 */
	protected static final String SCHEDULE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSchedule() <em>Schedule</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchedule()
	 * @generated
	 * @ordered
	 */
	protected String schedule = SCHEDULE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getProcessingUnits() <em>Processing Units</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcessingUnits()
	 * @generated
	 * @ordered
	 */
	protected EList<ProcessingResource> processingUnits;

	/**
	 * The cached value of the '{@link #getHost() <em>Host</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHost()
	 * @generated
	 * @ordered
	 */
	protected ComputingResource host;

	/**
	 * The cached value of the '{@link #getProtectedSharedResources() <em>Protected Shared Resources</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProtectedSharedResources()
	 * @generated
	 * @ordered
	 */
	protected EList<MutualExclusionResource> protectedSharedResources;

	/**
	 * The cached value of the '{@link #getSchedulableResources() <em>Schedulable Resources</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchedulableResources()
	 * @generated
	 * @ordered
	 */
	protected EList<SchedulableResource> schedulableResources;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SchedulerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GRMPackage.Literals.SCHEDULER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsPreemptible() {
		return isPreemptible;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsPreemptible(boolean newIsPreemptible) {
		boolean oldIsPreemptible = isPreemptible;
		isPreemptible = newIsPreemptible;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GRMPackage.SCHEDULER__IS_PREEMPTIBLE, oldIsPreemptible, isPreemptible));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SchedPolicyKind getSchedPolicy() {
		return schedPolicy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSchedPolicy(SchedPolicyKind newSchedPolicy) {
		SchedPolicyKind oldSchedPolicy = schedPolicy;
		schedPolicy = newSchedPolicy == null ? SCHED_POLICY_EDEFAULT : newSchedPolicy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GRMPackage.SCHEDULER__SCHED_POLICY, oldSchedPolicy, schedPolicy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOtherSchedPolicy() {
		return otherSchedPolicy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOtherSchedPolicy(String newOtherSchedPolicy) {
		String oldOtherSchedPolicy = otherSchedPolicy;
		otherSchedPolicy = newOtherSchedPolicy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GRMPackage.SCHEDULER__OTHER_SCHED_POLICY, oldOtherSchedPolicy, otherSchedPolicy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSchedule() {
		return schedule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSchedule(String newSchedule) {
		String oldSchedule = schedule;
		schedule = newSchedule;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GRMPackage.SCHEDULER__SCHEDULE, oldSchedule, schedule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ProcessingResource> getProcessingUnits() {
		if (processingUnits == null) {
			processingUnits = new EObjectResolvingEList<ProcessingResource>(ProcessingResource.class, this, GRMPackage.SCHEDULER__PROCESSING_UNITS);
		}
		return processingUnits;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComputingResource getHost() {
		if (host != null && host.eIsProxy()) {
			InternalEObject oldHost = (InternalEObject)host;
			host = (ComputingResource)eResolveProxy(oldHost);
			if (host != oldHost) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GRMPackage.SCHEDULER__HOST, oldHost, host));
			}
		}
		return host;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComputingResource basicGetHost() {
		return host;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHost(ComputingResource newHost) {
		ComputingResource oldHost = host;
		host = newHost;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GRMPackage.SCHEDULER__HOST, oldHost, host));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MutualExclusionResource> getProtectedSharedResources() {
		if (protectedSharedResources == null) {
			protectedSharedResources = new EObjectWithInverseResolvingEList<MutualExclusionResource>(MutualExclusionResource.class, this, GRMPackage.SCHEDULER__PROTECTED_SHARED_RESOURCES, GRMPackage.MUTUAL_EXCLUSION_RESOURCE__SCHEDULER);
		}
		return protectedSharedResources;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SchedulableResource> getSchedulableResources() {
		if (schedulableResources == null) {
			schedulableResources = new EObjectWithInverseResolvingEList<SchedulableResource>(SchedulableResource.class, this, GRMPackage.SCHEDULER__SCHEDULABLE_RESOURCES, GRMPackage.SCHEDULABLE_RESOURCE__HOST);
		}
		return schedulableResources;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GRMPackage.SCHEDULER__PROTECTED_SHARED_RESOURCES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getProtectedSharedResources()).basicAdd(otherEnd, msgs);
			case GRMPackage.SCHEDULER__SCHEDULABLE_RESOURCES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSchedulableResources()).basicAdd(otherEnd, msgs);
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
			case GRMPackage.SCHEDULER__PROTECTED_SHARED_RESOURCES:
				return ((InternalEList<?>)getProtectedSharedResources()).basicRemove(otherEnd, msgs);
			case GRMPackage.SCHEDULER__SCHEDULABLE_RESOURCES:
				return ((InternalEList<?>)getSchedulableResources()).basicRemove(otherEnd, msgs);
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
			case GRMPackage.SCHEDULER__IS_PREEMPTIBLE:
				return isIsPreemptible();
			case GRMPackage.SCHEDULER__SCHED_POLICY:
				return getSchedPolicy();
			case GRMPackage.SCHEDULER__OTHER_SCHED_POLICY:
				return getOtherSchedPolicy();
			case GRMPackage.SCHEDULER__SCHEDULE:
				return getSchedule();
			case GRMPackage.SCHEDULER__PROCESSING_UNITS:
				return getProcessingUnits();
			case GRMPackage.SCHEDULER__HOST:
				if (resolve) return getHost();
				return basicGetHost();
			case GRMPackage.SCHEDULER__PROTECTED_SHARED_RESOURCES:
				return getProtectedSharedResources();
			case GRMPackage.SCHEDULER__SCHEDULABLE_RESOURCES:
				return getSchedulableResources();
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
			case GRMPackage.SCHEDULER__IS_PREEMPTIBLE:
				setIsPreemptible((Boolean)newValue);
				return;
			case GRMPackage.SCHEDULER__SCHED_POLICY:
				setSchedPolicy((SchedPolicyKind)newValue);
				return;
			case GRMPackage.SCHEDULER__OTHER_SCHED_POLICY:
				setOtherSchedPolicy((String)newValue);
				return;
			case GRMPackage.SCHEDULER__SCHEDULE:
				setSchedule((String)newValue);
				return;
			case GRMPackage.SCHEDULER__PROCESSING_UNITS:
				getProcessingUnits().clear();
				getProcessingUnits().addAll((Collection<? extends ProcessingResource>)newValue);
				return;
			case GRMPackage.SCHEDULER__HOST:
				setHost((ComputingResource)newValue);
				return;
			case GRMPackage.SCHEDULER__PROTECTED_SHARED_RESOURCES:
				getProtectedSharedResources().clear();
				getProtectedSharedResources().addAll((Collection<? extends MutualExclusionResource>)newValue);
				return;
			case GRMPackage.SCHEDULER__SCHEDULABLE_RESOURCES:
				getSchedulableResources().clear();
				getSchedulableResources().addAll((Collection<? extends SchedulableResource>)newValue);
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
			case GRMPackage.SCHEDULER__IS_PREEMPTIBLE:
				setIsPreemptible(IS_PREEMPTIBLE_EDEFAULT);
				return;
			case GRMPackage.SCHEDULER__SCHED_POLICY:
				setSchedPolicy(SCHED_POLICY_EDEFAULT);
				return;
			case GRMPackage.SCHEDULER__OTHER_SCHED_POLICY:
				setOtherSchedPolicy(OTHER_SCHED_POLICY_EDEFAULT);
				return;
			case GRMPackage.SCHEDULER__SCHEDULE:
				setSchedule(SCHEDULE_EDEFAULT);
				return;
			case GRMPackage.SCHEDULER__PROCESSING_UNITS:
				getProcessingUnits().clear();
				return;
			case GRMPackage.SCHEDULER__HOST:
				setHost((ComputingResource)null);
				return;
			case GRMPackage.SCHEDULER__PROTECTED_SHARED_RESOURCES:
				getProtectedSharedResources().clear();
				return;
			case GRMPackage.SCHEDULER__SCHEDULABLE_RESOURCES:
				getSchedulableResources().clear();
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
			case GRMPackage.SCHEDULER__IS_PREEMPTIBLE:
				return isPreemptible != IS_PREEMPTIBLE_EDEFAULT;
			case GRMPackage.SCHEDULER__SCHED_POLICY:
				return schedPolicy != SCHED_POLICY_EDEFAULT;
			case GRMPackage.SCHEDULER__OTHER_SCHED_POLICY:
				return OTHER_SCHED_POLICY_EDEFAULT == null ? otherSchedPolicy != null : !OTHER_SCHED_POLICY_EDEFAULT.equals(otherSchedPolicy);
			case GRMPackage.SCHEDULER__SCHEDULE:
				return SCHEDULE_EDEFAULT == null ? schedule != null : !SCHEDULE_EDEFAULT.equals(schedule);
			case GRMPackage.SCHEDULER__PROCESSING_UNITS:
				return processingUnits != null && !processingUnits.isEmpty();
			case GRMPackage.SCHEDULER__HOST:
				return host != null;
			case GRMPackage.SCHEDULER__PROTECTED_SHARED_RESOURCES:
				return protectedSharedResources != null && !protectedSharedResources.isEmpty();
			case GRMPackage.SCHEDULER__SCHEDULABLE_RESOURCES:
				return schedulableResources != null && !schedulableResources.isEmpty();
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
		result.append(" (isPreemptible: ");
		result.append(isPreemptible);
		result.append(", schedPolicy: ");
		result.append(schedPolicy);
		result.append(", otherSchedPolicy: ");
		result.append(otherSchedPolicy);
		result.append(", schedule: ");
		result.append(schedule);
		result.append(')');
		return result.toString();
	}

} //SchedulerImpl
