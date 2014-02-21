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
 *  
 */
package org.eclipse.emf.facet.efacet.catalog.efacetcatalog;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.facet.util.emf.catalog.CatalogPackage;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta
 * objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.emf.facet.efacet.catalog.efacetcatalog.EfacetcatalogFactory
 * @model kind="package"
 * @generated
 * @deprecated cf. https://bugs.eclipse.org/bugs/show_bug.cgi?id=373672
 */
@Deprecated
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
	String eNS_URI = "http://www.eclipse.org/emf/facet/eFacetCatalog/0.1.incubation"; //$NON-NLS-1$

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
	EfacetcatalogPackage eINSTANCE = org.eclipse.emf.facet.efacet.catalog.efacetcatalog.impl.EfacetcatalogPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.emf.facet.efacet.catalog.efacetcatalog.impl.QuerySetCatalogImpl <em>Query Set Catalog</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.facet.efacet.catalog.efacetcatalog.impl.QuerySetCatalogImpl
	 * @see org.eclipse.emf.facet.efacet.catalog.efacetcatalog.impl.EfacetcatalogPackageImpl#getQuerySetCatalog()
	 * @generated
	 */
	int QUERY_SET_CATALOG = 0;

	/**
	 * The feature id for the '<em><b>Installed Entries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_SET_CATALOG__INSTALLED_ENTRIES = CatalogPackage.CATALOG__INSTALLED_ENTRIES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_SET_CATALOG__NAME = CatalogPackage.CATALOG__NAME;

	/**
	 * The feature id for the '<em><b>Installed Query Sets</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_SET_CATALOG__INSTALLED_QUERY_SETS = CatalogPackage.CATALOG_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Query Set Catalog</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_SET_CATALOG_FEATURE_COUNT = CatalogPackage.CATALOG_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.facet.efacet.catalog.efacetcatalog.impl.FacetSetCatalogImpl <em>Facet Set Catalog</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.facet.efacet.catalog.efacetcatalog.impl.FacetSetCatalogImpl
	 * @see org.eclipse.emf.facet.efacet.catalog.efacetcatalog.impl.EfacetcatalogPackageImpl#getFacetSetCatalog()
	 * @generated
	 */
	int FACET_SET_CATALOG = 1;

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
	 * The feature id for the '<em><b>Installed Facet Sets</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_SET_CATALOG__INSTALLED_FACET_SETS = CatalogPackage.CATALOG_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Facet Set Catalog</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_SET_CATALOG_FEATURE_COUNT = CatalogPackage.CATALOG_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.facet.efacet.catalog.efacetcatalog.QuerySetCatalog <em>Query Set Catalog</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Query Set Catalog</em>'.
	 * @see org.eclipse.emf.facet.efacet.catalog.efacetcatalog.QuerySetCatalog
	 * @generated
	 */
	EClass getQuerySetCatalog();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.emf.facet.efacet.catalog.efacetcatalog.QuerySetCatalog#getInstalledQuerySets <em>Installed Query Sets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Installed Query Sets</em>'.
	 * @see org.eclipse.emf.facet.efacet.catalog.efacetcatalog.QuerySetCatalog#getInstalledQuerySets()
	 * @see #getQuerySetCatalog()
	 * @generated
	 */
	EReference getQuerySetCatalog_InstalledQuerySets();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.facet.efacet.catalog.efacetcatalog.FacetSetCatalog <em>Facet Set Catalog</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Facet Set Catalog</em>'.
	 * @see org.eclipse.emf.facet.efacet.catalog.efacetcatalog.FacetSetCatalog
	 * @generated
	 */
	EClass getFacetSetCatalog();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.emf.facet.efacet.catalog.efacetcatalog.FacetSetCatalog#getInstalledFacetSets <em>Installed Facet Sets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Installed Facet Sets</em>'.
	 * @see org.eclipse.emf.facet.efacet.catalog.efacetcatalog.FacetSetCatalog#getInstalledFacetSets()
	 * @see #getFacetSetCatalog()
	 * @generated
	 */
	EReference getFacetSetCatalog_InstalledFacetSets();

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
		 * The meta object literal for the '{@link org.eclipse.emf.facet.efacet.catalog.efacetcatalog.impl.QuerySetCatalogImpl <em>Query Set Catalog</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.facet.efacet.catalog.efacetcatalog.impl.QuerySetCatalogImpl
		 * @see org.eclipse.emf.facet.efacet.catalog.efacetcatalog.impl.EfacetcatalogPackageImpl#getQuerySetCatalog()
		 * @generated
		 */
		EClass QUERY_SET_CATALOG = eINSTANCE.getQuerySetCatalog();

		/**
		 * The meta object literal for the '<em><b>Installed Query Sets</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUERY_SET_CATALOG__INSTALLED_QUERY_SETS = eINSTANCE.getQuerySetCatalog_InstalledQuerySets();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.facet.efacet.catalog.efacetcatalog.impl.FacetSetCatalogImpl <em>Facet Set Catalog</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.facet.efacet.catalog.efacetcatalog.impl.FacetSetCatalogImpl
		 * @see org.eclipse.emf.facet.efacet.catalog.efacetcatalog.impl.EfacetcatalogPackageImpl#getFacetSetCatalog()
		 * @generated
		 */
		EClass FACET_SET_CATALOG = eINSTANCE.getFacetSetCatalog();

		/**
		 * The meta object literal for the '<em><b>Installed Facet Sets</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FACET_SET_CATALOG__INSTALLED_FACET_SETS = eINSTANCE.getFacetSetCatalog_InstalledFacetSets();

	}

} //EfacetcatalogPackage
