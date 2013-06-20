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
package org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.papyrus.RobotML.RobotMLPackage;
import org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.Actionlib_datatypesPackage;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.impl.Actionlib_datatypesPackageImpl;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.diagnostic_datatypes.Diagnostic_datatypesPackage;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.diagnostic_datatypes.impl.Diagnostic_datatypesPackageImpl;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.Geometry_datatypesPackage;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.impl.Geometry_datatypesPackageImpl;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.Nav_datatypesPackage;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.impl.Nav_datatypesPackageImpl;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.Oarp1_datatypesPackage;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.impl.Oarp1_datatypesPackageImpl;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Oarp4_datatypesPackage;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Oarp4_datatypesPackageImpl;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.CameraInfo;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.CarLikeOdometry;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.ChannelFloat32;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.CompressedImage;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.DifferentialOdometry;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.Image;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.Imu;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.JointState;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.Joy;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.JoyFeedback;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.JoyFeedbackArray;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.LaserScan;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.NavSatFix;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.NavSatStatus;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.PointCloud;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.PointCloud2;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.PointField;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.Range;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.RegionOfInterest;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.Sensor_datatypesFactory;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.Sensor_datatypesPackage;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Std_datatypesPackage;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Std_datatypesPackageImpl;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class Sensor_datatypesPackageImpl extends EPackageImpl implements Sensor_datatypesPackage {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass regionOfInterestEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass rangeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass cameraInfoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass imuEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass laserScanEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass imageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass channelFloat32EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass compressedImageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass pointCloudEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass pointFieldEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass pointCloud2EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass jointStateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass navSatStatusEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass navSatFixEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass joyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass joyFeedbackEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass joyFeedbackArrayEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass carLikeOdometryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass differentialOdometryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EEnum statuS_TYPEEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EEnum servicE_TYPEEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EEnum covariancE_TYPEEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the
	 * package
	 * package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also performs initialization of the
	 * package, or returns the registered package, if one already exists. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.Sensor_datatypesPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private Sensor_datatypesPackageImpl() {
		super(eNS_URI, Sensor_datatypesFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>
	 * This method is used to initialize {@link Sensor_datatypesPackage#eINSTANCE} when that field is accessed. Clients should not invoke it directly.
	 * Instead, they should simply access that field to obtain the package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static Sensor_datatypesPackage init() {
		if(isInited)
			return (Sensor_datatypesPackage)EPackage.Registry.INSTANCE.getEPackage(Sensor_datatypesPackage.eNS_URI);

		// Obtain or create and register package
		Sensor_datatypesPackageImpl theSensor_datatypesPackage = (Sensor_datatypesPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof Sensor_datatypesPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new Sensor_datatypesPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		UMLPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		RobotMLPackageImpl theRobotMLPackage = (RobotMLPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(RobotMLPackage.eNS_URI) instanceof RobotMLPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(RobotMLPackage.eNS_URI) : RobotMLPackage.eINSTANCE);
		Diagnostic_datatypesPackageImpl theDiagnostic_datatypesPackage = (Diagnostic_datatypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Diagnostic_datatypesPackage.eNS_URI) instanceof Diagnostic_datatypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Diagnostic_datatypesPackage.eNS_URI) : Diagnostic_datatypesPackage.eINSTANCE);
		Geometry_datatypesPackageImpl theGeometry_datatypesPackage = (Geometry_datatypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Geometry_datatypesPackage.eNS_URI) instanceof Geometry_datatypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Geometry_datatypesPackage.eNS_URI) : Geometry_datatypesPackage.eINSTANCE);
		Nav_datatypesPackageImpl theNav_datatypesPackage = (Nav_datatypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Nav_datatypesPackage.eNS_URI) instanceof Nav_datatypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Nav_datatypesPackage.eNS_URI) : Nav_datatypesPackage.eINSTANCE);
		Actionlib_datatypesPackageImpl theActionlib_datatypesPackage = (Actionlib_datatypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Actionlib_datatypesPackage.eNS_URI) instanceof Actionlib_datatypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Actionlib_datatypesPackage.eNS_URI) : Actionlib_datatypesPackage.eINSTANCE);
		Oarp1_datatypesPackageImpl theOarp1_datatypesPackage = (Oarp1_datatypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Oarp1_datatypesPackage.eNS_URI) instanceof Oarp1_datatypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Oarp1_datatypesPackage.eNS_URI) : Oarp1_datatypesPackage.eINSTANCE);
		Oarp4_datatypesPackageImpl theOarp4_datatypesPackage = (Oarp4_datatypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Oarp4_datatypesPackage.eNS_URI) instanceof Oarp4_datatypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Oarp4_datatypesPackage.eNS_URI) : Oarp4_datatypesPackage.eINSTANCE);
		Std_datatypesPackageImpl theStd_datatypesPackage = (Std_datatypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Std_datatypesPackage.eNS_URI) instanceof Std_datatypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Std_datatypesPackage.eNS_URI) : Std_datatypesPackage.eINSTANCE);

		// Create package meta-data objects
		theSensor_datatypesPackage.createPackageContents();
		theRobotMLPackage.createPackageContents();
		theDiagnostic_datatypesPackage.createPackageContents();
		theGeometry_datatypesPackage.createPackageContents();
		theNav_datatypesPackage.createPackageContents();
		theActionlib_datatypesPackage.createPackageContents();
		theOarp1_datatypesPackage.createPackageContents();
		theOarp4_datatypesPackage.createPackageContents();
		theStd_datatypesPackage.createPackageContents();

		// Initialize created meta-data
		theSensor_datatypesPackage.initializePackageContents();
		theRobotMLPackage.initializePackageContents();
		theDiagnostic_datatypesPackage.initializePackageContents();
		theGeometry_datatypesPackage.initializePackageContents();
		theNav_datatypesPackage.initializePackageContents();
		theActionlib_datatypesPackage.initializePackageContents();
		theOarp1_datatypesPackage.initializePackageContents();
		theOarp4_datatypesPackage.initializePackageContents();
		theStd_datatypesPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSensor_datatypesPackage.freeze();


		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(Sensor_datatypesPackage.eNS_URI, theSensor_datatypesPackage);
		return theSensor_datatypesPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getRegionOfInterest() {
		return regionOfInterestEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getRegionOfInterest_X_offset() {
		return (EAttribute)regionOfInterestEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getRegionOfInterest_Y_offset() {
		return (EAttribute)regionOfInterestEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getRegionOfInterest_Height() {
		return (EAttribute)regionOfInterestEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getRegionOfInterest_Do_rectify() {
		return (EAttribute)regionOfInterestEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getRegionOfInterest_Width() {
		return (EAttribute)regionOfInterestEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getRange() {
		return rangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getRange_ULTRASOUND() {
		return (EAttribute)rangeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getRange_INFRARED() {
		return (EAttribute)rangeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getRange_Header() {
		return (EReference)rangeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getRange_Radiation_type() {
		return (EAttribute)rangeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getRange_Field_of_view() {
		return (EAttribute)rangeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getRange_Min_range() {
		return (EAttribute)rangeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getRange_Max_range() {
		return (EAttribute)rangeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getRange_Range() {
		return (EAttribute)rangeEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getCameraInfo() {
		return cameraInfoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getCameraInfo_Header() {
		return (EReference)cameraInfoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getCameraInfo_Height() {
		return (EAttribute)cameraInfoEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getCameraInfo_Width() {
		return (EAttribute)cameraInfoEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getCameraInfo_Distorsion_model() {
		return (EAttribute)cameraInfoEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getCameraInfo_D() {
		return (EAttribute)cameraInfoEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getCameraInfo_K() {
		return (EAttribute)cameraInfoEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getCameraInfo_R() {
		return (EAttribute)cameraInfoEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getCameraInfo_P() {
		return (EAttribute)cameraInfoEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getCameraInfo_Binning_x() {
		return (EAttribute)cameraInfoEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getCameraInfo_Binning_y() {
		return (EAttribute)cameraInfoEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getCameraInfo_Roi() {
		return (EReference)cameraInfoEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getImu() {
		return imuEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getImu_Header() {
		return (EReference)imuEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getImu_Orientation() {
		return (EReference)imuEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getImu_Orientation_covariance() {
		return (EAttribute)imuEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getImu_Angular_velocity() {
		return (EReference)imuEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getImu_Angular_velocity_covariance() {
		return (EAttribute)imuEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getImu_Linear_acceleration() {
		return (EReference)imuEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getImu_Linear_acceleration_covariance() {
		return (EAttribute)imuEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getLaserScan() {
		return laserScanEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getLaserScan_Header() {
		return (EReference)laserScanEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getLaserScan_Angle_min() {
		return (EAttribute)laserScanEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getLaserScan_Angle_max() {
		return (EAttribute)laserScanEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getLaserScan_Angle_increment() {
		return (EAttribute)laserScanEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getLaserScan_Time_increment() {
		return (EAttribute)laserScanEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getLaserScan_Scan_time() {
		return (EAttribute)laserScanEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getLaserScan_Range_min() {
		return (EAttribute)laserScanEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getLaserScan_Range_max() {
		return (EAttribute)laserScanEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getLaserScan_Range() {
		return (EAttribute)laserScanEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getLaserScan_Intensities() {
		return (EAttribute)laserScanEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getImage() {
		return imageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getImage_Header() {
		return (EReference)imageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getImage_Height() {
		return (EAttribute)imageEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getImage_Width() {
		return (EAttribute)imageEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getImage_Encoding() {
		return (EAttribute)imageEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getImage_Is_bigendian() {
		return (EAttribute)imageEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getImage_Step() {
		return (EAttribute)imageEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getImage_Data() {
		return (EAttribute)imageEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getChannelFloat32() {
		return channelFloat32EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getChannelFloat32_Name() {
		return (EAttribute)channelFloat32EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getChannelFloat32_Values() {
		return (EAttribute)channelFloat32EClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getCompressedImage() {
		return compressedImageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getCompressedImage_Header() {
		return (EReference)compressedImageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getCompressedImage_Format() {
		return (EAttribute)compressedImageEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getCompressedImage_Data() {
		return (EAttribute)compressedImageEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getPointCloud() {
		return pointCloudEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getPointCloud_Header() {
		return (EReference)pointCloudEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getPointCloud_Points() {
		return (EReference)pointCloudEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getPointCloud_Channels() {
		return (EReference)pointCloudEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getPointField() {
		return pointFieldEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getPointField_Name() {
		return (EAttribute)pointFieldEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getPointField_Offset() {
		return (EAttribute)pointFieldEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getPointField_Datatype() {
		return (EAttribute)pointFieldEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getPointField_Count() {
		return (EAttribute)pointFieldEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getPointCloud2() {
		return pointCloud2EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getPointCloud2_Header() {
		return (EReference)pointCloud2EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getPointCloud2_Height() {
		return (EAttribute)pointCloud2EClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getPointCloud2_Width() {
		return (EAttribute)pointCloud2EClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getPointCloud2_Fields() {
		return (EReference)pointCloud2EClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getPointCloud2_Is_bigendian() {
		return (EAttribute)pointCloud2EClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getPointCloud2_Point_step() {
		return (EAttribute)pointCloud2EClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getPointCloud2_Row_step() {
		return (EAttribute)pointCloud2EClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getPointCloud2_Data() {
		return (EAttribute)pointCloud2EClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getPointCloud2_Is_dense() {
		return (EAttribute)pointCloud2EClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getJointState() {
		return jointStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getJointState_Name() {
		return (EAttribute)jointStateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getJointState_Position() {
		return (EAttribute)jointStateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getJointState_Velocity() {
		return (EAttribute)jointStateEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getJointState_Effort() {
		return (EAttribute)jointStateEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getNavSatStatus() {
		return navSatStatusEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getNavSatStatus_STATUS_NO_FIX() {
		return (EAttribute)navSatStatusEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getNavSatStatus_STATUS_FIX() {
		return (EAttribute)navSatStatusEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getNavSatStatus_STATUS_SBAS_FIX() {
		return (EAttribute)navSatStatusEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getNavSatStatus_STATUS_GBAS_FIX() {
		return (EAttribute)navSatStatusEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getNavSatStatus_Status() {
		return (EAttribute)navSatStatusEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getNavSatStatus_SERVICE_GPS() {
		return (EAttribute)navSatStatusEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getNavSatStatus_SERVICE_GLONASS() {
		return (EAttribute)navSatStatusEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getNavSatStatus_SERVICE_COMPASS() {
		return (EAttribute)navSatStatusEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getNavSatStatus_SERVICE_GALILEO() {
		return (EAttribute)navSatStatusEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getNavSatStatus_Service() {
		return (EAttribute)navSatStatusEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getNavSatFix() {
		return navSatFixEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getNavSatFix_Status() {
		return (EAttribute)navSatFixEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getNavSatFix_Service() {
		return (EAttribute)navSatFixEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getNavSatFix_Header() {
		return (EReference)navSatFixEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getNavSatFix_Latitude() {
		return (EAttribute)navSatFixEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getNavSatFix_Longitude() {
		return (EAttribute)navSatFixEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getNavSatFix_Altitude() {
		return (EAttribute)navSatFixEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getNavSatFix_Position_covariance() {
		return (EAttribute)navSatFixEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getNavSatFix_Position_covariance_type() {
		return (EAttribute)navSatFixEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getJoy() {
		return joyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getJoy_Header() {
		return (EReference)joyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getJoy_Axes() {
		return (EAttribute)joyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getJoy_Buttons() {
		return (EAttribute)joyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getJoyFeedback() {
		return joyFeedbackEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getJoyFeedback_TYPE_LED() {
		return (EAttribute)joyFeedbackEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getJoyFeedback_TYPE_RUMBLE() {
		return (EAttribute)joyFeedbackEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getJoyFeedback_TYPE_BUZZER() {
		return (EAttribute)joyFeedbackEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getJoyFeedback_Type() {
		return (EAttribute)joyFeedbackEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getJoyFeedback_Id() {
		return (EAttribute)joyFeedbackEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getJoyFeedback_Intensity() {
		return (EAttribute)joyFeedbackEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getJoyFeedbackArray() {
		return joyFeedbackArrayEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getJoyFeedbackArray_Array() {
		return (EReference)joyFeedbackArrayEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getCarLikeOdometry() {
		return carLikeOdometryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getCarLikeOdometry_Header() {
		return (EReference)carLikeOdometryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getCarLikeOdometry_Steering_angle() {
		return (EAttribute)carLikeOdometryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getCarLikeOdometry_Left_rear_wheel_distance() {
		return (EAttribute)carLikeOdometryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getCarLikeOdometry_Right_rear_wheel_distance() {
		return (EAttribute)carLikeOdometryEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getCarLikeOdometry_Right_rear_wheel_velocity() {
		return (EAttribute)carLikeOdometryEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getCarLikeOdometry_Left_rear_wheel_velocity() {
		return (EAttribute)carLikeOdometryEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getDifferentialOdometry() {
		return differentialOdometryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getDifferentialOdometry_Header() {
		return (EReference)differentialOdometryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getDifferentialOdometry_Right_distance() {
		return (EAttribute)differentialOdometryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getDifferentialOdometry_Left_distance() {
		return (EAttribute)differentialOdometryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getDifferentialOdometry_Left_velocity() {
		return (EAttribute)differentialOdometryEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getDifferentialOdometry_Right_velocity() {
		return (EAttribute)differentialOdometryEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EEnum getSTATUS_TYPE() {
		return statuS_TYPEEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EEnum getSERVICE_TYPE() {
		return servicE_TYPEEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EEnum getCOVARIANCE_TYPE() {
		return covariancE_TYPEEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Sensor_datatypesFactory getSensor_datatypesFactory() {
		return (Sensor_datatypesFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package. This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void createPackageContents() {
		if(isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		regionOfInterestEClass = createEClass(REGION_OF_INTEREST);
		createEAttribute(regionOfInterestEClass, REGION_OF_INTEREST__XOFFSET);
		createEAttribute(regionOfInterestEClass, REGION_OF_INTEREST__YOFFSET);
		createEAttribute(regionOfInterestEClass, REGION_OF_INTEREST__HEIGHT);
		createEAttribute(regionOfInterestEClass, REGION_OF_INTEREST__DO_RECTIFY);
		createEAttribute(regionOfInterestEClass, REGION_OF_INTEREST__WIDTH);

		rangeEClass = createEClass(RANGE);
		createEAttribute(rangeEClass, RANGE__ULTRASOUND);
		createEAttribute(rangeEClass, RANGE__INFRARED);
		createEReference(rangeEClass, RANGE__HEADER);
		createEAttribute(rangeEClass, RANGE__RADIATION_TYPE);
		createEAttribute(rangeEClass, RANGE__FIELD_OF_VIEW);
		createEAttribute(rangeEClass, RANGE__MIN_RANGE);
		createEAttribute(rangeEClass, RANGE__MAX_RANGE);
		createEAttribute(rangeEClass, RANGE__RANGE);

		cameraInfoEClass = createEClass(CAMERA_INFO);
		createEReference(cameraInfoEClass, CAMERA_INFO__HEADER);
		createEAttribute(cameraInfoEClass, CAMERA_INFO__HEIGHT);
		createEAttribute(cameraInfoEClass, CAMERA_INFO__WIDTH);
		createEAttribute(cameraInfoEClass, CAMERA_INFO__DISTORSION_MODEL);
		createEAttribute(cameraInfoEClass, CAMERA_INFO__D);
		createEAttribute(cameraInfoEClass, CAMERA_INFO__K);
		createEAttribute(cameraInfoEClass, CAMERA_INFO__R);
		createEAttribute(cameraInfoEClass, CAMERA_INFO__P);
		createEAttribute(cameraInfoEClass, CAMERA_INFO__BINNING_X);
		createEAttribute(cameraInfoEClass, CAMERA_INFO__BINNING_Y);
		createEReference(cameraInfoEClass, CAMERA_INFO__ROI);

		imuEClass = createEClass(IMU);
		createEReference(imuEClass, IMU__HEADER);
		createEReference(imuEClass, IMU__ORIENTATION);
		createEAttribute(imuEClass, IMU__ORIENTATION_COVARIANCE);
		createEReference(imuEClass, IMU__ANGULAR_VELOCITY);
		createEAttribute(imuEClass, IMU__ANGULAR_VELOCITY_COVARIANCE);
		createEReference(imuEClass, IMU__LINEAR_ACCELERATION);
		createEAttribute(imuEClass, IMU__LINEAR_ACCELERATION_COVARIANCE);

		laserScanEClass = createEClass(LASER_SCAN);
		createEReference(laserScanEClass, LASER_SCAN__HEADER);
		createEAttribute(laserScanEClass, LASER_SCAN__ANGLE_MIN);
		createEAttribute(laserScanEClass, LASER_SCAN__ANGLE_MAX);
		createEAttribute(laserScanEClass, LASER_SCAN__ANGLE_INCREMENT);
		createEAttribute(laserScanEClass, LASER_SCAN__TIME_INCREMENT);
		createEAttribute(laserScanEClass, LASER_SCAN__SCAN_TIME);
		createEAttribute(laserScanEClass, LASER_SCAN__RANGE_MIN);
		createEAttribute(laserScanEClass, LASER_SCAN__RANGE_MAX);
		createEAttribute(laserScanEClass, LASER_SCAN__RANGE);
		createEAttribute(laserScanEClass, LASER_SCAN__INTENSITIES);

		imageEClass = createEClass(IMAGE);
		createEReference(imageEClass, IMAGE__HEADER);
		createEAttribute(imageEClass, IMAGE__HEIGHT);
		createEAttribute(imageEClass, IMAGE__WIDTH);
		createEAttribute(imageEClass, IMAGE__ENCODING);
		createEAttribute(imageEClass, IMAGE__IS_BIGENDIAN);
		createEAttribute(imageEClass, IMAGE__STEP);
		createEAttribute(imageEClass, IMAGE__DATA);

		channelFloat32EClass = createEClass(CHANNEL_FLOAT32);
		createEAttribute(channelFloat32EClass, CHANNEL_FLOAT32__NAME);
		createEAttribute(channelFloat32EClass, CHANNEL_FLOAT32__VALUES);

		compressedImageEClass = createEClass(COMPRESSED_IMAGE);
		createEReference(compressedImageEClass, COMPRESSED_IMAGE__HEADER);
		createEAttribute(compressedImageEClass, COMPRESSED_IMAGE__FORMAT);
		createEAttribute(compressedImageEClass, COMPRESSED_IMAGE__DATA);

		pointCloudEClass = createEClass(POINT_CLOUD);
		createEReference(pointCloudEClass, POINT_CLOUD__HEADER);
		createEReference(pointCloudEClass, POINT_CLOUD__POINTS);
		createEReference(pointCloudEClass, POINT_CLOUD__CHANNELS);

		pointFieldEClass = createEClass(POINT_FIELD);
		createEAttribute(pointFieldEClass, POINT_FIELD__NAME);
		createEAttribute(pointFieldEClass, POINT_FIELD__OFFSET);
		createEAttribute(pointFieldEClass, POINT_FIELD__DATATYPE);
		createEAttribute(pointFieldEClass, POINT_FIELD__COUNT);

		pointCloud2EClass = createEClass(POINT_CLOUD2);
		createEReference(pointCloud2EClass, POINT_CLOUD2__HEADER);
		createEAttribute(pointCloud2EClass, POINT_CLOUD2__HEIGHT);
		createEAttribute(pointCloud2EClass, POINT_CLOUD2__WIDTH);
		createEReference(pointCloud2EClass, POINT_CLOUD2__FIELDS);
		createEAttribute(pointCloud2EClass, POINT_CLOUD2__IS_BIGENDIAN);
		createEAttribute(pointCloud2EClass, POINT_CLOUD2__POINT_STEP);
		createEAttribute(pointCloud2EClass, POINT_CLOUD2__ROW_STEP);
		createEAttribute(pointCloud2EClass, POINT_CLOUD2__DATA);
		createEAttribute(pointCloud2EClass, POINT_CLOUD2__IS_DENSE);

		jointStateEClass = createEClass(JOINT_STATE);
		createEAttribute(jointStateEClass, JOINT_STATE__NAME);
		createEAttribute(jointStateEClass, JOINT_STATE__POSITION);
		createEAttribute(jointStateEClass, JOINT_STATE__VELOCITY);
		createEAttribute(jointStateEClass, JOINT_STATE__EFFORT);

		navSatStatusEClass = createEClass(NAV_SAT_STATUS);
		createEAttribute(navSatStatusEClass, NAV_SAT_STATUS__STATUS_NO_FIX);
		createEAttribute(navSatStatusEClass, NAV_SAT_STATUS__STATUS_FIX);
		createEAttribute(navSatStatusEClass, NAV_SAT_STATUS__STATUS_SBAS_FIX);
		createEAttribute(navSatStatusEClass, NAV_SAT_STATUS__STATUS_GBAS_FIX);
		createEAttribute(navSatStatusEClass, NAV_SAT_STATUS__STATUS);
		createEAttribute(navSatStatusEClass, NAV_SAT_STATUS__SERVICE_GPS);
		createEAttribute(navSatStatusEClass, NAV_SAT_STATUS__SERVICE_GLONASS);
		createEAttribute(navSatStatusEClass, NAV_SAT_STATUS__SERVICE_COMPASS);
		createEAttribute(navSatStatusEClass, NAV_SAT_STATUS__SERVICE_GALILEO);
		createEAttribute(navSatStatusEClass, NAV_SAT_STATUS__SERVICE);

		navSatFixEClass = createEClass(NAV_SAT_FIX);
		createEAttribute(navSatFixEClass, NAV_SAT_FIX__STATUS);
		createEAttribute(navSatFixEClass, NAV_SAT_FIX__SERVICE);
		createEReference(navSatFixEClass, NAV_SAT_FIX__HEADER);
		createEAttribute(navSatFixEClass, NAV_SAT_FIX__LATITUDE);
		createEAttribute(navSatFixEClass, NAV_SAT_FIX__LONGITUDE);
		createEAttribute(navSatFixEClass, NAV_SAT_FIX__ALTITUDE);
		createEAttribute(navSatFixEClass, NAV_SAT_FIX__POSITION_COVARIANCE);
		createEAttribute(navSatFixEClass, NAV_SAT_FIX__POSITION_COVARIANCE_TYPE);

		joyEClass = createEClass(JOY);
		createEReference(joyEClass, JOY__HEADER);
		createEAttribute(joyEClass, JOY__AXES);
		createEAttribute(joyEClass, JOY__BUTTONS);

		joyFeedbackEClass = createEClass(JOY_FEEDBACK);
		createEAttribute(joyFeedbackEClass, JOY_FEEDBACK__TYPE_LED);
		createEAttribute(joyFeedbackEClass, JOY_FEEDBACK__TYPE_RUMBLE);
		createEAttribute(joyFeedbackEClass, JOY_FEEDBACK__TYPE_BUZZER);
		createEAttribute(joyFeedbackEClass, JOY_FEEDBACK__TYPE);
		createEAttribute(joyFeedbackEClass, JOY_FEEDBACK__ID);
		createEAttribute(joyFeedbackEClass, JOY_FEEDBACK__INTENSITY);

		joyFeedbackArrayEClass = createEClass(JOY_FEEDBACK_ARRAY);
		createEReference(joyFeedbackArrayEClass, JOY_FEEDBACK_ARRAY__ARRAY);

		carLikeOdometryEClass = createEClass(CAR_LIKE_ODOMETRY);
		createEReference(carLikeOdometryEClass, CAR_LIKE_ODOMETRY__HEADER);
		createEAttribute(carLikeOdometryEClass, CAR_LIKE_ODOMETRY__STEERING_ANGLE);
		createEAttribute(carLikeOdometryEClass, CAR_LIKE_ODOMETRY__LEFT_REAR_WHEEL_DISTANCE);
		createEAttribute(carLikeOdometryEClass, CAR_LIKE_ODOMETRY__RIGHT_REAR_WHEEL_DISTANCE);
		createEAttribute(carLikeOdometryEClass, CAR_LIKE_ODOMETRY__RIGHT_REAR_WHEEL_VELOCITY);
		createEAttribute(carLikeOdometryEClass, CAR_LIKE_ODOMETRY__LEFT_REAR_WHEEL_VELOCITY);

		differentialOdometryEClass = createEClass(DIFFERENTIAL_ODOMETRY);
		createEReference(differentialOdometryEClass, DIFFERENTIAL_ODOMETRY__HEADER);
		createEAttribute(differentialOdometryEClass, DIFFERENTIAL_ODOMETRY__RIGHT_DISTANCE);
		createEAttribute(differentialOdometryEClass, DIFFERENTIAL_ODOMETRY__LEFT_DISTANCE);
		createEAttribute(differentialOdometryEClass, DIFFERENTIAL_ODOMETRY__LEFT_VELOCITY);
		createEAttribute(differentialOdometryEClass, DIFFERENTIAL_ODOMETRY__RIGHT_VELOCITY);

		// Create enums
		statuS_TYPEEEnum = createEEnum(STATUS_TYPE);
		servicE_TYPEEEnum = createEEnum(SERVICE_TYPE);
		covariancE_TYPEEEnum = createEEnum(COVARIANCE_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model. This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void initializePackageContents() {
		if(isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		Std_datatypesPackage theStd_datatypesPackage = (Std_datatypesPackage)EPackage.Registry.INSTANCE.getEPackage(Std_datatypesPackage.eNS_URI);
		Geometry_datatypesPackage theGeometry_datatypesPackage = (Geometry_datatypesPackage)EPackage.Registry.INSTANCE.getEPackage(Geometry_datatypesPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(regionOfInterestEClass, RegionOfInterest.class, "RegionOfInterest", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRegionOfInterest_X_offset(), theStd_datatypesPackage.getUInt32(), "x_offset", null, 1, 1, RegionOfInterest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getRegionOfInterest_Y_offset(), theStd_datatypesPackage.getUInt32(), "y_offset", null, 1, 1, RegionOfInterest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getRegionOfInterest_Height(), theStd_datatypesPackage.getUInt32(), "height", null, 1, 1, RegionOfInterest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getRegionOfInterest_Do_rectify(), theStd_datatypesPackage.getBool(), "do_rectify", null, 1, 1, RegionOfInterest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getRegionOfInterest_Width(), theStd_datatypesPackage.getUInt32(), "width", null, 1, 1, RegionOfInterest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(rangeEClass, Range.class, "Range", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRange_ULTRASOUND(), theStd_datatypesPackage.getUInt8(), "ULTRASOUND", null, 1, 1, Range.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getRange_INFRARED(), theStd_datatypesPackage.getUInt8(), "INFRARED", null, 1, 1, Range.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getRange_Header(), theStd_datatypesPackage.getHeader(), null, "header", null, 1, 1, Range.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getRange_Radiation_type(), theStd_datatypesPackage.getUInt8(), "radiation_type", null, 1, 1, Range.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getRange_Field_of_view(), theStd_datatypesPackage.getFloat32(), "field_of_view", null, 1, 1, Range.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getRange_Min_range(), theStd_datatypesPackage.getFloat32(), "min_range", null, 1, 1, Range.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getRange_Max_range(), theStd_datatypesPackage.getFloat32(), "max_range", null, 1, 1, Range.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getRange_Range(), theStd_datatypesPackage.getFloat32(), "range", null, 1, 1, Range.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(cameraInfoEClass, CameraInfo.class, "CameraInfo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCameraInfo_Header(), theStd_datatypesPackage.getHeader(), null, "header", null, 1, 1, CameraInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCameraInfo_Height(), theStd_datatypesPackage.getUInt32(), "height", null, 1, 1, CameraInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCameraInfo_Width(), theStd_datatypesPackage.getUInt32(), "width", null, 1, 1, CameraInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCameraInfo_Distorsion_model(), theStd_datatypesPackage.getString(), "distorsion_model", null, 1, 1, CameraInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCameraInfo_D(), theStd_datatypesPackage.getFloat64(), "D", null, 0, -1, CameraInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCameraInfo_K(), theStd_datatypesPackage.getFloat64(), "K", null, 9, 9, CameraInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCameraInfo_R(), theStd_datatypesPackage.getFloat64(), "R", null, 9, 9, CameraInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCameraInfo_P(), theStd_datatypesPackage.getFloat64(), "P", null, 12, 12, CameraInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCameraInfo_Binning_x(), theStd_datatypesPackage.getUInt32(), "binning_x", null, 1, 1, CameraInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCameraInfo_Binning_y(), theStd_datatypesPackage.getUInt32(), "binning_y", null, 1, 1, CameraInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCameraInfo_Roi(), this.getRegionOfInterest(), null, "roi", null, 1, 1, CameraInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(imuEClass, Imu.class, "Imu", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getImu_Header(), theStd_datatypesPackage.getHeader(), null, "header", null, 1, 1, Imu.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getImu_Orientation(), theGeometry_datatypesPackage.getQuaternion(), null, "orientation", null, 1, 1, Imu.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getImu_Orientation_covariance(), theStd_datatypesPackage.getFloat64(), "orientation_covariance", null, 9, 9, Imu.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getImu_Angular_velocity(), theGeometry_datatypesPackage.getVector3(), null, "angular_velocity", null, 1, 1, Imu.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getImu_Angular_velocity_covariance(), theStd_datatypesPackage.getFloat64(), "angular_velocity_covariance", null, 9, 9, Imu.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getImu_Linear_acceleration(), theGeometry_datatypesPackage.getVector3(), null, "linear_acceleration", null, 1, 1, Imu.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getImu_Linear_acceleration_covariance(), theStd_datatypesPackage.getFloat64(), "linear_acceleration_covariance", null, 9, 9, Imu.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(laserScanEClass, LaserScan.class, "LaserScan", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLaserScan_Header(), theStd_datatypesPackage.getHeader(), null, "header", null, 1, 1, LaserScan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getLaserScan_Angle_min(), theStd_datatypesPackage.getFloat32(), "angle_min", null, 1, 1, LaserScan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getLaserScan_Angle_max(), theStd_datatypesPackage.getFloat32(), "angle_max", null, 1, 1, LaserScan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getLaserScan_Angle_increment(), theStd_datatypesPackage.getFloat32(), "angle_increment", null, 1, 1, LaserScan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getLaserScan_Time_increment(), theStd_datatypesPackage.getFloat32(), "time_increment", null, 1, 1, LaserScan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getLaserScan_Scan_time(), theStd_datatypesPackage.getFloat32(), "scan_time", null, 1, 1, LaserScan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getLaserScan_Range_min(), theStd_datatypesPackage.getFloat32(), "range_min", null, 1, 1, LaserScan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getLaserScan_Range_max(), theStd_datatypesPackage.getFloat32(), "range_max", null, 1, 1, LaserScan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getLaserScan_Range(), theStd_datatypesPackage.getFloat32(), "range", null, 0, -1, LaserScan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getLaserScan_Intensities(), theStd_datatypesPackage.getFloat32(), "intensities", null, 0, -1, LaserScan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(imageEClass, Image.class, "Image", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getImage_Header(), theStd_datatypesPackage.getHeader(), null, "header", null, 1, 1, Image.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getImage_Height(), theStd_datatypesPackage.getUInt32(), "height", null, 1, 1, Image.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getImage_Width(), theStd_datatypesPackage.getUInt32(), "width", null, 1, 1, Image.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getImage_Encoding(), theStd_datatypesPackage.getString(), "encoding", null, 1, 1, Image.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getImage_Is_bigendian(), theStd_datatypesPackage.getUInt8(), "is_bigendian", null, 1, 1, Image.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getImage_Step(), theStd_datatypesPackage.getUInt32(), "step", null, 1, 1, Image.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getImage_Data(), theStd_datatypesPackage.getUInt8(), "data", null, 0, -1, Image.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(channelFloat32EClass, ChannelFloat32.class, "ChannelFloat32", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getChannelFloat32_Name(), theStd_datatypesPackage.getString(), "name", null, 1, 1, ChannelFloat32.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getChannelFloat32_Values(), theStd_datatypesPackage.getFloat32(), "values", null, 0, -1, ChannelFloat32.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(compressedImageEClass, CompressedImage.class, "CompressedImage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompressedImage_Header(), theStd_datatypesPackage.getHeader(), null, "header", null, 1, 1, CompressedImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCompressedImage_Format(), theStd_datatypesPackage.getString(), "format", null, 1, 1, CompressedImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCompressedImage_Data(), theStd_datatypesPackage.getUInt8(), "data", null, 0, -1, CompressedImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(pointCloudEClass, PointCloud.class, "PointCloud", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPointCloud_Header(), theStd_datatypesPackage.getHeader(), null, "header", null, 1, 1, PointCloud.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getPointCloud_Points(), theGeometry_datatypesPackage.getPoint32(), null, "points", null, 0, -1, PointCloud.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getPointCloud_Channels(), this.getChannelFloat32(), null, "channels", null, 0, -1, PointCloud.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(pointFieldEClass, PointField.class, "PointField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPointField_Name(), theStd_datatypesPackage.getString(), "name", null, 1, 1, PointField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getPointField_Offset(), theStd_datatypesPackage.getUInt32(), "offset", null, 1, 1, PointField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getPointField_Datatype(), theStd_datatypesPackage.getUInt8(), "datatype", null, 1, 1, PointField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getPointField_Count(), theStd_datatypesPackage.getUInt32(), "count", null, 1, 1, PointField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(pointCloud2EClass, PointCloud2.class, "PointCloud2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPointCloud2_Header(), theStd_datatypesPackage.getHeader(), null, "header", null, 1, 1, PointCloud2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getPointCloud2_Height(), theStd_datatypesPackage.getUInt32(), "height", null, 1, 1, PointCloud2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getPointCloud2_Width(), theStd_datatypesPackage.getUInt32(), "width", null, 1, 1, PointCloud2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getPointCloud2_Fields(), this.getPointField(), null, "fields", null, 0, -1, PointCloud2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getPointCloud2_Is_bigendian(), theStd_datatypesPackage.getBool(), "is_bigendian", null, 1, 1, PointCloud2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getPointCloud2_Point_step(), theStd_datatypesPackage.getUInt32(), "point_step", null, 1, 1, PointCloud2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getPointCloud2_Row_step(), theStd_datatypesPackage.getUInt32(), "row_step", null, 1, 1, PointCloud2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getPointCloud2_Data(), theStd_datatypesPackage.getUInt8(), "data", null, 0, -1, PointCloud2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getPointCloud2_Is_dense(), theStd_datatypesPackage.getBool(), "is_dense", null, 1, 1, PointCloud2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(jointStateEClass, JointState.class, "JointState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJointState_Name(), theStd_datatypesPackage.getString(), "name", null, 0, -1, JointState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getJointState_Position(), theStd_datatypesPackage.getFloat64(), "position", null, 0, -1, JointState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getJointState_Velocity(), theStd_datatypesPackage.getFloat64(), "velocity", null, 0, -1, JointState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getJointState_Effort(), theStd_datatypesPackage.getFloat64(), "effort", null, 0, -1, JointState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(navSatStatusEClass, NavSatStatus.class, "NavSatStatus", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNavSatStatus_STATUS_NO_FIX(), theStd_datatypesPackage.getInt8(), "STATUS_NO_FIX", "-1", 1, 1, NavSatStatus.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getNavSatStatus_STATUS_FIX(), theStd_datatypesPackage.getInt8(), "STATUS_FIX", "0", 1, 1, NavSatStatus.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getNavSatStatus_STATUS_SBAS_FIX(), theStd_datatypesPackage.getInt8(), "STATUS_SBAS_FIX", "1", 1, 1, NavSatStatus.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getNavSatStatus_STATUS_GBAS_FIX(), theStd_datatypesPackage.getInt8(), "STATUS_GBAS_FIX", "2", 1, 1, NavSatStatus.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getNavSatStatus_Status(), theStd_datatypesPackage.getInt8(), "status", null, 1, 1, NavSatStatus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getNavSatStatus_SERVICE_GPS(), theStd_datatypesPackage.getUInt16(), "SERVICE_GPS", "1", 1, 1, NavSatStatus.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getNavSatStatus_SERVICE_GLONASS(), theStd_datatypesPackage.getUInt16(), "SERVICE_GLONASS", "2", 1, 1, NavSatStatus.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getNavSatStatus_SERVICE_COMPASS(), theStd_datatypesPackage.getUInt16(), "SERVICE_COMPASS", "4", 1, 1, NavSatStatus.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getNavSatStatus_SERVICE_GALILEO(), theStd_datatypesPackage.getUInt16(), "SERVICE_GALILEO", "8", 1, 1, NavSatStatus.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getNavSatStatus_Service(), theStd_datatypesPackage.getUInt16(), "service", null, 1, 1, NavSatStatus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(navSatFixEClass, NavSatFix.class, "NavSatFix", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNavSatFix_Status(), this.getSTATUS_TYPE(), "status", null, 1, 1, NavSatFix.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getNavSatFix_Service(), this.getSERVICE_TYPE(), "service", null, 1, 1, NavSatFix.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getNavSatFix_Header(), theStd_datatypesPackage.getHeader(), null, "header", null, 1, 1, NavSatFix.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getNavSatFix_Latitude(), theStd_datatypesPackage.getFloat64(), "latitude", null, 1, 1, NavSatFix.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getNavSatFix_Longitude(), theStd_datatypesPackage.getFloat64(), "longitude", null, 1, 1, NavSatFix.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getNavSatFix_Altitude(), theStd_datatypesPackage.getFloat64(), "altitude", null, 1, 1, NavSatFix.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getNavSatFix_Position_covariance(), theStd_datatypesPackage.getFloat64(), "position_covariance", null, 9, 9, NavSatFix.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getNavSatFix_Position_covariance_type(), this.getCOVARIANCE_TYPE(), "position_covariance_type", null, 1, 1, NavSatFix.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(joyEClass, Joy.class, "Joy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJoy_Header(), theStd_datatypesPackage.getHeader(), null, "header", null, 1, 1, Joy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getJoy_Axes(), theStd_datatypesPackage.getFloat32(), "axes", null, 0, -1, Joy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getJoy_Buttons(), theStd_datatypesPackage.getInt32(), "buttons", null, 0, -1, Joy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(joyFeedbackEClass, JoyFeedback.class, "JoyFeedback", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJoyFeedback_TYPE_LED(), theStd_datatypesPackage.getUInt8(), "TYPE_LED", "0", 1, 1, JoyFeedback.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getJoyFeedback_TYPE_RUMBLE(), theStd_datatypesPackage.getUInt8(), "TYPE_RUMBLE", "1", 1, 1, JoyFeedback.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getJoyFeedback_TYPE_BUZZER(), theStd_datatypesPackage.getUInt8(), "TYPE_BUZZER", "2", 1, 1, JoyFeedback.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getJoyFeedback_Type(), theStd_datatypesPackage.getUInt8(), "type", null, 1, 1, JoyFeedback.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getJoyFeedback_Id(), theStd_datatypesPackage.getUInt8(), "id", null, 1, 1, JoyFeedback.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getJoyFeedback_Intensity(), theStd_datatypesPackage.getFloat32(), "intensity", null, 1, 1, JoyFeedback.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(joyFeedbackArrayEClass, JoyFeedbackArray.class, "JoyFeedbackArray", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJoyFeedbackArray_Array(), this.getJoyFeedback(), null, "array", null, 0, -1, JoyFeedbackArray.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(carLikeOdometryEClass, CarLikeOdometry.class, "CarLikeOdometry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCarLikeOdometry_Header(), theStd_datatypesPackage.getHeader(), null, "header", null, 1, 1, CarLikeOdometry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCarLikeOdometry_Steering_angle(), theStd_datatypesPackage.getFloat64(), "steering_angle", null, 1, 1, CarLikeOdometry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCarLikeOdometry_Left_rear_wheel_distance(), theStd_datatypesPackage.getFloat64(), "left_rear_wheel_distance", null, 1, 1, CarLikeOdometry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCarLikeOdometry_Right_rear_wheel_distance(), theStd_datatypesPackage.getFloat64(), "right_rear_wheel_distance", null, 1, 1, CarLikeOdometry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCarLikeOdometry_Right_rear_wheel_velocity(), theStd_datatypesPackage.getFloat64(), "right_rear_wheel_velocity", null, 1, 1, CarLikeOdometry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCarLikeOdometry_Left_rear_wheel_velocity(), theStd_datatypesPackage.getFloat64(), "left_rear_wheel_velocity", null, 1, 1, CarLikeOdometry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(differentialOdometryEClass, DifferentialOdometry.class, "DifferentialOdometry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDifferentialOdometry_Header(), theStd_datatypesPackage.getHeader(), null, "header", null, 1, 1, DifferentialOdometry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDifferentialOdometry_Right_distance(), theStd_datatypesPackage.getFloat64(), "right_distance", null, 1, 1, DifferentialOdometry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDifferentialOdometry_Left_distance(), theStd_datatypesPackage.getFloat64(), "left_distance", null, 1, 1, DifferentialOdometry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDifferentialOdometry_Left_velocity(), theStd_datatypesPackage.getFloat64(), "left_velocity", null, 1, 1, DifferentialOdometry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDifferentialOdometry_Right_velocity(), theStd_datatypesPackage.getFloat64(), "right_velocity", null, 1, 1, DifferentialOdometry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(statuS_TYPEEEnum, org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.STATUS_TYPE.class, "STATUS_TYPE");
		addEEnumLiteral(statuS_TYPEEEnum, org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.STATUS_TYPE.STATUS_NO_FIX);
		addEEnumLiteral(statuS_TYPEEEnum, org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.STATUS_TYPE.STATUS_FIX);
		addEEnumLiteral(statuS_TYPEEEnum, org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.STATUS_TYPE.STATUS_SBAS_FIX);
		addEEnumLiteral(statuS_TYPEEEnum, org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.STATUS_TYPE.STATUS_GBAS_FIX);

		initEEnum(servicE_TYPEEEnum, org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.SERVICE_TYPE.class, "SERVICE_TYPE");
		addEEnumLiteral(servicE_TYPEEEnum, org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.SERVICE_TYPE.SERVICE_GPS);
		addEEnumLiteral(servicE_TYPEEEnum, org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.SERVICE_TYPE.SERVICE_GLONASS);
		addEEnumLiteral(servicE_TYPEEEnum, org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.SERVICE_TYPE.SERVICE_COMPASS);
		addEEnumLiteral(servicE_TYPEEEnum, org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.SERVICE_TYPE.SERVICE_GALILEO);

		initEEnum(covariancE_TYPEEEnum, org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.COVARIANCE_TYPE.class, "COVARIANCE_TYPE");
		addEEnumLiteral(covariancE_TYPEEEnum, org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.COVARIANCE_TYPE.COVARIANCE_TYPE_UNKNOWN);
		addEEnumLiteral(covariancE_TYPEEEnum, org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.COVARIANCE_TYPE.COVARIANCE_TYPE_APPROXIMATED);
		addEEnumLiteral(covariancE_TYPEEEnum, org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.COVARIANCE_TYPE._COVARIANCE_TYPE_DIAGONAL_KNOWN);
		addEEnumLiteral(covariancE_TYPEEEnum, org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.COVARIANCE_TYPE.COVARIANCE_TYPE_KNOWN);

		// Create resource
		createResource(eNS_URI);
	}

} //Sensor_datatypesPackageImpl
