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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.emf.facet.infra.query.ModelQuery;

import org.eclipse.emf.facet.infra.query.impl.ModelQueryImpl;

import org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.Argument;
import org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.ParametricQuery;
import org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.ParametricqueryPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parametric Query</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.impl.ParametricQueryImpl#getCalledQuery <em>Called Query</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.impl.ParametricQueryImpl#getArguments <em>Arguments</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ParametricQueryImpl extends ModelQueryImpl implements ParametricQuery {

	/**
	 * The cached value of the '{@link #getCalledQuery() <em>Called Query</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getCalledQuery()
	 * @generated
	 * @ordered
	 */
	protected ModelQuery calledQuery;

	/**
	 * The cached value of the '{@link #getArguments() <em>Arguments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getArguments()
	 * @generated
	 * @ordered
	 */
	protected EList<Argument> arguments;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ParametricQueryImpl() {
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
		return ParametricqueryPackage.Literals.PARAMETRIC_QUERY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ModelQuery getCalledQuery() {
		if(calledQuery != null && calledQuery.eIsProxy()) {
			InternalEObject oldCalledQuery = (InternalEObject)calledQuery;
			calledQuery = (ModelQuery)eResolveProxy(oldCalledQuery);
			if(calledQuery != oldCalledQuery) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ParametricqueryPackage.PARAMETRIC_QUERY__CALLED_QUERY, oldCalledQuery, calledQuery));
			}
		}
		return calledQuery;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ModelQuery basicGetCalledQuery() {
		return calledQuery;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setCalledQuery(ModelQuery newCalledQuery) {
		ModelQuery oldCalledQuery = calledQuery;
		calledQuery = newCalledQuery;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ParametricqueryPackage.PARAMETRIC_QUERY__CALLED_QUERY, oldCalledQuery, calledQuery));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Argument> getArguments() {
		if(arguments == null) {
			arguments = new EObjectContainmentEList<Argument>(Argument.class, this, ParametricqueryPackage.PARAMETRIC_QUERY__ARGUMENTS);
		}
		return arguments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch(featureID) {
		case ParametricqueryPackage.PARAMETRIC_QUERY__ARGUMENTS:
			return ((InternalEList<?>)getArguments()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
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
		case ParametricqueryPackage.PARAMETRIC_QUERY__CALLED_QUERY:
			if(resolve)
				return getCalledQuery();
			return basicGetCalledQuery();
		case ParametricqueryPackage.PARAMETRIC_QUERY__ARGUMENTS:
			return getArguments();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch(featureID) {
		case ParametricqueryPackage.PARAMETRIC_QUERY__CALLED_QUERY:
			setCalledQuery((ModelQuery)newValue);
			return;
		case ParametricqueryPackage.PARAMETRIC_QUERY__ARGUMENTS:
			getArguments().clear();
			getArguments().addAll((Collection<? extends Argument>)newValue);
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
		case ParametricqueryPackage.PARAMETRIC_QUERY__CALLED_QUERY:
			setCalledQuery((ModelQuery)null);
			return;
		case ParametricqueryPackage.PARAMETRIC_QUERY__ARGUMENTS:
			getArguments().clear();
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
		case ParametricqueryPackage.PARAMETRIC_QUERY__CALLED_QUERY:
			return calledQuery != null;
		case ParametricqueryPackage.PARAMETRIC_QUERY__ARGUMENTS:
			return arguments != null && !arguments.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ParametricQueryImpl
