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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.Oarp1_datatypesFactory
 * @model kind="package"
 * @generated
 */
public interface Oarp1_datatypesPackage extends EPackage {

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "oarp1_datatypes";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http:///RobotMLLibraries/RobotML_ModelLibrary/RobotML_DataTypes/oarps_datatypes/oarp1_datatypes.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	Oarp1_datatypesPackage eINSTANCE = org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.impl.Oarp1_datatypesPackageImpl.init();

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.impl.CarLikeCommandImpl
	 * <em>Car Like Command</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.impl.CarLikeCommandImpl
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.impl.Oarp1_datatypesPackageImpl#getCarLikeCommand()
	 * @generated
	 */
	int CAR_LIKE_COMMAND = 0;

	/**
	 * The feature id for the '<em><b>Velocity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CAR_LIKE_COMMAND__VELOCITY = 0;

	/**
	 * The feature id for the '<em><b>Steering Angle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CAR_LIKE_COMMAND__STEERING_ANGLE = 1;

	/**
	 * The number of structural features of the '<em>Car Like Command</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CAR_LIKE_COMMAND_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.impl.MultiLayerLidarScanImpl
	 * <em>Multi Layer Lidar Scan</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.impl.MultiLayerLidarScanImpl
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.impl.Oarp1_datatypesPackageImpl#getMultiLayerLidarScan()
	 * @generated
	 */
	int MULTI_LAYER_LIDAR_SCAN = 1;

	/**
	 * The feature id for the '<em><b>Layers</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_LAYER_LIDAR_SCAN__LAYERS = 0;

	/**
	 * The feature id for the '<em><b>Nb Layer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_LAYER_LIDAR_SCAN__NB_LAYER = 1;

	/**
	 * The number of structural features of the '<em>Multi Layer Lidar Scan</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_LAYER_LIDAR_SCAN_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.impl.ExtentedLidarScanImpl
	 * <em>Extented Lidar Scan</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.impl.ExtentedLidarScanImpl
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.impl.Oarp1_datatypesPackageImpl#getExtentedLidarScan()
	 * @generated
	 */
	int EXTENTED_LIDAR_SCAN = 2;

	/**
	 * The feature id for the '<em><b>Scan</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXTENTED_LIDAR_SCAN__SCAN = 0;

	/**
	 * The feature id for the '<em><b>Layer Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXTENTED_LIDAR_SCAN__LAYER_ID = 1;

	/**
	 * The feature id for the '<em><b>Layer Angle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXTENTED_LIDAR_SCAN__LAYER_ANGLE = 2;

	/**
	 * The number of structural features of the '<em>Extented Lidar Scan</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXTENTED_LIDAR_SCAN_FEATURE_COUNT = 3;


	/**
	 * Returns the meta object for class '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.CarLikeCommand
	 * <em>Car Like Command</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Car Like Command</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.CarLikeCommand
	 * @generated
	 */
	EClass getCarLikeCommand();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.CarLikeCommand#getVelocity
	 * <em>Velocity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Velocity</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.CarLikeCommand#getVelocity()
	 * @see #getCarLikeCommand()
	 * @generated
	 */
	EAttribute getCarLikeCommand_Velocity();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.CarLikeCommand#getSteeringAngle
	 * <em>Steering Angle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Steering Angle</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.CarLikeCommand#getSteeringAngle()
	 * @see #getCarLikeCommand()
	 * @generated
	 */
	EAttribute getCarLikeCommand_SteeringAngle();

	/**
	 * Returns the meta object for class '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.MultiLayerLidarScan
	 * <em>Multi Layer Lidar Scan</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Multi Layer Lidar Scan</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.MultiLayerLidarScan
	 * @generated
	 */
	EClass getMultiLayerLidarScan();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.MultiLayerLidarScan#getLayers
	 * <em>Layers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Layers</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.MultiLayerLidarScan#getLayers()
	 * @see #getMultiLayerLidarScan()
	 * @generated
	 */
	EReference getMultiLayerLidarScan_Layers();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.MultiLayerLidarScan#getNbLayer
	 * <em>Nb Layer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Nb Layer</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.MultiLayerLidarScan#getNbLayer()
	 * @see #getMultiLayerLidarScan()
	 * @generated
	 */
	EAttribute getMultiLayerLidarScan_NbLayer();

