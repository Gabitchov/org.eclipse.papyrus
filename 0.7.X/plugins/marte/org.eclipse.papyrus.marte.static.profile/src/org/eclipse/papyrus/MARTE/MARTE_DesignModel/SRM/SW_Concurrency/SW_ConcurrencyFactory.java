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
package org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SW_ConcurrencyPackage
 * @generated
 */
public interface SW_ConcurrencyFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SW_ConcurrencyFactory eINSTANCE = org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.impl.SW_ConcurrencyFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Entry Point</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Entry Point</em>'.
	 * @generated
	 */
	EntryPoint createEntryPoint();

	/**
	 * Returns a new object of class '<em>Interrupt Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Interrupt Resource</em>'.
	 * @generated
	 */
	InterruptResource createInterruptResource();

	/**
	 * Returns a new object of class '<em>Sw Schedulable Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sw Schedulable Resource</em>'.
	 * @generated
	 */
	SwSchedulableResource createSwSchedulableResource();

	/**
	 * Returns a new object of class '<em>Sw Timer Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sw Timer Resource</em>'.
	 * @generated
	 */
	SwTimerResource createSwTimerResource();

	/**
	 * Returns a new object of class '<em>Memory Partition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Memory Partition</em>'.
	 * @generated
	 */
	MemoryPartition createMemoryPartition();

	/**
	 * Returns a new object of class '<em>Alarm</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Alarm</em>'.
	 * @generated
	 */
	Alarm createAlarm();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SW_ConcurrencyPackage getSW_ConcurrencyPackage();

} //SW_ConcurrencyFactory
