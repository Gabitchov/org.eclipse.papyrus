/**
 */
package org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.DifferentialOdometry;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.Sensor_datatypesPackage;

import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Header;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Differential Odometry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.DifferentialOdometryImpl#getHeader <em>Header</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.DifferentialOdometryImpl#getRight_distance <em>Right distance</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.DifferentialOdometryImpl#getLeft_distance <em>Left distance</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.DifferentialOdometryImpl#getLeft_velocity <em>Left velocity</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.DifferentialOdometryImpl#getRight_velocity <em>Right velocity</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DifferentialOdometryImpl extends MinimalEObjectImpl.Container implements DifferentialOdometry {
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
	 * The default value of the '{@link #getRight_distance() <em>Right distance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRight_distance()
	 * @generated
	 * @ordered
	 */
	protected static final double RIGHT_DISTANCE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getRight_distance() <em>Right distance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRight_distance()
	 * @generated
	 * @ordered
	 */
	protected double right_distance = RIGHT_DISTANCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getLeft_distance() <em>Left distance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeft_distance()
	 * @generated
	 * @ordered
	 */
	protected static final double LEFT_DISTANCE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getLeft_distance() <em>Left distance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeft_distance()
	 * @generated
	 * @ordered
	 */
	protected double left_distance = LEFT_DISTANCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getLeft_velocity() <em>Left velocity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeft_velocity()
	 * @generated
	 * @ordered
	 */
	protected static final double LEFT_VELOCITY_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getLeft_velocity() <em>Left velocity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeft_velocity()
	 * @generated
	 * @ordered
	 */
	protected double left_velocity = LEFT_VELOCITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getRight_velocity() <em>Right velocity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRight_velocity()
	 * @generated
	 * @ordered
	 */
	protected static final double RIGHT_VELOCITY_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getRight_velocity() <em>Right velocity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRight_velocity()
	 * @generated
	 * @ordered
	 */
	protected double right_velocity = RIGHT_VELOCITY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DifferentialOdometryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Sensor_datatypesPackage.Literals.DIFFERENTIAL_ODOMETRY;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.DIFFERENTIAL_ODOMETRY__HEADER, oldHeader, newHeader);
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
				msgs = ((InternalEObject)header).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Sensor_datatypesPackage.DIFFERENTIAL_ODOMETRY__HEADER, null, msgs);
			if (newHeader != null)
				msgs = ((InternalEObject)newHeader).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Sensor_datatypesPackage.DIFFERENTIAL_ODOMETRY__HEADER, null, msgs);
			msgs = basicSetHeader(newHeader, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.DIFFERENTIAL_ODOMETRY__HEADER, newHeader, newHeader));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getRight_distance() {
		return right_distance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRight_distance(double newRight_distance) {
		double oldRight_distance = right_distance;
		right_distance = newRight_distance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.DIFFERENTIAL_ODOMETRY__RIGHT_DISTANCE, oldRight_distance, right_distance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getLeft_distance() {
		return left_distance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLeft_distance(double newLeft_distance) {
		double oldLeft_distance = left_distance;
		left_distance = newLeft_distance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.DIFFERENTIAL_ODOMETRY__LEFT_DISTANCE, oldLeft_distance, left_distance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getLeft_velocity() {
		return left_velocity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLeft_velocity(double newLeft_velocity) {
		double oldLeft_velocity = left_velocity;
		left_velocity = newLeft_velocity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.DIFFERENTIAL_ODOMETRY__LEFT_VELOCITY, oldLeft_velocity, left_velocity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getRight_velocity() {
		return right_velocity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRight_velocity(double newRight_velocity) {
		double oldRight_velocity = right_velocity;
		right_velocity = newRight_velocity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.DIFFERENTIAL_ODOMETRY__RIGHT_VELOCITY, oldRight_velocity, right_velocity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Sensor_datatypesPackage.DIFFERENTIAL_ODOMETRY__HEADER:
				return basicSetHeader(null, msgs);
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
			case Sensor_datatypesPackage.DIFFERENTIAL_ODOMETRY__HEADER:
				return getHeader();
			case Sensor_datatypesPackage.DIFFERENTIAL_ODOMETRY__RIGHT_DISTANCE:
				return getRight_distance();
			case Sensor_datatypesPackage.DIFFERENTIAL_ODOMETRY__LEFT_DISTANCE:
				return getLeft_distance();
			case Sensor_datatypesPackage.DIFFERENTIAL_ODOMETRY__LEFT_VELOCITY:
				return getLeft_velocity();
			case Sensor_datatypesPackage.DIFFERENTIAL_ODOMETRY__RIGHT_VELOCITY:
				return getRight_velocity();
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
			case Sensor_datatypesPackage.DIFFERENTIAL_ODOMETRY__HEADER:
				setHeader((Header)newValue);
				return;
			case Sensor_datatypesPackage.DIFFERENTIAL_ODOMETRY__RIGHT_DISTANCE:
				setRight_distance((Double)newValue);
				return;
			case Sensor_datatypesPackage.DIFFERENTIAL_ODOMETRY__LEFT_DISTANCE:
				setLeft_distance((Double)newValue);
				return;
			case Sensor_datatypesPackage.DIFFERENTIAL_ODOMETRY__LEFT_VELOCITY:
				setLeft_velocity((Double)newValue);
				return;
			case Sensor_datatypesPackage.DIFFERENTIAL_ODOMETRY__RIGHT_VELOCITY:
				setRight_velocity((Double)newValue);
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
			case Sensor_datatypesPackage.DIFFERENTIAL_ODOMETRY__HEADER:
				setHeader((Header)null);
				return;
			case Sensor_datatypesPackage.DIFFERENTIAL_ODOMETRY__RIGHT_DISTANCE:
				setRight_distance(RIGHT_DISTANCE_EDEFAULT);
				return;
			case Sensor_datatypesPackage.DIFFERENTIAL_ODOMETRY__LEFT_DISTANCE:
				setLeft_distance(LEFT_DISTANCE_EDEFAULT);
				return;
			case Sensor_datatypesPackage.DIFFERENTIAL_ODOMETRY__LEFT_VELOCITY:
				setLeft_velocity(LEFT_VELOCITY_EDEFAULT);
				return;
			case Sensor_datatypesPackage.DIFFERENTIAL_ODOMETRY__RIGHT_VELOCITY:
				setRight_velocity(RIGHT_VELOCITY_EDEFAULT);
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
			case Sensor_datatypesPackage.DIFFERENTIAL_ODOMETRY__HEADER:
				return header != null;
			case Sensor_datatypesPackage.DIFFERENTIAL_ODOMETRY__RIGHT_DISTANCE:
				return right_distance != RIGHT_DISTANCE_EDEFAULT;
			case Sensor_datatypesPackage.DIFFERENTIAL_ODOMETRY__LEFT_DISTANCE:
				return left_distance != LEFT_DISTANCE_EDEFAULT;
			case Sensor_datatypesPackage.DIFFERENTIAL_ODOMETRY__LEFT_VELOCITY:
				return left_velocity != LEFT_VELOCITY_EDEFAULT;
			case Sensor_datatypesPackage.DIFFERENTIAL_ODOMETRY__RIGHT_VELOCITY:
				return right_velocity != RIGHT_VELOCITY_EDEFAULT;
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
		result.append(" (right_distance: ");
		result.append(right_distance);
		result.append(", left_distance: ");
		result.append(left_distance);
		result.append(", left_velocity: ");
		result.append(left_velocity);
		result.append(", right_velocity: ");
		result.append(right_velocity);
		result.append(')');
		return result.toString();
	}

} //DifferentialOdometryImpl
