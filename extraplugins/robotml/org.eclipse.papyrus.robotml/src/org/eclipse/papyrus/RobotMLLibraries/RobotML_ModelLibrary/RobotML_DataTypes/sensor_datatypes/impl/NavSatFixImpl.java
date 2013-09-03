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

import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.COVARIANCE_TYPE;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.NavSatFix;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.SERVICE_TYPE;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.STATUS_TYPE;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.Sensor_datatypesPackage;

import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Header;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Nav Sat Fix</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.NavSatFixImpl#getStatus <em>Status</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.NavSatFixImpl#getService <em>Service</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.NavSatFixImpl#getHeader <em>Header</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.NavSatFixImpl#getLatitude <em>Latitude</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.NavSatFixImpl#getLongitude <em>Longitude</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.NavSatFixImpl#getAltitude <em>Altitude</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.NavSatFixImpl#getPosition_covariance <em>Position covariance</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.NavSatFixImpl#getPosition_covariance_type <em>Position covariance type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NavSatFixImpl extends MinimalEObjectImpl.Container implements NavSatFix {
	/**
	 * The default value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected static final STATUS_TYPE STATUS_EDEFAULT = STATUS_TYPE.STATUS_NO_FIX;

	/**
	 * The cached value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected STATUS_TYPE status = STATUS_EDEFAULT;

	/**
	 * The default value of the '{@link #getService() <em>Service</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getService()
	 * @generated
	 * @ordered
	 */
	protected static final SERVICE_TYPE SERVICE_EDEFAULT = SERVICE_TYPE.SERVICE_GPS;

	/**
	 * The cached value of the '{@link #getService() <em>Service</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getService()
	 * @generated
	 * @ordered
	 */
	protected SERVICE_TYPE service = SERVICE_EDEFAULT;

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
	 * The default value of the '{@link #getLatitude() <em>Latitude</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLatitude()
	 * @generated
	 * @ordered
	 */
	protected static final double LATITUDE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getLatitude() <em>Latitude</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLatitude()
	 * @generated
	 * @ordered
	 */
	protected double latitude = LATITUDE_EDEFAULT;

	/**
	 * The default value of the '{@link #getLongitude() <em>Longitude</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLongitude()
	 * @generated
	 * @ordered
	 */
	protected static final double LONGITUDE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getLongitude() <em>Longitude</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLongitude()
	 * @generated
	 * @ordered
	 */
	protected double longitude = LONGITUDE_EDEFAULT;

	/**
	 * The default value of the '{@link #getAltitude() <em>Altitude</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAltitude()
	 * @generated
	 * @ordered
	 */
	protected static final double ALTITUDE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getAltitude() <em>Altitude</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAltitude()
	 * @generated
	 * @ordered
	 */
	protected double altitude = ALTITUDE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPosition_covariance() <em>Position covariance</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPosition_covariance()
	 * @generated
	 * @ordered
	 */
	protected EList<Double> position_covariance;

	/**
	 * The default value of the '{@link #getPosition_covariance_type() <em>Position covariance type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPosition_covariance_type()
	 * @generated
	 * @ordered
	 */
	protected static final COVARIANCE_TYPE POSITION_COVARIANCE_TYPE_EDEFAULT = COVARIANCE_TYPE.COVARIANCE_TYPE_UNKNOWN;

	/**
	 * The cached value of the '{@link #getPosition_covariance_type() <em>Position covariance type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPosition_covariance_type()
	 * @generated
	 * @ordered
	 */
	protected COVARIANCE_TYPE position_covariance_type = POSITION_COVARIANCE_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NavSatFixImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Sensor_datatypesPackage.Literals.NAV_SAT_FIX;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public STATUS_TYPE getStatus() {
		return status;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatus(STATUS_TYPE newStatus) {
		STATUS_TYPE oldStatus = status;
		status = newStatus == null ? STATUS_EDEFAULT : newStatus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.NAV_SAT_FIX__STATUS, oldStatus, status));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SERVICE_TYPE getService() {
		return service;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setService(SERVICE_TYPE newService) {
		SERVICE_TYPE oldService = service;
		service = newService == null ? SERVICE_EDEFAULT : newService;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.NAV_SAT_FIX__SERVICE, oldService, service));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.NAV_SAT_FIX__HEADER, oldHeader, newHeader);
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
				msgs = ((InternalEObject)header).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Sensor_datatypesPackage.NAV_SAT_FIX__HEADER, null, msgs);
			if (newHeader != null)
				msgs = ((InternalEObject)newHeader).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Sensor_datatypesPackage.NAV_SAT_FIX__HEADER, null, msgs);
			msgs = basicSetHeader(newHeader, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.NAV_SAT_FIX__HEADER, newHeader, newHeader));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLatitude(double newLatitude) {
		double oldLatitude = latitude;
		latitude = newLatitude;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.NAV_SAT_FIX__LATITUDE, oldLatitude, latitude));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLongitude(double newLongitude) {
		double oldLongitude = longitude;
		longitude = newLongitude;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.NAV_SAT_FIX__LONGITUDE, oldLongitude, longitude));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getAltitude() {
		return altitude;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAltitude(double newAltitude) {
		double oldAltitude = altitude;
		altitude = newAltitude;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.NAV_SAT_FIX__ALTITUDE, oldAltitude, altitude));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Double> getPosition_covariance() {
		if (position_covariance == null) {
			position_covariance = new EDataTypeUniqueEList<Double>(Double.class, this, Sensor_datatypesPackage.NAV_SAT_FIX__POSITION_COVARIANCE);
		}
		return position_covariance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public COVARIANCE_TYPE getPosition_covariance_type() {
		return position_covariance_type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPosition_covariance_type(COVARIANCE_TYPE newPosition_covariance_type) {
		COVARIANCE_TYPE oldPosition_covariance_type = position_covariance_type;
		position_covariance_type = newPosition_covariance_type == null ? POSITION_COVARIANCE_TYPE_EDEFAULT : newPosition_covariance_type;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.NAV_SAT_FIX__POSITION_COVARIANCE_TYPE, oldPosition_covariance_type, position_covariance_type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Sensor_datatypesPackage.NAV_SAT_FIX__HEADER:
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
			case Sensor_datatypesPackage.NAV_SAT_FIX__STATUS:
				return getStatus();
			case Sensor_datatypesPackage.NAV_SAT_FIX__SERVICE:
				return getService();
			case Sensor_datatypesPackage.NAV_SAT_FIX__HEADER:
				return getHeader();
			case Sensor_datatypesPackage.NAV_SAT_FIX__LATITUDE:
				return getLatitude();
			case Sensor_datatypesPackage.NAV_SAT_FIX__LONGITUDE:
				return getLongitude();
			case Sensor_datatypesPackage.NAV_SAT_FIX__ALTITUDE:
				return getAltitude();
			case Sensor_datatypesPackage.NAV_SAT_FIX__POSITION_COVARIANCE:
				return getPosition_covariance();
			case Sensor_datatypesPackage.NAV_SAT_FIX__POSITION_COVARIANCE_TYPE:
				return getPosition_covariance_type();
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
			case Sensor_datatypesPackage.NAV_SAT_FIX__STATUS:
				setStatus((STATUS_TYPE)newValue);
				return;
			case Sensor_datatypesPackage.NAV_SAT_FIX__SERVICE:
				setService((SERVICE_TYPE)newValue);
				return;
			case Sensor_datatypesPackage.NAV_SAT_FIX__HEADER:
				setHeader((Header)newValue);
				return;
			case Sensor_datatypesPackage.NAV_SAT_FIX__LATITUDE:
				setLatitude((Double)newValue);
				return;
			case Sensor_datatypesPackage.NAV_SAT_FIX__LONGITUDE:
				setLongitude((Double)newValue);
				return;
			case Sensor_datatypesPackage.NAV_SAT_FIX__ALTITUDE:
				setAltitude((Double)newValue);
				return;
			case Sensor_datatypesPackage.NAV_SAT_FIX__POSITION_COVARIANCE:
				getPosition_covariance().clear();
				getPosition_covariance().addAll((Collection<? extends Double>)newValue);
				return;
			case Sensor_datatypesPackage.NAV_SAT_FIX__POSITION_COVARIANCE_TYPE:
				setPosition_covariance_type((COVARIANCE_TYPE)newValue);
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
			case Sensor_datatypesPackage.NAV_SAT_FIX__STATUS:
				setStatus(STATUS_EDEFAULT);
				return;
			case Sensor_datatypesPackage.NAV_SAT_FIX__SERVICE:
				setService(SERVICE_EDEFAULT);
				return;
			case Sensor_datatypesPackage.NAV_SAT_FIX__HEADER:
				setHeader((Header)null);
				return;
			case Sensor_datatypesPackage.NAV_SAT_FIX__LATITUDE:
				setLatitude(LATITUDE_EDEFAULT);
				return;
			case Sensor_datatypesPackage.NAV_SAT_FIX__LONGITUDE:
				setLongitude(LONGITUDE_EDEFAULT);
				return;
			case Sensor_datatypesPackage.NAV_SAT_FIX__ALTITUDE:
				setAltitude(ALTITUDE_EDEFAULT);
				return;
			case Sensor_datatypesPackage.NAV_SAT_FIX__POSITION_COVARIANCE:
				getPosition_covariance().clear();
				return;
			case Sensor_datatypesPackage.NAV_SAT_FIX__POSITION_COVARIANCE_TYPE:
				setPosition_covariance_type(POSITION_COVARIANCE_TYPE_EDEFAULT);
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
			case Sensor_datatypesPackage.NAV_SAT_FIX__STATUS:
				return status != STATUS_EDEFAULT;
			case Sensor_datatypesPackage.NAV_SAT_FIX__SERVICE:
				return service != SERVICE_EDEFAULT;
			case Sensor_datatypesPackage.NAV_SAT_FIX__HEADER:
				return header != null;
			case Sensor_datatypesPackage.NAV_SAT_FIX__LATITUDE:
				return latitude != LATITUDE_EDEFAULT;
			case Sensor_datatypesPackage.NAV_SAT_FIX__LONGITUDE:
				return longitude != LONGITUDE_EDEFAULT;
			case Sensor_datatypesPackage.NAV_SAT_FIX__ALTITUDE:
				return altitude != ALTITUDE_EDEFAULT;
			case Sensor_datatypesPackage.NAV_SAT_FIX__POSITION_COVARIANCE:
				return position_covariance != null && !position_covariance.isEmpty();
			case Sensor_datatypesPackage.NAV_SAT_FIX__POSITION_COVARIANCE_TYPE:
				return position_covariance_type != POSITION_COVARIANCE_TYPE_EDEFAULT;
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
		result.append(" (status: ");
		result.append(status);
		result.append(", service: ");
		result.append(service);
		result.append(", latitude: ");
		result.append(latitude);
		result.append(", longitude: ");
		result.append(longitude);
		result.append(", altitude: ");
		result.append(altitude);
		result.append(", position_covariance: ");
		result.append(position_covariance);
		result.append(", position_covariance_type: ");
		result.append(position_covariance_type);
		result.append(')');
		return result.toString();
	}

} //NavSatFixImpl
