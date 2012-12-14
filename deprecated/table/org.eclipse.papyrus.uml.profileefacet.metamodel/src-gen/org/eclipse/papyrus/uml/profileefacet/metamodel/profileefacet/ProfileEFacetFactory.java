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
package org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.ProfileEFacetPackage
 * @generated
 */
public interface ProfileEFacetFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ProfileEFacetFactory eINSTANCE = org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.impl.ProfileEFacetFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Profile Facet Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Profile Facet Set</em>'.
	 * @generated
	 */
	ProfileFacetSet createProfileFacetSet();

	/**
	 * Returns a new object of class '<em>Stereotype Facet</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Stereotype Facet</em>'.
	 * @generated
	 */
	StereotypeFacet createStereotypeFacet();

	/**
	 * Returns a new object of class '<em>Stereotype Property Facet Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Stereotype Property Facet Reference</em>'.
	 * @generated
	 */
	StereotypePropertyFacetReference createStereotypePropertyFacetReference();

	/**
	 * Returns a new object of class '<em>Stereotype Property Facet Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Stereotype Property Facet Attribute</em>'.
	 * @generated
	 */
	StereotypePropertyFacetAttribute createStereotypePropertyFacetAttribute();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ProfileEFacetPackage getProfileEFacetPackage();

} //ProfileEFacetFactory
