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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.papyrus.RobotML.RobotMLPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.RobotML.impl.SystemImpl#getBase_Class <em>Base Class</em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotML.impl.SystemImpl#isNative <em>Native</em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotML.impl.SystemImpl#getLibraryPath <em>Library Path</em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotML.impl.SystemImpl#getLibraryComponentName <em>Library Component Name</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class SystemImpl extends EObjectImpl implements org.eclipse.papyrus.RobotML.System {

	/**
	 * The cached value of the '{@link #getBase_Class() <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getBase_Class()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.Class base_Class;

	/**
	 * The default value of the '{@link #isNative() <em>Native</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #isNative()
	 * @generated
	 * @ordered
	 */
	protected static final boolean NATIVE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isNative() <em>Native</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #isNative()
	 * @generated
	 * @ordered
	 */
	protected boolean native_ = NATIVE_EDEFAULT;

	/**
	 * The default value of the '{@link #getLibraryPath() <em>Library Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getLibraryPath()
	 * @generated
	 * @ordered
	 */
	protected static final String LIBRARY_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLibraryPath() <em>Library Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getLibraryPath()
	 * @generated
	 * @ordered
	 */
	protected String libraryPath = LIBRARY_PATH_EDEFAULT;

	/**
	 * The default value of the '{@link #getLibraryComponentName() <em>Library Component Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getLibraryComponentName()
	 * @generated
	 * @ordered
	 */
	protected static final String LIBRARY_COMPONENT_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLibraryComponentName() <em>Library Component Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getLibraryComponentName()
	 * @generated
	 * @ordered
	 */
	protected String libraryComponentName = LIBRARY_COMPONENT_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected SystemImpl() {
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
		return RobotMLPackage.Literals.SYSTEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class getBase_Class() {
		if(base_Class != null && base_Class.eIsProxy()) {
			InternalEObject oldBase_Class = (InternalEObject)base_Class;
			base_Class = (org.eclipse.uml2.uml.Class)eResolveProxy(oldBase_Class);
			if(base_Class != oldBase_Class) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RobotMLPackage.SYSTEM__BASE_CLASS, oldBase_Class, base_Class));
			}
		}
		return base_Class;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class basicGetBase_Class() {
		return base_Class;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setBase_Class(org.eclipse.uml2.uml.Class newBase_Class) {
		org.eclipse.uml2.uml.Class oldBase_Class = base_Class;
		base_Class = newBase_Class;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.SYSTEM__BASE_CLASS, oldBase_Class, base_Class));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isNative() {
		return native_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setNative(boolean newNative) {
		boolean oldNative = native_;
		native_ = newNative;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.SYSTEM__NATIVE, oldNative, native_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getLibraryPath() {
		return libraryPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setLibraryPath(String newLibraryPath) {
		String oldLibraryPath = libraryPath;
		libraryPath = newLibraryPath;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.SYSTEM__LIBRARY_PATH, oldLibraryPath, libraryPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getLibraryComponentName() {
		return libraryComponentName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setLibraryComponentName(String newLibraryComponentName) {
		String oldLibraryComponentName = libraryComponentName;
		libraryComponentName = newLibraryComponentName;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.SYSTEM__LIBRARY_COMPONENT_NAME, oldLibraryComponentName, libraryComponentName));
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
		case RobotMLPackage.SYSTEM__BASE_CLASS:
			if(resolve)
				return getBase_Class();
			return basicGetBase_Class();
		case RobotMLPackage.SYSTEM__NATIVE:
			return isNative();
		case RobotMLPackage.SYSTEM__LIBRARY_PATH:
			return getLibraryPath();
		case RobotMLPackage.SYSTEM__LIBRARY_COMPONENT_NAME:
			return getLibraryComponentName();
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
		case RobotMLPackage.SYSTEM__BASE_CLASS:
			setBase_Class((org.eclipse.uml2.uml.Class)newValue);
			return;
		case RobotMLPackage.SYSTEM__NATIVE:
			setNative((Boolean)newValue);
			return;
		case RobotMLPackage.SYSTEM__LIBRARY_PATH:
			setLibraryPath((String)newValue);
			return;
		case RobotMLPackage.SYSTEM__LIBRARY_COMPONENT_NAME:
			setLibraryComponentName((String)newValue);
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
		case RobotMLPackage.SYSTEM__BASE_CLASS:
			setBase_Class((org.eclipse.uml2.uml.Class)null);
			return;
		case RobotMLPackage.SYSTEM__NATIVE:
			setNative(NATIVE_EDEFAULT);
			return;
		case RobotMLPackage.SYSTEM__LIBRARY_PATH:
			setLibraryPath(LIBRARY_PATH_EDEFAULT);
			return;
		case RobotMLPackage.SYSTEM__LIBRARY_COMPONENT_NAME:
			setLibraryComponentName(LIBRARY_COMPONENT_NAME_EDEFAULT);
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
		case RobotMLPackage.SYSTEM__BASE_CLASS:
			return base_Class != null;
		case RobotMLPackage.SYSTEM__NATIVE:
			return native_ != NATIVE_EDEFAULT;
		case RobotMLPackage.SYSTEM__LIBRARY_PATH:
			return LIBRARY_PATH_EDEFAULT == null ? libraryPath != null : !LIBRARY_PATH_EDEFAULT.equals(libraryPath);
		case RobotMLPackage.SYSTEM__LIBRARY_COMPONENT_NAME:
			return LIBRARY_COMPONENT_NAME_EDEFAULT == null ? libraryComponentName != null : !LIBRARY_COMPONENT_NAME_EDEFAULT.equals(libraryComponentName);
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
		result.append(" (native: ");
		result.append(native_);
		result.append(", libraryPath: ");
		result.append(libraryPath);
		result.append(", libraryComponentName: ");
		result.append(libraryComponentName);
		result.append(')');
		return result.toString();
	}

} //SystemImpl
