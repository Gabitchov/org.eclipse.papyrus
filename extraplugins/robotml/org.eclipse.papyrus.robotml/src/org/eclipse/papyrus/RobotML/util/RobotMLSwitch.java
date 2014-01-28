/**
 */
package org.eclipse.papyrus.RobotML.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

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
import org.eclipse.papyrus.RobotML.DataFlowPort;
import org.eclipse.papyrus.RobotML.DeploymentPlan;
import org.eclipse.papyrus.RobotML.EngineSystem;
import org.eclipse.papyrus.RobotML.Environment;
import org.eclipse.papyrus.RobotML.ExternalLibrary;
import org.eclipse.papyrus.RobotML.Floor;
import org.eclipse.papyrus.RobotML.GPSSystem;
import org.eclipse.papyrus.RobotML.GraspingHardware;
import org.eclipse.papyrus.RobotML.GraspingSystem;
import org.eclipse.papyrus.RobotML.Ground;
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
import org.eclipse.papyrus.RobotML.Port;
import org.eclipse.papyrus.RobotML.PowerHardware;
import org.eclipse.papyrus.RobotML.Robot;
import org.eclipse.papyrus.RobotML.RobotMLPackage;
import org.eclipse.papyrus.RobotML.RoboticHead;
import org.eclipse.papyrus.RobotML.RoboticMiddleware;
import org.eclipse.papyrus.RobotML.RoboticSimulator;
import org.eclipse.papyrus.RobotML.RoboticSystem;
import org.eclipse.papyrus.RobotML.SensorDriver;
import org.eclipse.papyrus.RobotML.SensorHardware;
import org.eclipse.papyrus.RobotML.SensorSystem;
import org.eclipse.papyrus.RobotML.ServicePort;
import org.eclipse.papyrus.RobotML.Software;
import org.eclipse.papyrus.RobotML.Stairs;
import org.eclipse.papyrus.RobotML.State;
import org.eclipse.papyrus.RobotML.SteeredWheelHardware;
import org.eclipse.papyrus.RobotML.SteeredWheelSystem;
import org.eclipse.papyrus.RobotML.SupportingStructure;
import org.eclipse.papyrus.RobotML.Surface;
import org.eclipse.papyrus.RobotML.Transition;
import org.eclipse.papyrus.RobotML.WaterSurface;
import org.eclipse.papyrus.RobotML.WeaponSystem;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.RobotML.RobotMLPackage
 * @generated
 */
