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
package org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwStorage.HwMemory;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwStorage.HwMemory.HwMemoryPackage
 * @generated
 */
public interface HwMemoryFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	HwMemoryFactory eINSTANCE = org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwStorage.HwMemory.impl.HwMemoryFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Hw Memory</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Hw Memory</em>'.
	 * @generated
	 */
	HwMemory createHwMemory();

	/**
	 * Returns a new object of class '<em>Hw RAM</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Hw RAM</em>'.
	 * @generated
	 */
	HwRAM createHwRAM();

	/**
	 * Returns a new object of class '<em>Hw ROM</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Hw ROM</em>'.
	 * @generated
	 */
	HwROM createHwROM();

	/**
	 * Returns a new object of class '<em>Hw Drive</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Hw Drive</em>'.
	 * @generated
	 */
	HwDrive createHwDrive();

	/**
	 * Returns a new object of class '<em>Hw Cache</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Hw Cache</em>'.
	 * @generated
	 */
	HwCache createHwCache();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	HwMemoryPackage getHwMemoryPackage();

} //HwMemoryFactory
