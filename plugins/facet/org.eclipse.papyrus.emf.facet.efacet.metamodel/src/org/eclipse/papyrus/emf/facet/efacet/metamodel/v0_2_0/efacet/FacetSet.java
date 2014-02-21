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
 * 	Emmanuelle RouillÃ© (Mia-Software) - Bug 352618 - To be able to use non derived facet structural features and save them values. 
 * 	Nicolas Bros (Mia-Software) - Bug 361823 - [Restructuring] eFacet2 meta-model
 *  Gregoire Dupe (Mia-Software) - Bug 373078 - API Cleaning
 */
package org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Facet Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet#getCategories <em>Categories</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.EFacetPackage#getFacetSet()
 * @model annotation="GenModel documentation='A \"FacetSet\" is the root element of a facet model. It contains a list of \"Facet\".'"
 * @generated
 */
public interface FacetSet extends EPackage, DocumentedElement {
	/**
	 * Returns the value of the '<em><b>Categories</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.Category}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Categories</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Categories</em>' containment reference list.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.EFacetPackage#getFacetSet_Categories()
	 * @model containment="true"
	 * @generated
	 */
	EList<Category> getCategories();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="GenModel documentation='The FacetSets aggregated by this FacetSet (this operation is overridden in Aggregate in the aggregate metamodel).'"
	 * @generated
	 */
	EList<FacetSet> getFacetSets();

} // FacetSet
