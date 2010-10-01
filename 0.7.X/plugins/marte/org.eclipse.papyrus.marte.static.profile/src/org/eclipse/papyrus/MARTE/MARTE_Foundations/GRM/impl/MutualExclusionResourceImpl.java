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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.GRMPackage;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.MutualExclusionResource;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Scheduler;

import org.eclipse.papyrus.MARTE_Library.GRM_BasicTypes.ProtectProtocolKind;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mutual Exclusion Resource</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.MutualExclusionResourceImpl#getProtectKind <em>Protect Kind</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.MutualExclusionResourceImpl#getCeiling <em>Ceiling</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.MutualExclusionResourceImpl#getOtherProtectProtocol <em>Other Protect Protocol</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.MutualExclusionResourceImpl#getScheduler <em>Scheduler</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MutualExclusionResourceImpl extends ResourceImpl implements MutualExclusionResource {
	/**
	 * The default value of the '{@link #getProtectKind() <em>Protect Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProtectKind()
	 * @generated
	 * @ordered
	 */
	protected static final ProtectProtocolKind PROTECT_KIND_EDEFAULT = ProtectProtocolKind.PRIORITY_INHERITANCE;

	/**
	 * The cached value of the '{@link #getProtectKind() <em>Protect Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProtectKind()
	 * @generated
	 * @ordered
	 */
	protected ProtectProtocolKind protectKind = PROTECT_KIND_EDEFAULT;

	/**
	 * The default value of the '{@link #getCeiling() <em>Ceiling</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCeiling()
	 * @generated
	 * @ordered
	 */
	protected static final String CEILING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCeiling() <em>Ceiling</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCeiling()
	 * @generated
	 * @ordered
	 */
	protected String ceiling = CEILING_EDEFAULT;

	/**
	 * The default value of the '{@link #getOtherProtectProtocol() <em>Other Protect Protocol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOtherProtectProtocol()
	 * @generated
	 * @ordered
	 */
	protected static final String OTHER_PROTECT_PROTOCOL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOtherProtectProtocol() <em>Other Protect Protocol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOtherProtectProtocol()
	 * @generated
	 * @ordered
	 */
	protected String otherProtectProtocol = OTHER_PROTECT_PROTOCOL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getScheduler() <em>Scheduler</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScheduler()
	 * @generated
	 * @ordered
	 */
	protected Scheduler scheduler;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MutualExclusionResourceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GRMPackage.Literals.MUTUAL_EXCLUSION_RESOURCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProtectProtocolKind getProtectKind() {
		return protectKind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProtectKind(ProtectProtocolKind newProtectKind) {
		ProtectProtocolKind oldProtectKind = protectKind;
		protectKind = newProtectKind == null ? PROTECT_KIND_EDEFAULT : newProtectKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GRMPackage.MUTUAL_EXCLUSION_RESOURCE__PROTECT_KIND, oldProtectKind, protectKind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCeiling() {
		return ceiling;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCeiling(String newCeiling) {
		String oldCeiling = ceiling;
		ceiling = newCeiling;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GRMPackage.MUTUAL_EXCLUSION_RESOURCE__CEILING, oldCeiling, ceiling));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOtherProtectProtocol() {
		return otherProtectProtocol;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOtherProtectProtocol(String newOtherProtectProtocol) {
		String oldOtherProtectProtocol = otherProtectProtocol;
		otherProtectProtocol = newOtherProtectProtocol;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GRMPackage.MUTUAL_EXCLUSION_RESOURCE__OTHER_PROTECT_PROTOCOL, oldOtherProtectProtocol, otherProtectProtocol));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Scheduler getScheduler() {
		if (scheduler != null && scheduler.eIsProxy()) {
			InternalEObject oldScheduler = (InternalEObject)scheduler;
			scheduler = (Scheduler)eResolveProxy(oldScheduler);
			if (scheduler != oldScheduler) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GRMPackage.MUTUAL_EXCLUSION_RESOURCE__SCHEDULER, oldScheduler, scheduler));
			}
		}
		return scheduler;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Scheduler basicGetScheduler() {
		return scheduler;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetScheduler(Scheduler newScheduler, NotificationChain msgs) {
		Scheduler oldScheduler = scheduler;
		scheduler = newScheduler;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GRMPackage.MUTUAL_EXCLUSION_RESOURCE__SCHEDULER, oldScheduler, newScheduler);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScheduler(Scheduler newScheduler) {
		if (newScheduler != scheduler) {
			NotificationChain msgs = null;
			if (scheduler != null)
				msgs = ((InternalEObject)scheduler).eInverseRemove(this, GRMPackage.SCHEDULER__PROTECTED_SHARED_RESOURCES, Scheduler.class, msgs);
			if (newScheduler != null)
				msgs = ((InternalEObject)newScheduler).eInverseAdd(this, GRMPackage.SCHEDULER__PROTECTED_SHARED_RESOURCES, Scheduler.class, msgs);
			msgs = basicSetScheduler(newScheduler, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GRMPackage.MUTUAL_EXCLUSION_RESOURCE__SCHEDULER, newScheduler, newScheduler));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GRMPackage.MUTUAL_EXCLUSION_RESOURCE__SCHEDULER:
				if (scheduler != null)
					msgs = ((InternalEObject)scheduler).eInverseRemove(this, GRMPackage.SCHEDULER__PROTECTED_SHARED_RESOURCES, Scheduler.class, msgs);
				return basicSetScheduler((Scheduler)otherEnd, msgs);
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
			case GRMPackage.MUTUAL_EXCLUSION_RESOURCE__SCHEDULER:
				return basicSetScheduler(null, msgs);
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
			case GRMPackage.MUTUAL_EXCLUSION_RESOURCE__PROTECT_KIND:
				return getProtectKind();
			case GRMPackage.MUTUAL_EXCLUSION_RESOURCE__CEILING:
				return getCeiling();
			case GRMPackage.MUTUAL_EXCLUSION_RESOURCE__OTHER_PROTECT_PROTOCOL:
				return getOtherProtectProtocol();
			case GRMPackage.MUTUAL_EXCLUSION_RESOURCE__SCHEDULER:
				if (resolve) return getScheduler();
				return basicGetScheduler();
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
			case GRMPackage.MUTUAL_EXCLUSION_RESOURCE__PROTECT_KIND:
				setProtectKind((ProtectProtocolKind)newValue);
				return;
			case GRMPackage.MUTUAL_EXCLUSION_RESOURCE__CEILING:
				setCeiling((String)newValue);
				return;
			case GRMPackage.MUTUAL_EXCLUSION_RESOURCE__OTHER_PROTECT_PROTOCOL:
				setOtherProtectProtocol((String)newValue);
				return;
			case GRMPackage.MUTUAL_EXCLUSION_RESOURCE__SCHEDULER:
				setScheduler((Scheduler)newValue);
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
			case GRMPackage.MUTUAL_EXCLUSION_RESOURCE__PROTECT_KIND:
				setProtectKind(PROTECT_KIND_EDEFAULT);
				return;
			case GRMPackage.MUTUAL_EXCLUSION_RESOURCE__CEILING:
				setCeiling(CEILING_EDEFAULT);
				return;
			case GRMPackage.MUTUAL_EXCLUSION_RESOURCE__OTHER_PROTECT_PROTOCOL:
				setOtherProtectProtocol(OTHER_PROTECT_PROTOCOL_EDEFAULT);
				return;
			case GRMPackage.MUTUAL_EXCLUSION_RESOURCE__SCHEDULER:
				setScheduler((Scheduler)null);
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
			case GRMPackage.MUTUAL_EXCLUSION_RESOURCE__PROTECT_KIND:
				return protectKind != PROTECT_KIND_EDEFAULT;
			case GRMPackage.MUTUAL_EXCLUSION_RESOURCE__CEILING:
				return CEILING_EDEFAULT == null ? ceiling != null : !CEILING_EDEFAULT.equals(ceiling);
			case GRMPackage.MUTUAL_EXCLUSION_RESOURCE__OTHER_PROTECT_PROTOCOL:
				return OTHER_PROTECT_PROTOCOL_EDEFAULT == null ? otherProtectProtocol != null : !OTHER_PROTECT_PROTOCOL_EDEFAULT.equals(otherProtectProtocol);
			case GRMPackage.MUTUAL_EXCLUSION_RESOURCE__SCHEDULER:
				return scheduler != null;
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
		result.append(" (protectKind: ");
		result.append(protectKind);
		result.append(", ceiling: ");
		result.append(ceiling);
		result.append(", otherProtectProtocol: ");
		result.append(otherProtectProtocol);
		result.append(')');
		return result.toString();
	}

} //MutualExclusionResourceImpl
