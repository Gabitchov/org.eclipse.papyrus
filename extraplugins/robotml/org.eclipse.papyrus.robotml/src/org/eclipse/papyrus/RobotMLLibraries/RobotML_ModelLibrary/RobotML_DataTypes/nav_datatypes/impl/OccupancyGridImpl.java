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
package org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.MapMetaData;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.Nav_datatypesPackage;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.OccupancyGrid;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Header;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Occupancy Grid</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.impl.OccupancyGridImpl#getHeader <em>Header
 * </em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.impl.OccupancyGridImpl#getInfo <em>Info</em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.nav_datatypes.impl.OccupancyGridImpl#getData <em>Data</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class OccupancyGridImpl extends EObjectImpl implements OccupancyGrid {

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
	 * The cached value of the '{@link #getInfo() <em>Info</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getInfo()
	 * @generated
	 * @ordered
	 */
	protected MapMetaData info;

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
	protected OccupancyGridImpl() {
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
		return Nav_datatypesPackage.Literals.OCCUPANCY_GRID;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Nav_datatypesPackage.OCCUPANCY_GRID__HEADER, oldHeader, newHeader);
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
				msgs = ((InternalEObject)header).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Nav_datatypesPackage.OCCUPANCY_GRID__HEADER, null, msgs);
			if(newHeader != null)
				msgs = ((InternalEObject)newHeader).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Nav_datatypesPackage.OCCUPANCY_GRID__HEADER, null, msgs);
			msgs = basicSetHeader(newHeader, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Nav_datatypesPackage.OCCUPANCY_GRID__HEADER, newHeader, newHeader));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public MapMetaData getInfo() {
		return info;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetInfo(MapMetaData newInfo, NotificationChain msgs) {
		MapMetaData oldInfo = info;
		info = newInfo;
		if(eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Nav_datatypesPackage.OCCUPANCY_GRID__INFO, oldInfo, newInfo);
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
	public void setInfo(MapMetaData newInfo) {
		if(newInfo != info) {
			NotificationChain msgs = null;
			if(info != null)
				msgs = ((InternalEObject)info).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Nav_datatypesPackage.OCCUPANCY_GRID__INFO, null, msgs);
			if(newInfo != null)
				msgs = ((InternalEObject)newInfo).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Nav_datatypesPackage.OCCUPANCY_GRID__INFO, null, msgs);
			msgs = basicSetInfo(newInfo, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Nav_datatypesPackage.OCCUPANCY_GRID__INFO, newInfo, newInfo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Character> getData() {
		if(data == null) {
			data = new EDataTypeUniqueEList<Character>(Character.class, this, Nav_datatypesPackage.OCCUPANCY_GRID__DATA);
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
		case Nav_datatypesPackage.OCCUPANCY_GRID__HEADER:
			return basicSetHeader(null, msgs);
		case Nav_datatypesPackage.OCCUPANCY_GRID__INFO:
			return basicSetInfo(null, msgs);
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
		case Nav_datatypesPackage.OCCUPANCY_GRID__HEADER:
			return getHeader();
		case Nav_datatypesPackage.OCCUPANCY_GRID__INFO:
			return getInfo();
		case Nav_datatypesPackage.OCCUPANCY_GRID__DATA:
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
		case Nav_datatypesPackage.OCCUPANCY_GRID__HEADER:
			setHeader((Header)newValue);
			return;
		case Nav_datatypesPackage.OCCUPANCY_GRID__INFO:
			setInfo((MapMetaData)newValue);
			return;
		case Nav_datatypesPackage.OCCUPANCY_GRID__DATA:
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
		case Nav_datatypesPackage.OCCUPANCY_GRID__HEADER:
			setHeader((Header)null);
			return;
		case Nav_datatypesPackage.OCCUPANCY_GRID__INFO:
			setInfo((MapMetaData)null);
			return;
		case Nav_datatypesPackage.OCCUPANCY_GRID__DATA:
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
		case Nav_datatypesPackage.OCCUPANCY_GRID__HEADER:
			return header != null;
		case Nav_datatypesPackage.OCCUPANCY_GRID__INFO:
			return info != null;
		case Nav_datatypesPackage.OCCUPANCY_GRID__DATA:
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
		result.append(" (data: ");
		result.append(data);
		result.append(')');
		return result.toString();
	}

} //OccupancyGridImpl
