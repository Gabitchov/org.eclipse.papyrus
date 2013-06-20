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
import org.eclipse.papyrus.RobotML.Algorithm;
import org.eclipse.papyrus.RobotML.RobotMLPackage;
import org.eclipse.uml2.uml.Operation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Algorithm</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.RobotML.impl.AlgorithmImpl#getBase_Operation <em>Base Operation</em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotML.impl.AlgorithmImpl#isIsExternal <em>Is External</em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotML.impl.AlgorithmImpl#getExtFunctionName <em>Ext Function Name</em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotML.impl.AlgorithmImpl#getLibPath <em>Lib Path</em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotML.impl.AlgorithmImpl#getLibFileFormat <em>Lib File Format</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class AlgorithmImpl extends EObjectImpl implements Algorithm {

	/**
	 * The cached value of the '{@link #getBase_Operation() <em>Base Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getBase_Operation()
	 * @generated
	 * @ordered
	 */
	protected Operation base_Operation;

	/**
	 * The default value of the '{@link #isIsExternal() <em>Is External</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #isIsExternal()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_EXTERNAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsExternal() <em>Is External</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #isIsExternal()
	 * @generated
	 * @ordered
	 */
	protected boolean isExternal = IS_EXTERNAL_EDEFAULT;

	/**
	 * The default value of the '{@link #getExtFunctionName() <em>Ext Function Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getExtFunctionName()
	 * @generated
	 * @ordered
	 */
	protected static final String EXT_FUNCTION_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExtFunctionName() <em>Ext Function Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getExtFunctionName()
	 * @generated
	 * @ordered
	 */
	protected String extFunctionName = EXT_FUNCTION_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getLibPath() <em>Lib Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getLibPath()
	 * @generated
	 * @ordered
	 */
	protected static final String LIB_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLibPath() <em>Lib Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getLibPath()
	 * @generated
	 * @ordered
	 */
	protected String libPath = LIB_PATH_EDEFAULT;

	/**
	 * The default value of the '{@link #getLibFileFormat() <em>Lib File Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getLibFileFormat()
	 * @generated
	 * @ordered
	 */
	protected static final String LIB_FILE_FORMAT_EDEFAULT = "elf";

	/**
	 * The cached value of the '{@link #getLibFileFormat() <em>Lib File Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getLibFileFormat()
	 * @generated
	 * @ordered
	 */
	protected String libFileFormat = LIB_FILE_FORMAT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected AlgorithmImpl() {
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
		return RobotMLPackage.Literals.ALGORITHM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Operation getBase_Operation() {
		if(base_Operation != null && base_Operation.eIsProxy()) {
			InternalEObject oldBase_Operation = (InternalEObject)base_Operation;
			base_Operation = (Operation)eResolveProxy(oldBase_Operation);
			if(base_Operation != oldBase_Operation) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RobotMLPackage.ALGORITHM__BASE_OPERATION, oldBase_Operation, base_Operation));
			}
		}
		return base_Operation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Operation basicGetBase_Operation() {
		return base_Operation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setBase_Operation(Operation newBase_Operation) {
		Operation oldBase_Operation = base_Operation;
		base_Operation = newBase_Operation;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.ALGORITHM__BASE_OPERATION, oldBase_Operation, base_Operation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isIsExternal() {
		return isExternal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setIsExternal(boolean newIsExternal) {
		boolean oldIsExternal = isExternal;
		isExternal = newIsExternal;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.ALGORITHM__IS_EXTERNAL, oldIsExternal, isExternal));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getExtFunctionName() {
		return extFunctionName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setExtFunctionName(String newExtFunctionName) {
		String oldExtFunctionName = extFunctionName;
		extFunctionName = newExtFunctionName;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.ALGORITHM__EXT_FUNCTION_NAME, oldExtFunctionName, extFunctionName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getLibPath() {
		return libPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setLibPath(String newLibPath) {
		String oldLibPath = libPath;
		libPath = newLibPath;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.ALGORITHM__LIB_PATH, oldLibPath, libPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getLibFileFormat() {
		return libFileFormat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setLibFileFormat(String newLibFileFormat) {
		String oldLibFileFormat = libFileFormat;
		libFileFormat = newLibFileFormat;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.ALGORITHM__LIB_FILE_FORMAT, oldLibFileFormat, libFileFormat));
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
		case RobotMLPackage.ALGORITHM__BASE_OPERATION:
			if(resolve)
				return getBase_Operation();
			return basicGetBase_Operation();
		case RobotMLPackage.ALGORITHM__IS_EXTERNAL:
			return isIsExternal();
		case RobotMLPackage.ALGORITHM__EXT_FUNCTION_NAME:
			return getExtFunctionName();
		case RobotMLPackage.ALGORITHM__LIB_PATH:
			return getLibPath();
		case RobotMLPackage.ALGORITHM__LIB_FILE_FORMAT:
			return getLibFileFormat();
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
		case RobotMLPackage.ALGORITHM__BASE_OPERATION:
			setBase_Operation((Operation)newValue);
			return;
		case RobotMLPackage.ALGORITHM__IS_EXTERNAL:
			setIsExternal((Boolean)newValue);
			return;
		case RobotMLPackage.ALGORITHM__EXT_FUNCTION_NAME:
			setExtFunctionName((String)newValue);
			return;
		case RobotMLPackage.ALGORITHM__LIB_PATH:
			setLibPath((String)newValue);
			return;
		case RobotMLPackage.ALGORITHM__LIB_FILE_FORMAT:
			setLibFileFormat((String)newValue);
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
		case RobotMLPackage.ALGORITHM__BASE_OPERATION:
			setBase_Operation((Operation)null);
			return;
		case RobotMLPackage.ALGORITHM__IS_EXTERNAL:
			setIsExternal(IS_EXTERNAL_EDEFAULT);
			return;
		case RobotMLPackage.ALGORITHM__EXT_FUNCTION_NAME:
			setExtFunctionName(EXT_FUNCTION_NAME_EDEFAULT);
			return;
		case RobotMLPackage.ALGORITHM__LIB_PATH:
			setLibPath(LIB_PATH_EDEFAULT);
			return;
		case RobotMLPackage.ALGORITHM__LIB_FILE_FORMAT:
			setLibFileFormat(LIB_FILE_FORMAT_EDEFAULT);
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
		case RobotMLPackage.ALGORITHM__BASE_OPERATION:
			return base_Operation != null;
		case RobotMLPackage.ALGORITHM__IS_EXTERNAL:
			return isExternal != IS_EXTERNAL_EDEFAULT;
		case RobotMLPackage.ALGORITHM__EXT_FUNCTION_NAME:
			return EXT_FUNCTION_NAME_EDEFAULT == null ? extFunctionName != null : !EXT_FUNCTION_NAME_EDEFAULT.equals(extFunctionName);
		case RobotMLPackage.ALGORITHM__LIB_PATH:
			return LIB_PATH_EDEFAULT == null ? libPath != null : !LIB_PATH_EDEFAULT.equals(libPath);
		case RobotMLPackage.ALGORITHM__LIB_FILE_FORMAT:
			return LIB_FILE_FORMAT_EDEFAULT == null ? libFileFormat != null : !LIB_FILE_FORMAT_EDEFAULT.equals(libFileFormat);
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
		result.append(" (isExternal: ");
		result.append(isExternal);
		result.append(", extFunctionName: ");
		result.append(extFunctionName);
		result.append(", libPath: ");
		result.append(libPath);
		result.append(", libFileFormat: ");
		result.append(libFileFormat);
		result.append(')');
		return result.toString();
	}

} //AlgorithmImpl
