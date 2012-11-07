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

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.FacetAttributeImpl;

import org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.EObjectFacetRepresentation;
import org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.ProfileEFacetPackage;
import org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.StereotypePropertyElement;
import org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.StereotypePropertyFacetAttribute;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Stereotype Property Facet Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.impl.StereotypePropertyFacetAttributeImpl#getRepresentedElement_XMI_ID <em>Represented Element XMI ID</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.impl.StereotypePropertyFacetAttributeImpl#getPropertyQualifiedName <em>Property Qualified Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.impl.StereotypePropertyFacetAttributeImpl#isIsDerived <em>Is Derived</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StereotypePropertyFacetAttributeImpl extends FacetAttributeImpl implements StereotypePropertyFacetAttribute {
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
	 * The default value of the '{@link #getPropertyQualifiedName() <em>Property Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyQualifiedName()
	 * @generated
	 * @ordered
	 */
	protected static final String PROPERTY_QUALIFIED_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPropertyQualifiedName() <em>Property Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyQualifiedName()
	 * @generated
	 * @ordered
	 */
	protected String propertyQualifiedName = PROPERTY_QUALIFIED_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsDerived() <em>Is Derived</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsDerived()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_DERIVED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsDerived() <em>Is Derived</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsDerived()
	 * @generated
	 * @ordered
	 */
	protected boolean isDerived = IS_DERIVED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StereotypePropertyFacetAttributeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ProfileEFacetPackage.Literals.STEREOTYPE_PROPERTY_FACET_ATTRIBUTE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ProfileEFacetPackage.STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__REPRESENTED_ELEMENT_XMI_ID, oldRepresentedElement_XMI_ID, representedElement_XMI_ID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPropertyQualifiedName() {
		return propertyQualifiedName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPropertyQualifiedName(String newPropertyQualifiedName) {
		String oldPropertyQualifiedName = propertyQualifiedName;
		propertyQualifiedName = newPropertyQualifiedName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProfileEFacetPackage.STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__PROPERTY_QUALIFIED_NAME, oldPropertyQualifiedName, propertyQualifiedName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsDerived() {
		return isDerived;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsDerived(boolean newIsDerived) {
		boolean oldIsDerived = isDerived;
		isDerived = newIsDerived;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProfileEFacetPackage.STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__IS_DERIVED, oldIsDerived, isDerived));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ProfileEFacetPackage.STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__REPRESENTED_ELEMENT_XMI_ID:
				return getRepresentedElement_XMI_ID();
			case ProfileEFacetPackage.STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__PROPERTY_QUALIFIED_NAME:
				return getPropertyQualifiedName();
			case ProfileEFacetPackage.STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__IS_DERIVED:
				return isIsDerived();
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
			case ProfileEFacetPackage.STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__REPRESENTED_ELEMENT_XMI_ID:
				setRepresentedElement_XMI_ID((String)newValue);
				return;
			case ProfileEFacetPackage.STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__PROPERTY_QUALIFIED_NAME:
				setPropertyQualifiedName((String)newValue);
				return;
			case ProfileEFacetPackage.STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__IS_DERIVED:
				setIsDerived((Boolean)newValue);
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
			case ProfileEFacetPackage.STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__REPRESENTED_ELEMENT_XMI_ID:
				setRepresentedElement_XMI_ID(REPRESENTED_ELEMENT_XMI_ID_EDEFAULT);
				return;
			case ProfileEFacetPackage.STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__PROPERTY_QUALIFIED_NAME:
				setPropertyQualifiedName(PROPERTY_QUALIFIED_NAME_EDEFAULT);
				return;
			case ProfileEFacetPackage.STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__IS_DERIVED:
				setIsDerived(IS_DERIVED_EDEFAULT);
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
			case ProfileEFacetPackage.STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__REPRESENTED_ELEMENT_XMI_ID:
				return REPRESENTED_ELEMENT_XMI_ID_EDEFAULT == null ? representedElement_XMI_ID != null : !REPRESENTED_ELEMENT_XMI_ID_EDEFAULT.equals(representedElement_XMI_ID);
			case ProfileEFacetPackage.STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__PROPERTY_QUALIFIED_NAME:
				return PROPERTY_QUALIFIED_NAME_EDEFAULT == null ? propertyQualifiedName != null : !PROPERTY_QUALIFIED_NAME_EDEFAULT.equals(propertyQualifiedName);
			case ProfileEFacetPackage.STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__IS_DERIVED:
				return isDerived != IS_DERIVED_EDEFAULT;
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
				case ProfileEFacetPackage.STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__REPRESENTED_ELEMENT_XMI_ID: return ProfileEFacetPackage.EOBJECT_FACET_REPRESENTATION__REPRESENTED_ELEMENT_XMI_ID;
				default: return -1;
			}
		}
		if (baseClass == StereotypePropertyElement.class) {
			switch (derivedFeatureID) {
				case ProfileEFacetPackage.STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__PROPERTY_QUALIFIED_NAME: return ProfileEFacetPackage.STEREOTYPE_PROPERTY_ELEMENT__PROPERTY_QUALIFIED_NAME;
				case ProfileEFacetPackage.STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__IS_DERIVED: return ProfileEFacetPackage.STEREOTYPE_PROPERTY_ELEMENT__IS_DERIVED;
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
				case ProfileEFacetPackage.EOBJECT_FACET_REPRESENTATION__REPRESENTED_ELEMENT_XMI_ID: return ProfileEFacetPackage.STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__REPRESENTED_ELEMENT_XMI_ID;
				default: return -1;
			}
		}
		if (baseClass == StereotypePropertyElement.class) {
			switch (baseFeatureID) {
				case ProfileEFacetPackage.STEREOTYPE_PROPERTY_ELEMENT__PROPERTY_QUALIFIED_NAME: return ProfileEFacetPackage.STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__PROPERTY_QUALIFIED_NAME;
				case ProfileEFacetPackage.STEREOTYPE_PROPERTY_ELEMENT__IS_DERIVED: return ProfileEFacetPackage.STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__IS_DERIVED;
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
		result.append(", propertyQualifiedName: "); //$NON-NLS-1$
		result.append(propertyQualifiedName);
		result.append(", isDerived: "); //$NON-NLS-1$
		result.append(isDerived);
		result.append(')');
		return result.toString();
	}

} //StereotypePropertyFacetAttributeImpl
