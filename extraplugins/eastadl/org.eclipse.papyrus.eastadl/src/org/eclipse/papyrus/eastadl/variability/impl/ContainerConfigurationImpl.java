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
import org.eclipse.papyrus.eastadl.variability.ConfigurableContainer;
import org.eclipse.papyrus.eastadl.variability.ContainerConfiguration;
import org.eclipse.papyrus.eastadl.variability.VariabilityPackage;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Container Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.variability.impl.ContainerConfigurationImpl#getConfiguredContainer <em>Configured Container</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ContainerConfigurationImpl extends ConfigurationDecisionModelImpl implements ContainerConfiguration {
	/**
	 * The cached value of the '{@link #getConfiguredContainer() <em>Configured Container</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfiguredContainer()
	 * @generated
	 * @ordered
	 */
	protected ConfigurableContainer configuredContainer;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ContainerConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigurableContainer basicGetConfiguredContainer() {
		return configuredContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case VariabilityPackage.CONTAINER_CONFIGURATION__CONFIGURED_CONTAINER:
				if (resolve) return getConfiguredContainer();
				return basicGetConfiguredContainer();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case VariabilityPackage.CONTAINER_CONFIGURATION__CONFIGURED_CONTAINER:
				return configuredContainer != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case VariabilityPackage.CONTAINER_CONFIGURATION__CONFIGURED_CONTAINER:
				setConfiguredContainer((ConfigurableContainer)newValue);
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
	protected EClass eStaticClass() {
		return VariabilityPackage.Literals.CONTAINER_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case VariabilityPackage.CONTAINER_CONFIGURATION__CONFIGURED_CONTAINER:
				setConfiguredContainer((ConfigurableContainer)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigurableContainer getConfiguredContainer() {
		if (configuredContainer != null && configuredContainer.eIsProxy()) {
			InternalEObject oldConfiguredContainer = (InternalEObject)configuredContainer;
			configuredContainer = (ConfigurableContainer)eResolveProxy(oldConfiguredContainer);
			if (configuredContainer != oldConfiguredContainer) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VariabilityPackage.CONTAINER_CONFIGURATION__CONFIGURED_CONTAINER, oldConfiguredContainer, configuredContainer));
			}
		}
		return configuredContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConfiguredContainer(ConfigurableContainer newConfiguredContainer) {
		ConfigurableContainer oldConfiguredContainer = configuredContainer;
		configuredContainer = newConfiguredContainer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VariabilityPackage.CONTAINER_CONFIGURATION__CONFIGURED_CONTAINER, oldConfiguredContainer, configuredContainer));
	}

} //ContainerConfigurationImpl
