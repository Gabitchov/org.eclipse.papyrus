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
package org.eclipse.emf.facet.custom.metamodel.v0_2_0.customizationcatalog.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.emf.facet.custom.metamodel.v0_2_0.customizationcatalog.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CustomizationcatalogFactoryImpl extends EFactoryImpl implements CustomizationcatalogFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CustomizationcatalogFactory init() {
		try {
			CustomizationcatalogFactory theCustomizationcatalogFactory = (CustomizationcatalogFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/emf/facet/custom/0.2.internal/customizationcatalog"); 
			if (theCustomizationcatalogFactory != null) {
				return theCustomizationcatalogFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CustomizationcatalogFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CustomizationcatalogFactoryImpl() {
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
			case CustomizationcatalogPackage.CUSTOMIZATION_CATALOG: return createCustomizationCatalog();
			case CustomizationcatalogPackage.CUSTOMIZATION_PROPERTIES_CATALOG: return createCustomizationPropertiesCatalog();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CustomizationCatalog createCustomizationCatalog() {
		CustomizationCatalogImpl customizationCatalog = new CustomizationCatalogImpl();
		return customizationCatalog;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CustomizationPropertiesCatalog createCustomizationPropertiesCatalog() {
		CustomizationPropertiesCatalogImpl customizationPropertiesCatalog = new CustomizationPropertiesCatalogImpl();
		return customizationPropertiesCatalog;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CustomizationcatalogPackage getCustomizationcatalogPackage() {
		return (CustomizationcatalogPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CustomizationcatalogPackage getPackage() {
		return CustomizationcatalogPackage.eINSTANCE;
	}

} //CustomizationcatalogFactoryImpl
