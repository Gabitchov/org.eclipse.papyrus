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
package org.eclipse.papyrus.emf.facet.efacet.catalog.efacetcatalog;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each
 * non-abstract class of the model. <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.emf.facet.efacet.catalog.efacetcatalog.EfacetcatalogPackage
 * @generated
 * @deprecated cf. https://bugs.eclipse.org/bugs/show_bug.cgi?id=373672
 */
@Deprecated
public interface EfacetcatalogFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EfacetcatalogFactory eINSTANCE = org.eclipse.papyrus.emf.facet.efacet.catalog.efacetcatalog.impl.EfacetcatalogFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Query Set Catalog</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Query Set Catalog</em>'.
	 * @generated
	 */
	QuerySetCatalog createQuerySetCatalog();

	/**
	 * Returns a new object of class '<em>Facet Set Catalog</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Facet Set Catalog</em>'.
	 * @generated
	 */
	FacetSetCatalog createFacetSetCatalog();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	EfacetcatalogPackage getEfacetcatalogPackage();

} //EfacetcatalogFactory
