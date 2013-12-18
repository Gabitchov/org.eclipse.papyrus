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
package org.eclipse.papyrus.infra.extendedtypes.invariantcontainerconfiguration.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.papyrus.infra.extendedtypes.invariantcontainerconfiguration.HierarchyPermission;
import org.eclipse.papyrus.infra.extendedtypes.invariantcontainerconfiguration.InvariantContainerConfigurationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Hierarchy Permission</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.extendedtypes.invariantcontainerconfiguration.impl.HierarchyPermissionImpl#getChildType <em>Child Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.extendedtypes.invariantcontainerconfiguration.impl.HierarchyPermissionImpl#isIsPermitted <em>Is Permitted</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.extendedtypes.invariantcontainerconfiguration.impl.HierarchyPermissionImpl#isIsStrict <em>Is Strict</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class HierarchyPermissionImpl extends MinimalEObjectImpl.Container implements HierarchyPermission {
	/**
	 * The default value of the '{@link #getChildType() <em>Child Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildType()
	 * @generated
	 * @ordered
	 */
	protected static final String CHILD_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getChildType() <em>Child Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildType()
	 * @generated
	 * @ordered
	 */
	protected String childType = CHILD_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsPermitted() <em>Is Permitted</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsPermitted()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_PERMITTED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsPermitted() <em>Is Permitted</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsPermitted()
	 * @generated
	 * @ordered
	 */
	protected boolean isPermitted = IS_PERMITTED_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsStrict() <em>Is Strict</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsStrict()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_STRICT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsStrict() <em>Is Strict</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsStrict()
	 * @generated
	 * @ordered
	 */
	protected boolean isStrict = IS_STRICT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HierarchyPermissionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InvariantContainerConfigurationPackage.Literals.HIERARCHY_PERMISSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getChildType() {
		return childType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChildType(String newChildType) {
		String oldChildType = childType;
		childType = newChildType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InvariantContainerConfigurationPackage.HIERARCHY_PERMISSION__CHILD_TYPE, oldChildType, childType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsPermitted() {
		return isPermitted;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsPermitted(boolean newIsPermitted) {
		boolean oldIsPermitted = isPermitted;
		isPermitted = newIsPermitted;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InvariantContainerConfigurationPackage.HIERARCHY_PERMISSION__IS_PERMITTED, oldIsPermitted, isPermitted));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsStrict() {
		return isStrict;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsStrict(boolean newIsStrict) {
		boolean oldIsStrict = isStrict;
		isStrict = newIsStrict;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InvariantContainerConfigurationPackage.HIERARCHY_PERMISSION__IS_STRICT, oldIsStrict, isStrict));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case InvariantContainerConfigurationPackage.HIERARCHY_PERMISSION__CHILD_TYPE:
				return getChildType();
			case InvariantContainerConfigurationPackage.HIERARCHY_PERMISSION__IS_PERMITTED:
				return isIsPermitted();
			case InvariantContainerConfigurationPackage.HIERARCHY_PERMISSION__IS_STRICT:
				return isIsStrict();
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
			case InvariantContainerConfigurationPackage.HIERARCHY_PERMISSION__CHILD_TYPE:
				setChildType((String)newValue);
				return;
			case InvariantContainerConfigurationPackage.HIERARCHY_PERMISSION__IS_PERMITTED:
				setIsPermitted((Boolean)newValue);
				return;
			case InvariantContainerConfigurationPackage.HIERARCHY_PERMISSION__IS_STRICT:
				setIsStrict((Boolean)newValue);
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
			case InvariantContainerConfigurationPackage.HIERARCHY_PERMISSION__CHILD_TYPE:
				setChildType(CHILD_TYPE_EDEFAULT);
				return;
			case InvariantContainerConfigurationPackage.HIERARCHY_PERMISSION__IS_PERMITTED:
				setIsPermitted(IS_PERMITTED_EDEFAULT);
				return;
			case InvariantContainerConfigurationPackage.HIERARCHY_PERMISSION__IS_STRICT:
				setIsStrict(IS_STRICT_EDEFAULT);
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
			case InvariantContainerConfigurationPackage.HIERARCHY_PERMISSION__CHILD_TYPE:
				return CHILD_TYPE_EDEFAULT == null ? childType != null : !CHILD_TYPE_EDEFAULT.equals(childType);
			case InvariantContainerConfigurationPackage.HIERARCHY_PERMISSION__IS_PERMITTED:
				return isPermitted != IS_PERMITTED_EDEFAULT;
			case InvariantContainerConfigurationPackage.HIERARCHY_PERMISSION__IS_STRICT:
				return isStrict != IS_STRICT_EDEFAULT;
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
		result.append(" (childType: ");
		result.append(childType);
		result.append(", isPermitted: ");
		result.append(isPermitted);
		result.append(", isStrict: ");
		result.append(isStrict);
		result.append(')');
		return result.toString();
	}

} //HierarchyPermissionImpl
