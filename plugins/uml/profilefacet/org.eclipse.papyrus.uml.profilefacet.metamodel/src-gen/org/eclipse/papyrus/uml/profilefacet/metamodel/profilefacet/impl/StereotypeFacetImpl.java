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
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EClassImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.facet.infra.facet.Facet;
import org.eclipse.emf.facet.infra.facet.FacetPackage;
import org.eclipse.emf.facet.infra.facet.FacetSet;
import org.eclipse.emf.facet.infra.query.ModelQuery;
import org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.EObjectFacetRepresentation;
import org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.ProfileFacetPackage;
import org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.StereotypeFacet;
import org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.StereotypePropertyElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Stereotype Facet</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.impl.StereotypeFacetImpl#getRepresentedElement_XMI_ID <em>Represented Element XMI ID</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.impl.StereotypeFacetImpl#getConditionQuery <em>Condition Query</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.impl.StereotypeFacetImpl#getFacetSet <em>Facet Set</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.impl.StereotypeFacetImpl#getStereotypeQualifiedName <em>Stereotype Qualified Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StereotypeFacetImpl extends EClassImpl implements StereotypeFacet {
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
	 * The cached value of the '{@link #getConditionQuery() <em>Condition Query</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConditionQuery()
	 * @generated
	 * @ordered
	 */
	protected ModelQuery conditionQuery;

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
		return ProfileFacetPackage.Literals.STEREOTYPE_FACET;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ProfileFacetPackage.STEREOTYPE_FACET__REPRESENTED_ELEMENT_XMI_ID, oldRepresentedElement_XMI_ID, representedElement_XMI_ID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelQuery getConditionQuery() {
		if (conditionQuery != null && conditionQuery.eIsProxy()) {
			InternalEObject oldConditionQuery = (InternalEObject)conditionQuery;
			conditionQuery = (ModelQuery)eResolveProxy(oldConditionQuery);
			if (conditionQuery != oldConditionQuery) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProfileFacetPackage.STEREOTYPE_FACET__CONDITION_QUERY, oldConditionQuery, conditionQuery));
			}
		}
		return conditionQuery;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelQuery basicGetConditionQuery() {
		return conditionQuery;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConditionQuery(ModelQuery newConditionQuery) {
		ModelQuery oldConditionQuery = conditionQuery;
		conditionQuery = newConditionQuery;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProfileFacetPackage.STEREOTYPE_FACET__CONDITION_QUERY, oldConditionQuery, conditionQuery));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FacetSet getFacetSet() {
		FacetSet facetSet = basicGetFacetSet();
		return facetSet != null && facetSet.eIsProxy() ? (FacetSet)eResolveProxy((InternalEObject)facetSet) : facetSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public FacetSet basicGetFacetSet() {
		FacetSet result = null;
		if (this.getEPackage() instanceof FacetSet) {
			result = (FacetSet) this.getEPackage();
		}
		return result;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ProfileFacetPackage.STEREOTYPE_FACET__STEREOTYPE_QUALIFIED_NAME, oldStereotypeQualifiedName, stereotypeQualifiedName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 *            FIXME : write JUnit test
	 */
	public EList<StereotypePropertyElement> getStereotypePropertyElements() {
		final EList<StereotypePropertyElement> proeprties = new BasicEList<StereotypePropertyElement>();
		for(final EStructuralFeature current : getEAttributes()) {
			if(current instanceof StereotypePropertyElement) {
				proeprties.add((StereotypePropertyElement)current);
			}
		}
		for(final EStructuralFeature current : getEReferences()) {
			if(current instanceof StereotypePropertyElement) {
				proeprties.add((StereotypePropertyElement)current);
			}
		}
		return ECollections.unmodifiableEList(proeprties);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ProfileFacetPackage.STEREOTYPE_FACET__REPRESENTED_ELEMENT_XMI_ID:
				return getRepresentedElement_XMI_ID();
			case ProfileFacetPackage.STEREOTYPE_FACET__CONDITION_QUERY:
				if (resolve) return getConditionQuery();
				return basicGetConditionQuery();
			case ProfileFacetPackage.STEREOTYPE_FACET__FACET_SET:
				if (resolve) return getFacetSet();
				return basicGetFacetSet();
			case ProfileFacetPackage.STEREOTYPE_FACET__STEREOTYPE_QUALIFIED_NAME:
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
			case ProfileFacetPackage.STEREOTYPE_FACET__REPRESENTED_ELEMENT_XMI_ID:
				setRepresentedElement_XMI_ID((String)newValue);
				return;
			case ProfileFacetPackage.STEREOTYPE_FACET__CONDITION_QUERY:
				setConditionQuery((ModelQuery)newValue);
				return;
			case ProfileFacetPackage.STEREOTYPE_FACET__STEREOTYPE_QUALIFIED_NAME:
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
			case ProfileFacetPackage.STEREOTYPE_FACET__REPRESENTED_ELEMENT_XMI_ID:
				setRepresentedElement_XMI_ID(REPRESENTED_ELEMENT_XMI_ID_EDEFAULT);
				return;
			case ProfileFacetPackage.STEREOTYPE_FACET__CONDITION_QUERY:
				setConditionQuery((ModelQuery)null);
				return;
			case ProfileFacetPackage.STEREOTYPE_FACET__STEREOTYPE_QUALIFIED_NAME:
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
			case ProfileFacetPackage.STEREOTYPE_FACET__REPRESENTED_ELEMENT_XMI_ID:
				return REPRESENTED_ELEMENT_XMI_ID_EDEFAULT == null ? representedElement_XMI_ID != null : !REPRESENTED_ELEMENT_XMI_ID_EDEFAULT.equals(representedElement_XMI_ID);
			case ProfileFacetPackage.STEREOTYPE_FACET__CONDITION_QUERY:
				return conditionQuery != null;
			case ProfileFacetPackage.STEREOTYPE_FACET__FACET_SET:
				return basicGetFacetSet() != null;
			case ProfileFacetPackage.STEREOTYPE_FACET__STEREOTYPE_QUALIFIED_NAME:
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
		if (baseClass == EObject.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == EObjectFacetRepresentation.class) {
			switch (derivedFeatureID) {
				case ProfileFacetPackage.STEREOTYPE_FACET__REPRESENTED_ELEMENT_XMI_ID: return ProfileFacetPackage.EOBJECT_FACET_REPRESENTATION__REPRESENTED_ELEMENT_XMI_ID;
				default: return -1;
			}
		}
		if (baseClass == Facet.class) {
			switch (derivedFeatureID) {
				case ProfileFacetPackage.STEREOTYPE_FACET__CONDITION_QUERY: return FacetPackage.FACET__CONDITION_QUERY;
				case ProfileFacetPackage.STEREOTYPE_FACET__FACET_SET: return FacetPackage.FACET__FACET_SET;
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
				case ProfileFacetPackage.EOBJECT_FACET_REPRESENTATION__REPRESENTED_ELEMENT_XMI_ID: return ProfileFacetPackage.STEREOTYPE_FACET__REPRESENTED_ELEMENT_XMI_ID;
				default: return -1;
			}
		}
		if (baseClass == Facet.class) {
			switch (baseFeatureID) {
				case FacetPackage.FACET__CONDITION_QUERY: return ProfileFacetPackage.STEREOTYPE_FACET__CONDITION_QUERY;
				case FacetPackage.FACET__FACET_SET: return ProfileFacetPackage.STEREOTYPE_FACET__FACET_SET;
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
