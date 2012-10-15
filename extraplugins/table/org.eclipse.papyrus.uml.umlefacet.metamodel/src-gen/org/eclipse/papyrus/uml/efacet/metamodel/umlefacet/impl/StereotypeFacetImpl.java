/**
 * Copyright (c) 2012 CEA LIST.
 * 
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.uml.efacet.metamodel.umlefacet.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.FacetImpl;

import org.eclipse.papyrus.uml.efacet.metamodel.umlefacet.StereotypeFacet;
import org.eclipse.papyrus.uml.efacet.metamodel.umlefacet.UmlEFacetPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Stereotype Facet</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.efacet.metamodel.umlefacet.impl.StereotypeFacetImpl#getStereotypeQualifiedName <em>Stereotype Qualified Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StereotypeFacetImpl extends FacetImpl implements StereotypeFacet {
	/**
	 * The default value of the '{@link #getStereotypeQualifiedName() <em>Stereotype Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStereotypeQualifiedName()
	 * @generated
	 * @ordered
	 */
	protected static final String STEREOTYPE_QUALIFIED_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStereotypeQualifiedName() <em>Stereotype Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStereotypeQualifiedName()
	 * @generated
	 * @ordered
	 */
	protected String stereotypeQualifiedName = STEREOTYPE_QUALIFIED_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StereotypeFacetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UmlEFacetPackage.Literals.STEREOTYPE_FACET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStereotypeQualifiedName() {
		return stereotypeQualifiedName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStereotypeQualifiedName(String newStereotypeQualifiedName) {
		String oldStereotypeQualifiedName = stereotypeQualifiedName;
		stereotypeQualifiedName = newStereotypeQualifiedName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmlEFacetPackage.STEREOTYPE_FACET__STEREOTYPE_QUALIFIED_NAME, oldStereotypeQualifiedName, stereotypeQualifiedName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UmlEFacetPackage.STEREOTYPE_FACET__STEREOTYPE_QUALIFIED_NAME:
				return getStereotypeQualifiedName();
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
			case UmlEFacetPackage.STEREOTYPE_FACET__STEREOTYPE_QUALIFIED_NAME:
				setStereotypeQualifiedName((String)newValue);
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
			case UmlEFacetPackage.STEREOTYPE_FACET__STEREOTYPE_QUALIFIED_NAME:
				setStereotypeQualifiedName(STEREOTYPE_QUALIFIED_NAME_EDEFAULT);
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
			case UmlEFacetPackage.STEREOTYPE_FACET__STEREOTYPE_QUALIFIED_NAME:
				return STEREOTYPE_QUALIFIED_NAME_EDEFAULT == null ? stereotypeQualifiedName != null : !STEREOTYPE_QUALIFIED_NAME_EDEFAULT.equals(stereotypeQualifiedName);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (stereotypeQualifiedName: "); //$NON-NLS-1$
		result.append(stereotypeQualifiedName);
		result.append(')');
		return result.toString();
	}

} //StereotypeFacetImpl
