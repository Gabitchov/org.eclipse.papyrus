/**
 *  Copyright (c) 2012 CEA LIST.
 *  
 *   All rights reserved. This program and the accompanying materials
 *   are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *   http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *    Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EAttributeImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.facet.infra.facet.FacetAttribute;
import org.eclipse.emf.facet.infra.facet.FacetPackage;
import org.eclipse.emf.facet.infra.facet.FacetStructuralFeature;
import org.eclipse.emf.facet.infra.query.ModelQuery;
import org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.EObjectFacetRepresentation;
import org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.ProfileFacetPackage;
import org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.StereotypePropertyElement;
import org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.StereotypePropertyFacetAttribute;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Stereotype Property Facet Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.impl.StereotypePropertyFacetAttributeImpl#getRepresentedElement_XMI_ID <em>Represented Element XMI ID</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.impl.StereotypePropertyFacetAttributeImpl#getValueQuery <em>Value Query</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.impl.StereotypePropertyFacetAttributeImpl#getSetQuery <em>Set Query</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.impl.StereotypePropertyFacetAttributeImpl#getPropertyQualifiedName <em>Property Qualified Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.impl.StereotypePropertyFacetAttributeImpl#isIsDerived <em>Is Derived</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StereotypePropertyFacetAttributeImpl extends EAttributeImpl implements StereotypePropertyFacetAttribute {
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
	 * The cached value of the '{@link #getValueQuery() <em>Value Query</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueQuery()
	 * @generated
	 * @ordered
	 */
	protected ModelQuery valueQuery;

	/**
	 * The cached value of the '{@link #getSetQuery() <em>Set Query</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSetQuery()
	 * @generated
	 * @ordered
	 */
	protected ModelQuery setQuery;

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
		return ProfileFacetPackage.Literals.STEREOTYPE_PROPERTY_FACET_ATTRIBUTE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ProfileFacetPackage.STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__REPRESENTED_ELEMENT_XMI_ID, oldRepresentedElement_XMI_ID, representedElement_XMI_ID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelQuery getValueQuery() {
		if (valueQuery != null && valueQuery.eIsProxy()) {
			InternalEObject oldValueQuery = (InternalEObject)valueQuery;
			valueQuery = (ModelQuery)eResolveProxy(oldValueQuery);
			if (valueQuery != oldValueQuery) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProfileFacetPackage.STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__VALUE_QUERY, oldValueQuery, valueQuery));
			}
		}
		return valueQuery;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelQuery basicGetValueQuery() {
		return valueQuery;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValueQuery(ModelQuery newValueQuery) {
		ModelQuery oldValueQuery = valueQuery;
		valueQuery = newValueQuery;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProfileFacetPackage.STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__VALUE_QUERY, oldValueQuery, valueQuery));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelQuery getSetQuery() {
		if (setQuery != null && setQuery.eIsProxy()) {
			InternalEObject oldSetQuery = (InternalEObject)setQuery;
			setQuery = (ModelQuery)eResolveProxy(oldSetQuery);
			if (setQuery != oldSetQuery) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProfileFacetPackage.STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__SET_QUERY, oldSetQuery, setQuery));
			}
		}
		return setQuery;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelQuery basicGetSetQuery() {
		return setQuery;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSetQuery(ModelQuery newSetQuery) {
		ModelQuery oldSetQuery = setQuery;
		setQuery = newSetQuery;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProfileFacetPackage.STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__SET_QUERY, oldSetQuery, setQuery));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ProfileFacetPackage.STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__PROPERTY_QUALIFIED_NAME, oldPropertyQualifiedName, propertyQualifiedName));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ProfileFacetPackage.STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__IS_DERIVED, oldIsDerived, isDerived));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ProfileFacetPackage.STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__REPRESENTED_ELEMENT_XMI_ID:
				return getRepresentedElement_XMI_ID();
			case ProfileFacetPackage.STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__VALUE_QUERY:
				if (resolve) return getValueQuery();
				return basicGetValueQuery();
			case ProfileFacetPackage.STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__SET_QUERY:
				if (resolve) return getSetQuery();
				return basicGetSetQuery();
			case ProfileFacetPackage.STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__PROPERTY_QUALIFIED_NAME:
				return getPropertyQualifiedName();
			case ProfileFacetPackage.STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__IS_DERIVED:
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
			case ProfileFacetPackage.STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__REPRESENTED_ELEMENT_XMI_ID:
				setRepresentedElement_XMI_ID((String)newValue);
				return;
			case ProfileFacetPackage.STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__VALUE_QUERY:
				setValueQuery((ModelQuery)newValue);
				return;
			case ProfileFacetPackage.STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__SET_QUERY:
				setSetQuery((ModelQuery)newValue);
				return;
			case ProfileFacetPackage.STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__PROPERTY_QUALIFIED_NAME:
				setPropertyQualifiedName((String)newValue);
				return;
			case ProfileFacetPackage.STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__IS_DERIVED:
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
			case ProfileFacetPackage.STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__REPRESENTED_ELEMENT_XMI_ID:
				setRepresentedElement_XMI_ID(REPRESENTED_ELEMENT_XMI_ID_EDEFAULT);
				return;
			case ProfileFacetPackage.STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__VALUE_QUERY:
				setValueQuery((ModelQuery)null);
				return;
			case ProfileFacetPackage.STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__SET_QUERY:
				setSetQuery((ModelQuery)null);
				return;
			case ProfileFacetPackage.STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__PROPERTY_QUALIFIED_NAME:
				setPropertyQualifiedName(PROPERTY_QUALIFIED_NAME_EDEFAULT);
				return;
			case ProfileFacetPackage.STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__IS_DERIVED:
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
			case ProfileFacetPackage.STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__REPRESENTED_ELEMENT_XMI_ID:
				return REPRESENTED_ELEMENT_XMI_ID_EDEFAULT == null ? representedElement_XMI_ID != null : !REPRESENTED_ELEMENT_XMI_ID_EDEFAULT.equals(representedElement_XMI_ID);
			case ProfileFacetPackage.STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__VALUE_QUERY:
				return valueQuery != null;
			case ProfileFacetPackage.STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__SET_QUERY:
				return setQuery != null;
			case ProfileFacetPackage.STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__PROPERTY_QUALIFIED_NAME:
				return PROPERTY_QUALIFIED_NAME_EDEFAULT == null ? propertyQualifiedName != null : !PROPERTY_QUALIFIED_NAME_EDEFAULT.equals(propertyQualifiedName);
			case ProfileFacetPackage.STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__IS_DERIVED:
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
		if (baseClass == EObject.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == EObjectFacetRepresentation.class) {
			switch (derivedFeatureID) {
				case ProfileFacetPackage.STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__REPRESENTED_ELEMENT_XMI_ID: return ProfileFacetPackage.EOBJECT_FACET_REPRESENTATION__REPRESENTED_ELEMENT_XMI_ID;
				default: return -1;
			}
		}
		if (baseClass == FacetStructuralFeature.class) {
			switch (derivedFeatureID) {
				case ProfileFacetPackage.STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__VALUE_QUERY: return FacetPackage.FACET_STRUCTURAL_FEATURE__VALUE_QUERY;
				case ProfileFacetPackage.STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__SET_QUERY: return FacetPackage.FACET_STRUCTURAL_FEATURE__SET_QUERY;
				default: return -1;
			}
		}
		if (baseClass == StereotypePropertyElement.class) {
			switch (derivedFeatureID) {
				case ProfileFacetPackage.STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__PROPERTY_QUALIFIED_NAME: return ProfileFacetPackage.STEREOTYPE_PROPERTY_ELEMENT__PROPERTY_QUALIFIED_NAME;
				case ProfileFacetPackage.STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__IS_DERIVED: return ProfileFacetPackage.STEREOTYPE_PROPERTY_ELEMENT__IS_DERIVED;
				default: return -1;
			}
		}
		if (baseClass == FacetAttribute.class) {
			switch (derivedFeatureID) {
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
		if (baseClass == EObject.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == EObjectFacetRepresentation.class) {
			switch (baseFeatureID) {
				case ProfileFacetPackage.EOBJECT_FACET_REPRESENTATION__REPRESENTED_ELEMENT_XMI_ID: return ProfileFacetPackage.STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__REPRESENTED_ELEMENT_XMI_ID;
				default: return -1;
			}
		}
		if (baseClass == FacetStructuralFeature.class) {
			switch (baseFeatureID) {
				case FacetPackage.FACET_STRUCTURAL_FEATURE__VALUE_QUERY: return ProfileFacetPackage.STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__VALUE_QUERY;
				case FacetPackage.FACET_STRUCTURAL_FEATURE__SET_QUERY: return ProfileFacetPackage.STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__SET_QUERY;
				default: return -1;
			}
		}
		if (baseClass == StereotypePropertyElement.class) {
			switch (baseFeatureID) {
				case ProfileFacetPackage.STEREOTYPE_PROPERTY_ELEMENT__PROPERTY_QUALIFIED_NAME: return ProfileFacetPackage.STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__PROPERTY_QUALIFIED_NAME;
				case ProfileFacetPackage.STEREOTYPE_PROPERTY_ELEMENT__IS_DERIVED: return ProfileFacetPackage.STEREOTYPE_PROPERTY_FACET_ATTRIBUTE__IS_DERIVED;
				default: return -1;
			}
		}
		if (baseClass == FacetAttribute.class) {
			switch (baseFeatureID) {
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
