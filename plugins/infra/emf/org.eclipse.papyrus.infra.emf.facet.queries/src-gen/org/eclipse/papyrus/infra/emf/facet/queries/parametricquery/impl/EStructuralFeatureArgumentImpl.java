/**
 * Copyright (c) 2012 CEA LIST.
 * 
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *   Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.EStructuralFeatureArgument;
import org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.ParametricqueryPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EStructural Feature Argument</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.impl.EStructuralFeatureArgumentImpl#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class EStructuralFeatureArgumentImpl extends ArgumentImpl implements EStructuralFeatureArgument {

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected EStructuralFeatureArgumentImpl() {
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
		return ParametricqueryPackage.Literals.ESTRUCTURAL_FEATURE_ARGUMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EStructuralFeature getValue() {
		if(value != null && value.eIsProxy()) {
			InternalEObject oldValue = (InternalEObject)value;
			value = (EStructuralFeature)eResolveProxy(oldValue);
			if(value != oldValue) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ParametricqueryPackage.ESTRUCTURAL_FEATURE_ARGUMENT__VALUE, oldValue, value));
			}
		}
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EStructuralFeature basicGetValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setValue(EStructuralFeature newValue) {
		EStructuralFeature oldValue = value;
		value = newValue;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ParametricqueryPackage.ESTRUCTURAL_FEATURE_ARGUMENT__VALUE, oldValue, value));
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
		case ParametricqueryPackage.ESTRUCTURAL_FEATURE_ARGUMENT__VALUE:
			if(resolve)
				return getValue();
			return basicGetValue();
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
	public void eSet(int featureID, Object newValue) {
		switch(featureID) {
		case ParametricqueryPackage.ESTRUCTURAL_FEATURE_ARGUMENT__VALUE:
			setValue((EStructuralFeature)newValue);
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
		case ParametricqueryPackage.ESTRUCTURAL_FEATURE_ARGUMENT__VALUE:
			setValue((EStructuralFeature)null);
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
		case ParametricqueryPackage.ESTRUCTURAL_FEATURE_ARGUMENT__VALUE:
			return value != null;
		}
		return super.eIsSet(featureID);
	}

} //EStructuralFeatureArgumentImpl
