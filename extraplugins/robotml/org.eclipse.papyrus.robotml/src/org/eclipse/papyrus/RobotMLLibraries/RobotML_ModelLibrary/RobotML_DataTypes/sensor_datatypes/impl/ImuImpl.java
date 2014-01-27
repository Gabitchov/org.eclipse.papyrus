/**
 */
package org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.Quaternion;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.Vector3;

import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.Imu;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.Sensor_datatypesPackage;

import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Header;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Imu</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.ImuImpl#getHeader <em>Header</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.ImuImpl#getOrientation <em>Orientation</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.ImuImpl#getOrientation_covariance <em>Orientation covariance</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.ImuImpl#getAngular_velocity <em>Angular velocity</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.ImuImpl#getAngular_velocity_covariance <em>Angular velocity covariance</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.ImuImpl#getLinear_acceleration <em>Linear acceleration</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.ImuImpl#getLinear_acceleration_covariance <em>Linear acceleration covariance</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ImuImpl extends MinimalEObjectImpl.Container implements Imu {
	/**
	 * The cached value of the '{@link #getHeader() <em>Header</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeader()
	 * @generated
	 * @ordered
	 */
	protected Header header;

	/**
	 * The cached value of the '{@link #getOrientation() <em>Orientation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrientation()
	 * @generated
	 * @ordered
	 */
	protected Quaternion orientation;

	/**
	 * The cached value of the '{@link #getOrientation_covariance() <em>Orientation covariance</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrientation_covariance()
	 * @generated
	 * @ordered
	 */
	protected EList<Double> orientation_covariance;

	/**
	 * The cached value of the '{@link #getAngular_velocity() <em>Angular velocity</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAngular_velocity()
	 * @generated
	 * @ordered
	 */
	protected Vector3 angular_velocity;

	/**
	 * The cached value of the '{@link #getAngular_velocity_covariance() <em>Angular velocity covariance</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAngular_velocity_covariance()
	 * @generated
	 * @ordered
	 */
	protected EList<Double> angular_velocity_covariance;

	/**
	 * The cached value of the '{@link #getLinear_acceleration() <em>Linear acceleration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinear_acceleration()
	 * @generated
	 * @ordered
	 */
	protected Vector3 linear_acceleration;

	/**
	 * The cached value of the '{@link #getLinear_acceleration_covariance() <em>Linear acceleration covariance</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinear_acceleration_covariance()
	 * @generated
	 * @ordered
	 */
	protected EList<Double> linear_acceleration_covariance;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ImuImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Sensor_datatypesPackage.Literals.IMU;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Header getHeader() {
		return header;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetHeader(Header newHeader, NotificationChain msgs) {
		Header oldHeader = header;
		header = newHeader;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.IMU__HEADER, oldHeader, newHeader);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeader(Header newHeader) {
		if (newHeader != header) {
			NotificationChain msgs = null;
			if (header != null)
				msgs = ((InternalEObject)header).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Sensor_datatypesPackage.IMU__HEADER, null, msgs);
			if (newHeader != null)
				msgs = ((InternalEObject)newHeader).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Sensor_datatypesPackage.IMU__HEADER, null, msgs);
			msgs = basicSetHeader(newHeader, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.IMU__HEADER, newHeader, newHeader));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Quaternion getOrientation() {
		return orientation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOrientation(Quaternion newOrientation, NotificationChain msgs) {
		Quaternion oldOrientation = orientation;
		orientation = newOrientation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.IMU__ORIENTATION, oldOrientation, newOrientation);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOrientation(Quaternion newOrientation) {
		if (newOrientation != orientation) {
			NotificationChain msgs = null;
			if (orientation != null)
				msgs = ((InternalEObject)orientation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Sensor_datatypesPackage.IMU__ORIENTATION, null, msgs);
			if (newOrientation != null)
				msgs = ((InternalEObject)newOrientation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Sensor_datatypesPackage.IMU__ORIENTATION, null, msgs);
			msgs = basicSetOrientation(newOrientation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.IMU__ORIENTATION, newOrientation, newOrientation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Double> getOrientation_covariance() {
		if (orientation_covariance == null) {
			orientation_covariance = new EDataTypeUniqueEList<Double>(Double.class, this, Sensor_datatypesPackage.IMU__ORIENTATION_COVARIANCE);
		}
		return orientation_covariance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vector3 getAngular_velocity() {
		return angular_velocity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAngular_velocity(Vector3 newAngular_velocity, NotificationChain msgs) {
		Vector3 oldAngular_velocity = angular_velocity;
		angular_velocity = newAngular_velocity;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.IMU__ANGULAR_VELOCITY, oldAngular_velocity, newAngular_velocity);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAngular_velocity(Vector3 newAngular_velocity) {
		if (newAngular_velocity != angular_velocity) {
			NotificationChain msgs = null;
			if (angular_velocity != null)
				msgs = ((InternalEObject)angular_velocity).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Sensor_datatypesPackage.IMU__ANGULAR_VELOCITY, null, msgs);
			if (newAngular_velocity != null)
				msgs = ((InternalEObject)newAngular_velocity).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Sensor_datatypesPackage.IMU__ANGULAR_VELOCITY, null, msgs);
			msgs = basicSetAngular_velocity(newAngular_velocity, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.IMU__ANGULAR_VELOCITY, newAngular_velocity, newAngular_velocity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Double> getAngular_velocity_covariance() {
		if (angular_velocity_covariance == null) {
			angular_velocity_covariance = new EDataTypeUniqueEList<Double>(Double.class, this, Sensor_datatypesPackage.IMU__ANGULAR_VELOCITY_COVARIANCE);
		}
		return angular_velocity_covariance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vector3 getLinear_acceleration() {
		return linear_acceleration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLinear_acceleration(Vector3 newLinear_acceleration, NotificationChain msgs) {
		Vector3 oldLinear_acceleration = linear_acceleration;
		linear_acceleration = newLinear_acceleration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.IMU__LINEAR_ACCELERATION, oldLinear_acceleration, newLinear_acceleration);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinear_acceleration(Vector3 newLinear_acceleration) {
		if (newLinear_acceleration != linear_acceleration) {
			NotificationChain msgs = null;
			if (linear_acceleration != null)
				msgs = ((InternalEObject)linear_acceleration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Sensor_datatypesPackage.IMU__LINEAR_ACCELERATION, null, msgs);
			if (newLinear_acceleration != null)
				msgs = ((InternalEObject)newLinear_acceleration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Sensor_datatypesPackage.IMU__LINEAR_ACCELERATION, null, msgs);
			msgs = basicSetLinear_acceleration(newLinear_acceleration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.IMU__LINEAR_ACCELERATION, newLinear_acceleration, newLinear_acceleration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Double> getLinear_acceleration_covariance() {
		if (linear_acceleration_covariance == null) {
			linear_acceleration_covariance = new EDataTypeUniqueEList<Double>(Double.class, this, Sensor_datatypesPackage.IMU__LINEAR_ACCELERATION_COVARIANCE);
		}
		return linear_acceleration_covariance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Sensor_datatypesPackage.IMU__HEADER:
				return basicSetHeader(null, msgs);
			case Sensor_datatypesPackage.IMU__ORIENTATION:
				return basicSetOrientation(null, msgs);
			case Sensor_datatypesPackage.IMU__ANGULAR_VELOCITY:
				return basicSetAngular_velocity(null, msgs);
			case Sensor_datatypesPackage.IMU__LINEAR_ACCELERATION:
				return basicSetLinear_acceleration(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Sensor_datatypesPackage.IMU__HEADER:
				return getHeader();
			case Sensor_datatypesPackage.IMU__ORIENTATION:
				return getOrientation();
			case Sensor_datatypesPackage.IMU__ORIENTATION_COVARIANCE:
				return getOrientation_covariance();
			case Sensor_datatypesPackage.IMU__ANGULAR_VELOCITY:
				return getAngular_velocity();
			case Sensor_datatypesPackage.IMU__ANGULAR_VELOCITY_COVARIANCE:
				return getAngular_velocity_covariance();
			case Sensor_datatypesPackage.IMU__LINEAR_ACCELERATION:
				return getLinear_acceleration();
			case Sensor_datatypesPackage.IMU__LINEAR_ACCELERATION_COVARIANCE:
				return getLinear_acceleration_covariance();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case Sensor_datatypesPackage.IMU__HEADER:
				setHeader((Header)newValue);
				return;
			case Sensor_datatypesPackage.IMU__ORIENTATION:
				setOrientation((Quaternion)newValue);
				return;
			case Sensor_datatypesPackage.IMU__ORIENTATION_COVARIANCE:
				getOrientation_covariance().clear();
				getOrientation_covariance().addAll((Collection<? extends Double>)newValue);
				return;
			case Sensor_datatypesPackage.IMU__ANGULAR_VELOCITY:
				setAngular_velocity((Vector3)newValue);
				return;
			case Sensor_datatypesPackage.IMU__ANGULAR_VELOCITY_COVARIANCE:
				getAngular_velocity_covariance().clear();
				getAngular_velocity_covariance().addAll((Collection<? extends Double>)newValue);
				return;
			case Sensor_datatypesPackage.IMU__LINEAR_ACCELERATION:
				setLinear_acceleration((Vector3)newValue);
				return;
			case Sensor_datatypesPackage.IMU__LINEAR_ACCELERATION_COVARIANCE:
				getLinear_acceleration_covariance().clear();
				getLinear_acceleration_covariance().addAll((Collection<? extends Double>)newValue);
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
			case Sensor_datatypesPackage.IMU__HEADER:
				setHeader((Header)null);
				return;
			case Sensor_datatypesPackage.IMU__ORIENTATION:
				setOrientation((Quaternion)null);
				return;
			case Sensor_datatypesPackage.IMU__ORIENTATION_COVARIANCE:
				getOrientation_covariance().clear();
				return;
			case Sensor_datatypesPackage.IMU__ANGULAR_VELOCITY:
				setAngular_velocity((Vector3)null);
				return;
			case Sensor_datatypesPackage.IMU__ANGULAR_VELOCITY_COVARIANCE:
				getAngular_velocity_covariance().clear();
				return;
			case Sensor_datatypesPackage.IMU__LINEAR_ACCELERATION:
				setLinear_acceleration((Vector3)null);
				return;
			case Sensor_datatypesPackage.IMU__LINEAR_ACCELERATION_COVARIANCE:
				getLinear_acceleration_covariance().clear();
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
			case Sensor_datatypesPackage.IMU__HEADER:
				return header != null;
			case Sensor_datatypesPackage.IMU__ORIENTATION:
				return orientation != null;
			case Sensor_datatypesPackage.IMU__ORIENTATION_COVARIANCE:
				return orientation_covariance != null && !orientation_covariance.isEmpty();
			case Sensor_datatypesPackage.IMU__ANGULAR_VELOCITY:
				return angular_velocity != null;
			case Sensor_datatypesPackage.IMU__ANGULAR_VELOCITY_COVARIANCE:
				return angular_velocity_covariance != null && !angular_velocity_covariance.isEmpty();
			case Sensor_datatypesPackage.IMU__LINEAR_ACCELERATION:
				return linear_acceleration != null;
			case Sensor_datatypesPackage.IMU__LINEAR_ACCELERATION_COVARIANCE:
				return linear_acceleration_covariance != null && !linear_acceleration_covariance.isEmpty();
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
		result.append(" (orientation_covariance: ");
		result.append(orientation_covariance);
		result.append(", angular_velocity_covariance: ");
		result.append(angular_velocity_covariance);
		result.append(", linear_acceleration_covariance: ");
		result.append(linear_acceleration_covariance);
		result.append(')');
		return result.toString();
	}

} //ImuImpl
