/**
 * Copyright (c) 2013 CEA LIST
 * 
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Ansgar Radermacher - Initial API and implementation
 * 
 */
package org.eclipse.papyrus.FCM.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.papyrus.FCM.ConfigOption;
import org.eclipse.papyrus.FCM.Configuration;
import org.eclipse.papyrus.FCM.DeploymentPlan;
import org.eclipse.papyrus.FCM.FCMPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.FCM.impl.ConfigurationImpl#getBase_Class <em>Base Class</em>}</li>
 *   <li>{@link org.eclipse.papyrus.FCM.impl.ConfigurationImpl#getConfigOptions <em>Config Options</em>}</li>
 *   <li>{@link org.eclipse.papyrus.FCM.impl.ConfigurationImpl#getDeploymentPlan <em>Deployment Plan</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConfigurationImpl extends EObjectImpl implements Configuration {
	/**
	 * The cached value of the '{@link #getBase_Class() <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Class()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.Class base_Class;

	/**
	 * The cached value of the '{@link #getConfigOptions() <em>Config Options</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfigOptions()
	 * @generated
	 * @ordered
	 */
	protected EList<ConfigOption> configOptions;

	/**
	 * The cached value of the '{@link #getDeploymentPlan() <em>Deployment Plan</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeploymentPlan()
	 * @generated
	 * @ordered
	 */
	protected DeploymentPlan deploymentPlan;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FCMPackage.Literals.CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class getBase_Class() {
		if (base_Class != null && base_Class.eIsProxy()) {
			InternalEObject oldBase_Class = (InternalEObject)base_Class;
			base_Class = (org.eclipse.uml2.uml.Class)eResolveProxy(oldBase_Class);
			if (base_Class != oldBase_Class) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FCMPackage.CONFIGURATION__BASE_CLASS, oldBase_Class, base_Class));
			}
		}
		return base_Class;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class basicGetBase_Class() {
		return base_Class;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Class(org.eclipse.uml2.uml.Class newBase_Class) {
		org.eclipse.uml2.uml.Class oldBase_Class = base_Class;
		base_Class = newBase_Class;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FCMPackage.CONFIGURATION__BASE_CLASS, oldBase_Class, base_Class));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConfigOption> getConfigOptions() {
		if (configOptions == null) {
			configOptions = new EObjectResolvingEList<ConfigOption>(ConfigOption.class, this, FCMPackage.CONFIGURATION__CONFIG_OPTIONS);
		}
		return configOptions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeploymentPlan getDeploymentPlan() {
		if (deploymentPlan != null && deploymentPlan.eIsProxy()) {
			InternalEObject oldDeploymentPlan = (InternalEObject)deploymentPlan;
			deploymentPlan = (DeploymentPlan)eResolveProxy(oldDeploymentPlan);
			if (deploymentPlan != oldDeploymentPlan) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FCMPackage.CONFIGURATION__DEPLOYMENT_PLAN, oldDeploymentPlan, deploymentPlan));
			}
		}
		return deploymentPlan;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeploymentPlan basicGetDeploymentPlan() {
		return deploymentPlan;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeploymentPlan(DeploymentPlan newDeploymentPlan) {
		DeploymentPlan oldDeploymentPlan = deploymentPlan;
		deploymentPlan = newDeploymentPlan;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FCMPackage.CONFIGURATION__DEPLOYMENT_PLAN, oldDeploymentPlan, deploymentPlan));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FCMPackage.CONFIGURATION__BASE_CLASS:
				if (resolve) return getBase_Class();
				return basicGetBase_Class();
			case FCMPackage.CONFIGURATION__CONFIG_OPTIONS:
				return getConfigOptions();
			case FCMPackage.CONFIGURATION__DEPLOYMENT_PLAN:
				if (resolve) return getDeploymentPlan();
				return basicGetDeploymentPlan();
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
			case FCMPackage.CONFIGURATION__BASE_CLASS:
				setBase_Class((org.eclipse.uml2.uml.Class)newValue);
				return;
			case FCMPackage.CONFIGURATION__CONFIG_OPTIONS:
				getConfigOptions().clear();
				getConfigOptions().addAll((Collection<? extends ConfigOption>)newValue);
				return;
			case FCMPackage.CONFIGURATION__DEPLOYMENT_PLAN:
				setDeploymentPlan((DeploymentPlan)newValue);
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
			case FCMPackage.CONFIGURATION__BASE_CLASS:
				setBase_Class((org.eclipse.uml2.uml.Class)null);
				return;
			case FCMPackage.CONFIGURATION__CONFIG_OPTIONS:
				getConfigOptions().clear();
				return;
			case FCMPackage.CONFIGURATION__DEPLOYMENT_PLAN:
				setDeploymentPlan((DeploymentPlan)null);
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
			case FCMPackage.CONFIGURATION__BASE_CLASS:
				return base_Class != null;
			case FCMPackage.CONFIGURATION__CONFIG_OPTIONS:
				return configOptions != null && !configOptions.isEmpty();
			case FCMPackage.CONFIGURATION__DEPLOYMENT_PLAN:
				return deploymentPlan != null;
		}
		return super.eIsSet(featureID);
	}

} //ConfigurationImpl
