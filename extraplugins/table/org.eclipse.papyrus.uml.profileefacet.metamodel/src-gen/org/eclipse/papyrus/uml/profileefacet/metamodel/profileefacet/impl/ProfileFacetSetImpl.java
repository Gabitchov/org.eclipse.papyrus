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
package org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.BasicEList.UnmodifiableEList;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.FacetSetImpl;

import org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.EObjectFacetRepresentation;
import org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.ProfileEFacetPackage;
import org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.ProfileFacetSet;
import org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.StereotypeFacet;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Profile Facet Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.impl.ProfileFacetSetImpl#getRepresentedElement_XMI_ID <em>Represented Element XMI ID</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.impl.ProfileFacetSetImpl#getProfileQualifiedName <em>Profile Qualified Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProfileFacetSetImpl extends FacetSetImpl implements ProfileFacetSet {
	/**
	 * The default value of the '{@link #getRepresentedElement_XMI_ID() <em>Represented Element XMI ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepresentedElement_XMI_ID()
	 * @generated
	 * @ordered
	 */
	protected static final String REPRESENTED_ELEMENT_XMI_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRepresentedElement_XMI_ID() <em>Represented Element XMI ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepresentedElement_XMI_ID()
	 * @generated
	 * @ordered
	 */
	protected String representedElement_XMI_ID = REPRESENTED_ELEMENT_XMI_ID_EDEFAULT;

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
		return ProfileEFacetPackage.Literals.PROFILE_FACET_SET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRepresentedElement_XMI_ID() {
		return representedElement_XMI_ID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepresentedElement_XMI_ID(String newRepresentedElement_XMI_ID) {
		String oldRepresentedElement_XMI_ID = representedElement_XMI_ID;
		representedElement_XMI_ID = newRepresentedElement_XMI_ID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProfileEFacetPackage.PROFILE_FACET_SET__REPRESENTED_ELEMENT_XMI_ID, oldRepresentedElement_XMI_ID, representedElement_XMI_ID));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ProfileEFacetPackage.PROFILE_FACET_SET__PROFILE_QUALIFIED_NAME, oldProfileQualifiedName, profileQualifiedName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<ProfileFacetSet> getOwnedProfileFacetSets() {
		EList<ProfileFacetSet> ownedProfileFacetSet = new BasicEList<ProfileFacetSet>();
		for(final EPackage pack : getESubpackages()){
			if(pack instanceof ProfileFacetSet){
				ownedProfileFacetSet.add((ProfileFacetSet)pack);
			}
		}
		return new UnmodifiableEList<ProfileFacetSet>(ownedProfileFacetSet.size(), ownedProfileFacetSet.toArray());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<StereotypeFacet> getStereotypeFacets() {
		EList<StereotypeFacet> ownedStereotypeFacets = new BasicEList<StereotypeFacet>();
		for(final EClassifier eClass : getEClassifiers()){
			if(eClass instanceof StereotypeFacet){
				ownedStereotypeFacets.add((StereotypeFacet)eClass);
			}
		}
		return new UnmodifiableEList<StereotypeFacet>(ownedStereotypeFacets.size(), ownedStereotypeFacets.toArray());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ProfileEFacetPackage.PROFILE_FACET_SET__REPRESENTED_ELEMENT_XMI_ID:
				return getRepresentedElement_XMI_ID();
			case ProfileEFacetPackage.PROFILE_FACET_SET__PROFILE_QUALIFIED_NAME:
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
			case ProfileEFacetPackage.PROFILE_FACET_SET__REPRESENTED_ELEMENT_XMI_ID:
				setRepresentedElement_XMI_ID((String)newValue);
				return;
			case ProfileEFacetPackage.PROFILE_FACET_SET__PROFILE_QUALIFIED_NAME:
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
			case ProfileEFacetPackage.PROFILE_FACET_SET__REPRESENTED_ELEMENT_XMI_ID:
				setRepresentedElement_XMI_ID(REPRESENTED_ELEMENT_XMI_ID_EDEFAULT);
				return;
			case ProfileEFacetPackage.PROFILE_FACET_SET__PROFILE_QUALIFIED_NAME:
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
			case ProfileEFacetPackage.PROFILE_FACET_SET__REPRESENTED_ELEMENT_XMI_ID:
				return REPRESENTED_ELEMENT_XMI_ID_EDEFAULT == null ? representedElement_XMI_ID != null : !REPRESENTED_ELEMENT_XMI_ID_EDEFAULT.equals(representedElement_XMI_ID);
			case ProfileEFacetPackage.PROFILE_FACET_SET__PROFILE_QUALIFIED_NAME:
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
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == EObjectFacetRepresentation.class) {
			switch (derivedFeatureID) {
				case ProfileEFacetPackage.PROFILE_FACET_SET__REPRESENTED_ELEMENT_XMI_ID: return ProfileEFacetPackage.EOBJECT_FACET_REPRESENTATION__REPRESENTED_ELEMENT_XMI_ID;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == EObjectFacetRepresentation.class) {
			switch (baseFeatureID) {
				case ProfileEFacetPackage.EOBJECT_FACET_REPRESENTATION__REPRESENTED_ELEMENT_XMI_ID: return ProfileEFacetPackage.PROFILE_FACET_SET__REPRESENTED_ELEMENT_XMI_ID;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (representedElement_XMI_ID: "); //$NON-NLS-1$
		result.append(representedElement_XMI_ID);
		result.append(", profileQualifiedName: "); //$NON-NLS-1$
		result.append(profileQualifiedName);
		result.append(')');
		return result.toString();
	}

} //ProfileFacetSetImpl
