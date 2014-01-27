/**
 * Copyright (c) 2013 CEA LIST.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 * 	CEA LIST - Initial API and implementation
 * 
 */
package org.eclipse.papyrus.infra.newchild.ElementCreationMenuModel.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.infra.newchild.ElementCreationMenuModel.CreationMenu;
import org.eclipse.papyrus.infra.newchild.ElementCreationMenuModel.ElementCreationMenuModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Creation Menu</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.newchild.ElementCreationMenuModel.impl.CreationMenuImpl#getElementTypeIdRef <em>Element Type Id Ref</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.newchild.ElementCreationMenuModel.impl.CreationMenuImpl#getRole <em>Role</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.newchild.ElementCreationMenuModel.impl.CreationMenuImpl#isDisplayAllRoles <em>Display All Roles</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CreationMenuImpl extends MenuImpl implements CreationMenu {
	/**
	 * The default value of the '{@link #getElementTypeIdRef() <em>Element Type Id Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElementTypeIdRef()
	 * @generated
	 * @ordered
	 */
	protected static final String ELEMENT_TYPE_ID_REF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getElementTypeIdRef() <em>Element Type Id Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElementTypeIdRef()
	 * @generated
	 * @ordered
	 */
	protected String elementTypeIdRef = ELEMENT_TYPE_ID_REF_EDEFAULT;

	/**
	 * The default value of the '{@link #getRole() <em>Role</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRole()
	 * @generated
	 * @ordered
	 */
	protected static final String ROLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRole() <em>Role</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRole()
	 * @generated
	 * @ordered
	 */
	protected String role = ROLE_EDEFAULT;

	/**
	 * The default value of the '{@link #isDisplayAllRoles() <em>Display All Roles</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDisplayAllRoles()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DISPLAY_ALL_ROLES_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isDisplayAllRoles() <em>Display All Roles</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDisplayAllRoles()
	 * @generated
	 * @ordered
	 */
	protected boolean displayAllRoles = DISPLAY_ALL_ROLES_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CreationMenuImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ElementCreationMenuModelPackage.Literals.CREATION_MENU;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getElementTypeIdRef() {
		return elementTypeIdRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElementTypeIdRef(String newElementTypeIdRef) {
		String oldElementTypeIdRef = elementTypeIdRef;
		elementTypeIdRef = newElementTypeIdRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ElementCreationMenuModelPackage.CREATION_MENU__ELEMENT_TYPE_ID_REF, oldElementTypeIdRef, elementTypeIdRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRole() {
		return role;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRole(String newRole) {
		String oldRole = role;
		role = newRole;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ElementCreationMenuModelPackage.CREATION_MENU__ROLE, oldRole, role));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDisplayAllRoles() {
		return displayAllRoles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDisplayAllRoles(boolean newDisplayAllRoles) {
		boolean oldDisplayAllRoles = displayAllRoles;
		displayAllRoles = newDisplayAllRoles;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ElementCreationMenuModelPackage.CREATION_MENU__DISPLAY_ALL_ROLES, oldDisplayAllRoles, displayAllRoles));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ElementCreationMenuModelPackage.CREATION_MENU__ELEMENT_TYPE_ID_REF:
				return getElementTypeIdRef();
			case ElementCreationMenuModelPackage.CREATION_MENU__ROLE:
				return getRole();
			case ElementCreationMenuModelPackage.CREATION_MENU__DISPLAY_ALL_ROLES:
				return isDisplayAllRoles();
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
			case ElementCreationMenuModelPackage.CREATION_MENU__ELEMENT_TYPE_ID_REF:
				setElementTypeIdRef((String)newValue);
				return;
			case ElementCreationMenuModelPackage.CREATION_MENU__ROLE:
				setRole((String)newValue);
				return;
			case ElementCreationMenuModelPackage.CREATION_MENU__DISPLAY_ALL_ROLES:
				setDisplayAllRoles((Boolean)newValue);
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
			case ElementCreationMenuModelPackage.CREATION_MENU__ELEMENT_TYPE_ID_REF:
				setElementTypeIdRef(ELEMENT_TYPE_ID_REF_EDEFAULT);
				return;
			case ElementCreationMenuModelPackage.CREATION_MENU__ROLE:
				setRole(ROLE_EDEFAULT);
				return;
			case ElementCreationMenuModelPackage.CREATION_MENU__DISPLAY_ALL_ROLES:
				setDisplayAllRoles(DISPLAY_ALL_ROLES_EDEFAULT);
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
			case ElementCreationMenuModelPackage.CREATION_MENU__ELEMENT_TYPE_ID_REF:
				return ELEMENT_TYPE_ID_REF_EDEFAULT == null ? elementTypeIdRef != null : !ELEMENT_TYPE_ID_REF_EDEFAULT.equals(elementTypeIdRef);
			case ElementCreationMenuModelPackage.CREATION_MENU__ROLE:
				return ROLE_EDEFAULT == null ? role != null : !ROLE_EDEFAULT.equals(role);
			case ElementCreationMenuModelPackage.CREATION_MENU__DISPLAY_ALL_ROLES:
				return displayAllRoles != DISPLAY_ALL_ROLES_EDEFAULT;
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
		result.append(" (elementTypeIdRef: ");
		result.append(elementTypeIdRef);
		result.append(", role: ");
		result.append(role);
		result.append(", displayAllRoles: ");
		result.append(displayAllRoles);
		result.append(')');
		return result.toString();
	}

} //CreationMenuImpl
