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

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.facet.efacet.EFacetPackage;
import org.eclipse.emf.facet.efacet.OppositeReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Opposite Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.facet.efacet.impl.OppositeReferenceImpl#getFOpposite <em>FOpposite</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 * @deprecated use the new eFacet metamodel in org.eclipse.emf.facet.efacet.metamodel. Cf.
 *             https://bugs.eclipse.org/bugs/show_bug.cgi?id=373672
 */
@Deprecated
public class OppositeReferenceImpl extends FacetElementImpl implements OppositeReference {
	/**
	 * The cached value of the '{@link #getFOpposite() <em>FOpposite</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFOpposite()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	protected EReference fOpposite;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	protected OppositeReferenceImpl() {
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
		return EFacetPackage.Literals.OPPOSITE_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public EReference getFOpposite() {
		if (this.fOpposite != null && this.fOpposite.eIsProxy()) {
			InternalEObject oldFOpposite = (InternalEObject)this.fOpposite;
			this.fOpposite = (EReference)eResolveProxy(oldFOpposite);
			if (this.fOpposite != oldFOpposite) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EFacetPackage.OPPOSITE_REFERENCE__FOPPOSITE, oldFOpposite, this.fOpposite));
				}
			}
		}
		return this.fOpposite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public EReference basicGetFOpposite() {
		return this.fOpposite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public void setFOpposite(final EReference newFOpposite) {
		EReference oldFOpposite = this.fOpposite;
		this.fOpposite = newFOpposite;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, EFacetPackage.OPPOSITE_REFERENCE__FOPPOSITE, oldFOpposite, this.fOpposite));
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
	public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
		switch (featureID) {
		case EFacetPackage.OPPOSITE_REFERENCE__FOPPOSITE:
			if (resolve) {
				return getFOpposite();
			}
			return basicGetFOpposite();
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
	@Override
	public void eSet(final int featureID, final Object newValue) {
		switch (featureID) {
		case EFacetPackage.OPPOSITE_REFERENCE__FOPPOSITE:
			setFOpposite((EReference)newValue);
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
		case EFacetPackage.OPPOSITE_REFERENCE__FOPPOSITE:
			setFOpposite((EReference)null);
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
		case EFacetPackage.OPPOSITE_REFERENCE__FOPPOSITE:
			return this.fOpposite != null;
		}
		return super.eIsSet(featureID);
	}

} //OppositeReferenceImpl
