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
package org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.CompressedImage;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.Sensor_datatypesPackage;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Header;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Compressed Image</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.CompressedImageImpl#getHeader <em>
 * Header</em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.CompressedImageImpl#getFormat <em>
 * Format</em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.CompressedImageImpl#getData <em>Data
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class CompressedImageImpl extends EObjectImpl implements CompressedImage {

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
	 * The default value of the '{@link #getFormat() <em>Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getFormat()
	 * @generated
	 * @ordered
	 */
	protected static final String FORMAT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFormat() <em>Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getFormat()
	 * @generated
	 * @ordered
	 */
	protected String format = FORMAT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getData() <em>Data</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getData()
	 * @generated
	 * @ordered
	 */
	protected EList<Character> data;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected CompressedImageImpl() {
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
		return Sensor_datatypesPackage.Literals.COMPRESSED_IMAGE;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.COMPRESSED_IMAGE__HEADER, oldHeader, newHeader);
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
				msgs = ((InternalEObject)header).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Sensor_datatypesPackage.COMPRESSED_IMAGE__HEADER, null, msgs);
			if(newHeader != null)
				msgs = ((InternalEObject)newHeader).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Sensor_datatypesPackage.COMPRESSED_IMAGE__HEADER, null, msgs);
			msgs = basicSetHeader(newHeader, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.COMPRESSED_IMAGE__HEADER, newHeader, newHeader));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getFormat() {
		return format;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setFormat(String newFormat) {
		String oldFormat = format;
		format = newFormat;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.COMPRESSED_IMAGE__FORMAT, oldFormat, format));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Character> getData() {
		if(data == null) {
			data = new EDataTypeUniqueEList<Character>(Character.class, this, Sensor_datatypesPackage.COMPRESSED_IMAGE__DATA);
		}
		return data;
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
		case Sensor_datatypesPackage.COMPRESSED_IMAGE__HEADER:
			return basicSetHeader(null, msgs);
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
		case Sensor_datatypesPackage.COMPRESSED_IMAGE__HEADER:
			return getHeader();
		case Sensor_datatypesPackage.COMPRESSED_IMAGE__FORMAT:
			return getFormat();
		case Sensor_datatypesPackage.COMPRESSED_IMAGE__DATA:
			return getData();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch(featureID) {
		case Sensor_datatypesPackage.COMPRESSED_IMAGE__HEADER:
			setHeader((Header)newValue);
			return;
		case Sensor_datatypesPackage.COMPRESSED_IMAGE__FORMAT:
			setFormat((String)newValue);
			return;
		case Sensor_datatypesPackage.COMPRESSED_IMAGE__DATA:
			getData().clear();
			getData().addAll((Collection<? extends Character>)newValue);
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
		case Sensor_datatypesPackage.COMPRESSED_IMAGE__HEADER:
			setHeader((Header)null);
			return;
		case Sensor_datatypesPackage.COMPRESSED_IMAGE__FORMAT:
			setFormat(FORMAT_EDEFAULT);
			return;
		case Sensor_datatypesPackage.COMPRESSED_IMAGE__DATA:
			getData().clear();
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
		case Sensor_datatypesPackage.COMPRESSED_IMAGE__HEADER:
			return header != null;
		case Sensor_datatypesPackage.COMPRESSED_IMAGE__FORMAT:
			return FORMAT_EDEFAULT == null ? format != null : !FORMAT_EDEFAULT.equals(format);
		case Sensor_datatypesPackage.COMPRESSED_IMAGE__DATA:
			return data != null && !data.isEmpty();
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
		result.append(" (format: ");
		result.append(format);
		result.append(", data: ");
		result.append(data);
		result.append(')');
		return result.toString();
	}

} //CompressedImageImpl
