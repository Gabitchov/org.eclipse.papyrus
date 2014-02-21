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
package org.eclipse.papyrus.emf.facet.util.emf.catalog;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.emf.facet.util.emf.catalog.CatalogFactory
 * @model kind="package"
 * @generated
 */
public interface CatalogPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "catalog"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/emf/facet/catalog/0.1.incubation"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "catalog"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CatalogPackage eINSTANCE = org.eclipse.papyrus.emf.facet.util.emf.catalog.impl.CatalogPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.emf.facet.util.emf.catalog.impl.CatalogSetImpl <em>Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.emf.facet.util.emf.catalog.impl.CatalogSetImpl
	 * @see org.eclipse.papyrus.emf.facet.util.emf.catalog.impl.CatalogPackageImpl#getCatalogSet()
	 * @generated
	 */
	int CATALOG_SET = 0;

	/**
	 * The feature id for the '<em><b>Catalogs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATALOG_SET__CATALOGS = 0;

	/**
	 * The number of structural features of the '<em>Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATALOG_SET_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.emf.facet.util.emf.catalog.Catalog <em>Catalog</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.emf.facet.util.emf.catalog.Catalog
	 * @see org.eclipse.papyrus.emf.facet.util.emf.catalog.impl.CatalogPackageImpl#getCatalog()
	 * @generated
	 */
	int CATALOG = 1;

	/**
	 * The feature id for the '<em><b>Installed Entries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATALOG__INSTALLED_ENTRIES = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATALOG__NAME = 1;

	/**
	 * The number of structural features of the '<em>Catalog</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATALOG_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.emf.facet.util.emf.catalog.CatalogSet <em>Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set</em>'.
	 * @see org.eclipse.papyrus.emf.facet.util.emf.catalog.CatalogSet
	 * @generated
	 */
	EClass getCatalogSet();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.emf.facet.util.emf.catalog.CatalogSet#getCatalogs <em>Catalogs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Catalogs</em>'.
	 * @see org.eclipse.papyrus.emf.facet.util.emf.catalog.CatalogSet#getCatalogs()
	 * @see #getCatalogSet()
	 * @generated
	 */
	EReference getCatalogSet_Catalogs();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.emf.facet.util.emf.catalog.Catalog <em>Catalog</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Catalog</em>'.
	 * @see org.eclipse.papyrus.emf.facet.util.emf.catalog.Catalog
	 * @generated
	 */
	EClass getCatalog();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.emf.facet.util.emf.catalog.Catalog#getInstalledEntries <em>Installed Entries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Installed Entries</em>'.
	 * @see org.eclipse.papyrus.emf.facet.util.emf.catalog.Catalog#getInstalledEntries()
	 * @see #getCatalog()
	 * @generated
	 */
	EReference getCatalog_InstalledEntries();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.emf.facet.util.emf.catalog.Catalog#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.emf.facet.util.emf.catalog.Catalog#getName()
	 * @see #getCatalog()
	 * @generated
	 */
	EAttribute getCatalog_Name();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CatalogFactory getCatalogFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.emf.facet.util.emf.catalog.impl.CatalogSetImpl <em>Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.emf.facet.util.emf.catalog.impl.CatalogSetImpl
		 * @see org.eclipse.papyrus.emf.facet.util.emf.catalog.impl.CatalogPackageImpl#getCatalogSet()
		 * @generated
		 */
		EClass CATALOG_SET = eINSTANCE.getCatalogSet();

		/**
		 * The meta object literal for the '<em><b>Catalogs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CATALOG_SET__CATALOGS = eINSTANCE.getCatalogSet_Catalogs();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.emf.facet.util.emf.catalog.Catalog <em>Catalog</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.emf.facet.util.emf.catalog.Catalog
		 * @see org.eclipse.papyrus.emf.facet.util.emf.catalog.impl.CatalogPackageImpl#getCatalog()
		 * @generated
		 */
		EClass CATALOG = eINSTANCE.getCatalog();

		/**
		 * The meta object literal for the '<em><b>Installed Entries</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CATALOG__INSTALLED_ENTRIES = eINSTANCE.getCatalog_InstalledEntries();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CATALOG__NAME = eINSTANCE.getCatalog_Name();

	}

} //CatalogPackage
