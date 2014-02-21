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
 * 	Emmanuelle RouillÃ© (Mia-Software) - Bug 352618 - To be able to use non derived facet structural features and save them values. 
 * 	Nicolas Bros (Mia-Software) - Bug 361823 - [Restructuring] eFacet2 meta-model
 */
package org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.DerivedTypedElement;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.EFacetPackage;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.Query;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Derived Typed Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.DerivedTypedElementImpl#getQuery <em>Query</em>}</li>
 *   <li>{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.DerivedTypedElementImpl#getOverride <em>Override</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class DerivedTypedElementImpl extends FacetElementImpl implements DerivedTypedElement {
	/**
	 * The cached value of the '{@link #getQuery() <em>Query</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQuery()
	 * @generated
	 * @ordered
	 */
	protected Query query;

	/**
	 * The cached value of the '{@link #getOverride() <em>Override</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOverride()
	 * @generated
	 * @ordered
	 */
	protected DerivedTypedElement override;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DerivedTypedElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EFacetPackage.Literals.DERIVED_TYPED_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Query getQuery() {
		return query;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetQuery(Query newQuery, NotificationChain msgs) {
		Query oldQuery = query;
		query = newQuery;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EFacetPackage.DERIVED_TYPED_ELEMENT__QUERY, oldQuery, newQuery);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQuery(Query newQuery) {
		if (newQuery != query) {
			NotificationChain msgs = null;
			if (query != null)
				msgs = ((InternalEObject)query).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EFacetPackage.DERIVED_TYPED_ELEMENT__QUERY, null, msgs);
			if (newQuery != null)
				msgs = ((InternalEObject)newQuery).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EFacetPackage.DERIVED_TYPED_ELEMENT__QUERY, null, msgs);
			msgs = basicSetQuery(newQuery, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EFacetPackage.DERIVED_TYPED_ELEMENT__QUERY, newQuery, newQuery));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DerivedTypedElement getOverride() {
		if (override != null && override.eIsProxy()) {
			InternalEObject oldOverride = (InternalEObject)override;
			override = (DerivedTypedElement)eResolveProxy(oldOverride);
			if (override != oldOverride) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EFacetPackage.DERIVED_TYPED_ELEMENT__OVERRIDE, oldOverride, override));
			}
		}
		return override;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DerivedTypedElement basicGetOverride() {
		return override;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOverride(DerivedTypedElement newOverride) {
		DerivedTypedElement oldOverride = override;
		override = newOverride;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EFacetPackage.DERIVED_TYPED_ELEMENT__OVERRIDE, oldOverride, override));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EFacetPackage.DERIVED_TYPED_ELEMENT__QUERY:
				return basicSetQuery(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EFacetPackage.DERIVED_TYPED_ELEMENT__QUERY:
				return getQuery();
			case EFacetPackage.DERIVED_TYPED_ELEMENT__OVERRIDE:
				if (resolve) return getOverride();
				return basicGetOverride();
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
			case EFacetPackage.DERIVED_TYPED_ELEMENT__QUERY:
				setQuery((Query)newValue);
				return;
			case EFacetPackage.DERIVED_TYPED_ELEMENT__OVERRIDE:
				setOverride((DerivedTypedElement)newValue);
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
			case EFacetPackage.DERIVED_TYPED_ELEMENT__QUERY:
				setQuery((Query)null);
				return;
			case EFacetPackage.DERIVED_TYPED_ELEMENT__OVERRIDE:
				setOverride((DerivedTypedElement)null);
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
			case EFacetPackage.DERIVED_TYPED_ELEMENT__QUERY:
				return query != null;
			case EFacetPackage.DERIVED_TYPED_ELEMENT__OVERRIDE:
				return override != null;
		}
		return super.eIsSet(featureID);
	}

} //DerivedTypedElementImpl
