/**
 */
package org.eclipse.papyrus.RobotML.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.RobotML.RobotMLPackage;
import org.eclipse.papyrus.RobotML.SteeredWheelSystem;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Steered Wheel System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.SteeredWheelSystemImpl#getWheelRadius <em>Wheel Radius</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.SteeredWheelSystemImpl#getWheelWidth <em>Wheel Width</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.SteeredWheelSystemImpl#getSuspensionRestLength <em>Suspension Rest Length</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.SteeredWheelSystemImpl#getWheelConnectionHeight <em>Wheel Connection Height</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.SteeredWheelSystemImpl#getTypeOfWheel <em>Type Of Wheel</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.SteeredWheelSystemImpl#getWheelVelocityPIDkp <em>Wheel Velocity PI Dkp</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.SteeredWheelSystemImpl#getWheelVelocityPIDki <em>Wheel Velocity PI Dki</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.SteeredWheelSystemImpl#getWheelVelocityPIDkd <em>Wheel Velocity PI Dkd</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.SteeredWheelSystemImpl#getWheelSteeringPIDkp <em>Wheel Steering PI Dkp</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.SteeredWheelSystemImpl#getWheelSteeringPIDkd <em>Wheel Steering PI Dkd</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.SteeredWheelSystemImpl#getWheelFriction <em>Wheel Friction</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.SteeredWheelSystemImpl#getSuspensionStiffness <em>Suspension Stiffness</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.SteeredWheelSystemImpl#getSuspensionDamping <em>Suspension Damping</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.SteeredWheelSystemImpl#getSuspensionCompression <em>Suspension Compression</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.SteeredWheelSystemImpl#getWheelVelocityPIDmaxSum <em>Wheel Velocity PI Dmax Sum</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.SteeredWheelSystemImpl#getWheelVelocityPIDmaxVal <em>Wheel Velocity PI Dmax Val</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SteeredWheelSystemImpl extends LocomotionSystemImpl implements SteeredWheelSystem {
	/**
	 * The default value of the '{@link #getWheelRadius() <em>Wheel Radius</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWheelRadius()
	 * @generated
	 * @ordered
	 */
	protected static final float WHEEL_RADIUS_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getWheelRadius() <em>Wheel Radius</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWheelRadius()
	 * @generated
	 * @ordered
	 */
	protected float wheelRadius = WHEEL_RADIUS_EDEFAULT;

	/**
	 * The default value of the '{@link #getWheelWidth() <em>Wheel Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWheelWidth()
	 * @generated
	 * @ordered
	 */
	protected static final float WHEEL_WIDTH_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getWheelWidth() <em>Wheel Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWheelWidth()
	 * @generated
	 * @ordered
	 */
	protected float wheelWidth = WHEEL_WIDTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getSuspensionRestLength() <em>Suspension Rest Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuspensionRestLength()
	 * @generated
	 * @ordered
	 */
	protected static final float SUSPENSION_REST_LENGTH_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getSuspensionRestLength() <em>Suspension Rest Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuspensionRestLength()
	 * @generated
	 * @ordered
	 */
	protected float suspensionRestLength = SUSPENSION_REST_LENGTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getWheelConnectionHeight() <em>Wheel Connection Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWheelConnectionHeight()
	 * @generated
	 * @ordered
	 */
	protected static final float WHEEL_CONNECTION_HEIGHT_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getWheelConnectionHeight() <em>Wheel Connection Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWheelConnectionHeight()
	 * @generated
	 * @ordered
	 */
	protected float wheelConnectionHeight = WHEEL_CONNECTION_HEIGHT_EDEFAULT;

	/**
	 * The default value of the '{@link #getTypeOfWheel() <em>Type Of Wheel</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeOfWheel()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_OF_WHEEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTypeOfWheel() <em>Type Of Wheel</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeOfWheel()
	 * @generated
	 * @ordered
	 */
	protected String typeOfWheel = TYPE_OF_WHEEL_EDEFAULT;

	/**
	 * The default value of the '{@link #getWheelVelocityPIDkp() <em>Wheel Velocity PI Dkp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWheelVelocityPIDkp()
	 * @generated
	 * @ordered
	 */
	protected static final float WHEEL_VELOCITY_PI_DKP_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getWheelVelocityPIDkp() <em>Wheel Velocity PI Dkp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWheelVelocityPIDkp()
	 * @generated
	 * @ordered
	 */
	protected float wheelVelocityPIDkp = WHEEL_VELOCITY_PI_DKP_EDEFAULT;

	/**
	 * The default value of the '{@link #getWheelVelocityPIDki() <em>Wheel Velocity PI Dki</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWheelVelocityPIDki()
	 * @generated
	 * @ordered
	 */
	protected static final float WHEEL_VELOCITY_PI_DKI_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getWheelVelocityPIDki() <em>Wheel Velocity PI Dki</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWheelVelocityPIDki()
	 * @generated
	 * @ordered
	 */
	protected float wheelVelocityPIDki = WHEEL_VELOCITY_PI_DKI_EDEFAULT;

	/**
	 * The default value of the '{@link #getWheelVelocityPIDkd() <em>Wheel Velocity PI Dkd</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWheelVelocityPIDkd()
	 * @generated
	 * @ordered
	 */
	protected static final float WHEEL_VELOCITY_PI_DKD_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getWheelVelocityPIDkd() <em>Wheel Velocity PI Dkd</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWheelVelocityPIDkd()
	 * @generated
	 * @ordered
	 */
	protected float wheelVelocityPIDkd = WHEEL_VELOCITY_PI_DKD_EDEFAULT;

	/**
	 * The default value of the '{@link #getWheelSteeringPIDkp() <em>Wheel Steering PI Dkp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWheelSteeringPIDkp()
	 * @generated
	 * @ordered
	 */
	protected static final float WHEEL_STEERING_PI_DKP_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getWheelSteeringPIDkp() <em>Wheel Steering PI Dkp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWheelSteeringPIDkp()
	 * @generated
	 * @ordered
	 */
	protected float wheelSteeringPIDkp = WHEEL_STEERING_PI_DKP_EDEFAULT;

	/**
	 * The default value of the '{@link #getWheelSteeringPIDkd() <em>Wheel Steering PI Dkd</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWheelSteeringPIDkd()
	 * @generated
	 * @ordered
	 */
	protected static final float WHEEL_STEERING_PI_DKD_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getWheelSteeringPIDkd() <em>Wheel Steering PI Dkd</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWheelSteeringPIDkd()
	 * @generated
	 * @ordered
	 */
	protected float wheelSteeringPIDkd = WHEEL_STEERING_PI_DKD_EDEFAULT;

	/**
	 * The default value of the '{@link #getWheelFriction() <em>Wheel Friction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWheelFriction()
	 * @generated
	 * @ordered
	 */
	protected static final float WHEEL_FRICTION_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getWheelFriction() <em>Wheel Friction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWheelFriction()
	 * @generated
	 * @ordered
	 */
	protected float wheelFriction = WHEEL_FRICTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getSuspensionStiffness() <em>Suspension Stiffness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuspensionStiffness()
	 * @generated
	 * @ordered
	 */
	protected static final float SUSPENSION_STIFFNESS_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getSuspensionStiffness() <em>Suspension Stiffness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuspensionStiffness()
	 * @generated
	 * @ordered
	 */
	protected float suspensionStiffness = SUSPENSION_STIFFNESS_EDEFAULT;

	/**
	 * The default value of the '{@link #getSuspensionDamping() <em>Suspension Damping</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuspensionDamping()
	 * @generated
	 * @ordered
	 */
	protected static final float SUSPENSION_DAMPING_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getSuspensionDamping() <em>Suspension Damping</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuspensionDamping()
	 * @generated
	 * @ordered
	 */
	protected float suspensionDamping = SUSPENSION_DAMPING_EDEFAULT;

	/**
	 * The default value of the '{@link #getSuspensionCompression() <em>Suspension Compression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuspensionCompression()
	 * @generated
	 * @ordered
	 */
	protected static final float SUSPENSION_COMPRESSION_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getSuspensionCompression() <em>Suspension Compression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuspensionCompression()
	 * @generated
	 * @ordered
	 */
	protected float suspensionCompression = SUSPENSION_COMPRESSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getWheelVelocityPIDmaxSum() <em>Wheel Velocity PI Dmax Sum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWheelVelocityPIDmaxSum()
	 * @generated
	 * @ordered
	 */
	protected static final float WHEEL_VELOCITY_PI_DMAX_SUM_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getWheelVelocityPIDmaxSum() <em>Wheel Velocity PI Dmax Sum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWheelVelocityPIDmaxSum()
	 * @generated
	 * @ordered
	 */
	protected float wheelVelocityPIDmaxSum = WHEEL_VELOCITY_PI_DMAX_SUM_EDEFAULT;

	/**
	 * The default value of the '{@link #getWheelVelocityPIDmaxVal() <em>Wheel Velocity PI Dmax Val</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWheelVelocityPIDmaxVal()
	 * @generated
	 * @ordered
	 */
	protected static final float WHEEL_VELOCITY_PI_DMAX_VAL_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getWheelVelocityPIDmaxVal() <em>Wheel Velocity PI Dmax Val</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWheelVelocityPIDmaxVal()
	 * @generated
	 * @ordered
	 */
	protected float wheelVelocityPIDmaxVal = WHEEL_VELOCITY_PI_DMAX_VAL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SteeredWheelSystemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RobotMLPackage.Literals.STEERED_WHEEL_SYSTEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getWheelRadius() {
		return wheelRadius;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWheelRadius(float newWheelRadius) {
		float oldWheelRadius = wheelRadius;
		wheelRadius = newWheelRadius;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_RADIUS, oldWheelRadius, wheelRadius));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getWheelWidth() {
		return wheelWidth;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWheelWidth(float newWheelWidth) {
		float oldWheelWidth = wheelWidth;
		wheelWidth = newWheelWidth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_WIDTH, oldWheelWidth, wheelWidth));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getSuspensionRestLength() {
		return suspensionRestLength;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuspensionRestLength(float newSuspensionRestLength) {
		float oldSuspensionRestLength = suspensionRestLength;
		suspensionRestLength = newSuspensionRestLength;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.STEERED_WHEEL_SYSTEM__SUSPENSION_REST_LENGTH, oldSuspensionRestLength, suspensionRestLength));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getWheelConnectionHeight() {
		return wheelConnectionHeight;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWheelConnectionHeight(float newWheelConnectionHeight) {
		float oldWheelConnectionHeight = wheelConnectionHeight;
		wheelConnectionHeight = newWheelConnectionHeight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_CONNECTION_HEIGHT, oldWheelConnectionHeight, wheelConnectionHeight));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTypeOfWheel() {
		return typeOfWheel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeOfWheel(String newTypeOfWheel) {
		String oldTypeOfWheel = typeOfWheel;
		typeOfWheel = newTypeOfWheel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.STEERED_WHEEL_SYSTEM__TYPE_OF_WHEEL, oldTypeOfWheel, typeOfWheel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getWheelVelocityPIDkp() {
		return wheelVelocityPIDkp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWheelVelocityPIDkp(float newWheelVelocityPIDkp) {
		float oldWheelVelocityPIDkp = wheelVelocityPIDkp;
		wheelVelocityPIDkp = newWheelVelocityPIDkp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_VELOCITY_PI_DKP, oldWheelVelocityPIDkp, wheelVelocityPIDkp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getWheelVelocityPIDki() {
		return wheelVelocityPIDki;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWheelVelocityPIDki(float newWheelVelocityPIDki) {
		float oldWheelVelocityPIDki = wheelVelocityPIDki;
		wheelVelocityPIDki = newWheelVelocityPIDki;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_VELOCITY_PI_DKI, oldWheelVelocityPIDki, wheelVelocityPIDki));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getWheelVelocityPIDkd() {
		return wheelVelocityPIDkd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWheelVelocityPIDkd(float newWheelVelocityPIDkd) {
		float oldWheelVelocityPIDkd = wheelVelocityPIDkd;
		wheelVelocityPIDkd = newWheelVelocityPIDkd;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_VELOCITY_PI_DKD, oldWheelVelocityPIDkd, wheelVelocityPIDkd));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getWheelSteeringPIDkp() {
		return wheelSteeringPIDkp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWheelSteeringPIDkp(float newWheelSteeringPIDkp) {
		float oldWheelSteeringPIDkp = wheelSteeringPIDkp;
		wheelSteeringPIDkp = newWheelSteeringPIDkp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_STEERING_PI_DKP, oldWheelSteeringPIDkp, wheelSteeringPIDkp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getWheelSteeringPIDkd() {
		return wheelSteeringPIDkd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWheelSteeringPIDkd(float newWheelSteeringPIDkd) {
		float oldWheelSteeringPIDkd = wheelSteeringPIDkd;
		wheelSteeringPIDkd = newWheelSteeringPIDkd;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_STEERING_PI_DKD, oldWheelSteeringPIDkd, wheelSteeringPIDkd));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getWheelFriction() {
		return wheelFriction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWheelFriction(float newWheelFriction) {
		float oldWheelFriction = wheelFriction;
		wheelFriction = newWheelFriction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_FRICTION, oldWheelFriction, wheelFriction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getSuspensionStiffness() {
		return suspensionStiffness;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuspensionStiffness(float newSuspensionStiffness) {
		float oldSuspensionStiffness = suspensionStiffness;
		suspensionStiffness = newSuspensionStiffness;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.STEERED_WHEEL_SYSTEM__SUSPENSION_STIFFNESS, oldSuspensionStiffness, suspensionStiffness));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getSuspensionDamping() {
		return suspensionDamping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuspensionDamping(float newSuspensionDamping) {
		float oldSuspensionDamping = suspensionDamping;
		suspensionDamping = newSuspensionDamping;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.STEERED_WHEEL_SYSTEM__SUSPENSION_DAMPING, oldSuspensionDamping, suspensionDamping));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getSuspensionCompression() {
		return suspensionCompression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuspensionCompression(float newSuspensionCompression) {
		float oldSuspensionCompression = suspensionCompression;
		suspensionCompression = newSuspensionCompression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.STEERED_WHEEL_SYSTEM__SUSPENSION_COMPRESSION, oldSuspensionCompression, suspensionCompression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getWheelVelocityPIDmaxSum() {
		return wheelVelocityPIDmaxSum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWheelVelocityPIDmaxSum(float newWheelVelocityPIDmaxSum) {
		float oldWheelVelocityPIDmaxSum = wheelVelocityPIDmaxSum;
		wheelVelocityPIDmaxSum = newWheelVelocityPIDmaxSum;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_VELOCITY_PI_DMAX_SUM, oldWheelVelocityPIDmaxSum, wheelVelocityPIDmaxSum));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getWheelVelocityPIDmaxVal() {
		return wheelVelocityPIDmaxVal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWheelVelocityPIDmaxVal(float newWheelVelocityPIDmaxVal) {
		float oldWheelVelocityPIDmaxVal = wheelVelocityPIDmaxVal;
		wheelVelocityPIDmaxVal = newWheelVelocityPIDmaxVal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_VELOCITY_PI_DMAX_VAL, oldWheelVelocityPIDmaxVal, wheelVelocityPIDmaxVal));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_RADIUS:
				return getWheelRadius();
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_WIDTH:
				return getWheelWidth();
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__SUSPENSION_REST_LENGTH:
				return getSuspensionRestLength();
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_CONNECTION_HEIGHT:
				return getWheelConnectionHeight();
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__TYPE_OF_WHEEL:
				return getTypeOfWheel();
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_VELOCITY_PI_DKP:
				return getWheelVelocityPIDkp();
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_VELOCITY_PI_DKI:
				return getWheelVelocityPIDki();
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_VELOCITY_PI_DKD:
				return getWheelVelocityPIDkd();
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_STEERING_PI_DKP:
				return getWheelSteeringPIDkp();
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_STEERING_PI_DKD:
				return getWheelSteeringPIDkd();
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_FRICTION:
				return getWheelFriction();
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__SUSPENSION_STIFFNESS:
				return getSuspensionStiffness();
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__SUSPENSION_DAMPING:
				return getSuspensionDamping();
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__SUSPENSION_COMPRESSION:
				return getSuspensionCompression();
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_VELOCITY_PI_DMAX_SUM:
				return getWheelVelocityPIDmaxSum();
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_VELOCITY_PI_DMAX_VAL:
				return getWheelVelocityPIDmaxVal();
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
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_RADIUS:
				setWheelRadius((Float)newValue);
				return;
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_WIDTH:
				setWheelWidth((Float)newValue);
				return;
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__SUSPENSION_REST_LENGTH:
				setSuspensionRestLength((Float)newValue);
				return;
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_CONNECTION_HEIGHT:
				setWheelConnectionHeight((Float)newValue);
				return;
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__TYPE_OF_WHEEL:
				setTypeOfWheel((String)newValue);
				return;
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_VELOCITY_PI_DKP:
				setWheelVelocityPIDkp((Float)newValue);
				return;
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_VELOCITY_PI_DKI:
				setWheelVelocityPIDki((Float)newValue);
				return;
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_VELOCITY_PI_DKD:
				setWheelVelocityPIDkd((Float)newValue);
				return;
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_STEERING_PI_DKP:
				setWheelSteeringPIDkp((Float)newValue);
				return;
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_STEERING_PI_DKD:
				setWheelSteeringPIDkd((Float)newValue);
				return;
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_FRICTION:
				setWheelFriction((Float)newValue);
				return;
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__SUSPENSION_STIFFNESS:
				setSuspensionStiffness((Float)newValue);
				return;
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__SUSPENSION_DAMPING:
				setSuspensionDamping((Float)newValue);
				return;
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__SUSPENSION_COMPRESSION:
				setSuspensionCompression((Float)newValue);
				return;
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_VELOCITY_PI_DMAX_SUM:
				setWheelVelocityPIDmaxSum((Float)newValue);
				return;
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_VELOCITY_PI_DMAX_VAL:
				setWheelVelocityPIDmaxVal((Float)newValue);
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
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_RADIUS:
				setWheelRadius(WHEEL_RADIUS_EDEFAULT);
				return;
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_WIDTH:
				setWheelWidth(WHEEL_WIDTH_EDEFAULT);
				return;
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__SUSPENSION_REST_LENGTH:
				setSuspensionRestLength(SUSPENSION_REST_LENGTH_EDEFAULT);
				return;
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_CONNECTION_HEIGHT:
				setWheelConnectionHeight(WHEEL_CONNECTION_HEIGHT_EDEFAULT);
				return;
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__TYPE_OF_WHEEL:
				setTypeOfWheel(TYPE_OF_WHEEL_EDEFAULT);
				return;
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_VELOCITY_PI_DKP:
				setWheelVelocityPIDkp(WHEEL_VELOCITY_PI_DKP_EDEFAULT);
				return;
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_VELOCITY_PI_DKI:
				setWheelVelocityPIDki(WHEEL_VELOCITY_PI_DKI_EDEFAULT);
				return;
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_VELOCITY_PI_DKD:
				setWheelVelocityPIDkd(WHEEL_VELOCITY_PI_DKD_EDEFAULT);
				return;
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_STEERING_PI_DKP:
				setWheelSteeringPIDkp(WHEEL_STEERING_PI_DKP_EDEFAULT);
				return;
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_STEERING_PI_DKD:
				setWheelSteeringPIDkd(WHEEL_STEERING_PI_DKD_EDEFAULT);
				return;
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_FRICTION:
				setWheelFriction(WHEEL_FRICTION_EDEFAULT);
				return;
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__SUSPENSION_STIFFNESS:
				setSuspensionStiffness(SUSPENSION_STIFFNESS_EDEFAULT);
				return;
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__SUSPENSION_DAMPING:
				setSuspensionDamping(SUSPENSION_DAMPING_EDEFAULT);
				return;
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__SUSPENSION_COMPRESSION:
				setSuspensionCompression(SUSPENSION_COMPRESSION_EDEFAULT);
				return;
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_VELOCITY_PI_DMAX_SUM:
				setWheelVelocityPIDmaxSum(WHEEL_VELOCITY_PI_DMAX_SUM_EDEFAULT);
				return;
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_VELOCITY_PI_DMAX_VAL:
				setWheelVelocityPIDmaxVal(WHEEL_VELOCITY_PI_DMAX_VAL_EDEFAULT);
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
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_RADIUS:
				return wheelRadius != WHEEL_RADIUS_EDEFAULT;
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_WIDTH:
				return wheelWidth != WHEEL_WIDTH_EDEFAULT;
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__SUSPENSION_REST_LENGTH:
				return suspensionRestLength != SUSPENSION_REST_LENGTH_EDEFAULT;
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_CONNECTION_HEIGHT:
				return wheelConnectionHeight != WHEEL_CONNECTION_HEIGHT_EDEFAULT;
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__TYPE_OF_WHEEL:
				return TYPE_OF_WHEEL_EDEFAULT == null ? typeOfWheel != null : !TYPE_OF_WHEEL_EDEFAULT.equals(typeOfWheel);
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_VELOCITY_PI_DKP:
				return wheelVelocityPIDkp != WHEEL_VELOCITY_PI_DKP_EDEFAULT;
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_VELOCITY_PI_DKI:
				return wheelVelocityPIDki != WHEEL_VELOCITY_PI_DKI_EDEFAULT;
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_VELOCITY_PI_DKD:
				return wheelVelocityPIDkd != WHEEL_VELOCITY_PI_DKD_EDEFAULT;
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_STEERING_PI_DKP:
				return wheelSteeringPIDkp != WHEEL_STEERING_PI_DKP_EDEFAULT;
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_STEERING_PI_DKD:
				return wheelSteeringPIDkd != WHEEL_STEERING_PI_DKD_EDEFAULT;
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_FRICTION:
				return wheelFriction != WHEEL_FRICTION_EDEFAULT;
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__SUSPENSION_STIFFNESS:
				return suspensionStiffness != SUSPENSION_STIFFNESS_EDEFAULT;
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__SUSPENSION_DAMPING:
				return suspensionDamping != SUSPENSION_DAMPING_EDEFAULT;
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__SUSPENSION_COMPRESSION:
				return suspensionCompression != SUSPENSION_COMPRESSION_EDEFAULT;
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_VELOCITY_PI_DMAX_SUM:
				return wheelVelocityPIDmaxSum != WHEEL_VELOCITY_PI_DMAX_SUM_EDEFAULT;
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_VELOCITY_PI_DMAX_VAL:
				return wheelVelocityPIDmaxVal != WHEEL_VELOCITY_PI_DMAX_VAL_EDEFAULT;
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
		result.append(" (wheelRadius: ");
		result.append(wheelRadius);
		result.append(", wheelWidth: ");
		result.append(wheelWidth);
		result.append(", suspensionRestLength: ");
		result.append(suspensionRestLength);
		result.append(", wheelConnectionHeight: ");
		result.append(wheelConnectionHeight);
		result.append(", typeOfWheel: ");
		result.append(typeOfWheel);
		result.append(", wheelVelocityPIDkp: ");
		result.append(wheelVelocityPIDkp);
		result.append(", wheelVelocityPIDki: ");
		result.append(wheelVelocityPIDki);
		result.append(", wheelVelocityPIDkd: ");
		result.append(wheelVelocityPIDkd);
		result.append(", wheelSteeringPIDkp: ");
		result.append(wheelSteeringPIDkp);
		result.append(", wheelSteeringPIDkd: ");
		result.append(wheelSteeringPIDkd);
		result.append(", wheelFriction: ");
		result.append(wheelFriction);
		result.append(", suspensionStiffness: ");
		result.append(suspensionStiffness);
		result.append(", suspensionDamping: ");
		result.append(suspensionDamping);
		result.append(", suspensionCompression: ");
		result.append(suspensionCompression);
		result.append(", wheelVelocityPIDmaxSum: ");
		result.append(wheelVelocityPIDmaxSum);
		result.append(", wheelVelocityPIDmaxVal: ");
		result.append(wheelVelocityPIDmaxVal);
		result.append(')');
		return result.toString();
	}

} //SteeredWheelSystemImpl
