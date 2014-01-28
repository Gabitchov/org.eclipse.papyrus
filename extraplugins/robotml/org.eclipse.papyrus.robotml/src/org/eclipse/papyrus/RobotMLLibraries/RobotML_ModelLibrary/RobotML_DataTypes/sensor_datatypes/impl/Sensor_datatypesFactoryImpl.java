/**
 */
package org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Sensor_datatypesFactoryImpl extends EFactoryImpl implements Sensor_datatypesFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Sensor_datatypesFactory init() {
		try {
			Sensor_datatypesFactory theSensor_datatypesFactory = (Sensor_datatypesFactory)EPackage.Registry.INSTANCE.getEFactory(Sensor_datatypesPackage.eNS_URI);
			if (theSensor_datatypesFactory != null) {
				return theSensor_datatypesFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Sensor_datatypesFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Sensor_datatypesFactoryImpl() {
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
			case Sensor_datatypesPackage.REGION_OF_INTEREST: return createRegionOfInterest();
			case Sensor_datatypesPackage.RANGE: return createRange();
			case Sensor_datatypesPackage.CAMERA_INFO: return createCameraInfo();
			case Sensor_datatypesPackage.IMU: return createImu();
			case Sensor_datatypesPackage.LASER_SCAN: return createLaserScan();
			case Sensor_datatypesPackage.IMAGE: return createImage();
			case Sensor_datatypesPackage.CHANNEL_FLOAT32: return createChannelFloat32();
			case Sensor_datatypesPackage.COMPRESSED_IMAGE: return createCompressedImage();
			case Sensor_datatypesPackage.POINT_CLOUD: return createPointCloud();
			case Sensor_datatypesPackage.POINT_FIELD: return createPointField();
			case Sensor_datatypesPackage.POINT_CLOUD2: return createPointCloud2();
			case Sensor_datatypesPackage.JOINT_STATE: return createJointState();
			case Sensor_datatypesPackage.NAV_SAT_STATUS: return createNavSatStatus();
			case Sensor_datatypesPackage.NAV_SAT_FIX: return createNavSatFix();
			case Sensor_datatypesPackage.JOY: return createJoy();
			case Sensor_datatypesPackage.JOY_FEEDBACK: return createJoyFeedback();
			case Sensor_datatypesPackage.JOY_FEEDBACK_ARRAY: return createJoyFeedbackArray();
			case Sensor_datatypesPackage.CAR_LIKE_ODOMETRY: return createCarLikeOdometry();
			case Sensor_datatypesPackage.DIFFERENTIAL_ODOMETRY: return createDifferentialOdometry();
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
			case Sensor_datatypesPackage.STATUS_TYPE:
				return createSTATUS_TYPEFromString(eDataType, initialValue);
			case Sensor_datatypesPackage.SERVICE_TYPE:
				return createSERVICE_TYPEFromString(eDataType, initialValue);
			case Sensor_datatypesPackage.COVARIANCE_TYPE:
				return createCOVARIANCE_TYPEFromString(eDataType, initialValue);
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
			case Sensor_datatypesPackage.STATUS_TYPE:
				return convertSTATUS_TYPEToString(eDataType, instanceValue);
			case Sensor_datatypesPackage.SERVICE_TYPE:
				return convertSERVICE_TYPEToString(eDataType, instanceValue);
			case Sensor_datatypesPackage.COVARIANCE_TYPE:
				return convertCOVARIANCE_TYPEToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegionOfInterest createRegionOfInterest() {
		RegionOfInterestImpl regionOfInterest = new RegionOfInterestImpl();
		return regionOfInterest;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Range createRange() {
		RangeImpl range = new RangeImpl();
		return range;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CameraInfo createCameraInfo() {
		CameraInfoImpl cameraInfo = new CameraInfoImpl();
		return cameraInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Imu createImu() {
		ImuImpl imu = new ImuImpl();
		return imu;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LaserScan createLaserScan() {
		LaserScanImpl laserScan = new LaserScanImpl();
		return laserScan;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Image createImage() {
		ImageImpl image = new ImageImpl();
		return image;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChannelFloat32 createChannelFloat32() {
		ChannelFloat32Impl channelFloat32 = new ChannelFloat32Impl();
		return channelFloat32;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompressedImage createCompressedImage() {
		CompressedImageImpl compressedImage = new CompressedImageImpl();
		return compressedImage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PointCloud createPointCloud() {
		PointCloudImpl pointCloud = new PointCloudImpl();
		return pointCloud;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PointField createPointField() {
		PointFieldImpl pointField = new PointFieldImpl();
		return pointField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PointCloud2 createPointCloud2() {
		PointCloud2Impl pointCloud2 = new PointCloud2Impl();
		return pointCloud2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JointState createJointState() {
		JointStateImpl jointState = new JointStateImpl();
		return jointState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NavSatStatus createNavSatStatus() {
		NavSatStatusImpl navSatStatus = new NavSatStatusImpl();
		return navSatStatus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NavSatFix createNavSatFix() {
		NavSatFixImpl navSatFix = new NavSatFixImpl();
		return navSatFix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Joy createJoy() {
		JoyImpl joy = new JoyImpl();
		return joy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JoyFeedback createJoyFeedback() {
		JoyFeedbackImpl joyFeedback = new JoyFeedbackImpl();
		return joyFeedback;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JoyFeedbackArray createJoyFeedbackArray() {
		JoyFeedbackArrayImpl joyFeedbackArray = new JoyFeedbackArrayImpl();
		return joyFeedbackArray;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CarLikeOdometry createCarLikeOdometry() {
		CarLikeOdometryImpl carLikeOdometry = new CarLikeOdometryImpl();
		return carLikeOdometry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DifferentialOdometry createDifferentialOdometry() {
		DifferentialOdometryImpl differentialOdometry = new DifferentialOdometryImpl();
		return differentialOdometry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public STATUS_TYPE createSTATUS_TYPEFromString(EDataType eDataType, String initialValue) {
		STATUS_TYPE result = STATUS_TYPE.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSTATUS_TYPEToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SERVICE_TYPE createSERVICE_TYPEFromString(EDataType eDataType, String initialValue) {
		SERVICE_TYPE result = SERVICE_TYPE.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSERVICE_TYPEToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public COVARIANCE_TYPE createCOVARIANCE_TYPEFromString(EDataType eDataType, String initialValue) {
		COVARIANCE_TYPE result = COVARIANCE_TYPE.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCOVARIANCE_TYPEToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Sensor_datatypesPackage getSensor_datatypesPackage() {
		return (Sensor_datatypesPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static Sensor_datatypesPackage getPackage() {
		return Sensor_datatypesPackage.eINSTANCE;
	}

} //Sensor_datatypesFactoryImpl
