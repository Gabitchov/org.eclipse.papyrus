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
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.MultiArrayLayout;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Std_datatypesPackage;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.UIint16MultiArray;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>UIint16 Multi Array</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.UIint16MultiArrayImpl#getLayout <em>
 * Layout</em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.UIint16MultiArrayImpl#getData <em>Data
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class UIint16MultiArrayImpl extends EObjectImpl implements UIint16MultiArray {

	/**
	 * The cached value of the '{@link #getLayout() <em>Layout</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getLayout()
	 * @generated
	 * @ordered
	 */
	protected MultiArrayLayout layout;

	/**
	 * The cached value of the '{@link #getData() <em>Data</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getData()
	 * @generated
	 * @ordered
	 */
	protected EList<Integer> data;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected UIint16MultiArrayImpl() {
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
		return Std_datatypesPackage.Literals.UIINT16_MULTI_ARRAY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public MultiArrayLayout getLayout() {
		return layout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetLayout(MultiArrayLayout newLayout, NotificationChain msgs) {
		MultiArrayLayout oldLayout = layout;
		layout = newLayout;
		if(eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Std_datatypesPackage.UIINT16_MULTI_ARRAY__LAYOUT, oldLayout, newLayout);
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
	public void setLayout(MultiArrayLayout newLayout) {
		if(newLayout != layout) {
			NotificationChain msgs = null;
			if(layout != null)
				msgs = ((InternalEObject)layout).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Std_datatypesPackage.UIINT16_MULTI_ARRAY__LAYOUT, null, msgs);
			if(newLayout != null)
				msgs = ((InternalEObject)newLayout).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Std_datatypesPackage.UIINT16_MULTI_ARRAY__LAYOUT, null, msgs);
			msgs = basicSetLayout(newLayout, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Std_datatypesPackage.UIINT16_MULTI_ARRAY__LAYOUT, newLayout, newLayout));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Integer> getData() {
		if(data == null) {
			data = new EDataTypeUniqueEList<Integer>(Integer.class, this, Std_datatypesPackage.UIINT16_MULTI_ARRAY__DATA);
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
		case Std_datatypesPackage.UIINT16_MULTI_ARRAY__LAYOUT:
			return basicSetLayout(null, msgs);
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
		case Std_datatypesPackage.UIINT16_MULTI_ARRAY__LAYOUT:
			return getLayout();
		case Std_datatypesPackage.UIINT16_MULTI_ARRAY__DATA:
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
		case Std_datatypesPackage.UIINT16_MULTI_ARRAY__LAYOUT:
			setLayout((MultiArrayLayout)newValue);
			return;
		case Std_datatypesPackage.UIINT16_MULTI_ARRAY__DATA:
			getData().clear();
			getData().addAll((Collection<? extends Integer>)newValue);
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
		case Std_datatypesPackage.UIINT16_MULTI_ARRAY__LAYOUT:
			setLayout((MultiArrayLayout)null);
			return;
		case Std_datatypesPackage.UIINT16_MULTI_ARRAY__DATA:
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
		case Std_datatypesPackage.UIINT16_MULTI_ARRAY__LAYOUT:
			return layout != null;
		case Std_datatypesPackage.UIINT16_MULTI_ARRAY__DATA:
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

} //UIint16MultiArrayImpl
