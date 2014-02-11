/**
 */
package org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.NavSatStatus;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.Sensor_datatypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Nav Sat Status</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.NavSatStatusImpl#getSTATUS_NO_FIX <em>STATUS NO FIX</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.NavSatStatusImpl#getSTATUS_FIX <em>STATUS FIX</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.NavSatStatusImpl#getSTATUS_SBAS_FIX <em>STATUS SBAS FIX</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.NavSatStatusImpl#getSTATUS_GBAS_FIX <em>STATUS GBAS FIX</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.NavSatStatusImpl#getStatus <em>Status</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.NavSatStatusImpl#getSERVICE_GPS <em>SERVICE GPS</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.NavSatStatusImpl#getSERVICE_GLONASS <em>SERVICE GLONASS</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.NavSatStatusImpl#getSERVICE_COMPASS <em>SERVICE COMPASS</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.NavSatStatusImpl#getSERVICE_GALILEO <em>SERVICE GALILEO</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.NavSatStatusImpl#getService <em>Service</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NavSatStatusImpl extends MinimalEObjectImpl.Container implements NavSatStatus {
	/**
	 * The default value of the '{@link #getSTATUS_NO_FIX() <em>STATUS NO FIX</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSTATUS_NO_FIX()
	 * @generated
	 * @ordered
	 */
	protected static final char STATUS_NO_FIX_EDEFAULT = '\uffff';

	/**
	 * The cached value of the '{@link #getSTATUS_NO_FIX() <em>STATUS NO FIX</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSTATUS_NO_FIX()
	 * @generated
	 * @ordered
	 */
	protected char statuS_NO_FIX = STATUS_NO_FIX_EDEFAULT;

	/**
	 * The default value of the '{@link #getSTATUS_FIX() <em>STATUS FIX</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSTATUS_FIX()
	 * @generated
	 * @ordered
	 */
	protected static final char STATUS_FIX_EDEFAULT = '\u0000';

	/**
	 * The cached value of the '{@link #getSTATUS_FIX() <em>STATUS FIX</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSTATUS_FIX()
	 * @generated
	 * @ordered
	 */
	protected char statuS_FIX = STATUS_FIX_EDEFAULT;

	/**
	 * The default value of the '{@link #getSTATUS_SBAS_FIX() <em>STATUS SBAS FIX</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSTATUS_SBAS_FIX()
	 * @generated
	 * @ordered
	 */
	protected static final char STATUS_SBAS_FIX_EDEFAULT = '\u0001';

	/**
	 * The cached value of the '{@link #getSTATUS_SBAS_FIX() <em>STATUS SBAS FIX</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSTATUS_SBAS_FIX()
	 * @generated
	 * @ordered
	 */
	protected char statuS_SBAS_FIX = STATUS_SBAS_FIX_EDEFAULT;

	/**
	 * The default value of the '{@link #getSTATUS_GBAS_FIX() <em>STATUS GBAS FIX</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSTATUS_GBAS_FIX()
	 * @generated
	 * @ordered
	 */
	protected static final char STATUS_GBAS_FIX_EDEFAULT = '\u0002';

	/**
	 * The cached value of the '{@link #getSTATUS_GBAS_FIX() <em>STATUS GBAS FIX</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSTATUS_GBAS_FIX()
	 * @generated
	 * @ordered
	 */
	protected char statuS_GBAS_FIX = STATUS_GBAS_FIX_EDEFAULT;

	/**
	 * The default value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected static final char STATUS_EDEFAULT = '\u0000';

	/**
	 * The cached value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected char status = STATUS_EDEFAULT;

	/**
	 * The default value of the '{@link #getSERVICE_GPS() <em>SERVICE GPS</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSERVICE_GPS()
	 * @generated
	 * @ordered
	 */
	protected static final int SERVICE_GPS_EDEFAULT = 1;

	/**
	 * The cached value of the '{@link #getSERVICE_GPS() <em>SERVICE GPS</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSERVICE_GPS()
	 * @generated
	 * @ordered
	 */
	protected int servicE_GPS = SERVICE_GPS_EDEFAULT;

	/**
	 * The default value of the '{@link #getSERVICE_GLONASS() <em>SERVICE GLONASS</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSERVICE_GLONASS()
	 * @generated
	 * @ordered
	 */
	protected static final int SERVICE_GLONASS_EDEFAULT = 2;

	/**
	 * The cached value of the '{@link #getSERVICE_GLONASS() <em>SERVICE GLONASS</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSERVICE_GLONASS()
	 * @generated
	 * @ordered
	 */
	protected int servicE_GLONASS = SERVICE_GLONASS_EDEFAULT;

	/**
	 * The default value of the '{@link #getSERVICE_COMPASS() <em>SERVICE COMPASS</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSERVICE_COMPASS()
	 * @generated
	 * @ordered
	 */
	protected static final int SERVICE_COMPASS_EDEFAULT = 4;

	/**
	 * The cached value of the '{@link #getSERVICE_COMPASS() <em>SERVICE COMPASS</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSERVICE_COMPASS()
	 * @generated
	 * @ordered
	 */
	protected int servicE_COMPASS = SERVICE_COMPASS_EDEFAULT;

	/**
	 * The default value of the '{@link #getSERVICE_GALILEO() <em>SERVICE GALILEO</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSERVICE_GALILEO()
	 * @generated
	 * @ordered
	 */
	protected static final int SERVICE_GALILEO_EDEFAULT = 8;

	/**
	 * The cached value of the '{@link #getSERVICE_GALILEO() <em>SERVICE GALILEO</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSERVICE_GALILEO()
	 * @generated
	 * @ordered
	 */
	protected int servicE_GALILEO = SERVICE_GALILEO_EDEFAULT;

	/**
	 * The default value of the '{@link #getService() <em>Service</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getService()
	 * @generated
	 * @ordered
	 */
	protected static final int SERVICE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getService() <em>Service</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getService()
	 * @generated
	 * @ordered
	 */
	protected int service = SERVICE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NavSatStatusImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Sensor_datatypesPackage.Literals.NAV_SAT_STATUS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public char getSTATUS_NO_FIX() {
		return statuS_NO_FIX;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public char getSTATUS_FIX() {
		return statuS_FIX;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public char getSTATUS_SBAS_FIX() {
		return statuS_SBAS_FIX;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public char getSTATUS_GBAS_FIX() {
		return statuS_GBAS_FIX;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public char getStatus() {
		return status;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatus(char newStatus) {
		char oldStatus = status;
		status = newStatus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.NAV_SAT_STATUS__STATUS, oldStatus, status));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSERVICE_GPS() {
		return servicE_GPS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSERVICE_GLONASS() {
		return servicE_GLONASS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSERVICE_COMPASS() {
		return servicE_COMPASS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSERVICE_GALILEO() {
		return servicE_GALILEO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getService() {
		return service;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setService(int newService) {
		int oldService = service;
		service = newService;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.NAV_SAT_STATUS__SERVICE, oldService, service));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Sensor_datatypesPackage.NAV_SAT_STATUS__STATUS_NO_FIX:
				return getSTATUS_NO_FIX();
			case Sensor_datatypesPackage.NAV_SAT_STATUS__STATUS_FIX:
				return getSTATUS_FIX();
			case Sensor_datatypesPackage.NAV_SAT_STATUS__STATUS_SBAS_FIX:
				return getSTATUS_SBAS_FIX();
			case Sensor_datatypesPackage.NAV_SAT_STATUS__STATUS_GBAS_FIX:
				return getSTATUS_GBAS_FIX();
			case Sensor_datatypesPackage.NAV_SAT_STATUS__STATUS:
				return getStatus();
			case Sensor_datatypesPackage.NAV_SAT_STATUS__SERVICE_GPS:
				return getSERVICE_GPS();
			case Sensor_datatypesPackage.NAV_SAT_STATUS__SERVICE_GLONASS:
				return getSERVICE_GLONASS();
			case Sensor_datatypesPackage.NAV_SAT_STATUS__SERVICE_COMPASS:
				return getSERVICE_COMPASS();
			case Sensor_datatypesPackage.NAV_SAT_STATUS__SERVICE_GALILEO:
				return getSERVICE_GALILEO();
			case Sensor_datatypesPackage.NAV_SAT_STATUS__SERVICE:
				return getService();
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
			case Sensor_datatypesPackage.NAV_SAT_STATUS__STATUS:
				setStatus((Character)newValue);
				return;
			case Sensor_datatypesPackage.NAV_SAT_STATUS__SERVICE:
				setService((Integer)newValue);
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
			case Sensor_datatypesPackage.NAV_SAT_STATUS__STATUS:
				setStatus(STATUS_EDEFAULT);
				return;
			case Sensor_datatypesPackage.NAV_SAT_STATUS__SERVICE:
				setService(SERVICE_EDEFAULT);
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
			case Sensor_datatypesPackage.NAV_SAT_STATUS__STATUS_NO_FIX:
				return statuS_NO_FIX != STATUS_NO_FIX_EDEFAULT;
			case Sensor_datatypesPackage.NAV_SAT_STATUS__STATUS_FIX:
				return statuS_FIX != STATUS_FIX_EDEFAULT;
			case Sensor_datatypesPackage.NAV_SAT_STATUS__STATUS_SBAS_FIX:
				return statuS_SBAS_FIX != STATUS_SBAS_FIX_EDEFAULT;
			case Sensor_datatypesPackage.NAV_SAT_STATUS__STATUS_GBAS_FIX:
				return statuS_GBAS_FIX != STATUS_GBAS_FIX_EDEFAULT;
			case Sensor_datatypesPackage.NAV_SAT_STATUS__STATUS:
				return status != STATUS_EDEFAULT;
			case Sensor_datatypesPackage.NAV_SAT_STATUS__SERVICE_GPS:
				return servicE_GPS != SERVICE_GPS_EDEFAULT;
			case Sensor_datatypesPackage.NAV_SAT_STATUS__SERVICE_GLONASS:
				return servicE_GLONASS != SERVICE_GLONASS_EDEFAULT;
			case Sensor_datatypesPackage.NAV_SAT_STATUS__SERVICE_COMPASS:
				return servicE_COMPASS != SERVICE_COMPASS_EDEFAULT;
			case Sensor_datatypesPackage.NAV_SAT_STATUS__SERVICE_GALILEO:
				return servicE_GALILEO != SERVICE_GALILEO_EDEFAULT;
			case Sensor_datatypesPackage.NAV_SAT_STATUS__SERVICE:
				return service != SERVICE_EDEFAULT;
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
		result.append(" (STATUS_NO_FIX: ");
		result.append(statuS_NO_FIX);
		result.append(", STATUS_FIX: ");
		result.append(statuS_FIX);
		result.append(", STATUS_SBAS_FIX: ");
		result.append(statuS_SBAS_FIX);
		result.append(", STATUS_GBAS_FIX: ");
		result.append(statuS_GBAS_FIX);
		result.append(", status: ");
		result.append(status);
		result.append(", SERVICE_GPS: ");
		result.append(servicE_GPS);
		result.append(", SERVICE_GLONASS: ");
		result.append(servicE_GLONASS);
		result.append(", SERVICE_COMPASS: ");
		result.append(servicE_COMPASS);
		result.append(", SERVICE_GALILEO: ");
		result.append(servicE_GALILEO);
		result.append(", service: ");
		result.append(service);
		result.append(')');
		return result.toString();
	}

} //NavSatStatusImpl
