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
package org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.ConcurrentAccessProtocolKind;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.MutualExclusionResourceKind;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SW_InteractionPackage;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SwMutualExclusionResource;

import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.GRMPackage;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.MutualExclusionResource;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Scheduler;

import org.eclipse.papyrus.MARTE_Library.GRM_BasicTypes.ProtectProtocolKind;

import org.eclipse.uml2.uml.BehavioralFeature;
import org.eclipse.uml2.uml.TypedElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sw Mutual Exclusion Resource</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.impl.SwMutualExclusionResourceImpl#getProtectKind <em>Protect Kind</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.impl.SwMutualExclusionResourceImpl#getCeiling <em>Ceiling</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.impl.SwMutualExclusionResourceImpl#getOtherProtectProtocol <em>Other Protect Protocol</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.impl.SwMutualExclusionResourceImpl#getScheduler <em>Scheduler</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.impl.SwMutualExclusionResourceImpl#getMechanism <em>Mechanism</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.impl.SwMutualExclusionResourceImpl#getConcurrentAccessProtocol <em>Concurrent Access Protocol</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.impl.SwMutualExclusionResourceImpl#getAccessTokenElements <em>Access Token Elements</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.impl.SwMutualExclusionResourceImpl#getReleaseServices <em>Release Services</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.impl.SwMutualExclusionResourceImpl#getAcquireServices <em>Acquire Services</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SwMutualExclusionResourceImpl extends SwSynchronizationResourceImpl implements SwMutualExclusionResource {
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
	 * The default value of the '{@link #getMechanism() <em>Mechanism</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMechanism()
	 * @generated
	 * @ordered
	 */
	protected static final MutualExclusionResourceKind MECHANISM_EDEFAULT = MutualExclusionResourceKind.BOOLEAN_SEMAPHORE;

	/**
	 * The cached value of the '{@link #getMechanism() <em>Mechanism</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMechanism()
	 * @generated
	 * @ordered
	 */
	protected MutualExclusionResourceKind mechanism = MECHANISM_EDEFAULT;

	/**
	 * The default value of the '{@link #getConcurrentAccessProtocol() <em>Concurrent Access Protocol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConcurrentAccessProtocol()
	 * @generated
	 * @ordered
	 */
	protected static final ConcurrentAccessProtocolKind CONCURRENT_ACCESS_PROTOCOL_EDEFAULT = ConcurrentAccessProtocolKind.PIP;

	/**
	 * The cached value of the '{@link #getConcurrentAccessProtocol() <em>Concurrent Access Protocol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConcurrentAccessProtocol()
	 * @generated
	 * @ordered
	 */
	protected ConcurrentAccessProtocolKind concurrentAccessProtocol = CONCURRENT_ACCESS_PROTOCOL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAccessTokenElements() <em>Access Token Elements</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccessTokenElements()
	 * @generated
	 * @ordered
	 */
	protected EList<TypedElement> accessTokenElements;

	/**
	 * The cached value of the '{@link #getReleaseServices() <em>Release Services</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReleaseServices()
	 * @generated
	 * @ordered
	 */
	protected EList<BehavioralFeature> releaseServices;

	/**
	 * The cached value of the '{@link #getAcquireServices() <em>Acquire Services</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAcquireServices()
	 * @generated
	 * @ordered
	 */
	protected EList<BehavioralFeature> acquireServices;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SwMutualExclusionResourceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SW_InteractionPackage.Literals.SW_MUTUAL_EXCLUSION_RESOURCE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, SW_InteractionPackage.SW_MUTUAL_EXCLUSION_RESOURCE__PROTECT_KIND, oldProtectKind, protectKind));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SW_InteractionPackage.SW_MUTUAL_EXCLUSION_RESOURCE__CEILING, oldCeiling, ceiling));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SW_InteractionPackage.SW_MUTUAL_EXCLUSION_RESOURCE__OTHER_PROTECT_PROTOCOL, oldOtherProtectProtocol, otherProtectProtocol));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SW_InteractionPackage.SW_MUTUAL_EXCLUSION_RESOURCE__SCHEDULER, oldScheduler, scheduler));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SW_InteractionPackage.SW_MUTUAL_EXCLUSION_RESOURCE__SCHEDULER, oldScheduler, newScheduler);
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
			eNotify(new ENotificationImpl(this, Notification.SET, SW_InteractionPackage.SW_MUTUAL_EXCLUSION_RESOURCE__SCHEDULER, newScheduler, newScheduler));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MutualExclusionResourceKind getMechanism() {
		return mechanism;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMechanism(MutualExclusionResourceKind newMechanism) {
		MutualExclusionResourceKind oldMechanism = mechanism;
		mechanism = newMechanism == null ? MECHANISM_EDEFAULT : newMechanism;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SW_InteractionPackage.SW_MUTUAL_EXCLUSION_RESOURCE__MECHANISM, oldMechanism, mechanism));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConcurrentAccessProtocolKind getConcurrentAccessProtocol() {
		return concurrentAccessProtocol;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConcurrentAccessProtocol(ConcurrentAccessProtocolKind newConcurrentAccessProtocol) {
		ConcurrentAccessProtocolKind oldConcurrentAccessProtocol = concurrentAccessProtocol;
		concurrentAccessProtocol = newConcurrentAccessProtocol == null ? CONCURRENT_ACCESS_PROTOCOL_EDEFAULT : newConcurrentAccessProtocol;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SW_InteractionPackage.SW_MUTUAL_EXCLUSION_RESOURCE__CONCURRENT_ACCESS_PROTOCOL, oldConcurrentAccessProtocol, concurrentAccessProtocol));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TypedElement> getAccessTokenElements() {
		if (accessTokenElements == null) {
			accessTokenElements = new EObjectResolvingEList<TypedElement>(TypedElement.class, this, SW_InteractionPackage.SW_MUTUAL_EXCLUSION_RESOURCE__ACCESS_TOKEN_ELEMENTS);
		}
		return accessTokenElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BehavioralFeature> getReleaseServices() {
		if (releaseServices == null) {
			releaseServices = new EObjectResolvingEList<BehavioralFeature>(BehavioralFeature.class, this, SW_InteractionPackage.SW_MUTUAL_EXCLUSION_RESOURCE__RELEASE_SERVICES);
		}
		return releaseServices;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BehavioralFeature> getAcquireServices() {
		if (acquireServices == null) {
			acquireServices = new EObjectResolvingEList<BehavioralFeature>(BehavioralFeature.class, this, SW_InteractionPackage.SW_MUTUAL_EXCLUSION_RESOURCE__ACQUIRE_SERVICES);
		}
		return acquireServices;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SW_InteractionPackage.SW_MUTUAL_EXCLUSION_RESOURCE__SCHEDULER:
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
			case SW_InteractionPackage.SW_MUTUAL_EXCLUSION_RESOURCE__SCHEDULER:
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
			case SW_InteractionPackage.SW_MUTUAL_EXCLUSION_RESOURCE__PROTECT_KIND:
				return getProtectKind();
			case SW_InteractionPackage.SW_MUTUAL_EXCLUSION_RESOURCE__CEILING:
				return getCeiling();
			case SW_InteractionPackage.SW_MUTUAL_EXCLUSION_RESOURCE__OTHER_PROTECT_PROTOCOL:
				return getOtherProtectProtocol();
			case SW_InteractionPackage.SW_MUTUAL_EXCLUSION_RESOURCE__SCHEDULER:
				if (resolve) return getScheduler();
				return basicGetScheduler();
			case SW_InteractionPackage.SW_MUTUAL_EXCLUSION_RESOURCE__MECHANISM:
				return getMechanism();
			case SW_InteractionPackage.SW_MUTUAL_EXCLUSION_RESOURCE__CONCURRENT_ACCESS_PROTOCOL:
				return getConcurrentAccessProtocol();
			case SW_InteractionPackage.SW_MUTUAL_EXCLUSION_RESOURCE__ACCESS_TOKEN_ELEMENTS:
				return getAccessTokenElements();
			case SW_InteractionPackage.SW_MUTUAL_EXCLUSION_RESOURCE__RELEASE_SERVICES:
				return getReleaseServices();
			case SW_InteractionPackage.SW_MUTUAL_EXCLUSION_RESOURCE__ACQUIRE_SERVICES:
				return getAcquireServices();
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
			case SW_InteractionPackage.SW_MUTUAL_EXCLUSION_RESOURCE__PROTECT_KIND:
				setProtectKind((ProtectProtocolKind)newValue);
				return;
			case SW_InteractionPackage.SW_MUTUAL_EXCLUSION_RESOURCE__CEILING:
				setCeiling((String)newValue);
				return;
			case SW_InteractionPackage.SW_MUTUAL_EXCLUSION_RESOURCE__OTHER_PROTECT_PROTOCOL:
				setOtherProtectProtocol((String)newValue);
				return;
			case SW_InteractionPackage.SW_MUTUAL_EXCLUSION_RESOURCE__SCHEDULER:
				setScheduler((Scheduler)newValue);
				return;
			case SW_InteractionPackage.SW_MUTUAL_EXCLUSION_RESOURCE__MECHANISM:
				setMechanism((MutualExclusionResourceKind)newValue);
				return;
			case SW_InteractionPackage.SW_MUTUAL_EXCLUSION_RESOURCE__CONCURRENT_ACCESS_PROTOCOL:
				setConcurrentAccessProtocol((ConcurrentAccessProtocolKind)newValue);
				return;
			case SW_InteractionPackage.SW_MUTUAL_EXCLUSION_RESOURCE__ACCESS_TOKEN_ELEMENTS:
				getAccessTokenElements().clear();
				getAccessTokenElements().addAll((Collection<? extends TypedElement>)newValue);
				return;
			case SW_InteractionPackage.SW_MUTUAL_EXCLUSION_RESOURCE__RELEASE_SERVICES:
				getReleaseServices().clear();
				getReleaseServices().addAll((Collection<? extends BehavioralFeature>)newValue);
				return;
			case SW_InteractionPackage.SW_MUTUAL_EXCLUSION_RESOURCE__ACQUIRE_SERVICES:
				getAcquireServices().clear();
				getAcquireServices().addAll((Collection<? extends BehavioralFeature>)newValue);
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
			case SW_InteractionPackage.SW_MUTUAL_EXCLUSION_RESOURCE__PROTECT_KIND:
				setProtectKind(PROTECT_KIND_EDEFAULT);
				return;
			case SW_InteractionPackage.SW_MUTUAL_EXCLUSION_RESOURCE__CEILING:
				setCeiling(CEILING_EDEFAULT);
				return;
			case SW_InteractionPackage.SW_MUTUAL_EXCLUSION_RESOURCE__OTHER_PROTECT_PROTOCOL:
				setOtherProtectProtocol(OTHER_PROTECT_PROTOCOL_EDEFAULT);
				return;
			case SW_InteractionPackage.SW_MUTUAL_EXCLUSION_RESOURCE__SCHEDULER:
				setScheduler((Scheduler)null);
				return;
			case SW_InteractionPackage.SW_MUTUAL_EXCLUSION_RESOURCE__MECHANISM:
				setMechanism(MECHANISM_EDEFAULT);
				return;
			case SW_InteractionPackage.SW_MUTUAL_EXCLUSION_RESOURCE__CONCURRENT_ACCESS_PROTOCOL:
				setConcurrentAccessProtocol(CONCURRENT_ACCESS_PROTOCOL_EDEFAULT);
				return;
			case SW_InteractionPackage.SW_MUTUAL_EXCLUSION_RESOURCE__ACCESS_TOKEN_ELEMENTS:
				getAccessTokenElements().clear();
				return;
			case SW_InteractionPackage.SW_MUTUAL_EXCLUSION_RESOURCE__RELEASE_SERVICES:
				getReleaseServices().clear();
				return;
			case SW_InteractionPackage.SW_MUTUAL_EXCLUSION_RESOURCE__ACQUIRE_SERVICES:
				getAcquireServices().clear();
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
			case SW_InteractionPackage.SW_MUTUAL_EXCLUSION_RESOURCE__PROTECT_KIND:
				return protectKind != PROTECT_KIND_EDEFAULT;
			case SW_InteractionPackage.SW_MUTUAL_EXCLUSION_RESOURCE__CEILING:
				return CEILING_EDEFAULT == null ? ceiling != null : !CEILING_EDEFAULT.equals(ceiling);
			case SW_InteractionPackage.SW_MUTUAL_EXCLUSION_RESOURCE__OTHER_PROTECT_PROTOCOL:
				return OTHER_PROTECT_PROTOCOL_EDEFAULT == null ? otherProtectProtocol != null : !OTHER_PROTECT_PROTOCOL_EDEFAULT.equals(otherProtectProtocol);
			case SW_InteractionPackage.SW_MUTUAL_EXCLUSION_RESOURCE__SCHEDULER:
				return scheduler != null;
			case SW_InteractionPackage.SW_MUTUAL_EXCLUSION_RESOURCE__MECHANISM:
				return mechanism != MECHANISM_EDEFAULT;
			case SW_InteractionPackage.SW_MUTUAL_EXCLUSION_RESOURCE__CONCURRENT_ACCESS_PROTOCOL:
				return concurrentAccessProtocol != CONCURRENT_ACCESS_PROTOCOL_EDEFAULT;
			case SW_InteractionPackage.SW_MUTUAL_EXCLUSION_RESOURCE__ACCESS_TOKEN_ELEMENTS:
				return accessTokenElements != null && !accessTokenElements.isEmpty();
			case SW_InteractionPackage.SW_MUTUAL_EXCLUSION_RESOURCE__RELEASE_SERVICES:
				return releaseServices != null && !releaseServices.isEmpty();
			case SW_InteractionPackage.SW_MUTUAL_EXCLUSION_RESOURCE__ACQUIRE_SERVICES:
				return acquireServices != null && !acquireServices.isEmpty();
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
		if (baseClass == MutualExclusionResource.class) {
			switch (derivedFeatureID) {
				case SW_InteractionPackage.SW_MUTUAL_EXCLUSION_RESOURCE__PROTECT_KIND: return GRMPackage.MUTUAL_EXCLUSION_RESOURCE__PROTECT_KIND;
				case SW_InteractionPackage.SW_MUTUAL_EXCLUSION_RESOURCE__CEILING: return GRMPackage.MUTUAL_EXCLUSION_RESOURCE__CEILING;
				case SW_InteractionPackage.SW_MUTUAL_EXCLUSION_RESOURCE__OTHER_PROTECT_PROTOCOL: return GRMPackage.MUTUAL_EXCLUSION_RESOURCE__OTHER_PROTECT_PROTOCOL;
				case SW_InteractionPackage.SW_MUTUAL_EXCLUSION_RESOURCE__SCHEDULER: return GRMPackage.MUTUAL_EXCLUSION_RESOURCE__SCHEDULER;
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
		if (baseClass == MutualExclusionResource.class) {
			switch (baseFeatureID) {
				case GRMPackage.MUTUAL_EXCLUSION_RESOURCE__PROTECT_KIND: return SW_InteractionPackage.SW_MUTUAL_EXCLUSION_RESOURCE__PROTECT_KIND;
				case GRMPackage.MUTUAL_EXCLUSION_RESOURCE__CEILING: return SW_InteractionPackage.SW_MUTUAL_EXCLUSION_RESOURCE__CEILING;
				case GRMPackage.MUTUAL_EXCLUSION_RESOURCE__OTHER_PROTECT_PROTOCOL: return SW_InteractionPackage.SW_MUTUAL_EXCLUSION_RESOURCE__OTHER_PROTECT_PROTOCOL;
				case GRMPackage.MUTUAL_EXCLUSION_RESOURCE__SCHEDULER: return SW_InteractionPackage.SW_MUTUAL_EXCLUSION_RESOURCE__SCHEDULER;
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
		result.append(" (protectKind: ");
		result.append(protectKind);
		result.append(", ceiling: ");
		result.append(ceiling);
		result.append(", otherProtectProtocol: ");
		result.append(otherProtectProtocol);
		result.append(", mechanism: ");
		result.append(mechanism);
		result.append(", concurrentAccessProtocol: ");
		result.append(concurrentAccessProtocol);
		result.append(')');
		return result.toString();
	}

} //SwMutualExclusionResourceImpl
