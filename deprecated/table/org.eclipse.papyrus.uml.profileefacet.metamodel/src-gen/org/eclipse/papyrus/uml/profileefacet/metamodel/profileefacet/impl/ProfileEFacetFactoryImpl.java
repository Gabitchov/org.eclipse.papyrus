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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ProfileEFacetFactoryImpl extends EFactoryImpl implements ProfileEFacetFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ProfileEFacetFactory init() {
		try {
			ProfileEFacetFactory theProfileEFacetFactory = (ProfileEFacetFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/papyrus/0.9/profileefacet"); //$NON-NLS-1$ 
			if (theProfileEFacetFactory != null) {
				return theProfileEFacetFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ProfileEFacetFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProfileEFacetFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ProfileEFacetPackage.PROFILE_FACET_SET: return createProfileFacetSet();
			case ProfileEFacetPackage.STEREOTYPE_FACET: return createStereotypeFacet();
			case ProfileEFacetPackage.STEREOTYPE_PROPERTY_FACET_REFERENCE: return createStereotypePropertyFacetReference();
			case ProfileEFacetPackage.STEREOTYPE_PROPERTY_FACET_ATTRIBUTE: return createStereotypePropertyFacetAttribute();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProfileFacetSet createProfileFacetSet() {
		ProfileFacetSetImpl profileFacetSet = new ProfileFacetSetImpl();
		return profileFacetSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StereotypeFacet createStereotypeFacet() {
		StereotypeFacetImpl stereotypeFacet = new StereotypeFacetImpl();
		return stereotypeFacet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StereotypePropertyFacetReference createStereotypePropertyFacetReference() {
		StereotypePropertyFacetReferenceImpl stereotypePropertyFacetReference = new StereotypePropertyFacetReferenceImpl();
		return stereotypePropertyFacetReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StereotypePropertyFacetAttribute createStereotypePropertyFacetAttribute() {
		StereotypePropertyFacetAttributeImpl stereotypePropertyFacetAttribute = new StereotypePropertyFacetAttributeImpl();
		return stereotypePropertyFacetAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProfileEFacetPackage getProfileEFacetPackage() {
		return (ProfileEFacetPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ProfileEFacetPackage getPackage() {
		return ProfileEFacetPackage.eINSTANCE;
	}

} //ProfileEFacetFactoryImpl
