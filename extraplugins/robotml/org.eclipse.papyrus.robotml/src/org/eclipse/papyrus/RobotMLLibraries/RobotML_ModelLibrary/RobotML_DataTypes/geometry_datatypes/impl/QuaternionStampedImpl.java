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
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.Quaternion;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.QuaternionStamped;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Header;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Quaternion Stamped</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.impl.QuaternionStampedImpl#getHeader <em>
 * Header</em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.impl.QuaternionStampedImpl#getQuaternion
 * <em>Quaternion</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class QuaternionStampedImpl extends EObjectImpl implements QuaternionStamped {

	/**
	 * The cached value of the '{@link #getHeader() <em>Header</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getHeader()
	 * @generated
	 * @ordered
	 */
	protected Header header;

	/**
	 * The cached value of the '{@link #getQuaternion() <em>Quaternion</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getQuaternion()
	 * @generated
	 * @ordered
	 */
	protected Quaternion quaternion;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected QuaternionStampedImpl() {
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
		return Geometry_datatypesPackage.Literals.QUATERNION_STAMPED;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Header getHeader() {
		return header;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetHeader(Header newHeader, NotificationChain msgs) {
		Header oldHeader = header;
		header = newHeader;
		if(eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Geometry_datatypesPackage.QUATERNION_STAMPED__HEADER, oldHeader, newHeader);
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
	public void setHeader(Header newHeader) {
		if(newHeader != header) {
			NotificationChain msgs = null;
			if(header != null)
				msgs = ((InternalEObject)header).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Geometry_datatypesPackage.QUATERNION_STAMPED__HEADER, null, msgs);
			if(newHeader != null)
				msgs = ((InternalEObject)newHeader).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Geometry_datatypesPackage.QUATERNION_STAMPED__HEADER, null, msgs);
			msgs = basicSetHeader(newHeader, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Geometry_datatypesPackage.QUATERNION_STAMPED__HEADER, newHeader, newHeader));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Quaternion getQuaternion() {
		return quaternion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetQuaternion(Quaternion newQuaternion, NotificationChain msgs) {
		Quaternion oldQuaternion = quaternion;
		quaternion = newQuaternion;
		if(eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Geometry_datatypesPackage.QUATERNION_STAMPED__QUATERNION, oldQuaternion, newQuaternion);
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
	public void setQuaternion(Quaternion newQuaternion) {
		if(newQuaternion != quaternion) {
			NotificationChain msgs = null;
			if(quaternion != null)
				msgs = ((InternalEObject)quaternion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Geometry_datatypesPackage.QUATERNION_STAMPED__QUATERNION, null, msgs);
			if(newQuaternion != null)
				msgs = ((InternalEObject)newQuaternion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Geometry_datatypesPackage.QUATERNION_STAMPED__QUATERNION, null, msgs);
			msgs = basicSetQuaternion(newQuaternion, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Geometry_datatypesPackage.QUATERNION_STAMPED__QUATERNION, newQuaternion, newQuaternion));
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
		case Geometry_datatypesPackage.QUATERNION_STAMPED__HEADER:
			return basicSetHeader(null, msgs);
		case Geometry_datatypesPackage.QUATERNION_STAMPED__QUATERNION:
			return basicSetQuaternion(null, msgs);
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
		case Geometry_datatypesPackage.QUATERNION_STAMPED__HEADER:
			return getHeader();
		case Geometry_datatypesPackage.QUATERNION_STAMPED__QUATERNION:
			return getQuaternion();
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
		case Geometry_datatypesPackage.QUATERNION_STAMPED__HEADER:
			setHeader((Header)newValue);
			return;
		case Geometry_datatypesPackage.QUATERNION_STAMPED__QUATERNION:
			setQuaternion((Quaternion)newValue);
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
		case Geometry_datatypesPackage.QUATERNION_STAMPED__HEADER:
			setHeader((Header)null);
			return;
		case Geometry_datatypesPackage.QUATERNION_STAMPED__QUATERNION:
			setQuaternion((Quaternion)null);
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
		case Geometry_datatypesPackage.QUATERNION_STAMPED__HEADER:
			return header != null;
		case Geometry_datatypesPackage.QUATERNION_STAMPED__QUATERNION:
			return quaternion != null;
		}
		return super.eIsSet(featureID);
	}

} //QuaternionStampedImpl
