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
package org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.CarLikeCommand;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.ExtentedLidarScan;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.MultiLayerLidarScan;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.Oarp1_datatypesFactory;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.Oarp1_datatypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class Oarp1_datatypesFactoryImpl extends EFactoryImpl implements Oarp1_datatypesFactory {

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static Oarp1_datatypesFactory init() {
		try {
			Oarp1_datatypesFactory theOarp1_datatypesFactory = (Oarp1_datatypesFactory)EPackage.Registry.INSTANCE.getEFactory("http:///RobotMLLibraries/RobotML_ModelLibrary/RobotML_DataTypes/oarps_datatypes/oarp1_datatypes.ecore");
			if(theOarp1_datatypesFactory != null) {
				return theOarp1_datatypesFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Oarp1_datatypesFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Oarp1_datatypesFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch(eClass.getClassifierID()) {
		case Oarp1_datatypesPackage.CAR_LIKE_COMMAND:
			return createCarLikeCommand();
		case Oarp1_datatypesPackage.MULTI_LAYER_LIDAR_SCAN:
			return createMultiLayerLidarScan();
		case Oarp1_datatypesPackage.EXTENTED_LIDAR_SCAN:
			return createExtentedLidarScan();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CarLikeCommand createCarLikeCommand() {
		CarLikeCommandImpl carLikeCommand = new CarLikeCommandImpl();
		return carLikeCommand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public MultiLayerLidarScan createMultiLayerLidarScan() {
		MultiLayerLidarScanImpl multiLayerLidarScan = new MultiLayerLidarScanImpl();
		return multiLayerLidarScan;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ExtentedLidarScan createExtentedLidarScan() {
		ExtentedLidarScanImpl extentedLidarScan = new ExtentedLidarScanImpl();
		return extentedLidarScan;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Oarp1_datatypesPackage getOarp1_datatypesPackage() {
		return (Oarp1_datatypesPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static Oarp1_datatypesPackage getPackage() {
		return Oarp1_datatypesPackage.eINSTANCE;
	}

} //Oarp1_datatypesFactoryImpl
