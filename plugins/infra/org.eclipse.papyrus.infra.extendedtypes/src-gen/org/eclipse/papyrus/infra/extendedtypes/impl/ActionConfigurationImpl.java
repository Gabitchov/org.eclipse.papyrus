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
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.infra.extendedtypes.ActionConfiguration;
import org.eclipse.papyrus.infra.extendedtypes.ExtendedtypesPackage;

import org.eclipse.papyrus.infra.queries.core.configuration.QueryConfiguration;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Action Configuration</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.infra.extendedtypes.impl.ActionConfigurationImpl#getPreValidationQueryConfiguration <em>Pre Validation Query
 * Configuration</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public abstract class ActionConfigurationImpl extends ConfigurationElementImpl implements ActionConfiguration {

	/**
	 * The cached value of the '{@link #getPreValidationQueryConfiguration()
	 * <em>Pre Validation Query Configuration</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPreValidationQueryConfiguration()
	 * @generated
	 * @ordered
	 */
	protected QueryConfiguration preValidationQueryConfiguration;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ActionConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExtendedtypesPackage.eINSTANCE.getActionConfiguration();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public QueryConfiguration getPreValidationQueryConfiguration() {
		if(preValidationQueryConfiguration != null && preValidationQueryConfiguration.eIsProxy()) {
			InternalEObject oldPreValidationQueryConfiguration = (InternalEObject)preValidationQueryConfiguration;
			preValidationQueryConfiguration = (QueryConfiguration)eResolveProxy(oldPreValidationQueryConfiguration);
			if(preValidationQueryConfiguration != oldPreValidationQueryConfiguration) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExtendedtypesPackage.ACTION_CONFIGURATION__PRE_VALIDATION_QUERY_CONFIGURATION, oldPreValidationQueryConfiguration, preValidationQueryConfiguration));
			}
		}
		return preValidationQueryConfiguration;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public QueryConfiguration basicGetPreValidationQueryConfiguration() {
		return preValidationQueryConfiguration;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setPreValidationQueryConfiguration(QueryConfiguration newPreValidationQueryConfiguration) {
		QueryConfiguration oldPreValidationQueryConfiguration = preValidationQueryConfiguration;
		preValidationQueryConfiguration = newPreValidationQueryConfiguration;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExtendedtypesPackage.ACTION_CONFIGURATION__PRE_VALIDATION_QUERY_CONFIGURATION, oldPreValidationQueryConfiguration, preValidationQueryConfiguration));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch(featureID) {
		case ExtendedtypesPackage.ACTION_CONFIGURATION__PRE_VALIDATION_QUERY_CONFIGURATION:
			if(resolve)
				return getPreValidationQueryConfiguration();
			return basicGetPreValidationQueryConfiguration();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch(featureID) {
		case ExtendedtypesPackage.ACTION_CONFIGURATION__PRE_VALIDATION_QUERY_CONFIGURATION:
			setPreValidationQueryConfiguration((QueryConfiguration)newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch(featureID) {
		case ExtendedtypesPackage.ACTION_CONFIGURATION__PRE_VALIDATION_QUERY_CONFIGURATION:
			setPreValidationQueryConfiguration((QueryConfiguration)null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch(featureID) {
		case ExtendedtypesPackage.ACTION_CONFIGURATION__PRE_VALIDATION_QUERY_CONFIGURATION:
			return preValidationQueryConfiguration != null;
		}
		return super.eIsSet(featureID);
	}
} // ActionConfigurationImpl
