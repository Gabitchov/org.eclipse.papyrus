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
package org.eclipse.papyrus.infra.extendedtypes.aspectsemantic.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.infra.extendedtypes.aspectsemantic.AspectSemanticPackage;
import org.eclipse.papyrus.infra.extendedtypes.aspectsemantic.AspectSemanticTypeAdviceConfiguration;
import org.eclipse.papyrus.infra.extendedtypes.aspectsemantic.AspectSemanticTypeConfiguration;

import org.eclipse.papyrus.infra.extendedtypes.impl.SemanticTypeConfigurationImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Type Configuration</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.eclipse.papyrus.infra.extendedtypes.aspectsemantic.impl.AspectSemanticTypeConfigurationImpl#getAdviceConfiguration
 * <em>Advice Configuration</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class AspectSemanticTypeConfigurationImpl extends
		SemanticTypeConfigurationImpl implements
		AspectSemanticTypeConfiguration {
	/**
	 * The cached value of the '{@link #getAdviceConfiguration()
	 * <em>Advice Configuration</em>}' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getAdviceConfiguration()
	 * @generated
	 * @ordered
	 */
	protected AspectSemanticTypeAdviceConfiguration adviceConfiguration;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected AspectSemanticTypeConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AspectSemanticPackage.eINSTANCE
				.getAspectSemanticTypeConfiguration();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public AspectSemanticTypeAdviceConfiguration getAdviceConfiguration() {
		return adviceConfiguration;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetAdviceConfiguration(
			AspectSemanticTypeAdviceConfiguration newAdviceConfiguration,
			NotificationChain msgs) {
		AspectSemanticTypeAdviceConfiguration oldAdviceConfiguration = adviceConfiguration;
		adviceConfiguration = newAdviceConfiguration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(
					this,
					Notification.SET,
					AspectSemanticPackage.ASPECT_SEMANTIC_TYPE_CONFIGURATION__ADVICE_CONFIGURATION,
					oldAdviceConfiguration, newAdviceConfiguration);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setAdviceConfiguration(
			AspectSemanticTypeAdviceConfiguration newAdviceConfiguration) {
		if (newAdviceConfiguration != adviceConfiguration) {
			NotificationChain msgs = null;
			if (adviceConfiguration != null)
				msgs = ((InternalEObject) adviceConfiguration)
						.eInverseRemove(
								this,
								EOPPOSITE_FEATURE_BASE
										- AspectSemanticPackage.ASPECT_SEMANTIC_TYPE_CONFIGURATION__ADVICE_CONFIGURATION,
								null, msgs);
			if (newAdviceConfiguration != null)
				msgs = ((InternalEObject) newAdviceConfiguration)
						.eInverseAdd(
								this,
								EOPPOSITE_FEATURE_BASE
										- AspectSemanticPackage.ASPECT_SEMANTIC_TYPE_CONFIGURATION__ADVICE_CONFIGURATION,
								null, msgs);
			msgs = basicSetAdviceConfiguration(newAdviceConfiguration, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(
					this,
					Notification.SET,
					AspectSemanticPackage.ASPECT_SEMANTIC_TYPE_CONFIGURATION__ADVICE_CONFIGURATION,
					newAdviceConfiguration, newAdviceConfiguration));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case AspectSemanticPackage.ASPECT_SEMANTIC_TYPE_CONFIGURATION__ADVICE_CONFIGURATION:
			return basicSetAdviceConfiguration(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case AspectSemanticPackage.ASPECT_SEMANTIC_TYPE_CONFIGURATION__ADVICE_CONFIGURATION:
			return getAdviceConfiguration();
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
		switch (featureID) {
		case AspectSemanticPackage.ASPECT_SEMANTIC_TYPE_CONFIGURATION__ADVICE_CONFIGURATION:
			setAdviceConfiguration((AspectSemanticTypeAdviceConfiguration) newValue);
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
		switch (featureID) {
		case AspectSemanticPackage.ASPECT_SEMANTIC_TYPE_CONFIGURATION__ADVICE_CONFIGURATION:
			setAdviceConfiguration((AspectSemanticTypeAdviceConfiguration) null);
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
		switch (featureID) {
		case AspectSemanticPackage.ASPECT_SEMANTIC_TYPE_CONFIGURATION__ADVICE_CONFIGURATION:
			return adviceConfiguration != null;
		}
		return super.eIsSet(featureID);
	}

} // AspectSemanticTypeConfigurationImpl
