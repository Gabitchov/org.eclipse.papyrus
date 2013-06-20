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
package org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes;

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
 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Oarp4_datatypesFactory
 * @model kind="package"
 * @generated
 */
public interface Oarp4_datatypesPackage extends EPackage {

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "oarp4_datatypes";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http:///RobotMLLibraries/RobotML_ModelLibrary/RobotML_DataTypes/oarps_datatypes/oarp4_datatypes.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	Oarp4_datatypesPackage eINSTANCE = org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Oarp4_datatypesPackageImpl.init();

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Velocity_LinearImpl
	 * <em>Velocity Linear</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Velocity_LinearImpl
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Oarp4_datatypesPackageImpl#getVelocity_Linear()
	 * @generated
	 */
	int VELOCITY_LINEAR = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VELOCITY_LINEAR__VALUE = 0;

	/**
	 * The number of structural features of the '<em>Velocity Linear</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VELOCITY_LINEAR_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Art_Set_PointImpl
	 * <em>Art Set Point</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Art_Set_PointImpl
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Oarp4_datatypesPackageImpl#getArt_Set_Point()
	 * @generated
	 */
	int ART_SET_POINT = 1;

	/**
	 * The feature id for the '<em><b>Omega left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ART_SET_POINT__OMEGA_LEFT = 0;

	/**
	 * The feature id for the '<em><b>Omega right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ART_SET_POINT__OMEGA_RIGHT = 1;

	/**
	 * The number of structural features of the '<em>Art Set Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ART_SET_POINT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Velocity_AngularImpl
	 * <em>Velocity Angular</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Velocity_AngularImpl
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Oarp4_datatypesPackageImpl#getVelocity_Angular()
	 * @generated
	 */
	int VELOCITY_ANGULAR = 2;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VELOCITY_ANGULAR__VALUE = 0;

	/**
	 * The number of structural features of the '<em>Velocity Angular</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VELOCITY_ANGULAR_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.DistanceImpl
	 * <em>Distance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.DistanceImpl
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Oarp4_datatypesPackageImpl#getDistance()
	 * @generated
	 */
	int DISTANCE = 3;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DISTANCE__VALUE = 0;

	/**
	 * The number of structural features of the '<em>Distance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DISTANCE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.MetricImpl
	 * <em>Metric</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.MetricImpl
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Oarp4_datatypesPackageImpl#getMetric()
	 * @generated
	 */
	int METRIC = 4;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int METRIC__VALUE = 0;

	/**
	 * The number of structural features of the '<em>Metric</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int METRIC_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.AngularImpl
	 * <em>Angular</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.AngularImpl
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Oarp4_datatypesPackageImpl#getAngular()
	 * @generated
	 */
	int ANGULAR = 5;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ANGULAR__VALUE = 0;

	/**
	 * The number of structural features of the '<em>Angular</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ANGULAR_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Op_Set_PointImpl
	 * <em>Op Set Point</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Op_Set_PointImpl
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Oarp4_datatypesPackageImpl#getOp_Set_Point()
	 * @generated
	 */
	int OP_SET_POINT = 6;

	/**
	 * The feature id for the '<em><b>Velocity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OP_SET_POINT__VELOCITY = 0;

	/**
	 * The feature id for the '<em><b>Orientation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OP_SET_POINT__ORIENTATION = 1;

	/**
	 * The number of structural features of the '<em>Op Set Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OP_SET_POINT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Speed_Tics_Left_RightImpl
	 * <em>Speed Tics Left Right</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Speed_Tics_Left_RightImpl
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Oarp4_datatypesPackageImpl#getSpeed_Tics_Left_Right()
	 * @generated
	 */
	int SPEED_TICS_LEFT_RIGHT = 7;

