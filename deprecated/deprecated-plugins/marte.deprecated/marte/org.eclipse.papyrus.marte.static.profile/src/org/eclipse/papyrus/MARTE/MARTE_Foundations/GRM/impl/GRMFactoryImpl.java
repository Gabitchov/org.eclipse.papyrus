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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GRMFactoryImpl extends EFactoryImpl implements GRMFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static GRMFactory init() {
		try {
			GRMFactory theGRMFactory = (GRMFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/papyrus/GRM/1"); 
			if (theGRMFactory != null) {
				return theGRMFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new GRMFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GRMFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case GRMPackage.RESOURCE: return createResource();
			case GRMPackage.STORAGE_RESOURCE: return createStorageResource();
			case GRMPackage.COMMUNICATION_END_POINT: return createCommunicationEndPoint();
			case GRMPackage.SYNCHRONIZATION_RESOURCE: return createSynchronizationResource();
			case GRMPackage.CONCURRENCY_RESOURCE: return createConcurrencyResource();
			case GRMPackage.SCHEDULER: return createScheduler();
			case GRMPackage.PROCESSING_RESOURCE: return createProcessingResource();
			case GRMPackage.COMPUTING_RESOURCE: return createComputingResource();
			case GRMPackage.MUTUAL_EXCLUSION_RESOURCE: return createMutualExclusionResource();
			case GRMPackage.SCHEDULABLE_RESOURCE: return createSchedulableResource();
			case GRMPackage.SECONDARY_SCHEDULER: return createSecondaryScheduler();
			case GRMPackage.COMMUNICATION_MEDIA: return createCommunicationMedia();
			case GRMPackage.DEVICE_RESOURCE: return createDeviceResource();
			case GRMPackage.TIMING_RESOURCE: return createTimingResource();
			case GRMPackage.CLOCK_RESOURCE: return createClockResource();
			case GRMPackage.TIMER_RESOURCE: return createTimerResource();
			case GRMPackage.GR_SERVICE: return createGrService();
			case GRMPackage.RELEASE: return createRelease();
			case GRMPackage.ACQUIRE: return createAcquire();
			case GRMPackage.RESOURCE_USAGE: return createResourceUsage();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Resource createResource() {
		ResourceImpl resource = new ResourceImpl();
		return resource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StorageResource createStorageResource() {
		StorageResourceImpl storageResource = new StorageResourceImpl();
		return storageResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommunicationEndPoint createCommunicationEndPoint() {
		CommunicationEndPointImpl communicationEndPoint = new CommunicationEndPointImpl();
		return communicationEndPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SynchronizationResource createSynchronizationResource() {
		SynchronizationResourceImpl synchronizationResource = new SynchronizationResourceImpl();
		return synchronizationResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConcurrencyResource createConcurrencyResource() {
		ConcurrencyResourceImpl concurrencyResource = new ConcurrencyResourceImpl();
		return concurrencyResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Scheduler createScheduler() {
		SchedulerImpl scheduler = new SchedulerImpl();
		return scheduler;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessingResource createProcessingResource() {
		ProcessingResourceImpl processingResource = new ProcessingResourceImpl();
		return processingResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComputingResource createComputingResource() {
		ComputingResourceImpl computingResource = new ComputingResourceImpl();
		return computingResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MutualExclusionResource createMutualExclusionResource() {
		MutualExclusionResourceImpl mutualExclusionResource = new MutualExclusionResourceImpl();
		return mutualExclusionResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SchedulableResource createSchedulableResource() {
		SchedulableResourceImpl schedulableResource = new SchedulableResourceImpl();
		return schedulableResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SecondaryScheduler createSecondaryScheduler() {
		SecondarySchedulerImpl secondaryScheduler = new SecondarySchedulerImpl();
		return secondaryScheduler;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommunicationMedia createCommunicationMedia() {
		CommunicationMediaImpl communicationMedia = new CommunicationMediaImpl();
		return communicationMedia;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeviceResource createDeviceResource() {
		DeviceResourceImpl deviceResource = new DeviceResourceImpl();
		return deviceResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimingResource createTimingResource() {
		TimingResourceImpl timingResource = new TimingResourceImpl();
		return timingResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClockResource createClockResource() {
		ClockResourceImpl clockResource = new ClockResourceImpl();
		return clockResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimerResource createTimerResource() {
		TimerResourceImpl timerResource = new TimerResourceImpl();
		return timerResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GrService createGrService() {
		GrServiceImpl grService = new GrServiceImpl();
		return grService;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Release createRelease() {
		ReleaseImpl release = new ReleaseImpl();
		return release;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Acquire createAcquire() {
		AcquireImpl acquire = new AcquireImpl();
		return acquire;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceUsage createResourceUsage() {
		ResourceUsageImpl resourceUsage = new ResourceUsageImpl();
		return resourceUsage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GRMPackage getGRMPackage() {
		return (GRMPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static GRMPackage getPackage() {
		return GRMPackage.eINSTANCE;
	}

} //GRMFactoryImpl
