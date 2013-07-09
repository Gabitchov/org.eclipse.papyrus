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
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.EStructuralFeatureValueFillingConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EStructural Feature Value Filling Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.EStructuralFeatureValueFillingConfigurationImpl#getListenFeature <em>Listen Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EStructuralFeatureValueFillingConfigurationImpl extends MinimalEObjectImpl.Container implements EStructuralFeatureValueFillingConfiguration {

	/**
	 * The cached value of the '{@link #getListenFeature() <em>Listen Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getListenFeature()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature listenFeature;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EStructuralFeatureValueFillingConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NattableaxisconfigurationPackage.Literals.ESTRUCTURAL_FEATURE_VALUE_FILLING_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EStructuralFeature getListenFeature() {
		if (listenFeature != null && listenFeature.eIsProxy()) {
			InternalEObject oldListenFeature = (InternalEObject)listenFeature;
			listenFeature = (EStructuralFeature)eResolveProxy(oldListenFeature);
			if (listenFeature != oldListenFeature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NattableaxisconfigurationPackage.ESTRUCTURAL_FEATURE_VALUE_FILLING_CONFIGURATION__LISTEN_FEATURE, oldListenFeature, listenFeature));
			}
		}
		return listenFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EStructuralFeature basicGetListenFeature() {
		return listenFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setListenFeature(EStructuralFeature newListenFeature) {
		EStructuralFeature oldListenFeature = listenFeature;
		listenFeature = newListenFeature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NattableaxisconfigurationPackage.ESTRUCTURAL_FEATURE_VALUE_FILLING_CONFIGURATION__LISTEN_FEATURE, oldListenFeature, listenFeature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case NattableaxisconfigurationPackage.ESTRUCTURAL_FEATURE_VALUE_FILLING_CONFIGURATION__LISTEN_FEATURE:
				if (resolve) return getListenFeature();
				return basicGetListenFeature();
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
			case NattableaxisconfigurationPackage.ESTRUCTURAL_FEATURE_VALUE_FILLING_CONFIGURATION__LISTEN_FEATURE:
				setListenFeature((EStructuralFeature)newValue);
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
			case NattableaxisconfigurationPackage.ESTRUCTURAL_FEATURE_VALUE_FILLING_CONFIGURATION__LISTEN_FEATURE:
				setListenFeature((EStructuralFeature)null);
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
			case NattableaxisconfigurationPackage.ESTRUCTURAL_FEATURE_VALUE_FILLING_CONFIGURATION__LISTEN_FEATURE:
				return listenFeature != null;
		}
		return super.eIsSet(featureID);
	}

} //EStructuralFeatureValueFillingConfigurationImpl
