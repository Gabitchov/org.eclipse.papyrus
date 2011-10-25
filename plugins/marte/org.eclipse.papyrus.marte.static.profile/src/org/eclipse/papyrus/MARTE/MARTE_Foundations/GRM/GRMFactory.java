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
package org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.GRMPackage
 * @generated
 */
public interface GRMFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GRMFactory eINSTANCE = org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.GRMFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resource</em>'.
	 * @generated
	 */
	Resource createResource();

	/**
	 * Returns a new object of class '<em>Storage Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Storage Resource</em>'.
	 * @generated
	 */
	StorageResource createStorageResource();

	/**
	 * Returns a new object of class '<em>Communication End Point</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Communication End Point</em>'.
	 * @generated
	 */
	CommunicationEndPoint createCommunicationEndPoint();

	/**
	 * Returns a new object of class '<em>Synchronization Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Synchronization Resource</em>'.
	 * @generated
	 */
	SynchronizationResource createSynchronizationResource();

	/**
	 * Returns a new object of class '<em>Concurrency Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Concurrency Resource</em>'.
	 * @generated
	 */
	ConcurrencyResource createConcurrencyResource();

	/**
	 * Returns a new object of class '<em>Scheduler</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Scheduler</em>'.
	 * @generated
	 */
	Scheduler createScheduler();

	/**
	 * Returns a new object of class '<em>Processing Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Processing Resource</em>'.
	 * @generated
	 */
	ProcessingResource createProcessingResource();

	/**
	 * Returns a new object of class '<em>Computing Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Computing Resource</em>'.
	 * @generated
	 */
	ComputingResource createComputingResource();

	/**
	 * Returns a new object of class '<em>Mutual Exclusion Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mutual Exclusion Resource</em>'.
	 * @generated
	 */
	MutualExclusionResource createMutualExclusionResource();

	/**
	 * Returns a new object of class '<em>Schedulable Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Schedulable Resource</em>'.
	 * @generated
	 */
	SchedulableResource createSchedulableResource();

	/**
	 * Returns a new object of class '<em>Secondary Scheduler</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Secondary Scheduler</em>'.
	 * @generated
	 */
	SecondaryScheduler createSecondaryScheduler();

	/**
	 * Returns a new object of class '<em>Communication Media</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Communication Media</em>'.
	 * @generated
	 */
	CommunicationMedia createCommunicationMedia();

	/**
	 * Returns a new object of class '<em>Device Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Device Resource</em>'.
	 * @generated
	 */
	DeviceResource createDeviceResource();

	/**
	 * Returns a new object of class '<em>Timing Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Timing Resource</em>'.
	 * @generated
	 */
	TimingResource createTimingResource();

	/**
	 * Returns a new object of class '<em>Clock Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Clock Resource</em>'.
	 * @generated
	 */
	ClockResource createClockResource();

	/**
	 * Returns a new object of class '<em>Timer Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Timer Resource</em>'.
	 * @generated
	 */
	TimerResource createTimerResource();

	/**
	 * Returns a new object of class '<em>Gr Service</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Gr Service</em>'.
	 * @generated
	 */
	GrService createGrService();

	/**
	 * Returns a new object of class '<em>Release</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Release</em>'.
	 * @generated
	 */
	Release createRelease();

	/**
	 * Returns a new object of class '<em>Acquire</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Acquire</em>'.
	 * @generated
	 */
	Acquire createAcquire();

	/**
	 * Returns a new object of class '<em>Resource Usage</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resource Usage</em>'.
	 * @generated
	 */
	ResourceUsage createResourceUsage();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	GRMPackage getGRMPackage();

} //GRMFactory
