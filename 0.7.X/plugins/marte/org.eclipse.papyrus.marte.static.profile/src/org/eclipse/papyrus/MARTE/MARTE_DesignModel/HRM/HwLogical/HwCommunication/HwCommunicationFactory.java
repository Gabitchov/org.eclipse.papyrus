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
package org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwCommunication;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwCommunication.HwCommunicationPackage
 * @generated
 */
public interface HwCommunicationFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	HwCommunicationFactory eINSTANCE = org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwCommunication.impl.HwCommunicationFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resource</em>'.
	 * @generated
	 */
	HwCommunicationResource createHwCommunicationResource();

	/**
	 * Returns a new object of class '<em>Hw Arbiter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Hw Arbiter</em>'.
	 * @generated
	 */
	HwArbiter createHwArbiter();

	/**
	 * Returns a new object of class '<em>Hw Media</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Hw Media</em>'.
	 * @generated
	 */
	HwMedia createHwMedia();

	/**
	 * Returns a new object of class '<em>Hw Bus</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Hw Bus</em>'.
	 * @generated
	 */
	HwBus createHwBus();

	/**
	 * Returns a new object of class '<em>Hw Bridge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Hw Bridge</em>'.
	 * @generated
	 */
	HwBridge createHwBridge();

	/**
	 * Returns a new object of class '<em>Hw End Point</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Hw End Point</em>'.
	 * @generated
	 */
	HwEndPoint createHwEndPoint();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	HwCommunicationPackage getHwCommunicationPackage();

} //HwCommunicationFactory
