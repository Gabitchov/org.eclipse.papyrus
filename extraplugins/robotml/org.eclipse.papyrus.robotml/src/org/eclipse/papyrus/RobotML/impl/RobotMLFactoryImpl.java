/**
 */
package org.eclipse.papyrus.RobotML.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.RobotML.ActuatedJoint;
import org.eclipse.papyrus.RobotML.ActuatorHardware;
import org.eclipse.papyrus.RobotML.ActuatorSystem;
import org.eclipse.papyrus.RobotML.Agent;
import org.eclipse.papyrus.RobotML.Algorithm;
import org.eclipse.papyrus.RobotML.AlgorithmLibrary;
import org.eclipse.papyrus.RobotML.Allocate;
import org.eclipse.papyrus.RobotML.Arm;
import org.eclipse.papyrus.RobotML.BlenderMorse;
import org.eclipse.papyrus.RobotML.Building;
import org.eclipse.papyrus.RobotML.CameraSystem;
import org.eclipse.papyrus.RobotML.Chassis;
import org.eclipse.papyrus.RobotML.ClosedLoopControlSystem;
import org.eclipse.papyrus.RobotML.CompleteBonding;
import org.eclipse.papyrus.RobotML.CyberPhysicalSystem;
import org.eclipse.papyrus.RobotML.CycabTK;
import org.eclipse.papyrus.RobotML.DataFlowDirectionKind;
import org.eclipse.papyrus.RobotML.DataFlowPort;
import org.eclipse.papyrus.RobotML.DeploymentPlan;
import org.eclipse.papyrus.RobotML.EngineSystem;
import org.eclipse.papyrus.RobotML.Environment;
import org.eclipse.papyrus.RobotML.ExternalLibrary;
import org.eclipse.papyrus.RobotML.Floor;
import org.eclipse.papyrus.RobotML.GPSSystem;
import org.eclipse.papyrus.RobotML.GraspingHardware;
import org.eclipse.papyrus.RobotML.GraspingSystem;
import org.eclipse.papyrus.RobotML.Gyroscope;
import org.eclipse.papyrus.RobotML.Hardware;
import org.eclipse.papyrus.RobotML.Human;
import org.eclipse.papyrus.RobotML.ImageSensorSystem;
import org.eclipse.papyrus.RobotML.InertialMeasurementUnitSystem;
import org.eclipse.papyrus.RobotML.InertialNavigationSystem;
import org.eclipse.papyrus.RobotML.InfraRedProximetrySystem;
import org.eclipse.papyrus.RobotML.Joint;
import org.eclipse.papyrus.RobotML.JoysticNavigationSystem;
import org.eclipse.papyrus.RobotML.LandSurface;
import org.eclipse.papyrus.RobotML.Leg;
import org.eclipse.papyrus.RobotML.LegSystem;
import org.eclipse.papyrus.RobotML.LidarSystem;
import org.eclipse.papyrus.RobotML.LocalizationSensorSystem;
import org.eclipse.papyrus.RobotML.LocomotionHardware;
import org.eclipse.papyrus.RobotML.LocomotionSystem;
import org.eclipse.papyrus.RobotML.ManMachineInterfaceSystem;
import org.eclipse.papyrus.RobotML.Manipulator;
import org.eclipse.papyrus.RobotML.MechanicalLinkage;
import org.eclipse.papyrus.RobotML.MobileRobot;
import org.eclipse.papyrus.RobotML.MobileRobotKind;
import org.eclipse.papyrus.RobotML.NavigationCommandSystem;
import org.eclipse.papyrus.RobotML.ObjectDetectionSensorSystem;
import org.eclipse.papyrus.RobotML.ObjectTrackingSensorSystem;
import org.eclipse.papyrus.RobotML.OdometrySystem;
import org.eclipse.papyrus.RobotML.OnPort;
import org.eclipse.papyrus.RobotML.OnProperty;
import org.eclipse.papyrus.RobotML.OpenLoopControlSystem;
import org.eclipse.papyrus.RobotML.Pedestrian;
import org.eclipse.papyrus.RobotML.PhysicalObject;
import org.eclipse.papyrus.RobotML.PilotedSystem;
import org.eclipse.papyrus.RobotML.Planet;
import org.eclipse.papyrus.RobotML.Platform;
import org.eclipse.papyrus.RobotML.PowerHardware;
import org.eclipse.papyrus.RobotML.Robot;
import org.eclipse.papyrus.RobotML.RobotMLFactory;
import org.eclipse.papyrus.RobotML.RobotMLPackage;
import org.eclipse.papyrus.RobotML.RoboticHead;
import org.eclipse.papyrus.RobotML.RoboticMiddleware;
import org.eclipse.papyrus.RobotML.RoboticMiddlewareKind;
import org.eclipse.papyrus.RobotML.RoboticSimulator;
import org.eclipse.papyrus.RobotML.RoboticSystem;
import org.eclipse.papyrus.RobotML.SensorDriver;
import org.eclipse.papyrus.RobotML.SensorHardware;
import org.eclipse.papyrus.RobotML.SensorSystem;
import org.eclipse.papyrus.RobotML.ServiceFlowKind;
import org.eclipse.papyrus.RobotML.ServicePort;
import org.eclipse.papyrus.RobotML.Shade;
import org.eclipse.papyrus.RobotML.Software;
import org.eclipse.papyrus.RobotML.Stairs;
import org.eclipse.papyrus.RobotML.State;
import org.eclipse.papyrus.RobotML.SteeredWheelHardware;
import org.eclipse.papyrus.RobotML.SteeredWheelSystem;
import org.eclipse.papyrus.RobotML.SupportingStructure;
import org.eclipse.papyrus.RobotML.Surface;
import org.eclipse.papyrus.RobotML.SynchronizationKind;
import org.eclipse.papyrus.RobotML.Transition;
import org.eclipse.papyrus.RobotML.UGVKind;
import org.eclipse.papyrus.RobotML.WaterSurface;
import org.eclipse.papyrus.RobotML.WeaponSystem;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RobotMLFactoryImpl extends EFactoryImpl implements RobotMLFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static RobotMLFactory init() {
		try {
			RobotMLFactory theRobotMLFactory = (RobotMLFactory)EPackage.Registry.INSTANCE.getEFactory(RobotMLPackage.eNS_URI);
			if (theRobotMLFactory != null) {
				return theRobotMLFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new RobotMLFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RobotMLFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case RobotMLPackage.TRANSITION: return createTransition();
			case RobotMLPackage.ALGORITHM: return createAlgorithm();
			case RobotMLPackage.STATE: return createState();
			case RobotMLPackage.ACTUATED_JOINT: return createActuatedJoint();
			case RobotMLPackage.JOINT: return createJoint();
			case RobotMLPackage.COMPLETE_BONDING: return createCompleteBonding();
			case RobotMLPackage.ROBOT: return createRobot();
			case RobotMLPackage.SYSTEM: return createSystem();
			case RobotMLPackage.AGENT: return createAgent();
			case RobotMLPackage.PHYSICAL_OBJECT: return createPhysicalObject();
			case RobotMLPackage.ENVIRONMENT: return createEnvironment();
			case RobotMLPackage.SURFACE: return createSurface();
			case RobotMLPackage.DATA_FLOW_PORT: return createDataFlowPort();
			case RobotMLPackage.SERVICE_PORT: return createServicePort();
			case RobotMLPackage.ACTUATOR_SYSTEM: return createActuatorSystem();
			case RobotMLPackage.ROBOTIC_SYSTEM: return createRoboticSystem();
			case RobotMLPackage.CYBER_PHYSICAL_SYSTEM: return createCyberPhysicalSystem();
			case RobotMLPackage.SENSOR_SYSTEM: return createSensorSystem();
			case RobotMLPackage.HARDWARE: return createHardware();
			case RobotMLPackage.SOFTWARE: return createSoftware();
			case RobotMLPackage.ENGINE_SYSTEM: return createEngineSystem();
			case RobotMLPackage.STEERED_WHEEL_SYSTEM: return createSteeredWheelSystem();
			case RobotMLPackage.LOCOMOTION_SYSTEM: return createLocomotionSystem();
			case RobotMLPackage.IMAGE_SENSOR_SYSTEM: return createImageSensorSystem();
			case RobotMLPackage.CAMERA_SYSTEM: return createCameraSystem();
			case RobotMLPackage.OBJECT_DETECTION_SENSOR_SYSTEM: return createObjectDetectionSensorSystem();
			case RobotMLPackage.OBJECT_TRACKING_SENSOR_SYSTEM: return createObjectTrackingSensorSystem();
			case RobotMLPackage.LIDAR_SYSTEM: return createLidarSystem();
			case RobotMLPackage.LOCALIZATION_SENSOR_SYSTEM: return createLocalizationSensorSystem();
			case RobotMLPackage.GPS_SYSTEM: return createGPSSystem();
			case RobotMLPackage.ALGORITHM_LIBRARY: return createAlgorithmLibrary();
			case RobotMLPackage.SENSOR_DRIVER: return createSensorDriver();
			case RobotMLPackage.BUILDING: return createBuilding();
			case RobotMLPackage.PLANET: return createPlanet();
			case RobotMLPackage.LAND_SURFACE: return createLandSurface();
			case RobotMLPackage.FLOOR: return createFloor();
			case RobotMLPackage.WATER_SURFACE: return createWaterSurface();
			case RobotMLPackage.HUMAN: return createHuman();
			case RobotMLPackage.PEDESTRIAN: return createPedestrian();
			case RobotMLPackage.STAIRS: return createStairs();
			case RobotMLPackage.PLATFORM: return createPlatform();
			case RobotMLPackage.EXTERNAL_LIBRARY: return createExternalLibrary();
			case RobotMLPackage.ROBOTIC_MIDDLEWARE: return createRoboticMiddleware();
			case RobotMLPackage.ROBOTIC_SIMULATOR: return createRoboticSimulator();
			case RobotMLPackage.CYCAB_TK: return createCycabTK();
			case RobotMLPackage.BLENDER_MORSE: return createBlenderMorse();
			case RobotMLPackage.ON_PORT: return createOnPort();
			case RobotMLPackage.ALLOCATE: return createAllocate();
			case RobotMLPackage.INERTIAL_MEASUREMENT_UNIT_SYSTEM: return createInertialMeasurementUnitSystem();
			case RobotMLPackage.INERTIAL_NAVIGATION_SYSTEM: return createInertialNavigationSystem();
			case RobotMLPackage.ODOMETRY_SYSTEM: return createOdometrySystem();
			case RobotMLPackage.INFRA_RED_PROXIMETRY_SYSTEM: return createInfraRedProximetrySystem();
			case RobotMLPackage.DEPLOYMENT_PLAN: return createDeploymentPlan();
			case RobotMLPackage.GYROSCOPE: return createGyroscope();
			case RobotMLPackage.ON_PROPERTY: return createOnProperty();
			case RobotMLPackage.CHASSIS: return createChassis();
			case RobotMLPackage.SUPPORTING_STRUCTURE: return createSupportingStructure();
			case RobotMLPackage.MECHANICAL_LINKAGE: return createMechanicalLinkage();
			case RobotMLPackage.LEG: return createLeg();
			case RobotMLPackage.LOCOMOTION_HARDWARE: return createLocomotionHardware();
			case RobotMLPackage.ACTUATOR_HARDWARE: return createActuatorHardware();
			case RobotMLPackage.MOBILE_ROBOT: return createMobileRobot();
			case RobotMLPackage.MANIPULATOR: return createManipulator();
			case RobotMLPackage.PILOTED_SYSTEM: return createPilotedSystem();
			case RobotMLPackage.POWER_HARDWARE: return createPowerHardware();
			case RobotMLPackage.SENSOR_HARDWARE: return createSensorHardware();
			case RobotMLPackage.GRASPING_HARDWARE: return createGraspingHardware();
			case RobotMLPackage.STEERED_WHEEL_HARDWARE: return createSteeredWheelHardware();
			case RobotMLPackage.ARM: return createArm();
			case RobotMLPackage.LEG_SYSTEM: return createLegSystem();
			case RobotMLPackage.GRASPING_SYSTEM: return createGraspingSystem();
			case RobotMLPackage.WEAPON_SYSTEM: return createWeaponSystem();
			case RobotMLPackage.MAN_MACHINE_INTERFACE_SYSTEM: return createManMachineInterfaceSystem();
			case RobotMLPackage.CLOSED_LOOP_CONTROL_SYSTEM: return createClosedLoopControlSystem();
			case RobotMLPackage.OPEN_LOOP_CONTROL_SYSTEM: return createOpenLoopControlSystem();
			case RobotMLPackage.ROBOTIC_HEAD: return createRoboticHead();
			case RobotMLPackage.NAVIGATION_COMMAND_SYSTEM: return createNavigationCommandSystem();
			case RobotMLPackage.JOYSTIC_NAVIGATION_SYSTEM: return createJoysticNavigationSystem();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case RobotMLPackage.SYNCHRONIZATION_KIND:
				return createSynchronizationKindFromString(eDataType, initialValue);
			case RobotMLPackage.DATA_FLOW_DIRECTION_KIND:
				return createDataFlowDirectionKindFromString(eDataType, initialValue);
			case RobotMLPackage.SERVICE_FLOW_KIND:
				return createServiceFlowKindFromString(eDataType, initialValue);
			case RobotMLPackage.UGV_KIND:
				return createUGVKindFromString(eDataType, initialValue);
			case RobotMLPackage.ROBOTIC_MIDDLEWARE_KIND:
				return createRoboticMiddlewareKindFromString(eDataType, initialValue);
			case RobotMLPackage.SHADE:
				return createShadeFromString(eDataType, initialValue);
			case RobotMLPackage.MOBILE_ROBOT_KIND:
				return createMobileRobotKindFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case RobotMLPackage.SYNCHRONIZATION_KIND:
				return convertSynchronizationKindToString(eDataType, instanceValue);
			case RobotMLPackage.DATA_FLOW_DIRECTION_KIND:
				return convertDataFlowDirectionKindToString(eDataType, instanceValue);
			case RobotMLPackage.SERVICE_FLOW_KIND:
				return convertServiceFlowKindToString(eDataType, instanceValue);
			case RobotMLPackage.UGV_KIND:
				return convertUGVKindToString(eDataType, instanceValue);
			case RobotMLPackage.ROBOTIC_MIDDLEWARE_KIND:
				return convertRoboticMiddlewareKindToString(eDataType, instanceValue);
			case RobotMLPackage.SHADE:
				return convertShadeToString(eDataType, instanceValue);
			case RobotMLPackage.MOBILE_ROBOT_KIND:
				return convertMobileRobotKindToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Transition createTransition() {
		TransitionImpl transition = new TransitionImpl();
		return transition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Algorithm createAlgorithm() {
		AlgorithmImpl algorithm = new AlgorithmImpl();
		return algorithm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State createState() {
		StateImpl state = new StateImpl();
		return state;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActuatedJoint createActuatedJoint() {
		ActuatedJointImpl actuatedJoint = new ActuatedJointImpl();
		return actuatedJoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Joint createJoint() {
		JointImpl joint = new JointImpl();
		return joint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompleteBonding createCompleteBonding() {
		CompleteBondingImpl completeBonding = new CompleteBondingImpl();
		return completeBonding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Robot createRobot() {
		RobotImpl robot = new RobotImpl();
		return robot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.papyrus.RobotML.System createSystem() {
		SystemImpl system = new SystemImpl();
		return system;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Agent createAgent() {
		AgentImpl agent = new AgentImpl();
		return agent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PhysicalObject createPhysicalObject() {
		PhysicalObjectImpl physicalObject = new PhysicalObjectImpl();
		return physicalObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Environment createEnvironment() {
		EnvironmentImpl environment = new EnvironmentImpl();
		return environment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Surface createSurface() {
		SurfaceImpl surface = new SurfaceImpl();
		return surface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataFlowPort createDataFlowPort() {
		DataFlowPortImpl dataFlowPort = new DataFlowPortImpl();
		return dataFlowPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServicePort createServicePort() {
		ServicePortImpl servicePort = new ServicePortImpl();
		return servicePort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActuatorSystem createActuatorSystem() {
		ActuatorSystemImpl actuatorSystem = new ActuatorSystemImpl();
		return actuatorSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoboticSystem createRoboticSystem() {
		RoboticSystemImpl roboticSystem = new RoboticSystemImpl();
		return roboticSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CyberPhysicalSystem createCyberPhysicalSystem() {
		CyberPhysicalSystemImpl cyberPhysicalSystem = new CyberPhysicalSystemImpl();
		return cyberPhysicalSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SensorSystem createSensorSystem() {
		SensorSystemImpl sensorSystem = new SensorSystemImpl();
		return sensorSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Hardware createHardware() {
		HardwareImpl hardware = new HardwareImpl();
		return hardware;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Software createSoftware() {
		SoftwareImpl software = new SoftwareImpl();
		return software;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EngineSystem createEngineSystem() {
		EngineSystemImpl engineSystem = new EngineSystemImpl();
		return engineSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SteeredWheelSystem createSteeredWheelSystem() {
		SteeredWheelSystemImpl steeredWheelSystem = new SteeredWheelSystemImpl();
		return steeredWheelSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LocomotionSystem createLocomotionSystem() {
		LocomotionSystemImpl locomotionSystem = new LocomotionSystemImpl();
		return locomotionSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImageSensorSystem createImageSensorSystem() {
		ImageSensorSystemImpl imageSensorSystem = new ImageSensorSystemImpl();
		return imageSensorSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CameraSystem createCameraSystem() {
		CameraSystemImpl cameraSystem = new CameraSystemImpl();
		return cameraSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectDetectionSensorSystem createObjectDetectionSensorSystem() {
		ObjectDetectionSensorSystemImpl objectDetectionSensorSystem = new ObjectDetectionSensorSystemImpl();
		return objectDetectionSensorSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectTrackingSensorSystem createObjectTrackingSensorSystem() {
		ObjectTrackingSensorSystemImpl objectTrackingSensorSystem = new ObjectTrackingSensorSystemImpl();
		return objectTrackingSensorSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LidarSystem createLidarSystem() {
		LidarSystemImpl lidarSystem = new LidarSystemImpl();
		return lidarSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LocalizationSensorSystem createLocalizationSensorSystem() {
		LocalizationSensorSystemImpl localizationSensorSystem = new LocalizationSensorSystemImpl();
		return localizationSensorSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GPSSystem createGPSSystem() {
		GPSSystemImpl gpsSystem = new GPSSystemImpl();
		return gpsSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AlgorithmLibrary createAlgorithmLibrary() {
		AlgorithmLibraryImpl algorithmLibrary = new AlgorithmLibraryImpl();
		return algorithmLibrary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SensorDriver createSensorDriver() {
		SensorDriverImpl sensorDriver = new SensorDriverImpl();
		return sensorDriver;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Building createBuilding() {
		BuildingImpl building = new BuildingImpl();
		return building;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Planet createPlanet() {
		PlanetImpl planet = new PlanetImpl();
		return planet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LandSurface createLandSurface() {
		LandSurfaceImpl landSurface = new LandSurfaceImpl();
		return landSurface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Floor createFloor() {
		FloorImpl floor = new FloorImpl();
		return floor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WaterSurface createWaterSurface() {
		WaterSurfaceImpl waterSurface = new WaterSurfaceImpl();
		return waterSurface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Human createHuman() {
		HumanImpl human = new HumanImpl();
		return human;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pedestrian createPedestrian() {
		PedestrianImpl pedestrian = new PedestrianImpl();
		return pedestrian;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Stairs createStairs() {
		StairsImpl stairs = new StairsImpl();
		return stairs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Platform createPlatform() {
		PlatformImpl platform = new PlatformImpl();
		return platform;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExternalLibrary createExternalLibrary() {
		ExternalLibraryImpl externalLibrary = new ExternalLibraryImpl();
		return externalLibrary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoboticMiddleware createRoboticMiddleware() {
		RoboticMiddlewareImpl roboticMiddleware = new RoboticMiddlewareImpl();
		return roboticMiddleware;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoboticSimulator createRoboticSimulator() {
		RoboticSimulatorImpl roboticSimulator = new RoboticSimulatorImpl();
		return roboticSimulator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CycabTK createCycabTK() {
		CycabTKImpl cycabTK = new CycabTKImpl();
		return cycabTK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BlenderMorse createBlenderMorse() {
		BlenderMorseImpl blenderMorse = new BlenderMorseImpl();
		return blenderMorse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OnPort createOnPort() {
		OnPortImpl onPort = new OnPortImpl();
		return onPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Allocate createAllocate() {
		AllocateImpl allocate = new AllocateImpl();
		return allocate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InertialMeasurementUnitSystem createInertialMeasurementUnitSystem() {
		InertialMeasurementUnitSystemImpl inertialMeasurementUnitSystem = new InertialMeasurementUnitSystemImpl();
		return inertialMeasurementUnitSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InertialNavigationSystem createInertialNavigationSystem() {
		InertialNavigationSystemImpl inertialNavigationSystem = new InertialNavigationSystemImpl();
		return inertialNavigationSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OdometrySystem createOdometrySystem() {
		OdometrySystemImpl odometrySystem = new OdometrySystemImpl();
		return odometrySystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InfraRedProximetrySystem createInfraRedProximetrySystem() {
		InfraRedProximetrySystemImpl infraRedProximetrySystem = new InfraRedProximetrySystemImpl();
		return infraRedProximetrySystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeploymentPlan createDeploymentPlan() {
		DeploymentPlanImpl deploymentPlan = new DeploymentPlanImpl();
		return deploymentPlan;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Gyroscope createGyroscope() {
		GyroscopeImpl gyroscope = new GyroscopeImpl();
		return gyroscope;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OnProperty createOnProperty() {
		OnPropertyImpl onProperty = new OnPropertyImpl();
		return onProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Chassis createChassis() {
		ChassisImpl chassis = new ChassisImpl();
		return chassis;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SupportingStructure createSupportingStructure() {
		SupportingStructureImpl supportingStructure = new SupportingStructureImpl();
		return supportingStructure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MechanicalLinkage createMechanicalLinkage() {
		MechanicalLinkageImpl mechanicalLinkage = new MechanicalLinkageImpl();
		return mechanicalLinkage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Leg createLeg() {
		LegImpl leg = new LegImpl();
		return leg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LocomotionHardware createLocomotionHardware() {
		LocomotionHardwareImpl locomotionHardware = new LocomotionHardwareImpl();
		return locomotionHardware;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActuatorHardware createActuatorHardware() {
		ActuatorHardwareImpl actuatorHardware = new ActuatorHardwareImpl();
		return actuatorHardware;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MobileRobot createMobileRobot() {
		MobileRobotImpl mobileRobot = new MobileRobotImpl();
		return mobileRobot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Manipulator createManipulator() {
		ManipulatorImpl manipulator = new ManipulatorImpl();
		return manipulator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PilotedSystem createPilotedSystem() {
		PilotedSystemImpl pilotedSystem = new PilotedSystemImpl();
		return pilotedSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PowerHardware createPowerHardware() {
		PowerHardwareImpl powerHardware = new PowerHardwareImpl();
		return powerHardware;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SensorHardware createSensorHardware() {
		SensorHardwareImpl sensorHardware = new SensorHardwareImpl();
		return sensorHardware;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraspingHardware createGraspingHardware() {
		GraspingHardwareImpl graspingHardware = new GraspingHardwareImpl();
		return graspingHardware;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SteeredWheelHardware createSteeredWheelHardware() {
		SteeredWheelHardwareImpl steeredWheelHardware = new SteeredWheelHardwareImpl();
		return steeredWheelHardware;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Arm createArm() {
		ArmImpl arm = new ArmImpl();
		return arm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LegSystem createLegSystem() {
		LegSystemImpl legSystem = new LegSystemImpl();
		return legSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraspingSystem createGraspingSystem() {
		GraspingSystemImpl graspingSystem = new GraspingSystemImpl();
		return graspingSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WeaponSystem createWeaponSystem() {
		WeaponSystemImpl weaponSystem = new WeaponSystemImpl();
		return weaponSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ManMachineInterfaceSystem createManMachineInterfaceSystem() {
		ManMachineInterfaceSystemImpl manMachineInterfaceSystem = new ManMachineInterfaceSystemImpl();
		return manMachineInterfaceSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClosedLoopControlSystem createClosedLoopControlSystem() {
		ClosedLoopControlSystemImpl closedLoopControlSystem = new ClosedLoopControlSystemImpl();
		return closedLoopControlSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OpenLoopControlSystem createOpenLoopControlSystem() {
		OpenLoopControlSystemImpl openLoopControlSystem = new OpenLoopControlSystemImpl();
		return openLoopControlSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoboticHead createRoboticHead() {
		RoboticHeadImpl roboticHead = new RoboticHeadImpl();
		return roboticHead;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NavigationCommandSystem createNavigationCommandSystem() {
		NavigationCommandSystemImpl navigationCommandSystem = new NavigationCommandSystemImpl();
		return navigationCommandSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JoysticNavigationSystem createJoysticNavigationSystem() {
		JoysticNavigationSystemImpl joysticNavigationSystem = new JoysticNavigationSystemImpl();
		return joysticNavigationSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SynchronizationKind createSynchronizationKindFromString(EDataType eDataType, String initialValue) {
		SynchronizationKind result = SynchronizationKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSynchronizationKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataFlowDirectionKind createDataFlowDirectionKindFromString(EDataType eDataType, String initialValue) {
		DataFlowDirectionKind result = DataFlowDirectionKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDataFlowDirectionKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceFlowKind createServiceFlowKindFromString(EDataType eDataType, String initialValue) {
		ServiceFlowKind result = ServiceFlowKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertServiceFlowKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UGVKind createUGVKindFromString(EDataType eDataType, String initialValue) {
		UGVKind result = UGVKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertUGVKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoboticMiddlewareKind createRoboticMiddlewareKindFromString(EDataType eDataType, String initialValue) {
		RoboticMiddlewareKind result = RoboticMiddlewareKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRoboticMiddlewareKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Shade createShadeFromString(EDataType eDataType, String initialValue) {
		Shade result = Shade.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertShadeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MobileRobotKind createMobileRobotKindFromString(EDataType eDataType, String initialValue) {
		MobileRobotKind result = MobileRobotKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMobileRobotKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RobotMLPackage getRobotMLPackage() {
		return (RobotMLPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static RobotMLPackage getPackage() {
		return RobotMLPackage.eINSTANCE;
	}

} //RobotMLFactoryImpl
