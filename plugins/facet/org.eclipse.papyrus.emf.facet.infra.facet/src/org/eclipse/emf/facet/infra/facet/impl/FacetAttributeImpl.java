/**
 * Copyright (c) 2009 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Frederic MADIOT (Mia-Software) - meta-model design
 *     Gregoire DUPE (Mia-Software) - design and implementation
 *     Gregoire DUPE (Mia-Software) - Bug 339880 - To be able to edit derived facet attributes and derived facet references
 *
 * $Id$
 */
package org.eclipse.emf.facet.infra.facet.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EAttributeImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;


import org.eclipse.emf.facet.infra.facet.FacetAttribute;
import org.eclipse.emf.facet.infra.facet.FacetPackage;
import org.eclipse.emf.facet.infra.facet.FacetStructuralFeature;
import org.eclipse.emf.facet.infra.query.ModelQuery;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.facet.infra.facet.impl.FacetAttributeImpl#getValueQuery <em>Value Query</em>}</li>
 *   <li>{@link org.eclipse.emf.facet.infra.facet.impl.FacetAttributeImpl#getSetQuery <em>Set Query</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FacetAttributeImpl extends EAttributeImpl implements FacetAttribute {
	/**
	 * The cached value of the '{@link #getValueQuery() <em>Value Query</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueQuery()
	 * @generated
	 * @ordered
	 */
	protected ModelQuery valueQuery;

	/**
	 * The cached value of the '{@link #getSetQuery() <em>Set Query</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSetQuery()
	 * @generated
	 * @ordered
	 */
	protected ModelQuery setQuery;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FacetAttributeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FacetPackage.Literals.FACET_ATTRIBUTE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelQuery getValueQuery() {
		if (valueQuery != null && valueQuery.eIsProxy()) {
			InternalEObject oldValueQuery = (InternalEObject)valueQuery;
			valueQuery = (ModelQuery)eResolveProxy(oldValueQuery);
			if (valueQuery != oldValueQuery) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FacetPackage.FACET_ATTRIBUTE__VALUE_QUERY, oldValueQuery, valueQuery));
			}
		}
		return valueQuery;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelQuery basicGetValueQuery() {
		return valueQuery;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValueQuery(ModelQuery newValueQuery) {
		ModelQuery oldValueQuery = valueQuery;
		valueQuery = newValueQuery;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FacetPackage.FACET_ATTRIBUTE__VALUE_QUERY, oldValueQuery, valueQuery));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelQuery getSetQuery() {
		if (setQuery != null && setQuery.eIsProxy()) {
			InternalEObject oldSetQuery = (InternalEObject)setQuery;
			setQuery = (ModelQuery)eResolveProxy(oldSetQuery);
			if (setQuery != oldSetQuery) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FacetPackage.FACET_ATTRIBUTE__SET_QUERY, oldSetQuery, setQuery));
			}
		}
		return setQuery;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelQuery basicGetSetQuery() {
		return setQuery;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSetQuery(ModelQuery newSetQuery) {
		ModelQuery oldSetQuery = setQuery;
		setQuery = newSetQuery;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FacetPackage.FACET_ATTRIBUTE__SET_QUERY, oldSetQuery, setQuery));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FacetPackage.FACET_ATTRIBUTE__VALUE_QUERY:
				if (resolve) return getValueQuery();
				return basicGetValueQuery();
			case FacetPackage.FACET_ATTRIBUTE__SET_QUERY:
				if (resolve) return getSetQuery();
				return basicGetSetQuery();
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
			case FacetPackage.FACET_ATTRIBUTE__VALUE_QUERY:
				setValueQuery((ModelQuery)newValue);
				return;
			case FacetPackage.FACET_ATTRIBUTE__SET_QUERY:
				setSetQuery((ModelQuery)newValue);
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
			case FacetPackage.FACET_ATTRIBUTE__VALUE_QUERY:
				setValueQuery((ModelQuery)null);
				return;
			case FacetPackage.FACET_ATTRIBUTE__SET_QUERY:
				setSetQuery((ModelQuery)null);
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
			case FacetPackage.FACET_ATTRIBUTE__VALUE_QUERY:
				return valueQuery != null;
			case FacetPackage.FACET_ATTRIBUTE__SET_QUERY:
				return setQuery != null;
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
		if (baseClass == FacetStructuralFeature.class) {
			switch (derivedFeatureID) {
				case FacetPackage.FACET_ATTRIBUTE__VALUE_QUERY: return FacetPackage.FACET_STRUCTURAL_FEATURE__VALUE_QUERY;
				case FacetPackage.FACET_ATTRIBUTE__SET_QUERY: return FacetPackage.FACET_STRUCTURAL_FEATURE__SET_QUERY;
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
		if (baseClass == FacetStructuralFeature.class) {
			switch (baseFeatureID) {
				case FacetPackage.FACET_STRUCTURAL_FEATURE__VALUE_QUERY: return FacetPackage.FACET_ATTRIBUTE__VALUE_QUERY;
				case FacetPackage.FACET_STRUCTURAL_FEATURE__SET_QUERY: return FacetPackage.FACET_ATTRIBUTE__SET_QUERY;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //FacetAttributeImpl
