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
package org.eclipse.papyrus.infra.nattable.model.tableeditorconfiguration.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.infra.nattable.model.tableeditorconfiguration.LocalTableEditorConfiguration;
import org.eclipse.papyrus.infra.nattable.model.tableeditorconfiguration.TableEditorConfiguration;
import org.eclipse.papyrus.infra.nattable.model.tableeditorconfiguration.TableEditorConfigurationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Local Table Editor Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.tableeditorconfiguration.impl.LocalTableEditorConfigurationImpl#getDefaultTableEditorConfiguration <em>Default Table Editor Configuration</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LocalTableEditorConfigurationImpl extends TableEditorConfigurationImpl implements LocalTableEditorConfiguration {
	/**
	 * The cached value of the '{@link #getDefaultTableEditorConfiguration() <em>Default Table Editor Configuration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultTableEditorConfiguration()
	 * @generated
	 * @ordered
	 */
	protected TableEditorConfiguration defaultTableEditorConfiguration;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LocalTableEditorConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TableEditorConfigurationPackage.Literals.LOCAL_TABLE_EDITOR_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TableEditorConfiguration getDefaultTableEditorConfiguration() {
		if (defaultTableEditorConfiguration != null && defaultTableEditorConfiguration.eIsProxy()) {
			InternalEObject oldDefaultTableEditorConfiguration = (InternalEObject)defaultTableEditorConfiguration;
			defaultTableEditorConfiguration = (TableEditorConfiguration)eResolveProxy(oldDefaultTableEditorConfiguration);
			if (defaultTableEditorConfiguration != oldDefaultTableEditorConfiguration) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TableEditorConfigurationPackage.LOCAL_TABLE_EDITOR_CONFIGURATION__DEFAULT_TABLE_EDITOR_CONFIGURATION, oldDefaultTableEditorConfiguration, defaultTableEditorConfiguration));
			}
		}
		return defaultTableEditorConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TableEditorConfiguration basicGetDefaultTableEditorConfiguration() {
		return defaultTableEditorConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultTableEditorConfiguration(TableEditorConfiguration newDefaultTableEditorConfiguration) {
		TableEditorConfiguration oldDefaultTableEditorConfiguration = defaultTableEditorConfiguration;
		defaultTableEditorConfiguration = newDefaultTableEditorConfiguration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TableEditorConfigurationPackage.LOCAL_TABLE_EDITOR_CONFIGURATION__DEFAULT_TABLE_EDITOR_CONFIGURATION, oldDefaultTableEditorConfiguration, defaultTableEditorConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TableEditorConfigurationPackage.LOCAL_TABLE_EDITOR_CONFIGURATION__DEFAULT_TABLE_EDITOR_CONFIGURATION:
				if (resolve) return getDefaultTableEditorConfiguration();
				return basicGetDefaultTableEditorConfiguration();
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
			case TableEditorConfigurationPackage.LOCAL_TABLE_EDITOR_CONFIGURATION__DEFAULT_TABLE_EDITOR_CONFIGURATION:
				setDefaultTableEditorConfiguration((TableEditorConfiguration)newValue);
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
			case TableEditorConfigurationPackage.LOCAL_TABLE_EDITOR_CONFIGURATION__DEFAULT_TABLE_EDITOR_CONFIGURATION:
				setDefaultTableEditorConfiguration((TableEditorConfiguration)null);
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
			case TableEditorConfigurationPackage.LOCAL_TABLE_EDITOR_CONFIGURATION__DEFAULT_TABLE_EDITOR_CONFIGURATION:
				return defaultTableEditorConfiguration != null;
		}
		return super.eIsSet(featureID);
	}

} //LocalTableEditorConfigurationImpl
