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
package org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.Sensor_datatypesPackage
 * @generated
 */
public interface Sensor_datatypesFactory extends EFactory {

	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	Sensor_datatypesFactory eINSTANCE = org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.Sensor_datatypesFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Region Of Interest</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Region Of Interest</em>'.
	 * @generated
	 */
	RegionOfInterest createRegionOfInterest();

	/**
	 * Returns a new object of class '<em>Range</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Range</em>'.
	 * @generated
	 */
	Range createRange();

	/**
	 * Returns a new object of class '<em>Camera Info</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Camera Info</em>'.
	 * @generated
	 */
	CameraInfo createCameraInfo();

	/**
	 * Returns a new object of class '<em>Imu</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Imu</em>'.
	 * @generated
	 */
	Imu createImu();

	/**
	 * Returns a new object of class '<em>Laser Scan</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Laser Scan</em>'.
	 * @generated
	 */
	LaserScan createLaserScan();

	/**
	 * Returns a new object of class '<em>Image</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Image</em>'.
	 * @generated
	 */
	Image createImage();

	/**
	 * Returns a new object of class '<em>Channel Float32</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Channel Float32</em>'.
	 * @generated
	 */
	ChannelFloat32 createChannelFloat32();

	/**
	 * Returns a new object of class '<em>Compressed Image</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Compressed Image</em>'.
	 * @generated
	 */
	CompressedImage createCompressedImage();

	/**
	 * Returns a new object of class '<em>Point Cloud</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Point Cloud</em>'.
	 * @generated
	 */
	PointCloud createPointCloud();

	/**
	 * Returns a new object of class '<em>Point Field</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Point Field</em>'.
	 * @generated
	 */
	PointField createPointField();

	/**
	 * Returns a new object of class '<em>Point Cloud2</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Point Cloud2</em>'.
	 * @generated
	 */
	PointCloud2 createPointCloud2();

	/**
	 * Returns a new object of class '<em>Joint State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Joint State</em>'.
	 * @generated
	 */
	JointState createJointState();

	/**
	 * Returns a new object of class '<em>Nav Sat Status</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Nav Sat Status</em>'.
	 * @generated
	 */
	NavSatStatus createNavSatStatus();

	/**
	 * Returns a new object of class '<em>Nav Sat Fix</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Nav Sat Fix</em>'.
	 * @generated
	 */
	NavSatFix createNavSatFix();

	/**
	 * Returns a new object of class '<em>Joy</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Joy</em>'.
	 * @generated
	 */
	Joy createJoy();

	/**
	 * Returns a new object of class '<em>Joy Feedback</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Joy Feedback</em>'.
	 * @generated
	 */
	JoyFeedback createJoyFeedback();

	/**
	 * Returns a new object of class '<em>Joy Feedback Array</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Joy Feedback Array</em>'.
	 * @generated
	 */
	JoyFeedbackArray createJoyFeedbackArray();

	/**
	 * Returns a new object of class '<em>Car Like Odometry</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Car Like Odometry</em>'.
	 * @generated
	 */
	CarLikeOdometry createCarLikeOdometry();

	/**
	 * Returns a new object of class '<em>Differential Odometry</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Differential Odometry</em>'.
	 * @generated
	 */
	DifferentialOdometry createDifferentialOdometry();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the package supported by this factory.
	 * @generated
	 */
	Sensor_datatypesPackage getSensor_datatypesPackage();

} //Sensor_datatypesFactory