	/**
	 * Returns the meta object for class '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.ExtentedLidarScan
	 * <em>Extented Lidar Scan</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Extented Lidar Scan</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.ExtentedLidarScan
	 * @generated
	 */
	EClass getExtentedLidarScan();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.ExtentedLidarScan#getScan
	 * <em>Scan</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Scan</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.ExtentedLidarScan#getScan()
	 * @see #getExtentedLidarScan()
	 * @generated
	 */
	EReference getExtentedLidarScan_Scan();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.ExtentedLidarScan#getLayerId
	 * <em>Layer Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Layer Id</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.ExtentedLidarScan#getLayerId()
	 * @see #getExtentedLidarScan()
	 * @generated
	 */
	EAttribute getExtentedLidarScan_LayerId();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.ExtentedLidarScan#getLayerAngle
	 * <em>Layer Angle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Layer Angle</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.ExtentedLidarScan#getLayerAngle()
	 * @see #getExtentedLidarScan()
	 * @generated
	 */
	EAttribute getExtentedLidarScan_LayerAngle();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Oarp1_datatypesFactory getOarp1_datatypesFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	interface Literals {

		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.impl.CarLikeCommandImpl
		 * <em>Car Like Command</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.impl.CarLikeCommandImpl
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.impl.Oarp1_datatypesPackageImpl#getCarLikeCommand()
		 * @generated
		 */
		EClass CAR_LIKE_COMMAND = eINSTANCE.getCarLikeCommand();

		/**
		 * The meta object literal for the '<em><b>Velocity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute CAR_LIKE_COMMAND__VELOCITY = eINSTANCE.getCarLikeCommand_Velocity();

		/**
		 * The meta object literal for the '<em><b>Steering Angle</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute CAR_LIKE_COMMAND__STEERING_ANGLE = eINSTANCE.getCarLikeCommand_SteeringAngle();

		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.impl.MultiLayerLidarScanImpl
		 * <em>Multi Layer Lidar Scan</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.impl.MultiLayerLidarScanImpl
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.impl.Oarp1_datatypesPackageImpl#getMultiLayerLidarScan()
		 * @generated
		 */
		EClass MULTI_LAYER_LIDAR_SCAN = eINSTANCE.getMultiLayerLidarScan();

		/**
		 * The meta object literal for the '<em><b>Layers</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference MULTI_LAYER_LIDAR_SCAN__LAYERS = eINSTANCE.getMultiLayerLidarScan_Layers();

		/**
		 * The meta object literal for the '<em><b>Nb Layer</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute MULTI_LAYER_LIDAR_SCAN__NB_LAYER = eINSTANCE.getMultiLayerLidarScan_NbLayer();

		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.impl.ExtentedLidarScanImpl
		 * <em>Extented Lidar Scan</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.impl.ExtentedLidarScanImpl
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.impl.Oarp1_datatypesPackageImpl#getExtentedLidarScan()
		 * @generated
		 */
		EClass EXTENTED_LIDAR_SCAN = eINSTANCE.getExtentedLidarScan();

		/**
		 * The meta object literal for the '<em><b>Scan</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference EXTENTED_LIDAR_SCAN__SCAN = eINSTANCE.getExtentedLidarScan_Scan();

		/**
		 * The meta object literal for the '<em><b>Layer Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute EXTENTED_LIDAR_SCAN__LAYER_ID = eINSTANCE.getExtentedLidarScan_LayerId();

		/**
		 * The meta object literal for the '<em><b>Layer Angle</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute EXTENTED_LIDAR_SCAN__LAYER_ANGLE = eINSTANCE.getExtentedLidarScan_LayerAngle();

	}

} //Oarp1_datatypesPackage
