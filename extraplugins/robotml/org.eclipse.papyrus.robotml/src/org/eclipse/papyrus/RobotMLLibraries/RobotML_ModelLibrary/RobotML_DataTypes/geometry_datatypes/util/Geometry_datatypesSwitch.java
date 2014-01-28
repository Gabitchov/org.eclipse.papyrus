/**
 */
package org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.*;

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
 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.Geometry_datatypesPackage
 * @generated
 */
public class Geometry_datatypesSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static Geometry_datatypesPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Geometry_datatypesSwitch() {
		if (modelPackage == null) {
			modelPackage = Geometry_datatypesPackage.eINSTANCE;
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
			case Geometry_datatypesPackage.POINT: {
				Point point = (Point)theEObject;
				T result = casePoint(point);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Geometry_datatypesPackage.POINT32: {
				Point32 point32 = (Point32)theEObject;
				T result = casePoint32(point32);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Geometry_datatypesPackage.POINT_STAMPED: {
				PointStamped pointStamped = (PointStamped)theEObject;
				T result = casePointStamped(pointStamped);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Geometry_datatypesPackage.POLYGON: {
				Polygon polygon = (Polygon)theEObject;
				T result = casePolygon(polygon);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Geometry_datatypesPackage.POLYGON_STAMPED: {
				PolygonStamped polygonStamped = (PolygonStamped)theEObject;
				T result = casePolygonStamped(polygonStamped);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Geometry_datatypesPackage.VECTOR3: {
				Vector3 vector3 = (Vector3)theEObject;
				T result = caseVector3(vector3);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Geometry_datatypesPackage.VECTOR3_STAMPED: {
				Vector3Stamped vector3Stamped = (Vector3Stamped)theEObject;
				T result = caseVector3Stamped(vector3Stamped);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Geometry_datatypesPackage.QUATERNION: {
				Quaternion quaternion = (Quaternion)theEObject;
				T result = caseQuaternion(quaternion);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Geometry_datatypesPackage.POSE: {
				Pose pose = (Pose)theEObject;
				T result = casePose(pose);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Geometry_datatypesPackage.POSE_STAMPED: {
				PoseStamped poseStamped = (PoseStamped)theEObject;
				T result = casePoseStamped(poseStamped);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Geometry_datatypesPackage.TWIST_WITH_COVARIANCE: {
				TwistWithCovariance twistWithCovariance = (TwistWithCovariance)theEObject;
				T result = caseTwistWithCovariance(twistWithCovariance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Geometry_datatypesPackage.TWIST: {
				Twist twist = (Twist)theEObject;
				T result = caseTwist(twist);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Geometry_datatypesPackage.TWIST_STAMPED: {
				TwistStamped twistStamped = (TwistStamped)theEObject;
				T result = caseTwistStamped(twistStamped);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Geometry_datatypesPackage.POSE_WITH_COVARIANCE: {
				PoseWithCovariance poseWithCovariance = (PoseWithCovariance)theEObject;
				T result = casePoseWithCovariance(poseWithCovariance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Geometry_datatypesPackage.POSE2_D: {
				Pose2D pose2D = (Pose2D)theEObject;
				T result = casePose2D(pose2D);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Geometry_datatypesPackage.POSE_WITH_COVARIANCE_STAMPED: {
				PoseWithCovarianceStamped poseWithCovarianceStamped = (PoseWithCovarianceStamped)theEObject;
				T result = casePoseWithCovarianceStamped(poseWithCovarianceStamped);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Geometry_datatypesPackage.POSE_ARRAY: {
				PoseArray poseArray = (PoseArray)theEObject;
				T result = casePoseArray(poseArray);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Geometry_datatypesPackage.QUATERNION_STAMPED: {
				QuaternionStamped quaternionStamped = (QuaternionStamped)theEObject;
				T result = caseQuaternionStamped(quaternionStamped);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Geometry_datatypesPackage.TRANSFORM: {
				Transform transform = (Transform)theEObject;
				T result = caseTransform(transform);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Geometry_datatypesPackage.WRENCH_STAMPED: {
				WrenchStamped wrenchStamped = (WrenchStamped)theEObject;
				T result = caseWrenchStamped(wrenchStamped);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Geometry_datatypesPackage.WRENCH: {
				Wrench wrench = (Wrench)theEObject;
				T result = caseWrench(wrench);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Point</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Point</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePoint(Point object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Point32</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Point32</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePoint32(Point32 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Point Stamped</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Point Stamped</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePointStamped(PointStamped object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Polygon</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Polygon</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePolygon(Polygon object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Polygon Stamped</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Polygon Stamped</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePolygonStamped(PolygonStamped object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Vector3</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Vector3</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVector3(Vector3 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Vector3 Stamped</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Vector3 Stamped</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVector3Stamped(Vector3Stamped object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Quaternion</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Quaternion</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseQuaternion(Quaternion object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pose</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pose</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePose(Pose object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pose Stamped</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pose Stamped</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePoseStamped(PoseStamped object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Twist With Covariance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Twist With Covariance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTwistWithCovariance(TwistWithCovariance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Twist</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Twist</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTwist(Twist object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Twist Stamped</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Twist Stamped</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTwistStamped(TwistStamped object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pose With Covariance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pose With Covariance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePoseWithCovariance(PoseWithCovariance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pose2 D</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pose2 D</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePose2D(Pose2D object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pose With Covariance Stamped</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pose With Covariance Stamped</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePoseWithCovarianceStamped(PoseWithCovarianceStamped object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pose Array</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pose Array</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePoseArray(PoseArray object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Quaternion Stamped</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Quaternion Stamped</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseQuaternionStamped(QuaternionStamped object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Transform</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Transform</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTransform(Transform object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Wrench Stamped</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Wrench Stamped</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWrenchStamped(WrenchStamped object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Wrench</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Wrench</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWrench(Wrench object) {
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

} //Geometry_datatypesSwitch
