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

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisManagerConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisManagerRepresentation;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.IAxisConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationPackage;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.ILabelProviderConfiguration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Axis Manager Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.AxisManagerConfigurationImpl#getLocalHeaderLabelConfiguration
 * <em>Local Header Label Configuration</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.AxisManagerConfigurationImpl#getAxisManager <em>Axis
 * Manager</em>}</li>
 * <li>
 * {@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.AxisManagerConfigurationImpl#getLocalSpecificConfigurations
 * <em>Local Specific Configurations</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class AxisManagerConfigurationImpl extends MinimalEObjectImpl.Container implements AxisManagerConfiguration {

	/**
	 * The cached value of the '{@link #getLocalHeaderLabelConfiguration() <em>Local Header Label Configuration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getLocalHeaderLabelConfiguration()
	 * @generated
	 * @ordered
	 */
	protected ILabelProviderConfiguration localHeaderLabelConfiguration;

	/**
	 * The cached value of the '{@link #getAxisManager() <em>Axis Manager</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getAxisManager()
	 * @generated
	 * @ordered
	 */
	protected AxisManagerRepresentation axisManager;

	/**
	 * The cached value of the '{@link #getLocalSpecificConfigurations() <em>Local Specific Configurations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getLocalSpecificConfigurations()
	 * @generated
	 * @ordered
	 */
	protected EList<IAxisConfiguration> localSpecificConfigurations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected AxisManagerConfigurationImpl() {
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
		return NattableaxisconfigurationPackage.Literals.AXIS_MANAGER_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ILabelProviderConfiguration getLocalHeaderLabelConfiguration() {
		if(localHeaderLabelConfiguration != null && localHeaderLabelConfiguration.eIsProxy()) {
			InternalEObject oldLocalHeaderLabelConfiguration = (InternalEObject)localHeaderLabelConfiguration;
			localHeaderLabelConfiguration = (ILabelProviderConfiguration)eResolveProxy(oldLocalHeaderLabelConfiguration);
			if(localHeaderLabelConfiguration != oldLocalHeaderLabelConfiguration) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NattableaxisconfigurationPackage.AXIS_MANAGER_CONFIGURATION__LOCAL_HEADER_LABEL_CONFIGURATION, oldLocalHeaderLabelConfiguration, localHeaderLabelConfiguration));
			}
		}
		return localHeaderLabelConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ILabelProviderConfiguration basicGetLocalHeaderLabelConfiguration() {
		return localHeaderLabelConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setLocalHeaderLabelConfiguration(ILabelProviderConfiguration newLocalHeaderLabelConfiguration) {
		ILabelProviderConfiguration oldLocalHeaderLabelConfiguration = localHeaderLabelConfiguration;
		localHeaderLabelConfiguration = newLocalHeaderLabelConfiguration;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NattableaxisconfigurationPackage.AXIS_MANAGER_CONFIGURATION__LOCAL_HEADER_LABEL_CONFIGURATION, oldLocalHeaderLabelConfiguration, localHeaderLabelConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public AxisManagerRepresentation getAxisManager() {
		if(axisManager != null && axisManager.eIsProxy()) {
			InternalEObject oldAxisManager = (InternalEObject)axisManager;
			axisManager = (AxisManagerRepresentation)eResolveProxy(oldAxisManager);
			if(axisManager != oldAxisManager) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NattableaxisconfigurationPackage.AXIS_MANAGER_CONFIGURATION__AXIS_MANAGER, oldAxisManager, axisManager));
			}
		}
		return axisManager;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public AxisManagerRepresentation basicGetAxisManager() {
		return axisManager;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setAxisManager(AxisManagerRepresentation newAxisManager) {
		AxisManagerRepresentation oldAxisManager = axisManager;
		axisManager = newAxisManager;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NattableaxisconfigurationPackage.AXIS_MANAGER_CONFIGURATION__AXIS_MANAGER, oldAxisManager, axisManager));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<IAxisConfiguration> getLocalSpecificConfigurations() {
		if(localSpecificConfigurations == null) {
			localSpecificConfigurations = new EObjectResolvingEList<IAxisConfiguration>(IAxisConfiguration.class, this, NattableaxisconfigurationPackage.AXIS_MANAGER_CONFIGURATION__LOCAL_SPECIFIC_CONFIGURATIONS);
		}
		return localSpecificConfigurations;
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
		case NattableaxisconfigurationPackage.AXIS_MANAGER_CONFIGURATION__LOCAL_HEADER_LABEL_CONFIGURATION:
			if(resolve)
				return getLocalHeaderLabelConfiguration();
			return basicGetLocalHeaderLabelConfiguration();
		case NattableaxisconfigurationPackage.AXIS_MANAGER_CONFIGURATION__AXIS_MANAGER:
			if(resolve)
				return getAxisManager();
			return basicGetAxisManager();
		case NattableaxisconfigurationPackage.AXIS_MANAGER_CONFIGURATION__LOCAL_SPECIFIC_CONFIGURATIONS:
			return getLocalSpecificConfigurations();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch(featureID) {
		case NattableaxisconfigurationPackage.AXIS_MANAGER_CONFIGURATION__LOCAL_HEADER_LABEL_CONFIGURATION:
			setLocalHeaderLabelConfiguration((ILabelProviderConfiguration)newValue);
			return;
		case NattableaxisconfigurationPackage.AXIS_MANAGER_CONFIGURATION__AXIS_MANAGER:
			setAxisManager((AxisManagerRepresentation)newValue);
			return;
		case NattableaxisconfigurationPackage.AXIS_MANAGER_CONFIGURATION__LOCAL_SPECIFIC_CONFIGURATIONS:
			getLocalSpecificConfigurations().clear();
			getLocalSpecificConfigurations().addAll((Collection<? extends IAxisConfiguration>)newValue);
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
		case NattableaxisconfigurationPackage.AXIS_MANAGER_CONFIGURATION__LOCAL_HEADER_LABEL_CONFIGURATION:
			setLocalHeaderLabelConfiguration((ILabelProviderConfiguration)null);
			return;
		case NattableaxisconfigurationPackage.AXIS_MANAGER_CONFIGURATION__AXIS_MANAGER:
			setAxisManager((AxisManagerRepresentation)null);
			return;
		case NattableaxisconfigurationPackage.AXIS_MANAGER_CONFIGURATION__LOCAL_SPECIFIC_CONFIGURATIONS:
			getLocalSpecificConfigurations().clear();
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
		case NattableaxisconfigurationPackage.AXIS_MANAGER_CONFIGURATION__LOCAL_HEADER_LABEL_CONFIGURATION:
			return localHeaderLabelConfiguration != null;
		case NattableaxisconfigurationPackage.AXIS_MANAGER_CONFIGURATION__AXIS_MANAGER:
			return axisManager != null;
		case NattableaxisconfigurationPackage.AXIS_MANAGER_CONFIGURATION__LOCAL_SPECIFIC_CONFIGURATIONS:
			return localSpecificConfigurations != null && !localSpecificConfigurations.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //AxisManagerConfigurationImpl
