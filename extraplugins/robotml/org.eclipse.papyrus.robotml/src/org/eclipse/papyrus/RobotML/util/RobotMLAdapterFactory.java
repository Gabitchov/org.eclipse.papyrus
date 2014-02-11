/**
 */
package org.eclipse.papyrus.RobotML.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

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
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.RobotML.RobotMLPackage
 * @generated
 */
public class RobotMLAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static RobotMLPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RobotMLAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = RobotMLPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RobotMLSwitch<Adapter> modelSwitch =
		new RobotMLSwitch<Adapter>() {
			@Override
			public Adapter caseTransition(Transition object) {
				return createTransitionAdapter();
			}
			@Override
			public Adapter caseAlgorithm(Algorithm object) {
				return createAlgorithmAdapter();
			}
			@Override
			public Adapter caseState(State object) {
				return createStateAdapter();
			}
			@Override
			public Adapter caseActuatedJoint(ActuatedJoint object) {
				return createActuatedJointAdapter();
			}
			@Override
			public Adapter caseJoint(Joint object) {
				return createJointAdapter();
			}
			@Override
			public Adapter caseCompleteBonding(CompleteBonding object) {
				return createCompleteBondingAdapter();
			}
			@Override
			public Adapter caseRobot(Robot object) {
				return createRobotAdapter();
			}
			@Override
			public Adapter caseSystem(org.eclipse.papyrus.RobotML.System object) {
				return createSystemAdapter();
			}
			@Override
			public Adapter caseAgent(Agent object) {
				return createAgentAdapter();
			}
			@Override
			public Adapter casePhysicalObject(PhysicalObject object) {
				return createPhysicalObjectAdapter();
			}
			@Override
			public Adapter caseEnvironment(Environment object) {
				return createEnvironmentAdapter();
			}
			@Override
			public Adapter caseSurface(Surface object) {
				return createSurfaceAdapter();
			}
			@Override
			public Adapter caseDataFlowPort(DataFlowPort object) {
				return createDataFlowPortAdapter();
			}
			@Override
			public Adapter casePort(Port object) {
				return createPortAdapter();
			}
			@Override
			public Adapter caseServicePort(ServicePort object) {
				return createServicePortAdapter();
			}
			@Override
			public Adapter caseActuatorSystem(ActuatorSystem object) {
				return createActuatorSystemAdapter();
			}
			@Override
			public Adapter caseRoboticSystem(RoboticSystem object) {
				return createRoboticSystemAdapter();
			}
			@Override
			public Adapter caseCyberPhysicalSystem(CyberPhysicalSystem object) {
				return createCyberPhysicalSystemAdapter();
			}
			@Override
			public Adapter caseSensorSystem(SensorSystem object) {
				return createSensorSystemAdapter();
			}
			@Override
			public Adapter caseHardware(Hardware object) {
				return createHardwareAdapter();
			}
			@Override
			public Adapter caseSoftware(Software object) {
				return createSoftwareAdapter();
			}
			@Override
			public Adapter caseEngineSystem(EngineSystem object) {
				return createEngineSystemAdapter();
			}
			@Override
			public Adapter caseSteeredWheelSystem(SteeredWheelSystem object) {
				return createSteeredWheelSystemAdapter();
			}
			@Override
			public Adapter caseLocomotionSystem(LocomotionSystem object) {
				return createLocomotionSystemAdapter();
			}
			@Override
			public Adapter caseImageSensorSystem(ImageSensorSystem object) {
				return createImageSensorSystemAdapter();
			}
			@Override
			public Adapter caseCameraSystem(CameraSystem object) {
				return createCameraSystemAdapter();
			}
			@Override
			public Adapter caseObjectDetectionSensorSystem(ObjectDetectionSensorSystem object) {
				return createObjectDetectionSensorSystemAdapter();
			}
			@Override
			public Adapter caseObjectTrackingSensorSystem(ObjectTrackingSensorSystem object) {
				return createObjectTrackingSensorSystemAdapter();
			}
			@Override
			public Adapter caseLidarSystem(LidarSystem object) {
				return createLidarSystemAdapter();
			}
			@Override
			public Adapter caseLocalizationSensorSystem(LocalizationSensorSystem object) {
				return createLocalizationSensorSystemAdapter();
			}
			@Override
			public Adapter caseGPSSystem(GPSSystem object) {
				return createGPSSystemAdapter();
			}
			@Override
			public Adapter caseAlgorithmLibrary(AlgorithmLibrary object) {
				return createAlgorithmLibraryAdapter();
			}
			@Override
			public Adapter caseSensorDriver(SensorDriver object) {
				return createSensorDriverAdapter();
			}
			@Override
			public Adapter caseBuilding(Building object) {
				return createBuildingAdapter();
			}
			@Override
			public Adapter casePlanet(Planet object) {
				return createPlanetAdapter();
			}
			@Override
			public Adapter caseLandSurface(LandSurface object) {
				return createLandSurfaceAdapter();
			}
			@Override
			public Adapter caseGround(Ground object) {
				return createGroundAdapter();
			}
			@Override
			public Adapter caseFloor(Floor object) {
				return createFloorAdapter();
			}
			@Override
			public Adapter caseWaterSurface(WaterSurface object) {
				return createWaterSurfaceAdapter();
			}
			@Override
			public Adapter caseHuman(Human object) {
				return createHumanAdapter();
			}
			@Override
			public Adapter casePedestrian(Pedestrian object) {
				return createPedestrianAdapter();
			}
			@Override
			public Adapter caseStairs(Stairs object) {
				return createStairsAdapter();
			}
			@Override
			public Adapter casePlatform(Platform object) {
				return createPlatformAdapter();
			}
			@Override
			public Adapter caseExternalLibrary(ExternalLibrary object) {
				return createExternalLibraryAdapter();
			}
			@Override
			public Adapter caseRoboticMiddleware(RoboticMiddleware object) {
				return createRoboticMiddlewareAdapter();
			}
			@Override
			public Adapter caseRoboticSimulator(RoboticSimulator object) {
				return createRoboticSimulatorAdapter();
			}
			@Override
			public Adapter caseCycabTK(CycabTK object) {
				return createCycabTKAdapter();
			}
			@Override
			public Adapter caseBlenderMorse(BlenderMorse object) {
				return createBlenderMorseAdapter();
			}
			@Override
			public Adapter caseOnPort(OnPort object) {
				return createOnPortAdapter();
			}
			@Override
			public Adapter caseAllocate(Allocate object) {
				return createAllocateAdapter();
			}
			@Override
			public Adapter caseInertialMeasurementUnitSystem(InertialMeasurementUnitSystem object) {
				return createInertialMeasurementUnitSystemAdapter();
			}
			@Override
			public Adapter caseInertialNavigationSystem(InertialNavigationSystem object) {
				return createInertialNavigationSystemAdapter();
			}
			@Override
			public Adapter caseOdometrySystem(OdometrySystem object) {
				return createOdometrySystemAdapter();
			}
			@Override
			public Adapter caseInfraRedProximetrySystem(InfraRedProximetrySystem object) {
				return createInfraRedProximetrySystemAdapter();
			}
			@Override
			public Adapter caseDeploymentPlan(DeploymentPlan object) {
				return createDeploymentPlanAdapter();
			}
			@Override
			public Adapter caseGyroscope(Gyroscope object) {
				return createGyroscopeAdapter();
			}
			@Override
			public Adapter caseOnProperty(OnProperty object) {
				return createOnPropertyAdapter();
			}
			@Override
			public Adapter caseChassis(Chassis object) {
				return createChassisAdapter();
			}
			@Override
			public Adapter caseSupportingStructure(SupportingStructure object) {
				return createSupportingStructureAdapter();
			}
			@Override
			public Adapter caseMechanicalLinkage(MechanicalLinkage object) {
				return createMechanicalLinkageAdapter();
			}
			@Override
			public Adapter caseLeg(Leg object) {
				return createLegAdapter();
			}
			@Override
			public Adapter caseLocomotionHardware(LocomotionHardware object) {
				return createLocomotionHardwareAdapter();
			}
			@Override
			public Adapter caseActuatorHardware(ActuatorHardware object) {
				return createActuatorHardwareAdapter();
			}
			@Override
			public Adapter caseMobileRobot(MobileRobot object) {
				return createMobileRobotAdapter();
			}
			@Override
			public Adapter caseManipulator(Manipulator object) {
				return createManipulatorAdapter();
			}
			@Override
			public Adapter casePilotedSystem(PilotedSystem object) {
				return createPilotedSystemAdapter();
			}
			@Override
			public Adapter casePowerHardware(PowerHardware object) {
				return createPowerHardwareAdapter();
			}
			@Override
			public Adapter caseSensorHardware(SensorHardware object) {
				return createSensorHardwareAdapter();
			}
			@Override
			public Adapter caseGraspingHardware(GraspingHardware object) {
				return createGraspingHardwareAdapter();
			}
			@Override
			public Adapter caseSteeredWheelHardware(SteeredWheelHardware object) {
				return createSteeredWheelHardwareAdapter();
			}
			@Override
			public Adapter caseArm(Arm object) {
				return createArmAdapter();
			}
			@Override
			public Adapter caseLegSystem(LegSystem object) {
				return createLegSystemAdapter();
			}
			@Override
			public Adapter caseGraspingSystem(GraspingSystem object) {
				return createGraspingSystemAdapter();
			}
			@Override
			public Adapter caseWeaponSystem(WeaponSystem object) {
				return createWeaponSystemAdapter();
			}
			@Override
			public Adapter caseManMachineInterfaceSystem(ManMachineInterfaceSystem object) {
				return createManMachineInterfaceSystemAdapter();
			}
			@Override
			public Adapter caseClosedLoopControlSystem(ClosedLoopControlSystem object) {
				return createClosedLoopControlSystemAdapter();
			}
			@Override
			public Adapter caseOpenLoopControlSystem(OpenLoopControlSystem object) {
				return createOpenLoopControlSystemAdapter();
			}
			@Override
			public Adapter caseRoboticHead(RoboticHead object) {
				return createRoboticHeadAdapter();
			}
			@Override
			public Adapter caseNavigationCommandSystem(NavigationCommandSystem object) {
				return createNavigationCommandSystemAdapter();
			}
			@Override
			public Adapter caseJoysticNavigationSystem(JoysticNavigationSystem object) {
				return createJoysticNavigationSystemAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.RobotML.Transition <em>Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotML.Transition
	 * @generated
	 */
	public Adapter createTransitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.RobotML.Algorithm <em>Algorithm</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotML.Algorithm
	 * @generated
	 */
	public Adapter createAlgorithmAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.RobotML.State <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotML.State
	 * @generated
	 */
	public Adapter createStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.RobotML.ActuatedJoint <em>Actuated Joint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotML.ActuatedJoint
	 * @generated
	 */
	public Adapter createActuatedJointAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.RobotML.Joint <em>Joint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotML.Joint
	 * @generated
	 */
	public Adapter createJointAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.RobotML.CompleteBonding <em>Complete Bonding</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotML.CompleteBonding
	 * @generated
	 */
	public Adapter createCompleteBondingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.RobotML.Robot <em>Robot</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotML.Robot
	 * @generated
	 */
	public Adapter createRobotAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.RobotML.System <em>System</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotML.System
	 * @generated
	 */
	public Adapter createSystemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.RobotML.Agent <em>Agent</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotML.Agent
	 * @generated
	 */
	public Adapter createAgentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.RobotML.PhysicalObject <em>Physical Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotML.PhysicalObject
	 * @generated
	 */
	public Adapter createPhysicalObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.RobotML.Environment <em>Environment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotML.Environment
	 * @generated
	 */
	public Adapter createEnvironmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.RobotML.Surface <em>Surface</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotML.Surface
	 * @generated
	 */
	public Adapter createSurfaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.RobotML.DataFlowPort <em>Data Flow Port</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotML.DataFlowPort
	 * @generated
	 */
	public Adapter createDataFlowPortAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.RobotML.Port <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotML.Port
	 * @generated
	 */
	public Adapter createPortAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.RobotML.ServicePort <em>Service Port</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotML.ServicePort
	 * @generated
	 */
	public Adapter createServicePortAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.RobotML.ActuatorSystem <em>Actuator System</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotML.ActuatorSystem
	 * @generated
	 */
	public Adapter createActuatorSystemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.RobotML.RoboticSystem <em>Robotic System</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotML.RoboticSystem
	 * @generated
	 */
	public Adapter createRoboticSystemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.RobotML.CyberPhysicalSystem <em>Cyber Physical System</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotML.CyberPhysicalSystem
	 * @generated
	 */
	public Adapter createCyberPhysicalSystemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.RobotML.SensorSystem <em>Sensor System</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotML.SensorSystem
	 * @generated
	 */
	public Adapter createSensorSystemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.RobotML.Hardware <em>Hardware</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotML.Hardware
	 * @generated
	 */
	public Adapter createHardwareAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.RobotML.Software <em>Software</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotML.Software
	 * @generated
	 */
	public Adapter createSoftwareAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.RobotML.EngineSystem <em>Engine System</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotML.EngineSystem
	 * @generated
	 */
	public Adapter createEngineSystemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem <em>Steered Wheel System</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotML.SteeredWheelSystem
	 * @generated
	 */
	public Adapter createSteeredWheelSystemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.RobotML.LocomotionSystem <em>Locomotion System</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotML.LocomotionSystem
	 * @generated
	 */
	public Adapter createLocomotionSystemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.RobotML.ImageSensorSystem <em>Image Sensor System</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotML.ImageSensorSystem
	 * @generated
	 */
	public Adapter createImageSensorSystemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.RobotML.CameraSystem <em>Camera System</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotML.CameraSystem
	 * @generated
	 */
	public Adapter createCameraSystemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.RobotML.ObjectDetectionSensorSystem <em>Object Detection Sensor System</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotML.ObjectDetectionSensorSystem
	 * @generated
	 */
	public Adapter createObjectDetectionSensorSystemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.RobotML.ObjectTrackingSensorSystem <em>Object Tracking Sensor System</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotML.ObjectTrackingSensorSystem
	 * @generated
	 */
	public Adapter createObjectTrackingSensorSystemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.RobotML.LidarSystem <em>Lidar System</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotML.LidarSystem
	 * @generated
	 */
	public Adapter createLidarSystemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.RobotML.LocalizationSensorSystem <em>Localization Sensor System</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotML.LocalizationSensorSystem
	 * @generated
	 */
	public Adapter createLocalizationSensorSystemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.RobotML.GPSSystem <em>GPS System</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotML.GPSSystem
	 * @generated
	 */
	public Adapter createGPSSystemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.RobotML.AlgorithmLibrary <em>Algorithm Library</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotML.AlgorithmLibrary
	 * @generated
	 */
	public Adapter createAlgorithmLibraryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.RobotML.SensorDriver <em>Sensor Driver</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotML.SensorDriver
	 * @generated
	 */
	public Adapter createSensorDriverAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.RobotML.Building <em>Building</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotML.Building
	 * @generated
	 */
	public Adapter createBuildingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.RobotML.Planet <em>Planet</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotML.Planet
	 * @generated
	 */
	public Adapter createPlanetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.RobotML.LandSurface <em>Land Surface</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotML.LandSurface
	 * @generated
	 */
	public Adapter createLandSurfaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.RobotML.Ground <em>Ground</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotML.Ground
	 * @generated
	 */
	public Adapter createGroundAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.RobotML.Floor <em>Floor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotML.Floor
	 * @generated
	 */
	public Adapter createFloorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.RobotML.WaterSurface <em>Water Surface</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotML.WaterSurface
	 * @generated
	 */
	public Adapter createWaterSurfaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.RobotML.Human <em>Human</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotML.Human
	 * @generated
	 */
	public Adapter createHumanAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.RobotML.Pedestrian <em>Pedestrian</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotML.Pedestrian
	 * @generated
	 */
	public Adapter createPedestrianAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.RobotML.Stairs <em>Stairs</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotML.Stairs
	 * @generated
	 */
	public Adapter createStairsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.RobotML.Platform <em>Platform</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotML.Platform
	 * @generated
	 */
	public Adapter createPlatformAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.RobotML.ExternalLibrary <em>External Library</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotML.ExternalLibrary
	 * @generated
	 */
	public Adapter createExternalLibraryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.RobotML.RoboticMiddleware <em>Robotic Middleware</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotML.RoboticMiddleware
	 * @generated
	 */
	public Adapter createRoboticMiddlewareAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.RobotML.RoboticSimulator <em>Robotic Simulator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotML.RoboticSimulator
	 * @generated
	 */
	public Adapter createRoboticSimulatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.RobotML.CycabTK <em>Cycab TK</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotML.CycabTK
	 * @generated
	 */
	public Adapter createCycabTKAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.RobotML.BlenderMorse <em>Blender Morse</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotML.BlenderMorse
	 * @generated
	 */
	public Adapter createBlenderMorseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.RobotML.OnPort <em>On Port</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotML.OnPort
	 * @generated
	 */
	public Adapter createOnPortAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.RobotML.Allocate <em>Allocate</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotML.Allocate
	 * @generated
	 */
	public Adapter createAllocateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.RobotML.InertialMeasurementUnitSystem <em>Inertial Measurement Unit System</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotML.InertialMeasurementUnitSystem
	 * @generated
	 */
	public Adapter createInertialMeasurementUnitSystemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.RobotML.InertialNavigationSystem <em>Inertial Navigation System</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotML.InertialNavigationSystem
	 * @generated
	 */
	public Adapter createInertialNavigationSystemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.RobotML.OdometrySystem <em>Odometry System</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotML.OdometrySystem
	 * @generated
	 */
	public Adapter createOdometrySystemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.RobotML.InfraRedProximetrySystem <em>Infra Red Proximetry System</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotML.InfraRedProximetrySystem
	 * @generated
	 */
	public Adapter createInfraRedProximetrySystemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.RobotML.DeploymentPlan <em>Deployment Plan</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotML.DeploymentPlan
	 * @generated
	 */
	public Adapter createDeploymentPlanAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.RobotML.Gyroscope <em>Gyroscope</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotML.Gyroscope
	 * @generated
	 */
	public Adapter createGyroscopeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.RobotML.OnProperty <em>On Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotML.OnProperty
	 * @generated
	 */
	public Adapter createOnPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.RobotML.Chassis <em>Chassis</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotML.Chassis
	 * @generated
	 */
	public Adapter createChassisAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.RobotML.SupportingStructure <em>Supporting Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotML.SupportingStructure
	 * @generated
	 */
	public Adapter createSupportingStructureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.RobotML.MechanicalLinkage <em>Mechanical Linkage</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotML.MechanicalLinkage
	 * @generated
	 */
	public Adapter createMechanicalLinkageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.RobotML.Leg <em>Leg</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotML.Leg
	 * @generated
	 */
	public Adapter createLegAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.RobotML.LocomotionHardware <em>Locomotion Hardware</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotML.LocomotionHardware
	 * @generated
	 */
	public Adapter createLocomotionHardwareAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.RobotML.ActuatorHardware <em>Actuator Hardware</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotML.ActuatorHardware
	 * @generated
	 */
	public Adapter createActuatorHardwareAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.RobotML.MobileRobot <em>Mobile Robot</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotML.MobileRobot
	 * @generated
	 */
	public Adapter createMobileRobotAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.RobotML.Manipulator <em>Manipulator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotML.Manipulator
	 * @generated
	 */
	public Adapter createManipulatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.RobotML.PilotedSystem <em>Piloted System</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotML.PilotedSystem
	 * @generated
	 */
	public Adapter createPilotedSystemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.RobotML.PowerHardware <em>Power Hardware</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotML.PowerHardware
	 * @generated
	 */
	public Adapter createPowerHardwareAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.RobotML.SensorHardware <em>Sensor Hardware</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotML.SensorHardware
	 * @generated
	 */
	public Adapter createSensorHardwareAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.RobotML.GraspingHardware <em>Grasping Hardware</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotML.GraspingHardware
	 * @generated
	 */
	public Adapter createGraspingHardwareAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.RobotML.SteeredWheelHardware <em>Steered Wheel Hardware</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotML.SteeredWheelHardware
	 * @generated
	 */
	public Adapter createSteeredWheelHardwareAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.RobotML.Arm <em>Arm</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotML.Arm
	 * @generated
	 */
	public Adapter createArmAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.RobotML.LegSystem <em>Leg System</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotML.LegSystem
	 * @generated
	 */
	public Adapter createLegSystemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.RobotML.GraspingSystem <em>Grasping System</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotML.GraspingSystem
	 * @generated
	 */
	public Adapter createGraspingSystemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.RobotML.WeaponSystem <em>Weapon System</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotML.WeaponSystem
	 * @generated
	 */
	public Adapter createWeaponSystemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.RobotML.ManMachineInterfaceSystem <em>Man Machine Interface System</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotML.ManMachineInterfaceSystem
	 * @generated
	 */
	public Adapter createManMachineInterfaceSystemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.RobotML.ClosedLoopControlSystem <em>Closed Loop Control System</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotML.ClosedLoopControlSystem
	 * @generated
	 */
	public Adapter createClosedLoopControlSystemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.RobotML.OpenLoopControlSystem <em>Open Loop Control System</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotML.OpenLoopControlSystem
	 * @generated
	 */
	public Adapter createOpenLoopControlSystemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.RobotML.RoboticHead <em>Robotic Head</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotML.RoboticHead
	 * @generated
	 */
	public Adapter createRoboticHeadAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.RobotML.NavigationCommandSystem <em>Navigation Command System</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotML.NavigationCommandSystem
	 * @generated
	 */
	public Adapter createNavigationCommandSystemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.RobotML.JoysticNavigationSystem <em>Joystic Navigation System</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.RobotML.JoysticNavigationSystem
	 * @generated
	 */
	public Adapter createJoysticNavigationSystemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //RobotMLAdapterFactory
