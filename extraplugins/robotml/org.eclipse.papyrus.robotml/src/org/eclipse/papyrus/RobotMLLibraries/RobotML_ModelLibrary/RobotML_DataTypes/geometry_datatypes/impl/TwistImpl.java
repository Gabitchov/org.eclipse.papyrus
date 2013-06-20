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
package org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.Geometry_datatypesPackage;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.Twist;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.Vector3;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Twist</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.impl.TwistImpl#getLinear <em>Linear</em>}
 * </li>
 * <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.impl.TwistImpl#getAngular <em>Angular
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class TwistImpl extends EObjectImpl implements Twist {

	/**
	 * The cached value of the '{@link #getLinear() <em>Linear</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getLinear()
	 * @generated
	 * @ordered
	 */
	protected Vector3 linear;

	/**
	 * The cached value of the '{@link #getAngular() <em>Angular</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getAngular()
	 * @generated
	 * @ordered
	 */
	protected Vector3 angular;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected TwistImpl() {
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
		return Geometry_datatypesPackage.Literals.TWIST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Vector3 getLinear() {
		return linear;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetLinear(Vector3 newLinear, NotificationChain msgs) {
		Vector3 oldLinear = linear;
		linear = newLinear;
		if(eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Geometry_datatypesPackage.TWIST__LINEAR, oldLinear, newLinear);
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
	public void setLinear(Vector3 newLinear) {
		if(newLinear != linear) {
			NotificationChain msgs = null;
			if(linear != null)
				msgs = ((InternalEObject)linear).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Geometry_datatypesPackage.TWIST__LINEAR, null, msgs);
			if(newLinear != null)
				msgs = ((InternalEObject)newLinear).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Geometry_datatypesPackage.TWIST__LINEAR, null, msgs);
			msgs = basicSetLinear(newLinear, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Geometry_datatypesPackage.TWIST__LINEAR, newLinear, newLinear));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Vector3 getAngular() {
		return angular;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetAngular(Vector3 newAngular, NotificationChain msgs) {
		Vector3 oldAngular = angular;
		angular = newAngular;
		if(eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Geometry_datatypesPackage.TWIST__ANGULAR, oldAngular, newAngular);
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
	public void setAngular(Vector3 newAngular) {
		if(newAngular != angular) {
			NotificationChain msgs = null;
			if(angular != null)
				msgs = ((InternalEObject)angular).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Geometry_datatypesPackage.TWIST__ANGULAR, null, msgs);
			if(newAngular != null)
				msgs = ((InternalEObject)newAngular).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Geometry_datatypesPackage.TWIST__ANGULAR, null, msgs);
			msgs = basicSetAngular(newAngular, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Geometry_datatypesPackage.TWIST__ANGULAR, newAngular, newAngular));
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
		case Geometry_datatypesPackage.TWIST__LINEAR:
			return basicSetLinear(null, msgs);
		case Geometry_datatypesPackage.TWIST__ANGULAR:
			return basicSetAngular(null, msgs);
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
		case Geometry_datatypesPackage.TWIST__LINEAR:
			return getLinear();
		case Geometry_datatypesPackage.TWIST__ANGULAR:
			return getAngular();
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
		case Geometry_datatypesPackage.TWIST__LINEAR:
			setLinear((Vector3)newValue);
			return;
		case Geometry_datatypesPackage.TWIST__ANGULAR:
			setAngular((Vector3)newValue);
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
		case Geometry_datatypesPackage.TWIST__LINEAR:
			setLinear((Vector3)null);
			return;
		case Geometry_datatypesPackage.TWIST__ANGULAR:
			setAngular((Vector3)null);
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
		case Geometry_datatypesPackage.TWIST__LINEAR:
			return linear != null;
		case Geometry_datatypesPackage.TWIST__ANGULAR:
			return angular != null;
		}
		return super.eIsSet(featureID);
	}

} //TwistImpl