	/**
	 * The feature id for the '<em><b>Speed tics left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SPEED_TICS_LEFT_RIGHT__SPEED_TICS_LEFT = 0;

	/**
	 * The feature id for the '<em><b>Speed tics right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SPEED_TICS_LEFT_RIGHT__SPEED_TICS_RIGHT = 1;

	/**
	 * The number of structural features of the '<em>Speed Tics Left Right</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SPEED_TICS_LEFT_RIGHT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Speed_TicsImpl
	 * <em>Speed Tics</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Speed_TicsImpl
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Oarp4_datatypesPackageImpl#getSpeed_Tics()
	 * @generated
	 */
	int SPEED_TICS = 8;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SPEED_TICS__VALUE = 0;

	/**
	 * The number of structural features of the '<em>Speed Tics</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SPEED_TICS_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Odometer_TicsImpl
	 * <em>Odometer Tics</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Odometer_TicsImpl
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Oarp4_datatypesPackageImpl#getOdometer_Tics()
	 * @generated
	 */
	int ODOMETER_TICS = 9;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ODOMETER_TICS__VALUE = 0;

	/**
	 * The number of structural features of the '<em>Odometer Tics</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ODOMETER_TICS_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Odometer_Tics_Left_RightImpl
	 * <em>Odometer Tics Left Right</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Odometer_Tics_Left_RightImpl
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Oarp4_datatypesPackageImpl#getOdometer_Tics_Left_Right()
	 * @generated
	 */
	int ODOMETER_TICS_LEFT_RIGHT = 10;

	/**
	 * The feature id for the '<em><b>Odometer tics left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ODOMETER_TICS_LEFT_RIGHT__ODOMETER_TICS_LEFT = 0;

	/**
	 * The feature id for the '<em><b>Odometer tics right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ODOMETER_TICS_LEFT_RIGHT__ODOMETER_TICS_RIGHT = 1;

	/**
	 * The number of structural features of the '<em>Odometer Tics Left Right</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ODOMETER_TICS_LEFT_RIGHT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Proxi_Left_RightImpl
	 * <em>Proxi Left Right</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Proxi_Left_RightImpl
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Oarp4_datatypesPackageImpl#getProxi_Left_Right()
	 * @generated
	 */
	int PROXI_LEFT_RIGHT = 11;

	/**
	 * The feature id for the '<em><b>Proxi left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROXI_LEFT_RIGHT__PROXI_LEFT = 0;

	/**
	 * The feature id for the '<em><b>Proxi right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROXI_LEFT_RIGHT__PROXI_RIGHT = 1;

	/**
	 * The number of structural features of the '<em>Proxi Left Right</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROXI_LEFT_RIGHT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Milli_AmpImpl
	 * <em>Milli Amp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Milli_AmpImpl
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Oarp4_datatypesPackageImpl#getMilli_Amp()
	 * @generated
	 */
	int MILLI_AMP = 12;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MILLI_AMP__VALUE = 0;

	/**
	 * The number of structural features of the '<em>Milli Amp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MILLI_AMP_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Odometer_Linear_Left_RightImpl
	 * <em>Odometer Linear Left Right</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Odometer_Linear_Left_RightImpl
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Oarp4_datatypesPackageImpl#getOdometer_Linear_Left_Right()
	 * @generated
	 */
	int ODOMETER_LINEAR_LEFT_RIGHT = 13;

	/**
	 * The feature id for the '<em><b>Odometer linear left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ODOMETER_LINEAR_LEFT_RIGHT__ODOMETER_LINEAR_LEFT = 0;

	/**
	 * The feature id for the '<em><b>Odometer linear right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ODOMETER_LINEAR_LEFT_RIGHT__ODOMETER_LINEAR_RIGHT = 1;

	/**
	 * The number of structural features of the '<em>Odometer Linear Left Right</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ODOMETER_LINEAR_LEFT_RIGHT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Velocity_Angular_Left_RightImpl
	 * <em>Velocity Angular Left Right</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Velocity_Angular_Left_RightImpl
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Oarp4_datatypesPackageImpl#getVelocity_Angular_Left_Right()
	 * @generated
	 */
	int VELOCITY_ANGULAR_LEFT_RIGHT = 14;

