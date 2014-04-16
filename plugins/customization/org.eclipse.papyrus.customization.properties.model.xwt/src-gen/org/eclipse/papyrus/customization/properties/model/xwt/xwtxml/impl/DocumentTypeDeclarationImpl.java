/**
 * *******************************************************************************
 * Copyright (c) 2009 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 
 *     Fabien Giquel (Mia-Software) - initial API and implementation
 * *******************************************************************************
 *
 */
package org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.DocumentTypeDeclaration;
import org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.XwtxmlPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Document Type Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.impl.DocumentTypeDeclarationImpl#getPublicID <em>Public ID</em>}</li>
 *   <li>{@link org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.impl.DocumentTypeDeclarationImpl#getSystemID <em>System ID</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DocumentTypeDeclarationImpl extends NodeImpl implements DocumentTypeDeclaration {
	/**
	 * The default value of the '{@link #getPublicID() <em>Public ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPublicID()
	 * @generated
	 * @ordered
	 */
	protected static final String PUBLIC_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPublicID() <em>Public ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPublicID()
	 * @generated
	 * @ordered
	 */
	protected String publicID = PUBLIC_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getSystemID() <em>System ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSystemID()
	 * @generated
	 * @ordered
	 */
	protected static final String SYSTEM_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSystemID() <em>System ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSystemID()
	 * @generated
	 * @ordered
	 */
	protected String systemID = SYSTEM_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DocumentTypeDeclarationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XwtxmlPackage.Literals.DOCUMENT_TYPE_DECLARATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPublicID() {
		return publicID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPublicID(String newPublicID) {
		String oldPublicID = publicID;
		publicID = newPublicID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XwtxmlPackage.DOCUMENT_TYPE_DECLARATION__PUBLIC_ID, oldPublicID, publicID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSystemID() {
		return systemID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSystemID(String newSystemID) {
		String oldSystemID = systemID;
		systemID = newSystemID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XwtxmlPackage.DOCUMENT_TYPE_DECLARATION__SYSTEM_ID, oldSystemID, systemID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case XwtxmlPackage.DOCUMENT_TYPE_DECLARATION__PUBLIC_ID:
				return getPublicID();
			case XwtxmlPackage.DOCUMENT_TYPE_DECLARATION__SYSTEM_ID:
				return getSystemID();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case XwtxmlPackage.DOCUMENT_TYPE_DECLARATION__PUBLIC_ID:
				setPublicID((String)newValue);
				return;
			case XwtxmlPackage.DOCUMENT_TYPE_DECLARATION__SYSTEM_ID:
				setSystemID((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case XwtxmlPackage.DOCUMENT_TYPE_DECLARATION__PUBLIC_ID:
				setPublicID(PUBLIC_ID_EDEFAULT);
				return;
			case XwtxmlPackage.DOCUMENT_TYPE_DECLARATION__SYSTEM_ID:
				setSystemID(SYSTEM_ID_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case XwtxmlPackage.DOCUMENT_TYPE_DECLARATION__PUBLIC_ID:
				return PUBLIC_ID_EDEFAULT == null ? publicID != null : !PUBLIC_ID_EDEFAULT.equals(publicID);
			case XwtxmlPackage.DOCUMENT_TYPE_DECLARATION__SYSTEM_ID:
				return SYSTEM_ID_EDEFAULT == null ? systemID != null : !SYSTEM_ID_EDEFAULT.equals(systemID);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (publicID: ");
		result.append(publicID);
		result.append(", systemID: ");
		result.append(systemID);
		result.append(')');
		return result.toString();
	}

} //DocumentTypeDeclarationImpl
