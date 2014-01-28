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

import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.LaserScan;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.Sensor_datatypesPackage;

import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Header;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Laser Scan</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.LaserScanImpl#getHeader <em>Header</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.LaserScanImpl#getAngle_min <em>Angle min</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.LaserScanImpl#getAngle_max <em>Angle max</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.LaserScanImpl#getAngle_increment <em>Angle increment</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.LaserScanImpl#getTime_increment <em>Time increment</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.LaserScanImpl#getScan_time <em>Scan time</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.LaserScanImpl#getRange_min <em>Range min</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.LaserScanImpl#getRange_max <em>Range max</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.LaserScanImpl#getRange <em>Range</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.LaserScanImpl#getIntensities <em>Intensities</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LaserScanImpl extends MinimalEObjectImpl.Container implements LaserScan {
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
	 * The default value of the '{@link #getAngle_min() <em>Angle min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAngle_min()
	 * @generated
	 * @ordered
	 */
	protected static final float ANGLE_MIN_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getAngle_min() <em>Angle min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAngle_min()
	 * @generated
	 * @ordered
	 */
	protected float angle_min = ANGLE_MIN_EDEFAULT;

	/**
	 * The default value of the '{@link #getAngle_max() <em>Angle max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAngle_max()
	 * @generated
	 * @ordered
	 */
	protected static final float ANGLE_MAX_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getAngle_max() <em>Angle max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAngle_max()
	 * @generated
	 * @ordered
	 */
	protected float angle_max = ANGLE_MAX_EDEFAULT;

	/**
	 * The default value of the '{@link #getAngle_increment() <em>Angle increment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAngle_increment()
	 * @generated
	 * @ordered
	 */
	protected static final float ANGLE_INCREMENT_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getAngle_increment() <em>Angle increment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAngle_increment()
	 * @generated
	 * @ordered
	 */
	protected float angle_increment = ANGLE_INCREMENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getTime_increment() <em>Time increment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTime_increment()
	 * @generated
	 * @ordered
	 */
	protected static final float TIME_INCREMENT_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getTime_increment() <em>Time increment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTime_increment()
	 * @generated
	 * @ordered
	 */
	protected float time_increment = TIME_INCREMENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getScan_time() <em>Scan time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScan_time()
	 * @generated
	 * @ordered
	 */
	protected static final float SCAN_TIME_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getScan_time() <em>Scan time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScan_time()
	 * @generated
	 * @ordered
	 */
	protected float scan_time = SCAN_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getRange_min() <em>Range min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRange_min()
	 * @generated
	 * @ordered
	 */
	protected static final float RANGE_MIN_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getRange_min() <em>Range min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRange_min()
	 * @generated
	 * @ordered
	 */
	protected float range_min = RANGE_MIN_EDEFAULT;

	/**
	 * The default value of the '{@link #getRange_max() <em>Range max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRange_max()
	 * @generated
	 * @ordered
	 */
	protected static final float RANGE_MAX_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getRange_max() <em>Range max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRange_max()
	 * @generated
	 * @ordered
	 */
	protected float range_max = RANGE_MAX_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRange() <em>Range</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRange()
	 * @generated
	 * @ordered
	 */
	protected EList<Float> range;

	/**
	 * The cached value of the '{@link #getIntensities() <em>Intensities</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntensities()
	 * @generated
	 * @ordered
	 */
	protected EList<Float> intensities;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LaserScanImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Sensor_datatypesPackage.Literals.LASER_SCAN;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.LASER_SCAN__HEADER, oldHeader, newHeader);
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
				msgs = ((InternalEObject)header).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Sensor_datatypesPackage.LASER_SCAN__HEADER, null, msgs);
			if (newHeader != null)
				msgs = ((InternalEObject)newHeader).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Sensor_datatypesPackage.LASER_SCAN__HEADER, null, msgs);
			msgs = basicSetHeader(newHeader, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.LASER_SCAN__HEADER, newHeader, newHeader));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getAngle_min() {
		return angle_min;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAngle_min(float newAngle_min) {
		float oldAngle_min = angle_min;
		angle_min = newAngle_min;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.LASER_SCAN__ANGLE_MIN, oldAngle_min, angle_min));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getAngle_max() {
		return angle_max;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAngle_max(float newAngle_max) {
		float oldAngle_max = angle_max;
		angle_max = newAngle_max;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.LASER_SCAN__ANGLE_MAX, oldAngle_max, angle_max));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getAngle_increment() {
		return angle_increment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAngle_increment(float newAngle_increment) {
		float oldAngle_increment = angle_increment;
		angle_increment = newAngle_increment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.LASER_SCAN__ANGLE_INCREMENT, oldAngle_increment, angle_increment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getTime_increment() {
		return time_increment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTime_increment(float newTime_increment) {
		float oldTime_increment = time_increment;
		time_increment = newTime_increment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.LASER_SCAN__TIME_INCREMENT, oldTime_increment, time_increment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getScan_time() {
		return scan_time;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScan_time(float newScan_time) {
		float oldScan_time = scan_time;
		scan_time = newScan_time;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.LASER_SCAN__SCAN_TIME, oldScan_time, scan_time));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getRange_min() {
		return range_min;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRange_min(float newRange_min) {
		float oldRange_min = range_min;
		range_min = newRange_min;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.LASER_SCAN__RANGE_MIN, oldRange_min, range_min));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getRange_max() {
		return range_max;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRange_max(float newRange_max) {
		float oldRange_max = range_max;
		range_max = newRange_max;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.LASER_SCAN__RANGE_MAX, oldRange_max, range_max));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Float> getRange() {
		if (range == null) {
			range = new EDataTypeUniqueEList<Float>(Float.class, this, Sensor_datatypesPackage.LASER_SCAN__RANGE);
		}
		return range;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Float> getIntensities() {
		if (intensities == null) {
			intensities = new EDataTypeUniqueEList<Float>(Float.class, this, Sensor_datatypesPackage.LASER_SCAN__INTENSITIES);
		}
		return intensities;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Sensor_datatypesPackage.LASER_SCAN__HEADER:
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
			case Sensor_datatypesPackage.LASER_SCAN__HEADER:
				return getHeader();
			case Sensor_datatypesPackage.LASER_SCAN__ANGLE_MIN:
				return getAngle_min();
			case Sensor_datatypesPackage.LASER_SCAN__ANGLE_MAX:
				return getAngle_max();
			case Sensor_datatypesPackage.LASER_SCAN__ANGLE_INCREMENT:
				return getAngle_increment();
			case Sensor_datatypesPackage.LASER_SCAN__TIME_INCREMENT:
				return getTime_increment();
			case Sensor_datatypesPackage.LASER_SCAN__SCAN_TIME:
				return getScan_time();
			case Sensor_datatypesPackage.LASER_SCAN__RANGE_MIN:
				return getRange_min();
			case Sensor_datatypesPackage.LASER_SCAN__RANGE_MAX:
				return getRange_max();
			case Sensor_datatypesPackage.LASER_SCAN__RANGE:
				return getRange();
			case Sensor_datatypesPackage.LASER_SCAN__INTENSITIES:
				return getIntensities();
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
			case Sensor_datatypesPackage.LASER_SCAN__HEADER:
				setHeader((Header)newValue);
				return;
			case Sensor_datatypesPackage.LASER_SCAN__ANGLE_MIN:
				setAngle_min((Float)newValue);
				return;
			case Sensor_datatypesPackage.LASER_SCAN__ANGLE_MAX:
				setAngle_max((Float)newValue);
				return;
			case Sensor_datatypesPackage.LASER_SCAN__ANGLE_INCREMENT:
				setAngle_increment((Float)newValue);
				return;
			case Sensor_datatypesPackage.LASER_SCAN__TIME_INCREMENT:
				setTime_increment((Float)newValue);
				return;
			case Sensor_datatypesPackage.LASER_SCAN__SCAN_TIME:
				setScan_time((Float)newValue);
				return;
			case Sensor_datatypesPackage.LASER_SCAN__RANGE_MIN:
				setRange_min((Float)newValue);
				return;
			case Sensor_datatypesPackage.LASER_SCAN__RANGE_MAX:
				setRange_max((Float)newValue);
				return;
			case Sensor_datatypesPackage.LASER_SCAN__RANGE:
				getRange().clear();
				getRange().addAll((Collection<? extends Float>)newValue);
				return;
			case Sensor_datatypesPackage.LASER_SCAN__INTENSITIES:
				getIntensities().clear();
				getIntensities().addAll((Collection<? extends Float>)newValue);
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
			case Sensor_datatypesPackage.LASER_SCAN__HEADER:
				setHeader((Header)null);
				return;
			case Sensor_datatypesPackage.LASER_SCAN__ANGLE_MIN:
				setAngle_min(ANGLE_MIN_EDEFAULT);
				return;
			case Sensor_datatypesPackage.LASER_SCAN__ANGLE_MAX:
				setAngle_max(ANGLE_MAX_EDEFAULT);
				return;
			case Sensor_datatypesPackage.LASER_SCAN__ANGLE_INCREMENT:
				setAngle_increment(ANGLE_INCREMENT_EDEFAULT);
				return;
			case Sensor_datatypesPackage.LASER_SCAN__TIME_INCREMENT:
				setTime_increment(TIME_INCREMENT_EDEFAULT);
				return;
			case Sensor_datatypesPackage.LASER_SCAN__SCAN_TIME:
				setScan_time(SCAN_TIME_EDEFAULT);
				return;
			case Sensor_datatypesPackage.LASER_SCAN__RANGE_MIN:
				setRange_min(RANGE_MIN_EDEFAULT);
				return;
			case Sensor_datatypesPackage.LASER_SCAN__RANGE_MAX:
				setRange_max(RANGE_MAX_EDEFAULT);
				return;
			case Sensor_datatypesPackage.LASER_SCAN__RANGE:
				getRange().clear();
				return;
			case Sensor_datatypesPackage.LASER_SCAN__INTENSITIES:
				getIntensities().clear();
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
			case Sensor_datatypesPackage.LASER_SCAN__HEADER:
				return header != null;
			case Sensor_datatypesPackage.LASER_SCAN__ANGLE_MIN:
				return angle_min != ANGLE_MIN_EDEFAULT;
			case Sensor_datatypesPackage.LASER_SCAN__ANGLE_MAX:
				return angle_max != ANGLE_MAX_EDEFAULT;
			case Sensor_datatypesPackage.LASER_SCAN__ANGLE_INCREMENT:
				return angle_increment != ANGLE_INCREMENT_EDEFAULT;
			case Sensor_datatypesPackage.LASER_SCAN__TIME_INCREMENT:
				return time_increment != TIME_INCREMENT_EDEFAULT;
			case Sensor_datatypesPackage.LASER_SCAN__SCAN_TIME:
				return scan_time != SCAN_TIME_EDEFAULT;
			case Sensor_datatypesPackage.LASER_SCAN__RANGE_MIN:
				return range_min != RANGE_MIN_EDEFAULT;
			case Sensor_datatypesPackage.LASER_SCAN__RANGE_MAX:
				return range_max != RANGE_MAX_EDEFAULT;
			case Sensor_datatypesPackage.LASER_SCAN__RANGE:
				return range != null && !range.isEmpty();
			case Sensor_datatypesPackage.LASER_SCAN__INTENSITIES:
				return intensities != null && !intensities.isEmpty();
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
		result.append(" (angle_min: ");
		result.append(angle_min);
		result.append(", angle_max: ");
		result.append(angle_max);
		result.append(", angle_increment: ");
		result.append(angle_increment);
		result.append(", time_increment: ");
		result.append(time_increment);
		result.append(", scan_time: ");
		result.append(scan_time);
		result.append(", range_min: ");
		result.append(range_min);
		result.append(", range_max: ");
		result.append(range_max);
		result.append(", range: ");
		result.append(range);
		result.append(", intensities: ");
		result.append(intensities);
		result.append(')');
		return result.toString();
	}

} //LaserScanImpl
