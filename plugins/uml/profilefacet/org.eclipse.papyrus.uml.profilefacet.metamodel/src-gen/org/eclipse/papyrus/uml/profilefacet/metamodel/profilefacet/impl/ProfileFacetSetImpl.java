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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.util.EcoreEList;
import org.eclipse.emf.facet.infra.facet.Facet;
import org.eclipse.emf.facet.infra.facet.FacetPackage;
import org.eclipse.emf.facet.infra.facet.FacetSet;
import org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.EObjectFacetRepresentation;
import org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.ProfileFacetPackage;
import org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.ProfileFacetSet;
import org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.StereotypeFacet;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Profile Facet Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.impl.ProfileFacetSetImpl#getRepresentedElement_XMI_ID <em>Represented
 * Element XMI ID</em>}</li>
 * <li>{@link org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.impl.ProfileFacetSetImpl#getExtendedPackage <em>Extended Package</em>}</li>
 * <li>{@link org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.impl.ProfileFacetSetImpl#getFacets <em>Facets</em>}</li>
 * <li>{@link org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.impl.ProfileFacetSetImpl#getProfileQualifiedName <em>Profile Qualified Name
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ProfileFacetSetImpl extends EPackageImpl implements ProfileFacetSet {

	/**
	 * The default value of the '{@link #getRepresentedElement_XMI_ID() <em>Represented Element XMI ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getRepresentedElement_XMI_ID()
	 * @generated
	 * @ordered
	 */
	protected static final String REPRESENTED_ELEMENT_XMI_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRepresentedElement_XMI_ID() <em>Represented Element XMI ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getRepresentedElement_XMI_ID()
	 * @generated
	 * @ordered
	 */
	protected String representedElement_XMI_ID = REPRESENTED_ELEMENT_XMI_ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getExtendedPackage() <em>Extended Package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getExtendedPackage()
	 * @generated
	 * @ordered
	 */
	protected EPackage extendedPackage;

	/**
	 * The default value of the '{@link #getProfileQualifiedName() <em>Profile Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getProfileQualifiedName()
	 * @generated
	 * @ordered
	 */
	protected static final String PROFILE_QUALIFIED_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProfileQualifiedName() <em>Profile Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getProfileQualifiedName()
	 * @generated
	 * @ordered
	 */
	protected String profileQualifiedName = PROFILE_QUALIFIED_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ProfileFacetSetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ProfileFacetPackage.Literals.PROFILE_FACET_SET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getRepresentedElement_XMI_ID() {
		return representedElement_XMI_ID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setRepresentedElement_XMI_ID(String newRepresentedElement_XMI_ID) {
		String oldRepresentedElement_XMI_ID = representedElement_XMI_ID;
		representedElement_XMI_ID = newRepresentedElement_XMI_ID;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProfileFacetPackage.PROFILE_FACET_SET__REPRESENTED_ELEMENT_XMI_ID, oldRepresentedElement_XMI_ID, representedElement_XMI_ID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EPackage getExtendedPackage() {
		if(extendedPackage != null && extendedPackage.eIsProxy()) {
			InternalEObject oldExtendedPackage = (InternalEObject)extendedPackage;
			extendedPackage = (EPackage)eResolveProxy(oldExtendedPackage);
			if(extendedPackage != oldExtendedPackage) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProfileFacetPackage.PROFILE_FACET_SET__EXTENDED_PACKAGE, oldExtendedPackage, extendedPackage));
			}
		}
		return extendedPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EPackage basicGetExtendedPackage() {
		return extendedPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setExtendedPackage(EPackage newExtendedPackage) {
		EPackage oldExtendedPackage = extendedPackage;
		extendedPackage = newExtendedPackage;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProfileFacetPackage.PROFILE_FACET_SET__EXTENDED_PACKAGE, oldExtendedPackage, extendedPackage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<Facet> getFacets() {
		// DONE: implement this method to return the 'Facets' reference list
		// Ensure that you remove @generated or mark it @generated NOT
		// The list is expected to implement org.eclipse.emf.ecore.util.InternalEList and org.eclipse.emf.ecore.EStructuralFeature.Setting
		// so it's likely that an appropriate subclass of org.eclipse.emf.ecore.util.EcoreEList should be used.
		// throw new UnsupportedOperationException();
		List<Facet> facets = new ArrayList<Facet>();
		for(EClassifier eClassifier : getEClassifiers()) {
			if(eClassifier instanceof Facet) {
				facets.add((Facet)eClassifier);
			}
		}
		return new EcoreEList.UnmodifiableEList<Facet>(this, FacetPackage.eINSTANCE.getFacetSet_Facets(), facets.size(), facets.toArray()) {

			private static final long serialVersionUID = 1L;

			@Override
			public void addUnique(final int index, final Facet object) {
				// FIXME hack: FacetSets saved with an older version of the
				// metamodel have a non-derived facets reference.
				// So, overload this method to not throw an exception in order
				// to let the XMI parser create the model anyway
			}
		};
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getProfileQualifiedName() {
		return profileQualifiedName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setProfileQualifiedName(String newProfileQualifiedName) {
		String oldProfileQualifiedName = profileQualifiedName;
		profileQualifiedName = newProfileQualifiedName;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProfileFacetPackage.PROFILE_FACET_SET__PROFILE_QUALIFIED_NAME, oldProfileQualifiedName, profileQualifiedName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 *            FIXME write JUnit test
	 */
	public EList<StereotypeFacet> getStereotypeFacets() {
		final EList<StereotypeFacet> facets = new BasicEList<StereotypeFacet>();
		for(final Facet current : getFacets()) {
			if(current instanceof StereotypeFacet) {
				facets.add((StereotypeFacet)current);
			}
		}
		return ECollections.unmodifiableEList(facets);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 *            FIXME write JUnit test
	 */
	public EList<ProfileFacetSet> getSubProfileFacetSet() {
		final EList<ProfileFacetSet> facets = new BasicEList<ProfileFacetSet>();
		for(final EPackage current : getESubpackages()) {
			if(current instanceof ProfileFacetSet) {
				facets.add((ProfileFacetSet)current);
			}
		}
		return ECollections.unmodifiableEList(facets);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public Facet getFacet(final String name) {
		EClassifier eClassifier = getEClassifier(name);
		if(eClassifier instanceof Facet) {
			return (Facet)eClassifier;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch(featureID) {
		case ProfileFacetPackage.PROFILE_FACET_SET__REPRESENTED_ELEMENT_XMI_ID:
			return getRepresentedElement_XMI_ID();
		case ProfileFacetPackage.PROFILE_FACET_SET__EXTENDED_PACKAGE:
			if(resolve)
				return getExtendedPackage();
			return basicGetExtendedPackage();
		case ProfileFacetPackage.PROFILE_FACET_SET__FACETS:
			return getFacets();
		case ProfileFacetPackage.PROFILE_FACET_SET__PROFILE_QUALIFIED_NAME:
			return getProfileQualifiedName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch(featureID) {
		case ProfileFacetPackage.PROFILE_FACET_SET__REPRESENTED_ELEMENT_XMI_ID:
			setRepresentedElement_XMI_ID((String)newValue);
			return;
		case ProfileFacetPackage.PROFILE_FACET_SET__EXTENDED_PACKAGE:
			setExtendedPackage((EPackage)newValue);
			return;
		case ProfileFacetPackage.PROFILE_FACET_SET__PROFILE_QUALIFIED_NAME:
			setProfileQualifiedName((String)newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch(featureID) {
		case ProfileFacetPackage.PROFILE_FACET_SET__REPRESENTED_ELEMENT_XMI_ID:
			setRepresentedElement_XMI_ID(REPRESENTED_ELEMENT_XMI_ID_EDEFAULT);
			return;
		case ProfileFacetPackage.PROFILE_FACET_SET__EXTENDED_PACKAGE:
			setExtendedPackage((EPackage)null);
			return;
		case ProfileFacetPackage.PROFILE_FACET_SET__PROFILE_QUALIFIED_NAME:
			setProfileQualifiedName(PROFILE_QUALIFIED_NAME_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch(featureID) {
		case ProfileFacetPackage.PROFILE_FACET_SET__REPRESENTED_ELEMENT_XMI_ID:
			return REPRESENTED_ELEMENT_XMI_ID_EDEFAULT == null ? representedElement_XMI_ID != null : !REPRESENTED_ELEMENT_XMI_ID_EDEFAULT.equals(representedElement_XMI_ID);
		case ProfileFacetPackage.PROFILE_FACET_SET__EXTENDED_PACKAGE:
			return extendedPackage != null;
		case ProfileFacetPackage.PROFILE_FACET_SET__FACETS:
			return !getFacets().isEmpty();
		case ProfileFacetPackage.PROFILE_FACET_SET__PROFILE_QUALIFIED_NAME:
			return PROFILE_QUALIFIED_NAME_EDEFAULT == null ? profileQualifiedName != null : !PROFILE_QUALIFIED_NAME_EDEFAULT.equals(profileQualifiedName);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if(baseClass == EObject.class) {
			switch(derivedFeatureID) {
			default:
				return -1;
			}
		}
		if(baseClass == EObjectFacetRepresentation.class) {
			switch(derivedFeatureID) {
			case ProfileFacetPackage.PROFILE_FACET_SET__REPRESENTED_ELEMENT_XMI_ID:
				return ProfileFacetPackage.EOBJECT_FACET_REPRESENTATION__REPRESENTED_ELEMENT_XMI_ID;
			default:
				return -1;
			}
		}
		if(baseClass == FacetSet.class) {
			switch(derivedFeatureID) {
			case ProfileFacetPackage.PROFILE_FACET_SET__EXTENDED_PACKAGE:
				return FacetPackage.FACET_SET__EXTENDED_PACKAGE;
			case ProfileFacetPackage.PROFILE_FACET_SET__FACETS:
				return FacetPackage.FACET_SET__FACETS;
			default:
				return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if(baseClass == EObject.class) {
			switch(baseFeatureID) {
			default:
				return -1;
			}
		}
		if(baseClass == EObjectFacetRepresentation.class) {
			switch(baseFeatureID) {
			case ProfileFacetPackage.EOBJECT_FACET_REPRESENTATION__REPRESENTED_ELEMENT_XMI_ID:
				return ProfileFacetPackage.PROFILE_FACET_SET__REPRESENTED_ELEMENT_XMI_ID;
			default:
				return -1;
			}
		}
		if(baseClass == FacetSet.class) {
			switch(baseFeatureID) {
			case FacetPackage.FACET_SET__EXTENDED_PACKAGE:
				return ProfileFacetPackage.PROFILE_FACET_SET__EXTENDED_PACKAGE;
			case FacetPackage.FACET_SET__FACETS:
				return ProfileFacetPackage.PROFILE_FACET_SET__FACETS;
			default:
				return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if(eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (representedElement_XMI_ID: "); //$NON-NLS-1$
		result.append(representedElement_XMI_ID);
		result.append(", profileQualifiedName: "); //$NON-NLS-1$
		result.append(profileQualifiedName);
		result.append(')');
		return result.toString();
	}

} //ProfileFacetSetImpl
