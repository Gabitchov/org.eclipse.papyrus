/**
 *  Copyright (c) 2011, 2012 Mia-Software.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 * 	Gregoire Dupe (Mia-Software) - Design
 * 	Nicolas Guyomar (Mia-Software) - Implementation
 * 	Emmanuelle RouillÃ© (Mia-Software) - Bug 352618 - To be able to use non derived facet structural features and save them values. 
 * 	Nicolas Bros (Mia-Software) - Bug 361823 - [Restructuring] eFacet2 meta-model
 *  Gregoire Dupe (Mia-Software) - Bug 364325 - [Restructuring] The user must be able to navigate into a model using the Facet.
 *  Gregoire Dupe (Mia-Software) - Bug 373078 - API Cleaning
 */
package org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.EFacetPackage
 * @generated
 */
public interface EFacetFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EFacetFactory eINSTANCE = org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.EFacetFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Facet Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Facet Attribute</em>'.
	 * @generated
	 */
	FacetAttribute createFacetAttribute();

	/**
	 * Returns a new object of class '<em>Facet Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Facet Reference</em>'.
	 * @generated
	 */
	FacetReference createFacetReference();

	/**
	 * Returns a new object of class '<em>Facet Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Facet Operation</em>'.
	 * @generated
	 */
	FacetOperation createFacetOperation();

	/**
	 * Returns a new object of class '<em>Facet Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Facet Set</em>'.
	 * @generated
	 */
	FacetSet createFacetSet();

	/**
	 * Returns a new object of class '<em>Facet</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Facet</em>'.
	 * @generated
	 */
	Facet createFacet();

	/**
	 * Returns a new object of class '<em>Category</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Category</em>'.
	 * @generated
	 */
	Category createCategory();

	/**
	 * Returns a new object of class '<em>Parameter Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parameter Value</em>'.
	 * @generated
	 */
	ParameterValue createParameterValue();

	/**
	 * Returns a new object of class '<em>Documented Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Documented Element</em>'.
	 * @generated
	 */
	DocumentedElement createDocumentedElement();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	EFacetPackage getEFacetPackage();

} //EFacetFactory
