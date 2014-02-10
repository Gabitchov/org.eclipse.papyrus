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
 * 
 *
 * $Id$
 */
package org.eclipse.emf.facet.infra.facet.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EClassImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.facet.infra.facet.Facet;
import org.eclipse.emf.facet.infra.facet.FacetPackage;
import org.eclipse.emf.facet.infra.facet.FacetSet;
import org.eclipse.emf.facet.infra.query.ModelQuery;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Facet</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.facet.infra.facet.impl.FacetImpl#getConditionQuery <em>Condition Query</em>}</li>
 *   <li>{@link org.eclipse.emf.facet.infra.facet.impl.FacetImpl#getFacetSet <em>Facet Set</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FacetImpl extends EClassImpl implements Facet {
	/**
	 * The cached value of the '{@link #getConditionQuery() <em>Condition Query</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConditionQuery()
	 * @generated
	 * @ordered
	 */
	protected ModelQuery conditionQuery;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FacetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FacetPackage.Literals.FACET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelQuery getConditionQuery() {
		if (conditionQuery != null && conditionQuery.eIsProxy()) {
			InternalEObject oldConditionQuery = (InternalEObject)conditionQuery;
			conditionQuery = (ModelQuery)eResolveProxy(oldConditionQuery);
			if (conditionQuery != oldConditionQuery) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FacetPackage.FACET__CONDITION_QUERY, oldConditionQuery, conditionQuery));
			}
		}
		return conditionQuery;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelQuery basicGetConditionQuery() {
		return conditionQuery;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConditionQuery(ModelQuery newConditionQuery) {
		ModelQuery oldConditionQuery = conditionQuery;
		conditionQuery = newConditionQuery;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FacetPackage.FACET__CONDITION_QUERY, oldConditionQuery, conditionQuery));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FacetSet getFacetSet() {
		FacetSet facetSet = basicGetFacetSet();
		return facetSet != null && facetSet.eIsProxy() ? (FacetSet)eResolveProxy((InternalEObject)facetSet) : facetSet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public FacetSet basicGetFacetSet() {
		FacetSet result = null;
		if (this.getEPackage() instanceof FacetSet) {
			result = (FacetSet) this.getEPackage();
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FacetPackage.FACET__CONDITION_QUERY:
				if (resolve) return getConditionQuery();
				return basicGetConditionQuery();
			case FacetPackage.FACET__FACET_SET:
				if (resolve) return getFacetSet();
				return basicGetFacetSet();
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
			case FacetPackage.FACET__CONDITION_QUERY:
				setConditionQuery((ModelQuery)newValue);
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
			case FacetPackage.FACET__CONDITION_QUERY:
				setConditionQuery((ModelQuery)null);
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
			case FacetPackage.FACET__CONDITION_QUERY:
				return conditionQuery != null;
			case FacetPackage.FACET__FACET_SET:
				return basicGetFacetSet() != null;
		}
		return super.eIsSet(featureID);
	}

} //FacetImpl