	/**
	 * The feature id for the '<em><b>Velocity angular left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VELOCITY_ANGULAR_LEFT_RIGHT__VELOCITY_ANGULAR_LEFT = 0;

	/**
	 * The feature id for the '<em><b>Velocity angular right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VELOCITY_ANGULAR_LEFT_RIGHT__VELOCITY_ANGULAR_RIGHT = 1;

	/**
	 * The number of structural features of the '<em>Velocity Angular Left Right</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VELOCITY_ANGULAR_LEFT_RIGHT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.VelocityImpl
	 * <em>Velocity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.VelocityImpl
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Oarp4_datatypesPackageImpl#getVelocity()
	 * @generated
	 */
	int VELOCITY = 15;

	/**
	 * The feature id for the '<em><b>Velocity linear</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VELOCITY__VELOCITY_LINEAR = 0;

	/**
	 * The feature id for the '<em><b>Velocity angular</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VELOCITY__VELOCITY_ANGULAR = 1;

	/**
	 * The number of structural features of the '<em>Velocity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VELOCITY_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Velocity_Linear
	 * <em>Velocity Linear</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Velocity Linear</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Velocity_Linear
	 * @generated
	 */
	EClass getVelocity_Linear();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Velocity_Linear#getValue
	 * <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Velocity_Linear#getValue()
	 * @see #getVelocity_Linear()
	 * @generated
	 */
	EAttribute getVelocity_Linear_Value();

	/**
	 * Returns the meta object for class '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Art_Set_Point
	 * <em>Art Set Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Art Set Point</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Art_Set_Point
	 * @generated
	 */
	EClass getArt_Set_Point();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Art_Set_Point#getOmega_left
	 * <em>Omega left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Omega left</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Art_Set_Point#getOmega_left()
	 * @see #getArt_Set_Point()
	 * @generated
	 */
	EReference getArt_Set_Point_Omega_left();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Art_Set_Point#getOmega_right
	 * <em>Omega right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Omega right</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Art_Set_Point#getOmega_right()
	 * @see #getArt_Set_Point()
	 * @generated
	 */
	EReference getArt_Set_Point_Omega_right();

	/**
	 * Returns the meta object for class '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Velocity_Angular
	 * <em>Velocity Angular</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Velocity Angular</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Velocity_Angular
	 * @generated
	 */
	EClass getVelocity_Angular();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Velocity_Angular#getValue
	 * <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Velocity_Angular#getValue()
	 * @see #getVelocity_Angular()
	 * @generated
	 */
	EAttribute getVelocity_Angular_Value();

	/**
	 * Returns the meta object for class '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Distance <em>Distance</em>}
	 * '.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Distance</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Distance
	 * @generated
	 */
	EClass getDistance();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Distance#getValue
	 * <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Distance#getValue()
	 * @see #getDistance()
	 * @generated
	 */
	EAttribute getDistance_Value();

	/**
	 * Returns the meta object for class '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Metric <em>Metric</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Metric</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Metric
	 * @generated
	 */
	EClass getMetric();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Metric#getValue
	 * <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Metric#getValue()
	 * @see #getMetric()
	 * @generated
	 */
	EAttribute getMetric_Value();

	/**
	 * Returns the meta object for class '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Angular <em>Angular</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Angular</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Angular
	 * @generated
	 */
	EClass getAngular();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Angular#getValue
	 * <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Angular#getValue()
	 * @see #getAngular()
	 * @generated
	 */
	EAttribute getAngular_Value();

	/**
	 * Returns the meta object for class '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Op_Set_Point
	 * <em>Op Set Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Op Set Point</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Op_Set_Point
	 * @generated
	 */
	EClass getOp_Set_Point();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Op_Set_Point#getVelocity
	 * <em>Velocity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Velocity</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Op_Set_Point#getVelocity()
	 * @see #getOp_Set_Point()
	 * @generated
	 */
	EReference getOp_Set_Point_Velocity();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Op_Set_Point#getOrientation
	 * <em>Orientation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Orientation</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Op_Set_Point#getOrientation()
	 * @see #getOp_Set_Point()
	 * @generated
	 */
	EReference getOp_Set_Point_Orientation();

