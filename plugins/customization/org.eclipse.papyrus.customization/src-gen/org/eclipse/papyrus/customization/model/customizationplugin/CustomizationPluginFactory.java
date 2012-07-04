/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.customization.model.customizationplugin;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.customization.model.customizationplugin.CustomizationPluginPackage
 * @generated
 */
public interface CustomizationPluginFactory extends EFactory {

	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	CustomizationPluginFactory eINSTANCE = org.eclipse.papyrus.customization.model.customizationplugin.impl.CustomizationPluginFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Customization Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Customization Configuration</em>'.
	 * @generated
	 */
	CustomizationConfiguration createCustomizationConfiguration();

	/**
	 * Returns a new object of class '<em>Property View</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Property View</em>'.
	 * @generated
	 */
	PropertyView createPropertyView();

	/**
	 * Returns a new object of class '<em>UI Custom</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>UI Custom</em>'.
	 * @generated
	 */
	UICustom createUICustom();

	/**
	 * Returns a new object of class '<em>Model Template</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Model Template</em>'.
	 * @generated
	 */
	ModelTemplate createModelTemplate();

	/**
	 * Returns a new object of class '<em>Palette</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Palette</em>'.
	 * @generated
	 */
	Palette createPalette();

	/**
	 * Returns a new object of class '<em>Profile</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Profile</em>'.
	 * @generated
	 */
	Profile createProfile();

	/**
	 * Returns a new object of class '<em>UML Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>UML Model</em>'.
	 * @generated
	 */
	UMLModel createUMLModel();

	/**
	 * Returns a new object of class '<em>Constraints Environment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Constraints Environment</em>'.
	 * @generated
	 */
	ConstraintsEnvironment createConstraintsEnvironment();

	/**
	 * Returns a new object of class '<em>Property View Environment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property View Environment</em>'.
	 * @generated
	 */
	PropertyViewEnvironment createPropertyViewEnvironment();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the package supported by this factory.
	 * @generated
	 */
	CustomizationPluginPackage getCustomizationPluginPackage();

} //CustomizationPluginFactory
