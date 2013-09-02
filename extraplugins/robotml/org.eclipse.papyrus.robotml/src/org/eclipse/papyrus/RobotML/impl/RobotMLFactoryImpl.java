/**
 */
package org.eclipse.papyrus.RobotML.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

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
import org.eclipse.papyrus.RobotML.ExternalLibrary;
import org.eclipse.papyrus.RobotML.Floor;
import org.eclipse.papyrus.RobotML.GPSSystem;
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
import org.eclipse.papyrus.RobotML.OnProperty;
import org.eclipse.papyrus.RobotML.Pedestrian;
import org.eclipse.papyrus.RobotML.PhysicalObject;
import org.eclipse.papyrus.RobotML.Planet;
import org.eclipse.papyrus.RobotML.Platform;
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
			case RobotMLPackage.SENSOR_SYSTEM: return createSensorSystem();
			case RobotMLPackage.HARDWARE: return createHardware();
			case RobotMLPackage.SOFTWARE: return createSoftware();
			case RobotMLPackage.PRIMITIVE_DATA: return createPrimitiveData();
			case RobotMLPackage.DATA_TYPE: return createDataType();
			case RobotMLPackage.ENGINE_SYSTEM: return createEngineSystem();
			case RobotMLPackage.WHEEL_SYSTEM: return createWheelSystem();
			case RobotMLPackage.IMAGE_SENSOR_SYSTEM: return createImageSensorSystem();
			case RobotMLPackage.CAMERA_SYSTEM: return createCameraSystem();
			case RobotMLPackage.OBJECT_DETECTION_SENSOR_SYSTEM: return createObjectDetectionSensorSystem();
			case RobotMLPackage.OBJECT_TRACKING_SENSOR_SYSTEM: return createObjectTrackingSensorSystem();
			case RobotMLPackage.LIDAR_SYSTEM: return createLidarSystem();
			case RobotMLPackage.LOCALIZATION_SENSOR_SYSTEM: return createLocalizationSensorSystem();
			case RobotMLPackage.GPS_SYSTEM: return createGPSSystem();
			case RobotMLPackage.SIMULATED_SYSTEM: return createSimulatedSystem();
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
			case RobotMLPackage.ROBOT_KIND:
				return createRobotKindFromString(eDataType, initialValue);
			case RobotMLPackage.UGV_KIND:
				return createUGVKindFromString(eDataType, initialValue);
			case RobotMLPackage.SYNCHRONIZATION_KIND:
				return createSynchronizationKindFromString(eDataType, initialValue);
			case RobotMLPackage.DATA_FLOW_DIRECTION_KIND:
				return createDataFlowDirectionKindFromString(eDataType, initialValue);
			case RobotMLPackage.SERVICE_FLOW_KIND:
				return createServiceFlowKindFromString(eDataType, initialValue);
			case RobotMLPackage.ROBOTIC_MIDDLEWARE_KIND:
				return createRoboticMiddlewareKindFromString(eDataType, initialValue);
			case RobotMLPackage.SHADE:
				return createShadeFromString(eDataType, initialValue);
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
			case RobotMLPackage.ROBOT_KIND:
				return convertRobotKindToString(eDataType, instanceValue);
			case RobotMLPackage.UGV_KIND:
				return convertUGVKindToString(eDataType, instanceValue);
			case RobotMLPackage.SYNCHRONIZATION_KIND:
				return convertSynchronizationKindToString(eDataType, instanceValue);
			case RobotMLPackage.DATA_FLOW_DIRECTION_KIND:
				return convertDataFlowDirectionKindToString(eDataType, instanceValue);
			case RobotMLPackage.SERVICE_FLOW_KIND:
				return convertServiceFlowKindToString(eDataType, instanceValue);
			case RobotMLPackage.ROBOTIC_MIDDLEWARE_KIND:
				return convertRoboticMiddlewareKindToString(eDataType, instanceValue);
			case RobotMLPackage.SHADE:
				return convertShadeToString(eDataType, instanceValue);
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
	public PrimitiveData createPrimitiveData() {
		PrimitiveDataImpl primitiveData = new PrimitiveDataImpl();
		return primitiveData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType createDataType() {
		DataTypeImpl dataType = new DataTypeImpl();
		return dataType;
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
	public WheelSystem createWheelSystem() {
		WheelSystemImpl wheelSystem = new WheelSystemImpl();
		return wheelSystem;
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
	public SimulatedSystem createSimulatedSystem() {
		SimulatedSystemImpl simulatedSystem = new SimulatedSystemImpl();
		return simulatedSystem;
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
	public RobotKind createRobotKindFromString(EDataType eDataType, String initialValue) {
		RobotKind result = RobotKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRobotKindToString(EDataType eDataType, Object instanceValue) {
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
