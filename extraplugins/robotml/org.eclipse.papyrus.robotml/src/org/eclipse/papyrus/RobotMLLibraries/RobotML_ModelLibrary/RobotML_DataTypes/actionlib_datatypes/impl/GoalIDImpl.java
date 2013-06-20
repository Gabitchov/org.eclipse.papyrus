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
package org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.impl;

import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.Actionlib_datatypesPackage;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.GoalID;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Goal ID</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.impl.GoalIDImpl#getStamp <em>Stamp</em>}
 * </li>
 * <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.impl.GoalIDImpl#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class GoalIDImpl extends EObjectImpl implements GoalID {

	/**
	 * The default value of the '{@link #getStamp() <em>Stamp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getStamp()
	 * @generated
	 * @ordered
	 */
	protected static final Date STAMP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStamp() <em>Stamp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getStamp()
	 * @generated
	 * @ordered
	 */
	protected Date stamp = STAMP_EDEFAULT;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected GoalIDImpl() {
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
		return Actionlib_datatypesPackage.Literals.GOAL_ID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Date getStamp() {
		return stamp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setStamp(Date newStamp) {
		Date oldStamp = stamp;
		stamp = newStamp;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Actionlib_datatypesPackage.GOAL_ID__STAMP, oldStamp, stamp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Actionlib_datatypesPackage.GOAL_ID__ID, oldId, id));
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
		case Actionlib_datatypesPackage.GOAL_ID__STAMP:
			return getStamp();
		case Actionlib_datatypesPackage.GOAL_ID__ID:
			return getId();
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
		case Actionlib_datatypesPackage.GOAL_ID__STAMP:
			setStamp((Date)newValue);
			return;
		case Actionlib_datatypesPackage.GOAL_ID__ID:
			setId((String)newValue);
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
		case Actionlib_datatypesPackage.GOAL_ID__STAMP:
			setStamp(STAMP_EDEFAULT);
			return;
		case Actionlib_datatypesPackage.GOAL_ID__ID:
			setId(ID_EDEFAULT);
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
		case Actionlib_datatypesPackage.GOAL_ID__STAMP:
			return STAMP_EDEFAULT == null ? stamp != null : !STAMP_EDEFAULT.equals(stamp);
		case Actionlib_datatypesPackage.GOAL_ID__ID:
			return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
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
		result.append(" (stamp: ");
		result.append(stamp);
		result.append(", id: ");
		result.append(id);
		result.append(')');
		return result.toString();
	}

} //GoalIDImpl