public class RobotMLSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static RobotMLPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RobotMLSwitch() {
		if (modelPackage == null) {
			modelPackage = RobotMLPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case RobotMLPackage.TRANSITION: {
				Transition transition = (Transition)theEObject;
				T result = caseTransition(transition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotMLPackage.ALGORITHM: {
				Algorithm algorithm = (Algorithm)theEObject;
				T result = caseAlgorithm(algorithm);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotMLPackage.STATE: {
				State state = (State)theEObject;
				T result = caseState(state);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotMLPackage.ACTUATED_JOINT: {
				ActuatedJoint actuatedJoint = (ActuatedJoint)theEObject;
				T result = caseActuatedJoint(actuatedJoint);
				if (result == null) result = caseJoint(actuatedJoint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotMLPackage.JOINT: {
				Joint joint = (Joint)theEObject;
				T result = caseJoint(joint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotMLPackage.COMPLETE_BONDING: {
				CompleteBonding completeBonding = (CompleteBonding)theEObject;
				T result = caseCompleteBonding(completeBonding);
				if (result == null) result = caseJoint(completeBonding);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotMLPackage.ROBOT: {
				Robot robot = (Robot)theEObject;
				T result = caseRobot(robot);
				if (result == null) result = caseAgent(robot);
				if (result == null) result = casePhysicalObject(robot);
				if (result == null) result = caseSystem(robot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotMLPackage.SYSTEM: {
				org.eclipse.papyrus.RobotML.System system = (org.eclipse.papyrus.RobotML.System)theEObject;
				T result = caseSystem(system);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotMLPackage.AGENT: {
				Agent agent = (Agent)theEObject;
				T result = caseAgent(agent);
				if (result == null) result = casePhysicalObject(agent);
				if (result == null) result = caseSystem(agent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotMLPackage.PHYSICAL_OBJECT: {
				PhysicalObject physicalObject = (PhysicalObject)theEObject;
				T result = casePhysicalObject(physicalObject);
				if (result == null) result = caseSystem(physicalObject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotMLPackage.ENVIRONMENT: {
				Environment environment = (Environment)theEObject;
				T result = caseEnvironment(environment);
				if (result == null) result = caseSystem(environment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotMLPackage.SURFACE: {
				Surface surface = (Surface)theEObject;
				T result = caseSurface(surface);
				if (result == null) result = casePhysicalObject(surface);
				if (result == null) result = caseSystem(surface);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotMLPackage.DATA_FLOW_PORT: {
				DataFlowPort dataFlowPort = (DataFlowPort)theEObject;
				T result = caseDataFlowPort(dataFlowPort);
				if (result == null) result = casePort(dataFlowPort);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotMLPackage.PORT: {
				Port port = (Port)theEObject;
				T result = casePort(port);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotMLPackage.SERVICE_PORT: {
				ServicePort servicePort = (ServicePort)theEObject;
				T result = caseServicePort(servicePort);
				if (result == null) result = casePort(servicePort);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotMLPackage.ACTUATOR_SYSTEM: {
				ActuatorSystem actuatorSystem = (ActuatorSystem)theEObject;
				T result = caseActuatorSystem(actuatorSystem);
				if (result == null) result = caseRoboticSystem(actuatorSystem);
				if (result == null) result = caseCyberPhysicalSystem(actuatorSystem);
				if (result == null) result = caseSystem(actuatorSystem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotMLPackage.ROBOTIC_SYSTEM: {
				RoboticSystem roboticSystem = (RoboticSystem)theEObject;
				T result = caseRoboticSystem(roboticSystem);
				if (result == null) result = caseSystem(roboticSystem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotMLPackage.CYBER_PHYSICAL_SYSTEM: {
				CyberPhysicalSystem cyberPhysicalSystem = (CyberPhysicalSystem)theEObject;
				T result = caseCyberPhysicalSystem(cyberPhysicalSystem);
				if (result == null) result = caseSystem(cyberPhysicalSystem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotMLPackage.SENSOR_SYSTEM: {
				SensorSystem sensorSystem = (SensorSystem)theEObject;
				T result = caseSensorSystem(sensorSystem);
				if (result == null) result = caseRoboticSystem(sensorSystem);
				if (result == null) result = caseCyberPhysicalSystem(sensorSystem);
				if (result == null) result = caseSystem(sensorSystem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotMLPackage.HARDWARE: {
				Hardware hardware = (Hardware)theEObject;
				T result = caseHardware(hardware);
				if (result == null) result = casePhysicalObject(hardware);
				if (result == null) result = caseSystem(hardware);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotMLPackage.SOFTWARE: {
				Software software = (Software)theEObject;
				T result = caseSoftware(software);
				if (result == null) result = caseSystem(software);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotMLPackage.ENGINE_SYSTEM: {
				EngineSystem engineSystem = (EngineSystem)theEObject;
				T result = caseEngineSystem(engineSystem);
				if (result == null) result = caseActuatorSystem(engineSystem);
				if (result == null) result = caseRoboticSystem(engineSystem);
				if (result == null) result = caseCyberPhysicalSystem(engineSystem);
				if (result == null) result = caseSystem(engineSystem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotMLPackage.STEERED_WHEEL_SYSTEM: {
				SteeredWheelSystem steeredWheelSystem = (SteeredWheelSystem)theEObject;
				T result = caseSteeredWheelSystem(steeredWheelSystem);
				if (result == null) result = caseLocomotionSystem(steeredWheelSystem);
				if (result == null) result = caseActuatorSystem(steeredWheelSystem);
				if (result == null) result = caseRoboticSystem(steeredWheelSystem);
				if (result == null) result = caseCyberPhysicalSystem(steeredWheelSystem);
				if (result == null) result = caseSystem(steeredWheelSystem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotMLPackage.LOCOMOTION_SYSTEM: {
				LocomotionSystem locomotionSystem = (LocomotionSystem)theEObject;
				T result = caseLocomotionSystem(locomotionSystem);
				if (result == null) result = caseActuatorSystem(locomotionSystem);
				if (result == null) result = caseRoboticSystem(locomotionSystem);
				if (result == null) result = caseCyberPhysicalSystem(locomotionSystem);
				if (result == null) result = caseSystem(locomotionSystem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotMLPackage.IMAGE_SENSOR_SYSTEM: {
				ImageSensorSystem imageSensorSystem = (ImageSensorSystem)theEObject;
				T result = caseImageSensorSystem(imageSensorSystem);
				if (result == null) result = caseSensorSystem(imageSensorSystem);
				if (result == null) result = caseRoboticSystem(imageSensorSystem);
				if (result == null) result = caseCyberPhysicalSystem(imageSensorSystem);
				if (result == null) result = caseSystem(imageSensorSystem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotMLPackage.CAMERA_SYSTEM: {
				CameraSystem cameraSystem = (CameraSystem)theEObject;
				T result = caseCameraSystem(cameraSystem);
				if (result == null) result = caseImageSensorSystem(cameraSystem);
				if (result == null) result = caseSensorSystem(cameraSystem);
				if (result == null) result = caseRoboticSystem(cameraSystem);
				if (result == null) result = caseCyberPhysicalSystem(cameraSystem);
				if (result == null) result = caseSystem(cameraSystem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotMLPackage.OBJECT_DETECTION_SENSOR_SYSTEM: {
				ObjectDetectionSensorSystem objectDetectionSensorSystem = (ObjectDetectionSensorSystem)theEObject;
				T result = caseObjectDetectionSensorSystem(objectDetectionSensorSystem);
				if (result == null) result = caseSensorSystem(objectDetectionSensorSystem);
				if (result == null) result = caseRoboticSystem(objectDetectionSensorSystem);
				if (result == null) result = caseCyberPhysicalSystem(objectDetectionSensorSystem);
				if (result == null) result = caseSystem(objectDetectionSensorSystem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotMLPackage.OBJECT_TRACKING_SENSOR_SYSTEM: {
				ObjectTrackingSensorSystem objectTrackingSensorSystem = (ObjectTrackingSensorSystem)theEObject;
				T result = caseObjectTrackingSensorSystem(objectTrackingSensorSystem);
				if (result == null) result = caseSensorSystem(objectTrackingSensorSystem);
				if (result == null) result = caseRoboticSystem(objectTrackingSensorSystem);
				if (result == null) result = caseCyberPhysicalSystem(objectTrackingSensorSystem);
				if (result == null) result = caseSystem(objectTrackingSensorSystem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotMLPackage.LIDAR_SYSTEM: {
				LidarSystem lidarSystem = (LidarSystem)theEObject;
				T result = caseLidarSystem(lidarSystem);
				if (result == null) result = caseObjectDetectionSensorSystem(lidarSystem);
				if (result == null) result = caseObjectTrackingSensorSystem(lidarSystem);
				if (result == null) result = caseSensorSystem(lidarSystem);
				if (result == null) result = caseRoboticSystem(lidarSystem);
				if (result == null) result = caseCyberPhysicalSystem(lidarSystem);
				if (result == null) result = caseSystem(lidarSystem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotMLPackage.LOCALIZATION_SENSOR_SYSTEM: {
				LocalizationSensorSystem localizationSensorSystem = (LocalizationSensorSystem)theEObject;
				T result = caseLocalizationSensorSystem(localizationSensorSystem);
				if (result == null) result = caseSensorSystem(localizationSensorSystem);
				if (result == null) result = caseRoboticSystem(localizationSensorSystem);
				if (result == null) result = caseCyberPhysicalSystem(localizationSensorSystem);
				if (result == null) result = caseSystem(localizationSensorSystem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotMLPackage.GPS_SYSTEM: {
				GPSSystem gpsSystem = (GPSSystem)theEObject;
				T result = caseGPSSystem(gpsSystem);
				if (result == null) result = caseLocalizationSensorSystem(gpsSystem);
				if (result == null) result = caseSensorSystem(gpsSystem);
				if (result == null) result = caseRoboticSystem(gpsSystem);
				if (result == null) result = caseCyberPhysicalSystem(gpsSystem);
				if (result == null) result = caseSystem(gpsSystem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotMLPackage.ALGORITHM_LIBRARY: {
				AlgorithmLibrary algorithmLibrary = (AlgorithmLibrary)theEObject;
				T result = caseAlgorithmLibrary(algorithmLibrary);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotMLPackage.SENSOR_DRIVER: {
				SensorDriver sensorDriver = (SensorDriver)theEObject;
				T result = caseSensorDriver(sensorDriver);
				if (result == null) result = caseSoftware(sensorDriver);
				if (result == null) result = caseSystem(sensorDriver);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotMLPackage.BUILDING: {
				Building building = (Building)theEObject;
				T result = caseBuilding(building);
				if (result == null) result = casePhysicalObject(building);
				if (result == null) result = caseSystem(building);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotMLPackage.PLANET: {
				Planet planet = (Planet)theEObject;
				T result = casePlanet(planet);
				if (result == null) result = casePhysicalObject(planet);
				if (result == null) result = caseSystem(planet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotMLPackage.LAND_SURFACE: {
				LandSurface landSurface = (LandSurface)theEObject;
				T result = caseLandSurface(landSurface);
				if (result == null) result = caseGround(landSurface);
				if (result == null) result = caseSurface(landSurface);
				if (result == null) result = casePhysicalObject(landSurface);
				if (result == null) result = caseSystem(landSurface);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotMLPackage.GROUND: {
				Ground ground = (Ground)theEObject;
				T result = caseGround(ground);
				if (result == null) result = caseSurface(ground);
				if (result == null) result = casePhysicalObject(ground);
				if (result == null) result = caseSystem(ground);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotMLPackage.FLOOR: {
				Floor floor = (Floor)theEObject;
				T result = caseFloor(floor);
				if (result == null) result = caseGround(floor);
				if (result == null) result = caseSurface(floor);
				if (result == null) result = casePhysicalObject(floor);
				if (result == null) result = caseSystem(floor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotMLPackage.WATER_SURFACE: {
				WaterSurface waterSurface = (WaterSurface)theEObject;
				T result = caseWaterSurface(waterSurface);
				if (result == null) result = caseSurface(waterSurface);
				if (result == null) result = casePhysicalObject(waterSurface);
				if (result == null) result = caseSystem(waterSurface);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotMLPackage.HUMAN: {
				Human human = (Human)theEObject;
				T result = caseHuman(human);
				if (result == null) result = caseAgent(human);
				if (result == null) result = casePhysicalObject(human);
				if (result == null) result = caseSystem(human);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotMLPackage.PEDESTRIAN: {
				Pedestrian pedestrian = (Pedestrian)theEObject;
				T result = casePedestrian(pedestrian);
				if (result == null) result = caseHuman(pedestrian);
				if (result == null) result = caseAgent(pedestrian);
				if (result == null) result = casePhysicalObject(pedestrian);
				if (result == null) result = caseSystem(pedestrian);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotMLPackage.STAIRS: {
				Stairs stairs = (Stairs)theEObject;
				T result = caseStairs(stairs);
				if (result == null) result = caseGround(stairs);
				if (result == null) result = caseSurface(stairs);
				if (result == null) result = casePhysicalObject(stairs);
				if (result == null) result = caseSystem(stairs);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotMLPackage.PLATFORM: {
				Platform platform = (Platform)theEObject;
				T result = casePlatform(platform);
				if (result == null) result = caseSystem(platform);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotMLPackage.EXTERNAL_LIBRARY: {
				ExternalLibrary externalLibrary = (ExternalLibrary)theEObject;
				T result = caseExternalLibrary(externalLibrary);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotMLPackage.ROBOTIC_MIDDLEWARE: {
				RoboticMiddleware roboticMiddleware = (RoboticMiddleware)theEObject;
				T result = caseRoboticMiddleware(roboticMiddleware);
				if (result == null) result = casePlatform(roboticMiddleware);
				if (result == null) result = caseSystem(roboticMiddleware);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotMLPackage.ROBOTIC_SIMULATOR: {
				RoboticSimulator roboticSimulator = (RoboticSimulator)theEObject;
				T result = caseRoboticSimulator(roboticSimulator);
				if (result == null) result = casePlatform(roboticSimulator);
				if (result == null) result = caseSystem(roboticSimulator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotMLPackage.CYCAB_TK: {
				CycabTK cycabTK = (CycabTK)theEObject;
				T result = caseCycabTK(cycabTK);
				if (result == null) result = caseRoboticSimulator(cycabTK);
				if (result == null) result = casePlatform(cycabTK);
				if (result == null) result = caseSystem(cycabTK);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotMLPackage.BLENDER_MORSE: {
				BlenderMorse blenderMorse = (BlenderMorse)theEObject;
				T result = caseBlenderMorse(blenderMorse);
				if (result == null) result = caseRoboticSimulator(blenderMorse);
				if (result == null) result = casePlatform(blenderMorse);
				if (result == null) result = caseSystem(blenderMorse);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotMLPackage.ON_PORT: {
				OnPort onPort = (OnPort)theEObject;
				T result = caseOnPort(onPort);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotMLPackage.ALLOCATE: {
				Allocate allocate = (Allocate)theEObject;
				T result = caseAllocate(allocate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotMLPackage.INERTIAL_MEASUREMENT_UNIT_SYSTEM: {
				InertialMeasurementUnitSystem inertialMeasurementUnitSystem = (InertialMeasurementUnitSystem)theEObject;
				T result = caseInertialMeasurementUnitSystem(inertialMeasurementUnitSystem);
				if (result == null) result = caseSensorSystem(inertialMeasurementUnitSystem);
				if (result == null) result = caseRoboticSystem(inertialMeasurementUnitSystem);
				if (result == null) result = caseCyberPhysicalSystem(inertialMeasurementUnitSystem);
				if (result == null) result = caseSystem(inertialMeasurementUnitSystem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotMLPackage.INERTIAL_NAVIGATION_SYSTEM: {
				InertialNavigationSystem inertialNavigationSystem = (InertialNavigationSystem)theEObject;
				T result = caseInertialNavigationSystem(inertialNavigationSystem);
				if (result == null) result = caseGPSSystem(inertialNavigationSystem);
				if (result == null) result = caseLocalizationSensorSystem(inertialNavigationSystem);
				if (result == null) result = caseSensorSystem(inertialNavigationSystem);
				if (result == null) result = caseRoboticSystem(inertialNavigationSystem);
				if (result == null) result = caseCyberPhysicalSystem(inertialNavigationSystem);
				if (result == null) result = caseSystem(inertialNavigationSystem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotMLPackage.ODOMETRY_SYSTEM: {
				OdometrySystem odometrySystem = (OdometrySystem)theEObject;
				T result = caseOdometrySystem(odometrySystem);
				if (result == null) result = caseLocalizationSensorSystem(odometrySystem);
				if (result == null) result = caseSensorSystem(odometrySystem);
				if (result == null) result = caseRoboticSystem(odometrySystem);
				if (result == null) result = caseCyberPhysicalSystem(odometrySystem);
				if (result == null) result = caseSystem(odometrySystem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotMLPackage.INFRA_RED_PROXIMETRY_SYSTEM: {
				InfraRedProximetrySystem infraRedProximetrySystem = (InfraRedProximetrySystem)theEObject;
				T result = caseInfraRedProximetrySystem(infraRedProximetrySystem);
				if (result == null) result = caseObjectDetectionSensorSystem(infraRedProximetrySystem);
				if (result == null) result = caseSensorSystem(infraRedProximetrySystem);
				if (result == null) result = caseRoboticSystem(infraRedProximetrySystem);
				if (result == null) result = caseCyberPhysicalSystem(infraRedProximetrySystem);
				if (result == null) result = caseSystem(infraRedProximetrySystem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotMLPackage.DEPLOYMENT_PLAN: {
				DeploymentPlan deploymentPlan = (DeploymentPlan)theEObject;
				T result = caseDeploymentPlan(deploymentPlan);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotMLPackage.GYROSCOPE: {
				Gyroscope gyroscope = (Gyroscope)theEObject;
				T result = caseGyroscope(gyroscope);
				if (result == null) result = caseSensorSystem(gyroscope);
				if (result == null) result = caseRoboticSystem(gyroscope);
				if (result == null) result = caseCyberPhysicalSystem(gyroscope);
				if (result == null) result = caseSystem(gyroscope);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotMLPackage.ON_PROPERTY: {
				OnProperty onProperty = (OnProperty)theEObject;
				T result = caseOnProperty(onProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotMLPackage.CHASSIS: {
				Chassis chassis = (Chassis)theEObject;
				T result = caseChassis(chassis);
				if (result == null) result = caseSupportingStructure(chassis);
				if (result == null) result = caseHardware(chassis);
				if (result == null) result = casePhysicalObject(chassis);
				if (result == null) result = caseSystem(chassis);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotMLPackage.SUPPORTING_STRUCTURE: {
				SupportingStructure supportingStructure = (SupportingStructure)theEObject;
				T result = caseSupportingStructure(supportingStructure);
				if (result == null) result = caseHardware(supportingStructure);
				if (result == null) result = casePhysicalObject(supportingStructure);
				if (result == null) result = caseSystem(supportingStructure);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotMLPackage.MECHANICAL_LINKAGE: {
				MechanicalLinkage mechanicalLinkage = (MechanicalLinkage)theEObject;
				T result = caseMechanicalLinkage(mechanicalLinkage);
				if (result == null) result = caseHardware(mechanicalLinkage);
				if (result == null) result = casePhysicalObject(mechanicalLinkage);
				if (result == null) result = caseSystem(mechanicalLinkage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotMLPackage.LEG: {
				Leg leg = (Leg)theEObject;
				T result = caseLeg(leg);
				if (result == null) result = caseLocomotionHardware(leg);
				if (result == null) result = caseMechanicalLinkage(leg);
				if (result == null) result = caseActuatorHardware(leg);
				if (result == null) result = caseHardware(leg);
				if (result == null) result = casePhysicalObject(leg);
				if (result == null) result = caseSystem(leg);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotMLPackage.LOCOMOTION_HARDWARE: {
				LocomotionHardware locomotionHardware = (LocomotionHardware)theEObject;
				T result = caseLocomotionHardware(locomotionHardware);
				if (result == null) result = caseActuatorHardware(locomotionHardware);
				if (result == null) result = caseHardware(locomotionHardware);
				if (result == null) result = casePhysicalObject(locomotionHardware);
				if (result == null) result = caseSystem(locomotionHardware);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotMLPackage.ACTUATOR_HARDWARE: {
				ActuatorHardware actuatorHardware = (ActuatorHardware)theEObject;
				T result = caseActuatorHardware(actuatorHardware);
				if (result == null) result = caseHardware(actuatorHardware);
				if (result == null) result = casePhysicalObject(actuatorHardware);
				if (result == null) result = caseSystem(actuatorHardware);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotMLPackage.MOBILE_ROBOT: {
				MobileRobot mobileRobot = (MobileRobot)theEObject;
				T result = caseMobileRobot(mobileRobot);
				if (result == null) result = caseRobot(mobileRobot);
				if (result == null) result = caseAgent(mobileRobot);
				if (result == null) result = casePhysicalObject(mobileRobot);
				if (result == null) result = caseSystem(mobileRobot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotMLPackage.MANIPULATOR: {
				Manipulator manipulator = (Manipulator)theEObject;
				T result = caseManipulator(manipulator);
				if (result == null) result = caseRobot(manipulator);
				if (result == null) result = caseAgent(manipulator);
				if (result == null) result = casePhysicalObject(manipulator);
				if (result == null) result = caseSystem(manipulator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotMLPackage.PILOTED_SYSTEM: {
				PilotedSystem pilotedSystem = (PilotedSystem)theEObject;
				T result = casePilotedSystem(pilotedSystem);
				if (result == null) result = caseRobot(pilotedSystem);
				if (result == null) result = caseAgent(pilotedSystem);
				if (result == null) result = casePhysicalObject(pilotedSystem);
				if (result == null) result = caseSystem(pilotedSystem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotMLPackage.POWER_HARDWARE: {
				PowerHardware powerHardware = (PowerHardware)theEObject;
				T result = casePowerHardware(powerHardware);
				if (result == null) result = caseHardware(powerHardware);
				if (result == null) result = casePhysicalObject(powerHardware);
				if (result == null) result = caseSystem(powerHardware);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotMLPackage.SENSOR_HARDWARE: {
				SensorHardware sensorHardware = (SensorHardware)theEObject;
				T result = caseSensorHardware(sensorHardware);
				if (result == null) result = caseHardware(sensorHardware);
				if (result == null) result = casePhysicalObject(sensorHardware);
				if (result == null) result = caseSystem(sensorHardware);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotMLPackage.GRASPING_HARDWARE: {
				GraspingHardware graspingHardware = (GraspingHardware)theEObject;
				T result = caseGraspingHardware(graspingHardware);
				if (result == null) result = caseActuatorHardware(graspingHardware);
				if (result == null) result = caseHardware(graspingHardware);
				if (result == null) result = casePhysicalObject(graspingHardware);
				if (result == null) result = caseSystem(graspingHardware);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotMLPackage.STEERED_WHEEL_HARDWARE: {
				SteeredWheelHardware steeredWheelHardware = (SteeredWheelHardware)theEObject;
				T result = caseSteeredWheelHardware(steeredWheelHardware);
				if (result == null) result = caseLocomotionHardware(steeredWheelHardware);
				if (result == null) result = caseActuatorHardware(steeredWheelHardware);
				if (result == null) result = caseHardware(steeredWheelHardware);
				if (result == null) result = casePhysicalObject(steeredWheelHardware);
				if (result == null) result = caseSystem(steeredWheelHardware);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotMLPackage.ARM: {
				Arm arm = (Arm)theEObject;
				T result = caseArm(arm);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotMLPackage.LEG_SYSTEM: {
				LegSystem legSystem = (LegSystem)theEObject;
				T result = caseLegSystem(legSystem);
				if (result == null) result = caseLocomotionSystem(legSystem);
				if (result == null) result = caseActuatorSystem(legSystem);
				if (result == null) result = caseRoboticSystem(legSystem);
				if (result == null) result = caseCyberPhysicalSystem(legSystem);
				if (result == null) result = caseSystem(legSystem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotMLPackage.GRASPING_SYSTEM: {
				GraspingSystem graspingSystem = (GraspingSystem)theEObject;
				T result = caseGraspingSystem(graspingSystem);
				if (result == null) result = caseActuatorSystem(graspingSystem);
				if (result == null) result = caseRoboticSystem(graspingSystem);
				if (result == null) result = caseCyberPhysicalSystem(graspingSystem);
				if (result == null) result = caseSystem(graspingSystem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotMLPackage.WEAPON_SYSTEM: {
				WeaponSystem weaponSystem = (WeaponSystem)theEObject;
				T result = caseWeaponSystem(weaponSystem);
				if (result == null) result = caseActuatorSystem(weaponSystem);
				if (result == null) result = caseRoboticSystem(weaponSystem);
				if (result == null) result = caseCyberPhysicalSystem(weaponSystem);
				if (result == null) result = caseSystem(weaponSystem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotMLPackage.MAN_MACHINE_INTERFACE_SYSTEM: {
				ManMachineInterfaceSystem manMachineInterfaceSystem = (ManMachineInterfaceSystem)theEObject;
				T result = caseManMachineInterfaceSystem(manMachineInterfaceSystem);
				if (result == null) result = caseCyberPhysicalSystem(manMachineInterfaceSystem);
				if (result == null) result = caseSystem(manMachineInterfaceSystem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotMLPackage.CLOSED_LOOP_CONTROL_SYSTEM: {
				ClosedLoopControlSystem closedLoopControlSystem = (ClosedLoopControlSystem)theEObject;
				T result = caseClosedLoopControlSystem(closedLoopControlSystem);
				if (result == null) result = caseCyberPhysicalSystem(closedLoopControlSystem);
				if (result == null) result = caseSystem(closedLoopControlSystem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotMLPackage.OPEN_LOOP_CONTROL_SYSTEM: {
				OpenLoopControlSystem openLoopControlSystem = (OpenLoopControlSystem)theEObject;
				T result = caseOpenLoopControlSystem(openLoopControlSystem);
				if (result == null) result = caseCyberPhysicalSystem(openLoopControlSystem);
				if (result == null) result = caseSystem(openLoopControlSystem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotMLPackage.ROBOTIC_HEAD: {
				RoboticHead roboticHead = (RoboticHead)theEObject;
				T result = caseRoboticHead(roboticHead);
				if (result == null) result = caseManMachineInterfaceSystem(roboticHead);
				if (result == null) result = caseCyberPhysicalSystem(roboticHead);
				if (result == null) result = caseSystem(roboticHead);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotMLPackage.NAVIGATION_COMMAND_SYSTEM: {
				NavigationCommandSystem navigationCommandSystem = (NavigationCommandSystem)theEObject;
				T result = caseNavigationCommandSystem(navigationCommandSystem);
				if (result == null) result = caseManMachineInterfaceSystem(navigationCommandSystem);
				if (result == null) result = caseCyberPhysicalSystem(navigationCommandSystem);
				if (result == null) result = caseSystem(navigationCommandSystem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RobotMLPackage.JOYSTIC_NAVIGATION_SYSTEM: {
				JoysticNavigationSystem joysticNavigationSystem = (JoysticNavigationSystem)theEObject;
				T result = caseJoysticNavigationSystem(joysticNavigationSystem);
				if (result == null) result = caseNavigationCommandSystem(joysticNavigationSystem);
				if (result == null) result = caseManMachineInterfaceSystem(joysticNavigationSystem);
				if (result == null) result = caseCyberPhysicalSystem(joysticNavigationSystem);
				if (result == null) result = caseSystem(joysticNavigationSystem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Transition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Transition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTransition(Transition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Algorithm</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Algorithm</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAlgorithm(Algorithm object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseState(State object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Actuated Joint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Actuated Joint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActuatedJoint(ActuatedJoint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Joint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Joint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJoint(Joint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Complete Bonding</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Complete Bonding</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompleteBonding(CompleteBonding object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Robot</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Robot</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRobot(Robot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>System</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>System</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSystem(org.eclipse.papyrus.RobotML.System object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Agent</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Agent</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAgent(Agent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Physical Object</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Physical Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePhysicalObject(PhysicalObject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Environment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Environment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnvironment(Environment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Surface</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Surface</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSurface(Surface object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Flow Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Flow Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataFlowPort(DataFlowPort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePort(Port object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Service Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Service Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseServicePort(ServicePort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Actuator System</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Actuator System</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActuatorSystem(ActuatorSystem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Robotic System</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Robotic System</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRoboticSystem(RoboticSystem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cyber Physical System</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cyber Physical System</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCyberPhysicalSystem(CyberPhysicalSystem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sensor System</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sensor System</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSensorSystem(SensorSystem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Hardware</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Hardware</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHardware(Hardware object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Software</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Software</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSoftware(Software object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Engine System</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Engine System</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEngineSystem(EngineSystem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Steered Wheel System</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Steered Wheel System</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSteeredWheelSystem(SteeredWheelSystem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Locomotion System</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Locomotion System</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLocomotionSystem(LocomotionSystem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Image Sensor System</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Image Sensor System</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImageSensorSystem(ImageSensorSystem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Camera System</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Camera System</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCameraSystem(CameraSystem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Object Detection Sensor System</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Object Detection Sensor System</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseObjectDetectionSensorSystem(ObjectDetectionSensorSystem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Object Tracking Sensor System</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Object Tracking Sensor System</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseObjectTrackingSensorSystem(ObjectTrackingSensorSystem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Lidar System</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Lidar System</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLidarSystem(LidarSystem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Localization Sensor System</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Localization Sensor System</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLocalizationSensorSystem(LocalizationSensorSystem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>GPS System</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>GPS System</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGPSSystem(GPSSystem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Algorithm Library</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Algorithm Library</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAlgorithmLibrary(AlgorithmLibrary object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sensor Driver</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sensor Driver</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSensorDriver(SensorDriver object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Building</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Building</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBuilding(Building object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Planet</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Planet</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePlanet(Planet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Land Surface</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Land Surface</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLandSurface(LandSurface object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ground</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ground</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGround(Ground object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Floor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Floor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFloor(Floor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Water Surface</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Water Surface</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWaterSurface(WaterSurface object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Human</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Human</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHuman(Human object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pedestrian</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pedestrian</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePedestrian(Pedestrian object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Stairs</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Stairs</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStairs(Stairs object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Platform</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Platform</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePlatform(Platform object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>External Library</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>External Library</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExternalLibrary(ExternalLibrary object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Robotic Middleware</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Robotic Middleware</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRoboticMiddleware(RoboticMiddleware object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Robotic Simulator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Robotic Simulator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRoboticSimulator(RoboticSimulator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cycab TK</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cycab TK</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCycabTK(CycabTK object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Blender Morse</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Blender Morse</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBlenderMorse(BlenderMorse object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>On Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>On Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOnPort(OnPort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Allocate</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Allocate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAllocate(Allocate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Inertial Measurement Unit System</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Inertial Measurement Unit System</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInertialMeasurementUnitSystem(InertialMeasurementUnitSystem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Inertial Navigation System</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Inertial Navigation System</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInertialNavigationSystem(InertialNavigationSystem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Odometry System</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Odometry System</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOdometrySystem(OdometrySystem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Infra Red Proximetry System</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Infra Red Proximetry System</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInfraRedProximetrySystem(InfraRedProximetrySystem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Deployment Plan</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Deployment Plan</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeploymentPlan(DeploymentPlan object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gyroscope</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gyroscope</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGyroscope(Gyroscope object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>On Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>On Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOnProperty(OnProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Chassis</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Chassis</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseChassis(Chassis object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Supporting Structure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Supporting Structure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSupportingStructure(SupportingStructure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mechanical Linkage</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mechanical Linkage</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMechanicalLinkage(MechanicalLinkage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Leg</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Leg</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLeg(Leg object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Locomotion Hardware</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Locomotion Hardware</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLocomotionHardware(LocomotionHardware object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Actuator Hardware</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Actuator Hardware</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActuatorHardware(ActuatorHardware object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mobile Robot</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mobile Robot</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMobileRobot(MobileRobot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Manipulator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Manipulator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseManipulator(Manipulator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Piloted System</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Piloted System</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePilotedSystem(PilotedSystem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Power Hardware</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Power Hardware</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePowerHardware(PowerHardware object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sensor Hardware</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sensor Hardware</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSensorHardware(SensorHardware object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Grasping Hardware</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Grasping Hardware</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGraspingHardware(GraspingHardware object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Steered Wheel Hardware</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Steered Wheel Hardware</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSteeredWheelHardware(SteeredWheelHardware object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Arm</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Arm</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseArm(Arm object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Leg System</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Leg System</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLegSystem(LegSystem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Grasping System</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Grasping System</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGraspingSystem(GraspingSystem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Weapon System</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Weapon System</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWeaponSystem(WeaponSystem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Man Machine Interface System</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Man Machine Interface System</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseManMachineInterfaceSystem(ManMachineInterfaceSystem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Closed Loop Control System</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Closed Loop Control System</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClosedLoopControlSystem(ClosedLoopControlSystem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Open Loop Control System</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Open Loop Control System</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOpenLoopControlSystem(OpenLoopControlSystem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Robotic Head</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Robotic Head</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRoboticHead(RoboticHead object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Navigation Command System</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Navigation Command System</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNavigationCommandSystem(NavigationCommandSystem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Joystic Navigation System</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Joystic Navigation System</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJoysticNavigationSystem(JoysticNavigationSystem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //RobotMLSwitch
