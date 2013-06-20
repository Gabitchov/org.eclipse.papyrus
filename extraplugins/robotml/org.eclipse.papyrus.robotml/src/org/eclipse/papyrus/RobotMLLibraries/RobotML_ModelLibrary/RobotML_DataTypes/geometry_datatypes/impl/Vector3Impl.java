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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.Geometry_datatypesPackage;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.Vector3;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Vector3</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.impl.Vector3Impl#getX <em>X</em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.impl.Vector3Impl#getY <em>Y</em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.impl.Vector3Impl#getZ <em>Z</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class Vector3Impl extends EObjectImpl implements Vector3 {

	/**
	 * The default value of the '{@link #getX() <em>X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getX()
	 * @generated
	 * @ordered
	 */
	protected static final double X_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getX() <em>X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getX()
	 * @generated
	 * @ordered
	 */
	protected double x = X_EDEFAULT;

	/**
	 * The default value of the '{@link #getY() <em>Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getY()
	 * @generated
	 * @ordered
	 */
	protected static final double Y_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getY() <em>Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getY()
	 * @generated
	 * @ordered
	 */
	protected double y = Y_EDEFAULT;

	/**
	 * The default value of the '{@link #getZ() <em>Z</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getZ()
	 * @generated
	 * @ordered
	 */
	protected static final double Z_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getZ() <em>Z</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getZ()
	 * @generated
	 * @ordered
	 */
	protected double z = Z_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected Vector3Impl() {
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
		return Geometry_datatypesPackage.Literals.VECTOR3;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public double getX() {
		return x;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setX(double newX) {
		double oldX = x;
		x = newX;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Geometry_datatypesPackage.VECTOR3__X, oldX, x));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public double getY() {
		return y;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setY(double newY) {
		double oldY = y;
		y = newY;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Geometry_datatypesPackage.VECTOR3__Y, oldY, y));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public double getZ() {
		return z;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setZ(double newZ) {
		double oldZ = z;
		z = newZ;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Geometry_datatypesPackage.VECTOR3__Z, oldZ, z));
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
		case Geometry_datatypesPackage.VECTOR3__X:
			return getX();
		case Geometry_datatypesPackage.VECTOR3__Y:
			return getY();
		case Geometry_datatypesPackage.VECTOR3__Z:
			return getZ();
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
		case Geometry_datatypesPackage.VECTOR3__X:
			setX((Double)newValue);
			return;
		case Geometry_datatypesPackage.VECTOR3__Y:
			setY((Double)newValue);
			return;
		case Geometry_datatypesPackage.VECTOR3__Z:
			setZ((Double)newValue);
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
		case Geometry_datatypesPackage.VECTOR3__X:
			setX(X_EDEFAULT);
			return;
		case Geometry_datatypesPackage.VECTOR3__Y:
			setY(Y_EDEFAULT);
			return;
		case Geometry_datatypesPackage.VECTOR3__Z:
			setZ(Z_EDEFAULT);
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
		case Geometry_datatypesPackage.VECTOR3__X:
			return x != X_EDEFAULT;
		case Geometry_datatypesPackage.VECTOR3__Y:
			return y != Y_EDEFAULT;
		case Geometry_datatypesPackage.VECTOR3__Z:
			return z != Z_EDEFAULT;
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
		result.append(" (x: ");
		result.append(x);
		result.append(", y: ");
		result.append(y);
		result.append(", z: ");
		result.append(z);
		result.append(')');
		return result.toString();
	}

} //Vector3Impl
