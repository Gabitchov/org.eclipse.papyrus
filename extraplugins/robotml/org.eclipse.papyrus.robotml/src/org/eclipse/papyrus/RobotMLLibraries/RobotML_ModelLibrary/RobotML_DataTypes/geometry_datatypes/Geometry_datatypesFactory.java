/**
 */
package org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.Geometry_datatypesPackage
 * @generated
 */
public interface Geometry_datatypesFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Geometry_datatypesFactory eINSTANCE = org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.impl.Geometry_datatypesFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Point</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Point</em>'.
	 * @generated
	 */
	Point createPoint();

	/**
	 * Returns a new object of class '<em>Point32</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Point32</em>'.
	 * @generated
	 */
	Point32 createPoint32();

	/**
	 * Returns a new object of class '<em>Point Stamped</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Point Stamped</em>'.
	 * @generated
	 */
	PointStamped createPointStamped();

	/**
	 * Returns a new object of class '<em>Polygon</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Polygon</em>'.
	 * @generated
	 */
	Polygon createPolygon();

	/**
	 * Returns a new object of class '<em>Polygon Stamped</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Polygon Stamped</em>'.
	 * @generated
	 */
	PolygonStamped createPolygonStamped();

	/**
	 * Returns a new object of class '<em>Vector3</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Vector3</em>'.
	 * @generated
	 */
	Vector3 createVector3();

	/**
	 * Returns a new object of class '<em>Vector3 Stamped</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Vector3 Stamped</em>'.
	 * @generated
	 */
	Vector3Stamped createVector3Stamped();

	/**
	 * Returns a new object of class '<em>Quaternion</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Quaternion</em>'.
	 * @generated
	 */
	Quaternion createQuaternion();

	/**
	 * Returns a new object of class '<em>Pose</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pose</em>'.
	 * @generated
	 */
	Pose createPose();

	/**
	 * Returns a new object of class '<em>Pose Stamped</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pose Stamped</em>'.
	 * @generated
	 */
	PoseStamped createPoseStamped();

	/**
	 * Returns a new object of class '<em>Twist With Covariance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Twist With Covariance</em>'.
	 * @generated
	 */
	TwistWithCovariance createTwistWithCovariance();

	/**
	 * Returns a new object of class '<em>Twist</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Twist</em>'.
	 * @generated
	 */
	Twist createTwist();

	/**
	 * Returns a new object of class '<em>Twist Stamped</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Twist Stamped</em>'.
	 * @generated
	 */
	TwistStamped createTwistStamped();

	/**
	 * Returns a new object of class '<em>Pose With Covariance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pose With Covariance</em>'.
	 * @generated
	 */
	PoseWithCovariance createPoseWithCovariance();

	/**
	 * Returns a new object of class '<em>Pose2 D</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pose2 D</em>'.
	 * @generated
	 */
	Pose2D createPose2D();

	/**
	 * Returns a new object of class '<em>Pose With Covariance Stamped</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pose With Covariance Stamped</em>'.
	 * @generated
	 */
	PoseWithCovarianceStamped createPoseWithCovarianceStamped();

	/**
	 * Returns a new object of class '<em>Pose Array</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pose Array</em>'.
	 * @generated
	 */
	PoseArray createPoseArray();

	/**
	 * Returns a new object of class '<em>Quaternion Stamped</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Quaternion Stamped</em>'.
	 * @generated
	 */
	QuaternionStamped createQuaternionStamped();

	/**
	 * Returns a new object of class '<em>Transform</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Transform</em>'.
	 * @generated
	 */
	Transform createTransform();

	/**
	 * Returns a new object of class '<em>Wrench Stamped</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Wrench Stamped</em>'.
	 * @generated
	 */
	WrenchStamped createWrenchStamped();

	/**
	 * Returns a new object of class '<em>Wrench</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Wrench</em>'.
	 * @generated
	 */
	Wrench createWrench();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	Geometry_datatypesPackage getGeometry_datatypesPackage();

} //Geometry_datatypesFactory
