/**
 */
package org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Oarp4_datatypesFactoryImpl extends EFactoryImpl implements Oarp4_datatypesFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Oarp4_datatypesFactory init() {
		try {
			Oarp4_datatypesFactory theOarp4_datatypesFactory = (Oarp4_datatypesFactory)EPackage.Registry.INSTANCE.getEFactory(Oarp4_datatypesPackage.eNS_URI);
			if (theOarp4_datatypesFactory != null) {
				return theOarp4_datatypesFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Oarp4_datatypesFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Oarp4_datatypesFactoryImpl() {
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
			case Oarp4_datatypesPackage.VELOCITY_LINEAR: return createVelocity_Linear();
			case Oarp4_datatypesPackage.ART_SET_POINT: return createArt_Set_Point();
			case Oarp4_datatypesPackage.VELOCITY_ANGULAR: return createVelocity_Angular();
			case Oarp4_datatypesPackage.DISTANCE: return createDistance();
			case Oarp4_datatypesPackage.METRIC: return createMetric();
			case Oarp4_datatypesPackage.ANGULAR: return createAngular();
			case Oarp4_datatypesPackage.OP_SET_POINT: return createOp_Set_Point();
			case Oarp4_datatypesPackage.SPEED_TICS_LEFT_RIGHT: return createSpeed_Tics_Left_Right();
			case Oarp4_datatypesPackage.SPEED_TICS: return createSpeed_Tics();
			case Oarp4_datatypesPackage.ODOMETER_TICS: return createOdometer_Tics();
			case Oarp4_datatypesPackage.ODOMETER_TICS_LEFT_RIGHT: return createOdometer_Tics_Left_Right();
			case Oarp4_datatypesPackage.PROXI_LEFT_RIGHT: return createProxi_Left_Right();
			case Oarp4_datatypesPackage.MILLI_AMP: return createMilli_Amp();
			case Oarp4_datatypesPackage.ODOMETER_LINEAR_LEFT_RIGHT: return createOdometer_Linear_Left_Right();
			case Oarp4_datatypesPackage.VELOCITY_ANGULAR_LEFT_RIGHT: return createVelocity_Angular_Left_Right();
			case Oarp4_datatypesPackage.VELOCITY: return createVelocity();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Velocity_Linear createVelocity_Linear() {
		Velocity_LinearImpl velocity_Linear = new Velocity_LinearImpl();
		return velocity_Linear;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Art_Set_Point createArt_Set_Point() {
		Art_Set_PointImpl art_Set_Point = new Art_Set_PointImpl();
		return art_Set_Point;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Velocity_Angular createVelocity_Angular() {
		Velocity_AngularImpl velocity_Angular = new Velocity_AngularImpl();
		return velocity_Angular;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Distance createDistance() {
		DistanceImpl distance = new DistanceImpl();
		return distance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Metric createMetric() {
		MetricImpl metric = new MetricImpl();
		return metric;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Angular createAngular() {
		AngularImpl angular = new AngularImpl();
		return angular;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Op_Set_Point createOp_Set_Point() {
		Op_Set_PointImpl op_Set_Point = new Op_Set_PointImpl();
		return op_Set_Point;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Speed_Tics_Left_Right createSpeed_Tics_Left_Right() {
		Speed_Tics_Left_RightImpl speed_Tics_Left_Right = new Speed_Tics_Left_RightImpl();
		return speed_Tics_Left_Right;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Speed_Tics createSpeed_Tics() {
		Speed_TicsImpl speed_Tics = new Speed_TicsImpl();
		return speed_Tics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Odometer_Tics createOdometer_Tics() {
		Odometer_TicsImpl odometer_Tics = new Odometer_TicsImpl();
		return odometer_Tics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Odometer_Tics_Left_Right createOdometer_Tics_Left_Right() {
		Odometer_Tics_Left_RightImpl odometer_Tics_Left_Right = new Odometer_Tics_Left_RightImpl();
		return odometer_Tics_Left_Right;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Proxi_Left_Right createProxi_Left_Right() {
		Proxi_Left_RightImpl proxi_Left_Right = new Proxi_Left_RightImpl();
		return proxi_Left_Right;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Milli_Amp createMilli_Amp() {
		Milli_AmpImpl milli_Amp = new Milli_AmpImpl();
		return milli_Amp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Odometer_Linear_Left_Right createOdometer_Linear_Left_Right() {
		Odometer_Linear_Left_RightImpl odometer_Linear_Left_Right = new Odometer_Linear_Left_RightImpl();
		return odometer_Linear_Left_Right;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Velocity_Angular_Left_Right createVelocity_Angular_Left_Right() {
		Velocity_Angular_Left_RightImpl velocity_Angular_Left_Right = new Velocity_Angular_Left_RightImpl();
		return velocity_Angular_Left_Right;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Velocity createVelocity() {
		VelocityImpl velocity = new VelocityImpl();
		return velocity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Oarp4_datatypesPackage getOarp4_datatypesPackage() {
		return (Oarp4_datatypesPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static Oarp4_datatypesPackage getPackage() {
		return Oarp4_datatypesPackage.eINSTANCE;
	}

} //Oarp4_datatypesFactoryImpl
