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
 * 	Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisManagerConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.LocalTableHeaderAxisConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Local Table Header Axis Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.LocalTableHeaderAxisConfigurationImpl#getAxisManagerConfigurations <em>Axis Manager Configurations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LocalTableHeaderAxisConfigurationImpl extends AbstractHeaderAxisConfigurationImpl implements LocalTableHeaderAxisConfiguration {

	/**
	 * The cached value of the '{@link #getAxisManagerConfigurations() <em>Axis Manager Configurations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAxisManagerConfigurations()
	 * @generated
	 * @ordered
	 */
	protected EList<AxisManagerConfiguration> axisManagerConfigurations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LocalTableHeaderAxisConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NattableaxisconfigurationPackage.Literals.LOCAL_TABLE_HEADER_AXIS_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AxisManagerConfiguration> getAxisManagerConfigurations() {
		if (axisManagerConfigurations == null) {
			axisManagerConfigurations = new EObjectContainmentEList<AxisManagerConfiguration>(AxisManagerConfiguration.class, this, NattableaxisconfigurationPackage.LOCAL_TABLE_HEADER_AXIS_CONFIGURATION__AXIS_MANAGER_CONFIGURATIONS);
		}
		return axisManagerConfigurations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case NattableaxisconfigurationPackage.LOCAL_TABLE_HEADER_AXIS_CONFIGURATION__AXIS_MANAGER_CONFIGURATIONS:
				return ((InternalEList<?>)getAxisManagerConfigurations()).basicRemove(otherEnd, msgs);
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
			case NattableaxisconfigurationPackage.LOCAL_TABLE_HEADER_AXIS_CONFIGURATION__AXIS_MANAGER_CONFIGURATIONS:
				return getAxisManagerConfigurations();
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
			case NattableaxisconfigurationPackage.LOCAL_TABLE_HEADER_AXIS_CONFIGURATION__AXIS_MANAGER_CONFIGURATIONS:
				getAxisManagerConfigurations().clear();
				getAxisManagerConfigurations().addAll((Collection<? extends AxisManagerConfiguration>)newValue);
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
			case NattableaxisconfigurationPackage.LOCAL_TABLE_HEADER_AXIS_CONFIGURATION__AXIS_MANAGER_CONFIGURATIONS:
				getAxisManagerConfigurations().clear();
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
			case NattableaxisconfigurationPackage.LOCAL_TABLE_HEADER_AXIS_CONFIGURATION__AXIS_MANAGER_CONFIGURATIONS:
				return axisManagerConfigurations != null && !axisManagerConfigurations.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //LocalTableHeaderAxisConfigurationImpl
