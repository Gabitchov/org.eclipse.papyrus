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

import org.eclipse.emf.ecore.impl.EClassifierImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.emf.facet.efacet.EFacetPackage;
import org.eclipse.emf.facet.efacet.Facet;
import org.eclipse.emf.facet.efacet.FacetElement;
import org.eclipse.emf.facet.efacet.FacetSet;
import org.eclipse.emf.facet.efacet.Query;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Facet</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.facet.efacet.impl.FacetImpl#getFacetSet <em>Facet Set</em>}</li>
 *   <li>{@link org.eclipse.emf.facet.efacet.impl.FacetImpl#getConformanceQuery <em>Conformance Query</em>}</li>
 *   <li>{@link org.eclipse.emf.facet.efacet.impl.FacetImpl#getExtendedMetaclass <em>Extended Metaclass</em>}</li>
 *   <li>{@link org.eclipse.emf.facet.efacet.impl.FacetImpl#getFacetElements <em>Facet Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 * @deprecated use the new eFacet metamodel in org.eclipse.emf.facet.efacet.metamodel. Cf.
 *             https://bugs.eclipse.org/bugs/show_bug.cgi?id=373672
 */
@Deprecated
public class FacetImpl extends EClassifierImpl implements Facet {
	/**
	 * The cached value of the '{@link #getConformanceQuery() <em>Conformance Query</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConformanceQuery()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	protected Query conformanceQuery;

	/**
	 * The cached value of the '{@link #getExtendedMetaclass() <em>Extended Metaclass</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtendedMetaclass()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	protected EClass extendedMetaclass;

	/**
	 * The cached value of the '{@link #getFacetElements() <em>Facet Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFacetElements()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	protected EList<FacetElement> facetElements;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	protected FacetImpl() {
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
		return EFacetPackage.Literals.FACET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public FacetSet getFacetSet() {
		if (eContainerFeatureID() != EFacetPackage.FACET__FACET_SET) {
			return null;
		}
		return (FacetSet)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public NotificationChain basicSetFacetSet(final FacetSet newFacetSet, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newFacetSet, EFacetPackage.FACET__FACET_SET, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public void setFacetSet(final FacetSet newFacetSet) {
		if (newFacetSet != eInternalContainer() || (eContainerFeatureID() != EFacetPackage.FACET__FACET_SET && newFacetSet != null)) {
			if (EcoreUtil.isAncestor(this, newFacetSet))
			 {
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			}
			NotificationChain msgs = null;
			if (eInternalContainer() != null) {
				msgs = eBasicRemoveFromContainer(msgs);
			}
			if (newFacetSet != null) {
				msgs = ((InternalEObject)newFacetSet).eInverseAdd(this, EFacetPackage.FACET_SET__FACETS, FacetSet.class, msgs);
			}
			msgs = basicSetFacetSet(newFacetSet, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		}
		else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, EFacetPackage.FACET__FACET_SET, newFacetSet, newFacetSet));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public Query getConformanceQuery() {
		return this.conformanceQuery;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public NotificationChain basicSetConformanceQuery(final Query newConformanceQuery, NotificationChain msgs) {
		Query oldConformanceQuery = this.conformanceQuery;
		this.conformanceQuery = newConformanceQuery;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EFacetPackage.FACET__CONFORMANCE_QUERY, oldConformanceQuery, newConformanceQuery);
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
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public void setConformanceQuery(final Query newConformanceQuery) {
		if (newConformanceQuery != this.conformanceQuery) {
			NotificationChain msgs = null;
			if (this.conformanceQuery != null) {
				msgs = ((InternalEObject)this.conformanceQuery).eInverseRemove(this, InternalEObject.EOPPOSITE_FEATURE_BASE - EFacetPackage.FACET__CONFORMANCE_QUERY, null, msgs);
			}
			if (newConformanceQuery != null) {
				msgs = ((InternalEObject)newConformanceQuery).eInverseAdd(this, InternalEObject.EOPPOSITE_FEATURE_BASE - EFacetPackage.FACET__CONFORMANCE_QUERY, null, msgs);
			}
			msgs = basicSetConformanceQuery(newConformanceQuery, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		}
		else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, EFacetPackage.FACET__CONFORMANCE_QUERY, newConformanceQuery, newConformanceQuery));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public EClass getExtendedMetaclass() {
		if (this.extendedMetaclass != null && this.extendedMetaclass.eIsProxy()) {
			InternalEObject oldExtendedMetaclass = (InternalEObject)this.extendedMetaclass;
			this.extendedMetaclass = (EClass)eResolveProxy(oldExtendedMetaclass);
			if (this.extendedMetaclass != oldExtendedMetaclass) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EFacetPackage.FACET__EXTENDED_METACLASS, oldExtendedMetaclass, this.extendedMetaclass));
				}
			}
		}
		return this.extendedMetaclass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public EClass basicGetExtendedMetaclass() {
		return this.extendedMetaclass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public void setExtendedMetaclass(final EClass newExtendedMetaclass) {
		EClass oldExtendedMetaclass = this.extendedMetaclass;
		this.extendedMetaclass = newExtendedMetaclass;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, EFacetPackage.FACET__EXTENDED_METACLASS, oldExtendedMetaclass, this.extendedMetaclass));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public EList<FacetElement> getFacetElements() {
		if (this.facetElements == null) {
			this.facetElements = new EObjectContainmentWithInverseEList<FacetElement>(FacetElement.class, this, EFacetPackage.FACET__FACET_ELEMENTS, EFacetPackage.FACET_ELEMENT__FACET);
		}
		return this.facetElements;
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
	public NotificationChain eInverseAdd(final InternalEObject otherEnd, final int featureID, NotificationChain msgs) {
		switch (featureID) {
		case EFacetPackage.FACET__FACET_SET:
			if (eInternalContainer() != null) {
				msgs = eBasicRemoveFromContainer(msgs);
			}
			return basicSetFacetSet((FacetSet)otherEnd, msgs);
		case EFacetPackage.FACET__FACET_ELEMENTS:
			return ((InternalEList<InternalEObject>)(InternalEList<?>)getFacetElements()).basicAdd(otherEnd, msgs);
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
		case EFacetPackage.FACET__FACET_SET:
			return basicSetFacetSet(null, msgs);
		case EFacetPackage.FACET__CONFORMANCE_QUERY:
			return basicSetConformanceQuery(null, msgs);
		case EFacetPackage.FACET__FACET_ELEMENTS:
			return ((InternalEList<?>)getFacetElements()).basicRemove(otherEnd, msgs);
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
		case EFacetPackage.FACET__FACET_SET:
			return eInternalContainer().eInverseRemove(this, EFacetPackage.FACET_SET__FACETS, FacetSet.class, msgs);
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
		case EFacetPackage.FACET__FACET_SET:
			return getFacetSet();
		case EFacetPackage.FACET__CONFORMANCE_QUERY:
			return getConformanceQuery();
		case EFacetPackage.FACET__EXTENDED_METACLASS:
			if (resolve) {
				return getExtendedMetaclass();
			}
			return basicGetExtendedMetaclass();
		case EFacetPackage.FACET__FACET_ELEMENTS:
			return getFacetElements();
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
		case EFacetPackage.FACET__FACET_SET:
			setFacetSet((FacetSet)newValue);
			return;
		case EFacetPackage.FACET__CONFORMANCE_QUERY:
			setConformanceQuery((Query)newValue);
			return;
		case EFacetPackage.FACET__EXTENDED_METACLASS:
			setExtendedMetaclass((EClass)newValue);
			return;
		case EFacetPackage.FACET__FACET_ELEMENTS:
			getFacetElements().clear();
			getFacetElements().addAll((Collection<? extends FacetElement>)newValue);
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
		case EFacetPackage.FACET__FACET_SET:
			setFacetSet((FacetSet)null);
			return;
		case EFacetPackage.FACET__CONFORMANCE_QUERY:
			setConformanceQuery((Query)null);
			return;
		case EFacetPackage.FACET__EXTENDED_METACLASS:
			setExtendedMetaclass((EClass)null);
			return;
		case EFacetPackage.FACET__FACET_ELEMENTS:
			getFacetElements().clear();
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
		case EFacetPackage.FACET__FACET_SET:
			return getFacetSet() != null;
		case EFacetPackage.FACET__CONFORMANCE_QUERY:
			return this.conformanceQuery != null;
		case EFacetPackage.FACET__EXTENDED_METACLASS:
			return this.extendedMetaclass != null;
		case EFacetPackage.FACET__FACET_ELEMENTS:
			return this.facetElements != null && !this.facetElements.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //FacetImpl
