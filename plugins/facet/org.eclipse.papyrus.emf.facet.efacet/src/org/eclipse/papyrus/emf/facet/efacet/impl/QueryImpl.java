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
package org.eclipse.emf.facet.efacet.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.ETypedElementImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.emf.facet.efacet.EFacetPackage;
import org.eclipse.emf.facet.efacet.Parameter;
import org.eclipse.emf.facet.efacet.Query;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Query</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.facet.efacet.impl.QueryImpl#getScope <em>Scope</em>}</li>
 *   <li>{@link org.eclipse.emf.facet.efacet.impl.QueryImpl#isHasSideEffect <em>Has Side Effect</em>}</li>
 *   <li>{@link org.eclipse.emf.facet.efacet.impl.QueryImpl#isCanBeCached <em>Can Be Cached</em>}</li>
 *   <li>{@link org.eclipse.emf.facet.efacet.impl.QueryImpl#getParameters <em>Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 * @deprecated use the new eFacet metamodel in org.eclipse.emf.facet.efacet.metamodel. Cf.
 *             https://bugs.eclipse.org/bugs/show_bug.cgi?id=373672
 */
@Deprecated
public abstract class QueryImpl extends ETypedElementImpl implements Query {
	/**
	 * The cached value of the '{@link #getScope() <em>Scope</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScope()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	protected EClass scope;

	/**
	 * The default value of the '{@link #isHasSideEffect() <em>Has Side Effect</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHasSideEffect()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	protected static final boolean HAS_SIDE_EFFECT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isHasSideEffect() <em>Has Side Effect</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHasSideEffect()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	protected boolean hasSideEffect = QueryImpl.HAS_SIDE_EFFECT_EDEFAULT;

	/**
	 * The default value of the '{@link #isCanBeCached() <em>Can Be Cached</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCanBeCached()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	protected static final boolean CAN_BE_CACHED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isCanBeCached() <em>Can Be Cached</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCanBeCached()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	protected boolean canBeCached = QueryImpl.CAN_BE_CACHED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	protected EList<Parameter> parameters;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	protected QueryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	@Override
	protected EClass eStaticClass() {
		return EFacetPackage.Literals.QUERY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public EClass getScope() {
		if (this.scope != null && this.scope.eIsProxy()) {
			InternalEObject oldScope = (InternalEObject)this.scope;
			this.scope = (EClass)eResolveProxy(oldScope);
			if (this.scope != oldScope) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EFacetPackage.QUERY__SCOPE, oldScope, this.scope));
				}
			}
		}
		return this.scope;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public EClass basicGetScope() {
		return this.scope;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public void setScope(final EClass newScope) {
		EClass oldScope = this.scope;
		this.scope = newScope;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, EFacetPackage.QUERY__SCOPE, oldScope, this.scope));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public boolean isHasSideEffect() {
		return this.hasSideEffect;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public void setHasSideEffect(final boolean newHasSideEffect) {
		boolean oldHasSideEffect = this.hasSideEffect;
		this.hasSideEffect = newHasSideEffect;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, EFacetPackage.QUERY__HAS_SIDE_EFFECT, oldHasSideEffect, this.hasSideEffect));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public boolean isCanBeCached() {
		return this.canBeCached;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public void setCanBeCached(final boolean newCanBeCached) {
		boolean oldCanBeCached = this.canBeCached;
		this.canBeCached = newCanBeCached;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, EFacetPackage.QUERY__CAN_BE_CACHED, oldCanBeCached, this.canBeCached));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public EList<Parameter> getParameters() {
		if (this.parameters == null) {
			this.parameters = new EObjectContainmentEList<Parameter>(Parameter.class, this, EFacetPackage.QUERY__PARAMETERS);
		}
		return this.parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	@Override
	public NotificationChain eInverseRemove(final InternalEObject otherEnd, final int featureID, final NotificationChain msgs) {
		switch (featureID) {
		case EFacetPackage.QUERY__PARAMETERS:
			return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	@Override
	public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
		switch (featureID) {
		case EFacetPackage.QUERY__SCOPE:
			if (resolve) {
				return getScope();
			}
			return basicGetScope();
		case EFacetPackage.QUERY__HAS_SIDE_EFFECT:
			return isHasSideEffect();
		case EFacetPackage.QUERY__CAN_BE_CACHED:
			return isCanBeCached();
		case EFacetPackage.QUERY__PARAMETERS:
			return getParameters();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(final int featureID, final Object newValue) {
		switch (featureID) {
		case EFacetPackage.QUERY__SCOPE:
			setScope((EClass)newValue);
			return;
		case EFacetPackage.QUERY__HAS_SIDE_EFFECT:
			setHasSideEffect((Boolean)newValue);
			return;
		case EFacetPackage.QUERY__CAN_BE_CACHED:
			setCanBeCached((Boolean)newValue);
			return;
		case EFacetPackage.QUERY__PARAMETERS:
			getParameters().clear();
			getParameters().addAll((Collection<? extends Parameter>)newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	@Override
	public void eUnset(final int featureID) {
		switch (featureID) {
		case EFacetPackage.QUERY__SCOPE:
			setScope((EClass)null);
			return;
		case EFacetPackage.QUERY__HAS_SIDE_EFFECT:
			setHasSideEffect(QueryImpl.HAS_SIDE_EFFECT_EDEFAULT);
			return;
		case EFacetPackage.QUERY__CAN_BE_CACHED:
			setCanBeCached(QueryImpl.CAN_BE_CACHED_EDEFAULT);
			return;
		case EFacetPackage.QUERY__PARAMETERS:
			getParameters().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	@Override
	public boolean eIsSet(final int featureID) {
		switch (featureID) {
		case EFacetPackage.QUERY__SCOPE:
			return this.scope != null;
		case EFacetPackage.QUERY__HAS_SIDE_EFFECT:
			return this.hasSideEffect != QueryImpl.HAS_SIDE_EFFECT_EDEFAULT;
		case EFacetPackage.QUERY__CAN_BE_CACHED:
			return this.canBeCached != QueryImpl.CAN_BE_CACHED_EDEFAULT;
		case EFacetPackage.QUERY__PARAMETERS:
			return this.parameters != null && !this.parameters.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	@Override
	public String toString() {
		if (eIsProxy()) {
			return super.toString();
		}

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (hasSideEffect: "); //$NON-NLS-1$
		result.append(this.hasSideEffect);
		result.append(", canBeCached: "); //$NON-NLS-1$
		result.append(this.canBeCached);
		result.append(')');
		return result.toString();
	}

} //QueryImpl
