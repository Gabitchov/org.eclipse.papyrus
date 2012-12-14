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
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.BasicEList.UnmodifiableEList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetElement;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.FacetImpl;

import org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.EObjectFacetRepresentation;
import org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.ProfileEFacetPackage;
import org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.StereotypeFacet;
import org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.StereotypePropertyElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Stereotype Facet</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.impl.StereotypeFacetImpl#getRepresentedElement_XMI_ID <em>Represented Element XMI ID</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.impl.StereotypeFacetImpl#getStereotypeQualifiedName <em>Stereotype Qualified Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StereotypeFacetImpl extends FacetImpl implements StereotypeFacet {
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
		return ProfileEFacetPackage.Literals.STEREOTYPE_FACET;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ProfileEFacetPackage.STEREOTYPE_FACET__REPRESENTED_ELEMENT_XMI_ID, oldRepresentedElement_XMI_ID, representedElement_XMI_ID));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ProfileEFacetPackage.STEREOTYPE_FACET__STEREOTYPE_QUALIFIED_NAME, oldStereotypeQualifiedName, stereotypeQualifiedName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<StereotypePropertyElement> getStereotypePropertyElements() {
		EList<StereotypePropertyElement> ownedStereotypeFacets = new BasicEList<StereotypePropertyElement>();
		for(final EStructuralFeature feature : getFacetElements()){
			if(feature instanceof StereotypeFacet){
				ownedStereotypeFacets.add((StereotypePropertyElement)feature);
			}
		}
		return new UnmodifiableEList<StereotypePropertyElement>(ownedStereotypeFacets.size(), ownedStereotypeFacets.toArray());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ProfileEFacetPackage.STEREOTYPE_FACET__REPRESENTED_ELEMENT_XMI_ID:
				return getRepresentedElement_XMI_ID();
			case ProfileEFacetPackage.STEREOTYPE_FACET__STEREOTYPE_QUALIFIED_NAME:
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
			case ProfileEFacetPackage.STEREOTYPE_FACET__REPRESENTED_ELEMENT_XMI_ID:
				setRepresentedElement_XMI_ID((String)newValue);
				return;
			case ProfileEFacetPackage.STEREOTYPE_FACET__STEREOTYPE_QUALIFIED_NAME:
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
			case ProfileEFacetPackage.STEREOTYPE_FACET__REPRESENTED_ELEMENT_XMI_ID:
				setRepresentedElement_XMI_ID(REPRESENTED_ELEMENT_XMI_ID_EDEFAULT);
				return;
			case ProfileEFacetPackage.STEREOTYPE_FACET__STEREOTYPE_QUALIFIED_NAME:
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
			case ProfileEFacetPackage.STEREOTYPE_FACET__REPRESENTED_ELEMENT_XMI_ID:
				return REPRESENTED_ELEMENT_XMI_ID_EDEFAULT == null ? representedElement_XMI_ID != null : !REPRESENTED_ELEMENT_XMI_ID_EDEFAULT.equals(representedElement_XMI_ID);
			case ProfileEFacetPackage.STEREOTYPE_FACET__STEREOTYPE_QUALIFIED_NAME:
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
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == EObjectFacetRepresentation.class) {
			switch (derivedFeatureID) {
				case ProfileEFacetPackage.STEREOTYPE_FACET__REPRESENTED_ELEMENT_XMI_ID: return ProfileEFacetPackage.EOBJECT_FACET_REPRESENTATION__REPRESENTED_ELEMENT_XMI_ID;
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
				case ProfileEFacetPackage.EOBJECT_FACET_REPRESENTATION__REPRESENTED_ELEMENT_XMI_ID: return ProfileEFacetPackage.STEREOTYPE_FACET__REPRESENTED_ELEMENT_XMI_ID;
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
		result.append(", stereotypeQualifiedName: "); //$NON-NLS-1$
		result.append(stereotypeQualifiedName);
		result.append(')');
		return result.toString();
	}

} //StereotypeFacetImpl
