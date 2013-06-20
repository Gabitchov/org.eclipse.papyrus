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
package org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.MultiArrayDimension;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.MultiArrayLayout;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Std_datatypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Multi Array Layout</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.MultiArrayLayoutImpl#getDim <em>Dim</em>}
 * </li>
 * <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.MultiArrayLayoutImpl#getData_offset <em>
 * Data offset</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class MultiArrayLayoutImpl extends EObjectImpl implements MultiArrayLayout {

	/**
	 * The cached value of the '{@link #getDim() <em>Dim</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getDim()
	 * @generated
	 * @ordered
	 */
	protected EList<MultiArrayDimension> dim;

	/**
	 * The default value of the '{@link #getData_offset() <em>Data offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getData_offset()
	 * @generated
	 * @ordered
	 */
	protected static final long DATA_OFFSET_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getData_offset() <em>Data offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getData_offset()
	 * @generated
	 * @ordered
	 */
	protected long data_offset = DATA_OFFSET_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected MultiArrayLayoutImpl() {
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
		return Std_datatypesPackage.Literals.MULTI_ARRAY_LAYOUT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<MultiArrayDimension> getDim() {
		if(dim == null) {
			dim = new EObjectContainmentEList<MultiArrayDimension>(MultiArrayDimension.class, this, Std_datatypesPackage.MULTI_ARRAY_LAYOUT__DIM);
		}
		return dim;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public long getData_offset() {
		return data_offset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setData_offset(long newData_offset) {
		long oldData_offset = data_offset;
		data_offset = newData_offset;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Std_datatypesPackage.MULTI_ARRAY_LAYOUT__DATA_OFFSET, oldData_offset, data_offset));
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
		case Std_datatypesPackage.MULTI_ARRAY_LAYOUT__DIM:
			return ((InternalEList<?>)getDim()).basicRemove(otherEnd, msgs);
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
		case Std_datatypesPackage.MULTI_ARRAY_LAYOUT__DIM:
			return getDim();
		case Std_datatypesPackage.MULTI_ARRAY_LAYOUT__DATA_OFFSET:
			return getData_offset();
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
		case Std_datatypesPackage.MULTI_ARRAY_LAYOUT__DIM:
			getDim().clear();
			getDim().addAll((Collection<? extends MultiArrayDimension>)newValue);
			return;
		case Std_datatypesPackage.MULTI_ARRAY_LAYOUT__DATA_OFFSET:
			setData_offset((Long)newValue);
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
		case Std_datatypesPackage.MULTI_ARRAY_LAYOUT__DIM:
			getDim().clear();
			return;
		case Std_datatypesPackage.MULTI_ARRAY_LAYOUT__DATA_OFFSET:
			setData_offset(DATA_OFFSET_EDEFAULT);
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
		case Std_datatypesPackage.MULTI_ARRAY_LAYOUT__DIM:
			return dim != null && !dim.isEmpty();
		case Std_datatypesPackage.MULTI_ARRAY_LAYOUT__DATA_OFFSET:
			return data_offset != DATA_OFFSET_EDEFAULT;
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
		result.append(" (data_offset: ");
		result.append(data_offset);
		result.append(')');
		return result.toString();
	}

} //MultiArrayLayoutImpl
