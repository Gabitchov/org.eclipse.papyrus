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
package org.eclipse.emf.facet.util.emf.catalog;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A CatalogSet is a set of EMF Facet catalogs.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.facet.util.emf.catalog.CatalogSet#getCatalogs <em>Catalogs</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.facet.util.emf.catalog.CatalogPackage#getCatalogSet()
 * @model
 * @generated
 */
public interface CatalogSet extends EObject {
	/**
	 * Returns the value of the '<em><b>Catalogs</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.facet.util.emf.catalog.Catalog}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Catalogs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The "catalogs" reference references all the EMF Facet Catalog catalogs contained by a CatalogSet
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Catalogs</em>' containment reference list.
	 * @see org.eclipse.emf.facet.util.emf.catalog.CatalogPackage#getCatalogSet_Catalogs()
	 * @model containment="true"
	 * @generated
	 */
	EList<Catalog> getCatalogs();

} // CatalogSet