	/**
	 * Returns the meta object for class '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Speed_Tics_Left_Right
	 * <em>Speed Tics Left Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Speed Tics Left Right</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Speed_Tics_Left_Right
	 * @generated
	 */
	EClass getSpeed_Tics_Left_Right();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Speed_Tics_Left_Right#getSpeed_tics_left
	 * <em>Speed tics left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Speed tics left</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Speed_Tics_Left_Right#getSpeed_tics_left()
	 * @see #getSpeed_Tics_Left_Right()
	 * @generated
	 */
	EReference getSpeed_Tics_Left_Right_Speed_tics_left();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Speed_Tics_Left_Right#getSpeed_tics_right
	 * <em>Speed tics right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Speed tics right</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Speed_Tics_Left_Right#getSpeed_tics_right()
	 * @see #getSpeed_Tics_Left_Right()
	 * @generated
	 */
	EReference getSpeed_Tics_Left_Right_Speed_tics_right();

	/**
	 * Returns the meta object for class '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Speed_Tics
	 * <em>Speed Tics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Speed Tics</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Speed_Tics
	 * @generated
	 */
	EClass getSpeed_Tics();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Speed_Tics#getValue
	 * <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Speed_Tics#getValue()
	 * @see #getSpeed_Tics()
	 * @generated
	 */
	EAttribute getSpeed_Tics_Value();

	/**
	 * Returns the meta object for class '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Odometer_Tics
	 * <em>Odometer Tics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Odometer Tics</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Odometer_Tics
	 * @generated
	 */
	EClass getOdometer_Tics();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Odometer_Tics#getValue
	 * <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Odometer_Tics#getValue()
	 * @see #getOdometer_Tics()
	 * @generated
	 */
	EAttribute getOdometer_Tics_Value();

	/**
	 * Returns the meta object for class '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Odometer_Tics_Left_Right
	 * <em>Odometer Tics Left Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Odometer Tics Left Right</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Odometer_Tics_Left_Right
	 * @generated
	 */
	EClass getOdometer_Tics_Left_Right();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Odometer_Tics_Left_Right#getOdometer_tics_left
	 * <em>Odometer tics left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Odometer tics left</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Odometer_Tics_Left_Right#getOdometer_tics_left()
	 * @see #getOdometer_Tics_Left_Right()
	 * @generated
	 */
	EReference getOdometer_Tics_Left_Right_Odometer_tics_left();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Odometer_Tics_Left_Right#getOdometer_tics_right
	 * <em>Odometer tics right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Odometer tics right</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Odometer_Tics_Left_Right#getOdometer_tics_right()
	 * @see #getOdometer_Tics_Left_Right()
	 * @generated
	 */
	EReference getOdometer_Tics_Left_Right_Odometer_tics_right();

	/**
	 * Returns the meta object for class '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Proxi_Left_Right
	 * <em>Proxi Left Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Proxi Left Right</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Proxi_Left_Right
	 * @generated
	 */
	EClass getProxi_Left_Right();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Proxi_Left_Right#getProxi_left
	 * <em>Proxi left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Proxi left</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Proxi_Left_Right#getProxi_left()
	 * @see #getProxi_Left_Right()
	 * @generated
	 */
	EReference getProxi_Left_Right_Proxi_left();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Proxi_Left_Right#getProxi_right
	 * <em>Proxi right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Proxi right</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Proxi_Left_Right#getProxi_right()
	 * @see #getProxi_Left_Right()
	 * @generated
	 */
	EReference getProxi_Left_Right_Proxi_right();

	/**
	 * Returns the meta object for class '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Milli_Amp
	 * <em>Milli Amp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Milli Amp</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Milli_Amp
	 * @generated
	 */
	EClass getMilli_Amp();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Milli_Amp#getValue
	 * <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Milli_Amp#getValue()
	 * @see #getMilli_Amp()
	 * @generated
	 */
	EAttribute getMilli_Amp_Value();

