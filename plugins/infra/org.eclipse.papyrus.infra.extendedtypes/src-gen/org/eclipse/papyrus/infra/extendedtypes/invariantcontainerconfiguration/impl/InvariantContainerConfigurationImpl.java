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

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.infra.extendedtypes.invariantcontainerconfiguration.HierarchyPermission;
import org.eclipse.papyrus.infra.extendedtypes.invariantcontainerconfiguration.InvariantContainerConfiguration;
import org.eclipse.papyrus.infra.extendedtypes.invariantcontainerconfiguration.InvariantContainerConfigurationPackage;

import org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.impl.InvariantRuleConfigurationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Invariant Container Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.extendedtypes.invariantcontainerconfiguration.impl.InvariantContainerConfigurationImpl#getPermissions <em>Permissions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InvariantContainerConfigurationImpl extends InvariantRuleConfigurationImpl implements InvariantContainerConfiguration {
	/**
	 * The cached value of the '{@link #getPermissions() <em>Permissions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPermissions()
	 * @generated
	 * @ordered
	 */
	protected EList<HierarchyPermission> permissions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InvariantContainerConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InvariantContainerConfigurationPackage.Literals.INVARIANT_CONTAINER_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<HierarchyPermission> getPermissions() {
		if (permissions == null) {
			permissions = new EObjectContainmentEList<HierarchyPermission>(HierarchyPermission.class, this, InvariantContainerConfigurationPackage.INVARIANT_CONTAINER_CONFIGURATION__PERMISSIONS);
		}
		return permissions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case InvariantContainerConfigurationPackage.INVARIANT_CONTAINER_CONFIGURATION__PERMISSIONS:
				return ((InternalEList<?>)getPermissions()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case InvariantContainerConfigurationPackage.INVARIANT_CONTAINER_CONFIGURATION__PERMISSIONS:
				return getPermissions();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case InvariantContainerConfigurationPackage.INVARIANT_CONTAINER_CONFIGURATION__PERMISSIONS:
				getPermissions().clear();
				getPermissions().addAll((Collection<? extends HierarchyPermission>)newValue);
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
			case InvariantContainerConfigurationPackage.INVARIANT_CONTAINER_CONFIGURATION__PERMISSIONS:
				getPermissions().clear();
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
			case InvariantContainerConfigurationPackage.INVARIANT_CONTAINER_CONFIGURATION__PERMISSIONS:
				return permissions != null && !permissions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //InvariantContainerConfigurationImpl
