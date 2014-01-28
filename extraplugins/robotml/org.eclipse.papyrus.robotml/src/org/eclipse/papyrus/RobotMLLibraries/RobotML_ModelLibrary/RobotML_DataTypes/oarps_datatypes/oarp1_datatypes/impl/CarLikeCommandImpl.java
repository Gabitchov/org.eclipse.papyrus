/**
 */
package org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.CarLikeCommand;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.Oarp1_datatypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Car Like Command</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.impl.CarLikeCommandImpl#getVelocity <em>Velocity</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.impl.CarLikeCommandImpl#getSteeringAngle <em>Steering Angle</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CarLikeCommandImpl extends MinimalEObjectImpl.Container implements CarLikeCommand {
	/**
	 * The default value of the '{@link #getVelocity() <em>Velocity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVelocity()
	 * @generated
	 * @ordered
	 */
	protected static final double VELOCITY_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getVelocity() <em>Velocity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVelocity()
	 * @generated
	 * @ordered
	 */
	protected double velocity = VELOCITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getSteeringAngle() <em>Steering Angle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSteeringAngle()
	 * @generated
	 * @ordered
	 */
	protected static final double STEERING_ANGLE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getSteeringAngle() <em>Steering Angle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSteeringAngle()
	 * @generated
	 * @ordered
	 */
	protected double steeringAngle = STEERING_ANGLE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CarLikeCommandImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Oarp1_datatypesPackage.Literals.CAR_LIKE_COMMAND;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getVelocity() {
		return velocity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVelocity(double newVelocity) {
		double oldVelocity = velocity;
		velocity = newVelocity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Oarp1_datatypesPackage.CAR_LIKE_COMMAND__VELOCITY, oldVelocity, velocity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getSteeringAngle() {
		return steeringAngle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSteeringAngle(double newSteeringAngle) {
		double oldSteeringAngle = steeringAngle;
		steeringAngle = newSteeringAngle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Oarp1_datatypesPackage.CAR_LIKE_COMMAND__STEERING_ANGLE, oldSteeringAngle, steeringAngle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Oarp1_datatypesPackage.CAR_LIKE_COMMAND__VELOCITY:
				return getVelocity();
			case Oarp1_datatypesPackage.CAR_LIKE_COMMAND__STEERING_ANGLE:
				return getSteeringAngle();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case Oarp1_datatypesPackage.CAR_LIKE_COMMAND__VELOCITY:
				setVelocity((Double)newValue);
				return;
			case Oarp1_datatypesPackage.CAR_LIKE_COMMAND__STEERING_ANGLE:
				setSteeringAngle((Double)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case Oarp1_datatypesPackage.CAR_LIKE_COMMAND__VELOCITY:
				setVelocity(VELOCITY_EDEFAULT);
				return;
			case Oarp1_datatypesPackage.CAR_LIKE_COMMAND__STEERING_ANGLE:
				setSteeringAngle(STEERING_ANGLE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case Oarp1_datatypesPackage.CAR_LIKE_COMMAND__VELOCITY:
				return velocity != VELOCITY_EDEFAULT;
			case Oarp1_datatypesPackage.CAR_LIKE_COMMAND__STEERING_ANGLE:
				return steeringAngle != STEERING_ANGLE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (velocity: ");
		result.append(velocity);
		result.append(", steeringAngle: ");
		result.append(steeringAngle);
		result.append(')');
		return result.toString();
	}

} //CarLikeCommandImpl
