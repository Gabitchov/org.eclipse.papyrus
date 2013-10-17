/**
 */
package org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.papyrus.RobotML.RobotMLPackage;

import org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl;

import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.Actionlib_datatypesPackage;

import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.impl.Actionlib_datatypesPackageImpl;

import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.diagnostic_datatypes.Diagnostic_datatypesPackage;

import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.diagnostic_datatypes.impl.Diagnostic_datatypesPackageImpl;

import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.Geometry_datatypesFactory;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.Geometry_datatypesPackage;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.Point;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.Point32;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.PointStamped;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.Polygon;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.PolygonStamped;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.Pose;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.Pose2D;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.PoseArray;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.PoseStamped;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.PoseWithCovariance;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.PoseWithCovarianceStamped;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.Quaternion;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.QuaternionStamped;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.Transform;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.Twist;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.TwistStamped;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.TwistWithCovariance;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.Vector3;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.Vector3Stamped;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.Wrench;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.WrenchStamped;

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

import org.eclipse.uml2.uml.UMLPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Geometry_datatypesPackageImpl extends EPackageImpl implements Geometry_datatypesPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass point32EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pointStampedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass polygonEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass polygonStampedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vector3EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vector3StampedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass quaternionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass poseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass poseStampedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass twistWithCovarianceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass twistEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass twistStampedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass poseWithCovarianceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pose2DEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass poseWithCovarianceStampedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass poseArrayEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass quaternionStampedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass transformEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wrenchStampedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wrenchEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.Geometry_datatypesPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private Geometry_datatypesPackageImpl() {
		super(eNS_URI, Geometry_datatypesFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link Geometry_datatypesPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static Geometry_datatypesPackage init() {
		if (isInited) return (Geometry_datatypesPackage)EPackage.Registry.INSTANCE.getEPackage(Geometry_datatypesPackage.eNS_URI);

		// Obtain or create and register package
		Geometry_datatypesPackageImpl theGeometry_datatypesPackage = (Geometry_datatypesPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof Geometry_datatypesPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new Geometry_datatypesPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		UMLPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		RobotMLPackageImpl theRobotMLPackage = (RobotMLPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(RobotMLPackage.eNS_URI) instanceof RobotMLPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(RobotMLPackage.eNS_URI) : RobotMLPackage.eINSTANCE);
		Diagnostic_datatypesPackageImpl theDiagnostic_datatypesPackage = (Diagnostic_datatypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Diagnostic_datatypesPackage.eNS_URI) instanceof Diagnostic_datatypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Diagnostic_datatypesPackage.eNS_URI) : Diagnostic_datatypesPackage.eINSTANCE);
		Nav_datatypesPackageImpl theNav_datatypesPackage = (Nav_datatypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Nav_datatypesPackage.eNS_URI) instanceof Nav_datatypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Nav_datatypesPackage.eNS_URI) : Nav_datatypesPackage.eINSTANCE);
		Sensor_datatypesPackageImpl theSensor_datatypesPackage = (Sensor_datatypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Sensor_datatypesPackage.eNS_URI) instanceof Sensor_datatypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Sensor_datatypesPackage.eNS_URI) : Sensor_datatypesPackage.eINSTANCE);
		Actionlib_datatypesPackageImpl theActionlib_datatypesPackage = (Actionlib_datatypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Actionlib_datatypesPackage.eNS_URI) instanceof Actionlib_datatypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Actionlib_datatypesPackage.eNS_URI) : Actionlib_datatypesPackage.eINSTANCE);
		Oarp1_datatypesPackageImpl theOarp1_datatypesPackage = (Oarp1_datatypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Oarp1_datatypesPackage.eNS_URI) instanceof Oarp1_datatypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Oarp1_datatypesPackage.eNS_URI) : Oarp1_datatypesPackage.eINSTANCE);
		Oarp4_datatypesPackageImpl theOarp4_datatypesPackage = (Oarp4_datatypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Oarp4_datatypesPackage.eNS_URI) instanceof Oarp4_datatypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Oarp4_datatypesPackage.eNS_URI) : Oarp4_datatypesPackage.eINSTANCE);
		Std_datatypesPackageImpl theStd_datatypesPackage = (Std_datatypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Std_datatypesPackage.eNS_URI) instanceof Std_datatypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Std_datatypesPackage.eNS_URI) : Std_datatypesPackage.eINSTANCE);

		// Create package meta-data objects
		theGeometry_datatypesPackage.createPackageContents();
		theRobotMLPackage.createPackageContents();
		theDiagnostic_datatypesPackage.createPackageContents();
		theNav_datatypesPackage.createPackageContents();
		theSensor_datatypesPackage.createPackageContents();
		theActionlib_datatypesPackage.createPackageContents();
		theOarp1_datatypesPackage.createPackageContents();
		theOarp4_datatypesPackage.createPackageContents();
		theStd_datatypesPackage.createPackageContents();

		// Initialize created meta-data
		theGeometry_datatypesPackage.initializePackageContents();
		theRobotMLPackage.initializePackageContents();
		theDiagnostic_datatypesPackage.initializePackageContents();
		theNav_datatypesPackage.initializePackageContents();
		theSensor_datatypesPackage.initializePackageContents();
		theActionlib_datatypesPackage.initializePackageContents();
		theOarp1_datatypesPackage.initializePackageContents();
		theOarp4_datatypesPackage.initializePackageContents();
		theStd_datatypesPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theGeometry_datatypesPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(Geometry_datatypesPackage.eNS_URI, theGeometry_datatypesPackage);
		return theGeometry_datatypesPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPoint() {
		return pointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPoint_X() {
		return (EAttribute)pointEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPoint_Y() {
		return (EAttribute)pointEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPoint_Z() {
		return (EAttribute)pointEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPoint32() {
		return point32EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPoint32_X() {
		return (EAttribute)point32EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPoint32_Y() {
		return (EAttribute)point32EClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPoint32_Z() {
		return (EAttribute)point32EClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPointStamped() {
		return pointStampedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPointStamped_Header() {
		return (EReference)pointStampedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPointStamped_Point() {
		return (EReference)pointStampedEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPolygon() {
		return polygonEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPolygon_Point() {
		return (EReference)polygonEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPolygonStamped() {
		return polygonStampedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPolygonStamped_Header() {
		return (EReference)polygonStampedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPolygonStamped_Polygon() {
		return (EReference)polygonStampedEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVector3() {
		return vector3EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVector3_X() {
		return (EAttribute)vector3EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVector3_Y() {
		return (EAttribute)vector3EClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVector3_Z() {
		return (EAttribute)vector3EClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVector3Stamped() {
		return vector3StampedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVector3Stamped_Header() {
		return (EReference)vector3StampedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVector3Stamped_Vector() {
		return (EReference)vector3StampedEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQuaternion() {
		return quaternionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQuaternion_X() {
		return (EAttribute)quaternionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQuaternion_Y() {
		return (EAttribute)quaternionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQuaternion_Z() {
		return (EAttribute)quaternionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQuaternion_W() {
		return (EAttribute)quaternionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPose() {
		return poseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPose_Position() {
		return (EReference)poseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPose_Orientation() {
		return (EReference)poseEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPoseStamped() {
		return poseStampedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPoseStamped_Header() {
		return (EReference)poseStampedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPoseStamped_Pose() {
		return (EReference)poseStampedEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTwistWithCovariance() {
		return twistWithCovarianceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTwistWithCovariance_Twist() {
		return (EReference)twistWithCovarianceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTwistWithCovariance_Covariance() {
		return (EAttribute)twistWithCovarianceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTwist() {
		return twistEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTwist_Linear() {
		return (EReference)twistEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTwist_Angular() {
		return (EReference)twistEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTwistStamped() {
		return twistStampedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTwistStamped_Header() {
		return (EReference)twistStampedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTwistStamped_Twist() {
		return (EReference)twistStampedEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPoseWithCovariance() {
		return poseWithCovarianceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPoseWithCovariance_Pose() {
		return (EReference)poseWithCovarianceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPoseWithCovariance_Covariance() {
		return (EAttribute)poseWithCovarianceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPose2D() {
		return pose2DEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPose2D_X() {
		return (EAttribute)pose2DEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPose2D_Y() {
		return (EAttribute)pose2DEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPose2D_Theta() {
		return (EAttribute)pose2DEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPoseWithCovarianceStamped() {
		return poseWithCovarianceStampedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPoseArray() {
		return poseArrayEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPoseArray_Header() {
		return (EReference)poseArrayEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPoseArray_Poses() {
		return (EReference)poseArrayEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQuaternionStamped() {
		return quaternionStampedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQuaternionStamped_Header() {
		return (EReference)quaternionStampedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQuaternionStamped_Quaternion() {
		return (EReference)quaternionStampedEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTransform() {
		return transformEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransform_Translation() {
		return (EReference)transformEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransform_Rotation() {
		return (EReference)transformEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWrenchStamped() {
		return wrenchStampedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWrenchStamped_Header() {
		return (EReference)wrenchStampedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWrenchStamped_Wrench() {
		return (EReference)wrenchStampedEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWrench() {
		return wrenchEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWrench_Force() {
		return (EReference)wrenchEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWrench_Torque() {
		return (EReference)wrenchEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Geometry_datatypesFactory getGeometry_datatypesFactory() {
		return (Geometry_datatypesFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		pointEClass = createEClass(POINT);
		createEAttribute(pointEClass, POINT__X);
		createEAttribute(pointEClass, POINT__Y);
		createEAttribute(pointEClass, POINT__Z);

		point32EClass = createEClass(POINT32);
		createEAttribute(point32EClass, POINT32__X);
		createEAttribute(point32EClass, POINT32__Y);
		createEAttribute(point32EClass, POINT32__Z);

		pointStampedEClass = createEClass(POINT_STAMPED);
		createEReference(pointStampedEClass, POINT_STAMPED__HEADER);
		createEReference(pointStampedEClass, POINT_STAMPED__POINT);

		polygonEClass = createEClass(POLYGON);
		createEReference(polygonEClass, POLYGON__POINT);

		polygonStampedEClass = createEClass(POLYGON_STAMPED);
		createEReference(polygonStampedEClass, POLYGON_STAMPED__HEADER);
		createEReference(polygonStampedEClass, POLYGON_STAMPED__POLYGON);

		vector3EClass = createEClass(VECTOR3);
		createEAttribute(vector3EClass, VECTOR3__X);
		createEAttribute(vector3EClass, VECTOR3__Y);
		createEAttribute(vector3EClass, VECTOR3__Z);

		vector3StampedEClass = createEClass(VECTOR3_STAMPED);
		createEReference(vector3StampedEClass, VECTOR3_STAMPED__HEADER);
		createEReference(vector3StampedEClass, VECTOR3_STAMPED__VECTOR);

		quaternionEClass = createEClass(QUATERNION);
		createEAttribute(quaternionEClass, QUATERNION__X);
		createEAttribute(quaternionEClass, QUATERNION__Y);
		createEAttribute(quaternionEClass, QUATERNION__Z);
		createEAttribute(quaternionEClass, QUATERNION__W);

		poseEClass = createEClass(POSE);
		createEReference(poseEClass, POSE__POSITION);
		createEReference(poseEClass, POSE__ORIENTATION);

		poseStampedEClass = createEClass(POSE_STAMPED);
		createEReference(poseStampedEClass, POSE_STAMPED__HEADER);
		createEReference(poseStampedEClass, POSE_STAMPED__POSE);

		twistWithCovarianceEClass = createEClass(TWIST_WITH_COVARIANCE);
		createEReference(twistWithCovarianceEClass, TWIST_WITH_COVARIANCE__TWIST);
		createEAttribute(twistWithCovarianceEClass, TWIST_WITH_COVARIANCE__COVARIANCE);

		twistEClass = createEClass(TWIST);
		createEReference(twistEClass, TWIST__LINEAR);
		createEReference(twistEClass, TWIST__ANGULAR);

		twistStampedEClass = createEClass(TWIST_STAMPED);
		createEReference(twistStampedEClass, TWIST_STAMPED__HEADER);
		createEReference(twistStampedEClass, TWIST_STAMPED__TWIST);

		poseWithCovarianceEClass = createEClass(POSE_WITH_COVARIANCE);
		createEReference(poseWithCovarianceEClass, POSE_WITH_COVARIANCE__POSE);
		createEAttribute(poseWithCovarianceEClass, POSE_WITH_COVARIANCE__COVARIANCE);

		pose2DEClass = createEClass(POSE2_D);
		createEAttribute(pose2DEClass, POSE2_D__X);
		createEAttribute(pose2DEClass, POSE2_D__Y);
		createEAttribute(pose2DEClass, POSE2_D__THETA);

		poseWithCovarianceStampedEClass = createEClass(POSE_WITH_COVARIANCE_STAMPED);

		poseArrayEClass = createEClass(POSE_ARRAY);
		createEReference(poseArrayEClass, POSE_ARRAY__HEADER);
		createEReference(poseArrayEClass, POSE_ARRAY__POSES);

		quaternionStampedEClass = createEClass(QUATERNION_STAMPED);
		createEReference(quaternionStampedEClass, QUATERNION_STAMPED__HEADER);
		createEReference(quaternionStampedEClass, QUATERNION_STAMPED__QUATERNION);

		transformEClass = createEClass(TRANSFORM);
		createEReference(transformEClass, TRANSFORM__TRANSLATION);
		createEReference(transformEClass, TRANSFORM__ROTATION);

		wrenchStampedEClass = createEClass(WRENCH_STAMPED);
		createEReference(wrenchStampedEClass, WRENCH_STAMPED__HEADER);
		createEReference(wrenchStampedEClass, WRENCH_STAMPED__WRENCH);

		wrenchEClass = createEClass(WRENCH);
		createEReference(wrenchEClass, WRENCH__FORCE);
		createEReference(wrenchEClass, WRENCH__TORQUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		Std_datatypesPackage theStd_datatypesPackage = (Std_datatypesPackage)EPackage.Registry.INSTANCE.getEPackage(Std_datatypesPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(pointEClass, Point.class, "Point", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPoint_X(), theStd_datatypesPackage.getFloat64(), "x", null, 1, 1, Point.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getPoint_Y(), theStd_datatypesPackage.getFloat64(), "y", null, 1, 1, Point.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getPoint_Z(), theStd_datatypesPackage.getFloat64(), "z", null, 1, 1, Point.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(point32EClass, Point32.class, "Point32", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPoint32_X(), theStd_datatypesPackage.getFloat32(), "x", null, 1, 1, Point32.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getPoint32_Y(), theStd_datatypesPackage.getFloat32(), "y", null, 1, 1, Point32.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getPoint32_Z(), theStd_datatypesPackage.getFloat32(), "z", null, 1, 1, Point32.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(pointStampedEClass, PointStamped.class, "PointStamped", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPointStamped_Header(), theStd_datatypesPackage.getHeader(), null, "header", null, 1, 1, PointStamped.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getPointStamped_Point(), this.getPoint(), null, "point", null, 1, 1, PointStamped.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(polygonEClass, Polygon.class, "Polygon", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPolygon_Point(), this.getPoint32(), null, "point", null, 3, -1, Polygon.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(polygonStampedEClass, PolygonStamped.class, "PolygonStamped", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPolygonStamped_Header(), theStd_datatypesPackage.getHeader(), null, "header", null, 1, 1, PolygonStamped.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getPolygonStamped_Polygon(), this.getPolygon(), null, "polygon", null, 1, 1, PolygonStamped.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(vector3EClass, Vector3.class, "Vector3", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVector3_X(), theStd_datatypesPackage.getFloat64(), "x", null, 1, 1, Vector3.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getVector3_Y(), theStd_datatypesPackage.getFloat64(), "y", null, 1, 1, Vector3.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getVector3_Z(), theStd_datatypesPackage.getFloat64(), "z", null, 1, 1, Vector3.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(vector3StampedEClass, Vector3Stamped.class, "Vector3Stamped", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVector3Stamped_Header(), theStd_datatypesPackage.getHeader(), null, "header", null, 1, 1, Vector3Stamped.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getVector3Stamped_Vector(), this.getVector3(), null, "vector", null, 1, 1, Vector3Stamped.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(quaternionEClass, Quaternion.class, "Quaternion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getQuaternion_X(), theStd_datatypesPackage.getFloat64(), "x", null, 1, 1, Quaternion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getQuaternion_Y(), theStd_datatypesPackage.getFloat64(), "y", null, 1, 1, Quaternion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getQuaternion_Z(), theStd_datatypesPackage.getFloat64(), "z", null, 1, 1, Quaternion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getQuaternion_W(), theStd_datatypesPackage.getFloat64(), "w", null, 1, 1, Quaternion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(poseEClass, Pose.class, "Pose", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPose_Position(), this.getPoint(), null, "position", null, 1, 1, Pose.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getPose_Orientation(), this.getQuaternion(), null, "orientation", null, 1, 1, Pose.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(poseStampedEClass, PoseStamped.class, "PoseStamped", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPoseStamped_Header(), theStd_datatypesPackage.getHeader(), null, "header", null, 1, 1, PoseStamped.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getPoseStamped_Pose(), this.getPose(), null, "pose", null, 1, 1, PoseStamped.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(twistWithCovarianceEClass, TwistWithCovariance.class, "TwistWithCovariance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTwistWithCovariance_Twist(), this.getTwist(), null, "twist", null, 1, 1, TwistWithCovariance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getTwistWithCovariance_Covariance(), theStd_datatypesPackage.getFloat64(), "covariance", null, 36, 36, TwistWithCovariance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(twistEClass, Twist.class, "Twist", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTwist_Linear(), this.getVector3(), null, "linear", null, 1, 1, Twist.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getTwist_Angular(), this.getVector3(), null, "angular", null, 1, 1, Twist.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(twistStampedEClass, TwistStamped.class, "TwistStamped", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTwistStamped_Header(), theStd_datatypesPackage.getHeader(), null, "header", null, 1, 1, TwistStamped.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getTwistStamped_Twist(), this.getTwist(), null, "twist", null, 1, 1, TwistStamped.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(poseWithCovarianceEClass, PoseWithCovariance.class, "PoseWithCovariance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPoseWithCovariance_Pose(), this.getPose(), null, "pose", null, 1, 1, PoseWithCovariance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getPoseWithCovariance_Covariance(), theStd_datatypesPackage.getFloat64(), "covariance", null, 36, 36, PoseWithCovariance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(pose2DEClass, Pose2D.class, "Pose2D", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPose2D_X(), theStd_datatypesPackage.getFloat64(), "x", null, 1, 1, Pose2D.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getPose2D_Y(), theStd_datatypesPackage.getFloat64(), "y", null, 1, 1, Pose2D.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getPose2D_Theta(), theStd_datatypesPackage.getFloat64(), "theta", null, 1, 1, Pose2D.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(poseWithCovarianceStampedEClass, PoseWithCovarianceStamped.class, "PoseWithCovarianceStamped", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(poseArrayEClass, PoseArray.class, "PoseArray", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPoseArray_Header(), theStd_datatypesPackage.getHeader(), null, "header", null, 1, 1, PoseArray.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getPoseArray_Poses(), this.getPose(), null, "poses", null, 0, -1, PoseArray.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(quaternionStampedEClass, QuaternionStamped.class, "QuaternionStamped", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getQuaternionStamped_Header(), theStd_datatypesPackage.getHeader(), null, "header", null, 1, 1, QuaternionStamped.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getQuaternionStamped_Quaternion(), this.getQuaternion(), null, "quaternion", null, 1, 1, QuaternionStamped.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(transformEClass, Transform.class, "Transform", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTransform_Translation(), this.getVector3(), null, "translation", null, 1, 1, Transform.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getTransform_Rotation(), this.getQuaternion(), null, "rotation", null, 1, 1, Transform.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(wrenchStampedEClass, WrenchStamped.class, "WrenchStamped", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getWrenchStamped_Header(), theStd_datatypesPackage.getHeader(), null, "header", null, 1, 1, WrenchStamped.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getWrenchStamped_Wrench(), this.getWrench(), null, "wrench", null, 1, 1, WrenchStamped.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(wrenchEClass, Wrench.class, "Wrench", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getWrench_Force(), this.getVector3(), null, "force", null, 1, 1, Wrench.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getWrench_Torque(), this.getVector3(), null, "torque", null, 1, 1, Wrench.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //Geometry_datatypesPackageImpl
