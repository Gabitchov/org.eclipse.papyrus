/**
 *  Copyright (c) 2011 Mia-Software.
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
 *  Gregoire Dupe (Mia-Software) - Bug 373078 - API Cleaning
 */
package org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.SerializationPackage
 * @generated
 */
public interface SerializationFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SerializationFactory eINSTANCE = org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.impl.SerializationFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Abstract Reference Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Abstract Reference Instance</em>'.
	 * @generated
	 */
	AbstractReferenceInstance createAbstractReferenceInstance();

	/**
	 * Returns a new object of class '<em>Multi Valued Containment Reference Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Multi Valued Containment Reference Instance</em>'.
	 * @generated
	 */
	MultiValuedContainmentReferenceInstance createMultiValuedContainmentReferenceInstance();

	/**
	 * Returns a new object of class '<em>Multi Valued Reference Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Multi Valued Reference Instance</em>'.
	 * @generated
	 */
	MultiValuedReferenceInstance createMultiValuedReferenceInstance();

	/**
	 * Returns a new object of class '<em>Single Valued Attribute Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Single Valued Attribute Instance</em>'.
	 * @generated
	 */
	SingleValuedAttributeInstance createSingleValuedAttributeInstance();

	/**
	 * Returns a new object of class '<em>Extended EObject Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Extended EObject Reference</em>'.
	 * @generated
	 */
	ExtendedEObjectReference createExtendedEObjectReference();

	/**
	 * Returns a new object of class '<em>Single Valued Containment Reference Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Single Valued Containment Reference Instance</em>'.
	 * @generated
	 */
	SingleValuedContainmentReferenceInstance createSingleValuedContainmentReferenceInstance();

	/**
	 * Returns a new object of class '<em>Single Valued Reference Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Single Valued Reference Instance</em>'.
	 * @generated
	 */
	SingleValuedReferenceInstance createSingleValuedReferenceInstance();

	/**
	 * Returns a new object of class '<em>Multi Valued Attribute Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Multi Valued Attribute Instance</em>'.
	 * @generated
	 */
	MultiValuedAttributeInstance createMultiValuedAttributeInstance();

	/**
	 * Returns a new object of class '<em>Abstract Attribute Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Abstract Attribute Instance</em>'.
	 * @generated
	 */
	AbstractAttributeInstance createAbstractAttributeInstance();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SerializationPackage getSerializationPackage();

} //SerializationFactory
