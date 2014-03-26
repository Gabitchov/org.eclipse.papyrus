/**
 * Copyright (c) 2013 CEA LIST.
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *  Laurent Wouters laurent.wouters@cea.fr - Initial API and implementation
 *  
 * 
 */
package org.eclipse.papyrus.infra.viewpoints.configuration.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.papyrus.infra.viewpoints.configuration.ConfigurationPackage;
import org.eclipse.papyrus.infra.viewpoints.configuration.ModelAutoCreate;
import org.eclipse.papyrus.infra.viewpoints.configuration.OwningRule;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Auto Create</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.configuration.impl.ModelAutoCreateImpl#getFeature <em>Feature</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.configuration.impl.ModelAutoCreateImpl#getOrigin <em>Origin</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.configuration.impl.ModelAutoCreateImpl#getCreationType <em>Creation Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModelAutoCreateImpl extends MinimalEObjectImpl.Container implements ModelAutoCreate {
	/**
	 * The cached value of the '{@link #getFeature() <em>Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeature()
	 * @generated
	 * @ordered
	 */
	protected EReference feature;

	/**
	 * The cached value of the '{@link #getCreationType() <em>Creation Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreationType()
	 * @generated
	 * @ordered
	 */
	protected EClass creationType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelAutoCreateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfigurationPackage.Literals.MODEL_AUTO_CREATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeature() {
		if (feature != null && feature.eIsProxy()) {
			InternalEObject oldFeature = (InternalEObject)feature;
			feature = (EReference)eResolveProxy(oldFeature);
			if (feature != oldFeature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConfigurationPackage.MODEL_AUTO_CREATE__FEATURE, oldFeature, feature));
			}
		}
		return feature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference basicGetFeature() {
		return feature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeature(EReference newFeature) {
		EReference oldFeature = feature;
		feature = newFeature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.MODEL_AUTO_CREATE__FEATURE, oldFeature, feature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOrigin() {
		EClass origin = basicGetOrigin();
		return origin != null && origin.eIsProxy() ? (EClass)eResolveProxy((InternalEObject)origin) : origin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public EClass basicGetOrigin() {
		OwningRule rule = (OwningRule) this.eContainer();
		EList<ModelAutoCreate> list = rule.getNewModelPath();
		int index = list.indexOf(this);
		if (index == 0)
			return rule.getElement();
		return list.get(index - 1).getCreationType();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCreationType() {
		if (creationType != null && creationType.eIsProxy()) {
			InternalEObject oldCreationType = (InternalEObject)creationType;
			creationType = (EClass)eResolveProxy(oldCreationType);
			if (creationType != oldCreationType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConfigurationPackage.MODEL_AUTO_CREATE__CREATION_TYPE, oldCreationType, creationType));
			}
		}
		return creationType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass basicGetCreationType() {
		return creationType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreationType(EClass newCreationType) {
		EClass oldCreationType = creationType;
		creationType = newCreationType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.MODEL_AUTO_CREATE__CREATION_TYPE, oldCreationType, creationType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConfigurationPackage.MODEL_AUTO_CREATE__FEATURE:
				if (resolve) return getFeature();
				return basicGetFeature();
			case ConfigurationPackage.MODEL_AUTO_CREATE__ORIGIN:
				if (resolve) return getOrigin();
				return basicGetOrigin();
			case ConfigurationPackage.MODEL_AUTO_CREATE__CREATION_TYPE:
				if (resolve) return getCreationType();
				return basicGetCreationType();
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
			case ConfigurationPackage.MODEL_AUTO_CREATE__FEATURE:
				setFeature((EReference)newValue);
				return;
			case ConfigurationPackage.MODEL_AUTO_CREATE__CREATION_TYPE:
				setCreationType((EClass)newValue);
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
			case ConfigurationPackage.MODEL_AUTO_CREATE__FEATURE:
				setFeature((EReference)null);
				return;
			case ConfigurationPackage.MODEL_AUTO_CREATE__CREATION_TYPE:
				setCreationType((EClass)null);
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
			case ConfigurationPackage.MODEL_AUTO_CREATE__FEATURE:
				return feature != null;
			case ConfigurationPackage.MODEL_AUTO_CREATE__ORIGIN:
				return basicGetOrigin() != null;
			case ConfigurationPackage.MODEL_AUTO_CREATE__CREATION_TYPE:
				return creationType != null;
		}
		return super.eIsSet(featureID);
	}

} //ModelAutoCreateImpl
