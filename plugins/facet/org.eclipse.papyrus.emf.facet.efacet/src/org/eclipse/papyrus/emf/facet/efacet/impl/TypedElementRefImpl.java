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

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.emf.facet.efacet.EFacetPackage;
import org.eclipse.papyrus.emf.facet.efacet.TypedElementRef;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Typed Element Ref</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.emf.facet.efacet.impl.TypedElementRefImpl#getTypedElement <em>Typed Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 * @deprecated use the new eFacet metamodel in org.eclipse.papyrus.emf.facet.efacet.metamodel. Cf.
 *             https://bugs.eclipse.org/bugs/show_bug.cgi?id=373672
 */
@Deprecated
public class TypedElementRefImpl extends QueryImpl implements TypedElementRef {
	/**
	 * The cached value of the '{@link #getTypedElement() <em>Typed Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypedElement()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	protected ETypedElement typedElement;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	protected TypedElementRefImpl() {
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
		return EFacetPackage.Literals.TYPED_ELEMENT_REF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public ETypedElement getTypedElement() {
		if (this.typedElement != null && this.typedElement.eIsProxy()) {
			InternalEObject oldTypedElement = (InternalEObject)this.typedElement;
			this.typedElement = (ETypedElement)eResolveProxy(oldTypedElement);
			if (this.typedElement != oldTypedElement) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EFacetPackage.TYPED_ELEMENT_REF__TYPED_ELEMENT, oldTypedElement, this.typedElement));
				}
			}
		}
		return this.typedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public ETypedElement basicGetTypedElement() {
		return this.typedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public void setTypedElement(final ETypedElement newTypedElement) {
		ETypedElement oldTypedElement = this.typedElement;
		this.typedElement = newTypedElement;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, EFacetPackage.TYPED_ELEMENT_REF__TYPED_ELEMENT, oldTypedElement, this.typedElement));
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
	public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
		switch (featureID) {
		case EFacetPackage.TYPED_ELEMENT_REF__TYPED_ELEMENT:
			if (resolve) {
				return getTypedElement();
			}
			return basicGetTypedElement();
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
	@Override
	public void eSet(final int featureID, final Object newValue) {
		switch (featureID) {
		case EFacetPackage.TYPED_ELEMENT_REF__TYPED_ELEMENT:
			setTypedElement((ETypedElement)newValue);
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
		case EFacetPackage.TYPED_ELEMENT_REF__TYPED_ELEMENT:
			setTypedElement((ETypedElement)null);
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
		case EFacetPackage.TYPED_ELEMENT_REF__TYPED_ELEMENT:
			return this.typedElement != null;
		}
		return super.eIsSet(featureID);
	}

} //TypedElementRefImpl
