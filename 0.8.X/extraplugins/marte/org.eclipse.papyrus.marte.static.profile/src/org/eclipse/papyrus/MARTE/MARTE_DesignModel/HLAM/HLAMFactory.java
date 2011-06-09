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
package org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.HLAMPackage
 * @generated
 */
public interface HLAMFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	HLAMFactory eINSTANCE = org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.HLAMFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Rt Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rt Unit</em>'.
	 * @generated
	 */
	RtUnit createRtUnit();

	/**
	 * Returns a new object of class '<em>Pp Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pp Unit</em>'.
	 * @generated
	 */
	PpUnit createPpUnit();

	/**
	 * Returns a new object of class '<em>Rt Feature</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rt Feature</em>'.
	 * @generated
	 */
	RtFeature createRtFeature();

	/**
	 * Returns a new object of class '<em>Rt Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rt Specification</em>'.
	 * @generated
	 */
	RtSpecification createRtSpecification();

	/**
	 * Returns a new object of class '<em>Rt Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rt Action</em>'.
	 * @generated
	 */
	RtAction createRtAction();

	/**
	 * Returns a new object of class '<em>Rt Service</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rt Service</em>'.
	 * @generated
	 */
	RtService createRtService();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	HLAMPackage getHLAMPackage();

} //HLAMFactory
