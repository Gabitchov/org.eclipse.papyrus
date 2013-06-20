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
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.Transform;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.Vector3;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transform</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.impl.TransformImpl#getTranslation <em>
 * Translation</em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.geometry_datatypes.impl.TransformImpl#getRotation <em>
 * Rotation</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class TransformImpl extends EObjectImpl implements Transform {

	/**
	 * The cached value of the '{@link #getTranslation() <em>Translation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getTranslation()
	 * @generated
	 * @ordered
	 */
	protected Vector3 translation;

	/**
	 * The cached value of the '{@link #getRotation() <em>Rotation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getRotation()
	 * @generated
	 * @ordered
	 */
	protected Quaternion rotation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected TransformImpl() {
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
		return Geometry_datatypesPackage.Literals.TRANSFORM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Vector3 getTranslation() {
		return translation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetTranslation(Vector3 newTranslation, NotificationChain msgs) {
		Vector3 oldTranslation = translation;
		translation = newTranslation;
		if(eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Geometry_datatypesPackage.TRANSFORM__TRANSLATION, oldTranslation, newTranslation);
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
	public void setTranslation(Vector3 newTranslation) {
		if(newTranslation != translation) {
			NotificationChain msgs = null;
			if(translation != null)
				msgs = ((InternalEObject)translation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Geometry_datatypesPackage.TRANSFORM__TRANSLATION, null, msgs);
			if(newTranslation != null)
				msgs = ((InternalEObject)newTranslation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Geometry_datatypesPackage.TRANSFORM__TRANSLATION, null, msgs);
			msgs = basicSetTranslation(newTranslation, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Geometry_datatypesPackage.TRANSFORM__TRANSLATION, newTranslation, newTranslation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Quaternion getRotation() {
		return rotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetRotation(Quaternion newRotation, NotificationChain msgs) {
		Quaternion oldRotation = rotation;
		rotation = newRotation;
		if(eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Geometry_datatypesPackage.TRANSFORM__ROTATION, oldRotation, newRotation);
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
	public void setRotation(Quaternion newRotation) {
		if(newRotation != rotation) {
			NotificationChain msgs = null;
			if(rotation != null)
				msgs = ((InternalEObject)rotation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Geometry_datatypesPackage.TRANSFORM__ROTATION, null, msgs);
			if(newRotation != null)
				msgs = ((InternalEObject)newRotation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Geometry_datatypesPackage.TRANSFORM__ROTATION, null, msgs);
			msgs = basicSetRotation(newRotation, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Geometry_datatypesPackage.TRANSFORM__ROTATION, newRotation, newRotation));
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
		case Geometry_datatypesPackage.TRANSFORM__TRANSLATION:
			return basicSetTranslation(null, msgs);
		case Geometry_datatypesPackage.TRANSFORM__ROTATION:
			return basicSetRotation(null, msgs);
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
		case Geometry_datatypesPackage.TRANSFORM__TRANSLATION:
			return getTranslation();
		case Geometry_datatypesPackage.TRANSFORM__ROTATION:
			return getRotation();
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
		case Geometry_datatypesPackage.TRANSFORM__TRANSLATION:
			setTranslation((Vector3)newValue);
			return;
		case Geometry_datatypesPackage.TRANSFORM__ROTATION:
			setRotation((Quaternion)newValue);
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
		case Geometry_datatypesPackage.TRANSFORM__TRANSLATION:
			setTranslation((Vector3)null);
			return;
		case Geometry_datatypesPackage.TRANSFORM__ROTATION:
			setRotation((Quaternion)null);
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
		case Geometry_datatypesPackage.TRANSFORM__TRANSLATION:
			return translation != null;
		case Geometry_datatypesPackage.TRANSFORM__ROTATION:
			return rotation != null;
		}
		return super.eIsSet(featureID);
	}

} //TransformImpl
