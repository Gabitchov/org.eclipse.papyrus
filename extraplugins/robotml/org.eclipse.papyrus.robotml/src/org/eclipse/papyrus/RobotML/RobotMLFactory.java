/**
 */
package org.eclipse.papyrus.RobotML;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.RobotML.RobotMLPackage
 * @generated
 */
public interface RobotMLFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RobotMLFactory eINSTANCE = org.eclipse.papyrus.RobotML.impl.RobotMLFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Transition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Transition</em>'.
	 * @generated
	 */
	Transition createTransition();

	/**
	 * Returns a new object of class '<em>Algorithm</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Algorithm</em>'.
	 * @generated
	 */
	Algorithm createAlgorithm();

	/**
	 * Returns a new object of class '<em>State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>State</em>'.
	 * @generated
	 */
	State createState();

	/**
	 * Returns a new object of class '<em>Robot</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Robot</em>'.
	 * @generated
	 */
	Robot createRobot();

	/**
	 * Returns a new object of class '<em>System</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>System</em>'.
	 * @generated
	 */
	System createSystem();

	/**
	 * Returns a new object of class '<em>Agent</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Agent</em>'.
	 * @generated
	 */
	Agent createAgent();

	/**
	 * Returns a new object of class '<em>Physical Object</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Physical Object</em>'.
	 * @generated
	 */
	PhysicalObject createPhysicalObject();

	/**
	 * Returns a new object of class '<em>Environment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Environment</em>'.
	 * @generated
	 */
	Environment createEnvironment();

	/**
	 * Returns a new object of class '<em>Surface</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Surface</em>'.
	 * @generated
	 */
	Surface createSurface();

	/**
	 * Returns a new object of class '<em>Data Flow Port</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Flow Port</em>'.
	 * @generated
	 */
	DataFlowPort createDataFlowPort();

	/**
	 * Returns a new object of class '<em>Service Port</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Service Port</em>'.
	 * @generated
	 */
	ServicePort createServicePort();

	/**
	 * Returns a new object of class '<em>Actuator System</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Actuator System</em>'.
	 * @generated
	 */
	ActuatorSystem createActuatorSystem();

	/**
	 * Returns a new object of class '<em>Robotic System</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Robotic System</em>'.
	 * @generated
	 */
	RoboticSystem createRoboticSystem();

	/**
	 * Returns a new object of class '<em>Sensor System</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sensor System</em>'.
	 * @generated
	 */
	SensorSystem createSensorSystem();

	/**
	 * Returns a new object of class '<em>Hardware</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Hardware</em>'.
	 * @generated
	 */
	Hardware createHardware();

	/**
	 * Returns a new object of class '<em>Software</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Software</em>'.
	 * @generated
	 */
	Software createSoftware();

	/**
	 * Returns a new object of class '<em>Primitive Data</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Primitive Data</em>'.
	 * @generated
	 */
	PrimitiveData createPrimitiveData();

	/**
	 * Returns a new object of class '<em>Data Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Type</em>'.
	 * @generated
	 */
	DataType createDataType();

	/**
	 * Returns a new object of class '<em>Engine System</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Engine System</em>'.
	 * @generated
	 */
	EngineSystem createEngineSystem();

	/**
	 * Returns a new object of class '<em>Wheel System</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Wheel System</em>'.
	 * @generated
	 */
	WheelSystem createWheelSystem();

	/**
	 * Returns a new object of class '<em>Image Sensor System</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Image Sensor System</em>'.
	 * @generated
	 */
	ImageSensorSystem createImageSensorSystem();

	/**
	 * Returns a new object of class '<em>Camera System</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Camera System</em>'.
	 * @generated
	 */
	CameraSystem createCameraSystem();

	/**
	 * Returns a new object of class '<em>Object Detection Sensor System</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Object Detection Sensor System</em>'.
	 * @generated
	 */
	ObjectDetectionSensorSystem createObjectDetectionSensorSystem();

	/**
	 * Returns a new object of class '<em>Object Tracking Sensor System</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Object Tracking Sensor System</em>'.
	 * @generated
	 */
	ObjectTrackingSensorSystem createObjectTrackingSensorSystem();

	/**
	 * Returns a new object of class '<em>Lidar System</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Lidar System</em>'.
	 * @generated
	 */
	LidarSystem createLidarSystem();

	/**
	 * Returns a new object of class '<em>Localization Sensor System</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Localization Sensor System</em>'.
	 * @generated
	 */
	LocalizationSensorSystem createLocalizationSensorSystem();

	/**
	 * Returns a new object of class '<em>GPS System</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>GPS System</em>'.
	 * @generated
	 */
	GPSSystem createGPSSystem();

	/**
	 * Returns a new object of class '<em>Simulated System</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Simulated System</em>'.
	 * @generated
	 */
	SimulatedSystem createSimulatedSystem();

	/**
	 * Returns a new object of class '<em>Algorithm Library</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Algorithm Library</em>'.
	 * @generated
	 */
	AlgorithmLibrary createAlgorithmLibrary();

	/**
	 * Returns a new object of class '<em>Sensor Driver</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sensor Driver</em>'.
	 * @generated
	 */
	SensorDriver createSensorDriver();

	/**
	 * Returns a new object of class '<em>Building</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Building</em>'.
	 * @generated
	 */
	Building createBuilding();

	/**
	 * Returns a new object of class '<em>Planet</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Planet</em>'.
	 * @generated
	 */
	Planet createPlanet();

	/**
	 * Returns a new object of class '<em>Land Surface</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Land Surface</em>'.
	 * @generated
	 */
	LandSurface createLandSurface();

	/**
	 * Returns a new object of class '<em>Floor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Floor</em>'.
	 * @generated
	 */
	Floor createFloor();

	/**
	 * Returns a new object of class '<em>Water Surface</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Water Surface</em>'.
	 * @generated
	 */
	WaterSurface createWaterSurface();

	/**
	 * Returns a new object of class '<em>Human</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Human</em>'.
	 * @generated
	 */
	Human createHuman();

	/**
	 * Returns a new object of class '<em>Pedestrian</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pedestrian</em>'.
	 * @generated
	 */
	Pedestrian createPedestrian();

	/**
	 * Returns a new object of class '<em>Stairs</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Stairs</em>'.
	 * @generated
	 */
	Stairs createStairs();

	/**
	 * Returns a new object of class '<em>Platform</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Platform</em>'.
	 * @generated
	 */
	Platform createPlatform();

	/**
	 * Returns a new object of class '<em>External Library</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>External Library</em>'.
	 * @generated
	 */
	ExternalLibrary createExternalLibrary();

	/**
	 * Returns a new object of class '<em>Robotic Middleware</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Robotic Middleware</em>'.
	 * @generated
	 */
	RoboticMiddleware createRoboticMiddleware();

	/**
	 * Returns a new object of class '<em>Robotic Simulator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Robotic Simulator</em>'.
	 * @generated
	 */
	RoboticSimulator createRoboticSimulator();

	/**
	 * Returns a new object of class '<em>Cycab TK</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cycab TK</em>'.
	 * @generated
	 */
	CycabTK createCycabTK();

	/**
	 * Returns a new object of class '<em>Blender Morse</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Blender Morse</em>'.
	 * @generated
	 */
	BlenderMorse createBlenderMorse();

	/**
	 * Returns a new object of class '<em>On Port</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>On Port</em>'.
	 * @generated
	 */
	OnPort createOnPort();

	/**
	 * Returns a new object of class '<em>Allocate</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Allocate</em>'.
	 * @generated
	 */
	Allocate createAllocate();

	/**
	 * Returns a new object of class '<em>Inertial Measurement Unit System</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Inertial Measurement Unit System</em>'.
	 * @generated
	 */
	InertialMeasurementUnitSystem createInertialMeasurementUnitSystem();

	/**
	 * Returns a new object of class '<em>Inertial Navigation System</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Inertial Navigation System</em>'.
	 * @generated
	 */
	InertialNavigationSystem createInertialNavigationSystem();

	/**
	 * Returns a new object of class '<em>Odometry System</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Odometry System</em>'.
	 * @generated
	 */
	OdometrySystem createOdometrySystem();

	/**
	 * Returns a new object of class '<em>Infra Red Proximetry System</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Infra Red Proximetry System</em>'.
	 * @generated
	 */
	InfraRedProximetrySystem createInfraRedProximetrySystem();

	/**
	 * Returns a new object of class '<em>Deployment Plan</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Deployment Plan</em>'.
	 * @generated
	 */
	DeploymentPlan createDeploymentPlan();

	/**
	 * Returns a new object of class '<em>Gyroscope</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Gyroscope</em>'.
	 * @generated
	 */
	Gyroscope createGyroscope();

	/**
	 * Returns a new object of class '<em>On Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>On Property</em>'.
	 * @generated
	 */
	OnProperty createOnProperty();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	RobotMLPackage getRobotMLPackage();

} //RobotMLFactory