	/**
	 * Returns the meta object for class '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Odometer_Linear_Left_Right
	 * <em>Odometer Linear Left Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Odometer Linear Left Right</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Odometer_Linear_Left_Right
	 * @generated
	 */
	EClass getOdometer_Linear_Left_Right();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Odometer_Linear_Left_Right#getOdometer_linear_left
	 * <em>Odometer linear left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Odometer linear left</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Odometer_Linear_Left_Right#getOdometer_linear_left()
	 * @see #getOdometer_Linear_Left_Right()
	 * @generated
	 */
	EReference getOdometer_Linear_Left_Right_Odometer_linear_left();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Odometer_Linear_Left_Right#getOdometer_linear_right
	 * <em>Odometer linear right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Odometer linear right</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Odometer_Linear_Left_Right#getOdometer_linear_right()
	 * @see #getOdometer_Linear_Left_Right()
	 * @generated
	 */
	EReference getOdometer_Linear_Left_Right_Odometer_linear_right();

	/**
	 * Returns the meta object for class '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Velocity_Angular_Left_Right
	 * <em>Velocity Angular Left Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Velocity Angular Left Right</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Velocity_Angular_Left_Right
	 * @generated
	 */
	EClass getVelocity_Angular_Left_Right();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Velocity_Angular_Left_Right#getVelocity_angular_left
	 * <em>Velocity angular left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Velocity angular left</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Velocity_Angular_Left_Right#getVelocity_angular_left()
	 * @see #getVelocity_Angular_Left_Right()
	 * @generated
	 */
	EReference getVelocity_Angular_Left_Right_Velocity_angular_left();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Velocity_Angular_Left_Right#getVelocity_angular_right
	 * <em>Velocity angular right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Velocity angular right</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Velocity_Angular_Left_Right#getVelocity_angular_right()
	 * @see #getVelocity_Angular_Left_Right()
	 * @generated
	 */
	EReference getVelocity_Angular_Left_Right_Velocity_angular_right();

	/**
	 * Returns the meta object for class '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Velocity <em>Velocity</em>}
	 * '.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Velocity</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Velocity
	 * @generated
	 */
	EClass getVelocity();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Velocity#getVelocity_linear
	 * <em>Velocity linear</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Velocity linear</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Velocity#getVelocity_linear()
	 * @see #getVelocity()
	 * @generated
	 */
	EReference getVelocity_Velocity_linear();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Velocity#getVelocity_angular
	 * <em>Velocity angular</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Velocity angular</em>'.
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Velocity#getVelocity_angular()
	 * @see #getVelocity()
	 * @generated
	 */
	EReference getVelocity_Velocity_angular();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Oarp4_datatypesFactory getOarp4_datatypesFactory();

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
		 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Velocity_LinearImpl
		 * <em>Velocity Linear</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Velocity_LinearImpl
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Oarp4_datatypesPackageImpl#getVelocity_Linear()
		 * @generated
		 */
		EClass VELOCITY_LINEAR = eINSTANCE.getVelocity_Linear();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute VELOCITY_LINEAR__VALUE = eINSTANCE.getVelocity_Linear_Value();

		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Art_Set_PointImpl
		 * <em>Art Set Point</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Art_Set_PointImpl
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Oarp4_datatypesPackageImpl#getArt_Set_Point()
		 * @generated
		 */
		EClass ART_SET_POINT = eINSTANCE.getArt_Set_Point();

