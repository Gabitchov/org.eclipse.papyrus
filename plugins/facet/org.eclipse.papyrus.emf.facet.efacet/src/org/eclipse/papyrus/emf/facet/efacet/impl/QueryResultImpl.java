/**
 *  Copyright (c) 2011 Mia-Software.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 * 	Gregoire Dupe (Mia-Software) - Design
 * 	Nicolas Guyomar (Mia-Software) - Implementation
 *  
 */
package org.eclipse.papyrus.emf.facet.efacet.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.emf.facet.efacet.EFacetPackage;
import org.eclipse.papyrus.emf.facet.efacet.ParameterValue;
import org.eclipse.papyrus.emf.facet.efacet.Query;
import org.eclipse.papyrus.emf.facet.efacet.QueryResult;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Query Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.emf.facet.efacet.impl.QueryResultImpl#getQuery <em>Query</em>}</li>
 *   <li>{@link org.eclipse.papyrus.emf.facet.efacet.impl.QueryResultImpl#getScope <em>Scope</em>}</li>
 *   <li>{@link org.eclipse.papyrus.emf.facet.efacet.impl.QueryResultImpl#getParameterValues <em>Parameter Values</em>}</li>
 *   <li>{@link org.eclipse.papyrus.emf.facet.efacet.impl.QueryResultImpl#getResult <em>Result</em>}</li>
 *   <li>{@link org.eclipse.papyrus.emf.facet.efacet.impl.QueryResultImpl#getException <em>Exception</em>}</li>
 *   <li>{@link org.eclipse.papyrus.emf.facet.efacet.impl.QueryResultImpl#getSource <em>Source</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 * @deprecated use the new eFacet metamodel in org.eclipse.papyrus.emf.facet.efacet.metamodel. Cf.
 *             https://bugs.eclipse.org/bugs/show_bug.cgi?id=373672
 */
@Deprecated
public class QueryResultImpl extends EObjectImpl implements QueryResult {
	/**
	 * The cached value of the '{@link #getQuery() <em>Query</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQuery()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	protected Query query;

	/**
	 * The cached value of the '{@link #getScope() <em>Scope</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScope()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	protected EObject scope;

	/**
	 * The cached value of the '{@link #getParameterValues() <em>Parameter Values</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterValues()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	protected EList<ParameterValue> parameterValues;

	/**
	 * The default value of the '{@link #getResult() <em>Result</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResult()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	protected static final Object RESULT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getResult() <em>Result</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResult()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	protected Object result = QueryResultImpl.RESULT_EDEFAULT;

	/**
	 * The default value of the '{@link #getException() <em>Exception</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getException()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	protected static final Exception EXCEPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getException() <em>Exception</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getException()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	protected Exception exception = QueryResultImpl.EXCEPTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	protected EObject source;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	protected QueryResultImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	@Override
	protected EClass eStaticClass() {
		return EFacetPackage.Literals.QUERY_RESULT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public Query getQuery() {
		if (this.query != null && this.query.eIsProxy()) {
			InternalEObject oldQuery = (InternalEObject)this.query;
			this.query = (Query)eResolveProxy(oldQuery);
			if (this.query != oldQuery) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EFacetPackage.QUERY_RESULT__QUERY, oldQuery, this.query));
				}
			}
		}
		return this.query;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public Query basicGetQuery() {
		return this.query;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public void setQuery(final Query newQuery) {
		Query oldQuery = this.query;
		this.query = newQuery;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, EFacetPackage.QUERY_RESULT__QUERY, oldQuery, this.query));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public EObject getScope() {
		if (this.scope != null && this.scope.eIsProxy()) {
			InternalEObject oldScope = (InternalEObject)this.scope;
			this.scope = eResolveProxy(oldScope);
			if (this.scope != oldScope) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EFacetPackage.QUERY_RESULT__SCOPE, oldScope, this.scope));
				}
			}
		}
		return this.scope;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public EObject basicGetScope() {
		return this.scope;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public void setScope(final EObject newScope) {
		EObject oldScope = this.scope;
		this.scope = newScope;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, EFacetPackage.QUERY_RESULT__SCOPE, oldScope, this.scope));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public EList<ParameterValue> getParameterValues() {
		if (this.parameterValues == null) {
			this.parameterValues = new EObjectContainmentEList<ParameterValue>(ParameterValue.class, this, EFacetPackage.QUERY_RESULT__PARAMETER_VALUES);
		}
		return this.parameterValues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public Object getResult() {
		return this.result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public void setResult(final Object newResult) {
		Object oldResult = this.result;
		this.result = newResult;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, EFacetPackage.QUERY_RESULT__RESULT, oldResult, this.result));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public Exception getException() {
		return this.exception;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public void setException(final Exception newException) {
		Exception oldException = this.exception;
		this.exception = newException;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, EFacetPackage.QUERY_RESULT__EXCEPTION, oldException, this.exception));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public EObject getSource() {
		if (this.source != null && this.source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject)this.source;
			this.source = eResolveProxy(oldSource);
			if (this.source != oldSource) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EFacetPackage.QUERY_RESULT__SOURCE, oldSource, this.source));
				}
			}
		}
		return this.source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public EObject basicGetSource() {
		return this.source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public void setSource(final EObject newSource) {
		EObject oldSource = this.source;
		this.source = newSource;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, EFacetPackage.QUERY_RESULT__SOURCE, oldSource, this.source));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	@Override
	public NotificationChain eInverseRemove(final InternalEObject otherEnd, final int featureID, final NotificationChain msgs) {
		switch (featureID) {
		case EFacetPackage.QUERY_RESULT__PARAMETER_VALUES:
			return ((InternalEList<?>)getParameterValues()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	@Override
	public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
		switch (featureID) {
		case EFacetPackage.QUERY_RESULT__QUERY:
			if (resolve) {
				return getQuery();
			}
			return basicGetQuery();
		case EFacetPackage.QUERY_RESULT__SCOPE:
			if (resolve) {
				return getScope();
			}
			return basicGetScope();
		case EFacetPackage.QUERY_RESULT__PARAMETER_VALUES:
			return getParameterValues();
		case EFacetPackage.QUERY_RESULT__RESULT:
			return getResult();
		case EFacetPackage.QUERY_RESULT__EXCEPTION:
			return getException();
		case EFacetPackage.QUERY_RESULT__SOURCE:
			if (resolve) {
				return getSource();
			}
			return basicGetSource();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(final int featureID, final Object newValue) {
		switch (featureID) {
		case EFacetPackage.QUERY_RESULT__QUERY:
			setQuery((Query)newValue);
			return;
		case EFacetPackage.QUERY_RESULT__SCOPE:
			setScope((EObject)newValue);
			return;
		case EFacetPackage.QUERY_RESULT__PARAMETER_VALUES:
			getParameterValues().clear();
			getParameterValues().addAll((Collection<? extends ParameterValue>)newValue);
			return;
		case EFacetPackage.QUERY_RESULT__RESULT:
			setResult(newValue);
			return;
		case EFacetPackage.QUERY_RESULT__EXCEPTION:
			setException((Exception)newValue);
			return;
		case EFacetPackage.QUERY_RESULT__SOURCE:
			setSource((EObject)newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	@Override
	public void eUnset(final int featureID) {
		switch (featureID) {
		case EFacetPackage.QUERY_RESULT__QUERY:
			setQuery((Query)null);
			return;
		case EFacetPackage.QUERY_RESULT__SCOPE:
			setScope((EObject)null);
			return;
		case EFacetPackage.QUERY_RESULT__PARAMETER_VALUES:
			getParameterValues().clear();
			return;
		case EFacetPackage.QUERY_RESULT__RESULT:
			setResult(QueryResultImpl.RESULT_EDEFAULT);
			return;
		case EFacetPackage.QUERY_RESULT__EXCEPTION:
			setException(QueryResultImpl.EXCEPTION_EDEFAULT);
			return;
		case EFacetPackage.QUERY_RESULT__SOURCE:
			setSource((EObject)null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	@Override
	public boolean eIsSet(final int featureID) {
		switch (featureID) {
		case EFacetPackage.QUERY_RESULT__QUERY:
			return this.query != null;
		case EFacetPackage.QUERY_RESULT__SCOPE:
			return this.scope != null;
		case EFacetPackage.QUERY_RESULT__PARAMETER_VALUES:
			return this.parameterValues != null && !this.parameterValues.isEmpty();
		case EFacetPackage.QUERY_RESULT__RESULT:
			return QueryResultImpl.RESULT_EDEFAULT == null ? this.result != null : !QueryResultImpl.RESULT_EDEFAULT.equals(this.result);
		case EFacetPackage.QUERY_RESULT__EXCEPTION:
			return QueryResultImpl.EXCEPTION_EDEFAULT == null ? this.exception != null : !QueryResultImpl.EXCEPTION_EDEFAULT.equals(this.exception);
		case EFacetPackage.QUERY_RESULT__SOURCE:
			return this.source != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	@Override
	public String toString() {
		if (eIsProxy()) {
			return super.toString();
		}

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (result: "); //$NON-NLS-1$
		result.append(result);
		result.append(", exception: "); //$NON-NLS-1$
		result.append(this.exception);
		result.append(')');
		return result.toString();
	}

} //QueryResultImpl
