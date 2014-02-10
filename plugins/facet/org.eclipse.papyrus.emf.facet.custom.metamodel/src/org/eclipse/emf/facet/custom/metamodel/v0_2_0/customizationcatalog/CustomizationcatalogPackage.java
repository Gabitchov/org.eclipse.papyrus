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
package org.eclipse.emf.facet.custom.metamodel.v0_2_0.customizationcatalog;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.facet.util.emf.catalog.CatalogPackage;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains
 * accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.emf.facet.custom.metamodel.v0_2_0.customizationcatalog.CustomizationcatalogFactory
 * @model kind="package"
 * @generated
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface CustomizationcatalogPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "customizationcatalog";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/emf/facet/custom/0.2.internal/customizationcatalog";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "customizationcatalog";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CustomizationcatalogPackage eINSTANCE = org.eclipse.emf.facet.custom.metamodel.v0_2_0.customizationcatalog.impl.CustomizationcatalogPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.emf.facet.custom.metamodel.v0_2_0.customizationcatalog.impl.CustomizationCatalogImpl <em>Customization Catalog</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.facet.custom.metamodel.v0_2_0.customizationcatalog.impl.CustomizationCatalogImpl
	 * @see org.eclipse.emf.facet.custom.metamodel.v0_2_0.customizationcatalog.impl.CustomizationcatalogPackageImpl#getCustomizationCatalog()
	 * @generated
	 */
	int CUSTOMIZATION_CATALOG = 0;

	/**
	 * The feature id for the '<em><b>Installed Entries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMIZATION_CATALOG__INSTALLED_ENTRIES = CatalogPackage.CATALOG__INSTALLED_ENTRIES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMIZATION_CATALOG__NAME = CatalogPackage.CATALOG__NAME;

	/**
	 * The number of structural features of the '<em>Customization Catalog</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMIZATION_CATALOG_FEATURE_COUNT = CatalogPackage.CATALOG_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.facet.custom.metamodel.v0_2_0.customizationcatalog.impl.CustomizationPropertiesCatalogImpl <em>Customization Properties Catalog</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.facet.custom.metamodel.v0_2_0.customizationcatalog.impl.CustomizationPropertiesCatalogImpl
	 * @see org.eclipse.emf.facet.custom.metamodel.v0_2_0.customizationcatalog.impl.CustomizationcatalogPackageImpl#getCustomizationPropertiesCatalog()
	 * @generated
	 */
	int CUSTOMIZATION_PROPERTIES_CATALOG = 1;

	/**
	 * The feature id for the '<em><b>Installed Entries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMIZATION_PROPERTIES_CATALOG__INSTALLED_ENTRIES = CatalogPackage.CATALOG__INSTALLED_ENTRIES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMIZATION_PROPERTIES_CATALOG__NAME = CatalogPackage.CATALOG__NAME;

	/**
	 * The number of structural features of the '<em>Customization Properties Catalog</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMIZATION_PROPERTIES_CATALOG_FEATURE_COUNT = CatalogPackage.CATALOG_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.facet.custom.metamodel.v0_2_0.customizationcatalog.CustomizationCatalog <em>Customization Catalog</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Customization Catalog</em>'.
	 * @see org.eclipse.emf.facet.custom.metamodel.v0_2_0.customizationcatalog.CustomizationCatalog
	 * @generated
	 */
	EClass getCustomizationCatalog();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.facet.custom.metamodel.v0_2_0.customizationcatalog.CustomizationPropertiesCatalog <em>Customization Properties Catalog</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Customization Properties Catalog</em>'.
	 * @see org.eclipse.emf.facet.custom.metamodel.v0_2_0.customizationcatalog.CustomizationPropertiesCatalog
	 * @generated
	 */
	EClass getCustomizationPropertiesCatalog();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CustomizationcatalogFactory getCustomizationcatalogFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.emf.facet.custom.metamodel.v0_2_0.customizationcatalog.impl.CustomizationCatalogImpl <em>Customization Catalog</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.facet.custom.metamodel.v0_2_0.customizationcatalog.impl.CustomizationCatalogImpl
		 * @see org.eclipse.emf.facet.custom.metamodel.v0_2_0.customizationcatalog.impl.CustomizationcatalogPackageImpl#getCustomizationCatalog()
		 * @generated
		 */
		EClass CUSTOMIZATION_CATALOG = eINSTANCE.getCustomizationCatalog();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.facet.custom.metamodel.v0_2_0.customizationcatalog.impl.CustomizationPropertiesCatalogImpl <em>Customization Properties Catalog</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.facet.custom.metamodel.v0_2_0.customizationcatalog.impl.CustomizationPropertiesCatalogImpl
		 * @see org.eclipse.emf.facet.custom.metamodel.v0_2_0.customizationcatalog.impl.CustomizationcatalogPackageImpl#getCustomizationPropertiesCatalog()
		 * @generated
		 */
		EClass CUSTOMIZATION_PROPERTIES_CATALOG = eINSTANCE.getCustomizationPropertiesCatalog();

	}

} //CustomizationcatalogPackage