		/**
		 * The meta object literal for the '<em><b>Omega left</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ART_SET_POINT__OMEGA_LEFT = eINSTANCE.getArt_Set_Point_Omega_left();

		/**
		 * The meta object literal for the '<em><b>Omega right</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ART_SET_POINT__OMEGA_RIGHT = eINSTANCE.getArt_Set_Point_Omega_right();

		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Velocity_AngularImpl
		 * <em>Velocity Angular</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Velocity_AngularImpl
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Oarp4_datatypesPackageImpl#getVelocity_Angular()
		 * @generated
		 */
		EClass VELOCITY_ANGULAR = eINSTANCE.getVelocity_Angular();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute VELOCITY_ANGULAR__VALUE = eINSTANCE.getVelocity_Angular_Value();

		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.DistanceImpl
		 * <em>Distance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.DistanceImpl
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Oarp4_datatypesPackageImpl#getDistance()
		 * @generated
		 */
		EClass DISTANCE = eINSTANCE.getDistance();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DISTANCE__VALUE = eINSTANCE.getDistance_Value();

		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.MetricImpl
		 * <em>Metric</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.MetricImpl
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Oarp4_datatypesPackageImpl#getMetric()
		 * @generated
		 */
		EClass METRIC = eINSTANCE.getMetric();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute METRIC__VALUE = eINSTANCE.getMetric_Value();

		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.AngularImpl
		 * <em>Angular</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.AngularImpl
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Oarp4_datatypesPackageImpl#getAngular()
		 * @generated
		 */
		EClass ANGULAR = eINSTANCE.getAngular();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ANGULAR__VALUE = eINSTANCE.getAngular_Value();

		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Op_Set_PointImpl
		 * <em>Op Set Point</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Op_Set_PointImpl
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Oarp4_datatypesPackageImpl#getOp_Set_Point()
		 * @generated
		 */
		EClass OP_SET_POINT = eINSTANCE.getOp_Set_Point();

		/**
		 * The meta object literal for the '<em><b>Velocity</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference OP_SET_POINT__VELOCITY = eINSTANCE.getOp_Set_Point_Velocity();

		/**
		 * The meta object literal for the '<em><b>Orientation</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference OP_SET_POINT__ORIENTATION = eINSTANCE.getOp_Set_Point_Orientation();

		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Speed_Tics_Left_RightImpl
		 * <em>Speed Tics Left Right</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Speed_Tics_Left_RightImpl
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Oarp4_datatypesPackageImpl#getSpeed_Tics_Left_Right()
		 * @generated
		 */
		EClass SPEED_TICS_LEFT_RIGHT = eINSTANCE.getSpeed_Tics_Left_Right();

		/**
		 * The meta object literal for the '<em><b>Speed tics left</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SPEED_TICS_LEFT_RIGHT__SPEED_TICS_LEFT = eINSTANCE.getSpeed_Tics_Left_Right_Speed_tics_left();

		/**
		 * The meta object literal for the '<em><b>Speed tics right</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SPEED_TICS_LEFT_RIGHT__SPEED_TICS_RIGHT = eINSTANCE.getSpeed_Tics_Left_Right_Speed_tics_right();

		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Speed_TicsImpl
		 * <em>Speed Tics</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Speed_TicsImpl
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Oarp4_datatypesPackageImpl#getSpeed_Tics()
		 * @generated
		 */
		EClass SPEED_TICS = eINSTANCE.getSpeed_Tics();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute SPEED_TICS__VALUE = eINSTANCE.getSpeed_Tics_Value();

		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Odometer_TicsImpl
		 * <em>Odometer Tics</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Odometer_TicsImpl
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Oarp4_datatypesPackageImpl#getOdometer_Tics()
		 * @generated
		 */
		EClass ODOMETER_TICS = eINSTANCE.getOdometer_Tics();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ODOMETER_TICS__VALUE = eINSTANCE.getOdometer_Tics_Value();

		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Odometer_Tics_Left_RightImpl
		 * <em>Odometer Tics Left Right</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Odometer_Tics_Left_RightImpl
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Oarp4_datatypesPackageImpl#getOdometer_Tics_Left_Right()
		 * @generated
		 */
		EClass ODOMETER_TICS_LEFT_RIGHT = eINSTANCE.getOdometer_Tics_Left_Right();

