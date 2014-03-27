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
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EOperationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.papyrus.emf.facet.efacet.Category;
import org.eclipse.papyrus.emf.facet.efacet.EFacetPackage;
import org.eclipse.papyrus.emf.facet.efacet.Facet;
import org.eclipse.papyrus.emf.facet.efacet.FacetElement;
import org.eclipse.papyrus.emf.facet.efacet.FacetOperation;
import org.eclipse.papyrus.emf.facet.efacet.Query;
import org.eclipse.papyrus.emf.facet.efacet.QueryFacetElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Facet Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.emf.facet.efacet.impl.FacetOperationImpl#getCategories <em>Categories</em>}</li>
 *   <li>{@link org.eclipse.papyrus.emf.facet.efacet.impl.FacetOperationImpl#getFacet <em>Facet</em>}</li>
 *   <li>{@link org.eclipse.papyrus.emf.facet.efacet.impl.FacetOperationImpl#getOverride <em>Override</em>}</li>
 *   <li>{@link org.eclipse.papyrus.emf.facet.efacet.impl.FacetOperationImpl#getQuery <em>Query</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 * @deprecated use the new eFacet metamodel in org.eclipse.papyrus.emf.facet.efacet.metamodel. Cf.
 *             https://bugs.eclipse.org/bugs/show_bug.cgi?id=373672
 */
@Deprecated
public class FacetOperationImpl extends EOperationImpl implements FacetOperation {
	/**
	 * The cached value of the '{@link #getCategories() <em>Categories</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCategories()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	protected EList<Category> categories;

	/**
	 * The cached value of the '{@link #getOverride() <em>Override</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOverride()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	protected ETypedElement override;

	/**
	 * The cached value of the '{@link #getQuery() <em>Query</em>}' containment reference.
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	protected FacetOperationImpl() {
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
		return EFacetPackage.Literals.FACET_OPERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public EList<Category> getCategories() {
		if (this.categories == null) {
			this.categories = new EObjectResolvingEList<Category>(Category.class, this, EFacetPackage.FACET_OPERATION__CATEGORIES);
		}
		return this.categories;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public Facet getFacet() {
		if (eContainerFeatureID() != EFacetPackage.FACET_OPERATION__FACET) {
			return null;
		}
		return (Facet)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public NotificationChain basicSetFacet(final Facet newFacet, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newFacet, EFacetPackage.FACET_OPERATION__FACET, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public void setFacet(final Facet newFacet) {
		if (newFacet != eInternalContainer() || (eContainerFeatureID() != EFacetPackage.FACET_OPERATION__FACET && newFacet != null)) {
			if (EcoreUtil.isAncestor(this, newFacet))
			 {
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			}
			NotificationChain msgs = null;
			if (eInternalContainer() != null) {
				msgs = eBasicRemoveFromContainer(msgs);
			}
			if (newFacet != null) {
				msgs = ((InternalEObject)newFacet).eInverseAdd(this, EFacetPackage.FACET__FACET_ELEMENTS, Facet.class, msgs);
			}
			msgs = basicSetFacet(newFacet, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		}
		else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, EFacetPackage.FACET_OPERATION__FACET, newFacet, newFacet));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public ETypedElement getOverride() {
		if (this.override != null && this.override.eIsProxy()) {
			InternalEObject oldOverride = (InternalEObject)this.override;
			this.override = (ETypedElement)eResolveProxy(oldOverride);
			if (this.override != oldOverride) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EFacetPackage.FACET_OPERATION__OVERRIDE, oldOverride, this.override));
				}
			}
		}
		return this.override;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public ETypedElement basicGetOverride() {
		return this.override;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public void setOverride(final ETypedElement newOverride) {
		ETypedElement oldOverride = this.override;
		this.override = newOverride;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, EFacetPackage.FACET_OPERATION__OVERRIDE, oldOverride, this.override));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public Query getQuery() {
		return this.query;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public NotificationChain basicSetQuery(final Query newQuery, NotificationChain msgs) {
		Query oldQuery = this.query;
		this.query = newQuery;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EFacetPackage.FACET_OPERATION__QUERY, oldQuery, newQuery);
			if (msgs == null) {
				msgs = notification;
			} else {
				msgs.add(notification);
			}
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public void setQuery(final Query newQuery) {
		if (newQuery != this.query) {
			NotificationChain msgs = null;
			if (this.query != null) {
				msgs = ((InternalEObject)this.query).eInverseRemove(this, InternalEObject.EOPPOSITE_FEATURE_BASE - EFacetPackage.FACET_OPERATION__QUERY, null, msgs);
			}
			if (newQuery != null) {
				msgs = ((InternalEObject)newQuery).eInverseAdd(this, InternalEObject.EOPPOSITE_FEATURE_BASE - EFacetPackage.FACET_OPERATION__QUERY, null, msgs);
			}
			msgs = basicSetQuery(newQuery, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		}
		else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, EFacetPackage.FACET_OPERATION__QUERY, newQuery, newQuery));
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
	public NotificationChain eInverseAdd(final InternalEObject otherEnd, final int featureID, NotificationChain msgs) {
		switch (featureID) {
		case EFacetPackage.FACET_OPERATION__FACET:
			if (eInternalContainer() != null) {
				msgs = eBasicRemoveFromContainer(msgs);
			}
			return basicSetFacet((Facet)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
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
		case EFacetPackage.FACET_OPERATION__FACET:
			return basicSetFacet(null, msgs);
		case EFacetPackage.FACET_OPERATION__QUERY:
			return basicSetQuery(null, msgs);
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
	public NotificationChain eBasicRemoveFromContainerFeature(final NotificationChain msgs) {
		switch (eContainerFeatureID()) {
		case EFacetPackage.FACET_OPERATION__FACET:
			return eInternalContainer().eInverseRemove(this, EFacetPackage.FACET__FACET_ELEMENTS, Facet.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
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
		case EFacetPackage.FACET_OPERATION__CATEGORIES:
			return getCategories();
		case EFacetPackage.FACET_OPERATION__FACET:
			return getFacet();
		case EFacetPackage.FACET_OPERATION__OVERRIDE:
			if (resolve) {
				return getOverride();
			}
			return basicGetOverride();
		case EFacetPackage.FACET_OPERATION__QUERY:
			return getQuery();
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
		case EFacetPackage.FACET_OPERATION__CATEGORIES:
			getCategories().clear();
			getCategories().addAll((Collection<? extends Category>)newValue);
			return;
		case EFacetPackage.FACET_OPERATION__FACET:
			setFacet((Facet)newValue);
			return;
		case EFacetPackage.FACET_OPERATION__OVERRIDE:
			setOverride((ETypedElement)newValue);
			return;
		case EFacetPackage.FACET_OPERATION__QUERY:
			setQuery((Query)newValue);
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
		case EFacetPackage.FACET_OPERATION__CATEGORIES:
			getCategories().clear();
			return;
		case EFacetPackage.FACET_OPERATION__FACET:
			setFacet((Facet)null);
			return;
		case EFacetPackage.FACET_OPERATION__OVERRIDE:
			setOverride((ETypedElement)null);
			return;
		case EFacetPackage.FACET_OPERATION__QUERY:
			setQuery((Query)null);
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
		case EFacetPackage.FACET_OPERATION__CATEGORIES:
			return this.categories != null && !this.categories.isEmpty();
		case EFacetPackage.FACET_OPERATION__FACET:
			return getFacet() != null;
		case EFacetPackage.FACET_OPERATION__OVERRIDE:
			return this.override != null;
		case EFacetPackage.FACET_OPERATION__QUERY:
			return this.query != null;
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
	public int eBaseStructuralFeatureID(final int derivedFeatureID, final Class<?> baseClass) {
		if (baseClass == FacetElement.class) {
			switch (derivedFeatureID) {
			case EFacetPackage.FACET_OPERATION__CATEGORIES: return EFacetPackage.FACET_ELEMENT__CATEGORIES;
			case EFacetPackage.FACET_OPERATION__FACET: return EFacetPackage.FACET_ELEMENT__FACET;
			case EFacetPackage.FACET_OPERATION__OVERRIDE: return EFacetPackage.FACET_ELEMENT__OVERRIDE;
			default: return -1;
			}
		}
		if (baseClass == QueryFacetElement.class) {
			switch (derivedFeatureID) {
			case EFacetPackage.FACET_OPERATION__QUERY: return EFacetPackage.QUERY_FACET_ELEMENT__QUERY;
			default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	@Override
	public int eDerivedStructuralFeatureID(final int baseFeatureID, final Class<?> baseClass) {
		if (baseClass == FacetElement.class) {
			switch (baseFeatureID) {
			case EFacetPackage.FACET_ELEMENT__CATEGORIES: return EFacetPackage.FACET_OPERATION__CATEGORIES;
			case EFacetPackage.FACET_ELEMENT__FACET: return EFacetPackage.FACET_OPERATION__FACET;
			case EFacetPackage.FACET_ELEMENT__OVERRIDE: return EFacetPackage.FACET_OPERATION__OVERRIDE;
			default: return -1;
			}
		}
		if (baseClass == QueryFacetElement.class) {
			switch (baseFeatureID) {
			case EFacetPackage.QUERY_FACET_ELEMENT__QUERY: return EFacetPackage.FACET_OPERATION__QUERY;
			default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //FacetOperationImpl
