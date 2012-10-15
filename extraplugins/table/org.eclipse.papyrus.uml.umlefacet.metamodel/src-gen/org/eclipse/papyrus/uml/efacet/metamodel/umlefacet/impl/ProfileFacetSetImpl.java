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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.FacetSetImpl;

import org.eclipse.papyrus.uml.efacet.metamodel.umlefacet.ProfileFacetSet;
import org.eclipse.papyrus.uml.efacet.metamodel.umlefacet.UmlEFacetPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Profile Facet Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.efacet.metamodel.umlefacet.impl.ProfileFacetSetImpl#getProfileQualifiedName <em>Profile Qualified Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProfileFacetSetImpl extends FacetSetImpl implements ProfileFacetSet {
	/**
	 * The default value of the '{@link #getProfileQualifiedName() <em>Profile Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProfileQualifiedName()
	 * @generated
	 * @ordered
	 */
	protected static final String PROFILE_QUALIFIED_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProfileQualifiedName() <em>Profile Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProfileQualifiedName()
	 * @generated
	 * @ordered
	 */
	protected String profileQualifiedName = PROFILE_QUALIFIED_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProfileFacetSetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UmlEFacetPackage.Literals.PROFILE_FACET_SET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProfileQualifiedName() {
		return profileQualifiedName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProfileQualifiedName(String newProfileQualifiedName) {
		String oldProfileQualifiedName = profileQualifiedName;
		profileQualifiedName = newProfileQualifiedName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmlEFacetPackage.PROFILE_FACET_SET__PROFILE_QUALIFIED_NAME, oldProfileQualifiedName, profileQualifiedName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ProfileFacetSet> getProfileFacetSet() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UmlEFacetPackage.PROFILE_FACET_SET__PROFILE_QUALIFIED_NAME:
				return getProfileQualifiedName();
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
			case UmlEFacetPackage.PROFILE_FACET_SET__PROFILE_QUALIFIED_NAME:
				setProfileQualifiedName((String)newValue);
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
			case UmlEFacetPackage.PROFILE_FACET_SET__PROFILE_QUALIFIED_NAME:
				setProfileQualifiedName(PROFILE_QUALIFIED_NAME_EDEFAULT);
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
			case UmlEFacetPackage.PROFILE_FACET_SET__PROFILE_QUALIFIED_NAME:
				return PROFILE_QUALIFIED_NAME_EDEFAULT == null ? profileQualifiedName != null : !PROFILE_QUALIFIED_NAME_EDEFAULT.equals(profileQualifiedName);
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
		result.append(" (profileQualifiedName: "); //$NON-NLS-1$
		result.append(profileQualifiedName);
		result.append(')');
		return result.toString();
	}

} //ProfileFacetSetImpl
