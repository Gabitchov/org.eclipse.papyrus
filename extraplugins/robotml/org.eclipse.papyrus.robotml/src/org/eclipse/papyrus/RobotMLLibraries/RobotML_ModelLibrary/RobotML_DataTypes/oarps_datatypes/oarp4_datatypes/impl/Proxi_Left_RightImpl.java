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
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Distance;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Oarp4_datatypesPackage;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.Proxi_Left_Right;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Proxi Left Right</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Proxi_Left_RightImpl#getProxi_left
 * <em>Proxi left</em>}</li>
 * <li>
 * {@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.oarps_datatypes.oarp4_datatypes.impl.Proxi_Left_RightImpl#getProxi_right
 * <em>Proxi right</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class Proxi_Left_RightImpl extends EObjectImpl implements Proxi_Left_Right {

	/**
	 * The cached value of the '{@link #getProxi_left() <em>Proxi left</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getProxi_left()
	 * @generated
	 * @ordered
	 */
	protected Distance proxi_left;

	/**
	 * The cached value of the '{@link #getProxi_right() <em>Proxi right</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getProxi_right()
	 * @generated
	 * @ordered
	 */
	protected Distance proxi_right;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected Proxi_Left_RightImpl() {
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
		return Oarp4_datatypesPackage.Literals.PROXI_LEFT_RIGHT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Distance getProxi_left() {
		return proxi_left;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetProxi_left(Distance newProxi_left, NotificationChain msgs) {
		Distance oldProxi_left = proxi_left;
		proxi_left = newProxi_left;
		if(eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Oarp4_datatypesPackage.PROXI_LEFT_RIGHT__PROXI_LEFT, oldProxi_left, newProxi_left);
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
	public void setProxi_left(Distance newProxi_left) {
		if(newProxi_left != proxi_left) {
			NotificationChain msgs = null;
			if(proxi_left != null)
				msgs = ((InternalEObject)proxi_left).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Oarp4_datatypesPackage.PROXI_LEFT_RIGHT__PROXI_LEFT, null, msgs);
			if(newProxi_left != null)
				msgs = ((InternalEObject)newProxi_left).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Oarp4_datatypesPackage.PROXI_LEFT_RIGHT__PROXI_LEFT, null, msgs);
			msgs = basicSetProxi_left(newProxi_left, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Oarp4_datatypesPackage.PROXI_LEFT_RIGHT__PROXI_LEFT, newProxi_left, newProxi_left));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Distance getProxi_right() {
		return proxi_right;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetProxi_right(Distance newProxi_right, NotificationChain msgs) {
		Distance oldProxi_right = proxi_right;
		proxi_right = newProxi_right;
		if(eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Oarp4_datatypesPackage.PROXI_LEFT_RIGHT__PROXI_RIGHT, oldProxi_right, newProxi_right);
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
	public void setProxi_right(Distance newProxi_right) {
		if(newProxi_right != proxi_right) {
			NotificationChain msgs = null;
			if(proxi_right != null)
				msgs = ((InternalEObject)proxi_right).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Oarp4_datatypesPackage.PROXI_LEFT_RIGHT__PROXI_RIGHT, null, msgs);
			if(newProxi_right != null)
				msgs = ((InternalEObject)newProxi_right).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Oarp4_datatypesPackage.PROXI_LEFT_RIGHT__PROXI_RIGHT, null, msgs);
			msgs = basicSetProxi_right(newProxi_right, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Oarp4_datatypesPackage.PROXI_LEFT_RIGHT__PROXI_RIGHT, newProxi_right, newProxi_right));
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
		case Oarp4_datatypesPackage.PROXI_LEFT_RIGHT__PROXI_LEFT:
			return basicSetProxi_left(null, msgs);
		case Oarp4_datatypesPackage.PROXI_LEFT_RIGHT__PROXI_RIGHT:
			return basicSetProxi_right(null, msgs);
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
		case Oarp4_datatypesPackage.PROXI_LEFT_RIGHT__PROXI_LEFT:
			return getProxi_left();
		case Oarp4_datatypesPackage.PROXI_LEFT_RIGHT__PROXI_RIGHT:
			return getProxi_right();
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
		case Oarp4_datatypesPackage.PROXI_LEFT_RIGHT__PROXI_LEFT:
			setProxi_left((Distance)newValue);
			return;
		case Oarp4_datatypesPackage.PROXI_LEFT_RIGHT__PROXI_RIGHT:
			setProxi_right((Distance)newValue);
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
		case Oarp4_datatypesPackage.PROXI_LEFT_RIGHT__PROXI_LEFT:
			setProxi_left((Distance)null);
			return;
		case Oarp4_datatypesPackage.PROXI_LEFT_RIGHT__PROXI_RIGHT:
			setProxi_right((Distance)null);
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
		case Oarp4_datatypesPackage.PROXI_LEFT_RIGHT__PROXI_LEFT:
			return proxi_left != null;
		case Oarp4_datatypesPackage.PROXI_LEFT_RIGHT__PROXI_RIGHT:
			return proxi_right != null;
		}
		return super.eIsSet(featureID);
	}

} //Proxi_Left_RightImpl
