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
package org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.ExtentedLidarScan;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.Oarp1_datatypesPackage;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.LaserScan;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Extented Lidar Scan</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.impl.ExtentedLidarScanImpl#getScan
 * <em>Scan</em>}</li>
 * <li>
 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.impl.ExtentedLidarScanImpl#getLayerId
 * <em>Layer Id</em>}</li>
 * <li>
 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp1_datatypes.impl.ExtentedLidarScanImpl#getLayerAngle
 * <em>Layer Angle</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ExtentedLidarScanImpl extends EObjectImpl implements ExtentedLidarScan {

	/**
	 * The cached value of the '{@link #getScan() <em>Scan</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getScan()
	 * @generated
	 * @ordered
	 */
	protected LaserScan scan;

	/**
	 * The default value of the '{@link #getLayerId() <em>Layer Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getLayerId()
	 * @generated
	 * @ordered
	 */
	protected static final char LAYER_ID_EDEFAULT = '\u0000';

	/**
	 * The cached value of the '{@link #getLayerId() <em>Layer Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getLayerId()
	 * @generated
	 * @ordered
	 */
	protected char layerId = LAYER_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getLayerAngle() <em>Layer Angle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getLayerAngle()
	 * @generated
	 * @ordered
	 */
	protected static final float LAYER_ANGLE_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getLayerAngle() <em>Layer Angle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getLayerAngle()
	 * @generated
	 * @ordered
	 */
	protected float layerAngle = LAYER_ANGLE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ExtentedLidarScanImpl() {
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
		return Oarp1_datatypesPackage.Literals.EXTENTED_LIDAR_SCAN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public LaserScan getScan() {
		return scan;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetScan(LaserScan newScan, NotificationChain msgs) {
		LaserScan oldScan = scan;
		scan = newScan;
		if(eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Oarp1_datatypesPackage.EXTENTED_LIDAR_SCAN__SCAN, oldScan, newScan);
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
	public void setScan(LaserScan newScan) {
		if(newScan != scan) {
			NotificationChain msgs = null;
			if(scan != null)
				msgs = ((InternalEObject)scan).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Oarp1_datatypesPackage.EXTENTED_LIDAR_SCAN__SCAN, null, msgs);
			if(newScan != null)
				msgs = ((InternalEObject)newScan).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Oarp1_datatypesPackage.EXTENTED_LIDAR_SCAN__SCAN, null, msgs);
			msgs = basicSetScan(newScan, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Oarp1_datatypesPackage.EXTENTED_LIDAR_SCAN__SCAN, newScan, newScan));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public char getLayerId() {
		return layerId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setLayerId(char newLayerId) {
		char oldLayerId = layerId;
		layerId = newLayerId;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Oarp1_datatypesPackage.EXTENTED_LIDAR_SCAN__LAYER_ID, oldLayerId, layerId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public float getLayerAngle() {
		return layerAngle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setLayerAngle(float newLayerAngle) {
		float oldLayerAngle = layerAngle;
		layerAngle = newLayerAngle;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Oarp1_datatypesPackage.EXTENTED_LIDAR_SCAN__LAYER_ANGLE, oldLayerAngle, layerAngle));
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
		case Oarp1_datatypesPackage.EXTENTED_LIDAR_SCAN__SCAN:
			return basicSetScan(null, msgs);
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
		case Oarp1_datatypesPackage.EXTENTED_LIDAR_SCAN__SCAN:
			return getScan();
		case Oarp1_datatypesPackage.EXTENTED_LIDAR_SCAN__LAYER_ID:
			return getLayerId();
		case Oarp1_datatypesPackage.EXTENTED_LIDAR_SCAN__LAYER_ANGLE:
			return getLayerAngle();
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
		case Oarp1_datatypesPackage.EXTENTED_LIDAR_SCAN__SCAN:
			setScan((LaserScan)newValue);
			return;
		case Oarp1_datatypesPackage.EXTENTED_LIDAR_SCAN__LAYER_ID:
			setLayerId((Character)newValue);
			return;
		case Oarp1_datatypesPackage.EXTENTED_LIDAR_SCAN__LAYER_ANGLE:
			setLayerAngle((Float)newValue);
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
		case Oarp1_datatypesPackage.EXTENTED_LIDAR_SCAN__SCAN:
			setScan((LaserScan)null);
			return;
		case Oarp1_datatypesPackage.EXTENTED_LIDAR_SCAN__LAYER_ID:
			setLayerId(LAYER_ID_EDEFAULT);
			return;
		case Oarp1_datatypesPackage.EXTENTED_LIDAR_SCAN__LAYER_ANGLE:
			setLayerAngle(LAYER_ANGLE_EDEFAULT);
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
		case Oarp1_datatypesPackage.EXTENTED_LIDAR_SCAN__SCAN:
			return scan != null;
		case Oarp1_datatypesPackage.EXTENTED_LIDAR_SCAN__LAYER_ID:
			return layerId != LAYER_ID_EDEFAULT;
		case Oarp1_datatypesPackage.EXTENTED_LIDAR_SCAN__LAYER_ANGLE:
			return layerAngle != LAYER_ANGLE_EDEFAULT;
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
		result.append(" (layerId: ");
		result.append(layerId);
		result.append(", layerAngle: ");
		result.append(layerAngle);
		result.append(')');
		return result.toString();
	}

} //ExtentedLidarScanImpl
