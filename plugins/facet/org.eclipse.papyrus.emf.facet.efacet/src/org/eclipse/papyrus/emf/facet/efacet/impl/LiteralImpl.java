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

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.emf.facet.efacet.EFacetPackage;
import org.eclipse.papyrus.emf.facet.efacet.Literal;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Literal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.emf.facet.efacet.impl.LiteralImpl#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 * @deprecated use the new eFacet metamodel in org.eclipse.papyrus.emf.facet.efacet.metamodel. Cf.
 *             https://bugs.eclipse.org/bugs/show_bug.cgi?id=373672
 */
@Deprecated
public class LiteralImpl extends QueryImpl implements Literal {
	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	protected static final String VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 * @ordered
	 */
	@Deprecated
	protected String value = LiteralImpl.VALUE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	protected LiteralImpl() {
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
		return EFacetPackage.Literals.LITERAL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public String getValue() {
		return this.value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @deprecated use the new eFacet2 metamodel in org.eclipse.papyrus.emf.facet.efacet2.metamodel
	 */
	@Deprecated
	public void setValue(final String newValue) {
		String oldValue = this.value;
		this.value = newValue;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, EFacetPackage.LITERAL__VALUE, oldValue, this.value));
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
		case EFacetPackage.LITERAL__VALUE:
			return getValue();
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
		case EFacetPackage.LITERAL__VALUE:
			setValue((String)newValue);
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
		case EFacetPackage.LITERAL__VALUE:
			setValue(LiteralImpl.VALUE_EDEFAULT);
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
		case EFacetPackage.LITERAL__VALUE:
			return LiteralImpl.VALUE_EDEFAULT == null ? this.value != null : !LiteralImpl.VALUE_EDEFAULT.equals(this.value);
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
		result.append(" (value: "); //$NON-NLS-1$
		result.append(this.value);
		result.append(')');
		return result.toString();
	}

} //LiteralImpl
