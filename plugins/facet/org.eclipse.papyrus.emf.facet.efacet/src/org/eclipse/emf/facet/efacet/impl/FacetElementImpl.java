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
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.ETypedElementImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.emf.facet.efacet.Category;
import org.eclipse.emf.facet.efacet.EFacetPackage;
import org.eclipse.emf.facet.efacet.Facet;
import org.eclipse.emf.facet.efacet.FacetElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Facet Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.facet.efacet.impl.FacetElementImpl#getCategories <em>Categories</em>}</li>
 *   <li>{@link org.eclipse.emf.facet.efacet.impl.FacetElementImpl#getFacet <em>Facet</em>}</li>
 *   <li>{@link org.eclipse.emf.facet.efacet.impl.FacetElementImpl#getOverride <em>Override</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 * @deprecated use the new eFacet metamodel in org.eclipse.emf.facet.efacet.metamodel. Cf.
 *             https://bugs.eclipse.org/bugs/show_bug.cgi?id=373672
 */
@Deprecated
public abstract class FacetElementImpl extends ETypedElementImpl implements FacetElement {
	/**
	 * The cached value of the '{@link #getCategories() <em>Categories</em>}' reference list.
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
	 * The cached value of the '{@link #getOverride() <em>Override</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOverride()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	protected ETypedElement override;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	protected FacetElementImpl() {
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
		return EFacetPackage.Literals.FACET_ELEMENT;
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
			this.categories = new EObjectResolvingEList<Category>(Category.class, this, EFacetPackage.FACET_ELEMENT__CATEGORIES);
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
	public Facet getFacet() {
		if (eContainerFeatureID() != EFacetPackage.FACET_ELEMENT__FACET) {
			return null;
		}
		return (Facet)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public NotificationChain basicSetFacet(final Facet newFacet, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newFacet, EFacetPackage.FACET_ELEMENT__FACET, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public void setFacet(final Facet newFacet) {
		if (newFacet != eInternalContainer() || (eContainerFeatureID() != EFacetPackage.FACET_ELEMENT__FACET && newFacet != null)) {
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
			eNotify(new ENotificationImpl(this, Notification.SET, EFacetPackage.FACET_ELEMENT__FACET, newFacet, newFacet));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public ETypedElement getOverride() {
		if (this.override != null && this.override.eIsProxy()) {
			InternalEObject oldOverride = (InternalEObject)this.override;
			this.override = (ETypedElement)eResolveProxy(oldOverride);
			if (this.override != oldOverride) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EFacetPackage.FACET_ELEMENT__OVERRIDE, oldOverride, this.override));
				}
			}
		}
		return this.override;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public ETypedElement basicGetOverride() {
		return this.override;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public void setOverride(final ETypedElement newOverride) {
		ETypedElement oldOverride = this.override;
		this.override = newOverride;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, EFacetPackage.FACET_ELEMENT__OVERRIDE, oldOverride, this.override));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	@Override
	public NotificationChain eInverseAdd(final InternalEObject otherEnd, final int featureID, NotificationChain msgs) {
		switch (featureID) {
		case EFacetPackage.FACET_ELEMENT__FACET:
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
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	@Override
	public NotificationChain eInverseRemove(final InternalEObject otherEnd, final int featureID, final NotificationChain msgs) {
		switch (featureID) {
		case EFacetPackage.FACET_ELEMENT__FACET:
			return basicSetFacet(null, msgs);
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
	public NotificationChain eBasicRemoveFromContainerFeature(final NotificationChain msgs) {
		switch (eContainerFeatureID()) {
		case EFacetPackage.FACET_ELEMENT__FACET:
			return eInternalContainer().eInverseRemove(this, EFacetPackage.FACET__FACET_ELEMENTS, Facet.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
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
		case EFacetPackage.FACET_ELEMENT__CATEGORIES:
			return getCategories();
		case EFacetPackage.FACET_ELEMENT__FACET:
			return getFacet();
		case EFacetPackage.FACET_ELEMENT__OVERRIDE:
			if (resolve) {
				return getOverride();
			}
			return basicGetOverride();
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
		case EFacetPackage.FACET_ELEMENT__CATEGORIES:
			getCategories().clear();
			getCategories().addAll((Collection<? extends Category>)newValue);
			return;
		case EFacetPackage.FACET_ELEMENT__FACET:
			setFacet((Facet)newValue);
			return;
		case EFacetPackage.FACET_ELEMENT__OVERRIDE:
			setOverride((ETypedElement)newValue);
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
		case EFacetPackage.FACET_ELEMENT__CATEGORIES:
			getCategories().clear();
			return;
		case EFacetPackage.FACET_ELEMENT__FACET:
			setFacet((Facet)null);
			return;
		case EFacetPackage.FACET_ELEMENT__OVERRIDE:
			setOverride((ETypedElement)null);
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
		case EFacetPackage.FACET_ELEMENT__CATEGORIES:
			return this.categories != null && !this.categories.isEmpty();
		case EFacetPackage.FACET_ELEMENT__FACET:
			return getFacet() != null;
		case EFacetPackage.FACET_ELEMENT__OVERRIDE:
			return this.override != null;
		}
		return super.eIsSet(featureID);
	}

} //FacetElementImpl
