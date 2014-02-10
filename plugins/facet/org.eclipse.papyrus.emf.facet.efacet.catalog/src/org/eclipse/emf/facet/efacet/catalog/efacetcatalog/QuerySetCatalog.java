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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.facet.efacet.QuerySet;
import org.eclipse.emf.facet.util.emf.catalog.Catalog;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Query Set Catalog</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc --> A QuerySetCatalog aims at referencing EMF Facet QuerySet. <!--
 * end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>
 * {@link org.eclipse.emf.facet.efacet.catalog.efacetcatalog.QuerySetCatalog#getInstalledQuerySets
 * <em>Installed Query Sets</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.emf.facet.efacet.catalog.efacetcatalog.EfacetcatalogPackage#getQuerySetCatalog()
 * @model
 * @generated
 * @deprecated cf. https://bugs.eclipse.org/bugs/show_bug.cgi?id=373672
 */
@Deprecated
public interface QuerySetCatalog extends Catalog {
	/**
	 * Returns the value of the '<em><b>Installed Query Sets</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.facet.efacet.QuerySet}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * "installedQuerySets" derived link aims at providing a direct access to QuerySet objects in the catalog.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Installed Query Sets</em>' reference list.
	 * @see org.eclipse.emf.facet.efacet.catalog.efacetcatalog.EfacetcatalogPackage#getQuerySetCatalog_InstalledQuerySets()
	 * @model transient="true" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore validationDelegates='self.installedQuerySets = self.installedEntries'"
	 * @generated
	 */
	EList<QuerySet> getInstalledQuerySets();

} // QuerySetCatalog
