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
package org.eclipse.papyrus.RobotML.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.RobotML.GPSSystem;
import org.eclipse.papyrus.RobotML.RobotMLPackage;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.Point32;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>GPS System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.RobotML.impl.GPSSystemImpl#getOriginPosition <em>Origin Position</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class GPSSystemImpl extends LocalizationSensorSystemImpl implements GPSSystem {

	/**
	 * The cached value of the '{@link #getOriginPosition() <em>Origin Position</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getOriginPosition()
	 * @generated
	 * @ordered
	 */
	protected Point32 originPosition;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected GPSSystemImpl() {
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
		return RobotMLPackage.Literals.GPS_SYSTEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Point32 getOriginPosition() {
		return originPosition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetOriginPosition(Point32 newOriginPosition, NotificationChain msgs) {
		Point32 oldOriginPosition = originPosition;
		originPosition = newOriginPosition;
		if(eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RobotMLPackage.GPS_SYSTEM__ORIGIN_POSITION, oldOriginPosition, newOriginPosition);
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
	public void setOriginPosition(Point32 newOriginPosition) {
		if(newOriginPosition != originPosition) {
			NotificationChain msgs = null;
			if(originPosition != null)
				msgs = ((InternalEObject)originPosition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RobotMLPackage.GPS_SYSTEM__ORIGIN_POSITION, null, msgs);
			if(newOriginPosition != null)
				msgs = ((InternalEObject)newOriginPosition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RobotMLPackage.GPS_SYSTEM__ORIGIN_POSITION, null, msgs);
			msgs = basicSetOriginPosition(newOriginPosition, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.GPS_SYSTEM__ORIGIN_POSITION, newOriginPosition, newOriginPosition));
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
		case RobotMLPackage.GPS_SYSTEM__ORIGIN_POSITION:
			return basicSetOriginPosition(null, msgs);
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
		case RobotMLPackage.GPS_SYSTEM__ORIGIN_POSITION:
			return getOriginPosition();
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
		case RobotMLPackage.GPS_SYSTEM__ORIGIN_POSITION:
			setOriginPosition((Point32)newValue);
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
		case RobotMLPackage.GPS_SYSTEM__ORIGIN_POSITION:
			setOriginPosition((Point32)null);
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
		case RobotMLPackage.GPS_SYSTEM__ORIGIN_POSITION:
			return originPosition != null;
		}
		return super.eIsSet(featureID);
	}

} //GPSSystemImpl
