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
 */
package org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.ETypedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Facet Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A facet element is owned by a facet. It can be a facet reference, a facet attribute or a facet operation.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetElement#getCategories <em>Categories</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.EFacetPackage#getFacetElement()
 * @model abstract="true"
 * @generated
 */
public interface FacetElement extends ETypedElement, DocumentedElement {
	/**
	 * Returns the value of the '<em><b>Categories</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.Category}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Categories</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Categories</em>' reference list.
	 * @see org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.EFacetPackage#getFacetElement_Categories()
	 * @model
	 * @generated
	 */
	EList<Category> getCategories();

} // FacetElement
