/**
 *  Copyright (c) 2011,2012 Mia-Software.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *     Gregoire Dupe (Mia-Software) - Design
 *     Nicolas Guyomar (Mia-Software) - Implementation
 *     Emmanuelle Rouillé (Mia-Software) - Bug 352618 - To be able to use non-derived facet structural features and save their values.
 *     Nicolas Bros (Mia-Software) - Bug 370110 - Rename efacetcatalog2.ecore
 *     Grégoire Dupé (Mia-Software) - Bug 361817 - [Restructuring] Dynamic load to the facet catalog
 * 
 */
package org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacetcatalog;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.papyrus.emf.facet.util.emf.catalog.CatalogPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacetcatalog.EfacetcatalogFactory
 * @model kind="package"
 * @generated
 */
public interface EfacetcatalogPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "efacetcatalog"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/emf/facet/efacet/0.2.incubation/efacetcatalog"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "efacetcatalog"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EfacetcatalogPackage eINSTANCE = org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacetcatalog.impl.EfacetcatalogPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacetcatalog.impl.FacetSetCatalogImpl <em>Facet Set Catalog</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacetcatalog.impl.FacetSetCatalogImpl
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacetcatalog.impl.EfacetcatalogPackageImpl#getFacetSetCatalog()
	 * @generated
	 */
	int FACET_SET_CATALOG = 0;

	/**
	 * The feature id for the '<em><b>Installed Entries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_SET_CATALOG__INSTALLED_ENTRIES = CatalogPackage.CATALOG__INSTALLED_ENTRIES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_SET_CATALOG__NAME = CatalogPackage.CATALOG__NAME;

	/**
	 * The number of structural features of the '<em>Facet Set Catalog</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_SET_CATALOG_FEATURE_COUNT = CatalogPackage.CATALOG_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacetcatalog.FacetSetCatalog <em>Facet Set Catalog</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Facet Set Catalog</em>'.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacetcatalog.FacetSetCatalog
	 * @generated
	 */
	EClass getFacetSetCatalog();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EfacetcatalogFactory getEfacetcatalogFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacetcatalog.impl.FacetSetCatalogImpl <em>Facet Set Catalog</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacetcatalog.impl.FacetSetCatalogImpl
		 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacetcatalog.impl.EfacetcatalogPackageImpl#getFacetSetCatalog()
		 * @generated
		 */
		EClass FACET_SET_CATALOG = eINSTANCE.getFacetSetCatalog();

	}

} //EfacetcatalogPackage
