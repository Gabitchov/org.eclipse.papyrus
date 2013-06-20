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
package org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
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

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class Geometry_datatypesFactoryImpl extends EFactoryImpl implements Geometry_datatypesFactory {

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static Geometry_datatypesFactory init() {
		try {
			Geometry_datatypesFactory theGeometry_datatypesFactory = (Geometry_datatypesFactory)EPackage.Registry.INSTANCE.getEFactory("http:///RobotMLLibraries/RobotML_ModelLibrary/RobotML_DataTypes/geometry_datatypes.ecore");
			if(theGeometry_datatypesFactory != null) {
				return theGeometry_datatypesFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Geometry_datatypesFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Geometry_datatypesFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch(eClass.getClassifierID()) {
		case Geometry_datatypesPackage.POINT:
			return createPoint();
		case Geometry_datatypesPackage.POINT32:
			return createPoint32();
		case Geometry_datatypesPackage.POINT_STAMPED:
			return createPointStamped();
		case Geometry_datatypesPackage.POLYGON:
			return createPolygon();
		case Geometry_datatypesPackage.POLYGON_STAMPED:
			return createPolygonStamped();
		case Geometry_datatypesPackage.VECTOR3:
			return createVector3();
		case Geometry_datatypesPackage.VECTOR3_STAMPED:
			return createVector3Stamped();
		case Geometry_datatypesPackage.QUATERNION:
			return createQuaternion();
		case Geometry_datatypesPackage.POSE:
			return createPose();
		case Geometry_datatypesPackage.POSE_STAMPED:
			return createPoseStamped();
		case Geometry_datatypesPackage.TWIST_WITH_COVARIANCE:
			return createTwistWithCovariance();
		case Geometry_datatypesPackage.TWIST:
			return createTwist();
		case Geometry_datatypesPackage.TWIST_STAMPED:
			return createTwistStamped();
		case Geometry_datatypesPackage.POSE_WITH_COVARIANCE:
			return createPoseWithCovariance();
		case Geometry_datatypesPackage.POSE2_D:
			return createPose2D();
		case Geometry_datatypesPackage.POSE_WITH_COVARIANCE_STAMPED:
			return createPoseWithCovarianceStamped();
		case Geometry_datatypesPackage.POSE_ARRAY:
			return createPoseArray();
		case Geometry_datatypesPackage.QUATERNION_STAMPED:
			return createQuaternionStamped();
		case Geometry_datatypesPackage.TRANSFORM:
			return createTransform();
		case Geometry_datatypesPackage.WRENCH_STAMPED:
			return createWrenchStamped();
		case Geometry_datatypesPackage.WRENCH:
			return createWrench();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Point createPoint() {
		PointImpl point = new PointImpl();
		return point;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Point32 createPoint32() {
		Point32Impl point32 = new Point32Impl();
		return point32;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PointStamped createPointStamped() {
		PointStampedImpl pointStamped = new PointStampedImpl();
		return pointStamped;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Polygon createPolygon() {
		PolygonImpl polygon = new PolygonImpl();
		return polygon;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PolygonStamped createPolygonStamped() {
		PolygonStampedImpl polygonStamped = new PolygonStampedImpl();
		return polygonStamped;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Vector3 createVector3() {
		Vector3Impl vector3 = new Vector3Impl();
		return vector3;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Vector3Stamped createVector3Stamped() {
		Vector3StampedImpl vector3Stamped = new Vector3StampedImpl();
		return vector3Stamped;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Quaternion createQuaternion() {
		QuaternionImpl quaternion = new QuaternionImpl();
		return quaternion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Pose createPose() {
		PoseImpl pose = new PoseImpl();
		return pose;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PoseStamped createPoseStamped() {
		PoseStampedImpl poseStamped = new PoseStampedImpl();
		return poseStamped;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public TwistWithCovariance createTwistWithCovariance() {
		TwistWithCovarianceImpl twistWithCovariance = new TwistWithCovarianceImpl();
		return twistWithCovariance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Twist createTwist() {
		TwistImpl twist = new TwistImpl();
		return twist;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public TwistStamped createTwistStamped() {
		TwistStampedImpl twistStamped = new TwistStampedImpl();
		return twistStamped;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PoseWithCovariance createPoseWithCovariance() {
		PoseWithCovarianceImpl poseWithCovariance = new PoseWithCovarianceImpl();
		return poseWithCovariance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Pose2D createPose2D() {
		Pose2DImpl pose2D = new Pose2DImpl();
		return pose2D;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PoseWithCovarianceStamped createPoseWithCovarianceStamped() {
		PoseWithCovarianceStampedImpl poseWithCovarianceStamped = new PoseWithCovarianceStampedImpl();
		return poseWithCovarianceStamped;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PoseArray createPoseArray() {
		PoseArrayImpl poseArray = new PoseArrayImpl();
		return poseArray;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public QuaternionStamped createQuaternionStamped() {
		QuaternionStampedImpl quaternionStamped = new QuaternionStampedImpl();
		return quaternionStamped;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Transform createTransform() {
		TransformImpl transform = new TransformImpl();
		return transform;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public WrenchStamped createWrenchStamped() {
		WrenchStampedImpl wrenchStamped = new WrenchStampedImpl();
		return wrenchStamped;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Wrench createWrench() {
		WrenchImpl wrench = new WrenchImpl();
		return wrench;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Geometry_datatypesPackage getGeometry_datatypesPackage() {
		return (Geometry_datatypesPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static Geometry_datatypesPackage getPackage() {
		return Geometry_datatypesPackage.eINSTANCE;
	}

} //Geometry_datatypesFactoryImpl
