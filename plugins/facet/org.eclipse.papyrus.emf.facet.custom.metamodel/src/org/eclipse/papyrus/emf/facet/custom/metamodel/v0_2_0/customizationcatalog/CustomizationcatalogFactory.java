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
 *   	Gregoire Dupe (Mia-Software) - Bug 373078 - API Cleaning
 *  
 */
package org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.customizationcatalog;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a
 * create method for each non-abstract class of the model. <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.customizationcatalog.CustomizationcatalogPackage
 * @generated
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface CustomizationcatalogFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CustomizationcatalogFactory eINSTANCE = org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.customizationcatalog.impl.CustomizationcatalogFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Customization Catalog</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Customization Catalog</em>'.
	 * @generated
	 */
	CustomizationCatalog createCustomizationCatalog();

	/**
	 * Returns a new object of class '<em>Customization Properties Catalog</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Customization Properties Catalog</em>'.
	 * @generated
	 */
	CustomizationPropertiesCatalog createCustomizationPropertiesCatalog();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CustomizationcatalogPackage getCustomizationcatalogPackage();

} //CustomizationcatalogFactory
