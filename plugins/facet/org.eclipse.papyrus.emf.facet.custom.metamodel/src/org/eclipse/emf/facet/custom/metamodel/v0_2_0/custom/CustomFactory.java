/**
 *  Copyright (c) 2011 Mia-Software.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *  	Gregoire Dupe (Mia-Software) - Bug 361794 - [Restructuring] New customization meta-model
 *       Gregoire Dupe (Mia-Software) - Bug 369987 - [Restructuring][Table] Switch to the new customization and facet framework
 *       Gregoire Dupe (Mia-Software) - Bug 373078 - API Cleaning 
 */
package org.eclipse.emf.facet.custom.metamodel.v0_2_0.custom;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a
 * create method for each non-abstract class of the model. <!-- end-user-doc -->
 * @see org.eclipse.emf.facet.custom.metamodel.v0_2_0.custom.CustomPackage
 * @generated
 */
public interface CustomFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CustomFactory eINSTANCE = org.eclipse.emf.facet.custom.metamodel.v0_2_0.custom.impl.CustomFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Customization</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Customization</em>'.
	 * @generated
	 */
	Customization createCustomization();

	/**
	 * Returns a new object of class '<em>EClass Customization</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EClass Customization</em>'.
	 * @generated
	 */
	EClassCustomization createEClassCustomization();

	/**
	 * Returns a new object of class '<em>Facet Customization</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Facet Customization</em>'.
	 * @generated
	 */
	FacetCustomization createFacetCustomization();

	/**
	 * Returns a new object of class '<em>ETyped Element Switch Query</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ETyped Element Switch Query</em>'.
	 * @generated
	 */
	ETypedElementSwitchQuery createETypedElementSwitchQuery();

	/**
	 * Returns a new object of class '<em>ETyped Element Case</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ETyped Element Case</em>'.
	 * @generated
	 */
	ETypedElementCase createETypedElementCase();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CustomPackage getCustomPackage();

} //CustomFactory
