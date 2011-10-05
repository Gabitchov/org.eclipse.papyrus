/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.Tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.di.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.di.DiPackage;
import org.eclipse.papyrus.di.SimpleSemanticModelElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Simple Semantic Model Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.di.impl.SimpleSemanticModelElementImpl#getTypeinfo <em>Typeinfo</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class SimpleSemanticModelElementImpl extends SemanticModelBridgeImpl implements SimpleSemanticModelElement {

	/**
	 * The default value of the '{@link #getTypeinfo() <em>Typeinfo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getTypeinfo()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPEINFO_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTypeinfo() <em>Typeinfo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getTypeinfo()
	 * @generated
	 * @ordered
	 */
	protected String typeinfo = TYPEINFO_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected SimpleSemanticModelElementImpl() {
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
		return DiPackage.Literals.SIMPLE_SEMANTIC_MODEL_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getTypeinfo() {
		return typeinfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setTypeinfo(String newTypeinfo) {
		String oldTypeinfo = typeinfo;
		typeinfo = newTypeinfo;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiPackage.SIMPLE_SEMANTIC_MODEL_ELEMENT__TYPEINFO, oldTypeinfo, typeinfo));
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
		case DiPackage.SIMPLE_SEMANTIC_MODEL_ELEMENT__TYPEINFO:
			return getTypeinfo();
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
		case DiPackage.SIMPLE_SEMANTIC_MODEL_ELEMENT__TYPEINFO:
			setTypeinfo((String)newValue);
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
		case DiPackage.SIMPLE_SEMANTIC_MODEL_ELEMENT__TYPEINFO:
			setTypeinfo(TYPEINFO_EDEFAULT);
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
		case DiPackage.SIMPLE_SEMANTIC_MODEL_ELEMENT__TYPEINFO:
			return TYPEINFO_EDEFAULT == null ? typeinfo != null : !TYPEINFO_EDEFAULT.equals(typeinfo);
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
		result.append(" (typeinfo: ");
		result.append(typeinfo);
		result.append(')');
		return result.toString();
	}

} //SimpleSemanticModelElementImpl
