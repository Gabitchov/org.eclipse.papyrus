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
package org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.CarLikeOdometry;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.Sensor_datatypesPackage;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Header;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Car Like Odometry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.CarLikeOdometryImpl#getHeader <em>
 * Header</em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.CarLikeOdometryImpl#getSteering_angle
 * <em>Steering angle</em>}</li>
 * <li>
 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.CarLikeOdometryImpl#getLeft_rear_wheel_distance
 * <em>Left rear wheel distance</em>}</li>
 * <li>
 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.CarLikeOdometryImpl#getRight_rear_wheel_distance
 * <em>Right rear wheel distance</em>}</li>
 * <li>
 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.CarLikeOdometryImpl#getRight_rear_wheel_velocity
 * <em>Right rear wheel velocity</em>}</li>
 * <li>
 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.CarLikeOdometryImpl#getLeft_rear_wheel_velocity
 * <em>Left rear wheel velocity</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class CarLikeOdometryImpl extends EObjectImpl implements CarLikeOdometry {

	/**
	 * The cached value of the '{@link #getHeader() <em>Header</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getHeader()
	 * @generated
	 * @ordered
	 */
	protected Header header;

	/**
	 * The default value of the '{@link #getSteering_angle() <em>Steering angle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getSteering_angle()
	 * @generated
	 * @ordered
	 */
	protected static final double STEERING_ANGLE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getSteering_angle() <em>Steering angle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getSteering_angle()
	 * @generated
	 * @ordered
	 */
	protected double steering_angle = STEERING_ANGLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getLeft_rear_wheel_distance() <em>Left rear wheel distance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getLeft_rear_wheel_distance()
	 * @generated
	 * @ordered
	 */
	protected static final double LEFT_REAR_WHEEL_DISTANCE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getLeft_rear_wheel_distance() <em>Left rear wheel distance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getLeft_rear_wheel_distance()
	 * @generated
	 * @ordered
	 */
	protected double left_rear_wheel_distance = LEFT_REAR_WHEEL_DISTANCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getRight_rear_wheel_distance() <em>Right rear wheel distance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getRight_rear_wheel_distance()
	 * @generated
	 * @ordered
	 */
	protected static final double RIGHT_REAR_WHEEL_DISTANCE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getRight_rear_wheel_distance() <em>Right rear wheel distance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getRight_rear_wheel_distance()
	 * @generated
	 * @ordered
	 */
	protected double right_rear_wheel_distance = RIGHT_REAR_WHEEL_DISTANCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getRight_rear_wheel_velocity() <em>Right rear wheel velocity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getRight_rear_wheel_velocity()
	 * @generated
	 * @ordered
	 */
	protected static final double RIGHT_REAR_WHEEL_VELOCITY_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getRight_rear_wheel_velocity() <em>Right rear wheel velocity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getRight_rear_wheel_velocity()
	 * @generated
	 * @ordered
	 */
	protected double right_rear_wheel_velocity = RIGHT_REAR_WHEEL_VELOCITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getLeft_rear_wheel_velocity() <em>Left rear wheel velocity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getLeft_rear_wheel_velocity()
	 * @generated
	 * @ordered
	 */
	protected static final double LEFT_REAR_WHEEL_VELOCITY_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getLeft_rear_wheel_velocity() <em>Left rear wheel velocity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getLeft_rear_wheel_velocity()
	 * @generated
	 * @ordered
	 */
	protected double left_rear_wheel_velocity = LEFT_REAR_WHEEL_VELOCITY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected CarLikeOdometryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Sensor_datatypesPackage.Literals.CAR_LIKE_ODOMETRY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Header getHeader() {
		return header;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetHeader(Header newHeader, NotificationChain msgs) {
		Header oldHeader = header;
		header = newHeader;
		if(eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.CAR_LIKE_ODOMETRY__HEADER, oldHeader, newHeader);
			if(msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setHeader(Header newHeader) {
		if(newHeader != header) {
			NotificationChain msgs = null;
			if(header != null)
				msgs = ((InternalEObject)header).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Sensor_datatypesPackage.CAR_LIKE_ODOMETRY__HEADER, null, msgs);
			if(newHeader != null)
				msgs = ((InternalEObject)newHeader).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Sensor_datatypesPackage.CAR_LIKE_ODOMETRY__HEADER, null, msgs);
			msgs = basicSetHeader(newHeader, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.CAR_LIKE_ODOMETRY__HEADER, newHeader, newHeader));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public double getSteering_angle() {
		return steering_angle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setSteering_angle(double newSteering_angle) {
		double oldSteering_angle = steering_angle;
		steering_angle = newSteering_angle;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.CAR_LIKE_ODOMETRY__STEERING_ANGLE, oldSteering_angle, steering_angle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public double getLeft_rear_wheel_distance() {
		return left_rear_wheel_distance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setLeft_rear_wheel_distance(double newLeft_rear_wheel_distance) {
		double oldLeft_rear_wheel_distance = left_rear_wheel_distance;
		left_rear_wheel_distance = newLeft_rear_wheel_distance;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.CAR_LIKE_ODOMETRY__LEFT_REAR_WHEEL_DISTANCE, oldLeft_rear_wheel_distance, left_rear_wheel_distance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public double getRight_rear_wheel_distance() {
		return right_rear_wheel_distance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setRight_rear_wheel_distance(double newRight_rear_wheel_distance) {
		double oldRight_rear_wheel_distance = right_rear_wheel_distance;
		right_rear_wheel_distance = newRight_rear_wheel_distance;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.CAR_LIKE_ODOMETRY__RIGHT_REAR_WHEEL_DISTANCE, oldRight_rear_wheel_distance, right_rear_wheel_distance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public double getRight_rear_wheel_velocity() {
		return right_rear_wheel_velocity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setRight_rear_wheel_velocity(double newRight_rear_wheel_velocity) {
		double oldRight_rear_wheel_velocity = right_rear_wheel_velocity;
		right_rear_wheel_velocity = newRight_rear_wheel_velocity;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.CAR_LIKE_ODOMETRY__RIGHT_REAR_WHEEL_VELOCITY, oldRight_rear_wheel_velocity, right_rear_wheel_velocity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public double getLeft_rear_wheel_velocity() {
		return left_rear_wheel_velocity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setLeft_rear_wheel_velocity(double newLeft_rear_wheel_velocity) {
		double oldLeft_rear_wheel_velocity = left_rear_wheel_velocity;
		left_rear_wheel_velocity = newLeft_rear_wheel_velocity;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.CAR_LIKE_ODOMETRY__LEFT_REAR_WHEEL_VELOCITY, oldLeft_rear_wheel_velocity, left_rear_wheel_velocity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch(featureID) {
		case Sensor_datatypesPackage.CAR_LIKE_ODOMETRY__HEADER:
			return basicSetHeader(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch(featureID) {
		case Sensor_datatypesPackage.CAR_LIKE_ODOMETRY__HEADER:
			return getHeader();
		case Sensor_datatypesPackage.CAR_LIKE_ODOMETRY__STEERING_ANGLE:
			return getSteering_angle();
		case Sensor_datatypesPackage.CAR_LIKE_ODOMETRY__LEFT_REAR_WHEEL_DISTANCE:
			return getLeft_rear_wheel_distance();
		case Sensor_datatypesPackage.CAR_LIKE_ODOMETRY__RIGHT_REAR_WHEEL_DISTANCE:
			return getRight_rear_wheel_distance();
		case Sensor_datatypesPackage.CAR_LIKE_ODOMETRY__RIGHT_REAR_WHEEL_VELOCITY:
			return getRight_rear_wheel_velocity();
		case Sensor_datatypesPackage.CAR_LIKE_ODOMETRY__LEFT_REAR_WHEEL_VELOCITY:
			return getLeft_rear_wheel_velocity();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch(featureID) {
		case Sensor_datatypesPackage.CAR_LIKE_ODOMETRY__HEADER:
			setHeader((Header)newValue);
			return;
		case Sensor_datatypesPackage.CAR_LIKE_ODOMETRY__STEERING_ANGLE:
			setSteering_angle((Double)newValue);
			return;
		case Sensor_datatypesPackage.CAR_LIKE_ODOMETRY__LEFT_REAR_WHEEL_DISTANCE:
			setLeft_rear_wheel_distance((Double)newValue);
			return;
		case Sensor_datatypesPackage.CAR_LIKE_ODOMETRY__RIGHT_REAR_WHEEL_DISTANCE:
			setRight_rear_wheel_distance((Double)newValue);
			return;
		case Sensor_datatypesPackage.CAR_LIKE_ODOMETRY__RIGHT_REAR_WHEEL_VELOCITY:
			setRight_rear_wheel_velocity((Double)newValue);
			return;
		case Sensor_datatypesPackage.CAR_LIKE_ODOMETRY__LEFT_REAR_WHEEL_VELOCITY:
			setLeft_rear_wheel_velocity((Double)newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch(featureID) {
		case Sensor_datatypesPackage.CAR_LIKE_ODOMETRY__HEADER:
			setHeader((Header)null);
			return;
		case Sensor_datatypesPackage.CAR_LIKE_ODOMETRY__STEERING_ANGLE:
			setSteering_angle(STEERING_ANGLE_EDEFAULT);
			return;
		case Sensor_datatypesPackage.CAR_LIKE_ODOMETRY__LEFT_REAR_WHEEL_DISTANCE:
			setLeft_rear_wheel_distance(LEFT_REAR_WHEEL_DISTANCE_EDEFAULT);
			return;
		case Sensor_datatypesPackage.CAR_LIKE_ODOMETRY__RIGHT_REAR_WHEEL_DISTANCE:
			setRight_rear_wheel_distance(RIGHT_REAR_WHEEL_DISTANCE_EDEFAULT);
			return;
		case Sensor_datatypesPackage.CAR_LIKE_ODOMETRY__RIGHT_REAR_WHEEL_VELOCITY:
			setRight_rear_wheel_velocity(RIGHT_REAR_WHEEL_VELOCITY_EDEFAULT);
			return;
		case Sensor_datatypesPackage.CAR_LIKE_ODOMETRY__LEFT_REAR_WHEEL_VELOCITY:
			setLeft_rear_wheel_velocity(LEFT_REAR_WHEEL_VELOCITY_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch(featureID) {
		case Sensor_datatypesPackage.CAR_LIKE_ODOMETRY__HEADER:
			return header != null;
		case Sensor_datatypesPackage.CAR_LIKE_ODOMETRY__STEERING_ANGLE:
			return steering_angle != STEERING_ANGLE_EDEFAULT;
		case Sensor_datatypesPackage.CAR_LIKE_ODOMETRY__LEFT_REAR_WHEEL_DISTANCE:
			return left_rear_wheel_distance != LEFT_REAR_WHEEL_DISTANCE_EDEFAULT;
		case Sensor_datatypesPackage.CAR_LIKE_ODOMETRY__RIGHT_REAR_WHEEL_DISTANCE:
			return right_rear_wheel_distance != RIGHT_REAR_WHEEL_DISTANCE_EDEFAULT;
		case Sensor_datatypesPackage.CAR_LIKE_ODOMETRY__RIGHT_REAR_WHEEL_VELOCITY:
			return right_rear_wheel_velocity != RIGHT_REAR_WHEEL_VELOCITY_EDEFAULT;
		case Sensor_datatypesPackage.CAR_LIKE_ODOMETRY__LEFT_REAR_WHEEL_VELOCITY:
			return left_rear_wheel_velocity != LEFT_REAR_WHEEL_VELOCITY_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if(eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (steering_angle: ");
		result.append(steering_angle);
		result.append(", left_rear_wheel_distance: ");
		result.append(left_rear_wheel_distance);
		result.append(", right_rear_wheel_distance: ");
		result.append(right_rear_wheel_distance);
		result.append(", right_rear_wheel_velocity: ");
		result.append(right_rear_wheel_velocity);
		result.append(", left_rear_wheel_velocity: ");
		result.append(left_rear_wheel_velocity);
		result.append(')');
		return result.toString();
	}

} //CarLikeOdometryImpl
