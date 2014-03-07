/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Sara TUCCI (CEA LIST) sara.tucci@cea.fr - Initial API and implementation
 *  Chokri MRAIDHA (CEA LIST) chokri.mraidha@cea.fr - Initial API and implementation
 *  David SERVAT (CEA LIST) david.servat@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.eastadl.variability.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureModel;
import org.eclipse.papyrus.eastadl.variability.FeatureConfiguration;
import org.eclipse.papyrus.eastadl.variability.VariabilityPackage;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.variability.impl.FeatureConfigurationImpl#getConfiguredFeatureModel <em>Configured Feature Model</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class FeatureConfigurationImpl extends ConfigurationDecisionModelImpl implements FeatureConfiguration {

	/**
	 * The cached value of the '{@link #getConfiguredFeatureModel() <em>Configured Feature Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getConfiguredFeatureModel()
	 * @generated
	 * @ordered
	 */
	protected FeatureModel configuredFeatureModel;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected FeatureConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public FeatureModel basicGetConfiguredFeatureModel() {
		return configuredFeatureModel;
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
		case VariabilityPackage.FEATURE_CONFIGURATION__CONFIGURED_FEATURE_MODEL:
			if(resolve)
				return getConfiguredFeatureModel();
			return basicGetConfiguredFeatureModel();
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
	public boolean eIsSet(int featureID) {
		switch(featureID) {
		case VariabilityPackage.FEATURE_CONFIGURATION__CONFIGURED_FEATURE_MODEL:
			return configuredFeatureModel != null;
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
	public void eSet(int featureID, Object newValue) {
		switch(featureID) {
		case VariabilityPackage.FEATURE_CONFIGURATION__CONFIGURED_FEATURE_MODEL:
			setConfiguredFeatureModel((FeatureModel)newValue);
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
	protected EClass eStaticClass() {
		return VariabilityPackage.Literals.FEATURE_CONFIGURATION;
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
		case VariabilityPackage.FEATURE_CONFIGURATION__CONFIGURED_FEATURE_MODEL:
			setConfiguredFeatureModel((FeatureModel)null);
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
	public FeatureModel getConfiguredFeatureModel() {
		if(configuredFeatureModel != null && configuredFeatureModel.eIsProxy()) {
			InternalEObject oldConfiguredFeatureModel = (InternalEObject)configuredFeatureModel;
			configuredFeatureModel = (FeatureModel)eResolveProxy(oldConfiguredFeatureModel);
			if(configuredFeatureModel != oldConfiguredFeatureModel) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VariabilityPackage.FEATURE_CONFIGURATION__CONFIGURED_FEATURE_MODEL, oldConfiguredFeatureModel, configuredFeatureModel));
			}
		}
		return configuredFeatureModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setConfiguredFeatureModel(FeatureModel newConfiguredFeatureModel) {
		FeatureModel oldConfiguredFeatureModel = configuredFeatureModel;
		configuredFeatureModel = newConfiguredFeatureModel;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VariabilityPackage.FEATURE_CONFIGURATION__CONFIGURED_FEATURE_MODEL, oldConfiguredFeatureModel, configuredFeatureModel));
	}

} //FeatureConfigurationImpl
