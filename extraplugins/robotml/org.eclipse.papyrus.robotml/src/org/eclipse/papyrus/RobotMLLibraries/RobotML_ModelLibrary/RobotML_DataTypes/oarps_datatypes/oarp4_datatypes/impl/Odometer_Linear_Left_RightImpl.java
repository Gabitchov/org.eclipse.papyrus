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
package org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Metric;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Oarp4_datatypesPackage;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Odometer_Linear_Left_Right;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Odometer Linear Left Right</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Odometer_Linear_Left_RightImpl#getOdometer_linear_left
 * <em>Odometer linear left</em>}</li>
 * <li>
 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Odometer_Linear_Left_RightImpl#getOdometer_linear_right
 * <em>Odometer linear right</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class Odometer_Linear_Left_RightImpl extends EObjectImpl implements Odometer_Linear_Left_Right {

	/**
	 * The cached value of the '{@link #getOdometer_linear_left() <em>Odometer linear left</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getOdometer_linear_left()
	 * @generated
	 * @ordered
	 */
	protected Metric odometer_linear_left;

	/**
	 * The cached value of the '{@link #getOdometer_linear_right() <em>Odometer linear right</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getOdometer_linear_right()
	 * @generated
	 * @ordered
	 */
	protected Metric odometer_linear_right;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected Odometer_Linear_Left_RightImpl() {
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
		return Oarp4_datatypesPackage.Literals.ODOMETER_LINEAR_LEFT_RIGHT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Metric getOdometer_linear_left() {
		return odometer_linear_left;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetOdometer_linear_left(Metric newOdometer_linear_left, NotificationChain msgs) {
		Metric oldOdometer_linear_left = odometer_linear_left;
		odometer_linear_left = newOdometer_linear_left;
		if(eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Oarp4_datatypesPackage.ODOMETER_LINEAR_LEFT_RIGHT__ODOMETER_LINEAR_LEFT, oldOdometer_linear_left, newOdometer_linear_left);
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
	public void setOdometer_linear_left(Metric newOdometer_linear_left) {
		if(newOdometer_linear_left != odometer_linear_left) {
			NotificationChain msgs = null;
			if(odometer_linear_left != null)
				msgs = ((InternalEObject)odometer_linear_left).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Oarp4_datatypesPackage.ODOMETER_LINEAR_LEFT_RIGHT__ODOMETER_LINEAR_LEFT, null, msgs);
			if(newOdometer_linear_left != null)
				msgs = ((InternalEObject)newOdometer_linear_left).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Oarp4_datatypesPackage.ODOMETER_LINEAR_LEFT_RIGHT__ODOMETER_LINEAR_LEFT, null, msgs);
			msgs = basicSetOdometer_linear_left(newOdometer_linear_left, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Oarp4_datatypesPackage.ODOMETER_LINEAR_LEFT_RIGHT__ODOMETER_LINEAR_LEFT, newOdometer_linear_left, newOdometer_linear_left));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Metric getOdometer_linear_right() {
		return odometer_linear_right;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetOdometer_linear_right(Metric newOdometer_linear_right, NotificationChain msgs) {
		Metric oldOdometer_linear_right = odometer_linear_right;
		odometer_linear_right = newOdometer_linear_right;
		if(eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Oarp4_datatypesPackage.ODOMETER_LINEAR_LEFT_RIGHT__ODOMETER_LINEAR_RIGHT, oldOdometer_linear_right, newOdometer_linear_right);
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
	public void setOdometer_linear_right(Metric newOdometer_linear_right) {
		if(newOdometer_linear_right != odometer_linear_right) {
			NotificationChain msgs = null;
			if(odometer_linear_right != null)
				msgs = ((InternalEObject)odometer_linear_right).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Oarp4_datatypesPackage.ODOMETER_LINEAR_LEFT_RIGHT__ODOMETER_LINEAR_RIGHT, null, msgs);
			if(newOdometer_linear_right != null)
				msgs = ((InternalEObject)newOdometer_linear_right).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Oarp4_datatypesPackage.ODOMETER_LINEAR_LEFT_RIGHT__ODOMETER_LINEAR_RIGHT, null, msgs);
			msgs = basicSetOdometer_linear_right(newOdometer_linear_right, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Oarp4_datatypesPackage.ODOMETER_LINEAR_LEFT_RIGHT__ODOMETER_LINEAR_RIGHT, newOdometer_linear_right, newOdometer_linear_right));
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
		case Oarp4_datatypesPackage.ODOMETER_LINEAR_LEFT_RIGHT__ODOMETER_LINEAR_LEFT:
			return basicSetOdometer_linear_left(null, msgs);
		case Oarp4_datatypesPackage.ODOMETER_LINEAR_LEFT_RIGHT__ODOMETER_LINEAR_RIGHT:
			return basicSetOdometer_linear_right(null, msgs);
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
		case Oarp4_datatypesPackage.ODOMETER_LINEAR_LEFT_RIGHT__ODOMETER_LINEAR_LEFT:
			return getOdometer_linear_left();
		case Oarp4_datatypesPackage.ODOMETER_LINEAR_LEFT_RIGHT__ODOMETER_LINEAR_RIGHT:
			return getOdometer_linear_right();
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
		case Oarp4_datatypesPackage.ODOMETER_LINEAR_LEFT_RIGHT__ODOMETER_LINEAR_LEFT:
			setOdometer_linear_left((Metric)newValue);
			return;
		case Oarp4_datatypesPackage.ODOMETER_LINEAR_LEFT_RIGHT__ODOMETER_LINEAR_RIGHT:
			setOdometer_linear_right((Metric)newValue);
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
		case Oarp4_datatypesPackage.ODOMETER_LINEAR_LEFT_RIGHT__ODOMETER_LINEAR_LEFT:
			setOdometer_linear_left((Metric)null);
			return;
		case Oarp4_datatypesPackage.ODOMETER_LINEAR_LEFT_RIGHT__ODOMETER_LINEAR_RIGHT:
			setOdometer_linear_right((Metric)null);
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
		case Oarp4_datatypesPackage.ODOMETER_LINEAR_LEFT_RIGHT__ODOMETER_LINEAR_LEFT:
			return odometer_linear_left != null;
		case Oarp4_datatypesPackage.ODOMETER_LINEAR_LEFT_RIGHT__ODOMETER_LINEAR_RIGHT:
			return odometer_linear_right != null;
		}
		return super.eIsSet(featureID);
	}

} //Odometer_Linear_Left_RightImpl
