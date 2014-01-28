/**
 * Copyright (c) 2013 CEA LIST.
 * 
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.infra.extendedtypes.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.infra.extendedtypes.ExtendedtypesPackage;
import org.eclipse.papyrus.infra.extendedtypes.ViewTypeConfiguration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>View Type Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.infra.extendedtypes.impl.ViewTypeConfigurationImpl#getSpecializedDiagramTypeID <em>Specialized Diagram Type ID</em>}
 * </li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public abstract class ViewTypeConfigurationImpl extends ElementTypeConfigurationImpl implements ViewTypeConfiguration {

	/**
	 * The default value of the '{@link #getSpecializedDiagramTypeID() <em>Specialized Diagram Type ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getSpecializedDiagramTypeID()
	 * @generated
	 * @ordered
	 */
	protected static final String SPECIALIZED_DIAGRAM_TYPE_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSpecializedDiagramTypeID() <em>Specialized Diagram Type ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getSpecializedDiagramTypeID()
	 * @generated
	 * @ordered
	 */
	protected String specializedDiagramTypeID = SPECIALIZED_DIAGRAM_TYPE_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ViewTypeConfigurationImpl() {
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
		return ExtendedtypesPackage.eINSTANCE.getViewTypeConfiguration();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getSpecializedDiagramTypeID() {
		return specializedDiagramTypeID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setSpecializedDiagramTypeID(String newSpecializedDiagramTypeID) {
		String oldSpecializedDiagramTypeID = specializedDiagramTypeID;
		specializedDiagramTypeID = newSpecializedDiagramTypeID;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExtendedtypesPackage.VIEW_TYPE_CONFIGURATION__SPECIALIZED_DIAGRAM_TYPE_ID, oldSpecializedDiagramTypeID, specializedDiagramTypeID));
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
		case ExtendedtypesPackage.VIEW_TYPE_CONFIGURATION__SPECIALIZED_DIAGRAM_TYPE_ID:
			return getSpecializedDiagramTypeID();
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
		case ExtendedtypesPackage.VIEW_TYPE_CONFIGURATION__SPECIALIZED_DIAGRAM_TYPE_ID:
			setSpecializedDiagramTypeID((String)newValue);
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
		case ExtendedtypesPackage.VIEW_TYPE_CONFIGURATION__SPECIALIZED_DIAGRAM_TYPE_ID:
			setSpecializedDiagramTypeID(SPECIALIZED_DIAGRAM_TYPE_ID_EDEFAULT);
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
		case ExtendedtypesPackage.VIEW_TYPE_CONFIGURATION__SPECIALIZED_DIAGRAM_TYPE_ID:
			return SPECIALIZED_DIAGRAM_TYPE_ID_EDEFAULT == null ? specializedDiagramTypeID != null : !SPECIALIZED_DIAGRAM_TYPE_ID_EDEFAULT.equals(specializedDiagramTypeID);
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
		result.append(" (specializedDiagramTypeID: "); //$NON-NLS-1$
		result.append(specializedDiagramTypeID);
		result.append(')');
		return result.toString();
	}
} //ViewTypeConfigurationImpl
