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
package org.eclipse.papyrus.RobotML.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.papyrus.RobotML.ActuatorSystem;
import org.eclipse.papyrus.RobotML.Agent;
import org.eclipse.papyrus.RobotML.Algorithm;
import org.eclipse.papyrus.RobotML.AlgorithmLibrary;
import org.eclipse.papyrus.RobotML.Allocate;
import org.eclipse.papyrus.RobotML.BlenderMorse;
import org.eclipse.papyrus.RobotML.Building;
import org.eclipse.papyrus.RobotML.CameraSystem;
import org.eclipse.papyrus.RobotML.CycabTK;
import org.eclipse.papyrus.RobotML.DataFlowDirectionKind;
import org.eclipse.papyrus.RobotML.DataFlowPort;
import org.eclipse.papyrus.RobotML.DataType;
import org.eclipse.papyrus.RobotML.DeploymentPlan;
import org.eclipse.papyrus.RobotML.EngineSystem;
import org.eclipse.papyrus.RobotML.Environment;
import org.eclipse.papyrus.RobotML.Floor;
import org.eclipse.papyrus.RobotML.GPSSystem;
import org.eclipse.papyrus.RobotML.Ground;
import org.eclipse.papyrus.RobotML.Gyroscope;
import org.eclipse.papyrus.RobotML.Hardware;
import org.eclipse.papyrus.RobotML.Human;
import org.eclipse.papyrus.RobotML.ImageSensorSystem;
import org.eclipse.papyrus.RobotML.InertialMeasurementUnitSystem;
import org.eclipse.papyrus.RobotML.InertialNavigationSystem;
import org.eclipse.papyrus.RobotML.InfraRedProximetrySystem;
import org.eclipse.papyrus.RobotML.LandSurface;
import org.eclipse.papyrus.RobotML.LidarSystem;
import org.eclipse.papyrus.RobotML.LocalizationSensorSystem;
import org.eclipse.papyrus.RobotML.ObjectDetectionSensorSystem;
import org.eclipse.papyrus.RobotML.ObjectTrackingSensorSystem;
import org.eclipse.papyrus.RobotML.OdometrySystem;
import org.eclipse.papyrus.RobotML.OnPort;
import org.eclipse.papyrus.RobotML.Pedestrian;
import org.eclipse.papyrus.RobotML.PhysicalObject;
import org.eclipse.papyrus.RobotML.Planet;
import org.eclipse.papyrus.RobotML.Platform;
import org.eclipse.papyrus.RobotML.Port;
import org.eclipse.papyrus.RobotML.PrimitiveData;
import org.eclipse.papyrus.RobotML.Robot;
import org.eclipse.papyrus.RobotML.RobotKind;
import org.eclipse.papyrus.RobotML.RobotMLFactory;
import org.eclipse.papyrus.RobotML.RobotMLPackage;
import org.eclipse.papyrus.RobotML.RoboticMiddleware;
import org.eclipse.papyrus.RobotML.RoboticMiddlewareKind;
import org.eclipse.papyrus.RobotML.RoboticSimulator;
import org.eclipse.papyrus.RobotML.RoboticSystem;
import org.eclipse.papyrus.RobotML.SensorDriver;
import org.eclipse.papyrus.RobotML.SensorSystem;
import org.eclipse.papyrus.RobotML.ServiceFlowKind;
import org.eclipse.papyrus.RobotML.ServicePort;
import org.eclipse.papyrus.RobotML.Shade;
import org.eclipse.papyrus.RobotML.SimulatedSystem;
import org.eclipse.papyrus.RobotML.Software;
import org.eclipse.papyrus.RobotML.Stairs;
import org.eclipse.papyrus.RobotML.State;
import org.eclipse.papyrus.RobotML.Surface;
import org.eclipse.papyrus.RobotML.SynchronizationKind;
import org.eclipse.papyrus.RobotML.Transition;
import org.eclipse.papyrus.RobotML.UGVKind;
import org.eclipse.papyrus.RobotML.WaterSurface;
import org.eclipse.papyrus.RobotML.WheelSystem;
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
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.Sensor_datatypesPackage;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.Sensor_datatypesPackageImpl;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Std_datatypesPackage;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.Std_datatypesPackageImpl;
import org.eclipse.uml2.types.TypesPackage;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class RobotMLPackageImpl extends EPackageImpl implements RobotMLPackage {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass transitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass algorithmEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass robotEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass systemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass agentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass physicalObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass environmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass surfaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass dataFlowPortEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass portEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass servicePortEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass actuatorSystemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass roboticSystemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass sensorSystemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass hardwareEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass softwareEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass primitiveDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass dataTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass engineSystemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass wheelSystemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass imageSensorSystemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass cameraSystemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass objectDetectionSensorSystemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass objectTrackingSensorSystemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass lidarSystemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass localizationSensorSystemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass gpsSystemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass simulatedSystemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass algorithmLibraryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass stateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass sensorDriverEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass buildingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass planetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass landSurfaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass groundEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass floorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass waterSurfaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass humanEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass pedestrianEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass stairsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass platformEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass roboticMiddlewareEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass roboticSimulatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass cycabTKEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass blenderMorseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass onPortEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass allocateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass inertialMeasurementUnitSystemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass inertialNavigationSystemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass odometrySystemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass infraRedProximetrySystemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass deploymentPlanEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass gyroscopeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EEnum robotKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EEnum ugvKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EEnum synchronizationKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EEnum dataFlowDirectionKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EEnum serviceFlowKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EEnum roboticMiddlewareKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EEnum shadeEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the
	 * package
	 * package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also performs initialization of the
	 * package, or returns the registered package, if one already exists. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private RobotMLPackageImpl() {
		super(eNS_URI, RobotMLFactory.eINSTANCE);
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
	 * This method is used to initialize {@link RobotMLPackage#eINSTANCE} when that field is accessed. Clients should not invoke it directly. Instead,
	 * they should simply access that field to obtain the package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static RobotMLPackage init() {
		if(isInited)
			return (RobotMLPackage)EPackage.Registry.INSTANCE.getEPackage(RobotMLPackage.eNS_URI);

		// Obtain or create and register package
		RobotMLPackageImpl theRobotMLPackage = (RobotMLPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof RobotMLPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new RobotMLPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		UMLPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		Diagnostic_datatypesPackageImpl theDiagnostic_datatypesPackage = (Diagnostic_datatypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Diagnostic_datatypesPackage.eNS_URI) instanceof Diagnostic_datatypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Diagnostic_datatypesPackage.eNS_URI) : Diagnostic_datatypesPackage.eINSTANCE);
		Geometry_datatypesPackageImpl theGeometry_datatypesPackage = (Geometry_datatypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Geometry_datatypesPackage.eNS_URI) instanceof Geometry_datatypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Geometry_datatypesPackage.eNS_URI) : Geometry_datatypesPackage.eINSTANCE);
		Nav_datatypesPackageImpl theNav_datatypesPackage = (Nav_datatypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Nav_datatypesPackage.eNS_URI) instanceof Nav_datatypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Nav_datatypesPackage.eNS_URI) : Nav_datatypesPackage.eINSTANCE);
		Sensor_datatypesPackageImpl theSensor_datatypesPackage = (Sensor_datatypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Sensor_datatypesPackage.eNS_URI) instanceof Sensor_datatypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Sensor_datatypesPackage.eNS_URI) : Sensor_datatypesPackage.eINSTANCE);
		Actionlib_datatypesPackageImpl theActionlib_datatypesPackage = (Actionlib_datatypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Actionlib_datatypesPackage.eNS_URI) instanceof Actionlib_datatypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Actionlib_datatypesPackage.eNS_URI) : Actionlib_datatypesPackage.eINSTANCE);
		Oarp1_datatypesPackageImpl theOarp1_datatypesPackage = (Oarp1_datatypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Oarp1_datatypesPackage.eNS_URI) instanceof Oarp1_datatypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Oarp1_datatypesPackage.eNS_URI) : Oarp1_datatypesPackage.eINSTANCE);
		Oarp4_datatypesPackageImpl theOarp4_datatypesPackage = (Oarp4_datatypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Oarp4_datatypesPackage.eNS_URI) instanceof Oarp4_datatypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Oarp4_datatypesPackage.eNS_URI) : Oarp4_datatypesPackage.eINSTANCE);
		Std_datatypesPackageImpl theStd_datatypesPackage = (Std_datatypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Std_datatypesPackage.eNS_URI) instanceof Std_datatypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Std_datatypesPackage.eNS_URI) : Std_datatypesPackage.eINSTANCE);

		// Create package meta-data objects
		theRobotMLPackage.createPackageContents();
		theDiagnostic_datatypesPackage.createPackageContents();
		theGeometry_datatypesPackage.createPackageContents();
		theNav_datatypesPackage.createPackageContents();
		theSensor_datatypesPackage.createPackageContents();
		theActionlib_datatypesPackage.createPackageContents();
		theOarp1_datatypesPackage.createPackageContents();
		theOarp4_datatypesPackage.createPackageContents();
		theStd_datatypesPackage.createPackageContents();

		// Initialize created meta-data
		theRobotMLPackage.initializePackageContents();
		theDiagnostic_datatypesPackage.initializePackageContents();
		theGeometry_datatypesPackage.initializePackageContents();
		theNav_datatypesPackage.initializePackageContents();
		theSensor_datatypesPackage.initializePackageContents();
		theActionlib_datatypesPackage.initializePackageContents();
		theOarp1_datatypesPackage.initializePackageContents();
		theOarp4_datatypesPackage.initializePackageContents();
		theStd_datatypesPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theRobotMLPackage.freeze();


		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(RobotMLPackage.eNS_URI, theRobotMLPackage);
		return theRobotMLPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getTransition() {
		return transitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getTransition_Base_Transition() {
		return (EReference)transitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getTransition_Guard() {
		return (EReference)transitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getTransition_Effect() {
		return (EReference)transitionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getAlgorithm() {
		return algorithmEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getAlgorithm_Base_Operation() {
		return (EReference)algorithmEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getAlgorithm_IsExternal() {
		return (EAttribute)algorithmEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getAlgorithm_ExtFunctionName() {
		return (EAttribute)algorithmEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getAlgorithm_LibPath() {
		return (EAttribute)algorithmEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getAlgorithm_LibFileFormat() {
		return (EAttribute)algorithmEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getRobot() {
		return robotEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getRobot_Kind() {
		return (EAttribute)robotEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getRobot_Mass() {
		return (EAttribute)robotEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getRobot_Width() {
		return (EAttribute)robotEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getRobot_UgvKind() {
		return (EAttribute)robotEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getSystem() {
		return systemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getSystem_Base_Class() {
		return (EReference)systemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getSystem_Native() {
		return (EAttribute)systemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getSystem_LibraryPath() {
		return (EAttribute)systemEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getSystem_LibraryComponentName() {
		return (EAttribute)systemEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getAgent() {
		return agentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getAgent_MovesOver() {
		return (EReference)agentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getPhysicalObject() {
		return physicalObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getPhysicalObject_EvelovesIn() {
		return (EReference)physicalObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getPhysicalObject_HasSurface() {
		return (EReference)physicalObjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getEnvironment() {
		return environmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getSurface() {
		return surfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getDataFlowPort() {
		return dataFlowPortEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getDataFlowPort_Direction() {
		return (EAttribute)dataFlowPortEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getDataFlowPort_BufferSize() {
		return (EAttribute)dataFlowPortEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getPort() {
		return portEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getPort_Base_Port() {
		return (EReference)portEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getPort_SynchronizationPolicy() {
		return (EAttribute)portEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getServicePort() {
		return servicePortEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getServicePort_Kind() {
		return (EAttribute)servicePortEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getActuatorSystem() {
		return actuatorSystemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getRoboticSystem() {
		return roboticSystemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getRoboticSystem_LocalPosition() {
		return (EReference)roboticSystemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getRoboticSystem_LocalOrientation() {
		return (EReference)roboticSystemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getSensorSystem() {
		return sensorSystemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getSensorSystem_Frequency() {
		return (EAttribute)sensorSystemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getSensorSystem_Identifier() {
		return (EAttribute)sensorSystemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getHardware() {
		return hardwareEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getSoftware() {
		return softwareEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getSoftware_IsPeriodic() {
		return (EAttribute)softwareEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getSoftware_Period() {
		return (EAttribute)softwareEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getSoftware_Priority() {
		return (EAttribute)softwareEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getSoftware_Deadline() {
		return (EAttribute)softwareEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getSoftware_Wcet() {
		return (EAttribute)softwareEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getPrimitiveData() {
		return primitiveDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getPrimitiveData_Base_PrimitiveType() {
		return (EReference)primitiveDataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getDataType() {
		return dataTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getDataType_Base_DataType() {
		return (EReference)dataTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getDataType_Native() {
		return (EAttribute)dataTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getDataType_LibraryPath() {
		return (EAttribute)dataTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getEngineSystem() {
		return engineSystemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getEngineSystem_VehicleTraction() {
		return (EAttribute)engineSystemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getEngineSystem_MaxEngineForce() {
		return (EAttribute)engineSystemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getEngineSystem_MaxBreakingForce() {
		return (EAttribute)engineSystemEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getEngineSystem_MaxAllowedSteering() {
		return (EAttribute)engineSystemEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getEngineSystem_MaxAllowedVelocity() {
		return (EAttribute)engineSystemEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getEngineSystem_Gear_ration() {
		return (EAttribute)engineSystemEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getWheelSystem() {
		return wheelSystemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getWheelSystem_WheelRadius() {
		return (EAttribute)wheelSystemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getWheelSystem_WheelWidth() {
		return (EAttribute)wheelSystemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getWheelSystem_SuspensionRestLength() {
		return (EAttribute)wheelSystemEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getWheelSystem_WheelConnectionHeight() {
		return (EAttribute)wheelSystemEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getWheelSystem_TypeOfWheel() {
		return (EAttribute)wheelSystemEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getWheelSystem_WheelVelocityPIDkp() {
		return (EAttribute)wheelSystemEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getWheelSystem_WheelVelocityPIDki() {
		return (EAttribute)wheelSystemEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getWheelSystem_WheelVelocityPIDkd() {
		return (EAttribute)wheelSystemEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getWheelSystem_WheelSteeringPIDkp() {
		return (EAttribute)wheelSystemEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getWheelSystem_WheelSteeringPIDkd() {
		return (EAttribute)wheelSystemEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getWheelSystem_WheelFriction() {
		return (EAttribute)wheelSystemEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getWheelSystem_SuspensionStiffness() {
		return (EAttribute)wheelSystemEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getWheelSystem_SuspensionDamping() {
		return (EAttribute)wheelSystemEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getWheelSystem_SuspensionCompression() {
		return (EAttribute)wheelSystemEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getWheelSystem_WheelVelocityPIDmaxSum() {
		return (EAttribute)wheelSystemEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getWheelSystem_WheelVelocityPIDmaxVal() {
		return (EAttribute)wheelSystemEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getImageSensorSystem() {
		return imageSensorSystemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getCameraSystem() {
		return cameraSystemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getCameraSystem_Width() {
		return (EAttribute)cameraSystemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getCameraSystem_Height() {
		return (EAttribute)cameraSystemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getCameraSystem_Alpha_u() {
		return (EAttribute)cameraSystemEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getCameraSystem_Alpha_v() {
		return (EAttribute)cameraSystemEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getCameraSystem_U0() {
		return (EAttribute)cameraSystemEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getCameraSystem_V0() {
		return (EAttribute)cameraSystemEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getCameraSystem_Color_format() {
		return (EAttribute)cameraSystemEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getCameraSystem_Translate() {
		return (EReference)cameraSystemEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getCameraSystem_Rotate() {
		return (EReference)cameraSystemEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getObjectDetectionSensorSystem() {
		return objectDetectionSensorSystemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getObjectTrackingSensorSystem() {
		return objectTrackingSensorSystemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getLidarSystem() {
		return lidarSystemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getLidarSystem_NbLayers() {
		return (EAttribute)lidarSystemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getLidarSystem_LayerAngleMin() {
		return (EAttribute)lidarSystemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getLidarSystem_LayerAngleStep() {
		return (EAttribute)lidarSystemEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getLidarSystem_Noise() {
		return (EAttribute)lidarSystemEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getLidarSystem_SigmaNoise() {
		return (EAttribute)lidarSystemEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getLidarSystem_Angle_min() {
		return (EAttribute)lidarSystemEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getLidarSystem_Angle_max() {
		return (EAttribute)lidarSystemEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getLidarSystem_Time_increment() {
		return (EAttribute)lidarSystemEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getLidarSystem_Scan_time() {
		return (EAttribute)lidarSystemEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getLidarSystem_Range_min() {
		return (EAttribute)lidarSystemEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getLidarSystem_Range_max() {
		return (EAttribute)lidarSystemEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getLidarSystem_NbRays() {
		return (EAttribute)lidarSystemEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getLocalizationSensorSystem() {
		return localizationSensorSystemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getGPSSystem() {
		return gpsSystemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getGPSSystem_OriginPosition() {
		return (EReference)gpsSystemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getSimulatedSystem() {
		return simulatedSystemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getSimulatedSystem_Base_Property() {
		return (EReference)simulatedSystemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getSimulatedSystem_Mesh() {
		return (EAttribute)simulatedSystemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getAlgorithmLibrary() {
		return algorithmLibraryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getAlgorithmLibrary_Base_Class() {
		return (EReference)algorithmLibraryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getAlgorithmLibrary_Path() {
		return (EAttribute)algorithmLibraryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getState() {
		return stateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getState_Base_State() {
		return (EReference)stateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getState_Operation() {
		return (EReference)stateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getState_Arguments() {
		return (EReference)stateEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getSensorDriver() {
		return sensorDriverEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getBuilding() {
		return buildingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getPlanet() {
		return planetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getLandSurface() {
		return landSurfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getGround() {
		return groundEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getFloor() {
		return floorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getWaterSurface() {
		return waterSurfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getHuman() {
		return humanEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getPedestrian() {
		return pedestrianEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getStairs() {
		return stairsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getPlatform() {
		return platformEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getPlatform_Base_Node() {
		return (EReference)platformEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getRoboticMiddleware() {
		return roboticMiddlewareEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getRoboticMiddleware_Kind() {
		return (EAttribute)roboticMiddlewareEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getRoboticSimulator() {
		return roboticSimulatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getCycabTK() {
		return cycabTKEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getCycabTK_UseRealTime() {
		return (EAttribute)cycabTKEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getCycabTK_TimeStep() {
		return (EAttribute)cycabTKEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getCycabTK_TimeFactor() {
		return (EAttribute)cycabTKEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getBlenderMorse() {
		return blenderMorseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getBlenderMorse_DebugMode() {
		return (EAttribute)blenderMorseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getBlenderMorse_DebugDisplay() {
		return (EAttribute)blenderMorseEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getBlenderMorse_Gravity() {
		return (EAttribute)blenderMorseEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getBlenderMorse__viewport_shade() {
		return (EAttribute)blenderMorseEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getOnPort() {
		return onPortEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getOnPort_Port() {
		return (EReference)onPortEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getOnPort_Base_Parameter() {
		return (EReference)onPortEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getAllocate() {
		return allocateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getAllocate_Base_Abstraction() {
		return (EReference)allocateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getInertialMeasurementUnitSystem() {
		return inertialMeasurementUnitSystemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getInertialNavigationSystem() {
		return inertialNavigationSystemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getOdometrySystem() {
		return odometrySystemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getInfraRedProximetrySystem() {
		return infraRedProximetrySystemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getDeploymentPlan() {
		return deploymentPlanEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getDeploymentPlan_Base_Package() {
		return (EReference)deploymentPlanEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getDeploymentPlan_MainInstance() {
		return (EReference)deploymentPlanEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getGyroscope() {
		return gyroscopeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EEnum getRobotKind() {
		return robotKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EEnum getUGVKind() {
		return ugvKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EEnum getSynchronizationKind() {
		return synchronizationKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EEnum getDataFlowDirectionKind() {
		return dataFlowDirectionKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EEnum getServiceFlowKind() {
		return serviceFlowKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EEnum getRoboticMiddlewareKind() {
		return roboticMiddlewareKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EEnum getShade() {
		return shadeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public RobotMLFactory getRobotMLFactory() {
		return (RobotMLFactory)getEFactoryInstance();
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
		transitionEClass = createEClass(TRANSITION);
		createEReference(transitionEClass, TRANSITION__BASE_TRANSITION);
		createEReference(transitionEClass, TRANSITION__GUARD);
		createEReference(transitionEClass, TRANSITION__EFFECT);

		algorithmEClass = createEClass(ALGORITHM);
		createEReference(algorithmEClass, ALGORITHM__BASE_OPERATION);
		createEAttribute(algorithmEClass, ALGORITHM__IS_EXTERNAL);
		createEAttribute(algorithmEClass, ALGORITHM__EXT_FUNCTION_NAME);
		createEAttribute(algorithmEClass, ALGORITHM__LIB_PATH);
		createEAttribute(algorithmEClass, ALGORITHM__LIB_FILE_FORMAT);

		robotEClass = createEClass(ROBOT);
		createEAttribute(robotEClass, ROBOT__KIND);
		createEAttribute(robotEClass, ROBOT__MASS);
		createEAttribute(robotEClass, ROBOT__WIDTH);
		createEAttribute(robotEClass, ROBOT__UGV_KIND);

		systemEClass = createEClass(SYSTEM);
		createEReference(systemEClass, SYSTEM__BASE_CLASS);
		createEAttribute(systemEClass, SYSTEM__NATIVE);
		createEAttribute(systemEClass, SYSTEM__LIBRARY_PATH);
		createEAttribute(systemEClass, SYSTEM__LIBRARY_COMPONENT_NAME);

		agentEClass = createEClass(AGENT);
		createEReference(agentEClass, AGENT__MOVES_OVER);

		physicalObjectEClass = createEClass(PHYSICAL_OBJECT);
		createEReference(physicalObjectEClass, PHYSICAL_OBJECT__EVELOVES_IN);
		createEReference(physicalObjectEClass, PHYSICAL_OBJECT__HAS_SURFACE);

		environmentEClass = createEClass(ENVIRONMENT);

		surfaceEClass = createEClass(SURFACE);

		dataFlowPortEClass = createEClass(DATA_FLOW_PORT);
		createEAttribute(dataFlowPortEClass, DATA_FLOW_PORT__DIRECTION);
		createEAttribute(dataFlowPortEClass, DATA_FLOW_PORT__BUFFER_SIZE);

		portEClass = createEClass(PORT);
		createEReference(portEClass, PORT__BASE_PORT);
		createEAttribute(portEClass, PORT__SYNCHRONIZATION_POLICY);

		servicePortEClass = createEClass(SERVICE_PORT);
		createEAttribute(servicePortEClass, SERVICE_PORT__KIND);

		actuatorSystemEClass = createEClass(ACTUATOR_SYSTEM);

		roboticSystemEClass = createEClass(ROBOTIC_SYSTEM);
		createEReference(roboticSystemEClass, ROBOTIC_SYSTEM__LOCAL_POSITION);
		createEReference(roboticSystemEClass, ROBOTIC_SYSTEM__LOCAL_ORIENTATION);

		sensorSystemEClass = createEClass(SENSOR_SYSTEM);
		createEAttribute(sensorSystemEClass, SENSOR_SYSTEM__FREQUENCY);
		createEAttribute(sensorSystemEClass, SENSOR_SYSTEM__IDENTIFIER);

		hardwareEClass = createEClass(HARDWARE);

		softwareEClass = createEClass(SOFTWARE);
		createEAttribute(softwareEClass, SOFTWARE__IS_PERIODIC);
		createEAttribute(softwareEClass, SOFTWARE__PERIOD);
		createEAttribute(softwareEClass, SOFTWARE__PRIORITY);
		createEAttribute(softwareEClass, SOFTWARE__DEADLINE);
		createEAttribute(softwareEClass, SOFTWARE__WCET);

		primitiveDataEClass = createEClass(PRIMITIVE_DATA);
		createEReference(primitiveDataEClass, PRIMITIVE_DATA__BASE_PRIMITIVE_TYPE);

		dataTypeEClass = createEClass(DATA_TYPE);
		createEReference(dataTypeEClass, DATA_TYPE__BASE_DATA_TYPE);
		createEAttribute(dataTypeEClass, DATA_TYPE__NATIVE);
		createEAttribute(dataTypeEClass, DATA_TYPE__LIBRARY_PATH);

		engineSystemEClass = createEClass(ENGINE_SYSTEM);
		createEAttribute(engineSystemEClass, ENGINE_SYSTEM__VEHICLE_TRACTION);
		createEAttribute(engineSystemEClass, ENGINE_SYSTEM__MAX_ENGINE_FORCE);
		createEAttribute(engineSystemEClass, ENGINE_SYSTEM__MAX_BREAKING_FORCE);
		createEAttribute(engineSystemEClass, ENGINE_SYSTEM__MAX_ALLOWED_STEERING);
		createEAttribute(engineSystemEClass, ENGINE_SYSTEM__MAX_ALLOWED_VELOCITY);
		createEAttribute(engineSystemEClass, ENGINE_SYSTEM__GEAR_RATION);

		wheelSystemEClass = createEClass(WHEEL_SYSTEM);
		createEAttribute(wheelSystemEClass, WHEEL_SYSTEM__WHEEL_RADIUS);
		createEAttribute(wheelSystemEClass, WHEEL_SYSTEM__WHEEL_WIDTH);
		createEAttribute(wheelSystemEClass, WHEEL_SYSTEM__SUSPENSION_REST_LENGTH);
		createEAttribute(wheelSystemEClass, WHEEL_SYSTEM__WHEEL_CONNECTION_HEIGHT);
		createEAttribute(wheelSystemEClass, WHEEL_SYSTEM__TYPE_OF_WHEEL);
		createEAttribute(wheelSystemEClass, WHEEL_SYSTEM__WHEEL_VELOCITY_PI_DKP);
		createEAttribute(wheelSystemEClass, WHEEL_SYSTEM__WHEEL_VELOCITY_PI_DKI);
		createEAttribute(wheelSystemEClass, WHEEL_SYSTEM__WHEEL_VELOCITY_PI_DKD);
		createEAttribute(wheelSystemEClass, WHEEL_SYSTEM__WHEEL_STEERING_PI_DKP);
		createEAttribute(wheelSystemEClass, WHEEL_SYSTEM__WHEEL_STEERING_PI_DKD);
		createEAttribute(wheelSystemEClass, WHEEL_SYSTEM__WHEEL_FRICTION);
		createEAttribute(wheelSystemEClass, WHEEL_SYSTEM__SUSPENSION_STIFFNESS);
		createEAttribute(wheelSystemEClass, WHEEL_SYSTEM__SUSPENSION_DAMPING);
		createEAttribute(wheelSystemEClass, WHEEL_SYSTEM__SUSPENSION_COMPRESSION);
		createEAttribute(wheelSystemEClass, WHEEL_SYSTEM__WHEEL_VELOCITY_PI_DMAX_SUM);
		createEAttribute(wheelSystemEClass, WHEEL_SYSTEM__WHEEL_VELOCITY_PI_DMAX_VAL);

		imageSensorSystemEClass = createEClass(IMAGE_SENSOR_SYSTEM);

		cameraSystemEClass = createEClass(CAMERA_SYSTEM);
		createEAttribute(cameraSystemEClass, CAMERA_SYSTEM__WIDTH);
		createEAttribute(cameraSystemEClass, CAMERA_SYSTEM__HEIGHT);
		createEAttribute(cameraSystemEClass, CAMERA_SYSTEM__ALPHA_U);
		createEAttribute(cameraSystemEClass, CAMERA_SYSTEM__ALPHA_V);
		createEAttribute(cameraSystemEClass, CAMERA_SYSTEM__U0);
		createEAttribute(cameraSystemEClass, CAMERA_SYSTEM__V0);
		createEAttribute(cameraSystemEClass, CAMERA_SYSTEM__COLOR_FORMAT);
		createEReference(cameraSystemEClass, CAMERA_SYSTEM__TRANSLATE);
		createEReference(cameraSystemEClass, CAMERA_SYSTEM__ROTATE);

		objectDetectionSensorSystemEClass = createEClass(OBJECT_DETECTION_SENSOR_SYSTEM);

		objectTrackingSensorSystemEClass = createEClass(OBJECT_TRACKING_SENSOR_SYSTEM);

		lidarSystemEClass = createEClass(LIDAR_SYSTEM);
		createEAttribute(lidarSystemEClass, LIDAR_SYSTEM__NB_LAYERS);
		createEAttribute(lidarSystemEClass, LIDAR_SYSTEM__LAYER_ANGLE_MIN);
		createEAttribute(lidarSystemEClass, LIDAR_SYSTEM__LAYER_ANGLE_STEP);
		createEAttribute(lidarSystemEClass, LIDAR_SYSTEM__NOISE);
		createEAttribute(lidarSystemEClass, LIDAR_SYSTEM__SIGMA_NOISE);
		createEAttribute(lidarSystemEClass, LIDAR_SYSTEM__ANGLE_MIN);
		createEAttribute(lidarSystemEClass, LIDAR_SYSTEM__ANGLE_MAX);
		createEAttribute(lidarSystemEClass, LIDAR_SYSTEM__TIME_INCREMENT);
		createEAttribute(lidarSystemEClass, LIDAR_SYSTEM__SCAN_TIME);
		createEAttribute(lidarSystemEClass, LIDAR_SYSTEM__RANGE_MIN);
		createEAttribute(lidarSystemEClass, LIDAR_SYSTEM__RANGE_MAX);
		createEAttribute(lidarSystemEClass, LIDAR_SYSTEM__NB_RAYS);

		localizationSensorSystemEClass = createEClass(LOCALIZATION_SENSOR_SYSTEM);

		gpsSystemEClass = createEClass(GPS_SYSTEM);
		createEReference(gpsSystemEClass, GPS_SYSTEM__ORIGIN_POSITION);

		simulatedSystemEClass = createEClass(SIMULATED_SYSTEM);
		createEReference(simulatedSystemEClass, SIMULATED_SYSTEM__BASE_PROPERTY);
		createEAttribute(simulatedSystemEClass, SIMULATED_SYSTEM__MESH);

		algorithmLibraryEClass = createEClass(ALGORITHM_LIBRARY);
		createEReference(algorithmLibraryEClass, ALGORITHM_LIBRARY__BASE_CLASS);
		createEAttribute(algorithmLibraryEClass, ALGORITHM_LIBRARY__PATH);

		stateEClass = createEClass(STATE);
		createEReference(stateEClass, STATE__BASE_STATE);
		createEReference(stateEClass, STATE__OPERATION);
		createEReference(stateEClass, STATE__ARGUMENTS);

		sensorDriverEClass = createEClass(SENSOR_DRIVER);

		buildingEClass = createEClass(BUILDING);

		planetEClass = createEClass(PLANET);

		landSurfaceEClass = createEClass(LAND_SURFACE);

		groundEClass = createEClass(GROUND);

		floorEClass = createEClass(FLOOR);

		waterSurfaceEClass = createEClass(WATER_SURFACE);

		humanEClass = createEClass(HUMAN);

		pedestrianEClass = createEClass(PEDESTRIAN);

		stairsEClass = createEClass(STAIRS);

		platformEClass = createEClass(PLATFORM);
		createEReference(platformEClass, PLATFORM__BASE_NODE);

		roboticMiddlewareEClass = createEClass(ROBOTIC_MIDDLEWARE);
		createEAttribute(roboticMiddlewareEClass, ROBOTIC_MIDDLEWARE__KIND);

		roboticSimulatorEClass = createEClass(ROBOTIC_SIMULATOR);

		cycabTKEClass = createEClass(CYCAB_TK);
		createEAttribute(cycabTKEClass, CYCAB_TK__USE_REAL_TIME);
		createEAttribute(cycabTKEClass, CYCAB_TK__TIME_STEP);
		createEAttribute(cycabTKEClass, CYCAB_TK__TIME_FACTOR);

		blenderMorseEClass = createEClass(BLENDER_MORSE);
		createEAttribute(blenderMorseEClass, BLENDER_MORSE__DEBUG_MODE);
		createEAttribute(blenderMorseEClass, BLENDER_MORSE__DEBUG_DISPLAY);
		createEAttribute(blenderMorseEClass, BLENDER_MORSE__GRAVITY);
		createEAttribute(blenderMorseEClass, BLENDER_MORSE__VIEWPORT_SHADE);

		onPortEClass = createEClass(ON_PORT);
		createEReference(onPortEClass, ON_PORT__PORT);
		createEReference(onPortEClass, ON_PORT__BASE_PARAMETER);

		allocateEClass = createEClass(ALLOCATE);
		createEReference(allocateEClass, ALLOCATE__BASE_ABSTRACTION);

		inertialMeasurementUnitSystemEClass = createEClass(INERTIAL_MEASUREMENT_UNIT_SYSTEM);

		inertialNavigationSystemEClass = createEClass(INERTIAL_NAVIGATION_SYSTEM);

		odometrySystemEClass = createEClass(ODOMETRY_SYSTEM);

		infraRedProximetrySystemEClass = createEClass(INFRA_RED_PROXIMETRY_SYSTEM);

		deploymentPlanEClass = createEClass(DEPLOYMENT_PLAN);
		createEReference(deploymentPlanEClass, DEPLOYMENT_PLAN__BASE_PACKAGE);
		createEReference(deploymentPlanEClass, DEPLOYMENT_PLAN__MAIN_INSTANCE);

		gyroscopeEClass = createEClass(GYROSCOPE);

		// Create enums
		robotKindEEnum = createEEnum(ROBOT_KIND);
		ugvKindEEnum = createEEnum(UGV_KIND);
		synchronizationKindEEnum = createEEnum(SYNCHRONIZATION_KIND);
		dataFlowDirectionKindEEnum = createEEnum(DATA_FLOW_DIRECTION_KIND);
		serviceFlowKindEEnum = createEEnum(SERVICE_FLOW_KIND);
		roboticMiddlewareKindEEnum = createEEnum(ROBOTIC_MIDDLEWARE_KIND);
		shadeEEnum = createEEnum(SHADE);
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
		UMLPackage theUMLPackage = (UMLPackage)EPackage.Registry.INSTANCE.getEPackage(UMLPackage.eNS_URI);
		TypesPackage theTypesPackage = (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);
		Std_datatypesPackage theStd_datatypesPackage = (Std_datatypesPackage)EPackage.Registry.INSTANCE.getEPackage(Std_datatypesPackage.eNS_URI);
		Geometry_datatypesPackage theGeometry_datatypesPackage = (Geometry_datatypesPackage)EPackage.Registry.INSTANCE.getEPackage(Geometry_datatypesPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		robotEClass.getESuperTypes().add(this.getAgent());
		robotEClass.getESuperTypes().add(this.getSystem());
		agentEClass.getESuperTypes().add(this.getPhysicalObject());
		physicalObjectEClass.getESuperTypes().add(this.getSystem());
		environmentEClass.getESuperTypes().add(this.getSystem());
		surfaceEClass.getESuperTypes().add(this.getPhysicalObject());
		dataFlowPortEClass.getESuperTypes().add(this.getPort());
		servicePortEClass.getESuperTypes().add(this.getPort());
		actuatorSystemEClass.getESuperTypes().add(this.getRoboticSystem());
		roboticSystemEClass.getESuperTypes().add(this.getSystem());
		sensorSystemEClass.getESuperTypes().add(this.getRoboticSystem());
		hardwareEClass.getESuperTypes().add(this.getSystem());
		softwareEClass.getESuperTypes().add(this.getSystem());
		primitiveDataEClass.getESuperTypes().add(this.getDataType());
		engineSystemEClass.getESuperTypes().add(this.getActuatorSystem());
		wheelSystemEClass.getESuperTypes().add(this.getActuatorSystem());
		imageSensorSystemEClass.getESuperTypes().add(this.getSensorSystem());
		cameraSystemEClass.getESuperTypes().add(this.getImageSensorSystem());
		objectDetectionSensorSystemEClass.getESuperTypes().add(this.getSensorSystem());
		objectTrackingSensorSystemEClass.getESuperTypes().add(this.getSensorSystem());
		lidarSystemEClass.getESuperTypes().add(this.getObjectDetectionSensorSystem());
		lidarSystemEClass.getESuperTypes().add(this.getObjectTrackingSensorSystem());
		localizationSensorSystemEClass.getESuperTypes().add(this.getSensorSystem());
		gpsSystemEClass.getESuperTypes().add(this.getLocalizationSensorSystem());
		simulatedSystemEClass.getESuperTypes().add(this.getSoftware());
		sensorDriverEClass.getESuperTypes().add(this.getSoftware());
		buildingEClass.getESuperTypes().add(this.getPhysicalObject());
		planetEClass.getESuperTypes().add(this.getPhysicalObject());
		landSurfaceEClass.getESuperTypes().add(this.getGround());
		groundEClass.getESuperTypes().add(this.getSurface());
		floorEClass.getESuperTypes().add(this.getGround());
		waterSurfaceEClass.getESuperTypes().add(this.getSurface());
		humanEClass.getESuperTypes().add(this.getAgent());
		pedestrianEClass.getESuperTypes().add(this.getHuman());
		stairsEClass.getESuperTypes().add(this.getGround());
		platformEClass.getESuperTypes().add(this.getSystem());
		roboticMiddlewareEClass.getESuperTypes().add(this.getPlatform());
		roboticSimulatorEClass.getESuperTypes().add(this.getPlatform());
		cycabTKEClass.getESuperTypes().add(this.getRoboticSimulator());
		blenderMorseEClass.getESuperTypes().add(this.getRoboticSimulator());
		inertialMeasurementUnitSystemEClass.getESuperTypes().add(this.getSensorSystem());
		inertialNavigationSystemEClass.getESuperTypes().add(this.getGPSSystem());
		odometrySystemEClass.getESuperTypes().add(this.getLocalizationSensorSystem());
		infraRedProximetrySystemEClass.getESuperTypes().add(this.getObjectDetectionSensorSystem());
		gyroscopeEClass.getESuperTypes().add(this.getSensorSystem());

		// Initialize classes and features; add operations and parameters
		initEClass(transitionEClass, Transition.class, "Transition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTransition_Base_Transition(), theUMLPackage.getTransition(), null, "base_Transition", null, 1, 1, Transition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getTransition_Guard(), this.getAlgorithm(), null, "guard", null, 1, 1, Transition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getTransition_Effect(), this.getAlgorithm(), null, "effect", null, 1, 1, Transition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(algorithmEClass, Algorithm.class, "Algorithm", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAlgorithm_Base_Operation(), theUMLPackage.getOperation(), null, "base_Operation", null, 1, 1, Algorithm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getAlgorithm_IsExternal(), theTypesPackage.getBoolean(), "isExternal", null, 1, 1, Algorithm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getAlgorithm_ExtFunctionName(), theTypesPackage.getString(), "extFunctionName", null, 1, 1, Algorithm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getAlgorithm_LibPath(), theTypesPackage.getString(), "libPath", null, 1, 1, Algorithm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getAlgorithm_LibFileFormat(), theTypesPackage.getString(), "libFileFormat", "elf", 1, 1, Algorithm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(robotEClass, Robot.class, "Robot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRobot_Kind(), this.getRobotKind(), "kind", "UGV", 1, 1, Robot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getRobot_Mass(), theStd_datatypesPackage.getFloat32(), "mass", null, 1, 1, Robot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getRobot_Width(), theStd_datatypesPackage.getFloat32(), "width", null, 1, 1, Robot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getRobot_UgvKind(), this.getUGVKind(), "ugvKind", null, 0, 1, Robot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(systemEClass, org.eclipse.papyrus.RobotML.System.class, "System", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSystem_Base_Class(), theUMLPackage.getClass_(), null, "base_Class", null, 1, 1, org.eclipse.papyrus.RobotML.System.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getSystem_Native(), theTypesPackage.getBoolean(), "native", null, 1, 1, org.eclipse.papyrus.RobotML.System.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getSystem_LibraryPath(), theTypesPackage.getString(), "libraryPath", null, 1, 1, org.eclipse.papyrus.RobotML.System.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getSystem_LibraryComponentName(), theTypesPackage.getString(), "libraryComponentName", null, 1, 1, org.eclipse.papyrus.RobotML.System.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(agentEClass, Agent.class, "Agent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAgent_MovesOver(), this.getSurface(), null, "movesOver", null, 0, -1, Agent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(physicalObjectEClass, PhysicalObject.class, "PhysicalObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPhysicalObject_EvelovesIn(), this.getEnvironment(), null, "evelovesIn", null, 0, -1, PhysicalObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getPhysicalObject_HasSurface(), this.getSurface(), null, "hasSurface", null, 1, 1, PhysicalObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(environmentEClass, Environment.class, "Environment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(surfaceEClass, Surface.class, "Surface", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dataFlowPortEClass, DataFlowPort.class, "DataFlowPort", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDataFlowPort_Direction(), this.getDataFlowDirectionKind(), "direction", null, 1, 1, DataFlowPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDataFlowPort_BufferSize(), theTypesPackage.getInteger(), "bufferSize", "0", 1, 1, DataFlowPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(portEClass, Port.class, "Port", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPort_Base_Port(), theUMLPackage.getPort(), null, "base_Port", null, 1, 1, Port.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getPort_SynchronizationPolicy(), this.getSynchronizationKind(), "synchronizationPolicy", null, 1, 1, Port.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(servicePortEClass, ServicePort.class, "ServicePort", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getServicePort_Kind(), this.getServiceFlowKind(), "kind", null, 1, 1, ServicePort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(actuatorSystemEClass, ActuatorSystem.class, "ActuatorSystem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(roboticSystemEClass, RoboticSystem.class, "RoboticSystem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRoboticSystem_LocalPosition(), theGeometry_datatypesPackage.getPoint32(), null, "localPosition", null, 1, 1, RoboticSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getRoboticSystem_LocalOrientation(), theGeometry_datatypesPackage.getPoint32(), null, "localOrientation", null, 1, 1, RoboticSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(sensorSystemEClass, SensorSystem.class, "SensorSystem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSensorSystem_Frequency(), theStd_datatypesPackage.getFloat32(), "frequency", null, 1, 1, SensorSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getSensorSystem_Identifier(), theStd_datatypesPackage.getString(), "identifier", null, 1, 1, SensorSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(hardwareEClass, Hardware.class, "Hardware", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(softwareEClass, Software.class, "Software", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSoftware_IsPeriodic(), theTypesPackage.getBoolean(), "isPeriodic", null, 1, 1, Software.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getSoftware_Period(), theStd_datatypesPackage.getFloat32(), "period", null, 1, 1, Software.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getSoftware_Priority(), theStd_datatypesPackage.getUInt8(), "priority", null, 1, 1, Software.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getSoftware_Deadline(), theStd_datatypesPackage.getFloat32(), "deadline", null, 1, 1, Software.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getSoftware_Wcet(), theStd_datatypesPackage.getFloat32(), "wcet", null, 1, 1, Software.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(primitiveDataEClass, PrimitiveData.class, "PrimitiveData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPrimitiveData_Base_PrimitiveType(), theUMLPackage.getPrimitiveType(), null, "base_PrimitiveType", null, 1, 1, PrimitiveData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(dataTypeEClass, DataType.class, "DataType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataType_Base_DataType(), theUMLPackage.getDataType(), null, "base_DataType", null, 1, 1, DataType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDataType_Native(), theTypesPackage.getBoolean(), "native", null, 1, 1, DataType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDataType_LibraryPath(), theTypesPackage.getString(), "libraryPath", null, 1, 1, DataType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(engineSystemEClass, EngineSystem.class, "EngineSystem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEngineSystem_VehicleTraction(), theTypesPackage.getString(), "vehicleTraction", null, 1, 1, EngineSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getEngineSystem_MaxEngineForce(), theStd_datatypesPackage.getFloat32(), "maxEngineForce", null, 1, 1, EngineSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getEngineSystem_MaxBreakingForce(), theStd_datatypesPackage.getFloat32(), "maxBreakingForce", null, 1, 1, EngineSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getEngineSystem_MaxAllowedSteering(), theStd_datatypesPackage.getFloat32(), "maxAllowedSteering", null, 1, 1, EngineSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getEngineSystem_MaxAllowedVelocity(), theStd_datatypesPackage.getFloat32(), "maxAllowedVelocity", null, 1, 1, EngineSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getEngineSystem_Gear_ration(), theStd_datatypesPackage.getFloat32(), "gear_ration", null, 1, 1, EngineSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(wheelSystemEClass, WheelSystem.class, "WheelSystem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getWheelSystem_WheelRadius(), theStd_datatypesPackage.getFloat32(), "wheelRadius", null, 1, 1, WheelSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getWheelSystem_WheelWidth(), theStd_datatypesPackage.getFloat32(), "wheelWidth", null, 1, 1, WheelSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getWheelSystem_SuspensionRestLength(), theStd_datatypesPackage.getFloat32(), "suspensionRestLength", null, 1, 1, WheelSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getWheelSystem_WheelConnectionHeight(), theStd_datatypesPackage.getFloat32(), "wheelConnectionHeight", null, 1, 1, WheelSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getWheelSystem_TypeOfWheel(), theStd_datatypesPackage.getString(), "typeOfWheel", null, 1, 1, WheelSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getWheelSystem_WheelVelocityPIDkp(), theStd_datatypesPackage.getFloat32(), "wheelVelocityPIDkp", null, 1, 1, WheelSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getWheelSystem_WheelVelocityPIDki(), theStd_datatypesPackage.getFloat32(), "wheelVelocityPIDki", null, 1, 1, WheelSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getWheelSystem_WheelVelocityPIDkd(), theStd_datatypesPackage.getFloat32(), "wheelVelocityPIDkd", null, 1, 1, WheelSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getWheelSystem_WheelSteeringPIDkp(), theStd_datatypesPackage.getFloat32(), "wheelSteeringPIDkp", null, 1, 1, WheelSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getWheelSystem_WheelSteeringPIDkd(), theStd_datatypesPackage.getFloat32(), "wheelSteeringPIDkd", null, 1, 1, WheelSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getWheelSystem_WheelFriction(), theStd_datatypesPackage.getFloat32(), "wheelFriction", null, 1, 1, WheelSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getWheelSystem_SuspensionStiffness(), theStd_datatypesPackage.getFloat32(), "suspensionStiffness", null, 1, 1, WheelSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getWheelSystem_SuspensionDamping(), theStd_datatypesPackage.getFloat32(), "suspensionDamping", null, 1, 1, WheelSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getWheelSystem_SuspensionCompression(), theStd_datatypesPackage.getFloat32(), "suspensionCompression", null, 1, 1, WheelSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getWheelSystem_WheelVelocityPIDmaxSum(), theStd_datatypesPackage.getFloat32(), "wheelVelocityPIDmaxSum", null, 1, 1, WheelSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getWheelSystem_WheelVelocityPIDmaxVal(), theStd_datatypesPackage.getFloat32(), "wheelVelocityPIDmaxVal", null, 1, 1, WheelSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(imageSensorSystemEClass, ImageSensorSystem.class, "ImageSensorSystem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cameraSystemEClass, CameraSystem.class, "CameraSystem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCameraSystem_Width(), theStd_datatypesPackage.getUInt32(), "width", "0", 1, 1, CameraSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCameraSystem_Height(), theStd_datatypesPackage.getUInt32(), "height", null, 1, 1, CameraSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCameraSystem_Alpha_u(), theStd_datatypesPackage.getFloat32(), "alpha_u", null, 1, 1, CameraSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCameraSystem_Alpha_v(), theStd_datatypesPackage.getFloat32(), "alpha_v", null, 1, 1, CameraSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCameraSystem_U0(), theStd_datatypesPackage.getFloat32(), "u0", null, 1, 1, CameraSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCameraSystem_V0(), theStd_datatypesPackage.getFloat32(), "v0", null, 1, 1, CameraSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCameraSystem_Color_format(), theStd_datatypesPackage.getString(), "color_format", null, 1, 1, CameraSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCameraSystem_Translate(), theGeometry_datatypesPackage.getPoint32(), null, "translate", null, 1, 1, CameraSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCameraSystem_Rotate(), theGeometry_datatypesPackage.getPoint32(), null, "rotate", null, 1, 1, CameraSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(objectDetectionSensorSystemEClass, ObjectDetectionSensorSystem.class, "ObjectDetectionSensorSystem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(objectTrackingSensorSystemEClass, ObjectTrackingSensorSystem.class, "ObjectTrackingSensorSystem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(lidarSystemEClass, LidarSystem.class, "LidarSystem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLidarSystem_NbLayers(), theStd_datatypesPackage.getUInt32(), "nbLayers", null, 1, 1, LidarSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getLidarSystem_LayerAngleMin(), theStd_datatypesPackage.getFloat32(), "layerAngleMin", null, 1, 1, LidarSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getLidarSystem_LayerAngleStep(), theStd_datatypesPackage.getFloat32(), "layerAngleStep", null, 1, 1, LidarSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getLidarSystem_Noise(), theStd_datatypesPackage.getBool(), "noise", null, 1, 1, LidarSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getLidarSystem_SigmaNoise(), theStd_datatypesPackage.getFloat32(), "sigmaNoise", null, 1, 1, LidarSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getLidarSystem_Angle_min(), theStd_datatypesPackage.getFloat32(), "angle_min", null, 1, 1, LidarSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getLidarSystem_Angle_max(), theStd_datatypesPackage.getFloat32(), "angle_max", null, 1, 1, LidarSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getLidarSystem_Time_increment(), theStd_datatypesPackage.getFloat32(), "time_increment", null, 1, 1, LidarSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getLidarSystem_Scan_time(), theStd_datatypesPackage.getFloat32(), "scan_time", null, 1, 1, LidarSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getLidarSystem_Range_min(), theStd_datatypesPackage.getFloat32(), "range_min", null, 1, 1, LidarSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getLidarSystem_Range_max(), theStd_datatypesPackage.getFloat32(), "range_max", null, 1, 1, LidarSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getLidarSystem_NbRays(), theStd_datatypesPackage.getUInt32(), "nbRays", null, 1, 1, LidarSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(localizationSensorSystemEClass, LocalizationSensorSystem.class, "LocalizationSensorSystem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(gpsSystemEClass, GPSSystem.class, "GPSSystem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGPSSystem_OriginPosition(), theGeometry_datatypesPackage.getPoint32(), null, "originPosition", null, 0, 1, GPSSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(simulatedSystemEClass, SimulatedSystem.class, "SimulatedSystem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSimulatedSystem_Base_Property(), theUMLPackage.getProperty(), null, "base_Property", null, 1, 1, SimulatedSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getSimulatedSystem_Mesh(), theTypesPackage.getString(), "mesh", null, 0, -1, SimulatedSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(algorithmLibraryEClass, AlgorithmLibrary.class, "AlgorithmLibrary", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAlgorithmLibrary_Base_Class(), theUMLPackage.getClass_(), null, "base_Class", null, 1, 1, AlgorithmLibrary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getAlgorithmLibrary_Path(), theTypesPackage.getString(), "path", null, 1, 1, AlgorithmLibrary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(stateEClass, State.class, "State", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getState_Base_State(), theUMLPackage.getState(), null, "base_State", null, 1, 1, State.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getState_Operation(), this.getAlgorithm(), null, "operation", null, 1, 1, State.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getState_Arguments(), theUMLPackage.getProperty(), null, "arguments", null, 0, -1, State.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(sensorDriverEClass, SensorDriver.class, "SensorDriver", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(buildingEClass, Building.class, "Building", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(planetEClass, Planet.class, "Planet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(landSurfaceEClass, LandSurface.class, "LandSurface", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(groundEClass, Ground.class, "Ground", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(floorEClass, Floor.class, "Floor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(waterSurfaceEClass, WaterSurface.class, "WaterSurface", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(humanEClass, Human.class, "Human", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(pedestrianEClass, Pedestrian.class, "Pedestrian", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(stairsEClass, Stairs.class, "Stairs", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(platformEClass, Platform.class, "Platform", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPlatform_Base_Node(), theUMLPackage.getNode(), null, "base_Node", null, 1, 1, Platform.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(roboticMiddlewareEClass, RoboticMiddleware.class, "RoboticMiddleware", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRoboticMiddleware_Kind(), this.getRoboticMiddlewareKind(), "kind", null, 1, 1, RoboticMiddleware.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(roboticSimulatorEClass, RoboticSimulator.class, "RoboticSimulator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cycabTKEClass, CycabTK.class, "CycabTK", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCycabTK_UseRealTime(), theTypesPackage.getBoolean(), "useRealTime", null, 0, 1, CycabTK.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCycabTK_TimeStep(), theStd_datatypesPackage.getFloat32(), "timeStep", null, 0, 1, CycabTK.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCycabTK_TimeFactor(), theStd_datatypesPackage.getFloat32(), "timeFactor", null, 0, 1, CycabTK.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(blenderMorseEClass, BlenderMorse.class, "BlenderMorse", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBlenderMorse_DebugMode(), theTypesPackage.getBoolean(), "debugMode", null, 0, 1, BlenderMorse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getBlenderMorse_DebugDisplay(), theTypesPackage.getBoolean(), "debugDisplay", null, 0, 1, BlenderMorse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getBlenderMorse_Gravity(), theStd_datatypesPackage.getFloat32(), "gravity", null, 0, 1, BlenderMorse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getBlenderMorse__viewport_shade(), this.getShade(), "_viewport_shade", "WIREFRAME", 0, 1, BlenderMorse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(onPortEClass, OnPort.class, "OnPort", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOnPort_Port(), this.getPort(), null, "port", null, 1, 1, OnPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getOnPort_Base_Parameter(), theUMLPackage.getParameter(), null, "base_Parameter", null, 1, 1, OnPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(allocateEClass, Allocate.class, "Allocate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAllocate_Base_Abstraction(), theUMLPackage.getAbstraction(), null, "base_Abstraction", null, 1, 1, Allocate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(inertialMeasurementUnitSystemEClass, InertialMeasurementUnitSystem.class, "InertialMeasurementUnitSystem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(inertialNavigationSystemEClass, InertialNavigationSystem.class, "InertialNavigationSystem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(odometrySystemEClass, OdometrySystem.class, "OdometrySystem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(infraRedProximetrySystemEClass, InfraRedProximetrySystem.class, "InfraRedProximetrySystem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(deploymentPlanEClass, DeploymentPlan.class, "DeploymentPlan", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDeploymentPlan_Base_Package(), theUMLPackage.getPackage(), null, "base_Package", null, 1, 1, DeploymentPlan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getDeploymentPlan_MainInstance(), theUMLPackage.getInstanceSpecification(), null, "mainInstance", null, 1, 1, DeploymentPlan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(gyroscopeEClass, Gyroscope.class, "Gyroscope", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(robotKindEEnum, RobotKind.class, "RobotKind");
		addEEnumLiteral(robotKindEEnum, RobotKind.UUV);
		addEEnumLiteral(robotKindEEnum, RobotKind.UG_VCAR);
		addEEnumLiteral(robotKindEEnum, RobotKind.UG_VDIFFERENTIAL);
		addEEnumLiteral(robotKindEEnum, RobotKind.UAV);
		addEEnumLiteral(robotKindEEnum, RobotKind.USV);
		addEEnumLiteral(robotKindEEnum, RobotKind.PILOTED);

		initEEnum(ugvKindEEnum, UGVKind.class, "UGVKind");
		addEEnumLiteral(ugvKindEEnum, UGVKind.DIFFERENTIAL);
		addEEnumLiteral(ugvKindEEnum, UGVKind.CAR);

		initEEnum(synchronizationKindEEnum, SynchronizationKind.class, "SynchronizationKind");
		addEEnumLiteral(synchronizationKindEEnum, SynchronizationKind.SYNCH);
		addEEnumLiteral(synchronizationKindEEnum, SynchronizationKind.ASYNCH);
		addEEnumLiteral(synchronizationKindEEnum, SynchronizationKind.UNDEFINED);

		initEEnum(dataFlowDirectionKindEEnum, DataFlowDirectionKind.class, "DataFlowDirectionKind");
		addEEnumLiteral(dataFlowDirectionKindEEnum, DataFlowDirectionKind.IN);
		addEEnumLiteral(dataFlowDirectionKindEEnum, DataFlowDirectionKind.OUT);
		addEEnumLiteral(dataFlowDirectionKindEEnum, DataFlowDirectionKind.INOUT);

		initEEnum(serviceFlowKindEEnum, ServiceFlowKind.class, "ServiceFlowKind");
		addEEnumLiteral(serviceFlowKindEEnum, ServiceFlowKind.PROVIDED);
		addEEnumLiteral(serviceFlowKindEEnum, ServiceFlowKind.REQUIRED);

		initEEnum(roboticMiddlewareKindEEnum, RoboticMiddlewareKind.class, "RoboticMiddlewareKind");
		addEEnumLiteral(roboticMiddlewareKindEEnum, RoboticMiddlewareKind.RT_MAPS);
		addEEnumLiteral(roboticMiddlewareKindEEnum, RoboticMiddlewareKind.AROCAM);
		addEEnumLiteral(roboticMiddlewareKindEEnum, RoboticMiddlewareKind.ROS);
		addEEnumLiteral(roboticMiddlewareKindEEnum, RoboticMiddlewareKind.OROCOS);
		addEEnumLiteral(roboticMiddlewareKindEEnum, RoboticMiddlewareKind.URBI);

		initEEnum(shadeEEnum, Shade.class, "Shade");
		addEEnumLiteral(shadeEEnum, Shade.WIREFRAME);
		addEEnumLiteral(shadeEEnum, Shade.BOUNDBOX);
		addEEnumLiteral(shadeEEnum, Shade.SOLID);
		addEEnumLiteral(shadeEEnum, Shade.TEXTURED);

		// Create resource
		createResource(eNS_URI);
	}

} //RobotMLPackageImpl
