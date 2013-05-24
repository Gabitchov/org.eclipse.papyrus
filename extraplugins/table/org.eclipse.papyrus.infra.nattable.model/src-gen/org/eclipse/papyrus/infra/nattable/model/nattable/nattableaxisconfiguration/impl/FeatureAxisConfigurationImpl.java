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

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.FeatureAxisConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature Axis Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.FeatureAxisConfigurationImpl#isShowOnlyCommonFeature <em>Show Only Common Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FeatureAxisConfigurationImpl extends MinimalEObjectImpl.Container implements FeatureAxisConfiguration {
	/**
	 * The default value of the '{@link #isShowOnlyCommonFeature() <em>Show Only Common Feature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isShowOnlyCommonFeature()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SHOW_ONLY_COMMON_FEATURE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isShowOnlyCommonFeature() <em>Show Only Common Feature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isShowOnlyCommonFeature()
	 * @generated
	 * @ordered
	 */
	protected boolean showOnlyCommonFeature = SHOW_ONLY_COMMON_FEATURE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FeatureAxisConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NattableaxisconfigurationPackage.Literals.FEATURE_AXIS_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isShowOnlyCommonFeature() {
		return showOnlyCommonFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShowOnlyCommonFeature(boolean newShowOnlyCommonFeature) {
		boolean oldShowOnlyCommonFeature = showOnlyCommonFeature;
		showOnlyCommonFeature = newShowOnlyCommonFeature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NattableaxisconfigurationPackage.FEATURE_AXIS_CONFIGURATION__SHOW_ONLY_COMMON_FEATURE, oldShowOnlyCommonFeature, showOnlyCommonFeature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case NattableaxisconfigurationPackage.FEATURE_AXIS_CONFIGURATION__SHOW_ONLY_COMMON_FEATURE:
				return isShowOnlyCommonFeature();
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
			case NattableaxisconfigurationPackage.FEATURE_AXIS_CONFIGURATION__SHOW_ONLY_COMMON_FEATURE:
				setShowOnlyCommonFeature((Boolean)newValue);
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
			case NattableaxisconfigurationPackage.FEATURE_AXIS_CONFIGURATION__SHOW_ONLY_COMMON_FEATURE:
				setShowOnlyCommonFeature(SHOW_ONLY_COMMON_FEATURE_EDEFAULT);
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
			case NattableaxisconfigurationPackage.FEATURE_AXIS_CONFIGURATION__SHOW_ONLY_COMMON_FEATURE:
				return showOnlyCommonFeature != SHOW_ONLY_COMMON_FEATURE_EDEFAULT;
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
		result.append(" (showOnlyCommonFeature: "); //$NON-NLS-1$
		result.append(showOnlyCommonFeature);
		result.append(')');
		return result.toString();
	}

} //FeatureAxisConfigurationImpl