		/**
		 * The meta object literal for the '<em><b>Odometer tics left</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ODOMETER_TICS_LEFT_RIGHT__ODOMETER_TICS_LEFT = eINSTANCE.getOdometer_Tics_Left_Right_Odometer_tics_left();

		/**
		 * The meta object literal for the '<em><b>Odometer tics right</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ODOMETER_TICS_LEFT_RIGHT__ODOMETER_TICS_RIGHT = eINSTANCE.getOdometer_Tics_Left_Right_Odometer_tics_right();

		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Proxi_Left_RightImpl
		 * <em>Proxi Left Right</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Proxi_Left_RightImpl
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Oarp4_datatypesPackageImpl#getProxi_Left_Right()
		 * @generated
		 */
		EClass PROXI_LEFT_RIGHT = eINSTANCE.getProxi_Left_Right();

		/**
		 * The meta object literal for the '<em><b>Proxi left</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PROXI_LEFT_RIGHT__PROXI_LEFT = eINSTANCE.getProxi_Left_Right_Proxi_left();

		/**
		 * The meta object literal for the '<em><b>Proxi right</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PROXI_LEFT_RIGHT__PROXI_RIGHT = eINSTANCE.getProxi_Left_Right_Proxi_right();

		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Milli_AmpImpl
		 * <em>Milli Amp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Milli_AmpImpl
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Oarp4_datatypesPackageImpl#getMilli_Amp()
		 * @generated
		 */
		EClass MILLI_AMP = eINSTANCE.getMilli_Amp();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute MILLI_AMP__VALUE = eINSTANCE.getMilli_Amp_Value();

		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Odometer_Linear_Left_RightImpl
		 * <em>Odometer Linear Left Right</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Odometer_Linear_Left_RightImpl
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Oarp4_datatypesPackageImpl#getOdometer_Linear_Left_Right()
		 * @generated
		 */
		EClass ODOMETER_LINEAR_LEFT_RIGHT = eINSTANCE.getOdometer_Linear_Left_Right();

		/**
		 * The meta object literal for the '<em><b>Odometer linear left</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ODOMETER_LINEAR_LEFT_RIGHT__ODOMETER_LINEAR_LEFT = eINSTANCE.getOdometer_Linear_Left_Right_Odometer_linear_left();

		/**
		 * The meta object literal for the '<em><b>Odometer linear right</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ODOMETER_LINEAR_LEFT_RIGHT__ODOMETER_LINEAR_RIGHT = eINSTANCE.getOdometer_Linear_Left_Right_Odometer_linear_right();

		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Velocity_Angular_Left_RightImpl
		 * <em>Velocity Angular Left Right</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Velocity_Angular_Left_RightImpl
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Oarp4_datatypesPackageImpl#getVelocity_Angular_Left_Right()
		 * @generated
		 */
		EClass VELOCITY_ANGULAR_LEFT_RIGHT = eINSTANCE.getVelocity_Angular_Left_Right();

		/**
		 * The meta object literal for the '<em><b>Velocity angular left</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VELOCITY_ANGULAR_LEFT_RIGHT__VELOCITY_ANGULAR_LEFT = eINSTANCE.getVelocity_Angular_Left_Right_Velocity_angular_left();

		/**
		 * The meta object literal for the '<em><b>Velocity angular right</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VELOCITY_ANGULAR_LEFT_RIGHT__VELOCITY_ANGULAR_RIGHT = eINSTANCE.getVelocity_Angular_Left_Right_Velocity_angular_right();

		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.VelocityImpl
		 * <em>Velocity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.VelocityImpl
		 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Oarp4_datatypesPackageImpl#getVelocity()
		 * @generated
		 */
		EClass VELOCITY = eINSTANCE.getVelocity();

		/**
		 * The meta object literal for the '<em><b>Velocity linear</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VELOCITY__VELOCITY_LINEAR = eINSTANCE.getVelocity_Velocity_linear();

		/**
		 * The meta object literal for the '<em><b>Velocity angular</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VELOCITY__VELOCITY_ANGULAR = eINSTANCE.getVelocity_Velocity_angular();

	}

} //Oarp4_datatypesPackage
