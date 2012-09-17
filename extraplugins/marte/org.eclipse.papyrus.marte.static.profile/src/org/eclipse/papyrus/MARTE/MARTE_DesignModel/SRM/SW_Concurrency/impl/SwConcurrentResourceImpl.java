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
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SW_ConcurrencyPackage;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SwConcurrentResource;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_ResourceCore.impl.SwResourceImpl;
import org.eclipse.uml2.uml.BehavioralFeature;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.TypedElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sw Concurrent Resource</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.impl.SwConcurrentResourceImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.impl.SwConcurrentResourceImpl#getActivationCapacity <em>Activation Capacity</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.impl.SwConcurrentResourceImpl#getEntryPoints <em>Entry Points</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.impl.SwConcurrentResourceImpl#getAdressSpace <em>Adress Space</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.impl.SwConcurrentResourceImpl#getPeriodElements <em>Period Elements</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.impl.SwConcurrentResourceImpl#getPriorityElements <em>Priority Elements</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.impl.SwConcurrentResourceImpl#getStackSizeElements <em>Stack Size Elements</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.impl.SwConcurrentResourceImpl#getActivateServices <em>Activate Services</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.impl.SwConcurrentResourceImpl#getEnableConcurrencyServices <em>Enable Concurrency Services</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.impl.SwConcurrentResourceImpl#getResumeServices <em>Resume Services</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.impl.SwConcurrentResourceImpl#getSuspendServices <em>Suspend Services</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.impl.SwConcurrentResourceImpl#getTerminateServices <em>Terminate Services</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.impl.SwConcurrentResourceImpl#getDisableConcurrencyServices <em>Disable Concurrency Services</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.impl.SwConcurrentResourceImpl#getShareDataResources <em>Share Data Resources</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.impl.SwConcurrentResourceImpl#getMessageResources <em>Message Resources</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.impl.SwConcurrentResourceImpl#getMutualExclusionResources <em>Mutual Exclusion Resources</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.impl.SwConcurrentResourceImpl#getNotificationResources <em>Notification Resources</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.impl.SwConcurrentResourceImpl#getHeapSizeElements <em>Heap Size Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class SwConcurrentResourceImpl extends SwResourceImpl implements SwConcurrentResource {
	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected String type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getActivationCapacity() <em>Activation Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActivationCapacity()
	 * @generated
	 * @ordered
	 */
	protected static final int ACTIVATION_CAPACITY_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getActivationCapacity() <em>Activation Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActivationCapacity()
	 * @generated
	 * @ordered
	 */
	protected int activationCapacity = ACTIVATION_CAPACITY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEntryPoints() <em>Entry Points</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntryPoints()
	 * @generated
	 * @ordered
	 */
	protected EList<Element> entryPoints;

	/**
	 * The cached value of the '{@link #getAdressSpace() <em>Adress Space</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdressSpace()
	 * @generated
	 * @ordered
	 */
	protected EList<TypedElement> adressSpace;

	/**
	 * The cached value of the '{@link #getPeriodElements() <em>Period Elements</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPeriodElements()
	 * @generated
	 * @ordered
	 */
	protected EList<TypedElement> periodElements;

	/**
	 * The cached value of the '{@link #getPriorityElements() <em>Priority Elements</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPriorityElements()
	 * @generated
	 * @ordered
	 */
	protected EList<TypedElement> priorityElements;

	/**
	 * The cached value of the '{@link #getStackSizeElements() <em>Stack Size Elements</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStackSizeElements()
	 * @generated
	 * @ordered
	 */
	protected EList<TypedElement> stackSizeElements;

	/**
	 * The cached value of the '{@link #getActivateServices() <em>Activate Services</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActivateServices()
	 * @generated
	 * @ordered
	 */
	protected EList<BehavioralFeature> activateServices;

	/**
	 * The cached value of the '{@link #getEnableConcurrencyServices() <em>Enable Concurrency Services</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnableConcurrencyServices()
	 * @generated
	 * @ordered
	 */
	protected EList<BehavioralFeature> enableConcurrencyServices;

	/**
	 * The cached value of the '{@link #getResumeServices() <em>Resume Services</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResumeServices()
	 * @generated
	 * @ordered
	 */
	protected EList<BehavioralFeature> resumeServices;

	/**
	 * The cached value of the '{@link #getSuspendServices() <em>Suspend Services</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuspendServices()
	 * @generated
	 * @ordered
	 */
	protected EList<BehavioralFeature> suspendServices;

	/**
	 * The cached value of the '{@link #getTerminateServices() <em>Terminate Services</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTerminateServices()
	 * @generated
	 * @ordered
	 */
	protected EList<BehavioralFeature> terminateServices;

	/**
	 * The cached value of the '{@link #getDisableConcurrencyServices() <em>Disable Concurrency Services</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDisableConcurrencyServices()
	 * @generated
	 * @ordered
	 */
	protected EList<BehavioralFeature> disableConcurrencyServices;

	/**
	 * The cached value of the '{@link #getShareDataResources() <em>Share Data Resources</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShareDataResources()
	 * @generated
	 * @ordered
	 */
	protected EList<TypedElement> shareDataResources;

	/**
	 * The cached value of the '{@link #getMessageResources() <em>Message Resources</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessageResources()
	 * @generated
	 * @ordered
	 */
	protected EList<TypedElement> messageResources;

	/**
	 * The cached value of the '{@link #getMutualExclusionResources() <em>Mutual Exclusion Resources</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMutualExclusionResources()
	 * @generated
	 * @ordered
	 */
	protected EList<TypedElement> mutualExclusionResources;

	/**
	 * The cached value of the '{@link #getNotificationResources() <em>Notification Resources</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNotificationResources()
	 * @generated
	 * @ordered
	 */
	protected EList<TypedElement> notificationResources;

	/**
	 * The cached value of the '{@link #getHeapSizeElements() <em>Heap Size Elements</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeapSizeElements()
	 * @generated
	 * @ordered
	 */
	protected EList<TypedElement> heapSizeElements;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SwConcurrentResourceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SW_ConcurrencyPackage.Literals.SW_CONCURRENT_RESOURCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(String newType) {
		String oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getActivationCapacity() {
		return activationCapacity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActivationCapacity(int newActivationCapacity) {
		int oldActivationCapacity = activationCapacity;
		activationCapacity = newActivationCapacity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__ACTIVATION_CAPACITY, oldActivationCapacity, activationCapacity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Element> getEntryPoints() {
		if (entryPoints == null) {
			entryPoints = new EObjectResolvingEList<Element>(Element.class, this, SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__ENTRY_POINTS);
		}
		return entryPoints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TypedElement> getAdressSpace() {
		if (adressSpace == null) {
			adressSpace = new EObjectResolvingEList<TypedElement>(TypedElement.class, this, SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__ADRESS_SPACE);
		}
		return adressSpace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TypedElement> getPeriodElements() {
		if (periodElements == null) {
			periodElements = new EObjectResolvingEList<TypedElement>(TypedElement.class, this, SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__PERIOD_ELEMENTS);
		}
		return periodElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TypedElement> getPriorityElements() {
		if (priorityElements == null) {
			priorityElements = new EObjectResolvingEList<TypedElement>(TypedElement.class, this, SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__PRIORITY_ELEMENTS);
		}
		return priorityElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TypedElement> getStackSizeElements() {
		if (stackSizeElements == null) {
			stackSizeElements = new EObjectResolvingEList<TypedElement>(TypedElement.class, this, SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__STACK_SIZE_ELEMENTS);
		}
		return stackSizeElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BehavioralFeature> getActivateServices() {
		if (activateServices == null) {
			activateServices = new EObjectResolvingEList<BehavioralFeature>(BehavioralFeature.class, this, SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__ACTIVATE_SERVICES);
		}
		return activateServices;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BehavioralFeature> getEnableConcurrencyServices() {
		if (enableConcurrencyServices == null) {
			enableConcurrencyServices = new EObjectResolvingEList<BehavioralFeature>(BehavioralFeature.class, this, SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__ENABLE_CONCURRENCY_SERVICES);
		}
		return enableConcurrencyServices;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BehavioralFeature> getResumeServices() {
		if (resumeServices == null) {
			resumeServices = new EObjectResolvingEList<BehavioralFeature>(BehavioralFeature.class, this, SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__RESUME_SERVICES);
		}
		return resumeServices;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BehavioralFeature> getSuspendServices() {
		if (suspendServices == null) {
			suspendServices = new EObjectResolvingEList<BehavioralFeature>(BehavioralFeature.class, this, SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__SUSPEND_SERVICES);
		}
		return suspendServices;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BehavioralFeature> getTerminateServices() {
		if (terminateServices == null) {
			terminateServices = new EObjectResolvingEList<BehavioralFeature>(BehavioralFeature.class, this, SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__TERMINATE_SERVICES);
		}
		return terminateServices;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BehavioralFeature> getDisableConcurrencyServices() {
		if (disableConcurrencyServices == null) {
			disableConcurrencyServices = new EObjectResolvingEList<BehavioralFeature>(BehavioralFeature.class, this, SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__DISABLE_CONCURRENCY_SERVICES);
		}
		return disableConcurrencyServices;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TypedElement> getShareDataResources() {
		if (shareDataResources == null) {
			shareDataResources = new EObjectResolvingEList<TypedElement>(TypedElement.class, this, SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__SHARE_DATA_RESOURCES);
		}
		return shareDataResources;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TypedElement> getMessageResources() {
		if (messageResources == null) {
			messageResources = new EObjectResolvingEList<TypedElement>(TypedElement.class, this, SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__MESSAGE_RESOURCES);
		}
		return messageResources;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TypedElement> getMutualExclusionResources() {
		if (mutualExclusionResources == null) {
			mutualExclusionResources = new EObjectResolvingEList<TypedElement>(TypedElement.class, this, SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__MUTUAL_EXCLUSION_RESOURCES);
		}
		return mutualExclusionResources;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TypedElement> getNotificationResources() {
		if (notificationResources == null) {
			notificationResources = new EObjectResolvingEList<TypedElement>(TypedElement.class, this, SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__NOTIFICATION_RESOURCES);
		}
		return notificationResources;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TypedElement> getHeapSizeElements() {
		if (heapSizeElements == null) {
			heapSizeElements = new EObjectResolvingEList<TypedElement>(TypedElement.class, this, SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__HEAP_SIZE_ELEMENTS);
		}
		return heapSizeElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__TYPE:
				return getType();
			case SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__ACTIVATION_CAPACITY:
				return getActivationCapacity();
			case SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__ENTRY_POINTS:
				return getEntryPoints();
			case SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__ADRESS_SPACE:
				return getAdressSpace();
			case SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__PERIOD_ELEMENTS:
				return getPeriodElements();
			case SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__PRIORITY_ELEMENTS:
				return getPriorityElements();
			case SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__STACK_SIZE_ELEMENTS:
				return getStackSizeElements();
			case SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__ACTIVATE_SERVICES:
				return getActivateServices();
			case SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__ENABLE_CONCURRENCY_SERVICES:
				return getEnableConcurrencyServices();
			case SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__RESUME_SERVICES:
				return getResumeServices();
			case SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__SUSPEND_SERVICES:
				return getSuspendServices();
			case SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__TERMINATE_SERVICES:
				return getTerminateServices();
			case SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__DISABLE_CONCURRENCY_SERVICES:
				return getDisableConcurrencyServices();
			case SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__SHARE_DATA_RESOURCES:
				return getShareDataResources();
			case SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__MESSAGE_RESOURCES:
				return getMessageResources();
			case SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__MUTUAL_EXCLUSION_RESOURCES:
				return getMutualExclusionResources();
			case SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__NOTIFICATION_RESOURCES:
				return getNotificationResources();
			case SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__HEAP_SIZE_ELEMENTS:
				return getHeapSizeElements();
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
			case SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__TYPE:
				setType((String)newValue);
				return;
			case SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__ACTIVATION_CAPACITY:
				setActivationCapacity((Integer)newValue);
				return;
			case SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__ENTRY_POINTS:
				getEntryPoints().clear();
				getEntryPoints().addAll((Collection<? extends Element>)newValue);
				return;
			case SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__ADRESS_SPACE:
				getAdressSpace().clear();
				getAdressSpace().addAll((Collection<? extends TypedElement>)newValue);
				return;
			case SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__PERIOD_ELEMENTS:
				getPeriodElements().clear();
				getPeriodElements().addAll((Collection<? extends TypedElement>)newValue);
				return;
			case SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__PRIORITY_ELEMENTS:
				getPriorityElements().clear();
				getPriorityElements().addAll((Collection<? extends TypedElement>)newValue);
				return;
			case SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__STACK_SIZE_ELEMENTS:
				getStackSizeElements().clear();
				getStackSizeElements().addAll((Collection<? extends TypedElement>)newValue);
				return;
			case SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__ACTIVATE_SERVICES:
				getActivateServices().clear();
				getActivateServices().addAll((Collection<? extends BehavioralFeature>)newValue);
				return;
			case SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__ENABLE_CONCURRENCY_SERVICES:
				getEnableConcurrencyServices().clear();
				getEnableConcurrencyServices().addAll((Collection<? extends BehavioralFeature>)newValue);
				return;
			case SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__RESUME_SERVICES:
				getResumeServices().clear();
				getResumeServices().addAll((Collection<? extends BehavioralFeature>)newValue);
				return;
			case SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__SUSPEND_SERVICES:
				getSuspendServices().clear();
				getSuspendServices().addAll((Collection<? extends BehavioralFeature>)newValue);
				return;
			case SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__TERMINATE_SERVICES:
				getTerminateServices().clear();
				getTerminateServices().addAll((Collection<? extends BehavioralFeature>)newValue);
				return;
			case SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__DISABLE_CONCURRENCY_SERVICES:
				getDisableConcurrencyServices().clear();
				getDisableConcurrencyServices().addAll((Collection<? extends BehavioralFeature>)newValue);
				return;
			case SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__SHARE_DATA_RESOURCES:
				getShareDataResources().clear();
				getShareDataResources().addAll((Collection<? extends TypedElement>)newValue);
				return;
			case SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__MESSAGE_RESOURCES:
				getMessageResources().clear();
				getMessageResources().addAll((Collection<? extends TypedElement>)newValue);
				return;
			case SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__MUTUAL_EXCLUSION_RESOURCES:
				getMutualExclusionResources().clear();
				getMutualExclusionResources().addAll((Collection<? extends TypedElement>)newValue);
				return;
			case SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__NOTIFICATION_RESOURCES:
				getNotificationResources().clear();
				getNotificationResources().addAll((Collection<? extends TypedElement>)newValue);
				return;
			case SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__HEAP_SIZE_ELEMENTS:
				getHeapSizeElements().clear();
				getHeapSizeElements().addAll((Collection<? extends TypedElement>)newValue);
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
			case SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__ACTIVATION_CAPACITY:
				setActivationCapacity(ACTIVATION_CAPACITY_EDEFAULT);
				return;
			case SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__ENTRY_POINTS:
				getEntryPoints().clear();
				return;
			case SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__ADRESS_SPACE:
				getAdressSpace().clear();
				return;
			case SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__PERIOD_ELEMENTS:
				getPeriodElements().clear();
				return;
			case SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__PRIORITY_ELEMENTS:
				getPriorityElements().clear();
				return;
			case SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__STACK_SIZE_ELEMENTS:
				getStackSizeElements().clear();
				return;
			case SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__ACTIVATE_SERVICES:
				getActivateServices().clear();
				return;
			case SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__ENABLE_CONCURRENCY_SERVICES:
				getEnableConcurrencyServices().clear();
				return;
			case SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__RESUME_SERVICES:
				getResumeServices().clear();
				return;
			case SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__SUSPEND_SERVICES:
				getSuspendServices().clear();
				return;
			case SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__TERMINATE_SERVICES:
				getTerminateServices().clear();
				return;
			case SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__DISABLE_CONCURRENCY_SERVICES:
				getDisableConcurrencyServices().clear();
				return;
			case SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__SHARE_DATA_RESOURCES:
				getShareDataResources().clear();
				return;
			case SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__MESSAGE_RESOURCES:
				getMessageResources().clear();
				return;
			case SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__MUTUAL_EXCLUSION_RESOURCES:
				getMutualExclusionResources().clear();
				return;
			case SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__NOTIFICATION_RESOURCES:
				getNotificationResources().clear();
				return;
			case SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__HEAP_SIZE_ELEMENTS:
				getHeapSizeElements().clear();
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
			case SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__ACTIVATION_CAPACITY:
				return activationCapacity != ACTIVATION_CAPACITY_EDEFAULT;
			case SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__ENTRY_POINTS:
				return entryPoints != null && !entryPoints.isEmpty();
			case SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__ADRESS_SPACE:
				return adressSpace != null && !adressSpace.isEmpty();
			case SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__PERIOD_ELEMENTS:
				return periodElements != null && !periodElements.isEmpty();
			case SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__PRIORITY_ELEMENTS:
				return priorityElements != null && !priorityElements.isEmpty();
			case SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__STACK_SIZE_ELEMENTS:
				return stackSizeElements != null && !stackSizeElements.isEmpty();
			case SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__ACTIVATE_SERVICES:
				return activateServices != null && !activateServices.isEmpty();
			case SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__ENABLE_CONCURRENCY_SERVICES:
				return enableConcurrencyServices != null && !enableConcurrencyServices.isEmpty();
			case SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__RESUME_SERVICES:
				return resumeServices != null && !resumeServices.isEmpty();
			case SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__SUSPEND_SERVICES:
				return suspendServices != null && !suspendServices.isEmpty();
			case SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__TERMINATE_SERVICES:
				return terminateServices != null && !terminateServices.isEmpty();
			case SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__DISABLE_CONCURRENCY_SERVICES:
				return disableConcurrencyServices != null && !disableConcurrencyServices.isEmpty();
			case SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__SHARE_DATA_RESOURCES:
				return shareDataResources != null && !shareDataResources.isEmpty();
			case SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__MESSAGE_RESOURCES:
				return messageResources != null && !messageResources.isEmpty();
			case SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__MUTUAL_EXCLUSION_RESOURCES:
				return mutualExclusionResources != null && !mutualExclusionResources.isEmpty();
			case SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__NOTIFICATION_RESOURCES:
				return notificationResources != null && !notificationResources.isEmpty();
			case SW_ConcurrencyPackage.SW_CONCURRENT_RESOURCE__HEAP_SIZE_ELEMENTS:
				return heapSizeElements != null && !heapSizeElements.isEmpty();
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
		result.append(" (type: ");
		result.append(type);
		result.append(", activationCapacity: ");
		result.append(activationCapacity);
		result.append(')');
		return result.toString();
	}

} //SwConcurrentResourceImpl
