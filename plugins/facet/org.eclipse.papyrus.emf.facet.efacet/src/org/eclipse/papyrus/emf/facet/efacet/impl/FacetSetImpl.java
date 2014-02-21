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
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.emf.facet.efacet.Category;
import org.eclipse.emf.facet.efacet.EFacetPackage;
import org.eclipse.emf.facet.efacet.Facet;
import org.eclipse.emf.facet.efacet.FacetSet;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Facet Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.facet.efacet.impl.FacetSetImpl#getFacets <em>Facets</em>}</li>
 *   <li>{@link org.eclipse.emf.facet.efacet.impl.FacetSetImpl#getCategories <em>Categories</em>}</li>
 *   <li>{@link org.eclipse.emf.facet.efacet.impl.FacetSetImpl#getExtendedEPackage <em>Extended EPackage</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 * @deprecated use the new eFacet metamodel in org.eclipse.emf.facet.efacet.metamodel. Cf.
 *             https://bugs.eclipse.org/bugs/show_bug.cgi?id=373672
 */
@Deprecated
public class FacetSetImpl extends EPackageImpl implements FacetSet {
	/**
	 * The cached value of the '{@link #getFacets() <em>Facets</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFacets()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	protected EList<Facet> facets;

	/**
	 * The cached value of the '{@link #getCategories() <em>Categories</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCategories()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	protected EList<Category> categories;

	/**
	 * The cached value of the '{@link #getExtendedEPackage() <em>Extended EPackage</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtendedEPackage()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	protected EPackage extendedEPackage;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	protected FacetSetImpl() {
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
		return EFacetPackage.Literals.FACET_SET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public EList<Facet> getFacets() {
		if (this.facets == null) {
			this.facets = new EObjectContainmentWithInverseEList<Facet>(Facet.class, this, EFacetPackage.FACET_SET__FACETS, EFacetPackage.FACET__FACET_SET);
		}
		return this.facets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public EList<Category> getCategories() {
		if (this.categories == null) {
			this.categories = new EObjectContainmentEList<Category>(Category.class, this, EFacetPackage.FACET_SET__CATEGORIES);
		}
		return this.categories;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public EPackage getExtendedEPackage() {
		if (this.extendedEPackage != null && this.extendedEPackage.eIsProxy()) {
			InternalEObject oldExtendedEPackage = (InternalEObject)this.extendedEPackage;
			this.extendedEPackage = (EPackage)eResolveProxy(oldExtendedEPackage);
			if (this.extendedEPackage != oldExtendedEPackage) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EFacetPackage.FACET_SET__EXTENDED_EPACKAGE, oldExtendedEPackage, this.extendedEPackage));
				}
			}
		}
		return this.extendedEPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public EPackage basicGetExtendedEPackage() {
		return this.extendedEPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public void setExtendedEPackage(final EPackage newExtendedEPackage) {
		EPackage oldExtendedEPackage = this.extendedEPackage;
		this.extendedEPackage = newExtendedEPackage;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, EFacetPackage.FACET_SET__EXTENDED_EPACKAGE, oldExtendedEPackage, this.extendedEPackage));
		}
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
	public NotificationChain eInverseAdd(final InternalEObject otherEnd, final int featureID, final NotificationChain msgs) {
		switch (featureID) {
		case EFacetPackage.FACET_SET__FACETS:
			return ((InternalEList<InternalEObject>)(InternalEList<?>)getFacets()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
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
		case EFacetPackage.FACET_SET__FACETS:
			return ((InternalEList<?>)getFacets()).basicRemove(otherEnd, msgs);
		case EFacetPackage.FACET_SET__CATEGORIES:
			return ((InternalEList<?>)getCategories()).basicRemove(otherEnd, msgs);
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
		case EFacetPackage.FACET_SET__FACETS:
			return getFacets();
		case EFacetPackage.FACET_SET__CATEGORIES:
			return getCategories();
		case EFacetPackage.FACET_SET__EXTENDED_EPACKAGE:
			if (resolve) {
				return getExtendedEPackage();
			}
			return basicGetExtendedEPackage();
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
		case EFacetPackage.FACET_SET__FACETS:
			getFacets().clear();
			getFacets().addAll((Collection<? extends Facet>)newValue);
			return;
		case EFacetPackage.FACET_SET__CATEGORIES:
			getCategories().clear();
			getCategories().addAll((Collection<? extends Category>)newValue);
			return;
		case EFacetPackage.FACET_SET__EXTENDED_EPACKAGE:
			setExtendedEPackage((EPackage)newValue);
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
		case EFacetPackage.FACET_SET__FACETS:
			getFacets().clear();
			return;
		case EFacetPackage.FACET_SET__CATEGORIES:
			getCategories().clear();
			return;
		case EFacetPackage.FACET_SET__EXTENDED_EPACKAGE:
			setExtendedEPackage((EPackage)null);
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
		case EFacetPackage.FACET_SET__FACETS:
			return this.facets != null && !this.facets.isEmpty();
		case EFacetPackage.FACET_SET__CATEGORIES:
			return this.categories != null && !this.categories.isEmpty();
		case EFacetPackage.FACET_SET__EXTENDED_EPACKAGE:
			return this.extendedEPackage != null;
		}
		return super.eIsSet(featureID);
	}

} //FacetSetImpl
