/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Saadia Dhouib (CEA LIST) saadia.dhouib@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.Oarp1_datatypesPackage
 * @generated
 */
public interface Oarp1_datatypesFactory extends EFactory {

	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	Oarp1_datatypesFactory eINSTANCE = org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.impl.Oarp1_datatypesFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Car Like Command</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Car Like Command</em>'.
	 * @generated
	 */
	CarLikeCommand createCarLikeCommand();

	/**
	 * Returns a new object of class '<em>Multi Layer Lidar Scan</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Multi Layer Lidar Scan</em>'.
	 * @generated
	 */
	MultiLayerLidarScan createMultiLayerLidarScan();

	/**
	 * Returns a new object of class '<em>Extented Lidar Scan</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Extented Lidar Scan</em>'.
	 * @generated
	 */
	ExtentedLidarScan createExtentedLidarScan();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the package supported by this factory.
	 * @generated
	 */
	Oarp1_datatypesPackage getOarp1_datatypesPackage();

} //Oarp1_datatypesFactory
