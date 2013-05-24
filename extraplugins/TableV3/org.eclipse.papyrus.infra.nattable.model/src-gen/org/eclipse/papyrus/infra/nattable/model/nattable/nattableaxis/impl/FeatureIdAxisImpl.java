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
package org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.FeatureAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.FeatureIdAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.NattableaxisPackage;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.FeatureLabelProviderConfiguration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature Id Axis</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.impl.FeatureIdAxisImpl#getLocalLabelConfiguration <em>Local Label Configuration</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FeatureIdAxisImpl extends IdAxisImpl implements FeatureIdAxis {
	/**
	 * The cached value of the '{@link #getLocalLabelConfiguration() <em>Local Label Configuration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocalLabelConfiguration()
	 * @generated
	 * @ordered
	 */
	protected FeatureLabelProviderConfiguration localLabelConfiguration;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FeatureIdAxisImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NattableaxisPackage.Literals.FEATURE_ID_AXIS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureLabelProviderConfiguration getLocalLabelConfiguration() {
		if (localLabelConfiguration != null && localLabelConfiguration.eIsProxy()) {
			InternalEObject oldLocalLabelConfiguration = (InternalEObject)localLabelConfiguration;
			localLabelConfiguration = (FeatureLabelProviderConfiguration)eResolveProxy(oldLocalLabelConfiguration);
			if (localLabelConfiguration != oldLocalLabelConfiguration) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NattableaxisPackage.FEATURE_ID_AXIS__LOCAL_LABEL_CONFIGURATION, oldLocalLabelConfiguration, localLabelConfiguration));
			}
		}
		return localLabelConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureLabelProviderConfiguration basicGetLocalLabelConfiguration() {
		return localLabelConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocalLabelConfiguration(FeatureLabelProviderConfiguration newLocalLabelConfiguration) {
		FeatureLabelProviderConfiguration oldLocalLabelConfiguration = localLabelConfiguration;
		localLabelConfiguration = newLocalLabelConfiguration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NattableaxisPackage.FEATURE_ID_AXIS__LOCAL_LABEL_CONFIGURATION, oldLocalLabelConfiguration, localLabelConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case NattableaxisPackage.FEATURE_ID_AXIS__LOCAL_LABEL_CONFIGURATION:
				if (resolve) return getLocalLabelConfiguration();
				return basicGetLocalLabelConfiguration();
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
			case NattableaxisPackage.FEATURE_ID_AXIS__LOCAL_LABEL_CONFIGURATION:
				setLocalLabelConfiguration((FeatureLabelProviderConfiguration)newValue);
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
			case NattableaxisPackage.FEATURE_ID_AXIS__LOCAL_LABEL_CONFIGURATION:
				setLocalLabelConfiguration((FeatureLabelProviderConfiguration)null);
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
			case NattableaxisPackage.FEATURE_ID_AXIS__LOCAL_LABEL_CONFIGURATION:
				return localLabelConfiguration != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == FeatureAxis.class) {
			switch (derivedFeatureID) {
				case NattableaxisPackage.FEATURE_ID_AXIS__LOCAL_LABEL_CONFIGURATION: return NattableaxisPackage.FEATURE_AXIS__LOCAL_LABEL_CONFIGURATION;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == FeatureAxis.class) {
			switch (baseFeatureID) {
				case NattableaxisPackage.FEATURE_AXIS__LOCAL_LABEL_CONFIGURATION: return NattableaxisPackage.FEATURE_ID_AXIS__LOCAL_LABEL_CONFIGURATION;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //FeatureIdAxisImpl
