/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Saadia Dhouib (CEA LIST) saadia.dhouib@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.CameraInfo;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.CarLikeOdometry;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.ChannelFloat32;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.CompressedImage;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.DifferentialOdometry;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.Image;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.Imu;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.JointState;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.Joy;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.JoyFeedback;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.JoyFeedbackArray;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.LaserScan;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.NavSatFix;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.NavSatStatus;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.PointCloud;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.PointCloud2;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.PointField;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.Range;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.RegionOfInterest;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.Sensor_datatypesPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.Sensor_datatypesPackage
 * @generated
 */
public class Sensor_datatypesSwitch<T> extends Switch<T> {

	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static Sensor_datatypesPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Sensor_datatypesSwitch() {
		if(modelPackage == null) {
			modelPackage = Sensor_datatypesPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
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
	 * 
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch(classifierID) {
		case Sensor_datatypesPackage.REGION_OF_INTEREST:
		{
			RegionOfInterest regionOfInterest = (RegionOfInterest)theEObject;
			T result = caseRegionOfInterest(regionOfInterest);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Sensor_datatypesPackage.RANGE:
		{
			Range range = (Range)theEObject;
			T result = caseRange(range);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Sensor_datatypesPackage.CAMERA_INFO:
		{
			CameraInfo cameraInfo = (CameraInfo)theEObject;
			T result = caseCameraInfo(cameraInfo);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Sensor_datatypesPackage.IMU:
		{
			Imu imu = (Imu)theEObject;
			T result = caseImu(imu);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Sensor_datatypesPackage.LASER_SCAN:
		{
			LaserScan laserScan = (LaserScan)theEObject;
			T result = caseLaserScan(laserScan);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Sensor_datatypesPackage.IMAGE:
		{
			Image image = (Image)theEObject;
			T result = caseImage(image);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Sensor_datatypesPackage.CHANNEL_FLOAT32:
		{
			ChannelFloat32 channelFloat32 = (ChannelFloat32)theEObject;
			T result = caseChannelFloat32(channelFloat32);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Sensor_datatypesPackage.COMPRESSED_IMAGE:
		{
			CompressedImage compressedImage = (CompressedImage)theEObject;
			T result = caseCompressedImage(compressedImage);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Sensor_datatypesPackage.POINT_CLOUD:
		{
			PointCloud pointCloud = (PointCloud)theEObject;
			T result = casePointCloud(pointCloud);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Sensor_datatypesPackage.POINT_FIELD:
		{
			PointField pointField = (PointField)theEObject;
			T result = casePointField(pointField);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Sensor_datatypesPackage.POINT_CLOUD2:
		{
			PointCloud2 pointCloud2 = (PointCloud2)theEObject;
			T result = casePointCloud2(pointCloud2);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Sensor_datatypesPackage.JOINT_STATE:
		{
			JointState jointState = (JointState)theEObject;
			T result = caseJointState(jointState);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Sensor_datatypesPackage.NAV_SAT_STATUS:
		{
			NavSatStatus navSatStatus = (NavSatStatus)theEObject;
			T result = caseNavSatStatus(navSatStatus);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Sensor_datatypesPackage.NAV_SAT_FIX:
		{
			NavSatFix navSatFix = (NavSatFix)theEObject;
			T result = caseNavSatFix(navSatFix);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Sensor_datatypesPackage.JOY:
		{
			Joy joy = (Joy)theEObject;
			T result = caseJoy(joy);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Sensor_datatypesPackage.JOY_FEEDBACK:
		{
			JoyFeedback joyFeedback = (JoyFeedback)theEObject;
			T result = caseJoyFeedback(joyFeedback);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Sensor_datatypesPackage.JOY_FEEDBACK_ARRAY:
		{
			JoyFeedbackArray joyFeedbackArray = (JoyFeedbackArray)theEObject;
			T result = caseJoyFeedbackArray(joyFeedbackArray);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Sensor_datatypesPackage.CAR_LIKE_ODOMETRY:
		{
			CarLikeOdometry carLikeOdometry = (CarLikeOdometry)theEObject;
			T result = caseCarLikeOdometry(carLikeOdometry);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Sensor_datatypesPackage.DIFFERENTIAL_ODOMETRY:
		{
			DifferentialOdometry differentialOdometry = (DifferentialOdometry)theEObject;
			T result = caseDifferentialOdometry(differentialOdometry);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Region Of Interest</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Region Of Interest</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRegionOfInterest(RegionOfInterest object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Range</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Range</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRange(Range object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Camera Info</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Camera Info</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCameraInfo(CameraInfo object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Imu</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Imu</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImu(Imu object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Laser Scan</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Laser Scan</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLaserScan(LaserScan object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Image</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Image</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImage(Image object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Channel Float32</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Channel Float32</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseChannelFloat32(ChannelFloat32 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Compressed Image</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Compressed Image</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompressedImage(CompressedImage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Point Cloud</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Point Cloud</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePointCloud(PointCloud object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Point Field</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Point Field</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePointField(PointField object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Point Cloud2</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Point Cloud2</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePointCloud2(PointCloud2 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Joint State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Joint State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJointState(JointState object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Nav Sat Status</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Nav Sat Status</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNavSatStatus(NavSatStatus object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Nav Sat Fix</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Nav Sat Fix</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNavSatFix(NavSatFix object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Joy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Joy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJoy(Joy object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Joy Feedback</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Joy Feedback</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJoyFeedback(JoyFeedback object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Joy Feedback Array</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Joy Feedback Array</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJoyFeedbackArray(JoyFeedbackArray object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Car Like Odometry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Car Like Odometry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCarLikeOdometry(CarLikeOdometry object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Differential Odometry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Differential Odometry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDifferentialOdometry(DifferentialOdometry object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //Sensor_datatypesSwitch
