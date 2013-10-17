/**
 */
package org.eclipse.papyrus.RobotML.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.RobotML.EngineSystem;
import org.eclipse.papyrus.RobotML.RobotMLPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Engine System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.EngineSystemImpl#getVehicleTraction <em>Vehicle Traction</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.EngineSystemImpl#getMaxEngineForce <em>Max Engine Force</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.EngineSystemImpl#getMaxBreakingForce <em>Max Breaking Force</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.EngineSystemImpl#getMaxAllowedSteering <em>Max Allowed Steering</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.EngineSystemImpl#getMaxAllowedVelocity <em>Max Allowed Velocity</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.EngineSystemImpl#getGear_ration <em>Gear ration</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EngineSystemImpl extends ActuatorSystemImpl implements EngineSystem {
	/**
	 * The default value of the '{@link #getVehicleTraction() <em>Vehicle Traction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVehicleTraction()
	 * @generated
	 * @ordered
	 */
	protected static final String VEHICLE_TRACTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVehicleTraction() <em>Vehicle Traction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVehicleTraction()
	 * @generated
	 * @ordered
	 */
	protected String vehicleTraction = VEHICLE_TRACTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxEngineForce() <em>Max Engine Force</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxEngineForce()
	 * @generated
	 * @ordered
	 */
	protected static final float MAX_ENGINE_FORCE_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getMaxEngineForce() <em>Max Engine Force</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxEngineForce()
	 * @generated
	 * @ordered
	 */
	protected float maxEngineForce = MAX_ENGINE_FORCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxBreakingForce() <em>Max Breaking Force</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxBreakingForce()
	 * @generated
	 * @ordered
	 */
	protected static final float MAX_BREAKING_FORCE_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getMaxBreakingForce() <em>Max Breaking Force</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxBreakingForce()
	 * @generated
	 * @ordered
	 */
	protected float maxBreakingForce = MAX_BREAKING_FORCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxAllowedSteering() <em>Max Allowed Steering</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxAllowedSteering()
	 * @generated
	 * @ordered
	 */
	protected static final float MAX_ALLOWED_STEERING_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getMaxAllowedSteering() <em>Max Allowed Steering</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxAllowedSteering()
	 * @generated
	 * @ordered
	 */
	protected float maxAllowedSteering = MAX_ALLOWED_STEERING_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxAllowedVelocity() <em>Max Allowed Velocity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxAllowedVelocity()
	 * @generated
	 * @ordered
	 */
	protected static final float MAX_ALLOWED_VELOCITY_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getMaxAllowedVelocity() <em>Max Allowed Velocity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxAllowedVelocity()
	 * @generated
	 * @ordered
	 */
	protected float maxAllowedVelocity = MAX_ALLOWED_VELOCITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getGear_ration() <em>Gear ration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGear_ration()
	 * @generated
	 * @ordered
	 */
	protected static final float GEAR_RATION_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getGear_ration() <em>Gear ration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGear_ration()
	 * @generated
	 * @ordered
	 */
	protected float gear_ration = GEAR_RATION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EngineSystemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RobotMLPackage.Literals.ENGINE_SYSTEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVehicleTraction() {
		return vehicleTraction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVehicleTraction(String newVehicleTraction) {
		String oldVehicleTraction = vehicleTraction;
		vehicleTraction = newVehicleTraction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.ENGINE_SYSTEM__VEHICLE_TRACTION, oldVehicleTraction, vehicleTraction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getMaxEngineForce() {
		return maxEngineForce;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxEngineForce(float newMaxEngineForce) {
		float oldMaxEngineForce = maxEngineForce;
		maxEngineForce = newMaxEngineForce;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.ENGINE_SYSTEM__MAX_ENGINE_FORCE, oldMaxEngineForce, maxEngineForce));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getMaxBreakingForce() {
		return maxBreakingForce;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxBreakingForce(float newMaxBreakingForce) {
		float oldMaxBreakingForce = maxBreakingForce;
		maxBreakingForce = newMaxBreakingForce;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.ENGINE_SYSTEM__MAX_BREAKING_FORCE, oldMaxBreakingForce, maxBreakingForce));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getMaxAllowedSteering() {
		return maxAllowedSteering;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxAllowedSteering(float newMaxAllowedSteering) {
		float oldMaxAllowedSteering = maxAllowedSteering;
		maxAllowedSteering = newMaxAllowedSteering;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.ENGINE_SYSTEM__MAX_ALLOWED_STEERING, oldMaxAllowedSteering, maxAllowedSteering));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getMaxAllowedVelocity() {
		return maxAllowedVelocity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxAllowedVelocity(float newMaxAllowedVelocity) {
		float oldMaxAllowedVelocity = maxAllowedVelocity;
		maxAllowedVelocity = newMaxAllowedVelocity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.ENGINE_SYSTEM__MAX_ALLOWED_VELOCITY, oldMaxAllowedVelocity, maxAllowedVelocity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getGear_ration() {
		return gear_ration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGear_ration(float newGear_ration) {
		float oldGear_ration = gear_ration;
		gear_ration = newGear_ration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.ENGINE_SYSTEM__GEAR_RATION, oldGear_ration, gear_ration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RobotMLPackage.ENGINE_SYSTEM__VEHICLE_TRACTION:
				return getVehicleTraction();
			case RobotMLPackage.ENGINE_SYSTEM__MAX_ENGINE_FORCE:
				return getMaxEngineForce();
			case RobotMLPackage.ENGINE_SYSTEM__MAX_BREAKING_FORCE:
				return getMaxBreakingForce();
			case RobotMLPackage.ENGINE_SYSTEM__MAX_ALLOWED_STEERING:
				return getMaxAllowedSteering();
			case RobotMLPackage.ENGINE_SYSTEM__MAX_ALLOWED_VELOCITY:
				return getMaxAllowedVelocity();
			case RobotMLPackage.ENGINE_SYSTEM__GEAR_RATION:
				return getGear_ration();
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
			case RobotMLPackage.ENGINE_SYSTEM__VEHICLE_TRACTION:
				setVehicleTraction((String)newValue);
				return;
			case RobotMLPackage.ENGINE_SYSTEM__MAX_ENGINE_FORCE:
				setMaxEngineForce((Float)newValue);
				return;
			case RobotMLPackage.ENGINE_SYSTEM__MAX_BREAKING_FORCE:
				setMaxBreakingForce((Float)newValue);
				return;
			case RobotMLPackage.ENGINE_SYSTEM__MAX_ALLOWED_STEERING:
				setMaxAllowedSteering((Float)newValue);
				return;
			case RobotMLPackage.ENGINE_SYSTEM__MAX_ALLOWED_VELOCITY:
				setMaxAllowedVelocity((Float)newValue);
				return;
			case RobotMLPackage.ENGINE_SYSTEM__GEAR_RATION:
				setGear_ration((Float)newValue);
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
			case RobotMLPackage.ENGINE_SYSTEM__VEHICLE_TRACTION:
				setVehicleTraction(VEHICLE_TRACTION_EDEFAULT);
				return;
			case RobotMLPackage.ENGINE_SYSTEM__MAX_ENGINE_FORCE:
				setMaxEngineForce(MAX_ENGINE_FORCE_EDEFAULT);
				return;
			case RobotMLPackage.ENGINE_SYSTEM__MAX_BREAKING_FORCE:
				setMaxBreakingForce(MAX_BREAKING_FORCE_EDEFAULT);
				return;
			case RobotMLPackage.ENGINE_SYSTEM__MAX_ALLOWED_STEERING:
				setMaxAllowedSteering(MAX_ALLOWED_STEERING_EDEFAULT);
				return;
			case RobotMLPackage.ENGINE_SYSTEM__MAX_ALLOWED_VELOCITY:
				setMaxAllowedVelocity(MAX_ALLOWED_VELOCITY_EDEFAULT);
				return;
			case RobotMLPackage.ENGINE_SYSTEM__GEAR_RATION:
				setGear_ration(GEAR_RATION_EDEFAULT);
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
			case RobotMLPackage.ENGINE_SYSTEM__VEHICLE_TRACTION:
				return VEHICLE_TRACTION_EDEFAULT == null ? vehicleTraction != null : !VEHICLE_TRACTION_EDEFAULT.equals(vehicleTraction);
			case RobotMLPackage.ENGINE_SYSTEM__MAX_ENGINE_FORCE:
				return maxEngineForce != MAX_ENGINE_FORCE_EDEFAULT;
			case RobotMLPackage.ENGINE_SYSTEM__MAX_BREAKING_FORCE:
				return maxBreakingForce != MAX_BREAKING_FORCE_EDEFAULT;
			case RobotMLPackage.ENGINE_SYSTEM__MAX_ALLOWED_STEERING:
				return maxAllowedSteering != MAX_ALLOWED_STEERING_EDEFAULT;
			case RobotMLPackage.ENGINE_SYSTEM__MAX_ALLOWED_VELOCITY:
				return maxAllowedVelocity != MAX_ALLOWED_VELOCITY_EDEFAULT;
			case RobotMLPackage.ENGINE_SYSTEM__GEAR_RATION:
				return gear_ration != GEAR_RATION_EDEFAULT;
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
		result.append(" (vehicleTraction: ");
		result.append(vehicleTraction);
		result.append(", maxEngineForce: ");
		result.append(maxEngineForce);
		result.append(", maxBreakingForce: ");
		result.append(maxBreakingForce);
		result.append(", maxAllowedSteering: ");
		result.append(maxAllowedSteering);
		result.append(", maxAllowedVelocity: ");
		result.append(maxAllowedVelocity);
		result.append(", gear_ration: ");
		result.append(gear_ration);
		result.append(')');
		return result.toString();
	}

} //EngineSystemImpl
