/**
 */
package org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.impl;

import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.Pose;

import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.MapMetaData;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.Nav_datatypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Map Meta Data</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.impl.MapMetaDataImpl#getMap_load_time <em>Map load time</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.impl.MapMetaDataImpl#getResolution <em>Resolution</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.impl.MapMetaDataImpl#getWidth <em>Width</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.impl.MapMetaDataImpl#getOrigin <em>Origin</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MapMetaDataImpl extends MinimalEObjectImpl.Container implements MapMetaData {
	/**
	 * The default value of the '{@link #getMap_load_time() <em>Map load time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMap_load_time()
	 * @generated
	 * @ordered
	 */
	protected static final Date MAP_LOAD_TIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMap_load_time() <em>Map load time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMap_load_time()
	 * @generated
	 * @ordered
	 */
	protected Date map_load_time = MAP_LOAD_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getResolution() <em>Resolution</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResolution()
	 * @generated
	 * @ordered
	 */
	protected static final float RESOLUTION_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getResolution() <em>Resolution</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResolution()
	 * @generated
	 * @ordered
	 */
	protected float resolution = RESOLUTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getWidth() <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWidth()
	 * @generated
	 * @ordered
	 */
	protected static final long WIDTH_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getWidth() <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWidth()
	 * @generated
	 * @ordered
	 */
	protected long width = WIDTH_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOrigin() <em>Origin</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrigin()
	 * @generated
	 * @ordered
	 */
	protected Pose origin;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MapMetaDataImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Nav_datatypesPackage.Literals.MAP_META_DATA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getMap_load_time() {
		return map_load_time;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMap_load_time(Date newMap_load_time) {
		Date oldMap_load_time = map_load_time;
		map_load_time = newMap_load_time;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Nav_datatypesPackage.MAP_META_DATA__MAP_LOAD_TIME, oldMap_load_time, map_load_time));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getResolution() {
		return resolution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResolution(float newResolution) {
		float oldResolution = resolution;
		resolution = newResolution;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Nav_datatypesPackage.MAP_META_DATA__RESOLUTION, oldResolution, resolution));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getWidth() {
		return width;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWidth(long newWidth) {
		long oldWidth = width;
		width = newWidth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Nav_datatypesPackage.MAP_META_DATA__WIDTH, oldWidth, width));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pose getOrigin() {
		return origin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOrigin(Pose newOrigin, NotificationChain msgs) {
		Pose oldOrigin = origin;
		origin = newOrigin;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Nav_datatypesPackage.MAP_META_DATA__ORIGIN, oldOrigin, newOrigin);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOrigin(Pose newOrigin) {
		if (newOrigin != origin) {
			NotificationChain msgs = null;
			if (origin != null)
				msgs = ((InternalEObject)origin).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Nav_datatypesPackage.MAP_META_DATA__ORIGIN, null, msgs);
			if (newOrigin != null)
				msgs = ((InternalEObject)newOrigin).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Nav_datatypesPackage.MAP_META_DATA__ORIGIN, null, msgs);
			msgs = basicSetOrigin(newOrigin, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Nav_datatypesPackage.MAP_META_DATA__ORIGIN, newOrigin, newOrigin));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Nav_datatypesPackage.MAP_META_DATA__ORIGIN:
				return basicSetOrigin(null, msgs);
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
			case Nav_datatypesPackage.MAP_META_DATA__MAP_LOAD_TIME:
				return getMap_load_time();
			case Nav_datatypesPackage.MAP_META_DATA__RESOLUTION:
				return getResolution();
			case Nav_datatypesPackage.MAP_META_DATA__WIDTH:
				return getWidth();
			case Nav_datatypesPackage.MAP_META_DATA__ORIGIN:
				return getOrigin();
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
			case Nav_datatypesPackage.MAP_META_DATA__MAP_LOAD_TIME:
				setMap_load_time((Date)newValue);
				return;
			case Nav_datatypesPackage.MAP_META_DATA__RESOLUTION:
				setResolution((Float)newValue);
				return;
			case Nav_datatypesPackage.MAP_META_DATA__WIDTH:
				setWidth((Long)newValue);
				return;
			case Nav_datatypesPackage.MAP_META_DATA__ORIGIN:
				setOrigin((Pose)newValue);
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
			case Nav_datatypesPackage.MAP_META_DATA__MAP_LOAD_TIME:
				setMap_load_time(MAP_LOAD_TIME_EDEFAULT);
				return;
			case Nav_datatypesPackage.MAP_META_DATA__RESOLUTION:
				setResolution(RESOLUTION_EDEFAULT);
				return;
			case Nav_datatypesPackage.MAP_META_DATA__WIDTH:
				setWidth(WIDTH_EDEFAULT);
				return;
			case Nav_datatypesPackage.MAP_META_DATA__ORIGIN:
				setOrigin((Pose)null);
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
			case Nav_datatypesPackage.MAP_META_DATA__MAP_LOAD_TIME:
				return MAP_LOAD_TIME_EDEFAULT == null ? map_load_time != null : !MAP_LOAD_TIME_EDEFAULT.equals(map_load_time);
			case Nav_datatypesPackage.MAP_META_DATA__RESOLUTION:
				return resolution != RESOLUTION_EDEFAULT;
			case Nav_datatypesPackage.MAP_META_DATA__WIDTH:
				return width != WIDTH_EDEFAULT;
			case Nav_datatypesPackage.MAP_META_DATA__ORIGIN:
				return origin != null;
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
		result.append(" (map_load_time: ");
		result.append(map_load_time);
		result.append(", resolution: ");
		result.append(resolution);
		result.append(", width: ");
		result.append(width);
		result.append(')');
		return result.toString();
	}

} //MapMetaDataImpl
